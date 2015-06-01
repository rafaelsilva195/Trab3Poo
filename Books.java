package biblioteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Books implements IBooks{
	String name;
	int numOfEmp;
	boolean emprestado;
	String user;
	int cod;
	
	public Books(String name){
		this.name = name;
		this.numOfEmp = 0;
		this.emprestado = false;
		this.user = "none";
		
		
		String buffer;
    	BufferedReader br = null;
        try {
        	br = new BufferedReader(new FileReader("Users.csv"));
        	int i = 0;
            buffer = br.readLine();
            
            while(buffer != null){
            	i++;
            	buffer = br.readLine();
            }
            this.cod = i;
        } catch (IOException ioe) {
        	this.cod = 0;
            ioe.printStackTrace();
        } finally { // always close the file
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ioe2) {
                	
                }
            }
        }  
	}
	
	public String nameBook(){
		return name;
	}
	
	public int numOfEmp(){
		return numOfEmp;
	}
	
	public void setNameBook(String name){
		this.name = name;
	}
	
	public void setNumOfEmp(int num){
		this.numOfEmp = num;
	}
	
	public void setUser(String user){
		this.user = user;
		this.emprestado = true;
	}
	
	public String getUser(){
		return user;
	}
}
