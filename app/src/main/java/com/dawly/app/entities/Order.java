package com.dawly.app.entities;

import com.dawly.app.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "item_country",
        "item_name",
        "item_weight",
        "item_link",
        "item_pic",
        "order_want_date",
        "order_shopper_id",
        "order_traveller_id",
        "order_status",
        "created_at",
        "updated_at"
})
public class Order extends BaseEntity {




        @JsonProperty("id")
        private Integer id;
        @JsonProperty("item_country")
        private String itemCountry;
        @JsonProperty("item_name")
        private String itemName;
        @JsonProperty("item_weight")
        private String itemWeight;
        @JsonProperty("item_link")
        private String itemLink;
        @JsonProperty("item_pic")
        private String itemPic;
        @JsonProperty("order_want_date")
        private String orderWantDate;
        @JsonProperty("order_shopper_id")
        private Integer orderShopperId;
        @JsonProperty("order_traveller_id")
        private Integer orderTravellerId;
        @JsonProperty("order_status")
        private String orderStatus;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updatedAt;

        @JsonProperty("id")
        public Integer getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(Integer id) {
            this.id = id;
        }

        @JsonProperty("item_country")
        public String getItemCountry() {
            return itemCountry;
        }

        @JsonProperty("item_country")
        public void setItemCountry(String itemCountry) {
            this.itemCountry = itemCountry;
        }

        @JsonProperty("item_name")
        public String getItemName() {
            return itemName;
        }

        @JsonProperty("item_name")
        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        @JsonProperty("item_weight")
        public String getItemWeight() {
            return itemWeight;
        }

        @JsonProperty("item_weight")
        public void setItemWeight(String itemWeight) {
            this.itemWeight = itemWeight;
        }

        @JsonProperty("item_link")
        public String getItemLink() {
            return itemLink;
        }

        @JsonProperty("item_link")
        public void setItemLink(String itemLink) {
            this.itemLink = itemLink;
        }

        @JsonProperty("item_pic")
        public String getItemPic() {
            return itemPic;
        }

        @JsonProperty("item_pic")
        public void setItemPic(String itemPic) {
            this.itemPic = itemPic;
        }

        @JsonProperty("order_want_date")
        public String getOrderWantDate() {
            return orderWantDate;
        }

        @JsonProperty("order_want_date")
        public void setOrderWantDate(String orderWantDate) {
            this.orderWantDate = orderWantDate;
        }

        @JsonProperty("order_shopper_id")
        public Integer getOrderShopperId() {
            return orderShopperId;
        }

        @JsonProperty("order_shopper_id")
        public void setOrderShopperId(Integer orderShopperId) {
            this.orderShopperId = orderShopperId;
        }

        @JsonProperty("order_traveller_id")
        public Integer getOrderTravellerId() {
            return orderTravellerId;
        }

        @JsonProperty("order_traveller_id")
        public void setOrderTravellerId(Integer orderTravellerId) {
            this.orderTravellerId = orderTravellerId;
        }

        @JsonProperty("order_status")
        public String getOrderStatus() {
            return orderStatus;
        }

        @JsonProperty("order_status")
        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        @JsonProperty("created_at")
        public String getCreatedAt() {
            return createdAt;
        }

        @JsonProperty("created_at")
        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        @JsonProperty("updated_at")
        public String getUpdatedAt() {
            return updatedAt;
        }

        @JsonProperty("updated_at")
        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }


}
