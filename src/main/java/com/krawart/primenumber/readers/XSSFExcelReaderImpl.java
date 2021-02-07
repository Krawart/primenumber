package com.krawart.primenumber.readers;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XSSFExcelReaderImpl implements XSSFExcelReader {

  @Override
  public List<Integer> getValuesFromExcel(String path) throws IOException {
    XSSFWorkbook workbook = openWorkbook(path);
    List<Cell> column = readColumnFromSheet(workbook, 0, 1);
    workbook.close();

    return convertCellsToInteger(column);
  }

  private List<Cell> readColumnFromSheet(XSSFWorkbook workbook, int sheetNumber, int columnNumber) {
    XSSFSheet sheet = workbook.getSheetAt(sheetNumber);

    List<Cell> cellValues = new ArrayList<>();
    for (Row row : sheet) {
      cellValues.add(row.getCell(columnNumber));
    }

    return cellValues;
  }

  private List<Integer> convertCellsToInteger(List<Cell> cells) {
    List<Integer> list = new ArrayList<>();

    cells.forEach(cell -> {
      switch (cell.getCellType()) {
        case STRING:
          try {
            list.add(Integer.parseInt(cell.getStringCellValue()));
            break;
          } catch (NumberFormatException e) {
            return;
          }
        case NUMERIC:
          list.add((int) cell.getNumericCellValue());
          break;
        default:
          throw new IllegalArgumentException("Value inside cell " + cell.getAddress() + " is not number");
      }
    });

    return list;
  }
}
