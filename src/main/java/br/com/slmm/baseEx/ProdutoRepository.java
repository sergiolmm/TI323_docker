package br.com.slmm.baseEx;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    // o spring gera o SQL automaticamente
    List<Produto> findByNomeContainingIgnoreCase(String nome);

    List<Produto> findByPrecoLessThan(Double preco);
    
}
/*
Métodos herdados do JpaRepository:
Método.          Ação
findAll()        Lista todos
findById(id).    Busca por ID
save(obj)        Cria ou atualiza
deleteById(id).  Remove por ID
*/