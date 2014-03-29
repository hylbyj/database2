//package dbproj2;

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

import java.util.ArrayList;

public class main {
	public static void main(String[] args) {
		try {
            
			//query (will eventually be from parameters)
			String query = null;
			String accountKey = null;
			query = "Bill Gates";
			accountKey = "AIzaSyCIQ8gDGEMgxJpSsGK6BwkfLZXtN4MTf4E";
            
			HttpTransport httpTransport = new NetHttpTransport();
			HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
			JSONParser parser = new JSONParser();
			GenericUrl url = new GenericUrl("https://www.googleapis.com/freebase/v1/search");
			url.put("query", query);
			//url.put("filter", "(all type:/music/artist created:\"The Lady Killer\")");
			url.put("limit", "5");
			url.put("indent", "true");
			url.put("key", accountKey);
			HttpRequest request = requestFactory.buildGetRequest(url);
			HttpResponse httpResponse = request.execute();
			JSONObject response = (JSONObject)parser.parse(httpResponse.parseAsString());
			JSONArray results = (JSONArray)response.get("result");
            
			ArrayList<String> midList = new ArrayList<String>();
            
			for (Object result : results) {
				midList.add(JsonPath.read(result,"$.mid").toString());
			}
            
			System.out.println(midList);
            
			for(int i=0; i<midList.size(); i++){
                
				String topicId = midList.get(i);
				GenericUrl topicUrl = new GenericUrl("https://www.googleapis.com/freebase/v1/topic" + topicId);
				topicUrl.put("key", accountKey);
				HttpRequest request2 = requestFactory.buildGetRequest(topicUrl);
				HttpResponse httpResponse2 = request2.execute();
				JSONObject topic = (JSONObject)parser.parse(httpResponse2.parseAsString());
                
				ArrayList<String> topicList = new ArrayList<String>();
                
				for(int j=0; j<10; j++){
					topicList.add(JsonPath.read(topic,"$.property['/type/object/type'].values["+j+"].text").toString());
				}
                
				System.out.println(topicList);
                
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}