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

import co.edu.unal.usersdatabase.controller.CompanyController;
import co.edu.unal.usersdatabase.dataAccess.model.Company;

public class UpdateActivity extends AppCompatActivity {

    private TextInputEditText nameInput;
    private TextInputEditText urlInput;
    private TextInputEditText telephoneInput;
    private TextInputEditText emailInput;
    private TextInputEditText servicesInput;
    private TextInputEditText classificationInput;
    private Button updateButton;
    private CompanyController companyController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        companyController = new CompanyController();
        nameInput = (TextInputEditText) findViewById(R.id.updateName);
        urlInput = (TextInputEditText) findViewById(R.id.updateURL);
        telephoneInput = (TextInputEditText) findViewById(R.id.updatePhone);
        emailInput = (TextInputEditText) findViewById(R.id.updateEmail);
        servicesInput = (TextInputEditText) findViewById(R.id.updateServices);
        classificationInput = (TextInputEditText) findViewById(R.id.updateClassification);
        updateButton = (Button) findViewById(R.id.updateButton);
    }

    public void updateCompany(View view) {
        String name = nameInput.getText().toString().trim();
        String url = urlInput.getText().toString().trim();
        String telephone = telephoneInput.getText().toString().trim();
        String email = emailInput.getText().toString().trim();
        String services = servicesInput.getText().toString().trim();
        String classification = classificationInput.getText().toString().trim();
        Company company = companyController.getCompanyByEmail(email, getApplicationContext());
        if(company != null) {
            company.setName(name);
            company.setUrl(url);
            company.setPhoneNumber(telephone);
            company.setEmail(email);
            company.setServices(services);
            company.setClassification(classification);
            companyController.updateCompany(company, getApplicationContext());
            Toast toast = Toast.makeText(getApplicationContext(), "Actualizado con exito", Toast.LENGTH_SHORT);
            toast.show();
        }else{
            Toast toast = Toast.makeText(getApplicationContext(), "Email no existe", Toast.LENGTH_SHORT);
            toast.show();
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