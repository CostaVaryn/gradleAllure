package Base;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SearchPage {
    private final SelenideElement findInput = $x("//*[@id='find_film']");
    private final SelenideElement searchBtn = $x("//form[@id='formSearchMain']//input[@value='поиск']");

    public void setFindValue(String val) {
        this.findInput.sendKeys(val);
    }

    public SearchResultPage clickSearch() {
        this.searchBtn.click();
        return new SearchResultPage();
    }
}
