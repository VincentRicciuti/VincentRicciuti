/**
 * 
 */
package com.vincentricciuti.umlGenerator.Cleaner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.vincentricciuti.umlGenerator.Cleaner.UMLGenCleaner;

/**
 * CleanerTests
 * 
 * @author Vincent
 *
 */
public class CleanerTests {
    private UMLGenCleaner uMLGenCleaner;

    @BeforeEach
    public void init() {
	uMLGenCleaner = new UMLGenCleaner();
    }

    @Test
    public void test_that_removePackage_does_nothing_when_input_field_has_no_package() {
	String testField = "char";

	String result = uMLGenCleaner.removePackage(testField);

	assertEquals("char", result);
    }

    @Test
    public void test_that_removePackage_removes_all_characters_before_final_period_symbol() {
	String testField = "package.abc.Char";

	String result = uMLGenCleaner.removePackage(testField);

	assertEquals("Char", result);
    }

    @Test
    public void test_that_removePackage_removes_all_characters_before_final_period_symbol_for_generic_types() {
	String testField = "package.abc.SomeList<anotherPackage.def.SomeWrapper>";

	String result = uMLGenCleaner.removePackage(testField);

	assertEquals("SomeList<SomeWrapper>", result);
    }

    @Test
    public void test_that_removePackage_removes_all_characters_before_final_period_symbol_for_nested_generic_types() {
	String testField = "package.abc.SomeList<<package.def.NestedList<thirdPackage.ghi.ThirdType>>";

	String result = uMLGenCleaner.removePackage(testField);

	assertEquals("SomeList<<NestedList<ThirdType>>", result);
    }
}
