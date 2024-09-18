import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import static org.openqa.selenium.devtools.v85.runtime.model.PropertyPreview.Subtype.DATE;
import static org.openqa.selenium.remote.http.FormEncodedData.getData;

public class excelReader {

    @Test
    public void testDataFromExcelAsList() throws IOException {
        ArrayList<String> al=getData("LogoutPage");
        al.forEach(System.out::println);

    }

    @Test
    public void testDataFromExcelAsMap(){

    }

    //Identify Testcases coloum by scanning the entire 1st row
//once coloumn is identified then scan entire testcase coloum to identify purcjhase testcase row
//after you grab purchase testcase row = pull all the data of that row and feed into test

    public static Map<String, List<String>> getDataByMap(String testcaseName) throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Personal\\RS_P1\\resource\\demoData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);     //creating a Sheet object to retrieve object
        Iterator<Row> itr = sheet.iterator();

        Map<String, List<String>> map=new HashMap<>();
        if (itr.hasNext()) {
            Row row = itr.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                map.put(getCellValue(cell), new ArrayList<>());
            }
        }
        Iterator<List<String>> columnsIterator;
        while (itr.hasNext()) {

            // get the list iterator every row to start from first list
            columnsIterator = map.values().iterator();
            Row row = itr.next();
            Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                // here don't check hasNext() because if the file not contains problems
                // the # of columns is same as # of headers
                columnsIterator.next().add(getCellValue(cell));
            }
        }
        return map;
     }

    public static String getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:    //field that represents string cell type
                return cell.getStringCellValue() + "\t\t\t";
            case NUMERIC:    //field that represents number cell type
                return cell.getNumericCellValue() + "\t\t\t";
            case BOOLEAN:
                return cell.getBooleanCellValue()+ "\t\t\t";
            default:
                return "";
        }
    }

    public static ArrayList<String> getData(String testcaseName) throws IOException {
//fileInputStream argument
        ArrayList<String> a = new ArrayList<String>();

        FileInputStream fis = new FileInputStream("C:\\Personal\\RS_P1\\resource\\demoData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int sheets = workbook.getNumberOfSheets();
        for (int i = 0; i < sheets; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
                XSSFSheet sheet = workbook.getSheetAt(i);
//Identify Testcases coloum by scanning the entire 1st row

                Iterator<Row> rows = sheet.iterator();// sheet is collection of rows
                Row firstrow = rows.next();
                Iterator<Cell> ce = firstrow.cellIterator();//row is collection of cells
                int k = 0;
                int coloumn = 0;
                while (ce.hasNext()) {
                    Cell value = ce.next();

                    if (value.getStringCellValue().equalsIgnoreCase("Login")) {
                        coloumn = k;

                    }

                    k++;
                }
                System.out.println(coloumn);

////once coloumn is identified then scan entire testcase coloum to identify purcjhase testcase row
                while (rows.hasNext()) {

                    Row r = rows.next();

                    if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcaseName)) {

////after you grab purchase testcase row = pull all the data of that row and feed into test

                        Iterator<Cell> cv = r.cellIterator();
                        while (cv.hasNext()) {
                            Cell c = cv.next();
                            if (c.getCellType() == CellType.STRING) {

                                a.add(c.getStringCellValue());
                            } else {

                                a.add(NumberToTextConverter.toText(c.getNumericCellValue()));

                            }
                        }
                    }


                }


            }
        }
        return a;
    }
    }
