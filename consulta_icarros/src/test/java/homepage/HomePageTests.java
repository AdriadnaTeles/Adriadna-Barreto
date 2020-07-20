package homepage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import com.sun.java.util.jar.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.hamcrest.Matcher;
import base.BaseTests;
import pages.HomePage;
import pages.ResultadoPage;

import base.BaseTests;

public class HomePageTests extends BaseTests {
	
	@Test
	 public void testPesquisarCarros_CarrosUsados() {
		
		carregarPaginaInicial();
		
		//Desmarcar opção 0KM
		
		homePage.DesmarcarCarroZero();
		assertTrue(homePage.estaSelecionadoCheckboxUsados());
		
		
		
		// Mensagem de Segurança
		homePage.clicarOkEntendi();
		
		
		String marcaDoCarroHonda = "Honda";
		String modeloDoCarro = "HR-V";
		String anoMinimo = "De 2019";
		String anoMaximo = "Até 2020";
		String precoMinimo = "De R$ 60 mil";
		String precoMaximo = "Até R$ 100 mil";
		String cidade = "Osasco-SP";
		
		
		// Preencher Marca
		homePage.selecionarMarca("Honda");
		homePage.obterMarcaSelecionada();
		
		// Preencher Modelo
		
        homePage.selecionarModelo("HR-V");
		homePage.obterModeloSelecionado();
		
		//Preencher Ano Mínimo
		
		homePage.selecionarAnoMinimo("De 2019");
		homePage.obterAnoMinimoSelecionado();
	
		//Preencher Ano Máximo
		
		homePage.selecionarAnoMaximo(anoMaximo);
		homePage.obterAnoMaximoSelecionado();
		
		//Preencher Preço Mínimo
		
		homePage.selecionarPrecoMinimo("De R$ 60 mil");
		homePage.obterPrecoMinimoSelecionado();
		
		//Preencher Preço Máximo
		
		homePage.selecionarPrecoMaximo(precoMaximo);
		homePage.obterPrecoMaximoSelecionado();
		
		//Alterar Localização
		
		homePage.alterarLocalização(cidade);
		
		//Clicar em Buscar
		
		homePage.clicarEmBuscar();
	
		capturarTela(marcaDoCarroHonda, cidade);
		
	}
	
	//ResultadoPage resultadoPage;
	@Test
	public void testContarEvalidarCarrosDoResultado() {
		//Contar Lista de carros do Resultado
		ResultadoPage resultadoPage = homePage.clicarEmBuscar();
		testPesquisarCarros_CarrosUsados();
		assertThat (resultadoPage.contarCarros(), is (15));
		System.out.println(resultadoPage.contarCarros());
		
		// Validar Modelo do Primeiro carro
		int indice = 0;
		String modeloCarro_ResultadoPage = resultadoPage.obterModeloCarro(indice);
		String anoCarro_ResultadoPage = resultadoPage.obterAnoCarro(indice);
		anoCarro_ResultadoPage =anoCarro_ResultadoPage.replace("Ano\n", "");
		String KmCarro_ResultadoPage = resultadoPage.obterKmCarro(indice);
		KmCarro_ResultadoPage =KmCarro_ResultadoPage.replace("\n", "");
		String CorCarro_ResultadoPage = resultadoPage.obterCorCarro(indice);
		String CambioCarro_ResultadoPage = resultadoPage.obterCambioCarro(indice);
		System.out.println(modeloCarro_ResultadoPage);
		System.out.println(anoCarro_ResultadoPage);
		System.out.println(KmCarro_ResultadoPage);
		System.out.println(CorCarro_ResultadoPage);
		System.out.println(CambioCarro_ResultadoPage);
		assertThat(modeloCarro_ResultadoPage, is ("Honda HR-V 1.8 LX CVT"));
		assertThat(anoCarro_ResultadoPage, is ("2020/ 2020"));
		assertThat(KmCarro_ResultadoPage, is   ("Km120"));
		assertThat(CorCarro_ResultadoPage, is ("Preto"));
		assertThat(CambioCarro_ResultadoPage, is("automático"));
		
		
		
		//Validar preço do Primeiro Carro
		int indice2 = 0;
		String precoCarro_ResultadoPage = resultadoPage.obterprecoCarro(indice2);
		precoCarro_ResultadoPage =precoCarro_ResultadoPage.replace("R$ ", "");
		precoCarro_ResultadoPage =precoCarro_ResultadoPage.replace("preço à vista", "");
		precoCarro_ResultadoPage =precoCarro_ResultadoPage.replace("\n", "");
		System.out.println(precoCarro_ResultadoPage);
		assertThat(precoCarro_ResultadoPage, is ("97.050,00"));
		
		capturarTela(modeloCarro_ResultadoPage, precoCarro_ResultadoPage);
		
		// Validar Modelo do Segundo carro
		int indice3 = 1;
		String modeloCarroDois_ResultadoPage = resultadoPage.obterModeloCarroDois(indice3);
		String anoCarroDois_ResultadoPage = resultadoPage.obterAnoCarroDois(indice3);
		anoCarroDois_ResultadoPage =anoCarroDois_ResultadoPage.replace("Ano\n", "");
		String KmCarroDois_ResultadoPage = resultadoPage.obterKmCarroDois(indice3);
		KmCarroDois_ResultadoPage =KmCarroDois_ResultadoPage.replace("\n", "");
		String CorCarroDois_ResultadoPage = resultadoPage.obterCorCarroDois(indice);
		String CambioCarroDois_ResultadoPage = resultadoPage.obterCambioCarroDois(indice);
		System.out.println(modeloCarroDois_ResultadoPage);
		System.out.println(anoCarroDois_ResultadoPage);
		System.out.println(KmCarroDois_ResultadoPage);
		System.out.println(CorCarroDois_ResultadoPage);
		System.out.println(CambioCarroDois_ResultadoPage);
		assertThat(modeloCarroDois_ResultadoPage, is ("Honda HR-V 1.8 EXL CVT"));
		assertThat(anoCarroDois_ResultadoPage, is ("2019/ 2020"));
		assertThat(KmCarroDois_ResultadoPage, is   ("Km17.607"));
		assertThat(CorCarroDois_ResultadoPage, is ("Preto"));
		assertThat(CambioCarroDois_ResultadoPage, is("automático"));
				
		//Validar preço do Segundo Carro
		int indice4 = 1;
		String precoCarroDois_ResultadoPage = resultadoPage.obterprecoCarroDois(indice4);
		precoCarroDois_ResultadoPage =precoCarroDois_ResultadoPage.replace("R$ ", "");
		precoCarroDois_ResultadoPage =precoCarroDois_ResultadoPage.replace("preço à vista", "");
		precoCarroDois_ResultadoPage =precoCarroDois_ResultadoPage.replace("\n", "");
		System.out.println(precoCarroDois_ResultadoPage);
		assertThat(precoCarroDois_ResultadoPage, is ("98.900,00"));
		
		capturarTela(modeloCarroDois_ResultadoPage, precoCarroDois_ResultadoPage);
		
	}
}

	