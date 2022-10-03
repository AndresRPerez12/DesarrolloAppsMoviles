package co.edu.unal.usersdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import co.edu.unal.usersdatabase.controller.CompanyController;
import co.edu.unal.usersdatabase.dataAccess.model.Company;

public class FilterNameActivity extends AppCompatActivity {

    private TextInputEditText nameInput;
    private Button filterButton;
    private CompanyController companyController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_name);
        companyController = new CompanyController();
        nameInput = (TextInputEditText) findViewById(R.id.filterName);
        filterButton = (Button) findViewById(R.id.filterNameButton);
    }

    public void filterByName(View view) {
        String name = nameInput.getText().toString().trim();
        List<Company> companies = companyController.filterByName(name, getApplicationContext());
        if( companies.isEmpty() ){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No se encontraron resultados", Toast.LENGTH_SHORT);
            toast.show();
        }else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Filtrado con éxito", Toast.LENGTH_SHORT);
            toast.show();
            Intent intent;
            intent = new Intent(this, MainActivity.class);
            intent.putExtra(MainActivity.EXTRA_FILTER, "name");
            intent.putExtra(MainActivity.EXTRA_FILTER_VALUE, name);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.new_company:
                intent = new Intent(this, CreateActivity.class);
                startActivity(intent);
                return true;
            case R.id.update_company:
                intent = new Intent(this, UpdateActivity.class);
                startActivity(intent);
                return true;
            case R.id.delete_company:
                intent = new Intent(this, DeleteActivity.class);
                startActivity(intent);
                return true;
            case R.id.all_companies:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
        }
        return false;
    }
}