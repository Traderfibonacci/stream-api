package br.com.fiap.list.basico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CatalogoLivros {

    private final List<Livro> livrosList;

    public CatalogoLivros() {
        this.livrosList = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        livrosList.add(new Livro(titulo, autor, anoPublicacao));
    }

    public List<Livro> pesquisarPorAutor(String autor) {
        return livrosList.stream()
                .filter(livro -> livro.getAutor().equalsIgnoreCase(autor))
                .collect(Collectors.toList());
    }

    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {
        return livrosList.stream()
                .filter(livro -> livro.getAnoPublicacao() >= anoInicial && livro.getAnoPublicacao() <= anoFinal)
                .collect(Collectors.toList());
    }

    public Optional<Livro> pesquisarPorTitulo(String titulo) {
        return livrosList.stream()
                .filter(livro -> livro.getTitulo().equalsIgnoreCase(titulo))
                .findFirst();
    }

    public static void main(String[] args) {
        CatalogoLivros c = new CatalogoLivros();
        c.adicionarLivro("Livro 1", "Autor 1", 2021);
        c.adicionarLivro("Livro 2", "Autor 2", 2022);
        c.adicionarLivro("Livro 3", "Autor 3", 2023);
        c.adicionarLivro("Livro 4", "Autor 4", 2024);
        c.adicionarLivro("Livro 5", "Autor 5", 1992);

        System.out.println(c.pesquisarPorAutor("Autor 2"));
        System.out.println(c.pesquisarPorIntervaloAnos(2021, 2023));
        System.out.println(c.pesquisarPorTitulo("Livro 1"));
    }
}
