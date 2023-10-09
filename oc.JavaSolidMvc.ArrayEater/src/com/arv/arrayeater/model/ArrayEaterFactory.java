package com.arv.arrayeater.model;


/**
 * pattern FACTORY
 */
public class ArrayEaterFactory {
	
	
	public enum ArrayEaterType {
		Type1, Type2, Type3
	};

	
	public static ArrayEater makeArray(int dimTab) {

		return new ArrayEater(dimTab);
	}

}
