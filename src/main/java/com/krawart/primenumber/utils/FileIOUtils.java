package com.krawart.primenumber.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileIOUtils {
  static File getFile(String path) throws IOException {
    File file = new File(path);

    if (!file.exists()) throw new FileNotFoundException("File not found on path: " + path);

    return file;
  }
}
