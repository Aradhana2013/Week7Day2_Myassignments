Feature: EditLead functionality of Leaftaps application

Background: 
Given Open the browser
And Load the URL

Scenario: EditLead for positive testcase
Given Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
When Click Login button
Then Homepage should be displayed
When Click on CRMSFA link
And Click on Leads tab
And Click on Find Leads tab
And Click on Phone tab
And Enter search phone number as '99'
And Click Find Leads button
And Wait for sometime
And Click on first record from search results
Given Click on edit button
When Clear existing company name
And Enter new company name as 'TCS'
And Click on submit button
Then Verify if Lead is editted
And Close the browser