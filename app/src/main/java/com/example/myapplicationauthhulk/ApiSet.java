package com.example.myapplicationauthhulk;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiSet {
    @GET(".")
    Call<modelclass> getdata();

}
