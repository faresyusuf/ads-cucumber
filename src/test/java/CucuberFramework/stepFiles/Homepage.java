package CucuberFramework.stepFiles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import CucuberFramework.pageObjects.BrowserSetup;
import CucuberFramework.pageObjects.HomepagePageObject;
import CucuberFramework.pageObjects.SearchPage;
import CucuberFramework.pageObjects.UtilAdidas;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Homepage extends BrowserSetup {

	
	ArrayList list1 = new ArrayList();
	ArrayList list2 = new ArrayList();
	HomepagePageObject hm;
	UtilAdidas ut;
	SearchPage sr;

	@Before
	public void setup() throws IOException {
		driverSetup();
		hm = new HomepagePageObject(driver);
		ut = new UtilAdidas(driver);
		sr = new SearchPage(driver);
	}
	
	@After
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.quit();
		driver = null;
	}
	
	@Given("^User able to access adidas website$")
	public void user_able_to_access_adidas_website() throws Throwable {
		startNavigation();
	}

	@And("^User able to close location modal$")
	public void user_able_to_close_location_modal() throws Throwable {
		hm.click_location_modal();
	}

	@And("^User click on the search field$")
	public void user_click_on_the_search_field() throws Throwable {
		hm.click_search_field();
	}

	@And("^User type for a relavent product name into search field$")
	public void user_type_for_a_relavent_product_name_into_search_field() throws Throwable {
		hm.type_in_search_field();
	}

	@When("^User click press enter from keyboard$")
	public void user_click_press_enter_from_keyboard() throws Throwable {
		hm.hit_enter_search_field();
	}

	@Then("^User should be taken to the page contain relavent search data$")
	public void user_should_be_taken_to_the_page_contain_relavent_search_data() throws Throwable {
		ut.wait_for_element(sr.item_on_search_page);
		String searched_item = sr.get_text_from_search_page();
		Assert.assertEquals("GAZELLE", searched_item);
	}

	@And("^User hover mouse pointer on Men in top navigation$")
	public void user_hover_mouse_pointer_on_Men_in_top_navigation() throws Throwable {
		hm.hover_mouse_menu();
	}

	@When("^Click on All men's under Men navigation$")
	public void click_on_All_men_s_under_Men_navigation() throws Throwable {
		ut.wait_for_element_to_click(hm.all_men_menu_locator);
		hm.click_all_men_menu();
	}

	@Then("^User should be taken to the page containing Men's product$")
	public void user_should_be_taken_to_the_page_containing_Men_s_product() throws Throwable {
		ut.wait_for_element(sr.man_text_in_man_page);
		String men_text = sr.get_text_from_men_page();
		Assert.assertEquals("MEN", men_text);
		
	}

	@Given("^User can see the image on carousel$")
	public void user_can_see_the_image_on_carousel() throws Throwable {
		list1 = hm.get_list_from_carousel();
		System.out.println(list1);
	}

	@When("^Click on the right arrow for next carousel item$")
	public void click_on_the_right_arrow_for_next_carousel_item() throws Throwable {
		hm.click_right_arrow_in_carousel();
	}

	@Then("^User should be able see that carousel image is updated to next one$")
	public void user_should_be_able_see_that_carousel_image_is_updated_to_next_one() throws Throwable {
		list2 = hm.get_list_from_carousel();
		System.out.println(list2);
		Assert.assertNotEquals(list1, list2);

	}
}
