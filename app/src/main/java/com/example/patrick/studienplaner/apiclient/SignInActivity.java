package com.example.patrick.studienplaner.apiclient;

import android.app.ProgressDialog;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.patrick.studienplaner.R;
import com.example.patrick.studienplaner.model.data.User;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit.RetrofitError;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "SignInActivity";
    private static final int RC_SIGN_IN = 9001;
    private ProgressDialog mProgressDialog;
    /*
    GoogleApiClient apiClient = new GoogleApiClient() {
        @Override
        public boolean hasConnectedApi(@NonNull Api<?> api) {


        }

        @NonNull
        @Override
        public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
            return null;
        }

        @Override
        public void connect() {

        }

        @Override
        public ConnectionResult blockingConnect() {
            return null;
        }

        @Override
        public ConnectionResult blockingConnect(long l, @NonNull TimeUnit timeUnit) {
            return null;
        }

        @Override
        public void disconnect() {

        }

        @Override
        public void reconnect() {

        }

        @Override
        public PendingResult<Status> clearDefaultAccountAndReconnect() {
            return null;
        }

        @Override
        public void stopAutoManage(@NonNull FragmentActivity fragmentActivity) {

        }

        @Override
        public boolean isConnected() {
            return false;
        }

        @Override
        public boolean isConnecting() {
            return false;
        }

        @Override
        public void registerConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks) {

        }

        @Override
        public boolean isConnectionCallbacksRegistered(@NonNull ConnectionCallbacks connectionCallbacks) {
            return false;
        }

        @Override
        public void unregisterConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks) {

        }

        @Override
        public void registerConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener) {

        }

        @Override
        public boolean isConnectionFailedListenerRegistered(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
            return false;
        }

        @Override
        public void unregisterConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener) {

        }

        @Override
        public void dump(String s, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strings) {

        }
    }; */



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_layout);


        // Button listeners
        findViewById(R.id.sign_in_button).setOnClickListener(this);

        }

    @Override
    public void onClick(View v) {
        try {
            GoogleAccountsService accService = ServiceGenerator.createService(GoogleAccountsService.class, GoogleAccountsService.BASE_URL);
            UserCode userCode = accService.getUserCode(getString(R.string.server_client_id), "email profile");

            String verificationUrl = userCode.getVerificationUrl();

            AccessToken accessToken = accService.getAccessToken(getString(R.string.server_client_id), getString(R.string.client_key), userCode.getDeviceCode(), GoogleAccountsService.ACCESS_GRANT_TYPE);


            final String refreshToken = accessToken.getRefreshToken();
            GoogleApisService apisService = ServiceGenerator.createService(GoogleApisService.class, GoogleApisService.BASE_URL);

            AccessToken refreshedAccessToken = accService.refreshAccessToken(getString(R.string.server_client_id), getString(R.string.client_key), refreshToken, GoogleAccountsService.REFRESH_GRANT_TYPE);
            apisService = ServiceGenerator.createService(GoogleApisService.class, GoogleApisService.BASE_URL, refreshedAccessToken);
        }catch(RetrofitError error){
            if(error.getResponse() == null){
                //shizzl
            } else {
                //(error.getResponse() + ", " + error.getResponse().getStatus()
            }
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