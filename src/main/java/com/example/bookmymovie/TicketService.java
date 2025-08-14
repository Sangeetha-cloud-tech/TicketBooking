package com.example.bookmymovie;

import java.util.List;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



import jakarta.transaction.Transactional;

@Service
public class TicketService 
{
	@Autowired
	MovieRepo movierepo;
	@Autowired
	UserDetailsRepo repo1;
	@Autowired
	Paymentdetailsrepo repo2;
	@Autowired
	BookingInformationRepo repo3;
	BCryptPasswordEncoder passwordEncoder =new BCryptPasswordEncoder(12);
	
	
	public void selectSeats(int seatno, String status) 
	{
		
		BookMovies mt=new BookMovies(seatno,status);
		movierepo.save(mt);
		
		
	}

	public List<BookMovies> availableSeats(String status) 
	{
		return movierepo.filter1(status);	// TODO Auto-generated method stub
		
		
	}

	public List<BookMovies> checkSeats(int seatno) {
		
		List<BookMovies> result;// TODO Auto-generated method stub
	result= movierepo.filter(seatno);
	return result;
	 }
	@Transactional
public List<BookMovies> changeStatus(String status,String status1) {
		
		List<BookMovies> result;// TODO Auto-generated method stub
	 movierepo.update(status,status1);
	return null;
	
}
	public void registerUser(String number,String username,String password,String mail) 
	{
		Users user=new Users(number,username,password,mail);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		repo1.save(user);
		// TODO Auto-generated method stub
		
	}
public List<Users> checkdetails(String username) {
		
		List<Users> result;// TODO Auto-generated method stub
	result= repo1.filter(username);
	return result;
	 }
public void payment(String username,String seats,String venue,String date,String showtime) 
{
	Paymentdetails pay=new Paymentdetails(username,seats,venue,date,showtime);
	Paymentdetails1 pay1=new Paymentdetails1(username,seats,venue,date,showtime);
	repo2.save(pay);
	repo3.save(pay1);
	
	// TODO Auto-generated method stub
	
}

public List<Paymentdetails> bookingHistory(String username) 
{
	List<Paymentdetails> result1;
	result1=repo2.filter(username);
	return result1;
}

public List<Users> accountDetails(String username) {
	List<Users> result1;
	result1=repo1.filter(username);
	return result1;
		
}

@Transactional
public List<Users> changeNumber(String oldnumber, String newnumber) {
	
	repo1.update(oldnumber,newnumber);
	return null;
}
@Transactional
public List<Users> changeMail(String oldmail, String newmail) {
	repo1.update1(oldmail,newmail);// TODO Auto-generated method stub
	return null;
}
@Transactional
public List<Users> changePassword(String username, String newpassword) {
	String newpassword1 = new String();
	newpassword1=passwordEncoder.encode(newpassword);
	repo1.update2(username,newpassword1);
	return null;
}

public List<Paymentdetails1> bookingInformation(String username) {
	// TODO Auto-generated method stub
	return repo3.filter(username);
}
}
