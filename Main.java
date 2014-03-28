import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.jsoup.Jsoup;

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
        
		//---------	PART 1 INFOBOX
        
		ArrayList<String> midList = new ArrayList<String>();
        
		//search the search API with the given query
		String freebaseUrl = "https://www.googleapis.com/freebase/v1/search?query="+searchText+"&key="+accountKey;
        
		URL url = new URL(freebaseUrl);
		URLConnection urlConnection = url.openConnection();
		InputStream inputStream = (InputStream) urlConnection.getContent();
		byte[] contentRaw = new byte[urlConnection.getContentLength()];
		inputStream.read(contentRaw);
		String content = new String(contentRaw);
        
		//The content of webpage in xml/json format
		//System.out.println(content);
		
		//Length of the content in URL
		//This proves that what's being saved in "content" is the correct length, but it's not being fully searched through
		int length = content.length();
		//System.out.println(length);
		
		int j=0;
		
		PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
		System.setOut(out);
		out.println(content);
        
		//just looping through the first 10 mids right now to test
		for(int i=0; i <10; i++){
			//This keeps track of what loop you are on
			int saveIndex = content.indexOf("name", j);
			if(i>=1){
				j = saveIndex+100;
			}
			
			//Finding mid of first result
			//Find the index where the description starts
			int findmid = content.indexOf("mid", j);
			//Total characters we will reach
			int total = findmid + 1000;
			//array that will hold the characters
			char[] buffer = new char[4096];
			//put characters into array
			content.getChars(findmid+6, total, buffer, 0);
			//make the "buffer" array a string
			String str = new String(buffer);
			//find where the string will end
			int find2 = str.indexOf("\"");
			//create another "buffer" array
			char[] buffer2 = new char[1024];
			//retrieve characters from text and hold in buffer2
			str.getChars(0, find2, buffer2 , 0);
			//turn buffer into a string
			String mid = new String(buffer2);
			//analyze the string into text
			mid = Jsoup.parse(mid).text();
            
			midList.add(mid+"\n");
            
		}
        
		out.println(midList);
        
		//search for the mid in the topic API
		//commented out for now...
		
		/*String topicUrl = "https://www.googleapis.com/freebase/v1/topic"+mid+"?key="+accountKey;
         
         //read contents from topic API
         URL topicurl = new URL(topicUrl);
         URLConnection topurlConnection = topicurl.openConnection();
         InputStream inputStream2 = (InputStream) topurlConnection.getContent();
         byte[] contentRaw2 = new byte[topurlConnection.getContentLength()];
         inputStream2.read(contentRaw2);
         String content2 = new String(contentRaw2);
         
         //System.out.println(content2);*/
        
        
        
		//--------- PART 2 QUESTION
	}
    
}