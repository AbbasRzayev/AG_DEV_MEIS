@all @helpDesk @test
Feature: Create new request
  As a registered user,
  I want to create, edit, and manage requests in the Help Desk section by providing details such as direction, program, priority, notification type, description, and attachments,
  So that I can effectively report issues, suggestions, or errors and track the status of my requests within the system.

  @newRequest @new
  Scenario: Check the creation of a new request in the help desk tab
    Given user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    And goes to the help desk tab from main page
    And selects software "Digər problemlər" selection from the direction dropdown list
    And selects appeal "Xəta" from the notification type dropdown list
    And selects "Yüksək" from the notification priority dropdown list
    And adds text "new" to the description field
    And adds "new" file in the help desk tab
    And user selects save button in the help desk tab
    When selects the last appeal from the table
    Then new request has been successfully created and all information are displayed
      | İstiqamət        | Bildirişi göndərən | Əlaqə     | İP   | Kompüterinin adı | Bildirişin tipi | Prioritet | Cari nəticə | Akt tərtib edilib | Təsvir                                       | İş yeri       |
      | Digər problemlər | Abbas Rzayev       | 553968888 | 2233 | PC_99_77         | Xəta            | Yüksək    | İlkin       | Xeyr              | Xahiş olunur ki müraciətimə təcili baxılsın! | AISTGroup MMC |
    And selects edit button in the request review section
    And selects software "Proqram təminatı" selection from the direction dropdown list
    And selects "Elektron Sənəd Dövriyyəsi" program from software dropdown list
    And selects "Təcili" from the notification priority dropdown list
    And selects appeal "Təklif" from the notification type dropdown list
    And adds text "edited" to the description field
    And adds "edited" file in the help desk tab
    And user selects save button in the help desk tab
    When selects the last appeal from the table
    Then the edited request has been successfully created and all information are displayed
      | İstiqamət        | Bildirişi göndərən | Proqram təminatı          | Əlaqə     | İP   | Kompüterinin adı | Bildirişin tipi | Prioritet | Cari nəticə | Akt tərtib edilib | Təsvir                   | İş yeri       |
      | Proqram təminatı | Abbas Rzayev       | Elektron Sənəd Dövriyyəsi | 553968888 | 2233 | PC_99_77         | Təklif          | Təcili    | İlkin       | Xeyr              | Müraciət redaktə edildi! | AISTGroup MMC |
    #Test ssenarilər əhatə edir:
    #1.İstifadəçinin Yardım masası tabından yeni müraciətin əlavə edilməsi
    #2.Yeni müraciətin göndərilmiş müraciətlər cədvəlində əks olunması
    #3.Yeni müraciətin baxış hissəsinə keçid edərək id-sinin yoxlanılması
    #4.Yeni müraciətin baxış hissəsinə keçid edərək istiqamət məlumatının yoxlanılması
    #5.Yeni müraciətin baxış hissəsinə keçid edərək bildirişi göndərən məlumatının yoxlanılması
    #6.Yeni müraciətin baxış hissəsinə keçid edərək tarix məlumatının yoxlanılması
    #7.Yeni müraciətin baxış hissəsinə keçid edərək əlaqə məlumatının yoxlanılması
    #8.Yeni müraciətin baxış hissəsinə keçid edərək ip telefon nömrəsi məlumatının yoxlanılması
    #9.Yeni müraciətin baxış hissəsinə keçid edərək istifadəçi komputerin adı məlumatının yoxlanılması
    #10.Yeni müraciətin baxış hissəsinə keçid edərək bildiriş tipi məlumatının yoxlanılması
    #11.Yeni müraciətin baxış hissəsinə keçid edərək prioritet məlumatının yoxlanılması
    #12.Yeni müraciətin baxış hissəsinə keçid edərək cari nəticə məlumatının yoxlanılması
    #13.Yeni müraciətin baxış hissəsinə keçid edərək akt tərtib edilib məlumatının yoxlanılması
    #14.Yeni müraciətin baxış hissəsinə keçid edərək fayl məlumatının mövcud və link olmasının yoxlanılması
    #15.Yeni müraciətin baxış hissəsinə keçid edərək müraciət edənin qeyd məlumatının yoxlanılması
    #16.Yeni müraciətin baxış hissəsinə keçid edərək iş yeri məlumatının yoxlanılması
    #17.Yeni müraciətin redktə edilməsi
    #18.Redaktə edildikdən sonra məlumatların yoxlanılması