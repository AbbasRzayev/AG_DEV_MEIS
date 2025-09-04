@electronicLibrary @test
Feature:Edit useful information
  As a registered user with the necessary permissions,
  I want to edit an existing useful information by updating its title, content, attachments, and relevant metadata,
  So that the training content remains accurate, up-to-date, and useful for employees or participants in the system.

  @editUsefulInformation @new @test
  Scenario: Check if user can edit new useful information
    Given user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    And goes to the control panel
    And goes to the electronic library tab in the control panel
    And switches to the "Useful information" tab in electronic library
    And selects new "information" button in the training materials tab
    And adds "Manual Qa" to useful information name input
    And selects person "İbrahim" for notification and mail for electronic library
    And selects person "İbrahim" for the who sees field
    And adds file "new" for training
    And user selects save button
    #Faydalı məlumatın redaktə edilməsi
    And goes to the control panel
    And goes to the electronic library tab in the control panel
    And switches to the "Useful information" tab in electronic library
    And selects edit button in the control panel
    And adds "Automation QA" to useful information name input
    And adds file "edit" for training
    And user selects edit button
    And goes to the control panel
    When goes to the electronic library tab in the control panel
    And switches to the "Useful information" tab in electronic library
    Then all information about the useful information is displayed in the table in the admin panel
      | Məlumatın adı      | Materiallar      | Baxış sayı |
      | Useful Autmaion QA | EndToEnd.pdf.pdf | 0          |
    And selects delete button in the control panel
    Then the deleted training material is not displayed in the control panel
    #Test ssenarilər:
    #38.Yeni faydalı məlumatın redakə edilməsi
    #39.Redaktə edildikdən sonra faydalı məlumatların yoxlanılması