package com.project.pojoclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.BaseClassDef;
import com.project.Action.ActionClassload;

public class PojoStepdef_03 extends BaseClassDef{

	public PojoStepdef_03() {
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//input[@placeholder=contains(text(),Search)]")
	private WebElement searchtextbox;
	
	@FindBy(className ="_4ddWXP")
	private List<WebElement> listProduct;
	
	@FindBy(xpath="//button[text()='✕']")
	private WebElement loginclose;
	
	@FindBy(className="s1Q9rs")
	private List<WebElement> tittleprod;
	
	@FindBy(className="s1Q9rs")
	private WebElement eachtittleprod;


	public List<WebElement> getTittleprod() {
		return tittleprod;
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
