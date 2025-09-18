@all
Feature: Adding congratulations questionnaires to different tabs
  As a registered user with the necessary permissions,
  I want to add, edit, and delete congratulations questionnaires (such as ad types) from the control panel,
  So that the created questionnaires are correctly reflected in their related tabs (e.g., congratulations tab) and remain accurate and up to date in the system.

  @congratulationsQuestionnaires @new
  Scenario: Check if user can add/edit then delete congratulations questionnaires for different tabs
    Given user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    And goes to the control panel
    And goes to the questionnaires tab
    And user switches to the Congratulations tab
    #Təbrik tipləri
    And selects add new "congratulation" type name button
    When user adds "new-congratulation" to the name input in the questionnaires tab
    Then new "new-congratulation" is displayed in the questionnaires tab
      | congratulation |
      | Manual progress |
    And selects the edit button for "edit-congratulation" in the questionnaires tab
    When user edits new "congratulations"
    Then new "edited-congratulation" is displayed in the questionnaires tab
      | congratulation     |
      | Automation progress |
    And goes to the congratulations tab from admin panel
    And selects plus button for adding new "congratulation"
    And selects announcement type "edited-congratulation"
    Then new "edited-congratulation" is displayed in the announcement tab
    And goes to the control panel
    And goes to the questionnaires tab
    And user switches to the Congratulations tab
    When user selects the delete button for the "delete-congratulation"
    Then new the "congratulation" is successfully deletes in the questionnaires tab
    #Test ssenarilərs:
    #8.Soraqçalar bölməsində Təbriklər hissəsində yeni təbrik tipinin əlavə edilməsinin yoxlanılması
    #9.Əlavə edilmiş yeni təbrik tipinin Soraqçalar bölməsində mövcud olmasının yoxlanılması
    #10.Yeni təbrik tipinin Soraqçalar bölməsindən redaktə olunmasının yoxlanılması
    #11.Redaktə olunmuş təbrik tipinin Soraqçalar bölməsində düzgün əks olunmasının yoxlanılması
    #12.Admin paneldə Təbriklər tabında təbrik tipləri siyahısında yeni əlavə edilmiş təbrik tipinin düzgün əks olunmasının yoxlanılması
    #13.Soraqçalardan yeni əlavə edilmiş təbrik tipinin silinməsinin yoxlanılması
    #14.Silinmiş təbrik tipinin sistemdə mövcud olmamasının yoxlanılması