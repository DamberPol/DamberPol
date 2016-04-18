package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	
	Stage window;
	Scene scene, scene2,scene3,scene4,scene5,scene6, scene7, scene8;
	Button przyciskDoPaneluLogowania, przyciskDoOknaKlienta,wyszukajpolaczen;
	Label labelPowitalny, odstep, odstep1, odstep2, labelRozk³adJazdy, przyjazdlabel,odjazdLabel;
	BorderPane oknoPowitalne, layout2, bordePaneDlaOkna3, bordePaneDlaOkna4, bordePaneDlaOkna5, bordePaneDlaOkna6, bordePaneDlaOkna7,bordePaneDlaOkna8;
	VBox box, boxprzyjazd, boxodjazd;
	HBox hbox,hbox2,hbox3, hbox4, hbox5, hbox6;
	TilePane tilepanel1;
	Menu filemenu2,filemenu,editMenu;
	MenuItem newFile,paste;
	MenuBar menuBar, menuBar1, menuBar3, menuBar4, menuBar5, menuBar6;
	Boolean rezultat;
	TreeView<String> tree3, tree2, tree, tree4, tree5, tree6;
	TableView<Kierowcy> table;
	TableView<Przystanki> table2;
	TableView<Trasa> table3;
	TableView<Autokary> table4;
	TableView<Kursy> table5;
	TextField nameInput, idInput, nazwiskoInput, peselInput, dataInput, iDPrzystaniki, iDMiejscowsci, inputulica, idprzystaniki,	
	idkursyinput , idtrasyinput, dzentygodniainput, godzinainput, uwaginput, idAutokaruInput, modelInput, markaInput, rokProdukcjiInput,
	pojemnoscSilnikaInput,  spalanieInput, katAutokaruInput, iloscMiejsInput, numerRejestracyjny,IdKursInput, idAutaInput, idKierowcyInput,
	kursSygnaturaKursuInput, kursOpisInput, kursCzasOdjazduInput, kursCzasPrzyjazduInput;
	Button addbutton, deltebutton, addbutton2, deltebutton2, addbutton3, deltebutton3, addbutton4, deltebutton4, addbutton5, deltebutton5;
	Hyperlink link;
	
	public static void main(String[] args){
		
	launch(args);	
	}
	
	public void start(Stage primaryStage) throws Exception{
		
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////                                          Okno Powitalne                                                ////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		window= primaryStage;
	
		
		
		
		 //Hyperlink
		link = new Hyperlink();
		link.setText("Zaloguj");
		
		
		
		
		//Layout
		oknoPowitalne= new BorderPane();
		oknoPowitalne.setPadding(new Insets(20,20,20,20));

		
	
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


		link.setOnAction(e ->
				{ 
					rezultat=Loguj.display();
		
				if(rezultat==true){
					
					window.setScene(scene4);
					
					
				}
				});
//Vbox
		box.setAlignment(Pos.BASELINE_CENTER);
		box.getChildren().addAll(odstep,labelPowitalny,odstep2, przyciskDoOknaKlienta);


	
		BorderPane.setAlignment(link, Pos.TOP_RIGHT);
		
	//	BorderPane.setMargin(button, new Insets(12,12,12,12));
		
		oknoPowitalne.setTop(link);
		BorderPane.setAlignment(box, Pos.TOP_CENTER);
		oknoPowitalne.setCenter(box);
		
		
		scene = new Scene(oknoPowitalne,500,200);
		scene.getStylesheets().add("application/application.css");
		
		
		
		
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////                                          okno klienta                                                  ////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
		
		

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
		
		przyjazd.getItems().addAll("Miasto", "01:00", "02:00","03:00","03:00","05:00","06:00",
				"07:00","08:00","09:00","11:00","12:00","13:00","14:00","15:00","16:00",
				"17:00","18:00","19:00","20:00","21:00","22:00","23:00");
		
		przyjazd.setValue("Miasto");
	
		boxprzyjazd.getChildren().addAll(przyjazdlabel,przyjazd);
		
		
		wyszukajpolaczen = new Button("Wyszukaj");
	
		boxodjazd = new VBox();
		
		odjazdLabel = new Label("Odjazd");
		odjazdLabel.setStyle("-fx-text-fill:aliceblue; -fx-font-size: 15px; ");
	
		
		ChoiceBox<String> odjazd = new ChoiceBox<>();
		przyjazd.setStyle(" -fx-font-size: 12px;");
		
		odjazd.getItems().addAll("Miasto", "01:00", "02:00","03:00","03:00","05:00","06:00",
				"07:00","08:00","09:00","11:00","12:00","13:00","14:00","15:00","16:00",
				"17:00","18:00","19:00","20:00","21:00","22:00","23:00");
		
		odjazd.setValue("Miasto");
		boxodjazd.getChildren().addAll(odjazdLabel,odjazd);
		
		
		tilepanel1 .getChildren().addAll( boxprzyjazd, boxodjazd);
		
		layout2.setTop(labelRozk³adJazdy);
		layout2.setAlignment(labelRozk³adJazdy, Pos.TOP_CENTER);
		
		
		layout2.setCenter(tilepanel1);
		layout2.setAlignment(tilepanel1, Pos.TOP_CENTER);
		
		layout2.setBottom(wyszukajpolaczen);
		layout2.setAlignment(wyszukajpolaczen, Pos.TOP_CENTER);
		


		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////// 											 Baza Kierowcy                                                ////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		
		bordePaneDlaOkna3= new BorderPane();
		scene3 = new Scene(bordePaneDlaOkna3, 1250,500);
		scene3.getStylesheets().add("application/Panel_Dy¿urnego.css");
		
        filemenu2= new Menu("Plik");
		
		newFile= new MenuItem("nowy...");
		newFile.setOnAction(e -> System.out.println("cos"));
		filemenu2.getItems().add(newFile);
		filemenu2.getItems().add(new MenuItem("Nowy raport"));
		filemenu2.getItems().add(new SeparatorMenuItem());
		filemenu2.getItems().add(new MenuItem("Dodaj ..."));
		filemenu2.getItems().add(new SeparatorMenuItem());
		filemenu2.getItems().add(new MenuItem("Usuñ ..."));
		filemenu2.getItems().add(new SeparatorMenuItem());
		filemenu2.getItems().add(new MenuItem("Wyjœcie"));
		
		editMenu= new Menu("Edytuj");
		editMenu.getItems().add(new MenuItem("Kopiuj"));
		editMenu.getItems().add(new MenuItem("Wytnij"));
		paste= new MenuItem("Wklej.");
		paste.setOnAction(e -> System.out.println("cos"));
		editMenu.getItems().add(paste);
		
		menuBar= new MenuBar();
		menuBar.getMenus().addAll(filemenu2,editMenu);
		
		
		
TreeItem<String> treeitem, trasy, przystanki, kierowcy, miejscowosci, rejestr_przejazdow, kursy, autokary;

		
		treeitem = new TreeItem<>("Spis opcji");
		treeitem.setExpanded(true);

		
		trasy = makeBranch("Trasy", treeitem);
		przystanki = makeBranch("Przystanki", treeitem);
		kierowcy = makeBranch("Kierowcy", treeitem);
		autokary = makeBranch("Autokary", treeitem);
		kursy = makeBranch("Kursy", treeitem);
		miejscowosci = makeBranch("Miejscowoœci", treeitem);
		rejestr_przejazdow = makeBranch("Rejestr Przejazdów", treeitem);
	
		
		//Create Tree
		
		tree2= new TreeView<>(treeitem);
		tree2.setShowRoot(true);
		
		
		tree2.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue)-> {
		if(newValue !=null){
			String nazwa = newValue.getValue();
			wyborbazydanych(nazwa);
		}
		});
		

		TableColumn<Kierowcy, String> idColumn= new TableColumn<>("ID");
		idColumn.setMinWidth(200);
		idColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));

		TableColumn<Kierowcy, String> nameColumn= new TableColumn<>("Imie");
		nameColumn.setMinWidth(200);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		TableColumn<Kierowcy, String> nazwiskoColumn= new TableColumn<>("Nazwisko");
		nazwiskoColumn.setMinWidth(200);
		nazwiskoColumn.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
		
		
		TableColumn<Kierowcy, Double> peselColumn= new TableColumn<>("Pesel");
		peselColumn.setMinWidth(200);
		peselColumn.setCellValueFactory(new PropertyValueFactory<>("pesel"));
		
		TableColumn<Kierowcy, String> dataColumn= new TableColumn<>("Data");
		dataColumn.setMinWidth(200);
		dataColumn.setCellValueFactory(new PropertyValueFactory<>("datazatrudnienia"));
		
		
		idInput = new TextField();
		idInput.setPromptText("Id");
		idInput.setMinWidth(150);
		
	
		
		nameInput = new TextField();
		nameInput.setPromptText("Nazwisko");
		nameInput.setMinWidth(150);
		
		nazwiskoInput = new TextField();
		nazwiskoInput.setPromptText("Imie");
		nazwiskoInput.setMinWidth(150);
		
		peselInput = new TextField();
		peselInput.setPromptText("Pesel");
	
		
		dataInput = new TextField();
		dataInput.setPromptText("Data");
	
		
		addbutton= new Button("Add");
		addbutton.setOnAction(e -> addbuttonClicked());
		deltebutton = new Button("Delete");
		deltebutton.setOnAction(e -> deltebuttonClicked());
		
		
		hbox = new HBox();
		hbox.setPadding(new Insets(10, 10, 10, 10));
		hbox.setSpacing(10);
		hbox.getChildren().addAll(idInput,nameInput, nazwiskoInput, peselInput, dataInput, addbutton, deltebutton);
		
		
		table = new TableView<>();
		table.setItems(getProduct());
		table.getColumns().addAll(idColumn,nameColumn, nazwiskoColumn, peselColumn, dataColumn);
		
		
		VBox layout= new VBox();
		layout.getChildren().addAll(table, hbox);
		
		
		bordePaneDlaOkna3.setTop(menuBar);
		bordePaneDlaOkna3.setLeft(tree2);
		bordePaneDlaOkna3.setCenter(layout);
		
		
		
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////                                Okno bazy danych poczatkowe                                             ////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	

		bordePaneDlaOkna4= new BorderPane();
		scene4 = new Scene(bordePaneDlaOkna4, 1250,480);
		scene4.getStylesheets().add("application/Panel_Dy¿urnego.css");
        filemenu= new Menu("Plik");
		
		newFile= new MenuItem("nowy...");
		newFile.setOnAction(e -> System.out.println("cos"));
		filemenu.getItems().add(newFile);
		filemenu.getItems().add(new MenuItem("Nowy raport"));
		filemenu.getItems().add(new SeparatorMenuItem());
		filemenu.getItems().add(new MenuItem("Dodaj ..."));
		filemenu.getItems().add(new SeparatorMenuItem());
		filemenu.getItems().add(new MenuItem("Usuñ ..."));
		filemenu.getItems().add(new SeparatorMenuItem());
		filemenu.getItems().add(new MenuItem("Wyjœcie"));
		
		editMenu= new Menu("Edytuj");
		editMenu.getItems().add(new MenuItem("Kopiuj"));
		editMenu.getItems().add(new MenuItem("Wytnij"));
		paste= new MenuItem("Wklej.");
		paste.setOnAction(e -> System.out.println("cos"));
		editMenu.getItems().add(paste);
		
		menuBar1= new MenuBar();
		menuBar1.getMenus().addAll(filemenu,editMenu);
		
		
		
		tree2= new TreeView<>(treeitem);
		tree2.setShowRoot(true);
		
		
		tree2.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue)-> {
		if(newValue !=null){
			String nazwa = newValue.getValue();
			wyborbazydanych(nazwa);
		
		}
		});
		
	
		
		
		
		bordePaneDlaOkna4.setTop(menuBar1);
		bordePaneDlaOkna4.setLeft(tree2);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////									Okno bazy danych przestanki                                           ////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
		bordePaneDlaOkna5= new BorderPane();
		scene5 = new Scene(bordePaneDlaOkna5, 870,480);
		scene5.getStylesheets().add("application/Panel_Dy¿urnego.css");
		
		menuBar3= new MenuBar();
		menuBar3.getMenus().addAll(filemenu,editMenu);
		

		TableColumn<Przystanki, String> idPrzystaniki= new TableColumn<>("ID_Przystanki");
		idPrzystaniki.setMinWidth(200);
		idPrzystaniki.setCellValueFactory(new PropertyValueFactory<>("Id_Przystanki"));
		
		TableColumn<Przystanki, String> IdMiejscowsci= new TableColumn<>("ID_Miejscowosci");
		IdMiejscowsci.setMinWidth(200);
		IdMiejscowsci.setCellValueFactory(new PropertyValueFactory<>("Id_Miejscowosci"));
		
		TableColumn<Przystanki, Float> ulicacolumn= new TableColumn<>("Ulica");
		ulicacolumn.setMinWidth(200);
		ulicacolumn.setCellValueFactory(new PropertyValueFactory<>("ulica"));
		

		
		
		iDPrzystaniki = new TextField();
		iDPrzystaniki.setPromptText("Id");
		iDPrzystaniki.setMinWidth(150);
		
	
		
		iDMiejscowsci = new TextField();
		iDMiejscowsci.setPromptText("Nazwisko");
		iDMiejscowsci.setMinWidth(150);
		
		inputulica = new TextField();
		inputulica.setPromptText("Imie");
		inputulica.setMinWidth(150);
		

		
		addbutton2= new Button("Add");
		addbutton2.setOnAction(e -> addbutton2Clicked());
		deltebutton2 = new Button("Delete");
		deltebutton2.setOnAction(e -> deltebutton2Clicked());
		
		
		hbox2 = new HBox();
		hbox2.setPadding(new Insets(10, 10, 10, 10));
		hbox2.setSpacing(10);
		hbox2.getChildren().addAll(iDPrzystaniki, iDMiejscowsci, inputulica,  addbutton2, deltebutton2);
		
		
		table2 = new TableView<>();
		table2.getColumns().addAll( idPrzystaniki, IdMiejscowsci, ulicacolumn);
		table2.setItems(getProduct2());
		


		
		treeitem = new TreeItem<>("Spis opcji");
		treeitem.setExpanded(true);
		trasy = makeBranch("Trasy", treeitem);
		przystanki = makeBranch("Przystanki", treeitem);
	    kierowcy = makeBranch("Kierowcy", treeitem);
		autokary = makeBranch("Autokary", treeitem);
		kursy = makeBranch("Kursy", treeitem);
        miejscowosci = makeBranch("Miejscowoœci", treeitem);
		
		
		rejestr_przejazdow = makeBranch("Rejestr Przejazdów", treeitem);
	
		
		//Create Tree
		
		tree3= new TreeView<>(treeitem);
		tree3.setShowRoot(true);
		
		
		tree3.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue)-> {
		if(newValue !=null){
			String nazwa = newValue.getValue();
			wyborbazydanych(nazwa);
		
		}
		});
	
		
		//Create Tree

		
		
		
		
		VBox layout2= new VBox();
		layout2.getChildren().addAll(table2, hbox2);
		
		bordePaneDlaOkna5.setTop(menuBar3);
		bordePaneDlaOkna5.setLeft(tree3);
		bordePaneDlaOkna5.setCenter(layout2);
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////										Okno bazy danych trasy                                            ////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		bordePaneDlaOkna6= new BorderPane();
		scene6 = new Scene(bordePaneDlaOkna6, 1450,480);
		scene6.getStylesheets().add("application/Panel_Dy¿urnego.css");
		
		menuBar4= new MenuBar();
		menuBar4.getMenus().addAll(filemenu,editMenu);
		

		TableColumn<Trasa, String> idTrasy= new TableColumn<>("ID_Trasy");
		idTrasy.setMinWidth(200);
		idTrasy.setCellValueFactory(new PropertyValueFactory<>("Id_trasy"));
		
		TableColumn<Trasa, String> IdKursy= new TableColumn<>("ID_Kursy");
		IdKursy.setMinWidth(200);
		IdKursy.setCellValueFactory(new PropertyValueFactory<>("Id_Kursy"));
		
		TableColumn<Trasa, String> IdPrzystanki= new TableColumn<>("ID_Przystanki");
		IdPrzystanki.setMinWidth(200);
		IdPrzystanki.setCellValueFactory(new PropertyValueFactory<>("Id_Przystanki"));

		TableColumn<Trasa, String> dzientygcolumn = new TableColumn<>("Dzien Tygodnia");
		dzientygcolumn.setMinWidth(200);
		dzientygcolumn.setCellValueFactory(new PropertyValueFactory<>("Dzien Tygodnia"));
	
		TableColumn<Trasa, String> godzinacolumn = new TableColumn<>("Godzina");
		godzinacolumn.setMinWidth(200);
		godzinacolumn.setCellValueFactory(new PropertyValueFactory<>("Godzina"));
	
		TableColumn<Trasa, String> uwagicolumn = new TableColumn<>("Uwagi");
		uwagicolumn.setMinWidth(200);
		uwagicolumn.setCellValueFactory(new PropertyValueFactory<>("Uwagi"));
		
		

		
		idprzystaniki = new TextField();
		idprzystaniki.setPromptText("Id");
		idprzystaniki.setMinWidth(150);
		
		idkursyinput = new TextField();
		idkursyinput.setPromptText("Imie");
		idkursyinput.setMinWidth(150);
		
		idtrasyinput = new TextField();
		idtrasyinput.setPromptText("Imie");
		idtrasyinput.setMinWidth(150);

		dzentygodniainput = new TextField();
		dzentygodniainput.setPromptText("Imie");
		dzentygodniainput.setMinWidth(150);
		
		 godzinainput = new TextField();
		 godzinainput.setPromptText("Imie");
		 godzinainput.setMinWidth(150);
		
		 uwaginput = new TextField();
		 uwaginput.setPromptText("Imie");
		 uwaginput.setMinWidth(150);
		
		
		addbutton3= new Button("Add");
		addbutton3.setOnAction(e -> addbutton3Clicked());
		deltebutton3 = new Button("Delete");
		deltebutton3.setOnAction(e -> deltebutton3Clicked());
		
		
		hbox3 = new HBox();
		hbox3.setPadding(new Insets(10, 10, 10, 10));
		hbox3.setSpacing(10);
		hbox3.getChildren().addAll(idprzystaniki,idkursyinput , idtrasyinput, dzentygodniainput, godzinainput, uwaginput,  addbutton3, deltebutton3);
		
		
		table3 = new TableView<>();
		table3.getColumns().addAll(idTrasy, IdKursy, IdPrzystanki, dzientygcolumn, godzinacolumn, uwagicolumn);
		table3.setItems(getProduct3());
		


		
		treeitem = new TreeItem<>("Spis opcji");
		treeitem.setExpanded(true);
		trasy = makeBranch("Trasy", treeitem);
		przystanki = makeBranch("Przystanki", treeitem);
	    kierowcy = makeBranch("Kierowcy", treeitem);
		autokary = makeBranch("Autokary", treeitem);
		kursy = makeBranch("Kursy", treeitem);
        miejscowosci = makeBranch("Miejscowoœci", treeitem);
		
		
		rejestr_przejazdow = makeBranch("Rejestr Przejazdów", treeitem);
	
		
		//Create Tree
		
		tree4= new TreeView<>(treeitem);
		tree4.setShowRoot(true);
		
		
		tree4.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue)-> {
		if(newValue !=null){
			String nazwa = newValue.getValue();
			wyborbazydanych(nazwa);
		
		}
		});
		
		VBox layout3= new VBox();
		layout3.getChildren().addAll(table3, hbox3);
		
		bordePaneDlaOkna6.setTop(menuBar4);
		bordePaneDlaOkna6.setLeft(tree4);
		bordePaneDlaOkna6.setCenter(layout3);
		
	
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////									Okno bazy danych Autokary                                             ////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
		
		
		
		bordePaneDlaOkna7= new BorderPane();
		scene7 = new Scene(bordePaneDlaOkna7, 1600,480);
		scene7.getStylesheets().add("application/Panel_Dy¿urnego.css");
		
		menuBar5= new MenuBar();
		menuBar5.getMenus().addAll(filemenu,editMenu);
		

		TableColumn<Autokary, String> idAutokarucolumn= new TableColumn<>("ID_Autokaru");
		idAutokarucolumn.setMinWidth(125);
		idAutokarucolumn.setCellValueFactory(new PropertyValueFactory<>("Id_Autokary"));
		
		TableColumn<Autokary, String> Markacolumn= new TableColumn<>("Marka");
		Markacolumn.setMinWidth(125);
		Markacolumn.setCellValueFactory(new PropertyValueFactory<>("Marka"));
		
		TableColumn<Autokary, String> Modelcolumn= new TableColumn<>("Model");
		Modelcolumn.setMinWidth(125);
		Modelcolumn.setCellValueFactory(new PropertyValueFactory<>("Model"));
	
		TableColumn<Autokary, String> rokProdukcjicolumn = new TableColumn<>("Rok produkcji");
		rokProdukcjicolumn.setMinWidth(125);
		rokProdukcjicolumn.setCellValueFactory(new PropertyValueFactory<>("Rok produkcji"));
	
		TableColumn<Autokary, Double> pojemnoscSilnikacolumn = new TableColumn<>("Pojemnoœæ silnika");
		pojemnoscSilnikacolumn.setMinWidth(150);
		pojemnoscSilnikacolumn.setCellValueFactory(new PropertyValueFactory<>("Pojemnoœæ silnika"));
	
		TableColumn<Autokary, String> spalaniecolumn = new TableColumn<>("Spalanie");
		spalaniecolumn.setMinWidth(125);
		spalaniecolumn.setCellValueFactory(new PropertyValueFactory<>("Spalanie"));
		
		TableColumn<Autokary, String> KatAutokarucolumn = new TableColumn<>("Kat_Autokaru");
		KatAutokarucolumn.setMinWidth(125);
		KatAutokarucolumn.setCellValueFactory(new PropertyValueFactory<>("KAT_Autokaru"));
		
		TableColumn<Autokary, String> iloscMiejscColumn = new TableColumn<>("Ilosc Miejsc");
		iloscMiejscColumn.setMinWidth(125);
		iloscMiejscColumn.setCellValueFactory(new PropertyValueFactory<>("Ilosc Miejsc"));
		
		TableColumn<Autokary, String> nrRejstracjiColumn = new TableColumn<>("Numer Rejestracyjny");
		nrRejstracjiColumn.setMinWidth(150);
		nrRejstracjiColumn.setCellValueFactory(new PropertyValueFactory<>("Numer Rejestracyjny"));
		

		
		idAutokaruInput = new TextField();
		idAutokaruInput.setPromptText("Id");
		idAutokaruInput.setMinWidth(50);
		
		markaInput = new TextField();
		markaInput.setPromptText("Imie");
		markaInput.setMinWidth(50);
		
		modelInput = new TextField();
		modelInput.setPromptText("Imie");
		modelInput.setMinWidth(50);

		rokProdukcjiInput = new TextField();
		rokProdukcjiInput.setPromptText("Imie");
		rokProdukcjiInput.setMinWidth(50);
		
		pojemnoscSilnikaInput = new TextField();
		pojemnoscSilnikaInput.setPromptText("Imie");
		pojemnoscSilnikaInput.setMinWidth(50);
		
		 spalanieInput = new TextField();
		 spalanieInput.setPromptText("Imie");
		 spalanieInput.setMinWidth(50);
		 
		 katAutokaruInput = new TextField();
		 katAutokaruInput.setPromptText("Imie");
		 katAutokaruInput.setMinWidth(50);
		
		 iloscMiejsInput = new TextField();
		 iloscMiejsInput.setPromptText("Imie");
		 iloscMiejsInput.setMinWidth(50);
		 
		 numerRejestracyjny = new TextField();
		 numerRejestracyjny.setPromptText("Imie");
		 numerRejestracyjny.setMinWidth(50);
			
	
		 
		 
		addbutton4= new Button("Add");
		addbutton4.setOnAction(e -> addbutton4Clicked());
		addbutton4.setMinWidth(50);
		deltebutton4 = new Button("Delete");
		deltebutton4.setOnAction(e -> deltebutton4Clicked());
		deltebutton4.setMinWidth(70);
		
		hbox4 = new HBox();
		hbox4.setPadding(new Insets(10, 10, 10, 10));
		hbox4.setSpacing(10);
		hbox4.getChildren().addAll(idAutokaruInput, modelInput, markaInput, rokProdukcjiInput, pojemnoscSilnikaInput, spalanieInput, katAutokaruInput, iloscMiejsInput, numerRejestracyjny,  addbutton4, deltebutton4);
		
		
		table4 = new TableView<>();
		table4.getColumns().addAll(	idAutokarucolumn,  Markacolumn, Modelcolumn,rokProdukcjicolumn, pojemnoscSilnikacolumn,  spalaniecolumn, KatAutokarucolumn,  iloscMiejscColumn, nrRejstracjiColumn);
		table4.setItems(getProduct4());
		


		
		treeitem = new TreeItem<>("Spis opcji");
		treeitem.setExpanded(true);
		trasy = makeBranch("Trasy", treeitem);
		przystanki = makeBranch("Przystanki", treeitem);
	    kierowcy = makeBranch("Kierowcy", treeitem);
		autokary = makeBranch("Autokary", treeitem);
		kursy = makeBranch("Kursy", treeitem);
        miejscowosci = makeBranch("Miejscowoœci", treeitem);
		
		
		rejestr_przejazdow = makeBranch("Rejestr Przejazdów", treeitem);
	
		
		//Create Tree
		
		tree5 = new TreeView<>(treeitem);
		tree5.setShowRoot(true);
		
		
		tree5.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue)-> {
		if(newValue !=null){
			String nazwa = newValue.getValue();
			wyborbazydanych(nazwa);
		
		}
		});
		
		VBox layout4= new VBox();
		layout4.getChildren().addAll(table4, hbox4);
		
		bordePaneDlaOkna7.setTop(menuBar5);
		bordePaneDlaOkna7.setLeft(tree5);
		bordePaneDlaOkna7.setCenter(layout4);
		
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////									Okno bazy danych Kursy                                                ////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		
		
		
		bordePaneDlaOkna8= new BorderPane();
		scene8 = new Scene(bordePaneDlaOkna8, 1200,480);
		scene8.getStylesheets().add("application/Panel_Dy¿urnego.css");
		
		menuBar6= new MenuBar();
		menuBar6.getMenus().addAll(filemenu,editMenu);
		

		TableColumn<Kursy, String> columnIdKurs= new TableColumn<>("ID_Kurs");
		columnIdKurs.setMinWidth(125);
		columnIdKurs.setCellValueFactory(new PropertyValueFactory<>("Id_Kursy"));
		
		TableColumn<Kursy, String> columnIdAuta= new TableColumn<>("ID_Auta");
		columnIdAuta.setMinWidth(125);
		columnIdAuta.setCellValueFactory(new PropertyValueFactory<>("id_Auta"));
		
		TableColumn<Kursy, String> columnKierowcyInput= new TableColumn<>("ID_Kierowcy");
		columnKierowcyInput.setMinWidth(125);
		columnKierowcyInput.setCellValueFactory(new PropertyValueFactory<>("id_Kierowcy"));
	
		TableColumn<Kursy, String> columnSygnaturaKursu = new TableColumn<>("Sygnatury Kursu");
		columnSygnaturaKursu.setMinWidth(125);
		columnSygnaturaKursu.setCellValueFactory(new PropertyValueFactory<>("Sygnatury Kursu"));
	
		TableColumn<Kursy, String>  columnkursOpis= new TableColumn<>("Opis");
		 columnkursOpis.setMinWidth(150);
		 columnkursOpis.setCellValueFactory(new PropertyValueFactory<>("Opis"));
	
		TableColumn<Kursy, String> columnKursCzasOdjazd = new TableColumn<>("Czas Odjazdu");
		columnKursCzasOdjazd.setMinWidth(125);
		columnKursCzasOdjazd.setCellValueFactory(new PropertyValueFactory<>("Czas Odjazdu"));
		
		TableColumn<Kursy, String> columnKursCzasprzyjazdu = new TableColumn<>("Czas Przyjazdu");
		columnKursCzasprzyjazdu.setMinWidth(125);
		columnKursCzasprzyjazdu.setCellValueFactory(new PropertyValueFactory<>("Czas Przyjazdu"));
		
/*
		KUR_KEY, AUT_KEY, KIE_KEY, KUR_Sygnatura_Kursu, KUR_Opis, KUR_Czas_Odjazdu, KUR_Czas_Przyjazdu;
		columnIdKurs columnIdAuta, columnKierowcyInput, columnSygnaturaKursu, columnkursOpis, columnKursCzasOdjazd, columnKursCzasprzyjazdu
		IdKursInput, idAutaInput, idKierowcyInput, kursSygnaturaKursuInput, kursOpisInput, kursCzasOdjazduInput, kursCzasPrzyjazduInput
		
		*/
		IdKursInput = new TextField();
		IdKursInput.setPromptText("Id");
		idAutokaruInput.setMinWidth(50);
		
		idAutaInput = new TextField();
		idAutaInput.setPromptText("Imie");
		idAutaInput.setMinWidth(50);
		
		idKierowcyInput = new TextField();
		idKierowcyInput.setPromptText("Imie");
		idKierowcyInput.setMinWidth(50);

		kursSygnaturaKursuInput = new TextField();
		kursSygnaturaKursuInput.setPromptText("Imie");
		kursSygnaturaKursuInput.setMinWidth(50);
		
		kursOpisInput = new TextField();
		kursOpisInput.setPromptText("Imie");
		kursOpisInput.setMinWidth(150);
		
		kursCzasOdjazduInput = new TextField();
		kursCzasOdjazduInput.setPromptText("Imie");
		kursCzasOdjazduInput.setMinWidth(50);
		 
		kursCzasPrzyjazduInput = new TextField();
		kursCzasPrzyjazduInput.setPromptText("Imie");
		kursCzasPrzyjazduInput.setMinWidth(50);
		 
		addbutton5= new Button("Add");
		addbutton5.setOnAction(e -> addbutton5Clicked());
		addbutton5.setMinWidth(50);
		deltebutton5 = new Button("Delete");
		deltebutton5.setOnAction(e -> deltebutton5Clicked());
		deltebutton5.setMinWidth(70);
		
		hbox5 = new HBox();
		hbox5.setPadding(new Insets(10, 10, 10, 10));
		hbox5.setSpacing(10);
		hbox5.getChildren().addAll(IdKursInput, idAutaInput, idKierowcyInput, kursSygnaturaKursuInput, kursOpisInput, kursCzasOdjazduInput, kursCzasPrzyjazduInput,  addbutton5, deltebutton5);
		
		
		table5 = new TableView<>();
		table5.getColumns().addAll(	columnIdKurs, columnIdAuta, columnKierowcyInput, columnSygnaturaKursu, columnkursOpis, columnKursCzasOdjazd, columnKursCzasprzyjazdu);
		table5.setItems(getProduct5());
		


		
		treeitem = new TreeItem<>("Spis opcji");
		treeitem.setExpanded(true);
		trasy = makeBranch("Trasy", treeitem);
		przystanki = makeBranch("Przystanki", treeitem);
	    kierowcy = makeBranch("Kierowcy", treeitem);
		autokary = makeBranch("Autokary", treeitem);
		kursy = makeBranch("Kursy", treeitem);
        miejscowosci = makeBranch("Miejscowoœci", treeitem);
		
		
		rejestr_przejazdow = makeBranch("Rejestr Przejazdów", treeitem);
	
		
		//Create Tree
		
		tree6 = new TreeView<>(treeitem);
		tree6.setShowRoot(true);
		
		
		tree6.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue)-> {
		if(newValue !=null){
			String nazwa = newValue.getValue();
			wyborbazydanych(nazwa);
		
		}
		});
		
		VBox layout5= new VBox();
		layout5.getChildren().addAll(table5, hbox5);
		
		bordePaneDlaOkna8.setTop(menuBar6);
		bordePaneDlaOkna8.setLeft(tree6);
		bordePaneDlaOkna8.setCenter(layout5);
		
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////							Okno bazy danych Miejscowœci                                                  ////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
		
		
		
		
		
		
		window.setTitle("Damberpol");
		window.setScene(scene);
		window.show();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public TreeItem<String> makeBranch(String title, TreeItem<String> parent){
		TreeItem<String> item= new TreeItem<>(title);
		item.setExpanded(true);
		parent.getChildren().add(item);
		return item;
	}

	public void addbuttonClicked(){
		Kierowcy kierowca = new Kierowcy();
		kierowca.setId(Integer.parseInt(idInput.getText()));
		kierowca.setName(nameInput.getText());
		kierowca.setNazwisko(nameInput.getText());
		kierowca.setPesel(Integer.parseInt(peselInput.getText()));
		kierowca.setDatazatrudnienia(dataInput.getText());
		table.getItems().add(kierowca);
		idInput.clear();
		nameInput.clear();
		nazwiskoInput.clear();
		peselInput.clear();
		dataInput.clear();
		
		
	}
	
	public void addbutton2Clicked(){
		Przystanki przystanki = new Przystanki();
		przystanki.setPR_KEY(Integer.parseInt(iDPrzystaniki.getText()));
		przystanki.setMIE_KEY(Integer.parseInt(iDMiejscowsci.getText()));
		przystanki.setPR_Ulica(inputulica.getText());
		table2.getItems().add(przystanki);
		iDPrzystaniki.clear();
		iDMiejscowsci.clear();
		inputulica.clear();

		
		
	}
	public void addbutton3Clicked(){
		Trasa trasa = new Trasa();
		trasa.setTR_KEY(Integer.parseInt(idtrasyinput.getText()));
		trasa.setKUR_KEY(Integer.parseInt(idkursyinput.getText()));
		trasa.setPR_KEY(Integer.parseInt(idprzystaniki.getText()));
		trasa.setTR_Dzien_tyg(dzentygodniainput.getText());
		trasa.setTR_Godzina(godzinainput.getText());
		trasa.setTR_Uwagi(uwaginput.getText());
		table3.getItems().add(trasa);
		idtrasyinput.clear();
		idkursyinput.clear();
		idprzystaniki.clear();
		dzentygodniainput.clear();
		godzinainput.clear();
		uwaginput.clear();


		
	}

public void addbutton4Clicked(){
	Autokary autokary = new Autokary();
	
	autokary.setAUT_KEY(Integer.parseInt(idAutokaruInput.getText()));
	autokary.setAUT_Marka(modelInput.getText());
	autokary.setAUT_Model(markaInput.getText());
	autokary.setAUT_Rok_Prod(rokProdukcjiInput.getText());
	
	autokary.setAUT_Poj_silnik(Double.parseDouble(idkursyinput.getText()));
	autokary.setAUT_Spalamie_lkm(Integer.parseInt(pojemnoscSilnikaInput.getText()));
	autokary.setAUT_Kat_autokaru(dzentygodniainput.getText());
	autokary.setAUT_Ilosc_miejsc(Integer.parseInt(iloscMiejsInput.getText()));
	autokary.setAUT_Nr_rejestracji(numerRejestracyjny.getText());
	table4.getItems().add(autokary);
	
	idAutokaruInput.clear();
	modelInput.clear();
	markaInput.clear();
	rokProdukcjiInput.clear();
	pojemnoscSilnikaInput.clear();
	spalanieInput.clear();
	katAutokaruInput.clear();
	iloscMiejsInput.clear();
	numerRejestracyjny.clear();
	

/*
	 idAutokaruInput, modelInput, markaInput, rokProdukcjiInput,
		pojemnoscSilnikaInput,  spalanieInput, katAutokaruInput, iloscMiejsInput, numerRejestracyjny
	*/
}

public void addbutton5Clicked(){
	Kursy kursy = new Kursy();
	
	kursy.setKUR_KEY(Integer.parseInt(IdKursInput.getText()));
	kursy.setAUT_KEY(Integer.parseInt(idAutaInput.getText()));
	kursy.setKIE_KEY(Integer.parseInt(idKierowcyInput.getText()));
	
	kursy.setKUR_Sygnatura_Kursu(kursSygnaturaKursuInput.getText());
	kursy.setKUR_Opis(kursOpisInput.getText());
	kursy.setKUR_Czas_Odjazdu( kursCzasOdjazduInput.getText());
	kursy.setKUR_Czas_Przyjazdu(kursCzasPrzyjazduInput.getText());

	table5.getItems().add(kursy);
	
	IdKursInput.clear();
	idAutaInput.clear();
	idKierowcyInput.clear();
	kursSygnaturaKursuInput.clear();
	kursOpisInput.clear();
	kursCzasOdjazduInput.clear();
	kursCzasPrzyjazduInput.clear();

	/*
	KUR_KEY, AUT_KEY, KIE_KEY, KUR_Sygnatura_Kursu, KUR_Opis, KUR_Czas_Odjazdu, KUR_Czas_Przyjazdu;
	columnIdKurs columnIdAuta, columnKierowcyInput, columnSygnaturaKursu, columnkursOpis, columnKursCzasOdjazd, columnKursCzasprzyjazdu
	IdKursInput, idAutaInput, idKierowcyInput, kursSygnaturaKursuInput, kursOpisInput, kursCzasOdjazduInput, kursCzasPrzyjazduInput
	*/
}
	
	public void deltebuttonClicked(){
		ObservableList<Kierowcy> productSelected, allProducts;
		allProducts= table.getItems();
		productSelected= table.getSelectionModel().getSelectedItems();
		
		productSelected.forEach(allProducts::remove);
		
	}
	
	public void deltebutton2Clicked(){
		ObservableList<Przystanki> productSelected, allProducts;
		allProducts= table2.getItems();
		productSelected= table2.getSelectionModel().getSelectedItems();
		
		productSelected.forEach(allProducts::remove);
		
	}
	public void deltebutton3Clicked(){
		ObservableList<Trasa> productSelected, allProducts;
		allProducts= table3.getItems();
		productSelected= table3.getSelectionModel().getSelectedItems();
		
		productSelected.forEach(allProducts::remove);
		
	}
	
	public void deltebutton4Clicked(){
		ObservableList<Autokary> productSelected, allProducts;
		allProducts= table4.getItems();
		productSelected= table4.getSelectionModel().getSelectedItems();
		
		productSelected.forEach(allProducts::remove);
		
	}
	
	public void deltebutton5Clicked(){
		ObservableList<Kursy> productSelected, allProducts;
		allProducts= table5.getItems();
		productSelected= table5.getSelectionModel().getSelectedItems();
		
		productSelected.forEach(allProducts::remove);
		
	}
	
	public void wyborbazydanych(String wartosc){
		
		switch(wartosc){
		case "Kierowcy":
			window.setScene(scene3);
			break;
			
		case "Przystanki":
		window.setScene(scene5);
		break;
		
			case "Trasy":
			window.setScene(scene6);
			break;
			
			case "Autokary":
				window.setScene(scene7);
				break;
			
			case "Kursy":
				window.setScene(scene8);
				break;
	}
		
	}
	
public ObservableList<Kierowcy> getProduct(){
	ObservableList<Kierowcy> products= FXCollections.observableArrayList();
	products.add(new Kierowcy(1, "Tomasz","Noga", 2132423432,"20.07.1992"));

	
	return products;
}

public ObservableList<Przystanki> getProduct2(){
	ObservableList<Przystanki> products= FXCollections.observableArrayList();
	products.add(new Przystanki(1,1,"wies"));

	
	return products;
}
public ObservableList<Trasa> getProduct3(){
	ObservableList<Trasa> products= FXCollections.observableArrayList();
	products.add(new Trasa(1,1,1,"wies", "dasd", "sda"));

	
	return products;
}

public ObservableList<Autokary> getProduct4(){
	ObservableList<Autokary> products= FXCollections.observableArrayList();
	products.add(new Autokary(1,"ss","sss","wies", 1.3 ,1, "sda",2,"sds"));
	
	return products;
}

public ObservableList<Kursy> getProduct5(){
	ObservableList<Kursy> products= FXCollections.observableArrayList();
	products.add(new Kursy(1,1,1,"wies", "sda","sasdf","sds"));
	
	return products;
}
	}
