@all @calendar
Feature: Create Calendar
  As a user
  I want to create a new calendar
  So that I can schedule and manage events effectively

  @newEventCreation @new @test
  Scenario: Check if the user can add a new event
    Given user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    #Bütün vacib xanaları seçərək yeni tədbirin əlavə edilməsi
    And goes to the calendar tab
    And selects new event button
    And adds name "AT_TesT" for new event
    And selects category "Elan" for a new event
    And adds start date and time "00:30" for new event
    And adds end date and time "17:00" for new event
    And adds reminder "00:15" notification for the event
    And adds the person "Abbas" who organized the new event
    And adds url "https://aist.group/" for new event
    And selects user "Musa" for new event notification
    And selects user "Musa" for status view according to the addressees
    And adds the description "Tədbir AT elanı məqsədi ilə əlavə edildi!" for the new event
    And determines where the event "671 nömrəli otaq" will be held
    And adds the picture "Test" for the new event
    And adds the file "QaAutomation" for the new event
    And page is down
    When selects submit button for the new event
    Then new event successfully created and all information is displayed in the control panel
      | Başlıq  | Status                    |
      | AT_TesT | Ünvanlanmış şəxslərə görə |
    And user selects exit button
    #Ünvanlanmış şəxsə sistem üzrə yeni tədbir haqqında bildirişin yönəlməsi ve məlumatların yoxlanılması
    And user with login "rzayevmusa1234@gmail.com" and password "Musamusa88!!" logs into the "AG-MEIS" system
    And all the information about event is displayed in the notification
      | Tədbirin adı | Kateqoriya | Tədbirin keçiriləcəyi yer | Tədbiri təşkil edən | Tərtib edən  | Bildiriş statusu     | Baxış statusu        | Şəxslər     | Başlama vaxtı | Bitmə vaxtı | Url                 | Tip         | Təsvir                                    |
      | AT_TesT      | Elan       | 671 nömrəli otaq          | Abbas Rzayev        | Abbas Rzayev | Ünvanlanmış şəxslərə | Ünvanlanmış şəxslərə | Musa Rzayev | 00:30         | 17:00       | https://aist.group/ | Xəbərdarlıq | Tədbir AT elanı məqsədi ilə əlavə edildi! |
    And select close button in the notification modal window
    And page is reloaded
    When user goes to the calendar tab from left side bar
    #Təqvimin üzərində tədbirin əks olunması və məlumatların yoxlanılması
    Then event name "AT_TesT" is shown in the calendar
    When select event "AT_TesT" from calendar
    Then all the information about event is displayed in the event modal window
      | Tədbirin adı | Kateqoriya | Tədbirin keçiriləcəyi yer | Tədbiri təşkil edən | Tərtib edən  | Bildiriş statusu     | Baxış statusu        | Şəxslər     | Başlama vaxtı | Bitmə vaxtı | Url                 | Tip         | Təsvir                                    |
      | AT_TesT      | Elan       | 671 nömrəli otaq          | Abbas Rzayev        | Abbas Rzayev | Ünvanlanmış şəxslərə | Ünvanlanmış şəxslərə | Musa Rzayev | 00:30         | 17:00       | https://aist.group/ | Xəbərdarlıq | Tədbir AT elanı məqsədi ilə əlavə edildi! |
    #Test ssenarilər:
    #1.Bütün vacib xanaları seçərək yeni tədbirin əlavə edilməsi
    #2.İdarəetmənin təqvim hissəsində yeni əlavə edilmiş tədbirin mövcud olmasının yoxlanılması
    #3.İdarəetmənin təqvim hissəsində yeni tədbirin "Başlıq"-adının, vaxtın və statusun yoxlanılması
    #4.Bildirişin üzərində tədbirin ad(başlığ) məlumatlarının yoxlanılması
    #5.Bildirişin üzərində tədbirin "Kateqoriya" məlumatlarının edənyoxlanılması
    #6.Bildirişin üzərində tədbirin "Tədbirin keçiriləcəyi yer" məlumatlarının yoxlanılması
    #7.Bildirişin üzərində tədbirin "Tədbiri təşkil edən" məlumatlarının yoxlanılması
    #8.Bildirişin üzərində tədbirin "Tərtib edən" məlumatlarının yoxlanılması
    #9.Bildirişin üzərində tədbirin "Baxış statusu" məlumatlarının yoxlanılması
    #10.Bildirişin üzərində tədbirin "Şəxslər" məlumatlarının yoxlanılması
    #11.Bildirişin üzərində tədbirin "Başlama tarixi" məlumatlarının yoxlanılması
    #12.Bildirişin üzərində tədbirin "Başlama vaxtı" məlumatlarının yoxlanılması
    #13.Bildirişin üzərində tədbirin "Bitmə vaxtı" məlumatlarının yoxlanılması
    #14.Bildirişin üzərində tədbirin "Url" məlumatlarının yoxlanılması
    #15.Bildirişin üzərində tədbirin "Tip" məlumatlarının yoxlanılması
    #16.Bildirişin üzərində tədbirin "Təsvir" məlumatlarının yoxlanılması
    #17.Bildirişin üzərində tədbirin "Fayl" məlumatlarının yoxlanılması
    #18.Təqvimin üzərində tədbirin əks olunmasının yoxlanılması
    #19.Təqvimin üzərində təqvimi seçərək tədbir məlumatlarının əks olunan modal pəncərəyə keçid etməsi
    #20.Tədbir modal pəncərəsində tədbirin ad məlumatlarının yoxlanılması
    #21.Tədbir modal pəncərəsində tədbirin "Kateqoriya" məlumatlarının yoxlanılması
    #22.Tədbir modal pəncərəsində tədbirin "Tədbirin keçiriləcəyi yer" məlumatlarının yoxlanılması
    #23.Tədbir modal pəncərəsində tədbirin "Tədbiri təşkil edən" məlumatlarının yoxlanılması
    #24.Tədbir modal pəncərəsində tədbirin "Tərtib edən" məlumatlarının yoxlanılması
    #25.Tədbir modal pəncərəsində tədbirin "Bildiriş statusu" məlumatlarının yoxlanılması
    #26.Tədbir modal pəncərəsində tədbirin "Baxış statusu (Təqvimində görünsün)" məlumatlarının yoxlanılması
    #27.Tədbir modal pəncərəsində tədbirin "Şəxslər" məlumatlarının yoxlanılması
    #28.Tədbir modal pəncərəsində tədbirin "Başlama tarixi" məlumatlarının yoxlanılması
    #29.Tədbir modal pəncərəsində tədbirin "Başlama vaxtı" məlumatlarının yoxlanılması
    #30.Tədbir modal pəncərəsində tədbirin "Bitmə vaxtı" məlumatlarının yoxlanılması
    #31.Tədbir modal pəncərəsində tədbirin "Url" məlumatlarının yoxlanılması
    #32.Tədbir modal pəncərəsində tədbirin "Tip" məlumatlarının yoxlanılması
    #33.Tədbir modal pəncərəsində tədbirin "Təsvir" məlumatlarının yoxlanılması