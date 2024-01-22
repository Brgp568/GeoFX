package dad.geoFX.location;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.geoFX.resources.Ipapi;
import dad.geoFX.resources.Language;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class LocationController implements Initializable {

	@FXML
    private Label callingCodeLabel;

    @FXML
    private Label cityStateLabel;

    @FXML
    private Label currencyLabel;

    @FXML
    private ImageView imageViewFlag;

    @FXML
    private Label ipLocationLabel;

    @FXML
    private Label languageLabel;

    @FXML
    private Label latitudeLabel;

    @FXML
    private Label longitudeLabel;

    @FXML
    private Label timeZoneLabel;

    @FXML
    private Label zipCodeLabel;
    
    @FXML
    private GridPane view;
	
    private static LocationModel model;
    
    public LocationController() {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LocationView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model = new LocationModel();
		
		Bindings.bindBidirectional(callingCodeLabel.textProperty(), model.callingCodeProperty());
		Bindings.bindBidirectional(cityStateLabel.textProperty(), model.cityStateProperty());
		Bindings.bindBidirectional(currencyLabel.textProperty(), model.currencyProperty());
		Bindings.bindBidirectional(imageViewFlag.imageProperty(), model.flagProperty());
		Bindings.bindBidirectional(ipLocationLabel.textProperty(), model.ipLocationProperty());
		Bindings.bindBidirectional(languageLabel.textProperty(), model.languageProperty());
		Bindings.bindBidirectional(latitudeLabel.textProperty(), model.latitudeProperty());
		Bindings.bindBidirectional(longitudeLabel.textProperty(), model.longitudeProperty());
		Bindings.bindBidirectional(timeZoneLabel.textProperty(), model.timeZoneProperty());
		Bindings.bindBidirectional(zipCodeLabel.textProperty(), model.zipCodeProperty());
	}

	public static void changeLocation(Ipapi ipapi) {
		
			model.setCallingCode("+"+ipapi.getLocation().getCallingCode());
			model.setCityState(ipapi.getCity()+", "+ipapi.getRegionName());
			model.setCurrency(ipapi.getCurrency().getName()+"("+ipapi.getCurrency().getSymbol()+")");
			model.setFlag(new Image("/flag-icons/64x42/"+ipapi.getCountryCode()+".png"));
			model.setIpLocation(ipapi.getCountryName()+"("+ipapi.getCountryCode()+")");
			Language language = ipapi.getLocation().getLanguages().get(0);
			model.setLanguage(language.getName()+" ("+language.getCode()+")");
			model.setLatitude(ipapi.getLatitude()+"");
			model.setLongitude(ipapi.getLongitude()+"");
			model.setTimeZone(ipapi.getTimeZone().getCode());
			model.setZipCode(ipapi.getZip());
		
	}

	public GridPane getView() {
		return view;
	}

	public LocationModel getModel() {
		return model;
	}
}
