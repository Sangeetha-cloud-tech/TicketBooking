package com.example.bookmymovie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookingInformationRepo extends JpaRepository<Paymentdetails1,String> 
{
	@Query(value="SELECT * FROM paymentdetails1 where username=:username",nativeQuery=true)
	List<Paymentdetails1>filter(@Param("username")String username);

}
