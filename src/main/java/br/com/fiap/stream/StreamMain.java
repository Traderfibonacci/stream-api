package br.com.fiap.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class StreamMain {
    public static void main(String[] args) {
        List<Integer> numerosOrdenados = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        // Ordem numérica
        System.out.println("Ordem numérica:");
        numerosOrdenados.stream().sorted().forEach(System.out::println);

        // Soma dos números pares
        BinaryOperator<Integer> somaDosNumerosPares = Integer::sum;
        int somaPares = numerosOrdenados
                .stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, somaDosNumerosPares);
        System.out.println("Soma dos números pares: " + somaPares);

        // Verificando se é positivo
        Predicate<Integer> ehPositivo = n -> n > 0;
        List<Integer> numerosPositivos = numerosOrdenados.stream()
                .filter(ehPositivo)
                .toList();
        System.out.println("Números positivos: ");
        numerosPositivos.forEach(System.out::println);

        // Removendo números ímpares
        Predicate<Integer> ehPar = n -> n % 2 == 0;
        List<Integer> numerosPares = numerosOrdenados.stream()
                .filter(ehPar)
                .toList();
        System.out.println("Números pares: ");
        numerosPares.forEach(System.out::println);
    }
}
