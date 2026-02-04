package sentinel_api.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity    // Comunica ao Spring: Crie um tabela no banco de dados
@Data   // Gerar Getter e Setters automaticamente (Lombok)

public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O ID será 1, 2, 3,... Automático
    private long id;
    private String nome;
    private double preco;
    // JPA para abstrair o SQL
}
