package com.example.bookmymovie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDetailsRepo extends JpaRepository<BookMovies,Integer> 
{
	@Query(nativeQuery=true,
			value="SELECT * FROM movie_details where title=:searcharea")
	List<MovieDetails> search(@Param("searcharea")String searcharea);
	

}
