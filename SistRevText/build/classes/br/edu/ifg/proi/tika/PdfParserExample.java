package br.edu.ifg.proi.tika;  


/*import java.io.IOException;  
import java.io.InputStream;  
import org.apache.tika.exception.TikaException;  
import org.apache.tika.metadata.Metadata;  
import org.apache.tika.parser.ParseContext;  
import org.apache.tika.parser.pdf.PDFParser;  
import org.apache.tika.sax.BodyContentHandler;  
import org.xml.sax.SAXException;  
*/

public class PdfParserExample {  
	
	/*
    public static void main(String[] args) throws IOException, SAXException, TikaException {  
         BodyContentHandler handler   = new BodyContentHandler();  
         PDFParser parser             = new PDFParser();  
         Metadata metadata            = new Metadata();  
         ParseContext pcontext        = new ParseContext();  
         try (InputStream stream = AutoDetectParseExample.class.getResourceAsStream("javatpoint.pdf")) {  
                parser.parse(stream, handler, metadata, pcontext);  
         System.out.println("Document Content:" + handler.toString());  
         System.out.println("Document Metadata:");  
         String[] metadatas = metadata.names();   
         for(String data : metadatas) {  
             System.out.println(data + ":   " + metadata.get(data));    
         }  
         }catch(Exception e) {System.out.println("Exception message: "+ e.getMessage());}  
       }  */
    }  