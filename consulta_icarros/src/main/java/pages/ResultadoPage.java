package pages;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class ResultadoPage {
	private WebDriver driver;
	
	List<WebElement> listaCarros = new ArrayList();
	
	
	
	private By contarCarros = By.cssSelector("h2.esquerda.titulo_anuncio");
	
	private By descricaoDoModelo = By.cssSelector("h2.esquerda.titulo_anuncio");
	
	private By descricaoDopreco = By.cssSelector("h3.direita.preco_anuncio");
	
	private By descricaoDoAno = By.cssSelector("a.clearfix ul.listahorizontal li.primeiro");
			
	private By descricaoDoKM = By.cssSelector("a.clearfix ul.listahorizontal li.usado");
	
	private By descricaoDaCor = By.cssSelector("#ac29729203 > div > div.clearfix.dados_anuncio > div.dados_veiculo > a > ul > li:nth-child(3) > p");
	
	private By descricaoDoCambio = By.cssSelector("#ac29729203 > div > div.clearfix.dados_anuncio > div.dados_veiculo > a > ul > li.ultimo > p");
	
	
	public ResultadoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	 public int contarCarros() {
    	 carregarListaCarros();
    	 return listaCarros.size();
    	 

}
	 public void carregarListaCarros() {
		listaCarros = driver.findElements(contarCarros);
		
				}
		    
	 
	 public String obterModeloCarro (int indice) {
		 return driver.findElements(descricaoDoModelo).get(indice).getText();
		 
	 }
	 
	 public String obterAnoCarro (int indice) {
		 return driver.findElements(descricaoDoAno).get(indice).getText();
		 
	 }
	 
	 public String obterKmCarro(int indice) {
		 return driver.findElements(descricaoDoKM).get(indice).getText();
		 
	 }
	 public String obterCorCarro(int indice) {
		 return driver.findElements(descricaoDaCor).get(indice).getText();
		 
	 }
	 
	 public String obterCambioCarro(int indice) {
		 return driver.findElements(descricaoDoCambio).get(indice).getText();
		 
	 }
	 
	 public String obterprecoCarro (int indice) {
		 return driver.findElements(descricaoDopreco).get(indice).getText();
	 }
	 
	 
	 
	 public String obterModeloCarroDois (int indice) {
		 return driver.findElements(descricaoDoModelo).get(indice).getText();
		 
	 }
	 
	public String obterAnoCarroDois (int indice) {
		return driver.findElements(descricaoDoAno).get(indice).getText();
		 
} 
	public String obterKmCarroDois (int indice) {
		return driver.findElements(descricaoDoKM).get(indice).getText();
	
}
	public String obterCorCarroDois (int indice) {
		return driver.findElements(descricaoDaCor).get(indice).getText();
	}
	
	public String obterCambioCarroDois (int indice) {
		return driver.findElements(descricaoDoCambio).get(indice).getText();
	}
	
    public String obterprecoCarroDois (int indice) {
	return driver.findElements(descricaoDopreco).get(indice).getText();

}
}	
