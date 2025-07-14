@all
Feature: Adding questionnaires to different tabs
  @QuestionnairesAddEditDelete
  Scenario: Check if user can add/edit then delete questionnaires for different tabs
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the control panel
    And goes to the questionnaires tab
    #Elanlar-Elan tipləri
    And selects ad type name button
    When user enters ad name after selects create button
    Then new ad successfully adds
    And selects the edit button on the newly created ad
    When user edits new add
    Then new ad successfully edits
    When user selects the delete button on the newly created ad
    Then new ad successfully deletes
    #Təqvim-Tədbir keçiriləcəyi yerlər
    And user switches to the calendar tab
    And opens places where the event will be held option
    And selects add place button
    When user enters place name after selects create button
    Then new place successfully adds
    And selects the edit button on the newly created place
    When user edits new place
    Then new place successfully edits
    When user selects the delete button on the newly created place
    Then new place successfully deletes
    #Təqvim-Tədbir kateqoriyaları
#    And opens event categories option
#    And selects add category button
#    When user enters category name after selects create button
#    Then new category successfully adds
#    And selects the edit button on the newly created category
#    When user edits new category
#    Then new category successfully edits
#    When user selects the delete button on the newly created category
#    Then new category successfully deletes
    #Təbrik-Təbrik tipləri
    And user switches to the Congratulations tab
    And opens congratulations types option
    And selects add congratulation types button
    When user enters congratulation name after selects create button
    Then new congratulation successfully adds
    And selects the edit button on the newly created congratulation
    When user edits new congratulation
    Then new congratulation successfully edits
    When user selects the delete button on the newly created congratulation
    Then new congratulation successfully deletes

#Test ssenarilər:
#1.Elanlar hissəsində yeni elan tipinin əlavə  edilməsi
#2.Əlavə edilmiş yeni elan tipinin mövcud olmasının yoxlanılması
#3.Yeni elan tipinin redaktə edilməsi
#4.Redaktə edilən elan tipinin yoxlanılması
#5.Yeni əlavə edilən test elan tipinin silinməsi
#6.Silinmiş elan tipinin sistemdə mövcud olmamasının yoxlanılması
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