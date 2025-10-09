@all @announcementsAndCongratulations
Feature: Create new announcement
  As an administrator
  I want to create a new announcement with details such as name, type, URL, description, and media files, and verify that it is displayed correctly for the relevant addressees
  So that the correct users can view accurate and up-to-date announcements within the system

  @announcementAccordingToTheAddressees @new
  Scenario: Check that if user can add announcements according to the addressees
    Given user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    And goes to the control panel
    And goes to the announcements tab from admin panel
    And selects plus button for adding new "announcement"
    And adds "new-announcement" name in the name input
    And selects announcement type "new-announcement"
    And adds url "new announcement" for announcement
    And selects the status of the announcement according to the addressees
#    And user select escape button
    And adds "new" description
    And adds main picture for announcement
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
    Then the all information about announcement is displayed in the admin panel
      | Elan Başlığ | Elan Təsvir                                      |
      | Manual ELan | Bu elanın məqsədi automatlaşdırılmış təstlərdir. |
    When selects new added announcement
    Then the all information about announcement is displayed in the left sidebar
      | Elan Başlığ | Elan Təsvir                                      | Elanın tipi |
      | Manual ELan | Bu elanın məqsədi automatlaşdırılmış təstlərdir. | Elanlar     |
    And goes to the control panel
    And goes to the announcements tab from admin panel
    And page is reloaded
    And all the information about announcement is displayed in the notification
      | Elan Başlığ | Elan Təsvir                                      |
      | Manual ELan | Bu elanın məqsədi automatlaşdırılmış təstlərdir. |
    When selects delete button for announcement or for congrats in the control panel
    Then the deleted announcement or congrats is not displayed in the control panel
   #Test Ssenariləri:
   #1.Yeni elanın əlavə edilməsinin yoxlanılması (Ünvanlanmış şəxslərə görə)
   #2.Admin paneldə yeni elan başlıq məlumatının düzgün əks olunmasının yoxlanılması
   #3.Admin paneldə yeni elan təsvir məlumatının düzgün əks olunmasının yoxlanılması
   #4.Admin paneldə yeni elanın əlavə edilmə tarix və saat məlumatlarının düzgün əks olunmasının yoxlanılması
   #5.Ünvanlanmış şəxs üçün elanın sol sidebarda mövcud olmasının yoxlanılması
   #6.Elanın tarix, başlıq və təsvir məlumatlarının düzgün əks olunmasının yoxlanılması
   #7.Elana daxil olaraq baxış hissəsində əsas təsvirin düzgün əks olunmasının yoxlanılması
   #8.Elanın baxış hissəsində tarix məlumatlarının düzgün əks olunmasının yoxlanılması
   #9.Elanın baxış hissəsində elan tipi məlumatlarının düzgün əks olunmasının yoxlanılması
   #10.Elanın baxış hissəsində başlıq məlumatlarının düzgün əks olunmasının yoxlanılması
   #11.Elanın baxış hissəsində əsas şəklin düzgün əks olunmasının yoxlanılması
   #12.Elanın baxış hissəsində video məlumatlarının düzgün əks olunmasının yoxlanılması
   #13.Elanın baxış hissəsində əlavə şəklin düzgün əks olunmasının yoxlanılması
   #14.Elanın baxış hissəsində URL məlumatlarının və URL keçidinin düzgün işləməsinin yoxlanılması
   #15.Ünvanlanmış şəxsə elan barədə bildirişin gəlməsinin yoxlanılması
   #16.Bildiriş modal pəncərəsində elanın başlıq adının, təsvirin və şəklin düzgün əks olunmasının yoxlanılması