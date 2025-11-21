@all @helpDesk @test @not @new
Feature: Email notifications for Help Desk events
  As a registered user,
  I want to receive email notifications for important Help Desk events (such as new requests, updates, deadlines, or execution status),
  So that I stay informed and can take timely action without constantly checking the system.

  Background:
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
    And adds id to the id filter
    And user selects enter in the users tab
    And selects the last appeal from the table
    And the admin assigns an executor "Davud" to the request
    And user selects exit button

  @executorsEmailNotification   @new
  Scenario: Check if the notification about the assigned request reaches the requesters email
    And the user "Davud" enters to the e-mail address
    When opens notification about "help-desk-redirect" in the email
    Then all information about the "help-desk-assigned" is displayed in the email notification
      | İstiqamət        | Növü | Təsvir                                       | Prioritet | Müraciət edən  | İcraçı        | İstifadəçi kompüterinin adı | Cari nəticə |
      | Digər problemlər | Xəta | Xahiş olunur ki müraciətimə təcili baxılsın! | Yüksək    | İbrahim Rzayev | Davud Zamanov | PC_7788                     | Yeni        |
    Then file for "help-desk" is displayed in the email notification
    #Test ssenarilər:
    #113.Yeni müraciət barədə təyin olunmuş icraçıya elektron poçtla bildirişin yönlənidirilməsi
    #114.E-poçt bildirişində istiqamət məlumatının yoxlanılması
    #115.E-poçt bildirişində tarix məlumatının yoxlanılması
    #116.E-poçt bildirişində növü məlumatının yoxlanılması
    #117.E-poçt bildirişində təsvir məlumatının yoxlanılması
    #118.E-poçt bildirişində prioritet məlumatının yoxlanılması
    #119.E-poçt bildirişində müraciət edən məlumatının yoxlanılması
    #120.E-poçt bildirişində icraçı məlumatının yoxlanılması
    #121.E-poçt bildirişində İstifadəçi kompüterinin adı məlumatının yoxlanılması
    #122.E-poçt bildirişində cari nəticə məlumatının yoxlanılması
    #123.E-poçt bildirişində əlavə edilmiş faylın mövcudluğunun yoxlanılması


  @requestsAcceptanceReachedTheRequestersEmail   @new
  Scenario: Check if the notification about the request's acceptance reached the requester's email
    And user with login "davudzamanov88@proton.me" and password "Davud8888!!!!" logs into the "AG-MEIS" system
    And admin goes to the help desk tab from admin panel
    And adds id to the id filter
    And user selects enter in the users tab
    And selects the last appeal from the table
    And changes the status "İcraya qəbul edilib" of the request by selecting the current result
    And user selects exit button
    And the user "İbrahim" enters to the e-mail address
    When opens notification about "help-desk-redirect" in the email
    Then all information about the "help-desk-redirect" is displayed in the email notification
      | İstiqamət        | Növü | Təsvir                                       | Prioritet | Müraciət edən  | İcraçı        | İstifadəçi kompüterinin adı | Cari nəticə           | Qeyd                                           |
      | Digər problemlər | Xəta | Xahiş olunur ki müraciətimə təcili baxılsın! | Yüksək    | İbrahim Rzayev | Davud Zamanov | PC_7788                     | İcraya qəbul edi̇ldi̇ | Tezliklə nəticə barədə sizə məlumat veriləcək. |
    Then file for "help-desk" is displayed in the email notification
    #Test ssenarilər:
    #124.İcraçı müraciətin statusunu 'icraya qəbul edildi' etdikdən sonra, sistemə müraciəti daxil edənə elektron poçtla bildiriş göndərilməsi
    #125.İstifadəçiyə göndərilən e-poçtda müraciətin icraya qəbul olunduğu barədə məlumatın və müraciətlə bağlı digər detalların düzgün və tam əks olunduğunu yoxlanılması


  @executingRequestNotificationReachedToTheRequestersEmail   @new
  Scenario: Check if the notification about the executed request reached the requester's email
    And user with login "davudzamanov88@proton.me" and password "Davud8888!!!!" logs into the "AG-MEIS" system
    And admin goes to the help desk tab from admin panel
    And adds id to the id filter
    And user selects enter in the users tab
    And selects the last appeal from the table
    And changes the status "İcra edilib" of the request by selecting the current result
    And user selects exit button
    And the user "İbrahim" enters to the e-mail address
    When opens notification about "help-desk-redirect" in the email
    Then all information about the "help-desk-redirect" is displayed in the email notification
      | İstiqamət        | Növü | Təsvir                                       | Prioritet | Müraciət edən  | İcraçı        | İstifadəçi kompüterinin adı | Cari nəticə | Qeyd                                  |
      | Digər problemlər | Xəta | Xahiş olunur ki müraciətimə təcili baxılsın! | Yüksək    | İbrahim Rzayev | Davud Zamanov | PC_7788                     | İcra edilib | Qeyd edilən problem aradan qaldırıldı |
    Then file for "help-desk" is displayed in the email notification
    #Test ssenarilər:
    #126.İcraçı müraciətin statusunu 'icraya edildi' etdikdən sonra, sistemə müraciəti daxil edənə elektron poçtla bildiriş göndərilməsi
    #127.İstifadəçiyə göndərilən e-poçtda müraciətin icra edildi olunduğu barədə məlumatın və müraciətlə bağlı digər detalların düzgün və tam əks olunduğunu yoxlanılması


  @executionDeclinesNotificationReachedToTheRequestersEmail   @new
  Scenario: Check if the notification about the declines request reached the requester's email
    And user with login "davudzamanov88@proton.me" and password "Davud8888!!!!" logs into the "AG-MEIS" system
    And admin goes to the help desk tab from admin panel
    And adds id to the id filter
    And user selects enter in the users tab
    And selects the last appeal from the table
    And changes the status "İcradan imtina edilib" of the request by selecting the current result
    And user selects exit button
    And the user "İbrahim" enters to the e-mail address
    When opens notification about "help-desk-redirect" in the email
    Then all information about the "help-desk-redirect" is displayed in the email notification
      | İstiqamət        | Növü | Təsvir                                       | Prioritet | Müraciət edən  | İcraçı        | İstifadəçi kompüterinin adı | Cari nəticə           | Qeyd                                           |
      | Digər problemlər | Xəta | Xahiş olunur ki müraciətimə təcili baxılsın! | Yüksək    | İbrahim Rzayev | Davud Zamanov | PC_7788                     | İcradan imtina edilib | Bu task fix olduğuna görə icrası imtina edilib |
    Then file for "help-desk" is displayed in the email notification
    #Test ssenarilər:
    #128.İcraçı müraciətin statusunu 'icradan imtina edilib' etdikdən sonra, sistemə müraciəti daxil edənə elektron poçtla bildiriş göndərilməsi
    #129.İstifadəçiyə göndərilən e-poçtda müraciətin icradan imtina edilib olunduğu barədə məlumatın və müraciətlə bağlı digər detalların düzgün və tam əks olunduğunu yoxlanılması

  @executionDeadlinePassedNotificationReachedToTheRequestersEmail   @new
  Scenario: Check if the requester received the notification that the request's deadline has passed
    And user with login "davudzamanov88@proton.me" and password "Davud8888!!!!" logs into the "AG-MEIS" system
    And admin goes to the help desk tab from admin panel
    And adds id to the id filter
    And user selects enter in the users tab
    And selects the last appeal from the table
    And changes the status "Müddəti bitib" of the request by selecting the current result
    And user selects exit button
    And the user "İbrahim" enters to the e-mail address
    When opens notification about "help-desk-redirect" in the email
    Then all information about the "help-desk-redirect" is displayed in the email notification
      | İstiqamət        | Növü | Təsvir                                       | Prioritet | Müraciət edən  | İcraçı        | İstifadəçi kompüterinin adı | Cari nəticə   | Qeyd                  |
      | Digər problemlər | Xəta | Xahiş olunur ki müraciətimə təcili baxılsın! | Yüksək    | İbrahim Rzayev | Davud Zamanov | PC_7788                     | Müddəti bitib | İcra tarixi bitmişdir |
    Then file for "help-desk" is displayed in the email notification
    #Test ssenarilər:
    #130.İcraçı müraciətin statusunu 'müddəti bitib' etdikdən sonra, sistemə müraciəti daxil edənə elektron poçtla bildiriş göndərilməsi
    #131.İstifadəçiyə göndərilən e-poçtda müraciətin müddəti bitib olunduğu barədə məlumatın və müraciətlə bağlı digər detalların düzgün və tam əks olunduğunu yoxlanılması