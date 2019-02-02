package com.orocoder.nazmul.networkrequestwithretrofit.utility;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Custom progress dialog.
 * After Instantiating this class, call show method to show progress bar
 * Call hide method to hide progress bar.
 *
 * @author Nazmul Hasan
 */
public class MyProgressDialog {
	private AlertDialog.Builder alert;
	private LinearLayout layout;
	private Context context;
	private String message;
	private TextView textView;
	private AlertDialog alertDialog;

	public MyProgressDialog(Context context) {
		this.context = context;

	}

	private void makeLayout(){
		alert = new AlertDialog.Builder(context);

		// Creating Layout
		layout = new LinearLayout(context);
		//LinearLayout layout = new LinearLayout(context);
		layout.setOrientation(LinearLayout.HORIZONTAL);
		layout.setPadding(10,10,10,10);
		layout.setMinimumHeight(230);
		layout.setGravity(Gravity.CENTER_VERTICAL);

		//Creating progress bar widget
		final ProgressBar progressBar = new ProgressBar(context);
		progressBar.setPadding(30,0,0,0);
		layout.addView(progressBar);

		// Creating TextView widget
		textView = new TextView(context);
		// Setting left padding
		textView.setPadding(50,0,0,0);
		// Setting default loading message
		textView.setText("Loading ... Please Wait...");
		layout.addView(textView);

		alert.setView(layout);
		alert.setCancelable(false);

	}

	public void show(){

		makeLayout();
		if(getMessage() != null && !getMessage().equalsIgnoreCase("")){
			textView.setText(getMessage());
		}
		alertDialog = alert.create();
		alertDialog.show();  // to show
	}
	public void hide(){
		alertDialog.dismiss();  // to dismiss
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
