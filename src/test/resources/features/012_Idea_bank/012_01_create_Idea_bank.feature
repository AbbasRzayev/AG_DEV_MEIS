@ideaBank
Feature:Idea Bank
  As a registered user of the MEIS system,
  I want to create, update the status, like/unlike, comment, and delete ideas in the Idea Bank
  So that I can share my ideas, get feedback, and manage their lifecycle effectively.

  @new @createIdea
  Scenario: Check if user can add or change status then delete idea bank
    Given user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    #Statusların sayğac dəyərlərinin götürülməsi
    And goes to the idea bank tab from main page
    And selects add new idea button
    When user adds new idea by selecting save button
    #Yeni ideanın əks olunması və bütün fikirlər statusunun yoxlanılması
    Then the all ideas and pending status counters are updated and displayed correctly
    Then the information about new idea is displayed correctly in the idea bank section
      | İstiqamət | Fikir bildirən | Struktur      | Status         | Qeyd                                       |
      | Digər     | Abbas Rzayev   | AISTGroup MMC | Gözləmədə olan | Yeni idea bankı üçün qeyd əlavə edilmişdir |
    #Adminin yeni fikirin statusunu təstiqlənmiş statusuna dəyişməsi
    And switches to the idea bank tab from admin panel
    And user with role admin changes the status of the idea to accepted status
    And user switches to the idea tab from sidebar
    Then the status of the idea has successfully changed to accepted status and the accepted status counter is displayed correctly
      | Status       |
      | Təsdiqlənmiş |
    #Like,unlike, rəyin əlavə edilməsi və sayğacların yoxlanılması
    When user selects like button
    Then the like buttons counter is displayed correctly
    When user selects unlike button
    Then the unlike buttons counter is displayed correctly
    When user adds comment
    Then added comment is displayed correctly
      | Rəy               |
      | Maraqlı təklifdir |
    Then the comment counter is displayed correctly
    #Adminin yeni idea statusunu ləğv edilmiş statusuna dəyişməsi
    And switches to the idea bank tab from admin panel
    And user with role admin changes the status of the idea to canceled status
    When user switches to the idea tab from sidebar
    Then the status of the idea has successfully changed to canceled status and the canceled status counter is displayed correctly
      | Status       |
      | Ləğv edilmiş |
  #Test ssenarilər:
  #1.İdea bankı hissəsindən yeni fikrin əlavə edilməsi
  #2.Istidaəçi hissəsində Yeni əlavə edilmiş ideanın mövcud olmasının yoxlanılması
  #3.Istidaəçi hissəsində ideanın bütün fikirler və gözləmədə olanlar sayğaclarının artmasının yoxlanılması
  #4.İstidadəçi hissəsində idea bankın istiqamət məlumatının yoxlanılması
  #5.İstidadəçi hissəsində idea bankın fikir bildirən məlumatının yoxlanılması
  #6.İstidadəçi hissəsində idea bankın struktur məlumatının yoxlanılması
  #7.İstidadəçi hissəsində idea bankın statusun gözləmədə olduğunun yoxlanılması
  #8.İstidadəçi hissəsində idea bankın tarix məlumatının yoxlanılması
  #9.İstidadəçi hissəsində idea bankın qeyd məlumatının yoxlanılması
  #10.Adminin yeni idea statusunu təstiqlənmiş statusuna dəyişməsi
  #11.Istifadçi hissəsində yeni idea statusunun təstiqlənmiş olduğunun yoxlanılması
  #12.Istifadçi hissəsində qəbul edilənlər (təstiqlənmiş) sayğacının yenilənməsinin yoxlanılması
  #13.Istifadəçi yeni ideanın üzərində like düyməsi seçilməsi
  #14.Like düyməsi seçildikdən sonra like sayğacının yenilənməsinin yoxlanılmasl
  #15.Istifadəçi yeni ideanın üzərində unlike düyməsi seçilməsi
  #16.Unlike düyməsi seçildikdən sonra unlike sayğacının yenilənməsinin yoxlanılmasl
  #17.Istifadəçi yeni idea üçün rəy bildirməsi
  #18.Yeni ideanın üzərində rəyin əks olunması
  #19.Rəy verildikdən sonra rəy sağacının yenilənməsinin yoxlanılması
  #20.Adminin yeni idea statusunu ləğv edilmiş statusuna dəyişməsi
  #21.Istifadçi hissəsində yeni idea statusunun ləğv edilmiş olduğunun yoxlanılması
  #22.Istifadçi hissəsində ləğv edilmiş sayğacının yenilənməsinin yoxlanılması