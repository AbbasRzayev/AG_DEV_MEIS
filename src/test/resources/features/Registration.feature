@all @Registration
Feature: User registration

  @Reg1
  Scenario: Check if the user can register in the meis system then log in and archive the user
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the control panel
    And selects new user button
    And adds information to the field on the first registration stage
      | FIN     | Sənədin seriya və nömrəsi | Elektron poçt            | LDAP istifadəçi adı |
      | 1231231 | AA1233211                 | zamanovabbasqa@gmail.com | Abbas               |
    And selects not domein registration
    And selects next button on the first stage
    And adds picture and information to the field on the second registration stage
      | Ad    | Soyad   | Ata adı | Dogum tarixi | Etibarlıq müddəti | Yaşadıqı ünvan |
      | Abbas | Zamanov | Fuad    | 22.04.1988   | 20.07.2025        | Səbayıl rayonu |
    And selects next button on the second stage
    And information to the field on the third registration stage
      | Yeni şifrə | Sifrənin təkrarı |
      | Abbas88!!! | Abbas88!!!       |
    And selects next button on the third stage
    And information to the field on the fourth registration stage
      | Otaq  | Mobil nömrə  | İP telefon nömrəsi | Stasinonar nömrə |
      | 11111 | 55 396 88 88 | 2222               | 788787788        |
    And selects next button on the fourth stage
    And selects duty and structure on the fifth stage
    And selects next button on the fifth stage
    And selects instructor on the sixth stage
    And selects complete registration button
    And gets the verification code from email and puts it to the add code field
    #When user selects confirm button
    Then new user successfully registered

  @Reg2
  Scenario: Check if the admin can grant permission to the new user
   #Given admin logs to the system to give the necessary permissions to the use
    Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    And goes to the control panel
    And adds name "Abbas" and fin "1231231" to the name and fin fields
    And selects search button in the users tab
    And selects founded user and switches to the user permissions tab
    When admin gives rights to new user to login the system
    Then new user logs to the system successfully
    And user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "Meis" system
    #And admin logs to the system to give the necessary permissions to the use
    And admin goes to the control panel
    And adds name "Abbas" and fin "1231231" to the name and fin fields
    And selects search button in the users tab
    And selects founded user and switches to the user permissions tab
    And admin selects archive user button
    And admin adds name "Abbas" and fin "1231231" to the name and fin fields
    When admin selects search button in the users tab
    Then user not found and successfully archived


  @Reg3
  Scenario: Deleting the confirmation letter from meis
    Given user goes to the gmail
    Then deletes confirmation letter
  #Test ssenarilər:
  #1.Qeydiyyat bütün mərhələlərində vacib xanalara əlavə edərək keçid etməsi (7-mərhələ)
  #2.Qeydiyyatı yekunlaşdırması üçün sonuncu mərhələdə istifadəçinin  elektron poçt ünvanına təstiq kodunun gəlməsi
  #3.Təstiq kodunu əlavə edərək qeydiyyatı uğurla yekunlaşdırması
  #4.İnzibatçının yeni istifadəçiyə sistemə daxil olması üçün səlahiyyətlərin verilməsi
  #5.Səlahiyyətlər verildikdən sonra yeni istifadəçinin elektron poçt ünvanına hesabının təstiq olunması barədə bildirişin gəlməsi
  #6.Səlahiyyətlər verildikdən sonra yeni istifadəçinin sistemə daxil olması
  #7.İnzibatçı tərəfindən yeni istifadəçi hesabının arxivləşdirməsi
  #8.Arxivləşdirilmiş istifadəçinin sistemdə mövcud olmamasının təstiqi
