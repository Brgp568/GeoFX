package dad.geoFX.connection;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ConnectionModel {

	private StringProperty asn;

	private StringProperty hostname;

	private StringProperty ip;

	private StringProperty registeredIsp;

	private StringProperty type;

	public ConnectionModel() {
		asn = new SimpleStringProperty();
		hostname = new SimpleStringProperty();
		ip = new SimpleStringProperty();
		registeredIsp = new SimpleStringProperty();
		type = new SimpleStringProperty();
	}

	public final StringProperty asnProperty() {
		return this.asn;
	}

	public final String getAsn() {
		return this.asnProperty().get();
	}

	public final void setAsn(final String asn) {
		this.asnProperty().set(asn);
	}

	public final StringProperty hostnameProperty() {
		return this.hostname;
	}

	public final String getHostname() {
		return this.hostnameProperty().get();
	}

	public final void setHostname(final String hostname) {
		this.hostnameProperty().set(hostname);
	}

	public final StringProperty ipProperty() {
		return this.ip;
	}

	public final String getIp() {
		return this.ipProperty().get();
	}

	public final void setIp(final String ip) {
		this.ipProperty().set(ip);
	}

	public final StringProperty registeredIspProperty() {
		return this.registeredIsp;
	}

	public final String getRegisteredIsp() {
		return this.registeredIspProperty().get();
	}

	public final void setRegisteredIsp(final String registeredIsp) {
		this.registeredIspProperty().set(registeredIsp);
	}

	public final StringProperty typeProperty() {
		return this.type;
	}

	public final String getType() {
		return this.typeProperty().get();
	}

	public final void setType(final String type) {
		this.typeProperty().set(type);
	}
}
