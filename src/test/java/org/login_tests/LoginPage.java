package org.login_tests;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.*;

class LoginPage {
    // setters
    private void setEmail(String email){
        $(By.xpath("//*[@id='field_email']")).setValue(email);
    }
    private void setPwd(String pwd){
        $(By.xpath("//*[@id=\"field_password\"]")).setValue(pwd);
    }
    // action on page
    private void click(){

        $(By.xpath("//div[@class=\"login-form-actions\"]/input")).click();
    }
    // takers
    private String takeUserName(){
        return $(By.xpath("//div[@class=\"tico ellip\"]")).text();
    }
    public void checkUsername(String email, String pwd, String expectedUsername){
        this.setEmail(email);
        this.setPwd(pwd);
        this.click();
        assertEquals(expectedUsername, this.takeUserName());
    }
    public void checkNotLogged(String email, String pwd, boolean expectedResult){
        this.setEmail(email);
        this.setPwd(pwd);
        this.click();
        assertFalse(expectedResult);
    }
}
