package com.example.patrick.studienplaner.apiclient;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.alamkanak.weekview.WeekViewEvent;
import com.example.patrick.studienplaner.BaseActivity;
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

    public static final String FILENAME = "UserFile";
    private static final String TAG = "SignInActivity";
    private static final int RC_SIGN_IN = 9001;
    private ProgressDialog mProgressDialog;
    public static final String PREFS_NAME = "Preferences";
    private List<WeekViewEvent> events = new ArrayList<WeekViewEvent>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_layout);


        final SharedPreferences settings = getPreferences(0);
        // Button listeners
        findViewById(R.id.sign_in_button).setOnClickListener(this);


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


    @Override
    public void onStart() {
        super.onStart();

    }

    public void getTokensAndPostUser() throws NoSuchAlgorithmException {
        try {
            SharedPreferences settings = getPreferences(0);

            GoogleAccountsService accService = ServiceGenerator.createService(GoogleAccountsService.class, GoogleAccountsService.BASE_URL);
            UserCode userCode = accService.getUserCode(getString(R.string.client_id), "email profile");

            String verificationUrl = userCode.getVerificationUrl();

            AccessToken accessToken = accService.getAccessToken(getString(R.string.client_id), getString(R.string.client_secret), userCode.getDeviceCode(), GoogleAccountsService.ACCESS_GRANT_TYPE);

            SharedPreferences.Editor editor = settings.edit();
            editor.putString("access_token", accessToken.getAccessToken());
            editor.putString("token_type", accessToken.getTokenType());
            editor.putLong("expires_in", accessToken.getExpiresIn());
            editor.putString("refresh_token", accessToken.getRefreshToken());
            //HOUSTON! PROBLEM!


            String refreshToken = accessToken.getRefreshToken();

            AccessToken refreshedAccessToken = accService.refreshAccessToken(getString(R.string.client_id), getString(R.string.client_secret), refreshToken, GoogleAccountsService.REFRESH_GRANT_TYPE);

            GoogleApisService apisService = ServiceGenerator.createService(GoogleApisService.class, GoogleApisService.BASE_URL, refreshedAccessToken);
            User user = apisService.getProfile();
            editor.putString("user_id", user.getId());
            editor.commit();

            MyJsonService service = ServiceGenerator.createService(MyJsonService.class, MyJsonService.API_BASE_URL, accessToken);
            service.postUser(JWTMaker.createJWT("", "\"code\":" + userCode.getUserCode()));


        } catch (RetrofitError error) {
            if (error.getResponse() == null) {
                //shizzl
                error.printStackTrace();
            } else {
                //(error.getResponse() + ", " + error.getResponse().getStatus()
            }
        } catch (JoseException e) {
            //jose error
            e.printStackTrace();
        }
    }


    private void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }
        mProgressDialog.show();
    }

    private void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.hide();
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