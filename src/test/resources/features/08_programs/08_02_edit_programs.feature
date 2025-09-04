@programs @all
Feature: User edit programs
  As a registered user with the necessary permissions,
  I want to edit an existing program by updating its name, keyword, address, notes, API integration URL, logo, and instruction files (video/PDF),
  So that the program information remains accurate, relevant, and up to date for users who access and use it in the system.

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
      | Program Icon | First File   | Second File  | Video File   |
      | QAAT.png     | EndToEnd.pdf | EndToEnd.pdf | programs.mp4 |
    When selects the save button to create a new program
    Then the program "Light Future" is successfully created


    #Butun melumatlarin ve fayllarin redakte edilmesi
    #Axtarish hissesinde program adi ve melumatin yenilemesini yoxlanilmasi
    #Redakte edildikden sonra melumatlarin yoxlanilmasi
    #Redakte edildikden sonra faylarin yoxlanilmasi