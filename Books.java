package biblioteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Books implements IBooks{
	String name;
	int cod;
	int emp;
	
	public Books(String name){
		this.name = name;
		this.emp = 1;
		
		String bufferB;
    	BufferedReader brB = null;
        try {
        	brB = new BufferedReader(new FileReader("Books.csv"));
        	int i = 0;
        	
        	bufferB = brB.readLine();
            
            while(bufferB != null){
            	System.out.println(i);
            	i++;
            	bufferB = brB.readLine();
            }
            this.cod = i;
        } catch (IOException ioe) {
        	this.cod = 0;
            ioe.printStackTrace();
        } finally { // always close the file
            if (brB != null) {
                try {
                    brB.close();
                } catch (IOException ioe2) {
                	
                }
            }
        }  
	}
	
	public void setCod(int cod){
		this.cod = cod;
	}
	
	public int getCod(){
		return cod;
	}
	
	public String nameBook(){
		return name;
	}
	public void setEmp(int i){
		this.emp = i;
	}
	public boolean getEmp(){
		if(this.emp == 1){
			return true;
		}
		else{
			return false;
		}
	}
}
