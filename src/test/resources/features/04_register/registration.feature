@all @registration @new
Feature: User registration
  As an Administrator,
  I want to register a new user in the AG-MEIS system,
  So that I can manage their access, update their information, assign permissions, and archive them when needed.

  @user_registration
  Scenario: Check if the user can register in the AG-MEIS system then log in and archive the user
    Given user with login "imranovfarid@gmail.com" and password "Farid1020@@@" logs into the "AG-MEIS" system
    #Yeni istifadəçinin qeydiyyatı
    And goes to the control panel
    And selects new user button
    And adds information to the field on the first registration stage
    #FakePin, Fake emailAddress, Fake serialNumber
      | FIN     | Sənədin seriya və nömrəsi | Elektron poçt            | LDAP istifadəçi adı |
      | 1231231 | AA778899443               | abbaszamanov88@proton.me | Abbas               |
    And selects not domain registration
    And selects next button
    And adds picture and information to the field on the second registration stage
      | Ad    | Soyad   | Ata adı | Dogum tarixi | Etibarlıq müddəti | Yaşadıqı ünvan |
      | Abbas | Zamanov | Fuad    | 22.04.1988   | 20.07.2025        | Səbayıl rayonu |
    And selects next button
    And information to the field on the third registration stage
      | Yeni şifrə   | Sifrənin təkrarı |
      | Rabbas8888!! | Rabbas8888!!     |
    And selects next button
    And information to the field on the fourth registration stage
      | Otaq  | Mobil nömrə  | İP telefon nömrəsi | Stasinonar nömrə |
      | 11111 | 55 396 88 88 | 2222               | 788787788        |
    And selects next button
    And selects duty and structure on the fifth stage
    And selects next button
    And selects instructor on the sixth stage
    And selects next button
    #And close register modal window
    #OTTP kodun yönləndirilməsi
    And gets the verification code from email and puts it to the add code field
    When user selects confirm button
    And user with login "imranovfarid@gmail.com" and password "Farid1020@@@" logs into the "AG-MEIS" system
    And goes to the control panel
    And adds name "Zamanov" and fin to the name and fin fields
    When user selects enter in the users tab
    #Yeni qeydiyyat olunan istifadəçinin sistemdə mövcud olmasının yoxlanılması
    Then new user "Zamanov" successfully registered
    #İstifadəçinin qeydiyyat bitikdən sonra şəxsi və əlaqəli məlumatlarının yoxlanılması
    And selects founded user from table
    Then new registered users pin and serial number are displayed correctly
    Then new registered users name and surname and father name and birth data and gender and validity period are displayed correctly
      | Ad    | Soyad   | Ata adı | Dogum tarixi | Etibarlıq müddəti | Cins |
      | Abbas | Zamanov | Fuad    | 22.04.1988   | 20.07.2025        | Kişi |
    Then new registered users room and ip phone and stationary number and mobile number and email is displayed correctly
      | Otaq  | Mobil nömrə | IP telefon nömrəsi | Stasinonar nömrə | Elektron poçt            |
      | 11111 | 553968888   | 2222               | 788787788        | abbaszamanov88@proton.me |
    #Admin istifadəçinin şəxsi və əlaqə məlumatlarını redaktə edir
    And admin select edit button in the user account control page
    When admin edited users personal and contact info in the user account control page
      | Ad    | Soyad | Ata adı | Dogum tarixi | Etibarlıq müddəti | Cins | Otaq | Mobil nömrə | IP   | Stasionar nömrə | FIN     | Seriya    | Email                    | Komputer |
      | Musab | İyad  | Umeyr   | 22.04.1988   | 12.12.2025        | Kişi | 3333 | 506730717   | 1010 | 98899889989     | 19HLOII | AA7788994 | zamanovabbasqa@gmail.com | PC-007   |
    #Redaktə edildikdən sonra istifadəçinin şəxsi və əlaqə məlumatlarının yoxlanılması
    Then users personal and contact info are successfully edited
      | Ad    | Soyad | Ata adı | Dogum tarixi | Etibarlıq müddəti | Cins | Otaq | Mobil nömrə | IP   | Stasionar nömrə | FIN     | Seriya    | Email                    | Komputer |
      | Musab | İyad  | Umeyr   | 22.04.1988   | 12.12.2025        | Kişi | 3333 | 506730717   | 1010 | 98899889989     | 19HLOII | AA7788994 | zamanovabbasqa@gmail.com | PC-007   |
    #Adminin istifadəçiyə icazə və MEİS-də səlahiyyətləri verməsi
    And goes to the user permissions tab
    And admin gives rights and permissions to the new user
    And goes to the control panel
    And adds name "Musab" and fin to the name and fin fields
    When user selects enter in the users tab
    #Idarəetmə-istifadəçilər cədvəlində inzibatçı təstiqi və statusunun yoxlanılması
    Then admin control is displayed as a given in the users table
    Then status is displayed as a given in the users table
    When user selects exit button
    #Yeni istifadəçinin icazə və səlahiyyətlət verildikdən sonra sistemə daxil olması
    When new user logs into the "AG-MEIS" system
      | Email                    | Şifrə        |
      | zamanovabbasqa@gmail.com | Rabbas8888!! |
    Then new user has been successfully log into the system
    #Yeni istifadəçi şəxsi kainetində, şəxsi və əlaqə məlumatlarının yoxlanılması
    And user goes to the personal cabinet
    When user switches to the personal info tab in the personal cabinet
    Then the users personal info is displayed correctly
      | Ad    | Soyad | Ata adı | Dogum tarixi | Etibarlıq müddəti | Cins | FIN     | Seriya    |
      | Musab | İyad  | Umeyr   | 22.04.1988   | 12.12.2025        | Kişi | 19HLOII | AA7788994 |
    When user switches to the connection info tab in the personal cabinet
    Then the users connection info is displayed correctly
      | Otaq | Mobil nömrə | IP   | Stasionar nömrə | Email                    | Komputer |
      | 3333 | 506730717   | 1010 | 98899889989     | zamanovabbasqa@gmail.com | PC-007   |
    When user selects exit button
    #Adminin yeni istifadəçini arxivləşdirməsi və sistemdə mövcud olmamasının yoxlanılması
    And user with login "imranovfarid@gmail.com" and password "Farid1020@@@" logs into the "AG-MEIS" system
    And goes to the control panel
    And adds name "Musab" and fin to the name and fin fields
    And user selects enter in the users tab
    And selects founded user from table
    And goes to the user permissions tab
    And admin archived the new user
    And adds name "Musab" and fin to the name and fin fields
    And user selects enter in the users tab
    Then user not found and successfully archived
    When user selects exit button
    #Arxivləşdirdikdən sonra istifadəçinin sistemdə daxil ola bilməməsinin yoxlanılması
    And new user logs into the "AG-MEIS" system
      | Email                    | Şifrə        |
      | zamanovabbasqa@gmail.com | Rabbas8888!! |
    Then the archived user cannot access to the system
  #Test ssenarilər:
  #1.Qeydiyyat bütün mərhələlərində vacib xanalara əlavə edərək keçid etməsi (7-mərhələ)
  #2.Yeni istifadəçinin qeydiyyat edilməsi
  #3.İstifadəçinin elektron poçt ünvanına OTTP kodun yönlənidrilməsi
  #4.Sistemdə OTTP kod təsdiqləndikdən sonra qeydiyyatın yekunlaşması
  #5.Qeydiyyat yekunlaşdıqdan sonra yeni istifadəçinin sistemdə mövcud olmasının yoxlanılması
  #6.Yeni istifadəçinin şəxsi məlumatlarım hissəsində FİN məlumatlarının yoxlanılması
  #7.Yeni istifadəçinin şəxsi məlumatlarım hissəsində Ad məlumatlarının yoxlanılması
  #8.Yeni istifadəçinin şəxsi məlumatlarım hissəsində Soyad məlumatlarının yoxlanılması
  #9.Yeni istifadəçinin şəxsi məlumatlarım hissəsində Ata adı məlumatlarının yoxlanılması
  #10.Yeni istifadəçinin şəxsi məlumatlarım hissəsində Doğum tarixi məlumatlarının yoxlanılması
  #11.Yeni istifadəçinin şəxsi məlumatlarım hissəsində Cinsi məlumatlarının yoxlanılması
  #12.Yeni istifadəçinin şəxsi məlumatlarım hissəsində Otaq məlumatlarının yoxlanılması
  #13.Yeni istifadəçinin əlaqə məlumatlarım hissəsində İP telefon nömrəsi məlumatlarının yoxlanılması
  #14.Yeni istifadəçinin əlaqə məlumatlarım hissəsində Stasionar nömrə məlumatlarının yoxlanılması
  #15.Yeni istifadəçinin əlaqə məlumatlarım hissəsində Mobil nömrə məlumatlarının yoxlanılması
  #16.Yeni istifadəçinin əlaqə məlumatlarım hissəsində Elektron poçt məlumatlarının yoxlanılması
  #17.Yeni istifadəçinin şəxsi məlumatlarının redaktə edilməsi
  #18.Redaktə edildikdən sonra istifadəçi məlumatlarının yoxlanılması
  #19.Yeni istifadəçinin şəxsi məlumatlarının redaktə edilməsi
  #20.Redaktə edildikdən sonra istifadəçi məlumatlarının yoxlanılması
  #21.Adminin istifadəçiyə icazə və MEİS-də səlahiyyətləri verməsi
  #22.İcazə verildikdən sonra istifadəçinin, idarəetmə-istifadəçilər cədvəlində inzibatçı təstiqi və statusunun yoxlanılması
  #23.Yeni istifadəçinin icazə və səlahiyyətlət verildikdən sonra sistemə daxil olması
  #24.Yeni istifadəçi şəxsi kainetində, şəxsi və əlaqə məlumatlarının yoxlanılçası
  #25.Adminin yeni istifadəçini arxivləşdirməsi
  #26.Arxivləşdirdikdən sonra istifadəçinin sistemdə olmamasının yoxlanılması
  #27.Arxivləşdirdikdən sonra istifadəçinin sistemdə daxil ola bilməməsinin yoxlanılması


#  Scenario: Deleting the confirmation letter from meis
#    Given user goes to the gmail
#    Then deletes confirmation letter