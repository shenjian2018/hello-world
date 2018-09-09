package learn.tes;

public class Widget implements FatoryI<Widget> {

	@Override
	public Widget create() {
		
		return new Widget();
	}

}
