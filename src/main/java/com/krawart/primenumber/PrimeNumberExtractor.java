package com.krawart.primenumber;

import java.util.List;
import java.util.stream.Collectors;

public class PrimeNumberExtractor {
  public List<Integer> getPrimeNumbersOf(List<Integer> numbers) {
    return numbers.stream().filter(this::isPrimeNumber).collect(Collectors.toList());
  }

  public boolean isPrimeNumber(int number) {
    if (number == 0 || number == 1) {
      return false;
    } else {
      for (int i = 2; i <= number / 2; i++) {
        if (number % i == 0) {
          return false;
        }
      }
      return true;
    }
  }
}
