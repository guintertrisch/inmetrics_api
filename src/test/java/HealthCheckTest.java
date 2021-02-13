import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class HealthCheckTest extends BaseTest {

    @Test()
    public void healthCheckEmpregado() {
        given().contentType("application/json").
                when().get("/list_all").
                then().statusCode(200);
    }
}
