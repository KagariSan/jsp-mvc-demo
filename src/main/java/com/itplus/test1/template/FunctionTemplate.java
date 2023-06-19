package com.itplus.test1.template;

public class FunctionTemplate {
	public boolean isADD;
	public boolean isEDIT;
	
	public void displayForm() {
		this.isADD = false;
		this.isEDIT = false;
	}
	
	public void changeStateAdd() {
		this.isADD = true;
		this.isEDIT = false;
	}
	
	public void changeStateEdit() {
		this.isEDIT = true;
		this.isADD = false;
	}
	
	public void handCancel() {
		this.isADD = false;
		this.isEDIT = false;
	}
}
