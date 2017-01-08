package org.wahlzeit.model;

public @interface PatternInstance {
	String patternName() default "unknown";

	String[] participants() default {};
}
