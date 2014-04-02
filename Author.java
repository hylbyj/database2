
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
			BooksAbouttheAuthor[i] = aboutauthor[i];
		}
	}
	
	public String getBooksAbouttheAuthor(){
		String bookList = "";
		for(int i=0;i<BooksAbouttheAuthor.length;i++){
			if(i==BooksAbouttheAuthor.length-1){
				bookList=bookList+BooksAbouttheAuthor[i];
			}else{
				bookList=bookList+BooksAbouttheAuthor[i]+"\n";
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
		//print books
		if (!(Books[0]== null)){
	        String Rowname0 = FlushLeft(20,"Books:");
	        System.out.printf("|" + Rowname0);
	        for (int leng = 0;leng< Books.length;leng++){
	        	String books = FlushLeft(78,Books[leng]);
	            System.out.printf(books+"|");
	            System.out.println();
	            String Rowname1 = FlushLeft(20,"");
	            System.out.printf("|" + Rowname1);
	        }
	        String space = FlushLeft(78,"");
	        System.out.printf(space + "|");
	        System.out.println();
	        System.out.println(" "+"--------------------------------------------------------------------------------------------------");
	        }
		//print booksabout
		if (!(BooksAbouttheAuthor[0]== null)){
	        String Rowname0 = FlushLeft(20,"Books About:");
	        System.out.printf("|" + Rowname0);
	        for (int leng = 0;leng< BooksAbouttheAuthor.length;leng++){
	        	String booksabout = FlushLeft(78,BooksAbouttheAuthor[leng]);
	            System.out.printf(booksabout+"|");
	            System.out.println();
	            String Rowname1 = FlushLeft(20,"");
	            System.out.printf("|" + Rowname1);
	        }
	        String space = FlushLeft(78,"");
	        System.out.printf(space + "|");
	        System.out.println();
	        System.out.println(" "+"--------------------------------------------------------------------------------------------------");
	        }
		//print influenced
		if (!(Influenced[0]== null)){
	        String Rowname0 = FlushLeft(20,"Influenced:");
	        System.out.printf("|" + Rowname0);
	        for (int leng = 0;leng< Influenced.length;leng++){
	        	String influenced = FlushLeft(78,Influenced[leng]);
	            System.out.printf(influenced+"|");
	            System.out.println();
	            String Rowname1 = FlushLeft(20,"");
	            System.out.printf("|" + Rowname1);
	        }
	        String space = FlushLeft(78,"");
	        System.out.printf(space + "|");
	        System.out.println();
	        System.out.println(" "+"--------------------------------------------------------------------------------------------------");
	        }
		//Influencedby
		//System.out.println("wtf is the influenced by" + Influencedby[0])  ;
		if (Influencedby[0] != ""){
	        String Rowname0 = FlushLeft(20,"Influenced by:");
	        System.out.printf("|" + Rowname0);
	        for (int leng = 0;leng< Influencedby.length;leng++){
	        	String influencedby = FlushLeft(78,Influencedby[leng]);
	            System.out.printf(influencedby+"|");
	            System.out.println();
	            String Rowname1 = FlushLeft(20,"");
	            System.out.printf("|" + Rowname1);
	        }
	        String space = FlushLeft(78,"");
	        System.out.printf(space + "|");
	        System.out.println();
	        System.out.println(" "+"--------------------------------------------------------------------------------------------------");
	        }
		
		
		//System.out.println("---------"); //still not sure about this part
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
