package com.macro.mall.common.api.dropshipping;

public class AccessToken {

	private Long openId;
	private String accessToken;
	private String refreshToken;
	private String accessTokenExpiryDate;
	private String refreshTokenExpiryDate;
	private String createDate;
/*	  "openId": 123456789,
		  "accessToken": "f59ac98193d64d62a9e887abea830369",
		  "accessTokenExpiryDate": "2021-08-18T09:16:33+08:00",
		  "refreshToken": "f7edabe65c3b4a198b50ca8f969e36eb",
		  "refreshTokenExpiryDate": "2022-02-07T09:16:33+08:00",
		  "createDate": "2021-08-11T09:16:33+08:00"*/

	public Long getOpenId() {
		return openId;
	}

	public void setOpenId(Long openId) {
		this.openId = openId;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getAccessTokenExpiryDate() {
		return accessTokenExpiryDate;
	}

	public void setAccessTokenExpiryDate(String accessTokenExpiryDate) {
		this.accessTokenExpiryDate = accessTokenExpiryDate;
	}

	public String getRefreshTokenExpiryDate() {
		return refreshTokenExpiryDate;
	}

	public void setRefreshTokenExpiryDate(String refreshTokenExpiryDate) {
		this.refreshTokenExpiryDate = refreshTokenExpiryDate;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
}
