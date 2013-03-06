package org.rjava.restriction.rulesets;

import org.rjava.restriction.RestrictionRuleset;
import org.rjava.restriction.rules.NoCastOnMagicType;
import org.rjava.restriction.rules.NoDynamicLoading;
import org.rjava.restriction.rules.NoException;
import org.rjava.restriction.rules.NoReflection;
import org.rjava.restriction.rules.NoExplicitLibrary;
import org.rjava.restriction.rules.NoEnum;

@RestrictionRuleset

@NoDynamicLoading
@NoReflection
@NoException
@NoCastOnMagicType
@NoExplicitLibrary
@NoEnum
public @interface RJavaCore {

}
