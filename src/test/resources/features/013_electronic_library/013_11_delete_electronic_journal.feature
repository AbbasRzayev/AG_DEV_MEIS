

Given user with login "abbas.rzayev@aist.group" and password "Rabbas8888!!" logs into the "AG-MEIS" system
#Elektron jurnalın əlavə edilməsi
And goes to the control panel
And goes to the electronic library tab in the control panel
And switches to the "Electronic journal" tab in electronic library
And selects new "journal" button in the training materials tab
And adds "Journal Manual" to journal name input
And adds "7777" to journal number input
And adds journal date
And selects person "İbrahim" for notification and mail for electronic library
And selects person "İbrahim" for the who sees field
And adds file "new" for training
And user selects save button
#Elektron jurnalın silinməsi
When selects delete button in the control panel
Then the deleted electronic journal is not displayed in the control panel