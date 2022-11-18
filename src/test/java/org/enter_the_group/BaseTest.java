package org.enter_the_group;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;

public class BaseTest {
    public void open(String s){
        com.codeborne.selenide.Selenide.open(s);
    }
    public void close(){
        clearBrowserCookies();
    }
}
