package com.orocoder.nazmul.networkrequestwithretrofit;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.orocoder.nazmul.networkrequestwithretrofit.network.ApiInterface;
import com.orocoder.nazmul.networkrequestwithretrofit.network.RetrofitApiClient;
import com.orocoder.nazmul.networkrequestwithretrofit.utility.MyProgressDialog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

	private TextView txtCountry,txtCity,txtIP;
	private ProgressBar progressBar;
	private MyProgressDialog progressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txtCountry = findViewById(R.id.txtCountry);
		txtCity = findViewById(R.id.txtCity);
		txtIP = findViewById(R.id.txtIP);
		progressBar = findViewById(R.id.progressBar);

		/*ProgressDialog progressDialog1 = new ProgressDialog(this);
		progressDialog1.setMessage("Test");
		progressDialog1.show();
		progressDialog1.dismiss();*/
		progressDialog = new MyProgressDialog(this);


	}

	public void showIP(View view) {
		//showProgressBar();
		progressDialog.setMessage("Please wait...");
		progressDialog.show();

		//progressBar.setVisibility(View.VISIBLE);
		ApiInterface apiInterface = RetrofitApiClient.getClient().create(ApiInterface.class);
		Call<LocationIP> call = apiInterface.getMyIP();
		call.enqueue(new Callback<LocationIP>() {
			@Override
			public void onResponse(Call<LocationIP> call, Response<LocationIP> response) {
				LocationIP locationIP = response.body();
				//Toast.makeText(getApplicationContext(),"IP : " + response.code(),Toast.LENGTH_LONG).show();
				if (response.code() == 200 && locationIP != null){
					//progressBar.setVisibility(View.GONE);
					progressDialog.hide();

					txtCountry.setText(locationIP.getCountry());
					txtCity.setText(locationIP.getCity());
					txtIP.setText(locationIP.getIp());
				}
			}

			@Override
			public void onFailure(Call<LocationIP> call, Throwable t) {

			}
		});
	}

}
