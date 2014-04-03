
/*@entity type
BusinessPerson
*/
public class BusinessPerson extends Entity{
	private String[] LeadershipFrom;
	private String[] LeadershipTo;
	private String[] LeadershipOrganization;
	private String[] LeadershipRole;
	private String[] LeadershipTitle;
	
	private String[] BoardMemberFrom;
	private String[] BoardMemberTo;
	private String[] BoardMemberOrganization;
	private String[] BoardMemberRole;
	private String[] BoardMemberTitle;
	
	private String[] FoundedOrganizationName;
	
	
	public BusinessPerson(String mid){
		super(mid);
	}
	//set the properties from json
	
	public void setLeadership(String[] from,String[] to,String[] organization,String[] role,String[] title){
		LeadershipFrom = new String[from.length];
		LeadershipTo = new String[to.length];
		LeadershipOrganization = new String[organization.length];
		LeadershipRole = new String[role.length];
		LeadershipTitle = new String[title.length];
		for (int i=0;i< from.length;i++){
			LeadershipFrom[i] = from [i];
			LeadershipTo[i] = to [i];
			LeadershipOrganization[i] = organization [i];
			LeadershipRole[i] = role [i];
			LeadershipTitle[i] = title [i];
		}
	}
	
	public void setBoardMember(String[] from,String[] to,String[] organization,String[] role,String[] title){
		BoardMemberFrom = new String[from.length];
		BoardMemberTo = new String[to.length];
		BoardMemberOrganization = new String[organization.length];
		BoardMemberRole = new String[role.length];
		BoardMemberTitle = new String[title.length];
		for (int i=0;i< from.length;i++){
			BoardMemberFrom[i] = from [i];
			BoardMemberTo[i] = to [i];
			BoardMemberOrganization[i] = organization [i];
			BoardMemberRole[i] = role [i];
			BoardMemberTitle[i] = title [i];
		}
	}
	
	public void setFoundedOrganizationName (String[] name){
		FoundedOrganizationName = new String[name.length];
		for (int i=0;i< name.length;i++){
			FoundedOrganizationName[i] = name [i];
		}
	}
	
	public void print(){
		//founded
		if (!(FoundedOrganizationName[0]== null)){
	        String Rowname0 = FlushLeft(20,"Founded:");
	        System.out.printf("|" + Rowname0);
	        for (int leng = 0;leng< FoundedOrganizationName.length;leng++){
	        	String founded = FlushLeft(78,FoundedOrganizationName[leng]);
	            System.out.printf(founded+"|");
	            System.out.println();
	            String Rowname1 = FlushLeft(20,"");
	            System.out.printf("|" + Rowname1);
	        }
	        String space = FlushLeft(78,"");
	        System.out.printf(space + "|");
	        System.out.println();
	        System.out.println(" "+"--------------------------------------------------------------------------------------------------");
	        }
		
		//Leadership
		if (LeadershipOrganization[0]!= ""){
		 String Rowname0 = FlushLeft(20,"Leadership");
	     System.out.printf("|" + Rowname0);
	     String Rowname01 = FlushLeft(21,"Organization");
	     System.out.printf("|" + Rowname01);   
	     String Rowname02 = FlushLeft(18,"Role");
	     System.out.printf("|" + Rowname02   );  
	     String Rowname021 = FlushLeft(18,"Title");
	     System.out.printf("|" + Rowname021   );  
	     String Rowname022 = FlushLeft(17,"From-To");
	     System.out.printf("|" + Rowname022 + "|");  
	     
	     System.out.println();
	     String Rowname03 = FlushLeft(20,"");
	     System.out.printf("|" + Rowname03);
	     System.out.printf(" "+"-----------------------------------------------------------------------------");
	     System.out.println();
	     for (int leng1 = 0;leng1< LeadershipOrganization.length;leng1++){
	    	    
	        	String Rowname1 = FlushLeft(20,"");
	            System.out.printf("|" + Rowname1);
	            String organization = FlushLeft(21,LeadershipOrganization[leng1]);
	            System.out.printf("|"+organization);
	            String role = FlushLeft(18,LeadershipRole[leng1]);
	            System.out.printf("|"  +role );
	            String title = FlushLeft(18,LeadershipTitle[leng1]);
	            System.out.printf("|"  +title );
	            String fromto = FlushLeft(17,LeadershipFrom[leng1]+" / " + LeadershipTo[leng1]);
	            System.out.printf("|"  +fromto + "|" );
	            System.out.println();
	            
	        }   
	     System.out.println(" "+"---------------------------------------------------------------------------------------------------");
		}
	     //print board member
		if (BoardMemberOrganization[0]!= ""){
		 String Rowname0 = FlushLeft(20,"Board Member");
	     System.out.printf("|" + Rowname0);
	     String Rowname01 = FlushLeft(21,"Organization");
	     System.out.printf("|" + Rowname01);   
	     String Rowname02 = FlushLeft(18,"Role");
	     System.out.printf("|" + Rowname02   );  
	     String Rowname021 = FlushLeft(18,"Title");
	     System.out.printf("|" + Rowname021   );  
	     String Rowname022 = FlushLeft(17,"From-To");
	     System.out.printf("|" + Rowname022 + "|");  
	     
	     
	     System.out.println();
	     String Rowname03 = FlushLeft(20,"");
	     System.out.printf("|" + Rowname03);
	     System.out.printf(" "+"-----------------------------------------------------------------------------");
	     System.out.println();
	     for (int leng = 0;leng< BoardMemberOrganization.length;leng++){
	        	String Rowname1 = FlushLeft(20,"");
	            System.out.printf("|" + Rowname1);
	            String borganization = FlushLeft(21,BoardMemberOrganization[leng]);
	            System.out.printf("|"+borganization);
	            String brole = FlushLeft(18,BoardMemberRole[leng]);
	            System.out.printf("|"  +brole );
	            String btitle = FlushLeft(18,BoardMemberTitle[leng]);
	            System.out.printf("|"  +btitle );
	            String bfromto = FlushLeft(17,BoardMemberFrom[leng]+" / " + BoardMemberTo[leng]);
	            System.out.printf("|"  +bfromto + "|" );
	            System.out.println();
	            
	        }   
	     System.out.println(" "+"---------------------------------------------------------------------------------------------------");
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
