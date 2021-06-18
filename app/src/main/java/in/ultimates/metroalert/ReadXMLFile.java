package in.ultimates.metroalert;


import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;


 
public class ReadXMLFile {
	private ArrayList<UpdateItem> update = null;
	private String URL;
   public  ArrayList<UpdateItem> ReadXML(String URL, String startU) {
	   this.URL= URL;
	   update = new ArrayList<UpdateItem>();
    try {
 
	SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser = factory.newSAXParser();
 
	DefaultHandler handler = new DefaultHandler() {
 
	boolean namex = false;
	boolean vicinityx = false;
	boolean latx = false;
	boolean lngx = false;
	boolean resultx = false;
	
	UpdateItem item; 
 
	public void startElement(String uri, String localName,String qName, 
                Attributes attributes) throws SAXException {
 
	
 
		if (qName.equalsIgnoreCase("result")) {
			item = new UpdateItem();
			resultx = true;
		}
 
		if (qName.equalsIgnoreCase("name")) {
			
			namex = true;
		}
		if (qName.equalsIgnoreCase("vicinity")) {
			 vicinityx = true;
		}
 
		
 
		if (qName.equalsIgnoreCase("lat")) {
			latx = true;
		}
		if (qName.equalsIgnoreCase("lng")) {
			lngx = true;
		}
		
		
	}
 
	public void endElement(String uri, String localName,
		String qName) throws SAXException {
		
		
		
		if (resultx) {
		
			update.add(item);
				resultx = false;
			}
	 
			if (namex) {
			
				
				namex = false;
			}
			if (vicinityx) {
			
				vicinityx = false;
			}
	 
			if (latx) {
			
				latx = false;
			}
	 
			if (lngx) {
			
				lngx = false;
			}
			 
	}
 
	public void characters(char ch[], int start, int length) throws SAXException {
		
		
		
			/*if(resultx)
			{
				item.setPOSTID(new String(ch, start, length));
		
			}*/
			if(namex)
			{
				item.setName(new String(ch, start, length));
		
			}
			if(vicinityx)
			{
				item.setVicinity(new String(ch, start, length));
		
			}
			if(latx)
			{
				item.setLat(new String(ch, start, length));
				
			}
			if(lngx)
			{
				item.setLng(new String(ch, start, length));
				
			}
						
			
 
	}
 
     };
 
     
InputStream is = getConnection(URL);
     
     SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		parser.parse(is, handler);
 
     } catch (Exception e) {
       Log.i("uo", "exception1");
     }

   return update;  
     
     
   }
   public static  InputStream getConnection(String url) {
		InputStream is = null;
		try {
			URLConnection conn = new URL(url).openConnection();
			conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);
			is = conn.getInputStream();
		} catch (MalformedURLException e) {
			Log.i("uo", "exception2");
		} catch (IOException e) {
			Log.i("uo", "exception3");
		}
		return is;
	}
}