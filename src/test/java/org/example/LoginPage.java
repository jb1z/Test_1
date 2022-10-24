package org.example;

import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
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
        $(By.xpath("//*[@id=\"anonymPageContent\"]/div/div[1]/div[2]/div/div[2]/div[2]/div[1]/form/div[4]/input")).click();
    }
    // takers
    private String takeUserName(){
        return $(By.xpath("//*[@id=\"hook_Block_Navigation\"]/div/div/div[1]/a/div")).text();
    }
    public void loginMethod(String email, String pwd, String expectedUsername, boolean expectedResult){
        open("https://ok.ru");
        this.setEmail(email);
        this.setPwd(pwd);
        this.click();
        clearBrowserCookies();
        /* Используем try-catch так как в тесте, где мы вводим неверный пароль мы не сможем проверить
        ExpectedUsername потому что мы не сможем зайти на страницу пользователя => выкидываем False.
        Иначе тест не пройдёт даже с логически верным ожиданием (ввели неверный пароль => не смогли залогиниться). */
        try {
            assertEquals(expectedUsername, this.takeUserName());
        }
        catch (ElementNotFound e)
        {
            assertFalse(expectedResult);
        }
    }
}
