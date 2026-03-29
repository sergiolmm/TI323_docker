package br.com.slmm.baseEx;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> listar() { return produtoRepository.findAll();}
    
    @GetMapping("/{id}")
    public Produto getCustomerById(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElse(null);
    }

    @PostMapping
    public Produto createCustomer(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    
    @PutMapping("/{id}")
    public Produto putMethodName(@PathVariable String id, @RequestBody Produto produto) {
        //TODO: process PUT request
       

        return  produtoRepository.save(produto);
    }
  
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        produtoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    


}

/*
Para inserir via post em curl

curl -X POST http://localhost:8080/api/produtos \
  -H "Content-Type: application/json" \
  -d '{"nome":"Notebook","preco":3500.00,"estoque":10}'
  
*/
