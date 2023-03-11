package Base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SearchResultPage {
    private final ElementsCollection searchList = $$x("//div[@class='search_results search_results_last']//p[@class='name']/a");
    public final SelenideElement mostWantedElement = $x("//div[@class='element most_wanted']//span[@class='year']");
    public void getAllTitle() {
        for (SelenideElement e: searchList) {
            System.out.println(e.getText());
        }
    }
    public void checkMovieDate(String year) {
        mostWantedElement.shouldHave(Condition.text(year));
    }
}
