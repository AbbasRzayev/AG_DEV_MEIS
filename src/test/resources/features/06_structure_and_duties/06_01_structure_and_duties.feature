@all @structure_and_duties @new
Feature: Users structure and duties

  @structure_and_duties_add
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
    #Test ssenarilər:
    #1.İstifadəçinin strukturda yerinin dəyişdirilməsi
    #2.İstifadəçinin vəzifəsinin dəyişdirilməsi
    #3.İdarəetmə hissəsi,"İstifadəçilər" tabının ümumi cədvəlində istifadəçi üçün yeni təyin edilən strukturun yoxlanılması
    #4.İdarəetmə hissəsi,"İstifadəçilər" tabının ümumi cədvəlində istifadəçi üçün yeni təyin edilən vəzifənin yoxlanılması
    #5.Şəxsi kabinetim hissəsi,"Strukturda yerim və vəzifəm" tabında istifadəçi üçün yeni təyin edilən strukturun yoxlanılması
    #6.Şəxsi kabinetim hissəsi,"Strukturda yerim və vəzifəm" tabında istifadəçi üçün yeni təyin edilən vəzifəsinin yoxlanılması