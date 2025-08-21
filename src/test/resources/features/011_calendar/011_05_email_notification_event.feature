@all @calendar
Feature: Even email notification
  As a user,
  I want the scheduled event details to be automatically sent via email to the assigned participants,
  So that they are informed in a timely manner and can effectively follow the planned event.

  @eventEmail @new
  Scenario: Check if the scheduled event automatically sent via email to the assigned participants
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
    And selects user "İbrahim" for new event notification
    And selects user "İbrahim" for status view according to the addressees
    And adds the description "Tədbir AT elanı məqsədi ilə əlavə edildi!" for the new event
    And determines where the event "671 nömrəli otaq" will be held
    And adds the picture "Test" for the new event
    And adds the file "QaAutomation" for the new event
    And page is down
    And selects submit button for the new event
    #Ünvanlanmış şəxs elektron poçt ünvanına daxil olur
    And the user "İbrahim" enters to the e-mail address
    When opens notification about "Training material" in the email

    #Test ssenarilər:
    #46.
    #47.
    #48.