package others3;

import java.util.Objects;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main3 extends Application {

	private ObservableList<Person3> persons = FXCollections.observableArrayList(new Person3("AAA", 10),
			new Person3("BBB", 12), new Person3("CCC", 14), new Person3("DDD", 16));

	private TableView<Person3> tableView = new TableView<>(persons);

	private TableColumn<Person3, String> columnName = new TableColumn<>("Name");
	private TableColumn<Person3, Number> columnAge = new TableColumn<>("Age");

	private Label labelName = new Label("Name");
	private TextField textFieldName = new TextField();

	private Label labelAge = new Label("Age");
	private TextField textFieldAge = new TextField();

	private Button buttonSave = new Button("Save");
	private HBox hBox = new HBox(10, labelName, textFieldName, labelAge, textFieldAge, buttonSave);

	private BorderPane borderPane = new BorderPane(tableView, null, null, hBox, null);
	private Scene scene = new Scene(borderPane, 600, 400);

	private MenuItem menuItemPrint = new MenuItem("Print");
	private MenuItem menuItemInsert = new MenuItem("Insert");
	private MenuItem menuItemUpdate = new MenuItem("Update");
	private MenuItem menuItemDelete = new MenuItem("Delete");
	private ContextMenu contextMenu = new ContextMenu(menuItemPrint, new SeparatorMenuItem(), menuItemInsert,
			new SeparatorMenuItem(), menuItemUpdate, new SeparatorMenuItem(), menuItemDelete);

	private boolean signInsert;

	@Override
	public void init() {
		columnName.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getName()));

		columnAge.setCellValueFactory(cell -> new SimpleIntegerProperty(cell.getValue().getAge()));

		tableView.getColumns().add(columnName);
		tableView.getColumns().add(columnAge);

		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		menuItemPrint.setOnAction(event -> {
			tableView.getSelectionModel().getSelectedItems().forEach(System.out::println);
			System.out.println("--------------------------");
		});

		menuItemInsert.setOnAction(event -> {
			signInsert = true;
			textFieldName.requestFocus();
		});

		menuItemUpdate.setOnAction(event -> {
			signInsert = false;
			Person3 person = tableView.getSelectionModel().getSelectedItem();
			if (Objects.nonNull(person)) {
				textFieldName.setText(person.getName());
				textFieldAge.setText(String.valueOf(person.getAge()));
				textFieldName.requestFocus();
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setContentText("Doesn't selected item !");
				alert.showAndWait();
			}
		});

		menuItemDelete.setOnAction(event -> {
			persons.removeAll(tableView.getSelectionModel().getSelectedItems());
		});

		tableView.setContextMenu(contextMenu);

		buttonSave.setOnAction(event -> {
			try {
				Person3 person = new Person3(textFieldName.getText(), Integer.valueOf(textFieldAge.getText().trim()));
				if (signInsert) {
					persons.add(person);
				} else {
					persons.set(tableView.getSelectionModel().getSelectedIndex(), person);
				}
				textFieldName.setText(null);
				textFieldAge.setText(null);
			} catch (Exception e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setContentText(e.getClass().getName() + ": " + e.getMessage());
				alert.showAndWait();
			}
		});

		hBox.setAlignment(Pos.CENTER);
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
