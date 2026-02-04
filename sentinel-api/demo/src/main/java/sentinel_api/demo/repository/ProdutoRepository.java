package sentinel_api.demo.repository;

import sentinel_api.demo.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

// Essa interface dá métodos prontos como .save(), .findAll() e .delete()
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}