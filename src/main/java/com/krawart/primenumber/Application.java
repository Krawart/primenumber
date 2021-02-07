package com.krawart.primenumber;

import com.krawart.primenumber.readers.XSSFExcelReader;
import com.krawart.primenumber.readers.XSSFExcelReaderImpl;
import com.krawart.primenumber.utils.ArgumentsUtils;

import java.io.IOException;
import java.util.List;

public class Application {
  public static void main(String[] args) throws IOException {
    ArgumentsUtils.checkArguments(args);
    String path = args[ 0 ];

    XSSFExcelReader xssfExcelReader = new XSSFExcelReaderImpl();
    List<Integer> values = xssfExcelReader.getValuesFromExcel(path);

    PrimeNumberExtractor extractor = new PrimeNumberExtractor();
    values = extractor.getPrimeNumbersOf(values);

    //Print results
    printResults(values);
  }

  private static void printResults(List<Integer> values) {
    String number;
    for (Integer value : values) {
      number = String.valueOf(value);
      System.out.println(number); // Should be used logger, but result in console is straightforward in this case
    }
  }
}
