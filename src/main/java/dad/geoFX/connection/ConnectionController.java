package dad.geoFX.connection;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.geoFX.resources.Ipapi;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class ConnectionController implements Initializable {

	@FXML
    private Label asnLabel;

    @FXML
    private Label hostnameLabel;

    @FXML
    private Label ipLabel;

    @FXML
    private Label registeredIspLabel;

    @FXML
    private Label typeLabel;

    @FXML
    private GridPane view;
    
    private static ConnectionModel model;
	
	public ConnectionController() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ConnectionView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model = new ConnectionModel();
		
		Bindings.bindBidirectional(asnLabel.textProperty(), model.asnProperty());
		Bindings.bindBidirectional(hostnameLabel.textProperty(), model.hostnameProperty());
		Bindings.bindBidirectional(ipLabel.textProperty(), model.ipProperty());
		Bindings.bindBidirectional(registeredIspLabel.textProperty(), model.registeredIspProperty());
		Bindings.bindBidirectional(typeLabel.textProperty(), model.typeProperty());
	}
	
	public static void changeConnection(Ipapi ipapi) {
		model.setAsn(ipapi.getConnection().getAsn()+"");
		model.setHostname(ipapi.getHostname());
		model.setIp(ipapi.getIp());
		model.setRegisteredIsp(ipapi.getConnection().getIsp());
		model.setType(ipapi.getType());
	}

	public Label getAsnLabel() {
		return asnLabel;
	}

	public Label getHostnameLabel() {
		return hostnameLabel;
	}

	public Label getIpLabel() {
		return ipLabel;
	}

	public Label getRegisteredIspLabel() {
		return registeredIspLabel;
	}

	public Label getTypeLabel() {
		return typeLabel;
	}

	public GridPane getView() {
		return view;
	}
}
