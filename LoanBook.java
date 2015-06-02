package biblioteca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LoanBook {
	
	public LoanBook(){	
	
	}
	
	public void reWriteBooks(Books book){
		BufferedReader br1 = null;
    	BufferedWriter bw1 = null;
    	String Wr = null;
    	int i;
    	
    	try {
    		br1 = new BufferedReader(new FileReader("Books.csv"));
    		bw1 = new BufferedWriter(new FileWriter("tmpBooks.csv", true));
    		
    		for(i = 0; i < book.getCod(); i++){
    			Wr = br1.readLine();
    			bw1.write(Wr);
    			bw1.newLine();
                bw1.flush();
			}
    		bw1.write(book.cod + "," + book.name + "," + book.emp);
    		Wr = br1.readLine();
    		if(Wr != null){
    			Wr = br1.readLine();
    		}
    		while(Wr != null){
    			Wr = br1.readLine();
    			bw1.write(Wr);
    			bw1.newLine();
                bw1.flush();
			}
    		
    		br1.close();
    		bw1.close();
    		
    		new File("Books.csv").delete();
    		new File("tmpBooks.csv").renameTo(new File("Books.csv"));
    		
    	}
	    catch (IOException ioe) {
	        ioe.printStackTrace();
	    } finally { // always close the file
	        if (br1 != null || bw1 != null) {
	            try {
	                br1.close();
	                bw1.close();
	            } catch (IOException ioe2) {
	            	
	            }
	        }
	    }
	}
	
	public void reWriteUsers(Student st, int lineOfUser){
		BufferedReader br1 = null;
    	BufferedWriter bw1 = null;
    	String Wr = null;
    	int i;
    	
    	try {
    		br1 = new BufferedReader(new FileReader("User.csv"));
    		bw1 = new BufferedWriter(new FileWriter("tmpUser.csv", true));
    		
    		for(i = 0; i < lineOfUser; i++){
    			Wr = br1.readLine();
    			bw1.write(Wr);
    			bw1.newLine();
                bw1.flush();
			}
    		bw1.write(st.type + "," + st.name + "," + st.numBooks);
    		Wr = br1.readLine();
    		if(Wr != null){
    			Wr = br1.readLine();
    		}
    		while(Wr != null){
    			Wr = br1.readLine();
    			bw1.write(Wr);
    			bw1.newLine();
                bw1.flush();
			}
    		
    		br1.close();
    		bw1.close();
    		
    		new File("User.csv").delete();
    		new File("tmpUser.csv").renameTo(new File("User.csv"));
    		
    	}
	    catch (IOException ioe) {
	        ioe.printStackTrace();
	    } finally { // always close the file
	        if (br1 != null || bw1 != null) {
	            try {
	                br1.close();
	                bw1.close();
	            } catch (IOException ioe2) {
	            	
	            }
	        }
	    }
	}
	
	public void reWriteUsers(Comunity cm, int lineOfUser){
		BufferedReader br1 = null;
    	BufferedWriter bw1 = null;
    	String Wr = null;
    	int i;
    	
    	try {
    		br1 = new BufferedReader(new FileReader("User.csv"));
    		bw1 = new BufferedWriter(new FileWriter("tmpUser.csv", true));
    		
    		for(i = 0; i < lineOfUser; i++){
    			Wr = br1.readLine();
    			bw1.write(Wr);
    			bw1.newLine();
                bw1.flush();
			}
    		bw1.write(cm.type + "," + cm.name + "," + cm.numBooks);
    		Wr = br1.readLine();
    		if(Wr != null){
    			Wr = br1.readLine();
    		}
    		while(Wr != null){
    			Wr = br1.readLine();
    			bw1.write(Wr);
    			bw1.newLine();
                bw1.flush();
			}
    		
    		br1.close();
    		bw1.close();
    		
    		new File("User.csv").delete();
    		new File("tmpUser.csv").renameTo(new File("User.csv"));
    		
    	}
	    catch (IOException ioe) {
	        ioe.printStackTrace();
	    } finally { // always close the file
	        if (br1 != null || bw1 != null) {
	            try {
	                br1.close();
	                bw1.close();
	            } catch (IOException ioe2) {
	            	
	            }
	        }
	    }
	}
	
	public void reWriteUsers(Teacher tc, int lineOfUser){
		BufferedReader br1 = null;
    	BufferedWriter bw1 = null;
    	String Wr = null;
    	int i;
    	
    	try {
    		br1 = new BufferedReader(new FileReader("User.csv"));
    		bw1 = new BufferedWriter(new FileWriter("tmpUser.csv", true));
    		
    		for(i = 0; i < lineOfUser; i++){
    			Wr = br1.readLine();
    			bw1.write(Wr);
    			bw1.newLine();
                bw1.flush();
			}
    		bw1.write(tc.type + "," + tc.name + "," + tc.numBooks);
    		Wr = br1.readLine();
    		if(Wr != null){
    			Wr = br1.readLine();
    		}
    		while(Wr != null){
    			Wr = br1.readLine();
    			bw1.write(Wr);
    			bw1.newLine();
                bw1.flush();
			}
    		
    		br1.close();
    		bw1.close();
    		
    		new File("User.csv").delete();
    		new File("tmpUser.csv").renameTo(new File("User.csv"));
    		
    	}
	    catch (IOException ioe) {
	        ioe.printStackTrace();
	    } finally { // always close the file
	        if (br1 != null || bw1 != null) {
	            try {
	                br1.close();
	                bw1.close();
	            } catch (IOException ioe2) {
	            	
	            }
	        }
	    }
	}
	
	
	public void setNewLoan(int lineOfBook, int lineOfUser, String compUser, String compBook){
		int i = 0;
		String Book = null;
		String User = null;
		String auxUser = null;
		String auxUser2 = null;
		Books book = new Books(compBook);
		BufferedReader br1 = null;
    	BufferedReader br2 = null;
    	BufferedWriter br3 = null; 
    	try {
        	br1 = new BufferedReader(new FileReader("Books.csv"));
        	br2 = new BufferedReader(new FileReader("Users.csv"));
        	br3 = new BufferedWriter(new FileWriter("BooksOnLoan.csv", true));
			for(i = 0; i < lineOfBook; i++){
				Book = br1.readLine();
			}
			int begin = Book.indexOf(",");
			int end = Book.lastIndexOf(",");
			Book = Book.substring(begin+1, end);
			lineOfBook--;
			if(Book.equals("1")){
				book.setCod(lineOfBook);
				book.setEmp(0);
			}
			
			for(i = 0; i < lineOfUser; i++){
				User = br2.readLine();
			}
			begin = User.lastIndexOf(",");
			end = User.indexOf(",");
			auxUser = User.substring(0, end);
			auxUser2 = User.substring(begin+1, User.length());
			int numBooks = Integer.parseInt(auxUser2); 
			int typeUser = Integer.parseInt(auxUser);
			if(typeUser == 9 && numBooks > 0 && book.getEmp()){
				System.out.println("Entrou comunity");
				Comunity cm = new Comunity(compUser);
				numBooks--;
				cm.setNumBooks(numBooks);
				br3.write(book.cod + "," + cm.name);
				reWriteBooks(book);
				reWriteUsers(cm, lineOfUser);
			}
			else if(typeUser == 7 && numBooks > 0 && book.getEmp()){
				System.out.println("Entrou comunity");
				Student st = new Student(compUser);
				numBooks--;		
				st.setNumBooks(numBooks);
				br3.write(book.cod + "," + st.name);
				reWriteBooks(book);
				reWriteUsers(st, lineOfUser);
			}
			else if(typeUser == 8 && numBooks > 0 && book.getEmp()){
				System.out.println("Entrou comunity");
				Teacher tc = new Teacher(compUser);
				numBooks--;
				tc.setNumBooks(numBooks);
				br3.write(book.cod + "," + tc.name);
				reWriteBooks(book);
				reWriteUsers(tc, lineOfUser);
			}
	    }
	    catch (IOException ioe) {
	        ioe.printStackTrace();
	    } finally { // always close the file
	        if (br1 != null || br2 != null || br3 != null) {
	            try {
	                br1.close();
	                br2.close();
	                br3.close();
	            } catch (IOException ioe2) {
	            	
	            }
	        }
	    }
	}
	
	public void meetBookToLoan(String compBook, String compUser){
		String auxBufferBook;
    	String auxBufferUser;
    	int lineOfBook = 0;
    	int lineOfUser = 0;
    	BufferedReader br1 = null;
    	BufferedReader br2 = null; 
    	try {
        	br1 = new BufferedReader(new FileReader("Books.csv"));
        	br2 = new BufferedReader(new FileReader("Users.csv"));
        	auxBufferBook = br1.readLine();
            auxBufferUser = br2.readLine();
            while(auxBufferBook != null){
            	lineOfBook++;
            	int begin = auxBufferBook.indexOf(",");
            	int end = auxBufferBook.lastIndexOf(",");
            	auxBufferBook = auxBufferBook.substring(begin+1, end);
            	auxBufferBook = auxBufferBook.toUpperCase();
            	compBook = compBook.toUpperCase();
            	if(auxBufferBook.equals(compBook)){
                	while(auxBufferUser != null){
                		lineOfUser++;
                		int begin2 = auxBufferUser.indexOf(",");
                		int end2 = auxBufferUser.lastIndexOf(",");
                        auxBufferUser = auxBufferUser.substring(begin2+1, end2);
                        auxBufferUser = auxBufferUser.toUpperCase();
                    	compUser = compUser.toUpperCase();
                        if(auxBufferUser.equals(compUser)){
                        	setNewLoan(lineOfBook, lineOfUser, compUser, compBook);
                        	while(auxBufferUser != null){
                        		auxBufferUser = br2.readLine();
                        	}
                        	while(auxBufferBook != null){
                        		auxBufferBook = br1.readLine();
                        	}
                        	auxBufferUser = null;
                        	auxBufferBook = null;
                        }
                        if(auxBufferUser != null){
                        	auxBufferUser = br2.readLine();
                        }
                	}
                }
            	if(auxBufferBook != null){
            		auxBufferBook = br1.readLine();
                }
            	
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally { // always close the file
            if (br1 != null || br2 != null) {
                try {
                    br1.close();
                    br2.close();
                } catch (IOException ioe2) {
                	
                }
            }
        }
    	return;
	}
}
