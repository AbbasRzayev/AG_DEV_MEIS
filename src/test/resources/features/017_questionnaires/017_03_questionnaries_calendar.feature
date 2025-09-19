@all
Feature: Adding calendar questionnaires to different tabs
  As a registered user with the necessary permissions,
  I want to add, edit, and delete calendar questionnaires (such as ad types) from the control panel,
  So that the created questionnaires are correctly reflected in their related tabs (e.g., calendar tab) and remain accurate and up to date in the system.

  @calendarQuestionnaires @new
  Scenario: Check if user can add/edit then delete calendar questionnaires for different tabs
    Given user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    And goes to the control panel
    And goes to the questionnaires tab
    And user switches to the calendar tab
    #Təqvim tipləri-Tədbir keçiriləcəyi yerlər
    And selects add new "event place" type name button
    When user adds "new-event place" to the name input in the questionnaires tab
    Then new "new-event place" is displayed in the questionnaires tab
      | event place        |
      | Manual event place |
    And selects the edit button for "edit-event place" in the questionnaires tab
    When user edits new "event place"
    Then new "edited-event place" is displayed in the questionnaires tab
      | event place            |
      | Automation event place |
    #Təqvim tipləri-Tədbir kateqoriyaları
    And selects add new "category" type name button
    When user adds "new-category" to the name input in the questionnaires tab
    Then new "new-category" is displayed in the questionnaires tab
      | category        |
      | Manual category |
    And selects the edit button for "edit-category" in the questionnaires tab
    When user edits new "category"
    Then new "edited-category" is displayed in the questionnaires tab
      | category            |
      | Automation category |
    And goes to the calendar tab from admin panel
    And selects plus button for adding new "calendar"
    When selects category "Automation" for a new event
    Then new "Automation category" is displayed in the calendar tab
    When determines where the event "place" will be held
    Then new "event place" is displayed in the calendar tab
    And goes to the control panel
    And goes to the questionnaires tab
    And user switches to the calendar tab
    When user selects the delete button for the "delete-event place"
    Then the new "event place" is successfully deletes in the questionnaires tab
    When user selects the delete button for the "delete-category"
    Then the new "event place" is successfully deletes in the questionnaires tab
    #Test ssenarilər:
    #15.Soraqçalar bölməsində Təqvim hissəsində yeni tədbir tipinin əlavə edilməsinin yoxlanılması
    #16.Əlavə edilmiş yeni tədbir tipinin Soraqçalar bölməsində mövcud olmasının yoxlanılması
    #17.Yeni tədbir tipinin Soraqçalar bölməsindən redaktə olunmasının yoxlanılması
    #18.Redaktə olunmuş tədbir tipinin Soraqçalar bölməsində düzgün əks olunmasının yoxlanılması
    #19.Yeni Təqvim tabında tədbir tipləri siyahısında yeni əlavə edilmiş tədbir tipinin düzgün əks olunmasının yoxlanılması
    #20.Soraqçalardan yeni əlavə edilmiş tədbir tipinin silinməsinin yoxlanılması
    #21.Silinmiş tədbir tipinin sistemdə mövcud olmamasının yoxlanılması
    #22.Soraqçalar bölməsində Təqvim hissəsində yeni categoriya tipinin əlavə edilməsinin yoxlanılması
    #23.Əlavə edilmiş yeni categoriya tipinin Soraqçalar bölməsində mövcud olmasının yoxlanılması
    #24.Yeni categoriya tipinin Soraqçalar bölməsindən redaktə olunmasının yoxlanılması
    #25.Redaktə olunmuş categoriya tipinin Soraqçalar bölməsində düzgün əks olunmasının yoxlanılması
    #26.Yeni Təqvim tabında categoriya tipləri siyahısında yeni əlavə edilmiş categoriya tipinin düzgün əks olunmasının yoxlanılması
    #27.Soraqçalardan yeni əlavə edilmiş categoriya tipinin silinməsinin yoxlanılması
    #28.Silinmiş categoriya tipinin sistemdə mövcud olmamasının yoxlanılması