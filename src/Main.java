
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Ahmet Oruç
 * It is the class where the process.
 */
public class Main {

	/**
	 * Main programming.
	 * @param args It takes a look at the file names as arguments.
	 * @throws IOException The error occurs when it can not find the file.
	 * @throws ParseException Date conversion is not possible in findDrug function, an error occurs.
	 */
	public static void main(String[] args) throws IOException, ParseException{
		
		int size;
		
		/*read the prescription test file*/		
		ReadFile rPatient = new ReadFile();
		rPatient.read(args[0]);
		
		/*Object of patient is created from the readings prescription file */
		Patient patient = new Patient(rPatient.line);
		
		/*read the medicaments test file*/
		ReadFile rDrug = new ReadFile();
		rDrug.read(args[1]);
		
		/*Object of drugs are created from the readings medicaments file*/
		size = rDrug.line.size();
		Drug [] drugList = new Drug[size];
		
		for(int i = 0;i<size;i++){
			String [] splitLine = rDrug.line.get(i).split("\t");
			drugList[i] = new Drug(splitLine); 
		}
		
		findDrug(drugList, patient);
		endOutput(patient.getPatientDrug());
		
	}
	
	/**
	 * Patient prices of medicines finds from the list.
	 * This search is done by name of drug,social security administration and date.
	 * Select the smallest of the fair value to the equation.
	 * @param rd Drug object.
	 * @param rp Patient object
	 * @throws ParseException Date conversion is not possible, an error occurs.
	 */
	public static void findDrug(Drug [] rd,Patient rp) throws ParseException{
		
		DateFormat df = new SimpleDateFormat("dd.mm.yyyy");
		double minPrice;
		
		for(int j=0;j<rp.getPatientDrug().length;j++){
			minPrice = 0.0;
			for(int i=0;i<rd.length;i++)
			{
				if(rd[i].getDrugName().equals(rp.getPatientDrug()[j][0]))
				{
					if(rd[i].getDrugSsi().equals(rp.getPatientSsi()))
					{
						if(df.parse(rd[i].getStartDate()).before(df.parse(rp.getDate())))
						{
							if(df.parse(rd[i].getFinishDate()).after(df.parse(rp.getDate())))
							{
								if(minPrice>Double.parseDouble(rd[i].getDrugPrice()) || rp.getPatientDrug()[j][1] ==null)
								{
									minPrice=Double.parseDouble(rd[i].getDrugPrice());
									rp.setPatientDrug(j, rd[i].getDrugPrice());
									
								}
							}
						}
					}
				}
			}
		}
		
	}

	/**
	 * Then prints the price the patient's medication.
	 * @param rp Drugs' list of Patient object.
	 */
	public static void endOutput(String[][] rp){
		
		double total = 0.0, drugTotal = 0.0;
		
		for(int i = 0; i<rp.length;i++){
			for(int j = 0;j<rp[0].length;j++){
				if(j!=1){
					System.out.print(rp[i][j] + "\t");
				}
				if(j==1){
					drugTotal = Double.parseDouble(rp[i][j])*Double.parseDouble(rp[i][j+1]);
					System.out.printf("%.2f\t" ,Double.parseDouble(rp[i][j]) );
					total += drugTotal;
				}
			}
			System.out.printf("%.2f\n" , drugTotal);
		}
		
		System.out.printf("total\t%.2f" , total);
		
	}
}
