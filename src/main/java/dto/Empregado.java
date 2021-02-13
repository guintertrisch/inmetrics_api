package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Empregado {
    private String admissao;
    private String cargo;
    private String comissao;
    private String cpf;
    private Integer departamentoId;
    private String nome;
    private String salario;
    private String sexo;
    private String tipoContratacao;
}
