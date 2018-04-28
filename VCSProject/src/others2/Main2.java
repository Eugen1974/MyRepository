package others2;

import java.util.Objects;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main2 extends Application {

	public static final Person2 PERSON = new Person2("BBB", 12);

	private ObservableList<Person2> persons = FXCollections
			.observableArrayList(person -> new Observable[] { person.getPropertyName(), person.getPropertyAge() });

	private ListView<Person2> listView = new ListView<>(persons);

	private Button buttonName = new Button("Name");
	private Button buttonAge = new Button("Age");
	private HBox hBox = new HBox(10, buttonName, buttonAge);

	private BorderPane borderPane = new BorderPane(listView, null, null, hBox, null);
	private Scene scene = new Scene(borderPane, 400, 400);

	@Override
	public void init() {
		persons.addAll(new Person2("AAA", 10), PERSON, new Person2("CCC", 14), new Person2("DDD", 16));

		hBox.setAlignment(Pos.CENTER);

		buttonName.setOnAction(event -> PERSON.setName(Objects.equals(PERSON.getName(), "BBB") ? "bbbbbbb" : "BBB"));

		buttonAge.setOnAction(event -> PERSON.setAge(PERSON.getAge() == 12 ? 222222 : 12));
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
