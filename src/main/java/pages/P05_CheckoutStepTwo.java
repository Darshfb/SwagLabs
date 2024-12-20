package pages;
import actions.CustomDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_CheckoutStepTwo
{
    WebDriver driver;
    public P05_CheckoutStepTwo(WebDriver driver)
    {
        this.driver = driver;
    }
    private final By subTotal = By.xpath("(//div)[@class='summary_subtotal_label']");
    private final By cancelButton = By.xpath("(//a)[text()='CANCEL']");
    private final By finishButton = By.xpath("(//a)[text()='FINISH']");

    public void clickCancelButton() {
        new CustomDecorator(driver, cancelButton, 2).click();
    }

    public void clickFinishOrder() {
        driver.findElement(finishButton).click();
    }

    public Boolean checkTotalEqualToSum(double expectedPrice) {
        String subtotal = driver.findElement(subTotal).getText();
        double specificItemPrice = Double.parseDouble(subtotal.substring(13));
        System.out.println("hellowworld2 " + specificItemPrice);
        return (specificItemPrice == expectedPrice);
    }
}
