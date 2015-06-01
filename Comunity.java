package biblioteca;

public class Comunity implements IUsers{
	
	String name;
	int type;
	boolean canEmp;
	Books[] book = new Books[2];
	int suspetionDays;
	
	public Comunity(String name){
		this.name = name;
		this.type = 1;
		book[0] = new Books("empyt");
		book[1] = new Books("empyt");
		this.suspetionDays = 0;
		this.canEmp = true;
	}
	
	public int getType(){
		return this.type;
	}
	
	
	public int suspetion(){
		for(int i = 0; i < 2; i++){
			if(suspetionDays < (book[i].numOfEmp()-15) && book[i].nameBook() != "empyt"){
				suspetionDays = (book[i].numOfEmp()-15);
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
		for(int i = 0; i < 2; i++){
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
		for(int i = 0; i < 2; i++){
			if(this.book[i].nameBook() != "empyt"){
				System.out.println("Nome do livro : "+ this.book[i].nameBook());
			}
		}
		if((this.book[0].nameBook() == "empyt") && (this.book[1].nameBook() == "empyt")){
			System.out.println("Não foi emprestado livros para este usuário!!");
		}
	}
}
