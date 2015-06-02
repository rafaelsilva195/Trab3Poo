package biblioteca;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class biblioteca extends Application{


	public biblioteca() {
	}

	public void start(Stage primaryStageL) {
		
		Stage primaryStageP = new Stage();
		Stage primaryStageProc = new Stage();
		Stage primaryStageEmp = new Stage();
		Stage primaryStageMenu = new Stage();
		
		
		
		//*********************************************************************************************
        //************************************    Menu   **********************************************
        //*********************************************************************************************
		
		VBox vbMenu = new VBox();
		HBox hbMenu1 = new HBox();
		HBox hbMenu2 = new HBox();
		HBox hbMenu3 = new HBox();
		HBox hbMenu4 = new HBox();
		HBox hbMenu5 = new HBox();
		
		Button bttMenu1 = new Button("Procurar");
		Button bttMenu2 = new Button("Cadastro de Pessoas");
		Button bttMenu3 = new Button("Cadastro de Livros");
		Button bttMenu4 = new Button("Empréstimo");
		Button bttMenu5 = new Button("Fechar");
		hbMenu1.getChildren().addAll(bttMenu1);
		hbMenu1.setSpacing(10);
		hbMenu2.getChildren().addAll(bttMenu2);
		hbMenu2.setSpacing(10);
		hbMenu3.getChildren().addAll(bttMenu3);
		hbMenu3.setSpacing(10);
		hbMenu4.getChildren().addAll(bttMenu4);
		hbMenu4.setSpacing(10);
		hbMenu5.getChildren().addAll(bttMenu5);
		hbMenu5.setSpacing(10);
		vbMenu.getChildren().addAll(hbMenu1, hbMenu2, hbMenu3, hbMenu4, hbMenu5);
		vbMenu.setSpacing(10);
		
		bttMenu1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	primaryStageProc.show();
            	primaryStageMenu.close();
            	
            }
		});
		
		bttMenu2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	primaryStageP.show();
            	primaryStageMenu.close();
            	
            }
		});
		
		bttMenu3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	
            	primaryStageL.show();
            	primaryStageMenu.close();
            	
            }
		});
		
		bttMenu4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	
            	primaryStageEmp.show();
            	primaryStageMenu.close();
            }
		});
		
		bttMenu5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	primaryStageMenu.close();
            }
		});
		
		
		StackPane rootMenu = new StackPane();
		rootMenu.getChildren().add(vbMenu);
        Scene sceneMenu = new Scene(rootMenu, 0, 0);  
        primaryStageMenu.setTitle("Procura");
        primaryStageMenu.setScene(sceneMenu);
        primaryStageMenu.show();
		
		//*********************************************************************************************
        //*********************************    Procura   **********************************************
        //*********************************************************************************************
		ListView<String> lvProc1 = new ListView<> ();
		VBox vbProc1 = new VBox();
		HBox hbProc1 = new HBox();
		HBox hbProc2 = new HBox();
		HBox hbProc3 = new HBox();
		HBox hbProc4 = new HBox();
		Button bttProc = new Button("Procurar");
		Button bttProcVoltar = new Button("Voltar");
		final ToggleGroup tgProc = new ToggleGroup();
		RadioButton rbB = new RadioButton("Livros");
		rbB.setSelected(true);
		RadioButton rbU = new RadioButton("Usuários");
		RadioButton rbL = new RadioButton("Empréstimos");
		
		tgProc.getToggles().addAll(rbB, rbU, rbL);
		hbProc1.getChildren().addAll(rbB, rbU, rbL);
		hbProc1.setSpacing(10);
		hbProc2.getChildren().addAll(bttProc);
		hbProc2.setSpacing(10);
		hbProc3.getChildren().addAll(lvProc1);
		hbProc3.setSpacing(10);
		hbProc4.getChildren().addAll(bttProcVoltar);
		hbProc4.setSpacing(10);
		vbProc1.getChildren().addAll(hbProc1, hbProc2, hbProc3, hbProc4);
		vbProc1.setSpacing(10);
		
		bttProc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	
            	if(rbB.isSelected()){
            		String buffer;
                	BufferedReader br = null;
                    try {
                    	List<String> list = new ArrayList<String>();
                    	br = new BufferedReader(new FileReader("Books.csv"));
                        buffer = br.readLine();
                        
                        while(buffer != null){
                        	buffer = buffer.replaceAll(","," ");
                        	buffer = buffer.toUpperCase();
                        	list.add(buffer);
                        	buffer = br.readLine();
                        }
                        ObservableList<String> ol1 = FXCollections.observableList(list);
    					lvProc1.setItems(ol1);
                    } catch (IOException ioe) {
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
            	else if(rbU.isSelected()){
            		String buffer;
                	BufferedReader br = null;
                    try {
                    	List<String> list = new ArrayList<String>();
                    	br = new BufferedReader(new FileReader("Users.csv"));
                        buffer = br.readLine();
                        
                        while(buffer != null){
                        	buffer = buffer.replaceAll(","," ");
                        	buffer = buffer.replaceAll("1","");
                        	buffer = buffer.replaceAll("2","");
                        	buffer = buffer.replaceAll("3","");
                        	buffer = buffer.replaceAll("4","");
                        	buffer = buffer.replaceAll("5","");
                        	buffer = buffer.replaceAll("6","");
                        	buffer = buffer.replaceAll("7","Student:");
                        	buffer = buffer.replaceAll("8","Teacher:");
                        	buffer = buffer.replaceAll("9","Comunity:");
                        	buffer = buffer.toUpperCase();
                        	list.add(buffer);
                        	buffer = br.readLine();
                        }
                        ObservableList<String> ol1 = FXCollections.observableList(list);
    					lvProc1.setItems(ol1);
                    } catch (IOException ioe) {
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
            	else if(rbL.isSelected()){
            		String buffer;
                	BufferedReader br = null;
                    try {
                    	List<String> list = new ArrayList<String>();
                    	br = new BufferedReader(new FileReader("BooksOnLoan.csv"));
                        buffer = br.readLine();
                        
                        while(buffer != null){
                        	buffer = buffer.replaceAll(","," ");
                        	buffer = buffer.toUpperCase();
                        	list.add(buffer);
                        	buffer = br.readLine();
                        }
                        ObservableList<String> ol1 = FXCollections.observableList(list);
    					lvProc1.setItems(ol1);
                    } catch (IOException ioe) {
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
            	   
            }
		});
		
		bttProcVoltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	primaryStageProc.close();
            	primaryStageMenu.show();
            }
		});
		
		
		
		StackPane rootProc1 = new StackPane();
        rootProc1.getChildren().add(vbProc1);
        Scene sceneProc = new Scene(rootProc1, 0, 0);  
        primaryStageProc.setTitle("Procura");
        primaryStageProc.setScene(sceneProc);
		
		
        
        //*********************************************************************************************
        //*********************************    Cadastro  de pessoas   *********************************
        //*********************************************************************************************
        
        
		Label labelP1 = new Label("Name:");
		TextField tfP1 = new TextField ();
		Label labelP2 = new Label("Tipo:");
		Label labelFinal = new Label();
		VBox vbP1 = new VBox();
		HBox hbP1 = new HBox();
		HBox hbP2 = new HBox();
		HBox hbP3 = new HBox();
		HBox hbP4 = new HBox();
		HBox hbP5 = new HBox();
		
		Button bttPVoltar = new Button("Voltar");
		
		Button bttP = new Button("Cadastrar");
		final ToggleGroup tgP = new ToggleGroup();
		RadioButton rbA = new RadioButton("Aluno");
		rbA.setSelected(true);
		RadioButton rbP = new RadioButton("Professor");
		RadioButton rbC = new RadioButton("Comunidade");
		tgP.getToggles().addAll(rbA, rbP, rbC);	

		hbP1.getChildren().addAll(labelP1, tfP1);
		hbP1.setSpacing(10);
		hbP2.getChildren().addAll(labelP2, rbA, rbP, rbC);
		hbP2.setSpacing(10);
		hbP3.getChildren().addAll(bttP);
		hbP3.setSpacing(10);
		hbP4.getChildren().addAll(labelFinal);
		hbP4.setSpacing(10);
		hbP5.getChildren().addAll(bttPVoltar);
		hbP5.setSpacing(10);
		vbP1.getChildren().addAll(hbP1, hbP2, hbP3, hbP4, hbP5);
		vbP1.setSpacing(10);
		
		bttP.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if(rbA.isSelected()){
            		Student aluno = new Student(tfP1.getText());
            		labelFinal.setText("O usuário " + aluno.name + " foi adicionado!");
            		
            		BufferedWriter bw = null;
                    try {
                        bw = new BufferedWriter(new FileWriter("Users.csv", true));
                        bw.write(aluno.type + "," + aluno.name + "," + aluno.numBooks);
                        bw.newLine();
                        bw.flush();
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    } finally { // always close the file
                        if (bw != null) {
                            try {
                                bw.close();
                            } catch (IOException ioe2) {
                            	
                            }
                        }
                    }             		
            	}	
            	else if(rbP.isSelected()){
            		Teacher professor = new Teacher(tfP1.getText());  
            		labelFinal.setText("O usuário " + professor.name + " foi adicionado!");
            		
            		BufferedWriter bw = null;
                    try {
                        bw = new BufferedWriter(new FileWriter("Users.csv", true));
                        bw.write(professor.type + "," + professor.name + "," + professor.numBooks);
                        bw.newLine();
                        bw.flush();
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    } finally { // always close the file
                        if (bw != null) {
                            try {
                                bw.close();
                            } catch (IOException ioe2) {
                            	
                            }
                        }
                    }             		
				}
            	else if(rbC.isSelected()){
            		Comunity comunidade = new Comunity(tfP1.getText());
            		labelFinal.setText("O usuário " + comunidade.name + " foi adicionado!");	
            		BufferedWriter bw = null;
                    try {
                        bw = new BufferedWriter(new FileWriter("Users.csv", true));
                        bw.write(comunidade.type + "," + comunidade.name + "," + comunidade.numBooks);
                        bw.newLine();
                        bw.flush();
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    } finally { // always close the file
                        if (bw != null) {
                            try {
                                bw.close();
                            } catch (IOException ioe2) {
                            	
                            }
                        }
                    }  
				}
            }
		});
		
		bttPVoltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	primaryStageP.close();
            	primaryStageMenu.show();
            }
		});
		
		
		
		StackPane rootP1 = new StackPane();
        rootP1.getChildren().add(vbP1);
        Scene sceneP = new Scene(rootP1, 0, 0);  
        primaryStageP.setTitle("Cadastro de Pessoas");
        primaryStageP.setScene(sceneP);
        
        
        //*********************************************************************************************
        //*********************************    Empréstimo  de livros   ********************************
        //*********************************************************************************************
        
        
        Label labelEmp1 = new Label("Nome do livro:");
		TextField tfEmp1 = new TextField ();
		Label labelEmp2 = new Label("Nome do usuário:");
		TextField tfEmp2 = new TextField ();
		VBox vbEmp1 = new VBox();
		HBox hbEmp1 = new HBox();
		HBox hbEmp2 = new HBox();
		HBox hbEmp3 = new HBox();
		HBox hbEmp4 = new HBox();
		
		Button bttEmp = new Button("Emprestar");
		Button bttEmpVoltar = new Button("Voltar");

		hbEmp1.getChildren().addAll(labelEmp1, tfEmp1);
		hbEmp1.setSpacing(10);
		hbEmp2.getChildren().addAll(labelEmp2, tfEmp2);
		hbEmp2.setSpacing(10);
		hbEmp3.getChildren().addAll(bttEmp);
		hbEmp3.setSpacing(10);
		hbEmp4.getChildren().addAll(bttEmpVoltar);
		hbEmp4.setSpacing(10);
		vbEmp1.getChildren().addAll(hbEmp1, hbEmp2, hbEmp3, hbEmp4);
		vbEmp1.setSpacing(10);
		
		bttEmp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	LoanBook lB1 = new LoanBook();
            	lB1.meetBookToLoan(tfEmp1.getText(), tfEmp2.getText());
            }
		});
		
		bttEmpVoltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	primaryStageEmp.close();
            	primaryStageMenu.show();
            }
		});
		
		
		StackPane rootEmp1 = new StackPane();
        rootEmp1.getChildren().add(vbEmp1);
        Scene sceneEmp = new Scene(rootEmp1, 0, 0);  
        primaryStageEmp.setTitle("Empréstimo de Livros");
        primaryStageEmp.setScene(sceneEmp);
		
		

        //*********************************************************************************************
        //*********************************    Cadastro  de livros   **********************************
        //*********************************************************************************************
        
		Label labelL1 = new Label("Nome do livro:");
		TextField textFieldL1 = new TextField ();
		Label labelL2 = new Label ();
		VBox vbL1 = new VBox();
		HBox hbL1 = new HBox();
		HBox hbL2 = new HBox();
		HBox hbL3 = new HBox();
		HBox hbL4 = new HBox();
		Button bttLVoltar = new Button("Voltar");
 		Button bttCadL = new Button("Cadastrar");
		hbL1.getChildren().addAll(labelL1, textFieldL1);
		hbL1.setSpacing(10);
		hbL2.getChildren().addAll(bttCadL);
		hbL2.setSpacing(10);	
		hbL3.getChildren().addAll(labelL2);
		hbL3.setSpacing(10);
		hbL4.getChildren().addAll(bttLVoltar);
		hbL4.setSpacing(10);
		vbL1.getChildren().addAll(hbL1, hbL2, hbL3, hbL4);
		vbL1.setSpacing(10);		
		
		
		bttCadL.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Books book = new Books(textFieldL1.getText());
            	BufferedWriter bw = null;
            	try {
            		labelL2.setText("O livro " + book.name + " foi adicionado!");
                    bw = new BufferedWriter(new FileWriter("Books.csv", true));
                    bw.write(book.cod + "," + book.name + "," + book.emp);
                    bw.newLine();
                    bw.flush();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                } finally { // always close the file
                    if (bw != null) {
                        try {
                            bw.close();
                        } catch (IOException ioe2) {
                        	
                        }
                    }
                } 
            }
		});
		
		
		bttLVoltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	primaryStageL.close();
            	primaryStageMenu.show();
            }
		});
		
		
		StackPane rootL1 = new StackPane();
        rootL1.getChildren().add(vbL1);
        Scene sceneL = new Scene(rootL1, 0, 0);  
        primaryStageL.setTitle("Cadastro de Livros");
        primaryStageL.setScene(sceneL);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
