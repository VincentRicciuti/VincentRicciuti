/**
 * 
 */
package com.vincentricciuti.umlGenerator.Extractor;

import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import com.vincentricciuti.umlGenerator.Cleaner.UMLGenCleaner;
import com.vincentricciuti.umlGenerator.Converter.UMLGenConverter;

/**
 * UMLGenExtractor
 * 
 * @author Vincent
 *
 */
public class UMLGenExtractor {
    
    private UMLGenConverter uMLGenConverter = new UMLGenConverter();
    private UMLGenCleaner uMLGenCleaner = new UMLGenCleaner();
    
    public <T> void extractClassName(Class<T> inputClass, StringBuilder inputStringBuilder) {
	inputStringBuilder.append(inputClass.getSimpleName() + '\n');
    }

    public <T> void extractFields(Class<T> inputClass, StringBuilder inputStringBuilder) {
	Arrays.stream(inputClass.getDeclaredFields()).forEach(field -> {
	    String fieldModifiers = uMLGenConverter.convertFieldModifersToUMLSymbols(field);
	    String fieldName = field.getName();
	    String fieldGenericType = field.getGenericType().getTypeName();

	    String fieldType = uMLGenCleaner.removePackage(fieldGenericType);

	    inputStringBuilder.append(fieldModifiers + " " + fieldName + " : " + fieldType + '\n');
	});
    }

    public <T> void extractMethods(Class<T> inputClass, StringBuilder inputStringBuilder) {
	Arrays.stream(inputClass.getDeclaredMethods()).forEach(method -> {
	    Parameter[] methodParametersArray = method.getParameters();
	    Type[] genericParameterTypes = method.getGenericParameterTypes();

	    Function<Type, String> typeToString = param -> uMLGenCleaner.removePackage(param.getTypeName());
	    List<String> paramTypeList = Arrays.stream(genericParameterTypes).map(typeToString).toList();

	    Function<Parameter, String> parameterName = param -> param.getName();
	    List<String> paramNameList = Arrays.stream(methodParametersArray).map(parameterName).toList();

	    List<String> paramWithNameList = new ArrayList<>();
	    for (int i = 0; i < paramTypeList.size(); i++) {
		paramWithNameList.add(paramTypeList.get(i) + " " + paramNameList.get(i));
	    }

	    String methodModifiers = uMLGenConverter.convertMethodModifiersToUMLSymbol(method);
	    String methodSimpleName = method.getName();
	    String methodParameters = paramWithNameList.toString();
	    String methodReturnType = method.getReturnType().getSimpleName().toString();

	    inputStringBuilder.append(methodModifiers + " " + methodSimpleName + " " + methodParameters + " : "
		    + methodReturnType + '\n');
	});
    }
}
