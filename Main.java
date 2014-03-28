//package dbproj2;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    
	public static void main(String[] args) throws IOException {
		
		//query (will eventually be from parameters)
		String query = null;
		query = "Bill Gates";
		String[] queryArr = null;
		queryArr = query.split("\\s+");
		String searchText = null;
		for(int i=0; i < queryArr.length; i++){
			if (i==0){
				searchText = queryArr[i];
			}else{
				searchText = searchText + "%20" + queryArr[i];
			}
		}
		
		String accountKey = "AIzaSyCIQ8gDGEMgxJpSsGK6BwkfLZXtN4MTf4E";
		
		String freebaseUrl = "https://www.googleapis.com/freebase/v1/search?query="+searchText+"&key="+accountKey;
		
		URL url = new URL(freebaseUrl);
		URLConnection urlConnection = url.openConnection();
        
		InputStream inputStream = (InputStream) urlConnection.getContent();
		byte[] contentRaw = new byte[urlConnection.getContentLength()];
		inputStream.read(contentRaw);
		String content = new String(contentRaw);
        
		//The content of webpage in xml/json format
		System.out.println(content);
	}
    
}