@all @login_and_logout
Feature: Login to the MEIS system
  As a registered user,
  I want to log in to the MEIS system using my email and password,
  So that I can securely access the system's features and data.

  @login @new
  Scenario Outline: Entering the MEIS system with positive and negative data
    Given user enters the "AG-MEIS" system
    When user adds "<login>" and "<password>"
    Then entrance to the system is "<checked>"
    Examples:
      | login                  | password     | checked |
      | imranovfarid@gmail.com | Farid1020@@@ | true    |
      | farid@gmail.com        | Farid        | false   |
  #Scenariyoda yoxlanlır:
  #1.Istifadəçinin sistemə login olması və login olduqdan sonra url yoxlanılması