Feature: Login functionality of Leaftaps application

Background: 
Given Open the browser
And Load the URL

Scenario: Login for positive testcase
Given Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
When Click Login button
Then Homepage should be displayed
And Close the browser

Scenario: Login for invalid credential
Given Enter the username as 'DemoCSR1'
And Enter the password as 'crmsfa'
When Click Login button
But Error message should be displayed
And Close the browser