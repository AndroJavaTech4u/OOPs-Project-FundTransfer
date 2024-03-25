package com.pay.surya.transfer;

import java.util.Scanner;
 
import com.pay.surya.bean.User;
import com.pay.surya.service.UserService;
import com.pay.surya.validate.ValidateUser;

public class AccountFundTransfer implements UserService
{
	
	User user1,user2;
	int user,activeAcc;
	Scanner scanner=new Scanner(System.in);
	
	{
		user1=new User();
		user2=new User();	
	}
	
	
	public static void main(String[] args) 
	{
	
		AccountFundTransfer fundTransfer=new AccountFundTransfer();
		fundTransfer.mainMenu();
		
		 
	}


	private void mainMenu() 
	{
	
	System.out.println("");
	
	if(activeAcc!=0)
	{
		System.out.println("1. Logout");
		System.out.println("2. My Account Detail");
		System.out.println("3. Account Activity");
		System.out.println("4. Fund Transfer");
		System.out.println("5. Withdraw");
		System.out.println("6. Change Pin");
		
	}
	else
	{
		System.out.println("1. Login");
		System.out.println("2. Create Account");
	}
	
	
	System.out.println("");
	
	int menuChoice = scanner.nextInt();
	if(menuChoice==1)
	{
		this.login();
		
	}
	else
	{
		this.createAccount();
	}
	
	
	
	
	}


	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void createAccount() {
	 
		System.out.println("--------Fill Detail to Continue---------");
		System.out.println("====|  Enter Bank Name  |====");
		String bankName = scanner.next();
		
		if (!ValidateUser.checkLength(3, bankName, false)) {
			print("[!! Bank Name is Not Valid or Empty !! ]");
			createAccount();
		}
	
		System.out.println("====|  Full Name  |====");
		String name = scanner.next();
		System.out.println("====|  Email  |====");
		String email = scanner.next();
		System.out.println("====|  Mobile Number  |====");
		String mobile = scanner.next();
		System.out.println("====|  Create IFSC Code  |====");
		String ifsc = scanner.next();
		System.out.println("====|  Select Account Type    |====");
		String accountType = scanner.next();
		System.out.println("====|    Enter Amount You want to Save   |====");
		String save = scanner.next();
		System.out.println("====|  Create 6 Digit Pin    |====");
		String pin = scanner.next();
		System.out.println("====|   Generating 11 Digit Account Number    |====");
	 	
	}


	private void print(String string) {
		System.out.println(string);
		
	}


	@Override
	public void Logout() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void MyAccountDetail() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void AccountActivity() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void FundTransfer() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void withdraw() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void ChangePin() {
		// TODO Auto-generated method stub
		
	}

}
