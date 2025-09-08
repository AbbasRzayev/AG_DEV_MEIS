@programs @all
Feature: Assign program to user
As a system administrator (or a user with the necessary permissions)
I want to assign an existing program to a specific user
So that the user can access, manage, and utilize the assigned program within the system

  @userProgramAssignment @new
  Scenario: Check if the user can add/edit/delete a user category for the program
    Given user with login "imranovfarid@gmail.com" and password "Farid1020@@@" logs into the "AG-MEIS" system
    And switches to the my programs tab
    #Yeni proqramın əlavə edilməsi
    And select new program button
    And added data to the program name and to the keyword field
      | PROGRAM NAME  | KEYWORD       |
      | Bright Future | Never Give Up |
    And added data to the program address field
      | https://aist.group/ |
    And added data to the notes about programs field
      | Avtomatlaşdırılmış İnformasiya Sistemləri və Texnologiyaları |
    And added data to the url for api integration field
      | https://aist.group/az |
    And added program icon
    When selects the save button to create a new program
    Then the program "Bright Future" is successfully created
    And the user selects the "Operations on Modules" button
    And the module "First Module" name is entered
    And the keyword "First Key" is entered
    And the information "First module information" details are entered
    And the new module is confirmed
    And the module modal window is closed
    And the user selects the "User category" button
    And the module "First Category" name is entered
    And the keyword "First Key for Category" is entered
    And the information "First Category information" details are entered
    And the "First Module" module is assigned to the category
    And the new module is confirmed
    And the module modal window is closed
    And goes to the control panel
    And adds name "Abbas" and fin to the name and fin fields
    And user selects enter in the users tab
    And switches to the user programs tab
    And the program "Bright Future" is searched
    And the user "activates" the program
    And the program is selected for assigning user categories and modules
    And the "First Module" module is selected for the program
    And the "First Category" category is selected for the program
    And selects save button
    And user selects exit button
    And user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    And switches to the my programs tab
    And the program "Bright Future" is searched
    Then the navigation to the program has been successful
    And goes to the control panel
    And switches to the programs tab from control panel
    And the program "Bright Future" is searched
    And the program is selected
    When user selects delete button to delete the program
    Then the "new" program is successfully deleted
    #Test ssenarilər:
    #39.Yeni proqramın istifadəçi üçün aktivləşdirilməsinin yoxlanılması
    #40.Modul və kateqoriyanın proqrama təyin edilməsinin yoxlanılması
    #41.İstifadəçinin sistemə daxil olaraq "Proqramlarım" bölməsində ona təyin edilmiş proqramı görməsinin yoxlanılması
    #42.Proqrama daxil olduqdan sonra URL-in düzgünlüyünün yoxlanılması