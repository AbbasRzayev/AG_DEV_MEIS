@electronLibrary
Feature:Electron library
  As a registered user with the necessary permissions,
  I want to create a new training material by adding its title, content, attachments, and relevant metadata,
  So that employees or participants can easily access and benefit from the training content in the system

  @trainingMaterial @new
  Scenario Outline: Check if user can add/delete new training materials
    Given user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system


    And goes to the electronic library tab from personal cabinet
    And selects new training button in the training materials tab
    And adds "<training name>" to training name input
    And selects one of the two "<checkboxes>"
    And adds instructor from search list
    And adds training date
    And selects person for notification and mail
    And selects person for the who sees field
    And adds file for training
    And adds note to the note input
    When user selects sava button
    Then new "<material>" successfully added
    Then gets the information of the initial "<counter>" of the file for training materials
    When user upload the "<file>" from table
    Then counter of the information folder is displayed correctly due to the "<increase>" of the file for training materials
#    And user edit newly added material by using "<edit button>"
#    Then newly added material succssfully "<edited>"
    When user selects delete button on the "<new>" added material
    Then newly added material successfully "<deleted>"
    Examples:
      | training name  | checkboxes | material   | edit button | edited     | new            | deleted    | counter | file | increase |
#      | Daxili təlim   | firstcase  | firstcase  | firstcase   | firstcase  | Daxili təlim   | firstcase  | Daxili  | Daxili     | Daxili   |
      | Kənardan təlim | secondcase | secondcase | secondcase  | secondcase | Kənardan təlim | secondcase | Kənar   | Kənar      | Kənar    |
