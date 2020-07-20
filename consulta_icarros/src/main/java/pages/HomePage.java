package pages;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class HomePage {
	private WebDriver driver;
	
	private By opcaoCarroZero = By.cssSelector("input#anunciosNovos");
	
	private By checkboxUsados = By.id("anunciosUsados");
	
	private By okEntendi = By.cssSelector("button.btn-message");
	
	private By marcaDoCarro = By.cssSelector("button[title='Marca']");
	
	private By marcaDoCarroHonda = By.cssSelector("input.form-control");
	
	private By modeloDoCarro = By.cssSelector("button[title='Modelo']");
	
	private By modeloDoCarroHRV = By.xpath("//*[@id=\"buscaForm\"]/div[2]/div[2]/div/div/div/div/div/div/input");
	
	private By campoAnoMinimo = By.cssSelector("button[title='Ano min.']");
	
    private By anoMinimo = By.cssSelector("#buscaForm > div:nth-child(6) > div:nth-child(1) > div > div > div > div > div > div > input");
    
    private By campoAnoMaximo = By.cssSelector("button[title='Ano máx.']");
	
	private By anoMaximo = By.cssSelector("#buscaForm > div:nth-child(6) > div:nth-child(2) > div > div > div > div > div > div > input");
	
	private By campoPrecoMinimo = By.cssSelector("button[title='Preço min.']");
	
	private By precoMinimo = By.cssSelector("#buscaForm > div:nth-child(6) > div:nth-child(3) > div > div > div > div > div > div > input");
	
	private By campoPrecoMaximo = By.cssSelector("button[title='Preço máx.']");
	
	private By precoMaximo = By.cssSelector("#buscaForm > div:nth-child(6) > div:nth-child(4) > div > div > div > div > div > div > input");
	
	private By localização = By.className("showBoxLocation");
	
	private By cidade = By.id("cidade");
	
	private By buscar = By.xpath("//*[text()=\"Buscar\"]");
	
	public HomePage(WebDriver driver) {
		this.driver =driver;
	}
	
	public void DesmarcarCarroZero () {
		driver.findElement(opcaoCarroZero).click();
			
	}
	
     public boolean estaSelecionadoCheckboxUsados () {
    	 return driver.findElement(checkboxUsados).isSelected();
     }
	 
	
	public void  clicarOkEntendi () {
		driver.findElement(okEntendi).click();
	}
	
	public void selecionarMarca(String marca) {
		driver.findElement(marcaDoCarro).click();
		driver.findElement(marcaDoCarroHonda).sendKeys(marca);
		driver.findElement(marcaDoCarroHonda).sendKeys(Keys.ENTER);		
}
		 
	public String obterMarcaSelecionada() {
		return driver.findElement(marcaDoCarroHonda).getText();
	}

    
    public void selecionarModelo(String modelo) {
		driver.findElement(modeloDoCarroHRV).click();
		driver.findElement(modeloDoCarroHRV).sendKeys(modelo);
		driver.findElement(modeloDoCarroHRV).sendKeys(Keys.ENTER);
	}
   public String obterModeloSelecionado() {
		return driver.findElement(modeloDoCarroHRV).getText();
	}
   public void selecionarAnoMinimo(String anoMin) {
		driver.findElement(campoAnoMinimo).click();
		driver.findElement(anoMinimo).sendKeys(anoMin);
		driver.findElement(anoMinimo).sendKeys(Keys.ENTER);
	}
  public String obterAnoMinimoSelecionado() {
	  return driver.findElement(anoMinimo).getText();
  }
		
  public void selecionarAnoMaximo (String anoMax) {
		driver.findElement(campoAnoMaximo).click();
		driver.findElement(anoMaximo).sendKeys(anoMax);
		driver.findElement(anoMaximo).sendKeys(Keys.ENTER);
	}
   public String obterAnoMaximoSelecionado() {
	  return driver.findElement(anoMaximo).getText();
}

  public void selecionarPrecoMinimo(String precoMin) {
	driver.findElement(campoPrecoMinimo).click();
	driver.findElement(precoMinimo).sendKeys(precoMin);
	driver.findElement(precoMinimo).sendKeys(Keys.ENTER);
}
  public String obterPrecoMinimoSelecionado() {
	  return driver.findElement(precoMinimo).getText();
  }
 
  public void selecionarPrecoMaximo(String precoMax) {
		driver.findElement(campoPrecoMaximo).click();
		driver.findElement(precoMaximo).sendKeys(precoMax);
		driver.findElement(precoMaximo).sendKeys(Keys.ENTER);
	}
	  public String obterPrecoMaximoSelecionado() {
		  return driver.findElement(precoMaximo).getText();
    }
	  
	  public void alterarLocalização(String local) {
		    driver.findElement(localização).click();
			driver.findElement(cidade).sendKeys(local);
			
		  
	  }			
	  public ResultadoPage clicarEmBuscar () {
			driver.findElement(buscar).click();
			return new ResultadoPage(driver);
		}
	  
	  
	  
}   

