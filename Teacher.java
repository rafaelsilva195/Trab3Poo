package biblioteca;

public class Teacher implements IUsers{
	
	String name;
	int type;
	boolean canEmp;
	Books[] book = new Books[6];
	int suspetionDays;
	
	public Teacher(String name){
		this.name = name;
		this.type = 3;
		book[0] = new Books("empyt");
		book[1] = new Books("empyt");
		book[2] = new Books("empyt");
		book[3] = new Books("empyt");
		book[4] = new Books("empyt");
		book[5] = new Books("empyt");
		this.suspetionDays = 0;
		this.canEmp = true;
	}
	
	public int getType(){
		return this.type;
	}
	
	
	public int suspetion(){
		for(int i = 0; i < 2; i++){
			if(suspetionDays < (book[i].numOfEmp()-60) && book[i].nameBook() != "empyt"){
				suspetionDays = (book[i].numOfEmp()-60);
				canEmp = false;					
			}
		}
		return suspetionDays;
	}
	
	public void setBook(String name){
		if(this.canEmp == false){
			System.out.println("Este usuário está suspenso!");
			return;
		}
		for(int i = 0; i < 6; i++){
			if(this.book[i].nameBook() == "empyt"){
				System.out.println("O livro " + name + " foi emprestado");
				this.book[i].setNameBook(name);
				this.book[i].setNumOfEmp(15);
				this.book[i].setUser(this.name);
				return;
			}
		}
		System.out.println("Este usuário não pode emprestar mais livros!");
		return;
	}
	
	public void getBook(){
		for(int i = 0; i < 6; i++){
			if(this.book[i].nameBook() != "empyt"){
				System.out.println("Nome do livro : "+ this.book[i].nameBook());
			}
		}
	}
}
