/*@entity type
Actor
*/
public class Actor extends Entity{
	private String [] FilmName;
	private String [] Character;
	public Actor(String mid){
		super(mid);
	}
	//using string[] to get string[]
	public void setFilmsParticipated(String[] character,String[] filmname){
		FilmName = new String[filmname.length];
		Character = new String[character.length];
		for (int i=0;i< character.length;i++){
			Character[i] = character[i];
		    FilmName[i] = filmname[i];
		}
	}

	public String getFilmsParticipated(){
			String characterList = "";
			for(int i=0;i<Character.length;i++){
				if(i==Character.length-1){
					characterList=characterList+Character[i];
				}else{
					characterList=characterList+Character[i]+"\n";
				}
			}

		String filmList = "";
		for(int i=0;i<FilmName.length;i++){
			if(i==FilmName.length-1){
				filmList=filmList+FilmName[i];
			}else{
				filmList=filmList+FilmName[i]+"\n";
			}
		}
		return "Character: "+characterList+"Film Name: " +filmList;
	}

	public void print(){
		//print film and actor
		 String Rowname0 = FlushLeft(20,"Films:");
	     System.out.printf("|" + Rowname0);
	     String Rowname01 = FlushLeft(40,"Character");
	     System.out.printf("|" + Rowname01);   
	     String Rowname02 = FlushLeft(37,"Film Name");
	     System.out.printf("|"+Rowname02 + "|" );  
	     System.out.println();
	     String Rowname03 = FlushLeft(20,"");
	     System.out.printf("|"+ Rowname03);
	     System.out.printf(" "+"-----------------------------------------------------------------------------");
	     System.out.println();
	     for (int leng = 0;leng< FilmName.length;leng++){
	        	String Rowname1 = FlushLeft(20,"");
	            System.out.printf("|" + Rowname1);
	            String character = FlushLeft(40,Character[leng]);
	            System.out.printf("|"+character);
	            String filmname = FlushLeft(37,FilmName[leng]);
	            System.out.printf("|"+filmname + "|" );
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