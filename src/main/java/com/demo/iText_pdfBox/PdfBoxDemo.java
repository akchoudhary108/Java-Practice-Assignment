package com.demo.iText_pdfBox;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class PdfBoxDemo {
	public void inserttextPdf() {
		try {
			PDDocument document = new PDDocument();
			PDPage page = new PDPage();
			document.addPage(page);
			PDPageContentStream contentStream = new PDPageContentStream(document, page);
			contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.COURIER), 12);
			contentStream.beginText();
			contentStream.showText("Hello World");
			contentStream.endText();
			contentStream.close();
			document.save("iText_Output\\pdfBoxHelloWorld.pdf");
			document.close();
			System.out.println("pdfBox\\inserttextPdf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertImage() {
		PDDocument document = new PDDocument();
		PDPage page = new PDPage();
		document.addPage(page);
		try {
			Path path = Paths.get(ClassLoader.getSystemResource("logo.png").toURI());
			PDPageContentStream contentStream = new PDPageContentStream(document, page);
			PDImageXObject image = PDImageXObject.createFromFile(path.toAbsolutePath().toString(), document);
			contentStream.drawImage(image, 0, 0);
			contentStream.close();
			document.save("iText_Output\\pdfBoxImage.pdf");
			document.close();
			System.out.println("pdfBox\\insertImage");
		} catch (URISyntaxException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	//PdfBox doesn’t provide any out-of-the-box methods that allow us to create tables. 
	//What we can do in this situation is draw it manually, literally drawing each line until our drawing resembles our desired table.
	
	public void insertEncryptedFile() {
		PDDocument document = new PDDocument();
		PDPage page = new PDPage();
		document.addPage(page);
		AccessPermission accessPermission = new AccessPermission();
		accessPermission.setCanPrint(false);
		accessPermission.setCanModify(false);
		StandardProtectionPolicy standardProtectionPolicy = new StandardProtectionPolicy("ownerpass", "userpass", accessPermission);
		try {
			document.protect(standardProtectionPolicy);
			document.save("iText_Output\\pdfBoxEncryption.pdf");
			document.close();
			System.out.println("pdfBox\\insertEncryptedFile");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
