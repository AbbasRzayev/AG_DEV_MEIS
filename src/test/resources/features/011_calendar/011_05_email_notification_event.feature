@all @calendar @test
Feature: Event email notification
  As a user,
  I want the scheduled event details to be automatically sent via email to the assigned participants,
  So that they are informed in a timely manner and can effectively follow the planned event.

  @eventEmail @new
  Scenario: Check if the scheduled event automatically sent via email to the assigned participants
    Given user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    #Bütün vacib xanaları seçərək yeni tədbirin əlavə edilməsi
    And goes to the calendar tab
    And selects new event button
    And adds name "AT_TesT" for new event
    And selects category "Elan" for a new event
    And adds start date and time "00:30" for new event
    And adds end date and time "17:00" for new event
    And adds reminder "00:15" notification for the event
    And adds the person "Abbas" who organized the new event
    And adds url "https://aist.group/" for new event
    And selects user "İbrahim" for new event notification
    And selects user "İbrahim" for status view according to the addressees
    And adds the description "Tədbir AT elanı məqsədi ilə əlavə edildi!" for the new event
    And determines where the event "671 nömrəli otaq" will be held
    And adds the picture "Test" for the new event
    And adds the file "QaAutomation" for the new event
    And page is down
    And selects submit button for the new event
    #Ünvanlanmış şəxs elektron poçt ünvanına daxil olur
    And the user "İbrahim" enters to the e-mail address
    When opens notification about "event" in the email
    Then all information about the "event" is displayed in the email notification
      | Bildiriş Adı   | Tədbir status     | Kateqoriya | Başlığı | Tərtib edən  | Təsvir                                    | Tədbirin keçiriləcəyi yer | Status                    | Şəxslər             | Başlama Saatı | Bitmə Saatı | Url                 |
      | AT_TesT (Elan) | Təqvim yaradıldı! | Elan       | AT_TesT | Abbas Rzayev | Tədbir AT elanı məqsədi ilə əlavə edildi! | 671 nömrəli otaq          | Ünvanlanmış şəxslərə görə | İbrahim Rzayev Fuad | 00:30         | 17:00       | https://aist.group/ |
    Then file for "event" is displayed in the email notification
    #Test ssenarilər:
    #46.Tədbir(təqvim) bildirişinin istifadəçinin elektron poçtuna yönləndirilməsi
    #47.E-poçt bildirişində tədbirin bildiriş adı məlumatının yoxlanılması
    #48.E-poçt bildirişində tədbir status məlumatının yoxlanılması
    #49.E-poçt bildirişində tədbirin kateqoriya məlumatının yoxlanılması
    #50.E-poçt bildirişində tədbirin başlığı məlumatının yoxlanılması
    #51.E-poçt bildirişində tədbiri tərtib edən məlumatının yoxlanılması
    #52.E-poçt bildirişində tədbirin başlama tarix məlumatının yoxlanılması
    #53.E-poçt bildirişində tədbirin bitmə tarix məlumatının yoxlanılması
    #54.E-poçt bildirişində tədbirin təsvir məlumatının yoxlanılması
    #55.E-poçt bildirişində tədbirin keçirələcəyi yer məlumatının yoxlanılması
    #56.E-poçt bildirişində status məlumatının yoxlanılması
    #57.E-poçt bildirişində ünvanlanmış şəxs məlumatının yoxlanılması
    #58.E-poçt bildirişində tədbirin başlama saatı məlumatının yoxlanılması
    #59.E-poçt bildirişində tədbirin bitmə saatı məlumatının yoxlanılması
    #60.E-poçt bildirişində tədbirin url məlumatının yoxlanılması
    #61.E-poçt bildirişində əlavə edilmiş faylların mövcudluğunun yoxlanılması