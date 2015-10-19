package org.mperezcastell.impatientclient;

import java.io.Serializable;

public class UserCredential implements Serializable {



    private String id;
    private String userId;
    private String userName;
    private String userType;
    private int userRoleValue;
    private String password;

    public enum UserRole {
        NOT_ASSIGNED(-1), ADMIN(500), PATIENT(200);

        private int value = -1;

        private UserRole(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
        public void setValue(int value) {this.value = value;}

        public static UserRole findByValue(int val){
            for(UserRole r : values()){
                if( r.getValue() == val ){
                    return r;
                }
            }
            return NOT_ASSIGNED;
        }
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getUserRoleValue() {
        return userRoleValue;
    }
    public void setUserRoleValue(int userRoleValue) {
        this.userRoleValue = userRoleValue;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result
				+ ((userType == null) ? 0 : userType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof UserCredential))
			return false;
		UserCredential other = (UserCredential) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userType != other.userType)
			return false;
		return true;
	}

    @Override
    public String toString() {
        return "UserCredential{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userRole=" + userType +
                ", userRoleValue=" + userRoleValue +
                ", password='" + password + '\'' +
                '}';
    }
}
