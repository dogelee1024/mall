package com.macro.mall.portal.model;

import com.alibaba.fastjson.annotation.JSONField;

public class TrackerBo {

	@JSONField(name = "tracking_code")
	private String trackingCode;

	private String carrier;

	public String getTrackingCode() {
		return trackingCode;
	}

	public void setTrackingCode(String trackingCode) {
		this.trackingCode = trackingCode;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
}
