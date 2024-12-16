package com.dnzocoud.mantix_api.domain.adapters;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface IExcelDataAdapter<T> {
    List<T> dataReaded(InputStream excelFile) throws IOException;
}
