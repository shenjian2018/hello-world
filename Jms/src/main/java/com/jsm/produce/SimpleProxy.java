package com.jsm.produce;

public class SimpleProxy implements Interface {
	private Interface proxied;

	public SimpleProxy(Interface proxied) {
		this.proxied = proxied;
	}

	@Override
	public void doSomething() {
		System.out.println("SimpleProxy doSomething");
		proxied.doSomething();
	}

	@Override
	public void somethingElse(String args) {
		System.out.println("SimpleProxy somethingElse" + args);
		proxied.somethingElse(args);
	}

}
