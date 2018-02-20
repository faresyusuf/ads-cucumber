package CucuberFramework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

	WebDriver driver;
	public By item_on_search_page = By.cssSelector(".rbk-search-value.search-value");
	public By man_text_in_man_page = By.cssSelector(".rbk-heading-wrapper > h1");
	
	public SearchPage(WebDriver driver){
	       this.driver = driver;
	    }
	
	public String get_text_from_search_page() {
		return driver.findElement(item_on_search_page).getText();
	}
	
	public String get_text_from_men_page() {
		return driver.findElement(man_text_in_man_page).getText();
	}
}
