package com.example.bookmymovie;



	import java.io.ByteArrayInputStream;
		import java.io.IOException;
		import java.util.List;
		import java.lang.Float;
		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.core.io.InputStreamResource;
		import org.springframework.http.HttpHeaders;
		import org.springframework.http.MediaType;
		import org.springframework.http.ResponseEntity;
		import org.springframework.stereotype.Controller;
		import org.springframework.web.bind.annotation.GetMapping;
		import org.springframework.web.bind.annotation.RequestParam;

		@Controller
		public class PDFExportController {
		     
		    @Autowired
		    BookingInformationRepo repo;
		 
		    @GetMapping(value = "/openpdf/employees", produces = MediaType.APPLICATION_PDF_VALUE)
		    public ResponseEntity<InputStreamResource> employeeReport(@RequestParam("username")String username)  throws IOException 
		    {
		    	
		        List<Paymentdetails1> employees =  repo.filter(username);
		 
		       ByteArrayInputStream bis = DatabasePdfService.employeePDFReport(employees);
		 
		        HttpHeaders headers = new HttpHeaders();
		        headers.add("Content-Disposition", "inline; filename=employees.pdf");
		 
		        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
		                .body(new InputStreamResource(bis));
		    }
		        
		       

		}





	



