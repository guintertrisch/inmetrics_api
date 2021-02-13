import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import static io.restassured.RestAssured.*;

@Listeners(listeners.Listeners.class)
public class BaseTest {
    @BeforeClass
    public static void preCondicao() {
        baseURI = "https://inm-test-api.herokuapp.com/";
        basePath = "empregado";
        RestAssured.authentication = basic("inmetrics", "automacao");
        enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
