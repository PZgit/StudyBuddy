package com.example.patrick.studienplaner.apiclient;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alamkanak.weekview.WeekViewEvent;
import com.example.patrick.studienplaner.BaseActivity;
import com.example.patrick.studienplaner.MyApp;
import com.example.patrick.studienplaner.R;
import com.example.patrick.studienplaner.model.data.Event;
import com.example.patrick.studienplaner.model.data.User;

import org.jose4j.lang.JoseException;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import retrofit.RetrofitError;
import retrofit.client.Response;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_layout);


        final SharedPreferences settings = getPreferences(0);
        // Button listeners
        findViewById(R.id.sign_in_button).setOnClickListener(this);


    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onClick(View v) {
        try{
            getTokensAndPostUser();
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        Intent intent = new Intent(
                Intent.ACTION_VIEW,
                Uri.parse(ServiceGenerator.API_BASE_URL + "/users"));
        startActivity(intent);
    }


    public void getTokensAndPostUser() throws NoSuchAlgorithmException {
        try {
            SharedPreferences settings = MyApp.getAppContext().getSharedPreferences("UserFile", 0);

            GoogleAccountsService accService = ServiceGenerator.createService(GoogleAccountsService.class, GoogleAccountsService.BASE_URL);
            UserCode userCode = accService.getUserCode(getString(R.string.client_id), "email profile");

            String verificationUrl = userCode.getVerificationUrl();

            AccessToken accessToken = accService.getAccessToken(getString(R.string.client_id), getString(R.string.client_secret), userCode.getDeviceCode(), GoogleAccountsService.ACCESS_GRANT_TYPE);

            SharedPreferences.Editor editor = settings.edit();
            editor.putString("access_token", accessToken.getAccessToken());
            editor.putLong("expires_in", accessToken.getExpiresIn());
            editor.putString("refresh_token", accessToken.getRefreshToken());

            String refreshToken = accessToken.getRefreshToken();

            AccessToken refreshedAccessToken = accService.refreshAccessToken(getString(R.string.client_id), getString(R.string.client_secret), refreshToken, GoogleAccountsService.REFRESH_GRANT_TYPE);

            GoogleApisService apisService = ServiceGenerator.createService(GoogleApisService.class, GoogleApisService.BASE_URL);
            User user = apisService.getProfile();
            editor.putString("user_id", user.getId());
            editor.commit();

            MyJsonService service = ServiceGenerator.createService(MyJsonService.class);


        } catch (RetrofitError error) {
            if (error.getResponse() == null) {
                error.printStackTrace();
            } else {
                //error.getResponse() + ", " + error.getResponse().getStatus();
            }
        }
    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onStop() {
        super.onStop();


    }
}