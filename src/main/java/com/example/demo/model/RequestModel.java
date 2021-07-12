package com.example.demo.model;

public class RequestModel {
    public String image_url;
    public RequestModel() {
    	
    }
	public RequestModel(String image_url) {
		super();
		this.image_url = image_url;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

}
