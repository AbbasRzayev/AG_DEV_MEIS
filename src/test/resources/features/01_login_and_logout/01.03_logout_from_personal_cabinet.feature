@all @login_and_logout @new
Feature: Login to the MEIS system

  @logout_from_personal_cabinet
  Scenario: Check if user can log out from system via the personal cabinet
    Given user with login "imranovfarid@gmail.com" and password "Farid1020@@@" logs into the "AG-MEIS" system
    When user selects exit button from personal cabinet
    Then user has been successfully logged out from system
  #Scenariyoda yoxlanlır:
  #3.Istifadəçinin sistemdən şəxsi kabinetindən logout olması və logout olduqdan sonra url yoxlanılması