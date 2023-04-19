Feature: DeleteLead functionality of Leaftaps application

Background: 
Given Open the browser
And Load the URL

Scenario: DeleteLead for positive testcase
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
And Capture the LeadId of the first search record
And Click on first record from search results
When Click on Delete button
And Click on Find Leads tab for delete verification
And Search using the same LeadId
Then Verify if deleted lead does not show up
And Close the browser 
