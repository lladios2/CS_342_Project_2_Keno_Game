/**
 * Authors: Bianca J. & Leia L.
 * Project: Keno Game Using JavaFX
 * Class: CS 342
 * Professor: Mark Hallenbeck
 * Due Date: March 19, 2023  
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavaFXTemplate extends Application {

	
	private final int DIMY = 700;
	private final int DIMX = 700;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	// feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Keno");

		startPage(primaryStage);
		primaryStage.show();
	}
	
	private void startPage(Stage stage) {
		
		Text welcome = new Text("Welcome to Keno!");
		welcome.setFont(new Font(15));
		
		Button playButton = new Button("Play");
		playButton.setMinWidth(100);
		
		EventHandler<ActionEvent> h1 = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				buildBetCard(stage);
			}
		
		};
		
		playButton.setOnAction(h1);
		
		VBox vbStartPage = new VBox(10, welcome, playButton);
		
		MenuBar mb = buildMenu(stage);
		VBox vbMenu = new VBox(mb);
		
		BorderPane bp = new BorderPane(vbStartPage);
		
		vbStartPage.setAlignment(Pos.CENTER);
		
		bp.setTop(vbMenu);
		
		Scene startPage = new Scene(bp, DIMX, DIMY);
		stage.setScene(startPage);
		stage.show();
	}
	
	private MenuBar buildMenu(Stage stage) {

		Menu menu = new Menu("Menu");
		MenuBar menuBar = new MenuBar();
		
		MenuItem[] menuItems = new MenuItem[4];
		ArrayList<EventHandler<ActionEvent>> events = new ArrayList<EventHandler<ActionEvent>>();
		
		menuItems[0] = new MenuItem("Rules");
		menuItems[1] = new MenuItem("Winning Odds");
		menuItems[2] = new MenuItem("New Look");
		menuItems[3] = new MenuItem("Exit");
		
		EventHandler<ActionEvent> toRules = e -> {buildRules(stage);};
		EventHandler<ActionEvent> toOdds = e -> {buildWinningOdds(stage);};
		EventHandler<ActionEvent> appNewLook = e -> {}; // do something to applyNewLook
		EventHandler<ActionEvent> toExit = e -> {buildExit(stage);};
		
		events.add(toRules);
		events.add(toOdds);
		events.add(appNewLook);
		events.add(toExit);
		
		menuBar.getMenus().add(menu);
		
		
		//binds each MenuItem in menuItem array to an EventHandler in events array
		for(int i = 0; i < menuItems.length; i++) {
			menuItems[i].setOnAction(events.get(i));
			menu.getItems().add(menuItems[i]);
		}
		
		
		return menuBar;
	}
	
	private MenuBar buildMenu2(Stage stage) {

		Menu menu = new Menu("Menu");
		MenuBar menuBar = new MenuBar();

		MenuItem[] menuItems = new MenuItem[5];
		
		ArrayList<EventHandler<ActionEvent>> events = new ArrayList<EventHandler<ActionEvent>>();

		menuItems[0] = new MenuItem("Play Game");
		menuItems[1] = new MenuItem("Winning Odds");
		menuItems[2] = new MenuItem("Rules");
		menuItems[3] = new MenuItem("New Look");
		menuItems[4] = new MenuItem("Exit");

		EventHandler<ActionEvent> toPlay = e -> {buildBetCard(stage);};
		EventHandler<ActionEvent> toOdds = e -> {buildWinningOdds(stage);};
		EventHandler<ActionEvent> toRules = e -> {buildRules(stage);};
		EventHandler<ActionEvent> appNewLook = e -> {}; // do something to applyNewLook
		EventHandler<ActionEvent> toExit = e -> {buildExit(stage);};

		events.add(toPlay);
		events.add(toOdds);
		events.add(toRules);
		events.add(appNewLook);
		events.add(toExit);

		menuBar.getMenus().add(menu);

		for(int i = 0; i < menuItems.length; i++) {
			menuItems[i].setOnAction(events.get(i));
			menu.getItems().add(menuItems[i]);
		}

		return menuBar;

	}
	
	private void buildBetCard(Stage stage) {
		System.out.println("inside build bet card");
	}
	
	private void buildRules(Stage stage) {

		Text heading = new Text("Rules");
		heading.setFont(Font.font("Arial", FontWeight.BOLD, 15));
	

		Text ruleText = new Text("\n" +
				"Wager by choosing a set amount of numbers (pick 2 numbers, pick 10 numbers, etc) ranging from 1-80.\n" +
				"The player can choose to have the numbers randomly generated.\n" +
				"After player has chosen, 20 numbers are drawn between 1-80 with no duplicates.\n" +
				"Win by matching a set amount of numbers to the numbers drawn. ");
		ruleText.setFont(new Font(13));
		ruleText.setWrappingWidth(500);
		
		Label matchPrizes = new Label("Match Prizes");
		matchPrizes.setFont(Font.font(null, FontWeight.BOLD, 15));

		VBox vbRules = new VBox(heading, ruleText);
		
		Text header1 = new Text("Numbers Picked");
		Text header2 = new Text("Numbers Matched");
		Text header3 = new Text("Payout");
		
		
		HBox headers = new HBox(60, header1, header2, header3);
		
		
		VBox numsPicked = new VBox(25);
		numsPicked.getChildren().add(new Text("1 Number"));
		numsPicked.getChildren().add(new Text("4 Numbers\n"));
		numsPicked.getChildren().add(new Text("8 Numbers\n\n\n"));
		numsPicked.getChildren().add(new Text("10 Numbers"));
		
		
		VBox numsMatched = new VBox(8);
		
		Text col2One = new Text("1\n0");
		Text col2Two = new Text("4\n3\n2");
		Text col2Three = new Text("8\n7\n6\n5\n4");
		Text col2Four = new Text("10\n9\n8\n7\n6\n5\n0");
		
		numsMatched.getChildren().add(col2One);
		numsMatched.getChildren().add(col2Two);
		numsMatched.getChildren().add(col2Three);
		numsMatched.getChildren().add(col2Four);
		
		VBox payout = new VBox(8);
		
		Text col3One = new Text("$1\n$0");
		Text col3Two = new Text("$50\n$5\n$1");
		Text col3Three = new Text("$15,000\n$400\n$50\n$10\n$2");
		Text col3Four = new Text("$200,000\n$10,000\n$500\n$50\n$10\n$3\n$3");
		
		payout.getChildren().add(col3One);
		payout.getChildren().add(col3Two);
		payout.getChildren().add(col3Three);
		payout.getChildren().add(col3Four);
		
		HBox table = new HBox(120, numsPicked, numsMatched, payout);
		
		VBox vbPrize = new VBox(10, matchPrizes, headers, table);
		
		
		VBox rulesAndPrizes = new VBox(30, vbRules, vbPrize);

		MenuBar mb = buildMenu2(stage);
		VBox vbMenu = new VBox(mb);

		BorderPane bpRules = new BorderPane(rulesAndPrizes);

		bpRules.setTop(vbMenu);

		rulesAndPrizes.setPadding(new Insets(80, 0, 0, 120));

		Scene rulesPage = new Scene(bpRules, DIMX, DIMY);

		stage.setScene(rulesPage);
		stage.show();
	}
	
	
	/**
	 * Odds data gathered from https://casinosnet.com/keno-odds/
	 * @param stage
	 */
	private void buildWinningOdds(Stage stage) {
		Label winningOdds = new Label("Winning Odds");
		winningOdds.setFont(Font.font(null, FontWeight.BOLD, 17));
		
		Text header1 = new Text("Numbers Picked");
		Text header2 = new Text("Numbers Matched");
		Text header3 = new Text("Odds of Hitting");
		
		//column headers
		HBox headers = new HBox(45, header1, header2, header3);
		
		//numsPicked column
		VBox numsPicked = new VBox(49);
		numsPicked.getChildren().add(new Text("1 Number"));
		numsPicked.getChildren().add(new Text("4 Numbers\n\n"));
		numsPicked.getChildren().add(new Text("8 Numbers\n\n\n\n\n\n"));
		numsPicked.getChildren().add(new Text("10 Numbers"));
		
		
		//numsMatched column
		VBox numsMatched = new VBox(17);
		
		Text col2One = new Text("1\n\n0");
		Text col2Two = new Text("4\n\n3\n\n2");
		Text col2Three = new Text("8\n\n7\n\n6\n\n5\n\n4");
		Text col2Four = new Text("10\n\n9\n\n8\n\n7\n\n6\n\n5\n\n0");
		
	
		numsMatched.getChildren().add(col2One);
		numsMatched.getChildren().add(col2Two);
		numsMatched.getChildren().add(col2Three);
		numsMatched.getChildren().add(col2Four);
		
		//odds of hitting column
		
		VBox odds = new VBox(17);
		
		Text col3One = new Text("1 in 4\n\n1 in 3.33");
		Text col3Two = new Text("1 in 326\n\n1 in 23.12\n\n1 in 4.70");
		Text col3Three = new Text("1 in 230,114\n\n1 in 6,232.27\n\n1 in 422.53\n\n1 in 54.64\n\n1 in 12.27");
		Text col3Four = new Text("1 in 8,911,711\n\n1 in 163.381\n\n1 in 7,384\n\n1 in 621\n\n1 in 87.11\n\n1 in 19.44\n\n1 in 21.84");
		
		odds.getChildren().add(col3One);
		odds.getChildren().add(col3Two);
		odds.getChildren().add(col3Three);
		odds.getChildren().add(col3Four);
		
		
		HBox cols = new HBox(110, numsPicked, numsMatched, odds);
		
		
		VBox oddsText = new VBox(10, winningOdds, headers, cols);
		
		MenuBar mb = buildMenu2(stage);
		VBox vbMenu = new VBox(mb);
		
		BorderPane bpOdds = new BorderPane(oddsText);
		
		bpOdds.setTop(vbMenu);
		
		oddsText.setPadding(new Insets(30, 0, 0, 150));
		
		
		Scene winOdds = new Scene(bpOdds, DIMX, DIMY);
		stage.setScene(winOdds);
		stage.show();
		
	}
	
	private void buildExit(Stage stage) {
		stage.close();
	}
	
}
