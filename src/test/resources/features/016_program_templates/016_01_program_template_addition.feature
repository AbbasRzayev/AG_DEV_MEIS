@all @programTemplate
Feature: Program template addition
  As an administrator,
  I want to create a new program template,
  so that I can standardize program structures for future use

  @programTemplateAdd @new
  Scenario: Check if admin can add a new program templates
    Given user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    And goes to the control panel
    And the user switches to the program templates tab
    And the user clicks the "new Template" button
    And the user enters "new" as the template name
    And the user selects "new" duty for the template
    And the user selects "new" structure for the template
    And the user clicks the "Next" button
    When the user selects the "new" program for template
    Then the template information is displayed in the Admin Panel
      | Şablonun adı        | Vəzifə            | Struktur      | Proqramlar |
      | Automation Template | Ofis koordinatoru | AISTGroup MMC | 1          |
    When selects delete button in the template tab
#    Then the deleted template is not displayed in the template tab
    #Test ssenarilər:
    #1.Proqram şablonunun əlavə edilməsinin yoxlanılması
    #2.Yeni proqram şablonunun idarəetmə panelində mövcud olmasının yoxlanılması
    #3.Yeni proqram şablonunun ad məlumatının əks olunmasının yoxlanılması
    #4.Yeni proqram şablonunun vəzifə məlumatının əks olunmasının yoxlanılması
    #5.Yeni proqram şablonunun struktur məlumatının əks olunmasının yoxlanılması
    #6.Yeni proqram şablonuna təyin olunan proqram sayında yenilənmənin əks olunmasının yoxlanılması