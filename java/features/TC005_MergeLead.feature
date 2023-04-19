Feature: MergeLead functionality of Leaftaps application

Background: 
Given Open the browser
And Load the URL

Scenario: MergeLead for positive testcase
Given Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
When Click Login button
Then Homepage should be displayed
When Click on CRMSFA link
And Click on Leads tab
And Click on Merge Leads tab
And Fetch leadid on From Lead field
And Wait for sometime
And Capture the LeadId of the first search record in From Lead field
And Click on first record from search results of From Lead field 
And Fetch leadid on To Lead field
And Wait for sometime
And Click on first record from search results of To Lead field
And Click on Merge button and handle the alert of the same
And Search using the same Merge LeadId
And Wait for sometime
Then Verify if merged lead does not show up
And Close the browser 
