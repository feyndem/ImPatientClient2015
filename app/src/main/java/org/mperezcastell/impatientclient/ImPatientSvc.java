/* 
 **
 ** Copyright 2014, Jules White
 **
 ** 
 */
package org.mperezcastell.impatientclient;

import android.content.Context;
import android.content.Intent;


import org.mperezcastell.impatientclient.oauth.SecuredRestBuilder;
import org.mperezcastell.impatientclient.unsafe.EasyHttpClient;


import retrofit.RestAdapter.LogLevel;
import retrofit.client.ApacheClient;

public class ImPatientSvc {

	public static final String CLIENT_ID = "mobile";

	private static ImPatientSvcApi imPatientSvc_;

	public static synchronized ImPatientSvcApi getOrShowLogin(Context ctx) {
		if (imPatientSvc_ != null) {
			return imPatientSvc_;
		} else {
			Intent i = new Intent(ctx, LoginActivity.class);
			ctx.startActivity(i);
			return null;
		}
	}

	public static synchronized ImPatientSvcApi init(String server, String user,
			String pass) {

		imPatientSvc_ = new SecuredRestBuilder()
				.setLoginEndpoint(server + ImPatientSvcApi.TOKEN_PATH)
				.setUsername(user)
				.setPassword(pass)
				.setClientId(CLIENT_ID)
				.setClient(
						new ApacheClient(new EasyHttpClient()))
				.setEndpoint(server).setLogLevel(LogLevel.FULL).build()
				.create(ImPatientSvcApi.class);

		return imPatientSvc_;
	}
}
