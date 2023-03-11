import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class JavaFXTemplate extends Application {

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
		
		Scene startPage = new Scene(bp, 700, 700);
		stage.setScene(startPage);
		stage.show();
	}
	
	private MenuBar buildMenu(Stage stage) {

		Menu menu = new Menu("Menu");
		MenuBar menuBar = new MenuBar();
		
		MenuItem[] menuItems = new MenuItem[4];
		EventHandler[] events = new EventHandler[4];
		
		menuItems[0] = new MenuItem("Rules");
		menuItems[1] = new MenuItem("Winning Odds");
		menuItems[2] = new MenuItem("New Look");
		menuItems[3] = new MenuItem("Exit");
		
		EventHandler<ActionEvent> toRules = e -> {buildRules(stage);};
		EventHandler<ActionEvent> toOdds = e -> {buildWinningOdds(stage);};
		EventHandler<ActionEvent> appNewLook = e -> {}; // do something to applyNewLook
		EventHandler<ActionEvent> toExit = e -> {buildExit(stage);};
		
		events[0] = toRules;
		events[1] = toOdds;
		events[2] = appNewLook;
		events[3] = toExit;
		
		menuBar.getMenus().add(menu);
		
		
		//binds each MenuItem in menuItem array to an EventHandler in events array
		for(int i = 0; i < menuItems.length; i++) {
			menuItems[i].setOnAction(events[i]);
			menu.getItems().add(menuItems[i]);
		}
		
		
		return menuBar;
	}
	
	private MenuBar buildMenu2(Stage stage) {

		Menu menu = new Menu("Menu");
		MenuBar menuBar = new MenuBar();
		
		MenuItem[] menuItems = new MenuItem[4];
		
		menuItems[0] = new MenuItem("Play Game");
		menuItems[1] = new MenuItem("Winning Odds");
		menuItems[2] = new MenuItem("New Look");
		menuItems[3] = new MenuItem("Exit");
		
		menuBar.getMenus().add(menu);
		
		for(int i = 0; i < menuItems.length; i++) {
			menu.getItems().add(menuItems[i]);
		}
		
		return menuBar;
	}
	
	private void buildBetCard(Stage stage) {
		System.out.println("inside build bet card");
	}
	
	private void buildRules(Stage stage) {

		Text heading = new Text("Rules");
		heading.setFont(new Font(15));

		Text ruleText = new Text("\n" +
				"Wager by choosing a set amount of numbers (pick 2 numbers, pick 10 numbers, etc) ranging from 1-80\n" +
				"The player can choose to have the numbers randomly generated.\n" +
				"After player has chosen, 20 numbers are drawn between 1-80 with no duplicates.\n" +
				"Win by matching a set amount of numbers to the numbers drawn. ");
		ruleText.setFont(new Font(15));

		VBox vbRules = new VBox(10, heading, ruleText);

		MenuBar mb = buildMenu2(stage);
		VBox vbMenu = new VBox(mb);

		BorderPane bpRules = new BorderPane(vbRules);

		bpRules.setTop(vbMenu);

		vbRules.setAlignment(Pos.CENTER);


		Scene rulesPage = new Scene(bpRules, 700, 700);

		stage.setScene(rulesPage);
		stage.show();
	}
	
	private void buildWinningOdds(Stage stage) {
		//use buildMenu2() for this page's menu bar
		System.out.println("inside build winning odds");
		
	}
	
	private void buildExit(Stage stage) {
		stage.close();
	}
	
}
