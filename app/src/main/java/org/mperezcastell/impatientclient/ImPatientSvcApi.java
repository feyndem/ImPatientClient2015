package org.mperezcastell.impatientclient;

import org.mperezcastell.impatientclient.oauth.SecuredRestBuilder;

import java.lang.reflect.Array;
import java.util.Collection;


import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * This interface defines an API for a VideoSvc. The
 * interface is used to provide a contract for client/server
 * interactions. The interface is annotated with Retrofit
 * annotations so that clients can automatically convert the
 * 
 * 
 * @author jules
 *
 */
public interface ImPatientSvcApi {
	
	public static final String PASSWORD_PARAMETER = "password";

	public static final String USERNAME_PARAMETER = "username";

	public static final String TITLE_PARAMETER = "title";
	
	public static final String DURATION_PARAMETER = "duration";
	
	public static final String TOKEN_PATH = "/oauth/token";

	@GET("/admin/gethello")
	public String getHello();

	@GET("/")
	public Collection<UserCredential> getHome();

	@GET("/patient/appointment")
	public Appointment getAppointment();

}
