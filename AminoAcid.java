public class AminoAcid {
	private String acidCodon;
	private int acidCount;
	
	// Class written to allow for an acid and how many of that acid there are
	public AminoAcid(String acid, int count) {
		this.acidCodon = acid;
		this.acidCount = count;
	}
	
	public String getAcidCodon() {
		return this.acidCodon;
	}
	
	public int getAcidCount() {
		return this.acidCount;
	}
	
	public void setAcidCodon(String codon) {
		this.acidCodon = codon;
	}
	
	public void setAcidCount(int count) {
		this.acidCount = count;
	}
	
	public String toString() {
		return this.getAcidCodon() + " : " + this.getAcidCount();
	}
}