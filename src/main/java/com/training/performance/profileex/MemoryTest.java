package com.training.performance.profileex;

import com.training.performance.java8.Account;
import com.training.performance.java8.Customer;
import com.training.performance.java8.EAccountType;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MemoryTest {

    private List<Customer> customers = new ArrayList<>(10_000);

    public MemoryTest() {
        Random random = new Random();
        for (int i = 0; i < 10_000; i++) {
            customers.add(Customer.builder()
                                  .withName("name" + random.nextInt(1_000_000))
                                  .withActivated(true)
                                  .withHeight(random.nextInt(200))
                                  .withUsername("user" + random.nextInt())
                                  .withSurname("sur" + random.nextInt())
                                  .withAccounts(Arrays.asList(Account.builder()
                                                                     .withAmount(random.nextInt(1_000_000))
                                                                     .withAccountType(EAccountType.TL)
                                                                     .build(),
                                                              Account.builder()
                                                                     .withAmount(random.nextInt(1_000_000))
                                                                     .withAccountType(EAccountType.DOLAR)
                                                                     .build())

                                  ).build()
            );
        }
    }
    public void test(){
        System.out.println("test");
    }
}
