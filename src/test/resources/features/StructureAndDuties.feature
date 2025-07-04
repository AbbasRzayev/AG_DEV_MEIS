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
    #Test ssenarilər:
    #1.İstifadəçinin strukturda yerinin dəyişdirilməsi
    #2.İstifadəçinin vəzifəsinin dəyişdirilməsi
    #3.İdarəetmə hissəsi,"İstifadəçilər" tabının ümumi cədvəlində istifadəçi üçün yeni təyin edilən strukturun yoxlanılması
    #4.İdarəetmə hissəsi,"İstifadəçilər" tabının ümumi cədvəlində istifadəçi üçün yeni təyin edilən vəzifənin yoxlanılması
    #5.Şəxsi kabinetim hissəsi,"Strukturda yerim və vəzifəm" tabında istifadəçi üçün yeni təyin edilən strukturun yoxlanılması
    #6.Şəxsi kabinetim hissəsi,"Strukturda yerim və vəzifəm" tabında istifadəçi üçün yeni təyin edilən vəzifəsinin yoxlanılması



  @StructureAddAndEditThenDelete
  Scenario: Check if user can add and edit then delete a new structure
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "AG-MEIS" system
    And goes to the control panel
    And switches to the structure and duties tab
    And selects plus button for adding new structure
    #Yeni struktur əlavə edilir
    And adds information to the structure fields
      | STRUCTURE NAME             | SHORT NAME | COMPANY CODE | PRIORITY | SUN  | TIN  | ADDRESS  | DETAILED INFORMATION ABOUT THE STRUCTURE                               |
      | Avtomatlaşdırılmış Testlər | AT         | 7788         | 3        | AZ12 | AZ45 | Baku st. | Bu struktur automatlaşdırılmış testin tətbiqi üçün nəzərdə tutulmuşdur |
    When user select the save button in the structure modal window
    #idarəetmə və strukturun baxış hissəsində bütün məlumatlar yoxlanılır
    Then new structural is successfully added in the admin panel of the structure and position tab
    Then all information about the new structural is displayed in the structure preview section in the admin panel of the structure and position tab
      | STRUCTURE NAME             | SHORT NAME | COMPANY CODE | PRIORITY | SUN  | TIN  | ADDRESS  | DETAILED INFORMATION ABOUT THE STRUCTURE                               |
      | Avtomatlaşdırılmış Testlər | AT         | 7788         | 3        | AZ12 | AZ45 | Baku st. | Bu struktur automatlaşdırılmış testin tətbiqi üçün nəzərdə tutulmuşdur |
    #Yeni struktur bütün məlumatları redaktə edilir
    And user edit all information for the new structure
      | STRUCTURE NAME          | SHORT NAME | COMPANY CODE | PRIORITY | SUN  | TIN  | ADDRESS     | DETAILED INFORMATION ABOUT THE STRUCTURE            |
      | Keyfiyyət mütəxəsisləri | KM         | 1122         | 4        | AZ77 | AZ88 | Səbayıl st. | Bu struktur keyfiyyət üzrə mütəxəsisləri yetişdirir |
    When user select the save button in the structure modal window
    #Redaktə edildikdən sonra idarəetmə və strukturun baxış hissəsində bütün məlumatların yenilənməsi yoxlanılır
    Then new structural is successfully edited in the admin panel of the structure and position tab
    Then all information about the new structural is displayed after edition in the structure preview section in the admin panel of the structure and position tab
      | STRUCTURE NAME          | SHORT NAME | COMPANY CODE | PRIORITY | SUN  | TIN  | ADDRESS     | DETAILED INFORMATION ABOUT THE STRUCTURE            |
      | Keyfiyyət mütəxəsisləri | KM         | 1122         | 4        | AZ77 | AZ88 | Səbayıl st. | Bu struktur keyfiyyət üzrə mütəxəsisləri yetişdirir |
    #Struktura yeni şöbənin əlavə edilir
    And user adds new department to the structure
      | STRUCTURE NAME | SHORT NAME | COMPANY CODE | PRIORITY | SUN  | TIN  | ADDRESS     | DETAILED INFORMATION ABOUT THE STRUCTURE            |
      | Nəzarət şöbəsi | NŞ         | 5577         | 5        | AZ88 | AZ97 | Yasamal st. | Bu struktur keyfiyyət üzrə mütəxəsisləri yetişdirir |
    When user select the save button in the structure modal window
    #idarəetmə və şöbənin baxış hissəsində bütün məlumatlar yoxlanılır
    Then new department is successfully added in the admin panel of the structure and position tab
    Then all information about the new department is displayed in the structure preview section in the admin panel of the structure and position tab
      | STRUCTURE NAME | SHORT NAME | COMPANY CODE | PRIORITY | SUN  | TIN  | ADDRESS     | DETAILED INFORMATION ABOUT THE STRUCTURE            |
      | Nəzarət şöbəsi | NŞ         | 5577         | 5        | AZ88 | AZ97 | Yasamal st. | Bu struktur keyfiyyət üzrə mütəxəsisləri yetişdirir |
    #Şöbəyə yeni sektor əlavə edilir
    And user adds new sector to the department
      | STRUCTURE NAME         | SHORT NAME | COMPANY CODE | PRIORITY | SUN  | TIN   | ADDRESS     | DETAILED INFORMATION ABOUT THE STRUCTURE            |
      | Avtomalaşdırma sektoru | AS         | 5852         | 6        | AZ99 | AZ928 | Səbayıl st. | Bu struktur keyfiyyət üzrə mütəxəsisləri yetişdirir |
    #idarəetmə və sektorun baxış hissəsində bütün məlumatlar yoxlanılır
    When user select the save button in the structure modal window
    Then new sector is successfully added in the admin panel of the structure and position tab
    Then all information about the new sector is displayed in the structure preview section in the admin panel of the structure and position tab
      | STRUCTURE NAME         | SHORT NAME | COMPANY CODE | PRIORITY | SUN  | TIN   | ADDRESS     | DETAILED INFORMATION ABOUT THE STRUCTURE            |
      | Avtomalaşdırma sektoru | AS         | 5852         | 6        | AZ99 | AZ928 | Səbayıl st. | Bu struktur keyfiyyət üzrə mütəxəsisləri yetişdirir |
    And goes to the control panel
    And adds name "Abbas" and fin to the name and fin fields
    And user selects enter in the users tab
    When switches to the user change structure and duties tab
    #Yeni struktur,şöbə və sektorun idarəetmə panelində istifadəçiyə təyin edilən hissədə əks olunması
    Then the new structure is successfully displayed in the my structure and position tab
    Then the new department is successfully displayed in the my structure and position tab
    Then the new sector is successfully displayed in the my structure and position tab
    And goes to the control panel
    And switches to the structure and duties tab
    #Idarəetmə hissəsindən sektorun, şöbənin silinməsi və silindikdən sonra mövcud olmadıqlarının yoxlanılması
    When user deletes the newly added sector using the delete button
    Then the sector has been deleted successfully
    When user deletes the newly added department using the delete button
    Then the department has been deleted successfully
    When user deletes the newly added structure using the delete button
    Then the structure has been deleted successfully
    #Test ssenarilər:
    #6.Yeni strukturun əlavə edilməsi
    #7.İdarəetmə panelində yeni strukturun mövcud olmasının yoxlanılması
    #8.Struktur baxış hissəsində "Strukturun adı" məlumatlarının düzgünlüyünün yoxlanılması
    #9.Struktur baxış hissəsində "Strukturun qısa adı" məlumatlarının düzgünlüyünün yoxlanılması
    #10.Struktur baxış hissəsində "Müəssisənin kodu" məlumatlarının düzgünlüyünün yoxlanılması
    #11.Struktur baxış hissəsində "Prioritet" məlumatlarının düzgünlüyünün yoxlanılması
    #12..Struktur baxış hissəsində "Strukturun ünvanı" məlumatlarının düzgünlüyünün yoxlanılması
    #13..Struktur baxış hissəsində "Strukturun VÖEN-i" məlumatlarının düzgünlüyünün yoxlanılması
    #14.Struktur baxış hissəsində "Strukturun ünvanı" məlumatlarının düzgünlüyünün yoxlanılması
    #15.Struktur baxış hissəsində "Struktur haqqında ətraflı məlumat" məlumatlarının düzgünlüyünün yoxlanılması
    #16.Yeni strukturun redaktə edilməsi
    #17.Redaktə edildikdən sonra strukturun yenilənmış bütün məlumatlarının admin panel və strukturun baxış hissəsində yoxlanılması
    #18.Struktura yeni şöbənin əlavə edilməsi
    #19.İdarəetmə panelində struktura əlavə edilən şöbənin movcud olmasının yoxlanılması
    #20.Şöbənin baxış hissəsində bütün məlumatların düzgünlüyünün yoxlanılması
    #21.Şöbəyə yeni sektorun əlavə edilməsi
    #22.İdarəetmə panelində şöbəyə əlavə edilən sektorun movcud olmasının yoxlanılması
    #23.Şöbənin baxış hissəsində bütün məlumatların düzgünlüyünün yoxlanılması
    #24.İstifadəçiyə yeni struktur təyin edilmə hissəsində yeni strukturun əks olunmasının yoxlanılması
    #25.İstifadəçiyə yeni struktur təyin edilmə hissəsində yeni şöbənin əks olunmasının yoxlanılması
    #26.İstifadəçiyə yeni struktur təyin edilmə hissəsində yeni sektorun əks olunmasının yoxlanılması
    #27.Yeni sektorun silinməsi
    #28.Silindikdən sonra idarəetmə panelinde silinən sektorun mövcud olmamasının yoxlanılması
    #29.Yeni şöbənin silinməsi
    #30.Silindikdən sonra idarəetmə panelinde silinən şöbənin mövcud olmamasının yoxlanılması
    #31.Yeni sektorun silinməsi
    #32.Silindikdən sonra idarəetmə panelinde silinən strukturun mövcud olmamasının yoxlanılması


  @DutyAddAndDelete
  Scenario: Check if user can add and edit then delete a new duty
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "AG-MEIS" system
    And goes to the control panel
    And switches to the structure and duties tab
    And switches to the duties tab
    And selects plus button for adding new duty
    And adds duties name to the duty name field
    And adds priority name to the priority name field
    And user "deactivated" the duty
    #Yeni vəzifənin əlavə edilməsi
    And user selects add duty button
    And adds duties name to the duties name field in the filter
    When user selects enter in the duties tab
    #İdarəetmə panelində yeni vəzifənin mövcud olmasının yoxlanılması
    #İdarəetmə panelində yeni vəzifənin adına görə nəticələrin yoxlanılması
    #Adına görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    Then search results by name and new duty is displayed in the admin panel
    When user reset the changes for duty
    Then the changes is successfully resets in the duty tab
    #İdarəetmə panelində yeni vəzifənin id-sinə görə nəticələrin yoxlanılması
    #Id-sinə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    And adds duties id to the duties id field in the filter
    When user selects enter in the duties tab
    Then search results by id and new duty is displayed in the admin panel
    When user reset the changes for id duty
    Then the changes is successfully resets in the duty tab
    #İdarəetmə panelində deaktiv olan vəzifənin statusuna görə nəticələrin yoxlanılması
    #Deaktiv olan vəzifənin statusuna görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    And user search for a deactivated duty
    Then search results by deactivated duty is displayed in the admin panel
    When user reset the changes for status duty
    Then the changes is successfully resets in the duty tab
    #Deaktiv olan vəzifəni istifaçiyə təyin etməyin mümkün olmamasının yoxlanılması
    And goes to the control panel
    And adds name "Abbas" and fin to the name and fin fields
    And user selects enter in the users tab
    And switches to the user change structure and duties tab
    When selects new "<IT Mühəndis(QA)>"
    And page is reloaded
#    Then the deactivated duty is not displayed in the duty selection list
    #İdarəetmə panelində aktiv olan vəzifənin statusuna görə nəticələrin yoxlanılması
    #Aktiv olan vəzifənin statusuna görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    And goes to the control panel
    And switches to the structure and duties tab
    And switches to the duties tab
    And adds duties id to the duties id field in the filter
    When user selects enter in the duties tab
    And user "activated" the duty
    When user reset the changes for id duty
    And user search for a activate duty
    Then search results by activated duty is displayed in the admin panel
    #Aktiv olan vəzifənin statusuna görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes for status duty
    Then the changes is successfully resets in the duty tab
     #Aktiv olan vəzifəni istifaçiyə təyin etməyin mümkün olmasının yoxlanılması
    And goes to the control panel
    And adds name "Abbas" and fin to the name and fin fields
    And user selects enter in the users tab
    And switches to the user change structure and duties tab
    When selects new "<IT Mühəndis(QA)>"
    Then the active duty is displayed in the duty selection list
    And page is reloaded
    #Yeni vəzifənin redaktə edilməsi
    And goes to the control panel
    And switches to the structure and duties tab
    And switches to the duties tab
    And adds duties id to the duties id field in the filter
    And user selects enter in the duties tab
    When changes name and priority from edit modal window
    #Redaktə edildikdən sonra vəzifənin yenilənmış məlumatların yoxlanılması
    Then new duty is successfully edited
    #Yeni vəzifənin silinməsi və silinnın vəzifənin mövcud olmamasının yoxlanılması
    And user deletes the newly added duty using the delete button
    Then newly duty has been deleted successfully
  #Test ssenarilər:
  #33.Yeni vəzifənin əlavə edilməsi
  #34.İdarəetmə panelində yeni vəzifənin mövcud olmasının yoxlanılması
  #35.İdarəetmə panelində yeni vəzifənin adına görə nəticələrin yoxlanılması
  #36.Adına görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
  #37.İdarəetmə panelində yeni vəzifənin id-sinə görə nəticələrin yoxlanılması
  #38.id-sinə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
  #39.İdarəetmə panelində deaktiv olan vəzifənin statusuna görə nəticələrin yoxlanılması
  #40.Deaktiv olan vəzifənin statusuna görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
  #41.Deaktiv olan vəzifəni istifaçiyə təyin etməyin mümkün olmamasının yoxlanılması
  #42.İdarəetmə panelində aktiv olan vəzifənin statusuna görə nəticələrin yoxlanılması
  #43.Aktiv olan vəzifənin statusuna görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
  #44.Aktiv olan vəzifəni istifaçiyə təyin etməyin mümkün olmasının yoxlanılması
  #45.Yeni vəzifənin redaktə edilməsi
  #46.Redaktə edildikdən sonra vəzifənin yenilənmış məlumatların yoxlanılması
  #47.Yeni vəzifənin silinməsi
  #48.Silindikdən sonra idarəetmə panelinde silinən vəzifənin mövcud olmamasının yoxlanılması