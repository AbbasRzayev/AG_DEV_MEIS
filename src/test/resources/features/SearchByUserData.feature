@all
Feature: Search by user data

  @SearchParams
  Scenario: Check users search parameters
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the control panel
    And adds name to the name field
    When selects search button in the users tab
    Then search results are displayed by according to search name params
    And adds surname to the surname field
    When selects search button in the users tab
    Then search results are displayed by according to search surname params
    And selects unverified from verification status dropdown list
    When selects search button in the users tab
    Then search results are displayed by according to verification status
    And selects admin confirmed from verification status dropdown list
    When selects search button in the users tab
    Then search results are displayed by according to the verification status
    And adds fathers name to the fathers name field
    When selects search button in the users tab
    Then search results are displayed by according to search fathersname params
    And adds pin to the pin field
    When selects search button in the users tab
    Then search results are displayed by according to search pin params
    And adds workplace to the workplace field
    When user selects search button in the users tab
    Then search results are displayed by according to search workplace params
  #Scenariyoda yoxlanlır:
  #Adminpanel istifadəçi tabında axtarış funksionalı
  #1.İstifadəçinin adına görə nəticələrin yoxlanılması
  #2.İstifadəçinin soyadına görə nəticələrin yoxlanılması
  #3.İstifadəçinin ata adına görə nəticələrin yoxlanılması
  #4.İstifadəçinin təstiq statusuna görə nəticələrin yoxlanılması
  #5.İstifadəçinin fin koduna görə nəticələrin yoxlanılması
  #6.İstifadəçinin çalışdığı müəssisə görə nəticələrin yoxlanılması