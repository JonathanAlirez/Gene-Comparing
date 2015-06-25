# Gene-Comparing
Compare 2 DNA strands (random and actual)

This is a project where you can produce up to 2 different DNA strands and compare them. If you don't have two, or simply 
don't want to create a 2 million line DNA strand, this program will randomly generate one for you. It will compare two
DNA strands and will show you some basic information about it (more to come). 

# Steps the program takes to find results
1.) It does this by changing the DNA into amino acids codons, and writing it to a file, all in one step to save time.</br>
2.) It reads the amino acid files and puts them into two ArrayLists that use the AminoAcid class that allows</br>
for both the acid name, and the amount of times it is present in the list.</br>
3.) After it has two amino acid ArrayLists with all 64 combinations and times each acid appears in the files, it
prints them out to a file.

# Thoughts on speed
This program has the ability to write 60 million different DNA strands, put them into their respected amino acid codons,
and see how often each of the codons are present in each strand in less than 20 seconds.
I would like to see this go faster, but from my computer, that seems to be as fast as I can get.
```
How many DNA sequences to write: 30000000
Started at: 3:39:09 AM
DNA Strand 1 has been created... : 3 seconds
DNA Strand 2 has been created... : 3 seconds
DNA Strand 1 has been turned into amino acid pairs : 3 seconds
DNA Strand 2 has been turned into amino acid pairs : 2 seconds
DNA Strand 1 is being compared to DNA Strand 2...
Compare complete! : 5 seconds
Complete in: 19 seconds @ 3:39:28 AM
```

# Considerations for further implementations
I would like to see this program grow to being able to be used to process not only how many times a amino acid codons is
present, but would like to see if it could detect patterns in the codons to get a percentage of how closly related the
2 DNA strands are to one another.
