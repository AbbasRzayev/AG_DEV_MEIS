@all
Feature: Legal basis
  As an administrator (or a user with the necessary permissions)
  I want to add a new document to the Legal Basis page by providing details such as header, number, registration data, document type, authority, effective/expiration dates, status, links, and attachments
  So that the system stores the document in the Legal Basis repository and makes it available to other users for reference and compliance purposes

  @legalBasis @new
  Scenario: Check if user can add new document in the legal basis page
    Given user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    And goes to the control panel
    And goes to the legal basis tab from admin panel
    And selects new document button for adding new document in the legal basis tab
    And adds "new" name in the legal basis tab
    And adds "7788" number to the number field
    And adds state registration "AG-88" number
    And selects type "Əsasnamə" of document
    And adds the "new" receiving authority
    And adds effective date
    And adds expiration date
    And adds date of admission
    And adds "new" status of document
    And selects status "addressed person" for view
    And adds file for document
    And adds link to the link field
    When selects save button
    And page is up
    Then all information about legal basis is displayed in the legal base page
      | Başlıq   | Nömrəsi | Sənədin növü | Qəbul edən orqan | Status |
      | New Data | 7788    | Əsasnamə     | IT Product       | check  |
    When selects legal basis from table in the legal base page
    Then all information about legal basis is displayed in the legal base modal window
      | Başlıq   | Nömrəsi | Sənədin növü | Qəbul edən orqan | Status  |
      | New Data | 7788    | Əsasnamə     | IT Product       | Qüvvədə |
    And user select escape button
    And user selects exit button
    And user with login "rzayevmusa1234@gmail.com" and password "Musamusa88!!" logs into the "AG-MEIS" system
    And goes to the control panel
    And goes to the legal basis tab from admin panel
    Then all information about legal basis is displayed in the legal base page
      | Başlıq   | Nömrəsi | Sənədin növü | Qəbul edən orqan | Status |
      | New Data | 7788    | Əsasnamə     | IT Product       | check  |
    When selects legal basis from table in the legal base page
    Then all information about legal basis is displayed in the legal base modal window
      | Başlıq   | Nömrəsi | Sənədin növü | Qəbul edən orqan | Status  |
      | New Data | 7788    | Əsasnamə     | IT Product       | Qüvvədə |
    #Test ssenarilər:
    #1.Yeni sənədin əlavə edilməsinin yoxlanılması (Ünvanlanmış şəxs üzrə)
    #2.Əlavə edilmiş yeni sənədin sistemdə mövcud olmasının və məlumatlarının düzgünlüyünün yoxlanılması
    #3.Yeni sənədi seçərək "Fikrinizi bildirin" modal pəncərəsində başlıq məlumatının düzgün əks olunmasının yoxlanılması
    #4.Yeni sənədi seçərək "Fikrinizi bildirin" modal pəncərəsində nömrə məlumatının düzgün əks olunmasının yoxlanılması
    #5.Yeni sənədi seçərək "Fikrinizi bildirin" modal pəncərəsində sənədin növü məlumatının düzgün əks olunmasının yoxlanılması
    #6.Yeni sənədi seçərək "Fikrinizi bildirin" modal pəncərəsində qəbul edən orqan məlumatının düzgün əks olunmasının yoxlanılması
    #7.Yeni sənədi seçərək "Fikrinizi bildirin" modal pəncərəsində qüvvəyə minmə tarixi məlumatının düzgün əks olunmasının yoxlanılması
    #8.Yeni sənədi seçərək "Fikrinizi bildirin" modal pəncərəsində qüvvədən düşmə tarixi məlumatının düzgün əks olunmasının yoxlanılması
    #9.Yeni sənədi seçərək "Fikrinizi bildirin" modal pəncərəsində qəbul tarixi məlumatının düzgün əks olunmasının yoxlanılması
    #10.Yeni sənədi seçərək "Fikrinizi bildirin" modal pəncərəsində status məlumatının düzgün əks olunmasının yoxlanılması
    #11.Yeni sənədi seçərək "Fikrinizi bildirin" modal pəncərəsində URL məlumatının və URL-ə keçidin düzgün işləməsinin yoxlanılması
    #12.Ünvanlanmış şəxsin adından sistemə daxil olaraq sənədin sistemdə mövcud olmasının və məlumatlarının düzgün əks olunmasının yoxlanılması
    #13.Ünvanlanmış şəxsin adından sənədi seçərək "Fikrinizi bildirin" modal pəncərəsində bütün məlumatların düzgün əks olunmasının yoxlanılması