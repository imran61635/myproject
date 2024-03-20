package utils;

public class ExcelUtils {
	public static ExcelReader excel;


	public static Object[][] getData(String mysheetName){
		
		 if(excel == null){
				// load the Excel sheet
				
			
			 excel = new ExcelReader("./src/test/resources/InputFiles/testdata.xlsx");
					
			}
			String sheetName= mysheetName;
			int rows = excel.getRowCount(sheetName);  // Get Row Count
			int cols = excel.getColumnCount(sheetName);  // Get Col Count
			Object data[][] = new Object[rows-1][cols]; //-1
			
			for(int rowNum = 2 ; rowNum <= rows ; rowNum++){ //2
				
				for(int colNum=0 ; colNum< cols; colNum++){
					data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum); //-2
				}
			}
		
		return data;
}
}
