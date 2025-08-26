@electronicLibrary @test
Feature:Delete training material
  As a registered user with the necessary permissions,
  I want to delete an existing training material from the system,
  So that outdated, irrelevant, or incorrect content is removed and employees or participants only access valid and useful training resources.

  @deleteTrainingMaterial @new
  Scenario: Check if user can delete new training materials
    Given user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    #Təlim materialın əlavə edilməsi
    And goes to the control panel
    And goes to the electronic library tab in the control panel
    And selects new training button in the training materials tab
    And adds "Daxili təlim AT" to training name input
    And adds training date
    And adds instructor "Davud" from search list
    And selects person "İbrahim" for notification and mail
    And selects person "İbrahim" for the who sees field
    And adds note "Automaiton kurslar barədə" to the note input
    And adds file "new" for training
    And user selects save button
    And user selects exit button
    #Təlim materialın silinməsi
    And user with login "ibrahimzamanov88@proton.me" and password "Ibrahimibrahim88!!" logs into the "AG-MEIS" system
    And goes to the control panel
    And goes to the electronic library tab in the control panel
    And selects delete button in the control panel
    Then the deleted training material is not displayed in the control panel
    #Test ssenarilər:
    #14.Adminin idarəetmə hissəsindən təlim materialının silməsi
    #15.Silinən təlimin idarəetmə hissəsində mövcud olmamasının yoxlanılması