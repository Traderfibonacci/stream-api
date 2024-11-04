package br.com.fiap.set.basico;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ConjuntoConvidados {
    private Set<Convidado> convidadoSet;

    public ConjuntoConvidados() {
        this.convidadoSet = new HashSet<>();
    }

    public void adicionaConvidado(String nome, int codigoConvite) {
        convidadoSet.add(new Convidado(nome, codigoConvite));
    }

    public void removerConvidadoPorCodigoConvite(int codigoConvite) {
        convidadoSet = convidadoSet.stream()
                .filter(c -> c.getCodigoConvite() != codigoConvite)
                .collect(Collectors.toSet());
    }


    public int contarConvidados() {
        return convidadoSet.size();
    }

    public void exibirConvidados() {
        System.out.println(convidadoSet);
    }

    public static void main(String[] args) {

            ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();


            System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set de Convidados");


            conjuntoConvidados.adicionaConvidado("Alice", 1234);
            conjuntoConvidados.adicionaConvidado("Bob", 1235);
            conjuntoConvidados.adicionaConvidado("Charlie", 1235);
            conjuntoConvidados.adicionaConvidado("David", 1236);


            System.out.println("Convidados no conjunto:");
            conjuntoConvidados.exibirConvidados();


            System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set de Convidados");


            conjuntoConvidados.removerConvidadoPorCodigoConvite(1234);
            System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set de Convidados após a remoção");


            System.out.println("Convidados no conjunto após a remoção:");
            conjuntoConvidados.exibirConvidados();
        }
    }

