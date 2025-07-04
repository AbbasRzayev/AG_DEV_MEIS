@all  @SearchParams
Feature: Search by user data

  @SearchByNameBySurnameByPin
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

  @SearchByDuty
  Scenario: Check users search parameters by duty
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "AG-MEIS" system
    And goes to the control panel
    #Vəzifəsinə görə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    And adds duty to the duty field in the filter
    When user selects enter in the users tab for duty
    Then search results are displayed by according to search duty params
    #İstifadəçinin çalışdığı müəssisəyə görə nəticələrin yoxlanılması
    When user reset the changes for duty
    Then the changes is successfully resets
    #Test ssenarilər:
    #7.İstifadəçinin vəzifəsinə görə nəticələrin yoxlanılması
    #8.Vəzifəsinə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması

  @SearchByWorkPlace
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

  @SearchByAdminApproval
  Scenario Outline: Check users search parameters by administrator approval
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "AG-MEIS" system
    And goes to the control panel
    #İstifadəçinin inzibatçının təsdiqinə görə nəticələrin yoxlanılması
    #İstifadəçinin inzibatçının təsdiq etmədiyi seçimlərə görə nəticələrin yoxlanılması
    And selects verification of the situation where the administrator "<approves>" in the filter
    When user selects enter in the users tab for admin approval
    Then search results are displayed by according to admin approval params
    #İnzibatçının təsdiqinə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes for admin approval
    Then the changes is successfully resets
    Examples:
      | approves |
      | applied  |
      | not      |
    #Test ssenarilər:
    #11.İstifadəçinin inzibatçının təsdiqinə görə nəticələrin yoxlanılması
    #12.İnzibatçının təsdiqinə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    #13.İstifadəçinin inzibatçının təsdiq etmədiyi seçimlərə görə nəticələrin yoxlanılması
    #14.İnzibatçının təsdiq etmədiyi seçimlərə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması

   #Cari statusu elave edildikden sonra autotestler yazilmalidir