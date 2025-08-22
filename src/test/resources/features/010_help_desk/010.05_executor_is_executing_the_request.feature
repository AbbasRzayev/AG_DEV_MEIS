@all @helpDesk
Feature: Executor executed the request
  As an executor,
  I want to mark a request as executed after completing the necessary work,
  So that the Help Desk system reflects the request as resolved and the requester is informed.

  @executorExecuteTheRequest @new
  Scenario: Check if the executor can execute the request
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
    #İcraçının müraciəti icraya qəbul etməsi
    And close notification in the header section
    And changes the status "İcraya qəbul edilib" of the request by selecting the current result
    When page is down
    #Müraciətin baxış bölməsində icraçının adı, icraya qəbul tarixi və icra statusunun yoxlanılması
    Then the executors name and the date the request was accepted and the execution status  are "İcraya qəbul edilib" displayed
    #Müraciətin "İcraya qəbul edilib" statusu və icraçı barədə məlumatların ümumi cədvəldə yoxlanılması
    When user select go back button in the request review section
    And adds id to the id filter
    When user selects enter in the users tab
    Then current "İcraya qəbul edilib" result is displayed
    Then executors name "Davud" is displayed
    And selects the last appeal from the table
    #İcraçı müraciətə icra barədə qeyd və akt nömrəsi əlavə edərək statusunu 'İcra edilib' olaraq dəyişməsi
    When changes the status "İcra edilib" of the request by selecting the current result
    #Akt və icra barədə məlumatların yoxlanılması
    Then information about act and execute note is displayed in the request review section
      | Akt tərtib edilib | Aktın nömrəsi | İcra haqqında təsvir                  |
      | Bəli              | AG-88         | Qeyd edilən problem aradan qaldırıldı |
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
    Then current "İcra edilib" result is displayed
    Then executors name "Davud" is displayed
    And user selects exit button
    #Müraciətin statusu 'İcraya edilib' olduqda, sistemə müraciəti daxil edən şəxsə bildiriş göndərib-göndərmədiyi yoxlanılması
    And user with login "ibrahimzamanov88@proton.me" and password "Ibrahimibrahim88!!" logs into the "AG-MEIS" system
    And all the information is displayed in the notification sent to the person who initiated the execution
      | İstiqamət        | Prioritet | İcra statusu | Qeyd                                  | Akt nömrəsi | Müraciət edən  | İcraçı        | İstifadəçi komputeri |
      | Digər problemlər | Yüksək    | İcra edilib  | Qeyd edilən problem aradan qaldırıldı | AG-88       | İbrahim Rzayev | Davud Zamanov | PC_7788              |
    #Test ssenarilər:
    #91.İcraçı müraciətə icra barədə qeyd və akt nömrəsi əlavə edərək statusunu 'İcra edilib' olaraq dəyişməsi
    #92.Müraciətin baxış hissəində akt barədə məlumatların əks olunmasının yoxlanılması
    #93.Müraciətin baxış hissəsində icra haqqında təsvir melumatların əks olunmasının yoxlanılması
    #94.Bildirişin cari nəticəsinin dəyişdirilməsi modal pəncərəsində, proqres barın 100 faiz edilərək qeydin əlavə edilməsi
    #95.Müraciətin baxış hissəində, proqres bar, tarix və qeydin yoxlanılması
    #96.Müraciətin "İcraya edilib" statusu və icraçı barədə məlumatların ümumi cədvəldə yoxlanılması
    #97.Müraciətin statusu 'İcraya edilib' olduqda, sistemə müraciəti daxil edən şəxsə bildiriş göndərib-göndərmədiyi yoxlanılması
    #98.Sistemə müraciəti daxil edən şəxsin sistem üzrə bütün bildiriş məlumatlarının yoxlanması yoxlanılması