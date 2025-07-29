@all @change_password @new
Feature: Change of password

  @change_positive
  Scenario: Check with negative cases change password fields validation
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "AG-MEIS" system
    And switches to the Personal cabinet
    And goes to the change password tab
    And user add the old password "Farid1020" to the current password field
    When user added valid dates to the new password field and to the repeat new password field
    Then the submit button becomes active
   #Checkin valitaion with correct data:
   #1.More than ten sybols
   #2.At least must be one upper and one lowercase
   #3.Must be 5 different sybols
   #4.Must be special characters
    #Test ssenarilər:
    #5.Şifrəni dəyiş hissəsində mövcud xanaların validasiyalarının yoxlanılması (pozitiv case)