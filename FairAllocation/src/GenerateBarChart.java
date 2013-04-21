import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class GenerateBarChart {
	
	public void generateChart(int chartNo,ArrayList<Double> fairAlloc,ArrayList<Double> firstfit,ArrayList<Double> demand)
	{
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(int i=0;i<firstfit.size();i++)
		{	
		
		dataset.setValue(demand.get(i)*2285.0, "Demand", "Agent"+i);
		dataset.setValue(firstfit.get(i)*2285.0, "FirstFit", "Agent"+i);
		dataset.setValue(fairAlloc.get(i)*2285.0, "FairAlloc", "Agent"+i);
		
		}
		// Profit1, Profit2 represent the row keys
		// Jane, Tom, Jill, etc. represent the column keys
		
		JFreeChart chart = ChartFactory.createBarChart3D( "Comparison between Allocation",
		"Agents", "CPU Allocation", dataset, PlotOrientation.VERTICAL, true, true, false );
		
		try {
			ChartUtilities.saveChartAsJPEG(new File("chart"+chartNo+".jpg"), chart, 500, 300);
			} catch (IOException e) {
			System.err.println("Problem occurred creating chart.");
			}


	}
	
	
	
	
	
	

}
