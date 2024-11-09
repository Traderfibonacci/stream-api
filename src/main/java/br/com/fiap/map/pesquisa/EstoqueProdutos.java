package br.com.fiap.map.pesquisa;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> estoqueProdutosMap;

    public EstoqueProdutos() {
        this.estoqueProdutosMap = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco) {
        estoqueProdutosMap.put(cod, new Produto(nome, preco, quantidade));
    }

    public void exibirProdutos() {
        System.out.println(estoqueProdutosMap);
    }

    public double calcularValorTotalEstoque() {
        return estoqueProdutosMap.values()
                .stream()
                .mapToDouble(p -> p.getQuantidade() * p.getPreco())
                .sum();
    }

    public Produto obterProdutoMaisCaro() {
        return estoqueProdutosMap.values()
                .stream()
                .max(Comparator.comparingDouble(Produto::getPreco))
                .orElse(null);
    }

    public Produto obterProdutoMaisBarato() {
        return estoqueProdutosMap.values().stream()
                .min(Comparator.comparingDouble(Produto::getPreco))
                .orElse(null);
    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
       return estoqueProdutosMap.values().stream()
               .max(Comparator.comparingDouble(p -> p.getPreco() * p.getQuantidade()))
               .orElse(null);
    }

    public static void main(String[] args) {
        EstoqueProdutos estoque = new EstoqueProdutos();


        estoque.exibirProdutos();


        estoque.adicionarProduto(1L, "Notebook", 5, 1500.0);
        estoque.adicionarProduto(2L, "Mouse", 5, 25.0);
        estoque.adicionarProduto(3L, "Monitor", 2, 400.0);
        estoque.adicionarProduto(4L, "Teclado", 3, 40.0);


        estoque.exibirProdutos();


        System.out.println("Valor total do estoque: R$" + estoque.calcularValorTotalEstoque());


        Produto produtoMaisCaro = estoque.obterProdutoMaisCaro();
        System.out.println("Produto mais caro: " + produtoMaisCaro);


        Produto produtoMaisBarato = estoque.obterProdutoMaisBarato();
        System.out.println("Produto mais barato: " + produtoMaisBarato);


        Produto produtoMaiorQuantidadeValorTotal = estoque.obterProdutoMaiorQuantidadeValorTotalNoEstoque();
        System.out.println("Produto com maior quantidade em valor no estoque: " + produtoMaiorQuantidadeValorTotal);
    }
}
