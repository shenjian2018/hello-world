package com.jsm.produce;

public class RealObject implements Interface {

	@Override
	public void doSomething() {
		System.out.println("");
	}

	@Override
	public void somethingElse(String args) {
		System.out.println("somethingElse" + args);
	}

}
