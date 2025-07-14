@all
Feature: Legal basis

  @LegalBasis
  Scenario Outline: Check if user can add new document in the legal basis page
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the control panel
    And goes to the legal basis tab from admin panel
    And selects new document button for adding new document in the legal basis tab
    And adds "<header>" name in the legal basis tab
    And adds number to the number field
    And adds state registration number
    And selects type of document
    And adds the receiving authority
    And adds effective date
    And adds expiration date
    And adds date of admission
    And adds status of document
    And adds link to the link field
    And adds file for document
    And selects "<status>" for document
    When selects save button
    Then new "<document>" is successfully added
    And user with login "rzayevmusa1234@gmail.com" and with password "Musamusa88!!" logs into the "Meis" system
    When goes to the congratulations tab from sidebar
    Then document and information is "<displayed>" in the legal basis page
    Examples:
      | header                           | document                         | status                    | displayed  |
      | Document for public open         | Document for public open         | Ümumi açıq                | FirstCase  |
      | Document according to addressees | Document according to addressees | Ünvanlanmış şəxslərə görə | SecondCase |
      | Document according to structure  | Document according to structure  | Struktur bölmə daxilində  | ThirdCase  |
    #Test ssenarilər:
    #1.Yeni sənədin əlavə edilməsi (Ümumi açıq)
    #2.Yeni əlavə edilmiş sənədin sistemdə mövcud olması və məlumatların yoxlanılması(Ümumi açıq)
    #3.Yeni sənədin əlavə edilməsi(Ünvanlanmış şəxslərə görə)
    #4.Yeni əlavə edilmiş sənədin sistemdə mövcud olması və məlumatların yoxlanılması(Ünvanlanmış şəxslərə görə)
    #5.Yeni sənədin əlavə edilməsi(Struktur bölmə daxilində)
    #6.Yeni əlavə edilmiş sənədin sistemdə mövcud olması və məlumatların yoxlanılması(Struktur bölmə daxilində)
