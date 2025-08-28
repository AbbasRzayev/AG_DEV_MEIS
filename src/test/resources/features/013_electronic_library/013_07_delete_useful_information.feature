@electronicLibrary @test
Feature:Delete useful information
  As a registered user with the necessary permissions,
  I want to delete an existing useful information from the system,
  So that outdated, irrelevant, or incorrect content is removed and employees or participants only access valid and useful training resources.

  @deleteUsefulInformation @new
  Scenario: Check if user can delete new useful information
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
    #Faydalı məlumatın əlavə edilməsi
    And goes to the control panel
    And goes to the electronic library tab in the control panel
    And switches to the "Useful information" tab in electronic library
    And selects delete button in the control panel
    Then the deleted training material is not displayed in the control panel
    #Test ssenarilər:
    #40.Adminin idarəetmə hissəsindən faydalı məlumatı silməsi
    #41.Silinən faydalı məlumatın idarəetmə hissəsində mövcud olmamasının yoxlanılması