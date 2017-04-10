import java.util.ArrayList;

/**
 * @author Ahmet Oruç
 * It was created to keep the patient prescription.
 */
public class Patient {

	private String patientName;
	private String patientSsi;
	private String date;
	private String [][] patientDrug;
	
	/**
	 * It creates a patient objects.
	 * @param lines Lines read from the Prescription file.
	 */
	public Patient(ArrayList<String> lines){
		
		String [] splitStr = lines.get(0).split("\t");
		int size = lines.size();
		this.patientDrug = new String[size-1][3];
		
		this.patientName = splitStr[0];
		this.patientSsi = splitStr[1];
		this.date = splitStr[2];
		
		for(int i=1;i<size;i++){
			splitStr = lines.get(i).split("\t");
			this.patientDrug[i-1][0] = splitStr[0];
			this.patientDrug[i-1][2] = splitStr[1];
		}
	}
/**
 * Patient's social security administration get.
 * @return patientSsi
 */
	public String getPatientSsi() {
		return patientSsi;
	}
/**
 * Patient's prescription get.
 * @return date
 */
	public String getDate() {
		return date;
	}
/**
 * List of patient's drugs get.
 * @return patientDrug
 */
	public String[][] getPatientDrug() {
		return patientDrug;
	}
/**
 * Price of patient's drugs change
 * @param index Drug's index
 * @param value Drug's minimum price
 */
	public void setPatientDrug(int index,String value){
		this.patientDrug[index][1]= value;
	}
}
