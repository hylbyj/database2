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
		//print name
		String Rowname0 = FlushLeft(20,"Name:");
        System.out.printf( "|" + Rowname0);
        String name = FlushLeft(78,Name);
        System.out.printf(name+"|");
        System.out.println();
        System.out.println(" "+"--------------------------------------------------------------------------------------------------");
				 //print sport
		        String Rowname1 = FlushLeft(20,"Sport:");
		        System.out.printf( "|" + Rowname1);
		        String sport = FlushLeft(78,Sport);
		        System.out.printf(sport+"|");
		        System.out.println();
		        System.out.println(" "+"--------------------------------------------------------------------------------------------------");
		        //slogan
		        if (Slogan!= null){
		        String Rowname2 = FlushLeft(20,"Slogan:");
		        System.out.printf("|" + Rowname2);
		        String slogan = FlushLeft(78,Slogan);
		        System.out.printf(slogan+"|");
		        System.out.println();
		        System.out.println(" "+"--------------------------------------------------------------------------------------------------");
		        }//website
		        String Rowname3 = FlushLeft(20,"Official Website:");
		        System.out.printf("|" + Rowname3);
		        String website = FlushLeft(78,OfficialWebsite);
		        System.out.printf(website+"|");
		        System.out.println();
		        System.out.println(" "+"--------------------------------------------------------------------------------------------------");
		        //championship
		        String Rowname4 = FlushLeft(20,"Championship:");
		        System.out.printf("|" + Rowname4);
		        String champion = FlushLeft(78,Championship);
		        System.out.printf(champion+"|");
		        System.out.println();
		        System.out.println(" "+"--------------------------------------------------------------------------------------------------");
		        
		      //print teams
		        if (!(Teams[0]== null)){
		        String Rowname5 = FlushLeft(20,"Teams:");
		        System.out.printf("|" + Rowname5);
		        for (int leng2 = 0;leng2< Teams.length;leng2++){
		        	String teams = FlushLeft(78,Teams[leng2]);
		            System.out.printf(teams+"|");
		            System.out.println();
		            String Rowname51 = FlushLeft(20,"");
		            System.out.printf("|" + Rowname51);
		        }
		        String space = FlushLeft(78,"");
		        System.out.printf(space + "|");
		        System.out.println();
		        System.out.println(" "+"--------------------------------------------------------------------------------------------------");
		        }
		       
		        
		        //print description
		        String Rowname6 = FlushLeft(20,"Description:");
		        System.out.printf("|" + Rowname6);
		        int leng = this.getDescription().length();
		        int leng1 = leng/78 ;
		        for (int leng2 = 0;leng2< leng1;leng2++){
		        String subdesc = Description.substring(leng2*78,(leng2+1)*78);
		        if (!subdesc.contains("\n")){
		        	System.out.printf(subdesc + "|");
		        	System.out.println();
		            String Rowname7 = FlushLeft(20,"");
		            System.out.printf("|" + Rowname7);
		        }
		        }
		        String space = FlushLeft(78,"");
		        System.out.printf(space + "|");
		        System.out.println();
		        System.out.println(" "+"--------------------------------------------------------------------------------------------------");
				
		      
			
			
		
		
		
		
	}
	public static String FlushLeft(int length, String string)   
    {   
        String str = string;   
        String c = " ";
        if (string.length() > length)   
            str = string;   
        else  
            for (int i = 0; i < length - string.length(); i++)      
        str = str + c;   
        return str;   
    } 
	
}
