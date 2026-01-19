package com.macro.mall.common.api.dropshipping;

import java.io.Serializable;
import java.util.List;

public class ContentItem implements Serializable {

    private List<Product> productList;
    private List<RelatedCategory> relatedCategoryList;
    private String keyWord;
    private String keyWordOld;

    // getter & setter
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<RelatedCategory> getRelatedCategoryList() {
        return relatedCategoryList;
    }

    public void setRelatedCategoryList(List<RelatedCategory> relatedCategoryList) {
        this.relatedCategoryList = relatedCategoryList;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getKeyWordOld() {
        return keyWordOld;
    }

    public void setKeyWordOld(String keyWordOld) {
        this.keyWordOld = keyWordOld;
    }
}
