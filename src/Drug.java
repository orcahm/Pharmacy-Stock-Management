/**
 * @author Ahmet Oruç
 * It was created to keep the drug list.
 */
public class Drug {
	
	private String drugName;
	private String drugSsi;
	private String startDate;
	private String finishDate;
	private String drugPrice;
	
	/**
	 * It creates a drug objects.
	 * @param lines Lines read from the medicaments file.
	 */
	public Drug(String [] lines){
		
		this.drugName = lines[0];
		this.drugSsi = lines[1];
		this.startDate = lines[2];
		this.finishDate = lines[3];
		this.drugPrice = lines[4];
		
	}
	/**
	 * Drug's name get.
	 * @return drugName
	 */
	public String getDrugName() {
		return drugName;
	}
	/**
	 * Drug's social security administration get.
	 * @return drugSsi
	 */
	public String getDrugSsi() {
		return drugSsi;
	}
	/**
	 * Drug's start date get.
	 * @return startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * Drug's finish date get.
	 * @return finishDate
	 */
	public String getFinishDate() {
		return finishDate;
	}
	/**
	 * Drug's price get.
	 * @return drugPrice
	 */
	public String getDrugPrice() {
		return drugPrice;
	}
}
