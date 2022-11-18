package org.enter_the_group;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.codeborne.selenide.Selenide.$;

public class GroupPage {
    private final static SelenideElement INPUT_FIELD
            = $(By.xpath("//div[@class=\"wrap-input__414z3\"]//input"));
    private final static SelenideElement ADD_GROUP_BUTTON
            = $(By.xpath("//a[@class=\"button-pro group-join_btn __small\"]"));
    private final static SelenideElement LABEL_IN_GROUP
            = $(By.xpath("//span[@class=\"label__gp7y9\"]"));
    public GroupPage setInputField(String stringToInput){
        INPUT_FIELD.sendKeys(stringToInput);
        INPUT_FIELD.click();
        INPUT_FIELD.sendKeys(Keys.ENTER);
        return this;
    }
    public GroupPage addGroup(){
        ADD_GROUP_BUTTON.click();
        sleep(2000);
        return this;
    }
    public void checkAdding(){
        assertEquals("Вы в группе", LABEL_IN_GROUP.text());
    }
}
