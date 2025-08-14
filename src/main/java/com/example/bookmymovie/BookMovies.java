package com.example.bookmymovie;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BookMovies 
{
	
		@Id
		private int seatno;
		private String status;
		public int getSeatno()
		{
			return seatno;
		}
		public void setSeatno(int seatno) {
			this.seatno = seatno;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public BookMovies(int seatno, String status) {
			super();
			this.seatno = seatno;
			this.status = status;
		}
		public BookMovies() {
			super();
		}
		
}


