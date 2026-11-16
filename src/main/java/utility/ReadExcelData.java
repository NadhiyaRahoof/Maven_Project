package utility;

import org.apache.poi.ss.usermodel.*;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;

public class ReadExcelData {
    public static String getParticularData(int rowval,int colval){
        String data=null;

        try {
            File file =new File("C:\\Users\\DELL\\OneDrive\\Desktop\\DataDriven_IPT.xlsx");
            Workbook book = new XSSFWorkbook(file);
            Sheet sheet =book.getSheet("Sheet1");
            Row row =sheet.getRow(rowval);
            Cell cell =row.getCell(colval);

            //DATAFORMATTER -- > convert each cell into String value
            DataFormatter dataFormat = new DataFormatter();
            data =dataFormat.formatCellValue(cell);
            System.out.println(data);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
    public static void getAllData(){
        try {
            File file =new File("C:\\Users\\DELL\\OneDrive\\Desktop\\DataDriven_IPT.xlsx");
            Workbook book = new XSSFWorkbook(file);
            Sheet sheet =book.getSheet("Sheet1");

            int lastRowNum =sheet.getLastRowNum();
            System.out.println("No.of rows:"+lastRowNum);

            short lastCellNum =sheet.getRow(0).getLastCellNum();
            System.out.println("No.of Columns"+lastCellNum);

            for(int i=1; i<=lastRowNum;i++) {
                //DATAFORMATTER -- > convert each cell into String value
                for (int j = 0; j < lastCellNum; j++) {
                    Cell cell= sheet.getRow(i).getCell(j);
                    DataFormatter dataFormat = new DataFormatter();
                    String data =dataFormat.formatCellValue(cell);
                    System.out.println(data);


                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        getAllData();
    }

}
