@programs @all
Feature: User creat program
  As a registered user with the necessary permissions,
  I want to create a new program by adding its name, keyword, address, notes, API integration URL, logo, and instruction files (video/PDF),
  So that the program can be successfully stored in the system and all related information is clearly available for review and future use.

  @create_program @new
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
    #Proqram məlumatlarının yoxlanılması
    Then all information is displayed in the review section of the program
      | PROGRAM NAME  | KEYWORD       | PROGRAM ADDRESS     | API URL               | NOTE                                                         |
      | Bright Future | Never Give Up | https://aist.group/ | https://aist.group/az | Avtomatlaşdırılmış İnformasiya Sistemləri və Texnologiyaları |
    Then the "new" logo is displayed in the review section of the program
    Then the "new" video instruction file is displayed in the review section of the program
    Then the "new" instruction file is displayed in the review section of the program
    Then the "new" another instruction file is displayed in the review section of the program
    #Proqramın silinməsi və yoxlanılması
    When user selects delete button to delete the program
    Then the "new" program is successfully deleted
  #Test ssenarilər:
  #1.Yeni proqramın əlavə edilməsi
  #2.Yeni yaradılan proqarmın mövcud olmasının yoxlanılması
  #3.Yeni yaradılan proqarmın baxış hissəsində proqramən adının yoxlanılması
  #4.Yeni yaradılan proqarmın baxış hissəsində açar sözün yoxlanılması
  #5.Yeni yaradılan proqarmın baxış hissəsində proqramın ünvanının yoxlanılması
  #6.Yeni yaradılan proqarmın baxış hissəsində api inteqrasiya üçün url-ın yoxlanılması
  #7.Yeni yaradılan proqarmın baxış hissəsində proqram haqqında qeydlərin yoxlanılması
  #8.Yeni yaradılan proqarmın baxış hissəsində proqram loqosunun yoxlanılması
  #9.Yeni yaradılan proqarmın baxış hissəsində video təlimatın yoxlanılması
  #10.Yeni yaradılan proqarmın baxış hissəsində təlimat faylın yoxlanılması
  #11.Yeni yaradılan proqarmın baxış hissəsində digər faylın yoxlanılması
  #12.Yeni proqarmın silinməsi
  #13.Silindikdən sonra sistemdə mövcud olmadığının yoxlanılması