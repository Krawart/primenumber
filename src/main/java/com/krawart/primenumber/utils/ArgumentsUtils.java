package com.krawart.primenumber.utils;

import java.util.logging.Logger;

public interface ArgumentsUtils {
  Logger log = Logger.getLogger(ArgumentsUtils.class.getSimpleName());

  static void checkArguments(String[] args) {
    if (args.length != 1) {
      log.warning("Please specify path to excel sheet.");
      System.exit(1);
    }
  }
}
