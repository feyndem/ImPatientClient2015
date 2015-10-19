package org.mperezcastell.impatientclient;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import java.util.concurrent.Callable;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by mmpc on 10/10/15.
 */
public class PatientAppointmentActivity extends Activity {

    static String mChekedin;

    @InjectView(R.id.appointmentTime)
    protected TextView appointmentTime;

    @InjectView(R.id.checkinButton)
    protected Button checkinButton;

    @InjectView(R.id.refreshWaiting)
    protected Button refreshWaiting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientappointment);

        ButterKnife.inject(this);

    }

    @Override
    protected void onStart() {
        super.onStart();


        CallableTask.invoke(new Callable<Appointment>() {
            @Override
            public Appointment call() throws Exception {
                ImPatientSvcApi svc = ImPatientSvc.getOrShowLogin(getApplicationContext());
                return svc.getAppointment();
            }
        }, new TaskCallback<Appointment>() {
            @Override
            public void success(Appointment appointment) {

                if (appointment.getArrivalCheck() == true) {
                    LoginUtility.setCheckin(getApplicationContext(), true);
                    Calendar c = Calendar.getInstance();
                    c.setTimeInMillis(appointment.getAppointmentTime());
                    appointmentTime.setText(c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE));
                } else {
                    LoginUtility.setCheckin(getApplicationContext(), false);
                    refreshWaiting.setVisibility(View.INVISIBLE);
                    appointmentTime.setText("Please, check in to get your estimated waiting time");
                }


            }

            @Override
            public void error(Exception e) {
                Log.e(LoginActivity.class.getName(), "Error appointment", e);
            }

        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
