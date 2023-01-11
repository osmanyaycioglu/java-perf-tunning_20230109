package com.training.performance.java8;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lab2Run {

    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(final String[] args) throws Exception {
        List<Customer> customerList = Files.readAllLines(Paths.get("customer.txt"))
                                           .parallelStream()
                                           .skip(1)
                                           .map(line -> line.split(","))
                                           .peek(s -> System.out.println("Thread : " + Thread.currentThread().getName() + " before filter" ))
                                           .filter(sa -> sa.length == 8)
                                           .peek(s -> System.out.println("Thread : " + Thread.currentThread().getName() + " before map" ))
                                           .map(Lab2Run::createCustomer)
                                           .peek(s -> System.out.println("Thread : " + Thread.currentThread().getName() + " before active filter" ))
                                           .filter(c -> c.isActivated())
                                           .peek(s -> System.out.println("Thread : " + Thread.currentThread().getName() + " before collect" ))
                                           .collect(Collectors.toList());

        Map<String, Customer> collectLoc = customerList.stream()
                                                       .collect(Collectors.toMap(c -> c.getUsername(),
                                                                                 c -> c));
        IntSummaryStatistics heightStatisticsLoc = customerList.stream()
                                                               .mapToInt(c -> c.getHeight())
                                                               .summaryStatistics();
        System.out.println(heightStatisticsLoc);
        LocalDateTime filterDate = LocalDateTime.of(2015,
                                                    1,
                                                    1,
                                                    0,
                                                    0,
                                                    0);
        List<Customer> collect2Loc = customerList.stream()
                                                 .filter(c -> filterDate.isBefore(c.getActivatedDate()))
                                                 .filter(c -> c.getHeight() > 170)
                                                 .collect(Collectors.toList());
    }

    public static Customer createCustomer(final String[] sa) {
        return new Customer().setName(sa[0])
                             .setSurname(sa[1])
                             .setHeight(Integer.parseInt(sa[2]))
                             .setUsername(sa[3])
                             .setPassword(sa[4])
                             .setActivated(Boolean.valueOf(sa[5]))
                             .setActivatedDate(LocalDateTime.from(Lab2Run.dtf.parse(sa[6])))
                             .setAccounts(Arrays.stream(sa[7].split(";"))
                                                .map(Lab2Run::createAccount)
                                                .collect(Collectors.toList()));

    }

    private static Function<? super String[], ? extends Customer> createCustomerFunc(final DateTimeFormatter dtf) {
        return sa -> new Customer().setName(sa[0])
                                   .setSurname(sa[1])
                                   .setHeight(Integer.parseInt(sa[2]))
                                   .setUsername(sa[3])
                                   .setPassword(sa[4])
                                   .setActivated(Boolean.valueOf(sa[5]))
                                   .setActivatedDate(LocalDateTime.from(dtf.parse(sa[6])))
                                   .setAccounts(Arrays.stream(sa[7].split(";"))
                                                      .map(Lab2Run::createAccount)
                                                      .collect(Collectors.toList()));
    }

    public static Account createAccount(final String str) {
        String[] splitLoc = str.split("#");
        return new Account().setAccountType(EAccountType.valueOf(splitLoc[0]))
                            .setAmount(Integer.parseInt(splitLoc[1]));
    }
}
