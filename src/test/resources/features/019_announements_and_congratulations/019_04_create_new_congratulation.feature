@all @announcementsAndCongratulations @new
Feature: Create new congratulation
  As an administrator
  I want to create a new congratulation with details such as name, type, URL, description, and media files, and verify that it is displayed correctly for the relevant addressees
  So that the correct users can view accurate and up-to-date congratulation within the system

  @congratulationAccordingToTheAddressees
  Scenario: Check that if user can add congratulation according to the addressees
    Given user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    And goes to the control panel
    And goes to the congratulations tab from admin panel
    And selects plus button for adding new congratulations
    And adds "new-announcement" name in the name input
    And selects announcement type "new-announcement"
    And adds url "new announcement" for announcement
    And selects the status of the announcement according to the addressees
    #And user select escape button
    And adds "new" description
    And adds "congrats" main picture for announcement
    And adds additional photo for announcement
    And adds video for announcement
    And page is down
    When user selects save button
    #Admin panelde məlumatların yoxlanılması
    Then the all information about announcement is displayed in the admin panel
      | Elan Başlığ | Elan Təsvir                                      |
      | Manual ELan | Bu elanın məqsədi automatlaşdırılmış təstlərdir. |
    And user selects left sidebar button
    And user selects announcement and congratulations from left sidebar
    And user switches to the Congratulations tab in the left sidebar
    Then the all information about announcement is displayed in the admin panel
      | Elan Başlığ | Elan Təsvir                                      |
      | Manual ELan | Bu elanın məqsədi automatlaşdırılmış təstlərdir. |
    When selects new added announcement
    Then the all information about congratulation is displayed in the left sidebar
      | Elan Başlığ | Elan Təsvir                                      | Elanın tipi |
      | Manual ELan | Bu elanın məqsədi automatlaşdırılmış təstlərdir. | Elanlar     |
    And goes to the control panel
    And goes to the announcements tab from admin panel
    And goes to the congratulations tab from admin panel
    And page is reloaded
    And all the information about announcement is displayed in the notification
      | Elan Başlığ | Elan Təsvir                                      |
      | Manual ELan | Bu elanın məqsədi automatlaşdırılmış təstlərdir. |
    When selects delete button for announcement or for congrats in the control panel
    Then the deleted announcement or congrats is not displayed in the control panel
   #Test Ssenariləri:
   #23.Yeni təbrik əlavə edilməsinin yoxlanılması (Ünvanlanmış şəxslərə görə)
   #24.Admin paneldə yeni təbrik başlıq məlumatının düzgün əks olunmasının yoxlanılması
   #25.Admin paneldə yeni təbrik təsvir məlumatının düzgün əks olunmasının yoxlanılması
   #26.Admin paneldə yeni təbrik əlavə edilmə tarix və saat məlumatlarının düzgün əks olunmasının yoxlanılması
   #27.Ünvanlanmış şəxs üçün təbrik sol sidebarda mövcud olmasının yoxlanılması
   #28.Təbrikin tarix, başlıq və təsvir məlumatlarının düzgün əks olunmasının yoxlanılması
   #29.Təbrikə daxil olaraq baxış hissəsində əsas təsvirin düzgün əks olunmasının yoxlanılması
   #30.Təbrikin baxış hissəsində tarix məlumatlarının düzgün əks olunmasının yoxlanılması
   #31.Təbrikin baxış hissəsində təbrik tipi məlumatlarının düzgün əks olunmasının yoxlanılması
   #32.Təbrikin baxış hissəsində başlıq məlumatlarının düzgün əks olunmasının yoxlanılması
   #33.Təbrikin baxış hissəsində əsas şəklin düzgün əks olunmasının yoxlanılması
   #34.Təbrikin baxış hissəsində video məlumatlarının düzgün əks olunmasının yoxlanılması
   #35.Təbrikin baxış hissəsində əlavə şəklin düzgün əks olunmasının yoxlanılması
   #36.Təbrikin baxış hissəsində URL məlumatlarının və URL keçidinin düzgün işləməsinin yoxlanılması
   #37.Ünvanlanmış şəxsə təbrik barədə bildirişin gəlməsinin yoxlanılması
   #38.Bildiriş modal pəncərəsində təbrikin başlıq adının, təsvirin və şəklin düzgün əks olunmasının yoxlanılması