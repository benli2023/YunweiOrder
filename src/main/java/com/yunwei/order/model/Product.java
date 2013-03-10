package com.yunwei.order.model;

import cn.org.rapid_framework.util.DateConvertUtils;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.github.springrest.base.BaseEntity;

public class Product extends BaseEntity
  implements Serializable
{
  private static final long serialVersionUID = 5454155825314635342L;
  public static final String DEFAULT_FILE_UPLOAD_DIR = "fileUpload/productInfo";
  public static final String TABLE_ALIAS = "Product";
  public static final String ALIAS_PRODUCT_ID = "productId";
  public static final String ALIAS_CAT_ID = "产品分类";
  public static final String ALIAS_PRODUCT_NAME = "产品名称";
  public static final String ALIAS_PRODUCT_CODE = "产品编码";
  public static final String ALIAS_CEIL_LIMIT = "库存上限";
  public static final String ALIAS_LOW_LIMIT = "库存下限";
  public static final String ALIAS_PINY_CODE = "拼音编码";
  public static final String ALIAS_PRODUCT_SPEC = "规格型号";
  public static final String ALIAS_SALE_PRICE = "预设售价";
  public static final String ALIAS_PURCHASE_PRICE = "预设进价";
  public static final String ALIAS_IS_AVAILABLE = "是否有效";
  public static final String ALIAS_IS_SELLABLE = "是否可卖";
  public static final String ALIAS_IS_NEGATIVE = "是否允许负库存";
  public static final String ALIAS_IS_PURCHASABLE = "是否允许采购";
  public static final String ALIAS_PRODUCT_IMAGE = "产品图片";
  public static final String ALIAS_MANUFACTURER = "生产商";
  public static final String ALIAS_ORGINAL_PLACE = "产地";
  public static final String ALIAS_CTIME = "创建时间";
  public static final String FORMAT_CTIME = "yyyy-MM-dd HH:mm:ss";
  private Long productId;
  private Long catId;
  private String catIdTxt;

  @Length(max=64)
  @NotEmpty
  private String productName;

  @Length(max=64)
  @NotEmpty
  private String productCode;
  private Integer ceilLimit;
  private Integer lowLimit;

  @Length(max=64)
  private String pinyCode;

  @Length(max=64)
  private String productSpec;
  private BigDecimal salePrice;
  private BigDecimal purchasePrice;
  private int isAvailable;
  private int isSellable;
  private int isNegative;
  private int isPurchasable;

  @Length(max=256)
  private String productImage;
  private MultipartFile productImageFile;

  @Length(max=256)
  private String manufacturer;

  @Length(max=256)
  private String orginalPlace;
  private Date ctime;

  public String getCatIdTxt()
  {
    return this.catIdTxt;
  }

  public Product setFlag(int flag) {
    this.isAvailable = flag;
    this.isNegative = flag;
    this.isPurchasable = flag;
    this.isSellable = flag;
    return this;
  }

  public void setCatIdTxt(String catIdTxt) {
    this.catIdTxt = catIdTxt;
  }

  public Product()
  {
  }

  public Product(Long productId)
  {
    this.productId = productId;
  }

  public void setProductId(Long value) {
    this.productId = value;
  }

  public Long getProductId() {
    return this.productId;
  }
  public void setCatId(Long value) {
    this.catId = value;
  }

  public Long getCatId() {
    return this.catId;
  }
  public void setProductName(String value) {
    this.productName = value;
  }

  public String getProductName() {
    return this.productName;
  }
  public void setProductCode(String value) {
    this.productCode = value;
  }

  public String getProductCode() {
    return this.productCode;
  }
  public void setCeilLimit(Integer value) {
    this.ceilLimit = value;
  }

  public Integer getCeilLimit() {
    return this.ceilLimit;
  }
  public void setLowLimit(Integer value) {
    this.lowLimit = value;
  }

  public Integer getLowLimit() {
    return this.lowLimit;
  }
  public void setPinyCode(String value) {
    this.pinyCode = value;
  }

  public String getPinyCode() {
    return this.pinyCode;
  }
  public void setProductSpec(String value) {
    this.productSpec = value;
  }

  public String getProductSpec() {
    return this.productSpec;
  }

  public BigDecimal getSalePrice()
  {
    return this.salePrice;
  }

  public void setSalePrice(BigDecimal salePrice) {
    this.salePrice = salePrice;
  }

  public BigDecimal getPurchasePrice() {
    return this.purchasePrice;
  }

  public void setPurchasePrice(BigDecimal purchasePrice) {
    this.purchasePrice = purchasePrice;
  }

  public void setProductImage(String value) {
    this.productImage = value;
  }

  public String getProductImage() {
    return this.productImage;
  }
  public void setManufacturer(String value) {
    this.manufacturer = value;
  }

  public String getManufacturer() {
    return this.manufacturer;
  }
  public void setOrginalPlace(String value) {
    this.orginalPlace = value;
  }

  public String getOrginalPlace() {
    return this.orginalPlace;
  }
  public String getCtimeString() {
    return DateConvertUtils.format(getCtime(), "yyyy-MM-dd HH:mm:ss");
  }
  public void setCtimeString(String value) {
    setCtime(DateConvertUtils.parse(value, "yyyy-MM-dd HH:mm:ss", Date.class));
  }

  public void setCtime(Date value) {
    this.ctime = value;
  }

  public Date getCtime() {
    return this.ctime;
  }

  public int getIsAvailable()
  {
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

  public MultipartFile getProductImageFile() {
    return this.productImageFile;
  }

  public void setProductImageFile(MultipartFile productImageFile) {
    this.productImageFile = productImageFile;
  }

  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
      .append("ProductId", getProductId())
      .append("CatId", getCatId())
      .append("ProductName", getProductName())
      .append("ProductCode", getProductCode())
      .append("CeilLimit", getCeilLimit())
      .append("LowLimit", getLowLimit())
      .append("PinyCode", getPinyCode())
      .append("ProductSpec", getProductSpec())
      .append("SalePrice", getSalePrice())
      .append("PurchasePrice", getPurchasePrice())
      .append("IsAvailable", getIsAvailable())
      .append("IsSellable", getIsSellable())
      .append("IsNegative", getIsNegative())
      .append("IsPurchasable", getIsPurchasable())
      .append("ProductImage", getProductImage())
      .append("Manufacturer", getManufacturer())
      .append("OrginalPlace", getOrginalPlace())
      .append("Ctime", getCtime())
      .toString();
  }

  public int hashCode() {
    return new HashCodeBuilder()
      .append(getProductId())
      .toHashCode();
  }

  public boolean equals(Object obj) {
    if (!(obj instanceof Product)) return false;
    if (this == obj) return true;
    Product other = (Product)obj;
    return new EqualsBuilder()
      .append(getProductId(), other.getProductId())
      .isEquals();
  }
}