package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Logowanie {
	static boolean userAnswer;

	public static void display(Boolean wartosc) {
		Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Decyzja");
		window.setMinHeight(120);
		window.setMinWidth(120);

		HBox box = new HBox();
		Label separator = new Label("     ");
		Label separator1 = new Label("     ");
		Label separator2 = new Label("     ");
		Label separator3 = new Label("       ");
		Label separator4 = new Label("   \n ");

		VBox boxv = new VBox();
		Label passwordLabel;

		if (wartosc == true) {
			passwordLabel = new Label("        Logowanie poprawne");
		} else {
			passwordLabel = new Label("        Niepoprawny login/has³o");
		}
		Button loginButton = new Button("ok");
		loginButton.setMinWidth(100);
		passwordLabel.setFont(Font.loadFont("file:src/application/Lobster.otf", 20));

		loginButton.setOnAction(e -> {

			window.close();

		});

		box.getChildren().addAll(loginButton);
		boxv.getChildren().addAll(separator4, passwordLabel, separator1, separator2, box);

		Scene scene = new Scene(boxv, 270, 120);
		scene.getStylesheets().add("application/Panel_logowania.css");
		window.setScene(scene);

		window.showAndWait();

	}
}
