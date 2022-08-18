package com.project.pojoclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.BaseClassDef;
import com.project.Action.ActionClassload;

public class PojoStepdef_03 extends BaseClassDef {

	public PojoStepdef_03() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder=contains(text(),Search)]")
	private WebElement searchtextbox;

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div")
	private List<WebElement> listProduct;

	@FindBy(xpath = "//button[starts-with(@class,\"_2KpZ6l _2doB4z\")]")
	private WebElement loginclose;

	@FindBy(className= "_4rR01T")
	private List<WebElement> tittleprod;

	@FindBy(className = "s1Q9rs")
	private WebElement eachtittleprod;

	@FindBy(className = "_30jeq3")
	private List<WebElement> pricetag;

	public List<WebElement> getTittleprod() {
		return tittleprod;
	}

	public List<WebElement> getPricetag() {
		return pricetag;
	}

	public void setPricetag(List<WebElement> pricetag) {
		this.pricetag = pricetag;
	}

	public WebElement getEachtittleprod() {
		return eachtittleprod;
	}

	public WebElement getLoginclose() {
		return loginclose;
	}

	public WebElement getSearchtextbox() {
		return searchtextbox;
	}

	public List<WebElement> getListProduct() {
		return listProduct;
	}

}
