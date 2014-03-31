/*@entity
SportsTeam type
*/
public class SportsTeam extends Entity{
	private String Name;
	private String Description;
    private String Sport;
    private String Arena;
    private String [] Championships;
    private String [] CoachesName;
    private String [] CoachesPosition;
    private String [] CoachesFrom;
    private String [] CoachesTo;
    private String Founded;
    private String Leagues;
    private String Locations;
	
    private String [] PlayersRosterName;
    private String [] PlayersRosterPosition;
    private String [] PlayersRosterNumber;
    private String [] PlayersRosterFrom;
    private String [] PlayersRosterTo;
	
	//set the properties from Json
    
    public SportsTeam(String mid){
    	super(mid);
    }
	
	public void setName(String name){
		Name = name;
	}
	
	public String getName(){
		return Name;
	}
	
	public void setDescription(String description){
		Description= description;
	}
	
	public String getDescription(){
		return Description;
	}
	
	public void setSport(String sport){
		Sport= sport;
	}
	
	public String getSport(){
		return Sport;
	}
	
	public void setArena(String arena){
		Arena= arena;
	}
	
	public String getArena(){
		return Arena;
	}
	
	public void setChampionships(String[] championships){
		Championships = new String[championships.length];
		for (int i = 0; i< championships.length;i++){
			Championships [i]= championships [i];
		}
	}
	
	public void setCoaches(String[] name,String[] position,String[] from,String[] to){
		CoachesName = new String[name.length];
		CoachesPosition = new String[name.length];
		CoachesFrom = new String[name.length];
		CoachesTo = new String[name.length];		
		for (int i=0;i< name.length;i++){
			CoachesName[i] = name [i];
			CoachesPosition[i] = position [i];
			CoachesFrom[i] = from [i];
			CoachesTo[i] = to [i];
		}
	}
	
	public void setFounded(String founded){
		Founded = founded;
	}
	
	public String getFounded(){
		return Founded;
	}
	
	public void setLeagues(String leagues){
		Leagues = leagues;
	}
	
	public String getLeagues(){
		return Leagues;
	}
	
	public void setLocations(String locations){
		Locations = locations;
	}
	
	public String getLocations(){
		return Locations;
	}
	
	public void setPlayersRoster(String[] name,String[] position,String [] number,String[] from,String[] to){
		PlayersRosterName = new String[name.length];
		PlayersRosterPosition = new String[name.length];
		PlayersRosterNumber = new String[name.length];
		PlayersRosterFrom = new String[name.length];
		PlayersRosterTo = new String[name.length];		
		for (int i=0;i< name.length;i++){
			PlayersRosterName[i] = name [i];
			PlayersRosterPosition[i] = position [i];
			PlayersRosterNumber [i] = number [i];
			PlayersRosterFrom[i] = from [i];
			PlayersRosterTo[i] = to [i];
		}
	}
	public void print(){
		System.out.println("---------"); //still not sure about this part
	}
	
}
