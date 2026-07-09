package clase;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import java.io.FileOutputStream;

public class Exportador {

    public static void exportarKardexAExcel(JTable tablaCompras, JTable tablaVentas, String rutaArchivo) {
        
        try (Workbook libro = new XSSFWorkbook()) {
            
            // 1. Creamos la "paleta de colores" y estilos (SE HACE UNA SOLA VEZ)
            CellStyle estiloCabecera = crearEstiloCabecera(libro);
            CellStyle estiloDatos = crearEstiloDatos(libro);

            // 2. Creamos las pestañas
            Sheet hojaCompras = libro.createSheet("Historial Compras");
            Sheet hojaVentas = libro.createSheet("Historial Ventas");

            // 3. Llenamos y damos formato a cada pestaña
            llenarHojaConTabla(hojaCompras, tablaCompras, estiloCabecera, estiloDatos);
            llenarHojaConTabla(hojaVentas, tablaVentas, estiloCabecera, estiloDatos);

            // 4. Guardamos el archivo
            try (FileOutputStream archivo = new FileOutputStream(rutaArchivo)) {
                libro.write(archivo);
            }
            
            JOptionPane.showMessageDialog(null, "¡Reporte exportado con formato visual correctamente!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al exportar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // --- MÉTODO PARA DISEÑAR LA CABECERA ---
    private static CellStyle crearEstiloCabecera(Workbook libro) {
        CellStyle estilo = libro.createCellStyle();
        
        // Fondo Azul Claro
        estilo.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
        estilo.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        
        // Poner bordes delgados alrededor de la celda
        estilo.setBorderBottom(BorderStyle.THIN);
        estilo.setBorderTop(BorderStyle.THIN);
        estilo.setBorderLeft(BorderStyle.THIN);
        estilo.setBorderRight(BorderStyle.THIN);

        // Crear una fuente en Negrita (Bold)
        Font fuente = libro.createFont();
        fuente.setBold(true);
        estilo.setFont(fuente); // Le asignamos la fuente al estilo
        
        return estilo;
    }

    // --- MÉTODO PARA DISEÑAR LOS DATOS ---
    private static CellStyle crearEstiloDatos(Workbook libro) {
        CellStyle estilo = libro.createCellStyle();
        
        // Fondo Amarillo Claro (puedes cambiar LIGHT_YELLOW por LIGHT_TURQUOISE o CORNSILK)
        estilo.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        estilo.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        
        // Poner bordes delgados para que se vea como una cuadrícula limpia
        estilo.setBorderBottom(BorderStyle.THIN);
        estilo.setBorderTop(BorderStyle.THIN);
        estilo.setBorderLeft(BorderStyle.THIN);
        estilo.setBorderRight(BorderStyle.THIN);
        
        return estilo;
    }

    // --- MÉTODO QUE ARMA LA TABLA ---
    private static void llenarHojaConTabla(Sheet hoja, JTable tabla, CellStyle estiloCab, CellStyle estiloDat) {
        
        // 1. Extraemos las cabeceras y les aplicamos su estilo
        Row filaCabecera = hoja.createRow(0);
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            Cell celda = filaCabecera.createCell(i);
            celda.setCellValue(tabla.getColumnName(i));
            celda.setCellStyle(estiloCab); // <--- Aplicando estética
        }

        // 2. Extraemos los datos y les aplicamos su estilo
        for (int f = 0; f < tabla.getRowCount(); f++) {
            Row filaDatos = hoja.createRow(f + 1); 
            
            for (int c = 0; c < tabla.getColumnCount(); c++) {
                Cell celda = filaDatos.createCell(c);
                Object valor = tabla.getValueAt(f, c);
                
                if (valor != null) {
                    celda.setCellValue(valor.toString());
                } else {
                    celda.setCellValue("");
                }
                
                celda.setCellStyle(estiloDat); // <--- Aplicando estética
            }
        }

        // 3. MAGIA FINAL: Le decimos a Excel que estire las columnas al tamaño de los textos
        for (int c = 0; c < tabla.getColumnCount(); c++) {
            hoja.autoSizeColumn(c);
        }
    }
}