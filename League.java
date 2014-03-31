/*@entity
League type
*/
public class League extends Entity{
	private String Name;
	private String Championship;
	private String Sport;
	private String Slogan;
	private String OfficialWebsite;
	private String Description;
	private String[] Teams;
	
	//set the properties from Json
	
	public League(String mid){
		super(mid);
	}
	
	public void setName(String name){
		Name = name;
	}
	
	public String getName(){
		return Name;
	}
	
	public void setChampionship(String championship){
		Championship = championship;
	}
	
	public String getChampionship(){
		return Championship;
	}
	
	public void setSport(String sport){
		Sport= sport;
	}
	
	public String getSport(){
		return Sport;
	}
	
	public void setSlogan(String slogan){
		Slogan= slogan;
	}
	
	public String getSlogan(){
		return Slogan;
	}
	
	public void setOfficialWebsite(String officialWebsite){
		OfficialWebsite= officialWebsite;
	}
	
	public String getOfficialWebsite(){
		return OfficialWebsite;
	}
	
	public void setDescription(String description){
		Description= description;
	}
	
	public String getDescription(){
		return Description;
	}
	
	public void setTeams(String[] teams){
		Teams = new String[teams.length];
		for (int i = 0; i< teams.length;i++){
			Teams [i]= teams [i];
		}
	}
	
	public void print(){
		System.out.println("---------"); //still not sure about this part
	}
	
}
