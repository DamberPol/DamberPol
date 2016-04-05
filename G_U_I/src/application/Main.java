package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	
	Stage window;
	Scene scene, scene2,scene3;
	Button przyciskDoPaneluLogowania, przyciskDoOknaKlienta,wyszukajpolaczen;
	Label labelPowitalny, odstep, odstep1, odstep2, labelRozk³adJazdy, przyjazdlabel,odjazdLabel;
	BorderPane oknoPowitalne, layout2, bordePaneDlaOkna3;
	VBox box, boxprzyjazd, boxodjazd;
	HBox hbox;
	TilePane tilepanel1;
	Menu filemenu,editMenu;
	MenuItem newFile,paste;
	MenuBar menuBar;
	Boolean rezultat;
	TreeView<String> tree;
	TableView<Product> table;
	TextField nameInput,idInput, nazwiskoInput, peselInput, dataInput;
	Button addbutton, deltebutton;

	
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
		przyciskDoPaneluLogowania.setOnAction(e ->
				{ 
					rezultat=Loguj.display();
		
				if(rezultat==true){
					
					window.setScene(scene3);
					
					
				}
				});
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
		


		
		
		//layout 3
		
		
		bordePaneDlaOkna3= new BorderPane();
		scene3 = new Scene(bordePaneDlaOkna3, 1000,500);
		scene3.getStylesheets().add("application/Panel_Dy¿urnego.css");
		
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
		
		menuBar= new MenuBar();
		menuBar.getMenus().addAll(filemenu,editMenu);
		
		
		
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
		
		tree= new TreeView<>(treeitem);
		tree.setShowRoot(true);
		
		
		tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue)-> {
		if(newValue !=null)
			System.out.println(newValue.getValue());
		});
		

		TableColumn<Product, String> idColumn= new TableColumn<>("ID");
		idColumn.setMinWidth(100);
		idColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
		
		TableColumn<Product, String> nameColumn= new TableColumn<>("Imie");
		nameColumn.setMinWidth(100);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		TableColumn<Product, String> nazwiskoColumn= new TableColumn<>("Nazwisko");
		nazwiskoColumn.setMinWidth(100);
		nazwiskoColumn.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
		
		
		TableColumn<Product, Double> peselColumn= new TableColumn<>("Pesel");
		peselColumn.setMinWidth(100);
		peselColumn.setCellValueFactory(new PropertyValueFactory<>("pesel"));
		
		TableColumn<Product, String> dataColumn= new TableColumn<>("Data");
		dataColumn.setMinWidth(150);
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
	
		
		addbutton= new Button("+");
		addbutton.setOnAction(e -> addbuttonClicked());
		deltebutton = new Button("-");
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
		bordePaneDlaOkna3.setLeft(tree);
		bordePaneDlaOkna3.setCenter(layout);
		
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
		Product product = new Product();
		product.setId(Integer.parseInt(idInput.getText()));
		product.setName(nameInput.getText());
		product.setNazwisko(nameInput.getText());
		product.setPesel(Integer.parseInt(peselInput.getText()));
		product.setDatazatrudnienia(dataInput.getText());
		table.getItems().add(product);
		idInput.clear();
		nameInput.clear();
		nazwiskoInput.clear();
		peselInput.clear();
		dataInput.clear();
		
		
	}
	
	
	public void deltebuttonClicked(){
		ObservableList<Product> productSelected, allProducts;
		allProducts= table.getItems();
		productSelected= table.getSelectionModel().getSelectedItems();
		
		productSelected.forEach(allProducts::remove);
		
	}
	
	
public ObservableList<Product> getProduct(){
	ObservableList<Product> products= FXCollections.observableArrayList();
	products.add(new Product(1, "Tomasz","Noga", 2132423432,"20.07.1992"));

	
	return products;
}

	}
