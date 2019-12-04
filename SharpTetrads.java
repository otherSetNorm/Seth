/*Seth Norman
 * This program identifies tetrad chords based on input of 4 notes.
 * It is currently limited to identifying chords where the bottom note and the top note are within an octave of each other. 
 */

import java.io.File;
import java.util.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip; 

public class SharpTetrads 
{

	public static void main(String[] args) 
	{
		
		String [] notesArray = {"C","C#","D","D#","E","F","F#","G","G#","A","A#","B"};
		List<String> notesList = Arrays.asList(notesArray);
		List<String>selectedNotesList = new LinkedList<String>(); 
		String selectedNotes= "";
		
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
			
			System.out.println("Enter fourth note > ");
			String fourthNote = scan.next();
			selectedNotesList.add(fourthNote);
			
			System.out.println("\n");
			for (int i = 0; i<= notesArray.length; i++)
			{
				if(fourthNote.equalsIgnoreCase(notesArray[i]))
				{
					//System.out.println("Note entered successfully");
					File firstNoteFile = new File("C://Users//snorm//Desktop//Su_2019//Fun with Java//12 scale sharps//"+fourthNote+".WAV");  
					playNote(firstNoteFile);
					break; //Note that if first note is not found, loop will not stop (effectively creating an error)
				}
			}
			
			selectedNotes = firstNote +"  "+secondNote + "  " + thirdNote+ "  " + fourthNote; 
			
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
			int interval3 = sortedNotesList.indexOf(fourthNote)-sortedNotesList.indexOf(thirdNote);
			
			//uncommment line below if you want to see intervals (in units of semitones)
	//		System.out.println("First interval is  "+interval1 +" semitones." +"\nSecond interval is " +interval2+" semitones.");
			
			//major 6th - root and 3 inversions - La fille aux cheveux de lin
			//NOTE: major 6th chords has a doppleganger in the form of a minor 7th chord
			if(interval1 == 4 && interval2 == 3 && interval3 == 2)
			{
				System.out.println(selectedNotes +" make\t "+firstNote+ "maj6 chord");
				System.out.println("this is also 1st inverson minor 7th chord: \t"+fourthNote+"min7/"+firstNote);
			}
			
			else if(interval1 == 3 && interval2 == 2 && interval3 == 3)
			{
				System.out.println(selectedNotes + " make 1st inversion major 6th chord: \t" +fourthNote+"maj6/" +firstNote );
				System.out.println("This is also 2nd inversion minor 7th chord: \t" +thirdNote+"min7/"+firstNote);
			}
			
			else if(interval1 == 2 && interval2 == 3 && interval3 == 4)
			{
				System.out.println(selectedNotes + " make 2nd inversion major 6th chord: \t" +thirdNote+"maj6/" +firstNote);
				System.out.println("This is also 3rd inversion minor 7th chord: \t" +secondNote+"min7/"+firstNote);
			}
		
			else if(interval1 == 3 && interval2 == 4 && interval3 == 3)
			{
				System.out.println(selectedNotes + " make 3rd inversion major 6th chord: \t" +secondNote+"maj6/" +firstNote);
				System.out.println("this is also " +firstNote+ "min7 in root position" );
			}
			
			//minor 7th chord - root and 3 inversions
			//3,4,3 - root (same as 3rd inv for maj 6th)
			//4,3,2 - 1st inv (same as root for maj6)
			//3,2,3 - 2nd inv (same as 1st inv for maj6)
			
			//dom7 - the beast 
			else if(interval1 == 4 && interval2 == 3 && interval3 == 3)
			{
				System.out.println(selectedNotes + " make dominant 7th chord: \t" +firstNote+"dom7");
			}
			
			else if(interval1 == 3 && interval2 == 3 && interval3 == 2)
			{
				System.out.println(selectedNotes + " make 1st inversion of dom7 chord: " +fourthNote+"dom7/"+firstNote);
			}
			
			else if (interval1 == 3 && interval2 == 2 && interval3 == 4)
			{
				System.out.println(selectedNotes + " make 2nd inversion of dom7 chord: " +thirdNote+"dom7/"+firstNote);
			}
			
			else if (interval1 == 2 && interval2 == 4 && interval3 == 3)
			{
				System.out.println(selectedNotes + " make 3rd inversion of dom7 chord: " +secondNote+"dom7/"+firstNote);
			}
			
			//
			//major 7th - merry christmas 			
			else if (interval1 == 4 && interval2 == 3 && interval3 == 4)
			{
				System.out.println(selectedNotes + " make major 7th chord: " +firstNote+"maj7");
			}
			
			else if (interval1 == 3 && interval2 == 4 && interval3 == 1)
			{
				System.out.println(selectedNotes + " make 1st inversion of maj7 chord: " +fourthNote+"maj7/"+firstNote);
			}
			
			else if (interval1 == 4 && interval2 == 1 && interval3 == 4)
			{
				System.out.println(selectedNotes + " make 2nd inversion of maj7 chord: " +thirdNote+"maj7/"+firstNote);
			}
			
			else if (interval1 == 1 && interval2 == 4 && interval3 == 3)
			{
				System.out.println(selectedNotes + " make 3rd inversion of maj7 chord: " +secondNote+"maj7/"+firstNote);
			}

			else
			{
				System.out.println("Chord cannot yet be identified due to program limitations");
			}
			
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