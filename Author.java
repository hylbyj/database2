
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
		Books = new String[books.length];
		for (int i=0;i< books.length;i++){
			Books[i] = books[i];
		}
	}

	public String getBooks(){
		String bookList = "";
		for(int i=0;i<Books.length;i++){
			if(i==Books.length-1){
				bookList=bookList+Books[i];
			}else{
				bookList=bookList+Books[i]+"\n";
			}
		}
		return bookList;
	}
	
	public void setBooksAbouttheAuthor(String[] aboutauthor){
		BooksAbouttheAuthor = new String[aboutauthor.length];
		for (int i=0;i< aboutauthor.length;i++){
			BooksAbouttheAuthor[i] = aboutauthor [i];
		}
	}
	
	public String getBooksAbouttheAuthor(){
		String bookList = "";
		for(int i=0;i<BooksAbouttheAuthor.length;i++){
			if(i==BooksAbouttheAuthor.length-1){
				bookList=bookList+Books[i];
			}else{
				bookList=bookList+Books[i]+"\n";
			}
		}
		return bookList;
	}
	
	public void setInfluenced(String[] influenced){
		Influenced = new String[influenced.length];
		for (int i=0;i< influenced.length;i++){
			Influenced[i] = influenced [i];
		}
	}
	
	public String getInfluenced(){
		String influencedList = "";
		for(int i=0;i<Influenced.length;i++){
			if(i==Influenced.length-1){
				influencedList=influencedList+Influenced[i];
			}else{
				influencedList=influencedList+Influenced[i]+"\n";
			}
		}
		return influencedList;
	}
	
	public void setInfluencedby(String[] influencedby){
		Influencedby = new String[influencedby.length];
		for (int i=0;i< influencedby.length;i++){
			Influencedby[i] = influencedby [i];
		}
	}
	
	public String getInfluencedby(){
		String influencedByList = "";
		for(int i=0;i<Influencedby.length;i++){
			if(i==Influencedby.length-1){
				influencedByList=influencedByList+Influencedby[i];
			}else{
				influencedByList=influencedByList+Influencedby[i]+"\n";
			}
		}
		return influencedByList;
	}
	
	public void print(){
		System.out.println("---------"); //still not sure about this part
	}
	
}
