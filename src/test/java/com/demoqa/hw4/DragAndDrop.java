package com.demoqa.hw4;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {

    @BeforeAll
    static void setUp() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    void test() {
        open("/drag_and_drop");
        $$(".column header").shouldHave(CollectionCondition.texts("A", "B"));
        $("#column-a").dragAndDropTo($("#column-b"));
        $$(".column header").shouldHave(CollectionCondition.texts("B", "A"));
    }
}
