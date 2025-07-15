@all @helpDesk
Feature: Help Desk

  @newRequest
  Scenario: Check the creation of a new request in the help desk tab
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the help desk tab from main page
    And selects software selection from the direction dropdown list
    #And selects change password from the software dropdown list
    And selects appeal from the notification type dropdown list
    And selects high from the notification priority dropdown list
    And adds text to the description field
    And adds file in the help desk tab
    When user selects save button in the help desk tab
    Then new request has been successfully created
    #Test ssenarilər əhatə edir:
    #1.İstifadəçinin Yardım masası tabından yeni müraciət əlavə etməsi
    #2.Yeni müraciət məlumatlarının yoxlanılması


  @DesignetPersonOnTheStructure
  Scenario:Check the notification information directed to the e-mail address of the designated person on the structure
    Given test user with login "irina.kolesnikova62@mail.ru" and with password "Ibrahimibrahim88!!" logs into the "Meis" system
    And goes to the help desk tab from main page
    And selects software selection from the direction dropdown list
    And selects appeal from the notification type dropdown list
    And selects high from the notification priority dropdown list
    And adds text to the description field
    And adds file in the help desk tab
    When user selects save button in the help desk tab
    Then new help desk request has been successfully created
    Then an email about a new request has been sent to the e-mail address of the person designated in the system
    #Test ssenarilər əhatə edir:
    #3.Müraciət əlavə edilən kimi sistem üzrə təyin olunmuş şəxsin elektron poçt ünvanına bildirişin yönəlməsi
    #4.Sistem üzrə təyin olunmuş şəxsin elektron poçtuna ünvanlanmış  məlumatların yoxlanılması

  @SystemNotAndEmailNotDirectedToTheItSpecalist
  Scenario: Check system notification and email notification directed to the IT specialist
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And admin goes to the help desk tab from admin panel
    And admin selects new request from table
    When admin selects an executive person for the new request
    Then the status of the application and the name of the IT specialist are displayed in the general table
    When IT specialist with login "anjelika.huseynova60@mail.ru" and with password "Davud88!!!" logs to the system
    Then the system notification and information about request are displayed
    Then the notice arrived successfully in the mail and the information are displayed
    When IT specialist changes request status to the in process
    Then the request status successful has been changed to the in proccees
  #Test ssenarilər əhatə edir:
  #5.İnzibatçının sistemə daxil olaraq müraciəti icraçıya yönəltməsi
  #6.Müraciətin statusu və icraçının seçilməsinin ümumi cədvəldə yoxlanılması
  #7.Icraçıya sistem üzrə ona təyin olunmuş müraciət bildirişinin yönəlməsi
  #8.İcraçıya yönəlmiş bildiriş məlumatlarının yoxlanılması
  #9.Icraçının ona təyin olunmuş müraciət bildirişinin elektron poçt ünvanına yönəlməsi
  #10.Icraçının elektron poçt ünvanına yönəlmiş bildiriş məlumatlarının yoxlanılması
  #11.Icraçının müraciətin statusunu "İcraya qəbul edilib" statusuna dəyişməsi
  #12.Yardım masası hissəsində ümumi cədvəldə statusun dəyişilməsinin yoxlanılması

  @RequestSenderAndStructureDesignatedPerson
  Scenario: Request Sender And StructureDesignatedPerson
    Given user with role IT specialist logs to the system
    When IT specialist changes request status to the done
    Then the request status successful has been changed to the done
    When test user with login "irina.kolesnikova62@mail.ru" and with password "Ibrahimibrahim88!!" logs into the "Meis" system
    Then the system notification and information about request status is displayed
    Then the notification about done status arrived successfully in the mail and the information are displayed
    Then the notification about done status arrived successfully in the mail and the information are displayed to the person designated in the system
  #Test ssenarilər əhatə edir:
  #13.İcraçı müraciətin statusunu icra edildi statusuna dəyişməsi (icra edən,status,tarix yoxlanılması)
  #14.Yardım masası hissəsində ümumi cədvəldə müraciətin statusunun "İcra edildi" statusuna dəyişilməsinin yoxlanılması
  #15.Müraciəti göndərən əməkdaşa sistem üzərə bildirişin gəlməsi və məlumatların yoxlanılması
  #16.Müraciəti göndərən əməkdaşın elektron poçt ünvanına bildirişin yönəlməsi
  #17.Müraciəti göndərən əməkdaşın elektron poçt ünvanına yönəlmiş bildiriş məlumatlarının yoxlanılması
  #18.Sistem üzrə təyin olunmuş şəxsin elektron poçt ünvanına bildirişin yönəlməsi
  #19.Sistem üzrə təyin olunmuş şəxsin elektron poçt ünvanına yönəlmiş bildiriş məlumatlarının yoxlanılması