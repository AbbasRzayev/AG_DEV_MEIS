@all @StructureAndDuties
Feature: Users structure and duties

  @StructureAndDutiesAdd
  Scenario Outline: Check if user can change his position in the structure and in his duties
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "AG-MEIS" system
    #Istifadəçi strukturun, alt şöbəsi və vəzifəsi dəyişdirilir
    And goes to the control panel
    And adds name "Abbas" and fin to the name and fin fields
    And user selects enter in the users tab
    And switches to the user change structure and duties tab
    And user selects new "<structure>" position
    And selects new "<duties>"
    And selects submit button to change structure and duties
    And goes to the control panel
    And adds name "Abbas" and fin to the name and fin fields
    When user selects enter in the users tab
    #Birinci dəyişiklərdən sonra strukturun və vəzifənin yenilənməsi, idrarəetmə paneli, istifadəçinin ümumi cədvəlində yoxlanılır
    Then after the first changes for structure and position are successfully updated in the users table
    And user enters the system from admin panel by using entrance by user name button
    And user goes to the personal cabinet
    When user goes to the my structure and position tab
    #Birinci dəyişiklərdən sonra strukturun-sektorun və vəzifənin yenilənməsi, şəxsi profil,"Strukturda yerim və vəzifəm" tabında yoxlanılır
    Then after the first changes for structure and position are successfully updated in the my structure and position tab
    #Istifadəçi strukturunun və vəzifəsinin yenidən dəyişdirilir
    And goes to the control panel
    And adds name "Abbas" and fin to the name and fin fields
    And user selects enter in the users tab
    And switches to the user change structure and duties tab
    And user selects new "<new structure>" position
    And selects new "<new duty>"
    And selects submit button to change structure and duties
    And goes to the control panel
    And adds name "Abbas" and fin to the name and fin fields
    When user selects enter in the users tab
    #İkinci dəyişiklərdən sonra strukturun və vəzifənin yenilənməsi, idrarəetmə paneli, istifadəçinin ümumi cədvəlində yoxlanılır
    Then after the second changes for structure and position are successfully updated in the users table
    And user enters the system from admin panel by using entrance by user name button
    And user goes to the personal cabinet
    When user goes to the my structure and position tab
    #İkinci dəyişiklərdən sonra strukturun-sektorun və vəzifənin yenilənməsi, şəxsi profil,"Strukturda yerim və vəzifəm" tabında yoxlanılır
    Then after the second changes for structure and position are successfully updated in the my structure and position tab
    Examples:
      | structure     | duties      | new structure          | new duty |
      | AISTGroup MMC | Şöbə Müdiri | Keyfiyyətə Nəzarət(AT) | QA_AT    |


  @StructureAddAndDelete
  Scenario: Check if user can add and then delete a new structure
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the control panel
    And switches to the structure and duties tab
    And selects plus button for adding new structure
    And adds information to the structure fields
      | structure name                | short name | company code | priority | Detailed information about the structure                               |
      | Problemli sınaq şöbələr(test) | PSŞ        | 7788         | 3        | Bu struktur automatlaşdırılmış testin tətbiqi üçün nəzərdə tutulmuşdur |
    When user adds new structure by using save button
    Then new structure has been added successfully
    When user deletes the newly added structure using the delete button
    Then newly structure has been deleted successfully

  @DutyAddAndDelete
  Scenario: Check if user can add and then delete a new duty
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the control panel
    And switches to the duties tab
    And selects plus button for adding new duty
    And adds duties name to the duty name field
    When user selects add button
    Then new duty has been added successfully
    And user deletes the newly added duty using the delete button
    Then newly duty has been deleted successfully
  #Test ssenarilər:
  #1.İstifadəçinin strukturda yerinin dəyişdirilməsi
  #2.İstifadəçinin vəzifəsinin dəyişdirilməsi
  #3.İdarəetmə hissəsi, "İstifadəçilər" tabının ümumi cədvəlində istifadəçi üçün yeni təyin edilən strukturun yoxlanılması
  #4.İdarəetmə hissəsi, "İstifadəçilər" tabının ümumi cədvəlində istifadəçi üçün yeni təyin edilən vəzifənin yoxlanılması
  #5.Şəxsi kabinetim hissəsi, "Strukturda yerim və vəzifəm" tabında istifadəçi üçün yeni təyin edilən strukturun yoxlanılması
  #6.Şəxsi kabinetim hissəsi, "Strukturda yerim və vəzifəm" tabında istifadəçi üçün yeni təyin edilən vəzifəsinin yoxlanılması


  # vəzifəsinin dəyişdirilməsi
  #2.İstifadəçinin ü dəyişdirilmiş strukturda yer və vəzifəsinin yoxlanılması
  #3.Yeni strukturun əlavə edilməsi
  #4.Yeni əlavə edilmiş strukturun sistemdə mövcud olmasının yoxlanılması
  #5.Əlavə edilmiş strukturun silinməsi
  #6.Silinmiş strukturun sistemde mövcud olmamasının yoxlanılması
  #7.Yeni vəzifənin əlavə edilməsi
  #8.Yeni əlavə edilmiş vəzifəsinin sistemdə mövcud olmasının yoxlanılması
  #9.Əlavə edilmiş strukturun silinməsi
  #10.Silinmiş strukturun sistemdə mövcud olmamasının yoxlanılması