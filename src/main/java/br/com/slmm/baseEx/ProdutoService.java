package br.com.slmm.baseEx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Produto buscarPorId(Long id){
        return repository.findById(id)
            .orElseThrow(() -> 
               new RuntimeException("Produto nao encontrado " + id) );
    
    }
    // cria um metodo com regra de negocio

    public Produto salvar(Produto produto){
         if (produto.getPreco() <= 0)
            throw new IllegalArgumentException("Preço Invalido");
        return repository.save(produto);
    }

    public void deletar(Long id){
        buscarPorId(id);
        repository.deleteById(id);
        
    }

    public Produto atualizar(Long id, Produto produto) {
        repository.findById(id)
            .orElseThrow(() ->
                new RuntimeException("Produto não encontrado: " + id));
        if (produto.getPreco() <= 0)
            throw new IllegalArgumentException("Preço Invalido");
        if (produto.getEstoque() <= 0)
            throw new IllegalArgumentException("Estoque Invalido");
        return repository.save(produto);         
    }
}







