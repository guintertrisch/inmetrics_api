import dataprovider.EmpregadoProvider;
import dto.Empregado;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

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

    @Test
    public void deveListaEmpregadoCadastrado() {
        Empregado empregado = new Empregado("10/12/2012",
                "Pedreiro",
                "2.000,00",
                "855.639.100-16",
                1,
                "Dom pedro",
                "1.500,00",
                "m",
                "pj");

        //post do cadastro
        Response response = given().contentType("application/json").body(empregado).
                when().post("/cadastrar");

        int empregadoId = response.path("empregadoId");

        //get do funcionario cadastrado
        given().contentType("application/json").pathParam("empregadoId",empregadoId).
        when().log().all().get("/list/{empregadoId}").
        then().log().all().
                statusCode(202).body("empregadoId",equalTo(empregadoId)).
                                body("nome", equalTo(empregado.getNome())).
                                body("sexo", equalTo(empregado.getSexo())).
                                body("cpf", equalTo(empregado.getCpf())).
                                body("cargo", equalTo(empregado.getCargo())).
                                body("admissao", equalTo(empregado.getAdmissao())).
                                body("salario", equalTo(empregado.getSalario())).
                                body("comissao", equalTo(empregado.getComissao())).
                                body("tipoContratacao", equalTo(empregado.getTipoContratacao()));
    }

    @Test
    public void deveListarTodosEmpregados(){
        given().contentType("application/json").
        when().get("/list_all").
        then().statusCode(200);
    }

    @Test
    public void deveAlterarEmpregadoComSucesso(){
        Empregado empregado = new Empregado("10/12/2012",
                "Motorista",
                "2.000,00",
                "855.639.100-16",
                1,
                "Dom pedro",
                "1.500,00",
                "m",
                "clt");

        //post do cadastro
        Response response = given().contentType("application/json").body(empregado).
                when().post("/cadastrar");

        int empregadoId = response.path("empregadoId");

        empregado.setCargo("Garson");
        empregado.setTipoContratacao("pj");
        empregado.setSalario("500,00");

        //put alteração do empregado cadastrado
        given().contentType("application/json").pathParam("empregadoId",empregadoId).body(empregado).
                when().log().all().put("/alterar/{empregadoId}").
                then().log().all().
                statusCode(202).body("empregadoId",equalTo(empregadoId)).
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
