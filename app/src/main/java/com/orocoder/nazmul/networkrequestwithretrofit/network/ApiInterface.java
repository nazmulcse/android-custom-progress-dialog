package com.orocoder.nazmul.networkrequestwithretrofit.network;

import com.orocoder.nazmul.networkrequestwithretrofit.LocationIP;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
	@GET("/json")
	Call<LocationIP> getMyIP();
}
