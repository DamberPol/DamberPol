package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	
	Stage window;
	Scene scene, scene2;
	Button przyciskDoPaneluLogowania, przyciskDoOknaKlienta,wyszukajpolaczen;
	Label labelPowitalny, odstep, odstep1, odstep2, labelRozk³adJazdy, przyjazdlabel,odjazdLabel;
	BorderPane oknoPowitalne, layout2;
	VBox box, boxprzyjazd, boxodjazd;
	HBox hbox;
	TilePane tilepanel1;
	
	public static void main(String[] args){
		
	launch(args);	
	}
	
	public void start(Stage primaryStage) throws Exception{
		
		window= primaryStage;
	
		//Layout
		oknoPowitalne= new BorderPane();
		oknoPowitalne.setPadding(new Insets(20,20,20,20));

		
		przyciskDoPaneluLogowania= new Button("Zaloguj");
		//labelPowitalny =new Label("Witamy");
		labelPowitalny= new  Label("Witamy w programie firmy Damberpol \n");
		odstep= new  Label(" ");
		odstep1= new  Label(" ");
		odstep2= new  Label(" ");
		labelPowitalny.setStyle("-fx-text-fill:aliceblue");
		//button
		przyciskDoOknaKlienta = new Button("Rozk³ad Jazdy");
		przyciskDoOknaKlienta.setMaxWidth(100);
		przyciskDoOknaKlienta.setMaxHeight(40);
		przyciskDoOknaKlienta.setOnAction(e -> window.setScene(scene2));
		box = new VBox();
		

	

		window.setTitle("Damberpol");

		przyciskDoPaneluLogowania.setMaxWidth(60);
		przyciskDoPaneluLogowania.setMaxHeight(40);
		przyciskDoPaneluLogowania.setOnAction(e -> Loguj.display());
//Vbox
		box.setAlignment(Pos.BASELINE_CENTER);
		box.getChildren().addAll(odstep,labelPowitalny,odstep2, przyciskDoOknaKlienta);


	
		BorderPane.setAlignment(przyciskDoPaneluLogowania, Pos.TOP_RIGHT);
		
	//	BorderPane.setMargin(button, new Insets(12,12,12,12));
		oknoPowitalne.setTop(przyciskDoPaneluLogowania);
		BorderPane.setAlignment(box, Pos.TOP_CENTER);
		oknoPowitalne.setCenter(box);
		
		
		scene = new Scene(oknoPowitalne,500,200);
		scene.getStylesheets().add("application/application.css");
		
		
// Layout2
		layout2= new BorderPane();
		layout2.setPadding(new Insets(20,20,20,20));
		scene2 = new Scene(layout2,800,600);
		scene2.getStylesheets().add("application/Rozk³ad_Jazdy.css");
		
		labelRozk³adJazdy =new Label("Rozk³ad Jazdy");
		labelRozk³adJazdy.setStyle("-fx-text-fill:aliceblue; -fx-font-size: 60px;");
	
		tilepanel1 = new TilePane();
		tilepanel1 .setAlignment(Pos.BASELINE_CENTER);
		tilepanel1.setHgap(160);
		 
		boxprzyjazd = new VBox();
		 
		przyjazdlabel = new Label("Przyjazd");
		przyjazdlabel.setStyle("-fx-text-fill:aliceblue; -fx-font-size: 15px; ");
		ChoiceBox<String> przyjazd = new ChoiceBox<>();
		
		przyjazd.getItems().addAll("00:00", "01:00", "02:00","03:00","03:00","05:00","06:00",
				"07:00","08:00","09:00","11:00","12:00","13:00","14:00","15:00","16:00",
				"17:00","18:00","19:00","20:00","21:00","22:00","23:00");
		
		przyjazd.setValue("00:00");
	
		boxprzyjazd.getChildren().addAll(przyjazdlabel,przyjazd);
		
		
		wyszukajpolaczen = new Button("Wyszukaj");
	
		boxodjazd = new VBox();
		
		odjazdLabel = new Label("Odjazd");
		odjazdLabel.setStyle("-fx-text-fill:aliceblue; -fx-font-size: 15px; ");
	
		
		ChoiceBox<String> odjazd = new ChoiceBox<>();
		przyjazd.setStyle(" -fx-font-size: 12px;");
		
		odjazd.getItems().addAll("00:00", "01:00", "02:00","03:00","03:00","05:00","06:00",
				"07:00","08:00","09:00","11:00","12:00","13:00","14:00","15:00","16:00",
				"17:00","18:00","19:00","20:00","21:00","22:00","23:00");
		
		odjazd.setValue("00:00");
		boxodjazd.getChildren().addAll(odjazdLabel,odjazd);
		
		

		
		
		
		tilepanel1 .getChildren().addAll( boxprzyjazd, boxodjazd);
		
		layout2.setTop(labelRozk³adJazdy);
		layout2.setAlignment(labelRozk³adJazdy, Pos.TOP_CENTER);
		
		
		layout2.setCenter(tilepanel1);
		layout2.setAlignment(tilepanel1, Pos.TOP_CENTER);
		
		layout2.setBottom(wyszukajpolaczen);
		layout2.setAlignment(wyszukajpolaczen, Pos.TOP_CENTER);
		
		window.setTitle("Damberpol");
		window.setScene(scene);
		window.show();
		
	}
	
	}
