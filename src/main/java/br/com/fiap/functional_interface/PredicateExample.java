package br.com.fiap.functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("java", "kotlin", "javascript", "python");

        Predicate<String> menosDeCincoCaracteres = palavra -> palavra.length() < 5;

        palavras.stream()
                .filter(menosDeCincoCaracteres)
                .forEach(System.out::println);
    }
}
