package co.edu.unal.opendataapp.service;

import java.util.List;

import co.edu.unal.opendataapp.model.Company;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CompanyService {
    @GET("8hn7-rpp8.json")
    Call<List<Company>> getAllCompanies();

    @GET("8hn7-rpp8.json")
    Call<List<Company>> getAllCompaniesByProvince(@Query("departamento_domicilio") String province);
}
