@all @helpDesk
Feature: Help Desk

  @executorAcceptsTheRequest @new
  Scenario: Check if the executor accepts the request for execution
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
    When selects the last appeal from the table
    And the admin assigns an executor "Davud" to the request
    #Then the executors name "Davud" and all information about execute is displayed in the request review section
    When user select go back button in the request review section
    And adds id to the id filter
    When user selects enter in the users tab
    Then current "İlkin" result is displayed
    Then executors name "Davud" is displayed
    And user selects exit button
    #Icraçının sistemə daxil olaraq bildirişin gəlməsi və məlumatlarının yoxlanılması
    And user with login "davudzamanov88@proton.me" and password "Davud8888!!!!" logs into the "AG-MEIS" system
    #Bildirişin üzərində müraciətin id-sinin yoxlanılması
##    And selects notification in the header section
##    And selects last notification from not list
##    Then the system notification and information about request are displayed
##    And executor receives the correct notification with the same ID
    And all the information is displayed in the notification sent to the executor
      | İstiqamət        | Prioritet | İcra statusu | Qeyd                                         | Müraciət edən  | İcraçı        | İstifadəçi komputeri |
      | Digər problemlər | Yüksək    | İlkin        | Xahiş olunur ki müraciətimə təcili baxılsın! | İbrahim Rzayev | Davud Zamanov | PC_7788              |
    And the executor navigates to the request review section using the detailed button
    #İcraçının müraciəti icraya qəbul etməsi
#    And selects notification in the header section
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
    And user selects exit button
    #Müraciətin statusu 'İcraya qəbul edilib' olduqda, sistemin müraciəti daxil edən şəxsə bildiriş göndərib-göndərmədiyi yoxlanılması
    And user with login "ibrahimzamanov88@proton.me" and password "Ibrahimibrahim88!!" logs into the "AG-MEIS" system
#    And selects notification in the header section
#    And selects last notification from not list
    And all the information is displayed in the notification sent to the executor
      | İstiqamət        | Prioritet | İcra statusu        | Qeyd                                           | Müraciət edən  | İcraçı        | İstifadəçi komputeri |
      | Digər problemlər | Yüksək    | İcraya qəbul edilib | Tezliklə nəticə barədə sizə məlumat veriləcək. | İbrahim Rzayev | Davud Zamanov | PC_7788              |
    #Test ssenarilər:
    #77.Bildirişin üzərində müraciətin id-sinin yoxlanılması
    #78.Bildirişin üzərində müraciətin istiqamətinin yoxlanılması
    #79.Bildirişin üzərində müraciətin prioritetin yoxlanılması
    #80.Bildirişin üzərində müraciətin icra statusunun yoxlanılması
    #81.Bildirişin üzərində müraciət qeydinin yoxlanılması
    #82.Bildirişin üzərində müraciəti edən şəxsin məlumatlarının yoxlanılması
    #83.Bildirişin üzərində müraciət icraçısı məlumatlarının yoxlanılması
    #84.Bildirişin üzərində İstifadəçi komputer məlumatlarının yoxlanılması
    #85.Bildirişin üzərində "Ətraflı" düyməsini seçərək müraciətin baxış hissəsinə keçid edilməsi
    #86.İcraçının müraciəti icraya qəbul etməsi
    #87.Müraciətin baxış bölməsində icraçının adı, icraya qəbul tarixi və icra statusunun yoxlanılması
    #88.Müraciətin "İcraya qəbul edilib" statusu və icraçı barədə məlumatların ümumi cədvəldə yoxlanılması
    #89.Müraciətin statusu 'İcraya qəbul edilib' olduqda, sistemə müraciəti daxil edən şəxsə bildiriş göndərib-göndərmədiyi yoxlanılması
    #90.Sistemə müraciəti daxil edən şəxsin sistem üzrə bütün bildiriş məlumatlarının yoxlanması yoxlanılması