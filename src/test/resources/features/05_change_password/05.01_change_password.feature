@all @change_password @new
Feature: Change of password

  @change_users_password
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
    #Test ssenarilər:
    #1.İstifadəçinin şəxsi kabinetim hissəsindən şifrəni dəyişdirməsi
    #2.İstifadəçinin şifrə dəyişdirildikdən sonra sistemə daxil olması
    #3.Istifadəçinin öncəki şifrəni 5 dəfə fərqli şifrəyə dəyişdikdən sonra ilkin şirfəni seçməsi
    #4.İlkin şifrəni bərpa etdikdən sonra sistemə daxil olması



