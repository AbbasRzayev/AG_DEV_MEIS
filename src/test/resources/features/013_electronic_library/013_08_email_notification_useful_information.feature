@electronicLibrary @test
Feature:Useful information email notification
  As a registered user with the necessary permissions,
  I want to send the created useful information to the assigned person’s email address,
  So that the recipient is immediately informed and can conveniently access the training content directly from their inbox.

  @usefulInformationEmailNotification @new @test
  Scenario: Check if user can sent useful information notification to the assigned persons email address
    Given user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    And goes to the control panel
    And goes to the electronic library tab in the control panel
    And switches to the "Useful information" tab in electronic library
    And selects new "information" button in the training materials tab
    And adds "Manual Qa" to useful information name input
    And selects person "İbrahim" for notification and mail for electronic library
    And selects person "İbrahim" for the who sees field
    And adds file "new" for training
    And user selects save button
    #Ünvanlanmış şəxs elektron poçt ünvanına daxil olur
    And the user "İbrahim" enters to the e-mail address
    When opens notification about "useful information" in the email
    Then all information about the "useful information" is displayed in the email notification
      | Başlığı          | Tərtib edən  | Status                    | Şəxslər                      |
      | Useful Manual QA | Abbas Rzayev | Ünvanlanmış şəxslərə görə | Abbas Rzayev, İbrahim Rzayev |
    Then file for "Useful information" is displayed in the email notification
    #Test ssenarilər:
    #42.Faydalı məlumat bildirişinin istifadəçinin elektron poçtuna yönləndirilməsi
    #43.E-poçt bildirişində faydalı məlumat başlığının yoxlanılması
    #44.E-poçt bildirişində faydalı məlumatı tərtib edən məlumatının yoxlanılması
    #45.E-poçt bildirişində faydalı məlumatın yaradılma tarix məlumatının yoxlanılması
    #46.E-poçt bildirişində faydalı məlumat statusun yoxlanılması
    #47.E-poçt bildirişində ünvanlanan şəxslərin yoxlanılması
    #48.E-poçt bildirişində əlavə edilmiş faylın mövcudluğunun yoxlanılması