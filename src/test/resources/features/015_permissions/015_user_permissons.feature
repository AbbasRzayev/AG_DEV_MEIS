@userPermissions @new
Feature: User Permissions
  As a system administrator
  I want to assign, update, and verify permissions for users
  So that each user can only access the features and functionalities they are authorized to use within the system

  Scenario Outline: Check all permissions for user
    Given user with login "imranovfarid@gmail.com" and password "Farid1020@@@" logs into the "AG-MEIS" system
    And goes to the control panel
    And adds name "AT" and fin to the name and fin fields
    And user selects enter in the users tab
    And select founded user in the users tab in the admin panel
    And switches to the user permissions tab
    And selects "<permissions>" in the permissions tab
    And user select save changes button
    When admin selects Log in with user name button
    Then user can realize his "<opportunities>" in the MEIS system according to the permissions given to him
    Examples:
      | permissions                                     | opportunities    |
#      | Bütün istifadəçilərlə əməliyyatların aparılması | firstCase        |
#      | Elanlar modulunun idarə edilməsi                | secondCase       |
#      | Elektron jurnallara baxış                       | thirdCase        |
#      | Elektron jurnalların idarə edilməsi             | fourthCase       |
#      | Faydalı məlumatlar moduluna baxış               | fifthCase        |
#      | Faydalı məlumatlar modulunun idarə edilməsi     | sixthCase        |
#      | Fikir bankı modulunun idarə edilməsi            | seventhCase      |
#      | Hüquqi baza modulunun idarə edilməsi            | eighthCase       |
#      | Proqramçı IT mütəxəssis                         | ninthCase        |
#      | Proqramlar modulunun idarə edilməsi             | tenthCase        |
#      | Strukturda əməliyyatların aparılması            | eleventhCase     |
#      | Şəxsin adından sistemə giriş etmək              | twelfthCase      |
#      | Təbriklər modulunun idarə edilməsi              | thirteenthCase   |
#      | Təlimlər moduluna baxış                         | fourteenthCase   |
#      | Təlimlər modulunun idarə edilməsi               | fifteenCase      |
#      | Təqvimə baxış imkanı                            | sixteenCase      |
#      | Təqvim modulunun idarəedilməsi                  | seventeenCase    |
#      | Təyin edilmiş proqramlardan istifadə            | eighteenCase     |
#      | Yardım masası modulunun idarəedilməsi           | nineteenCase     |
      | Yardım masasına göndərilən müraciətlərə baxış   | twentyFirstCase  |
      | Bütün əməliyyatların aparılması                 | twentySecondCase |
    #Test ssenarilər:
    #1."Bütün istifadəçilərlə əməliyyatların aparılması" icazəsi verildikdə sol sidebarda İdarəetmə bölməsinin və admin paneldə İstifadəçilər tabının əks olunmasının yoxlanılması
    #2."Elanlar modulunun idarə edilməsi" icazəsi verildikdə sol sidebarda Elanlar bölməsinin və admin panel hissəsində Elanlar tabının əks olunmasının yoxlanılması
    #3."Elektron jurnala baxış" icazəsi verildikdə sol sidebarda "Elektron kitabxana/Elektron jurnal" bölməsinin əks olunmasının yoxlanılması
    #4."Elektron jurnalların idarə edilməsi" icazəsi verildikdə admin panel hissəsində Elektron kitabxana tabında "Elektron jurnal" bölməsinin əks olunmasının yoxlanılması
    #5."Faydalı məlumatlar moduluna baxış" icazəsi verildikdə sol sidebarda "Elektron kitabxana/Faydalı məlumatlar" bölməsinin əks olunmasının yoxlanılması
    #6."Faydalı məlumatlar modulununun idarə edilməsi" icazəsi verildikdə admin panel hissəsində Elektron kitabxana tabında "Faydalı məlumatlar" bölməsinin əks olunmasının yoxlanılması
    #7."Fikir bankı modulunun idarə edilməsi" icazəsi verildikdə sol sidebarda Idea bankı bölməsinin və admin paneldə İdea bankı tabının əks olunmasının yoxlanılması
    #8."Hüquqi baza modulunun idarə edilməsi" icazəsi verildikdə sol sidebarda Hüquqi baza bölməsinin və admin paneldə Hüquqi baza tabının əks olunmasının yoxlanılması
    #9."Proqramçı IT mütəxəssis" icazəsi verildikdə, istifadəçinin admin paneldə Yardım masası tabında və müraciət icraçıları siyahısında icraçı olaraq əks olunmasının yoxlanılması
    #10."Proqramlar modulunun idarə edilməsi" icazəsi verildikdə, admin paneldə Proqramlar və Şablonlar tablarının əks olunmasının yoxlanılması
    #11."Strukturda əməliyyatların aparılması" icazəsi verildikdə, admin paneldə Struktur və vəzifə tabının əks olunmasının yoxlanılması
    #12."Şəxsin adından sistemə giriş etmək" icazəsi verildikdə yoxlanlır:Admin userin adından sistemə daxil olması
    #13."Təbriklər modulunun idarə edilməsi" icazəsi verildikdə sol sidebarda Təbriklər bölməsinin və admin panel hissəsində Təbriklər tabının əks olunmasının yoxlanılması
    #14."Təlimlər moduluna baxış" icazəsi verildikdə sol sidebarda "Elektron kitabxana/Təlimlər materialları" bölməsinin əks olunmasının yoxlanılması
    #15."Təlimlər modulunun idarə edilməsi" icazəsi verildikdə admin panel hissəsində Elektron kitabxana tabında "Təıim materialları" bölməsinin əks olunmasının yoxlanılması
    #16."Təqvimə baxış imkanı" icazəsi verildikdə əsas səhifədə Təqvim icon və sol sidebarda Təvqim bölməsinin əks olunmasının yoxlanılması
    #17."Təqvim modulunun idarəedilməsi" icazəsi verildikdə admin panel hissəsində Təqvim bölməsinin əks olunmasının yoxlanılması
    #18."Təyin edilmiş proqramlardan istifadə" icazəsi verildikdə əsas səhifədə Proqramlarım iconun əks olunmasının yoxlanılması
    #19."Yardım masası modulunun idarəedilməsi" icazəsi verildikdə sol sidebarda Yardım masası bölməsi və admin panel hissəsində Yardım masası bölməsinin əks olunmasının yoxlanılması
    #20."Yardım masasına göndərilən müraciətlərə baxış" icazəsi verildikdə admin panel hissəsində yardım masasına aid müraciətlərin əks olunmasının yoxlanılması
    #21.Bütün əməliyyatların aparılması səlahiyyəti verildikdən sonra əsas səhifədə Proqramlarım, Elan və təbriklər, İdea Bankı, Hüquqi baza,Elektron kitabxana, Təqvim, İdarəetmə və Yardım masası linklərinin düzgün əks olunmasının yoxlanılması
    #22.Bütün əməliyyatların aparılması səlahiyyəti verildikdən sonra sol side menuda Əsas səhifə, Şəxsi kabinetim, Proqramlarım, Elan və təbriklər, İdea Bankı, Hüquqi baza, Elektron kitabxana, Təqvim, İdarəetmə və Yardım masası düymələrinin düzgün əks olunmasının yoxlanılması
    #23.Bütün əməliyyatların aparılması səlahiyyəti verildikdən sonra admin panel hissəsində İstifadəçilər, Şablonlar, Proqramlar, Struktur və vəzifə, Elanlar, Təbriklər, İdea Bankı, Hüquqi baza, Elektron kitabxana, Təqvim və Yardım masası tablarının düzgün əks olunmasının yoxlanılması