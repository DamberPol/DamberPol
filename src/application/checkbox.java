package application;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class checkbox {
	static boolean ansver;
	public static boolean display() {
		Stage window = new Stage();

	
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Decyzja");
		window.setMinHeight(120);
		window.setMinWidth(120);

	

		
	
		HBox box= new HBox();
		Label separator = new Label("     ");
		Label separator1 = new Label("     ");
		Label separator2 = new Label("     ");
		Label separator3 = new Label("       ");
		Label separator4 = new Label("   \n ");

		VBox boxv = new VBox();

		
	
		Label passwordLabel= new Label("        Czy na pewno chcesz usun¹æ ?");

		

		
		Button loginButton=new Button("Tak");
		loginButton.setMinWidth(100);
		
		loginButton.setOnAction(e ->{
	
			ansver= true;
			window.close();

			                        } 
		);
		
		Button closeButton=new Button("Nie");
		closeButton.setMinWidth(100);
		closeButton.setOnAction(e ->{
			ansver= false;
			window.close();
		});
		
		
		
		
	
		box.getChildren().addAll(separator3, loginButton, separator, closeButton);
		boxv.getChildren().addAll(separator4, passwordLabel,separator1,separator2,  box );
	

	
	Scene scene= new Scene(boxv,270,120);
	scene.getStylesheets().add("application/Panel_logowania.css");
	window.setScene(scene);

		window.showAndWait();
		return ansver;
		
	}}
