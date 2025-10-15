@all @announcementsAndCongratulations
Feature: Edit new congratulation
  As an administrator,
  I want to edit an existing congratulation by updating its details such as name, type, URL, description, and media files,
  So that any changes made are correctly reflected and displayed to the relevant addressees within the system, ensuring all users see the most up-to-date congratulation information.

  @editCongratulationAccordingToTheAddressees @new
  Scenario: Check that if user can edit congratulation according to the addressees
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
    #Redakte edilməsi
    And user selects edit button in the admin panel
    And adds "edit-announcement" name in the name input
    And selects announcement type "edit-announcement"
    And adds url "edit announcement" for announcement
    And adds "edit" description
    And adds "edit" main picture for announcement
    And page is down
    When user selects edit button
    #Admin panelde məlumatların yoxlanılması
    Then the all information about announcement is displayed in the admin panel
      | Elan Başlığ     | Elan Təsvir                         |
      | Automation ELan | Redaktə edilən mətn barədə məlumat. |
    And user selects left sidebar button
    And user selects announcement and congratulations from left sidebar
    And user switches to the Congratulations tab in the left sidebar
    Then the all information about announcement is displayed in the admin panel
      | Elan Başlığ     | Elan Təsvir                         |
      | Automation ELan | Redaktə edilən mətn barədə məlumat. |
    When selects new added announcement
    Then the all information about announcement is displayed in the left sidebar
      | Elan Başlığ     | Elan Təsvir                         | Elanın tipi |
      | Automation ELan | Redaktə edilən mətn barədə məlumat. | Məzuniyyət  |
    And goes to the control panel
    And goes to the announcements tab from admin panel
    And goes to the congratulations tab from admin panel
    And page is reloaded
    And all the information about announcement is displayed in the notification
      | Elan Başlığ     | Elan Təsvir                         |
      | Automation ELan | Redaktə edilən mətn barədə məlumat. |
    When selects delete button for announcement or for congrats in the control panel
    Then the deleted announcement or congrats is not displayed in the control panel
   #Test Ssenariləri:
   #41.Təbrikin redaktə olunmasının yoxlanılması
   #42.Redaktə edildikdən sonra admin paneldə təbrik məlumatlarının düzgün əks olunmasının yoxlanılması
   #43.Redaktə edildikdən sonra sol sidebarda təbrik məlumatlarının düzgün əks olunmasının yoxlanılması
   #44.Redaktə edildikdən sonra bildirişin gəlməsi və təbrik məlumatlarının düzgün əks olunmasının yoxlanılması