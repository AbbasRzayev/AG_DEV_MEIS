@CIE
Feature: Contact information editing
#SCenario 1 - LDAP eks olunmur
  @CIE_2
  Scenario Outline: Check if user can edit his contact information from personal cabinet
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And user goes to the personal cabinet
    And user goes to the contact information tab from personal cabinet
    And user selects edit button in the contact information tab
    And user changes "<room>" and "<ip num>" and "<stasionar num>" and "<mobile num>" and "<users pc>" and "<LDAP users name>" in the edit modal window
    When user selects save button in the edit modal window
    Then user contact information has been successfully "<changed>"
    Examples:
      | room | ip num | stasionar num | mobile num | users pc           | LDAP users name | changed    |
      | 1111 | 3456   | 498521478     | 553968888  | PC_DESKTOP_15124DD | Ferid           | firstcase  |
      | 2222 | 4542   | 454535351     | 506730717  | PC_DESKTOP_13123FF | Abbas           | secondcase |

#Scenario 2 de birhdate ve vaiditydate redakte etdikden sonra deyishilmir
  @CIE_3
  Scenario Outline: Check if user can edit other users contact information from admin panel
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the control panel
    And adds name "Abbas" and fin "19HSHLY" to the name and fin fields
    And selects founded user
    And user selects edit button in the users information tab
    And user changes "<fathersname>" and "<birtdate>" and "<validitydate>" and "<room>" and "<ip num>" and "<stasionary num>" and "<mobile num>" and "<users pc>" and "<email>"
    When user selects save button in the edit modal window
    Then user contact information has been successfully "<changed>" in the users personal information tab
    Examples:
      | fathersname | birtdate   | validitydate | room | ip num | stasionary num | mobile num | users pc  | email                   | changed    |
      | Fuad oğlu   | 14.04.1988 | 07.10.2030   | 1111 | 4433   | 22222223341    | 506730717  | RZAYEV_PC | rzabbasqa@gmail.com     | firstcase  |
      | FUAD OĞLU   | 22.04.1988 | 29.10.2030   | 2222 | 5577   | 11111111111    | 553968888  | ABBAS_PC  | abbas.rzayev@aist.group | secondcase |

  #Test Ssenarilər:
  #1.İstifadəçi şəxsi kabinetindən əlaqə məlumatlarını redaktə etməsi (Otaq,İp telefon nömrəsi,Stasionar nömrə,Mobil nömrə,İstifadəçi komputeri, LDAP istifadəçi adı)
  #2.Şəxsi kabinetim hissəsindən əlaqə məlumatların redaktə edildikdən sonra məlumatların yoxlanılması
  #3.İstifadəçi şəxsi kabinetindən əlaqə məlumatlarını redaktə etməsi (Otaq,İp telefon nömrəsi,Stasionar nömrə,Mobil nömrə,İstifadəçi komputeri, LDAP istifadəçi adı)
  #4.İnzibatçının adminpaneldən istifadəçinin əlaqə məlumatlarını redaktə etməsi (Otaq,İp telefon nömrəsi,Stasionar nömrə,Mobil nömrə,İstifadəçi komputeri, LDAP istifadəçi adı)
  #5.Adminpaneldən əlaqə məlumatlarının redaktə edildikdən sonra məlumatların yoxlanılması