package com.fanxing;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
	private Class[] types = { Lattee.class };
	private Random rand = new Random(47);

	public CoffeeGenerator() {
	}

	private int size = 0;

	public CoffeeGenerator(int sz) {
		sz = size;
	}

	@Override
	public Coffee next() {

		try {
			return (Coffee) types[rand.nextInt(types.length)].newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Iterator<Coffee> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
