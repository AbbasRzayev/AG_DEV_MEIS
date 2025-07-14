Feature: User Permissions
  @UserPermissions
  Scenario Outline: Check all permissions for user
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the control panel
    And adds name "Abbas" and fin "19HSHLY" to the name and fin fields
    And selects founded user
    And switches to the user permissions tab
    And selects "<permissions>" in the permissions tab
    And user select save changes button
    When admin selects Log in with user name button
    Then user can realize his "<opportunities>" in the Meis system according to the permissions given to him
    Examples:
      | permissions                                                          | opportunities  |
      | Bütün istifadəçilərlə əməliyyatların aparılması                      | firstCase      |
      | Şəxsin adından sistemə giriş etmək                                   | secondCase     |
      | Strukturda əməliyyatların aparılması                                 | thirdCase      |
      | Təyin edilmiş proqramlardan istifadə                                 | fourthCase     |
      | Elanlar modulunun idarə edilməsi                                     | fifthCase      |
      | Proqramçı IT mütəxəssis                                              | sixthCase      |
      | Fikir bankı modulunun idarə edilməsi                                 | seventhCase    |
      | Təqvimə baxış imkanı                                                 | eighthCase     |
      | Təqvim modulunun idarəedilməsi                                       | ninthCase      |
      | Yardım masası modulunun idarəedilməsi                                | tenthCase      |
      | Yardım masasına göndərilən müraciətlərə baxış                        | eleventhCase   |
      | Təlimlər moduluna baxış                                              | twelfthCase    |
      | Təlimlər modulunun idarə edilməsi                                    | thirteenthCase |
      | Təbriklər modulunun idarə edilməsi                                   | fourteenthCase |
      | Hüquqi baza modulunun idarə edilməsi                                 | fifteenCase    |
      | Proqramlar modulunun idarə edilməsi                                  | sixteenCase    |
      | Faydalı məlumatlar moduluna baxış                                    | seventeenCase  |
      | Faydalı məlumatlar modulunun idarə edilməsi                          | eighteenCase   |
      | Bütün əməliyyatların aparılması                                      | nineteenth     |
#      | İltizamı təlimatlandırdığı istifadəçilərlə əməliyyatların aparılması | twentieth      |

    #1."Bütün istifadəçilərlə əməliyyatların aparılması" icazəsi verildikdə yoxlanılır:Idarəetmə(left sidebare) admin panelin əks olunması,admin paneldə istifadəçi tabının əks olunması.
    #2."Şəxsin adından sistemə giriş etmək" icazəsi verildikdə yoxlanlır:Admin userin adından sistemə daxil olması
    #3."Strukturda əməliyyatların aparılması" icazəsi verildikdə yoxlanılır: Idarəetmə hissəsindən Strukturda əməliyyatların aparılması tab əks olunur
    #4."Təyin edilmiş proqramlardan istifadə" yoxlanılır: Solsidebare proqramlar tabı, Əsas səhifədə proqramlar icon-düyməsi
    #5."Elanlar modulunun idarə edilməsi" yoxlanılır: Idarəetmə panelində Elanlar, Təbriklər, Soraqçalar
    #6."Proqramçı & IT mütəxəssis" yoxlanılır: İdarəetmə panelində Yardım Massasının tabı əks olunur
    #7."Fikir bankı modulunun idarə edilməsi" yoxlanılır: Idarəetmə panelində Fikirbankı tabın əks olunur
    #8."Təqvimə baxış imkanı " yoxlanılır: Əsas səhifədə icon button və leftsidebare menuda əks olunur
    #9."Təqvim modulunun idarəedilməsi" yoxlanılır: İdarə etmə panelində Təqvim tabın əks olunması
    #10."Yardım masası modulunun idarəedilməsi" yoxlanılır: Idarəetmə panelində Yardım masası tabı əks olunur
    #11."Yardım masasına göndərilən müraciətlərə baxış" yoxlanılır: Idarəetmə panelində Yardım masası daxil olaraq müraciətləri görür
    #12."Təlimlər moduluna baxış" yoxlanılır: Solsidebar hissindən Elanlar tabına keçid edərək Təlim materialları bölümü əks olunur
    #13."Təlimlər modulunun idarə edilməsi" yoxlanılır: Solsidebar hissindən Elanlar tabına keçid edərək Təlim materialları bölümündə "Yeni təlim" görünür(edit/delete).
    #14."Təbriklər modulunun idarə edilməsi" yoxlanılır:İdarəetmə panelində Təbriklər tabı əks olunur
    #15."Hüquqi baza modulunun idarə edilməsi" yoxlanılır:İdarəetmə panelində Hüquqi baza tabı əks olunur
    #16."Proqramlar modulunun idarə edilməsi" yoxlanılır:İdarəetmə panelində Şablonlar və Proqramlar əks olunur
    #17."Faydalı məlumatlar moduluna baxış" yoxlanılır:Solsidebar Elektron kitabxana tabına daxil olduqda Faydalı məlumatlar bölümü əks olunur
    #18."Faydalı məlumatlar modulunun idarə edilməsi" yoxlanılır:İdarəetmə panelində Faydalı tabı əks olunur
    #19."Bütün əməliyyatların aparılması" yoxlanılır:Əsas səhifə,SolsideBare,AdminPanel mövcud bütün tablar


     #Negativ yazilmalıdır