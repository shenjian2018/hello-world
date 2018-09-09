package learn.tes;

public class IntegerFactory implements FatoryI<Integer>{

	@Override
	public Integer create() {
		
		return new Integer(0);
	}


}
