import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.jayway.jsonpath.JsonPath;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.*;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

public class part2 {
	public boolean op3 = false;
	public void main(String Question,String key) {
		try {

			//come from parameters
			String accountKey = "AIzaSyCIQ8gDGEMgxJpSsGK6BwkfLZXtN4MTf4E";
			String search = Question;
			
			//print the question for option3
			if (op3){
			System.out.println(" "+"--------------------------------------------------------------------------------------------------");
			
			String namespace = FlushLeft(30,"");
			System.out.printf( "|" + namespace );
			String question = "Who craeted " + search + "?";
			
			String printname = FlushLeft(68,question);
			System.out.printf(printname+"|");
			System.out.println();
			System.out.println(" "+"--------------------------------------------------------------------------------------------------");
			}

			HttpTransport httpTransport = new NetHttpTransport();
			HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
			JSONParser parser = new JSONParser();

			//query for books
			String query = "[{\"/book/author/works_written\":[{\"a:name\":null,\"name~=\":\""+search+"\"}],\"id\":null,\"name\":null,\"type\":\"/book/author\"}]";

			GenericUrl url = new GenericUrl("https://www.googleapis.com/freebase/v1/mqlread");
			url.put("query", query);
			url.put("key", accountKey);
			HttpRequest request = requestFactory.buildGetRequest(url);
			HttpResponse httpResponse = request.execute();
			JSONObject response = (JSONObject)parser.parse(httpResponse.parseAsString());
			JSONArray results = (JSONArray)response.get("result");
			//System.out.println(results);
			Map<String, String> resultList = new TreeMap<String, String>(); 
			for (Object result : results) {
				String name = JsonPath.read(result,"$.name").toString();
				ArrayList<String> creations = new ArrayList<String>();
				String type = null;
				//for an author
				if(JsonPath.read(result,"$.type").toString().contains("/book/author")){
					type = "Author";
					int count = StringUtils.countMatches(JsonPath.read(result,"$./book/author/works_written").toString(), "a:name");
					for(int i=0; i<count; i++){
						//creations.add(JsonPath.read(result,"$./book/author/works_written").toString());
						creations.add(JsonPath.read(result,"$./book/author/works_written.a:name["+i+"]").toString());
					}
				}else{
					type = "?";
				}
				//compressing their creations
				String creationStr = "";
				for(int i=0; i<creations.size(); i++){
					if(i==0){
						creationStr = creationStr +"<"+ creations.get(i) + ">";
					}else if(creations.size()>2 && i==creations.size()-1){
						creationStr = creationStr + ", and <" + creations.get(i) +">";
					}else if(creations.size()==2 && i==creations.size()-1){
						creationStr = creationStr + " and <" + creations.get(i) +">";
					}else{
						creationStr = creationStr + ", <" + creations.get(i) + ">";
					}
				}
				//for option3 print the table
				String[] creationbook = new String[creations.size()];
				for(int l=0; l<creationbook.length; l++){
					creationbook[l] = creations.get(l);
				}
				resultList.put(name, name+" (as "+type+") created "+creationStr);
				if (op3){
				printoption3(name,type,creationbook);
				}
			}

			//query for organization
			//String query = "[{\"/book/author/works_written\":[{\"a:name\":null,\"name~=\":\"Google\"}],\"id\":null,\"name\":null,\"type|=\":[\"/book/author\",\"/organization/organization_founder\"]}]";
			String query2 = "[{\"/organization/organization_founder/organizations_founded\":[{\"a:name\":null,\"name~=\":\""+search+"\"}],\"id\":null,\"name\":null,\"type\":\"/organization/organization_founder\"}]";

			url = new GenericUrl("https://www.googleapis.com/freebase/v1/mqlread");
			url.put("query", query2);
			url.put("key", accountKey);
			request = requestFactory.buildGetRequest(url);
			httpResponse = request.execute();
			response = (JSONObject)parser.parse(httpResponse.parseAsString());
			results = (JSONArray)response.get("result");

			for (Object result : results) {
				String name = JsonPath.read(result,"$.name").toString();
				ArrayList<String> creations = new ArrayList<String>();
				String type = null;
				//for an author
				if(JsonPath.read(result,"$.type").toString().contains("/organization/organization_founder")){
					type = "Businessperson";
					int count = StringUtils.countMatches(JsonPath.read(result,"$./organization/organization_founder/organizations_founded").toString(), "a:name");
					for(int i=0; i<count; i++){
						//creations.add(JsonPath.read(result,"$./organization/organization_founder/organizations_founded").toString());
						creations.add(JsonPath.read(result,"$./organization/organization_founder/organizations_founded.a:name["+i+"]").toString());
					}
				}else{
					type = "?";
				}
				//compressing their creations
				String creationStr = "";
				for(int i=0; i<creations.size(); i++){
					if(i==0){
						creationStr = creationStr +"<"+ creations.get(i) + ">";
					}else if(creations.size()>2 && i==creations.size()-1){
						creationStr = creationStr + ", and <" + creations.get(i) +">";
					}else if(creations.size()==2 && i==creations.size()-1){
						creationStr = creationStr + " and <" + creations.get(i) +">";
					}else{
						creationStr = creationStr + ", <" + creations.get(i) + ">";
					}
				}
				//for option3 print the table
				String[] creationauthor = new String[creations.size()];
				for(int l=0; l<creationauthor.length; l++){
					creationauthor[l] = creations.get(l);
				}
				
				if (op3) {printoption3(name,type,creationauthor);}
				resultList.put(name, name+" (as "+type+") created "+creationStr);
			}

			if (!op3){
			int i = 0;
			for(Entry<String, String> entry : resultList.entrySet()){
				i = i +1;
				System.out.println(i+". "+entry.getValue());
			}
			}
			
			

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	private static void printoption3(String name,String type,String[] creation ){
		 String Rowname0 = FlushLeft(30,name+ ":");
	     System.out.printf("|" + Rowname0);
	     String Rowname01 = FlushLeft(30,"As");
	     System.out.printf("|" + Rowname01);   
	     String Rowname02 = FlushLeft(37,"Creation");
	     System.out.printf("|"+Rowname02 + "|" );  
	     System.out.println();
	     String Rowname03 = FlushLeft(30,"");
	     System.out.printf("|"+ Rowname03);
	     System.out.printf(" "+"-------------------------------------------------------------------");
	     System.out.println();
	     for (int leng = 0;leng< creation .length;leng++){
	        	String Rowname1 = FlushLeft(30,"");
	            System.out.printf("|" + Rowname1);
	            String type1;
	            if (leng == 0) {
	            type1 = FlushLeft(30,type);}
	            else{
	            	type1 = FlushLeft(30,"");
	            }
	            System.out.printf("|"+ type1);
	            String creation1 = FlushLeft(37,creation[leng]);
	            System.out.printf("|"+creation1 + "|" );
	            System.out.println();
	            
	        }   
	        
	        
	        System.out.println(" "+"--------------------------------------------------------------------------------------------------");
				
			}
	public static String FlushLeft(int length, String string)   
    {   
        String str = string;   
        String c = " ";
        if (string.length() > length)   
            str = string.substring(0,length);   
        else  
            for (int i = 0; i < length - string.length(); i++)      
        str = str + c;   
        return str;   
    } 
	
}