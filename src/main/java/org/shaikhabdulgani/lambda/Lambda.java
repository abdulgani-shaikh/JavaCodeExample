package org.shaikhabdulgani.lambda;

import java.util.function.*;

public class Lambda {
    public static void main(String[] args) {
        LambdaExample lambdaExample = name -> System.out.println("My name is "+name);
        lambdaExample.printName("Abdul Gani");

        //takes one Generic Specified and returns the second Generic
        Function<String,String > fun = name -> "Hello, "+name;
        System.out.println(fun.apply("Abdul Gani"));

        //takes Two Generic Specified and returns the third Generic
        BiFunction<String, String, String> biFunction = (s, s2) -> s+" "+s2;
        System.out.println(biFunction.apply("Hello","BiFunction"));

        //takes no argument and return Generic specified
        Supplier<String> supplier = () -> "Hello";
        System.out.println(supplier.get());

        //takes one argument and consumes it
        Consumer<String > consumer = s -> System.out.println("Similar to our Lambda example: "+s);
        consumer.accept("Hello, I am getting consumed");

        //takes two argument and consumes it
        BiConsumer<String ,String> biConsumer = (s, s2) -> System.out.println(s+" "+s2);
        biConsumer.accept("Hello", "BiConsumer");

        //takes one argument and returns true or false
        Predicate<String > predicate = s -> s.equals("Hello");

        //takes two arguments and returns true or false
        BiPredicate<String,Integer > biPredicate = (s, integer) -> Integer.parseInt(s)==10;
    }
}

