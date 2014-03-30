/*@entity type
BusinessPerson
*/
public class BusinessPerson extends Entity{
	private String[] LeadershipFrom;
	private String[] Leadershipto;
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
		for (int i=0;i< from.length;i++){
			LeadershipFrom[i] = from [i];
			Leadershipto[i] = to [i];
			LeadershipOrganization[i] = organization [i];
			LeadershipRole[i] = role [i];
			LeadershipTitle[i] = title [i];
		}
	}
	
	public void setBoardMember(String[] from,String[] to,String[] organization,String[] role,String[] title){
		for (int i=0;i< from.length;i++){
			BoardMemberFrom[i] = from [i];
			BoardMemberTo[i] = to [i];
			BoardMemberOrganization[i] = organization [i];
			BoardMemberRole[i] = role [i];
			BoardMemberTitle[i] = title [i];
		}
	}
	
	public void setFoundedOrganizationName (String[] name){
		for (int i=0;i< name.length;i++){
			FoundedOrganizationName[i] = name [i];
		}
	}
	
	public void print(){
		System.out.println("---------"); //still not sure about this part
	}
	
	
	
	
	
}