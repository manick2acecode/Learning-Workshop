package com.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestListMap {

    public static void main(String[] args) {

        List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(1, "liquidweb.com", 80000));
        list.add(new Hosting(2, "linode.com", 90000));
        list.add(new Hosting(3, "digitalocean.com", 140000));
        list.add(new Hosting(4, "aws.amazon.com", 200000));
        list.add(new Hosting(5, "manickaselvam.com", 1));
        //list.add(new Hosting(6, "google.com", 120000));

        // key = id, value - websites
        //Map<Integer, Hosting> result1 = list.stream().collect(
                //Collectors.toMap(Hosting::getId, Function.identity()));

        Hosting findHosting = list.stream()
            .filter(customer -> (120000 == customer.getWebsites()))
            .findFirst().orElse(null);
        System.out.println("findHosting 29 : " + findHosting);
        if(findHosting == null) {
            System.out.println("findHosting 34 : ");
            List<Hosting> lis2 = new ArrayList<>();
            lis2.add(new Hosting(6, "google.com", 120000));
            list.addAll(lis2);
            findHosting = lis2.stream()
                    .filter(customer -> (120000 == customer.getWebsites()))
                    .findFirst().orElse(null);
        }

        //lis2.add(new Hosting(7, "aws.amazon.com", 200000));
        //lis2.add(new Hosting(8, "manick.com", 1));

        //lis2.forEach(e -> result1.put(e.getId(), e));

//        result1 = lis2.stream().collect(
//                Collectors.toMap(Hosting::getId, Function.identity()));

        System.out.println("Result 1 : " + list);
        System.out.println("findHosting : " + findHosting);

//        // key = name, value - websites
//        Map<String, Long> result2 = list.stream().collect(
//                Collectors.toMap(Hosting::getName, Hosting::getWebsites));
//
//        System.out.println("Result 2 : " + result2);
//
//        // Same with result1, just different syntax
//        // key = id, value = name
//        Map<Integer, String> result3 = list.stream().collect(
//                Collectors.toMap(x -> x.getId(), x -> x.getName()));

        //System.out.println("Result 3 : " + result3);
    }
}


