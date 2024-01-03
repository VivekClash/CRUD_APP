package com.vivek.users.service;

public interface UserService {
	
	public boolean verifyLoginCreds(String userId,String password) throws Exception;

}
