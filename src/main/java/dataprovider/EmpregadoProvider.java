package dataprovider;

import dto.Empregado;
import org.testng.annotations.DataProvider;

public class EmpregadoProvider {


    @DataProvider(name = "dados_empregado")
    public static Object[][] createData() {
        return new Object[][]{
                new Object[]{new Empregado("12/12/2010",
                        "Analista",
                        "460,00",
                        "380.178.890-38",
                        1,
                        "Dona Maria", "2.500,00", "f", "pj"), "empregado sexo Feminino e contratacao PJ"},
                {new Empregado("12/12/2010",
                        "Analista",
                        "460,00",
                        "380.178.890-38",
                        1,
                        "Dona Maria", "2.500,00", "m", "clt"), "empregado sexo Masculino e contratacao CLT"},
                {new Empregado("12/12/2010",
                        "Analista",
                        "460,00",
                        "380.178.890-38",
                        1,
                        "Dona Maria", "2.500,00", "i", "pj"), "empregado sexo Indiferente e contratacao PJ"
                }
        };
    }

}
