package bingo;

import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.IElement;
import com.itextpdf.layout.element.Table;

public class BingoBoard {
    
    Table table;
    int ptSize = 200;

    public BingoBoard(int size, Document doc, String[] strings) {
        table = new Table(size);
        //table.setWidth(200);
        //table.setHeight(200);
        table.setFontSize(8);

        for (int i = 0; i < size*size; i++) {
            table.addCell(strings[i]);
        }
        
        for (IElement iElement : table.getChildren()) {
            ((Cell)iElement).setHeight(ptSize / size);
            ((Cell)iElement).setWidth(ptSize / size);
            ((Cell)iElement).setMinHeight(ptSize / size);
            ((Cell)iElement).setMinWidth(ptSize / size);
        }
    }

    public Table getTable() {
        return table;
    }
    
}
