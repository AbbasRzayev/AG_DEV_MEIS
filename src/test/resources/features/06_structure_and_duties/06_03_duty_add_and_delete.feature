@all @structure_and_duties @new
Feature: Users structure and duties

@duty_add_and_delete
Scenario: Check if user can add and edit then delete a new duty
Given user with login "imranovfarid@gmail.com" and password "Farid1020@@@" logs into the "AG-MEIS" system
And goes to the control panel
And switches to the structure and duties tab
And switches to the duties tab
And selects plus button for adding new duty
And adds duties name to the duty name field
And adds priority name to the priority name field
And user "deactivated" the duty
    #Yeni vəzifənin əlavə edilməsi
And user selects add duty button
And adds duties name to the duties name field in the filter
When user selects enter in the duties tab
    #İdarəetmə panelində yeni vəzifənin mövcud olmasının yoxlanılması
    #İdarəetmə panelində yeni vəzifənin adına görə nəticələrin yoxlanılması
    #Adına görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
Then search results by name and new duty is displayed in the admin panel
When user reset the changes for "duty"
Then the changes is successfully resets in the duty tab
    #İdarəetmə panelində yeni vəzifənin id-sinə görə nəticələrin yoxlanılması
    #Id-sinə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
And adds duties id to the duties id field in the filter
When user selects enter in the duties tab
Then search results by id and new duty is displayed in the admin panel
When user reset the changes for id duty
Then the changes is successfully resets in the duty tab
    #İdarəetmə panelində deaktiv olan vəzifənin statusuna görə nəticələrin yoxlanılması
    #Deaktiv olan vəzifənin statusuna görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
And user search for a deactivated duty
Then search results by deactivated duty is displayed in the admin panel
When user reset the changes for status duty
Then the changes is successfully resets in the duty tab
    #Deaktiv olan vəzifəni istifaçiyə təyin etməyin mümkün olmamasının yoxlanılması
And goes to the control panel
And adds name "Abbas" and fin to the name and fin fields
And user selects enter in the users tab
And switches to the user change structure and duties tab
When selects new "<IT Mühəndis(QA)>"
Then the deactivated duty is not displayed in the duty selection list
And page is reloaded
    #İdarəetmə panelində aktiv olan vəzifənin statusuna görə nəticələrin yoxlanılması
    #Aktiv olan vəzifənin statusuna görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
And goes to the control panel
And switches to the structure and duties tab
And switches to the duties tab
And adds duties id to the duties id field in the filter
When user selects enter in the duties tab
And user "activated" the duty
When user reset the changes for id duty
And user search for a activate duty
Then search results by activated duty is displayed in the admin panel
    #Aktiv olan vəzifənin statusuna görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
When user reset the changes for status duty
Then the changes is successfully resets in the duty tab
     #Aktiv olan vəzifəni istifaçiyə təyin etməyin mümkün olmasının yoxlanılması
And goes to the control panel
And adds name "Abbas" and fin to the name and fin fields
And user selects enter in the users tab
And switches to the user change structure and duties tab
When selects new "<IT Mühəndis(QA)>"
Then the active duty is displayed in the duty selection list
And page is reloaded
    #Yeni vəzifənin redaktə edilməsi
And goes to the control panel
And switches to the structure and duties tab
And switches to the duties tab
And adds duties id to the duties id field in the filter
And user selects enter in the duties tab
When changes name and priority from edit modal window
    #Redaktə edildikdən sonra vəzifənin yenilənmış məlumatların yoxlanılması
Then new duty is successfully edited
    #Yeni vəzifənin silinməsi və silinnın vəzifənin mövcud olmamasının yoxlanılması
And user deletes the newly added duty using the delete button
Then newly duty has been deleted successfully
  #Test ssenarilər:
  #34.Yeni vəzifənin əlavə edilməsi
  #35.İdarəetmə panelində yeni vəzifənin mövcud olmasının yoxlanılması
  #36.İdarəetmə panelində yeni vəzifənin adına görə nəticələrin yoxlanılması
  #37.Adına görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
  #38.İdarəetmə panelində yeni vəzifənin id-sinə görə nəticələrin yoxlanılması
  #39.id-sinə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
  #40.İdarəetmə panelində deaktiv olan vəzifənin statusuna görə nəticələrin yoxlanılması
  #41.Deaktiv olan vəzifənin statusuna görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
  #42.Deaktiv olan vəzifəni istifaçiyə təyin etməyin mümkün olmamasının yoxlanılması
  #43.İdarəetmə panelində aktiv olan vəzifənin statusuna görə nəticələrin yoxlanılması
  #44.Aktiv olan vəzifənin statusuna görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
  #45.Aktiv olan vəzifəni istifaçiyə təyin etməyin mümkün olmasının yoxlanılması
  #46.Yeni vəzifənin redaktə edilməsi
  #47.Redaktə edildikdən sonra vəzifənin yenilənmış məlumatların yoxlanılması
  #48.Yeni vəzifənin silinməsi
  #49.Silindikdən sonra idarəetmə panelinde silinən vəzifənin mövcud olmamasının yoxlanılması