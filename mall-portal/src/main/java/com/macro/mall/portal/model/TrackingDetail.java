package com.macro.mall.portal.model;

import com.alibaba.fastjson.annotation.JSONField;

public class TrackingDetail {

	private String object;
	private String message;
	private String description;
	private String status;

	@JSONField(name = "status_detail")
	private String statusDetail;

	private String datetime;
	private String source;

	@JSONField(name = "carrier_code")
	private String carrierCode;

	@JSONField(name = "tracking_location")
	private TrackingLocation trackingLocation;

	@JSONField(name = "est_delivery_date")
	private String estDeliveryDate;

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusDetail() {
		return statusDetail;
	}

	public void setStatusDetail(String statusDetail) {
		this.statusDetail = statusDetail;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getCarrierCode() {
		return carrierCode;
	}

	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}

	public TrackingLocation getTrackingLocation() {
		return trackingLocation;
	}

	public void setTrackingLocation(TrackingLocation trackingLocation) {
		this.trackingLocation = trackingLocation;
	}

	public String getEstDeliveryDate() {
		return estDeliveryDate;
	}

	public void setEstDeliveryDate(String estDeliveryDate) {
		this.estDeliveryDate = estDeliveryDate;
	}
}
