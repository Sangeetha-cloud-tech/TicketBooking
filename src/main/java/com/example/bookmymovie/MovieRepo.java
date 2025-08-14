package com.example.bookmymovie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface MovieRepo extends JpaRepository<BookMovies,Integer> 
{
	@Query(nativeQuery=true,
			value="SELECT * FROM book_movies where seatno=:seatno")
	List<BookMovies> filter(@Param("seatno")int seatno);
	@Query(nativeQuery=true,
			value="SELECT * FROM book_movies where status=:status")
	List<BookMovies>filter1(String status);
	@Modifying(flushAutomatically=true)
	@Transactional
	@Query(value="UPDATE book_movies SET status=:status1 where status=:status",nativeQuery=true)
	void update(String status,String status1);
	

}
