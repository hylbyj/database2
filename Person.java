package dbproj2;

/*@entity type
 Person
 */
public class Person extends Entity {
	private String Name;
	private String Birthday;
	private String Place_of_Birth;
	private String Death_Place;
	private String Death_Date;
	private String Death_Cause;//not sure about if place, date, cause included in the death
	private String Siblings;
	private String Spouses;
	private String Description;
	
	public Person(String mid){
		super(mid);
	}
    
	public String Death(){
		String date = this.Death_Date;
		String place = this.Death_Place;
		String cause = this.Death_Cause;
		return date+" at "+ place + ", cause: ("+ cause +")";
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
	
	public void setSiblings(String siblings){
		Siblings = siblings;
	}
	
	public String getSiblings(){
		return Siblings;
	}
	
	public void setSpouses(String spouses){
		Spouses = spouses;
	}
	
	public String getSpouses(){
		return Spouses;
	}
	
	public void setDescription(String description){
		Description = description;
	}
	
	public String getDescription(){
		return Description;
	}
	public void print(){
		System.out.println("---------"); //still not sure about this part
	}
	
}
