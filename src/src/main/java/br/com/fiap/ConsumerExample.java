package br.com.fiap;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
/*
 * Operações que aceitam um argumento do tipo T e não retorna nenhum resultado
 * é utilizada principalmente para realizar ações, ou efeitos colaterais nos elementos do Stream sem modificar
 */


public class ConsumerExample {
    public static void main(String[] args) {
    List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

    numeros.forEach(n-> {
            if(n % 2 == 0) {
                System.out.println(n);
            }
        }
    );
 }
}