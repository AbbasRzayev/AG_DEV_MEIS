@all @programTemplate
Feature: Program template editing
  As an administrator,
  I want to edit an existing program template,
  so that I can keep template details up to date

  @programTemplateEdit @new
  Scenario: Check if admin can edit a new program templates
    Given user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    And goes to the control panel
    And the user switches to the program templates tab
    And the user clicks the "new Template" button
    And the user enters "new" as the template name
    And the user selects "new" duty for the template
    And the user selects "new" structure for the template
    And the user clicks the "Next" button
    And the user selects the "new" program for template
    #Şablonun redaktə edilməsi
    When selects edit button in the template tab
    And the user enters "edit" as the template name
    And the user selects "edit" duty for the template
    And the user selects "edit" structure for the template
    And the user clicks the "Next" button
    And the user selects the "edit" program for template
    Then the template information is displayed in the Admin Panel
      | Şablonun adı    | Vəzifə    | Struktur               | Proqramlar |
      | Manual Template | Proqramçı | Keyfiyyətə Nəzarət(AT) | 2          |
    When selects delete button in the template tab
    Then the deleted template is not displayed in the template tab
    #Test ssenarilər:
    #7.Yeni şablonun bütün məlumatlarının redaktə edilməsi
    #8.Redaktə edildikdən sonra şablon məlumatlarının yoxlanılması
