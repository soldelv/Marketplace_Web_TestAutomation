package stepsdefinitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.HomePage;

import static utils.CommonMethods.holdOn;
import static utils.CommonMethods.print;

public class HomeSteps {
    private final AppiumDriver driver = HooksSteps.getDriver();
    private final HomePage homePage = new HomePage(driver);

    @Given("the user is on marketplace screen")
    public void theUserIsOnMarketplaceScreen() {
        Assertions.assertTrue(homePage.checkOnMarketplace());
    }

    @When("chooses a product from marketplace and taps as favorite")
    public void choosesAProductFromMarketplace() {
        homePage.chooseAndTapFavoriteFromMarketplace();
    }

    @Given("the user is on favorite screen")
    @And("goes to favorite section")
    public void goesToFavoriteSection() {
        homePage.tapOnFavorites();
    }
    @When("taps on a product from marketplace")
    public void tapsOnAProductFromMarketplace() {
        homePage.tapsOnProduct();
    }

    @Given("the user is on bonus screen")
    public void theUserIsOnBonusScreen() {
        homePage.tapOnBonus();
    }

    @When("^taps on (.*) from marketplace$")
    public void tapsOnProduct_FromMarketplace(String product1) {
        homePage.tapOnProduct(product1);
    }
    @Given("the user is on orders screen")
    @And("goes to orders screen")
    public void goesToOrdersScreen() {
        holdOn(1000);
        homePage.tapOnOrders();
        holdOn(1000);
    }

    @When("scrolls down on the home")
    public void scrollsDownOnTheHome() {
        homePage.scrollDown();
        homePage.scrollDown();
    }

    @Then("the user can see the products listed")
    public void theUserCanSeeTheProductsListed() {
        Assertions.assertTrue(homePage.checkProductsAreListed("product-"));
    }

    @When("^the user searches for (.*) on the searchbar$")
    public void theUserSearchesForKeywordOnTheSearchbar(String keyword) {
        homePage.tapOnSearchbar();
        homePage.searchByKeywordOnSearchbar(keyword);
    }

    @Then("^products with word (.*) are displayed$")
    public void productsWithWordKeywordAreDisplayed(String keyword) {
        Assertions.assertTrue(homePage.checkProductsAreListed(keyword));
    }

    @When("^taps on (.*) from Home$")
    public void tapsOnCategoryFromHome(String categoryName) {
        homePage.tapOnCategory(categoryName);
    }

    @Then("^products related to (.*) are displayed$")
    public void productsRelatedToCategoryAreDisplayed(String categoryName) {
        Assertions.assertTrue(homePage.checkProductsAreListed("product-"));
        print("After filter by "+categoryName+" products are displayed");
    }
}