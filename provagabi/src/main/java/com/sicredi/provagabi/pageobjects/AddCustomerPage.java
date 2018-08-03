package com.sicredi.provagabi.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCustomerPage {
	protected WebDriver driver;
	protected WebDriverWait wait;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
	}

	public void preencherName(String name){
		driver.findElement(By.id("field-customerName")).sendKeys(name);
	}
	
	public void preencherLastName(String lastName){
		driver.findElement(By.id("field-contactLastName")).sendKeys(lastName);
	}
	
	public void preencherContactFirstName(String firstName){
		driver.findElement(By.id("field-contactFirstName")).sendKeys(firstName);
	}
	
	public void preencherPhone(String phone){
		driver.findElement(By.id("field-phone")).sendKeys(phone);
	}
	
	public void preencherAddressLine1(String address1){
		driver.findElement(By.id("field-addressLine1")).sendKeys(address1);
	}
	
	public void preencherAddressLine2(String address2){
		driver.findElement(By.id("field-addressLine2")).sendKeys(address2);
	}
	
	public void preencherCity(String city){
		driver.findElement(By.id("field-city")).sendKeys(city);
	}
	
	public void preencherState(String state){
		driver.findElement(By.id("field-state")).sendKeys(state);
	}
	
	public void preencherPostalCode(String code){
		driver.findElement(By.id("field-postalCode")).sendKeys(code);
	}
	
	public void preencherCountry(String country){
		driver.findElement(By.id("field-country")).sendKeys(country);
	}
	
	public void selecionarFromEmployeer(String employeer){
		driver.findElement(By.cssSelector("#field_salesRepEmployeeNumber_chosen > a")).click();
		driver.findElement(By.cssSelector("#field_salesRepEmployeeNumber_chosen > div > div > input[type=\"text\"]")).sendKeys(employeer);
		driver.findElement(By.cssSelector("#field_salesRepEmployeeNumber_chosen > div > div > input[type=\"text\"]")).sendKeys(Keys.ENTER);
	}
	
	public void preencherCreditLimit(String limit){
		driver.findElement(By.id("field-creditLimit")).sendKeys(limit);
	}
	
	public void clicarGoBackToList(){
		driver.findElement(By.cssSelector("#report-success > p > a:nth-child(2)")).click();
	}
	
	public void clicarSave(){
		driver.findElement(By.id("form-button-save")).click();
	}
	
	public String buscaMensagemSucesso(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("report-success")));
		return driver.findElement(By.cssSelector("#report-success > p")).getText();
	}
}
