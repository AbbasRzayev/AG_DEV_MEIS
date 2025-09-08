@programs @all
Feature: Add user categories for programs
  In order to extend the overall system functionality
  As a registered user with the necessary permissions
  I want to add new user categories by providing details such as:
  - Category name
  - Keyword
  - Configuration parameters
  - Information
  So that the system can expand its capabilities
  and offer additional features to end users.

  @addEditDeleteUserCategory @new
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
    Then the module "First Category" name details are displayed in the module modal window
    Then the module "First Key for Category" keyword details are displayed in the module modal window
    Then the module "First Category information" information details are displayed in the module modal window
    And the user selects the "Edit" button
    And the module "Second Category" name is entered
    And the keyword "Second Key for Category" is entered
    And the information "Second Category information" details are entered
    And the new module is confirmed
    Then the module "Second Category" name details are displayed in the module modal window
    Then the module "Second Key for Category" keyword details are displayed in the module modal window
    Then the module "Second Category information" information details are displayed in the module modal window
    When the user selects the "Delete" button
    Then the category has been successfully deleted
    And the module modal window is closed
    When user selects delete button to delete the program
    Then the "new" program is successfully deleted
   #Test Ssenariləri:
   #28.İstifadəçi kateqoriya adının əlavə edilməsinin yoxlanılması
   #29.Kateqoriya açar sözünün əlavə edilməsinin yoxlanılması
   #30.Kateqoriya məlumatının əlavə edilməsinin yoxlanılması
   #31.İstifadəçi kateqoriyaya modulun təyin edilməsinin yoxlanılması
   #32.Əlavə edilmiş kateqoriya adının "Kateqoriya üzərində əməliyyatlar" modal pəncərəsində əks olunmasının yoxlanılması
   #33.Əlavə edilmiş kateqoriya açar sözünün "Kateqoriya üzərində əməliyyatlar" modal pəncərəsində əks olunmasının yoxlanılması
   #34.Əlavə edilmiş kateqoriya məlumatının "Kateqoriya üzərində əməliyyatlar" modal pəncərəsində əks olunmasının yoxlanılması
   #35.Kateqoriya məlumatlarının redaktə olunmasının yoxlanılması
   #36.Redaktə əməliyyatından sonra kateqoriya məlumatlarının düzgün yenilənməsinin yoxlanılması
   #37.Kateqoriya məlumatının silinməsinin yoxlanılması
   #38.Silinmə əməliyyatından sonra kateqoriya məlumatlarının tam silindiyinin yoxlanılması