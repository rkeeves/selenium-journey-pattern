package io.github.rkeeves.sauce.task.inventory;

import io.github.rkeeves.sauce.data.Product;
import io.github.rkeeves.sauce.data.ProductSortKind;
import io.github.rkeeves.sauce.step.*;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Locale;
import java.util.function.Function;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

@UtilityClass
public class InventoryTasks {

    public static Task<Void> visit() {
        return actor -> actor
                .exec(Visit.theUrl(InventoryPage.PAGE_URL))
                .yieldVoid();
    }

    public static Task<Void> shouldBeAt() {
        return actor -> actor
                .exec(UrlShouldBe.theFollowing(InventoryPage.PAGE_URL))
                .yieldVoid();
    }

    public static Task<Void> changeSortingTo(ProductSortKind productSortKind) {
        return actor -> actor
                .exec(SelectByValue.on(InventoryPage.PRODUCT_SORT_KIND_SELECT,
                        InventoryPage.productSortKindToOptionValue(productSortKind)))
                .yieldVoid();
    }

    public static Task<Void> shouldHaveItemsInThisExactOrder(List<Product> sorted) {
        return actor -> {
            for (int i = 0; i < sorted.size(); i++) {
                actor.exec(shouldSeeProduct(i, sorted.get(i)));
            }
            return null;
        };
    }

    public static Step<Void> shouldSeeProduct(int index, Product product) {
        return webDriverWait -> {
            webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(
                    InventoryPage.itemName(index), product.getName()
            ));
            final var webDriver = webDriverWait.until(Function.identity());

            final var desc = webDriver.findElement(InventoryPage.itemDesc(index)).getText();
            final var price = webDriver.findElement(InventoryPage.itemPrice(index)).getText();
            final var src = webDriver.findElement(InventoryPage.img(index)).getAttribute("src");

            assertThat(desc, is(product.getDesc()));
            assertThat(price, is(String.format(Locale.US, "$%.2f", product.getPrice())));
            assertThat(src, containsString(product.getImgUrl()));
            return null;
        };
    }
}
