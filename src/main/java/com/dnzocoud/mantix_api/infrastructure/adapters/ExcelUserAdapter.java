package com.dnzocoud.mantix_api.infrastructure.adapters;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.dnzocoud.mantix_api.domain.adapters.IExcelDataAdapter;
import com.dnzocoud.mantix_api.domain.models.User;

public class ExcelUserAdapter implements IExcelDataAdapter<User> {

    @Override
    public List<User> dataReaded(InputStream excelFile) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }
}
