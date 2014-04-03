import java.io.*;
import java.net.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;  
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;
public class test{
         public static void main(String[] args) throws IOException{
        	 String username = System.getProperty("user.name");	 
        	 //get the key of the program
        	 String apikey;
        	 if (args[0].equals( "-key")){
        		 apikey = args[1];
        		 Main main = new Main();
            	 part2 test1 = new part2();
            	 
            	 int length = args.length;
            	 //option 1
            	 
            	if (args[2].equals("-q")){
            		String query = args[3];
            		if (args [5].equals("infobox")){
            			main.main(query,apikey);
            		}
            		if (args [5].equals( "question")){
            			String compress = query.substring(12);
            			test1.main(compress,apikey);
            		}
            	}
            	 //option2
            	 if (args[2].equals( "-f")){
            	 BufferedReader reader = null;
            	 String fileName = args[3];
            	 try {
            		 //read queries from the file
            		 File file = new File(fileName);
                     reader = new BufferedReader(new FileReader( file ) );
                     
            		 String tempString = null;
                     //int line = 1;
                     //for infobox
                     if (args[5] .equals( "infobox")){
                    	 while ((tempString = reader.readLine()) != null) {
                        	main.main(tempString,apikey);
                    	 }
                     }
                     if (args[5] .equals( "question")){
                     while ((tempString = reader.readLine()) != null) {
                    	 
                    	String compress = tempString.substring(12);
                    	System.out.println ("Question: "+ tempString);
                    	System.out.println ();
             			test1.main(compress,apikey);
                        
                     }
                     }
                     reader.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 } finally {
                     if (reader != null) {
                         try {
                             reader.close();
                         } catch (IOException e1) {
                         }
                     }
                 }
            	 }
            	//option 3
            	 
            	
            	 
            	
            	if (args[2].equals("")){
            		System.out.println("Welcome to infoxbox creator using Freebase knowledge graph.");
            		System.out.println("Feel curious? Start exploring...");
            		test1.op3 = true;
            		while (true){
            			SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
                   	     System.out.println("["+df.format(new Date())+"] " + username + "@agyh_ibox" );
            			BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));  
            			String text = buffer.readLine();
            			int textleng = text.length();
            			//for question
            			System.out.println("let me see...");
            			if (text.startsWith("Who")){
            				String compress = text.substring(12,textleng-1);
                			test1.main(compress,apikey);
            				
            			}
            			//for infobox
            			else{
            				
            				main.main(text,apikey);
            			}
            			
            		}
            	}
            	
        	 } else {
        		 System.out.println("Wrong commmand please follow the format:");
        		 System.out.println("Option1:");
        		 System.out.println("./run.sh -key <Freebase API key> -q <query> -t <infobox|question>");
        		 System.out.println("Option2:");
        		 System.out.println("./run.sh -key <Freebase API key> -f <file of queries> -t <infobox|question>");
        		 System.out.println("Option3:");
        		 System.out.println("./run.sh -key <Freebase API key>");
        	 }
        	 //get the functions of infobox and question
        	 
        	//main.main("Bill Gates", "AIzaSyBP6o6P8UvrbNdMde0iWfe7h_XLaL7Z9kU");
        	
        	//test.main("Romeo and Juliet", "AIzaSyBP6o6P8UvrbNdMde0iWfe7h_XLaL7Z9kU");
         }
		
	

	
	
	
	
	
}