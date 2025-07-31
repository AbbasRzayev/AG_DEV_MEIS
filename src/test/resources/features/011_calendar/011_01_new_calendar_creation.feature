@all @calendar
Feature: Calendar

  @newCalendarCreation @new
  Scenario: Check if the user can add a new event
    Given user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    #Bütün vacib xanaları seçərək yeni tədbirin əlavə edilməsi
    And goes to the calendar tab
    And selects new event button
    And adds name "AT_TesT" for new event
    And selects category "Elan" for a new event
    And adds start date and time "15:00" for new event
    And adds end date and time "17:00" for new event
    And adds reminder "14:45" notification for the event
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
    #unvanlanan shex bildirish gelmesi ve melumatlarinin yoxlanilmasi
    And user with login "rzayevmusa1234@gmail.com" and password "Musamusa88!!" logs into the "AG-MEIS" system
    And all the information about event is displayed in the notification
      | Tədbirin adı | Kateqoriya | Tədbirin keçiriləcəyi yer | Tədbiri təşkil edən | Tərtib edən  | Bildiriş statusu     | Baxış statusu        | Şəxslər                    | Başlama tarixi | Başlama vaxtı | Bitmə vaxtı | Url                 | Tip         | Təsvir                                    |
      | AT_TesT      | Elan       | 671 nömrəli otaq          | Abbas Rzayev        | Abbas Rzayev | Ünvanlanmış şəxslərə | Ünvanlanmış şəxslərə | Davud Zamanov, Musa Rzayev | 31.07.2025     | 15:00         | 17:00       | https://aist.group/ | Xəbərdarlıq | Tədbir AT elanı məqsədi ilə əlavə edildi! |



#    When user with login "rzayevmusa1234@gmail.com" and with password "Musamusa88!!" logs into the "MEIS" system
#    Then the system notification and information about new event is displayed
#    And user goes to the calendar tab from sidebar
#    When user selects new event from calendar
#    Then new event modal window and information is displayed
#    Then an email about the new event is sent to the e-mail address and the information about new event is displayed
#    And user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "MEIS" system
#    And goes to the control panel
#    And goes to the calendar tab from admin panel
#    When user deletes event for person from calendar tab
#    Then event for person is deleted successfully

  #1.Bütün vacib xanaları seçərək yeni tədbirin əlavə edilməsi
  #2.İdarəetmənin təqvim hissəsində yeni əlavə edilmiş tədbirin mövcud olmasının yoxlanılması
  #3.İdarəetmənin təqvim hissəsində yeni tədbirin "Başlıq"-adının, vaxtın və statusun yoxlanılması
  #4.


  #3.Ünvanlanmış şəxsə sistem üzrə yeni tədbir haqqında bildirişin yönəlməsi
  #4.Yeni tədbir barədə yönəlmiş bildiriş məlumatlarının yoxlanılması
  #5.Ünvanlanmış şəxsin təqvim üzərində yeni tədbirin əks olunmasının yoxlanılması
  #6.Təqvim üzərində əks olunan tədbiri seçərək, məlumatların yoxlanılması
  #7.Ünvanlanmış şəxsin elektron poçt ünvanına yeni tədbir barədə bildirişin yönəlməsi
  #8.Elektron poçt ünvanına tədbir barədə yönəlmiş bildiriş məlumatların yoxlanılması