package dad.geoFX.location;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class LocationModel {

	private StringProperty callingCode;

	private StringProperty cityState;

	private StringProperty currency;

	private ObjectProperty<Image> flag;

	private StringProperty ipLocation;

	private StringProperty language;

	private StringProperty latitude;

	private StringProperty longitude;

	private StringProperty timeZone;

	private StringProperty zipCode;

	public LocationModel() {
		callingCode = new SimpleStringProperty();
		cityState = new SimpleStringProperty();
		currency = new SimpleStringProperty();
		flag = new SimpleObjectProperty<>();
		ipLocation = new SimpleStringProperty();
		language = new SimpleStringProperty();
		latitude = new SimpleStringProperty();
		longitude = new SimpleStringProperty();
		timeZone = new SimpleStringProperty();
		zipCode = new SimpleStringProperty();
	}

	public final StringProperty callingCodeProperty() {
		return this.callingCode;
	}

	public final String getCallingCode() {
		return this.callingCodeProperty().get();
	}

	public final void setCallingCode(final String callingCode) {
		this.callingCodeProperty().set(callingCode);
	}

	public final StringProperty cityStateProperty() {
		return this.cityState;
	}

	public final String getCityState() {
		return this.cityStateProperty().get();
	}

	public final void setCityState(final String cityState) {
		this.cityStateProperty().set(cityState);
	}

	public final StringProperty currencyProperty() {
		return this.currency;
	}

	public final String getCurrency() {
		return this.currencyProperty().get();
	}

	public final void setCurrency(final String currency) {
		this.currencyProperty().set(currency);
	}

	public final ObjectProperty<Image> flagProperty() {
		return this.flag;
	}

	public final Image getFlag() {
		return this.flagProperty().get();
	}

	public final void setFlag(final Image flag) {
		this.flagProperty().set(flag);
	}

	public final StringProperty ipLocationProperty() {
		return this.ipLocation;
	}

	public final String getIpLocation() {
		return this.ipLocationProperty().get();
	}

	public final void setIpLocation(final String ipLocation) {
		this.ipLocationProperty().set(ipLocation);
	}

	public final StringProperty languageProperty() {
		return this.language;
	}

	public final String getLanguage() {
		return this.languageProperty().get();
	}

	public final void setLanguage(final String language) {
		this.languageProperty().set(language);
	}

	public final StringProperty latitudeProperty() {
		return this.latitude;
	}

	public final String getLatitude() {
		return this.latitudeProperty().get();
	}

	public final void setLatitude(final String latitude) {
		this.latitudeProperty().set(latitude);
	}

	public final StringProperty longitudeProperty() {
		return this.longitude;
	}

	public final String getLongitude() {
		return this.longitudeProperty().get();
	}

	public final void setLongitude(final String longitude) {
		this.longitudeProperty().set(longitude);
	}

	public final StringProperty timeZoneProperty() {
		return this.timeZone;
	}

	public final String getTimeZone() {
		return this.timeZoneProperty().get();
	}

	public final void setTimeZone(final String timeZone) {
		this.timeZoneProperty().set(timeZone);
	}

	public final StringProperty zipCodeProperty() {
		return this.zipCode;
	}

	public final String getZipCode() {
		return this.zipCodeProperty().get();
	}

	public final void setZipCode(final String zipCode) {
		this.zipCodeProperty().set(zipCode);
	}
}
