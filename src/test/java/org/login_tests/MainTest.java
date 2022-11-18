package org.login_tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainTest {
    final private static BaseTest base;
    static {
        base = new BaseTest();
    }
    @BeforeAll
    static void openPage(){
        base.open("https://ok.ru");
    }
    @DisplayName("Test checks, that user can't login with invalid password")
    @Test
    void userCantLogin() {
        // chain of invocation
        LoginPage loginPage = new LoginPage();
        loginPage
                .setEmail("technoPol10")
                .setPwd("zoloto1234")
                .click()
                .checkNotLogged(false);
    }
    @DisplayName("Test checks, that real username is equal to expected username")
    @Test
    void userCanLogin() {
        // chain of invocation
        LoginPage loginPage = new LoginPage();
        loginPage
                .setEmail("technoPol10")
                .setPwd("technoPolis2022")
                .click()
                .checkUsername("technoPol10 technoPol10");
    }
    @AfterAll
    static void clearCookies(){
        base.close();
    }
}
