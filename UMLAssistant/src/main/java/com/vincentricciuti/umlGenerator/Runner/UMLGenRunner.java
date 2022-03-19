/**
 *
 */
package com.vincentricciuti.umlGenerator.Runner;

import com.vincentricciuti.umlGenerator.ExampleClass;
import com.vincentricciuti.umlGenerator.UMLGenerator;

/**
 * UMLGenRunner
 *
 * @author Vincent
 *
 */
public class UMLGenRunner {
    public static void main(String[] args) {
	UMLGenerator uml = new UMLGenerator();
	ExampleClass exampleInstance = new ExampleClass();
	uml.classToClassDiagramSystemOut(exampleInstance.getClass());
    }
}
