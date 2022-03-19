/**
 * 
 */
package com.vincentricciuti.umlGenerator.Cleaner;

/**
 * UMLGenCleaner
 * 
 * @author Vincent
 *
 */
public class UMLGenCleaner {
    public String removePackage(String field) {
	// For fields of some generic class
	if (field.substring(1).contains("<")) {
	    String outerField = field.substring(0, field.indexOf("<"));
	    String genericParameterType = field.substring(field.indexOf("<") + 1);
	    String genericTypeWithoutPackage = removePackage(genericParameterType);
	    outerField += "<" + genericTypeWithoutPackage;
	    field = outerField;
	}

	if (field.contains("."))
	    field = field.substring(field.lastIndexOf(".") + 1);
	return field;
    }

    // To ensure method parameter brackets are curved, not square
    public void replaceSquareBracketsWithParentheses(char[] charArr) {
	for (int i = 0; i < charArr.length; i++) {
	    if (charArr[i] == '[' && charArr[i - 1] == ' ') {
		charArr[i] = '(';
	    }

	    if (charArr[i] == ']' && !(charArr[i - 1] == '[')) {
		charArr[i] = ')';
	    }
	}
    }
}
