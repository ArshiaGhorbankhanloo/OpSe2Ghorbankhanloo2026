package fileCreatorsGhorbankhanloo;

import java.io.IOException;

public class ConcreteTXTcreator extends ReaderCreatorGhorbankhanloo{

	@Override
	public ReaderProductGhorbankhanloo factoryMethod() throws IOException {
		
		return new ConcreteTXTproduct();
	}

}
