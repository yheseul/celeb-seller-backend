package com.shop.shop.dto;

public class AddFavoriteItem {
    private int productId;
    private String email;

    public AddFavoriteItem(int productId, String email) {
        this.productId = productId;
        this.email = email;
    }

    public AddFavoriteItem() {
        super();
    }

    @Override
    public String toString() {
        return "Cart [productId=" + productId + ", email=" + email + "]";
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
    
    public String getEmail() {
		return email;
	}
    
	public void setEmail(String email) {
		this.email = email;
	}
    
}
