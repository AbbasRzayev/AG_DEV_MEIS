@electronicLibrary @test
Feature:Create useful information
  As a registered user with the necessary permissions,
  I want to create a new useful information by adding its title, content, attachments, and relevant metadata,
  So that employees or participants can easily access and benefit from the training content in the system

  @usefulInformation @new
  Scenario: Check if user can add new useful information
    Given user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    #Faydalı məlumatın əlavə edilməsi
    And goes to the control panel
    And goes to the electronic library tab in the control panel
    And switches to the "Useful information" tab in electronic library
    And selects new "information" button in the training materials tab
    And adds "Manual Qa" to useful information name input
    And selects person "İbrahim" for notification and mail for electronic library
    And selects person "İbrahim" for the who sees field
    And adds file "new" for training
    And user selects save button
    Then all information about the useful information is displayed in the table in the admin panel
      | Məlumatın adı    | Materiallar      | Baxış sayı |
      | Useful Manual QA | QaAutomation.pdf | 0          |
    And user selects exit button
   #Ünvalanan şəxs sistemə daxil olduqda faydalı məlumat barədə bildirişin yönəlməsi
    And user with login "ibrahimzamanov88@proton.me" and password "Ibrahimibrahim88!!" logs into the "AG-MEIS" system
    And all the information about useful information is displayed in the notification
      | Başlıq                                              |
      | Useful Manual QA başlıqlı faydalı məlumat yaradıldı |
    And select close button in the notification modal window
    And page is reloaded
    And goes to the electronic library tab from main page
    And switches to the "Useful information" tab in electronic library
    Then all information about the useful information is displayed in the table in the admin panel
      | Məlumatın adı    | Materiallar      | Baxış sayı |
      | Useful Manual QA | QaAutomation.pdf | 0          |
    #Baxış sayının artmasının yoxlanması
    And user opens the document view modal window
    And uploads a video from the document view modal window
    When user closes the document view modal window
    Then an increase is observed in the view count data
    And goes to the control panel
    When goes to the electronic library tab in the control panel
    And selects delete button in the control panel
    Then the deleted training material is not displayed in the control panel
  #Test ssenarilər:
  #27.Yeni faydalı məlumatım əlavə edilməsi
  #28.İdarəetmə panelində əlavə edilən faydalı məlumatın mövcud olmasının yoxlanılması
  #29.İdarəetmə panelində əlavə edilən faydalı ad məlumatının yoxlanılması
  #30.İdarəetmə panelində əlavə edilən faydalı materiallar məlumatının yoxlanılması
  #31.İdarəetmə panelində faydalı məlumatın əlavə edilmə tarixinin yoxlanılması
  #32.İdarəetmə panelində əlavə edilən baxış sayı məlumatının yoxlanılması
  #33.Ünvalanan şəxs sistemə daxil olduqda təlim barədə bildirişin yönəlməsi
  #34.Faydalı məlumat barədə bildiriş məlumatlarının yoxlanması
  #35.Ünvanlanan şəxsin istifadəçi panelində faydalı məlumat barədə məlumatların yoxlanılması
  #36.Sənədə baxış modal pəncərəsində faylın seçilməsi
  #37.Fayl seçildikdən sonra ümumi cədvəldə baxış sayının artmasının yoxlanması