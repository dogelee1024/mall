package com.macro.mall.common.api.dropshipping;

import java.io.Serializable;

public class RelatedCategory implements Serializable {

    private String categoryId;
    private String categoryName;

    // getter & setter
    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
