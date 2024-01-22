package dad.geoFX.security;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import dad.geoFX.resources.Ipapi;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class SecurityController implements Initializable {

	@FXML
    private CheckBox crawlerDetectedCheckBox;

    @FXML
    private Label potentialThreatTypesLabel;

    @FXML
    private CheckBox proxyDetectedCheckBox;

    @FXML
    private Label securityMessageLabel;

    @FXML
    private Label threatLevelLabel;

    @FXML
    private CheckBox torDetectedCheckBox;

    @FXML
    private GridPane view;
	
    private static SecurityModel model;
    
	public SecurityController() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SecurityView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model = new SecurityModel();
		
		Bindings.bindBidirectional(crawlerDetectedCheckBox.selectedProperty(), model.crawlerDetectedProperty());
		Bindings.bindBidirectional(potentialThreatTypesLabel.textProperty(), model.potentialThreatTypesProperty());
		Bindings.bindBidirectional(proxyDetectedCheckBox.selectedProperty(), model.proxyDetectedProperty());
		Bindings.bindBidirectional(securityMessageLabel.textProperty(), model.securityMessageProperty());
		Bindings.bindBidirectional(torDetectedCheckBox.selectedProperty(), model.torDetectedProperty());
		Bindings.bindBidirectional(threatLevelLabel.textProperty(),model.threatLevelProperty() );
		
		
		model.threatLevelProperty().addListener((observable, oldValue, newValue) -> {
			switch (newValue.toLowerCase()) {
			case "low":
				model.setSecurityMessage("This IP is safe. No threats have been detected.");
				break;
			case "medium":
				model.setSecurityMessage("Potential threats detected. This IP may be unsafe.");
				break;
			case "high":
				model.setSecurityMessage("Definitive threats detected. This IP is unsafe.");
				break;
			default:
				model.setSecurityMessage("Threat level unknown.");
			}
		});
	}
	
	public static void changeSecurity(Ipapi ipapi) {
		model.setCrawlerDetected(ipapi.getSecurity().getIsCrawler());
		if (ipapi.getSecurity().getThreatTypes() != null) {
			model.setPotentialThreatTypes(ipapi.getSecurity().getThreatTypes()+"");
		} else {
			model.setPotentialThreatTypes("No threats have been detected for this IP address.");
		}
		model.setProxyDetected(ipapi.getSecurity().getIsProxy());
		model.setThreatLevel(ipapi.getSecurity().getThreatLevel());
		model.setTorDetected(ipapi.getSecurity().getIsTor());
	}

	public CheckBox getCrawlerDetectedCheckBox() {
		return crawlerDetectedCheckBox;
	}

	public Label getPotentialThreatTypesLabel() {
		return potentialThreatTypesLabel;
	}

	public CheckBox getProxyDetectedCheckBox() {
		return proxyDetectedCheckBox;
	}

	public Label getSecurityMessageLabel() {
		return securityMessageLabel;
	}

	public Label getThreatLevelLabel() {
		return threatLevelLabel;
	}

	public CheckBox getTorDetectedCheckBox() {
		return torDetectedCheckBox;
	}

	public GridPane getView() {
		return view;
	}

	public SecurityModel getModel() {
		return model;
	}
}
