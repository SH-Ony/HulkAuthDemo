package com.example.myapplicationauthhulk;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController {
    private static final String url="https://hulkenstein.com/edgecourse/api/get_nonce/?controller=user&method=register";
    private static ApiController clientobj;
    private static Retrofit retrofit;


    ApiController()
    {
        retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }



    public  static  synchronized  ApiController getInstance() {
        if(clientobj==null)
            clientobj=new ApiController();

        return clientobj;
    }

    ApiSet getApi()
    {
        return retrofit.create(ApiSet.class);
    }

}
