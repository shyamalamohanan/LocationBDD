Feature: Salesforce Location Funtionality

Scenario: TC001_Verify Clone Locations

Given Enter the UserName
And Enter the Password
And Click on the Login Button 
And Click on App Launcher in the Left corner
And Click View All
And Click on Locations under All items
And Enter Search Location as 'Coimbatore'
And Click on Locations Name link
And Click right side Corner DropDown
And Select Clone
And Change the External References
When Click on Save
Then Verify the  External References is Changed


Scenario: TC002_Verify Cancel Locations

Given Enter the UserName
And Enter the Password
And Click on the Login Button 
And Click on App Launcher in the Left corner
And Click View All
And Click on Locations under All items
And Click on New
And Enter the Location Name As Any name
And Choose Location Type as any type
And Enter the External References
When Click on Cancel
And Enter Search Location as 'Madurai'
Then Verify if the Locations is Cancelled







