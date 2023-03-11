package Kinopoisk;

import Base.BaseSelenideTest;
import Base.SearchPage;
import Base.SearchResultPage;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

public class KinoSelenideTest extends BaseSelenideTest {
    private final static String URL = "https://www.kinopoisk.ru/s/";
    @Test
    public void checkFilms() {
        Selenide.open(URL);
        SearchPage searchPage = new SearchPage();
        searchPage.setFindValue("Сумерки");
        SearchResultPage searchResultPage = searchPage.clickSearch();
        searchResultPage.getAllTitle();
        searchResultPage.checkMovieDate("2008");
    }

    @Test
    void checkUniqueMovie() {
        Selenide.open(URL);
        SearchPage searchPage = new SearchPage();
        searchPage.setFindValue("Весна");
        SearchResultPage searchResultPage = searchPage.clickSearch();
        searchResultPage.getAllTitle();
        searchResultPage.checkMovieDate("2014");
    }
}
