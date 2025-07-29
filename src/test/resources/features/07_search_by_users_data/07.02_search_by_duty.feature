@all  @SearchParams @new
Feature: Search by user data

  @search_by_duty
  Scenario: Check users search parameters by duty
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "AG-MEIS" system
    And goes to the control panel
    #Vəzifəsinə görə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    And adds duty to the duty field in the filter
    When user selects enter in the users tab for duty
    Then search results are displayed by according to search duty params
    #İstifadəçinin çalışdığı müəssisəyə görə nəticələrin yoxlanılması
    When user reset the changes for "duty"
    Then the changes is successfully resets
    #Test ssenarilər:
    #7.İstifadəçinin vəzifəsinə görə nəticələrin yoxlanılması
    #8.Vəzifəsinə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması