package br.com.fiap.list.ordenacao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrdenacaoPessoa {
    private List<Pessoa> pessoaList;

    public OrdenacaoPessoa() {
        this.pessoaList = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, double altura) {
        pessoaList.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdade() {
        return pessoaList.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Pessoa> ordenarPorAltura() {
        return pessoaList.stream()
                .sorted(new ComparatorPorAltura())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        OrdenacaoPessoa ordenacaoPessoa = new OrdenacaoPessoa();
        ordenacaoPessoa.adicionarPessoa("Nome 1",20,1.60);
        ordenacaoPessoa.adicionarPessoa("Nome 2",30,1.70);
        ordenacaoPessoa.adicionarPessoa("Nome 3",25,1.73);
        ordenacaoPessoa.adicionarPessoa("Nome 4",22,1.75);

        System.out.println(ordenacaoPessoa.ordenarPorIdade());
        System.out.println(ordenacaoPessoa.ordenarPorAltura());
    }
}

