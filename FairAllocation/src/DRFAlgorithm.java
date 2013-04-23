import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import lpsolve.*;

public class DRFAlgorithm {
	
	static double x[][]=new double[100][100];
	static Object data[][]=new Object[50][100];
	public ArrayList<Double> runDRF(ArrayList<DemandModel> demandVector,int total_resource,int iteration )
	{
		ArrayList<Double> allocationVector = new ArrayList<Double>();
		int k = demandVector.size();
		double row[] = solveLP(x, k, total_resource, demandVector);
		for(int i=1;i<=k;i++)
		{
			x[i][k]=row[i-1];
			
		}
		System.out.println();
		for(int i=1;i<=k;i++)
		{	
			allocationVector.add((x[i][k]*demandVector.get(i-1).demand_for_resource/k));
			System.out.println("demand of"+i+"th agent"+demandVector.get(i-1).getDemand_for_resource());
			System.out.println("allocation of"+i+"th agent at "+k+"th iteration:"+allocationVector.get(i-1));
		}
		
		return allocationVector;
	}
	
	
	public static double[] solveLP(double x[][],int k,int total_resource,ArrayList<DemandModel> demandVector)
	{	
		LpSolve lp;
		double[] row = new double[k+1];
        int ret=0;
		try
		{
		 lp = LpSolve.makeLp(0, k+1);
         for(int i=1;i<k;i++)
         {
           int [] coef = new int[k+1];
           for(int j=0;j<=k;j++)
        	   coef[j]=0;
           coef[i-1]=1;
           String cons="";
           for(int j=0;j<=k;j++)
        	   cons+=coef[j]+" ";
           
           cons=cons.substring(0,cons.length()-1);
           
        
        	 
           lp.strAddConstraint(cons, LpSolve.GE, x[i][k-1]);
         }
         
         for(int i=1;i<=k;i++)
         {
        	 String cons="";
             for(int j=1;j<=k+1;j++)
             {  
            	 if(j==k+1)
            		 cons+=-1+" ";
            	 else if(i==j)
            		 cons+= 1+" ";
            	 else
            		 cons+= 0+" ";
             }
           
           cons=cons.substring(0,cons.length()-1);
          
        	 
           lp.strAddConstraint(cons, LpSolve.GE, 0);
           
         }
         
         //lp.strAddConstraint("0 0 1 0", LpSolve.GE,((double)k/total_resource) );
         
        String cons="";
         for(int i=1;i<=k+1;i++)
         {  
        	 if(i==k+1)
        		 cons+=0+" ";
        	 else
        		 cons+= demandVector.get(i-1).demand_for_resource+" ";
         }
        
         cons=cons.substring(0,cons.length()-1);
       
         lp.strAddConstraint(cons, LpSolve.LE, ((double)k/(double)total_resource));
         for(int i=1;i<=k;i++)
         {
        	 cons+="0"+" ";
         }
         cons=cons.substring(0,cons.length()-1);
         cons="";
         for(int i=1;i<=k+1;i++)
         {  
        	 if(i==k+1)
        		 cons+=1+" ";
        	 else
        		 cons+= 0+" ";
         }
         lp.setMaxim();
       
         lp.strSetObjFn(cons);
         lp.writeLp("model.lp");
         ret = lp.solve();
         if(ret == LpSolve.OPTIMAL)
           ret = 0;
         else
           ret = 5;
         
         if(ret == 0) {
         
             /* variable values */
             lp.getVariables(row);
             //for(int j = 0; j < k; j++)
               //System.out.println(lp.getColName(j + 1) + ": " + row[j]);
              
           }
         
		}
		catch(Exception ex)
		{	
		  ex.printStackTrace();
		}
		
		return row;
	}
	
	public static void main(String[] args) {
		int max_agents=40;
		int total_resources=1;//scaled down to 1
		Random generator = new Random();
		ArrayList<DemandModel> demandVector=new ArrayList<DemandModel>();
		ArrayList<Double> demand = new ArrayList<Double>();
		ArrayList<Double> firstfit = new ArrayList<Double>();
		
		demandVector.add(new DemandModel(1,0.02173913));
		demandVector.add(new DemandModel(2,0.026086957));
		demandVector.add(new DemandModel(3,0.030434783));
		demandVector.add(new DemandModel(4,0.02826087));
		demandVector.add(new DemandModel(5,0.023913043));
		demandVector.add(new DemandModel(6,0.026086957));
		demandVector.add(new DemandModel(7,0.02173913));
		demandVector.add(new DemandModel(8,0.02826087));
		demandVector.add(new DemandModel(9,0.030434783));
		demandVector.add(new DemandModel(10,0.02173913));
		demandVector.add(new DemandModel(11,0.026086957));
		demandVector.add(new DemandModel(12,0.030434783));
		demandVector.add(new DemandModel(13,0.02826087));
		demandVector.add(new DemandModel(14,0.023913043));
		demandVector.add(new DemandModel(15,0.026086957));
		demandVector.add(new DemandModel(16,0.02173913));
		demandVector.add(new DemandModel(17,0.02826087));
		demandVector.add(new DemandModel(18,0.030434783));
		demandVector.add(new DemandModel(19,0.02173913));
		demandVector.add(new DemandModel(20,0.026086957));
		demandVector.add(new DemandModel(21,0.030434783));
		demandVector.add(new DemandModel(22,0.02826087));
		demandVector.add(new DemandModel(23,0.023913043));
		demandVector.add(new DemandModel(24,0.026086957));
		demandVector.add(new DemandModel(25,0.02173913));
		demandVector.add(new DemandModel(26,0.02826087));
		demandVector.add(new DemandModel(27,0.030434783));
		demandVector.add(new DemandModel(28,0.02173913));
		demandVector.add(new DemandModel(29,0.026086957));
		demandVector.add(new DemandModel(30,0.030434783));
		demandVector.add(new DemandModel(31,0.02826087));
		demandVector.add(new DemandModel(32,0.023913043));
		demandVector.add(new DemandModel(33,0.026086957));
		demandVector.add(new DemandModel(34,0.02173913));
		demandVector.add(new DemandModel(35,0.030434783));
		demandVector.add(new DemandModel(36,0.02173913));
		demandVector.add(new DemandModel(37,0.027173913));
		demandVector.add(new DemandModel(38,0.02173913));
		demandVector.add(new DemandModel(39,0.026086957));
		demandVector.add(new DemandModel(40,0.02173913));
		
		for(int l=0;l<40;l++){
			demand.add(demandVector.get(l).getDemand_for_resource());
		}
		
		
		//First fit implementation
		double res_remaining = 2285.0;
		
		
			
			if((demand.get(0)*2285.0)<res_remaining)
			{
				firstfit.add(demand.get(0));
				res_remaining =  res_remaining - demand.get(0)*2285.0 ;
			}
			else
			{
				firstfit.add(0.0);
			}
		
		
		x[1][1]=1;
		System.out.println("demand of"+1+"th agent"+demandVector.get(0).getDemand_for_resource());
		System.out.println("allocation of"+1+"th agent at "+1+"th iteration:"+(x[1][1]*demandVector.get(0).demand_for_resource/1));
		
		/*data[0][0]=1;
		data[0][1]=demandVector.get(0).getDemand_for_resource()*2285.0;
		data[0][2]=(x[1][1]*demandVector.get(0).demand_for_resource*2285.0);*/
		for(int i=3;i<11;i++)
		{
			//data[0][i]=" ";
		}
		ArrayList<Double> allocation=null;
		for(int i=2;i<=max_agents;i++){			
			
			//first fit
			
			if((demand.get(i-1)*2285.0)<res_remaining)
			{
				firstfit.add(demand.get(i-1));
				res_remaining =  res_remaining - demand.get(i-1)*2285.0 ;
			}
			else
			{
				firstfit.add(0.0);
			}
			
			//end first fit
			
			//demandVector.add(new DemandModel(i,generator.nextDouble()));
			//demand.add(demandVector.get(i-1).getDemand_for_resource());
			
			allocation=new DRFAlgorithm().runDRF(demandVector,total_resources,i);
			System.out.println("firstfit size:"+firstfit.size()+"fair allocation size:"+allocation.size());
			//new GenerateBarChart().generateChart(i,allocation, firstfit, demand);
		    data[i-2][0]=i;
			int k=1;
		    for(int j=0;j<i;j++)
		    {
		    	data[i-2][k++]=(int)(demandVector.get(j).getDemand_for_resource()*23000.0);
		    	data[i-2][k++]=(int)(allocation.get(j)*23000.0);
		    	System.out.println("data:"+data[i-2][k-1]);
		    }
		   
		    for(int j=k;j<11;j++)
		    {
		    	data[i-2][j]=" ";
		    }
		   
			
		}
		
		
		 new TableExample(data);
	}
}
