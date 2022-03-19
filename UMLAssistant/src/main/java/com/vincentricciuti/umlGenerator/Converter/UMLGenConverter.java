/**
 * 
 */
package com.vincentricciuti.umlGenerator.Converter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * UMLGenConverter
 * 
 * @author Vincent
 *
 */
public class UMLGenConverter {
    public String convertFieldModifersToUMLSymbols(Field field) {
	String[] fieldModifiers = Modifier.toString(field.getModifiers()).split(" ");
	return convertStringsToUMLSymbols(fieldModifiers);
    }

    public String convertMethodModifiersToUMLSymbol(Method method) {
	String[] methodModifiers = Modifier.toString(method.getModifiers()).split(" ");
	return convertStringsToUMLSymbols(methodModifiers);
    }

    // TODO
    public <T> String convertClassModifiersToUMLSymbol(Class<T> abc) {
	String[] classModifiers = Modifier.toString(abc.getModifiers()).split(" ");
	return "";
    }

    private static String convertStringsToUMLSymbols(String[] modifiers) {
	for (String modifier : modifiers) {
	    switch (modifier) {
	    case "private":
		return "-";
	    case "public":
		return "+";
	    case "protected":
		return "#";
	    }
	}
	return "";
    }

    // TODO
    private static String convertClassModifiersToUMLSymbols(String[] modifiers) {
	List<String> modifierList = Arrays.asList(modifiers);
	List<String> outList = new ArrayList<>();
	
	for (String m : modifierList) {
	    switch (m) {
	    case "interface":
		modifierList.set(modifierList.indexOf(m), "<<interface>>");
		break;

	    default:
		break;
	    }
	}
	return modifierList.toString();
    }
}
