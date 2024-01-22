package dad.geoFX.main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.geoFX.api.GeoService;
import dad.geoFX.connection.ConnectionController;
import dad.geoFX.location.LocationController;
import dad.geoFX.resources.Ipapi;
import dad.geoFX.resources.Ipify;
import dad.geoFX.security.SecurityController;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MainController implements Initializable {

	@FXML
	private Button checkIpButton;

	@FXML
	private BorderPane connectionPane;

	@FXML
	private TextField ip_TextField;

	@FXML
	private BorderPane locationPane;

	@FXML
	private BorderPane securityPane;

	@FXML
	private VBox view;

	private LocationController locationController;

	private ConnectionController connectionController;

	private SecurityController securityController;

	private GeoService geoservice;

	public MainController() {
		geoservice = new GeoService();
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadIP();

		locationController = new LocationController();
		connectionController = new ConnectionController();
		securityController = new SecurityController();

		locationPane.setCenter(locationController.getView());
		connectionPane.setCenter(connectionController.getView());
		securityPane.setCenter(securityController.getView());
	}

	public void loadIP() {
		Task<Ipify> task = new Task<Ipify>() {
			protected Ipify call() throws Exception {
				return geoservice.getIP();
			}
		};
		task.setOnSucceeded(event -> {
			ip_TextField.setText(task.getValue().getIp());
			onCheckIpAction(null);
		});
		task.setOnFailed(event -> event.getSource().getException().printStackTrace());
		new Thread(task).start();
	}

	@FXML
	void onCheckIpAction(ActionEvent event) {
		Task<Ipapi> task = new Task<Ipapi>() {
			protected Ipapi call() throws Exception {
				return geoservice.getIPData(ip_TextField.getText());
			}
		};
		task.setOnSucceeded(taskEvent -> {
			Ipapi result = task.getValue();
			LocationController.changeLocation(result);
			ConnectionController.changeConnection(result);
			SecurityController.changeSecurity(result);
		});
		task.setOnFailed(taskEvent -> taskEvent.getSource().getException().printStackTrace());
		new Thread(task).start();
		
			
	}

	public Button getCheckIpButton() {
		return checkIpButton;
	}

	public BorderPane getConnectionPane() {
		return connectionPane;
	}

	public TextField getIp_TextField() {
		return ip_TextField;
	}

	public BorderPane getLocationPane() {
		return locationPane;
	}

	public BorderPane getSecurityPane() {
		return securityPane;
	}

	public VBox getView() {
		return view;
	}
}
