package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static Constants.Constants.PAYPAL_EMAIL;
import static Constants.Constants.PAYPAL_PASSWORD;
import static utils.CommonMethods.holdOn;
import static utils.CommonMethods.print;

public class BonusPage extends BasePage{
    public BonusPage(AppiumDriver driver) {
        super(driver);
    }

    /* BONUS - MAIN SCREEN */
    By bonusIcon = MobileBy.AccessibilityId("bonus");
    By viewBalanceBtn = MobileBy.AccessibilityId("view-balance-button");
    By scanQR = MobileBy.AccessibilityId("scan-qr");
    By qrCode = MobileBy.xpath("//android.view.ViewGroup[@content-desc='address-qr']");
    By sendBtn = MobileBy.AccessibilityId("send-button");
    By paymentBtn = MobileBy.AccessibilityId("payment-button");
    By refillBtn = MobileBy.AccessibilityId("refill-button");
    By upcomingTransaction = MobileBy.AccessibilityId("Upcoming");
    By completedTransaction = MobileBy.AccessibilityId("Completed");

    /* TOP-UPS OPTIONS */
    By topUp_MyAccount = MobileBy.AccessibilityId("type-0");
    By topUp_AnotherAccount = MobileBy.AccessibilityId("type-1");

    /* PAYMENT METHODS */
    By closeModaBtn = MobileBy.AccessibilityId("btn-close-modal");
    By wave = MobileBy.AccessibilityId("type-0");
    By orangeMoney = MobileBy.AccessibilityId("type-1");
    By freeMoney = MobileBy.AccessibilityId("type-2");
    By paypal = MobileBy.AccessibilityId("type-3");
    By paytech = MobileBy.AccessibilityId("type-4");
    By bank = MobileBy.AccessibilityId("type-5");
    By changeMethodBtn = MobileBy.AccessibilityId("change-method");
    By inputAmount = MobileBy.AccessibilityId("input-amount");
    By confirmBtn = MobileBy.AccessibilityId("btn-confirm");

    /* ACTIONS */
    By actionConfirmBtn = MobileBy.AccessibilityId("action-confirm");
    By actionCancelBtn = MobileBy.AccessibilityId("action-cancel");

    /* PAYPAL SCREEN */
    By paypalEmail = MobileBy.xpath("//android.widget.EditText[contains(@resource-id,'email')]");

    By paypalNextBtn = MobileBy.xpath("//android.widget.Button[contains(@resource-id,'btnNext')]");
    By paypalPassword = MobileBy.xpath("//android.widget.EditText[contains(@resource-id,'password')]");
    By paypalLoginBtn = MobileBy.xpath("//android.widget.Button[contains(@resource-id,'btnLogin')]");
    By paypalSubmitBtn = MobileBy.xpath("//android.widget.Button[contains(@resource-id,'payment-submit-btn')]");

    /* SUCCESSFUL TOP-UP MESSAGE */
    By topUpSuccessful = MobileBy.xpath("//android.widget.TextView[contains(@text, 'Top-up completed')]");
    By actionCloseBtn = MobileBy.AccessibilityId("action-close");

    public void tapOnRefillBtn(){
        holdOn(3000);
        tap(refillBtn);
    }

    public void tapTopUpMtAccount(){
        holdOn(1000);
        tap(getElement(topUp_MyAccount));
    }

    public void tapTopUpAntoherAccount(){
        tap(getElement(topUp_AnotherAccount));
    }

    public void selectPaypal(){
        tap(getElement(paypal));
    }

    public void enterTopUpAmount(String amount){
        type(amount, inputAmount);
    }

    public void tapOnConfirmAmount(){
        tap(getElement(confirmBtn));
    }

    public void tapOnActionConfirm(){
        print("This is the second confirmation asked before top up money");
        tap(getElement(actionConfirmBtn));
    }

    public void loginPaypal(){
        holdOn(800);
        type(PAYPAL_EMAIL, paypalEmail);
        tap(paypalNextBtn);
        holdOn(800);
        type(PAYPAL_PASSWORD, paypalPassword);
        holdOn(800);
        tap(paypalLoginBtn);
        holdOn(500);
        scrollDown();
        tap(paypalSubmitBtn);
    }

    public boolean checkTopUpCompleted(){
        holdOn(800);
        boolean displayed = false;
        try {
            displayed = isDisplayed(getElement(topUpSuccessful));
        }catch(NoSuchElementException e){
            print("Message not found");
        }
        return displayed;
    }

    public void tapOnClose(){
        tap(getElement(actionCloseBtn));
    }







}