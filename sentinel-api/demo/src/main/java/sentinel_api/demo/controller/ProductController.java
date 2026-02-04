package sentinel_api.demo.controller;

import sentinel_api.demo.model.Produto;
import sentinel_api.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProductController {

    @Autowired // O Spring "instala" o repositório aqui automaticamente
    private ProdutoRepository repository;

    @PostMapping // Agora o Python enviará um JSON, e o Java converterá em Objeto
    public Produto criarProduto(@RequestBody Produto produto) {
        return repository.save(produto); // Salva no banco H2 e retorna o objeto com ID
    }

    @GetMapping
    public List<Produto> listarTodos() {
        return repository.findAll(); // Retorna todos os produtos salvos
    }
}