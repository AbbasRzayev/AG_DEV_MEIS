@all
Feature: Adding announcements questionnaires to different tabs
  As a registered user with the necessary permissions,
  I want to add, edit, and delete announcements questionnaires (such as ad types) from the control panel,
  So that the created questionnaires are correctly reflected in their related tabs (e.g., Announcements tab) and remain accurate and up to date in the system.

  @announcementsQuestionnaires @new
  Scenario: Check if user can add/edit then delete announcements questionnaires for different tabs
    Given user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    And goes to the control panel
    And goes to the questionnaires tab
    #Elan tipləri
    And selects add new "announce" type name button
    When user adds "new-announcement" to the name input in the questionnaires tab
    Then new "new-announcement" is displayed in the questionnaires tab
      | announcement  |
      | ManualQA news |
    And selects the edit button for "edit-announce" in the questionnaires tab
    When user edits new "announce"
    Then new "edited-announcement" is displayed in the questionnaires tab
      | announcement      |
      | AutomationQA news |
    And goes to the announcements tab from admin panel
    And selects plus button for adding new "announcement"
    And selects announcement type "edited-announcement"
    Then new "edited-announcement" is displayed in the announcement tab
    And goes to the control panel
    And goes to the questionnaires tab
    When user selects the delete button for the "delete-announce"
    Then the new "announce" is successfully deletes in the questionnaires tab
    #Test ssenariləri:
    #1.Soraqçalar bölməsində Elanlar hissəsində yeni elan tipinin əlavə edilməsinin yoxlanılması
    #2.Əlavə edilmiş yeni elan tipinin Soraqçalar bölməsində mövcud olmasının yoxlanılması
    #3.Yeni elan tipinin Soraqçalar bölməsindən redaktə olunmasının yoxlanılması
    #4.Redaktə olunmuş elan tipinin Soraqçalar bölməsində düzgün əks olunmasının yoxlanılması
    #5.Admin paneldə Elanlar tabında elan tipləri siyahısında yeni əlavə edilmiş elan tipinin düzgün əks olunmasının yoxlanılması
    #6.Soraqçalardan yeni əlavə edilmiş elan tipinin silinməsinin yoxlanılması
    #7.Silinmiş elan tipinin sistemdə mövcud olmamasının yoxlanılması