@all @ElectronicLibrary
Feature: Electronic library

  @EI
  Scenario Outline: Check if user can add/delete new training materials
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
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

  @UI
  Scenario: Check if user can add/delete new useful information
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the electronic library tab from personal cabinet
    And selects new useful information button in the electronic library tab
    And adds tittle name to tittle name input
    And adds file in the new useful information tab
    When user selects save button in the new useful information tab
    Then new useful information successfully added
    Then gets the information of the initial counter of the file for "useful information"
    When user upload the "file for useful information" from table
    Then counter of the information folder is displayed correctly due to the increase of the file for "useful information"
    When user selects delete button in the new useful information tab
    Then newly added useful successfully deleted

   @EJ
   Scenario: Check if user can add/delete new electron journal
     Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
     And goes to the electronic library tab from personal cabinet
     And selects new electron journal button in the electronic library tab
     And adds new journal name
     And adds number for journal name
     And selects person for notification and mail for the electron journal
     And adds journal date
     And selects person for the who sees field for the electron journal
     And adds file for training
     When user selects accept button
     Then gets the information of the initial counter of the file for "electron journal"
     When user upload the "file for electron journal" from table
     Then counter of the information folder is displayed correctly due to the increase of the file for "electron journal"
     When user selects delete button in the new electron journal tab
     Then newly added electron journal successfully deleted

  #Test ssenarilər:
  #1.Təlim materialları hissəsindən "Daxili təlimçi" seçimini seçərək yeni təlimin əlavə edilməsi
  #2.Əlavə edilmiş təlimin "Təlim materialları-Daxili təlimçi" hissəsində mövcud olmasının yoxlanılması
  #3.Təlim materialları(Daxili təlimçi) hissəsində file-upload sayğacının(click etdikdə artma) yoxlanılması
  #4.Yeni təlimin (Daxili təlimçi) sistemdən silinməsi
  #5.Silinmiş təlimin (Daxili təlimçi) sistemdə mövcud olmamasının yoxlanılması
  #6.Təlim materialları hissəsindən "Kənardan təlimçi" seçimini seçərək yeni təlimin əlavə edilməsi
  #7.Əlavə edilmiş təlimin "Təlim materialları-Kənardan təlimçi" hissəsində mövcud olmasının yoxlanılması
  #8.Təlim materialları(Kənardan təlimçi) hissəsində file-upload sayğacının(click etdikdə artma) yoxlanılması
  #9.Yeni təlimin (Kənardan təlimçi) sistemdən silinməsi
  #10.Silinmiş təlimin (Kənardan təlimçi) sistemdə mövcud olmamasının yoxlanılması
  #11.Faydalı məlumatlar hissəsindən faydalı məlumatın əlavə edilməsi
  #12.Əlavə edilmiş faydali məlumatın sistemdə mövcud olmasının yoxlanılması
  #13.Faydalı məlumatlar hissəsində file-upload sayğacının(click etdikdə artma) yoxlanılması
  #14.Yeni Faydalı məlumatın sistemdən silinməsi
  #15.Silinmiş faydalı məlumatın sistemdə mövcud olmamasının yoxlanılması
  #16.Elektron jurnal hissəsindən yeni elektron jurnalın əlavə edilməsi
  #17.Əlavə edilmiş elektron jurnalın sistemdə mövcud olmasının yoxlanılması
  #18.Elektron jurnal hissəsində file-upload sayğacının(click etdikdə artma) yoxlanılması
  #19.Yeni elektron jurnalın sistemdən silinməsi
  #20.Silinmiş elektron jurnalın sistemdə mövcud olmamasının yoxlanılması




