@all @StructureAndDuties
Feature: Users structure and duties

  @StructureAndDutiesAdd
  Scenario Outline: Check if user can change his position in the structure and in his duties
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the control panel
    And adds name "Abbas" and fin "19HSHLY" to the name and fin fields
    And selects search button and switches to the change structure and duties tab
    And user select new "<structure>" position
    And selects new "<duties>"
    And selects submit button to change stucture and duties
    And adds again name "Abbas" and fin "19HSHLY" to the name and fin fields
    When selects search button for results
    Then users "<new duty>" has been changed successfully
    And selects search button and switches to his page
    And user goes to the personal cabinet
    When user switches to my position in the structure tab
    Then users "<new structure>" position has been changed successfully
    Examples:
      | structure                                                 | duties         | new duty       | new structure                                             |
      | Bakı şəhər şöbəsi                                         | Baş məsləhətçi | Baş məsləhətçi | Bakı şəhər şöbəsi                                         |
      | İnformasiya texnologiyaları və elektron idarəetmə sektoru | Sektor müdiri  | Sektor müdiri  | İnformasiya texnologiyaları və elektron idarəetmə sektoru |

  @StructureAddAndDelete
  Scenario: Check if user can add and then delete a new structure
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the control panel
    And switches to the structure and duties tab
    And selects plus button for adding new structure
    And adds information to the structure fields
      | structure name                | short name | company code | priority | Detailed information about the structure                               |
      | Problemli sınaq şöbələr(test) | PSŞ        | 7788         | 3        | Bu struktur automatlaşdırılmış testin tətbiqi üçün nəzərdə tutulmuşdur |
    When user adds new structure by using save button
    Then new structure has been added successfully
    When user deletes the newly added structure using the delete button
    Then newly structure has been deleted successfully

  @DutyAddAndDelete
  Scenario: Check if user can add and then delete a new duty
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the control panel
    And switches to the duties tab
    And selects plus button for adding new duty
    And adds duties name to the duty name field
    When user selects add button
    Then new duty has been added successfully
    And user deletes the newly added duty using the delete button
    Then newly duty has been deleted successfully
  #Test ssenarilər:
  #1.İstifadıçinin strukturda yer və vəzifəsinin dəyişdirilmə imkanı
  #2.İstifadəçinin dəyişdirilmiş strukturda yer və vəzifəsinin yoxlanılması
  #3.Yeni strukturun əlavə edilməsi
  #4.Yeni əlavə edilmiş strukturun sistemdə mövcud olmasının yoxlanılması
  #5.Əlavə edilmiş strukturun silinməsi
  #6.Silinmiş strukturun sistemde mövcud olmamasının yoxlanılması
  #7.Yeni vəzifənin əlavə edilməsi
  #8.Yeni əlavə edilmiş vəzifəsinin sistemdə mövcud olmasının yoxlanılması
  #9.Əlavə edilmiş strukturun silinməsi
  #10.Silinmiş strukturun sistemdə mövcud olmamasının yoxlanılması