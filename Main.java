package dbproj2;

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

public class Main {

	public static void main(String[] args) {

		try {
			Entity entity = null;
			//query (will eventually be from parameters)
			String query = null;
			String accountKey = null;
			query = "Bill Gates";
			accountKey = "AIzaSyCIQ8gDGEMgxJpSsGK6BwkfLZXtN4MTf4E";


			//load and read content in search API results
			HttpTransport httpTransport = new NetHttpTransport();
			HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
			JSONParser parser = new JSONParser();
			GenericUrl url = new GenericUrl("https://www.googleapis.com/freebase/v1/search");
			url.put("query", query);
			//url.put("filter", "(all type:/music/artist created:\"The Lady Killer\")");
			//url.put("limit", "5");
			url.put("indent", "true");
			url.put("key", accountKey);
			HttpRequest request = requestFactory.buildGetRequest(url);
			HttpResponse httpResponse = request.execute();
			JSONObject response = (JSONObject)parser.parse(httpResponse.parseAsString());
			JSONArray results = (JSONArray)response.get("result");

			ArrayList<String> midList = new ArrayList<String>();
			ArrayList<String> nameList = new ArrayList<String>();

			//make a list of the mid results
			for (Object result : results) {
				midList.add(JsonPath.read(result,"$.mid").toString());
				nameList.add(JsonPath.read(result,"$.name").toString());
			}
			//list of names for mid results

			//System.out.println(midList);

			//define freebase Types
			String[] freebaseTypeList = {"/people/person", "/book/author", "/film/actor","/tv/tv_actor","/organization/organization_founder",
					"/business/board_member", "/sports/sports_league", "/sports/sports_team", "/sports/professional_sports_team"};

			ArrayList<String> entityTypeList = new ArrayList<String>();

			//running the mids through the Topic API
			topicloop:
				for(int i=0; i<midList.size(); i++){

					//loading Topic API content
					String topicId = midList.get(i);
					GenericUrl topicUrl = new GenericUrl("https://www.googleapis.com/freebase/v1/topic" + topicId);
					topicUrl.put("key", accountKey);
					HttpRequest request2 = requestFactory.buildGetRequest(topicUrl);
					HttpResponse httpResponse2 = request2.execute();
					JSONObject topic = (JSONObject)parser.parse(httpResponse2.parseAsString());

					ArrayList<String> topicList = new ArrayList<String>();

					//return first 10 freebase type results
					for(int j=0; j<10; j++){
						topicList.add(JsonPath.read(topic,"$.property['/type/object/type'].values["+j+"].id").toString());
					}

					//System.out.println(topicList);

					//if the freebase type matches entity type, save in list
					for(int k=0; k<topicList.size(); k++){
						for(int l=0; l<freebaseTypeList.length; l++){
							if(topicList.get(k).equals(freebaseTypeList[l])){
								//change the type into what we need	
								entityTypeList.add(topicList.get(k));
							}
						}
						//if we found a match, break out of the loop for running the mids through the topic API
						if(k == topicList.size()-1 && entityTypeList.size() != 0){
							//get the mid we need for the infobox

							String mid = midList.get(i);
							String name = nameList.get(i);
							//we can use the mid here to call different entities;
							System.out.println ("Mid: "+mid);
							entity = new Entity (mid);
							if(entityTypeList.contains("/people/person")){
								entity = new Person (mid);
								setPersonType((Person)entity);
								Person person = new Person (mid);
								//name
								person.setName(name);
								//birthday
								person.setBirthday(JsonPath.read(topic,"$.property['/people/person/date_of_birth'].values[0].text").toString());
								//place of birth
								person.setPlaceofBirth(JsonPath.read(topic,"$.property['/people/person/place_of_birth'].values[0].text").toString());
								//death
								//code here...
								//siblings
								String siblings = "";
								String count = JsonPath.read(topic,"$.property['/people/person/sibling_s'].count").toString();
								double numSiblings = Double.valueOf(count);
								for(int l=0; l<numSiblings; l++){
									String sibling = (JsonPath.read(topic,"$.property['/people/person/sibling_s'].values["+l+"].property['/people/sibling_relationship/sibling'].values[0].text").toString());
									if(l==0){
										siblings = siblings+sibling;
									}else{
										siblings = siblings+", "+sibling;
									}
								}
								person.setSiblings(siblings);
								//spouses
								String spouses = "";
								count = JsonPath.read(topic,"$.property['/people/person/spouse_s'].count").toString();
								double numSpouses = Double.valueOf(count);
								for(int l=0; l<numSpouses; l++){
									String spouse = (JsonPath.read(topic,"$.property['/people/person/spouse_s'].values["+l+"].property['/people/marriage/spouse'].values[0].text").toString());
									if(l==0){
										spouses = spouses+spouse;
									}else{
										spouses = spouses+", "+spouse;
									}
								}
								person.setSpouses(spouses);
								//description
								person.setDescription(JsonPath.read(topic,"$.property['/common/topic/description'].values[0].value").toString());

								System.out.println("Name: " + person.getName());
								System.out.println("Date of Birth: "+person.getBirthday());
								System.out.println("Place of Birth: "+person.getPlaceofBirth());
								System.out.println("Sibling(s): " + person.getSiblings());
								System.out.println("Spouse(s): " + person.getSpouses());
								System.out.println("Description: " + person.getDescription());
							}

							if(entityTypeList.contains("/book/author")){
								entity = new Author (mid);
								setAuthorType((Author)entity);

							}

							if(entityTypeList.contains("/film/actor") || entityTypeList.contains("/tv/tv_actor")){
								entity = new Actor (mid);
								setActorType((Actor)entity);

							} 

							if(entityTypeList.contains("/organization/organization_founder") || entityTypeList.contains("/business/board_member")){
								entity = new BusinessPerson (mid);
								setBusinessPersonType((BusinessPerson)entity);

							} 

							if(entityTypeList.contains("/sports/sports_league")){
								entity = new League (mid);
								setLeagueType((League)entity);

							}

							if(entityTypeList.contains("/sports/sports_team") || entityTypeList.contains("/sports/professional_sports_team")){
								entity = new SportsTeam(mid);
								setSportsTeamType((SportsTeam)entity);

							} 
							break topicloop;
						}

					}
				}




			System.out.println(entityTypeList);

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}
	//call different types of entity
	private static void setPersonType (Person et){
		System.out.println("Person");
	}

	private static void setAuthorType (Author et){
		System.out.println("Author");
	}

	private static void setActorType (Actor et){
		System.out.println("Actor");
	}

	private static void setBusinessPersonType (BusinessPerson et){
		System.out.println("BusinessPerson");
	}

	private static void setLeagueType (League et){
		System.out.println("League");
	}

	private static void setSportsTeamType (SportsTeam et){
		System.out.println("SportsTeam");
	}

}
