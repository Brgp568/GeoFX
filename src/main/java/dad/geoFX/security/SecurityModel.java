package dad.geoFX.security;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SecurityModel {

	private BooleanProperty crawlerDetected;

	private StringProperty potentialThreatTypes;

	private BooleanProperty proxyDetected;

	private StringProperty securityMessage;

	private StringProperty threatLevel;

	private BooleanProperty torDetected;

	public SecurityModel() {
		crawlerDetected = new SimpleBooleanProperty(false);
		potentialThreatTypes = new SimpleStringProperty();
		proxyDetected = new SimpleBooleanProperty(false);
		securityMessage = new SimpleStringProperty();
		threatLevel = new SimpleStringProperty();
		torDetected = new SimpleBooleanProperty();
	}

	public final BooleanProperty crawlerDetectedProperty() {
		return this.crawlerDetected;
	}

	public final boolean isCrawlerDetected() {
		return this.crawlerDetectedProperty().get();
	}

	public final void setCrawlerDetected(final boolean crawlerDetected) {
		this.crawlerDetectedProperty().set(crawlerDetected);
	}

	public final StringProperty potentialThreatTypesProperty() {
		return this.potentialThreatTypes;
	}

	public final String getPotentialThreatTypes() {
		return this.potentialThreatTypesProperty().get();
	}

	public final void setPotentialThreatTypes(final String potentialThreatTypes) {
		this.potentialThreatTypesProperty().set(potentialThreatTypes);
	}

	public final BooleanProperty proxyDetectedProperty() {
		return this.proxyDetected;
	}

	public final boolean isProxyDetected() {
		return this.proxyDetectedProperty().get();
	}

	public final void setProxyDetected(final boolean proxyDetected) {
		this.proxyDetectedProperty().set(proxyDetected);
	}

	public final StringProperty securityMessageProperty() {
		return this.securityMessage;
	}

	public final String getSecurityMessage() {
		return this.securityMessageProperty().get();
	}

	public final void setSecurityMessage(final String securityMessage) {
		this.securityMessageProperty().set(securityMessage);
	}

	public final StringProperty threatLevelProperty() {
		return this.threatLevel;
	}

	public final String getThreatLevel() {
		return this.threatLevelProperty().get();
	}

	public final void setThreatLevel(final String threatLevel) {
		this.threatLevelProperty().set(threatLevel);
	}

	public final BooleanProperty torDetectedProperty() {
		return this.torDetected;
	}

	public final boolean isTorDetected() {
		return this.torDetectedProperty().get();
	}

	public final void setTorDetected(final boolean torDetected) {
		this.torDetectedProperty().set(torDetected);
	}
}
