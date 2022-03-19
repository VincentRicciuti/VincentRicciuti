/**
 * 
 */
package com.vincentricciuti.umlGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * ExampleClass
 * 
 * @author Vincent
 *
 */
public class ExampleClass {

    private String stringField = "Here is a string.";
    public static int intField = 80;
    protected List<Integer> intList = new ArrayList<>();
    
    public void noParamMethod() {
	
    }
    
    public int singleParamMethod(int input) {
	return input * 5;
    }
    
    public Long doubleParamMethod(int input1, long input2) {
	return input1 * input2;
    }
    
    static protected String referenceTypeParamMethod(String str) {
	return "Another string.";
    }
    
    private double[] arrayTypeParamMethod(double[] arr) {
	return arr;
    }
    
    public List<String> genericMethod(List<String> list, List<Integer> abc, List<List<Character>> chars) {
	return list;
    }
    
}
