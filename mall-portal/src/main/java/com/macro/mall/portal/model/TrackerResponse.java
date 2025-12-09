package com.macro.mall.portal.model;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;

public class TrackerResponse {
	private String id;
	private String object;
	private String mode;

	@JSONField(name = "tracking_code")
	private String trackingCode;

	private String status;

	@JSONField(name = "status_detail")
	private String statusDetail;

	@JSONField(name = "created_at")
	private String createdAt;

	@JSONField(name = "updated_at")
	private String updatedAt;

	@JSONField(name = "signed_by")
	private String signedBy;

	private Double weight;

	@JSONField(name = "est_delivery_date")
	private String estDeliveryDate;

	@JSONField(name = "shipment_id")
	private String shipmentId;

	private String carrier;

	@JSONField(name = "tracking_details")
	private List<TrackingDetail> trackingDetails;

	@JSONField(name = "carrier_detail")
	private CarrierDetail carrierDetail;

	private Boolean finalized;

	@JSONField(name = "is_return")
	private Boolean isReturn;

	@JSONField(name = "public_url")
	private String publicUrl;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getTrackingCode() {
		return trackingCode;
	}

	public void setTrackingCode(String trackingCode) {
		this.trackingCode = trackingCode;
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

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getSignedBy() {
		return signedBy;
	}

	public void setSignedBy(String signedBy) {
		this.signedBy = signedBy;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getEstDeliveryDate() {
		return estDeliveryDate;
	}

	public void setEstDeliveryDate(String estDeliveryDate) {
		this.estDeliveryDate = estDeliveryDate;
	}

	public String getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public List<TrackingDetail> getTrackingDetails() {
		return trackingDetails;
	}

	public void setTrackingDetails(List<TrackingDetail> trackingDetails) {
		this.trackingDetails = trackingDetails;
	}

	public CarrierDetail getCarrierDetail() {
		return carrierDetail;
	}

	public void setCarrierDetail(CarrierDetail carrierDetail) {
		this.carrierDetail = carrierDetail;
	}

	public Boolean getFinalized() {
		return finalized;
	}

	public void setFinalized(Boolean finalized) {
		this.finalized = finalized;
	}

	public Boolean getReturn() {
		return isReturn;
	}

	public void setReturn(Boolean aReturn) {
		isReturn = aReturn;
	}

	public String getPublicUrl() {
		return publicUrl;
	}

	public void setPublicUrl(String publicUrl) {
		this.publicUrl = publicUrl;
	}
}
