@all
Feature: Left sidebar menu

  @leftSideBar
  Scenario: Check if user can navigate to the tabs from left sidebar menu
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "AG-MEIS" system
    And user selects left sidebar button
    When user selects main page from left sidebar
      #Əsas səhifə
    Then user successfully switches to the main page
    When user selects personal cabinet from left sidebar
      #ŞəxsiKabinetim
    Then user successfully switches to the personal cabinet tab
#    When user selects programs from left sidebar
#      #Proqramlarım
#    Then user successfully switches to the program tab
#    When user selects announcement and congratulations from left sidebar
#      #Elan və təbriklər
#    Then user successfully switches to the announcement and congratulations page
    When user selects idea bank from left sidebar
      #Idea bankı
    Then user successfully switches to the idea bank page
    When user selects legal basis from left sidebar
      #Hüquqi baza
    Then user successfully switches to the legal basis page
    When user selects electronic library from left sidebar
      #Elektron kitabxana
    Then user successfully switches to the electronic library
    When user selects Calendar from left sidebar
      #Təqvim
    Then user successfully switches to the calendar page
    When user selects admin panel from left sidebar
      #İdarəetmə
    Then user successfully switches to the admin panel
    When user selects  help desk from left sidebar
      #Yardım masası
    Then user successfully switches to the help desk page
    When user selects  log out from left sidebar
      #Çıxış
    Then user successfully log out from "AG-MEIS" system
  #Test Ssenarilər
  #1.Sidebardan "Əsas səhifə"-tabına keçid edərək url və title yoxlanılması
  #2.Sidebardan "Şəxsi Kabinetim"-tabına keçid edərək url və title yoxlanılması
  #3.Sidebardan "Proqramlarım"-tabına keçid edərək url və title yoxlanılması
  #4.Sidebardan "Elan və Təbriklər"-tabına keçid edərək url və title yoxlanılması
  #5.Sidebardan "İdea bankı"-tabına keçid edərək url və title yoxlanılması
  #6.Sidebardan "Hüquqi baza"-tabına keçid edərək url və title yoxlanılması
  #7.Sidebardan "Elektron kitabxana"-tabına keçid edərək url və title yoxlanılması
  #8.Sidebardan "Təqvim"-tabına keçid edərək url və title yoxlanılması
  #9.Sidebardan "İdarəetmə"-tabına keçid edərək url və title yoxlanılması
  #10.Sidebardan "Yardım masası"-tabına keçid edərək url və title yoxlanılması
  #11.Sidebardan "Çıxış"-düyməsini təstiqləyərək autorizasiya səhifəsinə keçid, url və title yoxlanılması