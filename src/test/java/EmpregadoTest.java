import dataprovider.EmpregadoProvider;
import dto.Empregado;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Listeners(listeners.Listeners.class)
public class EmpregadoTest extends BaseTest {


    @Test(dataProvider = "dados_empregado", dataProviderClass = EmpregadoProvider.class)
    public void deveCadastrarEmpregadoComSucesso(Empregado empregado, String cenario) {
        given().
                contentType("application/json").body(empregado).
                when().
                post("/cadastrar").
                then().
                log().all().statusCode(202).
                body("nome", equalTo(empregado.getNome())).
                body("sexo", equalTo(empregado.getSexo())).
                body("cpf", equalTo(empregado.getCpf())).
                body("cargo", equalTo(empregado.getCargo())).
                body("admissao", equalTo(empregado.getAdmissao())).
                body("salario", equalTo(empregado.getSalario())).
                body("comissao", equalTo(empregado.getComissao())).
                body("tipoContratacao", equalTo(empregado.getTipoContratacao()));
    }

}
