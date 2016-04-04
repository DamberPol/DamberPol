package application;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class Loguj {
	public static void display() {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("LOGUJ");
		window.setMinHeight(200);
		window.setMinWidth(200);
	
		GridPane grid= new GridPane(); 
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(12);
		VBox box= new VBox();
		
		//name
		Label nameLabel= new Label("Login");
		GridPane.setConstraints( nameLabel, 0, 0);
		
		//name input
		TextField nameInput= new TextField("Login");
		GridPane.setConstraints(nameInput, 1, 0);
		
		//possword
		Label passwordLabel= new Label("Has³o");
		GridPane.setConstraints( passwordLabel, 0, 1);
		
		//password input
		TextField passwordInput= new TextField();
		passwordInput.setPromptText("Has³o");
		GridPane.setConstraints( passwordInput, 1, 1);
	
		
		Button loginButton=new Button("Zaloguj");
		GridPane.setConstraints( loginButton, 1, 2);
		
		Button closeButton=new Button("Zamknij");
		closeButton.setOnAction(e -> window.close());
		GridPane.setConstraints( closeButton, 1, 3);
	
		
	grid.getChildren().addAll(nameLabel, nameInput, passwordLabel, passwordInput, loginButton,closeButton);

	Scene scene= new Scene(grid,300,150);
	scene.getStylesheets().add("application/Panel_logowania.css");
	window.setScene(scene);

		window.showAndWait();
		
	}

}