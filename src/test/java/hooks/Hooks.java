package hooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.Driver;

public class Hooks {
    /*
    Hooks : Her bir Scenario ya da Scenario Outline dan once ya da sonra calismasini istedigimiz metotlar konur
    @Before ve @After metotlarini icerir
     */
    @Before
    public void setUpScenarios(){
        System.out.println("Before Metotu");
    }
    @After
    public void tearDownScenarios(Scenario scenario){
          System.out.println("After Metotu");
////        Eger bir Scenario FAIL ederse, ekran goruntusunu al ve rapora ekle
//        if (scenario.isFailed()) {
//            final byte[] failedScreenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
////                       ekran goruntusu    file tipi                  ekran goruntusunun adi
//            scenario.attach(failedScreenshot, "image/png", "failed_scenario_" + scenario.getName());

 Driver.quitDriver(); // Burasi tarayici kapatir
        }
    }
//}

//package hooks;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import utilities.Driver;
//
//public class Hooks {
//
//    @Before
//    public void setUpScenarios() {
//        System.out.println("🔹 Before: Yeni driver açılır");
//        Driver.getDriver(); // Hər scenario öncəsi driver initialize edilir
//    }
//
//    @After
//    public void tearDownScenarios(Scenario scenario) {
//        System.out.println("🔹 After: Scenario bitdi");
//
//        // Fail olduqda screenshot əlavə et
//        if (scenario.isFailed() && Driver.getDriver() != null) {
//            final byte[] failedScreenshot = ((TakesScreenshot) Driver.getDriver())
//                    .getScreenshotAs(OutputType.BYTES);
//            scenario.attach(failedScreenshot, "image/png", "failed_scenario_" + scenario.getName());
//        }
//
//        // Hər scenariodan sonra driver tam bağlanır
//        Driver.quitDriver();
//    }
//}
