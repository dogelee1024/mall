package com.macro.mall.common.api.dropshipping;

import java.util.List;

public class VariantInventory {
	/** 变体 ID（VID） */
	private String vid;

	/** 不同国家库存 */
	private List<VariantCountryInventory> inventory;

	public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}

	public List<VariantCountryInventory> getInventory() {
		return inventory;
	}

	public void setInventory(List<VariantCountryInventory> inventory) {
		this.inventory = inventory;
	}
}
