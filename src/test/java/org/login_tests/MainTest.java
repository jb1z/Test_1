package org.example;

import org.junit.jupiter.api.Test;

public class MainTest {
    final private LoginPage loginPage;
    public MainTest(){
        this.loginPage = new LoginPage();
    }
    @Test
    void userCantLogin() {
        loginPage.loginMethod("technoPol10", "zoloto1234", "Олег ПозолотиРучку", false);
    }
    @Test
    void userCanLogin() {
        loginPage.loginMethod("technoPol10", "technoPolis2022", "technoPol10 technoPol10", true);
    }
}
