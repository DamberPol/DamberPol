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
	Scene scene, scene2,scene3,scene4,scene5,scene6;
	Button przyciskDoPaneluLogowania, przyciskDoOknaKlienta,wyszukajpolaczen;
	Label labelPowitalny, odstep, odstep1, odstep2, labelRozk³adJazdy, przyjazdlabel,odjazdLabel;
	BorderPane oknoPowitalne, layout2, bordePaneDlaOkna3, bordePaneDlaOkna4, bordePaneDlaOkna5, bordePaneDlaOkna6;
	VBox box, boxprzyjazd, boxodjazd;
	HBox hbox,hbox2,hbox3;
	TilePane tilepanel1;
	Menu filemenu2,filemenu,editMenu;
	MenuItem newFile,paste;
	MenuBar menuBar, menuBar1, menuBar3, menuBar4;
	Boolean rezultat;
	TreeView<String> tree3, tree2, tree, tree4;
	TableView<Kierowcy> table;
	TableView<Przystanki> table2;
	TableView<Trasa> table3;
	TextField nameInput,idInput, nazwiskoInput, peselInput, dataInput, iDPrzystaniki, iDMiejscowsci, inputulica, idprzystaniki,	
	idkursyinput , idtrasyinput, dzentygodniainput, godzinainput, uwaginput ;
	Button addbutton, deltebutton, addbutton2, deltebutton2, addbutton3, deltebutton3;
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
		scene4 = new Scene(bordePaneDlaOkna4, 1250,500);
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
		scene5 = new Scene(bordePaneDlaOkna5, 870,500);
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
		scene6 = new Scene(bordePaneDlaOkna6, 1450,500);
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
		deltebutton2.setOnAction(e -> deltebutton3Clicked());
		
		
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
		Przystanki przystanki = new Przystanki();
		przystanki.setPR_KEY(Integer.parseInt(iDPrzystaniki.getText()));
		przystanki.setMIE_KEY(Integer.parseInt(iDMiejscowsci.getText()));
		przystanki.setPR_Ulica(inputulica.getText());
		table2.getItems().add(przystanki);
		iDPrzystaniki.clear();
		iDMiejscowsci.clear();
		inputulica.clear();

		
		
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
		ObservableList<Przystanki> productSelected, allProducts;
		allProducts= table2.getItems();
		productSelected= table2.getSelectionModel().getSelectedItems();
		
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

	}
