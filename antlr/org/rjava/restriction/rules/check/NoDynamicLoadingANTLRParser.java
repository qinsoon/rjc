// $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g 2013-01-04 17:41:14

package org.rjava.restriction.rules.check;

import org.rjava.restriction.rules.NoDynamicLoading_CHECK;
import org.rjava.compiler.semantics.*;
import org.rjava.compiler.semantics.representation.*;
import org.rjava.compiler.semantics.symtab.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/** A Java 1.5 grammar for ANTLR v3 derived from the spec
 *
 *  This is a very close representation of the spec; the changes
 *  are comestic (remove left recursion) and also fixes (the spec
 *  isn't exactly perfect).  I have run this on the 1.4.2 source
 *  and some nasty looking enums from 1.5, but have not really
 *  tested for 1.5 compatibility.
 *
 *  I built this with: java -Xmx100M org.antlr.Tool java.g
 *  and got two errors that are ok (for now):
 *  java.g:691:9: Decision can match input such as
 *    "'0'..'9'{'E', 'e'}{'+', '-'}'0'..'9'{'D', 'F', 'd', 'f'}"
 *    using multiple alternatives: 3, 4
 *  As a result, alternative(s) 4 were disabled for that input
 *  java.g:734:35: Decision can match input such as "{'$', 'A'..'Z',
 *    '_', 'a'..'z', '\u00C0'..'\u00D6', '\u00D8'..'\u00F6',
 *    '\u00F8'..'\u1FFF', '\u3040'..'\u318F', '\u3300'..'\u337F',
 *    '\u3400'..'\u3D2D', '\u4E00'..'\u9FFF', '\uF900'..'\uFAFF'}"
 *    using multiple alternatives: 1, 2
 *  As a result, alternative(s) 2 were disabled for that input
 *
 *  You can turn enum on/off as a keyword :)
 *
 *  Version 1.0 -- initial release July 5, 2006 (requires 3.0b2 or higher)
 *
 *  Primary author: Terence Parr, July 2006
 *
 *  Version 1.0.1 -- corrections by Koen Vanderkimpen & Marko van Dooren,
 *      October 25, 2006;
 *      fixed normalInterfaceDeclaration: now uses typeParameters instead
 *          of typeParameter (according to JLS, 3rd edition)
 *      fixed castExpression: no longer allows expression next to type
 *          (according to semantics in JLS, in contrast with syntax in JLS)
 *
 *  Version 1.0.2 -- Terence Parr, Nov 27, 2006
 *      java spec I built this from had some bizarre for-loop control.
 *          Looked weird and so I looked elsewhere...Yep, it's messed up.
 *          simplified.
 *
 *  Version 1.0.3 -- Chris Hogue, Feb 26, 2007
 *      Factored out an annotationName rule and used it in the annotation rule.
 *          Not sure why, but typeName wasn't recognizing references to inner
 *          annotations (e.g. @InterfaceName.InnerAnnotation())
 *      Factored out the elementValue section of an annotation reference.  Created
 *          elementValuePair and elementValuePairs rules, then used them in the
 *          annotation rule.  Allows it to recognize annotation references with
 *          multiple, comma separated attributes.
 *      Updated elementValueArrayInitializer so that it allows multiple elements.
 *          (It was only allowing 0 or 1 element).
 *      Updated localVariableDeclaration to allow annotations.  Interestingly the JLS
 *          doesn't appear to indicate this is legal, but it does work as of at least
 *          JDK 1.5.0_06.
 *      Moved the Identifier portion of annotationTypeElementRest to annotationMethodRest.
 *          Because annotationConstantRest already references variableDeclarator which
 *          has the Identifier portion in it, the parser would fail on constants in
 *          annotation definitions because it expected two identifiers.
 *      Added optional trailing ';' to the alternatives in annotationTypeElementRest.
 *          Wouldn't handle an inner interface that has a trailing ';'.
 *      Swapped the expression and type rule reference order in castExpression to
 *          make it check for genericized casts first.  It was failing to recognize a
 *          statement like  "Class<Byte> TYPE = (Class<Byte>)...;" because it was seeing
 *          'Class<Byte' in the cast expression as a less than expression, then failing
 *          on the '>'.
 *      Changed createdName to use typeArguments instead of nonWildcardTypeArguments.
 *         
 *      Changed the 'this' alternative in primary to allow 'identifierSuffix' rather than
 *          just 'arguments'.  The case it couldn't handle was a call to an explicit
 *          generic method invocation (e.g. this.<E>doSomething()).  Using identifierSuffix
 *          may be overly aggressive--perhaps should create a more constrained thisSuffix rule?
 *
 *  Version 1.0.4 -- Hiroaki Nakamura, May 3, 2007
 *
 *  Fixed formalParameterDecls, localVariableDeclaration, forInit,
 *  and forVarControl to use variableModifier* not 'final'? (annotation)?
 *
 *  Version 1.0.5 -- Terence, June 21, 2007
 *  --a[i].foo didn't work. Fixed unaryExpression
 *
 *  Version 1.0.6 -- John Ridgway, March 17, 2008
 *      Made "assert" a switchable keyword like "enum".
 *      Fixed compilationUnit to disallow "annotation importDeclaration ...".
 *      Changed "Identifier ('.' Identifier)*" to "qualifiedName" in more
 *          places.
 *      Changed modifier* and/or variableModifier* to classOrInterfaceModifiers,
 *          modifiers or variableModifiers, as appropriate.
 *      Renamed "bound" to "typeBound" to better match language in the JLS.
 *      Added "memberDeclaration" which rewrites to methodDeclaration or
 *      fieldDeclaration and pulled type into memberDeclaration.  So we parse
 *          type and then move on to decide whether we're dealing with a field
 *          or a method.
 *      Modified "constructorDeclaration" to use "constructorBody" instead of
 *          "methodBody".  constructorBody starts with explicitConstructorInvocation,
 *          then goes on to blockStatement*.  Pulling explicitConstructorInvocation
 *          out of expressions allowed me to simplify "primary".
 *      Changed variableDeclarator to simplify it.
 *      Changed type to use classOrInterfaceType, thus simplifying it; of course
 *          I then had to add classOrInterfaceType, but it is used in several
 *          places.
 *      Fixed annotations, old version allowed "@X(y,z)", which is illegal.
 *      Added optional comma to end of "elementValueArrayInitializer"; as per JLS.
 *      Changed annotationTypeElementRest to use normalClassDeclaration and
 *          normalInterfaceDeclaration rather than classDeclaration and
 *          interfaceDeclaration, thus getting rid of a couple of grammar ambiguities.
 *      Split localVariableDeclaration into localVariableDeclarationStatement
 *          (includes the terminating semi-colon) and localVariableDeclaration.
 *          This allowed me to use localVariableDeclaration in "forInit" clauses,
 *           simplifying them.
 *      Changed switchBlockStatementGroup to use multiple labels.  This adds an
 *          ambiguity, but if one uses appropriately greedy parsing it yields the
 *           parse that is closest to the meaning of the switch statement.
 *      Renamed "forVarControl" to "enhancedForControl" -- JLS language.
 *      Added semantic predicates to test for shift operations rather than other
 *          things.  Thus, for instance, the string "< <" will never be treated
 *          as a left-shift operator.
 *      In "creator" we rule out "nonWildcardTypeArguments" on arrayCreation,
 *          which are illegal.
 *      Moved "nonWildcardTypeArguments into innerCreator.
 *      Removed 'super' superSuffix from explicitGenericInvocation, since that
 *          is only used in explicitConstructorInvocation at the beginning of a
 *           constructorBody.  (This is part of the simplification of expressions
 *           mentioned earlier.)
 *      Simplified primary (got rid of those things that are only used in
 *          explicitConstructorInvocation).
 *      Lexer -- removed "Exponent?" from FloatingPointLiteral choice 4, since it
 *          led to an ambiguity.
 *
 *      This grammar successfully parses every .java file in the JDK 1.5 source
 *          tree (excluding those whose file names include '-', which are not
 *          valid Java compilation units).
 *
 *  Known remaining problems:
 *      "Letter" and "JavaIDDigit" are wrong.  The actual specification of
 *      "Letter" should be "a character for which the method
 *      Character.isJavaIdentifierStart(int) returns true."  A "Java
 *      letter-or-digit is a character for which the method
 *      Character.isJavaIdentifierPart(int) returns true."
 */
@SuppressWarnings({"all", "warnings", "unchecked"})
public class NoDynamicLoadingANTLRParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ABSTRACT", "AMP", "AMPAMP", "AMPEQ", "ASSERT", "BANG", "BANGEQ", "BAR", "BARBAR", "BAREQ", "BOOLEAN", "BREAK", "BYTE", "CARET", "CARETEQ", "CASE", "CATCH", "CHAR", "CHARLITERAL", "CLASS", "COLON", "COMMA", "COMMENT", "CONST", "CONTINUE", "DEFAULT", "DO", "DOT", "DOUBLE", "DOUBLELITERAL", "DoubleSuffix", "ELLIPSIS", "ELSE", "ENUM", "EQ", "EQEQ", "EXTENDS", "EscapeSequence", "Exponent", "FALSE", "FINAL", "FINALLY", "FLOAT", "FLOATLITERAL", "FOR", "FloatSuffix", "GOTO", "GT", "HexDigit", "HexPrefix", "IDENTIFIER", "IF", "IMPLEMENTS", "IMPORT", "INSTANCEOF", "INT", "INTERFACE", "INTLITERAL", "IdentifierPart", "IdentifierStart", "IntegerNumber", "LBRACE", "LBRACKET", "LINE_COMMENT", "LONG", "LONGLITERAL", "LPAREN", "LT", "LongSuffix", "MONKEYS_AT", "NATIVE", "NEW", "NULL", "NonIntegerNumber", "PACKAGE", "PERCENT", "PERCENTEQ", "PLUS", "PLUSEQ", "PLUSPLUS", "PRIVATE", "PROTECTED", "PUBLIC", "QUES", "RBRACE", "RBRACKET", "RETURN", "RPAREN", "SEMI", "SHORT", "SLASH", "SLASHEQ", "STAR", "STAREQ", "STATIC", "STRICTFP", "STRINGLITERAL", "SUB", "SUBEQ", "SUBSUB", "SUPER", "SWITCH", "SYNCHRONIZED", "SurrogateIdentifer", "THIS", "THROW", "THROWS", "TILDE", "TRANSIENT", "TRUE", "TRY", "VOID", "VOLATILE", "WHILE", "WS"
    };

    public static final int EOF=-1;
    public static final int ABSTRACT=4;
    public static final int AMP=5;
    public static final int AMPAMP=6;
    public static final int AMPEQ=7;
    public static final int ASSERT=8;
    public static final int BANG=9;
    public static final int BANGEQ=10;
    public static final int BAR=11;
    public static final int BARBAR=12;
    public static final int BAREQ=13;
    public static final int BOOLEAN=14;
    public static final int BREAK=15;
    public static final int BYTE=16;
    public static final int CARET=17;
    public static final int CARETEQ=18;
    public static final int CASE=19;
    public static final int CATCH=20;
    public static final int CHAR=21;
    public static final int CHARLITERAL=22;
    public static final int CLASS=23;
    public static final int COLON=24;
    public static final int COMMA=25;
    public static final int COMMENT=26;
    public static final int CONST=27;
    public static final int CONTINUE=28;
    public static final int DEFAULT=29;
    public static final int DO=30;
    public static final int DOT=31;
    public static final int DOUBLE=32;
    public static final int DOUBLELITERAL=33;
    public static final int DoubleSuffix=34;
    public static final int ELLIPSIS=35;
    public static final int ELSE=36;
    public static final int ENUM=37;
    public static final int EQ=38;
    public static final int EQEQ=39;
    public static final int EXTENDS=40;
    public static final int EscapeSequence=41;
    public static final int Exponent=42;
    public static final int FALSE=43;
    public static final int FINAL=44;
    public static final int FINALLY=45;
    public static final int FLOAT=46;
    public static final int FLOATLITERAL=47;
    public static final int FOR=48;
    public static final int FloatSuffix=49;
    public static final int GOTO=50;
    public static final int GT=51;
    public static final int HexDigit=52;
    public static final int HexPrefix=53;
    public static final int IDENTIFIER=54;
    public static final int IF=55;
    public static final int IMPLEMENTS=56;
    public static final int IMPORT=57;
    public static final int INSTANCEOF=58;
    public static final int INT=59;
    public static final int INTERFACE=60;
    public static final int INTLITERAL=61;
    public static final int IdentifierPart=62;
    public static final int IdentifierStart=63;
    public static final int IntegerNumber=64;
    public static final int LBRACE=65;
    public static final int LBRACKET=66;
    public static final int LINE_COMMENT=67;
    public static final int LONG=68;
    public static final int LONGLITERAL=69;
    public static final int LPAREN=70;
    public static final int LT=71;
    public static final int LongSuffix=72;
    public static final int MONKEYS_AT=73;
    public static final int NATIVE=74;
    public static final int NEW=75;
    public static final int NULL=76;
    public static final int NonIntegerNumber=77;
    public static final int PACKAGE=78;
    public static final int PERCENT=79;
    public static final int PERCENTEQ=80;
    public static final int PLUS=81;
    public static final int PLUSEQ=82;
    public static final int PLUSPLUS=83;
    public static final int PRIVATE=84;
    public static final int PROTECTED=85;
    public static final int PUBLIC=86;
    public static final int QUES=87;
    public static final int RBRACE=88;
    public static final int RBRACKET=89;
    public static final int RETURN=90;
    public static final int RPAREN=91;
    public static final int SEMI=92;
    public static final int SHORT=93;
    public static final int SLASH=94;
    public static final int SLASHEQ=95;
    public static final int STAR=96;
    public static final int STAREQ=97;
    public static final int STATIC=98;
    public static final int STRICTFP=99;
    public static final int STRINGLITERAL=100;
    public static final int SUB=101;
    public static final int SUBEQ=102;
    public static final int SUBSUB=103;
    public static final int SUPER=104;
    public static final int SWITCH=105;
    public static final int SYNCHRONIZED=106;
    public static final int SurrogateIdentifer=107;
    public static final int THIS=108;
    public static final int THROW=109;
    public static final int THROWS=110;
    public static final int TILDE=111;
    public static final int TRANSIENT=112;
    public static final int TRUE=113;
    public static final int TRY=114;
    public static final int VOID=115;
    public static final int VOLATILE=116;
    public static final int WHILE=117;
    public static final int WS=118;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public NoDynamicLoadingANTLRParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public NoDynamicLoadingANTLRParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.ruleMemo = new HashMap[381+1];
         

    }

    public String[] getTokenNames() { return NoDynamicLoadingANTLRParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g"; }


      public static final boolean DEBUG = true;
      
      public void checkMethodInvocation(List ids) {
        if (DEBUG)
          System.out.print("--Checking method invocation:");
        
        String receiver = "";
        String methodName = null;
        for (int i = 0; i < ids.size(); i++) {
          Token t = (Token) ids.get(i);
          if (i != ids.size() - 1) {
            receiver += t.getText();
            if (i != ids.size() - 2) receiver += ".";
          }else {
            methodName = t.getText();
          }
        }
        
        if (DEBUG)
          System.out.println(methodName + " on " + receiver);
      }



    // $ANTLR start "compilationUnit"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:331:1: compilationUnit : ( ( annotations )? packageDeclaration )? ( importDeclaration )* ( typeDeclaration )* ;
    public final void compilationUnit() throws RecognitionException {
        int compilationUnit_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:332:5: ( ( ( annotations )? packageDeclaration )? ( importDeclaration )* ( typeDeclaration )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:332:9: ( ( annotations )? packageDeclaration )? ( importDeclaration )* ( typeDeclaration )*
            {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:332:9: ( ( annotations )? packageDeclaration )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==MONKEYS_AT) ) {
                int LA2_1 = input.LA(2);

                if ( (synpred2_NoDynamicLoadingANTLR()) ) {
                    alt2=1;
                }
            }
            else if ( (LA2_0==PACKAGE) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:332:13: ( annotations )? packageDeclaration
                    {
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:332:13: ( annotations )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==MONKEYS_AT) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:332:14: annotations
                            {
                            pushFollow(FOLLOW_annotations_in_compilationUnit101);
                            annotations();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    pushFollow(FOLLOW_packageDeclaration_in_compilationUnit130);
                    packageDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:336:9: ( importDeclaration )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==IMPORT) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:336:10: importDeclaration
            	    {
            	    pushFollow(FOLLOW_importDeclaration_in_compilationUnit152);
            	    importDeclaration();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:338:9: ( typeDeclaration )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==ABSTRACT||LA4_0==BOOLEAN||LA4_0==BYTE||LA4_0==CHAR||LA4_0==CLASS||LA4_0==DOUBLE||LA4_0==ENUM||LA4_0==FINAL||LA4_0==FLOAT||LA4_0==IDENTIFIER||(LA4_0 >= INT && LA4_0 <= INTERFACE)||LA4_0==LONG||LA4_0==LT||(LA4_0 >= MONKEYS_AT && LA4_0 <= NATIVE)||(LA4_0 >= PRIVATE && LA4_0 <= PUBLIC)||(LA4_0 >= SEMI && LA4_0 <= SHORT)||(LA4_0 >= STATIC && LA4_0 <= STRICTFP)||LA4_0==SYNCHRONIZED||LA4_0==TRANSIENT||(LA4_0 >= VOID && LA4_0 <= VOLATILE)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:338:10: typeDeclaration
            	    {
            	    pushFollow(FOLLOW_typeDeclaration_in_compilationUnit174);
            	    typeDeclaration();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, compilationUnit_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "compilationUnit"



    // $ANTLR start "packageDeclaration"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:342:1: packageDeclaration : 'package' qualifiedName ';' ;
    public final void packageDeclaration() throws RecognitionException {
        int packageDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:343:5: ( 'package' qualifiedName ';' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:343:9: 'package' qualifiedName ';'
            {
            match(input,PACKAGE,FOLLOW_PACKAGE_in_packageDeclaration205); if (state.failed) return ;

            pushFollow(FOLLOW_qualifiedName_in_packageDeclaration207);
            qualifiedName();

            state._fsp--;
            if (state.failed) return ;

            match(input,SEMI,FOLLOW_SEMI_in_packageDeclaration217); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, packageDeclaration_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "packageDeclaration"



    // $ANTLR start "importDeclaration"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:347:1: importDeclaration : ( 'import' ( 'static' )? IDENTIFIER '.' '*' ';' | 'import' ( 'static' )? IDENTIFIER ( '.' IDENTIFIER )+ ( '.' '*' )? ';' );
    public final void importDeclaration() throws RecognitionException {
        int importDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:348:5: ( 'import' ( 'static' )? IDENTIFIER '.' '*' ';' | 'import' ( 'static' )? IDENTIFIER ( '.' IDENTIFIER )+ ( '.' '*' )? ';' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==IMPORT) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==STATIC) ) {
                    int LA9_2 = input.LA(3);

                    if ( (LA9_2==IDENTIFIER) ) {
                        int LA9_3 = input.LA(4);

                        if ( (LA9_3==DOT) ) {
                            int LA9_4 = input.LA(5);

                            if ( (LA9_4==STAR) ) {
                                alt9=1;
                            }
                            else if ( (LA9_4==IDENTIFIER) ) {
                                alt9=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 4, input);

                                throw nvae;

                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 3, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 2, input);

                        throw nvae;

                    }
                }
                else if ( (LA9_1==IDENTIFIER) ) {
                    int LA9_3 = input.LA(3);

                    if ( (LA9_3==DOT) ) {
                        int LA9_4 = input.LA(4);

                        if ( (LA9_4==STAR) ) {
                            alt9=1;
                        }
                        else if ( (LA9_4==IDENTIFIER) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 4, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 3, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:348:9: 'import' ( 'static' )? IDENTIFIER '.' '*' ';'
                    {
                    match(input,IMPORT,FOLLOW_IMPORT_in_importDeclaration238); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:349:9: ( 'static' )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==STATIC) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:349:10: 'static'
                            {
                            match(input,STATIC,FOLLOW_STATIC_in_importDeclaration250); if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_importDeclaration271); if (state.failed) return ;

                    match(input,DOT,FOLLOW_DOT_in_importDeclaration273); if (state.failed) return ;

                    match(input,STAR,FOLLOW_STAR_in_importDeclaration275); if (state.failed) return ;

                    match(input,SEMI,FOLLOW_SEMI_in_importDeclaration285); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:353:9: 'import' ( 'static' )? IDENTIFIER ( '.' IDENTIFIER )+ ( '.' '*' )? ';'
                    {
                    match(input,IMPORT,FOLLOW_IMPORT_in_importDeclaration302); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:354:9: ( 'static' )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==STATIC) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:354:10: 'static'
                            {
                            match(input,STATIC,FOLLOW_STATIC_in_importDeclaration314); if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_importDeclaration335); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:357:9: ( '.' IDENTIFIER )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==DOT) ) {
                            int LA7_1 = input.LA(2);

                            if ( (LA7_1==IDENTIFIER) ) {
                                alt7=1;
                            }


                        }


                        switch (alt7) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:357:10: '.' IDENTIFIER
                    	    {
                    	    match(input,DOT,FOLLOW_DOT_in_importDeclaration346); if (state.failed) return ;

                    	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_importDeclaration348); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);


                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:359:9: ( '.' '*' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==DOT) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:359:10: '.' '*'
                            {
                            match(input,DOT,FOLLOW_DOT_in_importDeclaration370); if (state.failed) return ;

                            match(input,STAR,FOLLOW_STAR_in_importDeclaration372); if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,SEMI,FOLLOW_SEMI_in_importDeclaration393); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, importDeclaration_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "importDeclaration"



    // $ANTLR start "qualifiedImportName"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:364:1: qualifiedImportName : IDENTIFIER ( '.' IDENTIFIER )* ;
    public final void qualifiedImportName() throws RecognitionException {
        int qualifiedImportName_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:365:5: ( IDENTIFIER ( '.' IDENTIFIER )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:365:9: IDENTIFIER ( '.' IDENTIFIER )*
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_qualifiedImportName413); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:366:9: ( '.' IDENTIFIER )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==DOT) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:366:10: '.' IDENTIFIER
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_qualifiedImportName424); if (state.failed) return ;

            	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_qualifiedImportName426); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, qualifiedImportName_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "qualifiedImportName"



    // $ANTLR start "typeDeclaration"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:370:1: typeDeclaration : ( classOrInterfaceDeclaration | ';' );
    public final void typeDeclaration() throws RecognitionException {
        int typeDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:371:5: ( classOrInterfaceDeclaration | ';' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==ABSTRACT||LA11_0==BOOLEAN||LA11_0==BYTE||LA11_0==CHAR||LA11_0==CLASS||LA11_0==DOUBLE||LA11_0==ENUM||LA11_0==FINAL||LA11_0==FLOAT||LA11_0==IDENTIFIER||(LA11_0 >= INT && LA11_0 <= INTERFACE)||LA11_0==LONG||LA11_0==LT||(LA11_0 >= MONKEYS_AT && LA11_0 <= NATIVE)||(LA11_0 >= PRIVATE && LA11_0 <= PUBLIC)||LA11_0==SHORT||(LA11_0 >= STATIC && LA11_0 <= STRICTFP)||LA11_0==SYNCHRONIZED||LA11_0==TRANSIENT||(LA11_0 >= VOID && LA11_0 <= VOLATILE)) ) {
                alt11=1;
            }
            else if ( (LA11_0==SEMI) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }
            switch (alt11) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:371:9: classOrInterfaceDeclaration
                    {
                    pushFollow(FOLLOW_classOrInterfaceDeclaration_in_typeDeclaration457);
                    classOrInterfaceDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:372:9: ';'
                    {
                    match(input,SEMI,FOLLOW_SEMI_in_typeDeclaration467); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, typeDeclaration_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "typeDeclaration"



    // $ANTLR start "classOrInterfaceDeclaration"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:375:1: classOrInterfaceDeclaration : ( classDeclaration | interfaceDeclaration );
    public final void classOrInterfaceDeclaration() throws RecognitionException {
        int classOrInterfaceDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:376:5: ( classDeclaration | interfaceDeclaration )
            int alt12=2;
            switch ( input.LA(1) ) {
            case MONKEYS_AT:
                {
                int LA12_1 = input.LA(2);

                if ( (synpred12_NoDynamicLoadingANTLR()) ) {
                    alt12=1;
                }
                else if ( (true) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;

                }
                }
                break;
            case PUBLIC:
                {
                int LA12_2 = input.LA(2);

                if ( (synpred12_NoDynamicLoadingANTLR()) ) {
                    alt12=1;
                }
                else if ( (true) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 2, input);

                    throw nvae;

                }
                }
                break;
            case PROTECTED:
                {
                int LA12_3 = input.LA(2);

                if ( (synpred12_NoDynamicLoadingANTLR()) ) {
                    alt12=1;
                }
                else if ( (true) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 3, input);

                    throw nvae;

                }
                }
                break;
            case PRIVATE:
                {
                int LA12_4 = input.LA(2);

                if ( (synpred12_NoDynamicLoadingANTLR()) ) {
                    alt12=1;
                }
                else if ( (true) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 4, input);

                    throw nvae;

                }
                }
                break;
            case STATIC:
                {
                int LA12_5 = input.LA(2);

                if ( (synpred12_NoDynamicLoadingANTLR()) ) {
                    alt12=1;
                }
                else if ( (true) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 5, input);

                    throw nvae;

                }
                }
                break;
            case ABSTRACT:
                {
                int LA12_6 = input.LA(2);

                if ( (synpred12_NoDynamicLoadingANTLR()) ) {
                    alt12=1;
                }
                else if ( (true) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 6, input);

                    throw nvae;

                }
                }
                break;
            case FINAL:
                {
                int LA12_7 = input.LA(2);

                if ( (synpred12_NoDynamicLoadingANTLR()) ) {
                    alt12=1;
                }
                else if ( (true) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 7, input);

                    throw nvae;

                }
                }
                break;
            case NATIVE:
                {
                int LA12_8 = input.LA(2);

                if ( (synpred12_NoDynamicLoadingANTLR()) ) {
                    alt12=1;
                }
                else if ( (true) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 8, input);

                    throw nvae;

                }
                }
                break;
            case SYNCHRONIZED:
                {
                int LA12_9 = input.LA(2);

                if ( (synpred12_NoDynamicLoadingANTLR()) ) {
                    alt12=1;
                }
                else if ( (true) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 9, input);

                    throw nvae;

                }
                }
                break;
            case TRANSIENT:
                {
                int LA12_10 = input.LA(2);

                if ( (synpred12_NoDynamicLoadingANTLR()) ) {
                    alt12=1;
                }
                else if ( (true) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 10, input);

                    throw nvae;

                }
                }
                break;
            case VOLATILE:
                {
                int LA12_11 = input.LA(2);

                if ( (synpred12_NoDynamicLoadingANTLR()) ) {
                    alt12=1;
                }
                else if ( (true) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 11, input);

                    throw nvae;

                }
                }
                break;
            case STRICTFP:
                {
                int LA12_12 = input.LA(2);

                if ( (synpred12_NoDynamicLoadingANTLR()) ) {
                    alt12=1;
                }
                else if ( (true) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 12, input);

                    throw nvae;

                }
                }
                break;
            case CLASS:
            case ENUM:
                {
                alt12=1;
                }
                break;
            case INTERFACE:
                {
                alt12=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }

            switch (alt12) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:376:10: classDeclaration
                    {
                    pushFollow(FOLLOW_classDeclaration_in_classOrInterfaceDeclaration488);
                    classDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:377:9: interfaceDeclaration
                    {
                    pushFollow(FOLLOW_interfaceDeclaration_in_classOrInterfaceDeclaration498);
                    interfaceDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, classOrInterfaceDeclaration_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "classOrInterfaceDeclaration"



    // $ANTLR start "modifiers"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:381:1: modifiers : ( annotation | 'public' | 'protected' | 'private' | 'static' | 'abstract' | 'final' | 'native' | 'synchronized' | 'transient' | 'volatile' | 'strictfp' )* ;
    public final void modifiers() throws RecognitionException {
        int modifiers_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:382:5: ( ( annotation | 'public' | 'protected' | 'private' | 'static' | 'abstract' | 'final' | 'native' | 'synchronized' | 'transient' | 'volatile' | 'strictfp' )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:383:5: ( annotation | 'public' | 'protected' | 'private' | 'static' | 'abstract' | 'final' | 'native' | 'synchronized' | 'transient' | 'volatile' | 'strictfp' )*
            {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:383:5: ( annotation | 'public' | 'protected' | 'private' | 'static' | 'abstract' | 'final' | 'native' | 'synchronized' | 'transient' | 'volatile' | 'strictfp' )*
            loop13:
            do {
                int alt13=13;
                switch ( input.LA(1) ) {
                case MONKEYS_AT:
                    {
                    int LA13_2 = input.LA(2);

                    if ( (LA13_2==IDENTIFIER) ) {
                        alt13=1;
                    }


                    }
                    break;
                case PUBLIC:
                    {
                    alt13=2;
                    }
                    break;
                case PROTECTED:
                    {
                    alt13=3;
                    }
                    break;
                case PRIVATE:
                    {
                    alt13=4;
                    }
                    break;
                case STATIC:
                    {
                    alt13=5;
                    }
                    break;
                case ABSTRACT:
                    {
                    alt13=6;
                    }
                    break;
                case FINAL:
                    {
                    alt13=7;
                    }
                    break;
                case NATIVE:
                    {
                    alt13=8;
                    }
                    break;
                case SYNCHRONIZED:
                    {
                    alt13=9;
                    }
                    break;
                case TRANSIENT:
                    {
                    alt13=10;
                    }
                    break;
                case VOLATILE:
                    {
                    alt13=11;
                    }
                    break;
                case STRICTFP:
                    {
                    alt13=12;
                    }
                    break;

                }

                switch (alt13) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:383:10: annotation
            	    {
            	    pushFollow(FOLLOW_annotation_in_modifiers533);
            	    annotation();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:384:9: 'public'
            	    {
            	    match(input,PUBLIC,FOLLOW_PUBLIC_in_modifiers543); if (state.failed) return ;

            	    }
            	    break;
            	case 3 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:385:9: 'protected'
            	    {
            	    match(input,PROTECTED,FOLLOW_PROTECTED_in_modifiers553); if (state.failed) return ;

            	    }
            	    break;
            	case 4 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:386:9: 'private'
            	    {
            	    match(input,PRIVATE,FOLLOW_PRIVATE_in_modifiers563); if (state.failed) return ;

            	    }
            	    break;
            	case 5 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:387:9: 'static'
            	    {
            	    match(input,STATIC,FOLLOW_STATIC_in_modifiers573); if (state.failed) return ;

            	    }
            	    break;
            	case 6 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:388:9: 'abstract'
            	    {
            	    match(input,ABSTRACT,FOLLOW_ABSTRACT_in_modifiers583); if (state.failed) return ;

            	    }
            	    break;
            	case 7 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:389:9: 'final'
            	    {
            	    match(input,FINAL,FOLLOW_FINAL_in_modifiers593); if (state.failed) return ;

            	    }
            	    break;
            	case 8 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:390:9: 'native'
            	    {
            	    match(input,NATIVE,FOLLOW_NATIVE_in_modifiers603); if (state.failed) return ;

            	    }
            	    break;
            	case 9 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:391:9: 'synchronized'
            	    {
            	    match(input,SYNCHRONIZED,FOLLOW_SYNCHRONIZED_in_modifiers613); if (state.failed) return ;

            	    }
            	    break;
            	case 10 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:392:9: 'transient'
            	    {
            	    match(input,TRANSIENT,FOLLOW_TRANSIENT_in_modifiers623); if (state.failed) return ;

            	    }
            	    break;
            	case 11 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:393:9: 'volatile'
            	    {
            	    match(input,VOLATILE,FOLLOW_VOLATILE_in_modifiers633); if (state.failed) return ;

            	    }
            	    break;
            	case 12 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:394:9: 'strictfp'
            	    {
            	    match(input,STRICTFP,FOLLOW_STRICTFP_in_modifiers643); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, modifiers_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "modifiers"



    // $ANTLR start "variableModifiers"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:399:1: variableModifiers : ( 'final' | annotation )* ;
    public final void variableModifiers() throws RecognitionException {
        int variableModifiers_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:400:5: ( ( 'final' | annotation )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:400:9: ( 'final' | annotation )*
            {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:400:9: ( 'final' | annotation )*
            loop14:
            do {
                int alt14=3;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==FINAL) ) {
                    alt14=1;
                }
                else if ( (LA14_0==MONKEYS_AT) ) {
                    alt14=2;
                }


                switch (alt14) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:400:13: 'final'
            	    {
            	    match(input,FINAL,FOLLOW_FINAL_in_variableModifiers675); if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:401:13: annotation
            	    {
            	    pushFollow(FOLLOW_annotation_in_variableModifiers689);
            	    annotation();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, variableModifiers_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "variableModifiers"



    // $ANTLR start "classDeclaration"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:406:1: classDeclaration : ( normalClassDeclaration | enumDeclaration );
    public final void classDeclaration() throws RecognitionException {
        int classDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:407:5: ( normalClassDeclaration | enumDeclaration )
            int alt15=2;
            switch ( input.LA(1) ) {
            case MONKEYS_AT:
                {
                int LA15_1 = input.LA(2);

                if ( (synpred27_NoDynamicLoadingANTLR()) ) {
                    alt15=1;
                }
                else if ( (true) ) {
                    alt15=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 1, input);

                    throw nvae;

                }
                }
                break;
            case PUBLIC:
                {
                int LA15_2 = input.LA(2);

                if ( (synpred27_NoDynamicLoadingANTLR()) ) {
                    alt15=1;
                }
                else if ( (true) ) {
                    alt15=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 2, input);

                    throw nvae;

                }
                }
                break;
            case PROTECTED:
                {
                int LA15_3 = input.LA(2);

                if ( (synpred27_NoDynamicLoadingANTLR()) ) {
                    alt15=1;
                }
                else if ( (true) ) {
                    alt15=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 3, input);

                    throw nvae;

                }
                }
                break;
            case PRIVATE:
                {
                int LA15_4 = input.LA(2);

                if ( (synpred27_NoDynamicLoadingANTLR()) ) {
                    alt15=1;
                }
                else if ( (true) ) {
                    alt15=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 4, input);

                    throw nvae;

                }
                }
                break;
            case STATIC:
                {
                int LA15_5 = input.LA(2);

                if ( (synpred27_NoDynamicLoadingANTLR()) ) {
                    alt15=1;
                }
                else if ( (true) ) {
                    alt15=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 5, input);

                    throw nvae;

                }
                }
                break;
            case ABSTRACT:
                {
                int LA15_6 = input.LA(2);

                if ( (synpred27_NoDynamicLoadingANTLR()) ) {
                    alt15=1;
                }
                else if ( (true) ) {
                    alt15=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 6, input);

                    throw nvae;

                }
                }
                break;
            case FINAL:
                {
                int LA15_7 = input.LA(2);

                if ( (synpred27_NoDynamicLoadingANTLR()) ) {
                    alt15=1;
                }
                else if ( (true) ) {
                    alt15=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 7, input);

                    throw nvae;

                }
                }
                break;
            case NATIVE:
                {
                int LA15_8 = input.LA(2);

                if ( (synpred27_NoDynamicLoadingANTLR()) ) {
                    alt15=1;
                }
                else if ( (true) ) {
                    alt15=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 8, input);

                    throw nvae;

                }
                }
                break;
            case SYNCHRONIZED:
                {
                int LA15_9 = input.LA(2);

                if ( (synpred27_NoDynamicLoadingANTLR()) ) {
                    alt15=1;
                }
                else if ( (true) ) {
                    alt15=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 9, input);

                    throw nvae;

                }
                }
                break;
            case TRANSIENT:
                {
                int LA15_10 = input.LA(2);

                if ( (synpred27_NoDynamicLoadingANTLR()) ) {
                    alt15=1;
                }
                else if ( (true) ) {
                    alt15=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 10, input);

                    throw nvae;

                }
                }
                break;
            case VOLATILE:
                {
                int LA15_11 = input.LA(2);

                if ( (synpred27_NoDynamicLoadingANTLR()) ) {
                    alt15=1;
                }
                else if ( (true) ) {
                    alt15=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 11, input);

                    throw nvae;

                }
                }
                break;
            case STRICTFP:
                {
                int LA15_12 = input.LA(2);

                if ( (synpred27_NoDynamicLoadingANTLR()) ) {
                    alt15=1;
                }
                else if ( (true) ) {
                    alt15=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 12, input);

                    throw nvae;

                }
                }
                break;
            case CLASS:
                {
                alt15=1;
                }
                break;
            case ENUM:
                {
                alt15=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }

            switch (alt15) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:407:9: normalClassDeclaration
                    {
                    pushFollow(FOLLOW_normalClassDeclaration_in_classDeclaration725);
                    normalClassDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:408:9: enumDeclaration
                    {
                    pushFollow(FOLLOW_enumDeclaration_in_classDeclaration735);
                    enumDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, classDeclaration_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "classDeclaration"



    // $ANTLR start "normalClassDeclaration"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:411:1: normalClassDeclaration : modifiers 'class' IDENTIFIER ( typeParameters )? ( 'extends' type )? ( 'implements' typeList )? classBody ;
    public final void normalClassDeclaration() throws RecognitionException {
        int normalClassDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:412:5: ( modifiers 'class' IDENTIFIER ( typeParameters )? ( 'extends' type )? ( 'implements' typeList )? classBody )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:412:9: modifiers 'class' IDENTIFIER ( typeParameters )? ( 'extends' type )? ( 'implements' typeList )? classBody
            {
            pushFollow(FOLLOW_modifiers_in_normalClassDeclaration755);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            match(input,CLASS,FOLLOW_CLASS_in_normalClassDeclaration758); if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_normalClassDeclaration760); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:413:9: ( typeParameters )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==LT) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:413:10: typeParameters
                    {
                    pushFollow(FOLLOW_typeParameters_in_normalClassDeclaration771);
                    typeParameters();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:415:9: ( 'extends' type )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==EXTENDS) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:415:10: 'extends' type
                    {
                    match(input,EXTENDS,FOLLOW_EXTENDS_in_normalClassDeclaration793); if (state.failed) return ;

                    pushFollow(FOLLOW_type_in_normalClassDeclaration795);
                    type();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:417:9: ( 'implements' typeList )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==IMPLEMENTS) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:417:10: 'implements' typeList
                    {
                    match(input,IMPLEMENTS,FOLLOW_IMPLEMENTS_in_normalClassDeclaration817); if (state.failed) return ;

                    pushFollow(FOLLOW_typeList_in_normalClassDeclaration819);
                    typeList();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            pushFollow(FOLLOW_classBody_in_normalClassDeclaration852);
            classBody();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, normalClassDeclaration_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "normalClassDeclaration"



    // $ANTLR start "typeParameters"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:423:1: typeParameters : '<' typeParameter ( ',' typeParameter )* '>' ;
    public final void typeParameters() throws RecognitionException {
        int typeParameters_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:424:5: ( '<' typeParameter ( ',' typeParameter )* '>' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:424:9: '<' typeParameter ( ',' typeParameter )* '>'
            {
            match(input,LT,FOLLOW_LT_in_typeParameters873); if (state.failed) return ;

            pushFollow(FOLLOW_typeParameter_in_typeParameters887);
            typeParameter();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:426:13: ( ',' typeParameter )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==COMMA) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:426:14: ',' typeParameter
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_typeParameters902); if (state.failed) return ;

            	    pushFollow(FOLLOW_typeParameter_in_typeParameters904);
            	    typeParameter();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            match(input,GT,FOLLOW_GT_in_typeParameters929); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, typeParameters_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "typeParameters"



    // $ANTLR start "typeParameter"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:431:1: typeParameter : IDENTIFIER ( 'extends' typeBound )? ;
    public final void typeParameter() throws RecognitionException {
        int typeParameter_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:432:5: ( IDENTIFIER ( 'extends' typeBound )? )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:432:9: IDENTIFIER ( 'extends' typeBound )?
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_typeParameter949); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:433:9: ( 'extends' typeBound )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==EXTENDS) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:433:10: 'extends' typeBound
                    {
                    match(input,EXTENDS,FOLLOW_EXTENDS_in_typeParameter960); if (state.failed) return ;

                    pushFollow(FOLLOW_typeBound_in_typeParameter962);
                    typeBound();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, typeParameter_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "typeParameter"



    // $ANTLR start "typeBound"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:438:1: typeBound : type ( '&' type )* ;
    public final void typeBound() throws RecognitionException {
        int typeBound_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:439:5: ( type ( '&' type )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:439:9: type ( '&' type )*
            {
            pushFollow(FOLLOW_type_in_typeBound994);
            type();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:440:9: ( '&' type )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==AMP) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:440:10: '&' type
            	    {
            	    match(input,AMP,FOLLOW_AMP_in_typeBound1005); if (state.failed) return ;

            	    pushFollow(FOLLOW_type_in_typeBound1007);
            	    type();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 13, typeBound_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "typeBound"



    // $ANTLR start "enumDeclaration"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:445:1: enumDeclaration : modifiers ( 'enum' ) IDENTIFIER ( 'implements' typeList )? enumBody ;
    public final void enumDeclaration() throws RecognitionException {
        int enumDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:446:5: ( modifiers ( 'enum' ) IDENTIFIER ( 'implements' typeList )? enumBody )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:446:9: modifiers ( 'enum' ) IDENTIFIER ( 'implements' typeList )? enumBody
            {
            pushFollow(FOLLOW_modifiers_in_enumDeclaration1039);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:447:9: ( 'enum' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:447:10: 'enum'
            {
            match(input,ENUM,FOLLOW_ENUM_in_enumDeclaration1051); if (state.failed) return ;

            }


            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enumDeclaration1072); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:450:9: ( 'implements' typeList )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==IMPLEMENTS) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:450:10: 'implements' typeList
                    {
                    match(input,IMPLEMENTS,FOLLOW_IMPLEMENTS_in_enumDeclaration1083); if (state.failed) return ;

                    pushFollow(FOLLOW_typeList_in_enumDeclaration1085);
                    typeList();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            pushFollow(FOLLOW_enumBody_in_enumDeclaration1106);
            enumBody();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 14, enumDeclaration_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "enumDeclaration"



    // $ANTLR start "enumBody"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:456:1: enumBody : '{' ( enumConstants )? ( ',' )? ( enumBodyDeclarations )? '}' ;
    public final void enumBody() throws RecognitionException {
        int enumBody_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:457:5: ( '{' ( enumConstants )? ( ',' )? ( enumBodyDeclarations )? '}' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:457:9: '{' ( enumConstants )? ( ',' )? ( enumBodyDeclarations )? '}'
            {
            match(input,LBRACE,FOLLOW_LBRACE_in_enumBody1131); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:458:9: ( enumConstants )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==IDENTIFIER||LA23_0==MONKEYS_AT) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:458:10: enumConstants
                    {
                    pushFollow(FOLLOW_enumConstants_in_enumBody1142);
                    enumConstants();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:460:9: ( ',' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==COMMA) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:460:9: ','
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_enumBody1164); if (state.failed) return ;

                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:461:9: ( enumBodyDeclarations )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==SEMI) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:461:10: enumBodyDeclarations
                    {
                    pushFollow(FOLLOW_enumBodyDeclarations_in_enumBody1177);
                    enumBodyDeclarations();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            match(input,RBRACE,FOLLOW_RBRACE_in_enumBody1199); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 15, enumBody_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "enumBody"



    // $ANTLR start "enumConstants"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:466:1: enumConstants : enumConstant ( ',' enumConstant )* ;
    public final void enumConstants() throws RecognitionException {
        int enumConstants_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:467:5: ( enumConstant ( ',' enumConstant )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:467:9: enumConstant ( ',' enumConstant )*
            {
            pushFollow(FOLLOW_enumConstant_in_enumConstants1219);
            enumConstant();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:468:9: ( ',' enumConstant )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==COMMA) ) {
                    int LA26_1 = input.LA(2);

                    if ( (LA26_1==IDENTIFIER||LA26_1==MONKEYS_AT) ) {
                        alt26=1;
                    }


                }


                switch (alt26) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:468:10: ',' enumConstant
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_enumConstants1230); if (state.failed) return ;

            	    pushFollow(FOLLOW_enumConstant_in_enumConstants1232);
            	    enumConstant();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 16, enumConstants_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "enumConstants"



    // $ANTLR start "enumConstant"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:476:1: enumConstant : ( annotations )? IDENTIFIER ( arguments )? ( classBody )? ;
    public final void enumConstant() throws RecognitionException {
        int enumConstant_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:477:5: ( ( annotations )? IDENTIFIER ( arguments )? ( classBody )? )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:477:9: ( annotations )? IDENTIFIER ( arguments )? ( classBody )?
            {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:477:9: ( annotations )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==MONKEYS_AT) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:477:10: annotations
                    {
                    pushFollow(FOLLOW_annotations_in_enumConstant1266);
                    annotations();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enumConstant1287); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:480:9: ( arguments )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==LPAREN) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:480:10: arguments
                    {
                    pushFollow(FOLLOW_arguments_in_enumConstant1298);
                    arguments();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:482:9: ( classBody )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==LBRACE) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:482:10: classBody
                    {
                    pushFollow(FOLLOW_classBody_in_enumConstant1320);
                    classBody();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 17, enumConstant_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "enumConstant"



    // $ANTLR start "enumBodyDeclarations"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:488:1: enumBodyDeclarations : ';' ( classBodyDeclaration )* ;
    public final void enumBodyDeclarations() throws RecognitionException {
        int enumBodyDeclarations_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:489:5: ( ';' ( classBodyDeclaration )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:489:9: ';' ( classBodyDeclaration )*
            {
            match(input,SEMI,FOLLOW_SEMI_in_enumBodyDeclarations1361); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:490:9: ( classBodyDeclaration )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==ABSTRACT||LA30_0==BOOLEAN||LA30_0==BYTE||LA30_0==CHAR||LA30_0==CLASS||LA30_0==DOUBLE||LA30_0==ENUM||LA30_0==FINAL||LA30_0==FLOAT||LA30_0==IDENTIFIER||(LA30_0 >= INT && LA30_0 <= INTERFACE)||LA30_0==LBRACE||LA30_0==LONG||LA30_0==LT||(LA30_0 >= MONKEYS_AT && LA30_0 <= NATIVE)||(LA30_0 >= PRIVATE && LA30_0 <= PUBLIC)||(LA30_0 >= SEMI && LA30_0 <= SHORT)||(LA30_0 >= STATIC && LA30_0 <= STRICTFP)||LA30_0==SYNCHRONIZED||LA30_0==TRANSIENT||(LA30_0 >= VOID && LA30_0 <= VOLATILE)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:490:10: classBodyDeclaration
            	    {
            	    pushFollow(FOLLOW_classBodyDeclaration_in_enumBodyDeclarations1373);
            	    classBodyDeclaration();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 18, enumBodyDeclarations_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "enumBodyDeclarations"



    // $ANTLR start "interfaceDeclaration"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:494:1: interfaceDeclaration : ( normalInterfaceDeclaration | annotationTypeDeclaration );
    public final void interfaceDeclaration() throws RecognitionException {
        int interfaceDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:495:5: ( normalInterfaceDeclaration | annotationTypeDeclaration )
            int alt31=2;
            switch ( input.LA(1) ) {
            case MONKEYS_AT:
                {
                int LA31_1 = input.LA(2);

                if ( (synpred43_NoDynamicLoadingANTLR()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 1, input);

                    throw nvae;

                }
                }
                break;
            case PUBLIC:
                {
                int LA31_2 = input.LA(2);

                if ( (synpred43_NoDynamicLoadingANTLR()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 2, input);

                    throw nvae;

                }
                }
                break;
            case PROTECTED:
                {
                int LA31_3 = input.LA(2);

                if ( (synpred43_NoDynamicLoadingANTLR()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 3, input);

                    throw nvae;

                }
                }
                break;
            case PRIVATE:
                {
                int LA31_4 = input.LA(2);

                if ( (synpred43_NoDynamicLoadingANTLR()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 4, input);

                    throw nvae;

                }
                }
                break;
            case STATIC:
                {
                int LA31_5 = input.LA(2);

                if ( (synpred43_NoDynamicLoadingANTLR()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 5, input);

                    throw nvae;

                }
                }
                break;
            case ABSTRACT:
                {
                int LA31_6 = input.LA(2);

                if ( (synpred43_NoDynamicLoadingANTLR()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 6, input);

                    throw nvae;

                }
                }
                break;
            case FINAL:
                {
                int LA31_7 = input.LA(2);

                if ( (synpred43_NoDynamicLoadingANTLR()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 7, input);

                    throw nvae;

                }
                }
                break;
            case NATIVE:
                {
                int LA31_8 = input.LA(2);

                if ( (synpred43_NoDynamicLoadingANTLR()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 8, input);

                    throw nvae;

                }
                }
                break;
            case SYNCHRONIZED:
                {
                int LA31_9 = input.LA(2);

                if ( (synpred43_NoDynamicLoadingANTLR()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 9, input);

                    throw nvae;

                }
                }
                break;
            case TRANSIENT:
                {
                int LA31_10 = input.LA(2);

                if ( (synpred43_NoDynamicLoadingANTLR()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 10, input);

                    throw nvae;

                }
                }
                break;
            case VOLATILE:
                {
                int LA31_11 = input.LA(2);

                if ( (synpred43_NoDynamicLoadingANTLR()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 11, input);

                    throw nvae;

                }
                }
                break;
            case STRICTFP:
                {
                int LA31_12 = input.LA(2);

                if ( (synpred43_NoDynamicLoadingANTLR()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 12, input);

                    throw nvae;

                }
                }
                break;
            case INTERFACE:
                {
                alt31=1;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;

            }

            switch (alt31) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:495:9: normalInterfaceDeclaration
                    {
                    pushFollow(FOLLOW_normalInterfaceDeclaration_in_interfaceDeclaration1404);
                    normalInterfaceDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:496:9: annotationTypeDeclaration
                    {
                    pushFollow(FOLLOW_annotationTypeDeclaration_in_interfaceDeclaration1414);
                    annotationTypeDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 19, interfaceDeclaration_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "interfaceDeclaration"



    // $ANTLR start "normalInterfaceDeclaration"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:499:1: normalInterfaceDeclaration : modifiers 'interface' IDENTIFIER ( typeParameters )? ( 'extends' typeList )? interfaceBody ;
    public final void normalInterfaceDeclaration() throws RecognitionException {
        int normalInterfaceDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:500:5: ( modifiers 'interface' IDENTIFIER ( typeParameters )? ( 'extends' typeList )? interfaceBody )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:500:9: modifiers 'interface' IDENTIFIER ( typeParameters )? ( 'extends' typeList )? interfaceBody
            {
            pushFollow(FOLLOW_modifiers_in_normalInterfaceDeclaration1438);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            match(input,INTERFACE,FOLLOW_INTERFACE_in_normalInterfaceDeclaration1440); if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_normalInterfaceDeclaration1442); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:501:9: ( typeParameters )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==LT) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:501:10: typeParameters
                    {
                    pushFollow(FOLLOW_typeParameters_in_normalInterfaceDeclaration1453);
                    typeParameters();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:503:9: ( 'extends' typeList )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==EXTENDS) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:503:10: 'extends' typeList
                    {
                    match(input,EXTENDS,FOLLOW_EXTENDS_in_normalInterfaceDeclaration1475); if (state.failed) return ;

                    pushFollow(FOLLOW_typeList_in_normalInterfaceDeclaration1477);
                    typeList();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            pushFollow(FOLLOW_interfaceBody_in_normalInterfaceDeclaration1498);
            interfaceBody();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 20, normalInterfaceDeclaration_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "normalInterfaceDeclaration"



    // $ANTLR start "typeList"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:508:1: typeList : type ( ',' type )* ;
    public final void typeList() throws RecognitionException {
        int typeList_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:509:5: ( type ( ',' type )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:509:9: type ( ',' type )*
            {
            pushFollow(FOLLOW_type_in_typeList1518);
            type();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:510:9: ( ',' type )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==COMMA) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:510:10: ',' type
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_typeList1529); if (state.failed) return ;

            	    pushFollow(FOLLOW_type_in_typeList1531);
            	    type();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 21, typeList_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "typeList"



    // $ANTLR start "classBody"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:514:1: classBody : '{' ( classBodyDeclaration )* '}' ;
    public final void classBody() throws RecognitionException {
        int classBody_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:515:5: ( '{' ( classBodyDeclaration )* '}' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:515:9: '{' ( classBodyDeclaration )* '}'
            {
            match(input,LBRACE,FOLLOW_LBRACE_in_classBody1562); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:516:9: ( classBodyDeclaration )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==ABSTRACT||LA35_0==BOOLEAN||LA35_0==BYTE||LA35_0==CHAR||LA35_0==CLASS||LA35_0==DOUBLE||LA35_0==ENUM||LA35_0==FINAL||LA35_0==FLOAT||LA35_0==IDENTIFIER||(LA35_0 >= INT && LA35_0 <= INTERFACE)||LA35_0==LBRACE||LA35_0==LONG||LA35_0==LT||(LA35_0 >= MONKEYS_AT && LA35_0 <= NATIVE)||(LA35_0 >= PRIVATE && LA35_0 <= PUBLIC)||(LA35_0 >= SEMI && LA35_0 <= SHORT)||(LA35_0 >= STATIC && LA35_0 <= STRICTFP)||LA35_0==SYNCHRONIZED||LA35_0==TRANSIENT||(LA35_0 >= VOID && LA35_0 <= VOLATILE)) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:516:10: classBodyDeclaration
            	    {
            	    pushFollow(FOLLOW_classBodyDeclaration_in_classBody1574);
            	    classBodyDeclaration();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            match(input,RBRACE,FOLLOW_RBRACE_in_classBody1596); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 22, classBody_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "classBody"



    // $ANTLR start "interfaceBody"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:521:1: interfaceBody : '{' ( interfaceBodyDeclaration )* '}' ;
    public final void interfaceBody() throws RecognitionException {
        int interfaceBody_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:522:5: ( '{' ( interfaceBodyDeclaration )* '}' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:522:9: '{' ( interfaceBodyDeclaration )* '}'
            {
            match(input,LBRACE,FOLLOW_LBRACE_in_interfaceBody1616); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:523:9: ( interfaceBodyDeclaration )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==ABSTRACT||LA36_0==BOOLEAN||LA36_0==BYTE||LA36_0==CHAR||LA36_0==CLASS||LA36_0==DOUBLE||LA36_0==ENUM||LA36_0==FINAL||LA36_0==FLOAT||LA36_0==IDENTIFIER||(LA36_0 >= INT && LA36_0 <= INTERFACE)||LA36_0==LONG||LA36_0==LT||(LA36_0 >= MONKEYS_AT && LA36_0 <= NATIVE)||(LA36_0 >= PRIVATE && LA36_0 <= PUBLIC)||(LA36_0 >= SEMI && LA36_0 <= SHORT)||(LA36_0 >= STATIC && LA36_0 <= STRICTFP)||LA36_0==SYNCHRONIZED||LA36_0==TRANSIENT||(LA36_0 >= VOID && LA36_0 <= VOLATILE)) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:523:10: interfaceBodyDeclaration
            	    {
            	    pushFollow(FOLLOW_interfaceBodyDeclaration_in_interfaceBody1628);
            	    interfaceBodyDeclaration();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            match(input,RBRACE,FOLLOW_RBRACE_in_interfaceBody1650); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 23, interfaceBody_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "interfaceBody"



    // $ANTLR start "classBodyDeclaration"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:528:1: classBodyDeclaration : ( ';' | ( 'static' )? block | memberDecl );
    public final void classBodyDeclaration() throws RecognitionException {
        int classBodyDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:529:5: ( ';' | ( 'static' )? block | memberDecl )
            int alt38=3;
            switch ( input.LA(1) ) {
            case SEMI:
                {
                alt38=1;
                }
                break;
            case STATIC:
                {
                int LA38_2 = input.LA(2);

                if ( (LA38_2==LBRACE) ) {
                    alt38=2;
                }
                else if ( (LA38_2==ABSTRACT||LA38_2==BOOLEAN||LA38_2==BYTE||LA38_2==CHAR||LA38_2==CLASS||LA38_2==DOUBLE||LA38_2==ENUM||LA38_2==FINAL||LA38_2==FLOAT||LA38_2==IDENTIFIER||(LA38_2 >= INT && LA38_2 <= INTERFACE)||LA38_2==LONG||LA38_2==LT||(LA38_2 >= MONKEYS_AT && LA38_2 <= NATIVE)||(LA38_2 >= PRIVATE && LA38_2 <= PUBLIC)||LA38_2==SHORT||(LA38_2 >= STATIC && LA38_2 <= STRICTFP)||LA38_2==SYNCHRONIZED||LA38_2==TRANSIENT||(LA38_2 >= VOID && LA38_2 <= VOLATILE)) ) {
                    alt38=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 2, input);

                    throw nvae;

                }
                }
                break;
            case LBRACE:
                {
                alt38=2;
                }
                break;
            case ABSTRACT:
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case CLASS:
            case DOUBLE:
            case ENUM:
            case FINAL:
            case FLOAT:
            case IDENTIFIER:
            case INT:
            case INTERFACE:
            case LONG:
            case LT:
            case MONKEYS_AT:
            case NATIVE:
            case PRIVATE:
            case PROTECTED:
            case PUBLIC:
            case SHORT:
            case STRICTFP:
            case SYNCHRONIZED:
            case TRANSIENT:
            case VOID:
            case VOLATILE:
                {
                alt38=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;

            }

            switch (alt38) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:529:9: ';'
                    {
                    match(input,SEMI,FOLLOW_SEMI_in_classBodyDeclaration1670); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:530:9: ( 'static' )? block
                    {
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:530:9: ( 'static' )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==STATIC) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:530:10: 'static'
                            {
                            match(input,STATIC,FOLLOW_STATIC_in_classBodyDeclaration1681); if (state.failed) return ;

                            }
                            break;

                    }


                    pushFollow(FOLLOW_block_in_classBodyDeclaration1703);
                    block();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:533:9: memberDecl
                    {
                    pushFollow(FOLLOW_memberDecl_in_classBodyDeclaration1713);
                    memberDecl();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 24, classBodyDeclaration_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "classBodyDeclaration"



    // $ANTLR start "memberDecl"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:536:1: memberDecl : ( fieldDeclaration | methodDeclaration | classDeclaration | interfaceDeclaration );
    public final void memberDecl() throws RecognitionException {
        int memberDecl_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:537:5: ( fieldDeclaration | methodDeclaration | classDeclaration | interfaceDeclaration )
            int alt39=4;
            switch ( input.LA(1) ) {
            case MONKEYS_AT:
                {
                int LA39_1 = input.LA(2);

                if ( (synpred52_NoDynamicLoadingANTLR()) ) {
                    alt39=1;
                }
                else if ( (synpred53_NoDynamicLoadingANTLR()) ) {
                    alt39=2;
                }
                else if ( (synpred54_NoDynamicLoadingANTLR()) ) {
                    alt39=3;
                }
                else if ( (true) ) {
                    alt39=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 1, input);

                    throw nvae;

                }
                }
                break;
            case PUBLIC:
                {
                int LA39_2 = input.LA(2);

                if ( (synpred52_NoDynamicLoadingANTLR()) ) {
                    alt39=1;
                }
                else if ( (synpred53_NoDynamicLoadingANTLR()) ) {
                    alt39=2;
                }
                else if ( (synpred54_NoDynamicLoadingANTLR()) ) {
                    alt39=3;
                }
                else if ( (true) ) {
                    alt39=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 2, input);

                    throw nvae;

                }
                }
                break;
            case PROTECTED:
                {
                int LA39_3 = input.LA(2);

                if ( (synpred52_NoDynamicLoadingANTLR()) ) {
                    alt39=1;
                }
                else if ( (synpred53_NoDynamicLoadingANTLR()) ) {
                    alt39=2;
                }
                else if ( (synpred54_NoDynamicLoadingANTLR()) ) {
                    alt39=3;
                }
                else if ( (true) ) {
                    alt39=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 3, input);

                    throw nvae;

                }
                }
                break;
            case PRIVATE:
                {
                int LA39_4 = input.LA(2);

                if ( (synpred52_NoDynamicLoadingANTLR()) ) {
                    alt39=1;
                }
                else if ( (synpred53_NoDynamicLoadingANTLR()) ) {
                    alt39=2;
                }
                else if ( (synpred54_NoDynamicLoadingANTLR()) ) {
                    alt39=3;
                }
                else if ( (true) ) {
                    alt39=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 4, input);

                    throw nvae;

                }
                }
                break;
            case STATIC:
                {
                int LA39_5 = input.LA(2);

                if ( (synpred52_NoDynamicLoadingANTLR()) ) {
                    alt39=1;
                }
                else if ( (synpred53_NoDynamicLoadingANTLR()) ) {
                    alt39=2;
                }
                else if ( (synpred54_NoDynamicLoadingANTLR()) ) {
                    alt39=3;
                }
                else if ( (true) ) {
                    alt39=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 5, input);

                    throw nvae;

                }
                }
                break;
            case ABSTRACT:
                {
                int LA39_6 = input.LA(2);

                if ( (synpred52_NoDynamicLoadingANTLR()) ) {
                    alt39=1;
                }
                else if ( (synpred53_NoDynamicLoadingANTLR()) ) {
                    alt39=2;
                }
                else if ( (synpred54_NoDynamicLoadingANTLR()) ) {
                    alt39=3;
                }
                else if ( (true) ) {
                    alt39=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 6, input);

                    throw nvae;

                }
                }
                break;
            case FINAL:
                {
                int LA39_7 = input.LA(2);

                if ( (synpred52_NoDynamicLoadingANTLR()) ) {
                    alt39=1;
                }
                else if ( (synpred53_NoDynamicLoadingANTLR()) ) {
                    alt39=2;
                }
                else if ( (synpred54_NoDynamicLoadingANTLR()) ) {
                    alt39=3;
                }
                else if ( (true) ) {
                    alt39=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 7, input);

                    throw nvae;

                }
                }
                break;
            case NATIVE:
                {
                int LA39_8 = input.LA(2);

                if ( (synpred52_NoDynamicLoadingANTLR()) ) {
                    alt39=1;
                }
                else if ( (synpred53_NoDynamicLoadingANTLR()) ) {
                    alt39=2;
                }
                else if ( (synpred54_NoDynamicLoadingANTLR()) ) {
                    alt39=3;
                }
                else if ( (true) ) {
                    alt39=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 8, input);

                    throw nvae;

                }
                }
                break;
            case SYNCHRONIZED:
                {
                int LA39_9 = input.LA(2);

                if ( (synpred52_NoDynamicLoadingANTLR()) ) {
                    alt39=1;
                }
                else if ( (synpred53_NoDynamicLoadingANTLR()) ) {
                    alt39=2;
                }
                else if ( (synpred54_NoDynamicLoadingANTLR()) ) {
                    alt39=3;
                }
                else if ( (true) ) {
                    alt39=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 9, input);

                    throw nvae;

                }
                }
                break;
            case TRANSIENT:
                {
                int LA39_10 = input.LA(2);

                if ( (synpred52_NoDynamicLoadingANTLR()) ) {
                    alt39=1;
                }
                else if ( (synpred53_NoDynamicLoadingANTLR()) ) {
                    alt39=2;
                }
                else if ( (synpred54_NoDynamicLoadingANTLR()) ) {
                    alt39=3;
                }
                else if ( (true) ) {
                    alt39=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 10, input);

                    throw nvae;

                }
                }
                break;
            case VOLATILE:
                {
                int LA39_11 = input.LA(2);

                if ( (synpred52_NoDynamicLoadingANTLR()) ) {
                    alt39=1;
                }
                else if ( (synpred53_NoDynamicLoadingANTLR()) ) {
                    alt39=2;
                }
                else if ( (synpred54_NoDynamicLoadingANTLR()) ) {
                    alt39=3;
                }
                else if ( (true) ) {
                    alt39=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 11, input);

                    throw nvae;

                }
                }
                break;
            case STRICTFP:
                {
                int LA39_12 = input.LA(2);

                if ( (synpred52_NoDynamicLoadingANTLR()) ) {
                    alt39=1;
                }
                else if ( (synpred53_NoDynamicLoadingANTLR()) ) {
                    alt39=2;
                }
                else if ( (synpred54_NoDynamicLoadingANTLR()) ) {
                    alt39=3;
                }
                else if ( (true) ) {
                    alt39=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 12, input);

                    throw nvae;

                }
                }
                break;
            case IDENTIFIER:
                {
                int LA39_13 = input.LA(2);

                if ( (synpred52_NoDynamicLoadingANTLR()) ) {
                    alt39=1;
                }
                else if ( (synpred53_NoDynamicLoadingANTLR()) ) {
                    alt39=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 13, input);

                    throw nvae;

                }
                }
                break;
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case DOUBLE:
            case FLOAT:
            case INT:
            case LONG:
            case SHORT:
                {
                int LA39_14 = input.LA(2);

                if ( (synpred52_NoDynamicLoadingANTLR()) ) {
                    alt39=1;
                }
                else if ( (synpred53_NoDynamicLoadingANTLR()) ) {
                    alt39=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 14, input);

                    throw nvae;

                }
                }
                break;
            case LT:
            case VOID:
                {
                alt39=2;
                }
                break;
            case CLASS:
            case ENUM:
                {
                alt39=3;
                }
                break;
            case INTERFACE:
                {
                alt39=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;

            }

            switch (alt39) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:537:10: fieldDeclaration
                    {
                    pushFollow(FOLLOW_fieldDeclaration_in_memberDecl1734);
                    fieldDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:538:10: methodDeclaration
                    {
                    pushFollow(FOLLOW_methodDeclaration_in_memberDecl1745);
                    methodDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:539:10: classDeclaration
                    {
                    pushFollow(FOLLOW_classDeclaration_in_memberDecl1756);
                    classDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:540:10: interfaceDeclaration
                    {
                    pushFollow(FOLLOW_interfaceDeclaration_in_memberDecl1767);
                    interfaceDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 25, memberDecl_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "memberDecl"



    // $ANTLR start "methodDeclaration"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:544:1: methodDeclaration : ( modifiers ( typeParameters )? IDENTIFIER formalParameters ( 'throws' qualifiedNameList )? '{' ( explicitConstructorInvocation )? ( blockStatement )* '}' | modifiers ( typeParameters )? ( type | 'void' ) IDENTIFIER formalParameters ( '[' ']' )* ( 'throws' qualifiedNameList )? ( block | ';' ) );
    public final void methodDeclaration() throws RecognitionException {
        int methodDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:545:5: ( modifiers ( typeParameters )? IDENTIFIER formalParameters ( 'throws' qualifiedNameList )? '{' ( explicitConstructorInvocation )? ( blockStatement )* '}' | modifiers ( typeParameters )? ( type | 'void' ) IDENTIFIER formalParameters ( '[' ']' )* ( 'throws' qualifiedNameList )? ( block | ';' ) )
            int alt49=2;
            switch ( input.LA(1) ) {
            case MONKEYS_AT:
                {
                int LA49_1 = input.LA(2);

                if ( (synpred59_NoDynamicLoadingANTLR()) ) {
                    alt49=1;
                }
                else if ( (true) ) {
                    alt49=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 1, input);

                    throw nvae;

                }
                }
                break;
            case PUBLIC:
                {
                int LA49_2 = input.LA(2);

                if ( (synpred59_NoDynamicLoadingANTLR()) ) {
                    alt49=1;
                }
                else if ( (true) ) {
                    alt49=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 2, input);

                    throw nvae;

                }
                }
                break;
            case PROTECTED:
                {
                int LA49_3 = input.LA(2);

                if ( (synpred59_NoDynamicLoadingANTLR()) ) {
                    alt49=1;
                }
                else if ( (true) ) {
                    alt49=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 3, input);

                    throw nvae;

                }
                }
                break;
            case PRIVATE:
                {
                int LA49_4 = input.LA(2);

                if ( (synpred59_NoDynamicLoadingANTLR()) ) {
                    alt49=1;
                }
                else if ( (true) ) {
                    alt49=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 4, input);

                    throw nvae;

                }
                }
                break;
            case STATIC:
                {
                int LA49_5 = input.LA(2);

                if ( (synpred59_NoDynamicLoadingANTLR()) ) {
                    alt49=1;
                }
                else if ( (true) ) {
                    alt49=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 5, input);

                    throw nvae;

                }
                }
                break;
            case ABSTRACT:
                {
                int LA49_6 = input.LA(2);

                if ( (synpred59_NoDynamicLoadingANTLR()) ) {
                    alt49=1;
                }
                else if ( (true) ) {
                    alt49=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 6, input);

                    throw nvae;

                }
                }
                break;
            case FINAL:
                {
                int LA49_7 = input.LA(2);

                if ( (synpred59_NoDynamicLoadingANTLR()) ) {
                    alt49=1;
                }
                else if ( (true) ) {
                    alt49=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 7, input);

                    throw nvae;

                }
                }
                break;
            case NATIVE:
                {
                int LA49_8 = input.LA(2);

                if ( (synpred59_NoDynamicLoadingANTLR()) ) {
                    alt49=1;
                }
                else if ( (true) ) {
                    alt49=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 8, input);

                    throw nvae;

                }
                }
                break;
            case SYNCHRONIZED:
                {
                int LA49_9 = input.LA(2);

                if ( (synpred59_NoDynamicLoadingANTLR()) ) {
                    alt49=1;
                }
                else if ( (true) ) {
                    alt49=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 9, input);

                    throw nvae;

                }
                }
                break;
            case TRANSIENT:
                {
                int LA49_10 = input.LA(2);

                if ( (synpred59_NoDynamicLoadingANTLR()) ) {
                    alt49=1;
                }
                else if ( (true) ) {
                    alt49=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 10, input);

                    throw nvae;

                }
                }
                break;
            case VOLATILE:
                {
                int LA49_11 = input.LA(2);

                if ( (synpred59_NoDynamicLoadingANTLR()) ) {
                    alt49=1;
                }
                else if ( (true) ) {
                    alt49=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 11, input);

                    throw nvae;

                }
                }
                break;
            case STRICTFP:
                {
                int LA49_12 = input.LA(2);

                if ( (synpred59_NoDynamicLoadingANTLR()) ) {
                    alt49=1;
                }
                else if ( (true) ) {
                    alt49=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 12, input);

                    throw nvae;

                }
                }
                break;
            case LT:
                {
                int LA49_13 = input.LA(2);

                if ( (synpred59_NoDynamicLoadingANTLR()) ) {
                    alt49=1;
                }
                else if ( (true) ) {
                    alt49=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 13, input);

                    throw nvae;

                }
                }
                break;
            case IDENTIFIER:
                {
                int LA49_14 = input.LA(2);

                if ( (synpred59_NoDynamicLoadingANTLR()) ) {
                    alt49=1;
                }
                else if ( (true) ) {
                    alt49=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 14, input);

                    throw nvae;

                }
                }
                break;
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case DOUBLE:
            case FLOAT:
            case INT:
            case LONG:
            case SHORT:
            case VOID:
                {
                alt49=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;

            }

            switch (alt49) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:547:10: modifiers ( typeParameters )? IDENTIFIER formalParameters ( 'throws' qualifiedNameList )? '{' ( explicitConstructorInvocation )? ( blockStatement )* '}'
                    {
                    pushFollow(FOLLOW_modifiers_in_methodDeclaration1805);
                    modifiers();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:548:9: ( typeParameters )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==LT) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:548:10: typeParameters
                            {
                            pushFollow(FOLLOW_typeParameters_in_methodDeclaration1816);
                            typeParameters();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_methodDeclaration1837); if (state.failed) return ;

                    pushFollow(FOLLOW_formalParameters_in_methodDeclaration1847);
                    formalParameters();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:552:9: ( 'throws' qualifiedNameList )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==THROWS) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:552:10: 'throws' qualifiedNameList
                            {
                            match(input,THROWS,FOLLOW_THROWS_in_methodDeclaration1858); if (state.failed) return ;

                            pushFollow(FOLLOW_qualifiedNameList_in_methodDeclaration1860);
                            qualifiedNameList();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,LBRACE,FOLLOW_LBRACE_in_methodDeclaration1881); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:555:9: ( explicitConstructorInvocation )?
                    int alt42=2;
                    switch ( input.LA(1) ) {
                        case LT:
                            {
                            alt42=1;
                            }
                            break;
                        case THIS:
                            {
                            int LA42_2 = input.LA(2);

                            if ( (synpred57_NoDynamicLoadingANTLR()) ) {
                                alt42=1;
                            }
                            }
                            break;
                        case LPAREN:
                            {
                            int LA42_3 = input.LA(2);

                            if ( (synpred57_NoDynamicLoadingANTLR()) ) {
                                alt42=1;
                            }
                            }
                            break;
                        case SUPER:
                            {
                            int LA42_4 = input.LA(2);

                            if ( (synpred57_NoDynamicLoadingANTLR()) ) {
                                alt42=1;
                            }
                            }
                            break;
                        case IDENTIFIER:
                            {
                            int LA42_5 = input.LA(2);

                            if ( (synpred57_NoDynamicLoadingANTLR()) ) {
                                alt42=1;
                            }
                            }
                            break;
                        case CHARLITERAL:
                        case DOUBLELITERAL:
                        case FALSE:
                        case FLOATLITERAL:
                        case INTLITERAL:
                        case LONGLITERAL:
                        case NULL:
                        case STRINGLITERAL:
                        case TRUE:
                            {
                            int LA42_6 = input.LA(2);

                            if ( (synpred57_NoDynamicLoadingANTLR()) ) {
                                alt42=1;
                            }
                            }
                            break;
                        case NEW:
                            {
                            int LA42_7 = input.LA(2);

                            if ( (synpred57_NoDynamicLoadingANTLR()) ) {
                                alt42=1;
                            }
                            }
                            break;
                        case BOOLEAN:
                        case BYTE:
                        case CHAR:
                        case DOUBLE:
                        case FLOAT:
                        case INT:
                        case LONG:
                        case SHORT:
                            {
                            int LA42_8 = input.LA(2);

                            if ( (synpred57_NoDynamicLoadingANTLR()) ) {
                                alt42=1;
                            }
                            }
                            break;
                        case VOID:
                            {
                            int LA42_9 = input.LA(2);

                            if ( (synpred57_NoDynamicLoadingANTLR()) ) {
                                alt42=1;
                            }
                            }
                            break;
                    }

                    switch (alt42) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:555:10: explicitConstructorInvocation
                            {
                            pushFollow(FOLLOW_explicitConstructorInvocation_in_methodDeclaration1893);
                            explicitConstructorInvocation();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:557:9: ( blockStatement )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==ABSTRACT||(LA43_0 >= ASSERT && LA43_0 <= BANG)||(LA43_0 >= BOOLEAN && LA43_0 <= BYTE)||(LA43_0 >= CHAR && LA43_0 <= CLASS)||LA43_0==CONTINUE||LA43_0==DO||(LA43_0 >= DOUBLE && LA43_0 <= DOUBLELITERAL)||LA43_0==ENUM||(LA43_0 >= FALSE && LA43_0 <= FINAL)||(LA43_0 >= FLOAT && LA43_0 <= FOR)||(LA43_0 >= IDENTIFIER && LA43_0 <= IF)||(LA43_0 >= INT && LA43_0 <= INTLITERAL)||LA43_0==LBRACE||(LA43_0 >= LONG && LA43_0 <= LT)||(LA43_0 >= MONKEYS_AT && LA43_0 <= NULL)||LA43_0==PLUS||(LA43_0 >= PLUSPLUS && LA43_0 <= PUBLIC)||LA43_0==RETURN||(LA43_0 >= SEMI && LA43_0 <= SHORT)||(LA43_0 >= STATIC && LA43_0 <= SUB)||(LA43_0 >= SUBSUB && LA43_0 <= SYNCHRONIZED)||(LA43_0 >= THIS && LA43_0 <= THROW)||(LA43_0 >= TILDE && LA43_0 <= WHILE)) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:557:10: blockStatement
                    	    {
                    	    pushFollow(FOLLOW_blockStatement_in_methodDeclaration1915);
                    	    blockStatement();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop43;
                        }
                    } while (true);


                    match(input,RBRACE,FOLLOW_RBRACE_in_methodDeclaration1936); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:560:9: modifiers ( typeParameters )? ( type | 'void' ) IDENTIFIER formalParameters ( '[' ']' )* ( 'throws' qualifiedNameList )? ( block | ';' )
                    {
                    pushFollow(FOLLOW_modifiers_in_methodDeclaration1946);
                    modifiers();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:561:9: ( typeParameters )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==LT) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:561:10: typeParameters
                            {
                            pushFollow(FOLLOW_typeParameters_in_methodDeclaration1957);
                            typeParameters();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:563:9: ( type | 'void' )
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==BOOLEAN||LA45_0==BYTE||LA45_0==CHAR||LA45_0==DOUBLE||LA45_0==FLOAT||LA45_0==IDENTIFIER||LA45_0==INT||LA45_0==LONG||LA45_0==SHORT) ) {
                        alt45=1;
                    }
                    else if ( (LA45_0==VOID) ) {
                        alt45=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 45, 0, input);

                        throw nvae;

                    }
                    switch (alt45) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:563:10: type
                            {
                            pushFollow(FOLLOW_type_in_methodDeclaration1979);
                            type();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;
                        case 2 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:564:13: 'void'
                            {
                            match(input,VOID,FOLLOW_VOID_in_methodDeclaration1993); if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_methodDeclaration2013); if (state.failed) return ;

                    pushFollow(FOLLOW_formalParameters_in_methodDeclaration2023);
                    formalParameters();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:568:9: ( '[' ']' )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==LBRACKET) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:568:10: '[' ']'
                    	    {
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_methodDeclaration2034); if (state.failed) return ;

                    	    match(input,RBRACKET,FOLLOW_RBRACKET_in_methodDeclaration2036); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop46;
                        }
                    } while (true);


                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:570:9: ( 'throws' qualifiedNameList )?
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==THROWS) ) {
                        alt47=1;
                    }
                    switch (alt47) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:570:10: 'throws' qualifiedNameList
                            {
                            match(input,THROWS,FOLLOW_THROWS_in_methodDeclaration2058); if (state.failed) return ;

                            pushFollow(FOLLOW_qualifiedNameList_in_methodDeclaration2060);
                            qualifiedNameList();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:572:9: ( block | ';' )
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==LBRACE) ) {
                        alt48=1;
                    }
                    else if ( (LA48_0==SEMI) ) {
                        alt48=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 48, 0, input);

                        throw nvae;

                    }
                    switch (alt48) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:573:13: block
                            {
                            pushFollow(FOLLOW_block_in_methodDeclaration2115);
                            block();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;
                        case 2 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:574:13: ';'
                            {
                            match(input,SEMI,FOLLOW_SEMI_in_methodDeclaration2129); if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 26, methodDeclaration_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "methodDeclaration"



    // $ANTLR start "fieldDeclaration"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:579:1: fieldDeclaration : modifiers type variableDeclarator ( ',' variableDeclarator )* ';' ;
    public final void fieldDeclaration() throws RecognitionException {
        int fieldDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:580:5: ( modifiers type variableDeclarator ( ',' variableDeclarator )* ';' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:580:9: modifiers type variableDeclarator ( ',' variableDeclarator )* ';'
            {
            pushFollow(FOLLOW_modifiers_in_fieldDeclaration2161);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_type_in_fieldDeclaration2171);
            type();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_variableDeclarator_in_fieldDeclaration2181);
            variableDeclarator();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:583:9: ( ',' variableDeclarator )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==COMMA) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:583:10: ',' variableDeclarator
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_fieldDeclaration2192); if (state.failed) return ;

            	    pushFollow(FOLLOW_variableDeclarator_in_fieldDeclaration2194);
            	    variableDeclarator();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);


            match(input,SEMI,FOLLOW_SEMI_in_fieldDeclaration2215); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 27, fieldDeclaration_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "fieldDeclaration"



    // $ANTLR start "variableDeclarator"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:588:1: variableDeclarator : IDENTIFIER ( '[' ']' )* ( '=' variableInitializer )? ;
    public final void variableDeclarator() throws RecognitionException {
        int variableDeclarator_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:589:5: ( IDENTIFIER ( '[' ']' )* ( '=' variableInitializer )? )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:589:9: IDENTIFIER ( '[' ']' )* ( '=' variableInitializer )?
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_variableDeclarator2235); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:590:9: ( '[' ']' )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==LBRACKET) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:590:10: '[' ']'
            	    {
            	    match(input,LBRACKET,FOLLOW_LBRACKET_in_variableDeclarator2246); if (state.failed) return ;

            	    match(input,RBRACKET,FOLLOW_RBRACKET_in_variableDeclarator2248); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:592:9: ( '=' variableInitializer )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==EQ) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:592:10: '=' variableInitializer
                    {
                    match(input,EQ,FOLLOW_EQ_in_variableDeclarator2270); if (state.failed) return ;

                    pushFollow(FOLLOW_variableInitializer_in_variableDeclarator2272);
                    variableInitializer();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 28, variableDeclarator_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "variableDeclarator"



    // $ANTLR start "interfaceBodyDeclaration"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:599:1: interfaceBodyDeclaration : ( interfaceFieldDeclaration | interfaceMethodDeclaration | interfaceDeclaration | classDeclaration | ';' );
    public final void interfaceBodyDeclaration() throws RecognitionException {
        int interfaceBodyDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:600:5: ( interfaceFieldDeclaration | interfaceMethodDeclaration | interfaceDeclaration | classDeclaration | ';' )
            int alt53=5;
            switch ( input.LA(1) ) {
            case MONKEYS_AT:
                {
                int LA53_1 = input.LA(2);

                if ( (synpred68_NoDynamicLoadingANTLR()) ) {
                    alt53=1;
                }
                else if ( (synpred69_NoDynamicLoadingANTLR()) ) {
                    alt53=2;
                }
                else if ( (synpred70_NoDynamicLoadingANTLR()) ) {
                    alt53=3;
                }
                else if ( (synpred71_NoDynamicLoadingANTLR()) ) {
                    alt53=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 1, input);

                    throw nvae;

                }
                }
                break;
            case PUBLIC:
                {
                int LA53_2 = input.LA(2);

                if ( (synpred68_NoDynamicLoadingANTLR()) ) {
                    alt53=1;
                }
                else if ( (synpred69_NoDynamicLoadingANTLR()) ) {
                    alt53=2;
                }
                else if ( (synpred70_NoDynamicLoadingANTLR()) ) {
                    alt53=3;
                }
                else if ( (synpred71_NoDynamicLoadingANTLR()) ) {
                    alt53=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 2, input);

                    throw nvae;

                }
                }
                break;
            case PROTECTED:
                {
                int LA53_3 = input.LA(2);

                if ( (synpred68_NoDynamicLoadingANTLR()) ) {
                    alt53=1;
                }
                else if ( (synpred69_NoDynamicLoadingANTLR()) ) {
                    alt53=2;
                }
                else if ( (synpred70_NoDynamicLoadingANTLR()) ) {
                    alt53=3;
                }
                else if ( (synpred71_NoDynamicLoadingANTLR()) ) {
                    alt53=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 3, input);

                    throw nvae;

                }
                }
                break;
            case PRIVATE:
                {
                int LA53_4 = input.LA(2);

                if ( (synpred68_NoDynamicLoadingANTLR()) ) {
                    alt53=1;
                }
                else if ( (synpred69_NoDynamicLoadingANTLR()) ) {
                    alt53=2;
                }
                else if ( (synpred70_NoDynamicLoadingANTLR()) ) {
                    alt53=3;
                }
                else if ( (synpred71_NoDynamicLoadingANTLR()) ) {
                    alt53=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 4, input);

                    throw nvae;

                }
                }
                break;
            case STATIC:
                {
                int LA53_5 = input.LA(2);

                if ( (synpred68_NoDynamicLoadingANTLR()) ) {
                    alt53=1;
                }
                else if ( (synpred69_NoDynamicLoadingANTLR()) ) {
                    alt53=2;
                }
                else if ( (synpred70_NoDynamicLoadingANTLR()) ) {
                    alt53=3;
                }
                else if ( (synpred71_NoDynamicLoadingANTLR()) ) {
                    alt53=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 5, input);

                    throw nvae;

                }
                }
                break;
            case ABSTRACT:
                {
                int LA53_6 = input.LA(2);

                if ( (synpred68_NoDynamicLoadingANTLR()) ) {
                    alt53=1;
                }
                else if ( (synpred69_NoDynamicLoadingANTLR()) ) {
                    alt53=2;
                }
                else if ( (synpred70_NoDynamicLoadingANTLR()) ) {
                    alt53=3;
                }
                else if ( (synpred71_NoDynamicLoadingANTLR()) ) {
                    alt53=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 6, input);

                    throw nvae;

                }
                }
                break;
            case FINAL:
                {
                int LA53_7 = input.LA(2);

                if ( (synpred68_NoDynamicLoadingANTLR()) ) {
                    alt53=1;
                }
                else if ( (synpred69_NoDynamicLoadingANTLR()) ) {
                    alt53=2;
                }
                else if ( (synpred70_NoDynamicLoadingANTLR()) ) {
                    alt53=3;
                }
                else if ( (synpred71_NoDynamicLoadingANTLR()) ) {
                    alt53=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 7, input);

                    throw nvae;

                }
                }
                break;
            case NATIVE:
                {
                int LA53_8 = input.LA(2);

                if ( (synpred68_NoDynamicLoadingANTLR()) ) {
                    alt53=1;
                }
                else if ( (synpred69_NoDynamicLoadingANTLR()) ) {
                    alt53=2;
                }
                else if ( (synpred70_NoDynamicLoadingANTLR()) ) {
                    alt53=3;
                }
                else if ( (synpred71_NoDynamicLoadingANTLR()) ) {
                    alt53=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 8, input);

                    throw nvae;

                }
                }
                break;
            case SYNCHRONIZED:
                {
                int LA53_9 = input.LA(2);

                if ( (synpred68_NoDynamicLoadingANTLR()) ) {
                    alt53=1;
                }
                else if ( (synpred69_NoDynamicLoadingANTLR()) ) {
                    alt53=2;
                }
                else if ( (synpred70_NoDynamicLoadingANTLR()) ) {
                    alt53=3;
                }
                else if ( (synpred71_NoDynamicLoadingANTLR()) ) {
                    alt53=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 9, input);

                    throw nvae;

                }
                }
                break;
            case TRANSIENT:
                {
                int LA53_10 = input.LA(2);

                if ( (synpred68_NoDynamicLoadingANTLR()) ) {
                    alt53=1;
                }
                else if ( (synpred69_NoDynamicLoadingANTLR()) ) {
                    alt53=2;
                }
                else if ( (synpred70_NoDynamicLoadingANTLR()) ) {
                    alt53=3;
                }
                else if ( (synpred71_NoDynamicLoadingANTLR()) ) {
                    alt53=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 10, input);

                    throw nvae;

                }
                }
                break;
            case VOLATILE:
                {
                int LA53_11 = input.LA(2);

                if ( (synpred68_NoDynamicLoadingANTLR()) ) {
                    alt53=1;
                }
                else if ( (synpred69_NoDynamicLoadingANTLR()) ) {
                    alt53=2;
                }
                else if ( (synpred70_NoDynamicLoadingANTLR()) ) {
                    alt53=3;
                }
                else if ( (synpred71_NoDynamicLoadingANTLR()) ) {
                    alt53=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 11, input);

                    throw nvae;

                }
                }
                break;
            case STRICTFP:
                {
                int LA53_12 = input.LA(2);

                if ( (synpred68_NoDynamicLoadingANTLR()) ) {
                    alt53=1;
                }
                else if ( (synpred69_NoDynamicLoadingANTLR()) ) {
                    alt53=2;
                }
                else if ( (synpred70_NoDynamicLoadingANTLR()) ) {
                    alt53=3;
                }
                else if ( (synpred71_NoDynamicLoadingANTLR()) ) {
                    alt53=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 12, input);

                    throw nvae;

                }
                }
                break;
            case IDENTIFIER:
                {
                int LA53_13 = input.LA(2);

                if ( (synpred68_NoDynamicLoadingANTLR()) ) {
                    alt53=1;
                }
                else if ( (synpred69_NoDynamicLoadingANTLR()) ) {
                    alt53=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 13, input);

                    throw nvae;

                }
                }
                break;
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case DOUBLE:
            case FLOAT:
            case INT:
            case LONG:
            case SHORT:
                {
                int LA53_14 = input.LA(2);

                if ( (synpred68_NoDynamicLoadingANTLR()) ) {
                    alt53=1;
                }
                else if ( (synpred69_NoDynamicLoadingANTLR()) ) {
                    alt53=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 14, input);

                    throw nvae;

                }
                }
                break;
            case LT:
            case VOID:
                {
                alt53=2;
                }
                break;
            case INTERFACE:
                {
                alt53=3;
                }
                break;
            case CLASS:
            case ENUM:
                {
                alt53=4;
                }
                break;
            case SEMI:
                {
                alt53=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;

            }

            switch (alt53) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:601:9: interfaceFieldDeclaration
                    {
                    pushFollow(FOLLOW_interfaceFieldDeclaration_in_interfaceBodyDeclaration2311);
                    interfaceFieldDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:602:9: interfaceMethodDeclaration
                    {
                    pushFollow(FOLLOW_interfaceMethodDeclaration_in_interfaceBodyDeclaration2321);
                    interfaceMethodDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:603:9: interfaceDeclaration
                    {
                    pushFollow(FOLLOW_interfaceDeclaration_in_interfaceBodyDeclaration2331);
                    interfaceDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:604:9: classDeclaration
                    {
                    pushFollow(FOLLOW_classDeclaration_in_interfaceBodyDeclaration2341);
                    classDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:605:9: ';'
                    {
                    match(input,SEMI,FOLLOW_SEMI_in_interfaceBodyDeclaration2351); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 29, interfaceBodyDeclaration_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "interfaceBodyDeclaration"



    // $ANTLR start "interfaceMethodDeclaration"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:608:1: interfaceMethodDeclaration : modifiers ( typeParameters )? ( type | 'void' ) IDENTIFIER formalParameters ( '[' ']' )* ( 'throws' qualifiedNameList )? ';' ;
    public final void interfaceMethodDeclaration() throws RecognitionException {
        int interfaceMethodDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:609:5: ( modifiers ( typeParameters )? ( type | 'void' ) IDENTIFIER formalParameters ( '[' ']' )* ( 'throws' qualifiedNameList )? ';' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:609:9: modifiers ( typeParameters )? ( type | 'void' ) IDENTIFIER formalParameters ( '[' ']' )* ( 'throws' qualifiedNameList )? ';'
            {
            pushFollow(FOLLOW_modifiers_in_interfaceMethodDeclaration2371);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:610:9: ( typeParameters )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==LT) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:610:10: typeParameters
                    {
                    pushFollow(FOLLOW_typeParameters_in_interfaceMethodDeclaration2382);
                    typeParameters();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:612:9: ( type | 'void' )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==BOOLEAN||LA55_0==BYTE||LA55_0==CHAR||LA55_0==DOUBLE||LA55_0==FLOAT||LA55_0==IDENTIFIER||LA55_0==INT||LA55_0==LONG||LA55_0==SHORT) ) {
                alt55=1;
            }
            else if ( (LA55_0==VOID) ) {
                alt55=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;

            }
            switch (alt55) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:612:10: type
                    {
                    pushFollow(FOLLOW_type_in_interfaceMethodDeclaration2404);
                    type();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:613:10: 'void'
                    {
                    match(input,VOID,FOLLOW_VOID_in_interfaceMethodDeclaration2415); if (state.failed) return ;

                    }
                    break;

            }


            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_interfaceMethodDeclaration2435); if (state.failed) return ;

            pushFollow(FOLLOW_formalParameters_in_interfaceMethodDeclaration2445);
            formalParameters();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:617:9: ( '[' ']' )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==LBRACKET) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:617:10: '[' ']'
            	    {
            	    match(input,LBRACKET,FOLLOW_LBRACKET_in_interfaceMethodDeclaration2456); if (state.failed) return ;

            	    match(input,RBRACKET,FOLLOW_RBRACKET_in_interfaceMethodDeclaration2458); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:619:9: ( 'throws' qualifiedNameList )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==THROWS) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:619:10: 'throws' qualifiedNameList
                    {
                    match(input,THROWS,FOLLOW_THROWS_in_interfaceMethodDeclaration2480); if (state.failed) return ;

                    pushFollow(FOLLOW_qualifiedNameList_in_interfaceMethodDeclaration2482);
                    qualifiedNameList();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            match(input,SEMI,FOLLOW_SEMI_in_interfaceMethodDeclaration2495); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 30, interfaceMethodDeclaration_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "interfaceMethodDeclaration"



    // $ANTLR start "interfaceFieldDeclaration"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:628:1: interfaceFieldDeclaration : modifiers type variableDeclarator ( ',' variableDeclarator )* ';' ;
    public final void interfaceFieldDeclaration() throws RecognitionException {
        int interfaceFieldDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:629:5: ( modifiers type variableDeclarator ( ',' variableDeclarator )* ';' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:629:9: modifiers type variableDeclarator ( ',' variableDeclarator )* ';'
            {
            pushFollow(FOLLOW_modifiers_in_interfaceFieldDeclaration2517);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_type_in_interfaceFieldDeclaration2519);
            type();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_variableDeclarator_in_interfaceFieldDeclaration2521);
            variableDeclarator();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:630:9: ( ',' variableDeclarator )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==COMMA) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:630:10: ',' variableDeclarator
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_interfaceFieldDeclaration2532); if (state.failed) return ;

            	    pushFollow(FOLLOW_variableDeclarator_in_interfaceFieldDeclaration2534);
            	    variableDeclarator();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);


            match(input,SEMI,FOLLOW_SEMI_in_interfaceFieldDeclaration2555); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 31, interfaceFieldDeclaration_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "interfaceFieldDeclaration"



    // $ANTLR start "type"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:636:1: type : ( classOrInterfaceType ( '[' ']' )* | primitiveType ( '[' ']' )* );
    public final void type() throws RecognitionException {
        int type_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:637:5: ( classOrInterfaceType ( '[' ']' )* | primitiveType ( '[' ']' )* )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==IDENTIFIER) ) {
                alt61=1;
            }
            else if ( (LA61_0==BOOLEAN||LA61_0==BYTE||LA61_0==CHAR||LA61_0==DOUBLE||LA61_0==FLOAT||LA61_0==INT||LA61_0==LONG||LA61_0==SHORT) ) {
                alt61=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;

            }
            switch (alt61) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:637:9: classOrInterfaceType ( '[' ']' )*
                    {
                    pushFollow(FOLLOW_classOrInterfaceType_in_type2576);
                    classOrInterfaceType();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:638:9: ( '[' ']' )*
                    loop59:
                    do {
                        int alt59=2;
                        int LA59_0 = input.LA(1);

                        if ( (LA59_0==LBRACKET) ) {
                            alt59=1;
                        }


                        switch (alt59) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:638:10: '[' ']'
                    	    {
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_type2587); if (state.failed) return ;

                    	    match(input,RBRACKET,FOLLOW_RBRACKET_in_type2589); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop59;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:640:9: primitiveType ( '[' ']' )*
                    {
                    pushFollow(FOLLOW_primitiveType_in_type2610);
                    primitiveType();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:641:9: ( '[' ']' )*
                    loop60:
                    do {
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( (LA60_0==LBRACKET) ) {
                            alt60=1;
                        }


                        switch (alt60) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:641:10: '[' ']'
                    	    {
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_type2621); if (state.failed) return ;

                    	    match(input,RBRACKET,FOLLOW_RBRACKET_in_type2623); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop60;
                        }
                    } while (true);


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 32, type_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "type"



    // $ANTLR start "classOrInterfaceType"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:646:1: classOrInterfaceType : IDENTIFIER ( typeArguments )? ( '.' IDENTIFIER ( typeArguments )? )* ;
    public final void classOrInterfaceType() throws RecognitionException {
        int classOrInterfaceType_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:647:5: ( IDENTIFIER ( typeArguments )? ( '.' IDENTIFIER ( typeArguments )? )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:647:9: IDENTIFIER ( typeArguments )? ( '.' IDENTIFIER ( typeArguments )? )*
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_classOrInterfaceType2655); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:648:9: ( typeArguments )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==LT) ) {
                int LA62_1 = input.LA(2);

                if ( (LA62_1==BOOLEAN||LA62_1==BYTE||LA62_1==CHAR||LA62_1==DOUBLE||LA62_1==FLOAT||LA62_1==IDENTIFIER||LA62_1==INT||LA62_1==LONG||LA62_1==QUES||LA62_1==SHORT) ) {
                    alt62=1;
                }
            }
            switch (alt62) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:648:10: typeArguments
                    {
                    pushFollow(FOLLOW_typeArguments_in_classOrInterfaceType2666);
                    typeArguments();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:650:9: ( '.' IDENTIFIER ( typeArguments )? )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==DOT) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:650:10: '.' IDENTIFIER ( typeArguments )?
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_classOrInterfaceType2688); if (state.failed) return ;

            	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_classOrInterfaceType2690); if (state.failed) return ;

            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:651:13: ( typeArguments )?
            	    int alt63=2;
            	    int LA63_0 = input.LA(1);

            	    if ( (LA63_0==LT) ) {
            	        int LA63_1 = input.LA(2);

            	        if ( (LA63_1==BOOLEAN||LA63_1==BYTE||LA63_1==CHAR||LA63_1==DOUBLE||LA63_1==FLOAT||LA63_1==IDENTIFIER||LA63_1==INT||LA63_1==LONG||LA63_1==QUES||LA63_1==SHORT) ) {
            	            alt63=1;
            	        }
            	    }
            	    switch (alt63) {
            	        case 1 :
            	            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:651:14: typeArguments
            	            {
            	            pushFollow(FOLLOW_typeArguments_in_classOrInterfaceType2705);
            	            typeArguments();

            	            state._fsp--;
            	            if (state.failed) return ;

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 33, classOrInterfaceType_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "classOrInterfaceType"



    // $ANTLR start "primitiveType"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:656:1: primitiveType : ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' );
    public final void primitiveType() throws RecognitionException {
        int primitiveType_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:657:5: ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:
            {
            if ( input.LA(1)==BOOLEAN||input.LA(1)==BYTE||input.LA(1)==CHAR||input.LA(1)==DOUBLE||input.LA(1)==FLOAT||input.LA(1)==INT||input.LA(1)==LONG||input.LA(1)==SHORT ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 34, primitiveType_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "primitiveType"



    // $ANTLR start "typeArguments"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:667:1: typeArguments : '<' typeArgument ( ',' typeArgument )* '>' ;
    public final void typeArguments() throws RecognitionException {
        int typeArguments_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:668:5: ( '<' typeArgument ( ',' typeArgument )* '>' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:668:9: '<' typeArgument ( ',' typeArgument )* '>'
            {
            match(input,LT,FOLLOW_LT_in_typeArguments2842); if (state.failed) return ;

            pushFollow(FOLLOW_typeArgument_in_typeArguments2844);
            typeArgument();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:669:9: ( ',' typeArgument )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==COMMA) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:669:10: ',' typeArgument
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_typeArguments2855); if (state.failed) return ;

            	    pushFollow(FOLLOW_typeArgument_in_typeArguments2857);
            	    typeArgument();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);


            match(input,GT,FOLLOW_GT_in_typeArguments2879); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 35, typeArguments_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "typeArguments"



    // $ANTLR start "typeArgument"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:674:1: typeArgument : ( type | '?' ( ( 'extends' | 'super' ) type )? );
    public final void typeArgument() throws RecognitionException {
        int typeArgument_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:675:5: ( type | '?' ( ( 'extends' | 'super' ) type )? )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==BOOLEAN||LA67_0==BYTE||LA67_0==CHAR||LA67_0==DOUBLE||LA67_0==FLOAT||LA67_0==IDENTIFIER||LA67_0==INT||LA67_0==LONG||LA67_0==SHORT) ) {
                alt67=1;
            }
            else if ( (LA67_0==QUES) ) {
                alt67=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;

            }
            switch (alt67) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:675:9: type
                    {
                    pushFollow(FOLLOW_type_in_typeArgument2899);
                    type();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:676:9: '?' ( ( 'extends' | 'super' ) type )?
                    {
                    match(input,QUES,FOLLOW_QUES_in_typeArgument2909); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:677:9: ( ( 'extends' | 'super' ) type )?
                    int alt66=2;
                    int LA66_0 = input.LA(1);

                    if ( (LA66_0==EXTENDS||LA66_0==SUPER) ) {
                        alt66=1;
                    }
                    switch (alt66) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:678:13: ( 'extends' | 'super' ) type
                            {
                            if ( input.LA(1)==EXTENDS||input.LA(1)==SUPER ) {
                                input.consume();
                                state.errorRecovery=false;
                                state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            pushFollow(FOLLOW_type_in_typeArgument2977);
                            type();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 36, typeArgument_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "typeArgument"



    // $ANTLR start "qualifiedNameList"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:685:1: qualifiedNameList : qualifiedName ( ',' qualifiedName )* ;
    public final void qualifiedNameList() throws RecognitionException {
        int qualifiedNameList_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:686:5: ( qualifiedName ( ',' qualifiedName )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:686:9: qualifiedName ( ',' qualifiedName )*
            {
            pushFollow(FOLLOW_qualifiedName_in_qualifiedNameList3008);
            qualifiedName();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:687:9: ( ',' qualifiedName )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==COMMA) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:687:10: ',' qualifiedName
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_qualifiedNameList3019); if (state.failed) return ;

            	    pushFollow(FOLLOW_qualifiedName_in_qualifiedNameList3021);
            	    qualifiedName();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop68;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 37, qualifiedNameList_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "qualifiedNameList"



    // $ANTLR start "formalParameters"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:691:1: formalParameters : '(' ( formalParameterDecls )? ')' ;
    public final void formalParameters() throws RecognitionException {
        int formalParameters_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:692:5: ( '(' ( formalParameterDecls )? ')' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:692:9: '(' ( formalParameterDecls )? ')'
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_formalParameters3052); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:693:9: ( formalParameterDecls )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==BOOLEAN||LA69_0==BYTE||LA69_0==CHAR||LA69_0==DOUBLE||LA69_0==FINAL||LA69_0==FLOAT||LA69_0==IDENTIFIER||LA69_0==INT||LA69_0==LONG||LA69_0==MONKEYS_AT||LA69_0==SHORT) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:693:10: formalParameterDecls
                    {
                    pushFollow(FOLLOW_formalParameterDecls_in_formalParameters3063);
                    formalParameterDecls();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            match(input,RPAREN,FOLLOW_RPAREN_in_formalParameters3085); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 38, formalParameters_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "formalParameters"



    // $ANTLR start "formalParameterDecls"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:698:1: formalParameterDecls : ( ellipsisParameterDecl | normalParameterDecl ( ',' normalParameterDecl )* | ( normalParameterDecl ',' )+ ellipsisParameterDecl );
    public final void formalParameterDecls() throws RecognitionException {
        int formalParameterDecls_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:699:5: ( ellipsisParameterDecl | normalParameterDecl ( ',' normalParameterDecl )* | ( normalParameterDecl ',' )+ ellipsisParameterDecl )
            int alt72=3;
            switch ( input.LA(1) ) {
            case FINAL:
                {
                int LA72_1 = input.LA(2);

                if ( (synpred96_NoDynamicLoadingANTLR()) ) {
                    alt72=1;
                }
                else if ( (synpred98_NoDynamicLoadingANTLR()) ) {
                    alt72=2;
                }
                else if ( (true) ) {
                    alt72=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 72, 1, input);

                    throw nvae;

                }
                }
                break;
            case MONKEYS_AT:
                {
                int LA72_2 = input.LA(2);

                if ( (synpred96_NoDynamicLoadingANTLR()) ) {
                    alt72=1;
                }
                else if ( (synpred98_NoDynamicLoadingANTLR()) ) {
                    alt72=2;
                }
                else if ( (true) ) {
                    alt72=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 72, 2, input);

                    throw nvae;

                }
                }
                break;
            case IDENTIFIER:
                {
                int LA72_3 = input.LA(2);

                if ( (synpred96_NoDynamicLoadingANTLR()) ) {
                    alt72=1;
                }
                else if ( (synpred98_NoDynamicLoadingANTLR()) ) {
                    alt72=2;
                }
                else if ( (true) ) {
                    alt72=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 72, 3, input);

                    throw nvae;

                }
                }
                break;
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case DOUBLE:
            case FLOAT:
            case INT:
            case LONG:
            case SHORT:
                {
                int LA72_4 = input.LA(2);

                if ( (synpred96_NoDynamicLoadingANTLR()) ) {
                    alt72=1;
                }
                else if ( (synpred98_NoDynamicLoadingANTLR()) ) {
                    alt72=2;
                }
                else if ( (true) ) {
                    alt72=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 72, 4, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;

            }

            switch (alt72) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:699:9: ellipsisParameterDecl
                    {
                    pushFollow(FOLLOW_ellipsisParameterDecl_in_formalParameterDecls3105);
                    ellipsisParameterDecl();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:700:9: normalParameterDecl ( ',' normalParameterDecl )*
                    {
                    pushFollow(FOLLOW_normalParameterDecl_in_formalParameterDecls3115);
                    normalParameterDecl();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:701:9: ( ',' normalParameterDecl )*
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);

                        if ( (LA70_0==COMMA) ) {
                            alt70=1;
                        }


                        switch (alt70) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:701:10: ',' normalParameterDecl
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_formalParameterDecls3126); if (state.failed) return ;

                    	    pushFollow(FOLLOW_normalParameterDecl_in_formalParameterDecls3128);
                    	    normalParameterDecl();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop70;
                        }
                    } while (true);


                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:703:9: ( normalParameterDecl ',' )+ ellipsisParameterDecl
                    {
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:703:9: ( normalParameterDecl ',' )+
                    int cnt71=0;
                    loop71:
                    do {
                        int alt71=2;
                        switch ( input.LA(1) ) {
                        case FINAL:
                            {
                            int LA71_1 = input.LA(2);

                            if ( (synpred99_NoDynamicLoadingANTLR()) ) {
                                alt71=1;
                            }


                            }
                            break;
                        case MONKEYS_AT:
                            {
                            int LA71_2 = input.LA(2);

                            if ( (synpred99_NoDynamicLoadingANTLR()) ) {
                                alt71=1;
                            }


                            }
                            break;
                        case IDENTIFIER:
                            {
                            int LA71_3 = input.LA(2);

                            if ( (synpred99_NoDynamicLoadingANTLR()) ) {
                                alt71=1;
                            }


                            }
                            break;
                        case BOOLEAN:
                        case BYTE:
                        case CHAR:
                        case DOUBLE:
                        case FLOAT:
                        case INT:
                        case LONG:
                        case SHORT:
                            {
                            int LA71_4 = input.LA(2);

                            if ( (synpred99_NoDynamicLoadingANTLR()) ) {
                                alt71=1;
                            }


                            }
                            break;

                        }

                        switch (alt71) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:703:10: normalParameterDecl ','
                    	    {
                    	    pushFollow(FOLLOW_normalParameterDecl_in_formalParameterDecls3150);
                    	    normalParameterDecl();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    match(input,COMMA,FOLLOW_COMMA_in_formalParameterDecls3160); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt71 >= 1 ) break loop71;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(71, input);
                                throw eee;
                        }
                        cnt71++;
                    } while (true);


                    pushFollow(FOLLOW_ellipsisParameterDecl_in_formalParameterDecls3182);
                    ellipsisParameterDecl();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 39, formalParameterDecls_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "formalParameterDecls"



    // $ANTLR start "normalParameterDecl"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:709:1: normalParameterDecl : variableModifiers type IDENTIFIER ( '[' ']' )* ;
    public final void normalParameterDecl() throws RecognitionException {
        int normalParameterDecl_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:710:5: ( variableModifiers type IDENTIFIER ( '[' ']' )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:710:9: variableModifiers type IDENTIFIER ( '[' ']' )*
            {
            pushFollow(FOLLOW_variableModifiers_in_normalParameterDecl3202);
            variableModifiers();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_type_in_normalParameterDecl3204);
            type();

            state._fsp--;
            if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_normalParameterDecl3206); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:711:9: ( '[' ']' )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==LBRACKET) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:711:10: '[' ']'
            	    {
            	    match(input,LBRACKET,FOLLOW_LBRACKET_in_normalParameterDecl3217); if (state.failed) return ;

            	    match(input,RBRACKET,FOLLOW_RBRACKET_in_normalParameterDecl3219); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop73;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 40, normalParameterDecl_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "normalParameterDecl"



    // $ANTLR start "ellipsisParameterDecl"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:715:1: ellipsisParameterDecl : variableModifiers type '...' IDENTIFIER ;
    public final void ellipsisParameterDecl() throws RecognitionException {
        int ellipsisParameterDecl_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:716:5: ( variableModifiers type '...' IDENTIFIER )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:716:9: variableModifiers type '...' IDENTIFIER
            {
            pushFollow(FOLLOW_variableModifiers_in_ellipsisParameterDecl3250);
            variableModifiers();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_type_in_ellipsisParameterDecl3260);
            type();

            state._fsp--;
            if (state.failed) return ;

            match(input,ELLIPSIS,FOLLOW_ELLIPSIS_in_ellipsisParameterDecl3263); if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_ellipsisParameterDecl3273); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 41, ellipsisParameterDecl_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "ellipsisParameterDecl"



    // $ANTLR start "explicitConstructorInvocation"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:722:1: explicitConstructorInvocation : ( ( nonWildcardTypeArguments )? ( 'this' | 'super' ) arguments ';' | primary '.' ( nonWildcardTypeArguments )? 'super' arguments ';' );
    public final void explicitConstructorInvocation() throws RecognitionException {
        int explicitConstructorInvocation_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:723:5: ( ( nonWildcardTypeArguments )? ( 'this' | 'super' ) arguments ';' | primary '.' ( nonWildcardTypeArguments )? 'super' arguments ';' )
            int alt76=2;
            switch ( input.LA(1) ) {
            case LT:
                {
                alt76=1;
                }
                break;
            case THIS:
                {
                int LA76_2 = input.LA(2);

                if ( (synpred103_NoDynamicLoadingANTLR()) ) {
                    alt76=1;
                }
                else if ( (true) ) {
                    alt76=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 76, 2, input);

                    throw nvae;

                }
                }
                break;
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case CHARLITERAL:
            case DOUBLE:
            case DOUBLELITERAL:
            case FALSE:
            case FLOAT:
            case FLOATLITERAL:
            case IDENTIFIER:
            case INT:
            case INTLITERAL:
            case LONG:
            case LONGLITERAL:
            case LPAREN:
            case NEW:
            case NULL:
            case SHORT:
            case STRINGLITERAL:
            case TRUE:
            case VOID:
                {
                alt76=2;
                }
                break;
            case SUPER:
                {
                int LA76_4 = input.LA(2);

                if ( (synpred103_NoDynamicLoadingANTLR()) ) {
                    alt76=1;
                }
                else if ( (true) ) {
                    alt76=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 76, 4, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;

            }

            switch (alt76) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:723:9: ( nonWildcardTypeArguments )? ( 'this' | 'super' ) arguments ';'
                    {
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:723:9: ( nonWildcardTypeArguments )?
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0==LT) ) {
                        alt74=1;
                    }
                    switch (alt74) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:723:10: nonWildcardTypeArguments
                            {
                            pushFollow(FOLLOW_nonWildcardTypeArguments_in_explicitConstructorInvocation3295);
                            nonWildcardTypeArguments();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    if ( input.LA(1)==SUPER||input.LA(1)==THIS ) {
                        input.consume();
                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    pushFollow(FOLLOW_arguments_in_explicitConstructorInvocation3353);
                    arguments();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,SEMI,FOLLOW_SEMI_in_explicitConstructorInvocation3355); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:730:9: primary '.' ( nonWildcardTypeArguments )? 'super' arguments ';'
                    {
                    pushFollow(FOLLOW_primary_in_explicitConstructorInvocation3366);
                    primary();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,DOT,FOLLOW_DOT_in_explicitConstructorInvocation3376); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:732:9: ( nonWildcardTypeArguments )?
                    int alt75=2;
                    int LA75_0 = input.LA(1);

                    if ( (LA75_0==LT) ) {
                        alt75=1;
                    }
                    switch (alt75) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:732:10: nonWildcardTypeArguments
                            {
                            pushFollow(FOLLOW_nonWildcardTypeArguments_in_explicitConstructorInvocation3387);
                            nonWildcardTypeArguments();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,SUPER,FOLLOW_SUPER_in_explicitConstructorInvocation3408); if (state.failed) return ;

                    pushFollow(FOLLOW_arguments_in_explicitConstructorInvocation3418);
                    arguments();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,SEMI,FOLLOW_SEMI_in_explicitConstructorInvocation3420); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 42, explicitConstructorInvocation_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "explicitConstructorInvocation"



    // $ANTLR start "qualifiedName"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:738:1: qualifiedName : IDENTIFIER ( '.' IDENTIFIER )* ;
    public final void qualifiedName() throws RecognitionException {
        int qualifiedName_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:739:5: ( IDENTIFIER ( '.' IDENTIFIER )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:739:9: IDENTIFIER ( '.' IDENTIFIER )*
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_qualifiedName3440); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:740:9: ( '.' IDENTIFIER )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==DOT) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:740:10: '.' IDENTIFIER
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_qualifiedName3451); if (state.failed) return ;

            	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_qualifiedName3453); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop77;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 43, qualifiedName_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "qualifiedName"



    // $ANTLR start "annotations"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:744:1: annotations : ( annotation )+ ;
    public final void annotations() throws RecognitionException {
        int annotations_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:745:5: ( ( annotation )+ )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:745:9: ( annotation )+
            {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:745:9: ( annotation )+
            int cnt78=0;
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==MONKEYS_AT) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:745:10: annotation
            	    {
            	    pushFollow(FOLLOW_annotation_in_annotations3485);
            	    annotation();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt78 >= 1 ) break loop78;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(78, input);
                        throw eee;
                }
                cnt78++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 44, annotations_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "annotations"



    // $ANTLR start "annotation"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:753:1: annotation : '@' qualifiedName ( '(' ( elementValuePairs | elementValue )? ')' )? ;
    public final void annotation() throws RecognitionException {
        int annotation_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:754:5: ( '@' qualifiedName ( '(' ( elementValuePairs | elementValue )? ')' )? )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:754:9: '@' qualifiedName ( '(' ( elementValuePairs | elementValue )? ')' )?
            {
            match(input,MONKEYS_AT,FOLLOW_MONKEYS_AT_in_annotation3518); if (state.failed) return ;

            pushFollow(FOLLOW_qualifiedName_in_annotation3520);
            qualifiedName();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:755:9: ( '(' ( elementValuePairs | elementValue )? ')' )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==LPAREN) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:755:13: '(' ( elementValuePairs | elementValue )? ')'
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_annotation3534); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:756:19: ( elementValuePairs | elementValue )?
                    int alt79=3;
                    int LA79_0 = input.LA(1);

                    if ( (LA79_0==IDENTIFIER) ) {
                        int LA79_1 = input.LA(2);

                        if ( (LA79_1==EQ) ) {
                            alt79=1;
                        }
                        else if ( ((LA79_1 >= AMP && LA79_1 <= AMPAMP)||(LA79_1 >= BANGEQ && LA79_1 <= BARBAR)||LA79_1==CARET||LA79_1==DOT||LA79_1==EQEQ||LA79_1==GT||LA79_1==INSTANCEOF||LA79_1==LBRACKET||(LA79_1 >= LPAREN && LA79_1 <= LT)||LA79_1==PERCENT||LA79_1==PLUS||LA79_1==PLUSPLUS||LA79_1==QUES||LA79_1==RPAREN||LA79_1==SLASH||LA79_1==STAR||LA79_1==SUB||LA79_1==SUBSUB) ) {
                            alt79=2;
                        }
                    }
                    else if ( (LA79_0==BANG||LA79_0==BOOLEAN||LA79_0==BYTE||(LA79_0 >= CHAR && LA79_0 <= CHARLITERAL)||(LA79_0 >= DOUBLE && LA79_0 <= DOUBLELITERAL)||LA79_0==FALSE||(LA79_0 >= FLOAT && LA79_0 <= FLOATLITERAL)||LA79_0==INT||LA79_0==INTLITERAL||LA79_0==LBRACE||(LA79_0 >= LONG && LA79_0 <= LPAREN)||LA79_0==MONKEYS_AT||(LA79_0 >= NEW && LA79_0 <= NULL)||LA79_0==PLUS||LA79_0==PLUSPLUS||LA79_0==SHORT||(LA79_0 >= STRINGLITERAL && LA79_0 <= SUB)||(LA79_0 >= SUBSUB && LA79_0 <= SUPER)||LA79_0==THIS||LA79_0==TILDE||LA79_0==TRUE||LA79_0==VOID) ) {
                        alt79=2;
                    }
                    switch (alt79) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:756:23: elementValuePairs
                            {
                            pushFollow(FOLLOW_elementValuePairs_in_annotation3561);
                            elementValuePairs();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;
                        case 2 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:757:23: elementValue
                            {
                            pushFollow(FOLLOW_elementValue_in_annotation3585);
                            elementValue();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,RPAREN,FOLLOW_RPAREN_in_annotation3621); if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 45, annotation_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "annotation"



    // $ANTLR start "elementValuePairs"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:763:1: elementValuePairs : elementValuePair ( ',' elementValuePair )* ;
    public final void elementValuePairs() throws RecognitionException {
        int elementValuePairs_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:764:5: ( elementValuePair ( ',' elementValuePair )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:764:9: elementValuePair ( ',' elementValuePair )*
            {
            pushFollow(FOLLOW_elementValuePair_in_elementValuePairs3653);
            elementValuePair();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:765:9: ( ',' elementValuePair )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==COMMA) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:765:10: ',' elementValuePair
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_elementValuePairs3664); if (state.failed) return ;

            	    pushFollow(FOLLOW_elementValuePair_in_elementValuePairs3666);
            	    elementValuePair();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop81;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 46, elementValuePairs_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "elementValuePairs"



    // $ANTLR start "elementValuePair"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:769:1: elementValuePair : IDENTIFIER '=' elementValue ;
    public final void elementValuePair() throws RecognitionException {
        int elementValuePair_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:770:5: ( IDENTIFIER '=' elementValue )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:770:9: IDENTIFIER '=' elementValue
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_elementValuePair3697); if (state.failed) return ;

            match(input,EQ,FOLLOW_EQ_in_elementValuePair3699); if (state.failed) return ;

            pushFollow(FOLLOW_elementValue_in_elementValuePair3701);
            elementValue();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 47, elementValuePair_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "elementValuePair"



    // $ANTLR start "elementValue"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:773:1: elementValue : ( conditionalExpression | annotation | elementValueArrayInitializer );
    public final void elementValue() throws RecognitionException {
        int elementValue_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:774:5: ( conditionalExpression | annotation | elementValueArrayInitializer )
            int alt82=3;
            switch ( input.LA(1) ) {
            case BANG:
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case CHARLITERAL:
            case DOUBLE:
            case DOUBLELITERAL:
            case FALSE:
            case FLOAT:
            case FLOATLITERAL:
            case IDENTIFIER:
            case INT:
            case INTLITERAL:
            case LONG:
            case LONGLITERAL:
            case LPAREN:
            case NEW:
            case NULL:
            case PLUS:
            case PLUSPLUS:
            case SHORT:
            case STRINGLITERAL:
            case SUB:
            case SUBSUB:
            case SUPER:
            case THIS:
            case TILDE:
            case TRUE:
            case VOID:
                {
                alt82=1;
                }
                break;
            case MONKEYS_AT:
                {
                alt82=2;
                }
                break;
            case LBRACE:
                {
                alt82=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;

            }

            switch (alt82) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:774:9: conditionalExpression
                    {
                    pushFollow(FOLLOW_conditionalExpression_in_elementValue3721);
                    conditionalExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:775:9: annotation
                    {
                    pushFollow(FOLLOW_annotation_in_elementValue3731);
                    annotation();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:776:9: elementValueArrayInitializer
                    {
                    pushFollow(FOLLOW_elementValueArrayInitializer_in_elementValue3741);
                    elementValueArrayInitializer();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 48, elementValue_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "elementValue"



    // $ANTLR start "elementValueArrayInitializer"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:779:1: elementValueArrayInitializer : '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' ;
    public final void elementValueArrayInitializer() throws RecognitionException {
        int elementValueArrayInitializer_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:780:5: ( '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:780:9: '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}'
            {
            match(input,LBRACE,FOLLOW_LBRACE_in_elementValueArrayInitializer3761); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:781:9: ( elementValue ( ',' elementValue )* )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==BANG||LA84_0==BOOLEAN||LA84_0==BYTE||(LA84_0 >= CHAR && LA84_0 <= CHARLITERAL)||(LA84_0 >= DOUBLE && LA84_0 <= DOUBLELITERAL)||LA84_0==FALSE||(LA84_0 >= FLOAT && LA84_0 <= FLOATLITERAL)||LA84_0==IDENTIFIER||LA84_0==INT||LA84_0==INTLITERAL||LA84_0==LBRACE||(LA84_0 >= LONG && LA84_0 <= LPAREN)||LA84_0==MONKEYS_AT||(LA84_0 >= NEW && LA84_0 <= NULL)||LA84_0==PLUS||LA84_0==PLUSPLUS||LA84_0==SHORT||(LA84_0 >= STRINGLITERAL && LA84_0 <= SUB)||(LA84_0 >= SUBSUB && LA84_0 <= SUPER)||LA84_0==THIS||LA84_0==TILDE||LA84_0==TRUE||LA84_0==VOID) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:781:10: elementValue ( ',' elementValue )*
                    {
                    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer3772);
                    elementValue();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:782:13: ( ',' elementValue )*
                    loop83:
                    do {
                        int alt83=2;
                        int LA83_0 = input.LA(1);

                        if ( (LA83_0==COMMA) ) {
                            int LA83_1 = input.LA(2);

                            if ( (LA83_1==BANG||LA83_1==BOOLEAN||LA83_1==BYTE||(LA83_1 >= CHAR && LA83_1 <= CHARLITERAL)||(LA83_1 >= DOUBLE && LA83_1 <= DOUBLELITERAL)||LA83_1==FALSE||(LA83_1 >= FLOAT && LA83_1 <= FLOATLITERAL)||LA83_1==IDENTIFIER||LA83_1==INT||LA83_1==INTLITERAL||LA83_1==LBRACE||(LA83_1 >= LONG && LA83_1 <= LPAREN)||LA83_1==MONKEYS_AT||(LA83_1 >= NEW && LA83_1 <= NULL)||LA83_1==PLUS||LA83_1==PLUSPLUS||LA83_1==SHORT||(LA83_1 >= STRINGLITERAL && LA83_1 <= SUB)||(LA83_1 >= SUBSUB && LA83_1 <= SUPER)||LA83_1==THIS||LA83_1==TILDE||LA83_1==TRUE||LA83_1==VOID) ) {
                                alt83=1;
                            }


                        }


                        switch (alt83) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:782:14: ',' elementValue
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_elementValueArrayInitializer3787); if (state.failed) return ;

                    	    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer3789);
                    	    elementValue();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop83;
                        }
                    } while (true);


                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:784:12: ( ',' )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==COMMA) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:784:13: ','
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_elementValueArrayInitializer3818); if (state.failed) return ;

                    }
                    break;

            }


            match(input,RBRACE,FOLLOW_RBRACE_in_elementValueArrayInitializer3822); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 49, elementValueArrayInitializer_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "elementValueArrayInitializer"



    // $ANTLR start "annotationTypeDeclaration"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:791:1: annotationTypeDeclaration : modifiers '@' 'interface' IDENTIFIER annotationTypeBody ;
    public final void annotationTypeDeclaration() throws RecognitionException {
        int annotationTypeDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:792:5: ( modifiers '@' 'interface' IDENTIFIER annotationTypeBody )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:792:9: modifiers '@' 'interface' IDENTIFIER annotationTypeBody
            {
            pushFollow(FOLLOW_modifiers_in_annotationTypeDeclaration3845);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            match(input,MONKEYS_AT,FOLLOW_MONKEYS_AT_in_annotationTypeDeclaration3847); if (state.failed) return ;

            match(input,INTERFACE,FOLLOW_INTERFACE_in_annotationTypeDeclaration3857); if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_annotationTypeDeclaration3867); if (state.failed) return ;

            pushFollow(FOLLOW_annotationTypeBody_in_annotationTypeDeclaration3877);
            annotationTypeBody();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 50, annotationTypeDeclaration_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "annotationTypeDeclaration"



    // $ANTLR start "annotationTypeBody"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:799:1: annotationTypeBody : '{' ( annotationTypeElementDeclaration )* '}' ;
    public final void annotationTypeBody() throws RecognitionException {
        int annotationTypeBody_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:800:5: ( '{' ( annotationTypeElementDeclaration )* '}' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:800:9: '{' ( annotationTypeElementDeclaration )* '}'
            {
            match(input,LBRACE,FOLLOW_LBRACE_in_annotationTypeBody3898); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:801:9: ( annotationTypeElementDeclaration )*
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( (LA86_0==ABSTRACT||LA86_0==BOOLEAN||LA86_0==BYTE||LA86_0==CHAR||LA86_0==CLASS||LA86_0==DOUBLE||LA86_0==ENUM||LA86_0==FINAL||LA86_0==FLOAT||LA86_0==IDENTIFIER||(LA86_0 >= INT && LA86_0 <= INTERFACE)||LA86_0==LONG||LA86_0==LT||(LA86_0 >= MONKEYS_AT && LA86_0 <= NATIVE)||(LA86_0 >= PRIVATE && LA86_0 <= PUBLIC)||(LA86_0 >= SEMI && LA86_0 <= SHORT)||(LA86_0 >= STATIC && LA86_0 <= STRICTFP)||LA86_0==SYNCHRONIZED||LA86_0==TRANSIENT||(LA86_0 >= VOID && LA86_0 <= VOLATILE)) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:801:10: annotationTypeElementDeclaration
            	    {
            	    pushFollow(FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody3910);
            	    annotationTypeElementDeclaration();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop86;
                }
            } while (true);


            match(input,RBRACE,FOLLOW_RBRACE_in_annotationTypeBody3932); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 51, annotationTypeBody_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "annotationTypeBody"



    // $ANTLR start "annotationTypeElementDeclaration"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:809:1: annotationTypeElementDeclaration : ( annotationMethodDeclaration | interfaceFieldDeclaration | normalClassDeclaration | normalInterfaceDeclaration | enumDeclaration | annotationTypeDeclaration | ';' );
    public final void annotationTypeElementDeclaration() throws RecognitionException {
        int annotationTypeElementDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:810:5: ( annotationMethodDeclaration | interfaceFieldDeclaration | normalClassDeclaration | normalInterfaceDeclaration | enumDeclaration | annotationTypeDeclaration | ';' )
            int alt87=7;
            switch ( input.LA(1) ) {
            case MONKEYS_AT:
                {
                int LA87_1 = input.LA(2);

                if ( (synpred117_NoDynamicLoadingANTLR()) ) {
                    alt87=1;
                }
                else if ( (synpred118_NoDynamicLoadingANTLR()) ) {
                    alt87=2;
                }
                else if ( (synpred119_NoDynamicLoadingANTLR()) ) {
                    alt87=3;
                }
                else if ( (synpred120_NoDynamicLoadingANTLR()) ) {
                    alt87=4;
                }
                else if ( (synpred121_NoDynamicLoadingANTLR()) ) {
                    alt87=5;
                }
                else if ( (synpred122_NoDynamicLoadingANTLR()) ) {
                    alt87=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 87, 1, input);

                    throw nvae;

                }
                }
                break;
            case PUBLIC:
                {
                int LA87_2 = input.LA(2);

                if ( (synpred117_NoDynamicLoadingANTLR()) ) {
                    alt87=1;
                }
                else if ( (synpred118_NoDynamicLoadingANTLR()) ) {
                    alt87=2;
                }
                else if ( (synpred119_NoDynamicLoadingANTLR()) ) {
                    alt87=3;
                }
                else if ( (synpred120_NoDynamicLoadingANTLR()) ) {
                    alt87=4;
                }
                else if ( (synpred121_NoDynamicLoadingANTLR()) ) {
                    alt87=5;
                }
                else if ( (synpred122_NoDynamicLoadingANTLR()) ) {
                    alt87=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 87, 2, input);

                    throw nvae;

                }
                }
                break;
            case PROTECTED:
                {
                int LA87_3 = input.LA(2);

                if ( (synpred117_NoDynamicLoadingANTLR()) ) {
                    alt87=1;
                }
                else if ( (synpred118_NoDynamicLoadingANTLR()) ) {
                    alt87=2;
                }
                else if ( (synpred119_NoDynamicLoadingANTLR()) ) {
                    alt87=3;
                }
                else if ( (synpred120_NoDynamicLoadingANTLR()) ) {
                    alt87=4;
                }
                else if ( (synpred121_NoDynamicLoadingANTLR()) ) {
                    alt87=5;
                }
                else if ( (synpred122_NoDynamicLoadingANTLR()) ) {
                    alt87=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 87, 3, input);

                    throw nvae;

                }
                }
                break;
            case PRIVATE:
                {
                int LA87_4 = input.LA(2);

                if ( (synpred117_NoDynamicLoadingANTLR()) ) {
                    alt87=1;
                }
                else if ( (synpred118_NoDynamicLoadingANTLR()) ) {
                    alt87=2;
                }
                else if ( (synpred119_NoDynamicLoadingANTLR()) ) {
                    alt87=3;
                }
                else if ( (synpred120_NoDynamicLoadingANTLR()) ) {
                    alt87=4;
                }
                else if ( (synpred121_NoDynamicLoadingANTLR()) ) {
                    alt87=5;
                }
                else if ( (synpred122_NoDynamicLoadingANTLR()) ) {
                    alt87=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 87, 4, input);

                    throw nvae;

                }
                }
                break;
            case STATIC:
                {
                int LA87_5 = input.LA(2);

                if ( (synpred117_NoDynamicLoadingANTLR()) ) {
                    alt87=1;
                }
                else if ( (synpred118_NoDynamicLoadingANTLR()) ) {
                    alt87=2;
                }
                else if ( (synpred119_NoDynamicLoadingANTLR()) ) {
                    alt87=3;
                }
                else if ( (synpred120_NoDynamicLoadingANTLR()) ) {
                    alt87=4;
                }
                else if ( (synpred121_NoDynamicLoadingANTLR()) ) {
                    alt87=5;
                }
                else if ( (synpred122_NoDynamicLoadingANTLR()) ) {
                    alt87=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 87, 5, input);

                    throw nvae;

                }
                }
                break;
            case ABSTRACT:
                {
                int LA87_6 = input.LA(2);

                if ( (synpred117_NoDynamicLoadingANTLR()) ) {
                    alt87=1;
                }
                else if ( (synpred118_NoDynamicLoadingANTLR()) ) {
                    alt87=2;
                }
                else if ( (synpred119_NoDynamicLoadingANTLR()) ) {
                    alt87=3;
                }
                else if ( (synpred120_NoDynamicLoadingANTLR()) ) {
                    alt87=4;
                }
                else if ( (synpred121_NoDynamicLoadingANTLR()) ) {
                    alt87=5;
                }
                else if ( (synpred122_NoDynamicLoadingANTLR()) ) {
                    alt87=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 87, 6, input);

                    throw nvae;

                }
                }
                break;
            case FINAL:
                {
                int LA87_7 = input.LA(2);

                if ( (synpred117_NoDynamicLoadingANTLR()) ) {
                    alt87=1;
                }
                else if ( (synpred118_NoDynamicLoadingANTLR()) ) {
                    alt87=2;
                }
                else if ( (synpred119_NoDynamicLoadingANTLR()) ) {
                    alt87=3;
                }
                else if ( (synpred120_NoDynamicLoadingANTLR()) ) {
                    alt87=4;
                }
                else if ( (synpred121_NoDynamicLoadingANTLR()) ) {
                    alt87=5;
                }
                else if ( (synpred122_NoDynamicLoadingANTLR()) ) {
                    alt87=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 87, 7, input);

                    throw nvae;

                }
                }
                break;
            case NATIVE:
                {
                int LA87_8 = input.LA(2);

                if ( (synpred117_NoDynamicLoadingANTLR()) ) {
                    alt87=1;
                }
                else if ( (synpred118_NoDynamicLoadingANTLR()) ) {
                    alt87=2;
                }
                else if ( (synpred119_NoDynamicLoadingANTLR()) ) {
                    alt87=3;
                }
                else if ( (synpred120_NoDynamicLoadingANTLR()) ) {
                    alt87=4;
                }
                else if ( (synpred121_NoDynamicLoadingANTLR()) ) {
                    alt87=5;
                }
                else if ( (synpred122_NoDynamicLoadingANTLR()) ) {
                    alt87=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 87, 8, input);

                    throw nvae;

                }
                }
                break;
            case SYNCHRONIZED:
                {
                int LA87_9 = input.LA(2);

                if ( (synpred117_NoDynamicLoadingANTLR()) ) {
                    alt87=1;
                }
                else if ( (synpred118_NoDynamicLoadingANTLR()) ) {
                    alt87=2;
                }
                else if ( (synpred119_NoDynamicLoadingANTLR()) ) {
                    alt87=3;
                }
                else if ( (synpred120_NoDynamicLoadingANTLR()) ) {
                    alt87=4;
                }
                else if ( (synpred121_NoDynamicLoadingANTLR()) ) {
                    alt87=5;
                }
                else if ( (synpred122_NoDynamicLoadingANTLR()) ) {
                    alt87=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 87, 9, input);

                    throw nvae;

                }
                }
                break;
            case TRANSIENT:
                {
                int LA87_10 = input.LA(2);

                if ( (synpred117_NoDynamicLoadingANTLR()) ) {
                    alt87=1;
                }
                else if ( (synpred118_NoDynamicLoadingANTLR()) ) {
                    alt87=2;
                }
                else if ( (synpred119_NoDynamicLoadingANTLR()) ) {
                    alt87=3;
                }
                else if ( (synpred120_NoDynamicLoadingANTLR()) ) {
                    alt87=4;
                }
                else if ( (synpred121_NoDynamicLoadingANTLR()) ) {
                    alt87=5;
                }
                else if ( (synpred122_NoDynamicLoadingANTLR()) ) {
                    alt87=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 87, 10, input);

                    throw nvae;

                }
                }
                break;
            case VOLATILE:
                {
                int LA87_11 = input.LA(2);

                if ( (synpred117_NoDynamicLoadingANTLR()) ) {
                    alt87=1;
                }
                else if ( (synpred118_NoDynamicLoadingANTLR()) ) {
                    alt87=2;
                }
                else if ( (synpred119_NoDynamicLoadingANTLR()) ) {
                    alt87=3;
                }
                else if ( (synpred120_NoDynamicLoadingANTLR()) ) {
                    alt87=4;
                }
                else if ( (synpred121_NoDynamicLoadingANTLR()) ) {
                    alt87=5;
                }
                else if ( (synpred122_NoDynamicLoadingANTLR()) ) {
                    alt87=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 87, 11, input);

                    throw nvae;

                }
                }
                break;
            case STRICTFP:
                {
                int LA87_12 = input.LA(2);

                if ( (synpred117_NoDynamicLoadingANTLR()) ) {
                    alt87=1;
                }
                else if ( (synpred118_NoDynamicLoadingANTLR()) ) {
                    alt87=2;
                }
                else if ( (synpred119_NoDynamicLoadingANTLR()) ) {
                    alt87=3;
                }
                else if ( (synpred120_NoDynamicLoadingANTLR()) ) {
                    alt87=4;
                }
                else if ( (synpred121_NoDynamicLoadingANTLR()) ) {
                    alt87=5;
                }
                else if ( (synpred122_NoDynamicLoadingANTLR()) ) {
                    alt87=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 87, 12, input);

                    throw nvae;

                }
                }
                break;
            case IDENTIFIER:
                {
                int LA87_13 = input.LA(2);

                if ( (synpred117_NoDynamicLoadingANTLR()) ) {
                    alt87=1;
                }
                else if ( (synpred118_NoDynamicLoadingANTLR()) ) {
                    alt87=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 87, 13, input);

                    throw nvae;

                }
                }
                break;
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case DOUBLE:
            case FLOAT:
            case INT:
            case LONG:
            case SHORT:
                {
                int LA87_14 = input.LA(2);

                if ( (synpred117_NoDynamicLoadingANTLR()) ) {
                    alt87=1;
                }
                else if ( (synpred118_NoDynamicLoadingANTLR()) ) {
                    alt87=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 87, 14, input);

                    throw nvae;

                }
                }
                break;
            case CLASS:
                {
                alt87=3;
                }
                break;
            case INTERFACE:
                {
                alt87=4;
                }
                break;
            case ENUM:
                {
                alt87=5;
                }
                break;
            case SEMI:
                {
                alt87=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;

            }

            switch (alt87) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:810:9: annotationMethodDeclaration
                    {
                    pushFollow(FOLLOW_annotationMethodDeclaration_in_annotationTypeElementDeclaration3954);
                    annotationMethodDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:811:9: interfaceFieldDeclaration
                    {
                    pushFollow(FOLLOW_interfaceFieldDeclaration_in_annotationTypeElementDeclaration3964);
                    interfaceFieldDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:812:9: normalClassDeclaration
                    {
                    pushFollow(FOLLOW_normalClassDeclaration_in_annotationTypeElementDeclaration3974);
                    normalClassDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:813:9: normalInterfaceDeclaration
                    {
                    pushFollow(FOLLOW_normalInterfaceDeclaration_in_annotationTypeElementDeclaration3984);
                    normalInterfaceDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:814:9: enumDeclaration
                    {
                    pushFollow(FOLLOW_enumDeclaration_in_annotationTypeElementDeclaration3994);
                    enumDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:815:9: annotationTypeDeclaration
                    {
                    pushFollow(FOLLOW_annotationTypeDeclaration_in_annotationTypeElementDeclaration4004);
                    annotationTypeDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:816:9: ';'
                    {
                    match(input,SEMI,FOLLOW_SEMI_in_annotationTypeElementDeclaration4014); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 52, annotationTypeElementDeclaration_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "annotationTypeElementDeclaration"



    // $ANTLR start "annotationMethodDeclaration"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:819:1: annotationMethodDeclaration : modifiers type IDENTIFIER '(' ')' ( 'default' elementValue )? ';' ;
    public final void annotationMethodDeclaration() throws RecognitionException {
        int annotationMethodDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:820:5: ( modifiers type IDENTIFIER '(' ')' ( 'default' elementValue )? ';' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:820:9: modifiers type IDENTIFIER '(' ')' ( 'default' elementValue )? ';'
            {
            pushFollow(FOLLOW_modifiers_in_annotationMethodDeclaration4034);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_type_in_annotationMethodDeclaration4036);
            type();

            state._fsp--;
            if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_annotationMethodDeclaration4038); if (state.failed) return ;

            match(input,LPAREN,FOLLOW_LPAREN_in_annotationMethodDeclaration4048); if (state.failed) return ;

            match(input,RPAREN,FOLLOW_RPAREN_in_annotationMethodDeclaration4050); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:821:17: ( 'default' elementValue )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==DEFAULT) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:821:18: 'default' elementValue
                    {
                    match(input,DEFAULT,FOLLOW_DEFAULT_in_annotationMethodDeclaration4053); if (state.failed) return ;

                    pushFollow(FOLLOW_elementValue_in_annotationMethodDeclaration4055);
                    elementValue();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            match(input,SEMI,FOLLOW_SEMI_in_annotationMethodDeclaration4084); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 53, annotationMethodDeclaration_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "annotationMethodDeclaration"



    // $ANTLR start "block"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:826:1: block : '{' ( blockStatement )* '}' ;
    public final void block() throws RecognitionException {
        int block_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:827:5: ( '{' ( blockStatement )* '}' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:827:9: '{' ( blockStatement )* '}'
            {
            match(input,LBRACE,FOLLOW_LBRACE_in_block4108); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:828:9: ( blockStatement )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==ABSTRACT||(LA89_0 >= ASSERT && LA89_0 <= BANG)||(LA89_0 >= BOOLEAN && LA89_0 <= BYTE)||(LA89_0 >= CHAR && LA89_0 <= CLASS)||LA89_0==CONTINUE||LA89_0==DO||(LA89_0 >= DOUBLE && LA89_0 <= DOUBLELITERAL)||LA89_0==ENUM||(LA89_0 >= FALSE && LA89_0 <= FINAL)||(LA89_0 >= FLOAT && LA89_0 <= FOR)||(LA89_0 >= IDENTIFIER && LA89_0 <= IF)||(LA89_0 >= INT && LA89_0 <= INTLITERAL)||LA89_0==LBRACE||(LA89_0 >= LONG && LA89_0 <= LT)||(LA89_0 >= MONKEYS_AT && LA89_0 <= NULL)||LA89_0==PLUS||(LA89_0 >= PLUSPLUS && LA89_0 <= PUBLIC)||LA89_0==RETURN||(LA89_0 >= SEMI && LA89_0 <= SHORT)||(LA89_0 >= STATIC && LA89_0 <= SUB)||(LA89_0 >= SUBSUB && LA89_0 <= SYNCHRONIZED)||(LA89_0 >= THIS && LA89_0 <= THROW)||(LA89_0 >= TILDE && LA89_0 <= WHILE)) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:828:10: blockStatement
            	    {
            	    pushFollow(FOLLOW_blockStatement_in_block4119);
            	    blockStatement();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop89;
                }
            } while (true);


            match(input,RBRACE,FOLLOW_RBRACE_in_block4140); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 54, block_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "block"



    // $ANTLR start "blockStatement"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:857:1: blockStatement : ( localVariableDeclarationStatement | classOrInterfaceDeclaration | statement );
    public final void blockStatement() throws RecognitionException {
        int blockStatement_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:858:5: ( localVariableDeclarationStatement | classOrInterfaceDeclaration | statement )
            int alt90=3;
            switch ( input.LA(1) ) {
            case FINAL:
                {
                int LA90_1 = input.LA(2);

                if ( (synpred125_NoDynamicLoadingANTLR()) ) {
                    alt90=1;
                }
                else if ( (synpred126_NoDynamicLoadingANTLR()) ) {
                    alt90=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 90, 1, input);

                    throw nvae;

                }
                }
                break;
            case MONKEYS_AT:
                {
                int LA90_2 = input.LA(2);

                if ( (synpred125_NoDynamicLoadingANTLR()) ) {
                    alt90=1;
                }
                else if ( (synpred126_NoDynamicLoadingANTLR()) ) {
                    alt90=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 90, 2, input);

                    throw nvae;

                }
                }
                break;
            case IDENTIFIER:
                {
                int LA90_3 = input.LA(2);

                if ( (synpred125_NoDynamicLoadingANTLR()) ) {
                    alt90=1;
                }
                else if ( (true) ) {
                    alt90=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 90, 3, input);

                    throw nvae;

                }
                }
                break;
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case DOUBLE:
            case FLOAT:
            case INT:
            case LONG:
            case SHORT:
                {
                int LA90_4 = input.LA(2);

                if ( (synpred125_NoDynamicLoadingANTLR()) ) {
                    alt90=1;
                }
                else if ( (true) ) {
                    alt90=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 90, 4, input);

                    throw nvae;

                }
                }
                break;
            case ABSTRACT:
            case CLASS:
            case ENUM:
            case INTERFACE:
            case NATIVE:
            case PRIVATE:
            case PROTECTED:
            case PUBLIC:
            case STATIC:
            case STRICTFP:
            case TRANSIENT:
            case VOLATILE:
                {
                alt90=2;
                }
                break;
            case SYNCHRONIZED:
                {
                int LA90_11 = input.LA(2);

                if ( (synpred126_NoDynamicLoadingANTLR()) ) {
                    alt90=2;
                }
                else if ( (true) ) {
                    alt90=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 90, 11, input);

                    throw nvae;

                }
                }
                break;
            case ASSERT:
            case BANG:
            case BREAK:
            case CHARLITERAL:
            case CONTINUE:
            case DO:
            case DOUBLELITERAL:
            case FALSE:
            case FLOATLITERAL:
            case FOR:
            case IF:
            case INTLITERAL:
            case LBRACE:
            case LONGLITERAL:
            case LPAREN:
            case NEW:
            case NULL:
            case PLUS:
            case PLUSPLUS:
            case RETURN:
            case SEMI:
            case STRINGLITERAL:
            case SUB:
            case SUBSUB:
            case SUPER:
            case SWITCH:
            case THIS:
            case THROW:
            case TILDE:
            case TRUE:
            case TRY:
            case VOID:
            case WHILE:
                {
                alt90=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;

            }

            switch (alt90) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:858:9: localVariableDeclarationStatement
                    {
                    pushFollow(FOLLOW_localVariableDeclarationStatement_in_blockStatement4162);
                    localVariableDeclarationStatement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:859:9: classOrInterfaceDeclaration
                    {
                    pushFollow(FOLLOW_classOrInterfaceDeclaration_in_blockStatement4172);
                    classOrInterfaceDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:860:9: statement
                    {
                    pushFollow(FOLLOW_statement_in_blockStatement4182);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 55, blockStatement_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "blockStatement"



    // $ANTLR start "localVariableDeclarationStatement"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:864:1: localVariableDeclarationStatement : localVariableDeclaration ';' ;
    public final void localVariableDeclarationStatement() throws RecognitionException {
        int localVariableDeclarationStatement_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:865:5: ( localVariableDeclaration ';' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:865:9: localVariableDeclaration ';'
            {
            pushFollow(FOLLOW_localVariableDeclaration_in_localVariableDeclarationStatement4203);
            localVariableDeclaration();

            state._fsp--;
            if (state.failed) return ;

            match(input,SEMI,FOLLOW_SEMI_in_localVariableDeclarationStatement4213); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 56, localVariableDeclarationStatement_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "localVariableDeclarationStatement"



    // $ANTLR start "localVariableDeclaration"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:869:1: localVariableDeclaration : variableModifiers type variableDeclarator ( ',' variableDeclarator )* ;
    public final void localVariableDeclaration() throws RecognitionException {
        int localVariableDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:870:5: ( variableModifiers type variableDeclarator ( ',' variableDeclarator )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:870:9: variableModifiers type variableDeclarator ( ',' variableDeclarator )*
            {
            pushFollow(FOLLOW_variableModifiers_in_localVariableDeclaration4233);
            variableModifiers();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_type_in_localVariableDeclaration4235);
            type();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_variableDeclarator_in_localVariableDeclaration4245);
            variableDeclarator();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:872:9: ( ',' variableDeclarator )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==COMMA) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:872:10: ',' variableDeclarator
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_localVariableDeclaration4256); if (state.failed) return ;

            	    pushFollow(FOLLOW_variableDeclarator_in_localVariableDeclaration4258);
            	    variableDeclarator();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop91;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 57, localVariableDeclaration_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "localVariableDeclaration"



    // $ANTLR start "statement"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:876:1: statement : ( block | ( 'assert' ) expression ( ':' expression )? ';' | 'assert' expression ( ':' expression )? ';' | 'if' parExpression statement ( 'else' statement )? | forstatement | 'while' parExpression statement | 'do' statement 'while' parExpression ';' | trystatement | 'switch' parExpression '{' switchBlockStatementGroups '}' | 'synchronized' parExpression block | 'return' ( expression )? ';' | 'throw' expression ';' | 'break' ( IDENTIFIER )? ';' | 'continue' ( IDENTIFIER )? ';' | expression ';' | IDENTIFIER ':' statement | ';' );
    public final void statement() throws RecognitionException {
        int statement_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:877:5: ( block | ( 'assert' ) expression ( ':' expression )? ';' | 'assert' expression ( ':' expression )? ';' | 'if' parExpression statement ( 'else' statement )? | forstatement | 'while' parExpression statement | 'do' statement 'while' parExpression ';' | trystatement | 'switch' parExpression '{' switchBlockStatementGroups '}' | 'synchronized' parExpression block | 'return' ( expression )? ';' | 'throw' expression ';' | 'break' ( IDENTIFIER )? ';' | 'continue' ( IDENTIFIER )? ';' | expression ';' | IDENTIFIER ':' statement | ';' )
            int alt98=17;
            switch ( input.LA(1) ) {
            case LBRACE:
                {
                alt98=1;
                }
                break;
            case ASSERT:
                {
                int LA98_2 = input.LA(2);

                if ( (synpred130_NoDynamicLoadingANTLR()) ) {
                    alt98=2;
                }
                else if ( (synpred132_NoDynamicLoadingANTLR()) ) {
                    alt98=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 98, 2, input);

                    throw nvae;

                }
                }
                break;
            case IF:
                {
                alt98=4;
                }
                break;
            case FOR:
                {
                alt98=5;
                }
                break;
            case WHILE:
                {
                alt98=6;
                }
                break;
            case DO:
                {
                alt98=7;
                }
                break;
            case TRY:
                {
                alt98=8;
                }
                break;
            case SWITCH:
                {
                alt98=9;
                }
                break;
            case SYNCHRONIZED:
                {
                alt98=10;
                }
                break;
            case RETURN:
                {
                alt98=11;
                }
                break;
            case THROW:
                {
                alt98=12;
                }
                break;
            case BREAK:
                {
                alt98=13;
                }
                break;
            case CONTINUE:
                {
                alt98=14;
                }
                break;
            case BANG:
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case CHARLITERAL:
            case DOUBLE:
            case DOUBLELITERAL:
            case FALSE:
            case FLOAT:
            case FLOATLITERAL:
            case INT:
            case INTLITERAL:
            case LONG:
            case LONGLITERAL:
            case LPAREN:
            case NEW:
            case NULL:
            case PLUS:
            case PLUSPLUS:
            case SHORT:
            case STRINGLITERAL:
            case SUB:
            case SUBSUB:
            case SUPER:
            case THIS:
            case TILDE:
            case TRUE:
            case VOID:
                {
                alt98=15;
                }
                break;
            case IDENTIFIER:
                {
                int LA98_22 = input.LA(2);

                if ( (synpred148_NoDynamicLoadingANTLR()) ) {
                    alt98=15;
                }
                else if ( (synpred149_NoDynamicLoadingANTLR()) ) {
                    alt98=16;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 98, 22, input);

                    throw nvae;

                }
                }
                break;
            case SEMI:
                {
                alt98=17;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 98, 0, input);

                throw nvae;

            }

            switch (alt98) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:877:9: block
                    {
                    pushFollow(FOLLOW_block_in_statement4289);
                    block();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:879:9: ( 'assert' ) expression ( ':' expression )? ';'
                    {
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:879:9: ( 'assert' )
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:879:10: 'assert'
                    {
                    match(input,ASSERT,FOLLOW_ASSERT_in_statement4313); if (state.failed) return ;

                    }


                    pushFollow(FOLLOW_expression_in_statement4333);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:881:20: ( ':' expression )?
                    int alt92=2;
                    int LA92_0 = input.LA(1);

                    if ( (LA92_0==COLON) ) {
                        alt92=1;
                    }
                    switch (alt92) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:881:21: ':' expression
                            {
                            match(input,COLON,FOLLOW_COLON_in_statement4336); if (state.failed) return ;

                            pushFollow(FOLLOW_expression_in_statement4338);
                            expression();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,SEMI,FOLLOW_SEMI_in_statement4342); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:882:9: 'assert' expression ( ':' expression )? ';'
                    {
                    match(input,ASSERT,FOLLOW_ASSERT_in_statement4352); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_statement4355);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:882:30: ( ':' expression )?
                    int alt93=2;
                    int LA93_0 = input.LA(1);

                    if ( (LA93_0==COLON) ) {
                        alt93=1;
                    }
                    switch (alt93) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:882:31: ':' expression
                            {
                            match(input,COLON,FOLLOW_COLON_in_statement4358); if (state.failed) return ;

                            pushFollow(FOLLOW_expression_in_statement4360);
                            expression();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,SEMI,FOLLOW_SEMI_in_statement4364); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:883:9: 'if' parExpression statement ( 'else' statement )?
                    {
                    match(input,IF,FOLLOW_IF_in_statement4386); if (state.failed) return ;

                    pushFollow(FOLLOW_parExpression_in_statement4388);
                    parExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    pushFollow(FOLLOW_statement_in_statement4390);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:883:38: ( 'else' statement )?
                    int alt94=2;
                    int LA94_0 = input.LA(1);

                    if ( (LA94_0==ELSE) ) {
                        int LA94_1 = input.LA(2);

                        if ( (synpred133_NoDynamicLoadingANTLR()) ) {
                            alt94=1;
                        }
                    }
                    switch (alt94) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:883:39: 'else' statement
                            {
                            match(input,ELSE,FOLLOW_ELSE_in_statement4393); if (state.failed) return ;

                            pushFollow(FOLLOW_statement_in_statement4395);
                            statement();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 5 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:884:9: forstatement
                    {
                    pushFollow(FOLLOW_forstatement_in_statement4417);
                    forstatement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:885:9: 'while' parExpression statement
                    {
                    match(input,WHILE,FOLLOW_WHILE_in_statement4427); if (state.failed) return ;

                    pushFollow(FOLLOW_parExpression_in_statement4429);
                    parExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    pushFollow(FOLLOW_statement_in_statement4431);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:886:9: 'do' statement 'while' parExpression ';'
                    {
                    match(input,DO,FOLLOW_DO_in_statement4441); if (state.failed) return ;

                    pushFollow(FOLLOW_statement_in_statement4443);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,WHILE,FOLLOW_WHILE_in_statement4445); if (state.failed) return ;

                    pushFollow(FOLLOW_parExpression_in_statement4447);
                    parExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,SEMI,FOLLOW_SEMI_in_statement4449); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:887:9: trystatement
                    {
                    pushFollow(FOLLOW_trystatement_in_statement4459);
                    trystatement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 9 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:888:9: 'switch' parExpression '{' switchBlockStatementGroups '}'
                    {
                    match(input,SWITCH,FOLLOW_SWITCH_in_statement4469); if (state.failed) return ;

                    pushFollow(FOLLOW_parExpression_in_statement4471);
                    parExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,LBRACE,FOLLOW_LBRACE_in_statement4473); if (state.failed) return ;

                    pushFollow(FOLLOW_switchBlockStatementGroups_in_statement4475);
                    switchBlockStatementGroups();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,RBRACE,FOLLOW_RBRACE_in_statement4477); if (state.failed) return ;

                    }
                    break;
                case 10 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:889:9: 'synchronized' parExpression block
                    {
                    match(input,SYNCHRONIZED,FOLLOW_SYNCHRONIZED_in_statement4487); if (state.failed) return ;

                    pushFollow(FOLLOW_parExpression_in_statement4489);
                    parExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    pushFollow(FOLLOW_block_in_statement4491);
                    block();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 11 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:890:9: 'return' ( expression )? ';'
                    {
                    match(input,RETURN,FOLLOW_RETURN_in_statement4501); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:890:18: ( expression )?
                    int alt95=2;
                    int LA95_0 = input.LA(1);

                    if ( (LA95_0==BANG||LA95_0==BOOLEAN||LA95_0==BYTE||(LA95_0 >= CHAR && LA95_0 <= CHARLITERAL)||(LA95_0 >= DOUBLE && LA95_0 <= DOUBLELITERAL)||LA95_0==FALSE||(LA95_0 >= FLOAT && LA95_0 <= FLOATLITERAL)||LA95_0==IDENTIFIER||LA95_0==INT||LA95_0==INTLITERAL||(LA95_0 >= LONG && LA95_0 <= LPAREN)||(LA95_0 >= NEW && LA95_0 <= NULL)||LA95_0==PLUS||LA95_0==PLUSPLUS||LA95_0==SHORT||(LA95_0 >= STRINGLITERAL && LA95_0 <= SUB)||(LA95_0 >= SUBSUB && LA95_0 <= SUPER)||LA95_0==THIS||LA95_0==TILDE||LA95_0==TRUE||LA95_0==VOID) ) {
                        alt95=1;
                    }
                    switch (alt95) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:890:19: expression
                            {
                            pushFollow(FOLLOW_expression_in_statement4504);
                            expression();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,SEMI,FOLLOW_SEMI_in_statement4509); if (state.failed) return ;

                    }
                    break;
                case 12 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:891:9: 'throw' expression ';'
                    {
                    match(input,THROW,FOLLOW_THROW_in_statement4519); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_statement4521);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,SEMI,FOLLOW_SEMI_in_statement4523); if (state.failed) return ;

                    }
                    break;
                case 13 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:892:9: 'break' ( IDENTIFIER )? ';'
                    {
                    match(input,BREAK,FOLLOW_BREAK_in_statement4533); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:893:13: ( IDENTIFIER )?
                    int alt96=2;
                    int LA96_0 = input.LA(1);

                    if ( (LA96_0==IDENTIFIER) ) {
                        alt96=1;
                    }
                    switch (alt96) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:893:14: IDENTIFIER
                            {
                            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_statement4548); if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,SEMI,FOLLOW_SEMI_in_statement4565); if (state.failed) return ;

                    }
                    break;
                case 14 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:895:9: 'continue' ( IDENTIFIER )? ';'
                    {
                    match(input,CONTINUE,FOLLOW_CONTINUE_in_statement4575); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:896:13: ( IDENTIFIER )?
                    int alt97=2;
                    int LA97_0 = input.LA(1);

                    if ( (LA97_0==IDENTIFIER) ) {
                        alt97=1;
                    }
                    switch (alt97) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:896:14: IDENTIFIER
                            {
                            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_statement4590); if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,SEMI,FOLLOW_SEMI_in_statement4607); if (state.failed) return ;

                    }
                    break;
                case 15 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:898:9: expression ';'
                    {
                    pushFollow(FOLLOW_expression_in_statement4617);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,SEMI,FOLLOW_SEMI_in_statement4620); if (state.failed) return ;

                    }
                    break;
                case 16 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:899:9: IDENTIFIER ':' statement
                    {
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_statement4635); if (state.failed) return ;

                    match(input,COLON,FOLLOW_COLON_in_statement4637); if (state.failed) return ;

                    pushFollow(FOLLOW_statement_in_statement4639);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 17 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:900:9: ';'
                    {
                    match(input,SEMI,FOLLOW_SEMI_in_statement4649); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 58, statement_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "statement"



    // $ANTLR start "switchBlockStatementGroups"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:904:1: switchBlockStatementGroups : ( switchBlockStatementGroup )* ;
    public final void switchBlockStatementGroups() throws RecognitionException {
        int switchBlockStatementGroups_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:905:5: ( ( switchBlockStatementGroup )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:905:9: ( switchBlockStatementGroup )*
            {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:905:9: ( switchBlockStatementGroup )*
            loop99:
            do {
                int alt99=2;
                int LA99_0 = input.LA(1);

                if ( (LA99_0==CASE||LA99_0==DEFAULT) ) {
                    alt99=1;
                }


                switch (alt99) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:905:10: switchBlockStatementGroup
            	    {
            	    pushFollow(FOLLOW_switchBlockStatementGroup_in_switchBlockStatementGroups4671);
            	    switchBlockStatementGroup();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop99;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 59, switchBlockStatementGroups_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "switchBlockStatementGroups"



    // $ANTLR start "switchBlockStatementGroup"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:908:1: switchBlockStatementGroup : switchLabel ( blockStatement )* ;
    public final void switchBlockStatementGroup() throws RecognitionException {
        int switchBlockStatementGroup_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:909:5: ( switchLabel ( blockStatement )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:910:9: switchLabel ( blockStatement )*
            {
            pushFollow(FOLLOW_switchLabel_in_switchBlockStatementGroup4700);
            switchLabel();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:911:9: ( blockStatement )*
            loop100:
            do {
                int alt100=2;
                int LA100_0 = input.LA(1);

                if ( (LA100_0==ABSTRACT||(LA100_0 >= ASSERT && LA100_0 <= BANG)||(LA100_0 >= BOOLEAN && LA100_0 <= BYTE)||(LA100_0 >= CHAR && LA100_0 <= CLASS)||LA100_0==CONTINUE||LA100_0==DO||(LA100_0 >= DOUBLE && LA100_0 <= DOUBLELITERAL)||LA100_0==ENUM||(LA100_0 >= FALSE && LA100_0 <= FINAL)||(LA100_0 >= FLOAT && LA100_0 <= FOR)||(LA100_0 >= IDENTIFIER && LA100_0 <= IF)||(LA100_0 >= INT && LA100_0 <= INTLITERAL)||LA100_0==LBRACE||(LA100_0 >= LONG && LA100_0 <= LT)||(LA100_0 >= MONKEYS_AT && LA100_0 <= NULL)||LA100_0==PLUS||(LA100_0 >= PLUSPLUS && LA100_0 <= PUBLIC)||LA100_0==RETURN||(LA100_0 >= SEMI && LA100_0 <= SHORT)||(LA100_0 >= STATIC && LA100_0 <= SUB)||(LA100_0 >= SUBSUB && LA100_0 <= SYNCHRONIZED)||(LA100_0 >= THIS && LA100_0 <= THROW)||(LA100_0 >= TILDE && LA100_0 <= WHILE)) ) {
                    alt100=1;
                }


                switch (alt100) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:911:10: blockStatement
            	    {
            	    pushFollow(FOLLOW_blockStatement_in_switchBlockStatementGroup4711);
            	    blockStatement();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop100;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 60, switchBlockStatementGroup_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "switchBlockStatementGroup"



    // $ANTLR start "switchLabel"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:915:1: switchLabel : ( 'case' expression ':' | 'default' ':' );
    public final void switchLabel() throws RecognitionException {
        int switchLabel_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:916:5: ( 'case' expression ':' | 'default' ':' )
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==CASE) ) {
                alt101=1;
            }
            else if ( (LA101_0==DEFAULT) ) {
                alt101=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;

            }
            switch (alt101) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:916:9: 'case' expression ':'
                    {
                    match(input,CASE,FOLLOW_CASE_in_switchLabel4742); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_switchLabel4744);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,COLON,FOLLOW_COLON_in_switchLabel4746); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:917:9: 'default' ':'
                    {
                    match(input,DEFAULT,FOLLOW_DEFAULT_in_switchLabel4756); if (state.failed) return ;

                    match(input,COLON,FOLLOW_COLON_in_switchLabel4758); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 61, switchLabel_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "switchLabel"



    // $ANTLR start "trystatement"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:921:1: trystatement : 'try' block ( catches 'finally' block | catches | 'finally' block ) ;
    public final void trystatement() throws RecognitionException {
        int trystatement_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:922:5: ( 'try' block ( catches 'finally' block | catches | 'finally' block ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:922:9: 'try' block ( catches 'finally' block | catches | 'finally' block )
            {
            match(input,TRY,FOLLOW_TRY_in_trystatement4779); if (state.failed) return ;

            pushFollow(FOLLOW_block_in_trystatement4781);
            block();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:923:9: ( catches 'finally' block | catches | 'finally' block )
            int alt102=3;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==CATCH) ) {
                int LA102_1 = input.LA(2);

                if ( (synpred153_NoDynamicLoadingANTLR()) ) {
                    alt102=1;
                }
                else if ( (synpred154_NoDynamicLoadingANTLR()) ) {
                    alt102=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 102, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA102_0==FINALLY) ) {
                alt102=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;

            }
            switch (alt102) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:923:13: catches 'finally' block
                    {
                    pushFollow(FOLLOW_catches_in_trystatement4795);
                    catches();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,FINALLY,FOLLOW_FINALLY_in_trystatement4797); if (state.failed) return ;

                    pushFollow(FOLLOW_block_in_trystatement4799);
                    block();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:924:13: catches
                    {
                    pushFollow(FOLLOW_catches_in_trystatement4813);
                    catches();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:925:13: 'finally' block
                    {
                    match(input,FINALLY,FOLLOW_FINALLY_in_trystatement4827); if (state.failed) return ;

                    pushFollow(FOLLOW_block_in_trystatement4829);
                    block();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 62, trystatement_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "trystatement"



    // $ANTLR start "catches"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:929:1: catches : catchClause ( catchClause )* ;
    public final void catches() throws RecognitionException {
        int catches_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:930:5: ( catchClause ( catchClause )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:930:9: catchClause ( catchClause )*
            {
            pushFollow(FOLLOW_catchClause_in_catches4860);
            catchClause();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:931:9: ( catchClause )*
            loop103:
            do {
                int alt103=2;
                int LA103_0 = input.LA(1);

                if ( (LA103_0==CATCH) ) {
                    alt103=1;
                }


                switch (alt103) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:931:10: catchClause
            	    {
            	    pushFollow(FOLLOW_catchClause_in_catches4871);
            	    catchClause();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop103;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 63, catches_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "catches"



    // $ANTLR start "catchClause"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:935:1: catchClause : 'catch' '(' formalParameter ')' block ;
    public final void catchClause() throws RecognitionException {
        int catchClause_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:936:5: ( 'catch' '(' formalParameter ')' block )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:936:9: 'catch' '(' formalParameter ')' block
            {
            match(input,CATCH,FOLLOW_CATCH_in_catchClause4902); if (state.failed) return ;

            match(input,LPAREN,FOLLOW_LPAREN_in_catchClause4904); if (state.failed) return ;

            pushFollow(FOLLOW_formalParameter_in_catchClause4906);
            formalParameter();

            state._fsp--;
            if (state.failed) return ;

            match(input,RPAREN,FOLLOW_RPAREN_in_catchClause4916); if (state.failed) return ;

            pushFollow(FOLLOW_block_in_catchClause4918);
            block();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 64, catchClause_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "catchClause"



    // $ANTLR start "formalParameter"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:940:1: formalParameter : variableModifiers type IDENTIFIER ( '[' ']' )* ;
    public final void formalParameter() throws RecognitionException {
        int formalParameter_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:941:5: ( variableModifiers type IDENTIFIER ( '[' ']' )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:941:9: variableModifiers type IDENTIFIER ( '[' ']' )*
            {
            pushFollow(FOLLOW_variableModifiers_in_formalParameter4939);
            variableModifiers();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_type_in_formalParameter4941);
            type();

            state._fsp--;
            if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_formalParameter4943); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:942:9: ( '[' ']' )*
            loop104:
            do {
                int alt104=2;
                int LA104_0 = input.LA(1);

                if ( (LA104_0==LBRACKET) ) {
                    alt104=1;
                }


                switch (alt104) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:942:10: '[' ']'
            	    {
            	    match(input,LBRACKET,FOLLOW_LBRACKET_in_formalParameter4954); if (state.failed) return ;

            	    match(input,RBRACKET,FOLLOW_RBRACKET_in_formalParameter4956); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop104;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 65, formalParameter_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "formalParameter"



    // $ANTLR start "forstatement"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:946:1: forstatement : ( 'for' '(' variableModifiers type IDENTIFIER ':' expression ')' statement | 'for' '(' ( forInit )? ';' ( expression )? ';' ( expressionList )? ')' statement );
    public final void forstatement() throws RecognitionException {
        int forstatement_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:947:5: ( 'for' '(' variableModifiers type IDENTIFIER ':' expression ')' statement | 'for' '(' ( forInit )? ';' ( expression )? ';' ( expressionList )? ')' statement )
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==FOR) ) {
                int LA108_1 = input.LA(2);

                if ( (synpred157_NoDynamicLoadingANTLR()) ) {
                    alt108=1;
                }
                else if ( (true) ) {
                    alt108=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 108, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 108, 0, input);

                throw nvae;

            }
            switch (alt108) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:949:9: 'for' '(' variableModifiers type IDENTIFIER ':' expression ')' statement
                    {
                    match(input,FOR,FOLLOW_FOR_in_forstatement5005); if (state.failed) return ;

                    match(input,LPAREN,FOLLOW_LPAREN_in_forstatement5007); if (state.failed) return ;

                    pushFollow(FOLLOW_variableModifiers_in_forstatement5009);
                    variableModifiers();

                    state._fsp--;
                    if (state.failed) return ;

                    pushFollow(FOLLOW_type_in_forstatement5011);
                    type();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_forstatement5013); if (state.failed) return ;

                    match(input,COLON,FOLLOW_COLON_in_forstatement5015); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_forstatement5026);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,RPAREN,FOLLOW_RPAREN_in_forstatement5028); if (state.failed) return ;

                    pushFollow(FOLLOW_statement_in_forstatement5030);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:953:9: 'for' '(' ( forInit )? ';' ( expression )? ';' ( expressionList )? ')' statement
                    {
                    match(input,FOR,FOLLOW_FOR_in_forstatement5062); if (state.failed) return ;

                    match(input,LPAREN,FOLLOW_LPAREN_in_forstatement5064); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:954:17: ( forInit )?
                    int alt105=2;
                    int LA105_0 = input.LA(1);

                    if ( (LA105_0==BANG||LA105_0==BOOLEAN||LA105_0==BYTE||(LA105_0 >= CHAR && LA105_0 <= CHARLITERAL)||(LA105_0 >= DOUBLE && LA105_0 <= DOUBLELITERAL)||(LA105_0 >= FALSE && LA105_0 <= FINAL)||(LA105_0 >= FLOAT && LA105_0 <= FLOATLITERAL)||LA105_0==IDENTIFIER||LA105_0==INT||LA105_0==INTLITERAL||(LA105_0 >= LONG && LA105_0 <= LPAREN)||LA105_0==MONKEYS_AT||(LA105_0 >= NEW && LA105_0 <= NULL)||LA105_0==PLUS||LA105_0==PLUSPLUS||LA105_0==SHORT||(LA105_0 >= STRINGLITERAL && LA105_0 <= SUB)||(LA105_0 >= SUBSUB && LA105_0 <= SUPER)||LA105_0==THIS||LA105_0==TILDE||LA105_0==TRUE||LA105_0==VOID) ) {
                        alt105=1;
                    }
                    switch (alt105) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:954:18: forInit
                            {
                            pushFollow(FOLLOW_forInit_in_forstatement5084);
                            forInit();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,SEMI,FOLLOW_SEMI_in_forstatement5105); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:956:17: ( expression )?
                    int alt106=2;
                    int LA106_0 = input.LA(1);

                    if ( (LA106_0==BANG||LA106_0==BOOLEAN||LA106_0==BYTE||(LA106_0 >= CHAR && LA106_0 <= CHARLITERAL)||(LA106_0 >= DOUBLE && LA106_0 <= DOUBLELITERAL)||LA106_0==FALSE||(LA106_0 >= FLOAT && LA106_0 <= FLOATLITERAL)||LA106_0==IDENTIFIER||LA106_0==INT||LA106_0==INTLITERAL||(LA106_0 >= LONG && LA106_0 <= LPAREN)||(LA106_0 >= NEW && LA106_0 <= NULL)||LA106_0==PLUS||LA106_0==PLUSPLUS||LA106_0==SHORT||(LA106_0 >= STRINGLITERAL && LA106_0 <= SUB)||(LA106_0 >= SUBSUB && LA106_0 <= SUPER)||LA106_0==THIS||LA106_0==TILDE||LA106_0==TRUE||LA106_0==VOID) ) {
                        alt106=1;
                    }
                    switch (alt106) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:956:18: expression
                            {
                            pushFollow(FOLLOW_expression_in_forstatement5125);
                            expression();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,SEMI,FOLLOW_SEMI_in_forstatement5146); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:958:17: ( expressionList )?
                    int alt107=2;
                    int LA107_0 = input.LA(1);

                    if ( (LA107_0==BANG||LA107_0==BOOLEAN||LA107_0==BYTE||(LA107_0 >= CHAR && LA107_0 <= CHARLITERAL)||(LA107_0 >= DOUBLE && LA107_0 <= DOUBLELITERAL)||LA107_0==FALSE||(LA107_0 >= FLOAT && LA107_0 <= FLOATLITERAL)||LA107_0==IDENTIFIER||LA107_0==INT||LA107_0==INTLITERAL||(LA107_0 >= LONG && LA107_0 <= LPAREN)||(LA107_0 >= NEW && LA107_0 <= NULL)||LA107_0==PLUS||LA107_0==PLUSPLUS||LA107_0==SHORT||(LA107_0 >= STRINGLITERAL && LA107_0 <= SUB)||(LA107_0 >= SUBSUB && LA107_0 <= SUPER)||LA107_0==THIS||LA107_0==TILDE||LA107_0==TRUE||LA107_0==VOID) ) {
                        alt107=1;
                    }
                    switch (alt107) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:958:18: expressionList
                            {
                            pushFollow(FOLLOW_expressionList_in_forstatement5166);
                            expressionList();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,RPAREN,FOLLOW_RPAREN_in_forstatement5187); if (state.failed) return ;

                    pushFollow(FOLLOW_statement_in_forstatement5189);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 66, forstatement_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "forstatement"



    // $ANTLR start "forInit"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:962:1: forInit : ( localVariableDeclaration | expressionList );
    public final void forInit() throws RecognitionException {
        int forInit_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:963:5: ( localVariableDeclaration | expressionList )
            int alt109=2;
            switch ( input.LA(1) ) {
            case FINAL:
            case MONKEYS_AT:
                {
                alt109=1;
                }
                break;
            case IDENTIFIER:
                {
                int LA109_3 = input.LA(2);

                if ( (synpred161_NoDynamicLoadingANTLR()) ) {
                    alt109=1;
                }
                else if ( (true) ) {
                    alt109=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 109, 3, input);

                    throw nvae;

                }
                }
                break;
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case DOUBLE:
            case FLOAT:
            case INT:
            case LONG:
            case SHORT:
                {
                int LA109_4 = input.LA(2);

                if ( (synpred161_NoDynamicLoadingANTLR()) ) {
                    alt109=1;
                }
                else if ( (true) ) {
                    alt109=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 109, 4, input);

                    throw nvae;

                }
                }
                break;
            case BANG:
            case CHARLITERAL:
            case DOUBLELITERAL:
            case FALSE:
            case FLOATLITERAL:
            case INTLITERAL:
            case LONGLITERAL:
            case LPAREN:
            case NEW:
            case NULL:
            case PLUS:
            case PLUSPLUS:
            case STRINGLITERAL:
            case SUB:
            case SUBSUB:
            case SUPER:
            case THIS:
            case TILDE:
            case TRUE:
            case VOID:
                {
                alt109=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 109, 0, input);

                throw nvae;

            }

            switch (alt109) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:963:9: localVariableDeclaration
                    {
                    pushFollow(FOLLOW_localVariableDeclaration_in_forInit5209);
                    localVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:964:9: expressionList
                    {
                    pushFollow(FOLLOW_expressionList_in_forInit5219);
                    expressionList();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 67, forInit_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "forInit"



    // $ANTLR start "parExpression"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:967:1: parExpression : '(' expression ')' ;
    public final void parExpression() throws RecognitionException {
        int parExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:968:5: ( '(' expression ')' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:968:9: '(' expression ')'
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_parExpression5239); if (state.failed) return ;

            pushFollow(FOLLOW_expression_in_parExpression5241);
            expression();

            state._fsp--;
            if (state.failed) return ;

            match(input,RPAREN,FOLLOW_RPAREN_in_parExpression5243); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 68, parExpression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "parExpression"



    // $ANTLR start "expressionList"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:971:1: expressionList : expression ( ',' expression )* ;
    public final void expressionList() throws RecognitionException {
        int expressionList_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:972:5: ( expression ( ',' expression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:972:9: expression ( ',' expression )*
            {
            pushFollow(FOLLOW_expression_in_expressionList5263);
            expression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:973:9: ( ',' expression )*
            loop110:
            do {
                int alt110=2;
                int LA110_0 = input.LA(1);

                if ( (LA110_0==COMMA) ) {
                    alt110=1;
                }


                switch (alt110) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:973:10: ',' expression
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_expressionList5274); if (state.failed) return ;

            	    pushFollow(FOLLOW_expression_in_expressionList5276);
            	    expression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop110;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 69, expressionList_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "expressionList"



    // $ANTLR start "expression"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:978:1: expression : conditionalExpression ( assignmentOperator expression )? ;
    public final void expression() throws RecognitionException {
        int expression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:979:5: ( conditionalExpression ( assignmentOperator expression )? )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:979:9: conditionalExpression ( assignmentOperator expression )?
            {
            pushFollow(FOLLOW_conditionalExpression_in_expression5308);
            conditionalExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:980:9: ( assignmentOperator expression )?
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==AMPEQ||LA111_0==BAREQ||LA111_0==CARETEQ||LA111_0==EQ||LA111_0==GT||LA111_0==LT||LA111_0==PERCENTEQ||LA111_0==PLUSEQ||LA111_0==SLASHEQ||LA111_0==STAREQ||LA111_0==SUBEQ) ) {
                alt111=1;
            }
            switch (alt111) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:980:10: assignmentOperator expression
                    {
                    pushFollow(FOLLOW_assignmentOperator_in_expression5319);
                    assignmentOperator();

                    state._fsp--;
                    if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_expression5321);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 70, expression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "expression"



    // $ANTLR start "assignmentOperator"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:985:1: assignmentOperator : ( '=' | '+=' | '-=' | '*=' | '/=' | '&=' | '|=' | '^=' | '%=' | '<' '<' '=' | '>' '>' '>' '=' | '>' '>' '=' );
    public final void assignmentOperator() throws RecognitionException {
        int assignmentOperator_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:986:5: ( '=' | '+=' | '-=' | '*=' | '/=' | '&=' | '|=' | '^=' | '%=' | '<' '<' '=' | '>' '>' '>' '=' | '>' '>' '=' )
            int alt112=12;
            switch ( input.LA(1) ) {
            case EQ:
                {
                alt112=1;
                }
                break;
            case PLUSEQ:
                {
                alt112=2;
                }
                break;
            case SUBEQ:
                {
                alt112=3;
                }
                break;
            case STAREQ:
                {
                alt112=4;
                }
                break;
            case SLASHEQ:
                {
                alt112=5;
                }
                break;
            case AMPEQ:
                {
                alt112=6;
                }
                break;
            case BAREQ:
                {
                alt112=7;
                }
                break;
            case CARETEQ:
                {
                alt112=8;
                }
                break;
            case PERCENTEQ:
                {
                alt112=9;
                }
                break;
            case LT:
                {
                alt112=10;
                }
                break;
            case GT:
                {
                int LA112_11 = input.LA(2);

                if ( (LA112_11==GT) ) {
                    int LA112_12 = input.LA(3);

                    if ( (LA112_12==GT) ) {
                        alt112=11;
                    }
                    else if ( (LA112_12==EQ) ) {
                        alt112=12;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 112, 12, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 112, 11, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 112, 0, input);

                throw nvae;

            }

            switch (alt112) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:986:9: '='
                    {
                    match(input,EQ,FOLLOW_EQ_in_assignmentOperator5353); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:987:9: '+='
                    {
                    match(input,PLUSEQ,FOLLOW_PLUSEQ_in_assignmentOperator5363); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:988:9: '-='
                    {
                    match(input,SUBEQ,FOLLOW_SUBEQ_in_assignmentOperator5373); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:989:9: '*='
                    {
                    match(input,STAREQ,FOLLOW_STAREQ_in_assignmentOperator5383); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:990:9: '/='
                    {
                    match(input,SLASHEQ,FOLLOW_SLASHEQ_in_assignmentOperator5393); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:991:9: '&='
                    {
                    match(input,AMPEQ,FOLLOW_AMPEQ_in_assignmentOperator5403); if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:992:9: '|='
                    {
                    match(input,BAREQ,FOLLOW_BAREQ_in_assignmentOperator5413); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:993:9: '^='
                    {
                    match(input,CARETEQ,FOLLOW_CARETEQ_in_assignmentOperator5423); if (state.failed) return ;

                    }
                    break;
                case 9 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:994:9: '%='
                    {
                    match(input,PERCENTEQ,FOLLOW_PERCENTEQ_in_assignmentOperator5433); if (state.failed) return ;

                    }
                    break;
                case 10 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:995:10: '<' '<' '='
                    {
                    match(input,LT,FOLLOW_LT_in_assignmentOperator5444); if (state.failed) return ;

                    match(input,LT,FOLLOW_LT_in_assignmentOperator5446); if (state.failed) return ;

                    match(input,EQ,FOLLOW_EQ_in_assignmentOperator5448); if (state.failed) return ;

                    }
                    break;
                case 11 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:996:10: '>' '>' '>' '='
                    {
                    match(input,GT,FOLLOW_GT_in_assignmentOperator5459); if (state.failed) return ;

                    match(input,GT,FOLLOW_GT_in_assignmentOperator5461); if (state.failed) return ;

                    match(input,GT,FOLLOW_GT_in_assignmentOperator5463); if (state.failed) return ;

                    match(input,EQ,FOLLOW_EQ_in_assignmentOperator5465); if (state.failed) return ;

                    }
                    break;
                case 12 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:997:10: '>' '>' '='
                    {
                    match(input,GT,FOLLOW_GT_in_assignmentOperator5476); if (state.failed) return ;

                    match(input,GT,FOLLOW_GT_in_assignmentOperator5478); if (state.failed) return ;

                    match(input,EQ,FOLLOW_EQ_in_assignmentOperator5480); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 71, assignmentOperator_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "assignmentOperator"



    // $ANTLR start "conditionalExpression"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1001:1: conditionalExpression : conditionalOrExpression ( '?' expression ':' conditionalExpression )? ;
    public final void conditionalExpression() throws RecognitionException {
        int conditionalExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1002:5: ( conditionalOrExpression ( '?' expression ':' conditionalExpression )? )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1002:9: conditionalOrExpression ( '?' expression ':' conditionalExpression )?
            {
            pushFollow(FOLLOW_conditionalOrExpression_in_conditionalExpression5501);
            conditionalOrExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1003:9: ( '?' expression ':' conditionalExpression )?
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==QUES) ) {
                alt113=1;
            }
            switch (alt113) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1003:10: '?' expression ':' conditionalExpression
                    {
                    match(input,QUES,FOLLOW_QUES_in_conditionalExpression5512); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_conditionalExpression5514);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,COLON,FOLLOW_COLON_in_conditionalExpression5516); if (state.failed) return ;

                    pushFollow(FOLLOW_conditionalExpression_in_conditionalExpression5518);
                    conditionalExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 72, conditionalExpression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "conditionalExpression"



    // $ANTLR start "conditionalOrExpression"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1007:1: conditionalOrExpression : conditionalAndExpression ( '||' conditionalAndExpression )* ;
    public final void conditionalOrExpression() throws RecognitionException {
        int conditionalOrExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1008:5: ( conditionalAndExpression ( '||' conditionalAndExpression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1008:9: conditionalAndExpression ( '||' conditionalAndExpression )*
            {
            pushFollow(FOLLOW_conditionalAndExpression_in_conditionalOrExpression5549);
            conditionalAndExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1009:9: ( '||' conditionalAndExpression )*
            loop114:
            do {
                int alt114=2;
                int LA114_0 = input.LA(1);

                if ( (LA114_0==BARBAR) ) {
                    alt114=1;
                }


                switch (alt114) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1009:10: '||' conditionalAndExpression
            	    {
            	    match(input,BARBAR,FOLLOW_BARBAR_in_conditionalOrExpression5560); if (state.failed) return ;

            	    pushFollow(FOLLOW_conditionalAndExpression_in_conditionalOrExpression5562);
            	    conditionalAndExpression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop114;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 73, conditionalOrExpression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "conditionalOrExpression"



    // $ANTLR start "conditionalAndExpression"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1013:1: conditionalAndExpression : inclusiveOrExpression ( '&&' inclusiveOrExpression )* ;
    public final void conditionalAndExpression() throws RecognitionException {
        int conditionalAndExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 74) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1014:5: ( inclusiveOrExpression ( '&&' inclusiveOrExpression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1014:9: inclusiveOrExpression ( '&&' inclusiveOrExpression )*
            {
            pushFollow(FOLLOW_inclusiveOrExpression_in_conditionalAndExpression5593);
            inclusiveOrExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1015:9: ( '&&' inclusiveOrExpression )*
            loop115:
            do {
                int alt115=2;
                int LA115_0 = input.LA(1);

                if ( (LA115_0==AMPAMP) ) {
                    alt115=1;
                }


                switch (alt115) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1015:10: '&&' inclusiveOrExpression
            	    {
            	    match(input,AMPAMP,FOLLOW_AMPAMP_in_conditionalAndExpression5604); if (state.failed) return ;

            	    pushFollow(FOLLOW_inclusiveOrExpression_in_conditionalAndExpression5606);
            	    inclusiveOrExpression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop115;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 74, conditionalAndExpression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "conditionalAndExpression"



    // $ANTLR start "inclusiveOrExpression"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1019:1: inclusiveOrExpression : exclusiveOrExpression ( '|' exclusiveOrExpression )* ;
    public final void inclusiveOrExpression() throws RecognitionException {
        int inclusiveOrExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 75) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1020:5: ( exclusiveOrExpression ( '|' exclusiveOrExpression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1020:9: exclusiveOrExpression ( '|' exclusiveOrExpression )*
            {
            pushFollow(FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression5637);
            exclusiveOrExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1021:9: ( '|' exclusiveOrExpression )*
            loop116:
            do {
                int alt116=2;
                int LA116_0 = input.LA(1);

                if ( (LA116_0==BAR) ) {
                    alt116=1;
                }


                switch (alt116) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1021:10: '|' exclusiveOrExpression
            	    {
            	    match(input,BAR,FOLLOW_BAR_in_inclusiveOrExpression5648); if (state.failed) return ;

            	    pushFollow(FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression5650);
            	    exclusiveOrExpression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop116;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 75, inclusiveOrExpression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "inclusiveOrExpression"



    // $ANTLR start "exclusiveOrExpression"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1025:1: exclusiveOrExpression : andExpression ( '^' andExpression )* ;
    public final void exclusiveOrExpression() throws RecognitionException {
        int exclusiveOrExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 76) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1026:5: ( andExpression ( '^' andExpression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1026:9: andExpression ( '^' andExpression )*
            {
            pushFollow(FOLLOW_andExpression_in_exclusiveOrExpression5681);
            andExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1027:9: ( '^' andExpression )*
            loop117:
            do {
                int alt117=2;
                int LA117_0 = input.LA(1);

                if ( (LA117_0==CARET) ) {
                    alt117=1;
                }


                switch (alt117) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1027:10: '^' andExpression
            	    {
            	    match(input,CARET,FOLLOW_CARET_in_exclusiveOrExpression5692); if (state.failed) return ;

            	    pushFollow(FOLLOW_andExpression_in_exclusiveOrExpression5694);
            	    andExpression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop117;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 76, exclusiveOrExpression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "exclusiveOrExpression"



    // $ANTLR start "andExpression"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1031:1: andExpression : equalityExpression ( '&' equalityExpression )* ;
    public final void andExpression() throws RecognitionException {
        int andExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 77) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1032:5: ( equalityExpression ( '&' equalityExpression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1032:9: equalityExpression ( '&' equalityExpression )*
            {
            pushFollow(FOLLOW_equalityExpression_in_andExpression5725);
            equalityExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1033:9: ( '&' equalityExpression )*
            loop118:
            do {
                int alt118=2;
                int LA118_0 = input.LA(1);

                if ( (LA118_0==AMP) ) {
                    alt118=1;
                }


                switch (alt118) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1033:10: '&' equalityExpression
            	    {
            	    match(input,AMP,FOLLOW_AMP_in_andExpression5736); if (state.failed) return ;

            	    pushFollow(FOLLOW_equalityExpression_in_andExpression5738);
            	    equalityExpression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop118;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 77, andExpression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "andExpression"



    // $ANTLR start "equalityExpression"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1037:1: equalityExpression : instanceOfExpression ( ( '==' | '!=' ) instanceOfExpression )* ;
    public final void equalityExpression() throws RecognitionException {
        int equalityExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 78) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1038:5: ( instanceOfExpression ( ( '==' | '!=' ) instanceOfExpression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1038:9: instanceOfExpression ( ( '==' | '!=' ) instanceOfExpression )*
            {
            pushFollow(FOLLOW_instanceOfExpression_in_equalityExpression5769);
            instanceOfExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1039:9: ( ( '==' | '!=' ) instanceOfExpression )*
            loop119:
            do {
                int alt119=2;
                int LA119_0 = input.LA(1);

                if ( (LA119_0==BANGEQ||LA119_0==EQEQ) ) {
                    alt119=1;
                }


                switch (alt119) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1040:13: ( '==' | '!=' ) instanceOfExpression
            	    {
            	    if ( input.LA(1)==BANGEQ||input.LA(1)==EQEQ ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_instanceOfExpression_in_equalityExpression5846);
            	    instanceOfExpression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop119;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 78, equalityExpression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "equalityExpression"



    // $ANTLR start "instanceOfExpression"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1047:1: instanceOfExpression : relationalExpression ( 'instanceof' type )? ;
    public final void instanceOfExpression() throws RecognitionException {
        int instanceOfExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 79) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1048:5: ( relationalExpression ( 'instanceof' type )? )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1048:9: relationalExpression ( 'instanceof' type )?
            {
            pushFollow(FOLLOW_relationalExpression_in_instanceOfExpression5877);
            relationalExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1049:9: ( 'instanceof' type )?
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==INSTANCEOF) ) {
                alt120=1;
            }
            switch (alt120) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1049:10: 'instanceof' type
                    {
                    match(input,INSTANCEOF,FOLLOW_INSTANCEOF_in_instanceOfExpression5888); if (state.failed) return ;

                    pushFollow(FOLLOW_type_in_instanceOfExpression5890);
                    type();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 79, instanceOfExpression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "instanceOfExpression"



    // $ANTLR start "relationalExpression"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1053:1: relationalExpression : shiftExpression ( relationalOp shiftExpression )* ;
    public final void relationalExpression() throws RecognitionException {
        int relationalExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 80) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1054:5: ( shiftExpression ( relationalOp shiftExpression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1054:9: shiftExpression ( relationalOp shiftExpression )*
            {
            pushFollow(FOLLOW_shiftExpression_in_relationalExpression5921);
            shiftExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1055:9: ( relationalOp shiftExpression )*
            loop121:
            do {
                int alt121=2;
                int LA121_0 = input.LA(1);

                if ( (LA121_0==LT) ) {
                    int LA121_2 = input.LA(2);

                    if ( (LA121_2==BANG||LA121_2==BOOLEAN||LA121_2==BYTE||(LA121_2 >= CHAR && LA121_2 <= CHARLITERAL)||(LA121_2 >= DOUBLE && LA121_2 <= DOUBLELITERAL)||LA121_2==EQ||LA121_2==FALSE||(LA121_2 >= FLOAT && LA121_2 <= FLOATLITERAL)||LA121_2==IDENTIFIER||LA121_2==INT||LA121_2==INTLITERAL||(LA121_2 >= LONG && LA121_2 <= LPAREN)||(LA121_2 >= NEW && LA121_2 <= NULL)||LA121_2==PLUS||LA121_2==PLUSPLUS||LA121_2==SHORT||(LA121_2 >= STRINGLITERAL && LA121_2 <= SUB)||(LA121_2 >= SUBSUB && LA121_2 <= SUPER)||LA121_2==THIS||LA121_2==TILDE||LA121_2==TRUE||LA121_2==VOID) ) {
                        alt121=1;
                    }


                }
                else if ( (LA121_0==GT) ) {
                    int LA121_3 = input.LA(2);

                    if ( (LA121_3==BANG||LA121_3==BOOLEAN||LA121_3==BYTE||(LA121_3 >= CHAR && LA121_3 <= CHARLITERAL)||(LA121_3 >= DOUBLE && LA121_3 <= DOUBLELITERAL)||LA121_3==EQ||LA121_3==FALSE||(LA121_3 >= FLOAT && LA121_3 <= FLOATLITERAL)||LA121_3==IDENTIFIER||LA121_3==INT||LA121_3==INTLITERAL||(LA121_3 >= LONG && LA121_3 <= LPAREN)||(LA121_3 >= NEW && LA121_3 <= NULL)||LA121_3==PLUS||LA121_3==PLUSPLUS||LA121_3==SHORT||(LA121_3 >= STRINGLITERAL && LA121_3 <= SUB)||(LA121_3 >= SUBSUB && LA121_3 <= SUPER)||LA121_3==THIS||LA121_3==TILDE||LA121_3==TRUE||LA121_3==VOID) ) {
                        alt121=1;
                    }


                }


                switch (alt121) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1055:10: relationalOp shiftExpression
            	    {
            	    pushFollow(FOLLOW_relationalOp_in_relationalExpression5932);
            	    relationalOp();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    pushFollow(FOLLOW_shiftExpression_in_relationalExpression5934);
            	    shiftExpression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop121;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 80, relationalExpression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "relationalExpression"



    // $ANTLR start "relationalOp"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1059:1: relationalOp : ( '<' '=' | '>' '=' | '<' | '>' );
    public final void relationalOp() throws RecognitionException {
        int relationalOp_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 81) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1060:5: ( '<' '=' | '>' '=' | '<' | '>' )
            int alt122=4;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==LT) ) {
                int LA122_1 = input.LA(2);

                if ( (LA122_1==EQ) ) {
                    alt122=1;
                }
                else if ( (LA122_1==BANG||LA122_1==BOOLEAN||LA122_1==BYTE||(LA122_1 >= CHAR && LA122_1 <= CHARLITERAL)||(LA122_1 >= DOUBLE && LA122_1 <= DOUBLELITERAL)||LA122_1==FALSE||(LA122_1 >= FLOAT && LA122_1 <= FLOATLITERAL)||LA122_1==IDENTIFIER||LA122_1==INT||LA122_1==INTLITERAL||(LA122_1 >= LONG && LA122_1 <= LPAREN)||(LA122_1 >= NEW && LA122_1 <= NULL)||LA122_1==PLUS||LA122_1==PLUSPLUS||LA122_1==SHORT||(LA122_1 >= STRINGLITERAL && LA122_1 <= SUB)||(LA122_1 >= SUBSUB && LA122_1 <= SUPER)||LA122_1==THIS||LA122_1==TILDE||LA122_1==TRUE||LA122_1==VOID) ) {
                    alt122=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 122, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA122_0==GT) ) {
                int LA122_2 = input.LA(2);

                if ( (LA122_2==EQ) ) {
                    alt122=2;
                }
                else if ( (LA122_2==BANG||LA122_2==BOOLEAN||LA122_2==BYTE||(LA122_2 >= CHAR && LA122_2 <= CHARLITERAL)||(LA122_2 >= DOUBLE && LA122_2 <= DOUBLELITERAL)||LA122_2==FALSE||(LA122_2 >= FLOAT && LA122_2 <= FLOATLITERAL)||LA122_2==IDENTIFIER||LA122_2==INT||LA122_2==INTLITERAL||(LA122_2 >= LONG && LA122_2 <= LPAREN)||(LA122_2 >= NEW && LA122_2 <= NULL)||LA122_2==PLUS||LA122_2==PLUSPLUS||LA122_2==SHORT||(LA122_2 >= STRINGLITERAL && LA122_2 <= SUB)||(LA122_2 >= SUBSUB && LA122_2 <= SUPER)||LA122_2==THIS||LA122_2==TILDE||LA122_2==TRUE||LA122_2==VOID) ) {
                    alt122=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 122, 2, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 122, 0, input);

                throw nvae;

            }
            switch (alt122) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1060:10: '<' '='
                    {
                    match(input,LT,FOLLOW_LT_in_relationalOp5966); if (state.failed) return ;

                    match(input,EQ,FOLLOW_EQ_in_relationalOp5968); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1061:10: '>' '='
                    {
                    match(input,GT,FOLLOW_GT_in_relationalOp5979); if (state.failed) return ;

                    match(input,EQ,FOLLOW_EQ_in_relationalOp5981); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1062:9: '<'
                    {
                    match(input,LT,FOLLOW_LT_in_relationalOp5991); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1063:9: '>'
                    {
                    match(input,GT,FOLLOW_GT_in_relationalOp6001); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 81, relationalOp_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "relationalOp"



    // $ANTLR start "shiftExpression"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1066:1: shiftExpression : additiveExpression ( shiftOp additiveExpression )* ;
    public final void shiftExpression() throws RecognitionException {
        int shiftExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 82) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1067:5: ( additiveExpression ( shiftOp additiveExpression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1067:9: additiveExpression ( shiftOp additiveExpression )*
            {
            pushFollow(FOLLOW_additiveExpression_in_shiftExpression6021);
            additiveExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1068:9: ( shiftOp additiveExpression )*
            loop123:
            do {
                int alt123=2;
                int LA123_0 = input.LA(1);

                if ( (LA123_0==LT) ) {
                    int LA123_1 = input.LA(2);

                    if ( (LA123_1==LT) ) {
                        int LA123_4 = input.LA(3);

                        if ( (LA123_4==BANG||LA123_4==BOOLEAN||LA123_4==BYTE||(LA123_4 >= CHAR && LA123_4 <= CHARLITERAL)||(LA123_4 >= DOUBLE && LA123_4 <= DOUBLELITERAL)||LA123_4==FALSE||(LA123_4 >= FLOAT && LA123_4 <= FLOATLITERAL)||LA123_4==IDENTIFIER||LA123_4==INT||LA123_4==INTLITERAL||(LA123_4 >= LONG && LA123_4 <= LPAREN)||(LA123_4 >= NEW && LA123_4 <= NULL)||LA123_4==PLUS||LA123_4==PLUSPLUS||LA123_4==SHORT||(LA123_4 >= STRINGLITERAL && LA123_4 <= SUB)||(LA123_4 >= SUBSUB && LA123_4 <= SUPER)||LA123_4==THIS||LA123_4==TILDE||LA123_4==TRUE||LA123_4==VOID) ) {
                            alt123=1;
                        }


                    }


                }
                else if ( (LA123_0==GT) ) {
                    int LA123_2 = input.LA(2);

                    if ( (LA123_2==GT) ) {
                        int LA123_5 = input.LA(3);

                        if ( (LA123_5==GT) ) {
                            int LA123_7 = input.LA(4);

                            if ( (LA123_7==BANG||LA123_7==BOOLEAN||LA123_7==BYTE||(LA123_7 >= CHAR && LA123_7 <= CHARLITERAL)||(LA123_7 >= DOUBLE && LA123_7 <= DOUBLELITERAL)||LA123_7==FALSE||(LA123_7 >= FLOAT && LA123_7 <= FLOATLITERAL)||LA123_7==IDENTIFIER||LA123_7==INT||LA123_7==INTLITERAL||(LA123_7 >= LONG && LA123_7 <= LPAREN)||(LA123_7 >= NEW && LA123_7 <= NULL)||LA123_7==PLUS||LA123_7==PLUSPLUS||LA123_7==SHORT||(LA123_7 >= STRINGLITERAL && LA123_7 <= SUB)||(LA123_7 >= SUBSUB && LA123_7 <= SUPER)||LA123_7==THIS||LA123_7==TILDE||LA123_7==TRUE||LA123_7==VOID) ) {
                                alt123=1;
                            }


                        }
                        else if ( (LA123_5==BANG||LA123_5==BOOLEAN||LA123_5==BYTE||(LA123_5 >= CHAR && LA123_5 <= CHARLITERAL)||(LA123_5 >= DOUBLE && LA123_5 <= DOUBLELITERAL)||LA123_5==FALSE||(LA123_5 >= FLOAT && LA123_5 <= FLOATLITERAL)||LA123_5==IDENTIFIER||LA123_5==INT||LA123_5==INTLITERAL||(LA123_5 >= LONG && LA123_5 <= LPAREN)||(LA123_5 >= NEW && LA123_5 <= NULL)||LA123_5==PLUS||LA123_5==PLUSPLUS||LA123_5==SHORT||(LA123_5 >= STRINGLITERAL && LA123_5 <= SUB)||(LA123_5 >= SUBSUB && LA123_5 <= SUPER)||LA123_5==THIS||LA123_5==TILDE||LA123_5==TRUE||LA123_5==VOID) ) {
                            alt123=1;
                        }


                    }


                }


                switch (alt123) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1068:10: shiftOp additiveExpression
            	    {
            	    pushFollow(FOLLOW_shiftOp_in_shiftExpression6032);
            	    shiftOp();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    pushFollow(FOLLOW_additiveExpression_in_shiftExpression6034);
            	    additiveExpression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop123;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 82, shiftExpression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "shiftExpression"



    // $ANTLR start "shiftOp"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1073:1: shiftOp : ( '<' '<' | '>' '>' '>' | '>' '>' );
    public final void shiftOp() throws RecognitionException {
        int shiftOp_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 83) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1074:5: ( '<' '<' | '>' '>' '>' | '>' '>' )
            int alt124=3;
            int LA124_0 = input.LA(1);

            if ( (LA124_0==LT) ) {
                alt124=1;
            }
            else if ( (LA124_0==GT) ) {
                int LA124_2 = input.LA(2);

                if ( (LA124_2==GT) ) {
                    int LA124_3 = input.LA(3);

                    if ( (LA124_3==GT) ) {
                        alt124=2;
                    }
                    else if ( (LA124_3==BANG||LA124_3==BOOLEAN||LA124_3==BYTE||(LA124_3 >= CHAR && LA124_3 <= CHARLITERAL)||(LA124_3 >= DOUBLE && LA124_3 <= DOUBLELITERAL)||LA124_3==FALSE||(LA124_3 >= FLOAT && LA124_3 <= FLOATLITERAL)||LA124_3==IDENTIFIER||LA124_3==INT||LA124_3==INTLITERAL||(LA124_3 >= LONG && LA124_3 <= LPAREN)||(LA124_3 >= NEW && LA124_3 <= NULL)||LA124_3==PLUS||LA124_3==PLUSPLUS||LA124_3==SHORT||(LA124_3 >= STRINGLITERAL && LA124_3 <= SUB)||(LA124_3 >= SUBSUB && LA124_3 <= SUPER)||LA124_3==THIS||LA124_3==TILDE||LA124_3==TRUE||LA124_3==VOID) ) {
                        alt124=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 124, 3, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 124, 2, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 124, 0, input);

                throw nvae;

            }
            switch (alt124) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1074:10: '<' '<'
                    {
                    match(input,LT,FOLLOW_LT_in_shiftOp6067); if (state.failed) return ;

                    match(input,LT,FOLLOW_LT_in_shiftOp6069); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1075:10: '>' '>' '>'
                    {
                    match(input,GT,FOLLOW_GT_in_shiftOp6080); if (state.failed) return ;

                    match(input,GT,FOLLOW_GT_in_shiftOp6082); if (state.failed) return ;

                    match(input,GT,FOLLOW_GT_in_shiftOp6084); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1076:10: '>' '>'
                    {
                    match(input,GT,FOLLOW_GT_in_shiftOp6095); if (state.failed) return ;

                    match(input,GT,FOLLOW_GT_in_shiftOp6097); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 83, shiftOp_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "shiftOp"



    // $ANTLR start "additiveExpression"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1080:1: additiveExpression : multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )* ;
    public final void additiveExpression() throws RecognitionException {
        int additiveExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 84) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1081:5: ( multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1081:9: multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )*
            {
            pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression6118);
            multiplicativeExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1082:9: ( ( '+' | '-' ) multiplicativeExpression )*
            loop125:
            do {
                int alt125=2;
                int LA125_0 = input.LA(1);

                if ( (LA125_0==PLUS||LA125_0==SUB) ) {
                    alt125=1;
                }


                switch (alt125) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1083:13: ( '+' | '-' ) multiplicativeExpression
            	    {
            	    if ( input.LA(1)==PLUS||input.LA(1)==SUB ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression6195);
            	    multiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop125;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 84, additiveExpression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "additiveExpression"



    // $ANTLR start "multiplicativeExpression"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1090:1: multiplicativeExpression : unaryExpression ( ( '*' | '/' | '%' ) unaryExpression )* ;
    public final void multiplicativeExpression() throws RecognitionException {
        int multiplicativeExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 85) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1091:5: ( unaryExpression ( ( '*' | '/' | '%' ) unaryExpression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1092:9: unaryExpression ( ( '*' | '/' | '%' ) unaryExpression )*
            {
            pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression6233);
            unaryExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1093:9: ( ( '*' | '/' | '%' ) unaryExpression )*
            loop126:
            do {
                int alt126=2;
                int LA126_0 = input.LA(1);

                if ( (LA126_0==PERCENT||LA126_0==SLASH||LA126_0==STAR) ) {
                    alt126=1;
                }


                switch (alt126) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1094:13: ( '*' | '/' | '%' ) unaryExpression
            	    {
            	    if ( input.LA(1)==PERCENT||input.LA(1)==SLASH||input.LA(1)==STAR ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression6328);
            	    unaryExpression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop126;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 85, multiplicativeExpression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "multiplicativeExpression"



    // $ANTLR start "unaryExpression"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1106:1: unaryExpression : ( '+' unaryExpression | '-' unaryExpression | '++' unaryExpression | '--' unaryExpression | unaryExpressionNotPlusMinus );
    public final void unaryExpression() throws RecognitionException {
        int unaryExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 86) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1107:5: ( '+' unaryExpression | '-' unaryExpression | '++' unaryExpression | '--' unaryExpression | unaryExpressionNotPlusMinus )
            int alt127=5;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt127=1;
                }
                break;
            case SUB:
                {
                alt127=2;
                }
                break;
            case PLUSPLUS:
                {
                alt127=3;
                }
                break;
            case SUBSUB:
                {
                alt127=4;
                }
                break;
            case BANG:
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case CHARLITERAL:
            case DOUBLE:
            case DOUBLELITERAL:
            case FALSE:
            case FLOAT:
            case FLOATLITERAL:
            case IDENTIFIER:
            case INT:
            case INTLITERAL:
            case LONG:
            case LONGLITERAL:
            case LPAREN:
            case NEW:
            case NULL:
            case SHORT:
            case STRINGLITERAL:
            case SUPER:
            case THIS:
            case TILDE:
            case TRUE:
            case VOID:
                {
                alt127=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 127, 0, input);

                throw nvae;

            }

            switch (alt127) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1107:9: '+' unaryExpression
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_unaryExpression6361); if (state.failed) return ;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression6364);
                    unaryExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1108:9: '-' unaryExpression
                    {
                    match(input,SUB,FOLLOW_SUB_in_unaryExpression6374); if (state.failed) return ;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression6376);
                    unaryExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1109:9: '++' unaryExpression
                    {
                    match(input,PLUSPLUS,FOLLOW_PLUSPLUS_in_unaryExpression6386); if (state.failed) return ;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression6388);
                    unaryExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1110:9: '--' unaryExpression
                    {
                    match(input,SUBSUB,FOLLOW_SUBSUB_in_unaryExpression6398); if (state.failed) return ;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression6400);
                    unaryExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1111:9: unaryExpressionNotPlusMinus
                    {
                    pushFollow(FOLLOW_unaryExpressionNotPlusMinus_in_unaryExpression6410);
                    unaryExpressionNotPlusMinus();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 86, unaryExpression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "unaryExpression"



    // $ANTLR start "unaryExpressionNotPlusMinus"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1114:1: unaryExpressionNotPlusMinus : ( '~' unaryExpression | '!' unaryExpression | castExpression | primary ( selector )* ( '++' | '--' )? );
    public final void unaryExpressionNotPlusMinus() throws RecognitionException {
        int unaryExpressionNotPlusMinus_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 87) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1115:5: ( '~' unaryExpression | '!' unaryExpression | castExpression | primary ( selector )* ( '++' | '--' )? )
            int alt130=4;
            switch ( input.LA(1) ) {
            case TILDE:
                {
                alt130=1;
                }
                break;
            case BANG:
                {
                alt130=2;
                }
                break;
            case LPAREN:
                {
                int LA130_3 = input.LA(2);

                if ( (synpred202_NoDynamicLoadingANTLR()) ) {
                    alt130=3;
                }
                else if ( (true) ) {
                    alt130=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 130, 3, input);

                    throw nvae;

                }
                }
                break;
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case CHARLITERAL:
            case DOUBLE:
            case DOUBLELITERAL:
            case FALSE:
            case FLOAT:
            case FLOATLITERAL:
            case IDENTIFIER:
            case INT:
            case INTLITERAL:
            case LONG:
            case LONGLITERAL:
            case NEW:
            case NULL:
            case SHORT:
            case STRINGLITERAL:
            case SUPER:
            case THIS:
            case TRUE:
            case VOID:
                {
                alt130=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 130, 0, input);

                throw nvae;

            }

            switch (alt130) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1115:9: '~' unaryExpression
                    {
                    match(input,TILDE,FOLLOW_TILDE_in_unaryExpressionNotPlusMinus6430); if (state.failed) return ;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus6432);
                    unaryExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1116:9: '!' unaryExpression
                    {
                    match(input,BANG,FOLLOW_BANG_in_unaryExpressionNotPlusMinus6442); if (state.failed) return ;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus6444);
                    unaryExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1117:9: castExpression
                    {
                    pushFollow(FOLLOW_castExpression_in_unaryExpressionNotPlusMinus6454);
                    castExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1118:9: primary ( selector )* ( '++' | '--' )?
                    {
                    pushFollow(FOLLOW_primary_in_unaryExpressionNotPlusMinus6464);
                    primary();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1119:9: ( selector )*
                    loop128:
                    do {
                        int alt128=2;
                        int LA128_0 = input.LA(1);

                        if ( (LA128_0==DOT||LA128_0==LBRACKET) ) {
                            alt128=1;
                        }


                        switch (alt128) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1119:10: selector
                    	    {
                    	    pushFollow(FOLLOW_selector_in_unaryExpressionNotPlusMinus6475);
                    	    selector();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop128;
                        }
                    } while (true);


                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1121:9: ( '++' | '--' )?
                    int alt129=2;
                    int LA129_0 = input.LA(1);

                    if ( (LA129_0==PLUSPLUS||LA129_0==SUBSUB) ) {
                        alt129=1;
                    }
                    switch (alt129) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:
                            {
                            if ( input.LA(1)==PLUSPLUS||input.LA(1)==SUBSUB ) {
                                input.consume();
                                state.errorRecovery=false;
                                state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 87, unaryExpressionNotPlusMinus_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "unaryExpressionNotPlusMinus"



    // $ANTLR start "castExpression"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1126:1: castExpression : ( '(' primitiveType ')' unaryExpression | '(' type ')' unaryExpressionNotPlusMinus );
    public final void castExpression() throws RecognitionException {
        int castExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 88) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1127:5: ( '(' primitiveType ')' unaryExpression | '(' type ')' unaryExpressionNotPlusMinus )
            int alt131=2;
            int LA131_0 = input.LA(1);

            if ( (LA131_0==LPAREN) ) {
                int LA131_1 = input.LA(2);

                if ( (synpred206_NoDynamicLoadingANTLR()) ) {
                    alt131=1;
                }
                else if ( (true) ) {
                    alt131=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 131, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 131, 0, input);

                throw nvae;

            }
            switch (alt131) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1127:9: '(' primitiveType ')' unaryExpression
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_castExpression6545); if (state.failed) return ;

                    pushFollow(FOLLOW_primitiveType_in_castExpression6547);
                    primitiveType();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,RPAREN,FOLLOW_RPAREN_in_castExpression6549); if (state.failed) return ;

                    pushFollow(FOLLOW_unaryExpression_in_castExpression6551);
                    unaryExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1128:9: '(' type ')' unaryExpressionNotPlusMinus
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_castExpression6561); if (state.failed) return ;

                    pushFollow(FOLLOW_type_in_castExpression6563);
                    type();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,RPAREN,FOLLOW_RPAREN_in_castExpression6565); if (state.failed) return ;

                    pushFollow(FOLLOW_unaryExpressionNotPlusMinus_in_castExpression6567);
                    unaryExpressionNotPlusMinus();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 88, castExpression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "castExpression"



    // $ANTLR start "primary"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1134:1: primary : ( parExpression |ids+= 'this' ( '.' ids+= IDENTIFIER )* ( identifierSuffix )? |ids+= IDENTIFIER ( '.' ids+= IDENTIFIER )* ( identifierSuffix )? | 'super' superSuffix | literal | creator | primitiveType ( '[' ']' )* '.' 'class' | 'void' '.' 'class' );
    public final void primary() throws RecognitionException {
        int primary_StartIndex = input.index();

        Token ids=null;
        List list_ids=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 89) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1135:5: ( parExpression |ids+= 'this' ( '.' ids+= IDENTIFIER )* ( identifierSuffix )? |ids+= IDENTIFIER ( '.' ids+= IDENTIFIER )* ( identifierSuffix )? | 'super' superSuffix | literal | creator | primitiveType ( '[' ']' )* '.' 'class' | 'void' '.' 'class' )
            int alt137=8;
            switch ( input.LA(1) ) {
            case LPAREN:
                {
                alt137=1;
                }
                break;
            case THIS:
                {
                alt137=2;
                }
                break;
            case IDENTIFIER:
                {
                alt137=3;
                }
                break;
            case SUPER:
                {
                alt137=4;
                }
                break;
            case CHARLITERAL:
            case DOUBLELITERAL:
            case FALSE:
            case FLOATLITERAL:
            case INTLITERAL:
            case LONGLITERAL:
            case NULL:
            case STRINGLITERAL:
            case TRUE:
                {
                alt137=5;
                }
                break;
            case NEW:
                {
                alt137=6;
                }
                break;
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case DOUBLE:
            case FLOAT:
            case INT:
            case LONG:
            case SHORT:
                {
                alt137=7;
                }
                break;
            case VOID:
                {
                alt137=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 137, 0, input);

                throw nvae;

            }

            switch (alt137) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1135:9: parExpression
                    {
                    pushFollow(FOLLOW_parExpression_in_primary6589);
                    parExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1136:9: ids+= 'this' ( '.' ids+= IDENTIFIER )* ( identifierSuffix )?
                    {
                    ids=(Token)match(input,THIS,FOLLOW_THIS_in_primary6615); if (state.failed) return ;
                    if (list_ids==null) list_ids=new ArrayList();
                    list_ids.add(ids);


                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1137:9: ( '.' ids+= IDENTIFIER )*
                    loop132:
                    do {
                        int alt132=2;
                        int LA132_0 = input.LA(1);

                        if ( (LA132_0==DOT) ) {
                            int LA132_2 = input.LA(2);

                            if ( (LA132_2==IDENTIFIER) ) {
                                int LA132_3 = input.LA(3);

                                if ( (synpred208_NoDynamicLoadingANTLR()) ) {
                                    alt132=1;
                                }


                            }


                        }


                        switch (alt132) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1137:10: '.' ids+= IDENTIFIER
                    	    {
                    	    match(input,DOT,FOLLOW_DOT_in_primary6626); if (state.failed) return ;

                    	    ids=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primary6632); if (state.failed) return ;
                    	    if (list_ids==null) list_ids=new ArrayList();
                    	    list_ids.add(ids);


                    	    }
                    	    break;

                    	default :
                    	    break loop132;
                        }
                    } while (true);


                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1139:9: ( identifierSuffix )?
                    int alt133=2;
                    switch ( input.LA(1) ) {
                        case LBRACKET:
                            {
                            int LA133_1 = input.LA(2);

                            if ( (synpred209_NoDynamicLoadingANTLR()) ) {
                                alt133=1;
                            }
                            }
                            break;
                        case LPAREN:
                            {
                            alt133=1;
                            }
                            break;
                        case DOT:
                            {
                            int LA133_3 = input.LA(2);

                            if ( (synpred209_NoDynamicLoadingANTLR()) ) {
                                alt133=1;
                            }
                            }
                            break;
                    }

                    switch (alt133) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1139:10: identifierSuffix
                            {
                            pushFollow(FOLLOW_identifierSuffix_in_primary6654);
                            identifierSuffix();

                            state._fsp--;
                            if (state.failed) return ;

                            if ( state.backtracking==0 ) {checkMethodInvocation(list_ids);}

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1141:9: ids+= IDENTIFIER ( '.' ids+= IDENTIFIER )* ( identifierSuffix )?
                    {
                    ids=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primary6681); if (state.failed) return ;
                    if (list_ids==null) list_ids=new ArrayList();
                    list_ids.add(ids);


                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1142:9: ( '.' ids+= IDENTIFIER )*
                    loop134:
                    do {
                        int alt134=2;
                        int LA134_0 = input.LA(1);

                        if ( (LA134_0==DOT) ) {
                            int LA134_2 = input.LA(2);

                            if ( (LA134_2==IDENTIFIER) ) {
                                int LA134_3 = input.LA(3);

                                if ( (synpred211_NoDynamicLoadingANTLR()) ) {
                                    alt134=1;
                                }


                            }


                        }


                        switch (alt134) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1142:10: '.' ids+= IDENTIFIER
                    	    {
                    	    match(input,DOT,FOLLOW_DOT_in_primary6692); if (state.failed) return ;

                    	    ids=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primary6698); if (state.failed) return ;
                    	    if (list_ids==null) list_ids=new ArrayList();
                    	    list_ids.add(ids);


                    	    }
                    	    break;

                    	default :
                    	    break loop134;
                        }
                    } while (true);


                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1144:9: ( identifierSuffix )?
                    int alt135=2;
                    switch ( input.LA(1) ) {
                        case LBRACKET:
                            {
                            int LA135_1 = input.LA(2);

                            if ( (synpred212_NoDynamicLoadingANTLR()) ) {
                                alt135=1;
                            }
                            }
                            break;
                        case LPAREN:
                            {
                            alt135=1;
                            }
                            break;
                        case DOT:
                            {
                            int LA135_3 = input.LA(2);

                            if ( (synpred212_NoDynamicLoadingANTLR()) ) {
                                alt135=1;
                            }
                            }
                            break;
                    }

                    switch (alt135) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1144:10: identifierSuffix
                            {
                            pushFollow(FOLLOW_identifierSuffix_in_primary6720);
                            identifierSuffix();

                            state._fsp--;
                            if (state.failed) return ;

                            if ( state.backtracking==0 ) {checkMethodInvocation(list_ids);}

                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1146:9: 'super' superSuffix
                    {
                    match(input,SUPER,FOLLOW_SUPER_in_primary6743); if (state.failed) return ;

                    pushFollow(FOLLOW_superSuffix_in_primary6753);
                    superSuffix();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1148:9: literal
                    {
                    pushFollow(FOLLOW_literal_in_primary6763);
                    literal();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1149:9: creator
                    {
                    pushFollow(FOLLOW_creator_in_primary6773);
                    creator();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1150:9: primitiveType ( '[' ']' )* '.' 'class'
                    {
                    pushFollow(FOLLOW_primitiveType_in_primary6783);
                    primitiveType();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1151:9: ( '[' ']' )*
                    loop136:
                    do {
                        int alt136=2;
                        int LA136_0 = input.LA(1);

                        if ( (LA136_0==LBRACKET) ) {
                            alt136=1;
                        }


                        switch (alt136) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1151:10: '[' ']'
                    	    {
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_primary6794); if (state.failed) return ;

                    	    match(input,RBRACKET,FOLLOW_RBRACKET_in_primary6796); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop136;
                        }
                    } while (true);


                    match(input,DOT,FOLLOW_DOT_in_primary6817); if (state.failed) return ;

                    match(input,CLASS,FOLLOW_CLASS_in_primary6819); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1154:9: 'void' '.' 'class'
                    {
                    match(input,VOID,FOLLOW_VOID_in_primary6829); if (state.failed) return ;

                    match(input,DOT,FOLLOW_DOT_in_primary6831); if (state.failed) return ;

                    match(input,CLASS,FOLLOW_CLASS_in_primary6833); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 89, primary_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "primary"



    // $ANTLR start "superSuffix"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1158:1: superSuffix : ( arguments | '.' ( typeArguments )? IDENTIFIER ( arguments )? );
    public final void superSuffix() throws RecognitionException {
        int superSuffix_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 90) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1159:5: ( arguments | '.' ( typeArguments )? IDENTIFIER ( arguments )? )
            int alt140=2;
            int LA140_0 = input.LA(1);

            if ( (LA140_0==LPAREN) ) {
                alt140=1;
            }
            else if ( (LA140_0==DOT) ) {
                alt140=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 140, 0, input);

                throw nvae;

            }
            switch (alt140) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1159:9: arguments
                    {
                    pushFollow(FOLLOW_arguments_in_superSuffix6859);
                    arguments();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1160:9: '.' ( typeArguments )? IDENTIFIER ( arguments )?
                    {
                    match(input,DOT,FOLLOW_DOT_in_superSuffix6869); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1160:13: ( typeArguments )?
                    int alt138=2;
                    int LA138_0 = input.LA(1);

                    if ( (LA138_0==LT) ) {
                        alt138=1;
                    }
                    switch (alt138) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1160:14: typeArguments
                            {
                            pushFollow(FOLLOW_typeArguments_in_superSuffix6872);
                            typeArguments();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_superSuffix6893); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1163:9: ( arguments )?
                    int alt139=2;
                    int LA139_0 = input.LA(1);

                    if ( (LA139_0==LPAREN) ) {
                        alt139=1;
                    }
                    switch (alt139) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1163:10: arguments
                            {
                            pushFollow(FOLLOW_arguments_in_superSuffix6904);
                            arguments();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 90, superSuffix_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "superSuffix"



    // $ANTLR start "identifierSuffix"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1168:1: identifierSuffix : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | arguments | '.' 'class' | '.' nonWildcardTypeArguments IDENTIFIER arguments | '.' 'this' | '.' 'super' arguments | innerCreator );
    public final void identifierSuffix() throws RecognitionException {
        int identifierSuffix_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 91) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1169:5: ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | arguments | '.' 'class' | '.' nonWildcardTypeArguments IDENTIFIER arguments | '.' 'this' | '.' 'super' arguments | innerCreator )
            int alt143=8;
            switch ( input.LA(1) ) {
            case LBRACKET:
                {
                int LA143_1 = input.LA(2);

                if ( (LA143_1==RBRACKET) ) {
                    alt143=1;
                }
                else if ( (LA143_1==BANG||LA143_1==BOOLEAN||LA143_1==BYTE||(LA143_1 >= CHAR && LA143_1 <= CHARLITERAL)||(LA143_1 >= DOUBLE && LA143_1 <= DOUBLELITERAL)||LA143_1==FALSE||(LA143_1 >= FLOAT && LA143_1 <= FLOATLITERAL)||LA143_1==IDENTIFIER||LA143_1==INT||LA143_1==INTLITERAL||(LA143_1 >= LONG && LA143_1 <= LPAREN)||(LA143_1 >= NEW && LA143_1 <= NULL)||LA143_1==PLUS||LA143_1==PLUSPLUS||LA143_1==SHORT||(LA143_1 >= STRINGLITERAL && LA143_1 <= SUB)||(LA143_1 >= SUBSUB && LA143_1 <= SUPER)||LA143_1==THIS||LA143_1==TILDE||LA143_1==TRUE||LA143_1==VOID) ) {
                    alt143=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 143, 1, input);

                    throw nvae;

                }
                }
                break;
            case LPAREN:
                {
                alt143=3;
                }
                break;
            case DOT:
                {
                switch ( input.LA(2) ) {
                case CLASS:
                    {
                    alt143=4;
                    }
                    break;
                case THIS:
                    {
                    alt143=6;
                    }
                    break;
                case SUPER:
                    {
                    alt143=7;
                    }
                    break;
                case NEW:
                    {
                    alt143=8;
                    }
                    break;
                case LT:
                    {
                    alt143=5;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 143, 3, input);

                    throw nvae;

                }

                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 143, 0, input);

                throw nvae;

            }

            switch (alt143) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1169:9: ( '[' ']' )+ '.' 'class'
                    {
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1169:9: ( '[' ']' )+
                    int cnt141=0;
                    loop141:
                    do {
                        int alt141=2;
                        int LA141_0 = input.LA(1);

                        if ( (LA141_0==LBRACKET) ) {
                            alt141=1;
                        }


                        switch (alt141) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1169:10: '[' ']'
                    	    {
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_identifierSuffix6936); if (state.failed) return ;

                    	    match(input,RBRACKET,FOLLOW_RBRACKET_in_identifierSuffix6938); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt141 >= 1 ) break loop141;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(141, input);
                                throw eee;
                        }
                        cnt141++;
                    } while (true);


                    match(input,DOT,FOLLOW_DOT_in_identifierSuffix6959); if (state.failed) return ;

                    match(input,CLASS,FOLLOW_CLASS_in_identifierSuffix6961); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1172:9: ( '[' expression ']' )+
                    {
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1172:9: ( '[' expression ']' )+
                    int cnt142=0;
                    loop142:
                    do {
                        int alt142=2;
                        int LA142_0 = input.LA(1);

                        if ( (LA142_0==LBRACKET) ) {
                            int LA142_2 = input.LA(2);

                            if ( (synpred224_NoDynamicLoadingANTLR()) ) {
                                alt142=1;
                            }


                        }


                        switch (alt142) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1172:10: '[' expression ']'
                    	    {
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_identifierSuffix6972); if (state.failed) return ;

                    	    pushFollow(FOLLOW_expression_in_identifierSuffix6974);
                    	    expression();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    match(input,RBRACKET,FOLLOW_RBRACKET_in_identifierSuffix6976); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt142 >= 1 ) break loop142;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(142, input);
                                throw eee;
                        }
                        cnt142++;
                    } while (true);


                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1174:9: arguments
                    {
                    pushFollow(FOLLOW_arguments_in_identifierSuffix6997);
                    arguments();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1175:9: '.' 'class'
                    {
                    match(input,DOT,FOLLOW_DOT_in_identifierSuffix7007); if (state.failed) return ;

                    match(input,CLASS,FOLLOW_CLASS_in_identifierSuffix7009); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1176:9: '.' nonWildcardTypeArguments IDENTIFIER arguments
                    {
                    match(input,DOT,FOLLOW_DOT_in_identifierSuffix7019); if (state.failed) return ;

                    pushFollow(FOLLOW_nonWildcardTypeArguments_in_identifierSuffix7021);
                    nonWildcardTypeArguments();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_identifierSuffix7023); if (state.failed) return ;

                    pushFollow(FOLLOW_arguments_in_identifierSuffix7025);
                    arguments();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1177:9: '.' 'this'
                    {
                    match(input,DOT,FOLLOW_DOT_in_identifierSuffix7035); if (state.failed) return ;

                    match(input,THIS,FOLLOW_THIS_in_identifierSuffix7037); if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1178:9: '.' 'super' arguments
                    {
                    match(input,DOT,FOLLOW_DOT_in_identifierSuffix7047); if (state.failed) return ;

                    match(input,SUPER,FOLLOW_SUPER_in_identifierSuffix7049); if (state.failed) return ;

                    pushFollow(FOLLOW_arguments_in_identifierSuffix7051);
                    arguments();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1179:9: innerCreator
                    {
                    pushFollow(FOLLOW_innerCreator_in_identifierSuffix7061);
                    innerCreator();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 91, identifierSuffix_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "identifierSuffix"



    // $ANTLR start "selector"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1183:1: selector : ( '.' IDENTIFIER ( arguments )? | '.' 'this' | '.' 'super' superSuffix | innerCreator | '[' expression ']' );
    public final void selector() throws RecognitionException {
        int selector_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 92) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1184:5: ( '.' IDENTIFIER ( arguments )? | '.' 'this' | '.' 'super' superSuffix | innerCreator | '[' expression ']' )
            int alt145=5;
            int LA145_0 = input.LA(1);

            if ( (LA145_0==DOT) ) {
                switch ( input.LA(2) ) {
                case IDENTIFIER:
                    {
                    alt145=1;
                    }
                    break;
                case THIS:
                    {
                    alt145=2;
                    }
                    break;
                case SUPER:
                    {
                    alt145=3;
                    }
                    break;
                case NEW:
                    {
                    alt145=4;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 145, 1, input);

                    throw nvae;

                }

            }
            else if ( (LA145_0==LBRACKET) ) {
                alt145=5;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 145, 0, input);

                throw nvae;

            }
            switch (alt145) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1184:9: '.' IDENTIFIER ( arguments )?
                    {
                    match(input,DOT,FOLLOW_DOT_in_selector7083); if (state.failed) return ;

                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_selector7085); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1185:9: ( arguments )?
                    int alt144=2;
                    int LA144_0 = input.LA(1);

                    if ( (LA144_0==LPAREN) ) {
                        alt144=1;
                    }
                    switch (alt144) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1185:10: arguments
                            {
                            pushFollow(FOLLOW_arguments_in_selector7096);
                            arguments();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1187:9: '.' 'this'
                    {
                    match(input,DOT,FOLLOW_DOT_in_selector7117); if (state.failed) return ;

                    match(input,THIS,FOLLOW_THIS_in_selector7119); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1188:9: '.' 'super' superSuffix
                    {
                    match(input,DOT,FOLLOW_DOT_in_selector7129); if (state.failed) return ;

                    match(input,SUPER,FOLLOW_SUPER_in_selector7131); if (state.failed) return ;

                    pushFollow(FOLLOW_superSuffix_in_selector7141);
                    superSuffix();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1190:9: innerCreator
                    {
                    pushFollow(FOLLOW_innerCreator_in_selector7151);
                    innerCreator();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1191:9: '[' expression ']'
                    {
                    match(input,LBRACKET,FOLLOW_LBRACKET_in_selector7161); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_selector7163);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,RBRACKET,FOLLOW_RBRACKET_in_selector7165); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 92, selector_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "selector"



    // $ANTLR start "creator"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1194:1: creator : ( 'new' nonWildcardTypeArguments classOrInterfaceType classCreatorRest | 'new' classOrInterfaceType classCreatorRest | arrayCreator );
    public final void creator() throws RecognitionException {
        int creator_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 93) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1195:5: ( 'new' nonWildcardTypeArguments classOrInterfaceType classCreatorRest | 'new' classOrInterfaceType classCreatorRest | arrayCreator )
            int alt146=3;
            int LA146_0 = input.LA(1);

            if ( (LA146_0==NEW) ) {
                int LA146_1 = input.LA(2);

                if ( (synpred236_NoDynamicLoadingANTLR()) ) {
                    alt146=1;
                }
                else if ( (synpred237_NoDynamicLoadingANTLR()) ) {
                    alt146=2;
                }
                else if ( (true) ) {
                    alt146=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 146, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 146, 0, input);

                throw nvae;

            }
            switch (alt146) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1195:9: 'new' nonWildcardTypeArguments classOrInterfaceType classCreatorRest
                    {
                    match(input,NEW,FOLLOW_NEW_in_creator7185); if (state.failed) return ;

                    pushFollow(FOLLOW_nonWildcardTypeArguments_in_creator7187);
                    nonWildcardTypeArguments();

                    state._fsp--;
                    if (state.failed) return ;

                    pushFollow(FOLLOW_classOrInterfaceType_in_creator7189);
                    classOrInterfaceType();

                    state._fsp--;
                    if (state.failed) return ;

                    pushFollow(FOLLOW_classCreatorRest_in_creator7191);
                    classCreatorRest();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1196:9: 'new' classOrInterfaceType classCreatorRest
                    {
                    match(input,NEW,FOLLOW_NEW_in_creator7201); if (state.failed) return ;

                    pushFollow(FOLLOW_classOrInterfaceType_in_creator7203);
                    classOrInterfaceType();

                    state._fsp--;
                    if (state.failed) return ;

                    pushFollow(FOLLOW_classCreatorRest_in_creator7205);
                    classCreatorRest();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1197:9: arrayCreator
                    {
                    pushFollow(FOLLOW_arrayCreator_in_creator7215);
                    arrayCreator();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 93, creator_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "creator"



    // $ANTLR start "arrayCreator"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1200:1: arrayCreator : ( 'new' createdName '[' ']' ( '[' ']' )* arrayInitializer | 'new' createdName '[' expression ']' ( '[' expression ']' )* ( '[' ']' )* );
    public final void arrayCreator() throws RecognitionException {
        int arrayCreator_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 94) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1201:5: ( 'new' createdName '[' ']' ( '[' ']' )* arrayInitializer | 'new' createdName '[' expression ']' ( '[' expression ']' )* ( '[' ']' )* )
            int alt150=2;
            int LA150_0 = input.LA(1);

            if ( (LA150_0==NEW) ) {
                int LA150_1 = input.LA(2);

                if ( (synpred239_NoDynamicLoadingANTLR()) ) {
                    alt150=1;
                }
                else if ( (true) ) {
                    alt150=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 150, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 150, 0, input);

                throw nvae;

            }
            switch (alt150) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1201:9: 'new' createdName '[' ']' ( '[' ']' )* arrayInitializer
                    {
                    match(input,NEW,FOLLOW_NEW_in_arrayCreator7235); if (state.failed) return ;

                    pushFollow(FOLLOW_createdName_in_arrayCreator7237);
                    createdName();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,LBRACKET,FOLLOW_LBRACKET_in_arrayCreator7247); if (state.failed) return ;

                    match(input,RBRACKET,FOLLOW_RBRACKET_in_arrayCreator7249); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1203:9: ( '[' ']' )*
                    loop147:
                    do {
                        int alt147=2;
                        int LA147_0 = input.LA(1);

                        if ( (LA147_0==LBRACKET) ) {
                            alt147=1;
                        }


                        switch (alt147) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1203:10: '[' ']'
                    	    {
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_arrayCreator7260); if (state.failed) return ;

                    	    match(input,RBRACKET,FOLLOW_RBRACKET_in_arrayCreator7262); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop147;
                        }
                    } while (true);


                    pushFollow(FOLLOW_arrayInitializer_in_arrayCreator7283);
                    arrayInitializer();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1207:9: 'new' createdName '[' expression ']' ( '[' expression ']' )* ( '[' ']' )*
                    {
                    match(input,NEW,FOLLOW_NEW_in_arrayCreator7294); if (state.failed) return ;

                    pushFollow(FOLLOW_createdName_in_arrayCreator7296);
                    createdName();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,LBRACKET,FOLLOW_LBRACKET_in_arrayCreator7306); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_arrayCreator7308);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,RBRACKET,FOLLOW_RBRACKET_in_arrayCreator7318); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1210:9: ( '[' expression ']' )*
                    loop148:
                    do {
                        int alt148=2;
                        int LA148_0 = input.LA(1);

                        if ( (LA148_0==LBRACKET) ) {
                            int LA148_1 = input.LA(2);

                            if ( (synpred240_NoDynamicLoadingANTLR()) ) {
                                alt148=1;
                            }


                        }


                        switch (alt148) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1210:13: '[' expression ']'
                    	    {
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_arrayCreator7332); if (state.failed) return ;

                    	    pushFollow(FOLLOW_expression_in_arrayCreator7334);
                    	    expression();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    match(input,RBRACKET,FOLLOW_RBRACKET_in_arrayCreator7348); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop148;
                        }
                    } while (true);


                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1213:9: ( '[' ']' )*
                    loop149:
                    do {
                        int alt149=2;
                        int LA149_0 = input.LA(1);

                        if ( (LA149_0==LBRACKET) ) {
                            int LA149_2 = input.LA(2);

                            if ( (LA149_2==RBRACKET) ) {
                                alt149=1;
                            }


                        }


                        switch (alt149) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1213:10: '[' ']'
                    	    {
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_arrayCreator7370); if (state.failed) return ;

                    	    match(input,RBRACKET,FOLLOW_RBRACKET_in_arrayCreator7372); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop149;
                        }
                    } while (true);


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 94, arrayCreator_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "arrayCreator"



    // $ANTLR start "variableInitializer"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1217:1: variableInitializer : ( arrayInitializer | expression );
    public final void variableInitializer() throws RecognitionException {
        int variableInitializer_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 95) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1218:5: ( arrayInitializer | expression )
            int alt151=2;
            int LA151_0 = input.LA(1);

            if ( (LA151_0==LBRACE) ) {
                alt151=1;
            }
            else if ( (LA151_0==BANG||LA151_0==BOOLEAN||LA151_0==BYTE||(LA151_0 >= CHAR && LA151_0 <= CHARLITERAL)||(LA151_0 >= DOUBLE && LA151_0 <= DOUBLELITERAL)||LA151_0==FALSE||(LA151_0 >= FLOAT && LA151_0 <= FLOATLITERAL)||LA151_0==IDENTIFIER||LA151_0==INT||LA151_0==INTLITERAL||(LA151_0 >= LONG && LA151_0 <= LPAREN)||(LA151_0 >= NEW && LA151_0 <= NULL)||LA151_0==PLUS||LA151_0==PLUSPLUS||LA151_0==SHORT||(LA151_0 >= STRINGLITERAL && LA151_0 <= SUB)||(LA151_0 >= SUBSUB && LA151_0 <= SUPER)||LA151_0==THIS||LA151_0==TILDE||LA151_0==TRUE||LA151_0==VOID) ) {
                alt151=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 151, 0, input);

                throw nvae;

            }
            switch (alt151) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1218:9: arrayInitializer
                    {
                    pushFollow(FOLLOW_arrayInitializer_in_variableInitializer7403);
                    arrayInitializer();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1219:9: expression
                    {
                    pushFollow(FOLLOW_expression_in_variableInitializer7413);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 95, variableInitializer_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "variableInitializer"



    // $ANTLR start "arrayInitializer"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1222:1: arrayInitializer : '{' ( variableInitializer ( ',' variableInitializer )* )? ( ',' )? '}' ;
    public final void arrayInitializer() throws RecognitionException {
        int arrayInitializer_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 96) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1223:5: ( '{' ( variableInitializer ( ',' variableInitializer )* )? ( ',' )? '}' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1223:9: '{' ( variableInitializer ( ',' variableInitializer )* )? ( ',' )? '}'
            {
            match(input,LBRACE,FOLLOW_LBRACE_in_arrayInitializer7433); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1224:13: ( variableInitializer ( ',' variableInitializer )* )?
            int alt153=2;
            int LA153_0 = input.LA(1);

            if ( (LA153_0==BANG||LA153_0==BOOLEAN||LA153_0==BYTE||(LA153_0 >= CHAR && LA153_0 <= CHARLITERAL)||(LA153_0 >= DOUBLE && LA153_0 <= DOUBLELITERAL)||LA153_0==FALSE||(LA153_0 >= FLOAT && LA153_0 <= FLOATLITERAL)||LA153_0==IDENTIFIER||LA153_0==INT||LA153_0==INTLITERAL||LA153_0==LBRACE||(LA153_0 >= LONG && LA153_0 <= LPAREN)||(LA153_0 >= NEW && LA153_0 <= NULL)||LA153_0==PLUS||LA153_0==PLUSPLUS||LA153_0==SHORT||(LA153_0 >= STRINGLITERAL && LA153_0 <= SUB)||(LA153_0 >= SUBSUB && LA153_0 <= SUPER)||LA153_0==THIS||LA153_0==TILDE||LA153_0==TRUE||LA153_0==VOID) ) {
                alt153=1;
            }
            switch (alt153) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1224:14: variableInitializer ( ',' variableInitializer )*
                    {
                    pushFollow(FOLLOW_variableInitializer_in_arrayInitializer7449);
                    variableInitializer();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1225:17: ( ',' variableInitializer )*
                    loop152:
                    do {
                        int alt152=2;
                        int LA152_0 = input.LA(1);

                        if ( (LA152_0==COMMA) ) {
                            int LA152_1 = input.LA(2);

                            if ( (LA152_1==BANG||LA152_1==BOOLEAN||LA152_1==BYTE||(LA152_1 >= CHAR && LA152_1 <= CHARLITERAL)||(LA152_1 >= DOUBLE && LA152_1 <= DOUBLELITERAL)||LA152_1==FALSE||(LA152_1 >= FLOAT && LA152_1 <= FLOATLITERAL)||LA152_1==IDENTIFIER||LA152_1==INT||LA152_1==INTLITERAL||LA152_1==LBRACE||(LA152_1 >= LONG && LA152_1 <= LPAREN)||(LA152_1 >= NEW && LA152_1 <= NULL)||LA152_1==PLUS||LA152_1==PLUSPLUS||LA152_1==SHORT||(LA152_1 >= STRINGLITERAL && LA152_1 <= SUB)||(LA152_1 >= SUBSUB && LA152_1 <= SUPER)||LA152_1==THIS||LA152_1==TILDE||LA152_1==TRUE||LA152_1==VOID) ) {
                                alt152=1;
                            }


                        }


                        switch (alt152) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1225:18: ',' variableInitializer
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_arrayInitializer7468); if (state.failed) return ;

                    	    pushFollow(FOLLOW_variableInitializer_in_arrayInitializer7470);
                    	    variableInitializer();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop152;
                        }
                    } while (true);


                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1228:13: ( ',' )?
            int alt154=2;
            int LA154_0 = input.LA(1);

            if ( (LA154_0==COMMA) ) {
                alt154=1;
            }
            switch (alt154) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1228:14: ','
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_arrayInitializer7520); if (state.failed) return ;

                    }
                    break;

            }


            match(input,RBRACE,FOLLOW_RBRACE_in_arrayInitializer7533); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 96, arrayInitializer_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "arrayInitializer"



    // $ANTLR start "createdName"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1233:1: createdName : ( classOrInterfaceType | primitiveType );
    public final void createdName() throws RecognitionException {
        int createdName_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 97) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1234:5: ( classOrInterfaceType | primitiveType )
            int alt155=2;
            int LA155_0 = input.LA(1);

            if ( (LA155_0==IDENTIFIER) ) {
                alt155=1;
            }
            else if ( (LA155_0==BOOLEAN||LA155_0==BYTE||LA155_0==CHAR||LA155_0==DOUBLE||LA155_0==FLOAT||LA155_0==INT||LA155_0==LONG||LA155_0==SHORT) ) {
                alt155=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 155, 0, input);

                throw nvae;

            }
            switch (alt155) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1234:9: classOrInterfaceType
                    {
                    pushFollow(FOLLOW_classOrInterfaceType_in_createdName7567);
                    classOrInterfaceType();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1235:9: primitiveType
                    {
                    pushFollow(FOLLOW_primitiveType_in_createdName7577);
                    primitiveType();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 97, createdName_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "createdName"



    // $ANTLR start "innerCreator"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1238:1: innerCreator : '.' 'new' ( nonWildcardTypeArguments )? IDENTIFIER ( typeArguments )? classCreatorRest ;
    public final void innerCreator() throws RecognitionException {
        int innerCreator_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 98) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1239:5: ( '.' 'new' ( nonWildcardTypeArguments )? IDENTIFIER ( typeArguments )? classCreatorRest )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1239:9: '.' 'new' ( nonWildcardTypeArguments )? IDENTIFIER ( typeArguments )? classCreatorRest
            {
            match(input,DOT,FOLLOW_DOT_in_innerCreator7598); if (state.failed) return ;

            match(input,NEW,FOLLOW_NEW_in_innerCreator7600); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1240:9: ( nonWildcardTypeArguments )?
            int alt156=2;
            int LA156_0 = input.LA(1);

            if ( (LA156_0==LT) ) {
                alt156=1;
            }
            switch (alt156) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1240:10: nonWildcardTypeArguments
                    {
                    pushFollow(FOLLOW_nonWildcardTypeArguments_in_innerCreator7611);
                    nonWildcardTypeArguments();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_innerCreator7632); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1243:9: ( typeArguments )?
            int alt157=2;
            int LA157_0 = input.LA(1);

            if ( (LA157_0==LT) ) {
                alt157=1;
            }
            switch (alt157) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1243:10: typeArguments
                    {
                    pushFollow(FOLLOW_typeArguments_in_innerCreator7643);
                    typeArguments();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            pushFollow(FOLLOW_classCreatorRest_in_innerCreator7664);
            classCreatorRest();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 98, innerCreator_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "innerCreator"



    // $ANTLR start "classCreatorRest"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1249:1: classCreatorRest : arguments ( classBody )? ;
    public final void classCreatorRest() throws RecognitionException {
        int classCreatorRest_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 99) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1250:5: ( arguments ( classBody )? )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1250:9: arguments ( classBody )?
            {
            pushFollow(FOLLOW_arguments_in_classCreatorRest7685);
            arguments();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1251:9: ( classBody )?
            int alt158=2;
            int LA158_0 = input.LA(1);

            if ( (LA158_0==LBRACE) ) {
                alt158=1;
            }
            switch (alt158) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1251:10: classBody
                    {
                    pushFollow(FOLLOW_classBody_in_classCreatorRest7696);
                    classBody();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 99, classCreatorRest_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "classCreatorRest"



    // $ANTLR start "nonWildcardTypeArguments"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1256:1: nonWildcardTypeArguments : '<' typeList '>' ;
    public final void nonWildcardTypeArguments() throws RecognitionException {
        int nonWildcardTypeArguments_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 100) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1257:5: ( '<' typeList '>' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1257:9: '<' typeList '>'
            {
            match(input,LT,FOLLOW_LT_in_nonWildcardTypeArguments7728); if (state.failed) return ;

            pushFollow(FOLLOW_typeList_in_nonWildcardTypeArguments7730);
            typeList();

            state._fsp--;
            if (state.failed) return ;

            match(input,GT,FOLLOW_GT_in_nonWildcardTypeArguments7740); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 100, nonWildcardTypeArguments_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "nonWildcardTypeArguments"



    // $ANTLR start "arguments"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1261:1: arguments : '(' ( expressionList )? ')' ;
    public final void arguments() throws RecognitionException {
        int arguments_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 101) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1262:5: ( '(' ( expressionList )? ')' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1262:9: '(' ( expressionList )? ')'
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_arguments7760); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1262:13: ( expressionList )?
            int alt159=2;
            int LA159_0 = input.LA(1);

            if ( (LA159_0==BANG||LA159_0==BOOLEAN||LA159_0==BYTE||(LA159_0 >= CHAR && LA159_0 <= CHARLITERAL)||(LA159_0 >= DOUBLE && LA159_0 <= DOUBLELITERAL)||LA159_0==FALSE||(LA159_0 >= FLOAT && LA159_0 <= FLOATLITERAL)||LA159_0==IDENTIFIER||LA159_0==INT||LA159_0==INTLITERAL||(LA159_0 >= LONG && LA159_0 <= LPAREN)||(LA159_0 >= NEW && LA159_0 <= NULL)||LA159_0==PLUS||LA159_0==PLUSPLUS||LA159_0==SHORT||(LA159_0 >= STRINGLITERAL && LA159_0 <= SUB)||(LA159_0 >= SUBSUB && LA159_0 <= SUPER)||LA159_0==THIS||LA159_0==TILDE||LA159_0==TRUE||LA159_0==VOID) ) {
                alt159=1;
            }
            switch (alt159) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1262:14: expressionList
                    {
                    pushFollow(FOLLOW_expressionList_in_arguments7763);
                    expressionList();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            match(input,RPAREN,FOLLOW_RPAREN_in_arguments7776); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 101, arguments_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "arguments"



    // $ANTLR start "literal"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1266:1: literal : ( INTLITERAL | LONGLITERAL | FLOATLITERAL | DOUBLELITERAL | CHARLITERAL | STRINGLITERAL | TRUE | FALSE | NULL );
    public final void literal() throws RecognitionException {
        int literal_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 102) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1267:5: ( INTLITERAL | LONGLITERAL | FLOATLITERAL | DOUBLELITERAL | CHARLITERAL | STRINGLITERAL | TRUE | FALSE | NULL )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:
            {
            if ( input.LA(1)==CHARLITERAL||input.LA(1)==DOUBLELITERAL||input.LA(1)==FALSE||input.LA(1)==FLOATLITERAL||input.LA(1)==INTLITERAL||input.LA(1)==LONGLITERAL||input.LA(1)==NULL||input.LA(1)==STRINGLITERAL||input.LA(1)==TRUE ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 102, literal_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "literal"



    // $ANTLR start "classHeader"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1282:1: classHeader : modifiers 'class' IDENTIFIER ;
    public final void classHeader() throws RecognitionException {
        int classHeader_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 103) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1283:5: ( modifiers 'class' IDENTIFIER )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1283:9: modifiers 'class' IDENTIFIER
            {
            pushFollow(FOLLOW_modifiers_in_classHeader7900);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            match(input,CLASS,FOLLOW_CLASS_in_classHeader7902); if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_classHeader7904); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 103, classHeader_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "classHeader"



    // $ANTLR start "enumHeader"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1286:1: enumHeader : modifiers ( 'enum' | IDENTIFIER ) IDENTIFIER ;
    public final void enumHeader() throws RecognitionException {
        int enumHeader_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 104) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1287:5: ( modifiers ( 'enum' | IDENTIFIER ) IDENTIFIER )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1287:9: modifiers ( 'enum' | IDENTIFIER ) IDENTIFIER
            {
            pushFollow(FOLLOW_modifiers_in_enumHeader7924);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            if ( input.LA(1)==ENUM||input.LA(1)==IDENTIFIER ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enumHeader7932); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 104, enumHeader_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "enumHeader"



    // $ANTLR start "interfaceHeader"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1290:1: interfaceHeader : modifiers 'interface' IDENTIFIER ;
    public final void interfaceHeader() throws RecognitionException {
        int interfaceHeader_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 105) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1291:5: ( modifiers 'interface' IDENTIFIER )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1291:9: modifiers 'interface' IDENTIFIER
            {
            pushFollow(FOLLOW_modifiers_in_interfaceHeader7952);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            match(input,INTERFACE,FOLLOW_INTERFACE_in_interfaceHeader7954); if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_interfaceHeader7956); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 105, interfaceHeader_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "interfaceHeader"



    // $ANTLR start "annotationHeader"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1294:1: annotationHeader : modifiers '@' 'interface' IDENTIFIER ;
    public final void annotationHeader() throws RecognitionException {
        int annotationHeader_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 106) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1295:5: ( modifiers '@' 'interface' IDENTIFIER )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1295:9: modifiers '@' 'interface' IDENTIFIER
            {
            pushFollow(FOLLOW_modifiers_in_annotationHeader7976);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            match(input,MONKEYS_AT,FOLLOW_MONKEYS_AT_in_annotationHeader7978); if (state.failed) return ;

            match(input,INTERFACE,FOLLOW_INTERFACE_in_annotationHeader7980); if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_annotationHeader7982); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 106, annotationHeader_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "annotationHeader"



    // $ANTLR start "typeHeader"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1298:1: typeHeader : modifiers ( 'class' | 'enum' | ( ( '@' )? 'interface' ) ) IDENTIFIER ;
    public final void typeHeader() throws RecognitionException {
        int typeHeader_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 107) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1299:5: ( modifiers ( 'class' | 'enum' | ( ( '@' )? 'interface' ) ) IDENTIFIER )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1299:9: modifiers ( 'class' | 'enum' | ( ( '@' )? 'interface' ) ) IDENTIFIER
            {
            pushFollow(FOLLOW_modifiers_in_typeHeader8002);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1299:19: ( 'class' | 'enum' | ( ( '@' )? 'interface' ) )
            int alt161=3;
            switch ( input.LA(1) ) {
            case CLASS:
                {
                alt161=1;
                }
                break;
            case ENUM:
                {
                alt161=2;
                }
                break;
            case INTERFACE:
            case MONKEYS_AT:
                {
                alt161=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 161, 0, input);

                throw nvae;

            }

            switch (alt161) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1299:20: 'class'
                    {
                    match(input,CLASS,FOLLOW_CLASS_in_typeHeader8005); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1299:28: 'enum'
                    {
                    match(input,ENUM,FOLLOW_ENUM_in_typeHeader8007); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1299:35: ( ( '@' )? 'interface' )
                    {
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1299:35: ( ( '@' )? 'interface' )
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1299:36: ( '@' )? 'interface'
                    {
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1299:36: ( '@' )?
                    int alt160=2;
                    int LA160_0 = input.LA(1);

                    if ( (LA160_0==MONKEYS_AT) ) {
                        alt160=1;
                    }
                    switch (alt160) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1299:36: '@'
                            {
                            match(input,MONKEYS_AT,FOLLOW_MONKEYS_AT_in_typeHeader8010); if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,INTERFACE,FOLLOW_INTERFACE_in_typeHeader8014); if (state.failed) return ;

                    }


                    }
                    break;

            }


            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_typeHeader8018); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 107, typeHeader_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "typeHeader"



    // $ANTLR start "methodHeader"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1302:1: methodHeader : modifiers ( typeParameters )? ( type | 'void' )? IDENTIFIER '(' ;
    public final void methodHeader() throws RecognitionException {
        int methodHeader_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 108) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1303:5: ( modifiers ( typeParameters )? ( type | 'void' )? IDENTIFIER '(' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1303:9: modifiers ( typeParameters )? ( type | 'void' )? IDENTIFIER '('
            {
            pushFollow(FOLLOW_modifiers_in_methodHeader8038);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1303:19: ( typeParameters )?
            int alt162=2;
            int LA162_0 = input.LA(1);

            if ( (LA162_0==LT) ) {
                alt162=1;
            }
            switch (alt162) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1303:19: typeParameters
                    {
                    pushFollow(FOLLOW_typeParameters_in_methodHeader8040);
                    typeParameters();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1303:35: ( type | 'void' )?
            int alt163=3;
            switch ( input.LA(1) ) {
                case IDENTIFIER:
                    {
                    int LA163_1 = input.LA(2);

                    if ( (LA163_1==DOT||LA163_1==IDENTIFIER||LA163_1==LBRACKET||LA163_1==LT) ) {
                        alt163=1;
                    }
                    }
                    break;
                case BOOLEAN:
                case BYTE:
                case CHAR:
                case DOUBLE:
                case FLOAT:
                case INT:
                case LONG:
                case SHORT:
                    {
                    alt163=1;
                    }
                    break;
                case VOID:
                    {
                    alt163=2;
                    }
                    break;
            }

            switch (alt163) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1303:36: type
                    {
                    pushFollow(FOLLOW_type_in_methodHeader8044);
                    type();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1303:41: 'void'
                    {
                    match(input,VOID,FOLLOW_VOID_in_methodHeader8046); if (state.failed) return ;

                    }
                    break;

            }


            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_methodHeader8050); if (state.failed) return ;

            match(input,LPAREN,FOLLOW_LPAREN_in_methodHeader8052); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 108, methodHeader_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "methodHeader"



    // $ANTLR start "fieldHeader"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1306:1: fieldHeader : modifiers type IDENTIFIER ( '[' ']' )* ( '=' | ',' | ';' ) ;
    public final void fieldHeader() throws RecognitionException {
        int fieldHeader_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 109) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1307:5: ( modifiers type IDENTIFIER ( '[' ']' )* ( '=' | ',' | ';' ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1307:9: modifiers type IDENTIFIER ( '[' ']' )* ( '=' | ',' | ';' )
            {
            pushFollow(FOLLOW_modifiers_in_fieldHeader8072);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_type_in_fieldHeader8074);
            type();

            state._fsp--;
            if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_fieldHeader8076); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1307:35: ( '[' ']' )*
            loop164:
            do {
                int alt164=2;
                int LA164_0 = input.LA(1);

                if ( (LA164_0==LBRACKET) ) {
                    alt164=1;
                }


                switch (alt164) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1307:36: '[' ']'
            	    {
            	    match(input,LBRACKET,FOLLOW_LBRACKET_in_fieldHeader8079); if (state.failed) return ;

            	    match(input,RBRACKET,FOLLOW_RBRACKET_in_fieldHeader8080); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop164;
                }
            } while (true);


            if ( input.LA(1)==COMMA||input.LA(1)==EQ||input.LA(1)==SEMI ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 109, fieldHeader_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "fieldHeader"



    // $ANTLR start "localVariableHeader"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1310:1: localVariableHeader : variableModifiers type IDENTIFIER ( '[' ']' )* ( '=' | ',' | ';' ) ;
    public final void localVariableHeader() throws RecognitionException {
        int localVariableHeader_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 110) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1311:5: ( variableModifiers type IDENTIFIER ( '[' ']' )* ( '=' | ',' | ';' ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1311:9: variableModifiers type IDENTIFIER ( '[' ']' )* ( '=' | ',' | ';' )
            {
            pushFollow(FOLLOW_variableModifiers_in_localVariableHeader8110);
            variableModifiers();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_type_in_localVariableHeader8112);
            type();

            state._fsp--;
            if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_localVariableHeader8114); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1311:43: ( '[' ']' )*
            loop165:
            do {
                int alt165=2;
                int LA165_0 = input.LA(1);

                if ( (LA165_0==LBRACKET) ) {
                    alt165=1;
                }


                switch (alt165) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1311:44: '[' ']'
            	    {
            	    match(input,LBRACKET,FOLLOW_LBRACKET_in_localVariableHeader8117); if (state.failed) return ;

            	    match(input,RBRACKET,FOLLOW_RBRACKET_in_localVariableHeader8118); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop165;
                }
            } while (true);


            if ( input.LA(1)==COMMA||input.LA(1)==EQ||input.LA(1)==SEMI ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 110, localVariableHeader_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "localVariableHeader"

    // $ANTLR start synpred2_NoDynamicLoadingANTLR
    public final void synpred2_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:332:13: ( ( annotations )? packageDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:332:13: ( annotations )? packageDeclaration
        {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:332:13: ( annotations )?
        int alt166=2;
        int LA166_0 = input.LA(1);

        if ( (LA166_0==MONKEYS_AT) ) {
            alt166=1;
        }
        switch (alt166) {
            case 1 :
                // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:332:14: annotations
                {
                pushFollow(FOLLOW_annotations_in_synpred2_NoDynamicLoadingANTLR101);
                annotations();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        pushFollow(FOLLOW_packageDeclaration_in_synpred2_NoDynamicLoadingANTLR130);
        packageDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred2_NoDynamicLoadingANTLR

    // $ANTLR start synpred12_NoDynamicLoadingANTLR
    public final void synpred12_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:376:10: ( classDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:376:10: classDeclaration
        {
        pushFollow(FOLLOW_classDeclaration_in_synpred12_NoDynamicLoadingANTLR488);
        classDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred12_NoDynamicLoadingANTLR

    // $ANTLR start synpred27_NoDynamicLoadingANTLR
    public final void synpred27_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:407:9: ( normalClassDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:407:9: normalClassDeclaration
        {
        pushFollow(FOLLOW_normalClassDeclaration_in_synpred27_NoDynamicLoadingANTLR725);
        normalClassDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred27_NoDynamicLoadingANTLR

    // $ANTLR start synpred43_NoDynamicLoadingANTLR
    public final void synpred43_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:495:9: ( normalInterfaceDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:495:9: normalInterfaceDeclaration
        {
        pushFollow(FOLLOW_normalInterfaceDeclaration_in_synpred43_NoDynamicLoadingANTLR1404);
        normalInterfaceDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred43_NoDynamicLoadingANTLR

    // $ANTLR start synpred52_NoDynamicLoadingANTLR
    public final void synpred52_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:537:10: ( fieldDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:537:10: fieldDeclaration
        {
        pushFollow(FOLLOW_fieldDeclaration_in_synpred52_NoDynamicLoadingANTLR1734);
        fieldDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred52_NoDynamicLoadingANTLR

    // $ANTLR start synpred53_NoDynamicLoadingANTLR
    public final void synpred53_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:538:10: ( methodDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:538:10: methodDeclaration
        {
        pushFollow(FOLLOW_methodDeclaration_in_synpred53_NoDynamicLoadingANTLR1745);
        methodDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred53_NoDynamicLoadingANTLR

    // $ANTLR start synpred54_NoDynamicLoadingANTLR
    public final void synpred54_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:539:10: ( classDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:539:10: classDeclaration
        {
        pushFollow(FOLLOW_classDeclaration_in_synpred54_NoDynamicLoadingANTLR1756);
        classDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred54_NoDynamicLoadingANTLR

    // $ANTLR start synpred57_NoDynamicLoadingANTLR
    public final void synpred57_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:555:10: ( explicitConstructorInvocation )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:555:10: explicitConstructorInvocation
        {
        pushFollow(FOLLOW_explicitConstructorInvocation_in_synpred57_NoDynamicLoadingANTLR1893);
        explicitConstructorInvocation();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred57_NoDynamicLoadingANTLR

    // $ANTLR start synpred59_NoDynamicLoadingANTLR
    public final void synpred59_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:547:10: ( modifiers ( typeParameters )? IDENTIFIER formalParameters ( 'throws' qualifiedNameList )? '{' ( explicitConstructorInvocation )? ( blockStatement )* '}' )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:547:10: modifiers ( typeParameters )? IDENTIFIER formalParameters ( 'throws' qualifiedNameList )? '{' ( explicitConstructorInvocation )? ( blockStatement )* '}'
        {
        pushFollow(FOLLOW_modifiers_in_synpred59_NoDynamicLoadingANTLR1805);
        modifiers();

        state._fsp--;
        if (state.failed) return ;

        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:548:9: ( typeParameters )?
        int alt169=2;
        int LA169_0 = input.LA(1);

        if ( (LA169_0==LT) ) {
            alt169=1;
        }
        switch (alt169) {
            case 1 :
                // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:548:10: typeParameters
                {
                pushFollow(FOLLOW_typeParameters_in_synpred59_NoDynamicLoadingANTLR1816);
                typeParameters();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred59_NoDynamicLoadingANTLR1837); if (state.failed) return ;

        pushFollow(FOLLOW_formalParameters_in_synpred59_NoDynamicLoadingANTLR1847);
        formalParameters();

        state._fsp--;
        if (state.failed) return ;

        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:552:9: ( 'throws' qualifiedNameList )?
        int alt170=2;
        int LA170_0 = input.LA(1);

        if ( (LA170_0==THROWS) ) {
            alt170=1;
        }
        switch (alt170) {
            case 1 :
                // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:552:10: 'throws' qualifiedNameList
                {
                match(input,THROWS,FOLLOW_THROWS_in_synpred59_NoDynamicLoadingANTLR1858); if (state.failed) return ;

                pushFollow(FOLLOW_qualifiedNameList_in_synpred59_NoDynamicLoadingANTLR1860);
                qualifiedNameList();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        match(input,LBRACE,FOLLOW_LBRACE_in_synpred59_NoDynamicLoadingANTLR1881); if (state.failed) return ;

        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:555:9: ( explicitConstructorInvocation )?
        int alt171=2;
        switch ( input.LA(1) ) {
            case LT:
                {
                alt171=1;
                }
                break;
            case THIS:
                {
                int LA171_2 = input.LA(2);

                if ( (synpred57_NoDynamicLoadingANTLR()) ) {
                    alt171=1;
                }
                }
                break;
            case LPAREN:
                {
                int LA171_3 = input.LA(2);

                if ( (synpred57_NoDynamicLoadingANTLR()) ) {
                    alt171=1;
                }
                }
                break;
            case SUPER:
                {
                int LA171_4 = input.LA(2);

                if ( (synpred57_NoDynamicLoadingANTLR()) ) {
                    alt171=1;
                }
                }
                break;
            case IDENTIFIER:
                {
                int LA171_5 = input.LA(2);

                if ( (synpred57_NoDynamicLoadingANTLR()) ) {
                    alt171=1;
                }
                }
                break;
            case CHARLITERAL:
            case DOUBLELITERAL:
            case FALSE:
            case FLOATLITERAL:
            case INTLITERAL:
            case LONGLITERAL:
            case NULL:
            case STRINGLITERAL:
            case TRUE:
                {
                int LA171_6 = input.LA(2);

                if ( (synpred57_NoDynamicLoadingANTLR()) ) {
                    alt171=1;
                }
                }
                break;
            case NEW:
                {
                int LA171_7 = input.LA(2);

                if ( (synpred57_NoDynamicLoadingANTLR()) ) {
                    alt171=1;
                }
                }
                break;
            case BOOLEAN:
            case BYTE:
            case CHAR:
            case DOUBLE:
            case FLOAT:
            case INT:
            case LONG:
            case SHORT:
                {
                int LA171_8 = input.LA(2);

                if ( (synpred57_NoDynamicLoadingANTLR()) ) {
                    alt171=1;
                }
                }
                break;
            case VOID:
                {
                int LA171_9 = input.LA(2);

                if ( (synpred57_NoDynamicLoadingANTLR()) ) {
                    alt171=1;
                }
                }
                break;
        }

        switch (alt171) {
            case 1 :
                // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:555:10: explicitConstructorInvocation
                {
                pushFollow(FOLLOW_explicitConstructorInvocation_in_synpred59_NoDynamicLoadingANTLR1893);
                explicitConstructorInvocation();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:557:9: ( blockStatement )*
        loop172:
        do {
            int alt172=2;
            int LA172_0 = input.LA(1);

            if ( (LA172_0==ABSTRACT||(LA172_0 >= ASSERT && LA172_0 <= BANG)||(LA172_0 >= BOOLEAN && LA172_0 <= BYTE)||(LA172_0 >= CHAR && LA172_0 <= CLASS)||LA172_0==CONTINUE||LA172_0==DO||(LA172_0 >= DOUBLE && LA172_0 <= DOUBLELITERAL)||LA172_0==ENUM||(LA172_0 >= FALSE && LA172_0 <= FINAL)||(LA172_0 >= FLOAT && LA172_0 <= FOR)||(LA172_0 >= IDENTIFIER && LA172_0 <= IF)||(LA172_0 >= INT && LA172_0 <= INTLITERAL)||LA172_0==LBRACE||(LA172_0 >= LONG && LA172_0 <= LT)||(LA172_0 >= MONKEYS_AT && LA172_0 <= NULL)||LA172_0==PLUS||(LA172_0 >= PLUSPLUS && LA172_0 <= PUBLIC)||LA172_0==RETURN||(LA172_0 >= SEMI && LA172_0 <= SHORT)||(LA172_0 >= STATIC && LA172_0 <= SUB)||(LA172_0 >= SUBSUB && LA172_0 <= SYNCHRONIZED)||(LA172_0 >= THIS && LA172_0 <= THROW)||(LA172_0 >= TILDE && LA172_0 <= WHILE)) ) {
                alt172=1;
            }


            switch (alt172) {
        	case 1 :
        	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:557:10: blockStatement
        	    {
        	    pushFollow(FOLLOW_blockStatement_in_synpred59_NoDynamicLoadingANTLR1915);
        	    blockStatement();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop172;
            }
        } while (true);


        match(input,RBRACE,FOLLOW_RBRACE_in_synpred59_NoDynamicLoadingANTLR1936); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred59_NoDynamicLoadingANTLR

    // $ANTLR start synpred68_NoDynamicLoadingANTLR
    public final void synpred68_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:601:9: ( interfaceFieldDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:601:9: interfaceFieldDeclaration
        {
        pushFollow(FOLLOW_interfaceFieldDeclaration_in_synpred68_NoDynamicLoadingANTLR2311);
        interfaceFieldDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred68_NoDynamicLoadingANTLR

    // $ANTLR start synpred69_NoDynamicLoadingANTLR
    public final void synpred69_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:602:9: ( interfaceMethodDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:602:9: interfaceMethodDeclaration
        {
        pushFollow(FOLLOW_interfaceMethodDeclaration_in_synpred69_NoDynamicLoadingANTLR2321);
        interfaceMethodDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred69_NoDynamicLoadingANTLR

    // $ANTLR start synpred70_NoDynamicLoadingANTLR
    public final void synpred70_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:603:9: ( interfaceDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:603:9: interfaceDeclaration
        {
        pushFollow(FOLLOW_interfaceDeclaration_in_synpred70_NoDynamicLoadingANTLR2331);
        interfaceDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred70_NoDynamicLoadingANTLR

    // $ANTLR start synpred71_NoDynamicLoadingANTLR
    public final void synpred71_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:604:9: ( classDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:604:9: classDeclaration
        {
        pushFollow(FOLLOW_classDeclaration_in_synpred71_NoDynamicLoadingANTLR2341);
        classDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred71_NoDynamicLoadingANTLR

    // $ANTLR start synpred96_NoDynamicLoadingANTLR
    public final void synpred96_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:699:9: ( ellipsisParameterDecl )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:699:9: ellipsisParameterDecl
        {
        pushFollow(FOLLOW_ellipsisParameterDecl_in_synpred96_NoDynamicLoadingANTLR3105);
        ellipsisParameterDecl();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred96_NoDynamicLoadingANTLR

    // $ANTLR start synpred98_NoDynamicLoadingANTLR
    public final void synpred98_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:700:9: ( normalParameterDecl ( ',' normalParameterDecl )* )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:700:9: normalParameterDecl ( ',' normalParameterDecl )*
        {
        pushFollow(FOLLOW_normalParameterDecl_in_synpred98_NoDynamicLoadingANTLR3115);
        normalParameterDecl();

        state._fsp--;
        if (state.failed) return ;

        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:701:9: ( ',' normalParameterDecl )*
        loop175:
        do {
            int alt175=2;
            int LA175_0 = input.LA(1);

            if ( (LA175_0==COMMA) ) {
                alt175=1;
            }


            switch (alt175) {
        	case 1 :
        	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:701:10: ',' normalParameterDecl
        	    {
        	    match(input,COMMA,FOLLOW_COMMA_in_synpred98_NoDynamicLoadingANTLR3126); if (state.failed) return ;

        	    pushFollow(FOLLOW_normalParameterDecl_in_synpred98_NoDynamicLoadingANTLR3128);
        	    normalParameterDecl();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop175;
            }
        } while (true);


        }

    }
    // $ANTLR end synpred98_NoDynamicLoadingANTLR

    // $ANTLR start synpred99_NoDynamicLoadingANTLR
    public final void synpred99_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:703:10: ( normalParameterDecl ',' )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:703:10: normalParameterDecl ','
        {
        pushFollow(FOLLOW_normalParameterDecl_in_synpred99_NoDynamicLoadingANTLR3150);
        normalParameterDecl();

        state._fsp--;
        if (state.failed) return ;

        match(input,COMMA,FOLLOW_COMMA_in_synpred99_NoDynamicLoadingANTLR3160); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred99_NoDynamicLoadingANTLR

    // $ANTLR start synpred103_NoDynamicLoadingANTLR
    public final void synpred103_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:723:9: ( ( nonWildcardTypeArguments )? ( 'this' | 'super' ) arguments ';' )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:723:9: ( nonWildcardTypeArguments )? ( 'this' | 'super' ) arguments ';'
        {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:723:9: ( nonWildcardTypeArguments )?
        int alt176=2;
        int LA176_0 = input.LA(1);

        if ( (LA176_0==LT) ) {
            alt176=1;
        }
        switch (alt176) {
            case 1 :
                // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:723:10: nonWildcardTypeArguments
                {
                pushFollow(FOLLOW_nonWildcardTypeArguments_in_synpred103_NoDynamicLoadingANTLR3295);
                nonWildcardTypeArguments();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        if ( input.LA(1)==SUPER||input.LA(1)==THIS ) {
            input.consume();
            state.errorRecovery=false;
            state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        pushFollow(FOLLOW_arguments_in_synpred103_NoDynamicLoadingANTLR3353);
        arguments();

        state._fsp--;
        if (state.failed) return ;

        match(input,SEMI,FOLLOW_SEMI_in_synpred103_NoDynamicLoadingANTLR3355); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred103_NoDynamicLoadingANTLR

    // $ANTLR start synpred117_NoDynamicLoadingANTLR
    public final void synpred117_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:810:9: ( annotationMethodDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:810:9: annotationMethodDeclaration
        {
        pushFollow(FOLLOW_annotationMethodDeclaration_in_synpred117_NoDynamicLoadingANTLR3954);
        annotationMethodDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred117_NoDynamicLoadingANTLR

    // $ANTLR start synpred118_NoDynamicLoadingANTLR
    public final void synpred118_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:811:9: ( interfaceFieldDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:811:9: interfaceFieldDeclaration
        {
        pushFollow(FOLLOW_interfaceFieldDeclaration_in_synpred118_NoDynamicLoadingANTLR3964);
        interfaceFieldDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred118_NoDynamicLoadingANTLR

    // $ANTLR start synpred119_NoDynamicLoadingANTLR
    public final void synpred119_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:812:9: ( normalClassDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:812:9: normalClassDeclaration
        {
        pushFollow(FOLLOW_normalClassDeclaration_in_synpred119_NoDynamicLoadingANTLR3974);
        normalClassDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred119_NoDynamicLoadingANTLR

    // $ANTLR start synpred120_NoDynamicLoadingANTLR
    public final void synpred120_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:813:9: ( normalInterfaceDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:813:9: normalInterfaceDeclaration
        {
        pushFollow(FOLLOW_normalInterfaceDeclaration_in_synpred120_NoDynamicLoadingANTLR3984);
        normalInterfaceDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred120_NoDynamicLoadingANTLR

    // $ANTLR start synpred121_NoDynamicLoadingANTLR
    public final void synpred121_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:814:9: ( enumDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:814:9: enumDeclaration
        {
        pushFollow(FOLLOW_enumDeclaration_in_synpred121_NoDynamicLoadingANTLR3994);
        enumDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred121_NoDynamicLoadingANTLR

    // $ANTLR start synpred122_NoDynamicLoadingANTLR
    public final void synpred122_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:815:9: ( annotationTypeDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:815:9: annotationTypeDeclaration
        {
        pushFollow(FOLLOW_annotationTypeDeclaration_in_synpred122_NoDynamicLoadingANTLR4004);
        annotationTypeDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred122_NoDynamicLoadingANTLR

    // $ANTLR start synpred125_NoDynamicLoadingANTLR
    public final void synpred125_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:858:9: ( localVariableDeclarationStatement )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:858:9: localVariableDeclarationStatement
        {
        pushFollow(FOLLOW_localVariableDeclarationStatement_in_synpred125_NoDynamicLoadingANTLR4162);
        localVariableDeclarationStatement();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred125_NoDynamicLoadingANTLR

    // $ANTLR start synpred126_NoDynamicLoadingANTLR
    public final void synpred126_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:859:9: ( classOrInterfaceDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:859:9: classOrInterfaceDeclaration
        {
        pushFollow(FOLLOW_classOrInterfaceDeclaration_in_synpred126_NoDynamicLoadingANTLR4172);
        classOrInterfaceDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred126_NoDynamicLoadingANTLR

    // $ANTLR start synpred130_NoDynamicLoadingANTLR
    public final void synpred130_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:879:9: ( ( 'assert' ) expression ( ':' expression )? ';' )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:879:9: ( 'assert' ) expression ( ':' expression )? ';'
        {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:879:9: ( 'assert' )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:879:10: 'assert'
        {
        match(input,ASSERT,FOLLOW_ASSERT_in_synpred130_NoDynamicLoadingANTLR4313); if (state.failed) return ;

        }


        pushFollow(FOLLOW_expression_in_synpred130_NoDynamicLoadingANTLR4333);
        expression();

        state._fsp--;
        if (state.failed) return ;

        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:881:20: ( ':' expression )?
        int alt179=2;
        int LA179_0 = input.LA(1);

        if ( (LA179_0==COLON) ) {
            alt179=1;
        }
        switch (alt179) {
            case 1 :
                // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:881:21: ':' expression
                {
                match(input,COLON,FOLLOW_COLON_in_synpred130_NoDynamicLoadingANTLR4336); if (state.failed) return ;

                pushFollow(FOLLOW_expression_in_synpred130_NoDynamicLoadingANTLR4338);
                expression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        match(input,SEMI,FOLLOW_SEMI_in_synpred130_NoDynamicLoadingANTLR4342); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred130_NoDynamicLoadingANTLR

    // $ANTLR start synpred132_NoDynamicLoadingANTLR
    public final void synpred132_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:882:9: ( 'assert' expression ( ':' expression )? ';' )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:882:9: 'assert' expression ( ':' expression )? ';'
        {
        match(input,ASSERT,FOLLOW_ASSERT_in_synpred132_NoDynamicLoadingANTLR4352); if (state.failed) return ;

        pushFollow(FOLLOW_expression_in_synpred132_NoDynamicLoadingANTLR4355);
        expression();

        state._fsp--;
        if (state.failed) return ;

        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:882:30: ( ':' expression )?
        int alt180=2;
        int LA180_0 = input.LA(1);

        if ( (LA180_0==COLON) ) {
            alt180=1;
        }
        switch (alt180) {
            case 1 :
                // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:882:31: ':' expression
                {
                match(input,COLON,FOLLOW_COLON_in_synpred132_NoDynamicLoadingANTLR4358); if (state.failed) return ;

                pushFollow(FOLLOW_expression_in_synpred132_NoDynamicLoadingANTLR4360);
                expression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        match(input,SEMI,FOLLOW_SEMI_in_synpred132_NoDynamicLoadingANTLR4364); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred132_NoDynamicLoadingANTLR

    // $ANTLR start synpred133_NoDynamicLoadingANTLR
    public final void synpred133_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:883:39: ( 'else' statement )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:883:39: 'else' statement
        {
        match(input,ELSE,FOLLOW_ELSE_in_synpred133_NoDynamicLoadingANTLR4393); if (state.failed) return ;

        pushFollow(FOLLOW_statement_in_synpred133_NoDynamicLoadingANTLR4395);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred133_NoDynamicLoadingANTLR

    // $ANTLR start synpred148_NoDynamicLoadingANTLR
    public final void synpred148_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:898:9: ( expression ';' )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:898:9: expression ';'
        {
        pushFollow(FOLLOW_expression_in_synpred148_NoDynamicLoadingANTLR4617);
        expression();

        state._fsp--;
        if (state.failed) return ;

        match(input,SEMI,FOLLOW_SEMI_in_synpred148_NoDynamicLoadingANTLR4620); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred148_NoDynamicLoadingANTLR

    // $ANTLR start synpred149_NoDynamicLoadingANTLR
    public final void synpred149_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:899:9: ( IDENTIFIER ':' statement )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:899:9: IDENTIFIER ':' statement
        {
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred149_NoDynamicLoadingANTLR4635); if (state.failed) return ;

        match(input,COLON,FOLLOW_COLON_in_synpred149_NoDynamicLoadingANTLR4637); if (state.failed) return ;

        pushFollow(FOLLOW_statement_in_synpred149_NoDynamicLoadingANTLR4639);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred149_NoDynamicLoadingANTLR

    // $ANTLR start synpred153_NoDynamicLoadingANTLR
    public final void synpred153_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:923:13: ( catches 'finally' block )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:923:13: catches 'finally' block
        {
        pushFollow(FOLLOW_catches_in_synpred153_NoDynamicLoadingANTLR4795);
        catches();

        state._fsp--;
        if (state.failed) return ;

        match(input,FINALLY,FOLLOW_FINALLY_in_synpred153_NoDynamicLoadingANTLR4797); if (state.failed) return ;

        pushFollow(FOLLOW_block_in_synpred153_NoDynamicLoadingANTLR4799);
        block();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred153_NoDynamicLoadingANTLR

    // $ANTLR start synpred154_NoDynamicLoadingANTLR
    public final void synpred154_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:924:13: ( catches )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:924:13: catches
        {
        pushFollow(FOLLOW_catches_in_synpred154_NoDynamicLoadingANTLR4813);
        catches();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred154_NoDynamicLoadingANTLR

    // $ANTLR start synpred157_NoDynamicLoadingANTLR
    public final void synpred157_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:949:9: ( 'for' '(' variableModifiers type IDENTIFIER ':' expression ')' statement )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:949:9: 'for' '(' variableModifiers type IDENTIFIER ':' expression ')' statement
        {
        match(input,FOR,FOLLOW_FOR_in_synpred157_NoDynamicLoadingANTLR5005); if (state.failed) return ;

        match(input,LPAREN,FOLLOW_LPAREN_in_synpred157_NoDynamicLoadingANTLR5007); if (state.failed) return ;

        pushFollow(FOLLOW_variableModifiers_in_synpred157_NoDynamicLoadingANTLR5009);
        variableModifiers();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_type_in_synpred157_NoDynamicLoadingANTLR5011);
        type();

        state._fsp--;
        if (state.failed) return ;

        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred157_NoDynamicLoadingANTLR5013); if (state.failed) return ;

        match(input,COLON,FOLLOW_COLON_in_synpred157_NoDynamicLoadingANTLR5015); if (state.failed) return ;

        pushFollow(FOLLOW_expression_in_synpred157_NoDynamicLoadingANTLR5026);
        expression();

        state._fsp--;
        if (state.failed) return ;

        match(input,RPAREN,FOLLOW_RPAREN_in_synpred157_NoDynamicLoadingANTLR5028); if (state.failed) return ;

        pushFollow(FOLLOW_statement_in_synpred157_NoDynamicLoadingANTLR5030);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred157_NoDynamicLoadingANTLR

    // $ANTLR start synpred161_NoDynamicLoadingANTLR
    public final void synpred161_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:963:9: ( localVariableDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:963:9: localVariableDeclaration
        {
        pushFollow(FOLLOW_localVariableDeclaration_in_synpred161_NoDynamicLoadingANTLR5209);
        localVariableDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred161_NoDynamicLoadingANTLR

    // $ANTLR start synpred202_NoDynamicLoadingANTLR
    public final void synpred202_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1117:9: ( castExpression )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1117:9: castExpression
        {
        pushFollow(FOLLOW_castExpression_in_synpred202_NoDynamicLoadingANTLR6454);
        castExpression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred202_NoDynamicLoadingANTLR

    // $ANTLR start synpred206_NoDynamicLoadingANTLR
    public final void synpred206_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1127:9: ( '(' primitiveType ')' unaryExpression )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1127:9: '(' primitiveType ')' unaryExpression
        {
        match(input,LPAREN,FOLLOW_LPAREN_in_synpred206_NoDynamicLoadingANTLR6545); if (state.failed) return ;

        pushFollow(FOLLOW_primitiveType_in_synpred206_NoDynamicLoadingANTLR6547);
        primitiveType();

        state._fsp--;
        if (state.failed) return ;

        match(input,RPAREN,FOLLOW_RPAREN_in_synpred206_NoDynamicLoadingANTLR6549); if (state.failed) return ;

        pushFollow(FOLLOW_unaryExpression_in_synpred206_NoDynamicLoadingANTLR6551);
        unaryExpression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred206_NoDynamicLoadingANTLR

    // $ANTLR start synpred208_NoDynamicLoadingANTLR
    public final void synpred208_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        Token ids=null;
        List list_ids=null;

        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1137:10: ( '.' ids+= IDENTIFIER )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1137:10: '.' ids+= IDENTIFIER
        {
        match(input,DOT,FOLLOW_DOT_in_synpred208_NoDynamicLoadingANTLR6626); if (state.failed) return ;

        ids=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred208_NoDynamicLoadingANTLR6632); if (state.failed) return ;
        if (list_ids==null) list_ids=new ArrayList();
        list_ids.add(ids);


        }

    }
    // $ANTLR end synpred208_NoDynamicLoadingANTLR

    // $ANTLR start synpred209_NoDynamicLoadingANTLR
    public final void synpred209_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1139:10: ( identifierSuffix )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1139:10: identifierSuffix
        {
        pushFollow(FOLLOW_identifierSuffix_in_synpred209_NoDynamicLoadingANTLR6654);
        identifierSuffix();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred209_NoDynamicLoadingANTLR

    // $ANTLR start synpred211_NoDynamicLoadingANTLR
    public final void synpred211_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        Token ids=null;
        List list_ids=null;

        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1142:10: ( '.' ids+= IDENTIFIER )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1142:10: '.' ids+= IDENTIFIER
        {
        match(input,DOT,FOLLOW_DOT_in_synpred211_NoDynamicLoadingANTLR6692); if (state.failed) return ;

        ids=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred211_NoDynamicLoadingANTLR6698); if (state.failed) return ;
        if (list_ids==null) list_ids=new ArrayList();
        list_ids.add(ids);


        }

    }
    // $ANTLR end synpred211_NoDynamicLoadingANTLR

    // $ANTLR start synpred212_NoDynamicLoadingANTLR
    public final void synpred212_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1144:10: ( identifierSuffix )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1144:10: identifierSuffix
        {
        pushFollow(FOLLOW_identifierSuffix_in_synpred212_NoDynamicLoadingANTLR6720);
        identifierSuffix();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred212_NoDynamicLoadingANTLR

    // $ANTLR start synpred224_NoDynamicLoadingANTLR
    public final void synpred224_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1172:10: ( '[' expression ']' )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1172:10: '[' expression ']'
        {
        match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred224_NoDynamicLoadingANTLR6972); if (state.failed) return ;

        pushFollow(FOLLOW_expression_in_synpred224_NoDynamicLoadingANTLR6974);
        expression();

        state._fsp--;
        if (state.failed) return ;

        match(input,RBRACKET,FOLLOW_RBRACKET_in_synpred224_NoDynamicLoadingANTLR6976); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred224_NoDynamicLoadingANTLR

    // $ANTLR start synpred236_NoDynamicLoadingANTLR
    public final void synpred236_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1195:9: ( 'new' nonWildcardTypeArguments classOrInterfaceType classCreatorRest )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1195:9: 'new' nonWildcardTypeArguments classOrInterfaceType classCreatorRest
        {
        match(input,NEW,FOLLOW_NEW_in_synpred236_NoDynamicLoadingANTLR7185); if (state.failed) return ;

        pushFollow(FOLLOW_nonWildcardTypeArguments_in_synpred236_NoDynamicLoadingANTLR7187);
        nonWildcardTypeArguments();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_classOrInterfaceType_in_synpred236_NoDynamicLoadingANTLR7189);
        classOrInterfaceType();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_classCreatorRest_in_synpred236_NoDynamicLoadingANTLR7191);
        classCreatorRest();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred236_NoDynamicLoadingANTLR

    // $ANTLR start synpred237_NoDynamicLoadingANTLR
    public final void synpred237_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1196:9: ( 'new' classOrInterfaceType classCreatorRest )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1196:9: 'new' classOrInterfaceType classCreatorRest
        {
        match(input,NEW,FOLLOW_NEW_in_synpred237_NoDynamicLoadingANTLR7201); if (state.failed) return ;

        pushFollow(FOLLOW_classOrInterfaceType_in_synpred237_NoDynamicLoadingANTLR7203);
        classOrInterfaceType();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_classCreatorRest_in_synpred237_NoDynamicLoadingANTLR7205);
        classCreatorRest();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred237_NoDynamicLoadingANTLR

    // $ANTLR start synpred239_NoDynamicLoadingANTLR
    public final void synpred239_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1201:9: ( 'new' createdName '[' ']' ( '[' ']' )* arrayInitializer )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1201:9: 'new' createdName '[' ']' ( '[' ']' )* arrayInitializer
        {
        match(input,NEW,FOLLOW_NEW_in_synpred239_NoDynamicLoadingANTLR7235); if (state.failed) return ;

        pushFollow(FOLLOW_createdName_in_synpred239_NoDynamicLoadingANTLR7237);
        createdName();

        state._fsp--;
        if (state.failed) return ;

        match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred239_NoDynamicLoadingANTLR7247); if (state.failed) return ;

        match(input,RBRACKET,FOLLOW_RBRACKET_in_synpred239_NoDynamicLoadingANTLR7249); if (state.failed) return ;

        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1203:9: ( '[' ']' )*
        loop193:
        do {
            int alt193=2;
            int LA193_0 = input.LA(1);

            if ( (LA193_0==LBRACKET) ) {
                alt193=1;
            }


            switch (alt193) {
        	case 1 :
        	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1203:10: '[' ']'
        	    {
        	    match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred239_NoDynamicLoadingANTLR7260); if (state.failed) return ;

        	    match(input,RBRACKET,FOLLOW_RBRACKET_in_synpred239_NoDynamicLoadingANTLR7262); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop193;
            }
        } while (true);


        pushFollow(FOLLOW_arrayInitializer_in_synpred239_NoDynamicLoadingANTLR7283);
        arrayInitializer();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred239_NoDynamicLoadingANTLR

    // $ANTLR start synpred240_NoDynamicLoadingANTLR
    public final void synpred240_NoDynamicLoadingANTLR_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1210:13: ( '[' expression ']' )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/restriction/rules/check/NoDynamicLoadingANTLR.g:1210:13: '[' expression ']'
        {
        match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred240_NoDynamicLoadingANTLR7332); if (state.failed) return ;

        pushFollow(FOLLOW_expression_in_synpred240_NoDynamicLoadingANTLR7334);
        expression();

        state._fsp--;
        if (state.failed) return ;

        match(input,RBRACKET,FOLLOW_RBRACKET_in_synpred240_NoDynamicLoadingANTLR7348); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred240_NoDynamicLoadingANTLR

    // Delegated rules

    public final boolean synpred154_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred154_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred59_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred59_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred237_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred237_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred118_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred118_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred161_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred161_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred96_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred96_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred71_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred71_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred68_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred68_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred52_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred52_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred209_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred209_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred126_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred126_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred208_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred208_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred70_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred70_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred130_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred130_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred103_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred103_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred224_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred224_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred98_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred98_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred133_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred133_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred157_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred157_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred153_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred153_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred240_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred240_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred148_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred148_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred122_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred122_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred125_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred125_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred236_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred236_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred212_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred212_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred132_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred132_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred69_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred69_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred211_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred211_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred119_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred119_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred53_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred53_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred239_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred239_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred57_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred57_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred117_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred117_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred120_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred120_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred206_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred206_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred43_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred121_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred121_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred202_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred202_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred54_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred99_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred99_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred149_NoDynamicLoadingANTLR() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred149_NoDynamicLoadingANTLR_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_annotations_in_compilationUnit101 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_packageDeclaration_in_compilationUnit130 = new BitSet(new long[]{0x1200102000800012L,0x0011040C10700600L});
    public static final BitSet FOLLOW_importDeclaration_in_compilationUnit152 = new BitSet(new long[]{0x1200102000800012L,0x0011040C10700600L});
    public static final BitSet FOLLOW_typeDeclaration_in_compilationUnit174 = new BitSet(new long[]{0x1000102000800012L,0x0011040C10700600L});
    public static final BitSet FOLLOW_PACKAGE_in_packageDeclaration205 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_qualifiedName_in_packageDeclaration207 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_packageDeclaration217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_importDeclaration238 = new BitSet(new long[]{0x0040000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_STATIC_in_importDeclaration250 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_importDeclaration271 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_DOT_in_importDeclaration273 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_STAR_in_importDeclaration275 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_importDeclaration285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_importDeclaration302 = new BitSet(new long[]{0x0040000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_STATIC_in_importDeclaration314 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_importDeclaration335 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_DOT_in_importDeclaration346 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_importDeclaration348 = new BitSet(new long[]{0x0000000080000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_DOT_in_importDeclaration370 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_STAR_in_importDeclaration372 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_importDeclaration393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_qualifiedImportName413 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_DOT_in_qualifiedImportName424 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_qualifiedImportName426 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_classOrInterfaceDeclaration_in_typeDeclaration457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_typeDeclaration467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classDeclaration_in_classOrInterfaceDeclaration488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceDeclaration_in_classOrInterfaceDeclaration498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_modifiers533 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_PUBLIC_in_modifiers543 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_PROTECTED_in_modifiers553 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_PRIVATE_in_modifiers563 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_STATIC_in_modifiers573 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_ABSTRACT_in_modifiers583 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_FINAL_in_modifiers593 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_NATIVE_in_modifiers603 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_SYNCHRONIZED_in_modifiers613 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_TRANSIENT_in_modifiers623 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_VOLATILE_in_modifiers633 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_STRICTFP_in_modifiers643 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_FINAL_in_variableModifiers675 = new BitSet(new long[]{0x0000100000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_annotation_in_variableModifiers689 = new BitSet(new long[]{0x0000100000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_normalClassDeclaration_in_classDeclaration725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumDeclaration_in_classDeclaration735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_normalClassDeclaration755 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_CLASS_in_normalClassDeclaration758 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_normalClassDeclaration760 = new BitSet(new long[]{0x0100010000000000L,0x0000000000000082L});
    public static final BitSet FOLLOW_typeParameters_in_normalClassDeclaration771 = new BitSet(new long[]{0x0100010000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_EXTENDS_in_normalClassDeclaration793 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_normalClassDeclaration795 = new BitSet(new long[]{0x0100000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_IMPLEMENTS_in_normalClassDeclaration817 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_typeList_in_normalClassDeclaration819 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_classBody_in_normalClassDeclaration852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_typeParameters873 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_typeParameter_in_typeParameters887 = new BitSet(new long[]{0x0008000002000000L});
    public static final BitSet FOLLOW_COMMA_in_typeParameters902 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_typeParameter_in_typeParameters904 = new BitSet(new long[]{0x0008000002000000L});
    public static final BitSet FOLLOW_GT_in_typeParameters929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_typeParameter949 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_EXTENDS_in_typeParameter960 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_typeBound_in_typeParameter962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typeBound994 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_AMP_in_typeBound1005 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_typeBound1007 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_modifiers_in_enumDeclaration1039 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_ENUM_in_enumDeclaration1051 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_enumDeclaration1072 = new BitSet(new long[]{0x0100000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_IMPLEMENTS_in_enumDeclaration1083 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_typeList_in_enumDeclaration1085 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_enumBody_in_enumDeclaration1106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_enumBody1131 = new BitSet(new long[]{0x0040000002000000L,0x0000000011000200L});
    public static final BitSet FOLLOW_enumConstants_in_enumBody1142 = new BitSet(new long[]{0x0000000002000000L,0x0000000011000000L});
    public static final BitSet FOLLOW_COMMA_in_enumBody1164 = new BitSet(new long[]{0x0000000000000000L,0x0000000011000000L});
    public static final BitSet FOLLOW_enumBodyDeclarations_in_enumBody1177 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_RBRACE_in_enumBody1199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumConstant_in_enumConstants1219 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_enumConstants1230 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_enumConstant_in_enumConstants1232 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_annotations_in_enumConstant1266 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_enumConstant1287 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000042L});
    public static final BitSet FOLLOW_arguments_in_enumConstant1298 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_classBody_in_enumConstant1320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_enumBodyDeclarations1361 = new BitSet(new long[]{0x1840502100A14012L,0x0019040C30700692L});
    public static final BitSet FOLLOW_classBodyDeclaration_in_enumBodyDeclarations1373 = new BitSet(new long[]{0x1840502100A14012L,0x0019040C30700692L});
    public static final BitSet FOLLOW_normalInterfaceDeclaration_in_interfaceDeclaration1404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeDeclaration_in_interfaceDeclaration1414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_normalInterfaceDeclaration1438 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_INTERFACE_in_normalInterfaceDeclaration1440 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_normalInterfaceDeclaration1442 = new BitSet(new long[]{0x0000010000000000L,0x0000000000000082L});
    public static final BitSet FOLLOW_typeParameters_in_normalInterfaceDeclaration1453 = new BitSet(new long[]{0x0000010000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_EXTENDS_in_normalInterfaceDeclaration1475 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_typeList_in_normalInterfaceDeclaration1477 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceBody_in_normalInterfaceDeclaration1498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typeList1518 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_typeList1529 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_typeList1531 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_LBRACE_in_classBody1562 = new BitSet(new long[]{0x1840502100A14010L,0x0019040C31700692L});
    public static final BitSet FOLLOW_classBodyDeclaration_in_classBody1574 = new BitSet(new long[]{0x1840502100A14010L,0x0019040C31700692L});
    public static final BitSet FOLLOW_RBRACE_in_classBody1596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_interfaceBody1616 = new BitSet(new long[]{0x1840502100A14010L,0x0019040C31700690L});
    public static final BitSet FOLLOW_interfaceBodyDeclaration_in_interfaceBody1628 = new BitSet(new long[]{0x1840502100A14010L,0x0019040C31700690L});
    public static final BitSet FOLLOW_RBRACE_in_interfaceBody1650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_classBodyDeclaration1670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STATIC_in_classBodyDeclaration1681 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_classBodyDeclaration1703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_memberDecl_in_classBodyDeclaration1713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fieldDeclaration_in_memberDecl1734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_methodDeclaration_in_memberDecl1745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classDeclaration_in_memberDecl1756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceDeclaration_in_memberDecl1767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_methodDeclaration1805 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_typeParameters_in_methodDeclaration1816 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_methodDeclaration1837 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_formalParameters_in_methodDeclaration1847 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000002L});
    public static final BitSet FOLLOW_THROWS_in_methodDeclaration1858 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_qualifiedNameList_in_methodDeclaration1860 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_methodDeclaration1881 = new BitSet(new long[]{0x38C1D82350E1C310L,0x003FB7BC357A1EF2L});
    public static final BitSet FOLLOW_explicitConstructorInvocation_in_methodDeclaration1893 = new BitSet(new long[]{0x38C1D82350E1C310L,0x003FB7BC357A1E72L});
    public static final BitSet FOLLOW_blockStatement_in_methodDeclaration1915 = new BitSet(new long[]{0x38C1D82350E1C310L,0x003FB7BC357A1E72L});
    public static final BitSet FOLLOW_RBRACE_in_methodDeclaration1936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_methodDeclaration1946 = new BitSet(new long[]{0x0840400100214000L,0x0008000020000090L});
    public static final BitSet FOLLOW_typeParameters_in_methodDeclaration1957 = new BitSet(new long[]{0x0840400100214000L,0x0008000020000010L});
    public static final BitSet FOLLOW_type_in_methodDeclaration1979 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_VOID_in_methodDeclaration1993 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_methodDeclaration2013 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_formalParameters_in_methodDeclaration2023 = new BitSet(new long[]{0x0000000000000000L,0x0000400010000006L});
    public static final BitSet FOLLOW_LBRACKET_in_methodDeclaration2034 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_methodDeclaration2036 = new BitSet(new long[]{0x0000000000000000L,0x0000400010000006L});
    public static final BitSet FOLLOW_THROWS_in_methodDeclaration2058 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_qualifiedNameList_in_methodDeclaration2060 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000002L});
    public static final BitSet FOLLOW_block_in_methodDeclaration2115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_methodDeclaration2129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_fieldDeclaration2161 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_fieldDeclaration2171 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_variableDeclarator_in_fieldDeclaration2181 = new BitSet(new long[]{0x0000000002000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_COMMA_in_fieldDeclaration2192 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_variableDeclarator_in_fieldDeclaration2194 = new BitSet(new long[]{0x0000000002000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_fieldDeclaration2215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_variableDeclarator2235 = new BitSet(new long[]{0x0000004000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_variableDeclarator2246 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_variableDeclarator2248 = new BitSet(new long[]{0x0000004000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_EQ_in_variableDeclarator2270 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1872L});
    public static final BitSet FOLLOW_variableInitializer_in_variableDeclarator2272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceFieldDeclaration_in_interfaceBodyDeclaration2311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceMethodDeclaration_in_interfaceBodyDeclaration2321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceDeclaration_in_interfaceBodyDeclaration2331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classDeclaration_in_interfaceBodyDeclaration2341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_interfaceBodyDeclaration2351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_interfaceMethodDeclaration2371 = new BitSet(new long[]{0x0840400100214000L,0x0008000020000090L});
    public static final BitSet FOLLOW_typeParameters_in_interfaceMethodDeclaration2382 = new BitSet(new long[]{0x0840400100214000L,0x0008000020000010L});
    public static final BitSet FOLLOW_type_in_interfaceMethodDeclaration2404 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_VOID_in_interfaceMethodDeclaration2415 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_interfaceMethodDeclaration2435 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_formalParameters_in_interfaceMethodDeclaration2445 = new BitSet(new long[]{0x0000000000000000L,0x0000400010000004L});
    public static final BitSet FOLLOW_LBRACKET_in_interfaceMethodDeclaration2456 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_interfaceMethodDeclaration2458 = new BitSet(new long[]{0x0000000000000000L,0x0000400010000004L});
    public static final BitSet FOLLOW_THROWS_in_interfaceMethodDeclaration2480 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_qualifiedNameList_in_interfaceMethodDeclaration2482 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_interfaceMethodDeclaration2495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_interfaceFieldDeclaration2517 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_interfaceFieldDeclaration2519 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_variableDeclarator_in_interfaceFieldDeclaration2521 = new BitSet(new long[]{0x0000000002000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_COMMA_in_interfaceFieldDeclaration2532 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_variableDeclarator_in_interfaceFieldDeclaration2534 = new BitSet(new long[]{0x0000000002000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_interfaceFieldDeclaration2555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_type2576 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_type2587 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_type2589 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_primitiveType_in_type2610 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_type2621 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_type2623 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_classOrInterfaceType2655 = new BitSet(new long[]{0x0000000080000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_typeArguments_in_classOrInterfaceType2666 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_DOT_in_classOrInterfaceType2688 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_classOrInterfaceType2690 = new BitSet(new long[]{0x0000000080000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_typeArguments_in_classOrInterfaceType2705 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_LT_in_typeArguments2842 = new BitSet(new long[]{0x0840400100214000L,0x0000000020800010L});
    public static final BitSet FOLLOW_typeArgument_in_typeArguments2844 = new BitSet(new long[]{0x0008000002000000L});
    public static final BitSet FOLLOW_COMMA_in_typeArguments2855 = new BitSet(new long[]{0x0840400100214000L,0x0000000020800010L});
    public static final BitSet FOLLOW_typeArgument_in_typeArguments2857 = new BitSet(new long[]{0x0008000002000000L});
    public static final BitSet FOLLOW_GT_in_typeArguments2879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typeArgument2899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUES_in_typeArgument2909 = new BitSet(new long[]{0x0000010000000002L,0x0000010000000000L});
    public static final BitSet FOLLOW_set_in_typeArgument2933 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_typeArgument2977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedName_in_qualifiedNameList3008 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_qualifiedNameList3019 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_qualifiedName_in_qualifiedNameList3021 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_LPAREN_in_formalParameters3052 = new BitSet(new long[]{0x0840500100214000L,0x0000000028000210L});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameters3063 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_formalParameters3085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ellipsisParameterDecl_in_formalParameterDecls3105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normalParameterDecl_in_formalParameterDecls3115 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_formalParameterDecls3126 = new BitSet(new long[]{0x0840500100214000L,0x0000000020000210L});
    public static final BitSet FOLLOW_normalParameterDecl_in_formalParameterDecls3128 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_normalParameterDecl_in_formalParameterDecls3150 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_COMMA_in_formalParameterDecls3160 = new BitSet(new long[]{0x0840500100214000L,0x0000000020000210L});
    public static final BitSet FOLLOW_ellipsisParameterDecl_in_formalParameterDecls3182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableModifiers_in_normalParameterDecl3202 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_normalParameterDecl3204 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_normalParameterDecl3206 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_normalParameterDecl3217 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_normalParameterDecl3219 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_variableModifiers_in_ellipsisParameterDecl3250 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_ellipsisParameterDecl3260 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_ELLIPSIS_in_ellipsisParameterDecl3263 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_ellipsisParameterDecl3273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nonWildcardTypeArguments_in_explicitConstructorInvocation3295 = new BitSet(new long[]{0x0000000000000000L,0x0000110000000000L});
    public static final BitSet FOLLOW_set_in_explicitConstructorInvocation3321 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_arguments_in_explicitConstructorInvocation3353 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_explicitConstructorInvocation3355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_explicitConstructorInvocation3366 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_DOT_in_explicitConstructorInvocation3376 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000080L});
    public static final BitSet FOLLOW_nonWildcardTypeArguments_in_explicitConstructorInvocation3387 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_SUPER_in_explicitConstructorInvocation3408 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_arguments_in_explicitConstructorInvocation3418 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_explicitConstructorInvocation3420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_qualifiedName3440 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_DOT_in_qualifiedName3451 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_qualifiedName3453 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_annotation_in_annotations3485 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_MONKEYS_AT_in_annotation3518 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_qualifiedName_in_annotation3520 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_LPAREN_in_annotation3534 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0280A1A72L});
    public static final BitSet FOLLOW_elementValuePairs_in_annotation3561 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_elementValue_in_annotation3585 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_annotation3621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs3653 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_elementValuePairs3664 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs3666 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_elementValuePair3697 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_EQ_in_elementValuePair3699 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1A72L});
    public static final BitSet FOLLOW_elementValue_in_elementValuePair3701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalExpression_in_elementValue3721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_elementValue3731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elementValueArrayInitializer_in_elementValue3741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_elementValueArrayInitializer3761 = new BitSet(new long[]{0x2840C80302614200L,0x000A91B0210A1A72L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer3772 = new BitSet(new long[]{0x0000000002000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_COMMA_in_elementValueArrayInitializer3787 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1A72L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer3789 = new BitSet(new long[]{0x0000000002000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_COMMA_in_elementValueArrayInitializer3818 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_RBRACE_in_elementValueArrayInitializer3822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_annotationTypeDeclaration3845 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_MONKEYS_AT_in_annotationTypeDeclaration3847 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_INTERFACE_in_annotationTypeDeclaration3857 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_annotationTypeDeclaration3867 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeBody_in_annotationTypeDeclaration3877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_annotationTypeBody3898 = new BitSet(new long[]{0x1840502100A14010L,0x0011040C31700610L});
    public static final BitSet FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody3910 = new BitSet(new long[]{0x1840502100A14010L,0x0011040C31700610L});
    public static final BitSet FOLLOW_RBRACE_in_annotationTypeBody3932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationMethodDeclaration_in_annotationTypeElementDeclaration3954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceFieldDeclaration_in_annotationTypeElementDeclaration3964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normalClassDeclaration_in_annotationTypeElementDeclaration3974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normalInterfaceDeclaration_in_annotationTypeElementDeclaration3984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumDeclaration_in_annotationTypeElementDeclaration3994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeDeclaration_in_annotationTypeElementDeclaration4004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_annotationTypeElementDeclaration4014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_annotationMethodDeclaration4034 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_annotationMethodDeclaration4036 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_annotationMethodDeclaration4038 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_LPAREN_in_annotationMethodDeclaration4048 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_annotationMethodDeclaration4050 = new BitSet(new long[]{0x0000000020000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_DEFAULT_in_annotationMethodDeclaration4053 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1A72L});
    public static final BitSet FOLLOW_elementValue_in_annotationMethodDeclaration4055 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_annotationMethodDeclaration4084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_block4108 = new BitSet(new long[]{0x38C1D82350E1C310L,0x003FB7BC357A1E72L});
    public static final BitSet FOLLOW_blockStatement_in_block4119 = new BitSet(new long[]{0x38C1D82350E1C310L,0x003FB7BC357A1E72L});
    public static final BitSet FOLLOW_RBRACE_in_block4140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localVariableDeclarationStatement_in_blockStatement4162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceDeclaration_in_blockStatement4172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_blockStatement4182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localVariableDeclaration_in_localVariableDeclarationStatement4203 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_localVariableDeclarationStatement4213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableModifiers_in_localVariableDeclaration4233 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_localVariableDeclaration4235 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_variableDeclarator_in_localVariableDeclaration4245 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_localVariableDeclaration4256 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_variableDeclarator_in_localVariableDeclaration4258 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_block_in_statement4289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSERT_in_statement4313 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_statement4333 = new BitSet(new long[]{0x0000000001000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_COLON_in_statement4336 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_statement4338 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_statement4342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSERT_in_statement4352 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_statement4355 = new BitSet(new long[]{0x0000000001000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_COLON_in_statement4358 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_statement4360 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_statement4364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_statement4386 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_parExpression_in_statement4388 = new BitSet(new long[]{0x28C1C8035061C300L,0x002EB7B0340A1872L});
    public static final BitSet FOLLOW_statement_in_statement4390 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_ELSE_in_statement4393 = new BitSet(new long[]{0x28C1C8035061C300L,0x002EB7B0340A1872L});
    public static final BitSet FOLLOW_statement_in_statement4395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forstatement_in_statement4417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_in_statement4427 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_parExpression_in_statement4429 = new BitSet(new long[]{0x28C1C8035061C300L,0x002EB7B0340A1872L});
    public static final BitSet FOLLOW_statement_in_statement4431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DO_in_statement4441 = new BitSet(new long[]{0x28C1C8035061C300L,0x002EB7B0340A1872L});
    public static final BitSet FOLLOW_statement_in_statement4443 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_WHILE_in_statement4445 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_parExpression_in_statement4447 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_statement4449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_trystatement_in_statement4459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SWITCH_in_statement4469 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_parExpression_in_statement4471 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_statement4473 = new BitSet(new long[]{0x0000000020080000L,0x0000000001000000L});
    public static final BitSet FOLLOW_switchBlockStatementGroups_in_statement4475 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_RBRACE_in_statement4477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYNCHRONIZED_in_statement4487 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_parExpression_in_statement4489 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_statement4491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_in_statement4501 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0300A1870L});
    public static final BitSet FOLLOW_expression_in_statement4504 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_statement4509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROW_in_statement4519 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_statement4521 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_statement4523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BREAK_in_statement4533 = new BitSet(new long[]{0x0040000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_statement4548 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_statement4565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONTINUE_in_statement4575 = new BitSet(new long[]{0x0040000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_statement4590 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_statement4607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_statement4617 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_statement4620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_statement4635 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_COLON_in_statement4637 = new BitSet(new long[]{0x28C1C8035061C300L,0x002EB7B0340A1872L});
    public static final BitSet FOLLOW_statement_in_statement4639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_statement4649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_switchBlockStatementGroup_in_switchBlockStatementGroups4671 = new BitSet(new long[]{0x0000000020080002L});
    public static final BitSet FOLLOW_switchLabel_in_switchBlockStatementGroup4700 = new BitSet(new long[]{0x38C1D82350E1C312L,0x003FB7BC347A1E72L});
    public static final BitSet FOLLOW_blockStatement_in_switchBlockStatementGroup4711 = new BitSet(new long[]{0x38C1D82350E1C312L,0x003FB7BC347A1E72L});
    public static final BitSet FOLLOW_CASE_in_switchLabel4742 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_switchLabel4744 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_COLON_in_switchLabel4746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFAULT_in_switchLabel4756 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_COLON_in_switchLabel4758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRY_in_trystatement4779 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_trystatement4781 = new BitSet(new long[]{0x0000200000100000L});
    public static final BitSet FOLLOW_catches_in_trystatement4795 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_FINALLY_in_trystatement4797 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_trystatement4799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_catches_in_trystatement4813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FINALLY_in_trystatement4827 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_trystatement4829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_catchClause_in_catches4860 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_catchClause_in_catches4871 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_CATCH_in_catchClause4902 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_LPAREN_in_catchClause4904 = new BitSet(new long[]{0x0840500100214000L,0x0000000020000210L});
    public static final BitSet FOLLOW_formalParameter_in_catchClause4906 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_catchClause4916 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_catchClause4918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableModifiers_in_formalParameter4939 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_formalParameter4941 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_formalParameter4943 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_formalParameter4954 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_formalParameter4956 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_FOR_in_forstatement5005 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_LPAREN_in_forstatement5007 = new BitSet(new long[]{0x0840500100214000L,0x0000000020000210L});
    public static final BitSet FOLLOW_variableModifiers_in_forstatement5009 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_forstatement5011 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_forstatement5013 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_COLON_in_forstatement5015 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_forstatement5026 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_forstatement5028 = new BitSet(new long[]{0x28C1C8035061C300L,0x002EB7B0340A1872L});
    public static final BitSet FOLLOW_statement_in_forstatement5030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_forstatement5062 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_LPAREN_in_forstatement5064 = new BitSet(new long[]{0x2840D80300614200L,0x000A91B0300A1A70L});
    public static final BitSet FOLLOW_forInit_in_forstatement5084 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_forstatement5105 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0300A1870L});
    public static final BitSet FOLLOW_expression_in_forstatement5125 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_forstatement5146 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0280A1870L});
    public static final BitSet FOLLOW_expressionList_in_forstatement5166 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_forstatement5187 = new BitSet(new long[]{0x28C1C8035061C300L,0x002EB7B0340A1872L});
    public static final BitSet FOLLOW_statement_in_forstatement5189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localVariableDeclaration_in_forInit5209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionList_in_forInit5219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_parExpression5239 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_parExpression5241 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_parExpression5243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_expressionList5263 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_expressionList5274 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_expressionList5276 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_conditionalExpression_in_expression5308 = new BitSet(new long[]{0x0008004000042082L,0x0000004280050080L});
    public static final BitSet FOLLOW_assignmentOperator_in_expression5319 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_expression5321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQ_in_assignmentOperator5353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUSEQ_in_assignmentOperator5363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUBEQ_in_assignmentOperator5373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAREQ_in_assignmentOperator5383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SLASHEQ_in_assignmentOperator5393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AMPEQ_in_assignmentOperator5403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAREQ_in_assignmentOperator5413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CARETEQ_in_assignmentOperator5423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERCENTEQ_in_assignmentOperator5433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_assignmentOperator5444 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_LT_in_assignmentOperator5446 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_EQ_in_assignmentOperator5448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_assignmentOperator5459 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_GT_in_assignmentOperator5461 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_GT_in_assignmentOperator5463 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_EQ_in_assignmentOperator5465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_assignmentOperator5476 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_GT_in_assignmentOperator5478 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_EQ_in_assignmentOperator5480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalOrExpression_in_conditionalExpression5501 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_QUES_in_conditionalExpression5512 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_conditionalExpression5514 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_COLON_in_conditionalExpression5516 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_conditionalExpression_in_conditionalExpression5518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalAndExpression_in_conditionalOrExpression5549 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_BARBAR_in_conditionalOrExpression5560 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_conditionalAndExpression_in_conditionalOrExpression5562 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_inclusiveOrExpression_in_conditionalAndExpression5593 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_AMPAMP_in_conditionalAndExpression5604 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_inclusiveOrExpression_in_conditionalAndExpression5606 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression5637 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_BAR_in_inclusiveOrExpression5648 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression5650 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_andExpression_in_exclusiveOrExpression5681 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_CARET_in_exclusiveOrExpression5692 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_andExpression_in_exclusiveOrExpression5694 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_equalityExpression_in_andExpression5725 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_AMP_in_andExpression5736 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_equalityExpression_in_andExpression5738 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_instanceOfExpression_in_equalityExpression5769 = new BitSet(new long[]{0x0000008000000402L});
    public static final BitSet FOLLOW_set_in_equalityExpression5796 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_instanceOfExpression_in_equalityExpression5846 = new BitSet(new long[]{0x0000008000000402L});
    public static final BitSet FOLLOW_relationalExpression_in_instanceOfExpression5877 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_INSTANCEOF_in_instanceOfExpression5888 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_instanceOfExpression5890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpression5921 = new BitSet(new long[]{0x0008000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_relationalOp_in_relationalExpression5932 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpression5934 = new BitSet(new long[]{0x0008000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_LT_in_relationalOp5966 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_EQ_in_relationalOp5968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_relationalOp5979 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_EQ_in_relationalOp5981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_relationalOp5991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_relationalOp6001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_additiveExpression_in_shiftExpression6021 = new BitSet(new long[]{0x0008000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_shiftOp_in_shiftExpression6032 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_additiveExpression_in_shiftExpression6034 = new BitSet(new long[]{0x0008000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_LT_in_shiftOp6067 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_LT_in_shiftOp6069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_shiftOp6080 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_GT_in_shiftOp6082 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_GT_in_shiftOp6084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_shiftOp6095 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_GT_in_shiftOp6097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression6118 = new BitSet(new long[]{0x0000000000000002L,0x0000002000020000L});
    public static final BitSet FOLLOW_set_in_additiveExpression6145 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression6195 = new BitSet(new long[]{0x0000000000000002L,0x0000002000020000L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression6233 = new BitSet(new long[]{0x0000000000000002L,0x0000000140008000L});
    public static final BitSet FOLLOW_set_in_multiplicativeExpression6260 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression6328 = new BitSet(new long[]{0x0000000000000002L,0x0000000140008000L});
    public static final BitSet FOLLOW_PLUS_in_unaryExpression6361 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression6364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUB_in_unaryExpression6374 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression6376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUSPLUS_in_unaryExpression6386 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression6388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUBSUB_in_unaryExpression6398 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression6400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryExpressionNotPlusMinus_in_unaryExpression6410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TILDE_in_unaryExpressionNotPlusMinus6430 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus6432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BANG_in_unaryExpressionNotPlusMinus6442 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus6444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_castExpression_in_unaryExpressionNotPlusMinus6454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unaryExpressionNotPlusMinus6464 = new BitSet(new long[]{0x0000000080000002L,0x0000008000080004L});
    public static final BitSet FOLLOW_selector_in_unaryExpressionNotPlusMinus6475 = new BitSet(new long[]{0x0000000080000002L,0x0000008000080004L});
    public static final BitSet FOLLOW_LPAREN_in_castExpression6545 = new BitSet(new long[]{0x0800400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_primitiveType_in_castExpression6547 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_castExpression6549 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_unaryExpression_in_castExpression6551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_castExpression6561 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_castExpression6563 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_castExpression6565 = new BitSet(new long[]{0x2840C80300614200L,0x000A911020001870L});
    public static final BitSet FOLLOW_unaryExpressionNotPlusMinus_in_castExpression6567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parExpression_in_primary6589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THIS_in_primary6615 = new BitSet(new long[]{0x0000000080000002L,0x0000000000000044L});
    public static final BitSet FOLLOW_DOT_in_primary6626 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primary6632 = new BitSet(new long[]{0x0000000080000002L,0x0000000000000044L});
    public static final BitSet FOLLOW_identifierSuffix_in_primary6654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primary6681 = new BitSet(new long[]{0x0000000080000002L,0x0000000000000044L});
    public static final BitSet FOLLOW_DOT_in_primary6692 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primary6698 = new BitSet(new long[]{0x0000000080000002L,0x0000000000000044L});
    public static final BitSet FOLLOW_identifierSuffix_in_primary6720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUPER_in_primary6743 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_superSuffix_in_primary6753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_primary6763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_creator_in_primary6773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveType_in_primary6783 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_primary6794 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_primary6796 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_DOT_in_primary6817 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_CLASS_in_primary6819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VOID_in_primary6829 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_DOT_in_primary6831 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_CLASS_in_primary6833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arguments_in_superSuffix6859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_superSuffix6869 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_typeArguments_in_superSuffix6872 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_superSuffix6893 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_arguments_in_superSuffix6904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_identifierSuffix6936 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_identifierSuffix6938 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_DOT_in_identifierSuffix6959 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_CLASS_in_identifierSuffix6961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_identifierSuffix6972 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_identifierSuffix6974 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_identifierSuffix6976 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_arguments_in_identifierSuffix6997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_identifierSuffix7007 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_CLASS_in_identifierSuffix7009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_identifierSuffix7019 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_nonWildcardTypeArguments_in_identifierSuffix7021 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_identifierSuffix7023 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_arguments_in_identifierSuffix7025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_identifierSuffix7035 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_THIS_in_identifierSuffix7037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_identifierSuffix7047 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_SUPER_in_identifierSuffix7049 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_arguments_in_identifierSuffix7051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_innerCreator_in_identifierSuffix7061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_selector7083 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_selector7085 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_arguments_in_selector7096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_selector7117 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_THIS_in_selector7119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_selector7129 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_SUPER_in_selector7131 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_superSuffix_in_selector7141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_innerCreator_in_selector7151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_selector7161 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_selector7163 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_selector7165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_creator7185 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_nonWildcardTypeArguments_in_creator7187 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_creator7189 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_classCreatorRest_in_creator7191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_creator7201 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_creator7203 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_classCreatorRest_in_creator7205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayCreator_in_creator7215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_arrayCreator7235 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_createdName_in_arrayCreator7237 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_arrayCreator7247 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_arrayCreator7249 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_LBRACKET_in_arrayCreator7260 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_arrayCreator7262 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_arrayInitializer_in_arrayCreator7283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_arrayCreator7294 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_createdName_in_arrayCreator7296 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_arrayCreator7306 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_arrayCreator7308 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_arrayCreator7318 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_arrayCreator7332 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_arrayCreator7334 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_arrayCreator7348 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_arrayCreator7370 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_arrayCreator7372 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_arrayInitializer_in_variableInitializer7403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_variableInitializer7413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_arrayInitializer7433 = new BitSet(new long[]{0x2840C80302614200L,0x000A91B0210A1872L});
    public static final BitSet FOLLOW_variableInitializer_in_arrayInitializer7449 = new BitSet(new long[]{0x0000000002000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_COMMA_in_arrayInitializer7468 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1872L});
    public static final BitSet FOLLOW_variableInitializer_in_arrayInitializer7470 = new BitSet(new long[]{0x0000000002000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_COMMA_in_arrayInitializer7520 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_RBRACE_in_arrayInitializer7533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_createdName7567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveType_in_createdName7577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_innerCreator7598 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_NEW_in_innerCreator7600 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_nonWildcardTypeArguments_in_innerCreator7611 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_innerCreator7632 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_typeArguments_in_innerCreator7643 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_classCreatorRest_in_innerCreator7664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arguments_in_classCreatorRest7685 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_classBody_in_classCreatorRest7696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_nonWildcardTypeArguments7728 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_typeList_in_nonWildcardTypeArguments7730 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_GT_in_nonWildcardTypeArguments7740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_arguments7760 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0280A1870L});
    public static final BitSet FOLLOW_expressionList_in_arguments7763 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_arguments7776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_classHeader7900 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_CLASS_in_classHeader7902 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_classHeader7904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_enumHeader7924 = new BitSet(new long[]{0x0040002000000000L});
    public static final BitSet FOLLOW_set_in_enumHeader7926 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_enumHeader7932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_interfaceHeader7952 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_INTERFACE_in_interfaceHeader7954 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_interfaceHeader7956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_annotationHeader7976 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_MONKEYS_AT_in_annotationHeader7978 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_INTERFACE_in_annotationHeader7980 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_annotationHeader7982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_typeHeader8002 = new BitSet(new long[]{0x1000002000800000L,0x0000000000000200L});
    public static final BitSet FOLLOW_CLASS_in_typeHeader8005 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ENUM_in_typeHeader8007 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_MONKEYS_AT_in_typeHeader8010 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_INTERFACE_in_typeHeader8014 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_typeHeader8018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_methodHeader8038 = new BitSet(new long[]{0x0840400100214000L,0x0008000020000090L});
    public static final BitSet FOLLOW_typeParameters_in_methodHeader8040 = new BitSet(new long[]{0x0840400100214000L,0x0008000020000010L});
    public static final BitSet FOLLOW_type_in_methodHeader8044 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_VOID_in_methodHeader8046 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_methodHeader8050 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_LPAREN_in_methodHeader8052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_fieldHeader8072 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_fieldHeader8074 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_fieldHeader8076 = new BitSet(new long[]{0x0000004002000000L,0x0000000010000004L});
    public static final BitSet FOLLOW_LBRACKET_in_fieldHeader8079 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_fieldHeader8080 = new BitSet(new long[]{0x0000004002000000L,0x0000000010000004L});
    public static final BitSet FOLLOW_set_in_fieldHeader8084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableModifiers_in_localVariableHeader8110 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_localVariableHeader8112 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_localVariableHeader8114 = new BitSet(new long[]{0x0000004002000000L,0x0000000010000004L});
    public static final BitSet FOLLOW_LBRACKET_in_localVariableHeader8117 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_localVariableHeader8118 = new BitSet(new long[]{0x0000004002000000L,0x0000000010000004L});
    public static final BitSet FOLLOW_set_in_localVariableHeader8122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotations_in_synpred2_NoDynamicLoadingANTLR101 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_packageDeclaration_in_synpred2_NoDynamicLoadingANTLR130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classDeclaration_in_synpred12_NoDynamicLoadingANTLR488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normalClassDeclaration_in_synpred27_NoDynamicLoadingANTLR725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normalInterfaceDeclaration_in_synpred43_NoDynamicLoadingANTLR1404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fieldDeclaration_in_synpred52_NoDynamicLoadingANTLR1734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_methodDeclaration_in_synpred53_NoDynamicLoadingANTLR1745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classDeclaration_in_synpred54_NoDynamicLoadingANTLR1756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_explicitConstructorInvocation_in_synpred57_NoDynamicLoadingANTLR1893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_synpred59_NoDynamicLoadingANTLR1805 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_typeParameters_in_synpred59_NoDynamicLoadingANTLR1816 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred59_NoDynamicLoadingANTLR1837 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_formalParameters_in_synpred59_NoDynamicLoadingANTLR1847 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000002L});
    public static final BitSet FOLLOW_THROWS_in_synpred59_NoDynamicLoadingANTLR1858 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_qualifiedNameList_in_synpred59_NoDynamicLoadingANTLR1860 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_synpred59_NoDynamicLoadingANTLR1881 = new BitSet(new long[]{0x38C1D82350E1C310L,0x003FB7BC357A1EF2L});
    public static final BitSet FOLLOW_explicitConstructorInvocation_in_synpred59_NoDynamicLoadingANTLR1893 = new BitSet(new long[]{0x38C1D82350E1C310L,0x003FB7BC357A1E72L});
    public static final BitSet FOLLOW_blockStatement_in_synpred59_NoDynamicLoadingANTLR1915 = new BitSet(new long[]{0x38C1D82350E1C310L,0x003FB7BC357A1E72L});
    public static final BitSet FOLLOW_RBRACE_in_synpred59_NoDynamicLoadingANTLR1936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceFieldDeclaration_in_synpred68_NoDynamicLoadingANTLR2311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceMethodDeclaration_in_synpred69_NoDynamicLoadingANTLR2321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceDeclaration_in_synpred70_NoDynamicLoadingANTLR2331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classDeclaration_in_synpred71_NoDynamicLoadingANTLR2341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ellipsisParameterDecl_in_synpred96_NoDynamicLoadingANTLR3105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normalParameterDecl_in_synpred98_NoDynamicLoadingANTLR3115 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_synpred98_NoDynamicLoadingANTLR3126 = new BitSet(new long[]{0x0840500100214000L,0x0000000020000210L});
    public static final BitSet FOLLOW_normalParameterDecl_in_synpred98_NoDynamicLoadingANTLR3128 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_normalParameterDecl_in_synpred99_NoDynamicLoadingANTLR3150 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_COMMA_in_synpred99_NoDynamicLoadingANTLR3160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nonWildcardTypeArguments_in_synpred103_NoDynamicLoadingANTLR3295 = new BitSet(new long[]{0x0000000000000000L,0x0000110000000000L});
    public static final BitSet FOLLOW_set_in_synpred103_NoDynamicLoadingANTLR3321 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_arguments_in_synpred103_NoDynamicLoadingANTLR3353 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_synpred103_NoDynamicLoadingANTLR3355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationMethodDeclaration_in_synpred117_NoDynamicLoadingANTLR3954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceFieldDeclaration_in_synpred118_NoDynamicLoadingANTLR3964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normalClassDeclaration_in_synpred119_NoDynamicLoadingANTLR3974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normalInterfaceDeclaration_in_synpred120_NoDynamicLoadingANTLR3984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumDeclaration_in_synpred121_NoDynamicLoadingANTLR3994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeDeclaration_in_synpred122_NoDynamicLoadingANTLR4004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localVariableDeclarationStatement_in_synpred125_NoDynamicLoadingANTLR4162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceDeclaration_in_synpred126_NoDynamicLoadingANTLR4172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSERT_in_synpred130_NoDynamicLoadingANTLR4313 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_synpred130_NoDynamicLoadingANTLR4333 = new BitSet(new long[]{0x0000000001000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_COLON_in_synpred130_NoDynamicLoadingANTLR4336 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_synpred130_NoDynamicLoadingANTLR4338 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_synpred130_NoDynamicLoadingANTLR4342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSERT_in_synpred132_NoDynamicLoadingANTLR4352 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_synpred132_NoDynamicLoadingANTLR4355 = new BitSet(new long[]{0x0000000001000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_COLON_in_synpred132_NoDynamicLoadingANTLR4358 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_synpred132_NoDynamicLoadingANTLR4360 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_synpred132_NoDynamicLoadingANTLR4364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_in_synpred133_NoDynamicLoadingANTLR4393 = new BitSet(new long[]{0x28C1C8035061C300L,0x002EB7B0340A1872L});
    public static final BitSet FOLLOW_statement_in_synpred133_NoDynamicLoadingANTLR4395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred148_NoDynamicLoadingANTLR4617 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_synpred148_NoDynamicLoadingANTLR4620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred149_NoDynamicLoadingANTLR4635 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_COLON_in_synpred149_NoDynamicLoadingANTLR4637 = new BitSet(new long[]{0x28C1C8035061C300L,0x002EB7B0340A1872L});
    public static final BitSet FOLLOW_statement_in_synpred149_NoDynamicLoadingANTLR4639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_catches_in_synpred153_NoDynamicLoadingANTLR4795 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_FINALLY_in_synpred153_NoDynamicLoadingANTLR4797 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_synpred153_NoDynamicLoadingANTLR4799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_catches_in_synpred154_NoDynamicLoadingANTLR4813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_synpred157_NoDynamicLoadingANTLR5005 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_LPAREN_in_synpred157_NoDynamicLoadingANTLR5007 = new BitSet(new long[]{0x0840500100214000L,0x0000000020000210L});
    public static final BitSet FOLLOW_variableModifiers_in_synpred157_NoDynamicLoadingANTLR5009 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_synpred157_NoDynamicLoadingANTLR5011 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred157_NoDynamicLoadingANTLR5013 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_COLON_in_synpred157_NoDynamicLoadingANTLR5015 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_synpred157_NoDynamicLoadingANTLR5026 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_synpred157_NoDynamicLoadingANTLR5028 = new BitSet(new long[]{0x28C1C8035061C300L,0x002EB7B0340A1872L});
    public static final BitSet FOLLOW_statement_in_synpred157_NoDynamicLoadingANTLR5030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localVariableDeclaration_in_synpred161_NoDynamicLoadingANTLR5209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_castExpression_in_synpred202_NoDynamicLoadingANTLR6454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_synpred206_NoDynamicLoadingANTLR6545 = new BitSet(new long[]{0x0800400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_primitiveType_in_synpred206_NoDynamicLoadingANTLR6547 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_synpred206_NoDynamicLoadingANTLR6549 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_unaryExpression_in_synpred206_NoDynamicLoadingANTLR6551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_synpred208_NoDynamicLoadingANTLR6626 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred208_NoDynamicLoadingANTLR6632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierSuffix_in_synpred209_NoDynamicLoadingANTLR6654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_synpred211_NoDynamicLoadingANTLR6692 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred211_NoDynamicLoadingANTLR6698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierSuffix_in_synpred212_NoDynamicLoadingANTLR6720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred224_NoDynamicLoadingANTLR6972 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_synpred224_NoDynamicLoadingANTLR6974 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_synpred224_NoDynamicLoadingANTLR6976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_synpred236_NoDynamicLoadingANTLR7185 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_nonWildcardTypeArguments_in_synpred236_NoDynamicLoadingANTLR7187 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_synpred236_NoDynamicLoadingANTLR7189 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_classCreatorRest_in_synpred236_NoDynamicLoadingANTLR7191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_synpred237_NoDynamicLoadingANTLR7201 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_synpred237_NoDynamicLoadingANTLR7203 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_classCreatorRest_in_synpred237_NoDynamicLoadingANTLR7205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_synpred239_NoDynamicLoadingANTLR7235 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_createdName_in_synpred239_NoDynamicLoadingANTLR7237 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred239_NoDynamicLoadingANTLR7247 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_synpred239_NoDynamicLoadingANTLR7249 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred239_NoDynamicLoadingANTLR7260 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_synpred239_NoDynamicLoadingANTLR7262 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_arrayInitializer_in_synpred239_NoDynamicLoadingANTLR7283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred240_NoDynamicLoadingANTLR7332 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_synpred240_NoDynamicLoadingANTLR7334 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_synpred240_NoDynamicLoadingANTLR7348 = new BitSet(new long[]{0x0000000000000002L});

}