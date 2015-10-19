package org.mperezcastell.impatientclient;

import org.mperezcastell.impatientclient.Appointment;

interface ImPatientResult {

    oneway void setAppointment(in Appointment result);

}
