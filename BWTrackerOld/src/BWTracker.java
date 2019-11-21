import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class BWTracker {
	
	private static final String FILE_NAME 
		= System.getProperty("user.home").concat("\\Desktop\\BWTracker.xlsx");

	public static void main(String[] args) {
		try {

            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet0 = workbook.getSheetAt(0);
            Iterator<Row> iterator = sheet0.iterator();
            //System.out.println(sheet0.column);
            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                System.out.println(currentRow.getCell(8).getColumnIndex());
                
                while (cellIterator.hasNext()) {

                	
                    Cell currentCell = cellIterator.next();
                    
                    System.out.println(currentRow.getRowNum() + " ah" + currentCell.getColumnIndex());
                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
                        System.out.println(currentCell.getStringCellValue() + "-X-");
                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                        System.out.println(currentCell.getNumericCellValue() + "-0-");
                    }

                }
                System.out.println();

            }
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static int getLastDataCellOfColumn(Sheet asheet, int acolumn){
		Iterator<Row> iterator = asheet.iterator();
        while (iterator.hasNext()) {
            Row currentRow = iterator.next();
        }
		return 0;
	}

}
