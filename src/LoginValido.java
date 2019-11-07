import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginValido {
	
	FirefoxDriver pagina;

	@Before
	public void antes() {
		System.setProperty("webdriver.gecko.driver", 
				"C:\\ads3n192\\geckodriver.exe");
		pagina = new FirefoxDriver();
		pagina.get("https://pt-br.facebook.com/login/");
		pagina.manage().window().maximize();
	}
	
	@Test
	public void test() {
		WebElement txtLogin = pagina.findElementById("email");
		txtLogin.sendKeys("adaltoss");
		
		WebElement txtSenha = pagina.findElementByName("pass");
		txtSenha.sendKeys("1q2w3e");
		
		WebElement botao = pagina.findElementByXPath("/html/body/div[1]/div[3]/div[1]/div/div/div[2]/form/div/div[3]/button");
		botao.click();
	}
	
	@After
	public void depois() {
		try {
			WebElement nome = pagina.findElementByXPath("/html/body/div[1]/div[2]/div/div[1]/div/div/div/div[2]/div[1]/div[1]/div/a/span/span");
			if( nome.getText().equals("Adalto")) {
				JOptionPane.showMessageDialog(null, 
						"Teste realizado com sucesso");
			}else {
				JOptionPane.showMessageDialog(null, 
						"Foi encontrado um erro");
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, 
					"Foi encontrado um erro");
		}
		
	}

}
