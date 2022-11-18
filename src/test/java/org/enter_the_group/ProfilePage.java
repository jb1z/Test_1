package org.enter_the_group;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {
    private final static SelenideElement GROUP_BUTTON
            = $(By.xpath("//a[@data-l=\"t,userAltGroup\"]/div[@class=\"tico null\"]"));
    public GroupPage clickOnGroupButton(){
        GROUP_BUTTON.click();
        return new GroupPage();
    }
}
