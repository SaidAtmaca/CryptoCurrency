package com.said.cryptocurrency.service;

import com.said.cryptocurrency.model.CryptoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CryptoAPI {

    //GET, POST , UPDATE, DELETE

    //URL BASE www.website.com

    // GET -> price?key=xxx

    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    Call<List<CryptoModel>> getData();
}
