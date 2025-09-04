@programs @all
Feature: Edit existing programs
  As a registered user with appropriate permissions
  I want to edit an existing program by updating its details, including:
  - Program name
  - Keyword
  - Address
  - Notes
  - API integration URL
  - Logo
  - Instruction files (Video/PDF)
  So that the program information stays accurate, relevant, and up to date
  for all users who access and use it within the system.

  @edit_program @new
  Scenario: Check if user can create program
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
    And added video to the video instruction file
    And added pdf file to the instruction file
    And added one more pdf file to the another file
    #Yeni proqarmın mövcud olmasının yoxlanılması
    When selects the save button to create a new program
    Then the program "Bright Future" is successfully created
    Then all information is displayed in the review section of the program
      | PROGRAM NAME  | KEYWORD       | PROGRAM ADDRESS     | API URL               | NOTE                                                         |
      | Bright Future | Never Give Up | https://aist.group/ | https://aist.group/az | Avtomatlaşdırılmış İnformasiya Sistemləri və Texnologiyaları |
    #Program məlumatlarının redaktə edilməsi
    And edited all information in the review section of the program
      | PROGRAM NAME | KEYWORD           | PROGRAM ADDRESS              | API URL                      | NOTE                                           |
      | Light Future | Keep your head up | https://dev-meis.aist.group/ | https://dev-meis.aist.group/ | Mərkəzləşdirilmiş Elektron İnformasiya Sistemi |
    And edited all files in the review section of the program
    When selects the save button to create a new program
    Then the program "Light Future" is successfully created
    And all edited information is displayed in the review section of the program
      | PROGRAM NAME | KEYWORD           | PROGRAM ADDRESS              | API URL                      | NOTE                                           |
      | Light Future | Keep your head up | https://dev-meis.aist.group/ | https://dev-meis.aist.group/ | Mərkəzləşdirilmiş Elektron İnformasiya Sistemi |
    Then the "edited" logo is displayed in the review section of the program
    Then the "edited" video instruction file is displayed in the review section of the program
    Then the "edited" instruction file is displayed in the review section of the program
    Then the "edited" another instruction file is displayed in the review section of the program
    When user selects delete button to delete the program
    Then the "edited" program is successfully deleted
    #Test ssenarilər:
    #14.Proqram daxilində bütün məlumatların və faylların redaktə olunması
    #15.Axtarış modulunda proqram adının və məlumatların yenilənməsinin test edilməsi
    #16.Redaktə əməliyyatından sonra məlumatların düzgünlüyünün yoxlanılması
    #17.Redaktə əməliyyatından sonra faylların düzgünlüyünün yoxlanılması