package com.wallissoftware.universalanalytics.shared.options;

import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;
import com.wallissoftware.universalanalytics.shared.options.OptionsCallback;
import com.wallissoftware.universalanalytics.shared.options.EnhancedEcommerceOptions;

public class EnhancedEcommerceOptions extends AnalyticsOptions {

	EnhancedEcommerceOptions(OptionsCallback<?> optionsCallback) {
		super(optionsCallback);
	}

	/**
* Optional.
* </p>
* <p>The SKU of the product. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>P12345</code>
**/
public EnhancedEcommerceOptions ProductSku(String ProductSku) {
putText("(product) id", ProductSku);
return this;
}

/**
* Optional.
* </p>
* <p>The name of the product. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>Android T-Shirt</code>
**/
public EnhancedEcommerceOptions ProductName(String ProductName) {
putText("(product) name", ProductName);
return this;
}

/**
* Optional.
* </p>
* <p>The brand associated with the product. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>Google</code>
**/
public EnhancedEcommerceOptions ProductBrand(String ProductBrand) {
putText("(product) brand", ProductBrand);
return this;
}

/**
* Optional.
* </p>
* <p>The category to which the product belongs. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>Apparel</code>
**/
public EnhancedEcommerceOptions ProductCategory(String ProductCategory) {
putText("(product) category", ProductCategory);
return this;
}

/**
* Optional.
* </p>
* <p>The variant of the product. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>Black</code>
**/
public EnhancedEcommerceOptions ProductVariant(String ProductVariant) {
putText("(product) variant", ProductVariant);
return this;
}

/**
* Optional.
* </p>
* <p>The price of a product. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>29.20</code>
**/
public EnhancedEcommerceOptions ProductPrice(String ProductPrice) {
putText("(product) price", ProductPrice);
return this;
}

/**
* Optional.
* </p>
* <p>The quantity of a product. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>2</code>
**/
public EnhancedEcommerceOptions ProductQuantity(int ProductQuantity) {
putNumber("(product) quantity", ProductQuantity);
return this;
}

/**
* Optional.
* </p>
* <p>The coupon code associated with a product. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>SUMMER_SALE13</code>
**/
public EnhancedEcommerceOptions ProductCouponCode(String ProductCouponCode) {
putText("(product) coupon", ProductCouponCode);
return this;
}

/**
* Optional.
* </p>
* <p>The product&#39;s position in a list or collection. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>2</code>
**/
public EnhancedEcommerceOptions ProductPosition(int ProductPosition) {
putNumber("(product) position", ProductPosition);
return this;
}

/**
* Optional.
* </p>
* <p>A product-level custom dimesion where index is a positive integer between 0 and 200. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>Member</code>
**/
public EnhancedEcommerceOptions ProductCustomDimension(String ProductCustomDimension) {
putText("(product) dimension", ProductCustomDimension);
return this;
}

/**
* Optional.
* </p>
* <p>A product-level custom metric where index is a positive integer between 0 and 200. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>28</code>
**/
public EnhancedEcommerceOptions ProductCustomMetric(int ProductCustomMetric) {
putNumber("(product) metric", ProductCustomMetric);
return this;
}

/**
* Optional.
* </p>
* <p>The role of the products included in a hit. If a product action is not specified, all product definitions included with the hit will be ignored. Must be one of: detail, click, add, remove, checkout, checkout_option, purchase, refund. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>detail</code>
**/
public EnhancedEcommerceOptions ProductAction(String ProductAction) {
putText("(product action)", ProductAction);
return this;
}

/**
* Optional.
* </p>
* <p>The transaction ID. This is an additional parameter that can be sent when Product Action is set to &#39;purchase&#39; or &#39;refund&#39;. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>T1234</code>
**/
public EnhancedEcommerceOptions TransactionId(String TransactionId) {
putText("(product action) id", TransactionId);
return this;
}

/**
* Optional.
* </p>
* <p>The store or affiliation from which this transaction occurred. This is an additional parameter that can be sent when Product Action is set to &#39;purchase&#39; or &#39;refund&#39;. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>Google Store</code>
**/
public EnhancedEcommerceOptions Affiliation(String Affiliation) {
putText("(product action) affiliation", Affiliation);
return this;
}

/**
* Optional.
* </p>
* <p>The total value of the transaction, including tax and shipping. If not sent, this value will be automatically calculated using the product quantity and price fields of all products in the same hit. This is an additional parameter that can be sent when Product Action is set to &#39;purchase&#39; or &#39;refund&#39;. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>123.21</code>
**/
public EnhancedEcommerceOptions Revenue(String Revenue) {
putText("(product action) revenue", Revenue);
return this;
}

/**
* Optional.
* </p>
* <p>The total tax associated with the transaction. This is an additional parameter that can be sent when Product Action is set to &#39;purchase&#39; or &#39;refund&#39;. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>10.78</code>
**/
public EnhancedEcommerceOptions Tax(String Tax) {
putText("(product action) tax", Tax);
return this;
}

/**
* Optional.
* </p>
* <p>The shipping cost associated with the transaction. This is an additional parameter that can be sent when Product Action is set to &#39;purchase&#39; or &#39;refund&#39;. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>3.55</code>
**/
public EnhancedEcommerceOptions Shipping(String Shipping) {
putText("(product action) shipping", Shipping);
return this;
}

/**
* Optional.
* </p>
* <p>The transaction coupon redeemed with the transaction. This is an additional parameter that can be sent when Product Action is set to &#39;purchase&#39; or &#39;refund&#39;. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>SUMMER08</code>
**/
public EnhancedEcommerceOptions CouponCode(String CouponCode) {
putText("(product action) coupon", CouponCode);
return this;
}

/**
* Optional.
* </p>
* <p>The list or collection from which a product action occurred. This is an additional parameter that can be sent when Product Action is set to &#39;detail&#39; or &#39;click&#39;. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>Search Results</code>
**/
public EnhancedEcommerceOptions ProductActionList(String ProductActionList) {
putText("(product action) list", ProductActionList);
return this;
}

/**
* Optional.
* </p>
* <p>The step number in a checkout funnel. This is an additional parameter that can be sent when Product Action is set to &#39;checkout&#39;. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>2</code>
**/
public EnhancedEcommerceOptions CheckoutStep(int CheckoutStep) {
putNumber("(product action) step", CheckoutStep);
return this;
}

/**
* Optional.
* </p>
* <p>Additional information about a checkout step. This is an additional parameter that can be sent when Product Action is set to &#39;checkout&#39;. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>Visa</code>
**/
public EnhancedEcommerceOptions CheckoutStepOption(String CheckoutStepOption) {
putText("(product action) option", CheckoutStepOption);
return this;
}

/**
* Optional.
* </p>
* <p>The list or collection to which a product belongs. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>Search Results</code>
**/
public EnhancedEcommerceOptions ProductImpressionListName(String ProductImpressionListName) {
putText("(impression) list", ProductImpressionListName);
return this;
}

/**
* Optional.
* </p>
* <p>The product ID or SKU. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>P67890</code>
**/
public EnhancedEcommerceOptions ProductImpressionSku(String ProductImpressionSku) {
putText("(impression) id", ProductImpressionSku);
return this;
}

/**
* Optional.
* </p>
* <p>The name of the product. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>Android T-Shirt</code>
**/
public EnhancedEcommerceOptions ProductImpressionName(String ProductImpressionName) {
putText("(impression) name", ProductImpressionName);
return this;
}

/**
* Optional.
* </p>
* <p>The brand associated with the product. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>Google</code>
**/
public EnhancedEcommerceOptions ProductImpressionBrand(String ProductImpressionBrand) {
putText("(impression) brand", ProductImpressionBrand);
return this;
}

/**
* Optional.
* </p>
* <p>The category to which the product belongs. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>Apparel</code>
**/
public EnhancedEcommerceOptions ProductImpressionCategory(String ProductImpressionCategory) {
putText("(impression) category", ProductImpressionCategory);
return this;
}

/**
* Optional.
* </p>
* <p>The variant of the product. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>Black</code>
**/
public EnhancedEcommerceOptions ProductImpressionVariant(String ProductImpressionVariant) {
putText("(impression) variant", ProductImpressionVariant);
return this;
}

/**
* Optional.
* </p>
* <p>The product&#39;s position in a list or collection. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>2</code>
**/
public EnhancedEcommerceOptions ProductImpressionPosition(int ProductImpressionPosition) {
putNumber("(impression) position", ProductImpressionPosition);
return this;
}

/**
* Optional.
* </p>
* <p>The price of a product. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>29.20</code>
**/
public EnhancedEcommerceOptions ProductImpressionPrice(String ProductImpressionPrice) {
putText("(impression) price", ProductImpressionPrice);
return this;
}

/**
* Optional.
* </p>
* <p>A product-level custom dimesion where index is a positive integer between 0 and 200. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>Member</code>
**/
public EnhancedEcommerceOptions ProductImpressionCustomDimension(String ProductImpressionCustomDimension) {
putText("(impression) dimension", ProductImpressionCustomDimension);
return this;
}

/**
* Optional.
* </p>
* <p>A product-level custom metric where index is a positive integer between 0 and 200. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>28</code>
**/
public EnhancedEcommerceOptions ProductImpressionCustomMetric(int ProductImpressionCustomMetric) {
putNumber("(impression) metric", ProductImpressionCustomMetric);
return this;
}

/**
* Optional.
* </p>
* <p>The promotion ID. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>SHIP</code>
**/
public EnhancedEcommerceOptions PromotionId(String PromotionId) {
putText("(promo) id", PromotionId);
return this;
}

/**
* Optional.
* </p>
* <p>The name of the promotion. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>Free Shipping</code>
**/
public EnhancedEcommerceOptions PromotionName(String PromotionName) {
putText("(promo) name", PromotionName);
return this;
}

/**
* Optional.
* </p>
* <p>The creative associated with the promotion. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>Shipping Banner</code>
**/
public EnhancedEcommerceOptions PromotionCreative(String PromotionCreative) {
putText("(promo) creative", PromotionCreative);
return this;
}

/**
* Optional.
* </p>
* <p>The position of the creative. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>banner_slot_1</code>
**/
public EnhancedEcommerceOptions PromotionPosition(String PromotionPosition) {
putText("(promo) position", PromotionPosition);
return this;
}

/**
* Optional.
* </p>
* <p>Specifies the role of the promotions included in a hit. If a promotion action is not specified, the default promotion action, &#39;view&#39;, is assumed. To measure a user click on a promotion set this to &#39;promo_click&#39;. For analytics.js the Enhanced Ecommerce plugin must be installed before using this field.</p>
* Default Value: None<br>
* Example Value: <code>click</code>
**/
public EnhancedEcommerceOptions PromotionAction(String PromotionAction) {
putText("(promo) action", PromotionAction);
return this;
}



}