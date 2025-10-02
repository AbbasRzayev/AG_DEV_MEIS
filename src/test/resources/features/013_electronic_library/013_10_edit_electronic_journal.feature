@electronicLibrary @test
Feature:Edit electronic journal
  As a registered user with the necessary permissions,
  I want to edit an existing electronic journal by updating its title, content, attachments, and relevant metadata,
  So that the training content remains accurate, up-to-date, and useful for employees or participants in the system.

  @editElectronicJournal @new @test
  Scenario: Check if user can edit electronic journal
    Given user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    #Elektron jurnalın əlavə edilməsi
    And goes to the control panel
    And goes to the electronic library tab in the control panel
    And switches to the "Electronic journal" tab in electronic library
    And selects new "journal" button in the training materials tab
    And adds "Journal Manual" to journal name input
    And adds "7777" to journal number input
    And adds journal date
    And selects person "İbrahim" for notification and mail for electronic library
    And selects person "İbrahim" for the who sees field
    And adds file "new" for training
    And user selects save button
    #Elektron jurnalın redaktə edilməsi
    And selects edit button in the control panel
    And adds "Journal Automation" to journal name input
    And adds "8888" to journal number input
    And adds file "edit" for electronic journal
    And user selects save button
    Then all information about the electronic journal is displayed in the table in the admin panel
      | Adı                | Buraxılış nömrəsi | Materiallar  | Baxış sayı |
      | Journal Automation | 8888              | EndToEnd.pdf | 0          |
    And selects delete button in the control panel
    Then the deleted electronic journal is not displayed in the control panel
    #Test ssenarilər:
    #61.Yeni elektron jurnalın redaktə edilməsi
    #62.Redaktə edildikdən sonra elektron jurnal məlumatların yoxlanılması