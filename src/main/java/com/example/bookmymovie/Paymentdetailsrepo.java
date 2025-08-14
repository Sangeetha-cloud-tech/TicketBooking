package com.example.bookmymovie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Paymentdetailsrepo extends JpaRepository<Paymentdetails,Integer>
{
	@Query(value="SELECT * FROM paymentdetails where username=:username",nativeQuery=true)
	List<Paymentdetails>filter(@Param("username")String username);

}
