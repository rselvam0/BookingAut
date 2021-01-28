Feature: Login into Application

Scenario Outline: Positive test validating login
Given Initialize the browser with chrome
And Navigate to "https://rahulshettyacademy.com" site
And Click on login link in home page to land on secure signin page 
When User enteres <username> and <password> and logs in
Then Verify the user is successfully logged in
And close browsers

Examples:
|username					|password	|
|ramesh.selvam27@gmail.com	|171revathy@|
|dummyuser@gmail.com		|abcd12334	|