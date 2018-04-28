package dialogs;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		doDialog(new Alert(AlertType.CONFIRMATION, "contextText", ButtonType.NO, ButtonType.YES));
		doDialog(new ChoiceDialog<>("222", Arrays.asList("000", "111", "222", "333", "444", "555")));
		doDialog(new TextInputDialog());

		doFileChooser();
	}

	public void doFileChooser() {
		FileChooser fileChooser = new FileChooser();
		File startDisc;
		try {
			startDisc = File.listRoots()[1];
		} catch (ArrayIndexOutOfBoundsException e) {
			startDisc = File.listRoots()[0];
		}
		fileChooser.setInitialDirectory(startDisc);
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("txt-файлы", "*.txt"));
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("jar-файлы", "*.jar"));
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Все файлы", "*.*"));
		try {
			showNameFile(fileChooser.showOpenDialog(null));
			showNameFile(fileChooser.showSaveDialog(null));
			System.out.println("----------------------------");
			List<File> files = fileChooser.showOpenMultipleDialog(null);
			if (Objects.nonNull(files)) {
				files.forEach(this::showNameFile);
			}
		} catch (IllegalArgumentException e) {
			throw e;
		}
	}

	public void showNameFile(File file) {
		try {
			if (Objects.nonNull(file)) {
				System.out.println(file.getCanonicalPath());
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void doDialog(Dialog<?> dialog) {
		dialog.setTitle("Вопрос");
		dialog.setHeaderText(null);
		dialog.setContentText("contentText");
		Optional<?> result = dialog.showAndWait();
		System.out.println(result.isPresent() ? result.get() : "nothing");
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
