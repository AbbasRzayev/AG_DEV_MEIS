@all @calendar
Feature: Delete Calendar
  As a user
  I want to delete an existing calendar
  So that I can remove calendars that are no longer needed

  @deleteEvent @new
  Scenario: Check if the user can edit a new event
    Given user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    And goes to the calendar tab
    And selects new event button
    And adds name "AT_Delete" for new event
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
      | Başlıq    | Status                    |
      | AT_Delete | Ünvanlanmış şəxslərə görə |
    When new event is deleted
    Then the deleted event is not displayed in the control panel
    And user selects exit button
    And user with login "rzayevmusa1234@gmail.com" and password "Musamusa88!!" logs into the "AG-MEIS" system
    When user goes to the calendar tab from left side bar
    Then the deleted event is not shown in the calendar
    #Test ssenarilər:
    #40.Yeni tədbir əlavə edildikdən sonra silinməsi
    #41.Silinən tədbirin İdarəetmənin təqvim hissəsində mövcud olmamasının yoxlanılması
    #42.Silinən tədbirin Təqvimin üzərində əks olunmamasının yoxlanılması

  #Silindikden sonra sistem ve email bilidiş getmir.Bu səbəbdən indiki halda autotestlər yazmaq mümkün olmadı