@Mens
Feature: Ajio MensClothing

Background: Mens Clothing Shorting With Lowest Price
Given Launch the Ajio "https://www.ajio.com/"
And Go to mens and click on clothing

Scenario: Select Mens Clothing
When User click on dropdown and select the lowest price in dropdown
Then Validate the price in lowest price

  