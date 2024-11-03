package br.com.fiap.functional_interface;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<Integer> gerarNumeroAleatorio = () -> new Random().nextInt(100);

        List<Integer> numerosAleatorios = Stream.generate(gerarNumeroAleatorio)
                .limit(10)
                .collect(Collectors.toList());

        numerosAleatorios.forEach(System.out::println);
    }
}
