package bingo;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.IElement;
import com.itextpdf.layout.element.Table;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 14:45 - 15:55
 */
public class Bingo {

    public static final String DEST = "./simple_table.pdf";
    public static final int SIZE = 4;
    public static final int BOARDS = 4;

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File(DEST);
        file.getParentFile().mkdirs();
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(DEST));
        Document doc = new Document(pdfDoc);
        
        Table outer = new Table(2);
        outer.useAllAvailableWidth();
        
        for(int i = 0; i < BOARDS; i++)
        {
            BingoBoard bb = new BingoBoard(SIZE, doc);
            outer.addCell(bb.table);
        }
        
        for (IElement iElement : outer.getChildren()) {
            ((Cell)iElement).setBorder(Border.NO_BORDER);
            ((Cell)iElement).setPaddingTop(30);
        }
        doc.add(outer);
        
        doc.close();
    }
}
