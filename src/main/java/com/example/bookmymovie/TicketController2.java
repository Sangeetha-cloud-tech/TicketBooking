package com.example.bookmymovie;

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
public class TicketController2 
{
	@Autowired
	private MailService mailService;

	@Autowired
	TicketService servi;
	@GetMapping("/public/register")
	public String register()
	{
	 return "register";
	}
	@GetMapping("/public/forgotpassword")
	public String forgotPassword()
	{
	 return "forgotpassword";
	}
	@GetMapping("/public/registerdone")
	public String registerdone()
	{
	 return "registerdone";
	}
	@GetMapping("/public/passwordchanged")
	public String passwordchanged()
	{
	 return "passwordchanged";
	}
	@GetMapping("/public/bookinginformation")
	public String bookinginformation()
	{
	 return "bookinginformation";
	}
	@GetMapping("/sendmail")
	public String sendmail(@RequestParam("mailid") String to,String subject,String body)
	{
		mailService.sendMail(to,"Booking confirmation Mail","Your tickets are booked!!");
		return "finalpage";
	}
	@GetMapping("/logout")
	public String logout()
	{
	 return "register";
	}
	@GetMapping("/search")
	public String searchArea(@RequestParam("searcharea")String searcharea,Model model)
	{
		List<MovieDetails> result;
		result=servi.searchMovies(searcharea);
		if(result.isEmpty())
		{
			return"norecords";
		}
		else
		{	
			model.addAttribute("info",result);
		return "moviesearch";
		}
	}
	

}
