package CucuberFramework.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilAdidas {

	WebDriver driver;
	WebDriverWait wait;
	
	
	public UtilAdidas(WebDriver driver){
	       this.driver = driver;
	       this.wait = new WebDriverWait(driver, 40);
	    }
	
	public void wait_for_element(By by) {
		wait.until(ExpectedConditions.presenceOfElementLocated((By) by));
	}
	
	public void wait_for_element_to_click(By by) {
		wait.until(ExpectedConditions.elementToBeClickable((By) by));
	}

}


