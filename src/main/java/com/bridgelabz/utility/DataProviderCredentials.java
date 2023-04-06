package com.bridgelabz.utility;

public class DataProviderCredentials {

    @org.testng.annotations.DataProvider(name = "testLoginData")
    public Object[][] getDataFromSheetFile()  {
        DataDrivenFramework ddf = new DataDrivenFramework("C:\\Users\\chetan bhagat\\IdeaProjects\\Selenium_Automation_On_BookSwagon_Application\\src\\main\\resources\\LoginDetailsOfBooksWagon.xlsx");
        int rows = ddf.getRowCount(0);
        Object[][] credentialsOfLogin = new Object[rows][2];
        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < 2; j++) {
                credentialsOfLogin[i][0] = ddf.getData(0,i,0);
                credentialsOfLogin[i][1] = ddf.getData(0,i,1);
            }
        }
        return credentialsOfLogin;
    }
}

