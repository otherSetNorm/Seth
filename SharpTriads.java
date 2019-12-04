/*Seth Norman
 * This program identifies triad chords based on input of 3 notes.
 * It is currently limited to identifying chords where the bottom note and the top note are within an octave of each other. 
 */

import java.util.*; 
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip; 

public class SharpTriads 
{

	public static void main(String[] args) 
	{
		
		String [] notesArray = {"C","C#","D","D#","E","F","F#","G","G#","A","A#","B"};
		List<String> notesList = Arrays.asList(notesArray);
		List<String>selectedNotesList = new LinkedList<String>(); 
		
		//File C = new File("C://Users//snorm//Desktop//Su_2019//Fun with Java//12 scale sharps//C.WAV"); 
		
		
		//System.out.println("Number of notes is " +NotesArray.length);
		
		//Get user to input three notes
		Scanner scan = new Scanner(System.in);
		String sentinel = "a"; 
		System.out.println(Arrays.toString(notesList.toArray())+"\n");
		while (sentinel!= "q")
		{
//			System.out.println("Enter a letter to continue (q to quit after this iteration) > ");
//			sentinel = scan.next();
			System.out.println("Enter first note (notes must be entered in the form shown in the list above - program will stop otherwise)> ");
			String firstNote = scan.next();
			selectedNotesList.add(firstNote);
			for (int i = 0; i<= notesArray.length; i++)
			{
				if(firstNote.equalsIgnoreCase(notesArray[i]))
				{
					//System.out.println("Note entered successfully");
					File firstNoteFile = new File("C://Users//snorm//Desktop//Su_2019//Fun with Java//12 scale sharps//"+firstNote+".WAV");  
					playNote(firstNoteFile);
					break; //Note that if first note is not found, loop will not stop (effectively creating an error)
				}
			}
			
			System.out.println("Enter second note > ");
			String secondNote = scan.next();
			selectedNotesList.add(secondNote);
			for (int i = 0; i<= notesArray.length; i++)
			{
				if(secondNote.equals(notesArray[i]))
				{
					//System.out.println("Note entered successfully");
					File firstNoteFile = new File("C://Users//snorm//Desktop//Su_2019//Fun with Java//12 scale sharps//"+secondNote+".WAV");  
					playNote(firstNoteFile);
					break;
				}
			}
			
			System.out.println("Enter third note > ");
			String thirdNote = scan.next(); 
			selectedNotesList.add(thirdNote);
			for (int i = 0 ; i<= notesArray.length; i++)
			{
				if(thirdNote.equals(notesArray[i]))
				{
					//System.out.println("Note entered successfully");
					File firstNoteFile = new File("C://Users//snorm//Desktop//Su_2019//Fun with Java//12 scale sharps//"+thirdNote+".WAV");  
					playNote(firstNoteFile);
					break; 
				}
			}
			
			//make firstNote the first element in the notesList:
			List <String> sortedNotesList = new LinkedList<String>();
			for (int i = 0; i<= notesList.size(); i++)
			{
				if(notesList.indexOf(firstNote)+i <=11)
				{
					sortedNotesList.add(notesArray[notesList.indexOf(firstNote)+i]);
				}
			}
			//uncomment line below if you'd like to see the sorted list of notes 
	//		System.out.println(Arrays.toString(sortedNotesList.toArray()));
	//		
			
			int i = 0; 
			while(sortedNotesList.size()<notesList.size())
			{
				sortedNotesList.add(notesArray[i]);
				i++;
			}
			
			//define intervals by taking difference of positions of 1st and 2nd note, and 2nd and 3rd note
			int interval1 = sortedNotesList.indexOf(secondNote) - sortedNotesList.indexOf(firstNote);
			int interval2 = sortedNotesList.indexOf(thirdNote)-sortedNotesList.indexOf(secondNote);
			
			//uncommment line below if you want to see intervals (in units of semitones)
	//		System.out.println("First interval is  "+interval1 +" semitones." +"\nSecond interval is " +interval2+" semitones.");
			
			//root major and minor triads
			if(interval1 == 4 && interval2 == 3)
			{
				System.out.println("You entered a " +firstNote+ " major triad");
				//NEAR FUTURE: 
				File resultingChordFile = new File("C://Users//snorm//Desktop//Su_2019//Fun with Java//Triads//"+firstNote+"majortriad"+".WAV");  
				playNote(resultingChordFile);
			}
			
			else if(interval1 == 3 && interval2 == 4)
			{
				System.out.println("You entered a " +firstNote+ " minor triad");
				File resultingChordFile = new File("C://Users//snorm//Desktop//Su_2019//Fun with Java//Triads//"+firstNote+"minortriad"+".WAV");  
				playNote(resultingChordFile);
			}
	//		}
			
			//First inversion of major and minor triads: 
			else if(interval1 == 3 && interval2 == 5)
			{
				System.out.println("You entered the 1st inverted major chord: " + thirdNote+ "/"+firstNote);
			}
			
			else if(interval1 == 4 && interval2 == 5)
			{
				System.out.println("You entered the 1st inverted MINOR chord: " +thirdNote+"m/"+firstNote);
			}
			
			//Second inversion of major and minor triads: 
			else if(interval1 == 5 && interval2 == 4)
			{
				System.out.println("You entered the 2nd inverted major chord: " +secondNote+"/"+firstNote);
			}
			
			else if(interval1 == 5 && interval2 == 3)
			{
				System.out.println("You entered the 2nd inverted MINOR chord: "+secondNote+"m/"+firstNote);
			}
			
			//Diminished triad - root and inversions
			else if(interval1 == 3 && interval2 == 3)
			{
				System.out.println("You entered a diminished triad: " +firstNote+"dim");
			}
			
			else if(interval1 == 3 && interval2 == 6)
			{
				System.out.println("You entered the 1st inverted diminished triad: " +thirdNote+"dim/"+firstNote);
			}
			
			else if(interval1 == 6 && interval2 == 3)
			{
				System.out.println("You entered the 2nd inverted diminished triad: " +secondNote+"dim/"+firstNote);
			}
			
			//augmented triads - NOTE: augmented triad notes are ALWAYS 4 semitones apart - REGARDLESS of inversion
			//inverted augmented triads get new names - ex: Caug/E = Eaug
			//...the computer was "smarter" than I was here
			else if(interval1 ==4 && interval2 == 4)
			{
				System.out.println("You entered an augmented triad: "+firstNote+"aug");
			}
			
			//suspended triads 
			else if(interval1 == 2 && interval2 == 5)
			{
				System.out.println("You entered a " +firstNote+"sus2 chord");
				System.out.println("(This might also be considered as a 1st inversion of sus4: " +thirdNote+ "sus4/"+firstNote+")");
			}
			
			else if(interval1 == 5 && interval2 == 2)
			{
				System.out.println("You entered a "+firstNote+"sus4 chord");
				System.out.println("(This might also be considered as a 2nd inversion of sus2: " +secondNote+ "sus2/"+firstNote +")");
			}
			
			else if(interval1 == 5 && interval2 == 5)
			{
				System.out.println("You entered a 1st inversion of sus2: "+thirdNote + "sus2/"+firstNote);
				System.out.println("This might also be considered a 2nd inversion of sus4: "+secondNote+"sus4/"+firstNote);
				System.out.println("This is a pretty odd chord, son.");
			}
			
			else
			{
				System.out.println("A chord (girl) has no name ...");
			}
			System.out.println("\n");
		}
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


