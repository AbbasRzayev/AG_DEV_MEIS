@meisAndProgramLogs @test
Feature: MEIS and program access logs
  As a system administrator
  I want to view and manage access logs for MEIS and programs
  So that I can monitor user activity, ensure security, and track unauthorized access attempts

  Scenario: Check if user login events are recorded in access logs
    And user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    And switches to the my programs tab
    And the program "E-Sened" is searched
    And the navigation to the "E-Sened" program has been successful
    And goes to the control panel
    And adds name "Abbas" and fin to the name and fin fields
    And user selects enter in the users tab
    And select founded user in the users tab in the admin panel
    When switches to the meis and program log tab
    Then the users MEIS access log information is displayed correctly
    Then the users program access log information for "Elektron Sənəd Dövriyyəsi" is displayed correctly
    #Test ssenarilər:
    #1.İstifadəçinin "MEİS-ə girişlər" bölməsində sistemə giriş loglarının gün, ay, il, tarix və saat dəqiqə məlumatlarının düzgün əks olunmasının yoxlanılması
    #2.İstifadəçinin "Proqramlara girişlər" bölməsində proqrama giriş loglarının gün, ay, il, tarix və saat dəqiqə məlumatlarının düzgün əks olunmasının yoxlanılması