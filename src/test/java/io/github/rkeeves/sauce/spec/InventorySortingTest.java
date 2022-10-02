package io.github.rkeeves.sauce.spec;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.rkeeves.sauce.Actor;
import io.github.rkeeves.sauce.data.ProductSortKind;
import io.github.rkeeves.sauce.data.Products;
import io.github.rkeeves.sauce.data.Users;
import io.github.rkeeves.sauce.task.inventory.InventoryTasks;
import io.github.rkeeves.sauce.task.setup.SetupTask;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventorySortingTest {

    static WebDriver webDriver;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @AfterAll
    static void afterAll() {
        webDriver.quit();
    }

    @ParameterizedTest
    @EnumSource(ProductSortKind.class)
    void changingSortingResultInCorrectProductOrder(ProductSortKind productSortKind) {
        final var standardSuzy = Users.standard();
        final var webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5L), Duration.ofMillis(400L));
        Actor.of(webDriverWait)
                .exec(SetupTask.logMeIn(standardSuzy))
                .exec(InventoryTasks.visit())
                .exec(InventoryTasks.changeSortingTo(productSortKind))
                .exec(InventoryTasks.shouldHaveItemsInThisExactOrder(Products.sorted(productSortKind)));
    }
}
