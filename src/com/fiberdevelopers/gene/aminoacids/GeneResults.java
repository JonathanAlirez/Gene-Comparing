package com.fiberdevelopers.gene.aminoacids;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GeneResults {
	// both ArrayLists with a custom AminoAcid class
	ArrayList<AminoAcid> aminoAcidsList1 = new ArrayList<AminoAcid>();
	ArrayList<AminoAcid> aminoAcidsList2 = new ArrayList<AminoAcid>();

	public GeneResults() {
	}
	
	// generate results for all the amino acids in files
	// f1 = first amino acid list, f2 = second, f3 is the result file to write to
	public void generateAminoResults(File f1, File f2, File f3) {
		try {
			fillAminoAcids(f1, aminoAcidsList1);
			fillAminoAcids(f2, aminoAcidsList2);
			PrintWriter pw = new PrintWriter(f3);
			pw.println("List of codons and appearances");
			pw.println("-------------------------------------");
			pw.println("DNA 1:\t\t\tDNA 2:");
			boolean isLast = false;
			// Printing all the amino acids to the file
			for (int i = 0; i < aminoAcidsList1.size(); i++) {
				if (i == aminoAcidsList1.size() - 1)
					isLast = true;
				pw.print(aminoAcidsList1.get(i).toString() + "\t\t\t"
						+ aminoAcidsList2.get(i).toString());
				if (!isLast)
					pw.println();
			}
			pw.close();
		} catch (Exception e) {
		}
	}

	// this adds to each arraylist the amino acids made from the GeneAminoAcids class
	// This takes the file where the amino acids are stored, and puts them in the arrayList
	private void fillAminoAcids(File f1, ArrayList<AminoAcid> ar) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader(f1));
			String temp;
			while ((temp = bf.readLine()) != null) {
				boolean added = false;
				// if array is bigger than 0, otherwise it is empty and just add first one !
				if (ar.size() > 0) {
					// Loop through the size and add 1 if the amino acid is a duplicate
					// or add it to the list if it isn't
					for (int i = 0; i < ar.size(); i++) {
						if (ar.get(i).getAcidCodon().equals(temp)) {
							ar.get(i)
									.setAcidCount(ar.get(i).getAcidCount() + 1);
							added = true;
							break;
						}
					}
					if (added == false) {
						ar.add(new AminoAcid(temp, 1));
					}
				} else {
					// ! adding the first one
					ar.add(new AminoAcid(temp, 1));
				}
			}
			bf.close();
		} catch (Exception e) {
		}
	}
}