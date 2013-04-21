import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;
import org.jfree.data.xy.*;
public class Histrogram {
 
	static  JFreeChart chart;
	static int count;
	static ChartFrame frame; 
    public static void generateChart(double values[],String label) {
       HistogramDataset dataset = new HistogramDataset();
        XYSeries serie = new XYSeries("Gaussian distributuin", true, false);

        
        dataset.addSeries("Histogram",values,values.length);
        if(chart==null)
        	chart = ChartFactory.createHistogram(label, "", "Random values", dataset, PlotOrientation.VERTICAL,true,true,true);
        XYPlot plot = chart.getXYPlot();
        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
        //xAxis.setTickUnit(new NumberTickUnit(1));
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        //xAxis.setTickUnit(new NumberTickUnit(0.1));
        xAxis.setAutoRangeMinimumSize(10);
        if(frame==null)
        	 frame = new ChartFrame("Allocation", chart);
        frame.pack();
        frame.setVisible(true);
    }
}
