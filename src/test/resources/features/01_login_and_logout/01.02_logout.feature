@all @login_and_logout @new
Feature: Login to the MEIS system

  @logout
  Scenario: Check if user can log out from system via the left sidebar
    Given user with login "imranovfarid@gmail.com" and password "Farid1020@@@" logs into the "AG-MEIS" system
    When user selects exit button
    Then user has been successfully logged out from system
  #Scenariyoda yoxlanlır:
  #2.Istifadəçinin sistemdəm(leftsidebar) logout olması və logout oluqdan sonra url yoxlanılması