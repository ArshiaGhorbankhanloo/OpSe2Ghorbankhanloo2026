package fileCreatorsGhorbankhanloo;

import java.io.IOException;

public class ConcreteCreator extends ReaderCreatorGhorbankhanloo{

	@Override
	public ReaderProductGhorbankhanloo factoryMethod() throws IOException {
		// TODO Auto-generated method stub
		return new ConcreteProduct();
	}

}
