@electronicLibrary @test
Feature:Training material email notification
  As a registered user with the necessary permissions,
  I want to send the created training material to the assigned person’s email address,
  So that the recipient is immediately informed and can conveniently access the training content directly from their inbox.

  @trainingMaterialEmailNotification @test
  Scenario: Check if user can sent training materials notification to the assigned persons email address
    Given user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
  #Təlim materialın əlavə edilməsi
    And goes to the control panel
    And goes to the electronic library tab in the control panel
    And selects new "training" button in the training materials tab
    And adds "Daxili təlim AT" to training name input
    And adds training date
    And adds instructor "Davud" from search list
    And selects person "İbrahim" for notification and mail
    And selects person "İbrahim" for the who sees field
    And adds note "Automaiton kurslar barədə" to the note input
    And adds file "new" for training
    And user selects save button
    And user selects exit button
  #Ünvanlanmış şəxs elektron poçt ünvanına daxil olur
    And the user "İbrahim" enters to the e-mail address
    When opens notification about "Training material" in the email
    Then all information about the "Training material" is displayed in the email notification
      | Təlim status                 | Təsvir                    | Daxili təlimçilər | Başlığı      | Tərtib edən  | Status                    | Şəxslər                      |
      | Yeni daxili təlim yaradıldı! | Automaiton kurslar barədə | Davud Zamanov     | Daxili təlim | Abbas Rzayev | Ünvanlanmış şəxslərə görə | Abbas Rzayev, İbrahim Rzayev |
    Then file for "Training material" is displayed in the email notification
    #Test ssenarilər:
    #16.Təlim materialı bildirişinin istifadəçinin elektron poçtuna yönləndirilməsi
    #17.E-poçt bildirişində təlimin status məlumatının yoxlanılması
    #18.E-poçt bildirişində təlimin təsvirinin yoxlanılması
    #19.E-poçt bildirişində təlimin tarix məlumatının yoxlanılması
    #20.E-poçt bildirişində təlimçilərin adlarının yoxlanılması
    #21.E-poçt bildirişində təlimin başlığının yoxlanılması
    #22.E-poçt bildirişində tərtib edən məlumatının yoxlanılması.
    #23.E-poçt bildirişində təlimin yaradlıma tarixinin yoxlanılması
    #24.E-poçt bildirişində statusun yoxlanılması
    #25.E-poçt bildirişində ünvanlanan şəxslərin yoxlanılması
    #26.E-poçt bildirişində əlavə edilmiş faylın mövcudluğunun yoxlanılması