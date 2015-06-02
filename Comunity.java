package biblioteca;

public class Comunity implements IUsers{
	
	String name;
	int type;
	int numBooks;
	
	public Comunity(String name){
		this.type = 9;
		this.name = name;
		this.numBooks = 2;
	}
	
	public int getType(){
		return this.type;
	}
	
	public void setNumBooks(int numBooks){
		this.numBooks = numBooks;
	}
}
