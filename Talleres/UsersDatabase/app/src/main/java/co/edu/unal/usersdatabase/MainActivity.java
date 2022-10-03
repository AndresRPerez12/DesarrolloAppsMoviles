package co.edu.unal.usersdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import co.edu.unal.usersdatabase.controller.CompanyController;
import co.edu.unal.usersdatabase.dataAccess.model.Company;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private CompanyController companyController;

    public static final String EXTRA_FILTER = "mainActivity.FILTER";
    public static final String EXTRA_FILTER_VALUE = "mainActivity.FILTER_VALUE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        companyController = new CompanyController();
        listView = (ListView) findViewById(R.id.list_view);
        List<Company> companies;
        if( getIntent().getStringExtra(EXTRA_FILTER) != null &&
                getIntent().getStringExtra(EXTRA_FILTER).equals("name") ){
            String filterValue = getIntent().getStringExtra(EXTRA_FILTER_VALUE);
            companies = companyController.filterByName(filterValue, getApplicationContext());
        }else if( getIntent().getStringExtra(EXTRA_FILTER) != null &&
                getIntent().getStringExtra(EXTRA_FILTER).equals("classification") ){
            String filterValue = getIntent().getStringExtra(EXTRA_FILTER_VALUE);
            companies = companyController.filterByClassification(filterValue, getApplicationContext());
        }else{
            companies = companyController.getAllCompanies(getApplicationContext());
        }
        String[] companiesArray = new String[companies.size()];
        for( int i = 0 ; i < companies.size() ; i ++ ){
            companiesArray[i] = companies.get(i).toString();
        }
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, companiesArray);
        listView.setAdapter(adapter);
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