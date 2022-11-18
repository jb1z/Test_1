package org.enter_the_group;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

public class MainTest {
    final private static BaseTest BASE_TEST;
    final private static BaseGroupPage BASE_GROUP_PAGE;
    static {
        BASE_TEST = new BaseTest();
        BASE_GROUP_PAGE = new BaseGroupPage();
    }

    @BeforeAll
    public static void loginToAccount(){
        LoginPage loginPage = new LoginPage();
        BASE_TEST.open("https://ok.ru");
        loginPage.enterAccount("technoPol10", "technoPolis2022");
    }

    @Nested
    class NestedTest {
        private static final SelenideElement PROFILE_PHOTO =
                $(By.xpath("//div[@class=\"tico ellip\"]"));

        @DisplayName("Test checks, if the page after logging is open")
        @Test
        public void test(){
            $(PROFILE_PHOTO).shouldBe(Condition.visible);
        }
    }

    @DisplayName("Test checks, if the group is added")
    @Test
    public void AddGroup(){
        ProfilePage profilePage = new ProfilePage();
        profilePage
                .clickOnGroupButton()
                .setInputField("Москва FM")
                .addGroup()
                .checkAdding();
    }

    @AfterAll
    public static void clearCookies(){
        BASE_GROUP_PAGE
                .openGroupPage()
                .dropDownGroup();
        BASE_TEST.close();
    }
}
