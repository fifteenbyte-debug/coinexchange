package com.fifteen.util;

import cn.hutool.core.text.csv.CsvWriter;
import org.apache.commons.lang3.StringUtils;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

public class ReportCsvUtils {

    public static void reportList(HttpServletResponse response,
                                  String[] header,
                                  String[] properties,
                                  String fileName,
                                  List<?> sourceList) throws Exception {
        if (header == null || properties == null || sourceList == null || header.length < 0 || properties.length < 0 || sourceList.size() < 0) {
            return;
        }
        if (StringUtils.isNotBlank(fileName)) {
            fileName = "1.csv";
        }
        response.setContentType("application/csv");
        response.setCharacterEncoding("GBK");
        response.setHeader("Content-FileName", URLEncoder.encode(fileName, "utf-8"));
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        csvWriter.writeHeader(header);
        for (Object bean : sourceList) {
            csvWriter.write(bean, properties);
        }
        csvWriter.close();
    }

    public static void reportListCsv(HttpServletResponse response,
                                     String[] header,
                                     String[] properties,
                                     String fileName,
                                     List<?> sourceList,
                                     CellProcessor[] processors) throws Exception {
        if (header == null || properties == null || sourceList == null || header.length < 0 || properties.length < 0 || sourceList.size() < 0) {
            return;
        }
        if (StringUtils.isNotBlank(fileName)) {
            fileName = "1.csv";
        }
        response.setContentType("application/csv");
        response.setCharacterEncoding("GBK");
        response.setHeader("Content-FileName", URLEncoder.encode(fileName, "utf-8"));
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        csvWriter.writeHeader(header);
        for (Object bean : sourceList) {
            csvWriter.write(bean, properties, processors);
        }
        csvWriter.close();
    }
}
