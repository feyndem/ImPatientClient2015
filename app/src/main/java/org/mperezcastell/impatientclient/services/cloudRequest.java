package org.mperezcastell.impatientclient.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import org.mperezcastell.impatientclient.Appointment;
import org.mperezcastell.impatientclient.ImPatientSvc;
import org.mperezcastell.impatientclient.ImPatientSvcApi;
import org.mperezcastell.impatientclient.ImPatientRequest;

import java.util.concurrent.ExecutorService;

public class cloudRequest extends Service {
    public cloudRequest() {
    }

    private ExecutorService mExecutorService;

    /**
     * Factory method that makes an Intent used to start the
     * AcronymServiceAsync when passed to bindService().
     *
     * @param context
     *            The context of the calling component.
     */
    public static Intent makeIntent(Context context) {
        return new Intent(context, cloudRequest.class);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mImpatientRequest;
    }

    private final ImPatientRequest.Stub mImpatientRequest = new ImPatientRequest.Stub() {

        public void getAppointment() {
            ImPatientSvcApi svc = ImPatientSvc.getOrShowLogin(getApplicationContext());
            Appointment result = svc.getAppointment();
            //callback.sendResults(result);
        }
    };
}
