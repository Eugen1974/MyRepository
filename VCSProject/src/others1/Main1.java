package others1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main1 extends Application {

	private Label label = new Label("Text");
	private Button button = new Button("Кнопка");
	private HBox hBox = new HBox(10, label, button);

	private MenuItem menuItemSave = new MenuItem("Save");
	private MenuItem menuItemOpen = new MenuItem("Open");
	private MenuItem menuItemClose = new MenuItem("Close");

	private MenuItem menuItemCopy = new MenuItem("Copy");
	private MenuItem menuItemCut = new MenuItem("Cut");
	private MenuItem menuItemPaste = new MenuItem("Paste");

	private MenuItem menuItemAbout = new MenuItem("About");

	private Menu menuFile = new Menu("File", null, menuItemSave, menuItemOpen, menuItemClose);
	private Menu menuEdit = new Menu("Edit", null, menuItemCopy, menuItemCut, menuItemPaste);
	private Menu menuHelp = new Menu("Help", null, menuItemAbout);

	private MenuBar menuBar = new MenuBar(menuFile, menuEdit, menuHelp);

	private BorderPane borderPane = new BorderPane(hBox, menuBar, null, null, null);

	private Scene scene = new Scene(borderPane, 400, 400);

	@Override
	public void init() {

		button.setOnAction(event -> {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setContentText("Information");
			alert.showAndWait();
		});

		button.addEventHandler(ActionEvent.ACTION, event -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setHeaderText(null);
			alert.setContentText("Confirmation");
			alert.showAndWait();
		});

		hBox.setAlignment(Pos.CENTER);

		scene.getStylesheets().add("./others1/a.css");

		label.getStyleClass().add("my");

		button.getStyleClass().add("my");
		button.getStyleClass().add("colour1");

		hBox.getStyleClass().add("colour2");

		menuBar.getStyleClass().add("my");

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
	}

	@Override
	public void start(Stage stage) {
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
