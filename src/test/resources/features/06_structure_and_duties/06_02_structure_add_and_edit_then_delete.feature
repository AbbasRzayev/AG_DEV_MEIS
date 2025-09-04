@all @structure_and_duties @new
Feature: Users structure and duties

@structure_add_and_edit_then_delete
Scenario: Check if user can add and edit then delete a new structure
Given user with login "imranovfarid@gmail.com" and password "Farid1020" logs into the "AG-MEIS" system
And goes to the control panel
And switches to the structure and duties tab
And selects plus button for adding new structure
    #Yeni struktur əlavə edilir
And adds information to the structure fields
| STRUCTURE NAME             | SHORT NAME | COMPANY CODE | PRIORITY | SUN  | TIN  | ADDRESS  | DETAILED INFORMATION ABOUT THE STRUCTURE                               |
| Avtomatlaşdırılmış Testlər | AT         | 7788         | 3        | AZ12 | AZ45 | Baku st. | Bu struktur automatlaşdırılmış testin tətbiqi üçün nəzərdə tutulmuşdur |
When user select the save button in the structure modal window
    #idarəetmə və strukturun baxış hissəsində bütün məlumatlar yoxlanılır
Then new structural is successfully added in the admin panel of the structure and position tab
Then all information about the new structural is displayed in the structure preview section in the admin panel of the structure and position tab
| STRUCTURE NAME             | SHORT NAME | COMPANY CODE | PRIORITY | SUN  | TIN  | ADDRESS  | DETAILED INFORMATION ABOUT THE STRUCTURE                               |
| Avtomatlaşdırılmış Testlər | AT         | 7788         | 3        | AZ12 | AZ45 | Baku st. | Bu struktur automatlaşdırılmış testin tətbiqi üçün nəzərdə tutulmuşdur |
    #Yeni struktur bütün məlumatları redaktə edilir
And user edit all information for the new structure
| STRUCTURE NAME          | SHORT NAME | COMPANY CODE | PRIORITY | SUN  | TIN  | ADDRESS     | DETAILED INFORMATION ABOUT THE STRUCTURE            |
| Keyfiyyət mütəxəsisləri | KM         | 1122         | 4        | AZ77 | AZ88 | Səbayıl st. | Bu struktur keyfiyyət üzrə mütəxəsisləri yetişdirir |
When user select the save button in the structure modal window
    #Redaktə edildikdən sonra idarəetmə və strukturun baxış hissəsində bütün məlumatların yenilənməsi yoxlanılır
Then new structural is successfully edited in the admin panel of the structure and position tab
Then all information about the new structural is displayed after edition in the structure preview section in the admin panel of the structure and position tab
| STRUCTURE NAME          | SHORT NAME | COMPANY CODE | PRIORITY | SUN  | TIN  | ADDRESS     | DETAILED INFORMATION ABOUT THE STRUCTURE            |
| Keyfiyyət mütəxəsisləri | KM         | 1122         | 4        | AZ77 | AZ88 | Səbayıl st. | Bu struktur keyfiyyət üzrə mütəxəsisləri yetişdirir |
    #Struktura yeni şöbənin əlavə edilir
And user adds new department to the structure
| STRUCTURE NAME | SHORT NAME | COMPANY CODE | PRIORITY | SUN  | TIN  | ADDRESS     | DETAILED INFORMATION ABOUT THE STRUCTURE            |
| Nəzarət şöbəsi | NŞ         | 5577         | 5        | AZ88 | AZ97 | Yasamal st. | Bu struktur keyfiyyət üzrə mütəxəsisləri yetişdirir |
When user select the save button in the structure modal window
    #idarəetmə və şöbənin baxış hissəsində bütün məlumatlar yoxlanılır
Then new department is successfully added in the admin panel of the structure and position tab
Then all information about the new department is displayed in the structure preview section in the admin panel of the structure and position tab
| STRUCTURE NAME | SHORT NAME | COMPANY CODE | PRIORITY | SUN  | TIN  | ADDRESS     | DETAILED INFORMATION ABOUT THE STRUCTURE            |
| Nəzarət şöbəsi | NŞ         | 5577         | 5        | AZ88 | AZ97 | Yasamal st. | Bu struktur keyfiyyət üzrə mütəxəsisləri yetişdirir |
    #Şöbəyə yeni sektor əlavə edilir
And user adds new sector to the department
| STRUCTURE NAME         | SHORT NAME | COMPANY CODE | PRIORITY | SUN  | TIN   | ADDRESS     | DETAILED INFORMATION ABOUT THE STRUCTURE            |
| Avtomalaşdırma sektoru | AS         | 5852         | 6        | AZ99 | AZ928 | Səbayıl st. | Bu struktur keyfiyyət üzrə mütəxəsisləri yetişdirir |
    #idarəetmə və sektorun baxış hissəsində bütün məlumatlar yoxlanılır
When user select the save button in the structure modal window
Then new sector is successfully added in the admin panel of the structure and position tab
Then all information about the new sector is displayed in the structure preview section in the admin panel of the structure and position tab
| STRUCTURE NAME         | SHORT NAME | COMPANY CODE | PRIORITY | SUN  | TIN   | ADDRESS     | DETAILED INFORMATION ABOUT THE STRUCTURE            |
| Avtomalaşdırma sektoru | AS         | 5852         | 6        | AZ99 | AZ928 | Səbayıl st. | Bu struktur keyfiyyət üzrə mütəxəsisləri yetişdirir |
And goes to the control panel
And adds name "Abbas" and fin to the name and fin fields
And user selects enter in the users tab
When switches to the user change structure and duties tab
    #Yeni struktur,şöbə və sektorun idarəetmə panelində istifadəçiyə təyin edilən hissədə əks olunması
Then the new structure is successfully displayed in the my structure and position tab
Then the new department is successfully displayed in the my structure and position tab
Then the new sector is successfully displayed in the my structure and position tab
And goes to the control panel
And switches to the structure and duties tab
    #Idarəetmə hissəsindən sektorun, şöbənin silinməsi və silindikdən sonra mövcud olmadıqlarının yoxlanılması
When user deletes the newly added sector using the delete button
Then the sector has been deleted successfully
When user deletes the newly added department using the delete button
Then the department has been deleted successfully
When user deletes the newly added structure using the delete button
Then the structure has been deleted successfully
    #Test ssenarilər:
    #7.Yeni strukturun əlavə edilməsi
    #8.İdarəetmə panelində yeni strukturun mövcud olmasının yoxlanılması
    #9.Struktur baxış hissəsində "Strukturun adı" məlumatlarının düzgünlüyünün yoxlanılması
    #10.Struktur baxış hissəsində "Strukturun qısa adı" məlumatlarının düzgünlüyünün yoxlanılması
    #11.Struktur baxış hissəsində "Müəssisənin kodu" məlumatlarının düzgünlüyünün yoxlanılması
    #12.Struktur baxış hissəsində "Prioritet" məlumatlarının düzgünlüyünün yoxlanılması
    #13.Struktur baxış hissəsində "Strukturun ünvanı" məlumatlarının düzgünlüyünün yoxlanılması
    #14.Struktur baxış hissəsində "Strukturun VÖEN-i" məlumatlarının düzgünlüyünün yoxlanılması
    #15.Struktur baxış hissəsində "Strukturun ünvanı" məlumatlarının düzgünlüyünün yoxlanılması
    #16.Struktur baxış hissəsində "Struktur haqqında ətraflı məlumat" məlumatlarının düzgünlüyünün yoxlanılması
    #17.Yeni strukturun redaktə edilməsi
    #18.Redaktə edildikdən sonra strukturun yenilənmış bütün məlumatlarının admin panel və strukturun baxış hissəsində yoxlanılması
    #19.Struktura yeni şöbənin əlavə edilməsi
    #20.İdarəetmə panelində struktura əlavə edilən şöbənin movcud olmasının yoxlanılması
    #21.Şöbənin baxış hissəsində bütün məlumatların düzgünlüyünün yoxlanılması
    #22.Şöbəyə yeni sektorun əlavə edilməsi
    #23.İdarəetmə panelində şöbəyə əlavə edilən sektorun movcud olmasının yoxlanılması
    #24.Şöbənin baxış hissəsində bütün məlumatların düzgünlüyünün yoxlanılması
    #25.İstifadəçiyə yeni struktur təyin edilmə hissəsində yeni strukturun əks olunmasının yoxlanılması
    #26.İstifadəçiyə yeni struktur təyin edilmə hissəsində yeni şöbənin əks olunmasının yoxlanılması
    #27.İstifadəçiyə yeni struktur təyin edilmə hissəsində yeni sektorun əks olunmasının yoxlanılması
    #28.Yeni sektorun silinməsi
    #29.Silindikdən sonra idarəetmə panelinde silinən sektorun mövcud olmamasının yoxlanılması
    #30.Yeni şöbənin silinməsi
    #31.Silindikdən sonra idarəetmə panelinde silinən şöbənin mövcud olmamasının yoxlanılması
    #32.Yeni sektorun silinməsi
    #33.Silindikdən sonra idarəetmə panelinde silinən strukturun mövcud olmamasının yoxlanılması