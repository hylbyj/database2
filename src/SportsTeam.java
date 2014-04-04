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
		//print name
				String Rowname0 = FlushLeft(20,"Name:");
		        System.out.printf( "|" + Rowname0);
		        String name = FlushLeft(78,Name);
		        System.out.printf(name+"|");
		        System.out.println();
		        System.out.println(" "+"--------------------------------------------------------------------------------------------------");
						 //print sport
		        if (Sport != null){
				        String Rowname1 = FlushLeft(20,"Sport:");
				        System.out.printf( "|" + Rowname1);
				        String sport = FlushLeft(78,Sport);
				        System.out.printf(sport+"|");
				        System.out.println();
				        System.out.println(" "+"--------------------------------------------------------------------------------------------------");
		        }
		        //arena
		        if (Arena != null){
				        String Rowname2 = FlushLeft(20,"Arena:");
				        System.out.printf("|" + Rowname2);
				        String arena = FlushLeft(78,Arena);
				        System.out.printf(arena+"|");
				        System.out.println();
				        System.out.println(" "+"--------------------------------------------------------------------------------------------------");
				        //championship
				        if (!(Championships[0]== null)){
					        String Rowname4 = FlushLeft(20,"Championships:");
					        System.out.printf("|" + Rowname4);
					        for (int leng = 0;leng< Championships.length;leng++){
					        	String championships = FlushLeft(78,Championships[leng]);
					            System.out.printf(championships+"|");
					            System.out.println();
					            String Rowname41 = FlushLeft(20,"");
					            System.out.printf("|" + Rowname41);
					        }
					        String space = FlushLeft(78,"");
					        System.out.printf(space + "|");
					        System.out.println();
					        System.out.println(" "+"--------------------------------------------------------------------------------------------------");
					        }
		        }
		        if (Founded != null){
				        //Founded
				        String Rowname3 = FlushLeft(20,"Founded");
				        System.out.printf("|" + Rowname3);
				        String founded = FlushLeft(78,Founded);
				        System.out.printf(founded+"|");
				        System.out.println();
				        System.out.println(" "+"--------------------------------------------------------------------------------------------------");
				        
		        }//Leagues
		        if (Leagues != null){
				        String Rowname7 = FlushLeft(20,"Leagues");
				        System.out.printf("|" + Rowname7);
				        String leagues = FlushLeft(78,Leagues);
				        System.out.printf(leagues+"|");
				        System.out.println();
				        System.out.println(" "+"--------------------------------------------------------------------------------------------------");
		        }    
		        //locations
		        if (Locations != null){
				        String Rowname8 = FlushLeft(20,"Locations");
				        System.out.printf("|" + Rowname8);
				        String location = FlushLeft(78,Locations);
				        System.out.printf(location+"|");
				        System.out.println();
				        System.out.println(" "+"--------------------------------------------------------------------------------------------------");
		        }
		        if (CoachesName[0]!= ""){
				        //coaches
				         String Rowname00 = FlushLeft(20,"Coaches");
					     System.out.printf("|" + Rowname00);
					     String Rowname01 = FlushLeft(27,"Name");
					     System.out.printf("|" + Rowname01);   
					     String Rowname02 = FlushLeft(24,"Position");
					     System.out.printf("|" + Rowname02   );  
					      
					     String Rowname022 = FlushLeft(24,"From-To");
					     System.out.printf("|" + Rowname022 + "|");  
					     
					     
					     System.out.println();
					     String Rowname03 = FlushLeft(20,"");
					     System.out.printf("|" + Rowname03);
					     System.out.printf(" "+"-----------------------------------------------------------------------------");
					     System.out.println();
					     for (int leng = 0;leng< CoachesName.length;leng++){
					        	String Rowname10 = FlushLeft(20,"");
					            System.out.printf("|" + Rowname10);
					            String coachname = FlushLeft(27,CoachesName[leng]);
					            System.out.printf("|"+coachname);
					            String coachposition = FlushLeft(24,CoachesPosition[leng]);
					            System.out.printf("|"  +coachposition );
					            
					            String fromto = FlushLeft(24,CoachesFrom[leng]+" / " + CoachesTo[leng]);
					            System.out.printf("|"  +fromto + "|" );
					            System.out.println();
					            System.out.println(" "+"---------------------------------------------------------------------------------------------------");       
				        
					     }//playroaster
					     if (PlayersRosterName[0] != ""){
					            String Rowname60 = FlushLeft(20,"PlayRoster:");
					   	     System.out.printf("|" + Rowname60);
					   	     String Rowname61 = FlushLeft(21,"Name");
					   	     System.out.printf("|" + Rowname61);   
					   	     String Rowname62 = FlushLeft(18,"Position");
					   	     System.out.printf("|" + Rowname62   );  
					   	     String Rowname63 = FlushLeft(18,"Number");
					   	     System.out.printf("|" + Rowname63   );  
					   	     String Rowname64 = FlushLeft(17,"From-To");
					   	     System.out.printf("|" + Rowname64 + "|");  
					   	     
					   	     
					   	     System.out.println();
					   	     String Rowname65 = FlushLeft(20,"");
					   	     System.out.printf("|" + Rowname65);
					   	     System.out.printf(" "+"-----------------------------------------------------------------------------");
					   	     System.out.println();
					   	     for (int pleng = 0;pleng< PlayersRosterName.length;pleng++){
					   	        	String Rowname66 = FlushLeft(20,"");
					   	            System.out.printf("|" + Rowname66);
					   	            String pname = FlushLeft(21,PlayersRosterName[pleng]);
					   	            System.out.printf("|"+pname);
					   	            String pposition = FlushLeft(18,PlayersRosterPosition[pleng]);
					   	            System.out.printf("|"  +pposition );
					   	            String pnumber = FlushLeft(18,PlayersRosterNumber[pleng]);
					   	            System.out.printf("|"  +pnumber );
					   	            String pfromto = FlushLeft(17,PlayersRosterFrom[pleng]+" / " + PlayersRosterTo[pleng]);
					   	            System.out.printf("|"  +pfromto  + "|" );
					   	            System.out.println();
					   	            
					   	        }   
					     
					   	     System.out.println(" "+"---------------------------------------------------------------------------------------------------");
					     }
				        
				        
				        
				        
				      
				        
				        //print description
					   	     if (Description != null){
				        String Rowname6 = FlushLeft(20,"Description:");
				        System.out.printf("|" + Rowname6);
				        int leng0 = this.getDescription().length();
				        int leng1 = leng0/78 ;
				        for (int leng2 = 0;leng2< leng1;leng2++){
				        String subdesc = Description.substring(leng2*78,(leng2+1)*78);
				        if (!subdesc.contains("\n")){
				        	System.out.printf(subdesc + "|");
				        	System.out.println();
				            String Rowname17 = FlushLeft(20,"");
				            System.out.printf("|" + Rowname17);
				        }
				        }
				        String space = FlushLeft(78,"");
				        System.out.printf(space + "|");
				        System.out.println();
				        System.out.println(" "+"--------------------------------------------------------------------------------------------------");
					   	     }
				      
					
					
				
				
		
		
		
		
		
	
					     }
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
