package com.yunwei.order.vo.query;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.github.springrest.base.BaseQuery;

public class ProductQuery extends BaseQuery
  implements Serializable
{
  private static final long serialVersionUID = 3148176768559230877L;
  private Long productId;
  private Long catId;
  private String catIdTxt;
  private String productName;
  private String productCode;
  private Integer ceilLimit;
  private Integer lowLimit;
  private String pinyCode;
  private String productSpec;
  private Long salePrice;
  private Long purchasePrice;
  private int isAvailable = -1;

  private int isSellable = -1;

  private int isNegative = -1;

  private int isPurchasable = -1;
  private String productImage;
  private String manufacturer;
  private String orginalPlace;
  private Date ctimeBegin;
  private Date ctimeEnd;

  public Long getProductId()
  {
    return this.productId;
  }

  public void setProductId(Long value) {
    this.productId = value;
  }

  public Long getCatId() {
    return this.catId;
  }

  public void setCatId(Long value) {
    this.catId = value;
  }

  public String getProductName() {
    return this.productName;
  }

  public void setProductName(String value) {
    this.productName = value;
  }

  public String getProductCode() {
    return this.productCode;
  }

  public void setProductCode(String value) {
    this.productCode = value;
  }

  public Integer getCeilLimit() {
    return this.ceilLimit;
  }

  public void setCeilLimit(Integer value) {
    this.ceilLimit = value;
  }

  public Integer getLowLimit() {
    return this.lowLimit;
  }

  public void setLowLimit(Integer value) {
    this.lowLimit = value;
  }

  public String getPinyCode() {
    return this.pinyCode;
  }

  public void setPinyCode(String value) {
    this.pinyCode = value;
  }

  public String getProductSpec() {
    return this.productSpec;
  }

  public void setProductSpec(String value) {
    this.productSpec = value;
  }

  public Long getSalePrice() {
    return this.salePrice;
  }

  public void setSalePrice(Long value) {
    this.salePrice = value;
  }

  public Long getPurchasePrice() {
    return this.purchasePrice;
  }

  public void setPurchasePrice(Long value) {
    this.purchasePrice = value;
  }

  public int getIsAvailable() {
    return this.isAvailable;
  }

  public void setIsAvailable(int isAvailable) {
    this.isAvailable = isAvailable;
  }

  public int getIsSellable() {
    return this.isSellable;
  }

  public void setIsSellable(int isSellable) {
    this.isSellable = isSellable;
  }

  public int getIsNegative() {
    return this.isNegative;
  }

  public void setIsNegative(int isNegative) {
    this.isNegative = isNegative;
  }

  public int getIsPurchasable() {
    return this.isPurchasable;
  }

  public void setIsPurchasable(int isPurchasable) {
    this.isPurchasable = isPurchasable;
  }

  public String getProductImage() {
    return this.productImage;
  }

  public void setProductImage(String value) {
    this.productImage = value;
  }

  public String getManufacturer() {
    return this.manufacturer;
  }

  public void setManufacturer(String value) {
    this.manufacturer = value;
  }

  public String getOrginalPlace() {
    return this.orginalPlace;
  }

  public void setOrginalPlace(String value) {
    this.orginalPlace = value;
  }

  public Date getCtimeBegin() {
    return this.ctimeBegin;
  }

  public void setCtimeBegin(Date value) {
    this.ctimeBegin = value;
  }

  public Date getCtimeEnd() {
    return this.ctimeEnd;
  }

  public void setCtimeEnd(Date value) {
    this.ctimeEnd = value;
  }
  public String getCatIdTxt() {
	return catIdTxt;
}

public void setCatIdTxt(String catIdTxt) {
	this.catIdTxt = catIdTxt;
}

public String toString()
  {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
}