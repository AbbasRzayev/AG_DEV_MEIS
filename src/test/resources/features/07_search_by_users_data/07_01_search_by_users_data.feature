@all  @SearchParams @new
Feature: Search by user data

  @search_by_name_by_surname_by_pin @test
  Scenario: Check users search parameters by name surname and pin
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "AG-MEIS" system
    And goes to the control panel
    #İstifadəçinin adına görə nəticələrin yoxlanılması
    And adds name to the name field in the filter
    When user selects enter in the users tab
    Then search results are displayed by according to search name params
    #Adına görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes
    Then the changes is successfully resets
    #İstifadəçinin soyadına görə nəticələrin yoxlanılması
    And adds surname to the surname field in the filter
    When user selects enter in the users tab
    Then search results are displayed by according to search surname params
    #Soyadına görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes
    Then the changes is successfully resets
    #İstifadəçinin fin koduna görə nəticələrin yoxlanılması
    And adds pin to the pin field in the filter
    When user selects enter in the users tab
    Then search results are displayed by according to search pin params
    #Fin koduna görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes
    Then the changes is successfully resets
    #Test ssenarilər:
    #1.İstifadəçinin adına görə nəticələrin yoxlanılması
    #2.Adına görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    #3.İstifadəçinin soyadına görə nəticələrin yoxlanılması
    #4.Soyadına görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    #5.İstifadəçinin fin koduna görə nəticələrin yoxlanılması
    #6.Fin koduna görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması








