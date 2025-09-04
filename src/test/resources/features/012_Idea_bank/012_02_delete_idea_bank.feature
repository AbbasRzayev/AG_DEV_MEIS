@ideaBank
Feature:Idea Bank
  As a user of the AG-MEIS system,
  I want to add new ideas to the Idea Bank, view them, track their status, and delete them if needed,
  So that I can efficiently share suggestions, see their current status, and keep the Idea Bank up-to-date.

  @new @deleteIdea @test
  Scenario: Check if user can add or change status then delete idea bank
    Given user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    And goes to the idea bank tab from main page
    And selects add new idea button
    When user adds new idea by selecting save button
    Then the all ideas and pending status counters are updated and displayed correctly
    Then the information about new idea is displayed correctly in the idea bank section
      | İstiqamət | Fikir bildirən | Struktur      | Status         | Qeyd                                       |
      | Digər     | Abbas Rzayev   | AISTGroup MMC | Gözləmədə olan | Yeni idea bankı üçün qeyd əlavə edilmişdir |
    #Adminin yeni fikirin statusunu təstiqlənmiş statusuna dəyişməsi
    And switches to the idea bank tab from admin panel
    When user deletes idea bank by selecting delete button
    Then the idea has successfully deleted in the admin panel
    When user switches to the idea tab from sidebar
    Then the deleted idea is not displayed in the idea tab from sidebar
    #Test ssenarilər:
    #23.Adminin idarəetmə hissəsindən idea bankını silməsi
    #24.Silinən ideanın idarəetmə hissəsində mövcud olmamasının yoxlanılması
    #25.Silinən ideanın istifadəçilər hissəsində mövcud olmamasının yoxlanılması