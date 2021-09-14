package prosjektKode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("My app");
		primaryStage.setScene(new Scene(FXMLLoader.load(App.class.getResource("Ui.fxml"))));
		primaryStage.show();
	}

	public static void main(String[] args) {
		App.launch(args);
	}

}
