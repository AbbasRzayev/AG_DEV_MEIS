@all @programTemplate
Feature: Program template application for new user
  As an administrator,
  I want to apply an existing program template to a newly created user,
  so that the user has preconfigured program settings.

  @programTemplateAssignToUser @new
  Scenario: Check if admin can apply a program templates to a newly user
    Given user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    And goes to the control panel
    And the user switches to the program templates tab
    And the user clicks the "new Template" button
    And the user enters "new" as the template name
    And the user selects "new" duty for the template
    And the user selects "new" structure for the template
    And the user clicks the "Next" button
    And the user selects the "new" program for template
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
    When selects next button
    Then the added program template is displayed in the registration stage
    And selects duty and structure on the fifth stage
    And user select escape button
    And goes to the control panel
    And the user switches to the program templates tab
    When selects delete button in the template tab
#    Then the deleted template is not displayed in the template tab
    #Test ssenarilər:
    #9.Yeni istifadəçi yaradılarkən proqram şablonunun tətbiqi
    #10.Qeydiyyatın bütün mərhələlərində şablon məlumatlarının düzgün göstərilməsi
