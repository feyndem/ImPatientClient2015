package org.mperezcastell.impatientclient;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mmpc on 12/10/15.
 */
public class Patient implements Parcelable {

    private String recordNumber;
    private String firstName;
    private String lastName;
    private String userName;

    // Parcelable interface

    public static final Parcelable.Creator<Patient> CREATOR = new
            Parcelable.Creator<Patient>() {
                public Patient createFromParcel(Parcel in) {
                    return new Patient(in);
                }

                public Patient[] newArray(int size) {
                    return new Patient[size];
                }
            };

    public Patient() {
    }

    private Patient(Parcel in) {
        readFromParcel(in);
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(recordNumber);
        out.writeString(firstName);
        out.writeString(lastName);
        out.writeString(userName);

    }

    public void readFromParcel(Parcel in) {
        recordNumber = in.readString();
        firstName = in.readString();
        lastName = in.readString();
        userName = in.readString();

    }

    public int describeContents() {
        return 0;
    }

    // Getters and Setters

    public String getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
