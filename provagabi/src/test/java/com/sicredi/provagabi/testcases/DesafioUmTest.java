package com.sicredi.provagabi.testcases;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.sicredi.provagabi.pageobjects.AddCustomerPage;
import com.sicredi.provagabi.pageobjects.CustomerPage;
import com.sicredi.provagabi.pageobjects.PopUpPage;

public class DesafioUmTest {
	private static ChromeDriverService service;
	private static WebDriver driver;

	@BeforeClass
	public static void createAndStartService() throws IOException {
		service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File("src/test/resources/drivers/chromedriver.exe"))
				.usingAnyFreePort()
				.build();
		service.start();
	}

	@AfterClass
	public static void createAndStopService() {
		if (driver != null) {
			driver.quit();
		}
		service.stop();
	}

	@Before
	public void createDriver() {
		driver = new RemoteWebDriver(service.getUrl(),
				DesiredCapabilities.chrome());
	}

	@After
	public void quitDriver() {

	}

	
	public void desafioUmTest() {
		
		driver.get("https://www.grocerycrud.com/demo/bootstrap_theme");

		CustomerPage page = new CustomerPage(driver);
		page.selecionarVersao("Bootstrap V4 Theme");
		page.clicarAddCustomer();

		AddCustomerPage add = new AddCustomerPage(driver);
		add.preencherName("Teste Sicredi");
		add.preencherLastName("Teste");
		add.preencherContactFirstName("Gabriela");
		add.preencherPhone("51 9999-9999");
		add.preencherAddressLine1("Av Assis Brasil, 3970");
		add.preencherAddressLine2("Torre D");
		add.preencherCity("Porto Alegre");
		add.preencherState("RS");
		add.preencherPostalCode("91000-000");
		add.preencherCountry("Brasil");
		add.selecionarFromEmployeer("Fixter");
		add.preencherCreditLimit("200");
		add.clicarSave();

		String msg = "Your data has been successfully stored into the database. Edit Customer or Go back to list";

		assertEquals("Verificando mensagem de sucesso", msg, add.buscaMensagemSucesso());
	}

	@Test
	public void desafioDoisTest() throws InterruptedException {
		desafioUmTest();

		AddCustomerPage add = new AddCustomerPage(driver);
		add.clicarGoBackToList();
		
		CustomerPage page = new CustomerPage(driver);
		page.clicarLupa();
		page.preencherPesquisaLupa("Teste Sicredi");
		page.clicarCheckbox();
		page.clicarDelete();
		
		PopUpPage popup = new PopUpPage(driver);
		String msg1 = "Are you sure that you want to delete this 1 item?";
		assertEquals("Verificando mensagem de confirmacao delete", msg1, popup.buscaMensagemDelete());
		popup.clicarDelete();
		
		String msg2 = "Your data has been successfully deleted from the database.";
		assertEquals("Verificando mensagem de deletado com sucesso", msg2, page.buscaMensagemSucessoDelete());
	}
}
