package org.rjava.restriction.rules;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import org.rjava.restriction.RestrictionRule;

@RestrictionRule
@Target(ElementType.FIELD)
@Deprecated
public @interface RegisterField {

}
