package utilities;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static utilities.Driver.getDriver;


public class ReusableMethods {
    /**
     * bu metot ile JS yolu string olarak verilen elementi JavascriptExecutor kullanarak tiklayabilirim
     *
     * @param javascriptYolu click yapilacak webelement yolu string olarak verilir
     */
    public static void clickJSElementWithJavaScript(String javascriptYolu) {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        WebElement webElement = (WebElement) jse.executeScript("return " + javascriptYolu + "");
        jse.executeScript("arguments[0].click();", webElement);

    }

    /**
     * Hard wait istenemeyen wait. Butun kodlari durdurur.
     * Gozle testi izleyebilmek icin koyduk. Otomasyon testi kosarken kaldirilmali.
     *
     * @param saniye int cinsinden saniye olarak verilmeli
     */
    public static void wait(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * bu metot verilen iki stringin birbirine esit oldugunu dogrular
     *
     * @param str1 verilecek olan 1. string parametresidir
     * @param str2 verilecek olan 2. string parametresidir
     */
    public static void assertString(String str1, String str2) {

        assertTrue(str1.equals(str2));
    }

    /**
     * alerti reddeder / cancel yapar
     */
    public static void dismissAlert() {
        getDriver().switchTo().alert().dismiss();
    }

    /**
     * alerti accept yapar
     */
    public static void acceptAlert() {
        getDriver().switchTo().alert().accept();
    }

    /**
     * alerte text gondermek icin kullaniriz
     *
     * @param str alertin icine gonderilecek olan string dir.
     */
    public static void sendKeysToAlert(String str) {

        getDriver().switchTo().alert().sendKeys(str);
    }

    /**
     * WebElement ScreenShot alir
     *
     * @param element screen shot alinacak elementin locate verilir
     */
    public static void webElementScreenShoot(WebElement element) {
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/webElementScreenShoot" + tarih + ".png";

        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * tum sayfanin screenshoot ini alir
     */
    public static void tumSayfaScreenShoot() {

        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/screenshoot" + tarih + ".png";
        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();

        try {
            FileUtils.copyFile(takesScreenshot.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * sayfada mause tekerinin bir donusu kadar asagi iner
     */
    public static void pageDown() {
        Actions actions = new Actions(getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    /**
     * sayfada mause tekerinin bir donusu kadar asagi iner
     */
    public static void pageUp() {
        Actions actions = new Actions(getDriver());
        actions.sendKeys(Keys.PAGE_UP).perform();
    }


    /**
     * bu metot ile locate verilen element gorunene kadar scroll yapilir
     *
     * @param element scroll yapilacak elementin locate idir.
     */
    public static void scrollToElementByActions(WebElement element) {
        Actions actions = new Actions(getDriver());
        actions.scrollToElement(element).perform();
    }

    public static void scrollModalWindow(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", element);
    }

    /**
     * javascript ile bir element üstünde sağ klik yapmaya yarar
     *
     * @param element yerine üstünde sağ klik yapilacak elementin locate verilir
     */
    public static void contextClickByJavascript(WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
        String script = "var element = arguments[0];" +
                "var evt= new MouseEvent('contextmenu', { bubbles: true, cancelable: true, view:window});" +
                "element.dispatchEvent(evt);" +
                "window.open(element.href, '_blanck');";

        javascriptExecutor.executeScript(script, element);
    }

    /**
     * Bu metot ile bir dosyayi bilgisayardan secerek yukleme yapilir. Metot dosya yukleme
     * isteyen bir pencere acildiginda kullanilabilir
     *
     * @param filePath bilgisayardan yuklenecek dosya yolu
     */
    public static void robotClassDosyaYukleme(String filePath) {
        try {
            ReusableMethods.wait(1);
            StringSelection stringSelection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            Robot robot = new Robot();
            //pressing ctrl+v
            robot.keyPress(KeyEvent.VK_CONTROL);
            ReusableMethods.wait(1);
            robot.keyPress(KeyEvent.VK_V);
            ReusableMethods.wait(1);
            //releasing ctrl+v
            robot.keyRelease(KeyEvent.VK_CONTROL);
            ReusableMethods.wait(1);
            robot.keyRelease(KeyEvent.VK_V);
            ReusableMethods.wait(1);
            System.out.println("PASSED");
            //pressing enter
            ReusableMethods.wait(1);
            robot.keyPress(KeyEvent.VK_ENTER);
            ReusableMethods.wait(1);
            //releasing enter
            robot.keyRelease(KeyEvent.VK_ENTER);
            ReusableMethods.wait(1);
            System.out.println("ENTER");
        } catch (Exception e) {
        }
    }

    /**
     * bu metot ile bir elementin value'suna deger atanir.
     *
     * @param element deger atanacak elementin locate verilmeli
     * @param text    elemente gönderilecek value verilmeli
     */
    public static void sendAttributeJS(String text, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
    }

    /**
     * bu metot ile javascript kullanarak bir elemente sendKey yapılır
     *
     * @param element sendKey yapılacak elementin locate verilmeli
     * @param text    elemente gönderilecek değer verilmeli
     */
    public static void sendKeysJS(String text, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].value='" + text + "'", element);

    }

    /**
     * bu metot ile bir webelemente javascript ile click yapılır
     *
     * @param element yerine elementin locate'i verilir
     */
    public static void clickByJavaScript(WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
        javascriptExecutor.executeScript("arguments[0].click();", element);
    }

    /**
     * bu metot ile locate'i verilen elemente kadar sayfa scroll yapılır.
     *
     * @param element yerine üzerine scroll yapılacak webelelement locate'i verilir
     */
    public static void f(WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * bu metot ile javascript kullanarak sayfanın en altına scroll yapılır
     */
    public static void scrollEndByJavascript() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    /**
     * bu metot ile javascript kullanarak sayfanın en üstüne scroll yapılır
     */
    public static void scrollTopByJavascript() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
        javascriptExecutor.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
    }

    /**
     * bu metot javascript kullanarak bir elementin value'sunu string olarak döndürür
     *
     * @param id            yerine elementin id değeri verilir
     * @param attributeName yerine elementin id'si yazılır
     * @return string return eder
     */
    public static String getValueByJavaScript(String id, String attributeName) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
        String string = javascriptExecutor.executeScript("return document.getElementById('" + id + "')." + attributeName).toString();
        return string;
    }

    /**
     * Bu metot ile locate verilen elementin value değeri string olarak döndürülür
     *
     * @param element yerine locate verilecek
     * @return
     */
    public static String getValueByJavaScript(WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
        return (String) javascriptExecutor.executeScript("return arguments[0].value", element);
    }

    /**
     * Bu metot Actions class kullanarak bir webelementin ustune gidip bekler
     *
     * @param element yerine webelement'in locate koyulmalidir
     */
    public static void moveToElementWithAction(WebElement element) {
        Actions action = new Actions(getDriver());
        action.moveToElement(element).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * bu metot ile görünürlüğü olmayan elementin javascript kullanarak kullanarak görünürlüğünü sağlarız
     *
     * @param element yerine görünürlüğü sağlanacak elementin locate'i verilir
     */
    public static void setElementVisible(WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
        javascriptExecutor.executeScript("arguments[0].style.opacity='1';", element);
    }

    /**
     * bu metot ile selenium kodlarıyla textini alamadığımz elementin textini javascript ile alabiliriz
     *
     * @param xpath yerin texti alınacak elementin xpath'i string olarak verilir. Örnek: "//div[@class='Toastify__toast-body']"
     * @return olarak elementin texti String olarak döner
     */
    public static String getTextByJavascript(String xpath) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
        String text = (String) javascriptExecutor.executeScript("return arguments[0].textContent;", xpath);
        return text;
    }

    /**
     * bu metot ile bir element kliklenebilir olana kadar (bu sureyi biz verecegiz) beklenir
     *
     * @param element klik yapilacak olan locate girilir
     * @param timeout beklenilecek sure verilir
     * @return
     */
    public static WebElement waitForClickability(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until((ExpectedConditions.elementToBeClickable(element)));

    }

    public static void waitForClickabilityAndClick(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        clickElementUsingJS(element);
    }

    private static void clickElementUsingJS(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * Bu metot element gorunur olana kadar kodlari bekletir. explicitly wait yapar.
     *
     * @param locator
     * @param sayi
     * @return
     */
    public static WebElement visibleLocateWait(By locator, int sayi) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(sayi));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }


    /**
     * Bu metot bir element gorunur olana kadar kodlari bekletir.
     *
     * @param element
     * @param sayi
     */
    public static void visibleWait(WebElement element, int sayi) {
        ReusableMethods.wait(30);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    /**
     * click yapilacak element clickible olana kadar bekler
     *
     * @param element elementin locati
     * @param timeout beklenecek sure
     * @return
     */
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * bu metot ile bir element icindeki texti clear() daki gibi temizleriz
     *
     * @param element icindeki text silinecek olan elementin locate'i verilir
     */
    public static void clearTextBox(WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
        javascriptExecutor.executeScript("arguments[0].value='';", element);
    }

    public static void clickEditButtonForItem(String itemName) {
        // Find the table row containing the specified item name
        WebElement itemRow = getDriver().findElement(By.xpath("//td[text()='" + itemName + "']/.."));
        // Find the "edit" button within the row
        WebElement editButton = itemRow.findElement(By.cssSelector("td.mat-column-edit button"));
        // Click the "edit" button
        editButton.click();
    }

    public static void EditButtonForString(String text) {
        // Find the row containing the specified text
        WebElement row = getDriver().findElement(By.xpath("//td[contains(text(), '" + text + "')]//ancestor::tr"));
        System.out.println(row);
        ReusableMethods.wait(1);
        // Find the edit button within the row
        WebElement editButton = row.findElement(By.xpath(".//td[contains(@class, 'mat-column-edit')]//button"));
        System.out.println("editButton = " + editButton);
        editButton.click();
    }

    public static void clickDeleteButtonForItem(String itemName) {
        // Find the table row containing the specified item name
        WebElement itemRow = getDriver().findElement(By.xpath("//td[text()='" + itemName + "']/.."));
        // Find the "edit" button within the row
        WebElement editButton = itemRow.findElement(By.cssSelector("td.mat-column-delete button"));
        // Click the "edit" button
        editButton.click();
    }

    public static void assertElementNotDisplayed(WebElement element) {
        try {
            assertFalse(element.isDisplayed());
            System.out.println("Element is not displayed as expected.");
        } catch (NoSuchElementException e) {
            System.out.println("Element is not found. Test passed.");
        }
    }

    public static void assertElementDeleted(WebDriver driver, String text) {
        try {
            // Wait for the element to become stale or disappear
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//td[text()='" + text + "']")));

            // If the element is not found, it has been successfully deleted
            assertFalse("Element still present, not deleted successfully", driver.findElement(By.xpath("//td[text()='" + text + "']")).isDisplayed());
            System.out.println("Element successfully deleted.");
        } catch (NoSuchElementException e) {
            System.out.println("Element successfully deleted.");
        }
    }

    public static void flash(WebElement element, WebDriver driver) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
        String elementColor = element.getCssValue("backgroundColor"); //elementin arka rengini alir
        for (int i = 0; i < 10; i++) {
            // changeColor("rgb(0,0,0)", element, driver);// elemente siyah ren verir
            changeColor("rgb(75,179,116)", element, driver);// elemente kirmizi ren verir
            //changeColor("rgb(0,255,0)", element, driver);// elemente yesil ren verir
            changeColor(elementColor, element, driver);

        }
    }

    public static void flashCorner(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        String originalStyle = element.getAttribute("style");

        // Apply a red border for highlighting
//        js.executeScript("arguments[0].setAttribute('style', arguments[0].getAttribute('style') + '; border: 2px solid red;');", element);
        js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", element);
        // Pause for a moment to visualize the effect
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * bu metot flash metodu icine atanir. bu metot ile elementin rengi parametre olarak atanacagi bildirilir
     *
     * @param color
     * @param element
     * @param driver
     */
    public static void changeColor(String color, WebElement element, WebDriver driver) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
        javascriptExecutor.executeScript("arguments[0].style.backgroundColor='" + color + "'", element);
        try {
            Thread.sleep(20);
        } catch (Exception e) {

        }

    }

    /**
     * Bu metot ile txt dosyasına istenen bilgileri alt alta yazdırıp kaydedersiniz
     *
     * @param fileName üstüne veri yazılacak txt dosyasının yolu
     * @param list     dosyaya yazdırılacak veri
     */
    public static void saveDataInTxtFile(String fileName, List<String> list) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            for (String str : list) {
                writer.append(str);
                writer.newLine(); // yeni satır ekleme
            }
            writer.close();
        } catch (Exception e) {
            // hata durumunu işle
            e.printStackTrace();
        }
    }

    /**
     * bu metot bir elementin arka plan rengini String olarak verir
     *
     * @param element
     * @return
     */
    public static String getBackgroundColor(WebElement element) {
        String rgbColor = element.getCssValue("background-color");

        Color color = Color.fromString(rgbColor);
        String actualRgbColor = color.asHex();
        return actualRgbColor;
    }

    /**
     * element clickable olana kadar bekler
     *
     * @param element beklenecek element locate verilir
     * @param sayi    beklenecek sure verilir
     */
    public static void clickableWait(WebElement element, int sayi) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForOverlayToDisappear(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));
        } catch (TimeoutException e) {
            System.out.println("Overlay vaxtında yox olmadı.");
        }
    }

    public static String getPathSegment(String targetSegment) {
        String result = "";

        try {
            String actualUrl = getDriver().getCurrentUrl();
            URI uri = new URI(actualUrl);

            // 1. path hissəsində axtar
            String path = uri.getPath();
            System.out.println("Path: " + path); // DEBUG
            if (path != null) {
                String[] pathParts = path.split("/");
                for (String part : pathParts) {
                    if (part.equals(targetSegment)) {
                        return part;
                    }
                }
            }

            // 2. fragment hissəsində axtar
            String fragment = uri.getFragment();
            System.out.println("Fragment: " + fragment); // DEBUG
            if (fragment != null) {
                String[] fragmentParts = fragment.split("/");
                for (String part : fragmentParts) {
                    if (part.equals(targetSegment)) {
                        return part;
                    }
                }
            }

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return result;
    }
}