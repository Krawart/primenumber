package com.krawart.primenumber.readers;

import com.krawart.primenumber.utils.FileIOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public interface XSSFExcelReader {
  List<Integer> getValuesFromExcel(String path) throws IOException;

  default XSSFWorkbook openWorkbook(String path) throws IOException {

    try (
      FileInputStream inputStream = new FileInputStream(FileIOUtils.getFile(path));
      XSSFWorkbook workbook = new XSSFWorkbook(inputStream)
    ) {
      return workbook;
    }
  }
}
