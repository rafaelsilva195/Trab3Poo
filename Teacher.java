package biblioteca;

public class Teacher implements IUsers{
	
	String name;
	int type;
	int numBooks;
	
	public Teacher(String name){
		this.type = 8;
		this.name = name;
		this.numBooks = 6;
	}
	
	public int getType(){
		return this.type;
	}
	
	public void setNumBooks(int numBooks){
		this.numBooks = numBooks;
	}
}
