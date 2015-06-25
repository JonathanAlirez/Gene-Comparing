package com.fiberdevelopers.gene.aminoacids;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class GeneAminoAcids {

	public GeneAminoAcids() {
	}

	// changes DNA into codon pairs (includes switching T -> U)
	public void generateAminos(File f1, File f2, int num) {
		try {
			BufferedReader file1 = new BufferedReader(new FileReader(f1));
			PrintWriter pw = new PrintWriter(f2);
			String temp;
			int count = 0; // count to print a newline (allows for UUG \n GUU)
			int overallCount = 0; // no extra line at the end
			while ((temp = file1.readLine()) != null) {
				count++;
				overallCount++;
				if (temp.equals("T"))
					pw.print("U");
				else
					pw.print(temp);
				if (count == 3 && overallCount != num) {
					count = 0;
					pw.println();
				}
			}
			pw.close();
			file1.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
}