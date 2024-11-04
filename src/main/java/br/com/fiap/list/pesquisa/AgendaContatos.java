package br.com.fiap.list.pesquisa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class AgendaContatos {
    private Set<Contato> contatosSet;

    public AgendaContatos() {
        this.contatosSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero) {
        contatosSet.add(new Contato(nome, numero));
    }

    public void exibirContatos() {
        System.out.println(contatosSet);
    }

    public Set<Contato> pesquisarPorNome(String nome) {
        return contatosSet.stream()
                .filter(c -> c.getNome().startsWith(nome))
                .collect(Collectors.toSet());
    }

    public Optional<Contato> atualizarNumeroContato(String nome, int novoNumero) {
        contatosSet.stream()
                .filter(c -> c.getNome().equalsIgnoreCase(nome))
                .forEach(c -> c.setNumero(novoNumero));
        return contatosSet.stream()
                .filter(c -> c.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.exibirContatos();

        agendaContatos.adicionarContato("Lucas", 123456);
        agendaContatos.adicionarContato("Lucas", 5663);
        agendaContatos.adicionarContato("Lucas Fiap", 11111);
        agendaContatos.adicionarContato("Lucas Cunha", 656362);
        agendaContatos.adicionarContato("Fulano Silva", 11111);

        agendaContatos.exibirContatos();

        System.out.println(agendaContatos.pesquisarPorNome("Lucas"));

        System.out.println("Contato atualizado: " + agendaContatos.atualizarNumeroContato("Lucas", 999999));

        agendaContatos.exibirContatos();
    }
}
