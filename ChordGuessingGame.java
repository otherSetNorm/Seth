import java.util.Scanner;
import java.util.Random; 
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip; 


public class ChordGuessingGame
{
	
	//randomly generate BLOCK chord from set of triads - major, minor, diminished, augmented, sus2 and sus4 - and tetrads - dom7, m7, maj7 only 
	
	//for difficulty - chord played can be in any inversion 
	
	//Give user (probably just me ... :) ) options
	//OPTION 1: answer
		// answers will be of the form "major triad", "sus2", "dom71stinv", etc
	//OPTION 2: repeat
	//OPTION 3: Hint
	
		//Hint 1 will be the block chord played in root form, followed by twice played root note 
		//after hint 1, options 1 - 3 will again be displayed
	
		//Hint 2 will be block chord played in all inversions 
	
		//Hint 3 will be broken chord in all inversions 
		
		//Hint 4 will be arpeggiated chord in all inversions 
		
	
//	File firstNoteFile = new File("C://Users//snorm//Desktop//Su_2019//Fun with Java//12 scale sharps//"+thirdNote+".WAV");  
//	playNote(firstNoteFile);
	
	public static void main (String[] args)
	{
		
		File chordDirectory = new File("C://Users//snorm//Desktop//Su_2019//Fun with Java//Chord Pool//"); 
		File[] arrayOfChordFilePaths = chordDirectory.listFiles();
		Random rand = new Random(); 
		
		
//		for (File x: arrayOfChordFilePaths)
//		{
//			System.out.println(x);
//		}
		Scanner scan = new Scanner(System.in);
		String answer = "";
		int selectedFileIndex = 0; 
		
		System.out.println("This program tests chord quality recognition.");
		System.out.println("The following answers are examples of what is acceptable. You may enter \"repeat\" to repeat once. Other input may not be recognized: \n");
		System.out.println("mintriad  majtriad  dim  aug  dom7  maj7  min7 sus \n");
	
		while(answer != "q")
		{
			System.out.println("\nIdentify the following chord:");
			selectedFileIndex = rand.nextInt(arrayOfChordFilePaths.length);
			
		
			String intervalFilePathName = arrayOfChordFilePaths[selectedFileIndex].toString();
			//DON'T UNCOMMENT THE LINE BELOW! YOU CHEATER!
			System.out.println(intervalFilePathName+"\n");
	
			
			playChord(arrayOfChordFilePaths[selectedFileIndex]);
			answer = scan.next();
			
			if (answer.equals("repeat"))
			{
				playChord(arrayOfChordFilePaths[selectedFileIndex]);
				answer = scan.next();	
			}
			
			if (intervalFilePathName.contains(answer))
			{
				System.out.println("correct");
			}
			
			else
			{
				System.out.println("wrong");
				System.out.println("try again > ");
				playChord(arrayOfChordFilePaths[selectedFileIndex]);
				answer = scan.next();
				
				if (intervalFilePathName.contains(answer))
				{
					System.out.println("correct");
				}
				
				else
				{
					System.out.println("wrong");
					System.out.println("try again > ");
					playChord(arrayOfChordFilePaths[selectedFileIndex]);
					answer = scan.next();
	
					if (intervalFilePathName.contains(answer))
					{
						System.out.println("correct");
					}
					
					else
					{
						System.out.println("\nThree strikes and yer out, kid. We'll try a different chord now. Maybe this time it'll be easier for yeh.");
					}
				}
			}
		}
	}
	
	
	
	public static void playChord (File chord)
	{
		try
		{
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(chord));
			clip.start();
			
			Thread.sleep(clip.getMicrosecondLength()/1000);  // division by 1000 due to microsecond/millisecond disparity
			
		}
		catch(Exception e)
		{
			
		}
	}
}
