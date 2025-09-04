@electronicLibrary @test
Feature:Electronic journal notification
  As a registered user with the necessary permissions,
  I want to send the created electronic journal to the assigned person’s email address,
  So that the recipient is immediately informed and can conveniently access the training content directly from their inbox.

  @electronicJournalEmailNotification @new @test
  Scenario: Check if user can sent electronic journal notification to the assigned persons email address
    Given user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    #Elektron jurnalın əlavə edilməsi
    And goes to the control panel
    And goes to the electronic library tab in the control panel
    And switches to the "Electronic journal" tab in electronic library
    And selects new "journal" button in the training materials tab
    And adds "Journal Manual" to journal name input
    And adds "7777" to journal number input
    And adds journal date
    And selects person "İbrahim" for notification and mail for electronic library
    And selects person "İbrahim" for the who sees field
    And adds file "new" for training
    And user selects save button
    #Ünvanlanmış şəxs elektron poçt ünvanına daxil olur
    And the user "İbrahim" enters to the e-mail address
    When opens notification about "Journal Manual" in the email
    Then all information about the "Journal Manual" is displayed in the email notification
      | Başlığı        | Tərtib edən  | Jurnalın buraxılış nömrəsi | Status                    | Şəxslər                      |
      | Journal Manual | Abbas Rzayev | 7777                       | Ünvanlanmış şəxslərə görə | Abbas Rzayev, İbrahim Rzayev |
    Then file for "Journal Manual" is displayed in the email notification
    #Test ssenarilər:
    #65.Elektron jurnal bildirişinin istifadəçinin elektron poçtuna yönləndirilməsi
    #66.E-poçt bildirişində elektron jurnal başlığının yoxlanılması
    #67.E-poçt bildirişində elektron jurnalı tərtib edən məlumatının yoxlanılması
    #68.E-poçt bildirişində elektron jurnalı yaradılma tarix məlumatının yoxlanılması
    #69.E-poçt bildirişində elektron jurnalı Jurnalın buraxılış nömrə məlumatının yoxlanılması
    #70.E-poçt bildirişində elektron jurnalın statusunun yoxlanılması
    #71.E-poçt bildirişində ünvanlanan şəxslərin yoxlanılması
    #72.E-poçt bildirişində əlavə edilmiş faylın mövcudluğunun yoxlanılması