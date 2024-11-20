package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.PharmacyPage;

public class PharmacyParameterizedTests extends TestBase {

    final PharmacyPage pharmacyPage = new PharmacyPage();

    @ValueSource(strings = {
            "Траумель", "Анальгин"})
    @ParameterizedTest
    void checkPharmacyMedicine(String searchQuery) {

        pharmacyPage.openPage();
        pharmacyPage.searchMedicineInput(searchQuery);
        pharmacyPage.checkMedicineResult(searchQuery);
    }

    @CsvSource(value = {
            "г Москва, метро Академическая / г. Москва, пр-т. Ленинский, д. 54",
            "г Москва, метро Алексеевская / г. Москва, пр-т. Мира, д. 112",
    }, delimiter = '/')
    @ParameterizedTest
    void checkPharmacyStores(String storeName, String expectedStore) {

        pharmacyPage.openPage();
        pharmacyPage.clickFavoritePharmacyButton();
        pharmacyPage.clickMapListRadioButton();
        pharmacyPage.searchStoreInput(storeName);
        pharmacyPage.checkListOfStores(expectedStore);
    }

    @CsvFileSource(resources = "/checkPharmacyMoreThanTwoStores.csv", delimiter = '/')
    @ParameterizedTest
    void checkPharmacyMoreThanTwoStores(String storeName, String expectedStore) {

        pharmacyPage.openPage();
        pharmacyPage.clickFavoritePharmacyButton();
        pharmacyPage.clickMapListRadioButton();
        pharmacyPage.searchStoreInput(storeName);
        pharmacyPage.checkListOfStores(expectedStore);
    }
}
