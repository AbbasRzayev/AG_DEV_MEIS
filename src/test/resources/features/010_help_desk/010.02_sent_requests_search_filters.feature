@all @helpDesk @new @test
Feature: Search filters in the sent requests section
  As a user of the Help Desk system,
  I want to use search filters in the Sent Requests section (such as direction, program, priority, notification type, status, and date),
  So that I can quickly find and review specific requests I have submitted without scrolling through the entire list.

  Background:
    Given user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
    And goes to the help desk tab from main page
    And goes to the my sent requests section

  @sentNameSearchFilter @filter
  Scenario: Checking the sender filter in the sent requests section
    #Müraciəti göndərənin ad və soyadına görə filterin yoxlanılması
    And adds name to the sent filter
    When user selects enter in the users tab
    Then search results are displayed by according to search name surname params
    #Müraciəti göndərənin ad və soyadına görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes
    Then the changes is successfully resets in the sent requests section
    #Test ssenarilər:
    #19.Yeni müraciətlər hissəsindən Göndərdiyim müraciətlər hissəsinə keçidin yoxlanılması
    #20.Müraciəti göndərənin ad və soyadına görə axtarış filter nəticələrinin yoxlanılması
    #21.Müraciəti göndərənin ad və soyadına görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması

  @directionSearchFilter @filter
  Scenario: Checking the direction filter in the sent requests section
    #Müraciəti proqram təminatı istiqamətinə görə axtarış filterin yoxlanılması
    When selects direction "Proqram təminatı" from direction filter list
    Then search results are displayed by according to search direction "Proqram təminatı" params
    #Müraciəti proqram təminatı istiqamətinə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes for "direction"
    Then the changes is successfully resets in the sent requests section
    #Müraciəti digər problemlər istiqamətinə görə axtarış filterin yoxlanılması
    When selects direction "Digər problemlər" from direction filter list
    Then search results are displayed by according to search direction "Digər problemlər" params
    #Müraciəti digər problemlər istiqamətinə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes for "direction"
    Then the changes is successfully resets in the sent requests section
    #Müraciəti şəbəkə və rabitə problemləri istiqamətinə görə axtarış filterin yoxlanılması
    When selects direction "Şəbəkə və rabitə problemləri" from direction filter list
    Then search results are displayed by according to search direction "Şəbəkə və rabitə problemləri" params
    #Müraciəti şəbəkə və rabitə problemləri istiqamətinə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes for "direction"
    Then the changes is successfully resets in the sent requests section
    #Müraciəti əməliyyat sistemi istiqamətinə görə axtarış filterin yoxlanılması
    When selects direction "Əməliyyat sistemi" from direction filter list
    Then search results are displayed by according to search direction "Əməliyyat sistemi" params
    #Müraciəti əməliyyat sistemi istiqamətinə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes for "direction"
    Then the changes is successfully resets in the sent requests section
    #Müraciəti cari işlər istiqamətinə görə axtarış filterin yoxlanılması
    When selects direction "Cari işlər" from direction filter list
    Then search results are displayed by according to search direction "Cari işlər" params
    #Müraciəti cari işlər istiqamətinə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes for "direction"
    Then the changes is successfully resets in the sent requests section
    #Müraciəti elektron xidmətlər istiqamətinə görə axtarış filterin yoxlanılması
    When selects direction "Elektron xidmətlər" from direction filter list
    Then search results are displayed by according to search direction "Elektron xidmətlər" params
    #Müraciəti elektron xidmətlər istiqamətinə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes for "direction"
    Then the changes is successfully resets in the sent requests section
    #Müraciəti avadanlıq istiqamətinə görə axtarış filterin yoxlanılması
    When selects direction "Avadanlıq" from direction filter list
    Then search results are displayed by according to search direction "Avadanlıq" params
    #Müraciəti avadanlıq istiqamətinə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes for "direction"
    Then the changes is successfully resets in the sent requests section
    #Test ssenarilər:
    #22.Müraciəti proqram təminatı istiqamətinə görə axtarış filterin yoxlanılması
    #23.Müraciəti proqram təminatı istiqamətinə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    #24.Müraciəti digər problemlər istiqamətinə görə axtarış filterin yoxlanılması
    #25.Müraciəti digər problemlər istiqamətinə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    #26.Müraciəti şəbəkə və rabitə problemləri istiqamətinə görə axtarış filterin yoxlanılması
    #27.Müraciəti şəbəkə və rabitə problemləri istiqamətinə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    #28.Müraciəti əməliyyat sistemi istiqamətinə görə axtarış filterin yoxlanılması
    #29.Müraciəti əməliyyat sistemi istiqamətinə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    #30.Müraciəti cari işlər istiqamətinə görə axtarış filterin yoxlanılması
    #31.Müraciəti cari işlər istiqamətinə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    #32.Müraciəti elektron xidmətlər istiqamətinə görə axtarış filterin yoxlanılması
    #33.Müraciəti elektron xidmətlər istiqamətinə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    #34.Müraciəti avadanlıq istiqamətinə görə axtarış filterin yoxlanılması
    #35.Müraciəti avadanlıq istiqamətinə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
  
  @notificationTypeSearchFilter
  Scenario: Checking the notification type filter in the sent requests section
    #Bildiriş tipi "Xəta"-ya görə axtarışın filterin yoxlanılması
    When selects "Xəta" from notification type filter list
    Then search results are displayed by according to search note type "Xəta" params
    #Bildiriş tipi "Xəta"-ya görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes for "note type"
    Then the changes is successfully resets in the sent requests section
    #Bildiriş tipi "Təklif"-ə görə axtarışın filterin yoxlanılması
    When selects "Təklif" from notification type filter list
    Then search results are displayed by according to search note type "Təklif" params
    #Bildiriş tipi "Təklif"-ə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes for "note type"
    Then the changes is successfully resets in the sent requests section
    #Bildiriş tipi "Qeyd"-ə görə axtarışın filterin yoxlanılması
    When selects "Qeyd" from notification type filter list
    Then search results are displayed by according to search note type "Qeyd" params
    #Bildiriş tipi "Qeyd"-ə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes for "note type"
    Then the changes is successfully resets in the sent requests section
    #Bildiriş tipi "Quraşdırma/Sazlama"-ra görə axtarışın filterin yoxlanılması
    When selects "Quraşdırma/Sazlama" from notification type filter list
    Then search results are displayed by according to search note type "Quraşdırma/Sazlama" params
    #Bildiriş tipi "Quraşdırma/Sazlama"-ra görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes for "note type"
    Then the changes is successfully resets in the sent requests section
    #Bildiriş tipi "Sorğu"-ya görə axtarışın filterin yoxlanılması
    When selects "Sorğu" from notification type filter list
    Then search results are displayed by according to search note type "Sorğu" params
    #Bildiriş tipi "Sorğu"-ya görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes for "note type"
    Then the changes is successfully resets in the sent requests section
    #Bildiriş tipi "Müraciət"-ə görə axtarışın filterin yoxlanılması
    When selects "Müraciət" from notification type filter list
    Then search results are displayed by according to search note type "Müraciət" params
    #Bildiriş tipi "Müraciət"-ə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes for "note type"
    Then the changes is successfully resets in the sent requests section
    #Bildiriş tipi "Digər"-ə görə axtarışın filterin yoxlanılması
    When selects "Digər" from notification type filter list
    Then search results are displayed by according to search note type "Digər" params
    #Bildiriş tipi "Digər"-ə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes for "note type"
    Then the changes is successfully resets in the sent requests section
  #Test ssenarilər:
  #36.Bildiriş tipi "Xəta"-ya görə axtarışın filtrinin yoxlanılması
  #37.Bildiriş tipi "Xəta"-ya görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
  #38.Bildiriş tipi "Təklif"-ə görə axtarışın filtrinin yoxlanılması
  #39.Bildiriş tipi "Təklif"-ə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
  #40.Bildiriş tipi "Qeyd"-ə görə axtarışın filtrinin yoxlanılması
  #41.Bildiriş tipi "Qeyd"-ə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
  #42.Bildiriş tipi "Quraşdırma/Sazlama"-ya görə axtarışın filtrinin yoxlanılması
  #43.Bildiriş tipi "Quraşdırma/Sazlama"-ya görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
  #44.Bildiriş tipi "Sorğu"-ya görə axtarışın filtrinin yoxlanılması
  #45.Bildiriş tipi "Sorğu"-ya görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
  #46.Bildiriş tipi "Müraciət"-ə görə axtarışın filtrinin yoxlanılması
  #47.Bildiriş tipi "Müraciət"-ə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
  #48.Bildiriş tipi "Digər"-ə görə axtarışın filtrinin yoxlanılması
  #49.Bildiriş tipi "Digər"-ə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması

  @currentResultSearchFilter
  Scenario: Checking the current status filter in the sent requests section
    #Cari nəticə "Ilkin" seçiminə görə axtarışın filterin yoxlanılması
    When selects "Ilkin" from current result filter list
    Then search results are displayed by according to search current result "Ilkin" params
    #Cari nəticə "Ilkin" seçiminə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes for "current result"
    Then the changes is successfully resets in the sent requests section
    #Cari nəticə "İcraya qəbul edilib" seçiminə görə axtarışın filterin yoxlanılması
    When selects "Icraya qəbul edilib" from current result filter list
    Then search results are displayed by according to search current result "Icraya qəbul edilib" params
    #Cari nəticə "İcraya qəbul edilib" seçiminə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes for "current result"
    Then the changes is successfully resets in the sent requests section
    #Cari nəticə "Müddəti bitib" seçiminə görə axtarışın filterin yoxlanılması
    When selects "Müddəti bitib" from current result filter list
    Then search results are displayed by according to search current result "Müddəti bitib" params
    #Cari nəticə "Müddəti bitib" seçiminə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes for "current result"
    Then the changes is successfully resets in the sent requests section
    #Cari nəticə "İcra edilib" seçiminə görə axtarışın filterin yoxlanılması
    When selects "Icra edilib" from current result filter list
    Then search results are displayed by according to search current result "Icra edilib" params
    #Cari nəticə "İcra edilib" seçiminə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes for "current result"
    Then the changes is successfully resets in the sent requests section
    #Cari nəticə "İcradan imtina edilib" seçiminə görə axtarışın filterin yoxlanılması
    When selects "Icradan imtina edilib" from current result filter list
    Then search results are displayed by according to search current result "Icradan imtina edilib" params
    #Cari nəticə "İcradan imtina edilib" seçiminə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes for "current result"
    Then the changes is successfully resets in the sent requests section
    #Test ssenarilər:
    #50.Cari nəticə "Ilkin" seçiminə görə axtarışın filterin yoxlanılması
    #51.Cari nəticə "Ilkin" seçiminə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    #52.Cari nəticə "İcraya qəbul edilib" seçiminə görə axtarışın filterin yoxlanılması
    #53.Cari nəticə "İcraya qəbul edilib" seçiminə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    #54.Cari nəticə "Müddəti bitib" seçiminə görə axtarışın filterin yoxlanılması
    #55.Cari nəticə "Müddəti bitib" seçiminə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    #56.Cari nəticə "İcra edilib" seçiminə görə axtarışın filterin yoxlanılması
    #57.Cari nəticə "İcra edilib" seçiminə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    #58.Cari nəticə "İcradan imtina edilib" seçiminə görə axtarışın filterin yoxlanılması
    #59.Cari nəticə "İcradan imtina edilib" seçiminə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması

  @priorityFilter
  Scenario: Checking the priority status filter in the sent requests section
    #Prioritet "Təcili" seçiminə görə axtarışın filterin yoxlanılması
    When selects "Təcili" from priority filter list
    Then search results are displayed by according to search priority "Təcili" params
    #Prioritet "Təcili" seçiminə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes for "priority"
    Then the changes is successfully resets in the sent requests section
    #Prioritet "Yüksək" seçiminə görə axtarışın filterin yoxlanılması
    When selects "Yüksək" from priority filter list
    Then search results are displayed by according to search priority "Yüksək" params
    #Prioritet "Yüksək" seçiminə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes for "priority"
    Then the changes is successfully resets in the sent requests section
    #Prioritet "Normal" seçiminə görə axtarışın filterin yoxlanılması
    When selects "Normal" from priority filter list
    Then search results are displayed by according to search priority "Normal" params
    #Prioritet "Normal" seçiminə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes for "priority"
    Then the changes is successfully resets in the sent requests section
    #Prioritet "Aşağı" seçiminə görə axtarışın filterin yoxlanılması
    When selects "Aşağı" from priority filter list
    Then search results are displayed by according to search priority "Aşağı" params
    #Prioritet "Aşağı" seçiminə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    When user reset the changes for "priority"
    Then the changes is successfully resets in the sent requests section
    #Test ssenarilər:
    #60.Prioritet "Təcili" seçiminə görə axtarışın filterin yoxlanılması
    #61.Prioritet "Təcili" seçiminə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    #62.Prioritet "Yüksək" seçiminə görə axtarışın filterin yoxlanılması
    #63.Prioritet "Yüksək" seçiminə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    #64.Prioritet "Normal" seçiminə görə axtarışın filterin yoxlanılması
    #65.Prioritet "Normal" seçiminə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması
    #66.Prioritet "Aşağı" seçiminə görə axtarışın filterin yoxlanılması
    #67.Prioritet "Aşağı" seçiminə görə axtarışdan sonra nəticələrin sıfırlanmasının yoxlanılması