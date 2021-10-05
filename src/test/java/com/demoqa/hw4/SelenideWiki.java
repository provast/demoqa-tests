package com.demoqa.hw4;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideWiki {

    String currentPage = "SoftAssertions";

    @BeforeAll
    static void setUp() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void test() {
        open("/selenide/selenide/wiki");

        SelenideElement wikiBox = $("#wiki-pages-box");
        wikiBox.$("[class$='wiki-more-pages-link'] button").click();
        wikiBox.$(byText(currentPage)).shouldBe(visible).click();
        $("#wiki-wrapper h1").shouldHave(text(currentPage));
        $("#wiki-body").shouldHave(text("Using JUnit5"));
    }

    @Test
    void checkPageTitle() {
        open("/selenide/selenide/wiki");

        Assertions.assertTrue(WebDriverRunner.getWebDriver().getTitle().contains("selenide/selenide Wiki"));
    }
}
