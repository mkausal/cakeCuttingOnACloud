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
    String[] columnNames = {"Iterations", "Demand1", "Allocation1", "Demand2", "Allocation2", "Demand3", "Allocation3","Demand4","Allocation4","Demand5","Allocation5"};
    public TableExample(Object [][]data)
    {
    	this.data=data;
    	
    	
    	JFrame guiFrame = new JFrame();
        
        //make sure the program exits when the frame closes
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("4 Agents allocation matrix");
        guiFrame.setSize(1000,400);
      
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
