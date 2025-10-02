@all @programTemplate
Feature: Program template deletion
  As an administrator,
  I want to delete outdated program templates,
  so that users only see relevant and active templates.

  @programTemplateDelete @new
  Scenario: Check if admin can delete program templates
    Given user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    And goes to the control panel
    And the user switches to the program templates tab
    And the user clicks the "new Template" button
    And the user enters "new" as the template name
    And the user selects "new" duty for the template
    And the user selects "new" structure for the template
    And the user clicks the "Next" button
    When the user selects the "new" program for template
    When selects delete button in the template tab
#    Then the deleted template is not displayed in the template tab
    #Test ssenarilər:
    #11.Proqram şablonunun silinməsi
    #12.Silinən proqram şablonunun idarəetmə hissəsində mövcud olmamasının yoxlanılması
