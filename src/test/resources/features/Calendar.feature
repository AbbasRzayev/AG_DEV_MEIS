@all @Calendar
Feature: Calendar

  @AccordingToTheAddressees
  Scenario: Check if the user can add a new event according to the addressees in the calendar
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the calendar tab
    And selects new event button
    And adds name for new event
    And adds start date for new event
    And adds end date for new event
    And adds url for new event
    And selects users for new event notification
    And chooses whose calendar the event will appear on
    And sets the category for the new event
    And determines where the event will be held
    And adds the person who organized the new event
    And adds the picture for the new event
    And adds the description for the new event
    When selects submit button for the new event
    Then new event successfully created
    When user with login "rzayevmusa1234@gmail.com" and with password "Musamusa88!!" logs into the "MEIS" system
    Then the system notification and information about new event is displayed
    And user goes to the calendar tab from sidebar
    When user selects new event from calendar
    Then new event modal window and information is displayed
    Then an email about the new event is sent to the e-mail address and the information about new event is displayed
    And user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "MEIS" system
    And goes to the control panel
    And goes to the calendar tab from admin panel
    When user deletes event for person from calendar tab
    Then event for person is deleted successfully
  #1.Bütün vacib xanaları seçərək yeni tədbirin əlavə edilməsi
  #2.İdarəetmənin təqvim hissəsində yeni əlavə edilmiş tədbirin mövcud olmasının yoxlanılması
  #3.Ünvanlanmış şəxsə sistem üzrə yeni tədbir haqqında bildirişin yönəlməsi
  #4.Yeni tədbir barədə yönəlmiş bildiriş məlumatlarının yoxlanılması
  #5.Ünvanlanmış şəxsin təqvim üzərində yeni tədbirin əks olunmasının yoxlanılması
  #6.Təqvim üzərində əks olunan tədbiri seçərək, məlumatların yoxlanılması
  #7.Ünvanlanmış şəxsin elektron poçt ünvanına yeni tədbir barədə bildirişin yönəlməsi
  #8.Elektron poçt ünvanına tədbir barədə yönəlmiş bildiriş məlumatların yoxlanılması

  @AccordingToStructureDivision
  Scenario: Check if the user can add a new event according to structure division in the calendar
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the calendar tab
    And selects new event button
    And adds name for new structure event
    And adds start date for new event
    And adds end date for new event
    And adds url for new event
    And selects user for new event notification according to structure division
    And selects the event to be displayed in the calendar of selected persons within the structural unit
    And sets the category for the new event
    And determines where the event will be held
    And adds the person the new event who organized
    And adds the picture for the new event
    And adds the description for the new event
    When selects submit button for the new event
    Then new event successfully created
    When user with login "rzayevmusa1234@gmail.com" and with password "Musamusa88!!" logs into the "Meis" system
    Then the system notification and information about structure event is displayed
    And user goes to the calendar tab from sidebar
    When user selects new event for structure from calendar
    Then event modal window and information is displayed
    Then email about the new event is sent to the e-mail address and the information about new event is displayed
    And user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the control panel
    And goes to the calendar tab from admin panel
    When makes a copy of the event
    Then the copy of the event is being carried out successfully
    When user deletes all structure events from calendar tab
    Then all structure events are deleted successfully
  #Test ssenarilər:
  #9.Bütün vacib xanaları seçərək yeni tədbirin əlavə edilməsi(Struktur bölmə daxilində)
  #10.İdarəetmənin təqvim hissəsində yeni əlavə edilmiş tədbirin mövcud olmasının yoxlanılması
  #11.İstifadəçiyə (Struktur bölmə daxilində) sistem üzrə yeni tədbir haqqında bildirişin yönəlməsi
  #12.Yeni tədbir barədə yönəlmiş bildiriş məlumatlarının yoxlanılması
  #13.İstifadəçinin (Struktur bölmə daxilində) təqvim üzərində yeni tədbirin əks olunmasının yoxlanılması
  #14.Təqvim üzərində əks olunan tədbiri seçərək, məlumatların yoxlanılması
  #15.İstifadəçinin(Struktur bölmə daxilində) elektron poçt ünvanına yeni tədbir barədə bildirişin yönəlməsi
  #16.Elektron poçt ünvanına tədbir barədə yönəlmiş bildiriş məlumatların yoxlanılması
  #16.Tədbirin sürətinin çıxarılması  (Sürətini çıxar funskionlı)
  #17.Tədbirin silinməsi və sistemdə mövcudd olmamasının yoxlanılması