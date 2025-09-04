@electronicLibrary @test
Feature:Create electronic journal
  As a registered user with the necessary permissions,
  I want to create a new electronic journal by adding its title, content, attachments,
  So that employees or participants can easily access and benefit from the electronic journal in the system

  @electronicJournal @new @test
  Scenario: Check if user can add new electronic journal
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
    Then all information about the electronic journal is displayed in the table in the admin panel
      | Adı            | Buraxılış nömrəsi | Materiallar      | Baxış sayı |
      | Journal Manual | 7777              | QaAutomation.pdf | 0          |
    And user selects exit button
    #Ünvalanan şəxs sistemə daxil olduqda elektron jurnal barədə bildirişin yönəlməsi
    And user with login "ibrahimzamanov88@proton.me" and password "Ibrahimibrahim88!!" logs into the "AG-MEIS" system
    And all the information about electronic journal is displayed in the notification
      | Başlıq                               |
      | Journal Manual adlı jurnal yaradıldı |
    And select close button in the notification modal window
    And page is reloaded
    And goes to the electronic library tab from main page
    And switches to the "Electronic journal" tab in electronic library
    Then all information about the electronic journal is displayed in the table in the admin panel
      | Adı            | Buraxılış nömrəsi | Materiallar      | Baxış sayı |
      | Journal Manual | 7777              | QaAutomation.pdf | 0          |
    #Baxış sayının artmasının yoxlanması
    And user opens the document view modal window
    And uploads a video from the document view modal window
    When user closes the document view modal window
    Then an increase is observed in the view count data
    And goes to the control panel
    And goes to the electronic library tab in the control panel
    And switches to the "Electronic journal" tab in electronic library
    And selects delete button in the control panel
    Then the deleted electronic journal is not displayed in the control panel
  #Test ssenarilər:
  #49.Yeni elektron jurnalın əlavə edilməsi
  #50.İdarəetmə panelində əlavə edilən elektron jurnalın mövcud olmasının yoxlanılması
  #51.İdarəetmə panelində əlavə edilən elektron jurnalın ad məlumatının yoxlanılması
  #52.İdarəetmə panelində əlavə edilən elektron jurnalın buraxılış nömrəsi məlumatının yoxlanılması
  #53.İdarəetmə panelində əlavə edilən elektron jurnalın tarix məlumatının yoxlanılması
  #54.İdarəetmə panelində əlavə edilən elektron jurnalın materiallar məlumatının yoxlanılması
  #55.İdarəetmə panelində əlavə edilən elektron jurnalın baxış sayı məlumatının yoxlanılması
  #56.Ünvalanan şəxs sistemə daxil olduqda elektron jurnal barədə bildirişin yönəlməsi
  #57.Elektron jurnal barədə bildiriş məlumatlarının yoxlanması
  #58.Ünvanlanan şəxsin elektron kitabxana hissəsində elektron jurnal barədə məlumatların yoxlanılması
  #59.Sənədə baxış modal pəncərəsində faylın seçilməsi
  #60.Fayl seçildikdən sonra ümumi cədvəldə baxış sayının artmasının yoxlanması