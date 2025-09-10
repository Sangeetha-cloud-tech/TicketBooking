package com.example.bookmymovie;

//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
	import java.util.List;
	import java.util.Optional;


	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.MockitoAnnotations;



	public class TicketTest {

	    @InjectMocks
	    private TicketService servicee;

	    @Mock
	    private BookingInformationRepo repo;
	    
	    @Mock
	    private MovieDetailsRepo repo1;
	    @BeforeEach
	    public void init() {
	        MockitoAnnotations.openMocks(this);
	    }
	    
	        @Test
	        public void filter()
	        {
	        	
	        List<Paymentdetails1> ins=servicee.bookingInformation("Sangeetha");
	        List<Paymentdetails1> ins1=servicee.bookingInformation("Narayan");
	       assertEquals(ins,ins1);
	        	
	      }
	        @Test
	        public void filter1()
	        {
	        	
	        List<Paymentdetails1> ins=servicee.bookingInformation("Srihari");
	        List<Paymentdetails1> ins1=servicee.bookingInformation("Murugan");
	       assertEquals(ins,ins1);
	        	
	      }
	        @Test
	        public void filter2()
	        {
	        	
	        List<MovieDetails> ins=servicee.searchMovies("Coolie");
	        List<MovieDetails> ins1=servicee.searchMovies("Kubera");
	       assertEquals(ins,ins1);
	        	
	      }
	        @Test
	        public void filter3()
	        {
	        	
	        List<MovieDetails> ins=servicee.searchMovies("Margan");
	        List<MovieDetails> ins1=servicee.searchMovies("Kubera");
	       assertEquals(ins,ins1);
	        	
	      }
	       
	    }


