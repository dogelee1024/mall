package com.macro.mall.portal.model;

import java.util.List;

public class RequestDeleteCartItem {
	private List<Long> ids;

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}
}
