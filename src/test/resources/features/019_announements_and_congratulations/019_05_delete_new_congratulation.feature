@all @announcementsAndCongratulations
Feature: Delete new congratulation
  As an administrator
  I want to delete an existing congratulations from the system through the admin panel
  So that outdated or irrelevant congratulations are removed and not visible to users

  @deleteCongratulationAccordingToTheAddressees
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
    When selects delete button for announcement or for congrats in the control panel
    Then the deleted announcement or congrats is not displayed in the control panel
    #Test Ssenariləri:
    #39.Admin paneldən təbrikin sistemdən silinməsinin yoxlanılması
    #40.Silinmiş təbrikin sistemdə mövcud olmamasının yoxlanılması