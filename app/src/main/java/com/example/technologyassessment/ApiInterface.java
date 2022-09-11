package com.example.technologyassessment;

import com.example.technologyassessment.Models.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET(Constants.key)
    Call<Model> getlist();
}
