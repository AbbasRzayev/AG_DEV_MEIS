@electronicLibrary
Feature:Create training material
  As a registered user with the necessary permissions,
  I want to create a new training material by adding its title, content, attachments, and relevant metadata,
  So that employees or participants can easily access and benefit from the training content in the system

  @trainingMaterial @new
  Scenario: Check if user can add new training materials
    Given user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    #Təlim materialın əlavə edilməsi
    And goes to the control panel
    And goes to the electronic library tab in the control panel
    And selects new training button in the training materials tab
    And adds "Daxili təlim AT" to training name input
    And adds training date
    And adds instructor "Davud" from search list
    And selects person "İbrahim" for notification and mail
    And selects person "İbrahim" for the who sees field
    And adds note "Automaiton kurslar barədə" to the note input
    And adds file "new" for training
    And user selects save button
    And user selects exit button
    #İdarəetmə hissəsində təlim məlumatlarının yoxlanılması
    And user with login "davudzamanov88@proton.me" and password "Davud8888!!!!" logs into the "AG-MEIS" system
    And goes to the control panel
    When goes to the electronic library tab in the control panel
    Then all information about the training material is displayed in the table in the admin panel
      | Təlimin adı  | Təlimçi            | Təlim materialları | Baxış sayı |
      | Daxili təlim | Davud Zamanov Musa | QaAutomation.pdf   | 0          |
    And user selects exit button
    #Ünvalanan şəxs sistemə daxil olduqda təlim barədə bildirişin yönəlməsi
    And user with login "ibrahimzamanov88@proton.me" and password "Ibrahimibrahim88!!" logs into the "AG-MEIS" system
    And all the information about training material is displayed in the notification
      | Başlıq                                |
      | Daxili təlim başlıqlı təlim yaradıldı |
    And select close button in the notification modal window
    And page is reloaded
    And goes to the electronic library tab from main page
    Then all information about the training material is displayed in the table in the admin panel
      | Təlimin adı  | Təlimçi            | Təlim materialları | Baxış sayı |
      | Daxili təlim | Davud Zamanov Musa | QaAutomation.pdf   | 0          |
    #Baxış sayının artmasının yoxlanması
    And user opens the document view modal window
    And uploads a video from the document view modal window
    When user closes the document view modal window
    Then an increase is observed in the view count data
  #Test ssenarilər:
  #1.Yeni təlim materialın əlavə edilməsi
  #2.İdarəetmə panelində əlavə edilən təlimin mövcud olmasının yoxlanılması
  #3.İdarəetmə panelində əlavə edilən təlimin adı məlumatının yoxlanılması
  #4.İdarəetmə panelində əlavə edilən təlimçi məlumatının yoxlanılması
  #5.İdarəetmə panelində əlavə edilən təlim materialları məlumatının yoxlanılması
  #6.İdarəetmə panelində əlavə edilən baxış sayı məlumatının yoxlanılması
  #7.Ünvalanan şəxs sistemə daxil olduqda təlim barədə bildirişin yönəlməsi
  #8.Təlim barədə bildiriş məlumatlarının yoxlanması
  #9.Ünvanlanan şəxsin elektron kitabxana hissədində təlim barədə məlumatların yoxlanılması
  #10.Sənədə baxış modal pəncərəsində faylın seçilməsi
  #11.Fayl seçildikdən sonra ümumi cədvəldə baxış sayının artmasının yoxlanması