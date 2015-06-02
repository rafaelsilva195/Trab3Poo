package biblioteca;

public class Student implements IUsers{
	String name;
	int type;
	int numBooks;
	
	public Student(String name){
		this.type = 7;
		this.name = name;
		this.numBooks = 4;
	}
	
	public int getType(){
		return this.type;
	}
	
	public void setNumBooks(int numBooks){
		this.numBooks = numBooks;
	}
}
