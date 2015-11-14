import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class GeneLogic {
	File dna1 = new File("Dna1.txt");
	File dna2 = new File("Dna2.txt");
	File amino1 = new File("amino1.txt");
	File amino2 = new File("amino2.txt");
	File results = new File("results.txt");
	SimpleDateFormat sdf = new SimpleDateFormat("h:mm:ss a"); // user friendly time
	GeneMaker geneMaker = new GeneMaker();
	Date start, end, tStart, tEnd; // used to check how long each process is using
	long howLong; // the time in seconds ^

	public GeneLogic() {
	}

	public void start() {
		System.out.print("How many DNA sequences to write: ");
		Scanner s = new Scanner(System.in);
		int numOfLetters = s.nextInt();
		start = Calendar.getInstance().getTime();
		System.out.println("Started at: " + sdf.format(start));
		// If they choose an amount to randomly generate for DNA, if < 0 it will use the Files f1 and f2
		if (numOfLetters > 0) {
			geneMaker.writeToFile(dna1, numOfLetters);
			tEnd = Calendar.getInstance().getTime();
			howLong = tEnd.getTime() - start.getTime();
			System.out.println("DNA Strand 1 has been created..." + " : "
					+ howLong / 1000 + " seconds");
			tStart = tEnd;
			geneMaker.writeToFile(dna2, numOfLetters);
			tEnd = Calendar.getInstance().getTime();
			howLong = tEnd.getTime() - tStart.getTime();
			System.out.println("DNA Strand 2 has been created..." + " : "
					+ howLong / 1000 + " seconds");
		} // else for reading how many items are in 1 of the strands 
		else {
			try {
				BufferedReader scan = new BufferedReader(new FileReader(dna1));
				while (scan.readLine() != null) {
					numOfLetters++;
				}
				scan.close();
				tEnd = Calendar.getInstance().getTime();
				howLong = tEnd.getTime() - start.getTime();
				System.out.println("DNA Strands have been evaluated" + " : "
						+ howLong / 1000 + " seconds");
			} catch (FileNotFoundException e) {
			} catch (IOException e) {
			}
		}
		s.close();
		tStart = tEnd;
		GeneAminoAcids geneAmino = new GeneAminoAcids();
		GeneResults geneResults = new GeneResults();
		geneAmino.generateAminos(dna1, amino1, numOfLetters);
		tEnd = Calendar.getInstance().getTime();
		howLong = tEnd.getTime() - tStart.getTime();
		System.out.println("DNA Strand 1 has been turned into amino acid pairs"
				+ " : " + howLong / 1000 + " seconds");
		tStart = tEnd;
		geneAmino.generateAminos(dna2, amino2, numOfLetters);
		tEnd = Calendar.getInstance().getTime();
		howLong = tEnd.getTime() - tStart.getTime();
		System.out.println("DNA Strand 2 has been turned into amino acid pairs"
				+ " : " + howLong / 1000 + " seconds");
		System.out.println("DNA Strand 1 is being compared to DNA Strand 2...");
		tStart = tEnd;
		geneResults.generateAminoResults(amino1, amino2, results);
		end = Calendar.getInstance().getTime();
		howLong = end.getTime() - tStart.getTime();
		System.out.println("Compare complete!" + " : " + howLong / 1000 + " seconds");
		howLong = end.getTime() - start.getTime();
		System.out.println("Complete in: " + howLong / 1000 + " seconds"
				+ " @ " + sdf.format(end));
	}
}