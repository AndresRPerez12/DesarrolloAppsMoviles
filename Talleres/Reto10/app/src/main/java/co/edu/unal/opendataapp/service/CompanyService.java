package co.edu.unal.opendataapp.service;

import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CompanyService {
    @GET("8hn7-rpp8.json/")
    Call<List<JSONObject>> getAllCompanies();
}
