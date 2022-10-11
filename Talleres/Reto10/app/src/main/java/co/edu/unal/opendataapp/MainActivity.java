package co.edu.unal.opendataapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import co.edu.unal.opendataapp.service.CompanyService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create Retrofit object
        retrofit = createCompanyRepository();
        CompanyService companyService = retrofit.create(CompanyService.class);
        Call<List<JSONObject>> call = companyService.getAllCompanies();
        call.enqueue(new Callback<List<JSONObject>>() {
            @Override
            public void onResponse(Call<List<JSONObject>> call, Response<List<JSONObject>> response) {
                if( !response.isSuccessful() ){
                    System.out.println( "Code: " + response.code() + "\n" );
                    Toast toast = Toast.makeText(getApplicationContext(), "Query exitosa", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
            }

            @Override
            public void onFailure(Call<List<JSONObject>> call, Throwable t) {
                System.out.println( "Message : " + t.getMessage() + "\n" );
                Toast toast = Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG);
                toast.show();
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