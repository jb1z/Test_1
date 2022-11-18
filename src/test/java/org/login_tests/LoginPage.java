package org.login_tests;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class LoginPage {
    // setters
    public LoginPage setEmail(String email){
        $(By.xpath("//*[@id='field_email']")).setValue(email);
        return this;
    }
    public LoginPage setPwd(String pwd){
        $(By.xpath("//*[@id=\"field_password\"]")).setValue(pwd);
        return this;
    }

    // action on page
    public LoginPage click(){
        $(By.xpath("//div[@class=\"login-form-actions\"]/input")).click();
        return this;
    }

    // takers
    private String takeUserName(){
        return $(By.xpath("//div[@class=\"tico ellip\"]")).text();
    }

    // checkers
    public void checkUsername(String expectedUsername){
        assertEquals(expectedUsername, this.takeUserName());
    }
    public void checkNotLogged(boolean expectedResult){
        assertFalse(expectedResult);
    }
}
