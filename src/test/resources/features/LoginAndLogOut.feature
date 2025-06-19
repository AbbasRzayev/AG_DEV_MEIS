@all @loginAndLogOut
Feature: Login to the MEIS system

  @LogIn
  Scenario Outline: Entering the MEIS system with positive and negative data
    Given user enters the "AG-MEIS" system
    When user adds "<login>" and "<parol>"
    Then entrance to the system is "<checked>"
    Examples:
      | login                  | parol        | checked |
      | imranovfarid@gmail.com | Farid1020@@@ | true    |
      | farid@gmail.com        | Farid        | false   |
  #Scenariyoda yoxlanlır:
  #1.Istifadəçinin sistemə login olması və login olduqdan sonra url yoxlanılması

  @LogOut
  Scenario: Check if user can log out from system via the left sidebar
    Given user with login "imranovfarid@gmail.com" and password "Farid1020@@@" logs into the "AG-MEIS" system
    When user selects exit button
    Then user has been successfully logged out from system
  #Scenariyoda yoxlanlır:
  #2.Istifadəçinin sistemdəm(leftsidebar) logout olması və logout oluqdan sonra url yoxlanılması

  @LogOutFromPersonalCabinet
  Scenario: Check if user can log out from system via the personal cabinet
    Given user with login "imranovfarid@gmail.com" and password "Farid1020@@@" logs into the "AG-MEIS" system
    When user selects exit button from personal cabinet
    Then user has been successfully logged out from system
  #Scenariyoda yoxlanlır:
  #3.Istifadəçinin sistemdən şəxsi kabinetindən logout olması və logout olduqdan sonra url yoxlanılması