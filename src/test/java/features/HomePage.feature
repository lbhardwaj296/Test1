Feature: Storyweaver Home Page

Scenario: To Validate Home Page
Given I open Storyweaver
Then I should navigate to Home Page successfully
And I close the browser

Scenario Outline: To Validate the Home page with login
Given I open Storyweaver
Given I login to Storyweaver with "<Email>" and "<Password>"
Then I should navigate to Home Page successfully
And I close the browser

Examples:
|Email					| Password	|
|loveleen@yopmail.com	| 123456	|
|loveleen@yopmail.com	| 12345678	|