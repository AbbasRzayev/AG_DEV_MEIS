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
    Then new the "announce" is successfully deletes in the questionnaires tab
    #Test ssenariləri:
    #1.Soraqçalar bölməsində Elanlar hissəsində yeni elan tipinin əlavə edilməsinin yoxlanılması
    #2.Əlavə edilmiş yeni elan tipinin Soraqçalar bölməsində mövcud olmasının yoxlanılması
    #3.Yeni elan tipinin Soraqçalar bölməsindən redaktə olunmasının yoxlanılması
    #4.Redaktə olunmuş elan tipinin Soraqçalar bölməsində düzgün əks olunmasının yoxlanılması
    #5.Admin paneldə Elanlar tabında elan tipləri siyahısında yeni əlavə edilmiş elan tipinin düzgün əks olunmasının yoxlanılması
    #6.Soraqçalardan yeni əlavə edilmiş elan tipinin silinməsinin yoxlanılması
    #7.Silinmiş elan tipinin sistemdə mövcud olmamasının yoxlanılması




#    #Təqvim-Tədbir keçiriləcəyi yerlər
#    And user switches to the calendar tab
#    And opens places where the event will be held option
#    And selects add place button
#    When user enters place name after selects create button
#    Then new place successfully adds
#    And selects the edit button on the newly created place
#    When user edits new place
#    Then new place successfully edits
#    When user selects the delete button on the newly created place
#    Then new place successfully deletes
#    #Təqvim-Tədbir kateqoriyaları
##    And opens event categories option
##    And selects add category button
##    When user enters category name after selects create button
##    Then new category successfully adds
##    And selects the edit button on the newly created category
##    When user edits new category
##    Then new category successfully edits
##    When user selects the delete button on the newly created category
##    Then new category successfully deletes




#7.Təqvim hissəsində yeni tədbirin keçirələcəyi yerin əlavə  edilməsi
#8.Əlavə edilmiş yeni tədbirin keçirələcəyi yerin mövcud olmasının yoxlanılması
#9.Yeni tədbirin keçirələcəyi yerin redaktə edilməsi
#10.Redaktə edilən yeni tədbirin keçirələcəyi yerin yoxlanılması
#11.Yeni əlavə edilən tədbirin keçirələcəyi yerin silinməsi
#12.Silinmiş tədbirin keçirələcəyi yerin sistemdə mövcud olmamasının yoxlanılması
#13.Təqvim hissəsində yeni tədbir kateqroyasının əlavə  edilməsi
#14.Əlavə edilmiş yeni tədbir kateqroyasının mövcud olmasının yoxlanılması
#15.Yeni tədbir kateqroyasının redaktə edilməsi
#16.Redaktə edilən yeni tədbir kateqroyasının yoxlanılması
#17.Yeni əlavə edilən tədbir kateqroyasının silinməsi
#18.Silinmiş tədbir kateqroyasının sistemdə mövcud olmamasının yoxlanılması
#19.Təbrik hissəsində yeni təbrik tipinin əlavə  edilməsi
#20.Əlavə edilmiş yeni təbrik tipinin mövcud olmasının yoxlanılması
#21.Yeni təbrik tipinin redaktə edilməsi
#22.Redaktə edilən təbrik tipinin yoxlanılması
#23.Yeni əlavə edilən test təbrik tipinin silinməsi
#24.Silinmiş təbrik tipinin sistemdə mövcud olmamasının yoxlanılması