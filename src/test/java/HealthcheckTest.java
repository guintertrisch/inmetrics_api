import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class HealthcheckTest extends BaseTest {
    @BeforeClass
    static void healthCheckActuator() {
        basePath = "/";
    }

    @Test(enabled = false)
    public void healthCheckEntregaTalao() {
        given().
                relaxedHTTPSValidation().
                when().
                get("actuator/health").
                then().
                statusCode(200).
                body("status", CoreMatchers.is("UP"));
    }
}
