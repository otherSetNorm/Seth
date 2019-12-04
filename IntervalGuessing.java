import java.util.Scanner;
import java.util.Random; 
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip; 

public class IntervalGuessing
{
	public static void main(String [] args)
	{
//		File firstNoteFile = new File("C://Users//snorm//Desktop//Su_2019//Fun with Java//Interval Pool//maj2.WAV");  
//		playNote(firstNoteFile);
		
		File intervalDirectory = new File("C://Users//snorm//Desktop//Su_2019//Fun with Java//Interval Pool//"); 
		File[] arrayOfIntervalFilePaths = intervalDirectory.listFiles();
		Random rand = new Random(); 
		
		Scanner scan = new Scanner(System.in);
		String answer = "";
		int selectedFileIndex = 0; 
		
		System.out.println("This program tests pitch interval recognition.");
		System.out.println("The following answers are acceptable. You may also \"give up\"Other input will not be recognized: \n");
		System.out.println("min2  maj2  min3 maj3  p4  tritone p5  min6  maj6  min7  maj7  p8\n");
		
//		String [] intervalFileName
//		for (File x: arrayOfIntervalFilePaths)
//		{
//			
//		}
//		answer = "howdy.edu";
//		int dotposition = answer.indexOf('.');
//		System.out.println(dotposition);
//		String shortenedAnswer = (String) answer.subSequence(dotposition, answer.length());
//		System.out.println(shortenedAnswer);
////		
		while(answer != "q")
		{
			System.out.println("\nIdentify the following interval:");
			selectedFileIndex = rand.nextInt(arrayOfIntervalFilePaths.length);
			
		
			String intervalFilePathName = arrayOfIntervalFilePaths[selectedFileIndex].toString();
			//DON'T UNCOMMENT THE LINE BELOW! YOU CHEATER!
//			System.out.println(intervalFilePathName+"\n");

			
			playNote(arrayOfIntervalFilePaths[selectedFileIndex]);
			answer = scan.next();
//			
			if (intervalFilePathName.contains(answer))
			{
				System.out.println("correct");
			}
			
			else
			{
				System.out.println("wrong");
				//System.out.println("\n\n\n\n\n\"");
				System.out.println(intervalFilePathName+"\n");
				//System.out.println("\n\n\n\n\n\");
				
				System.out.println("try again > ");
				playNote(arrayOfIntervalFilePaths[selectedFileIndex]);
				answer = scan.next();
				
				if (intervalFilePathName.contains(answer))
				{
					System.out.println("correct");
				}
				
//				if (answer.equals("give up"))
//				{
//					System.out.println("Quitter!");
//					System.out.println("Answer is "+intervalFilePathName);
//				}
				else
				{
					System.out.println("wrong");
					System.out.println("try again > ");
					playNote(arrayOfIntervalFilePaths[selectedFileIndex]);
					answer = scan.next();

					if (intervalFilePathName.contains(answer))
					{
						System.out.println("correct");
					}
					
					else
					{
						System.out.println("\nThree strikes and yer out, kid. We'll try a different interval now. Maybe this time it'll be easier for yeh.");
					}
				}
			}
		}
		
//		}
		

	}
	
	public static void playNote (File note)
	{
		try
		{
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(note));
			clip.start();
			
			Thread.sleep(clip.getMicrosecondLength()/1000);  // division by 1000 due to microsecond/millisecond disparity
			
		}
		catch(Exception e)
		{
			
		}
	}
}
