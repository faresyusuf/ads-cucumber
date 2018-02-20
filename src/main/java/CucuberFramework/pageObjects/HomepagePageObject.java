package CucuberFramework.pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Mouse;

import com.fasterxml.jackson.databind.Module;

public class HomepagePageObject {
	
	WebDriver driver;
	String search_item = "Gazelle";
	By location_modal = By.cssSelector(".icon.icon-close");
	By search_element = By.cssSelector(".searchinput___3ump9");
	By men_in_menu_locator = By.cssSelector("a[href='/men']");
	By carousel_locator = By.cssSelector("h1.title___1_bN-");
	By right_arrow_in_carousel = By.cssSelector(".icon.icon-arrow-right");
	
	public By all_men_menu_locator = By.cssSelector("a[href='/men?grid=true']");
	
	public HomepagePageObject(WebDriver driver){
       this.driver = driver;
    }
	
	public void click_location_modal() {
		driver.findElement(location_modal).click();
	}
	
	public void click_search_field() {
		driver.findElement(search_element).click();
	}
	
	public void type_in_search_field() {
		driver.findElement(search_element).sendKeys(search_item);
	}
	
	public void hit_enter_search_field() {
		driver.findElement(search_element).sendKeys(Keys.RETURN);
	}
	
	public void hover_mouse_menu() throws AWTException {
		WebElement men_in_menu = driver.findElement(men_in_menu_locator);
		Actions action = new Actions(driver);
		action.moveToElement(men_in_menu).build().perform();
	}
	
	public void click_all_men_menu() {
		driver.findElement(all_men_menu_locator).click();
	}
	
	public ArrayList get_list_from_carousel() {
		ArrayList list = new ArrayList();
		ArrayList items = (ArrayList) driver.findElements(carousel_locator);
		String displayed_item;

		for (int i = 0; i < items.size(); i++) {
			displayed_item = ((WebElement) items.get(i)).getText();
			list.add(displayed_item);
		}
		
		return list;
	}
	
	public void click_right_arrow_in_carousel() {
		driver.findElement(right_arrow_in_carousel).click();
	}
		
}
