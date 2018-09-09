package learn.tes;

public class Foo2<T> {
	private T x;

	public <F extends FatoryI<T>> Foo2(F factory) {
		x=factory.create();
	}

}
