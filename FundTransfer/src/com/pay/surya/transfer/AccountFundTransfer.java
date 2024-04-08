package com.pay.surya.transfer;

import java.util.Scanner;

import com.pay.surya.bean.User;
import com.pay.surya.bean.utils.Utils;
import com.pay.surya.service.UserService;
import com.pay.surya.validate.ValidateUser;

public class AccountFundTransfer implements UserService {

	User user1, user2;
	int user, activeAcc;
	Scanner scanner = new Scanner(System.in);
	private String accType;

	{
		user1 = new User();
		user2 = new User();
	}

	public static void main(String[] args) {

		AccountFundTransfer fundTransfer = new AccountFundTransfer();
		fundTransfer.mainMenu();

	}

	private void mainMenu() {

		System.out.println("");

		if (activeAcc != 0) {
			System.out.println("1. Logout");
			System.out.println("2. My Account Detail");
			System.out.println("3. Account Activity");
			System.out.println("4. Fund Transfer");
			System.out.println("5. Withdraw");
			System.out.println("6. Change Pin");

		} else {
			System.out.println("1. Login");
			System.out.println("2. Create Account");
		}

		System.out.println("");

		int menuChoice = scanner.nextInt();
		if (menuChoice == 1) {
			this.login();

		} else {
			this.createAccount();
		}

	}

	@Override
	public void login() { 
		System.out.println("Welcome to bank");
		System.out.println("Eneter Your bank Account Number");
		String accNumber=scanner.next();
		
		if(accNumber.equalsIgnoreCase(user1.getAcccountNumber()))
		{
			System.out.println("Eneter 6 digit Pin !!!");
			int pin = scanner.nextInt();
			if(ValidateUser.verifyPin(pin, user1))
			{
			activeAcc=1;	
			System.out.println("!! Login Successfull   !!");
			createLog(user1, "Account Login");
			mainMenu();
			}
			else
			{
				System.out.println("!! Wrong Pin Try Again !!");
				login();
			}
		}
		
		else if(accNumber.equalsIgnoreCase(user2.getAcccountNumber()))
		{
			
			System.out.println("Eneter 6 digit Pin !!!");
			int pin = scanner.nextInt();
			if(ValidateUser.verifyPin(pin, user2))
			{
			activeAcc=2;	
			System.out.println("!! Login Successfull   !!");
			createLog(user2, "Account Login");
			mainMenu();
			}
			else
			{
				System.out.println("!! Wrong Pin Try Again !!");
				login();
			}
		}

		
	}

	@Override
	public void createAccount() {
		
		if(user1.getUserName()==null)
		{
			user=1;
		}
		else if(user2.getUserName()==null)
		{
			user=2;
			
		}
		else
		{
			System.out.println("!! OOps Only 2 user Can be created...");
		}

		System.out.println("--------Fill Detail to Continue---------");
		System.out.println("====|  Enter Bank Name  |====");
		String bankName = scanner.next();

		if (!ValidateUser.checkLength(3, bankName, false)) {
			print("[!! Bank Name is Not Valid or Empty !! ]");
			createAccount();
		}

		System.out.println("====|  Full Name  |====");
		String name = scanner.next();

		if (!ValidateUser.checkLength(2, name, false)) {
			print("[!! Name is Not Valid or Empty !! ]");
			createAccount();
		}

		System.out.println("====|  Email  |====");
		String email = scanner.next();

		if (!ValidateUser.checkLength(10, email, false) && !ValidateUser.validateEmail(email)) {
			print("[!! Email is Not Valid or Empty !! ]");
			createAccount();
		}

		System.out.println("====|  Mobile Number  |====");
		String mobile = scanner.next();

		if (ValidateUser.validateMaxMobile(mobile) || ValidateUser.validateMinMobile(mobile)) {
			print("[!! Mobile Number Must be 10 digit !! ]");
			createAccount();
		}

		System.out.println("====|  Create IFSC Code  |====");
		String ifsc = scanner.next();

		if (!ValidateUser.checkLength(11, ifsc, true)) {
			print("[!! ifsc is Not Valid or Empty !! ]");
			createAccount();
		}

		System.out.println("====|  Select Account Type    |====");
		System.out.println("1.Saving ");
		System.out.println("2.Current");
		int accountType = scanner.nextInt();
		if(accountType!= 0 && accountType<=2)
		{
		  if(accountType==1)
			  accType="Saving";
		  else
			  accType="Current";
		}
		else
		{
			print("[!! Account Type is Not Valid !! ]");
		}
		
		System.out.println("====|    Enter Amount You want to Save   |====");
		int amount = scanner.nextInt();
		if(amount<0)
		{
		print("[!! Sorry You Can Not Open an Account With 0(Zero) !! ]");	
		}
		
		System.out.println("====|  Create 6 Digit Pin    |====");
		int pin = scanner.nextInt();
		if (!ValidateUser.checkLength(6, String.valueOf(pin),true)) {
			print("[!! Pin Must Be 6 Digit !! ]");
			createAccount();
		}
		
		System.out.println("====|   Generating 11 Digit Account Number    |====");
		String acNum = Utils.generateAcNum();
		if(user==1)
		{
		user1.setAcccountNumber(acNum);
		user1.setUserName(name);
		user1.setAccountBalance(amount);
		user1.setBankName(bankName);
		user1.setAccountPin(pin);
		user1.setEmail(email);
		user1.setType(accType);
		user1.setAcccountNumber(acNum);
		user1.setHistory(Utils.getTimestamp());
		user1.setIfscCode(ifsc);
		user1.setMobile(mobile);
		this.createLog(user1, " Account Created "); 
	    this.accountInfo(user1);
		}
		else
		{
			user2.setAcccountNumber(acNum);
			user2.setUserName(name);
			user2.setAccountBalance(amount);
			user2.setBankName(bankName);
			user2.setAccountPin(pin);
			user2.setEmail(email);
			user2.setType(accType);
			user2.setAcccountNumber(acNum);
			user2.setHistory(Utils.getTimestamp());
			user2.setIfscCode(ifsc);
			user2.setMobile(mobile);
			this.createLog(user2, " Account Created "); 
		    this.accountInfo(user2);

			
		}
	}

	
	
	private void accountInfo(User user) {
		System.out.println("-----------*******-------------");
		System.out.println("-----------***[ Account Created Successfully ]***-------------");
		System.out.println("!! Account Detail !!");
		System.out.println("!!~ Bank Name => " + user.getBankName());
		System.out.println("!!~ Account Name => " + user.getUserName());
		System.out.println("!!~ Account Email => " + user.getEmail());
		System.out.println("!!~ Mobile Number => " + user.getMobile());
		System.out.println("!!~ Account Number => " + user.getAcccountNumber());
		System.out.println("!!~ Account Balance => " + user.getAccountBalance());
		System.out.println("!!~ Account Type => " + user.getType());
		System.out.println("!!~ IFSC Code => " + user.getIfscCode());
		System.out.println("!!~ Account Pin => " + user.getAccountPin());
		print("-----------*******-------------");
		this.mainMenu();
 	 	  	
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

	@Override
	public void createLog(User user, String msg) {
		 
		String history=null;
		if(user.getHistory()==null)
		{
			history="";
		}
		else
		{
			history=user.getHistory();
			
		}
		user.setHistory(msg+" on "+Utils.getTimestamp()+"\n"+history);
	}

}
