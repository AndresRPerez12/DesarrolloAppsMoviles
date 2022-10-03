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

public class FilterClassificationActivity extends AppCompatActivity {

    private TextInputEditText classificationInput;
    private Button filterButton;
    private CompanyController companyController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_classification);
        companyController = new CompanyController();
        classificationInput = (TextInputEditText) findViewById(R.id.filterClassification);
        filterButton = (Button) findViewById(R.id.filterClassificationButton);
    }

    public void filterByClassification(View view) {
        String classification = classificationInput.getText().toString().trim();
        List<Company> companies = companyController.filterByClassification(classification, getApplicationContext());
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
            intent.putExtra(MainActivity.EXTRA_FILTER, "classification");
            intent.putExtra(MainActivity.EXTRA_FILTER_VALUE, classification);
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
            case R.id.filter_name:
                intent = new Intent(this, FilterNameActivity.class);
                startActivity(intent);
                return true;
            case R.id.filter_classification:
                intent = new Intent(this, FilterClassificationActivity.class);
                startActivity(intent);
                return true;
        }
        return false;
    }
}