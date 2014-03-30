/*@entity type
Author
*/
public class Author extends Entity{
	private String[] Books;
	private String[] BooksAbouttheAuthor;
	private String[] Influenced;
	private String[] Influencedby;
	
	public Author(String mid){
		super(mid);
	}
	//set the propoerties from json
	
	public void setBooks(String[] books){
		for (int i=0;i< books.length;i++){
			Books[i] = books [i];
		}
	}
	
	public void setBooksAbouttheAuthor(String[] aboutauthor){
		for (int i=0;i< aboutauthor.length;i++){
			BooksAbouttheAuthor[i] = aboutauthor [i];
		}
	}
	
	public void setInfluenced(String[] influenced){
		for (int i=0;i< influenced.length;i++){
			Influenced[i] = influenced [i];
		}
	}
	
	public void setInfluencedby(String[] influencedby){
		for (int i=0;i< influencedby.length;i++){
			Influencedby[i] = influencedby [i];
		}
	}
	
	public void print(){
		System.out.println("---------"); //still not sure about this part
	}
	
}