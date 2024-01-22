package dad.geoFX.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	private MainController controller;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		controller = new MainController();
		
		primaryStage.setTitle("GeoFX");
		primaryStage.setScene(new Scene(controller.getView()));
		primaryStage.show();	
	}

	public static void main(String[] args) {
		launch(args);
	}

}
