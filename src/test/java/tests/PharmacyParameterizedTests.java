package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.PharmacyParameterizedPage;

public class PharmacyParameterizedTests extends TestBase {

    PharmacyParameterizedPage pharmacyParameterizedPage = new PharmacyParameterizedPage();

    @ValueSource(strings = {
            "Траумель", "Анальгин"})
    @ParameterizedTest
    void checkPharmacyMedicine(String searchQuery) {

        pharmacyParameterizedPage.openPage();
        pharmacyParameterizedPage.searchMedicineInput(searchQuery);
        pharmacyParameterizedPage.checkMedicineResult(searchQuery);
    }

    @CsvSource(value = {
            "г Москва, метро Академическая / г. Москва, пр-т. Ленинский, д. 54",
            "г Москва, метро Алексеевская / г. Москва, пр-т. Мира, д. 112",
    }, delimiter = '/')
    @ParameterizedTest
    void checkPharmacyStores(String storeName, String expectedStore) {

        pharmacyParameterizedPage.openPage();
        pharmacyParameterizedPage.clickFavoritePharmacyButton();
        pharmacyParameterizedPage.clickMapListRadioButton();
        pharmacyParameterizedPage.searchStoreInput(storeName);
        pharmacyParameterizedPage.checkListOfStores(expectedStore);
    }
    @CsvFileSource(resources = "/checkPharmacyMoreThanTwoStores.csv", delimiter = '/')
    @ParameterizedTest
    void checkPharmacyMoreThanTwoStores(String storeName, String expectedStore) {

        pharmacyParameterizedPage.openPage();
        pharmacyParameterizedPage.clickFavoritePharmacyButton();
        pharmacyParameterizedPage.clickMapListRadioButton();
        pharmacyParameterizedPage.searchStoreInput(storeName);
        pharmacyParameterizedPage.checkListOfStores(expectedStore);
    }
}
