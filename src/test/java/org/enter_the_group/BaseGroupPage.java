package org.enter_the_group;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BaseGroupPage {
    public BaseGroupPage openGroupPage(){
        com.codeborne.selenide.Selenide.open("https://ok.ru/group/57465582845992");
        return this;
    }
    public void dropDownGroup(){
        $(By.xpath("//span[@class=\"dropdown_ac button-pro __sec __with-arrow __arrow-svg __wide\"]")).hover();
        $(By.xpath("//span[@class=\"dropdown_ac button-pro __sec __with-arrow __arrow-svg __wide\"]")).click();
        $(By.xpath("//div[@class=\"dropdown_cnt __wide __show\"]")).hover();
        $(By.xpath("//div[@class=\"dropdown_cnt __wide __show\"]")).click();
        $(By.xpath("//input[@data-l=\"t,confirm\"]")).click();
    }
}
