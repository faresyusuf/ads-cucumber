Feature: Homepage features
	User should be able to use some core feature on the homepage
	
Scenario: Searching for relevent items using search field
	Given User able to access adidas website
	And User able to close location modal
	And User click on the search field
	And User type for a relavent product name into search field
	When User click press enter from keyboard
	Then User should be taken to the page contain relavent search data 
		
Scenario: Access navigation menu
	Given User able to access adidas website
	And User able to close location modal
	And User hover mouse pointer on Men in top navigation
	When Click on All men's under Men navigation
	Then User should be taken to the page containing Men's product
	
Scenario: Carousel is working properly
	Given User able to access adidas website
	And User able to close location modal
	And User can see the image on carousel
	When Click on the right arrow for next carousel item
	Then User should be able see that carousel image is updated to next one