import java.awt.Point;
import java.util.*;
import javafx.application.Application;
import javafx.stage.Stage; 



public class pool 
{

	public static void main(String[] args) 
	{
		ArrayList<Double> x = new ArrayList<Double>(); 
		ArrayList<Double> y = new ArrayList<Double>(); 
		
		Scanner scan = new Scanner(System.in); 
		Random rand = new Random(); 
		
//								//Get starting location
//								System.out.println("Enter starting position in x dimension (min 0, max 8)> ");
//								double x0 = scan.nextDouble(); 
//								while (x0 <0 || x0 >8 )
//								{
//									System.out.println("you messed up - enter value between 0 and 8 >");
//									x0 = scan.nextDouble();
//								}
//								x.add(x0);
//								
//								System.out.println("Enter starting position in y dimension > ");
//								double y0 = scan.nextDouble(); 
//								while(y0 <0 || y0 > 4)
//								{
//									System.out.println("you messed up - enter value between 0 and 4 >");
//									y0 = scan.nextDouble();
//								}
//								y.add(y0);
//		
//		//Get aim point - must be a rail 
//		System.out.println("Enter aim point x coord (x or y must be a rail)> ");
//		double x1 = scan.nextDouble(); 
//		
//		System.out.println("\nEnter aim point y coord > ");
//		double y1 = scan.nextDouble(); 
//		
//		while (x1 != 0 && x1 != 8 && y1 != 0 && y1 != 8 || (x1 <0 || x1 >8 || y1 <0 || y1 >4))
//		{
//			System.out.println("You messed up: aim for rail - requires x = 0 or 8 OR y = 0 or 4");
//			System.out.println("Also requires that x val is between 0 and 8 and y value is between 0 and 4");
//			System.out.println("Enter aim point x coord > ");
//			x1 = scan.nextDouble(); 
//			
//			System.out.println("\nEnter aim point y coord > ");
//			y1 = scan.nextDouble();
//		}
		
		double x0 = Math.round(8*rand.nextDouble()*4)/4.0;
		double x1 = Math.round(8*rand.nextDouble()*4)/4.0;
		double y0 = Math.round(4*rand.nextDouble()*4)/4.0;
		double y1 = Math.round(4*rand.nextDouble()*4)/4.0;
		
		while (x1 != 0 && x1 != 8 && y1 != 0 && y1 != 8 || (x1 <0 || x1 >8 || y1 <0 || y1 >4))
		{
			x0 = Math.round(8*rand.nextDouble()*4)/4.0;
			x1 = Math.round(8*rand.nextDouble()*4)/4.0;
			y0 = Math.round(4*rand.nextDouble()*4)/4.0;
			y1 = Math.round(4*rand.nextDouble()*4)/4.0;
		}
		
//		x0 = 0.75;
//		y0 = 0.5;
//		x1 = 8; 
//		y1 = 1.5;
		
//		System.out.println("(x0, y0):\t" + "(" +x0+", "+y0+")");
//		System.out.println("(x1, y1):\t" + "("+x1+", "+y1+")");
		
//		System.out.println("x0: \t" +x0+"\n"+
//							"x1: \t" +x1+"\n"+
//							"y0: \t" +y0+ "\n"+
//							"y1: \t" +y1);
		
		ArrayList<Double> deltaX= new ArrayList<Double>();
		ArrayList<Double> deltaY= new ArrayList<Double>();
		
		deltaX.add(Math.abs(x1-x0));
//		System.out.println("deltaX: \t"+deltaX.get(0));
		deltaY.add(Math.abs(y1-y0));
//		System.out.println("deltaY: \t"+deltaY.get(0));
		
		ArrayList<Double> incidentAngle = new ArrayList<Double>(); 
		double theta0 = Math.toDegrees(Math.atan(deltaX.get(0)/deltaY.get(0)));
		incidentAngle.add(theta0);
		
		
		System.out.println("Incident angle:\t"+ Math.round(theta0) + " degrees\n");
		ArrayList<Double> emergingAngle = new ArrayList<Double>(); 
		emergingAngle.add(incidentAngle.get(0));
	
		
		
		
		
		
		//case 1: (y2 = 4) - ball will end up at TOP rail 
		double y2 = 4; 
		double deltax0 = Math.abs(y2-y1)*Math.atan(Math.toRadians(emergingAngle.get(0)));
//		System.out.println("Change in x: \t" +Math.round(deltax0*4)/4.0);
		double x2 = x1 + deltax0;  
//		System.out.println("Final x position: \t" +x2);
		
		if (x2 < 0 || x2 > 8)
		{
			//case 2: (x2 = 8) ball will end up at RIGHT rail
			x2 = 8;
			double deltay0 = Math.abs(x2 - x1)/(Math.tan(Math.toRadians(emergingAngle.get(0))));
			deltaY.add(deltay0);
//			System.out.println("Change in y:\t"+Math.round(deltay0*4)/4.0);
			y2 = y1 + deltaY.get(0);
//			System.out.println("Final y position: \t"+y2);
			
			if (deltay0 == 0)
			{
				System.out.println("ERROR: there was no movement in the y direction  ...\n\n");
				//case4: (x2 = 0) - ball will end up at LEFT rail
//				System.out.println("Emerging angle:\t" +Math.round(emergingAngle.get(0)));
				x2 = 0;
				deltay0 = Math.abs(x2 - x1)/(Math.tan(Math.toRadians(emergingAngle.get(0))));
				deltaY.add(deltay0);
//				System.out.println("Change in y:\t"+Math.round(deltay0*4)/4.0);
				y2 = y1 + deltaY.get(0);
//				System.out.println("Final y position: \t"+y2);
			}
			
		}
		
		
		
		System.out.println("\nStarting position: \t" +"(" +x0+","+y0+")");
		System.out.println("Aim point: \t\t" +"(" +x1+","+y1+")");
		System.out.println("Ending position: \t" +"(" +Math.round(x2*4)/4.0+","+y2+")");
		
		//case 3: (y2 = 0) bottom rail
		//y2 = 0; 
		
		
		
		
								//2 RAIL PREDICTION 
								System.out.println("\n\n2 rail kick time:");
		
								deltaX.add(Math.abs(x2-x1));
						//		System.out.println("deltaX: \t"+deltaX.get(0));
								deltaY.add(Math.abs(y2-y1));
						//		System.out.println("deltaY: \t"+deltaY.get(0));
								
								 
								double theta1 = Math.toDegrees(Math.atan(deltaX.get(1)/deltaY.get(1)));
								incidentAngle.add(theta1);
								
								
								System.out.println("Incident angle:\t"+ Math.round(theta1) + " degrees\n");
								emergingAngle.add(incidentAngle.get(1));
								//case 1: (y2 = 4) - ball will end up at TOP rail 
								double y3 = 4; 
								double deltax2 = Math.abs(y3-y2)*Math.atan(Math.toRadians(emergingAngle.get(1)));
						//		System.out.println("Change in x: \t" +Math.round(deltax0*4)/4.0);
								double x3 = x2 + deltax2;  
						//		System.out.println("Final x position: \t" +x2);
								
								if (x3 < 0 || x3 > 8)
								{
									//case 2: (x2 = 8) ball will end up at RIGHT rail
									x3 = 8;
									double deltay1 = Math.abs(x3 - x2)/(Math.tan(Math.toRadians(emergingAngle.get(1))));
									deltaY.add(deltay1);
						//			System.out.println("Change in y:\t"+Math.round(deltay0*4)/4.0);
									y3 = y2 + deltaY.get(1);
						//			System.out.println("Final y position: \t"+y2);
									
									if (deltay1 == 0)
									{
										System.out.println("ERROR: there was no movement in the y direction  ...\n\n");
										//case4: (x2 = 0) - ball will end up at LEFT rail
						//				System.out.println("Emerging angle:\t" +Math.round(emergingAngle.get(0)));
										x3 = 0;
										deltay1 = Math.abs(x3 - x2)/(Math.tan(Math.toRadians(emergingAngle.get(1))));
										deltaY.add(deltay1);
						//				System.out.println("Change in y:\t"+Math.round(deltay0*4)/4.0);
										y3 = y2 + deltaY.get(1);
						//				System.out.println("Final y position: \t"+y2);
									}
									
								}
								
								
								
								System.out.println("\nStarting position: \t" +"(" +x1+","+y1+")");
								System.out.println("Aim point: \t\t" +"(" +x2+","+y2+")");
								System.out.println("Ending position: \t" +"(" +Math.round(x3*4)/4.0+","+Math.round(y3*4)/4.0+")");
		
		
//		case 4: (x3 = 0) left rail
//		System.out.println("Emerging angle:\t" +Math.round(emergingAngle.get(0)));
//		x2 = 0;
//		deltay0 = Math.abs(x2 - x1)/(Math.tan(Math.toRadians(emergingAngle.get(0))));
//		deltaY.add(deltay0);
//		System.out.println("Change in y:\t"+Math.round(deltay0*4)/4.0);
//		y2 = y1 + deltaY.get(0);
//		System.out.println("Final y position: \t"+y2);
		
		
//		//make arrays of possible x and y values - increments go in 1/4 diamonds
//		ArrayList<Double> xValsPossible = new ArrayList<Double>();
//		ArrayList<Double> yValsPossible = new ArrayList<Double>();
//		
//		double xmin = 0; 
//		double xmax = 8; 
//		double ymin = 0; 
//		double ymax = 4; 
//		
//		for (double xcounter = 0; xcounter <=8; xcounter = xcounter + 0.25)
//		{
//			xValsPossible.add(xcounter);
//		}
//		
//		for (double ycounter = 0; ycounter <=4; ycounter = ycounter + 0.25)
//		{
//			yValsPossible.add(ycounter);
//		}
		
		
		
//								
//								for(int ix = 0; ix<xValsPossible.size(); ix++)
//								{
//									for (int iy = 0; iy<yValsPossible.size(); iy++)
//									{
//										System.out.println(xValsPossible.get(ix)+"\t"+yValsPossible.get(iy));
//									}
//								}
//		ArrayList<Point> arrayOfPossiblePoints = new ArrayList<Point>(); 
//		
//		for(int ix = 0; ix<xValsPossible.size(); ix++)
//		{
//			for (int iy = 0; iy<yValsPossible.size(); iy++)
//			{
//				arrayOfPossiblePoints.add(new Point(xValsPossible.get(ix), yValsPossible.get(iy)));
//			}
//		}
		
		}
}
