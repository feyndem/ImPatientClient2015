package org.mperezcastell.impatientclient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.Callable;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class LoginActivity extends Activity {

    @InjectView(R.id.userName)
    protected EditText userName_;

    @InjectView(R.id.password)
    protected EditText password_;

    @InjectView(R.id.server)
    protected EditText server_;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.inject(this);
    }

    @OnClick(R.id.loginButton)
    public void login() {
        String user = userName_.getText().toString();
        String pass = password_.getText().toString();
        String server = server_.getText().toString();

        final ImPatientSvcApi svc = ImPatientSvc.init(server, user, pass);

        Log.i(LoginActivity.class.getName(), svc.toString());

        CallableTask.invoke(new Callable<Collection<UserCredential>>() {

            @Override
            public Collection<UserCredential> call() throws Exception {
                return svc.getHome();
            }
        }, new TaskCallback<Collection<UserCredential>>() {

            @Override
            public void success(Collection<UserCredential> result) {
                // OAuth 2.0 grant was successful and web
                // can talk to the server
                UserCredential cred = result.iterator().next();
                LoginUtility.setLoggedIn(getApplicationContext(), cred);
                if (Objects.equals(LoginUtility.getUserType(getApplicationContext()), "ADMIN")) {
                    Intent mIntent = new Intent(LoginActivity.this, HelloActivity.class);
                    startActivity(mIntent);
                } else {
                    if (Objects.equals(LoginUtility.getUserType(getApplicationContext()), "PATIENT")) {
                        Intent mIntent = new Intent(LoginActivity.this, PatientAppointmentActivity.class);
                        startActivity(mIntent);
                    }
                }
            }

            @Override
            public void error(Exception e) {
                Log.e(LoginActivity.class.getName(), "Error logging in via OAuth.", e);

                Toast.makeText(
                        LoginActivity.this,
                        "Login failed, check your Internet connection and credentials.",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }


}
