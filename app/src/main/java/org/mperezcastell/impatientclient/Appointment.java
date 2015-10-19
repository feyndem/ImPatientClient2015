package org.mperezcastell.impatientclient;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by mmpc on 12/10/15.
 */
public class Appointment implements Serializable, Parcelable {

    private int id;
    private Patient patient;
    private long appointmentTime;
    private Boolean arrivalCheck;
    private Boolean treatmentCheck;
    private Boolean treatedCheck;


    // Parcelable interface

    public static final Parcelable.Creator<Appointment> CREATOR = new
            Parcelable.Creator<Appointment>() {
                public Appointment createFromParcel(Parcel in) {
                    return new Appointment(in);
                }

                public Appointment[] newArray(int size) {
                    return new Appointment[size];
                }
            };

    public Appointment() {
    }

    private Appointment(Parcel in) {
        readFromParcel(in);
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(id);
        out.writeParcelable(patient, flags);
        out.writeLong(appointmentTime);
        out.writeByte((byte) (arrivalCheck ? 1 : 0));
        out.writeByte((byte) (treatmentCheck ? 1 : 0));
        out.writeByte((byte) (treatedCheck ? 1 : 0));
    }

    public void readFromParcel(Parcel in) {
        id = in.readInt();
        patient = in.readParcelable(null);
        appointmentTime = in.readLong();
        arrivalCheck = in.readByte() != 0;
        treatmentCheck = in.readByte() != 0;
        treatedCheck = in.readByte() != 0;
    }

    public int describeContents() {
        return 0;
    }


    // Getters and Setters

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(long appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Boolean getArrivalCheck() {
        return arrivalCheck;
    }

    public void setArrivalCheck(Boolean arrivalCheck) {
        this.arrivalCheck = arrivalCheck;
    }

    public Boolean getTreatmentCheck() {
        return treatmentCheck;
    }

    public void setTreatmentCheck(Boolean treatmentCheck) {
        this.treatmentCheck = treatmentCheck;
    }

    public Boolean getTreatedCheck() {
        return treatedCheck;
    }

    public void setTreatedCheck(Boolean treatedCheck) {
        this.treatedCheck = treatedCheck;
    }
}
