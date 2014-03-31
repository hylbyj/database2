
/*@entity type
Acthor
*/
public class Actor extends Entity{
	String [] FilmName;
	String [] Character;
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
		System.out.println("---------"); //still not sure about this part
	}
	
}
