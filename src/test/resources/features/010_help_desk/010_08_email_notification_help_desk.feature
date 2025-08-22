@all @helpDesk
Feature: Email notifications for Help Desk events
  As a registered user,
  I want to receive email notifications for important Help Desk events (such as new requests, updates, deadlines, or execution status),
  So that I stay informed and can take timely action without constantly checking the system.

  Background:
    Given user with login "ibrahimzamanov88@proton.me" and password "Ibrahimibrahim88!!" logs into the "AG-MEIS" system
    And goes to the help desk tab from main page
    And selects software "Digər problemlər" selection from the direction dropdown list
    And selects appeal "Xəta" from the notification type dropdown list
    And selects "Yüksək" from the notification priority dropdown list
    And adds text "new" to the description field
    And adds "new" file in the help desk tab
    And user selects save button in the help desk tab
    And selects the last appeal from the table
    When user selects exit button
    #Inzibatçının sistemə daxil olması
    And user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    And admin goes to the help desk tab from admin panel
    And adds id to the id filter
    And user selects enter in the users tab
    And selects the last appeal from the table
    And the admin assigns an executor "Davud" to the request
    And user selects exit button
  @executorsEmailNotification   @new
  Scenario: Check if the notification about the assigned request reaches the requesters email
    And the user "Davud" enters to the e-mail address
    When opens notification about "help-desk-redirect" in the email
    Then all information about the "help-desk-redirect" is displayed in the email notification
      | İstiqamət        | Növü | Təsvir                                       | Prioritet | Müraciət edən  | İcraçı        | İstifadəçi kompüterinin adı | Cari nəticə |
      | Digər problemlər | Xəta | Xahiş olunur ki müraciətimə təcili baxılsın! | Yüksək    | İbrahim Rzayev | Davud Zamanov | PC_7788                     | Yeni        |
    Then file for "help-desk" is displayed in the email notification
    #Test ssenarilər:
    #113.Yeni müraciət barədə təyin olunmuş icraçıya elektron poçtla bildirişin yönlənidirilməsi
    #114.E-poçt bildirişində istiqamət məlumatının yoxlanılması
    #115.E-poçt bildirişində tarix məlumatının yoxlanılması
    #116.E-poçt bildirişində növü məlumatının yoxlanılması
    #117.E-poçt bildirişində təsvir məlumatının yoxlanılması
    #118.E-poçt bildirişində prioritet məlumatının yoxlanılması
    #119.E-poçt bildirişində müraciət edən məlumatının yoxlanılması
    #120.E-poçt bildirişində icraçı məlumatının yoxlanılması
    #121.E-poçt bildirişində İstifadəçi kompüterinin adı məlumatının yoxlanılması
    #122.E-poçt bildirişində cari nəticə məlumatının yoxlanılması
    #123.E-poçt bildirişində əlavə edilmiş faylın mövcudluğunun yoxlanılması



#  @requestersEmailNotificationAssigned  @new
#  Scenario: Check if the notification about the assigned request reaches the executors email
#    And user with login "davudzamanov88@proton.me" and password "Davud8888!!!!" logs into the "AG-MEIS" system
#    And admin goes to the help desk tab from admin panel
#    And adds id to the id filter
#    And user selects enter in the users tab
#    And selects the last appeal from the table
#    And changes the status "İcraya qəbul edilib" of the request by selecting the current result
