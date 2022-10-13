package co.edu.unal.opendataapp.service;

import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import co.edu.unal.opendataapp.model.Company;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CompanyService {
    @GET("8hn7-rpp8.json/")
    Call<List<Company>> getAllCompanies();

    @GET("8hn7-rpp8.json/departamento_domicilio={province}")
    Call<List<Company>> getAllCompaniesByProvince(@Path("province") String province);
}
