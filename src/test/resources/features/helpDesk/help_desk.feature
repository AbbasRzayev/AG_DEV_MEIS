@all @helpDesk
Feature: Help Desk

  @newRequest
  Scenario: Check the creation of a new request in the help desk tab
    Given user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    And goes to the help desk tab from main page
    And selects software "Digər problemlər" selection from the direction dropdown list
    And selects appeal "Xəta" from the notification type dropdown list
    And selects "Yüksək" from the notification priority dropdown list
    And adds text "new" to the description field
    And adds "new" file in the help desk tab
    And user selects save button in the help desk tab
    When selects the last appeal from the table
    Then new request has been successfully created and all information are displayed
      | İstiqamət        | Bildirişi göndərən | Əlaqə     | İP   | Kompüterinin adı | Bildirişin tipi | Prioritet | Cari nəticə | Akt tərtib edilib | Təsvir                                       | İş yeri       |
      | Digər problemlər | Abbas Rzayev       | 553968888 | 2233 | PC_99_77         | Xəta            | Yüksək    | İlkin       | Xeyr              | Xahiş olunur ki müraciətimə təcili baxılsın! | AISTGroup MMC |
    And selects edit button in the request review section
    And selects software "Proqram təminatı" selection from the direction dropdown list
    And selects "Elektron Sənəd Dövriyyəsi" program from software dropdown list
    And selects "Təcili" from the notification priority dropdown list
    And selects appeal "Təklif" from the notification type dropdown list
    And adds text "edited" to the description field
    And adds "edited" file in the help desk tab
    And user selects save button in the help desk tab
    When selects the last appeal from the table
    Then the edited request has been successfully created and all information are displayed
      | İstiqamət        | Bildirişi göndərən | Proqram təminatı          | Əlaqə     | İP   | Kompüterinin adı | Bildirişin tipi | Prioritet | Cari nəticə | Akt tərtib edilib | Təsvir                   | İş yeri       |
      | Proqram təminatı | Abbas Rzayev       | Elektron Sənəd Dövriyyəsi | 553968888 | 2233 | PC_99_77         | Təklif          | Təcili    | İlkin       | Xeyr              | Müraciət redaktə edildi! | AISTGroup MMC |
    #Test ssenarilər əhatə edir:
    #1.İstifadəçinin Yardım masası tabından yeni müraciətin əlavə edilməsi
    #2.Yeni müraciətin göndərilmiş müraciətlər cədvəlində əks olunması
    #3.Yeni müraciətin baxış hissəsinə keçid edərək id-sinin yoxlanılması
    #4.Yeni müraciətin baxış hissəsinə keçid edərək istiqamət məlumatının yoxlanılması
    #5.Yeni müraciətin baxış hissəsinə keçid edərək bildirişi göndərən məlumatının yoxlanılması
    #6.Yeni müraciətin baxış hissəsinə keçid edərək tarix məlumatının yoxlanılması
    #7.Yeni müraciətin baxış hissəsinə keçid edərək əlaqə məlumatının yoxlanılması
    #8.Yeni müraciətin baxış hissəsinə keçid edərək ip telefon nömrəsi məlumatının yoxlanılması
    #9.Yeni müraciətin baxış hissəsinə keçid edərək istifadəçi komputerin adı məlumatının yoxlanılması
    #10.Yeni müraciətin baxış hissəsinə keçid edərək bildiriş tipi məlumatının yoxlanılması
    #11.Yeni müraciətin baxış hissəsinə keçid edərək prioritet məlumatının yoxlanılması
    #12.Yeni müraciətin baxış hissəsinə keçid edərək cari nəticə məlumatının yoxlanılması
    #13.Yeni müraciətin baxış hissəsinə keçid edərək akt tərtib edilib məlumatının yoxlanılması
    #14.Yeni müraciətin baxış hissəsinə keçid edərək fayl məlumatının mövcud və link olmasının yoxlanılması
    #15.Yeni müraciətin baxış hissəsinə keçid edərək müraciət edənin qeyd məlumatının yoxlanılması
    #16.Yeni müraciətin baxış hissəsinə keçid edərək iş yeri məlumatının yoxlanılması
    #17.Yeni müraciətin redktə edilməsi
    #18.Redaktə edildikdən sonra məlumatların yoxlanılması


  @designetPersonOnTheStructure
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