package br.edu.ifg.proi.tika;

/*import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;*/


public class GetMetadata {
	
   /*public static void main(final String[] args) throws IOException, TikaException {
	
      //Assume that boy.jpg is in your current directory
      File file = new File("boy.jpg");

      //Parser method parameters
      Parser parser = new AutoDetectParser();
      BodyContentHandler handler = new BodyContentHandler();
      Metadata metadata = new Metadata();
      FileInputStream inputstream = new FileInputStream(file);
      ParseContext context = new ParseContext();
      
      parser.parse(inputstream, handler, metadata, context);
      System.out.println(handler.toString());

      //getting the list of all meta data elements 
      String[] metadataNames = metadata.names();

      for(String name : metadataNames) {		        
         System.out.println(name + ": " + metadata.get(name));
      }
   }*/
}