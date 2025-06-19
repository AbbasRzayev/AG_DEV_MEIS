@all @ChangePassword
Feature: Change of password

  @CP1
  Scenario Outline: Check if user can change the password
    And the user with login "<userLogin>" and password "<userPassword>" logs into the "AG-MEIS" system
    And switches to the Personal cabinet
    And goes to the change password tab
    And add the "<current>" password
    And add "<new>" new password
    And add "<repeat>" the new password
    And select submit button
    And goes to the authorization page
    And user with "<login>" and "<password>" logs into the MEIS system
    Then user has successfully entered to the MEIS system
    Examples:
      | userLogin               | userPassword      | current           | new               | repeat            | login                   | password          |
      | abbas.rzayev@aist.group | Rabbas8888!!      | Rabbas8888!!      | Rabbas8888!!!     | Rabbas8888!!!     | abbas.rzayev@aist.group | Rabbas8888!!!     |
      | abbas.rzayev@aist.group | Rabbas8888!!!     | Rabbas8888!!!     | Rabbas8888!!!!    | Rabbas8888!!!!    | abbas.rzayev@aist.group | Rabbas8888!!!!    |
      | abbas.rzayev@aist.group | Rabbas8888!!!!    | Rabbas8888!!!!    | Rabbas8888!!!!!   | Rabbas8888!!!!!   | abbas.rzayev@aist.group | Rabbas8888!!!!!   |
      | abbas.rzayev@aist.group | Rabbas8888!!!!!   | Rabbas8888!!!!!   | Rabbas8888!!!!!!  | Rabbas8888!!!!!!  | abbas.rzayev@aist.group | Rabbas8888!!!!!!  |
      | abbas.rzayev@aist.group | Rabbas8888!!!!!!  | Rabbas8888!!!!!!  | Rabbas8888!!!!!!! | Rabbas8888!!!!!!! | abbas.rzayev@aist.group | Rabbas8888!!!!!!! |
      | abbas.rzayev@aist.group | Rabbas8888!!!!!!! | Rabbas8888!!!!!!! | Rabbas8888!!      | Rabbas8888!!      | abbas.rzayev@aist.group | Rabbas8888!!      |
#1.İstifadəçinin şəxsi kabinetim hissəsindən şifrəni dəyişdirməsi
#2.İstifadəçinin şifrə dəyişdirildikdən sonra sistemə daxil olması
#3.Istifadəçinin öncəki şifrəni 5 dəfə fərqli şifrəyə dəyişdikdən sonra ilkin şirfəni seçməsi
#4.İlkin şifrəni bərpa etdikdən sonra sistemə daxil olması

  @CP2-positive
  Scenario: Check with negative cases change password fields validation
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "AG-MEIS" system
    And switches to the Personal cabinet
    And goes to the change password tab
    And user add the old password "Farid1020" to the current password field
    When user added valid datas to the new password field and to the repeat new password field
    Then the submit button becomes active
   #Checkin valitaion with correct data^
   #1.More than ten sybols
   #2.At least must be one upper and one lowercase
   #3.Must be 5 different sybols
   #4.Must be special characters

  #5.Şifrəni dəyiş hissəsində mövcud xanaların validasiyalarının yoxlanılması (pozitiv case)

  @CP3-negative
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

#6.Şifrəni dəyiş hissəsində mövcud xanaların validasiyalarının yoxlanılması (neqativ case)