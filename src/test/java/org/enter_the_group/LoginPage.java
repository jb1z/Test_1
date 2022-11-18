package org.enter_the_group;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

class LoginPage {
    private void click() {
        $(By.xpath("//div[@class=\"login-form-actions\"]/input")).click();
    }
    public void enterAccount(String email, String pwd){
        $(By.xpath("//*[@id='field_email']")).setValue(email);
        $(By.xpath("//*[@id=\"field_password\"]")).setValue(pwd);
        this.click();
    }
}