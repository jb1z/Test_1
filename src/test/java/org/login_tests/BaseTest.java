package org.example;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    public void open(String s){
        com.codeborne.selenide.Selenide.open(s);
    }
    public void close(){
        clearBrowserCookies();
    }
}
