@all @new
Feature: Headers and Footers icons,buttons,texts

  @header_and_footer
  Scenario: Check headers and footers icons-buttons-text are clickable and visible
    Given user with login "imranovfarid@gmail.com" and password "Farid1020@@@" logs into the "AG-MEIS" system
    #Header
    Then headers left sidebar are clickable and visible
    Then "Mərkəzləşdirilmiş Elektron İnformasiya Sistemi" is displayed in the header section
    Then contacts are clickable and visible in the header section
    Then notification is clickable and visible in the header section
    Then personal cabinet is clickable and visible in the header section
    Then "Fərid İmranov" name and surname of user is displayed correctly in the header section
    #Footer
    When user scrolls to the end of page
    Then copyright is displayed in the footer section
    Then logo is displayed and redirected in the footer section
  #Test ssenarilər:
  #1.Header hissəsində sol side barın mövcud olması
  #2.Header hissəsində Mərkəzləşdirilmiş Elektron İnformasiya Sistemi əks olunması
  #3.Header hissəsində kontaklarımın əks olunması və seçilməsi
  #4.Header hissəsində bildirişlərin əks olunması və seçilməsi
  #5.Header hissəsində şəxsi kabinetimin əks olunması və seçilməsi
  #6.Header hissəsində ad və soyadın əks olunması
  #7.Footer "Bütün hüquqlar qorunur - copyright" əks olunması
  #8.Footer hissəsində "AISTGroup MMC"- logoC:\Users\User\TestFiles\Test.png
  # əks olunması əks olunması və klik etdikdə keçid etmə və url yoxlanılması