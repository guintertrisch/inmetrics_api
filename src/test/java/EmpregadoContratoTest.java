import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class EmpregadoContratoTest extends BaseTest{
    @Test
    public void testContrato() {

        given().contentType("application/json").pathParam("empregadoId", 1086).
        when().log().all().get("/list/{empregadoId}").
        then().statusCode(202).body(matchesJsonSchema(new File("src/test/resources/empregado_v1_schema.json")));

    }
}
