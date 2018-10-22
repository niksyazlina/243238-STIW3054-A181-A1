package myAssignment;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.xml.bind.Element;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class writeExcel {
    public void keepData()
    {
        readData readData = new readData();
        try{

            final String[] name = {"TITLE","INFO"};

            readData ReadData = new readData();
            HSSFWorkbook book = new HSSFWorkbook();
            HSSFSheet sheet = book.createSheet("Trivia");

            //Row rh = sheet.createRow(0);
            //rh.createCell(0).setCellValue("No.");
            //rh.createCell(0).setCellValue("Info 1");
            //rh.createCell(0).setCellValue("Info 2");

            //for(int a=1;a<4;a++)
            //{
            CellStyle style = book.createCellStyle();
            Font font = book.createFont();

            font.setBold(true);
            font.setFontName(HSSFFont.FONT_ARIAL);
            font.setFontHeightInPoints((short)12);
            style.setFont(font);
            style.setVerticalAlignment(VerticalAlignment.CENTER);
            //rh.getCell(a).setCellStyle(style);
            //}

            Row row = sheet.createRow(0);

            for(int x=0;x<name.length;x++){
                Cell cell = row.createCell(x);
                cell.setCellValue(name[x]);
                cell.setCellStyle(style);
            }

            int w=1;
            for (Table data : readData.getData()){

                Row rows = sheet.createRow(w);

                //Cell rowID = row.createCell(0);
                //rowID.setCellValue(data.getNum());


                Cell cell = row.createCell(0);
                cell.setCellValue(data.getInfo1());

                Cell cells = row.createCell(1);
                cells.setCellValue(data.getInfo2());
                w++;
            }

            for(int a=0;a<=24;a++)
                sheet.autoSizeColumn(a);

            FileOutputStream save = new FileOutputStream(new File("Trivia.xlsx"));
            book.write(save);
            save.flush();
            save.close();
            book.close();

        }catch (Exception e){
            System.out.print(e.getStackTrace());
        }
    }
}


    /*public static void writeExcel(){
        try {
            readData readData = new readData();

            XSSFWorkbook excel = new XSSFWorkbook(); //blank workbook
            XSSFSheet sheet = excel.createSheet("Trivia"); //blank sheet

            int i=0;
                for (Table info : readData.ReadData()) {
                    Row row = sheet.createRow(i);
                    Cell cellA = row.createCell(0);
                    cellA.setCellValue(info.getList());

                    Cell cellB = row.createCell(1);
                    cellB.setCellValue(info.getInfo());
                    i++;

                }

            for (int x=0;x<2;x++)
                sheet.autoSizeColumn(x);

            FileOutputStream fileOut = new FileOutputStream(new File("Trivia.xlsx"));
            excel.write(fileOut);
            fileOut.flush();
            fileOut.close();
            excel.close();

            System.out.println("\nTrivia.xlsx successfully");

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void openExcel() {
        System.out.print("\nOpen excel...");
            try {
                Desktop.getDesktop().open(new File("Trivia.xlsx"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/

