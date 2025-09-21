@all @calendar
Feature: Edit Calendar
  As a user
  I want to edit an existing calendar
  So that I can update its information

  @editEvent @new @test
  Scenario: Check if the user can edit a new event
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
    #Yeni tədbirin redaktə edilməsi
    And goes to the control panel
    And goes to the calendar tab from admin panel
    And selects edit button for the new event
    And adds name "AT_Edited" for new event
    And selects category "İcazə" for a new event
    And adds start date and time "00:50" for new event
    And adds end date and time "19:00" for new event
    And adds reminder "00:30" notification for the event
    And adds the person "Davud" who organized the new event
    And adds url "https://dev-meis.aist.group/auth" for new event
    And selects user "Davud" for new event notification
    And selects user "Davud" for status view according to the addressees
    And adds the description "Tədbir test məqsədi ilə redaktə edildi." for the new event
    And determines where the event "İclas zalı" will be held
    And adds the picture "QAAT" for the new event
    And adds the file "EndToEnd" for the new event
    And page is down
    When selects submit button for the new event
    #İdarəetmənin təqvim hissəsində redaktə edildikdən sonra tədbirin "Başlıq"-adının, vaxtın və statusun yoxlanılması
    Then new event successfully created and all information is displayed in the control panel
      | Başlıq    | Status                    |
      | AT_Edited | Ünvanlanmış şəxslərə görə |
    And user selects exit button
    And user with login "davudzamanov88@proton.me" and password "Davud8888!!!!" logs into the "AG-MEIS" system
    #Ünvanlanmış şəxsə sistem üzrə redaktə edildikdən sonra tədbir haqqında bildirişin yönəlməsi ve məlumatların yoxlanılması
    And all the information about event is displayed in the notification
      | Tədbirin adı | Kateqoriya | Tədbirin keçiriləcəyi yer | Tədbiri təşkil edən | Tərtib edən  | Bildiriş statusu     | Baxış statusu        | Şəxslər       | Başlama vaxtı | Bitmə vaxtı | Url                              | Tip         | Təsvir                                  |
      | AT_Edited    | İcazə      | İclas zalı                | Davud Zamanov       | Abbas Rzayev | Ünvanlanmış şəxslərə | Ünvanlanmış şəxslərə | Davud Zamanov | 00:50         | 19:00       | https://dev-meis.aist.group/auth | Xəbərdarlıq | Tədbir test məqsədi ilə redaktə edildi. |
    And select close button in the notification modal window
    And page is reloaded
    When user goes to the calendar tab from left side bar
    #Redaktə edildikdən sonra Təqvimin üzərində tədbirin əks olunması  və məlumatların yoxlanılması
    Then event name "AT_Edited" is shown in the calendar
    When select event "AT_Edited" from calendar
    Then all the information about event is displayed in the event modal window
      | Tədbirin adı | Kateqoriya | Tədbirin keçiriləcəyi yer | Tədbiri təşkil edən | Tərtib edən  | Bildiriş statusu     | Baxış statusu        | Şəxslər       | Başlama vaxtı | Bitmə vaxtı | Url                              | Tip         | Təsvir                                  |
      | AT_Edited    | İcazə      | İclas zalı                | Davud Zamanov       | Abbas Rzayev | Ünvanlanmış şəxslərə | Ünvanlanmış şəxslərə | Davud Zamanov | 00:50         | 19:00       | https://dev-meis.aist.group/auth | Xəbərdarlıq | Tədbir test məqsədi ilə redaktə edildi. |
    And user select escape button
    When user goes to the calendar tab from left side bar
    Then the event is "AT_Edited" successfully deleted from calendar
    #Test ssenarilər:
    #34.Yeni tədbirin redaktə edilməsi
    #35.İdarəetmənin təqvim hissəsində redaktə edildikdən sonra tədbirin "Başlıq"-adının, vaxtın və statusun yoxlanılması
    #36.Ünvanlanmış şəxsə sistem üzrə redaktə edildikdən sonra tədbir haqqında bildirişin yönəlməsi
    #37.Ünvanlanmış şəxsə sistem üzrə redaktə edildikdən bildiriş modal pəncərəsində məlumatların yoxlanılması
    #38.Redaktə edildikdən sonra Təqvimin üzərində tədbirin əks olunması
    #39.Redaktə edildikdən sonra tədbir modal pəncərəsində məlumatların yoxlanılması