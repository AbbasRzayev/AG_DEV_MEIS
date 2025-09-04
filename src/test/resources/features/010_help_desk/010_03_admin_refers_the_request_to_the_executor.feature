@all @helpDesk @test
Feature: Request refers to the executor
  As a Help Desk administrator,
  I want to be able to refer a request to a specific executor or responsible person,
  So that the request is assigned correctly, tracked efficiently, and resolved by the right executor within the system.

  @referRequestToTheExecutor @new
  Scenario: Check if admin can refer the request to the executor
    Given user with login "ibrahimzamanov88@proton.me" and password "Ibrahimibrahim88!!" logs into the "AG-MEIS" system
    And goes to the help desk tab from main page
    And selects software "Digər problemlər" selection from the direction dropdown list
    And selects appeal "Xəta" from the notification type dropdown list
    And selects "Yüksək" from the notification priority dropdown list
    And adds text "new" to the description field
    And adds "new" file in the help desk tab
    And user selects save button in the help desk tab
    And selects the last appeal from the table
    When user selects exit button
    #Inzibatçının sistemə daxil olması
    And user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    And admin goes to the help desk tab from admin panel
    #Yeni müraciətin id-sinə görə müraciəti tapılması və cari nəticə ilə İcraçıların yoxlanılması
    And adds id to the id filter
    When user selects enter in the users tab
    Then current "İlkin" result is displayed
    Then executors name "none" is displayed
    #Müraciətə daxil olaraq bütün məlumatların yoxlanılması
    When selects the last appeal from the table
    Then all information are displayed in the request review section from admin panel
      | İstiqamət        | Bildirişi göndərən | İstifadəçi kompüterinin adı | Bildirişin tipi | Prioritet | Cari nəticə | Akt tərtib edilib | Təsvir                                       | İş yeri       |
      | Digər problemlər | İbrahim Rzayev     | PC_7788                     | Xəta            | Yüksək    | İlkin       | Xeyr              | Xahiş olunur ki müraciətimə təcili baxılsın! | AISTGroup MMC |
    #İnzibatçı müraciətə icraçı təyin edir və müraciətin baxış hissəsində təyin olunan icraçı və müraciətin statusu yoxlanılması
    When the admin assigns an executor "Fərid" to the request
    #Then the executors name "Fərid" and all information about execute is displayed in the request review section - bugfixden sonra realize edecem
    #Müraciətin statusu və icraçı barədə məlumatların ümumi cədvəldə yoxlanılması
    When user select go back button in the request review section
    And adds id to the id filter
    When user selects enter in the users tab
    Then current "İlkin" result is displayed
    Then executors name "Fərid" is displayed
    #İnzibatçı müraciətdən icraçını silərək əvəz etməsi
    When selects the last appeal from the table
    And changes the status "İlkin" of the request by selecting the current result
    And page is down
    And admin removed the executor
    #Silinən icraçının müraciətin baxış hissəsində və ümumi cədvəldə mövcud olmamasının yoxlanılması
    Then the deleted executor was successfully removed in the request section
    And user select go back button in the request review section
    And adds id to the id filter
    When user selects enter in the users tab
    Then the deleted executor is not displayed in the requests table
    And selects the last appeal from the table
    #Əvəz edilən icraçının sənədin baxış hissəsində və ümumi cədvəldə əks olunmasının yoxlanılması
    And the admin assigns an executor "Davud" to the request
    #Then the executors name "Davud" and all information about execute is displayed in the request review section
    When user select go back button in the request review section
    And adds id to the id filter
    When user selects enter in the users tab
    Then current "İlkin" result is displayed
    Then executors name "Fərid" is displayed
    #Test ssenarilər:
    #68.Admin panel hissəsi,Yardım masası tabına keçid edilməsi
    #69.Ümumi cədvəldən yeni müraciətin id-sinə görə axtarış edərək, cari statusunun "İlkin" və icraçıların olmamasının yoxlanılması
    #70.Müraciətə daxil olaraq bütün məlumatların yoxlanılması
    #71.İnzibatçı müraciətə icraçı təyin etməsi
    #72.Müraciətin baxış hissəsində təyin olunan icraçı və müraciətin statusunun yoxlanılması
    #73.Ümumi cədvəldə cari statusun "İlkin" və təyin olunan icraçı adının əks olunması
    #74.İnzibatçı müraciətdən icraçını silərək əvəz etməsi
    #75.Silinən icraçının müraciətin baxış hissəsində və ümumi cədvəldə mövcud olmamasının yoxlanılması
    #76.Əvəz edilən icraçının sənədin baxış hissəsində və ümumi cədvəldə əks olunmasının yoxlanılması