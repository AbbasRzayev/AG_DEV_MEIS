@all  @SearchParams @new
Feature: Search by user data

  @search_by_admin_approval
  Scenario Outline: Check users search parameters by administrator approval
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "AG-MEIS" system
    And goes to the control panel
    #İstifadəçinin inzibatçının təsdiqinə görə nəticələrin yoxlanılması
    #İstifadəçinin inzibatçının təsdiq etmədiyi seçimlərə görə nəticələrin yoxlanılması
    And selects verification of the situation where the administrator "<approves>" in the filter
    When user selects enter in the users tab for admin approval
    Then search results are displayed by according to admin approves "<params>"
    #İnzibatçının təsdiqinə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes for admin approval
    Then the changes is successfully resets
    Examples:
      | approves | params  |
      | applied  | applied |
      | not      | not     |
    #Test ssenarilər:
    #11.İstifadəçinin inzibatçının təsdiqinə görə nəticələrin yoxlanılması
    #12.İnzibatçının təsdiqinə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    #13.İstifadəçinin inzibatçının təsdiq etmədiyi seçimlərə görə nəticələrin yoxlanılması
    #14.İnzibatçının təsdiq etmədiyi seçimlərə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması