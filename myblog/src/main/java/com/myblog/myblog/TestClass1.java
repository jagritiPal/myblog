//package com.myblog.myblog;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Random;
//import java.util.function.Consumer;
//import java.util.function.Function;
//import java.util.function.Predicate;
//import java.util.function.Supplier;
//import java.util.stream.Collectors;
//
//public class TestClass {
//
//    public static void main(String[] args) {
//
////        Predicate<Integer> val = x->x%2==0;
////        boolean result = val.test(19);
////        System.out.println(result);
//
////        Predicate<String> val = str->str.equals("mike");
////        boolean result = val.test("jagriti");
////        System.out.println(result);
//
////        List<Integer> numbers = Arrays.asList(10, 45, 57, 82, 46, 8);
////        List<Integer> result = numbers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
////        System.out.println(result);
//
////        List<Integer> numbers = Arrays.asList(10, 45, 57, 82, 46, 8);
////        List<Integer> result = numbers.stream().filter(x -> x % 2 != 0).collect(Collectors.toList());
////        System.out.println(result);
//
////        List<String> names = Arrays.asList("dev", "golu", "mike", "sam", "sonu");
////        List<String> results1 = names.stream().filter(x -> x.startsWith("s")).collect(Collectors.toList());
////        System.out.println(results1);
////        List<String> results2 = names.stream().filter(x -> x.endsWith("v")).collect(Collectors.toList());
////        System.out.println(results2);
////        List<String> results3 = names.stream().filter(x -> x.equals("golu")).collect(Collectors.toList());
////        System.out.println(results3);
//
////        Function<String, Integer> val = str-> str.length();
////        Integer result = val.apply("Jagriti");
////        System.out.println(result);
//
////        Function<Integer, Integer> val = x->x+10;
////        Integer result = val.apply(10);
////        System.out.println(result);
//
////        List<Integer> numbers = Arrays.asList(10, 45, 57, 82, 46, 8);
////        List<Integer> results = numbers.stream().map(x -> x + 10).collect(Collectors.toList());
////        System.out.println(results);
//
////        List<String> names = Arrays.asList("dev", "golu", "mike", "sam", "sonu");
////        List<String> results = names.stream().map(x -> x.toUpperCase()).collect(Collectors.toList());
////        System.out.println(results);
//
////        List<String> names = Arrays.asList("dev", "golu", "mike", "sam", "sonu");
////        List<String> results = names.stream().sorted().collect(Collectors.toList());
////        System.out.println(results);
//
////        List<Integer> numbers = Arrays.asList(10, 45, 57, 82, 46, 8);
////        List<Integer> results = numbers.stream().sorted().collect(Collectors.toList());
////        System.out.println(results);
//
////        List<Integer> numbers = Arrays.asList(10, 45, 57, 82, 46, 57, 45, 10, 54, 8);
////        List<Integer> results = numbers.stream().distinct().collect(Collectors.toList());
////        System.out.println(results);
//
////        List<Integer> numbers = Arrays.asList(10, 45, 57, 82, 46, 57, 45, 10, 54, 8);
////        List<Integer> results = numbers.stream().distinct().sorted().collect(Collectors.toList());
////        System.out.println(results);
//
////        List<Integer> numbers = Arrays.asList(10, 45, 57, 82, 46, 57, 45, 10, 54, 8);
////        List<Integer> results = numbers.stream().distinct().sorted((a,b)->b.compareTo(a)).collect(Collectors.toList());
////        System.out.println(results);
//
////        Consumer<Integer> val = number -> System.out.println(number);
////        val.accept(10);
//
////        List<String> names = Arrays.asList("dev", "golu", "mike", "sam", "sonu");
////        Consumer<String> val = name -> System.out.println(name);
////        names.forEach(val);
//
////        System.out.println(new Random().nextInt(10));
//
////        Supplier<Integer> val = ()->new Random().nextInt(500);
////        Integer x = val.get();
////        System.out.println(x);
//
//        List<Login> logins = Arrays.asList(
//                new Login("Jagriti", "testing"),
//                new Login("Swarup", "testing")
//        );
//        List<LoginDto> dtos = logins.stream().map(login-> mapToDto(login)).collect(Collectors.toList());
//        System.out.println(dtos);
//    }
//
//    static LoginDto mapToDto(Login login){
//        LoginDto dto = new LoginDto();
//        dto.setUsername(login.getUsername());
//        dto.setPassword(login.getPassword());
//        return dto;
//    }
//}
