package org.login_tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainTest {
    final private LoginPage loginPage;
    final private static BaseTest base;
    static {
        base = new BaseTest();
    }
    public MainTest(){
        this.loginPage = new LoginPage();
    }
    @BeforeAll
    static void openPage(){
        base.open("https://ok.ru");
    }
    @DisplayName("User can't login successful")
    @Test
    void userCantLogin() {
        loginPage.checkNotLogged("technoPol10", "zoloto1234", false);
    }
    @DisplayName("Username is equal successful")
    @Test
    void userCanLogin() {
        loginPage.checkUsername("technoPol10", "technoPolis2022", "technoPol10 technoPol10");
    }
    @AfterAll
    static void clearCookies(){
        base.close();
    }
}
