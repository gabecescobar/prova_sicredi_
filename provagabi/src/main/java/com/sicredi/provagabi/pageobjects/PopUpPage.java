
package com.sicredi.provagabi.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PopUpPage {
	protected WebDriver driver;
	protected WebDriverWait wait;

	public PopUpPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
	}

	public String buscaMensagemDelete(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.container-fluid.gc-container > div.row > div.delete-multiple-confirmation.modal.fade.in.show > div > div > div.modal-body")));
		return driver.findElement(By.cssSelector("p.alert-delete-multiple-one")).getText();
	}
	
	public void clicarDelete(){
		driver.findElement(By.cssSelector("button.btn.btn-danger.delete-multiple-confirmation-button")).click();
	}
}
