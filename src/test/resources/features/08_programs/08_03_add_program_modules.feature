@programs @all
Feature: Add program modules
  In order to extend the overall system functionality
  As a registered user with the necessary permissions
  I want to add new software modules by providing details such as:
  - Module name
  - Keyword
  - Configuration parameters
  - Information
  So that the system can expand its capabilities
  and offer additional features to end users.

  @addEditDeleteModule @new
  Scenario: Check if the user can add/edit/delete a module to the program
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
    #Modul məlumatlarının yoxlanılması
    Then the module "First Module" name details are displayed in the module modal window
    Then the module "First Key" keyword details are displayed in the module modal window
    Then the module "First module information" information details are displayed in the module modal window
    #Modulun redaktə edilməsi
    And the user selects the "Edit" button
    And the module "Second Module" name is entered
    And the keyword "Second Key" is entered
    And the information "Second module information" details are entered
    And the new module is confirmed
    Then the module "Second Module" name details are displayed in the module modal window
    Then the module "Second Key" keyword details are displayed in the module modal window
    Then the module "Second module information" information details are displayed in the module modal window
    #Modulun silinəsi
    When the user selects the "Delete" button
    Then the module has been successfully deleted
    And the module modal window is closed
    When user selects delete button to delete the program
    Then the "new" program is successfully deleted
   #Test ssenarilər:
   #18.Modul adının əlavə edilməsinin yoxlanılması
   #19.Modul açar sözünün əlavə edilməsinin yoxlanılması
   #20.Modul məlumatının əlavə edilməsinin yoxlanılması
   #21.Əlavə edilmiş modul adının "Modul üzərində əməliyyatlar" modal pəncərəsində əks olunmasının yoxlanılması
   #22.Əlavə edilmiş modul açar sözünün "Modul üzərində əməliyyatlar" modal pəncərəsində əks olunmasının yoxlanılması
   #23.Əlavə edilmiş modul məlumatının "Modul üzərində əməliyyatlar" modal pəncərəsində əks olunmasının yoxlanılması
   #24.Modul məlumatlarının redaktə olunmasının yoxlanılması
   #25.Redaktə əməliyyatından sonra modul məlumatlarının düzgün yenilənməsinin yoxlanılması
   #26.Modul məlumatının silinməsinin yoxlanılması
   #27.Silinmə əməliyyatından sonra modul məlumatlarının tam silindiyinin yoxlanılması