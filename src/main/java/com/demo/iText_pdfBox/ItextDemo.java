package com.demo.iText_pdfBox;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class ItextDemo {
	public void inserttextPdf() {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("iText_Output\\iTextDemo-Anjani.pdf"));
			document.open();
			Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
			Chunk chunk = new Chunk("iTextDemo- Anjani Kumar Choudhary - Success", font);
			document.add(chunk);
			System.out.println("inserttextPdf Success");
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
		document.close();
	}

	public void insertImagePdf() {
		try {
			Path path = Paths.get(ClassLoader.getSystemResource("logo.png").toURI());
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream("iText_Output\\iTextImageExample.pdf"));
			document.open();
			Image img = Image.getInstance(path.toAbsolutePath().toString());
			document.add(img);
			document.close();
			System.out.println("insertImagePdf Success");
		} catch (URISyntaxException | DocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertTable() {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("iText_Output\\iTextTable.pdf"));
			document.open();
			PdfPTable table = new PdfPTable(3);
			addTableHeader(table);
			addRows(table);
			addCustomRows(table);
			document.add(table);
			document.close();
		} catch (DocumentException | URISyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("insertTable Success");
	}

	private void addTableHeader(PdfPTable table) {
		Stream.of("column header 1", "column header 2", "column header 3").forEach(columnTitle -> {
			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setBorderWidth(2);
			header.setPhrase(new Phrase(columnTitle));
			table.addCell(header);
		});
	}

	private void addRows(PdfPTable table) {
		table.addCell("row 1, col 1");
		table.addCell("row 1, col 2");
		table.addCell("row 1, col 3");
	}

	private void addCustomRows(PdfPTable table) throws URISyntaxException, BadElementException, IOException {
		Path path = Paths.get(ClassLoader.getSystemResource("logo.png").toURI());
		Image img = Image.getInstance(path.toAbsolutePath().toString());
		img.scalePercent(10);

		PdfPCell imageCell = new PdfPCell(img);
		table.addCell(imageCell);

		PdfPCell horizontalAlignCell = new PdfPCell(new Phrase("row 2, col 2"));
		horizontalAlignCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(horizontalAlignCell);

		PdfPCell verticalAlignCell = new PdfPCell(new Phrase("row 2, col 3"));
		verticalAlignCell.setVerticalAlignment(Element.ALIGN_BOTTOM);
		table.addCell(verticalAlignCell);
	}

	public void insertFileEncryption() {
		try {
			PdfReader pdfReader = new PdfReader("iText_Output\\HelloWorld.pdf");
			PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream("iText_Output\\encryptedPdf.pdf"));
			pdfStamper.setEncryption("userpass".getBytes(), "userpass".getBytes(), 0, PdfWriter.ENCRYPTION_AES_256);
			pdfStamper.close();
			System.out.println("insertFileEncryption Success");
		} catch (IOException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
