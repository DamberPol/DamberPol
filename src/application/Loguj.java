package application;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.control.*;

import java.sql.Connection;

import javafx.geometry.*;

public class Loguj extends ConnectionToDB{
	static boolean ansver;

	public static boolean display() {
		Stage window = new Stage();

	//	String login = "user";
		//String has³o = "user";
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Zaloguj");
		window.setMinHeight(120);
		window.setMinWidth(120);
		BorderPane layout = new BorderPane();
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(12);
		HBox box = new HBox();
		Label separator = new Label("     ");
		// name
		Label nameLabel = new Label("Login");
		nameLabel.setFont(Font.loadFont("file:src/application/Lobster.otf", 21));
		GridPane.setConstraints(nameLabel, 0, 0);

		// name input
		TextField nameInput = new TextField("Login");
		GridPane.setConstraints(nameInput, 1, 0);

		// possword
		Label passwordLabel = new Label("Has³o");
		GridPane.setConstraints(passwordLabel, 0, 1);
		passwordLabel.setFont(Font.loadFont("file:src/application/Lobster.otf", 21));
		// password input
		TextField passwordInput = new TextField();
		passwordInput.setPromptText("Has³o");
		GridPane.setConstraints(passwordInput, 1, 1);

		Button loginButton = new Button("Zaloguj");
		loginButton.setMinWidth(100);
		loginButton.setFont(Font.loadFont("file:src/application/Lobster.otf", 15));

		loginButton.setOnAction(e -> {
			String user = nameInput.getText().toString().trim();
			ConnectionToDB connect = new ConnectionToDB();
			Connection connection = connect.getConnection(user);
			if(connection != null)
			{
				ansver = true;
				window.close();
			}
			else
			{
				//TODO Powiadomienie w labelu o niepoprawnym loginie/hasle
				ansver = false;
			}

		});

		Button closeButton = new Button("Zamknij");
		closeButton.setOnAction(e -> {
			ansver = false;
			window.close();
		});

		box.getChildren().addAll(separator, loginButton);
		GridPane.setConstraints(box, 1, 2);
		grid.getChildren().addAll(nameLabel, nameInput, passwordLabel, passwordInput, box);

		layout.setCenter(grid);
		Scene scene = new Scene(layout, 270, 120);
		scene.getStylesheets().add("application/Panel_logowania.css");
		window.setScene(scene);

		window.showAndWait();
		return ansver;

	}

}