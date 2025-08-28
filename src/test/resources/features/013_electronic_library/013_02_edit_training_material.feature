@electronicLibrary @test
Feature:Edit training material
  As a registered user with the necessary permissions,
  I want to edit an existing training material by updating its title, content, attachments, and relevant metadata,
  So that the training content remains accurate, up-to-date, and useful for employees or participants in the system.

  @editTrainingMaterial @new
  Scenario: Check if user can edit new training materials
    Given user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    #Təlim materialın əlavə edilməsi
    And goes to the control panel
#    And goes to the electronic library tab in the control panel
    And goes to the electronic library in the control panel
    And selects new "training" button in the training materials tab
    And adds "Daxili təlim AT" to training name input
    And adds training date
    And adds instructor "Davud" from search list
    And selects person "İbrahim" for notification and mail
    And selects person "İbrahim" for the who sees field
    And adds note "Automaiton kurslar barədə" to the note input
    And adds file "new" for training
    And user selects save button
    And user selects exit button
    #Təlim materialın redaktə edilməsi
    And user with login "ibrahimzamanov88@proton.me" and password "Ibrahimibrahim88!!" logs into the "AG-MEIS" system
    And goes to the control panel
    And goes to the electronic library tab in the control panel
    And selects edit button in the control panel
    And adds "Kənardan təlim" to training name input
    And adds instructor "Abbas Rzayev" from search list
    And adds file "edit" for training
    And user selects edit button
    And goes to the control panel
    When goes to the electronic library tab in the control panel
    Then all information about the training material is displayed in the table in the admin panel
      | Təlimin adı    | Təlimçi      | Təlim materialları | Baxış sayı |
      | Kənardan təlim | Abbas Rzayev | EndToEnd.pdf       | 0          |
    And selects delete button in the control panel
    Then the deleted training material is not displayed in the control panel
    #Test ssenarilər:
    #12.Yeni təlim materialın redakə edilməsi
    #13.Redaktə edildikdən sonra məlumatların yoxlanılması