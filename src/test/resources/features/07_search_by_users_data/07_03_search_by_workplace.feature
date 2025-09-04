@all  @SearchParams @new
Feature: Search by user data

  @search_by_workplace @test
  Scenario: Check users search parameters by workplace
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "AG-MEIS" system
    And goes to the control panel
    #İstifadəçinin çalışdığı müəssisəyə görə nəticələrin yoxlanılması
    And adds workplace "Keyfiyyətə Nəzarət(AT)" to the workplace field in the filter
    When user selects enter in the users tab
    Then search results are displayed by according to search workplace params
    #Çalışdığı müəssisəyə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes for workplace
    Then the changes is successfully resets
    #Test ssenarilər:
    #9.İstifadəçinin çalışdığı müəssisəyə görə nəticələrin yoxlanılması
    #10.Çalışdığı müəssisəyə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması