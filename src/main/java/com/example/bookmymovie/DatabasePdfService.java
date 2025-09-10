package com.example.bookmymovie;

import java.awt.Color;
	import java.io.ByteArrayInputStream;
	import java.io.ByteArrayOutputStream;
	import java.util.List;
	import java.util.stream.Stream;


	import com.lowagie.text.Chunk;
	import com.lowagie.text.Document;
	import com.lowagie.text.DocumentException;
	import com.lowagie.text.Element;
	import com.lowagie.text.Font;
	import com.lowagie.text.FontFactory;
	import com.lowagie.text.Paragraph;
	import com.lowagie.text.Phrase;
	import com.lowagie.text.pdf.PdfPCell;
	import com.lowagie.text.pdf.PdfPTable;
	import com.lowagie.text.pdf.PdfWriter;

	public class DatabasePdfService {
		 
	    public static ByteArrayInputStream employeePDFReport(List<Paymentdetails1> employees) {
	        Document document = new Document();
	        ByteArrayOutputStream out = new ByteArrayOutputStream();
	 
	        try {
	 
	            PdfWriter.getInstance(document, out);
	            document.open();
	 
	            // Add Content to PDF file ->
	            Font fontHeader = FontFactory.getFont(FontFactory.TIMES_BOLD, 22);
	            Paragraph para = new Paragraph("Employee Structure", fontHeader);
	            para.setAlignment(Element.ALIGN_CENTER);
	            document.add(para);
	            document.add(Chunk.NEWLINE);
	 
	            PdfPTable table = new PdfPTable(5);
	            // Add PDF Table Header ->
	            Stream.of("Username", "Seats", "Venue", "Date", "Showtime").forEach(headerTitle -> {
	                PdfPCell header = new PdfPCell();
	                Font headFont = FontFactory.getFont(FontFactory.TIMES_BOLD);
	                header.setBackgroundColor(Color.CYAN);
	                header.setHorizontalAlignment(Element.ALIGN_CENTER);
	                header.setBorderWidth(2);
	                header.setPhrase(new Phrase(headerTitle, headFont));
	                table.addCell(header);
	            });
	 
	            for (Paymentdetails1 employee : employees) {
	                PdfPCell idCell = new PdfPCell(new Phrase(String.valueOf(employee.getUsername())));
	                idCell.setPaddingLeft(4);
	                idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                table.addCell(idCell);
	 
	                PdfPCell firstNameCell = new PdfPCell(new Phrase(employee.getSeats()));
	                firstNameCell.setPaddingLeft(4);
	                firstNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                firstNameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                table.addCell(firstNameCell);
	 
	                PdfPCell lastNameCell = new PdfPCell(new Phrase(String.valueOf(employee.getVenue())));
	                lastNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                lastNameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                lastNameCell.setPaddingRight(4);
	                table.addCell(lastNameCell);
	                
	                PdfPCell deptCell1 = new PdfPCell(new Phrase(String.valueOf(employee.getDate())));
	                deptCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                deptCell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	                deptCell1.setPaddingRight(4);
	                table.addCell(deptCell1);
	 
	                PdfPCell deptCell = new PdfPCell(new Phrase(String.valueOf(employee.getShowtime())));
	                deptCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                deptCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                deptCell.setPaddingRight(4);
	                table.addCell(deptCell);
	 
	                
	            }
	            document.add(table);
	 
	            document.close();
	        } catch (DocumentException e) {
	            e.printStackTrace();
	        }
	 
	        return new ByteArrayInputStream(out.toByteArray());
	    }
	}





