import java.util.ArrayList;
import java.util.List;

public class Slot {
    private static int row;
    private static int col;
    private static int value;
    private static boolean isDefault;

    public Slot(){
        System.out.println("row" + row );
        System.out.println("col" + col );
        System.out.println("value" + value );
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setValue(int value) {
        this.value = value;
        if(value==0) isDefault =false;
        isDefault =true;
    }

    public int getValue() {
        return value;
    }


    @Override
    public String toString() {
        return "Slot{" +
                "row=" + row +
                ", col=" + col +
                ", value=" + value +
                ", isDefault=" + isDefault +
                '}';
    }
}
