/*@entity
League type
*/
public class League{
	private String Name;
	private String Championship;
	private String Sport;
	private String Slogan;
	private String OfficialWebsite;
	private String Description;
	private String[] Teams;
	
	//set the properties from Json
	
	public void setName(String name){
		Name = name;
	}
	
	public void setChampionship(String championship){
		Championship = championship;
	}
	
	public void setSport(String sport){
		Sport= sport;
	}
	
	public void setSlogan(String slogan){
		Slogan= slogan;
	}
	
	public void setOfficialWebsite(String officialWebsite){
		OfficialWebsite= officialWebsite;
	}
	
	public void setDescription(String description){
		Description= description;
	}
	
	public void setTeams(String[] teams){
		for (int i = 0; i< teams.length;i++){
			Teams [i]= teams [i];
		}
	}
	
	public void print(){
		System.out.println("---------"); //still not sure about this part
	}
	
}

