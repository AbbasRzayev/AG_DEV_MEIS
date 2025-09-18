@AnnouncementsAndCongratulations @All
Feature:Announcements and Congratulations

  @AnnouncementAccordingToTheAddressees
  Scenario: Check that if user can add then delete announcements according to the addressees
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the control panel
    And goes to the announcements tab from admin panel
    And selects plus button for adding new "announcement"
    And adds "TestElanForPerson" name
    And adds "Bu elanın məqsədi automatlaşdırılmış təstlərin keçməsi üçün nəzərdə tutulmuşdur." description
    And adds url for announcement
    And selects announcement type "new"
    And selects the status of the announcement according to the addressees
    And adds main picture for announcement
    #And adds additional photo for announcement
    And adds video for announcement
    When user selects save button
    Then new announcement according to the addressees successfully added
    When user with login "rzayevmusa1234@gmail.com" and with password "Musamusa88!!" logs into the "Meis" system
    Then the system notification and information about announcements according to the address  is displayed
    When user goes to the announcements tab from side bare
    Then announcement according to the address and information about it is displayed
    Then email about the new announcement according to the address is sent to the e-mail address and the information about new is announcement displayed
    And user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the control panel
    And goes to the announcements tab from admin panel
    When user deletes announcements for person from admin panel
    Then announcements for person is deleted successfully
  #Test ssenarilər:
  #1.Yeni elanın əlavə edilməsi (Ünvanlanmış şəxslərə görə)
  #2.Ünvanlanmış şəxsə sistem üzrə yeni elan barədə bildirişin gəlməsi
  #3.Ünvanlanmış şəxsin Elanlar tabında yeni elanın mövcud olması və məlumatların yoxlanılması
  #4.Ünvanlanmış şəxsin elektron poçt ünvanına yeni elan barədə bildirişin yönəlməsi
  #5.Elektron poçt ünvanına elan barədə yönəlmiş bildiriş məlumatların yoxlanılması
  #6.Elanın(Ünvanlanmış şəxs) sistemdən silinməsi
  #7.Silinən elanən sistemdə mövcud olmamasının yoxlanması


  @AnnouncementAccordingToTheStructure
  Scenario: Check that if user can add then delete announcements according to the structure
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the control panel
    And goes to the announcements tab from admin panel
    And selects plus button for adding new "congratulation"
    And adds "TestElanForStructure" name
    And adds "Bu elanın məqsədi automatlaşdırılmış təstlərin keçməsi üçün nəzərdə tutulmuşdur." description
    And adds url for announcement
    And selects announcement type
    And selects the status of the announcement according to the structure
    And adds main picture for announcement
    And adds video for announcement
    When user selects save button
    Then new announcement according to the structure successfully added
    When user with login "rzayevmusa1234@gmail.com" and with password "Musamusa88!!" logs into the "Meis" system
    Then the system notification and information about announcements to the structure is displayed
    When user goes to the announcements tab from side bare
    Then announcement according to the structure and information about it is displayed
    Then email about the new announcement according to the structure is sent to the e-mail address and the information is announcement displayed
    And user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the control panel
    And goes to the announcements tab from admin panel
    When user deletes according to the structure from admin panel
    Then according to the structure is deleted successfully
  #8.Yeni elanın əlavə edilməsi (Struktur bölmə daxilində)
  #9.İstifadəçiyə(Struktur bölmə daxilində) sistem üzrə yeni elan barədə bildirişin gəlməsi
  #10.İstifadəçinin(Struktur bölmə daxilində) Elanlar tabında yeni elanın mövcud olması və məlumatların yoxlanılması
  #11.İstifadəçinin(Struktur bölmə daxilində) elektron poçt ünvanına yeni elan barədə bildirişin yönəlməsi
  #12.Elektron poçt ünvanına elan(Struktur bölmə daxilində) barədə yönəlmiş bildiriş məlumatların yoxlanılması
  #13.Elanın(Struktur bölmə daxilində) sistemdən silinməsi
  #14.Silinən elanın sistemdə mövcud olmamasının yoxlanması

  @AnnouncementAccordingToThePublicOpen
  Scenario: Check that if user can add then delete announcements according to the public open
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the control panel
    And goes to the announcements tab from admin panel
    And selects plus button for adding new announcement
    And adds "TestElanForPublicOpen" name
    And adds "Bu elanın məqsədi automatlaşdırılmış təstlərin keçməsi üçün nəzərdə tutulmuşdur." description
    And adds url for announcement for public open
    And selects announcement type
    And adds main picture for announcement
    And adds video for announcement for public open
    When user selects save button
    Then new announcement according to the public open successfully added
    When user with login "rzayevmusa1234@gmail.com" and with password "Musamusa88!!" logs into the "Meis" system
    Then the system notification and information about announcements according to the public open is displayed
    When user goes to the announcements tab from side bare
    Then announcement according to the public open and information about it is displayed
    When user goes to the announcements tab from authorization page
    Then announcement according to the public open and information about it is displayed in the authorization page
    Then email about the new announcement according to the public open is sent to the e-mail address and the information is announcement displayed
    And user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the control panel
    And goes to the announcements tab from admin panel
    When user deletes according to the public open from admin panel
    Then according to the public open is deleted successfully
#15.Yeni elanın əlavə edilməsi (Ümumi açıq)
#16.İstifadəçiyə(Ümumi açıq) sistem üzrə yeni elan barədə bildirişin gəlməsi
#17.İstifadəçinin(Ümumi açıq) Elanlar tabında yeni elanın mövcud olması və məlumatların yoxlanılması
#18.Autorizasiya səhifəsinin elanlar hissəsində yeni elanın mövcud olması və məlumatların yoxlanılması
#19.Istifadəçinin(Ümumi açıq) elektron poçt ünvanına yeni elan barədə bildirişin yönəlməsi
#20.Elektron poçt ünvanına elan barədə yönəlmiş bildiriş məlumatların yoxlanılması
#21.Elanın(Ümumi açıq) sistemdən silinməsi
#22.Silinən elanın sistemdə mövcud olmamasının yoxlanması


  @CongratulationsAccordingToTheAddressees
  Scenario: Check that if user can add then delete congratulations according to the addressees
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the control panel
    And goes to the congratulations tab from admin panel
    And selects plus button for adding new congratulations
    And adds "Congratulations according to the addressees" name
    And adds "Test Automation, integrates automation tools and processes into the overall Quality Assurance strategy. It involves using automated testing tools and frameworks to enhance the efficiency and effectiveness of the testing process." description
    And adds url for congratulations
    And selects congratulations type
    And selects the status of the congratulations according to the addressees
    And adds main picture for congratulations
    And adds video for congratulations
    When user selects save button
    Then new congratulations according to the addressees successfully added
    When user with login "rzayevmusa1234@gmail.com" and with password "Musamusa88!!" logs into the "Meis" system
    Then the system notification and information about congratulations according to the address  is displayed
    When user goes to the congratulations tab from side bare
    Then congratulations according to the address and information about it is displayed
    Then email about the new congratulations according to the address is sent to the e-mail address and the information about new congratulations is displayed
    And user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the control panel
    And goes to the congratulations tab from admin panel
    When user deletes congratulations for person from admin panel
    Then congratulations for person is deleted successfully
  #23.Yeni təbrikin əlavə edilməsi (Ünvanlanmış şəxslərə görə)
  #24.Ünvanlanmış şəxsə sistem üzrə yeni təbrik barədə bildirişin gəlməsi
  #25.Ünvanlanmış şəxsin Təbriklər tabında yeni təbrikin mövcud olması və məlumatların yoxlanılması
  #26.Ünvanlanmış şəxsin elektron poçt ünvanına yeni təbrik barədə bildirişin yönəlməsi
  #27.Elektron poçt ünvanına təbrik barədə yönəlmiş bildiriş məlumatların yoxlanılması
  #28.Təbrikin(Ünvanlanmış şəxslərə görə) sistemdən silinməsi
  #29.Silinən təbrikin sistemdə mövcud olmamasının yoxlanması


  @CongratulationsAccordingToTheStructure
  Scenario: Check that if user can add then delete congratulations according to the structure
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the control panel
    And goes to the congratulations tab from admin panel
    And selects plus button for adding new congratulations
    And adds "Congratulations according to the structure" name
    And adds "Test Automation, integrates automation tools and processes into the overall Quality Assurance strategy. It involves using automated testing tools and frameworks to enhance the efficiency and effectiveness of the testing process." description
    And adds url for congratulations
    And selects congratulations type
    And selects the status of the congratulations according to the structure
    And adds main picture for congratulations
    And adds video for congratulations
    When user selects save button
    Then new congratulations according to the structure successfully added
    When user with login "rzayevmusa1234@gmail.com" and with password "Musamusa88!!" logs into the "Meis" system
    Then the system notification and information about congratulations to the structure is displayed
    When user goes to the congratulations tab from side bare
    Then congratulations according to the structure and information about it is displayed
    Then email about the new congratulations according to the structure is sent to the e-mail address and the information about new congratulations is displayed
    And user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the control panel
    And goes to the congratulations tab from admin panel
    When user deletes congratulations according to the structure from admin panel
    Then congratulations according to the structure is deleted successfully
#30.Yeni təbrikin əlavə edilməsi (Struktur bölmə daxilində)
#31.İstifadəçiyə(Struktur bölmə daxilində) sistem üzrə yeni təbrik barədə bildirişin gəlməsi
#32.İstifadəçinin(Struktur bölmə daxilində) Təbriklər tabında yeni elanın mövcud olması və məlumatların yoxlanılması
#33.İstifadəçinin(Struktur bölmə daxilində) elektron poçt ünvanına yeni təbrik barədə bildirişin yönəlməsi
#34.Elektron poçt ünvanına elan(Struktur bölmə daxilində) barədə yönəlmiş bildiriş məlumatların yoxlanılması
#35.Təbrikin(Struktur bölmə daxilində) sistemdən silinməsi
#36.Silinən təbrikin sistemdə mövcud olmamasının yoxlanması


  @CongratulationsAccordingToThePublicOpen
  Scenario: Check that if user can add then delete congratulations according to the public open
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the control panel
    And goes to the congratulations tab from admin panel
    And selects plus button for adding new congratulations
    And adds "Congratulations according to the public open" name
    And adds "Test Automation, integrates automation tools and processes into the overall Quality Assurance strategy. It involves using automated testing tools and frameworks to enhance the efficiency and effectiveness of the testing process." description
    And adds url for congratulations for public open
    And selects congratulations type
    And adds main picture for congratulations
    And adds video for congratulations for public open
    When user selects save button
    Then new congratulations according to the public open successfully added
    When user with login "rzayevmusa1234@gmail.com" and with password "Musamusa88!!" logs into the "Meis" system
    Then the system notification and information about congratulations according to the public open is displayed
    When user goes to the congratulations tab from side bare
    Then congratulations according to the public open and information about it is displayed
#    When user goes to the announcements tab from authorization page
#    Then congratulations according to the public open and information about it is displayed in the authorization page
    Then email about the new congratulations according to the public open is sent to the e-mail address and the information is displayed
    And user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the control panel
    And goes to the congratulations tab from admin panel
    When user deletes congratulations to the public open from admin panel
    Then congratulations to the public open is deleted successfully
#37.Yeni təbrikin əlavə edilməsi (Ümumi açıq)
#38.İstifadəçiyə(Ümumi açıq) sistem üzrə yeni təbrik barədə bildirişin gəlməsi
#39.İstifadəçinin(Ümumi açıq) Təbriklər tabında yeni elanın mövcud olması və məlumatların yoxlanılması
#40.Autorizasiya səhifəsinin təbriklər hissəsində yeni təbrikin mövcud olması və məlumatların yoxlanılması
#41.Istifadəçinin(Ümumi açıq) elektron poçt ünvanına yeni təbrik barədə bildirişin yönəlməsi
#42.Elektron poçt ünvanına elan barədə yönəlmiş bildiriş məlumatların yoxlanılması
#43.Təbrikin(Ümumi açıq) sistemdən silinməsi
#44.Silinən təbrikin sistemdə mövcud olmamasının yoxlanması