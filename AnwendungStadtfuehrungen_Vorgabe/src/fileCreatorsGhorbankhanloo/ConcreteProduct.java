package fileCreatorsGhorbankhanloo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteProduct extends ReaderProductGhorbankhanloo{
	private BufferedReader ein;
	
	public ConcreteProduct()throws IOException {
		
		 ein = new BufferedReader(new FileReader("Teppich.csv"));
	}

	@Override
	public String[] leseAusDatei() throws IOException {
		
		return  ein.readLine().split(";");
		
	}

	@Override
	public void schliesseDatei() throws IOException {
		
		ein.close();
	}
	
	

}
