
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
		System.out.println("---------"); //still not sure about this part
	}
	
	
	
	
	
}
