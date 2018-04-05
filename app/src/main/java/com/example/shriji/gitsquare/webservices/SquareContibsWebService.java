package com.example.shriji.gitsquare.webservices;

import com.example.shriji.gitsquare.models.SquareContribsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SquareContibsWebService {

    String BASE_URL = "https://api.github.com/";
    String FEED = "repos/square/retrofit/contributors";

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET(FEED)
    Call<List<SquareContribsModel>> getUsers();

}
