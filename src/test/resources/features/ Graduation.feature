@all
Feature: Graduation

  @graduation
  Scenario: Check that if it is possible assignment the graduation to the user in the MEİS system
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the control panel
    And adds name "Abbas" and fin "19HSHLY" to the name and fin fields
    And after searching selects founded user
    And switches to the user permissions tab
    And administrator approval switcher turned on or off
    And current account status switcher turned on or off
    And graduation start date is added
    And graduation end date is added
    And user saved changes
    And goes to the control panel
    And adds name "Abbas" and fin "19HSHLY" to the name and fin fields
    When after searching the results are displayed in the users table
    Then the user's administrative approval is displayed as closed in the table
    Then the user's current account status is displayed as closed in the table
    And after searching selects founded user
    And switches to the user permissions tab
    And administrator approval switcher turned on or off
    And current account status switcher turned on or off
    And user saved changes
    And goes to the control panel
    And adds name "Abbas" and fin "19HSHLY" to the name and fin fields
    When after searching the results are displayed in the users table
    Then the user's administrative approval is displayed as opened in the table
    Then the user's current account status is displayed as opened in the table
    #Test ssenarilər:
    #1.İstifadəçi üçün məzuniyyətin başlanma tarixinin əlavə edilməsinin yoxlanılması
    #2.İstifadəçi üçün məzuniyyətin bitmə tarixinin əlavə edilməsinin yoxlanılması
    #3.Dəyişikliklər yadda saxladıqdan sonra admin panelin istifadəçilər tabında istifadəçinin icazə statuslarının yoxlanılması
    #4.İstifadəçinin məzuniyyətini deaktiv etdikdən sonra admin panelin istifadəçilər tabında istifadəçinin icazə statuslarının yoxlanılması