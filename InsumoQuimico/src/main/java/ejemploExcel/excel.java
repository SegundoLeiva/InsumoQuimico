package ejemploExcel;
import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;



public class excel {

	public static void main(String[] args) throws IOException, BiffException, WriteException {
		// TODO Auto-generated method stub
				
		
		for (int z = 1; z <= 77; z++) {
			String archivoCrear = "LOTE"+String.format("%04d", z);
			String archivoAlfresco = "LOTE-ARCA"+String.format("%04d", z);
			Workbook workbook = Workbook.getWorkbook(new File("E:\\ARCATA_OBREROS.xls"));
			
			int numero =  obtenerNumero(workbook,archivoCrear);
//			WritableWorkbook workbook2 = Workbook.createWorkbook(new File("C:\\Users\\segundo.leiva\\Desktop\\Alfresco\\ARCATA_OBREROS\\"+archivoCrear+"_O-"+numero+".xls"));
//			WritableSheet hoja = workbook2.createSheet("Sheet1", 0);
			String jjj = archivoCrear+"_O-"+numero+".xls";
			System.out.print("java -jar cargaMetadatosCMIS.jar \"10.30.44.23:8080\" \"admin\" \"admin\"  \"ARCATA_OBREROS/"+jjj+"\" \"ARCATA_OBREROS/SALIDA"+z+".xls\" \"hmplc:planilla\" "+numero+" 4 \"/Sites/hochschild-mining/documentLibrary/Recursos_Humanos/Planillas_Digitalizadas/Arcata/Obreros/"+archivoAlfresco+"\" \n");	

			Sheet sheet = workbook.getSheet(0);
			
		    Cell cell1;
		   
		    
		    int fila = sheet.getRows();
		    int k = 0;
		    for (int i = 0; i < fila; i++) {

				if(sheet.getCell(0, i).getContents().contains(archivoCrear)){
					
					for (int j = 0; j < 8; j++) {
						cell1 = sheet.getCell(j, i);
						
//						hoja.addCell(new jxl.write.Label(1, 4, "N°"));
//						hoja.addCell(new jxl.write.Label(2, 4, "NOMBRE"));
//						hoja.addCell(new jxl.write.Label(3, 4, "TITULO"));
//						hoja.addCell(new jxl.write.Label(4, 4, "DESCRIPCION"));
//						hoja.addCell(new jxl.write.Label(5, 4, "TIPO MIME"));
//						hoja.addCell(new jxl.write.Label(6, 4, "TIPO DE PLANILLA"));
//						hoja.addCell(new jxl.write.Label(7, 4, "COMPAÑÍA"));
//						hoja.addCell(new jxl.write.Label(8, 4, "MES"));
//						hoja.addCell(new jxl.write.Label(9, 4, "AÑO"));
//						
//						
//						
//						hoja.addCell(new jxl.write.Label(2, 5, "cm:name"));
//						hoja.addCell(new jxl.write.Label(6, 5, "hmplc:tipoPlanilla"));
//						hoja.addCell(new jxl.write.Label(7, 5, "hmplc:companhia"));
//						hoja.addCell(new jxl.write.Label(8, 5, "hmplc:mes"));
//						hoja.addCell(new jxl.write.Label(9, 5, "hmplc:anho"));
//						
//						hoja.addCell(new jxl.write.Label(2, 6, "text"));
//						hoja.addCell(new jxl.write.Label(6, 6, "text"));
//						hoja.addCell(new jxl.write.Label(7, 6, "text"));
//						hoja.addCell(new jxl.write.Label(8, 6, "text"));
//						hoja.addCell(new jxl.write.Label(9, 6, "text"));
//						
//						hoja.addCell(new jxl.write.Label(j+2, k+7, cell1.getContents()));
//						hoja.addCell(new jxl.write.Number(1, k+7, k+1));

					}
					k++;
				}
				
			}
//		    workbook2.write();
//		    workbook2.close();
			workbook.close();
		}
		

		System.out.print("FIN");
	}
	
	public static int  obtenerNumero(Workbook workbook,String archivoCrear){
Sheet sheet = workbook.getSheet(0);

	    
	    int fila = sheet.getRows();
	    int rpta = 0;
	    int k = 0;
	    for (int i = 0; i < fila; i++) {

			if(sheet.getCell(0, i).getContents().contains(archivoCrear)){
				
					k++;
			
			}
		}
		return k;
	}
}
