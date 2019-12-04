import java.util.Scanner; 

public class pool_again
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in );
	
		int sentinel = -1; 
		double x2; 
		double y2; 
		double x3; 
		double y3; 
		double x4; 
		double y4;
		
		
		double deltay1; 
		double deltax1; 
		
		
		double deltay2; 
		double deltax2;
		
		while(sentinel != 0)
		{
			System.out.println("\n");
			System.out.println("Enter starting x position > ");
			double x0 = scan.nextDouble(); 
			
			System.out.println("Enter starting y position > ");
			double y0 = scan.nextDouble();
			
			System.out.println("Enter aim x position > ");
			double x1 = scan.nextDouble();
			
			System.out.println("Enter aim y position > ");
			double y1 = scan.nextDouble();
			
			double deltax0 = Math.abs(x1-x0);
			double deltay0 = Math.abs(y1-y0);
			
			
		
			
			//case 1: if x0 < x1 and x1 != 8 THEN x2 will be greater than x1 (ball will travel right) 
			if (x0 < x1 && x1 !=8)
			{
				x2 = x1 + deltax0/100;
				
				if (y0 < y1) //ball will go down and right
				{
					y2 = y1 -deltay0/100;
					while (x2 <8 && y2 >0)
					{
						x2 = x2 + deltax0/100;
	//					System.out.println("Value of x2: \t" +x2);
						
						y2 = y2 - deltay0/100; 
	//					System.out.println("Value of y2: \t" +y2);
	
					}
					System.out.println("FINAL value of x2: \t" +x2);
					System.out.println("FINAL value of y2: \t" +y2);
					
					
												//TWO RAIL prediction that assumes x0 < x1 != 8 and y0< y1 
												System.out.println("\n Now for two rails:");
												//TWO RAILS
												deltax1 = Math.abs(x2-x1);
												deltay1 = Math.abs(y2-y1);
												
												//case 1a: if x1 < x2 and x2 != 8 THEN x3 will be greater than x2 (ball will travel right) 
												if (x1 < x2 && Math.abs(x2 - 8) > 0.05)
												{
													x3 = x2 + deltax1/100;
													
													if (y1 < y2) //ball will go down and right
													{
														y3 = y2 -deltay1/100;
														while (x3 <8 && y3 >0)
														{
															x3 = x3 + deltax1/100;
										//					System.out.println("Value of x2: \t" +x2);
															
															y3 = y3 - deltay1/100; 
										//					System.out.println("Value of y2: \t" +y2);
										
														}
														System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
														System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
													
														
													}
													
													else //ball will go up and right
													{
														y3 = y2 + deltay1/100; 
														while(x3 < 8 && y3 <4)
														{
															x3 = x3 + deltax1/100;
										//					System.out.println("Value of x2: \t" +x2);
															
															y3 = y3 + deltay1/100; 
										//					System.out.println("Value of y2: \t" +y2);
										
														}
														System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
														System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
														

													}
												}
												
												
												//case 2a: ball is traveling to right and "APPROXIMATELY" hits right rail  (x2 is within 0.05 diamonds of 8th diamond)- will be sent back to left
												else if (x1 < x2 && Math.abs(x2 - 8) < 0.05)
												{	
													x3 = x2 - deltax1/100;
													if (y1 < y2) //ball will go up and left
													{
														y3 = y2 +deltay1/100;
														while (x3 >0 && y3 <4)
														{
															x3 = x3 - deltax1/100;
										//					System.out.println("Value of x2: \t" +x2);
															
															y3 = y3 + deltay1/100; 
										//					System.out.println("Value of y2: \t" +y2);
										
														}
														System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
														System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
														

													}
													
													else //ball will go down and left
													{
														y3 = y2 - deltay1/100; 
														while(x3 > 0 && y3 >0)
														{
															x3 = x3 - deltax1/100;
										//					System.out.println("Value of x2: \t" +x2);
															
															y3 = y3 - deltay1/100; 
										//					System.out.println("Value of y2: \t" +y2);
														}
														System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
														System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
														

													}
												}
												
												//case 3a: if x1 > x2 and x2 != 0 THEN x2 will be greater than x1 (ball will travel left)
												//NOTE TO INTELLIGENT PEOPLE - case3a may not be a possible subset case of case 1 - here just in case ... and to increase computer workload 
												
												else if (x1 > x2 && Math.abs(x2 - 0) > 0.05)
												{
													x3 = x2 - deltax1/100;
													
													if (y1 < y2) //ball will go down and left
													{
														y3 = y2 -deltay1/100;
														while (x3 >0 && y3 >0)
														{
															x3 = x3 - deltax1/100;
										//					System.out.println("Value of x2: \t" +x2);
															
															y3 = y3 - deltay1/100; 
										//					System.out.println("Value of y2: \t" +y2);
														}
														System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
														System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
														

													}
													
													else //ball will go up and right
													{
														y3 = y2 + deltay1/100; 
														while(x3 > 0 && y3 <4)
														{
															x3 = x3 - deltax1/100;
										//					System.out.println("Value of x2: \t" +x2);
															
															y3 = y3 + deltay1/100; 
										//					System.out.println("Value of y2: \t" +y2);
														}
														System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
														System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
												
													}
												}
												
												//case 4: if x1 > x2 and x2 approximately = 0 THEN ball will hit left bank and travel right) 
												else if (x1 > x2 && Math.abs(x2 - 0) < 0.05)
												{
													x3 = x2 + deltax1/100;
														
													if (y1 < y2) //ball will go up and right
													{
														y3 = y2 +deltay1/100;
														while (x3 >0 && y3 <4)
														{
															x3 = x3 + deltax1/100;
										//					System.out.println("Value of x2: \t" +x2);
																
															y3 = y3 + deltay1/100; 
										//					System.out.println("Value of y2: \t" +y2);
														}
														System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
														System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
													}
															
													else //ball will go down and right
													{
														y3 = y2 - deltay1/100; 
														while(x3 < 8 && y3 >0)
														{
															x3 = x3 + deltax1/100;
										//					System.out.println("Value of x2: \t" +x2);
																	
															y3 = y3 - deltay1/100; 
										//					System.out.println("Value of y2: \t" +y2);
														}
														System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
														System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
													}
												}
												
												else
												{
													System.out.println("Case not handled yet - was ball shot straight into rail? ");
												}	
				}
				else // (x0 < x1 and y0 >  y1 )ball will go up and right
				{
					y2 = y1 + deltay0/100; 
					while(x2 < 8 && y2 <4)
					{
						x2 = x2 + deltax0/100;
	//					System.out.println("Value of x2: \t" +x2);
						
						y2 = y2 + deltay0/100; 
	//					System.out.println("Value of y2: \t" +y2);
					}
					
					System.out.println("FINAL value of x2: \t" +Math.round(x2*4)/4.0);
					System.out.println("FINAL value of y2: \t" +Math.round(y2*4)/4.0);
					
					 
																System.out.println("\n Now for two rails:");
																//TWO RAILS
																deltax1 = Math.abs(x2-x1);
																deltay1 = Math.abs(y2-y1);
																
																//case 1a: if x1 < x2 and x2 != 8 THEN x3 will be greater than x2 (ball will travel right) 
																if (x1 < x2 && Math.abs(x2 - 8) > 0.05)
																{
																	x3 = x2 + deltax1/100;
																	
																	if (y1 < y2) //ball will go down and right
																	{
																		y3 = y2 -deltay1/100;
																		while (x3 <8 && y3 >0)
																		{
																			x3 = x3 + deltax1/100;
														//					System.out.println("Value of x2: \t" +x2);
																			
																			y3 = y3 - deltay1/100; 
														//					System.out.println("Value of y2: \t" +y2);
														
																		}
																		System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																		System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																	}
																	
																	else //ball will go up and right
																	{
																		y3 = y2 + deltay1/100; 
																		while(x3 < 8 && y3 <4)
																		{
																			x3 = x3 + deltax1/100;
														//					System.out.println("Value of x2: \t" +x2);
																			
																			y3 = y3 + deltay1/100; 
														//					System.out.println("Value of y2: \t" +y2);
														
																		}
																		System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																		System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																	}
																}
																
																
																//case 2a: ball is traveling to right and "APPROXIMATELY" hits right rail  (x2 is within 0.05 diamonds of 8th diamond)- will be sent back to left
																else if (x1 < x2 && Math.abs(x2 - 8) < 0.05)
																{	
																	x3 = x2 - deltax1/100;
																	if (y1 < y2) //ball will go up and left
																	{
																		y3 = y2 +deltay1/100;
																		while (x3 >0 && y3 <4)
																		{
																			x3 = x3 - deltax1/100;
														//					System.out.println("Value of x2: \t" +x2);
																			
																			y3 = y3 + deltay1/100; 
														//					System.out.println("Value of y2: \t" +y2);
														
																		}
																		System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																		System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																	}
																	
																	else //ball will go down and left
																	{
																		y3 = y2 - deltay1/100; 
																		while(x3 > 0 && y3 >0)
																		{
																			x3 = x3 - deltax1/100;
														//					System.out.println("Value of x2: \t" +x2);
																			
																			y3 = y3 - deltay1/100; 
														//					System.out.println("Value of y2: \t" +y2);
																		}
																		System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																		System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																	}
																}
																
																//case 3a: if x1 > x2 and x2 != 0 THEN x2 will be greater than x1 (ball will travel left)
																//NOTE TO INTELLIGENT PEOPLE - case3a may not be a possible subset case of case 1 - here just in case ... and to increase computer workload 
																
																else if (x1 > x2 && Math.abs(x2 - 0) > 0.05)
																{
																	x3 = x2 - deltax1/100;
																	
																	if (y1 < y2) //ball will go down and left
																	{
																		y3 = y2 -deltay1/100;
																		while (x3 >0 && y3 >0)
																		{
																			x3 = x3 - deltax1/100;
														//					System.out.println("Value of x2: \t" +x2);
																			
																			y3 = y3 - deltay1/100; 
														//					System.out.println("Value of y2: \t" +y2);
																		}
																		System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																		System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																	}
																	
																	else //ball will go up and right
																	{
																		y3 = y2 + deltay1/100; 
																		while(x3 > 0 && y3 <4)
																		{
																			x3 = x3 - deltax1/100;
														//					System.out.println("Value of x2: \t" +x2);
																			
																			y3 = y3 + deltay1/100; 
														//					System.out.println("Value of y2: \t" +y2);
																		}
																		System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																		System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																	}
																}
																
																//case 4: if x1 > x2 and x2 approximately = 0 THEN ball will hit left bank and travel right) 
																else if (x1 > x2 && Math.abs(x2 - 0) < 0.05)
																{
																	x3 = x2 + deltax1/100;
																		
																	if (y1 < y2) //ball will go up and right
																	{
																		y3 = y2 +deltay1/100;
																		while (x3 >0 && y3 <4)
																		{
																			x3 = x3 + deltax1/100;
														//					System.out.println("Value of x2: \t" +x2);
																				
																			y3 = y3 + deltay1/100; 
														//					System.out.println("Value of y2: \t" +y2);
																		}
																		System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																		System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																	}
																			
																	else //ball will go down and right
																	{
																		y3 = y2 - deltay1/100; 
																		while(x3 < 8 && y3 >0)
																		{
																			x3 = x3 + deltax1/100;
														//					System.out.println("Value of x2: \t" +x2);
																					
																			y3 = y3 - deltay1/100; 
														//					System.out.println("Value of y2: \t" +y2);
																		}
																		System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																		System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																	}
																}
																
																else
																{
																	System.out.println("Case not handled yet - was ball shot straight into rail? ");
																}	
				}
			}

			
			//case 2: ball is traveling to right and hits right rail - will be sent back to left
			else if (x0 < x1 && x1 ==8)
			{	
				x2 = x1 - deltax0/100;
				if (y0 < y1) //ball will go up and left
				{
					y2 = y1 +deltay0/100;
					while (x2 >0 && y2 <4)
					{
						x2 = x2 - deltax0/100;
	//					System.out.println("Value of x2: \t" +x2);
						
						y2 = y2 + deltay0/100; 
	//					System.out.println("Value of y2: \t" +y2);
	
					}
					System.out.println("FINAL value of x2: \t" +Math.round(x2*4)/4.0);
					System.out.println("FINAL value of y2: \t" +Math.round(y2*4)/4.0);
					
														System.out.println("\n Now for two rails:");
														//TWO RAILS
														deltax1 = Math.abs(x2-x1);
														deltay1 = Math.abs(y2-y1);
														
														//case 1a: if x1 < x2 and x2 != 8 THEN x3 will be greater than x2 (ball will travel right) 
														if (x1 < x2 && Math.abs(x2 - 8) > 0.05)
														{
															x3 = x2 + deltax1/100;
															
															if (y1 < y2) //ball will go down and right
															{
																y3 = y2 -deltay1/100;
																while (x3 <8 && y3 >0)
																{
																	x3 = x3 + deltax1/100;
												//					System.out.println("Value of x2: \t" +x2);
																	
																	y3 = y3 - deltay1/100; 
												//					System.out.println("Value of y2: \t" +y2);
												
																}
																System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
															}
															
															else //ball will go up and right
															{
																y3 = y2 + deltay1/100; 
																while(x3 < 8 && y3 <4)
																{
																	x3 = x3 + deltax1/100;
												//					System.out.println("Value of x2: \t" +x2);
																	
																	y3 = y3 + deltay1/100; 
												//					System.out.println("Value of y2: \t" +y2);
												
																}
																System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
															}
														}
														
														
														//case 2a: ball is traveling to right and "APPROXIMATELY" hits right rail  (x2 is within 0.05 diamonds of 8th diamond)- will be sent back to left
														else if (x1 < x2 && Math.abs(x2 - 8) < 0.05)
														{	
															x3 = x2 - deltax1/100;
															if (y1 < y2) //ball will go up and left
															{
																y3 = y2 +deltay1/100;
																while (x3 >0 && y3 <4)
																{
																	x3 = x3 - deltax1/100;
												//					System.out.println("Value of x2: \t" +x2);
																	
																	y3 = y3 + deltay1/100; 
												//					System.out.println("Value of y2: \t" +y2);
												
																}
																System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
															}
															
															else //ball will go down and left
															{
																y3 = y2 - deltay1/100; 
																while(x3 > 0 && y3 >0)
																{
																	x3 = x3 - deltax1/100;
												//					System.out.println("Value of x2: \t" +x2);
																	
																	y3 = y3 - deltay1/100; 
												//					System.out.println("Value of y2: \t" +y2);
																}
																System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
															}
														}
														
														//case 3a: if x1 > x2 and x2 != 0 THEN x2 will be greater than x1 (ball will travel left)
														//NOTE TO INTELLIGENT PEOPLE - case3a may not be a possible subset case of case 1 - here just in case ... and to increase computer workload 
														
														else if (x1 > x2 && Math.abs(x2 - 0) > 0.05)
														{
															x3 = x2 - deltax1/100;
															
															if (y1 < y2) //ball will go down and left
															{
																y3 = y2 -deltay1/100;
																while (x3 >0 && y3 >0)
																{
																	x3 = x3 - deltax1/100;
												//					System.out.println("Value of x2: \t" +x2);
																	
																	y3 = y3 - deltay1/100; 
												//					System.out.println("Value of y2: \t" +y2);
																}
																System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
															}
															
															else //ball will go up and right
															{
																y3 = y2 + deltay1/100; 
																while(x3 > 0 && y3 <4)
																{
																	x3 = x3 - deltax1/100;
												//					System.out.println("Value of x2: \t" +x2);
																	
																	y3 = y3 + deltay1/100; 
												//					System.out.println("Value of y2: \t" +y2);
																}
																System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
															}
														}
														
														//case 4: if x1 > x2 and x2 approximately = 0 THEN ball will hit left bank and travel right) 
														else if (x1 > x2 && Math.abs(x2 - 0) < 0.05)
														{
															x3 = x2 + deltax1/100;
																
															if (y1 < y2) //ball will go up and right
															{
																y3 = y2 +deltay1/100;
																while (x3 >0 && y3 <4)
																{
																	x3 = x3 + deltax1/100;
												//					System.out.println("Value of x2: \t" +x2);
																		
																	y3 = y3 + deltay1/100; 
												//					System.out.println("Value of y2: \t" +y2);
																}
																System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
															}
																	
															else //ball will go down and right
															{
																y3 = y2 - deltay1/100; 
																while(x3 < 8 && y3 >0)
																{
																	x3 = x3 + deltax1/100;
												//					System.out.println("Value of x2: \t" +x2);
																			
																	y3 = y3 - deltay1/100; 
												//					System.out.println("Value of y2: \t" +y2);
																}
																System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
															}
														}
														
														else
														{
															System.out.println("Case not handled yet - was ball shot straight into rail? ");
														}	
					
					
					
				}
				
				else //ball will go down and left
				{
					y2 = y1 - deltay0/100; 
					while(x2 > 0 && y2 >0)
					{
						x2 = x2 - deltax0/100;
	//					System.out.println("Value of x2: \t" +x2);
						
						y2 = y2 - deltay0/100; 
	//					System.out.println("Value of y2: \t" +y2);
					}
					
					System.out.println("FINAL value of x2: \t" +Math.round(x2*4)/4.0);
					System.out.println("FINAL value of y2: \t" +Math.round(y2*4)/4.0);
					
					
															System.out.println("\n Now for two rails:");
															//TWO RAILS
															deltax1 = Math.abs(x2-x1);
															deltay1 = Math.abs(y2-y1);
															
															//case 1a: if x1 < x2 and x2 != 8 THEN x3 will be greater than x2 (ball will travel right) 
															if (x1 < x2 && Math.abs(x2 - 8) > 0.05)
															{
																x3 = x2 + deltax1/100;
																
																if (y1 < y2) //ball will go down and right
																{
																	y3 = y2 -deltay1/100;
																	while (x3 <8 && y3 >0)
																	{
																		x3 = x3 + deltax1/100;
													//					System.out.println("Value of x2: \t" +x2);
																		
																		y3 = y3 - deltay1/100; 
													//					System.out.println("Value of y2: \t" +y2);
													
																	}
																	System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																	System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																}
																
																else //ball will go up and right
																{
																	y3 = y2 + deltay1/100; 
																	while(x3 < 8 && y3 <4)
																	{
																		x3 = x3 + deltax1/100;
													//					System.out.println("Value of x2: \t" +x2);
																		
																		y3 = y3 + deltay1/100; 
													//					System.out.println("Value of y2: \t" +y2);
													
																	}
																	System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																	System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																}
															}
															
															
															//case 2a: ball is traveling to right and "APPROXIMATELY" hits right rail  (x2 is within 0.05 diamonds of 8th diamond)- will be sent back to left
															else if (x1 < x2 && Math.abs(x2 - 8) < 0.05)
															{	
																x3 = x2 - deltax1/100;
																if (y1 < y2) //ball will go up and left
																{
																	y3 = y2 +deltay1/100;
																	while (x3 >0 && y3 <4)
																	{
																		x3 = x3 - deltax1/100;
													//					System.out.println("Value of x2: \t" +x2);
																		
																		y3 = y3 + deltay1/100; 
													//					System.out.println("Value of y2: \t" +y2);
													
																	}
																	System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																	System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																}
																
																else //ball will go down and left
																{
																	y3 = y2 - deltay1/100; 
																	while(x3 > 0 && y3 >0)
																	{
																		x3 = x3 - deltax1/100;
													//					System.out.println("Value of x2: \t" +x2);
																		
																		y3 = y3 - deltay1/100; 
													//					System.out.println("Value of y2: \t" +y2);
																	}
																	System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																	System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																}
															}
															
															//case 3a: if x1 > x2 and x2 != 0 THEN x2 will be greater than x1 (ball will travel left)
															//NOTE TO INTELLIGENT PEOPLE - case3a may not be a possible subset case of case 1 - here just in case ... and to increase computer workload 
															
															else if (x1 > x2 && Math.abs(x2 - 0) > 0.05)
															{
																x3 = x2 - deltax1/100;
																
																if (y1 < y2) //ball will go down and left
																{
																	y3 = y2 -deltay1/100;
																	while (x3 >0 && y3 >0)
																	{
																		x3 = x3 - deltax1/100;
													//					System.out.println("Value of x2: \t" +x2);
																		
																		y3 = y3 - deltay1/100; 
													//					System.out.println("Value of y2: \t" +y2);
																	}
																	System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																	System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																}
																
																else //ball will go up and right
																{
																	y3 = y2 + deltay1/100; 
																	while(x3 > 0 && y3 <4)
																	{
																		x3 = x3 - deltax1/100;
													//					System.out.println("Value of x2: \t" +x2);
																		
																		y3 = y3 + deltay1/100; 
													//					System.out.println("Value of y2: \t" +y2);
																	}
																	System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																	System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																}
															}
															
															//case 4: if x1 > x2 and x2 approximately = 0 THEN ball will hit left bank and travel right) 
															else if (x1 > x2 && Math.abs(x2 - 0) < 0.05)
															{
																x3 = x2 + deltax1/100;
																	
																if (y1 < y2) //ball will go up and right
																{
																	y3 = y2 +deltay1/100;
																	while (x3 >0 && y3 <4)
																	{
																		x3 = x3 + deltax1/100;
													//					System.out.println("Value of x2: \t" +x2);
																			
																		y3 = y3 + deltay1/100; 
													//					System.out.println("Value of y2: \t" +y2);
																	}
																	System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																	System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																}
																		
																else //ball will go down and right
																{
																	y3 = y2 - deltay1/100; 
																	while(x3 < 8 && y3 >0)
																	{
																		x3 = x3 + deltax1/100;
													//					System.out.println("Value of x2: \t" +x2);
																				
																		y3 = y3 - deltay1/100; 
													//					System.out.println("Value of y2: \t" +y2);
																	}
																	System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																	System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																}
															}
															
															else
															{
																System.out.println("Case not handled yet - was ball shot straight into rail? ");
															}	
						}
			}
														
//case 3: if x0 > x1 and x1 != 0 THEN x2 will be greater than x1 (ball will travel left) 
	else if (x0 > x1 && x1 !=0)
	{
		x2 = x1 - deltax0/100;
		
		if (y0 < y1) //ball will go down and left
		{
			y2 = y1 -deltay0/100;
			while (x2 >0 && y2 >0)
			{
				x2 = x2 - deltax0/100;
//					System.out.println("Value of x2: \t" +x2);
				
				y2 = y2 - deltay0/100; 
//					System.out.println("Value of y2: \t" +y2);
			}
			System.out.println("FINAL value of x2: \t" +Math.round(x2*4)/4.0);
			System.out.println("FINAL value of y2: \t" +Math.round(y2*4)/4.0);
			
																System.out.println("\n Now for two rails:");
																//TWO RAILS
																deltax1 = Math.abs(x2-x1);
																deltay1 = Math.abs(y2-y1);
																
																//case 1a: if x1 < x2 and x2 != 8 THEN x3 will be greater than x2 (ball will travel right) 
																if (x1 < x2 && Math.abs(x2 - 8) > 0.05)
																{
																	x3 = x2 + deltax1/100;
																	
																	if (y1 < y2) //ball will go down and right
																	{
																		y3 = y2 -deltay1/100;
																		while (x3 <8 && y3 >0)
																		{
																			x3 = x3 + deltax1/100;
														//					System.out.println("Value of x2: \t" +x2);
																			
																			y3 = y3 - deltay1/100; 
														//					System.out.println("Value of y2: \t" +y2);
														
																		}
																		System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																		System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																	}
																	
																	else //ball will go up and right
																	{
																		y3 = y2 + deltay1/100; 
																		while(x3 < 8 && y3 <4)
																		{
																			x3 = x3 + deltax1/100;
														//					System.out.println("Value of x2: \t" +x2);
																			
																			y3 = y3 + deltay1/100; 
														//					System.out.println("Value of y2: \t" +y2);
														
																		}
																		System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																		System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																	}
																}
																
																
																//case 2a: ball is traveling to right and "APPROXIMATELY" hits right rail  (x2 is within 0.05 diamonds of 8th diamond)- will be sent back to left
																else if (x1 < x2 && Math.abs(x2 - 8) < 0.05)
																{	
																	x3 = x2 - deltax1/100;
																	if (y1 < y2) //ball will go up and left
																	{
																		y3 = y2 +deltay1/100;
																		while (x3 >0 && y3 <4)
																		{
																			x3 = x3 - deltax1/100;
														//					System.out.println("Value of x2: \t" +x2);
																			
																			y3 = y3 + deltay1/100; 
														//					System.out.println("Value of y2: \t" +y2);
														
																		}
																		System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																		System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																	}
																	
																	else //ball will go down and left
																	{
																		y3 = y2 - deltay1/100; 
																		while(x3 > 0 && y3 >0)
																		{
																			x3 = x3 - deltax1/100;
														//					System.out.println("Value of x2: \t" +x2);
																			
																			y3 = y3 - deltay1/100; 
														//					System.out.println("Value of y2: \t" +y2);
																		}
																		System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																		System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																	}
																}
																
																//case 3a: if x1 > x2 and x2 != 0 THEN x2 will be greater than x1 (ball will travel left)
																//NOTE TO INTELLIGENT PEOPLE - case3a may not be a possible subset case of case 1 - here just in case ... and to increase computer workload 
																
																else if (x1 > x2 && Math.abs(x2 - 0) > 0.05)
																{
																	x3 = x2 - deltax1/100;
																	
																	if (y1 < y2) //ball will go down and left
																	{
																		y3 = y2 -deltay1/100;
																		while (x3 >0 && y3 >0)
																		{
																			x3 = x3 - deltax1/100;
														//					System.out.println("Value of x2: \t" +x2);
																			
																			y3 = y3 - deltay1/100; 
														//					System.out.println("Value of y2: \t" +y2);
																		}
																		System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																		System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																	}
																	
																	else //ball will go up and right
																	{
																		y3 = y2 + deltay1/100; 
																		while(x3 > 0 && y3 <4)
																		{
																			x3 = x3 - deltax1/100;
														//					System.out.println("Value of x2: \t" +x2);
																			
																			y3 = y3 + deltay1/100; 
														//					System.out.println("Value of y2: \t" +y2);
																		}
																		System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																		System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																	}
																}
																
																//case 4: if x1 > x2 and x2 approximately = 0 THEN ball will hit left bank and travel right) 
																else if (x1 > x2 && Math.abs(x2 - 0) < 0.05)
																{
																	x3 = x2 + deltax1/100;
																		
																	if (y1 < y2) //ball will go up and right
																	{
																		y3 = y2 +deltay1/100;
																		while (x3 >0 && y3 <4)
																		{
																			x3 = x3 + deltax1/100;
														//					System.out.println("Value of x2: \t" +x2);
																				
																			y3 = y3 + deltay1/100; 
														//					System.out.println("Value of y2: \t" +y2);
																		}
																		System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																		System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																	}
																			
																	else //ball will go down and right
																	{
																		y3 = y2 - deltay1/100; 
																		while(x3 < 8 && y3 >0)
																		{
																			x3 = x3 + deltax1/100;
														//					System.out.println("Value of x2: \t" +x2);
																					
																			y3 = y3 - deltay1/100; 
														//					System.out.println("Value of y2: \t" +y2);
																		}
																		System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																		System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																	}
																}
																
																else
																{
																	System.out.println("Case not handled yet - was ball shot straight into rail? ");
																}	
			
			
			
		}
		
		else //ball will go up and right
		{
			y2 = y1 + deltay0/100; 
			while(x2 > 0 && y2 <4)
			{
				x2 = x2 - deltax0/100;
//					System.out.println("Value of x2: \t" +x2);
				
				y2 = y2 + deltay0/100; 
//					System.out.println("Value of y2: \t" +y2);
			}
			System.out.println("FINAL value of x2: \t" +Math.round(x2*4)/4.0);
			System.out.println("FINAL value of y2: \t" +Math.round(y2*4)/4.0);
			
			
			
																		System.out.println("\n Now for two rails:");
																		//TWO RAILS
																		deltax1 = Math.abs(x2-x1);
																		deltay1 = Math.abs(y2-y1);
																		
																		//case 1a: if x1 < x2 and x2 != 8 THEN x3 will be greater than x2 (ball will travel right) 
																		if (x1 < x2 && Math.abs(x2 - 8) > 0.05)
																		{
																			x3 = x2 + deltax1/100;
																			
																			if (y1 < y2) //ball will go down and right
																			{
																				y3 = y2 -deltay1/100;
																				while (x3 <8 && y3 >0)
																				{
																					x3 = x3 + deltax1/100;
																//					System.out.println("Value of x2: \t" +x2);
																					
																					y3 = y3 - deltay1/100; 
																//					System.out.println("Value of y2: \t" +y2);
																
																				}
																				System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																				System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																			}
																			
																			else //ball will go up and right
																			{
																				y3 = y2 + deltay1/100; 
																				while(x3 < 8 && y3 <4)
																				{
																					x3 = x3 + deltax1/100;
																//					System.out.println("Value of x2: \t" +x2);
																					
																					y3 = y3 + deltay1/100; 
																//					System.out.println("Value of y2: \t" +y2);
																
																				}
																				System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																				System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																			}
																		}
																		
																		
																		//case 2a: ball is traveling to right and "APPROXIMATELY" hits right rail  (x2 is within 0.05 diamonds of 8th diamond)- will be sent back to left
																		else if (x1 < x2 && Math.abs(x2 - 8) < 0.05)
																		{	
																			x3 = x2 - deltax1/100;
																			if (y1 < y2) //ball will go up and left
																			{
																				y3 = y2 +deltay1/100;
																				while (x3 >0 && y3 <4)
																				{
																					x3 = x3 - deltax1/100;
																//					System.out.println("Value of x2: \t" +x2);
																					
																					y3 = y3 + deltay1/100; 
																//					System.out.println("Value of y2: \t" +y2);
																
																				}
																				System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																				System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																			}
																			
																			else //ball will go down and left
																			{
																				y3 = y2 - deltay1/100; 
																				while(x3 > 0 && y3 >0)
																				{
																					x3 = x3 - deltax1/100;
																//					System.out.println("Value of x2: \t" +x2);
																					
																					y3 = y3 - deltay1/100; 
																//					System.out.println("Value of y2: \t" +y2);
																				}
																				System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																				System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																			}
																		}
																		
																		//case 3a: if x1 > x2 and x2 != 0 THEN x2 will be greater than x1 (ball will travel left)
																		//NOTE TO INTELLIGENT PEOPLE - case3a may not be a possible subset case of case 1 - here just in case ... and to increase computer workload 
																		
																		else if (x1 > x2 && Math.abs(x2 - 0) > 0.05)
																		{
																			x3 = x2 - deltax1/100;
																			
																			if (y1 < y2) //ball will go down and left
																			{
																				y3 = y2 -deltay1/100;
																				while (x3 >0 && y3 >0)
																				{
																					x3 = x3 - deltax1/100;
																//					System.out.println("Value of x2: \t" +x2);
																					
																					y3 = y3 - deltay1/100; 
																//					System.out.println("Value of y2: \t" +y2);
																				}
																				System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																				System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																			}
																			
																			else //ball will go up and right
																			{
																				y3 = y2 + deltay1/100; 
																				while(x3 > 0 && y3 <4)
																				{
																					x3 = x3 - deltax1/100;
																//					System.out.println("Value of x2: \t" +x2);
																					
																					y3 = y3 + deltay1/100; 
																//					System.out.println("Value of y2: \t" +y2);
																				}
																				System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																				System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																			}
																		}
																		
																		//case 4: if x1 > x2 and x2 approximately = 0 THEN ball will hit left bank and travel right) 
																		else if (x1 > x2 && Math.abs(x2 - 0) < 0.05)
																		{
																			x3 = x2 + deltax1/100;
																				
																			if (y1 < y2) //ball will go up and right
																			{
																				y3 = y2 +deltay1/100;
																				while (x3 >0 && y3 <4)
																				{
																					x3 = x3 + deltax1/100;
																//					System.out.println("Value of x2: \t" +x2);
																						
																					y3 = y3 + deltay1/100; 
																//					System.out.println("Value of y2: \t" +y2);
																				}
																				System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																				System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																			}
																					
																			else //ball will go down and right
																			{
																				y3 = y2 - deltay1/100; 
																				while(x3 < 8 && y3 >0)
																				{
																					x3 = x3 + deltax1/100;
																//					System.out.println("Value of x2: \t" +x2);
																							
																					y3 = y3 - deltay1/100; 
																//					System.out.println("Value of y2: \t" +y2);
																				}
																				System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																				System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																			}
																		}
																		
																		else
																		{
																			System.out.println("Case not handled yet - was ball shot straight into rail? ");
																		}	
		}
	}
	
	//case 4: if x0 > x1 and x1 = 0 THEN ball will hit left bank and travel right) 
	else if (x0 > x1 && x1 ==0)
	{
		x2 = x1 + deltax0/100;
			
		if (y0 < y1) //ball will go up and right
		{
			y2 = y1 +deltay0/100;
			while (x2 >0 && y2 <4)
			{
				x2 = x2 + deltax0/100;
//					System.out.println("Value of x2: \t" +x2);
					
				y2 = y2 + deltay0/100; 
//					System.out.println("Value of y2: \t" +y2);
			}
			System.out.println("FINAL value of x2: \t" +Math.round(x2*4)/4.0);
			System.out.println("FINAL value of y2: \t" +Math.round(y2*4)/4.0);
			
			
			
			
																				System.out.println("\n Now for two rails:");
																				//TWO RAILS
																				deltax1 = Math.abs(x2-x1);
																				deltay1 = Math.abs(y2-y1);
																				
																				//case 1a: if x1 < x2 and x2 != 8 THEN x3 will be greater than x2 (ball will travel right) 
																				if (x1 < x2 && Math.abs(x2 - 8) > 0.05)
																				{
																					x3 = x2 + deltax1/100;
																					
																					if (y1 < y2) //ball will go down and right
																					{
																						y3 = y2 -deltay1/100;
																						while (x3 <8 && y3 >0)
																						{
																							x3 = x3 + deltax1/100;
																		//					System.out.println("Value of x2: \t" +x2);
																							
																							y3 = y3 - deltay1/100; 
																		//					System.out.println("Value of y2: \t" +y2);
																		
																						}
																						System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																						System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																					}
																					
																					else //ball will go up and right
																					{
																						y3 = y2 + deltay1/100; 
																						while(x3 < 8 && y3 <4)
																						{
																							x3 = x3 + deltax1/100;
																		//					System.out.println("Value of x2: \t" +x2);
																							
																							y3 = y3 + deltay1/100; 
																		//					System.out.println("Value of y2: \t" +y2);
																		
																						}
																						System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																						System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																					}
																				}
																				
																				
																				//case 2a: ball is traveling to right and "APPROXIMATELY" hits right rail  (x2 is within 0.05 diamonds of 8th diamond)- will be sent back to left
																				else if (x1 < x2 && Math.abs(x2 - 8) < 0.05)
																				{	
																					x3 = x2 - deltax1/100;
																					if (y1 < y2) //ball will go up and left
																					{
																						y3 = y2 +deltay1/100;
																						while (x3 >0 && y3 <4)
																						{
																							x3 = x3 - deltax1/100;
																		//					System.out.println("Value of x2: \t" +x2);
																							
																							y3 = y3 + deltay1/100; 
																		//					System.out.println("Value of y2: \t" +y2);
																		
																						}
																						System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																						System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																					}
																					
																					else //ball will go down and left
																					{
																						y3 = y2 - deltay1/100; 
																						while(x3 > 0 && y3 >0)
																						{
																							x3 = x3 - deltax1/100;
																		//					System.out.println("Value of x2: \t" +x2);
																							
																							y3 = y3 - deltay1/100; 
																		//					System.out.println("Value of y2: \t" +y2);
																						}
																						System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																						System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																					}
																				}
																				
																				//case 3a: if x1 > x2 and x2 != 0 THEN x2 will be greater than x1 (ball will travel left)
																				//NOTE TO INTELLIGENT PEOPLE - case3a may not be a possible subset case of case 1 - here just in case ... and to increase computer workload 
																				
																				else if (x1 > x2 && Math.abs(x2 - 0) > 0.05)
																				{
																					x3 = x2 - deltax1/100;
																					
																					if (y1 < y2) //ball will go down and left
																					{
																						y3 = y2 -deltay1/100;
																						while (x3 >0 && y3 >0)
																						{
																							x3 = x3 - deltax1/100;
																		//					System.out.println("Value of x2: \t" +x2);
																							
																							y3 = y3 - deltay1/100; 
																		//					System.out.println("Value of y2: \t" +y2);
																						}
																						System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																						System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																					}
																					
																					else //ball will go up and right
																					{
																						y3 = y2 + deltay1/100; 
																						while(x3 > 0 && y3 <4)
																						{
																							x3 = x3 - deltax1/100;
																		//					System.out.println("Value of x2: \t" +x2);
																							
																							y3 = y3 + deltay1/100; 
																		//					System.out.println("Value of y2: \t" +y2);
																						}
																						System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																						System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																					}
																				}
																				
																				//case 4: if x1 > x2 and x2 approximately = 0 THEN ball will hit left bank and travel right) 
																				else if (x1 > x2 && Math.abs(x2 - 0) < 0.05)
																				{
																					x3 = x2 + deltax1/100;
																						
																					if (y1 < y2) //ball will go up and right
																					{
																						y3 = y2 +deltay1/100;
																						while (x3 >0 && y3 <4)
																						{
																							x3 = x3 + deltax1/100;
																		//					System.out.println("Value of x2: \t" +x2);
																								
																							y3 = y3 + deltay1/100; 
																		//					System.out.println("Value of y2: \t" +y2);
																						}
																						System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																						System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																					}
																							
																					else //ball will go down and right
																					{
																						y3 = y2 - deltay1/100; 
																						while(x3 < 8 && y3 >0)
																						{
																							x3 = x3 + deltax1/100;
																		//					System.out.println("Value of x2: \t" +x2);
																									
																							y3 = y3 - deltay1/100; 
																		//					System.out.println("Value of y2: \t" +y2);
																						}
																						System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																						System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																					}
																				}
																				
																				else
																				{
																					System.out.println("Case not handled yet - was ball shot straight into rail? ");
																				}	
		}
				
		else //ball will go down and right
		{
			y2 = y1 - deltay0/100; 
			while(x2 < 8 && y2 >0)
			{
				x2 = x2 + deltax0/100;
//					System.out.println("Value of x2: \t" +x2);
						
				y2 = y2 - deltay0/100; 
//					System.out.println("Value of y2: \t" +y2);
			}
			System.out.println("FINAL value of x2: \t" +Math.round(x2*4)/4.0);
			System.out.println("FINAL value of y2: \t" +Math.round(y2*4)/4.0);
			
																			System.out.println("\n Now for two rails:");
																			//TWO RAILS
																			deltax1 = Math.abs(x2-x1);
																			deltay1 = Math.abs(y2-y1);
																			
																			//case 1a: if x1 < x2 and x2 != 8 THEN x3 will be greater than x2 (ball will travel right) 
																			if (x1 < x2 && Math.abs(x2 - 8) > 0.05)
																			{
																				x3 = x2 + deltax1/100;
																				
																				if (y1 < y2) //ball will go down and right
																				{
																					y3 = y2 -deltay1/100;
																					while (x3 <8 && y3 >0)
																					{
																						x3 = x3 + deltax1/100;
																	//					System.out.println("Value of x2: \t" +x2);
																						
																						y3 = y3 - deltay1/100; 
																	//					System.out.println("Value of y2: \t" +y2);
																	
																					}
																					System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																					System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																				}
																				
																				else //ball will go up and right
																				{
																					y3 = y2 + deltay1/100; 
																					while(x3 < 8 && y3 <4)
																					{
																						x3 = x3 + deltax1/100;
																	//					System.out.println("Value of x2: \t" +x2);
																						
																						y3 = y3 + deltay1/100; 
																	//					System.out.println("Value of y2: \t" +y2);
																	
																					}
																					System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																					System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																				}
																			}
																			
																			
																			//case 2a: ball is traveling to right and "APPROXIMATELY" hits right rail  (x2 is within 0.05 diamonds of 8th diamond)- will be sent back to left
																			else if (x1 < x2 && Math.abs(x2 - 8) < 0.05)
																			{	
																				x3 = x2 - deltax1/100;
																				if (y1 < y2) //ball will go up and left
																				{
																					y3 = y2 +deltay1/100;
																					while (x3 >0 && y3 <4)
																					{
																						x3 = x3 - deltax1/100;
																	//					System.out.println("Value of x2: \t" +x2);
																						
																						y3 = y3 + deltay1/100; 
																	//					System.out.println("Value of y2: \t" +y2);
																	
																					}
																					System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																					System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																				}
																				
																				else //ball will go down and left
																				{
																					y3 = y2 - deltay1/100; 
																					while(x3 > 0 && y3 >0)
																					{
																						x3 = x3 - deltax1/100;
																	//					System.out.println("Value of x2: \t" +x2);
																						
																						y3 = y3 - deltay1/100; 
																	//					System.out.println("Value of y2: \t" +y2);
																					}
																					System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																					System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																				}
																			}
																			
																			//case 3a: if x1 > x2 and x2 != 0 THEN x2 will be greater than x1 (ball will travel left)
																			//NOTE TO INTELLIGENT PEOPLE - case3a may not be a possible subset case of case 1 - here just in case ... and to increase computer workload 
																			
																			else if (x1 > x2 && Math.abs(x2 - 0) > 0.05)
																			{
																				x3 = x2 - deltax1/100;
																				
																				if (y1 < y2) //ball will go down and left
																				{
																					y3 = y2 -deltay1/100;
																					while (x3 >0 && y3 >0)
																					{
																						x3 = x3 - deltax1/100;
																	//					System.out.println("Value of x2: \t" +x2);
																						
																						y3 = y3 - deltay1/100; 
																	//					System.out.println("Value of y2: \t" +y2);
																					}
																					System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																					System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																				}
																				
																				else //ball will go up and right
																				{
																					y3 = y2 + deltay1/100; 
																					while(x3 > 0 && y3 <4)
																					{
																						x3 = x3 - deltax1/100;
																	//					System.out.println("Value of x2: \t" +x2);
																						
																						y3 = y3 + deltay1/100; 
																	//					System.out.println("Value of y2: \t" +y2);
																					}
																					System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																					System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																				}
																			}
																			
																			//case 4: if x1 > x2 and x2 approximately = 0 THEN ball will hit left bank and travel right) 
																			else if (x1 > x2 && Math.abs(x2 - 0) < 0.05)
																			{
																				x3 = x2 + deltax1/100;
																					
																				if (y1 < y2) //ball will go up and right
																				{
																					y3 = y2 +deltay1/100;
																					while (x3 >0 && y3 <4)
																					{
																						x3 = x3 + deltax1/100;
																	//					System.out.println("Value of x2: \t" +x2);
																							
																						y3 = y3 + deltay1/100; 
																	//					System.out.println("Value of y2: \t" +y2);
																					}
																					System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																					System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																				}
																						
																				else //ball will go down and right
																				{
																					y3 = y2 - deltay1/100; 
																					while(x3 < 8 && y3 >0)
																					{
																						x3 = x3 + deltax1/100;
																	//					System.out.println("Value of x2: \t" +x2);
																								
																						y3 = y3 - deltay1/100; 
																	//					System.out.println("Value of y2: \t" +y2);
																					}
																					System.out.println("FINAL value of x3: \t" +Math.round(x3*4)/4.0);
																					System.out.println("FINAL value of y3: \t" +Math.round(y3*4)/4.0);
																				}
																			}
																			
																			else
																			{
																				System.out.println("Case not handled yet - was ball shot straight into rail? ");
																			}	
		}
	}
	
	else
	{
		System.out.println("Case not handled yet - was ball shot straight into rail? ");
	}	
		}	
	}
}		
	