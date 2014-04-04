/*@entity type
 Person
 */
public class Person extends Entity {
	private String Name;
	private String Birthday;
	private String Place_of_Birth;
	private String Death_Place;
	private String Death_Date;
	private String Death_Cause;
	private String[] Siblings;
	private String[] Spouses;
	private String Description;
	
	public Person(String mid){
		super(mid);
	}
    
	public String Death(){
		String date = this.Death_Date;
		String place = this.Death_Place;
		String cause = this.Death_Cause;
		return date+" at "+ place + ", cause: "+ cause;
	}
	
	//get the propoerties from json
	
	public void setName(String name){
		Name = name;
	}
	
	public String getName(){
		return Name;
	}
	
	public void setBirthday(String birthday){
		Birthday = birthday;
	}
	
	public String getBirthday(){
		return Birthday;
	}
	
	public void setPlaceofBirth(String place){
		Place_of_Birth = place;
	}
	
	public String getPlaceofBirth(){
		return Place_of_Birth;
	}
	
	public void setDeathPlace(String place){
		Death_Place = place;
	}
	
	public void setDeathDate(String date){
		Death_Date = date;
	}
	
	public void setDeathCause(String cause){
		Death_Cause = cause;
	}
	
	public void setSiblings(String[] siblings){
		Siblings = new String[siblings.length];
		for (int i=0;i< siblings.length;i++){
			Siblings[i] = siblings[i];
		}
		
	}
	
	public String getSiblings(){
		String siblinglist = "";
		for(int i=0;i<Siblings.length;i++){
			if(i==Siblings.length-1){
				siblinglist=siblinglist+Siblings[i];
			}else{
				siblinglist=siblinglist+Siblings[i]+"\n";
			}
		}
		return siblinglist;
		
	}
	
	public void setSpouses(String[] spouses){
		Spouses = new String[spouses.length];
		for (int i=0;i< spouses.length;i++){
			Spouses[i] = spouses[i];
		}
	}
	
	public String getSpouses(){
		String spouselist = "";
		for(int i=0;i<Spouses.length;i++){
			if(i==Spouses.length-1){
				spouselist=spouselist+Spouses[i];
			}else{
				spouselist=spouselist+Spouses[i]+"\n";
			}
		}
		return spouselist;
	}
	
	public void setDescription(String description){
		Description = description;
	}
	
	public String getDescription(){
		return Description;
	}
	//print the info box we need
	public void print(){
		String space = FlushLeft(78,"");
		//print name
		/*System.out.println(" "+"--------------------------------------------------------------------------------------------------");
		
		String namespace = FlushLeft(40,"");
		System.out.printf( "|" + namespace );
		String name = FlushLeft(58,this.getName());
		System.out.printf(name+"|");
		System.out.println();
		System.out.println(" "+"--------------------------------------------------------------------------------------------------");
		 */
		String Rowname0 = FlushLeft(20,"Name:");
        System.out.printf( "|" + Rowname0);
        String name = FlushLeft(78,Name);
        System.out.printf(name+"|");
        System.out.println();
        System.out.println(" "+"--------------------------------------------------------------------------------------------------");
		 //print birthday
        if (Birthday!= null){
        String Rowname1 = FlushLeft(20,"Date of Birth:");
        System.out.printf( "|" + Rowname1);
        String Bday = FlushLeft(78,this.getBirthday());
        System.out.printf(Bday+"|");
        System.out.println();
        System.out.println(" "+"--------------------------------------------------------------------------------------------------");
        }
        //print birth place
        if (Place_of_Birth != null){
        String Rowname2 = FlushLeft(20,"Place of Birth:");
        System.out.printf("|" + Rowname2);
        String Bplace = FlushLeft(78,this.getPlaceofBirth());
        System.out.printf(Bplace+"|");
        System.out.println();
        System.out.println(" "+"--------------------------------------------------------------------------------------------------");
        }
        //print death
        if (!(Death_Date == null)){
        	String Rowname21 = FlushLeft(20,"Death:");
            System.out.printf("|" + Rowname21);
            String death = FlushLeft(78,Death());
            System.out.printf(death+"|");
            System.out.println();
            System.out.println(" "+"--------------------------------------------------------------------------------------------------");
        }
        
        //print description
        if (Description!=null){
        String Rowname3 = FlushLeft(20,"Description:");
        System.out.printf("|" + Rowname3);
        int leng = this.getDescription().length();
        int leng1 = leng/78 ;
        for (int leng2 = 0;leng2< leng1;leng2++){
        String subdesc = this.getDescription().substring(leng2*78,(leng2+1)*78);
        if (!subdesc.contains("\n")){
        	System.out.printf(subdesc + "|");
        	System.out.println();
            String Rowname4 = FlushLeft(20,"");
            System.out.printf("|" + Rowname4);
        }
        }
        
        System.out.printf(space + "|");
        System.out.println();
        System.out.println(" "+"--------------------------------------------------------------------------------------------------");
        }
        //print siblings
        if (!(Siblings[0]== "")){
        String Rowname5 = FlushLeft(20,"Siblings:");
        System.out.printf("|" + Rowname5);
        for (int leng2 = 0;leng2< Siblings.length;leng2++){
        	String siblings = FlushLeft(78,Siblings[leng2]);
            System.out.printf(siblings+"|");
            System.out.println();
            String Rowname4 = FlushLeft(20,"");
            System.out.printf("|" + Rowname4);
        }
        
        System.out.printf(space + "|");
        System.out.println();
        System.out.println(" "+"--------------------------------------------------------------------------------------------------");
        }
        //print spousess
        if (!(Spouses[0]== "")){
        String Rowname6 = FlushLeft(20,"Spouses:");
        System.out.printf("|" + Rowname6);
        for (int leng2 = 0;leng2< Spouses.length;leng2++){
        	String spouses = FlushLeft(78,Spouses[leng2]);
            System.out.printf(spouses+"|");
            System.out.println();
            String Rowname4 = FlushLeft(20,"");
            System.out.printf("|" + Rowname4);
        }
        System.out.printf(space + "|");
        System.out.println();
        System.out.println(" "+"--------------------------------------------------------------------------------------------------");
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
