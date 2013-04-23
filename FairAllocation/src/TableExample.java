import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.DefaultCellEditor;

public class TableExample {


   
    Object [][]data;
    String[] columnNames = {"Iterations", "Demand1", "Allocation1", "Demand2", "Allocation2", "Demand3", "Allocation3","Demand4","Allocation4","Demand5","Allocation5","Demand6","Allocation6","Demand7","Allocation7","Demand8","Allocation8","Demand9","Allocation9","Demand10","Allocation10","Demand11","Allocation11","Demand12","Allocation12","Demand13","Allocation13","Demand14","Allocation14","Demand15","Allocation15","Demand16","Allocation16","Demand17","Allocation17","Demand18","Allocation18","Demand19","Allocation19","Demand20","Allocation20","Demand21","Allocation21","Demand22","Allocation22","Demand23","Allocation23","Demand24","Allocation24","Demand25","Allocation25","Demand26","Allocation26","Demand27","Allocation27","Demand28","Allocation28","Demand29","Allocation29","Demand30","Allocation30","Demand31","Allocation31","Demand32","Allocation32","Demand33","Allocation33","Demand34","Allocation34","Demand35","Allocation35","Demand36","Allocation36","Demand37","Alloction37","Demand38","Allocation38","Demand39","Allocation39","Demand40","Allocation40"};
    public TableExample(Object [][]data)
    {
    	this.data=data;
    	
    	
    	JFrame guiFrame = new JFrame();
    	JScrollPane jsp = new JScrollPane();
        
        //make sure the program exits when the frame closes
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("40 Agents allocation matrix");
        guiFrame.setSize(3000,400);
        guiFrame.add(jsp);
        
      
        //This will center the JFrame in the middle of the screen
        guiFrame.setLocationRelativeTo(null);
        
        //Create the JTable using the ExampleTableModel implementing 
        //the AbstractTableModel abstract class
        JTable table = new JTable(data,columnNames);
        JTableHeader header = table.getTableHeader();
        //Set the column sorting functionality on
        table.setAutoCreateRowSorter(true);
        
       
        table.setGridColor(Color.YELLOW);
        table.setBackground(Color.CYAN);
        
        //String array to populate the combobox options
     
        
        
        //Place the JTable object in a JScrollPane for a scrolling table
        JScrollPane tableScrollPane = new JScrollPane(table);
        
        guiFrame.add(tableScrollPane);
        guiFrame.setVisible(true);
        
    }
    
    //implement a table model by extending a class to use
    //the AbstractTableModel
    
    
}
