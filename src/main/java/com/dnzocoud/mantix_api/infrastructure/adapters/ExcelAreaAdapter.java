package com.dnzocoud.mantix_api.infrastructure.adapters;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.dnzocoud.mantix_api.application.dto.adapters.ExcelAreaDTO;
import com.dnzocoud.mantix_api.domain.adapters.IExcelDataAdapter;

public class ExcelAreaAdapter implements IExcelDataAdapter<ExcelAreaDTO> {

    @Override
    public List<ExcelAreaDTO> dataReaded(InputStream excelFile) throws IOException {
        List<ExcelAreaDTO> areasDto = new ArrayList<>();

        try (Workbook workbook = new XSSFWorkbook(excelFile)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0)
                    continue;
                ExcelAreaDTO excelAreaDTO = new ExcelAreaDTO(
                        row.getCell(0).getStringCellValue(),
                        row.getCell(1).getStringCellValue());
                areasDto.add(excelAreaDTO);
            }
            workbook.close();

        } catch (IOException e) {
            throw new RuntimeException("Error al procesar el archivo Excel", e);
        }
        return areasDto;
    }
}
