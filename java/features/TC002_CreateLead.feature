Feature: CreateLead functionality of Leaftaps application

Background: 
Given Open the browser
And Load the URL

Scenario Outline: CreateLead for positive testcase
Given Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
When Click Login button
Then Homepage should be displayed
When Click on CRMSFA link
And Click on Leads tab
And Click on Create Leads tab
Given Enter Company Name as <companyName>
And Enter firstName as <firstName>
And Enter lastName as <lastName>
And Enter phone number as <phoneNumber>
When Click on Create Lead button
Then ViewLeads page should be displayed
And Close the browser

Examples:
|companyName|firstName|lastName|phoneNumber|
|TestLeaf|Subraja|Subi|99|
|TCS|Gomathy|Vasudevan|6479642013|
|TestLeaf|Vidya|R|98|
 
