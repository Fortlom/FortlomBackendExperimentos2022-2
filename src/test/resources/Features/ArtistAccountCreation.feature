Feature: Artist account creation
  Scenario: Successful artist account creation
   Given that the artist enters the platform
   When press “Register yourself as an Artist”
   And complete the form with your data
   And hit the “Register as Artist” button
   Then your account was successfully created
  Scenario: Incorrect artist account creation
   Given that the artist enters the platform
   When press “Register yourself as an Artist”
   And incorrectly complete the form
   And hit the “Register as Artist” button
   Then will display a message that your account was not created
  Scenario: Enter with the artist account created
   Given that the artist enters the platform
   And already has an account created on the platform
   When complete your corresponding data in the form
   And hit the “Enter” button
   Then will enter the platform with the account created