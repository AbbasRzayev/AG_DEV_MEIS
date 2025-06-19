@all
Feature: Headers and Footers icons,buttons,texts
  @HeaderAndFooter
  Scenario: Check headers and footers icons-buttons-text are clickable and visible
    Given user with login "abbas.rzayev@aist.group" and with password "Rabbas88!!" logs into the "Meis" system
#      | Header menu   | Leftsidebare                                   |
#      | Header text   | Mərkəzləşdirilmiş Elektron İnformasiya Sistemi |
#      | Header button | Contacts                                       |
#      | Header button | Notification                                   |
#      | Header text   | Fullname of user                               |
#      | Header button | Personal cabinet                               |
    Then headers leftsidebare and text and contacts and notification and name and surname of user and personal cabinet buttons are clickable and visible
    When user scrolls to the end of page
#      | Footer icon      | Azərbaycan Respublikasının İqtisadiyyat Nazirliyi yanında Antiinhisar və İstehlak Bazarına Nəzarət Dövlət Xidməti |
#      | Footer copyright | Bütün hüquqlar qorunur                                                                                            |
#      | Footer icon      | AISTGroup MMC                                                                                                     |
   Then footers copyright text and icons are displayed and redirected

  #1.Header hissəsində:Solsidebar menyu, Mərkəzləşdirilmiş Elektron İnformasiya Sistemi(text),Kontaklar(düymə), Bildirişlər(düymə), İstifadəçi ad-soyad,Şəxsi kabinetim(düymə) əks olunması
  #2.Footer hissəsində: "Azərbaycan Respublikasının İqtisadiyyat Nazirliyi yanında Antiinhisar və İstehlak Bazarına Nəzarət Dövlət Xidməti"-logo, Bütün hüquqlar qorunur - copyright, AISTGroup MMC- logo əks olunması
  #3.Logoları klik etdikdə saytlara keçid etmə və url yoxlanılması


