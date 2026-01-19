package com.macro.mall.common.api.dropshipping;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {

    private String id;
    private String nameEn;
    private String sku;
    private String spu;
    private String bigImage;

    private String sellPrice;
    private String nowPrice;
    private String discountPrice;
    private String discountPriceRate;

    private Integer listedNum;
    private Integer warehouseInventoryNum;
    private Integer totalVerifiedInventory;
    private Integer totalUnVerifiedInventory;
    private Integer verifiedWarehouse;

    private String categoryId;
    private String threeCategoryName;
    private String twoCategoryId;
    private String twoCategoryName;
    private String oneCategoryId;
    private String oneCategoryName;

    private Integer addMarkStatus;
    private Integer isVideo;
    private List<String> videoList;

    private String productType;
    private String supplierName;

    private Long createAt;

    private Integer customization;
    private Integer hasCECertification;
    private Integer isCollect;
    private Boolean myProduct;

    private String currency;
    private String description;
    private String deliveryCycle;

    private String saleStatus;
    private String authorityStatus;
    private Integer isPersonalized;
    private String inventoryInfo;
    private String countryCode;

    // getter & setter（可由 IDE 自动生成）


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getSpu() {
        return spu;
    }

    public void setSpu(String spu) {
        this.spu = spu;
    }

    public String getBigImage() {
        return bigImage;
    }

    public void setBigImage(String bigImage) {
        this.bigImage = bigImage;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getNowPrice() {
        return nowPrice;
    }

    public void setNowPrice(String nowPrice) {
        this.nowPrice = nowPrice;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getDiscountPriceRate() {
        return discountPriceRate;
    }

    public void setDiscountPriceRate(String discountPriceRate) {
        this.discountPriceRate = discountPriceRate;
    }

    public Integer getListedNum() {
        return listedNum;
    }

    public void setListedNum(Integer listedNum) {
        this.listedNum = listedNum;
    }

    public Integer getWarehouseInventoryNum() {
        return warehouseInventoryNum;
    }

    public void setWarehouseInventoryNum(Integer warehouseInventoryNum) {
        this.warehouseInventoryNum = warehouseInventoryNum;
    }

    public Integer getTotalVerifiedInventory() {
        return totalVerifiedInventory;
    }

    public void setTotalVerifiedInventory(Integer totalVerifiedInventory) {
        this.totalVerifiedInventory = totalVerifiedInventory;
    }

    public Integer getTotalUnVerifiedInventory() {
        return totalUnVerifiedInventory;
    }

    public void setTotalUnVerifiedInventory(Integer totalUnVerifiedInventory) {
        this.totalUnVerifiedInventory = totalUnVerifiedInventory;
    }

    public Integer getVerifiedWarehouse() {
        return verifiedWarehouse;
    }

    public void setVerifiedWarehouse(Integer verifiedWarehouse) {
        this.verifiedWarehouse = verifiedWarehouse;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getThreeCategoryName() {
        return threeCategoryName;
    }

    public void setThreeCategoryName(String threeCategoryName) {
        this.threeCategoryName = threeCategoryName;
    }

    public String getTwoCategoryId() {
        return twoCategoryId;
    }

    public void setTwoCategoryId(String twoCategoryId) {
        this.twoCategoryId = twoCategoryId;
    }

    public String getTwoCategoryName() {
        return twoCategoryName;
    }

    public void setTwoCategoryName(String twoCategoryName) {
        this.twoCategoryName = twoCategoryName;
    }

    public String getOneCategoryId() {
        return oneCategoryId;
    }

    public void setOneCategoryId(String oneCategoryId) {
        this.oneCategoryId = oneCategoryId;
    }

    public String getOneCategoryName() {
        return oneCategoryName;
    }

    public void setOneCategoryName(String oneCategoryName) {
        this.oneCategoryName = oneCategoryName;
    }

    public Integer getAddMarkStatus() {
        return addMarkStatus;
    }

    public void setAddMarkStatus(Integer addMarkStatus) {
        this.addMarkStatus = addMarkStatus;
    }

    public Integer getIsVideo() {
        return isVideo;
    }

    public void setIsVideo(Integer isVideo) {
        this.isVideo = isVideo;
    }

    public List<String> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<String> videoList) {
        this.videoList = videoList;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Integer getCustomization() {
        return customization;
    }

    public void setCustomization(Integer customization) {
        this.customization = customization;
    }

    public Integer getHasCECertification() {
        return hasCECertification;
    }

    public void setHasCECertification(Integer hasCECertification) {
        this.hasCECertification = hasCECertification;
    }

    public Integer getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(Integer isCollect) {
        this.isCollect = isCollect;
    }

    public Boolean getMyProduct() {
        return myProduct;
    }

    public void setMyProduct(Boolean myProduct) {
        this.myProduct = myProduct;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeliveryCycle() {
        return deliveryCycle;
    }

    public void setDeliveryCycle(String deliveryCycle) {
        this.deliveryCycle = deliveryCycle;
    }

    public String getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(String saleStatus) {
        this.saleStatus = saleStatus;
    }

    public String getAuthorityStatus() {
        return authorityStatus;
    }

    public void setAuthorityStatus(String authorityStatus) {
        this.authorityStatus = authorityStatus;
    }

    public Integer getIsPersonalized() {
        return isPersonalized;
    }

    public void setIsPersonalized(Integer isPersonalized) {
        this.isPersonalized = isPersonalized;
    }

    public String getInventoryInfo() {
        return inventoryInfo;
    }

    public void setInventoryInfo(String inventoryInfo) {
        this.inventoryInfo = inventoryInfo;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
