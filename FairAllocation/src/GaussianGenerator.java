import java.util.Random;

import javax.sound.sampled.Line;


public class GaussianGenerator {

	
	public static double[] generateGaussian(int no_of_samples,double mean,double variance)
	{
		Random r=new Random();
		double d[]=new double[no_of_samples];
		for(int i=0;i<no_of_samples;i++)
		{
			d[i]=mean + r.nextGaussian()*variance;
		    	
		}
		return d;
		
	}
	
	public static void main(String[] args) {
	
		double d1[];
	      d1=GaussianGenerator.generateGaussian(1000,0.0,Math.sqrt(1));
		
	      Histrogram.generateChart(d1,"Gaussian distribution with mean 0 and variance 1");
		
		d1=GaussianGenerator.generateGaussian(1000,0.0,Math.sqrt(0.5));
		
		Histrogram.generateChart(d1,"Gaussian distribution with mean 0 and variance 0.5");
		
		d1=GaussianGenerator.generateGaussian(1000,0.0,Math.sqrt(0.1));
		
		Histrogram.generateChart(d1,"Gaussian distribution with mean 0 and variance 0.1");
		
		d1=GaussianGenerator.generateGaussian(1000,0.0,Math.sqrt(2));
		
		Histrogram.generateChart(d1,"Gaussian distribution with mean 0 and variance 2");
		
		
		
		
	}
	
	
}


