package com.example.bookmymovie;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@Controller
public class TicketController 
{
	@Autowired
	TicketService servi;
	@Autowired
	MovieRepo movierepo;
	@GetMapping("/availableseats")
	public String availableSeats(String status,Model model)
	{
		
		List<BookMovies> bookmovies1;
		status="booked";
		bookmovies1=servi.availableSeats(status);
		model.addAttribute("greetings",bookmovies1);
		
			return "selectseats";
	
	}
	@PostMapping("/selectseats")
	public String selectSeats(@RequestParam("seatno") int seatno,@RequestParam("status") String status,Model model)
			
	{
		
		if((seatno<=50)&&(movierepo.filter(seatno).isEmpty()))
		{
			servi.selectSeats(seatno,status);
			return"booked";
			
		}else
		{
			
			return"cannotbook";
		}
		
			
	}
	
	@GetMapping("/checkseats")
	public String checkSeats(@RequestParam("seatno") int seatno,Model model)
	{
		List<BookMovies> result1,result2;
		result1=servi.checkSeats(seatno);
		model.addAttribute("greetings",result1);
		if(result1.isEmpty())
		{	
		
			return "notbooked";
		}
		else
		{
			
			return "alreadybooked";
		}
		
		
		
	}
	@GetMapping("/changestatus")
	public String changeStatus(String status)
	{
		String status1="booked";
		status="selected";
		servi.changeStatus(status,status1);
		return "finalpage";
		
	}
	@GetMapping("/public/homepage")
	public String getName()
	{
		return"hii";
	}
	
	@GetMapping("/public/registeruser")
	public String registerUser(@RequestParam("number") String number,@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("mail") String mail)
{
		List<Users> result1;
		result1=servi.checkdetails(username);
		if(result1.isEmpty())
		{
	servi.registerUser(number,username,password,mail);
	return "registerdone";
		}
		else
		{
			return "alreadyuser";
		}
	}
	@GetMapping("/paymentform")
	public String payment(@RequestParam("username") String username,@RequestParam("seats") String seats,@RequestParam("venue") String venue,@RequestParam("date") String date,@RequestParam("showtime") String showtime)
	{
		servi.payment(username,seats,venue,date,showtime);
		return "paymentdone";
	}
	@GetMapping("/bookinghistory")
	public String bookingHistory(@RequestParam("username")String username,Model model)
	{
		List<Paymentdetails>result;
		result=servi.bookingHistory(username);
		model.addAttribute("info",result);
		return "bookinghistoryfetched";
	}
	@GetMapping("/accountdetails")
	public String accountDetails(@RequestParam("username")String username,Model model)
	{
		List<Users>result;
		result=servi.accountDetails(username);
		model.addAttribute("info",result);
		return "accountdetailsfetched";
	}
	
	@GetMapping("/changenumber")
	public String changeNumber(@RequestParam("oldnumber")String oldnumber,@RequestParam("newnumber")String newnumber)
	{
		servi.changeNumber(oldnumber,newnumber);
		return "updated";
	}
	@GetMapping("/changemail")
	public String changeMail(@RequestParam("oldmail")String oldmail,@RequestParam("newmail")String newmail)
	{
		servi.changeMail(oldmail,newmail);
		return "updated";
	}
	@GetMapping("/public/changepassword")
	public String changePassword(@RequestParam("username")String username,@RequestParam("newpassword")String newpassword)
	{
		List<Users>result;
		result=servi.changePassword(username,newpassword);
		return "passwordchanged";
	}
	@GetMapping("/public/ticketbookinginformation")
	public String bookingInformation(@RequestParam("username")String username,Model model)
	{
		List<Paymentdetails1>result;
		result=servi.bookingInformation(username);
		model.addAttribute("info",result);
		return "bookinginformationfetched";
	}
	
	
	
}
