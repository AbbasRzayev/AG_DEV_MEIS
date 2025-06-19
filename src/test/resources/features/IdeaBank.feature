@IdeaBank
Feature:Idea Bank

  Scenario: Check if user can add or change status then delete idea bank
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the idea bank tab from main page
    And selects add new idea button
    When user adds new idea by selecting save button
    Then the  all ideas status counter is changed and displayed correctly
    And switches to the idea bank tab from admin panel
    And user with role admin changes the status of the idea to pending status
    When user switches to the idea tab from sidebar
    Then the status of the idea has successfully changed to pending status and the pending status counter is displayed correctly
    And switches to the idea bank tab from admin panel
    And user with role admin changes the status of the idea to accepted status
    When user switches to the idea tab from sidebar
    Then the status of the idea has successfully changed to accepted status and the accepted status counter is displayed correctly
    And switches to the idea bank tab from admin panel
    And user with role admin changes the status of the idea to canceled status
    When user switches to the idea tab from sidebar
    Then the status of the idea has successfully changed to canceled status and the canceled status counter is displayed correctly
    When user selects like button
    Then the like buttons counter is displayed correctly
    When user selects unlike button
    Then the unlike buttons counter is displayed correctly
    When user adds comment
    Then added comment is displayed correctly
    And switches to the idea bank tab from the admin panel
    When user deletes idea bank by selecting delete button
    Then the idea has successfully deleted

  #Test ssenarilər:
  #1.Fikir bankı hissəsindən yeni fikrin əlavə edilməsi
  #2.Admin panel hissəsində yeni əlavə edilmiş fikrin mövcud olmasının yoxlanılması
  #3.Adminin yeni fikirin statusunu gözləmədə olanlar statusuna dəyişməsi
  #4.İstifadəçi tərəfdə bütün fikirlər sayğacının düzgün işlənilməsinin yoxlanılması
  #5.İstifadəçi tərəfdə yeni fikir statusunun gözləmədə olanlar statusuna dəyişilməsinin yoxlanılması
  #6.İstifadəçi tərəfdə gözləmədə status sayğacının düzgün işlənilməsinin yoxlanılması
  #7.Adminin yeni fikirin statusunu təstiqlənmiş statusuna dəyişməsi
  #8.İstifadəçi tərəfdə yeni fikir statsunun təstiqlənmiş statusuna dəyişilməsinin yoxlanılması
  #9.İstifadəçi tərəfdə təstiqlənmiş status sayğacının düzgün işlənilməsinin yoxlanılması
  #10.Adminin yeni fikirin statusunu ləğv edilənlər statusuna dəyişməsi
  #11.İstifadəçi tərəfdə yeni fikir statsunun ləğv edilənlər statusuna dəyişilməsinin yoxlanılması
  #12.İstifadəçi tərəfdə ləğv edilənlər status sayğacının işlənilməsinin yoxlanılması
  #13.Yeni fikrin üzərində like düyməsi seçildikdə like sayğacının düzgün işlənilməsinin yoxlanılması
  #14.Yeni fikrin üzərində unlike düyməsi seçildikdə unlike sayğacının düzgün işlənilməsinin yoxlanılması
  #15.Yeni fikrə şərhin əlavə edilməsi və əks olunması
  #16.Yeni fikrə şərh sayğacının düzgün işlənilməsinin yoxlanılması
  #17.Yeni fikrin silinməsi və sistemdən silinməsinin yoxlanılması




