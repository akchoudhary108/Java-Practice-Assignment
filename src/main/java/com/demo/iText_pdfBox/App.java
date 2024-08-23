package com.demo.iText_pdfBox;

/**
 * @author Anjani Choudhary
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ItextDemo itextDemo = new ItextDemo();   
        itextDemo.inserttextPdf();        
        itextDemo.insertImagePdf();         
        itextDemo.insertTable();        
        itextDemo.insertFileEncryption();
        
        PdfBoxDemo boxDemo = new PdfBoxDemo();
        boxDemo.inserttextPdf();
        boxDemo.insertImage();
        boxDemo.insertEncryptedFile();
    }
}
