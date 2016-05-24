package application;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

	Stage window;
	Scene scenaOknoPowitalne, scenaRozkladJazdy, scene3, scenePanelDyzurnego, scene5, scene6, scene7, scene8, scene9, scene10;
	Button przyciskDoPaneluLogowania, przyciskDoOknaKlienta, btnWyszukajPolaczenia, btnCofnij;
	Label labelPowitalny, odstep, odstep1, odstep2, labelRozk³adJazdy, odjazdLabel, przyjazdLabel;
	BorderPane oknoPowitalne, layout2, bordePaneDlaOkna3, bordePaneDlaOkna4, bordePaneDlaOkna5, bordePaneDlaOkna6,
			bordePaneDlaOkna7, bordePaneDlaOkna8, bordePaneDlaOkna9, bordePaneDlaOkna10;
	VBox box, boxprzyjazd, boxodjazd;
	HBox hbox, hbox2, hbox3, hbox4, hbox5, hbox6, hbox7, hbox8, hboxklijent;
	TilePane tilepanel1;
	Menu filemenu2, filemenu;
	MenuItem newFile, paste;
	MenuBar menuBar, menuBar1, menuBar3, menuBar4, menuBar5, menuBar6, menuBar7, menuBar8;
	Boolean rezultat;
	TreeView<String> tree3, tree2, tree, tree4, tree5, tree6, tree7, tree8;
	TableView<Kierowcy> table;
	TableView<Przystanki> table2;
	TableView<Trasa> table3;
	TableView<Autokary> table4;
	TableView<Kursy> table5;
	TableView<Miejscowosci> table6;
	TableView<Rejestr_przejazdow> table7;
	TableView<RozkladJazdy> tableRozkladJazdy;
	TextField nameInput, nazwiskoInput, peselInput, dataInput, iDPrzystaniki, iDMiejscowsci, inputulica, trasaKursStart,
			trasaGodzinaPrzyjazdu, trasaKursKoniec, trasaMiejscowoscStartowa, trasaMiejscowoscKoncowa, trasaPrzystanek,
			trasaDzienTygodnia, trasaGodzinaOdjazdu, trasaUwagi, idAutokaruInput, modelInput, markaInput,
			rokProdukcjiInput, pojemnoscSilnikaInput, spalanieInput, katAutokaruInput, iloscMiejsInput,
			numerRejestracyjny, IdKursInput, idAutaInput, idKierowcyInput, kursSygnaturaKursuInput, kursOpisInput,
			kursMiejscStartowa, kursCzasOdjazduInput, kursCzasPrzyjazduInput, IdMiejscowosciInput,
			nazwaMiejscowosciInput, wojewodztwoInput, powiatInput, gminaInput, IdRejstrówPrzejazdówInput,
			reIdKursyInput, txtColRejestrDataStart, txtColRejestrPrzystanek, txtColRejestrDataKoniec,
			rejestrIloscOsobInput;
	Button addbutton, deltebutton, addbutton2, deltebutton2, trasaAddButton, trasaDeleteButton, addbutton4,
			deltebutton4, addbutton5, deltebutton5, addbutton6, deltebutton6, addbutton7, deltebutton7;
	Hyperlink linkZaloguj, doRozkladuJazdy, linkPowrot;

	Queries queries = new Queries();

	public ChoiceBox<String> choiceBoxPrzyjazd;
	public ChoiceBox<String> choiceBoxOdjazd;

	public static void main(String[] args) {

		launch(args);
	}

	@SuppressWarnings("unchecked")
	public void start(Stage primaryStage) throws Exception {

		FillingTables fillTable = new FillingTables();

		window = primaryStage;

		linkZaloguj = new Hyperlink();
		linkZaloguj.setText("Zaloguj");
		linkZaloguj.setFont(Font.loadFont("file:src/application/Lobster.otf", 20));

		doRozkladuJazdy = new Hyperlink();
		doRozkladuJazdy.setText("Do rozk³adu jazdy");
		doRozkladuJazdy.setOnAction(e -> window.setScene(scenaRozkladJazdy));
		doRozkladuJazdy.setFont(Font.loadFont("file:src/application/Lobster.otf", 20));

		oknoPowitalne = new BorderPane();
		oknoPowitalne.setPadding(new Insets(20, 20, 20, 20));

		labelPowitalny = new Label("Witamy w programie firmy Damberpol \n");
		labelPowitalny.setFont(Font.loadFont("file:src/application/Lobster.otf", 25));

		odstep = new Label(" ");
		odstep1 = new Label("                                                                  ");
		odstep2 = new Label(" ");
		Label odstep3 = new Label(" ");

		przyciskDoOknaKlienta = new Button("Rozk³ad Jazdy");
		przyciskDoOknaKlienta.setMaxWidth(100);
		przyciskDoOknaKlienta.setMaxHeight(40);
		przyciskDoOknaKlienta.setOnAction(e -> window.setScene(scenaRozkladJazdy));
		box = new VBox();

		window.setTitle("Damberpol");

		linkZaloguj.setOnAction(e -> {
			rezultat = Loguj.display();

			if (rezultat == true) {

				window.setScene(scenePanelDyzurnego);

			}
		});

		box.setAlignment(Pos.BASELINE_CENTER);
		box.getChildren().addAll(odstep, odstep1, labelPowitalny, odstep2, odstep3, doRozkladuJazdy);

		BorderPane.setAlignment(linkZaloguj, Pos.TOP_RIGHT);

		oknoPowitalne.setTop(linkZaloguj);
		BorderPane.setAlignment(box, Pos.TOP_CENTER);
		oknoPowitalne.setCenter(box);

		scenaOknoPowitalne = new Scene(oknoPowitalne, 500, 300);
		scenaOknoPowitalne.getStylesheets().add("application/application.css");

		layout2 = new BorderPane();
		layout2.setPadding(new Insets(20, 20, 20, 20));

		scenaRozkladJazdy = new Scene(layout2, 800, 600);
		scenaRozkladJazdy.getStylesheets().add("application/Rozk³ad_Jazdy.css");

		hboxklijent = new HBox();

		labelRozk³adJazdy = new Label("               Rozk³ad jazdy");
		labelRozk³adJazdy.setFont(Font.loadFont("file:src/application/Lobster.otf", 60));
		labelRozk³adJazdy.setStyle(" -fx-text-fill: #FFFFFF;");

		Label odstepp = new Label(" ");
		Label odstepp1 = new Label(" ");
		Label odstepp2 = new Label(" ");
		Label odstepp3 = new Label(" ");

		tilepanel1 = new TilePane();
		tilepanel1.setAlignment(Pos.BASELINE_CENTER);
		tilepanel1.setHgap(160);

		linkPowrot = new Hyperlink();
		linkPowrot.setText("Do okna poczatkowego");
		linkPowrot.setFont(Font.loadFont("file:src/application/Lobster.otf", 28));
		linkPowrot.setOnAction(e -> window.setScene(scenaOknoPowitalne));

		HBox boxOdjazd = new HBox();

		odjazdLabel = new Label("Odjazd");
		odjazdLabel.setFont(Font.loadFont("file:src/application/Lobster.otf", 19));
		odjazdLabel.setStyle("-fx-text-fill:#FFFFFF; ");

		btnWyszukajPolaczenia = new Button("Wyszukaj");
		btnCofnij = new Button("Cofnij");
		btnCofnij.setOnAction(e -> window.setScene(scenaOknoPowitalne));

		TableColumn<RozkladJazdy, String> rozkladKluczTrasy = new TableColumn<>("Klucz trasy");
		rozkladKluczTrasy.setMinWidth(100);
		rozkladKluczTrasy.setCellValueFactory(new PropertyValueFactory<>("TR_KEY"));

		TableColumn<RozkladJazdy, String> rozkladSygnaturaKursu = new TableColumn<>("Sygnatura kursu");
		rozkladSygnaturaKursu.setMinWidth(100);
		rozkladSygnaturaKursu.setCellValueFactory(new PropertyValueFactory<>("KUR_Sygnatura"));

		TableColumn<RozkladJazdy, String> rozkladSkad = new TableColumn<>("Skad");
		rozkladSkad.setMinWidth(200);
		rozkladSkad.setCellValueFactory(new PropertyValueFactory<>("TR_Skad"));

		TableColumn<RozkladJazdy, String> rozkladDokad = new TableColumn<>("Dokad");
		rozkladDokad.setMinWidth(150);
		rozkladDokad.setCellValueFactory(new PropertyValueFactory<>("TR_Dokad"));

		TableColumn<RozkladJazdy, String> rozkladPrzystanek = new TableColumn<>("Przystanek");
		rozkladPrzystanek.setMinWidth(150);
		rozkladPrzystanek.setCellValueFactory(new PropertyValueFactory<>("TR_Przystanek"));

		TableColumn<RozkladJazdy, String> rozkladWDni = new TableColumn<>("W dni");
		rozkladWDni.setMinWidth(150);
		rozkladWDni.setCellValueFactory(new PropertyValueFactory<>("TR_Dni_Tygodnia"));

		TableColumn<RozkladJazdy, String> rozkladGodzinaOdjazdu = new TableColumn<>("Godzina odjazdu");
		rozkladGodzinaOdjazdu.setMinWidth(150);
		rozkladGodzinaOdjazdu.setCellValueFactory(new PropertyValueFactory<>("TR_Godzina_Odjazdu"));

		TableColumn<RozkladJazdy, String> rozkladGodzinaPrzyjazdu = new TableColumn<>("Godzina przyjazdu");
		rozkladGodzinaPrzyjazdu.setMinWidth(150);
		rozkladGodzinaPrzyjazdu.setCellValueFactory(new PropertyValueFactory<>("TR_Godzina_Przyjazdu"));

		TableColumn<RozkladJazdy, String> rozkladUwagi = new TableColumn<>("Uwagi");
		rozkladUwagi.setMinWidth(150);
		rozkladUwagi.setCellValueFactory(new PropertyValueFactory<>("TR_Uwagi"));

		tableRozkladJazdy = new TableView<>();
		tableRozkladJazdy.getColumns().addAll(rozkladKluczTrasy, rozkladSygnaturaKursu, rozkladSkad, rozkladDokad,
				rozkladPrzystanek, rozkladWDni, rozkladGodzinaOdjazdu, rozkladGodzinaPrzyjazdu, rozkladUwagi);
		tableRozkladJazdy.setPlaceholder((new Label("Brak wybranego kursu")));

		hboxklijent.getChildren().addAll(linkPowrot);

		HBox boxPrzyjazd = new HBox();

		przyjazdLabel = new Label(" Przyjazd");
		przyjazdLabel.setFont(Font.loadFont("file:src/application/Lobster.otf", 19));
		przyjazdLabel.setStyle("-fx-text-fill:#FFFFFF;  ");

		choiceBoxPrzyjazd = new ChoiceBox<>();
		choiceBoxPrzyjazd.getItems().add("Przystanek");
		choiceBoxPrzyjazd.setValue("Przystanek");

		choiceBoxPrzyjazd.getSelectionModel().selectedItemProperty().addListener(
				(ObservableValue<? extends String> observable, String oldValue, String miejscowoscKoncowa) -> {
					fillTable.getProduct8(
							choiceBoxOdjazd.getSelectionModel().selectedItemProperty().getValue().toString(),
							miejscowoscKoncowa);
					tableRozkladJazdy.setItems(fillTable.getProduct8(
							choiceBoxOdjazd.getSelectionModel().selectedItemProperty().getValue().toString(),
							miejscowoscKoncowa));

				});

		choiceBoxOdjazd = new ChoiceBox<>();
		choiceBoxOdjazd.getItems().add("Przystanek");
		choiceBoxOdjazd.setValue("Przystanek");

		ResultSet rsListaMiejscowosci = queries.showAllTableMiejscowosci();
		while (rsListaMiejscowosci.next()) {
			String em = rsListaMiejscowosci.getString("MIE_Nazwa_Miejscow");
			String arr = em.replace("\n", ",");
			choiceBoxPrzyjazd.getItems().add(arr);
			choiceBoxOdjazd.getItems().add(arr);
		}

		boxOdjazd.getChildren().addAll(odjazdLabel, odstepp1, choiceBoxOdjazd);
		boxPrzyjazd.getChildren().addAll(przyjazdLabel, odstepp2, choiceBoxPrzyjazd);

		tilepanel1.getChildren().addAll(boxOdjazd, boxPrzyjazd);
		VBox centter = new VBox();

		centter.getChildren().addAll(tilepanel1, odstepp, tableRozkladJazdy);

		VBox boxxx = new VBox();
		boxxx.getChildren().addAll(labelRozk³adJazdy, odstepp3);

		layout2.setTop(boxxx);
		BorderPane.setAlignment(boxxx, Pos.TOP_CENTER);

		layout2.setCenter(centter);
		BorderPane.setAlignment(centter, Pos.TOP_CENTER);

		layout2.setBottom(hboxklijent);
		BorderPane.setAlignment(hboxklijent, Pos.TOP_RIGHT);

		////////////// Baza Kierowcy ////////////////

		bordePaneDlaOkna3 = new BorderPane();
		scene3 = new Scene(bordePaneDlaOkna3, 1250, 480);
		scene3.getStylesheets().add("application/Panel_Dy¿urnego.css");

		filemenu = new Menu("Plik");
		MenuItem trasymi = new MenuItem("Trasy");
		trasymi.setOnAction(e -> window.setScene(scene6));
		filemenu.getItems().add(trasymi);

		MenuItem przystankimi = new MenuItem("Przystanik");
		przystankimi.setOnAction(e -> window.setScene(scene5));
		filemenu.getItems().add(przystankimi);

		MenuItem kierowcymi = new MenuItem("Kierowcy");
		kierowcymi.setOnAction(e -> window.setScene(scene3));
		filemenu.getItems().add(kierowcymi);

		MenuItem autokarymi = new MenuItem("Autokary");
		autokarymi.setOnAction(e -> window.setScene(scene7));
		filemenu.getItems().add(autokarymi);

		MenuItem kursymi = new MenuItem("Kursy");
		kursymi.setOnAction(e -> window.setScene(scene8));
		filemenu.getItems().add(kursymi);

		MenuItem miejscowoscimi = new MenuItem("Miejscowoœci");
		miejscowoscimi.setOnAction(e -> window.setScene(scene9));
		filemenu.getItems().add(miejscowoscimi);

		MenuItem rejestrmi = new MenuItem("Rejestr przejazdów");
		rejestrmi.setOnAction(e -> window.setScene(scene10));
		filemenu.getItems().add(rejestrmi);

		filemenu.getItems().add(new SeparatorMenuItem());

		MenuItem wyloguj = new MenuItem("Wyloguj");
		wyloguj.setOnAction(e -> window.setScene(scenaOknoPowitalne));
		filemenu.getItems().add(wyloguj);

		filemenu.getItems().add(new SeparatorMenuItem());

		MenuItem wyjscie = new MenuItem("Wyjscie");
		wyjscie.setOnAction(e -> window.close());
		filemenu.getItems().add(wyjscie);

		menuBar = new MenuBar();
		menuBar.getMenus().addAll(filemenu);

		TreeItem<String> treeitem;

		treeitem = new TreeItem<>("Spis opcji");
		treeitem.setExpanded(true);

		makeBranch("Trasy", treeitem);
		makeBranch("Przystanki", treeitem);
		makeBranch("Kierowcy", treeitem);
		makeBranch("Autokary", treeitem);
		makeBranch("Kursy", treeitem);
		makeBranch("Miejscowoœci", treeitem);
		makeBranch("Rejestr Przejazdów", treeitem);

		tree2 = new TreeView<>(treeitem);
		tree2.setShowRoot(true);

		tree2.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
			if (newValue != null) {
				String nazwa = newValue.getValue();
				wyborbazydanych(nazwa);
			}
		});

		TableColumn<Kierowcy, String> idColumn = new TableColumn<>("ID");
		idColumn.setMinWidth(200);
		idColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));

		TableColumn<Kierowcy, String> nameColumn = new TableColumn<>("Imie");
		nameColumn.setMinWidth(200);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

		TableColumn<Kierowcy, String> nazwiskoColumn = new TableColumn<>("Nazwisko");
		nazwiskoColumn.setMinWidth(200);
		nazwiskoColumn.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));

		TableColumn<Kierowcy, Double> peselColumn = new TableColumn<>("Pesel");
		peselColumn.setMinWidth(200);
		peselColumn.setCellValueFactory(new PropertyValueFactory<>("pesel"));

		TableColumn<Kierowcy, String> dataColumn = new TableColumn<>("Data zatrudnienia");
		dataColumn.setMinWidth(200);
		dataColumn.setCellValueFactory(new PropertyValueFactory<>("datazatrudnienia"));

		nameInput = new TextField();
		nameInput.setPromptText("Imie");
		nameInput.setMinWidth(150);

		nazwiskoInput = new TextField();
		nazwiskoInput.setPromptText("Nazwisko");
		nazwiskoInput.setMinWidth(150);

		peselInput = new TextField();
		peselInput.setPromptText("Pesel");

		dataInput = new TextField();
		dataInput.setPromptText("Data");

		addbutton = new Button("Add");
		addbutton.setOnAction(e -> btnAddKierowcy());
		deltebutton = new Button("Delete");
		deltebutton.setOnAction(e -> {

			rezultat = checkbox.display();
			if (rezultat == true) {

				deltebuttonClicked();
			}
		});

		hbox = new HBox();
		hbox.setPadding(new Insets(10, 10, 10, 10));
		hbox.setSpacing(10);
		hbox.getChildren().addAll(nameInput, nazwiskoInput, peselInput, dataInput, addbutton, deltebutton);

		table = new TableView<>();
		table.setItems(fillTable.getProduct());
		table.getColumns().addAll(idColumn, nameColumn, nazwiskoColumn, peselColumn, dataColumn);

		VBox layout = new VBox();
		layout.getChildren().addAll(table, hbox);

		bordePaneDlaOkna3.setTop(menuBar);
		bordePaneDlaOkna3.setLeft(tree2);
		bordePaneDlaOkna3.setCenter(layout);


		bordePaneDlaOkna4 = new BorderPane();
		scenePanelDyzurnego = new Scene(bordePaneDlaOkna4, 1250, 480);
		scenePanelDyzurnego.getStylesheets().add("application/Panel_Dy¿urnego.css");

		menuBar1 = new MenuBar();
		menuBar1.getMenus().addAll(filemenu);

		tree2 = new TreeView<>(treeitem);
		tree2.setShowRoot(true);

		tree2.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
			if (newValue != null) {
				String nazwa = newValue.getValue();
				wyborbazydanych(nazwa);

			}
		});

		bordePaneDlaOkna4.setTop(menuBar1);
		bordePaneDlaOkna4.setLeft(tree2);
		////////////// Okno bazy danych przestanki ////////////////
		bordePaneDlaOkna5 = new BorderPane();
		scene5 = new Scene(bordePaneDlaOkna5, 870, 470);
		scene5.getStylesheets().add("application/Panel_Dy¿urnego.css");

		menuBar3 = new MenuBar();
		menuBar3.getMenus().addAll(filemenu);

		TableColumn<Przystanki, String> idPrzystaniki = new TableColumn<>("Klucz przystanku");
		idPrzystaniki.setMinWidth(200);
		idPrzystaniki.setCellValueFactory(new PropertyValueFactory<>("PR_KEY"));

		TableColumn<Przystanki, String> IdMiejscowsci = new TableColumn<>("Nazwa miejscowosci");
		IdMiejscowsci.setMinWidth(200);
		IdMiejscowsci.setCellValueFactory(new PropertyValueFactory<>("MIE_KEY"));

		TableColumn<Przystanki, Float> ulicacolumn = new TableColumn<>("Nazwa przystanku");
		ulicacolumn.setMinWidth(200);
		ulicacolumn.setCellValueFactory(new PropertyValueFactory<>("PR_Ulica"));

		iDMiejscowsci = new TextField();
		iDMiejscowsci.setPromptText("Nazwa miejscowoœci");
		iDMiejscowsci.setMinWidth(150);

		inputulica = new TextField();
		inputulica.setPromptText("Nazwa przystanku");
		inputulica.setMinWidth(150);

		addbutton2 = new Button("Add");
		addbutton2.setOnAction(e -> btnAddPrzystanki());
		deltebutton2 = new Button("Delete");
		deltebutton2.setOnAction(e -> {

			rezultat = checkbox.display();
			if (rezultat == true) {

				deltebutton2Clicked();
			}
		});

		hbox2 = new HBox();
		hbox2.setPadding(new Insets(10, 10, 10, 10));
		hbox2.setSpacing(10);
		hbox2.getChildren().addAll(iDMiejscowsci, inputulica, addbutton2, deltebutton2);

		table2 = new TableView<>();
		table2.getColumns().addAll(idPrzystaniki, IdMiejscowsci, ulicacolumn);
		table2.setItems(fillTable.getProduct2());

		treeitem = new TreeItem<>("Spis opcji");
		treeitem.setExpanded(true);
		makeBranch("Trasy", treeitem);
		makeBranch("Przystanki", treeitem);
		makeBranch("Kierowcy", treeitem);
		makeBranch("Autokary", treeitem);
		makeBranch("Kursy", treeitem);
		makeBranch("Miejscowoœci", treeitem);

		makeBranch("Rejestr Przejazdów", treeitem);

		tree3 = new TreeView<>(treeitem);
		tree3.setShowRoot(true);

		tree3.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
			if (newValue != null) {
				String nazwa = newValue.getValue();
				wyborbazydanych(nazwa);

			}
		});

		VBox layout2 = new VBox();
		layout2.getChildren().addAll(table2, hbox2);

		bordePaneDlaOkna5.setTop(menuBar3);
		bordePaneDlaOkna5.setLeft(tree3);
		bordePaneDlaOkna5.setCenter(layout2);

		////////////// Okno bazy danych trasy ////////////////

		bordePaneDlaOkna6 = new BorderPane();
		scene6 = new Scene(bordePaneDlaOkna6, 1450, 480);
		scene6.getStylesheets().add("application/Panel_Dy¿urnego.css");

		menuBar4 = new MenuBar();
		menuBar4.getMenus().addAll(filemenu);

		TableColumn<Trasa, String> idTrasy = new TableColumn<>("Klucz trasy");
		idTrasy.setMinWidth(40);
		idTrasy.setCellValueFactory(new PropertyValueFactory<>("TR_KEY"));

		TableColumn<Trasa, String> IdKursy = new TableColumn<>("Sygnatura kursu");
		IdKursy.setMinWidth(100);
		IdKursy.setCellValueFactory(new PropertyValueFactory<>("KUR_Sygnatura_Kursu"));

		TableColumn<Trasa, String> trasyMiejscStartowa = new TableColumn<>("Miejscowoœæ startowa");
		trasyMiejscStartowa.setMinWidth(100);
		trasyMiejscStartowa.setCellValueFactory(new PropertyValueFactory<>("TR_Skad"));

		TableColumn<Trasa, String> trasyMiejscKonco = new TableColumn<>("Miejscowosc koñcowa");
		trasyMiejscKonco.setMinWidth(100);
		trasyMiejscKonco.setCellValueFactory(new PropertyValueFactory<>("MIE_Nazwa_Miejscow"));

		TableColumn<Trasa, String> IdPrzystanki = new TableColumn<>("Przystanek");
		IdPrzystanki.setMinWidth(100);
		IdPrzystanki.setCellValueFactory(new PropertyValueFactory<>("PR_Ulica"));

		TableColumn<Trasa, String> godzinaOdjazducolumn = new TableColumn<>("Godzina odjazdu");
		godzinaOdjazducolumn.setMinWidth(100);
		godzinaOdjazducolumn.setCellValueFactory(new PropertyValueFactory<>("TR_Godzina"));

		TableColumn<Trasa, String> godzinacolumn = new TableColumn<>("Godzina przyjazdu");
		godzinacolumn.setMinWidth(100);
		godzinacolumn.setCellValueFactory(new PropertyValueFactory<>("TR_Dzien_tyg"));

		TableColumn<Trasa, String> dzientygcolumn = new TableColumn<>("Dzieñ tygodnia");
		dzientygcolumn.setMinWidth(100);
		dzientygcolumn.setCellValueFactory(new PropertyValueFactory<>("TR_Godzina_odjazdu"));

		TableColumn<Trasa, String> uwagicolumn = new TableColumn<>("Uwagi");
		uwagicolumn.setMinWidth(200);
		uwagicolumn.setCellValueFactory(new PropertyValueFactory<>("TR_Uwagi"));

		trasaKursStart = new TextField();
		trasaKursStart.setPromptText("Kurs start");
		trasaKursStart.setMinWidth(70);

		trasaKursKoniec = new TextField();
		trasaKursKoniec.setPromptText("Kurs koniec");
		trasaKursKoniec.setMinWidth(70);

		trasaMiejscowoscStartowa = new TextField();
		trasaMiejscowoscStartowa.setPromptText("Miejscowosc startowa");
		trasaMiejscowoscStartowa.setMinWidth(70);

		trasaMiejscowoscKoncowa = new TextField();
		trasaMiejscowoscKoncowa.setPromptText("Miejscowosc koñcowa");
		trasaMiejscowoscKoncowa.setMinWidth(70);

		trasaDzienTygodnia = new TextField();
		trasaDzienTygodnia.setPromptText("Dzieñ tygodnia");
		trasaDzienTygodnia.setMinWidth(40);

		trasaGodzinaOdjazdu = new TextField();
		trasaGodzinaOdjazdu.setPromptText("Godzina odjazdu");
		trasaGodzinaOdjazdu.setMinWidth(30);

		trasaGodzinaPrzyjazdu = new TextField();
		trasaGodzinaPrzyjazdu.setPromptText("Godzina przyjazdu");
		trasaGodzinaPrzyjazdu.setMinWidth(30);

		trasaUwagi = new TextField();
		trasaUwagi.setPromptText("Uwagi");
		trasaUwagi.setMinWidth(50);

		trasaAddButton = new Button("Add");
		trasaAddButton.setOnAction(e -> btnAddTrasy());
		trasaDeleteButton = new Button("Delete");
		trasaDeleteButton.setOnAction(e -> {

			rezultat = checkbox.display();
			if (rezultat == true) {

				deltebutton3Clicked();
			}
		});

		hbox3 = new HBox();
		hbox3.setPadding(new Insets(10, 10, 10, 10));
		hbox3.setSpacing(10);
		hbox3.getChildren().addAll(trasaKursStart, trasaKursKoniec, trasaMiejscowoscStartowa, trasaMiejscowoscKoncowa,
				trasaGodzinaOdjazdu, trasaGodzinaPrzyjazdu, trasaDzienTygodnia, trasaUwagi, trasaAddButton,
				trasaDeleteButton);
		// TODO
		table3 = new TableView<>();
		table3.getColumns().addAll(idTrasy, IdKursy, trasyMiejscStartowa, trasyMiejscKonco, IdPrzystanki,
				godzinaOdjazducolumn, godzinacolumn, dzientygcolumn, uwagicolumn);
		table3.setItems(fillTable.getProduct3());

		treeitem = new TreeItem<>("Spis opcji");
		treeitem.setExpanded(true);
		makeBranch("Trasy", treeitem);
		makeBranch("Przystanki", treeitem);
		makeBranch("Kierowcy", treeitem);
		makeBranch("Autokary", treeitem);
		makeBranch("Kursy", treeitem);
		makeBranch("Miejscowoœci", treeitem);

		makeBranch("Rejestr Przejazdów", treeitem);

		tree4 = new TreeView<>(treeitem);
		tree4.setShowRoot(true);

		tree4.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
			if (newValue != null) {
				String nazwa = newValue.getValue();
				wyborbazydanych(nazwa);

			}
		});

		VBox layout3 = new VBox();
		layout3.getChildren().addAll(table3, hbox3);

		bordePaneDlaOkna6.setTop(menuBar4);
		bordePaneDlaOkna6.setLeft(tree4);
		bordePaneDlaOkna6.setCenter(layout3);

		////////////// Okno bazy danych Autokary ////////////////

		bordePaneDlaOkna7 = new BorderPane();
		scene7 = new Scene(bordePaneDlaOkna7, 1600, 480);
		scene7.getStylesheets().add("application/Panel_Dy¿urnego.css");

		menuBar5 = new MenuBar();
		menuBar5.getMenus().addAll(filemenu);

		TableColumn<Autokary, String> idAutokarucolumn = new TableColumn<>("Numer Aut");
		idAutokarucolumn.setMinWidth(40);
		idAutokarucolumn.setCellValueFactory(new PropertyValueFactory<>("AUT_KEY"));

		TableColumn<Autokary, String> Markacolumn = new TableColumn<>("Marka");
		Markacolumn.setMinWidth(125);
		Markacolumn.setCellValueFactory(new PropertyValueFactory<>("AUT_Marka"));

		TableColumn<Autokary, String> Modelcolumn = new TableColumn<>("Model");
		Modelcolumn.setMinWidth(125);
		Modelcolumn.setCellValueFactory(new PropertyValueFactory<>("AUT_Model"));

		TableColumn<Autokary, String> rokProdukcjicolumn = new TableColumn<>("Rok produkcji");
		rokProdukcjicolumn.setMinWidth(60);
		rokProdukcjicolumn.setCellValueFactory(new PropertyValueFactory<>("AUT_Rok_Prod"));

		TableColumn<Autokary, Double> pojemnoscSilnikacolumn = new TableColumn<>("Pojemnoœæ silnika");
		pojemnoscSilnikacolumn.setMinWidth(60);
		pojemnoscSilnikacolumn.setCellValueFactory(new PropertyValueFactory<>("AUT_Poj_silnik"));

		TableColumn<Autokary, String> spalaniecolumn = new TableColumn<>("Spalanie");
		spalaniecolumn.setMinWidth(40);
		spalaniecolumn.setCellValueFactory(new PropertyValueFactory<>("AUT_Spalamie_lkm"));

		TableColumn<Autokary, String> KatAutokarucolumn = new TableColumn<>("Klasa Autokaru");
		KatAutokarucolumn.setMinWidth(125);
		KatAutokarucolumn.setCellValueFactory(new PropertyValueFactory<>("AUT_Kat_autokaru"));

		TableColumn<Autokary, String> iloscMiejscColumn = new TableColumn<>("Iloœæ Miejsc");
		iloscMiejscColumn.setMinWidth(40);
		iloscMiejscColumn.setCellValueFactory(new PropertyValueFactory<>("AUT_Ilosc_miejsc"));

		TableColumn<Autokary, String> nrRejstracjiColumn = new TableColumn<>("Numer Rejestracyjny");
		nrRejstracjiColumn.setMinWidth(150);
		nrRejstracjiColumn.setCellValueFactory(new PropertyValueFactory<>("AUT_Nr_rejestracji"));

		markaInput = new TextField();
		markaInput.setPromptText("Marka");
		markaInput.setMinWidth(125);

		modelInput = new TextField();
		modelInput.setPromptText("Model");
		modelInput.setMinWidth(125);

		rokProdukcjiInput = new TextField();
		rokProdukcjiInput.setPromptText("Rok produkcji");
		rokProdukcjiInput.setMinWidth(60);

		pojemnoscSilnikaInput = new TextField();
		pojemnoscSilnikaInput.setPromptText("Pojemnoœæ silnika");
		pojemnoscSilnikaInput.setMinWidth(60);

		spalanieInput = new TextField();
		spalanieInput.setPromptText("Spalanie");
		spalanieInput.setMinWidth(40);

		katAutokaruInput = new TextField();
		katAutokaruInput.setPromptText("Kategoria");
		katAutokaruInput.setMinWidth(100);

		iloscMiejsInput = new TextField();
		iloscMiejsInput.setPromptText("Iloœæ miejsc");
		iloscMiejsInput.setMinWidth(40);

		numerRejestracyjny = new TextField();
		numerRejestracyjny.setPromptText("Numer rejestracji");
		numerRejestracyjny.setMinWidth(150);

		addbutton4 = new Button("Add");
		addbutton4.setOnAction(e -> addbutton4Clicked());
		addbutton4.setMinWidth(50);
		deltebutton4 = new Button("Delete");
		deltebutton4.setOnAction(e -> {

			rezultat = checkbox.display();
			if (rezultat == true) {

				deltebutton4Clicked();
			}
		});

		deltebutton4.setMinWidth(70);

		hbox4 = new HBox();
		hbox4.setPadding(new Insets(10, 10, 10, 10));
		hbox4.setSpacing(10);
		hbox4.getChildren().addAll(markaInput, modelInput, rokProdukcjiInput, pojemnoscSilnikaInput, spalanieInput,
				katAutokaruInput, iloscMiejsInput, numerRejestracyjny, addbutton4, deltebutton4);

		table4 = new TableView<>();
		table4.getColumns().addAll(idAutokarucolumn, Markacolumn, Modelcolumn, rokProdukcjicolumn,
				pojemnoscSilnikacolumn, spalaniecolumn, KatAutokarucolumn, iloscMiejscColumn, nrRejstracjiColumn);
		table4.setItems(fillTable.getProduct4());

		treeitem = new TreeItem<>("Spis opcji");
		treeitem.setExpanded(true);
		makeBranch("Trasy", treeitem);
		makeBranch("Przystanki", treeitem);
		makeBranch("Kierowcy", treeitem);
		makeBranch("Autokary", treeitem);
		makeBranch("Kursy", treeitem);
		makeBranch("Miejscowoœci", treeitem);

		makeBranch("Rejestr Przejazdów", treeitem);

		tree5 = new TreeView<>(treeitem);
		tree5.setShowRoot(true);

		tree5.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
			if (newValue != null) {
				String nazwa = newValue.getValue();
				wyborbazydanych(nazwa);

			}
		});

		VBox layout4 = new VBox();
		layout4.getChildren().addAll(table4, hbox4);

		bordePaneDlaOkna7.setTop(menuBar5);
		bordePaneDlaOkna7.setLeft(tree5);
		bordePaneDlaOkna7.setCenter(layout4);

		////////////// Okno bazy danych Kursy ////////////////

		bordePaneDlaOkna8 = new BorderPane();
		scene8 = new Scene(bordePaneDlaOkna8, 1200, 480);
		scene8.getStylesheets().add("application/Panel_Dy¿urnego.css");

		menuBar6 = new MenuBar();
		menuBar6.getMenus().addAll(filemenu);

		TableColumn<Kursy, String> columnIdKurs = new TableColumn<>("ID_Kurs");
		columnIdKurs.setMinWidth(50);
		columnIdKurs.setCellValueFactory(new PropertyValueFactory<>("KUR_KEY"));

		TableColumn<Kursy, String> columnIdAuta = new TableColumn<>("Numer rej autokaru");
		columnIdAuta.setMinWidth(80);
		columnIdAuta.setCellValueFactory(new PropertyValueFactory<>("AUT_KEY"));

		TableColumn<Kursy, String> columnKierowcyInput = new TableColumn<>("Pesel kierowcy");
		columnKierowcyInput.setMinWidth(80);
		columnKierowcyInput.setCellValueFactory(new PropertyValueFactory<>("KIE_KEY"));

		TableColumn<Kursy, String> columnSygnaturaKursu = new TableColumn<>("Sygnatury Kursu");
		columnSygnaturaKursu.setMinWidth(100);
		columnSygnaturaKursu.setCellValueFactory(new PropertyValueFactory<>("KUR_Sygnatura_Kursu"));

		TableColumn<Kursy, String> columnMiejscStartowa = new TableColumn<>("Przystanek startowy");
		columnMiejscStartowa.setMinWidth(150);
		columnMiejscStartowa.setCellValueFactory(new PropertyValueFactory<>("KUR_Miejsc_Konco"));

		TableColumn<Kursy, String> columnMiejscKoncowa = new TableColumn<>("Przystanek koñcowy");
		columnMiejscKoncowa.setMinWidth(150);
		columnMiejscKoncowa.setCellValueFactory(new PropertyValueFactory<>("KUR_Opis"));

		TableColumn<Kursy, String> columnKursCzasOdjazd = new TableColumn<>("Czas Odjazdu");
		columnKursCzasOdjazd.setMinWidth(80);
		columnKursCzasOdjazd.setCellValueFactory(new PropertyValueFactory<>("KUR_Czas_Odjazdu"));

		TableColumn<Kursy, String> columnKursCzasprzyjazdu = new TableColumn<>("Czas Przyjazdu");
		columnKursCzasprzyjazdu.setMinWidth(80);
		columnKursCzasprzyjazdu.setCellValueFactory(new PropertyValueFactory<>("KUR_Czas_Przyjazdu"));

		idAutaInput = new TextField();
		idAutaInput.setPromptText("Numer rej autokaru");
		idAutaInput.setMinWidth(50);

		idKierowcyInput = new TextField();
		idKierowcyInput.setPromptText("Pesel kierowcy");
		idKierowcyInput.setMinWidth(50);

		kursSygnaturaKursuInput = new TextField();
		kursSygnaturaKursuInput.setPromptText("Sygnatura Kursu");
		kursSygnaturaKursuInput.setMinWidth(50);

		kursMiejscStartowa = new TextField();
		kursMiejscStartowa.setPromptText("Przystanek startowy");
		kursMiejscStartowa.setMinWidth(100);

		kursOpisInput = new TextField();
		kursOpisInput.setPromptText("Przystanek koñcowy");
		kursOpisInput.setMinWidth(100);

		kursCzasOdjazduInput = new TextField();
		kursCzasOdjazduInput.setPromptText("Czas Odjazdu");
		kursCzasOdjazduInput.setMinWidth(50);

		kursCzasPrzyjazduInput = new TextField();
		kursCzasPrzyjazduInput.setPromptText("Czas Przyjazdu");
		kursCzasPrzyjazduInput.setMinWidth(50);

		addbutton5 = new Button("Add");
		addbutton5.setOnAction(e -> addbutton5Clicked());
		addbutton5.setMinWidth(50);

		deltebutton5 = new Button("Delete");
		deltebutton5.setOnAction(e -> {

			rezultat = checkbox.display();
			if (rezultat == true) {

				deltebutton5Clicked();
			}
		});

		deltebutton5.setMinWidth(70);

		hbox5 = new HBox();
		hbox5.setPadding(new Insets(10, 10, 10, 10));
		hbox5.setSpacing(10);
		hbox5.getChildren().addAll(idAutaInput, idKierowcyInput, kursSygnaturaKursuInput, kursMiejscStartowa,
				kursOpisInput, kursCzasOdjazduInput, kursCzasPrzyjazduInput, addbutton5, deltebutton5);

		table5 = new TableView<>();
		table5.getColumns().addAll(columnIdKurs, columnIdAuta, columnKierowcyInput, columnSygnaturaKursu,
				columnMiejscStartowa, columnMiejscKoncowa, columnKursCzasOdjazd, columnKursCzasprzyjazdu);
		table5.setItems(fillTable.getProduct5());

		treeitem = new TreeItem<>("Spis opcji");
		treeitem.setExpanded(true);
		makeBranch("Trasy", treeitem);
		makeBranch("Przystanki", treeitem);
		makeBranch("Kierowcy", treeitem);
		makeBranch("Autokary", treeitem);
		makeBranch("Kursy", treeitem);
		makeBranch("Miejscowoœci", treeitem);

		makeBranch("Rejestr Przejazdów", treeitem);

		tree6 = new TreeView<>(treeitem);
		tree6.setShowRoot(true);

		tree6.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
			if (newValue != null) {
				String nazwa = newValue.getValue();
				wyborbazydanych(nazwa);

			}
		});

		VBox layout5 = new VBox();
		layout5.getChildren().addAll(table5, hbox5);

		bordePaneDlaOkna8.setTop(menuBar6);
		bordePaneDlaOkna8.setLeft(tree6);
		bordePaneDlaOkna8.setCenter(layout5);

		////////////// Okno bazy danych Miejscowœci ////////////////

		bordePaneDlaOkna9 = new BorderPane();
		scene9 = new Scene(bordePaneDlaOkna9, 1200, 480);
		scene9.getStylesheets().add("application/Panel_Dy¿urnego.css");

		menuBar7 = new MenuBar();
		menuBar7.getMenus().addAll(filemenu);

		TableColumn<Miejscowosci, String> columnIDmiejscow = new TableColumn<>("ID_Miejscowoœæ");
		columnIDmiejscow.setMinWidth(180);
		columnIDmiejscow.setCellValueFactory(new PropertyValueFactory<>("MIE_KEY"));

		TableColumn<Miejscowosci, String> columnNazwaMiejscowosci = new TableColumn<>("Nazwa Miejscowoœci");
		columnNazwaMiejscowosci.setMinWidth(180);
		columnNazwaMiejscowosci.setCellValueFactory(new PropertyValueFactory<>("MIE_Nazwa_Miejscow"));

		TableColumn<Miejscowosci, String> columnWojewodztwo = new TableColumn<>("Wojewodztwo");
		columnWojewodztwo.setMinWidth(180);
		columnWojewodztwo.setCellValueFactory(new PropertyValueFactory<>("MIE_Wojewodztwo"));

		TableColumn<Miejscowosci, String> columnPowiat = new TableColumn<>("Powiat");
		columnPowiat.setMinWidth(180);
		columnPowiat.setCellValueFactory(new PropertyValueFactory<>("MIE_Powiat"));

		TableColumn<Miejscowosci, String> columnGmina = new TableColumn<>("Gmina");
		columnGmina.setMinWidth(180);
		columnGmina.setCellValueFactory(new PropertyValueFactory<>("MIE_Gmina"));

		nazwaMiejscowosciInput = new TextField();
		nazwaMiejscowosciInput.setPromptText("Nazwa");
		nazwaMiejscowosciInput.setMinWidth(50);

		wojewodztwoInput = new TextField();
		wojewodztwoInput.setPromptText("Wojewodztwo");
		wojewodztwoInput.setMinWidth(50);

		powiatInput = new TextField();
		powiatInput.setPromptText("Powiat");
		powiatInput.setMinWidth(50);

		gminaInput = new TextField();
		gminaInput.setPromptText("Gmina");
		gminaInput.setMinWidth(50);

		addbutton6 = new Button("Add");
		addbutton6.setOnAction(e -> addbutton6Clicked());
		addbutton6.setMinWidth(50);

		deltebutton6 = new Button("Delete");
		deltebutton6.setOnAction(e -> {

			rezultat = checkbox.display();
			if (rezultat == true) {

				deltebutton6Clicked();
			}
		});

		deltebutton6.setMinWidth(70);

		hbox6 = new HBox();
		hbox6.setPadding(new Insets(10, 10, 10, 10));
		hbox6.setSpacing(10);
		hbox6.getChildren().addAll(nazwaMiejscowosciInput, wojewodztwoInput, powiatInput, gminaInput, addbutton6,
				deltebutton6);

		table6 = new TableView<>();
		table6.getColumns().addAll(columnIDmiejscow, columnNazwaMiejscowosci, columnWojewodztwo, columnPowiat,
				columnGmina);
		table6.setItems(fillTable.getProduct6());

		treeitem = new TreeItem<>("Spis opcji");
		treeitem.setExpanded(true);
		makeBranch("Trasy", treeitem);
		makeBranch("Przystanki", treeitem);
		makeBranch("Kierowcy", treeitem);
		makeBranch("Autokary", treeitem);
		makeBranch("Kursy", treeitem);
		makeBranch("Miejscowoœci", treeitem);

		makeBranch("Rejestr Przejazdów", treeitem);

		// Create Tree

		tree7 = new TreeView<>(treeitem);
		tree7.setShowRoot(true);

		tree7.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
			if (newValue != null) {
				String nazwa = newValue.getValue();
				wyborbazydanych(nazwa);

			}
		});

		VBox layout6 = new VBox();
		layout6.getChildren().addAll(table6, hbox6);

		bordePaneDlaOkna9.setTop(menuBar7);
		bordePaneDlaOkna9.setLeft(tree7);
		bordePaneDlaOkna9.setCenter(layout6);

		////////////// Okno bazy danych Rejestr przejazdów ////////////////

		bordePaneDlaOkna10 = new BorderPane();
		scene10 = new Scene(bordePaneDlaOkna10, 1200, 480);
		scene10.getStylesheets().add("application/Panel_Dy¿urnego.css");

		menuBar8 = new MenuBar();
		menuBar8.getMenus().addAll(filemenu);

		TableColumn<Rejestr_przejazdow, String> columnIdrejest = new TableColumn<>("Numer rejestru");
		columnIdrejest.setMinWidth(180);
		columnIdrejest.setCellValueFactory(new PropertyValueFactory<>("REJ_KEY"));

		TableColumn<Rejestr_przejazdow, String> columnIDkurs = new TableColumn<>("Skad");
		columnIDkurs.setMinWidth(180);
		columnIDkurs.setCellValueFactory(new PropertyValueFactory<>("KUR_Miejsc_Startowa"));

		TableColumn<Rejestr_przejazdow, String> columnRejestdata = new TableColumn<>("Dokad");
		columnRejestdata.setMinWidth(180);
		columnRejestdata.setCellValueFactory(new PropertyValueFactory<>("PR_Ulica"));

		TableColumn<Rejestr_przejazdow, String> columnOdDnia = new TableColumn<>("Od dnia");
		columnOdDnia.setMinWidth(180);
		columnOdDnia.setCellValueFactory(new PropertyValueFactory<>("REJ_data_start"));

		TableColumn<Rejestr_przejazdow, String> columnDoDnia = new TableColumn<>("Do dnia");
		columnDoDnia.setMinWidth(180);
		columnDoDnia.setCellValueFactory(new PropertyValueFactory<>("REJ_data_konc"));

		TableColumn<Rejestr_przejazdow, String> columnIloscOsub = new TableColumn<>("Ilosc Osób");
		columnIloscOsub.setMinWidth(180);
		columnIloscOsub.setCellValueFactory(new PropertyValueFactory<>("REJ_iloscOsob"));

		reIdKursyInput = new TextField();
		reIdKursyInput.setPromptText("Skad");
		reIdKursyInput.setMinWidth(50);

		txtColRejestrPrzystanek = new TextField();
		txtColRejestrPrzystanek.setPromptText("Dokad");
		txtColRejestrPrzystanek.setMinWidth(50);

		txtColRejestrDataStart = new TextField();
		txtColRejestrDataStart.setPromptText("Od dnia");
		txtColRejestrDataStart.setMinWidth(50);

		txtColRejestrDataKoniec = new TextField();
		txtColRejestrDataKoniec.setPromptText("Do dnia");
		txtColRejestrDataKoniec.setMinWidth(50);

		rejestrIloscOsobInput = new TextField();
		rejestrIloscOsobInput.setPromptText("Ilosc Osób");
		rejestrIloscOsobInput.setMinWidth(50);

		addbutton7 = new Button("Add");
		addbutton7.setOnAction(e -> addbutton7Clicked());
		addbutton7.setMinWidth(50);

		deltebutton7 = new Button("Delete");
		deltebutton7.setOnAction(e -> {

			rezultat = checkbox.display();
			if (rezultat == true) {

				deltebutton7Clicked();
			}
		});

		deltebutton7.setMinWidth(70);

		hbox7 = new HBox();
		hbox7.setPadding(new Insets(10, 10, 10, 10));
		hbox7.setSpacing(10);
		hbox7.getChildren().addAll(reIdKursyInput, txtColRejestrPrzystanek, txtColRejestrDataStart,
				txtColRejestrDataKoniec, rejestrIloscOsobInput, addbutton7, deltebutton7);

		table7 = new TableView<>();
		table7.getColumns().addAll(columnIdrejest, columnIDkurs, columnRejestdata, columnOdDnia, columnDoDnia,
				columnIloscOsub);
		table7.setItems(fillTable.getProduct7());

		treeitem = new TreeItem<>("Spis opcji");
		treeitem.setExpanded(true);
		makeBranch("Trasy", treeitem);
		makeBranch("Przystanki", treeitem);
		makeBranch("Kierowcy", treeitem);
		makeBranch("Autokary", treeitem);
		makeBranch("Kursy", treeitem);
		makeBranch("Miejscowoœci", treeitem);

		makeBranch("Rejestr Przejazdów", treeitem);

		tree8 = new TreeView<>(treeitem);
		tree8.setShowRoot(true);

		tree8.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
			if (newValue != null) {
				String nazwa = newValue.getValue();
				wyborbazydanych(nazwa);

			}
		});

		VBox layout7 = new VBox();
		layout7.getChildren().addAll(table7, hbox7);

		bordePaneDlaOkna10.setTop(menuBar8);
		bordePaneDlaOkna10.setLeft(tree8);
		bordePaneDlaOkna10.setCenter(layout7);

		window.setTitle("Damberpol");
		window.setScene(scenaOknoPowitalne);
		window.show();

	}

	public TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
		TreeItem<String> item = new TreeItem<>(title);
		item.setExpanded(true);
		parent.getChildren().add(item);
		return item;
	}

	public void btnAddKierowcy() {
		Kierowcy kierowca = new Kierowcy();

		String KIE_Imie = "'" + kierowca.setName(nameInput.getText()) + "'";
		String KIE_Nazwisko = "'" + kierowca.setNazwisko(nazwiskoInput.getText()) + "'";
		String KIE_Pesel = "'" + kierowca.setPesel(peselInput.getText()) + "'";
		String KIE_Data_zatr = "'" + kierowca.setDatazatrudnienia(dataInput.getText()) + "'";
		
		queries.insertDataToKierowcy(KIE_Imie, KIE_Nazwisko, KIE_Pesel, KIE_Data_zatr);
/*
		FillingTables fillTable = new FillingTables();
		try {
			table.setItems(fillTable.getProduct());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		*/
		nameInput.clear();
		nazwiskoInput.clear();
		peselInput.clear();
		dataInput.clear();

	}

	public void btnAddPrzystanki() {
		Przystanki przystanki = new Przystanki();
		
		String MIE_Nazwa_Miejscow = "'" + przystanki.setMIE_KEY(iDMiejscowsci.getText()) + "'";
		String PR_Ulica = "'" + przystanki.setPR_Ulica(inputulica.getText()) + "'";
		
		table2.getItems().add(przystanki);
		queries.insertDataToPrzystanki(MIE_Nazwa_Miejscow, PR_Ulica);
		
		iDMiejscowsci.clear();
		inputulica.clear();

	}

	public void btnAddTrasy() {
		Trasa trasa = new Trasa();
		String trasaKursStartowa = "'" + trasa.setKUR_Sygnatura_Kursu(trasaKursStart.getText()) + "'";
		String trasaKursKoncowa = "'" + trasa.setMIE_Nazwa_Miejscow(trasaKursKoniec.getText()) + "'";
		String TR_Skad = "'" + trasa.setTR_Skad(trasaMiejscowoscStartowa.getText()) + "'";
		String MIE_Nazwa_Miejscow = "'" + trasa.setMIE_Nazwa_Miejscow(trasaMiejscowoscKoncowa.getText()) + "'";
		String TR_Dzien_tyg = "'" + trasa.setTR_Dzien_tyg(trasaDzienTygodnia.getText()) + "'";
		String TR_Godzina_odjazdu = "'" + trasa.setTR_Godzina_odjazdu(trasaGodzinaOdjazdu.getText()) + "'";
		String TR_Godzina = "'" + trasa.setTR_Godzina(trasaGodzinaPrzyjazdu.getText()) + "'";
		String TR_Uwagi = "'" + trasa.setTR_Uwagi(trasaUwagi.getText()) + "'";

		queries.insertDataToTrasy(trasaKursStartowa, trasaKursKoncowa, TR_Skad, MIE_Nazwa_Miejscow, TR_Dzien_tyg,
				TR_Godzina_odjazdu, TR_Godzina, TR_Uwagi);
		table3.getItems().add(trasa);

		trasaKursStart.clear();
		trasaKursKoniec.clear();
		trasaMiejscowoscStartowa.clear();
		trasaMiejscowoscKoncowa.clear();
		trasaGodzinaOdjazdu.clear();
		trasaGodzinaPrzyjazdu.clear();
		trasaDzienTygodnia.clear();
		trasaUwagi.clear();

	}

	public void addbutton4Clicked() {
		Autokary autokary = new Autokary();

		String AUT_Marka = "'" + autokary.setAUT_Marka(modelInput.getText()) + "'";
		String AUT_Model = "'" + autokary.setAUT_Model(markaInput.getText()) + "'";
		int AUT_Rok_Prod = autokary.setAUT_Rok_Prod(Integer.parseInt(rokProdukcjiInput.getText()));
		int AUT_Poj_Silnik = autokary.setAUT_Poj_silnik(Integer.parseInt(pojemnoscSilnikaInput.getText()));
		int AUT_Spalanie = autokary.setAUT_Spalamie_lkm(Integer.parseInt(spalanieInput.getText()));
		String AUT_Kategoria = "'" + autokary.setAUT_Kat_autokaru(katAutokaruInput.getText()) + "'";
		int AUT_Ilosc_Miejsc = autokary.setAUT_Ilosc_miejsc(Integer.parseInt(iloscMiejsInput.getText()));
		String AUT_NR_Rej = "'" + autokary.setAUT_Nr_rejestracji(numerRejestracyjny.getText()) + "')";
		queries.insertDataToAutokary(AUT_Marka, AUT_Model, AUT_Rok_Prod, AUT_Poj_Silnik, AUT_Spalanie, AUT_Kategoria,
				AUT_Ilosc_Miejsc, AUT_NR_Rej);
		table4.getItems().add(autokary);

		// idAutokaruInput.clear();
		modelInput.clear();
		markaInput.clear();
		rokProdukcjiInput.clear();
		pojemnoscSilnikaInput.clear();
		spalanieInput.clear();
		katAutokaruInput.clear();
		iloscMiejsInput.clear();
		numerRejestracyjny.clear();
	}

	public void addbutton5Clicked() {
		Kursy kursy = new Kursy();

		String numerRejAutokary = "'" + kursy.setAUT_KEY(idAutaInput.getText()) + "'";
		String KIE_Pesel = "'" + kursy.setKIE_KEY(idKierowcyInput.getText()) + "'";
		String KUR_Sygnatura_Kursu = "'" + kursy.setKUR_Sygnatura_Kursu(kursSygnaturaKursuInput.getText()) + "'";
		String KUR_Miejsc_Start = "'" + kursy.setKUR_Opis(kursMiejscStartowa.getText()) + "'";
		String KUR_Miejsc_Konco = "'" + kursy.setKUR_Miejsc_Konco(kursOpisInput.getText()) + "'";
		String KUR_Czas_Odjazdu = "'" + kursy.setKUR_Czas_Odjazdu(kursCzasOdjazduInput.getText()) + "'";
		String KUR_Czas_Przyjazdu = "'" + kursy.setKUR_Czas_Przyjazdu(kursCzasPrzyjazduInput.getText()) + "'";

		queries.insertDataToKursy(KIE_Pesel, numerRejAutokary, KUR_Sygnatura_Kursu, KUR_Miejsc_Start, KUR_Miejsc_Konco,
				KUR_Czas_Odjazdu, KUR_Czas_Przyjazdu);
		table5.getItems().add(kursy);
		// TODO Dodaje poprawnie do bazy, niepoprawnie do kolumn
		// IdKursInput.clear();
		idAutaInput.clear();
		idKierowcyInput.clear();
		kursSygnaturaKursuInput.clear();
		kursMiejscStartowa.clear();
		kursOpisInput.clear();
		kursCzasOdjazduInput.clear();
		kursCzasPrzyjazduInput.clear();
	}

	public void addbutton6Clicked() {
		Miejscowosci miejscowosci = new Miejscowosci();

		String MIE_Nazwa_Miejscow = "'" + miejscowosci.setMIE_Nazwa_Miejscow(nazwaMiejscowosciInput.getText()) + "'";
		String MIE_Wojewodztwo = "'" + miejscowosci.setMIE_Wojewodztwo(wojewodztwoInput.getText()) + "'";
		String MIE_Powiat = "'" + miejscowosci.setMIE_Powiat(powiatInput.getText()) + "'";
		String MIE_Gmina = "'" + miejscowosci.setMIE_Gmina(gminaInput.getText()) + "'";
		queries.insertDataToMiejscowosci(MIE_Nazwa_Miejscow, MIE_Wojewodztwo, MIE_Powiat, MIE_Gmina);

		table6.getItems().add(miejscowosci);

		// TODO Nieskonczona proba oswiezania tabeli po dodaniu rekordu
		FillingTables fillTable = new FillingTables();
		try {
			fillTable.getProduct6();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nazwaMiejscowosciInput.clear();
		wojewodztwoInput.clear();
		powiatInput.clear();
		gminaInput.clear();

	}

	public void addbutton7Clicked() {
		Rejestr_przejazdow rejestr = new Rejestr_przejazdow();

		String KUR_Miejsc_Startowa = "'" + rejestr.setKUR_Miejsc_Startowa(reIdKursyInput.getText()) + "'";
		String KUR_Miejsc_Konco = "'" + rejestr.setPR_Ulica(txtColRejestrPrzystanek.getText()) + "'";
		String REJ_data_start = "'" + rejestr.setREJ_data_start(txtColRejestrDataStart.getText()) + "'";
		String REJ_data_konc = "'" + rejestr.setREJ_data_konc(txtColRejestrDataKoniec.getText()) + "'";
		int REJ_iloscOsob = rejestr.setREJ_iloscOsob(Integer.parseInt(rejestrIloscOsobInput.getText()));
		queries.insertDataToRaport(KUR_Miejsc_Startowa, KUR_Miejsc_Konco, REJ_data_start, REJ_data_konc, REJ_iloscOsob);
		table7.getItems().add(rejestr);

		IdRejstrówPrzejazdówInput.clear();
		reIdKursyInput.clear();
		txtColRejestrPrzystanek.clear();
		txtColRejestrDataStart.clear();
		txtColRejestrDataKoniec.clear();
		rejestrIloscOsobInput.clear();

	}

	public void deltebuttonClicked() {

		ObservableList<Kierowcy> productSelected, allProducts;
		allProducts = table.getItems();
		productSelected = table.getSelectionModel().getSelectedItems();
		Kierowcy selectedKierowcy = productSelected.get(0);
		int id = selectedKierowcy.getId();

		try {
			queries.deleteByIdKierowcy(id);
			productSelected.forEach(allProducts::remove);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deltebutton2Clicked() {
		ObservableList<Przystanki> productSelected, allProducts;
		allProducts = table2.getItems();
		productSelected = table2.getSelectionModel().getSelectedItems();

		Przystanki selectedPrzystanki = productSelected.get(0);
		int id = selectedPrzystanki.getPR_KEY();

		try {
			queries.deleteByIdPrzystanki(id);
			productSelected.forEach(allProducts::remove);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deltebutton3Clicked() {
		ObservableList<Trasa> productSelected, allProducts;
		allProducts = table3.getItems();
		productSelected = table3.getSelectionModel().getSelectedItems();
		Trasa selectedTrasa = productSelected.get(0);
		int id = selectedTrasa.getTR_KEY();

		try {
			queries.deleteByIdTrasy(id);
			productSelected.forEach(allProducts::remove);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deltebutton4Clicked() {
		ObservableList<Autokary> productSelected, allProducts;
		allProducts = table4.getItems();
		productSelected = table4.getSelectionModel().getSelectedItems();

		Autokary selectedAutokary = productSelected.get(0);
		int id = selectedAutokary.getAUT_KEY();

		try {
			queries.deleteByIdAutokary(id);
			productSelected.forEach(allProducts::remove);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deltebutton5Clicked() {
		ObservableList<Kursy> productSelected, allProducts;
		allProducts = table5.getItems();
		productSelected = table5.getSelectionModel().getSelectedItems();

		Kursy selectedKursy = productSelected.get(0);
		int id = selectedKursy.getKUR_KEY();

		try {
			queries.deleteByIdKursy(id);
			productSelected.forEach(allProducts::remove);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deltebutton6Clicked() {
		ObservableList<Miejscowosci> productSelected, allProducts;
		allProducts = table6.getItems();
		productSelected = table6.getSelectionModel().getSelectedItems();

		Miejscowosci selectedMiejscowosci = productSelected.get(0);
		int id = selectedMiejscowosci.getMIE_KEY();

		try {
			queries.deleteByIdMiejscowosci(id);
			productSelected.forEach(allProducts::remove);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deltebutton7Clicked() {
		ObservableList<Rejestr_przejazdow> productSelected, allProducts;
		allProducts = table7.getItems();
		productSelected = table7.getSelectionModel().getSelectedItems();

		Rejestr_przejazdow selectedRejestrPrzejazdow = productSelected.get(0);
		int id = selectedRejestrPrzejazdow.getREJ_KEY();

		try {
			queries.deleteByIdRejestrPrzejazdow(id);
			productSelected.forEach(allProducts::remove);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void wyborbazydanych(String wartosc) {

		switch (wartosc) {

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

		case "Miejscowoœci":
			window.setScene(scene9);
			break;

		case "Rejestr Przejazdów":
			window.setScene(scene10);
			break;
		}

	}

}
