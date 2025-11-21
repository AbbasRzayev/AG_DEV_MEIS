@all
Feature: Graduation
  As an administrator
  I want to assign a graduation (vacation) period to a user and control their access to the system during that time
  So that users on leave cannot log into the system until their graduation period ends

  @graduation @new @test
  Scenario: Check that if it is possible assignment the graduation to the user in the MEİS system
    Given user with login "imranovfarid@gmail.com" and password "Farid1020@@@" logs into the "AG-MEIS" system
    And goes to the control panel
    And adds name "Abbas" and fin to the name and fin fields
    And user selects enter in the users tab
    And selects founded user from table
    And switches to the user permissions tab
    And administrator approval switcher turned off
    And current account status switcher turned off
    And page is down
    #Istifadəçiyə məzuniyyət təyin edilir
    And graduation start date is added
    And graduation end date is added
    And graduation note is added
    And user saved changes
    And goes to the control panel
    And adds name "Abbas" and fin to the name and fin fields
    And user selects enter in the users tab
    #Məzuniyyət verildikdən sonra istifadəçinin status və sistemə daxil olmasının yoxlanılması
    Then admin control is displayed as not approved in the users table
    Then status is displayed as not approved in the users table
    And user selects exit button
    #Məzuniyyətdə olan istifadəçinin sistemə daxil olması
    When user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    Then A user on vacation is unable to enter the system
    #Istifadəçidən məzuniyyətin ləğv edilməsi
    And user with login "imranovfarid@gmail.com" and password "Farid1020@@@" logs into the "AG-MEIS" system
    And goes to the control panel
    And adds name "Abbas" and fin to the name and fin fields
    And user selects enter in the users tab
    And selects founded user from table
    And switches to the user permissions tab
    And page is down
    #Məzuniyyət barədə öncəki tarixlər və qeydlər yoxlanılır
    And previous start date for graduation is displayed
    And previous end date for graduation is displayed
    And previous note for graduation is displayed
    And page is up
    And administrator approval switcher turned on
    And current account status switcher turned on
    And page is down
    And user saved changes
    And goes to the control panel
    And adds name "Abbas" and fin to the name and fin fields
    And user selects enter in the users tab
    #Istifadəçilər tabında istifadəçinin icazə statuslarının yoxlanılması
    Then admin control is displayed as a given in the users table
    Then status is displayed as a given in the users table
    When user selects exit button
    #Məzuniyyəti ləğv edildikdən sonra istifadəçinin sistemə daxil olması
    When user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    Then the user is successfully entered to the system
    #Test ssenarilər:
    #1.İstifadəçi üçün məzuniyyətin başlanma tarixinin əlavə edilməsi
    #2.İstifadəçi üçün məzuniyyətin bitmə tarixinin əlavə edilməsi
    #3.İstifadəçi üçün məzuniyyət qeydinin əlavə edilməsi
    #4.Dəyişikliklər yadda saxladıqdan sonra admin panelin istifadəçilər tabında istifadəçinin icazə statuslarının yoxlanılması
    #5.Məzuniyyət təyin edilən istifadəçinin adından sistemə giriş edilə bilməməsinin yoxlanılması
    #6.Istifadəçinin məzuniyyəti deaktiv edilmədən öncə məzuniyyət barədə təyin edilən tarixlərin və qeydin yoxlanılması
    #7.İstifadəçinin məzuniyyətini deaktiv etdikdən sonra admin panelin istifadəçilər tabında istifadəçinin icazə statuslarının yoxlanılması
    #8.İstifadəçinin məzuniyyətini deaktiv etdikdən sonra istifadəçinin sistemə uğurla daxil olmasının yoxlanılması