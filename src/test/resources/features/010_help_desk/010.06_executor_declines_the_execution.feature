@all @helpDesk @test
Feature: Executor decline the execution
  As an executor,
  I want to decline the execution of a request with a reason,
  So that the Help Desk administrator can reassign or take necessary action to ensure the request is handled properly.

  @executorDeclinesTheExecutionOfTheRequest @new
  Scenario: Check if the executor can declines the execution of the request
    Given user with login "ibrahimzamanov88@proton.me" and password "Ibrahimibrahim88!!" logs into the "AG-MEIS" system
    And goes to the help desk tab from main page
    And selects software "Digər problemlər" selection from the direction dropdown list
    And selects appeal "Xəta" from the notification type dropdown list
    And selects "Yüksək" from the notification priority dropdown list
    And adds text "new" to the description field
    And adds "new" file in the help desk tab
    And user selects save button in the help desk tab
    And selects the last appeal from the table
    And user selects exit button
    #Inzibatçının sistemə daxil olması
    And user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    And admin goes to the help desk tab from admin panel
    #Yeni müraciətin id-sinə görə müraciəti tapılması və cari nəticə ilə İcraçıların yoxlanılması
    And adds id to the id filter
    When user selects enter in the users tab
    Then current "İlkin" result is displayed
    Then executors name "none" is displayed
    When selects the last appeal from the table
    And the admin assigns an executor "Davud" to the request
    And user selects exit button
    #Then the executors name "Davud" and all information about execute is displayed in the request review section
    #Icraçının sistemə daxil olaraq bildirişin gəlməsi və məlumatlarının yoxlanılması
    And user with login "davudzamanov88@proton.me" and password "Davud8888!!!!" logs into the "AG-MEIS" system
    #Bildirişin üzərində müraciətin id-sinin yoxlanılması
    And all the information is displayed in the notification sent to the executor
      | İstiqamət        | Prioritet | İcra statusu | Müraciət edən  | İcraçı        | İstifadəçi komputeri |
      | Digər problemlər | Yüksək    | İlkin        | İbrahim Rzayev | Davud Zamanov | PC_7788              |
    And the executor navigates to the request review section using the detailed button
    #İcraçının müraciəti statusunu "İcradan imtina edilib" etməsi
    And close notification in the header section
    And changes the status "İcradan imtina edilib" of the request by selecting the current result
    When page is down
    #Müraciətin baxış bölməsində icraçının adı, icraya qəbul tarixi və icra statusunun yoxlanılması
    Then the executors name and the date the request was accepted and the execution status  are "İcradan imtina edilib" displayed
    #Müraciətin "İcradan imtina edilib" statusu və icraçı barədə məlumatların ümumi cədvəldə yoxlanılması
    When user select go back button in the request review section
    And adds id to the id filter
    When user selects enter in the users tab
    Then current "İcradan imtina edilib" result is displayed
    Then executors name "Davud" is displayed
    And selects the last appeal from the table
    #Akt və icra barədə məlumatların yoxlanılması
    Then information about the decline execute is displayed in the request review section
      | Akt tərtib edilib | İcra haqqında təsvir                           |
      | Xeyr              | Bu task fix olduğuna görə icrası imtina edilib |
    #Proqres barın 100 faiz edilərək qeydin əlavə edilməsi
    When page is down
    And executor selects edit ticket button
    And note to the note field in the ticket modal window
    And raises the "100%"  percentage of the execution
    When user selects accept button
    #Baxış hissəində, proqres bar, tarix və qeydin yoxlanılması
    #Qeyde buuuuuuuuuuuuuug var
    Then "100%" percentage and tickets note are displayed in the request review section
    #Müraciətin "İcraya edilib" statusu və icraçı barədə məlumatların ümumi cədvəldə yoxlanılması
    When user select go back button in the request review section
    And adds id to the id filter
    When user selects enter in the users tab
    Then current "İcradan imtina edilib" result is displayed
    Then executors name "Davud" is displayed
    And user selects exit button
    #Müraciətin statusu 'İcradan imtina edilib' olduqda, sistemə müraciəti daxil edən şəxsə bildiriş göndərib-göndərmədiyi yoxlanılması
    And user with login "ibrahimzamanov88@proton.me" and password "Ibrahimibrahim88!!" logs into the "AG-MEIS" system
    And all the information is displayed about decline request in the notification sent to the person who initiated the execution
      | İstiqamət        | Prioritet | İcra statusu          | Qeyd                                           | Müraciət edən  | İcraçı        | İstifadəçi komputeri |
      | Digər problemlər | Yüksək    | İcradan imtina edilib | Bu task fix olduğuna görə icrası imtina edilib | İbrahim Rzayev | Davud Zamanov | PC_7788              |
    #Test ssenarilər:
    #99.İcraçı müraciətə icra barədə qeyd əlavə edərək statusunu 'İcradan imtina edilib' olaraq dəyişməsi
    #100.Müraciətin baxış hissəsində icra haqqında(imtina) təsvir melumatların əks olunmasının yoxlanılması
    #101.Bildirişin cari nəticəsinin dəyişdirilməsi modal pəncərəsində, proqres barın 100 faiz edilərək qeydin əlavə edilməsi
    #102.Müraciətin baxış hissəində, proqres barın və qeydin yoxlanılması
    #103.Müraciətin "İcradan imtina edilib" statusu və icraçı barədə məlumatların ümumi cədvəldə yoxlanılması
    #104.Müraciətin statusu 'İcradan imtina edilib' olduqda, sistemə müraciəti daxil edən şəxsə bildiriş göndərib-göndərmədiyi yoxlanılması
    #105.Sistemə müraciəti daxil edən şəxsin sistem üzrə bütün bildiriş məlumatlarının yoxlanması yoxlanılması