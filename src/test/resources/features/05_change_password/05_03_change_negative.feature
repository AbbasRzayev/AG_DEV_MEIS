@all @change_password @new
Feature: Change of password

  @change_negative
  Scenario: Check with negative cases change password fields validation
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "AG-MEIS" system
    And switches to the Personal cabinet
    And goes to the change password tab
    And user add the old password "Farid1020" to the current password field
    When user added not valid data to the new password field and to the repeat new password field
      | 12345Ab!!          |
      | all lowercase 88!! |
      | ALL UPPERCASE 88!! |
      | No special sybols  |
    Then the submit button is not active
#Checkin validation with wrong data:
#1.Minimum 9 sybols
#2.All lower case
#3.All upper case
#4.No special sybols
#Test ssenarilər:
#6.Şifrəni dəyiş hissəsində mövcud xanaların validasiyalarının yoxlanılması (neqativ case)