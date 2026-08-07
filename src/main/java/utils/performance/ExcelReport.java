    package utils.performance;

    import org.apache.poi.ss.usermodel.*;
    import org.apache.poi.xssf.usermodel.XSSFWorkbook;

    import java.io.FileOutputStream;
    import java.io.IOException;
    import java.util.List;
    import java.time.LocalDateTime;
    import java.time.format.DateTimeFormatter;
    import config.ConfigReader;
    import org.apache.poi.ss.util.CellRangeAddress;

    public class ExcelReport {

        public void generate(List<PerformanceResult> results) {

            Workbook workbook = new XSSFWorkbook();

            Sheet sheet = workbook.createSheet("Performance Report");

            CellStyle titleStyle = workbook.createCellStyle();
            Font titleFont = workbook.createFont();

            titleFont.setBold(true);
            titleFont.setFontHeightInPoints((short) 16);
            titleFont.setColor(IndexedColors.WHITE.getIndex());

            titleStyle.setFont(titleFont);

            titleStyle.setFillForegroundColor(IndexedColors.TEAL.getIndex());
            titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            titleStyle.setAlignment(HorizontalAlignment.CENTER);
            titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);

            titleStyle.setBorderTop(BorderStyle.THIN);
            titleStyle.setBorderBottom(BorderStyle.THIN);
            titleStyle.setBorderLeft(BorderStyle.THIN);
            titleStyle.setBorderRight(BorderStyle.THIN);

            CellStyle headerStyle = workbook.createCellStyle();
            Font headerFont = workbook.createFont();

            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.WHITE.getIndex());

            headerStyle.setFont(headerFont);
            headerStyle.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            headerStyle.setAlignment(HorizontalAlignment.CENTER);
            CellStyle loadTimeStyle = workbook.createCellStyle();

            loadTimeStyle.setAlignment(HorizontalAlignment.LEFT);
            loadTimeStyle.setVerticalAlignment(VerticalAlignment.CENTER);

            DataFormat dataFormat = workbook.createDataFormat();
            loadTimeStyle.setDataFormat(dataFormat.getFormat("0.000"));

            loadTimeStyle.setBorderTop(BorderStyle.THIN);
            loadTimeStyle.setBorderBottom(BorderStyle.THIN);
            loadTimeStyle.setBorderLeft(BorderStyle.THIN);
            loadTimeStyle.setBorderRight(BorderStyle.THIN);

            loadTimeStyle.setBorderTop(BorderStyle.THIN);
            loadTimeStyle.setBorderBottom(BorderStyle.THIN);
            loadTimeStyle.setBorderLeft(BorderStyle.THIN);
            loadTimeStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            headerStyle.setWrapText(true);

            CellStyle passStyle = workbook.createCellStyle();
            passStyle.setBorderTop(BorderStyle.THIN);
            passStyle.setBorderBottom(BorderStyle.THIN);
            passStyle.setBorderLeft(BorderStyle.THIN);
            passStyle.setBorderRight(BorderStyle.THIN);
            passStyle.setAlignment(HorizontalAlignment.CENTER);
            passStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
            passStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            Font passFont = workbook.createFont();
            passFont.setBold(true);
            passFont.setColor(IndexedColors.BLACK.getIndex());

            passStyle.setFont(passFont);

            CellStyle warningStyle = workbook.createCellStyle();
            warningStyle.setBorderTop(BorderStyle.THIN);
            warningStyle.setBorderBottom(BorderStyle.THIN);
            warningStyle.setBorderLeft(BorderStyle.THIN);
            warningStyle.setBorderRight(BorderStyle.THIN);
            warningStyle.setAlignment(HorizontalAlignment.CENTER);
            warningStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
            warningStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            Font warningFont = workbook.createFont();
            warningFont.setBold(true);
            warningFont.setColor(IndexedColors.BLACK.getIndex());

            warningStyle.setFont(warningFont);

            CellStyle failStyle = workbook.createCellStyle();
            failStyle.setBorderTop(BorderStyle.THIN);
            failStyle.setBorderBottom(BorderStyle.THIN);
            failStyle.setBorderLeft(BorderStyle.THIN);
            failStyle.setBorderRight(BorderStyle.THIN);
            failStyle.setAlignment(HorizontalAlignment.CENTER);
            failStyle.setFillForegroundColor(IndexedColors.ROSE.getIndex());
            failStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            Font failFont = workbook.createFont();
            failFont.setBold(true);
            failFont.setColor(IndexedColors.BLACK.getIndex());

            failStyle.setFont(failFont);

            // =========================
            // Report Title
            // =========================

            Row title = sheet.createRow(0);

            title.createCell(0).setCellValue("TrackView Performance Test Report");

            sheet.addMergedRegion(new CellRangeAddress(
                    0, 0, 0, 5
            ));

            title.getCell(0).setCellStyle(titleStyle);

            // =========================
            // Report Information
            // =========================

            Row infoHeader = sheet.createRow(1);

            infoHeader.createCell(0).setCellValue("Test Date");
            infoHeader.createCell(1).setCellValue("Browser");
            infoHeader.createCell(2).setCellValue("Release");
            infoHeader.createCell(3).setCellValue("Environment");
            infoHeader.createCell(4).setCellValue("Tester");
            infoHeader.createCell(5).setCellValue("Benchmark");

            for (int i = 0; i < 6; i++) {
                infoHeader.getCell(i).setCellStyle(headerStyle);
            }

            Row info = sheet.createRow(2);

            info.createCell(0).setCellValue(
                    LocalDateTime.now().format(
                            DateTimeFormatter.ofPattern("dd-MMM-yyyy"))
            );

            info.createCell(1).setCellValue(ConfigReader.getBrowser());
            info.createCell(2).setCellValue(ConfigReader.getRelease());
            info.createCell(3).setCellValue(ConfigReader.getEnvironment());
            info.createCell(4).setCellValue(ConfigReader.getTester());
            info.createCell(5).setCellValue("3 sec");

            CellStyle infoStyle = workbook.createCellStyle();

            infoStyle.setBorderTop(BorderStyle.THIN);
            infoStyle.setBorderBottom(BorderStyle.THIN);
            infoStyle.setBorderLeft(BorderStyle.THIN);
            infoStyle.setBorderRight(BorderStyle.THIN);

            infoStyle.setAlignment(HorizontalAlignment.CENTER);
            infoStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            CellStyle dataStyle = workbook.createCellStyle();

            dataStyle.setBorderTop(BorderStyle.THIN);
            dataStyle.setBorderBottom(BorderStyle.THIN);
            dataStyle.setBorderLeft(BorderStyle.THIN);
            dataStyle.setBorderRight(BorderStyle.THIN);

            dataStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            dataStyle.setAlignment(HorizontalAlignment.LEFT);

            for (int i = 0; i < 6; i++) {
                info.getCell(i).setCellStyle(infoStyle);
            }

            // Header
            Row header = sheet.createRow(4);
            header.setHeightInPoints(35);
            header.createCell(0).setCellValue("Module");
            header.createCell(1).setCellValue("Page");
            header.createCell(2).setCellValue(
                    "Load Time\nAfter \"Please Wait\" (sec)"
            );
            header.createCell(3).setCellValue("Status");

            for (int i = 0; i < 4; i++) {
                header.getCell(i).setCellStyle(headerStyle);
            }

            int rowNum = 5;

            for (PerformanceResult result : results) {

                Row row = sheet.createRow(rowNum++);

                Cell moduleCell = row.createCell(0);
                moduleCell.setCellValue(result.getModule());
                moduleCell.setCellStyle(dataStyle);

                Cell pageCell = row.createCell(1);
                pageCell.setCellValue(result.getPage());
                pageCell.setCellStyle(dataStyle);

                double loadTimeSec = result.getLoadTime() / 1000.0;
                Cell loadTimeCell = row.createCell(2);

                loadTimeCell.setCellValue(loadTimeSec);
                loadTimeCell.setCellStyle(loadTimeStyle);
                String status;

                if (loadTimeSec < 3) {
                    status = "PASS";
                } else if (loadTimeSec <= 5) {
                    status = "WARNING";
                } else {
                    status = "FAIL";
                }

                Cell statusCell = row.createCell(3);

                statusCell.setCellValue(status);

                if ("PASS".equals(status)) {
                    statusCell.setCellStyle(passStyle);
                } else if ("WARNING".equals(status)) {
                    statusCell.setCellStyle(warningStyle);
                } else {
                    statusCell.setCellStyle(failStyle);
                }            }

            sheet.setColumnWidth(0, 15 * 256);      // Module

            sheet.autoSizeColumn(1);                // Page

            sheet.setColumnWidth(2, 24 * 256);      // Load Time

            sheet.setColumnWidth(3, 20 * 256);      // Status

            sheet.setColumnWidth(4, 12 * 256);      // Tester

            sheet.setColumnWidth(5, 18 * 256);      // Benchmark

            String fileName =
                    "Performance_Report_"
                            + LocalDateTime.now().format(
                            DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"))
                            + ".xlsx";

            try (FileOutputStream output =
                         new FileOutputStream("reports" + java.io.File.separator + fileName)) {

                workbook.write(output);
                workbook.close();

                System.out.println("Performance Report Generated Successfully.");
                System.out.println("File: " + fileName);

            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }