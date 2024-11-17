package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PharmacyParameterizedPage {
    private final SelenideElement searchInput = $("#js-site-search-input"),
            medicineLine = $(".breadcrumbs"),
            favoritePharmacyButton = $("a[data-autotest='favorite_pharmacy']"),
            mapListRadioButton = $(".js-storefinder-sort"),
            searchInputStore = $(".js-address-search-input"),
            listOfStores = $(".popup_stores__list");

    public void openPage() {
    open("");
    }
    public void searchMedicineInput(String medicineName) {
        searchInput.setValue(medicineName).pressEnter();
    }
    public void checkMedicineResult(String expectedMedicine) {
        medicineLine.shouldHave(text(expectedMedicine));
    }
    public void clickFavoritePharmacyButton() {
        favoritePharmacyButton.click();
}
    public void clickMapListRadioButton() {
        mapListRadioButton.shouldBe(visible).click();
    }
    public void searchStoreInput(String storeName) {
        searchInputStore.setValue(storeName).pressEnter();
    }
    public void checkListOfStores(String expectedStore) {
        listOfStores.shouldHave(text(expectedStore));
}
    }
