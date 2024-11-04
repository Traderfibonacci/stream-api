package br.com.fiap.set.ordenacao;

import java.util.*;
import java.util.stream.Collectors;

public class CadastroProdutos {

    private Set<Produto> produtoSet;

    public CadastroProdutos() {
        this.produtoSet = new HashSet<>();
    }

    public void adicionarProduto(long cod, String nome, double preco, int quantidade) {
        produtoSet.add(new Produto(cod, nome, preco, quantidade));
    }

    public Set<Produto> exibirProdutosPorNome() {
        return produtoSet.stream()
                .sorted(Comparator.comparing(Produto::getNome))
                .collect(Collectors.toCollection(TreeSet::new));
    }


    public Set<Produto> exibirProdutosPorPreco() {
        return produtoSet.stream()
                .sorted(Comparator.comparing(Produto::getPreco))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
    public static void main(String[] args) {

        CadastroProdutos cadastroProdutos = new CadastroProdutos();


        cadastroProdutos.adicionarProduto(1L, "Smartphone", 1000d, 10);
        cadastroProdutos.adicionarProduto(2L, "Notebook", 1500d, 5);
        cadastroProdutos.adicionarProduto(3L, "Mouse", 30d, 20);
        cadastroProdutos.adicionarProduto(4L, "Teclado", 50d, 15);


        System.out.println(cadastroProdutos.produtoSet);


        System.out.println(cadastroProdutos.exibirProdutosPorNome());


        System.out.println(cadastroProdutos.exibirProdutosPorPreco());
    }
}
