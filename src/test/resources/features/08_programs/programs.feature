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
    And added data to the program adress field
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
    Then the program successfully created
    #Proqram məlumatlarının yoxlanılması
    Then all information is displayed in the review section of the program
      | PROGRAM NAME  | KEYWORD       | PROGRAM ADDRESS     | API URL               | NOTE                                                         |
      | Bright Future | Never Give Up | https://aist.group/ | https://aist.group/az | Avtomatlaşdırılmış İnformasiya Sistemləri və Texnologiyaları |
    Then logo is displayed in the review section of the program
    Then video instruction file is displayed in the review section of the program
    Then instruction file is displayed in the review section of the program
    Then the another instruction file is displayed in the review section of the program
    #Proqramın silinməsi və yoxlanılması
    When user selects delete button to delete the program
    Then the program is successfully deleted
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






#    And selects operation on modules button
#    And adds data to the add name field in the operation on modules modal window
#      | Proqramlaşdırma |
#    And adds data to the keyword field in the operation on modules modal window
#      | Java |
#    And accepts changes in the operation on modules modal window
#    And selects close button in the operation on modules modal window
#    And selects user categories operations button
#    And adds data to the add name field in the user categories operations modal window
#      | Automation |
#    And adds data to the keyword field in the user categories operations modal window
#      | Selenium |
#    And accepts changes in the user categories operations modal window
#    And selects close button in the user categories operations modal window
#    #And opens modules from modules search list
#    #And selects modul from list
#    And goes to the control panel
##    And adds name "Abbas" and fin "19HSHLY" to the name and fin fields
#    And after searching selects founded user
#    And switches to the user programs tab
#    And finds the newly added program by using search input in the programs tab
#    And activates the program by selecting it
#    And adds module and category
#    And admin selects Log in with user name button
#    And user goes to my programs tab in the main page
#    When user selects and switches to the newly added program
#    Then user successfully switches to the program
#    And goes to the control panel
#    And user goes programs tab in the control panel
#    And finds added program by using search input in the programs tab
#    And user edits program fields
#      | Proqramın adı | Proqram haqqında qeydlər          | Proqram haqqında qeydlər | API integrasiya                | Proqramın ünvanı                  | Proqram ikonu                             |
#      | AistGroup     | Elektron xidmətlərin hazırlanması | Saytların yaradılması    | https://aist.group/az/about-us | https://aist.group/az/programming | C:\Users\User\Desktop\TestFiles\aist1.png |
#    When user selects save button in the program page
#    Then program data has been successfully changed
#    When user selects delete button to delete the program
#    Then the program is successfully deleted




#  2. Proqrama modul və katepqriyaların əlavə edilməsi
#  3. Əlavə edilmiş proqramın sistemdə mövcud olmasının təstiqi
#  4. Adminin userin proqrama daxil olması üçün idarəetmə panlindən proqramın aktivləşdirilməsi (+ modul/kateqproiya) və təstiqləməsi
#  5. Userin proqrama daxil olması
#  6. Proqramın redaktə edilməsi
#  7. Proqramın silinməsi