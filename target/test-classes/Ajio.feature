@woman
Feature: Ajio Kids Clothing

Background: Kids Clothing Shorting With Lowest Price
Given Launch the Ajio "https://www.ajio.com/"
And Go to kids and click on clothing
  

Scenario: Select kids Clothing
When User click on dropdown and select the lowest price in dropdown
Then Validate the price in lowest price
And Validate all the url 


