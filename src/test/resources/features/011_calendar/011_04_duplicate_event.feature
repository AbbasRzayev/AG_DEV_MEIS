@all @calendar
Feature: Duplicate event
  As a system user,
  I want to select an existing event from the calendar and use the “Sürətini çıxar” button
  So that I can duplicate the event data quickly without re-entering all the details manually.

  @duplicateEvent @new
  Scenario: Check if the user can duplicate event
    Given user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
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
#    And determines where the event "671 nömrəli otaq" will be held
    And page is down
    When selects submit button for the new event
    Then new event successfully created and all information is displayed in the control panel
      | Başlıq  | Status                    |
      | AT_TesT | Ünvanlanmış şəxslərə görə |
    And user selects duplicate event button
    And adds name "AT_Duplicate" for new event
    And page is down
    When selects submit button for the new event
    Then new event successfully created and all information is displayed in the control panel
      | Başlıq       | Status                    |
      | AT_Duplicate | Ünvanlanmış şəxslərə görə |
    And user selects exit button
    And user with login "rzayevmusa1234@gmail.com" and password "Musamusa88!!" logs into the "AG-MEIS" system
    When user goes to the calendar tab from left side bar
    Then event name "AT_Duplicate" is shown in the calendar
    #Test ssenarilər:
    #43.Tədbirin sürətinin çıxarılması
    #44.Sürəti çıxarılan tədbirin İdarəetmənin təqvim hissəsində mövcud olmamasının yoxlanılması
    #45.Sürəti çıxarılan tədbirin Təqvimin üzərində əks olunmamasının yoxlanılması