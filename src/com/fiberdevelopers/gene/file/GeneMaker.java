package com.fiberdevelopers.gene.file;

import java.io.File;
import java.io.PrintWriter;
import java.util.Random;

public class GeneMaker {
	
	// Write to File for Random generated DNA strands
	public void writeToFile(File f, int num) {
		try {
			boolean isLast = false;
			PrintWriter pw = new PrintWriter(f);
			for (int i = 0; i < num; i++) {
				if (i == num - 1)
					isLast = true;
				Random r = new Random();
				int ran = r.nextInt(100);
				if (ran <= 24)
					pw.print("A");
				if (ran >= 25 && ran <= 49)
					pw.print("T");
				if (ran >= 50 && ran <= 74)
					pw.print("C");
				if (ran >= 75 && ran <= 99)
					pw.print("G");
				if (isLast == false)
					pw.println();
			}
			pw.close();
		} catch (Exception e) {
		}
	}
}