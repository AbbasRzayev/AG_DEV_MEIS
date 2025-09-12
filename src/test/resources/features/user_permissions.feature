Feature: User Permissions

  Scenario Outline: Check all permissions for user
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the control panel
    And adds name "Abbas" and fin "19HSHLY" to the name and fin fields
    And selects founded user
    And switches to the user permissions tab
    And selects "<permissions>" in the permissions tab
    And user select save changes button
    When admin selects Log in with user name button
    Then user can realize his "<opportunities>" in the MEIS system according to the permissions given to him
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



#  if (opportunities.contains("firstCase")) {
#  ReusableMethods.wait(1);
#  page.leftSideBare.click();
#  ReusableMethods.flash(page.adminPanelBtn, getDriver());
#  assertTrue(page.adminPanelBtn.isDisplayed());
#  page.adminPanelBtn.click();
#  ReusableMethods.flash(page.userTittle, getDriver());
#  ReusableMethods.wait(1);
#  } else if (opportunities.contains("secondCase")) {
#  ReusableMethods.wait(1);
#  ReusableMethods.flash(page.checkUserName, getDriver());
#  assertTrue(page.checkUserName.isDisplayed());
#  } else if (opportunities.contains("thirdCase")) {
#  page.leftSideBare.click();
#  ReusableMethods.wait(2);
#  page.adminPanelBtn.click();
#  ReusableMethods.wait(1);
#  ReusableMethods.flash(page.sturctireAndDutyTab, getDriver());
#  ReusableMethods.wait(1);
#  assertTrue(page.sturctireAndDutyTab.isDisplayed());
#  page.sturctireAndDutyTab.click();
#  ReusableMethods.wait(1);
#  } else if (opportunities.contains("fourthCase")) {
#  ReusableMethods.wait(1);
#  ReusableMethods.flash(page.mainProqramBtnk, getDriver());
#  ReusableMethods.wait(1);
#  page.leftSideBare.click();
#  ReusableMethods.wait(1);
#  ReusableMethods.flash(page.leftSideBareProgram, getDriver());
#  page.leftSideBareProgram.click();
#  ReusableMethods.flash(page.programTittle, getDriver());
#  ReusableMethods.wait(1);
#  } else if (opportunities.contains("fifthCase")) {
#  page.leftSideBare.click();
#  ReusableMethods.wait(2);
#  page.adminPanelBtn.click();
#  ReusableMethods.flash(page.elanAdmin, getDriver());
#  page.elanAdmin.click();
#  ReusableMethods.wait(1);
#  //ReusableMethods.flash(page.tebrikAdmin, getDriver());
#  //page.tebrikAdmin.click();
#  ReusableMethods.wait(1);
#  ReusableMethods.flash(page.soraqAdmin, getDriver());
#  page.soraqAdmin.click();
#  ReusableMethods.wait(1);
#  } else if (opportunities.contains("sixthCase")) {
#  page.leftSideBare.click();
#  ReusableMethods.wait(2);
#  page.adminPanelBtn.click();
#  ReusableMethods.flash(page.helpAdminFlash, getDriver());
#  assertTrue(page.helpAdminFlash.isDisplayed());
#  ReusableMethods.wait(1);
#  page.adminPanelBtn.click();
#  ReusableMethods.flash(page.helpAdminFlash2, getDriver());
#  assertTrue(page.helpAdminFlash2.isDisplayed());
#  } else if (opportunities.contains("seventhCase")) {
#  page.leftSideBare.click();
#  ReusableMethods.wait(2);
#  page.adminPanelBtn.click();
#  ReusableMethods.flash(page.ideaAdmin, getDriver());
#  assertTrue(page.ideaAdmin.isDisplayed());
#  page.ideaAdmin.click();
#  ReusableMethods.wait(1);
#  page.soraqAdmin.click();
#  ReusableMethods.flash(page.ideaSoraq, getDriver());
#  } else if (opportunities.contains("eighthCase")) {
#  ReusableMethods.flash(page.mainCalendar, getDriver());
#  page.leftSideBare.click();
#  ReusableMethods.wait(2);
#  ReusableMethods.flash(page.leftSideCalendar, getDriver());
#  ReusableMethods.wait(1);
#  } else if (opportunities.contains("ninthCase")) {
#  page.leftSideBare.click();
#  page.adminPanelBtn.click();
#  ReusableMethods.flash(page.adminCalendar, getDriver());
#  page.adminCalendar.click();
#  ReusableMethods.wait(1);
#  } else if (opportunities.contains("tenthCase")) {
#  page.leftSideBare.click();
#  page.adminPanelBtn.click();
#  ReusableMethods.flash(page.helpDeskAdmin, getDriver());
#  ReusableMethods.wait(1);
#  } else if (opportunities.contains("eleventhCase")) {
#  page.leftSideBare.click();
#  page.adminPanelBtn.click();
#  ReusableMethods.wait(1);
#  page.helpDeskAdmin.click();
#  ReusableMethods.wait(1);
#  ReusableMethods.flash(page.helpDeskVisionAdin, getDriver());
#  ReusableMethods.wait(1);
#  } else if (opportunities.contains("twelfthCase")) {
#  page.leftSideBare.click();
#  page.elanSideBare.click();
#  ReusableMethods.wait(1);
#  ReusableMethods.flash(page.studyAdminFlash, getDriver());
#  assertTrue(page.studyAdminFlash.isDisplayed());
#  ReusableMethods.wait(1);
#  } else if (opportunities.contains("thirteenthCase")) {
#  page.leftSideBare.click();
#  page.adminPanelBtn.click();
#  page.electronBookAdmin.click();
#  ReusableMethods.wait(1);
#  ReusableMethods.flash(page.newUsefull, getDriver());
#  assertTrue(page.newUsefull.isDisplayed());
#  ReusableMethods.wait(1);
#  } else if (opportunities.contains("fourteenthCase")) {
#  page.leftSideBare.click();
#  page.adminPanelBtn.click();
#  ReusableMethods.wait(1);
#  ReusableMethods.flash(page.congratAdmin, getDriver());
#  page.congratAdmin.click();
#  ReusableMethods.wait(1);
#  } else if (opportunities.contains("fifteenCase")) {
#  page.leftSideBare.click();
#  page.adminPanelBtn.click();
#  ReusableMethods.wait(1);
#  ReusableMethods.flash(page.bazaAdmin, getDriver());
#  page.bazaAdmin.click();
#  ReusableMethods.wait(2);
#  } else if (opportunities.contains("sixteenCase")) {
#  page.leftSideBare.click();
#  page.adminPanelBtn.click();
#  ReusableMethods.wait(1);
#  ReusableMethods.flash(page.shablonAdmin, getDriver());
#  page.shablonAdmin.click();
#  ReusableMethods.flash(page.proqAdmin, getDriver());
#  assertTrue(page.proqAdmin.isDisplayed());
#  page.proqAdmin.click();
#  ReusableMethods.wait(2);
#  } else if (opportunities.contains("seventeenCase")) {
#  page.leftSideBare.click();
#  page.electronBookLeftside.click();
#  ReusableMethods.wait(1);
#  ReusableMethods.flash(page.usefullFlash, getDriver());
#  assertTrue(page.usefullFlash.isDisplayed());
#  ReusableMethods.wait(1);
#  } else if (opportunities.contains("eighteenCase")) {
#  page.leftSideBare.click();
#  page.adminPanelBtn.click();
#  ReusableMethods.wait(1);
#  page.electronBookAdmin.click();
#  ReusableMethods.flash(page.usefullFlash, getDriver());
#  ReusableMethods.flash(page.usefullAddBtn, getDriver());
#  assertTrue(page.usefullAddBtn.isDisplayed());
#  page.usefullAddBtn.click();
#  ReusableMethods.wait(1);
#  } else if (opportunities.contains("nineteenth")) {
#  ReusableMethods.flash(page.checkUserName, getDriver());
#  assertTrue(page.checkUserName.isDisplayed());
#  ReusableMethods.flash(page.mainEsas, getDriver());
#  assertTrue(page.mainEsas.isDisplayed());
#  ReusableMethods.flash(page.mainPersonalCab, getDriver());
#  assertTrue(page.mainEsas.isDisplayed());
#  ReusableMethods.flash(page.mainProg, getDriver());
#  assertTrue(page.mainProg.isDisplayed());
#  ReusableMethods.flash(page.mainElan, getDriver());
#  assertTrue(page.mainElan.isDisplayed());
#  ReusableMethods.flash(page.mainFikir, getDriver());
#  assertTrue(page.mainFikir.isDisplayed());
#  ReusableMethods.flash(page.mainBaza, getDriver());
#  assertTrue(page.mainBaza.isDisplayed());
#  ReusableMethods.scrollEndByJavascript();
#  ReusableMethods.flash(page.mainElectronBook, getDriver());
#  assertTrue(page.mainElectronBook.isDisplayed());
#  ReusableMethods.flash(page.mainCal, getDriver());
#  assertTrue(page.mainCal.isDisplayed());
#  ReusableMethods.flash(page.mainAdminPanel, getDriver());
#  assertTrue(page.mainAdminPanel.isDisplayed());
#  ReusableMethods.flash(page.mainHelpDesk, getDriver());
#  assertTrue(page.mainHelpDesk.isDisplayed());
#  ReusableMethods.flash(page.mainExit, getDriver());
#  assertTrue(page.mainExit.isDisplayed());
#  ReusableMethods.scrollTopByJavascript();
#  page.leftSideBare.click();
#
#  ReusableMethods.flash(page.leftMain, getDriver());
#  assertTrue(page.leftMain.isDisplayed());
#  ReusableMethods.flash(page.leftPer, getDriver());
#  assertTrue(page.leftPer.isDisplayed());
#  ReusableMethods.flash(page.leftProq, getDriver());
#  assertTrue(page.leftProq.isDisplayed());
#  ReusableMethods.flash(page.leftElm, getDriver());
#  assertTrue(page.leftElm.isDisplayed());
#  ReusableMethods.flash(page.leftIdea, getDriver());
#  assertTrue(page.leftIdea.isDisplayed());
#  ReusableMethods.flash(page.leftBaza, getDriver());
#  assertTrue(page.leftBaza.isDisplayed());
#  ReusableMethods.flash(page.leftELecLibary, getDriver());
#  assertTrue(page.leftELecLibary.isDisplayed());
#  ReusableMethods.flash(page.leftcal, getDriver());
#  assertTrue(page.leftcal.isDisplayed());
#  ReusableMethods.flash(page.leftAdmin, getDriver());
#  assertTrue(page.leftAdmin.isDisplayed());
#  ReusableMethods.flash(page.leftHelp, getDriver());
#  assertTrue(page.leftHelp.isDisplayed());
#  ReusableMethods.flash(page.leftExit, getDriver());
#  assertTrue(page.leftExit.isDisplayed());
#  page.adminPanelBtn.click();
#  ReusableMethods.wait(1);
#
#  page.adminUsers.click();
#  ReusableMethods.flash(page.adminUsers, getDriver());
#  assertTrue(page.adminUsers.isDisplayed());
#  ReusableMethods.wait(1);
#
#  page.adminShablon.click();
#  ReusableMethods.flash(page.adminShablon, getDriver());
#  assertTrue(page.adminShablon.isDisplayed());
#  ReusableMethods.wait(1);
#
#  page.adminProqram.click();
#  ReusableMethods.flash(page.adminProqram, getDriver());
#  assertTrue(page.adminProqram.isDisplayed());
#  ReusableMethods.wait(1);
#
#
#  page.adminStrukturDuty.click();
#  ReusableMethods.flash(page.adminStrukturDuty, getDriver());
#  assertTrue(page.adminStrukturDuty.isDisplayed());
#  ReusableMethods.wait(1);
#
#
#  page.adminElan.click();
#  ReusableMethods.flash(page.adminElan, getDriver());
#  assertTrue(page.adminElan.isDisplayed());
#  ReusableMethods.wait(1);
#
#
#  page.adminCongrats.click();
#  ReusableMethods.flash(page.adminCongrats, getDriver());
#  assertTrue(page.adminCongrats.isDisplayed());
#  ReusableMethods.wait(1);
#
#  page.adminIdea.click();
#  ReusableMethods.flash(page.adminIdea, getDriver());
#  assertTrue(page.adminIdea.isDisplayed());
#  ReusableMethods.wait(1);
#
#  page.adminBaza.click();
#  ReusableMethods.flash(page.adminBaza, getDriver());
#  assertTrue(page.adminBaza.isDisplayed());
#  ReusableMethods.wait(1);
#
#  page.adminElectrLibary.click();
#  ReusableMethods.flash(page.adminElectrLibary, getDriver());
#  assertTrue(page.adminElectrLibary.isDisplayed());
#  ReusableMethods.wait(1);
#
#  page.adminCal.click();
#  ReusableMethods.flash(page.adminCal, getDriver());
#  assertTrue(page.adminCal.isDisplayed());
#  ReusableMethods.wait(1);
#
#  page.adminHelpDesk.click();
#  ReusableMethods.flash(page.adminHelpDesk, getDriver());
#  assertTrue(page.adminHelpDesk.isDisplayed());
#  ReusableMethods.wait(1);
#
#  page.adminQuestionnaires.click();
#  ReusableMethods.flash(page.adminQuestionnaires, getDriver());
#  assertTrue(page.adminQuestionnaires.isDisplayed());
#  ReusableMethods.wait(1);
#  }