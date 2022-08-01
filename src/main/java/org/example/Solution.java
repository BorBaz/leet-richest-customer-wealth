package org.example;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Solution {
    public int maximumWealth(int[][] accounts) {

        int maxWealth = 0;

        for (int[] rich : accounts) {
            int currentWealth = 0;
            for (int money : rich) {
                currentWealth += money;
            }
            maxWealth = Math.max(maxWealth, currentWealth);
        }

        return maxWealth;
    }

    public int maximumWealthJDK8(int[][] accounts) {

        AtomicInteger maxWealth = new AtomicInteger();

        Arrays.stream(accounts).forEach(bankAccount -> {
            int currentWealth = IntStream.of(bankAccount).sum();
            maxWealth.set(Math.max(maxWealth.get(), currentWealth));
        });

        return maxWealth.get();
    }

    public int maximumWealthJDK8BestOption(int[][] accounts) {
        return Arrays.stream(accounts)
                .mapToInt(customer -> Arrays.stream(customer).sum())
                .max()
                .getAsInt();
    }

}
