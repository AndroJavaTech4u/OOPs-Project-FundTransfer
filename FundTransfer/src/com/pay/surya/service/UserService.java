package com.pay.surya.service;

import com.pay.surya.bean.User;

public interface UserService {

	public void login();

	public void createAccount();

	public void Logout();

	public void MyAccountDetail();

	public void AccountActivity();

	public void FundTransfer();

	public void withdraw();

	public void ChangePin();
	
	public void createLog(User user,String msg);
}
