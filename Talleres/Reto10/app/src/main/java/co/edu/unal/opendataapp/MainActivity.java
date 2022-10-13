package co.edu.unal.opendataapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Settings;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import co.edu.unal.opendataapp.model.Company;
import co.edu.unal.opendataapp.service.CompanyService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_view);

        // Create Retrofit object and make a call to the API
        retrofit = createCompanyRepository();
        CompanyService companyService = retrofit.create(CompanyService.class);
        Call<List<Company>> call = companyService.getAllCompanies();
        System.out.println("BEFORE QUERY");

        // Save parent object
        MainActivity mainActivity = this;
        call.enqueue(new Callback<List<Company>>() {
            @Override
            public void onResponse(Call<List<Company>> call, Response<List<Company>> response) {
                if( !response.isSuccessful() ){
                    System.out.println( "Code: " + response.code() + "\n" );
                    return;
                }
                List<Company> companies = response.body();
                String[] companiesArray = new String[companies.size()];
                for( int i = 0 ; i < companies.size() ; i ++ ){
                    companiesArray[i] = companies.get(i).toString();
                }
                ArrayAdapter adapter = new ArrayAdapter<String>(mainActivity,
                        R.layout.activity_listview, companiesArray);
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Company>> call, Throwable t) {
                System.out.println( "Message : " + t.getMessage() + "\n" );
            }
        });
    }

    public Retrofit createCompanyRepository( ) {
        return new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}