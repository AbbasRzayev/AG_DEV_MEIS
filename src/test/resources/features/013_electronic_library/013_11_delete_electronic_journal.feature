@electronicLibrary @test
Feature:Delete electronic journal
  As a registered user with the necessary permissions,
  I want to delete an existing electronic journal from the system,
  So that outdated, irrelevant, or incorrect content is removed and employees or participants only access valid and electronic journal resources.

  @deleteElectronicJournal @new
  Scenario: Check if user can delete new electronic journal
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
    #Elektron jurnalın silinməsi
    When selects delete button in the control panel
    Then the deleted electronic journal is not displayed in the control panel
    #Test ssenarilər:
    #63.Adminin idarəetmə hissəsindən elektron jurnalın silinməsi
    #64.Silinən faydalı məlumatın idarəetmə hissəsində mövcud olmamasının yoxlanılması