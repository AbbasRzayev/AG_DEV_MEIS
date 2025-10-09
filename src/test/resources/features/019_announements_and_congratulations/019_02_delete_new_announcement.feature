@all @announcementsAndCongratulations
Feature: Delete new announcement
  As an administrator
  I want to delete an existing announcement from the system through the admin panel
  So that outdated or irrelevant announcements are removed and not visible to users

  @deleteAnnouncementAccordingToTheAddressees @new
  Scenario: Check that if user can delete announcements according to the addressees
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
    And user selects save button
    When selects delete button for announcement or for congrats in the control panel
    Then the deleted announcement or congrats is not displayed in the control panel
    #Test Ssenariləri:
    #17.Admin paneldən elanın sistemdən silinməsinin yoxlanılması
    #18.Silinmiş elanın sistemdə mövcud olmamasının yoxlanılması