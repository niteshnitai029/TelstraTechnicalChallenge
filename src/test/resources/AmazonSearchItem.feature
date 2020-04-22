Feature: Search item "Sony 55 inch TV" in amazon website and add to the cart.
Description: The purpose of the feature file is to login to Amazon, search item and add to the cart

Scenario: User search for item and add to the cart in Amazon.com.au.
Given user is on Amazon home page
When user click on signIn link
And enter username and click continue button
Then enter password and click signin button
When user enter item name in search textbox and click search button
Then user view search results and selects item
When user views selected item and add to cart 
Then user can view item in the cart list