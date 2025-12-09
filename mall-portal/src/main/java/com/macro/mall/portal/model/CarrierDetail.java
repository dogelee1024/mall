package com.macro.mall.portal.model;

import com.alibaba.fastjson.annotation.JSONField;

public class CarrierDetail {

	private String object;
	private String service;

	@JSONField(name = "container_type")
	private String containerType;

	@JSONField(name = "est_delivery_date_local")
	private String estDeliveryDateLocal;

	@JSONField(name = "est_delivery_time_local")
	private String estDeliveryTimeLocal;

	@JSONField(name = "origin_location")
	private String originLocation;

	@JSONField(name = "origin_tracking_location")
	private TrackingLocation originTrackingLocation;

	@JSONField(name = "destination_location")
	private String destinationLocation;

	@JSONField(name = "destination_tracking_location")
	private TrackingLocation destinationTrackingLocation;

	@JSONField(name = "guaranteed_delivery_date")
	private String guaranteedDeliveryDate;

	@JSONField(name = "alternate_identifier")
	private String alternateIdentifier;

	@JSONField(name = "initial_delivery_attempt")
	private String initialDeliveryAttempt;

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getContainerType() {
		return containerType;
	}

	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}

	public String getEstDeliveryDateLocal() {
		return estDeliveryDateLocal;
	}

	public void setEstDeliveryDateLocal(String estDeliveryDateLocal) {
		this.estDeliveryDateLocal = estDeliveryDateLocal;
	}

	public String getEstDeliveryTimeLocal() {
		return estDeliveryTimeLocal;
	}

	public void setEstDeliveryTimeLocal(String estDeliveryTimeLocal) {
		this.estDeliveryTimeLocal = estDeliveryTimeLocal;
	}

	public String getOriginLocation() {
		return originLocation;
	}

	public void setOriginLocation(String originLocation) {
		this.originLocation = originLocation;
	}

	public TrackingLocation getOriginTrackingLocation() {
		return originTrackingLocation;
	}

	public void setOriginTrackingLocation(TrackingLocation originTrackingLocation) {
		this.originTrackingLocation = originTrackingLocation;
	}

	public String getDestinationLocation() {
		return destinationLocation;
	}

	public void setDestinationLocation(String destinationLocation) {
		this.destinationLocation = destinationLocation;
	}

	public TrackingLocation getDestinationTrackingLocation() {
		return destinationTrackingLocation;
	}

	public void setDestinationTrackingLocation(TrackingLocation destinationTrackingLocation) {
		this.destinationTrackingLocation = destinationTrackingLocation;
	}

	public String getGuaranteedDeliveryDate() {
		return guaranteedDeliveryDate;
	}

	public void setGuaranteedDeliveryDate(String guaranteedDeliveryDate) {
		this.guaranteedDeliveryDate = guaranteedDeliveryDate;
	}

	public String getAlternateIdentifier() {
		return alternateIdentifier;
	}

	public void setAlternateIdentifier(String alternateIdentifier) {
		this.alternateIdentifier = alternateIdentifier;
	}

	public String getInitialDeliveryAttempt() {
		return initialDeliveryAttempt;
	}

	public void setInitialDeliveryAttempt(String initialDeliveryAttempt) {
		this.initialDeliveryAttempt = initialDeliveryAttempt;
	}
}
