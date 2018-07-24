/*
 *  Name         : Andrew Hartwell
 *  CruzID       : arhartwe
 *  Assignment   : pa1
*/

import java.io.*;
import java.util.Scanner;

class Lex
{
	public static void main(String[] args) throws IOException
	{
		Scanner in = null;
		Scanner insert = null;
		PrintWriter out = null;
		String line = null;
		int lineNumber = 0;
		List indices = new List();

		if(args.length < 2) // User must specify input and output file
		{
			System.err.println("Usage: FileIO infile outfile");
			System.exit(1);
		}	

		in = new Scanner(new File(args[0]));
		out = new PrintWriter(new FileWriter(args[1]));
		
		while(in.hasNextLine()) // Count number of lines (i.e. strings) of input file.
		{
			lineNumber++;
			in.nextLine();
		}
		
		insert = new Scanner(new File(args[0]));
		String[] words = new String[lineNumber];
		int i = 0;
	
		while(insert.hasNextLine()) // Place input file strings into array
		{
			words[i] = insert.nextLine();
			i++;
		}	
		
		indices.append(0);
		
		for(int j = 1; j < words.length; j++) // Indirectly sorts strings using List ADT
		{
			indices.moveFront();
			
			while(words[j].compareTo(words[indices.get()]) > 0)
			{
				if(indices.length() == 1)
				{
					indices.append(j);
				}
				if(indices.length() == indices.index()+1)
				{
					indices.append(j);
				}
				indices.moveNext();
			}
			
			if(words[j].compareTo(words[indices.get()]) < 0)
			{
				indices.insertBefore(j);
			}
			
					
		}
		
		indices.moveFront();
		int x;
		while(indices.index() >= 0) // Prints alphabetized strings to output file
		{
			x = indices.get();
			out.println(words[x]);
			indices.moveNext();
		}		

		in.close();
		out.close();
	}
}
