package others4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	private MenuItem menuItemOpen = new MenuItem("Open");
	private MenuItem menuItemSave = new MenuItem("Save");
	private MenuItem menuItemClose = new MenuItem("Close");

	private MenuItem menuItemCut = new MenuItem("Cut");
	private MenuItem menuItemCopy = new MenuItem("Copy");
	private MenuItem menuItemPaste = new MenuItem("Paste");

	private MenuItem menuItemAbout = new MenuItem("About");

	private Menu menuFile = new Menu("File", null, menuItemOpen, menuItemSave, menuItemClose);
	private Menu menuEdit = new Menu("Edit", null, menuItemCut, menuItemCopy, menuItemPaste);
	private Menu menuHelp = new Menu("Help", null, menuItemAbout);

	private MenuBar menuBar = new MenuBar(menuFile, menuEdit, menuHelp);

	private BorderPane borderPane = new BorderPane(null, menuBar, null, null, null);

	private Scene scene = new Scene(borderPane, 400, 400);

	@Override
	public void init() {
		EventHandler<ActionEvent> eventHandler = event -> {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setContentText(
					((Menu) event.getSource()).getText() + " -> " + ((MenuItem) event.getTarget()).getText());
			alert.showAndWait();
		};

		menuFile.setOnAction(eventHandler);
		menuEdit.setOnAction(eventHandler);
		menuHelp.setOnAction(eventHandler);

		scene.getStylesheets().add("./others4/b.css");
		menuBar.getStyleClass().add("my");
		menuBar.getStyleClass().add("colour1");
	}

	@Override
	public void start(Stage stage) {
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.setResizable(false);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
