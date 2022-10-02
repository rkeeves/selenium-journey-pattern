package io.github.rkeeves.sauce.task.inventory;

import io.github.rkeeves.sauce.data.ProductSortKind;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;

@UtilityClass
class InventoryPage {

    static final String PAGE_URL = "https://www.saucedemo.com/inventory.html";

    static final By PRODUCT_SORT_KIND_SELECT = By.cssSelector("*[data-test='product_sort_container']");

    static final By INVENTORY_ITEM = By.cssSelector(".inventory_item");

    private static By inventoryItemAt(int index) {
        return By.cssSelector(".inventory_item:nth-child(" + (index + 1) + ")");
    }

    static By itemName(int index) {
        return new ByChained(inventoryItemAt(index), By.cssSelector(".inventory_item_name"));
    }

    static By itemDesc(int index) {
        return new ByChained(inventoryItemAt(index), By.cssSelector(".inventory_item_desc"));
    }

    static By itemPrice(int index) {
        return new ByChained(inventoryItemAt(index), By.cssSelector(".inventory_item_price"));
    }

    static By img(int index) {
        return new ByChained(inventoryItemAt(index), By.cssSelector("img.inventory_item_img"));
    }

    static String productSortKindToOptionValue(ProductSortKind productSortKind) {
        return switch (productSortKind) {
            case A_TO_Z -> "az";
            case Z_TO_A -> "za";
            case LO_TO_HI -> "lohi";
            case HI_TO_LO -> "hilo";
        };
    }
}
