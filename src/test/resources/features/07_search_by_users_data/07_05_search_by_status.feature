@all  @SearchParams @new
Feature: Search by user data

  @search_by_status
  Scenario Outline: Check users search parameters by administrator approval
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "AG-MEIS" system
    And goes to the control panel
    #İstifadəçi hesabın cari statusuna görə (təstiq edilən və edilməyən) nəticələrin yoxlanılması
    And selects the current status of the account "<approves>" in the filter
    When user selects enter in the users tab for admin approval
    Then search results of the current status are displayed by according to admin approval "<params>"
    #İnzibatçının təsdiqinə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes for current status
    Then the changes is successfully resets
    Examples:
      | approves | params  |
      | applied  | applied |
      | not      | not     |
    #Test ssenarilər:
    #15.İstifadəçi hesabının cari status təsdiqinə görə nəticələrin yoxlanılması
    #16.İstifadəçi hesabının cari status təsdiqinə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    #17.İstifadəçi hesabının cari statusunun, təsdiq edilmədiyi seçimlərə görə nəticələrin yoxlanılması
    #18.İstifadəçi hesabının cari statusunun, təsdiq edilmədiyi seçimlərə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması