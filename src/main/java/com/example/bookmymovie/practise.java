package com.example.bookmymovie;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class practise 
{
	public static void main(String args[])
	{
	BCryptPasswordEncoder passwordEncoder =new BCryptPasswordEncoder(12);
	String newpassword1 = new String();
	String newpassword="hari";
	//setPassword(passwordEncoder.encode(newpass);
	newpassword1=passwordEncoder.encode(newpassword);
	System.out.println(newpassword1);
	}
	


}
