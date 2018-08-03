package com.sicredi.provagabi.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerPage {
	protected WebDriver driver;
	protected WebDriverWait wait;

	public CustomerPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
	}

	public void selecionarVersao(String versao) {
		WebElement selecionarVersao = driver.findElement(By.id("switch-version-select"));
		Select combobox = new Select(selecionarVersao);
		combobox.selectByVisibleText(versao);
	}

	public void clicarAddCustomer(){
		driver.findElement(By.cssSelector("#gcrud-search-form > div.header-tools > div.floatL.t5 > a")).click();
	}
	
	public void clicarLupa(){
		driver.findElement(By.cssSelector("a.btn.btn-primary.search-button.t5")).click();
	}
	
	public void preencherPesquisaLupa(String name){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.search-input")));
		driver.findElement(By.cssSelector("input.search-input")).sendKeys(name);
		driver.findElement(By.cssSelector("input.search-input")).sendKeys(Keys.ENTER);
	}
	
	public void clicarCheckbox() throws InterruptedException{
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.select-all-none")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='gcrud-search-form']/div[2]/table/thead/tr[2]/td[1]/div/input")).click();
	}
	
	public void clicarDelete(){
		driver.findElement(By.cssSelector("a.btn.btn-outline-dark.delete-selected-button")).click();
	}

	public String buscaMensagemSucessoDelete(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.alert.alert-success.growl-animated.animated.bounceInDown")));
		return driver.findElement(By.cssSelector("body > div.alert.alert-success.growl-animated.animated.bounceInDown > span:nth-child(4) > p")).getText();
	}
}
