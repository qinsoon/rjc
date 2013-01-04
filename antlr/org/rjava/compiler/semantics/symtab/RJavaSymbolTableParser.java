// $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g 2013-01-04 11:46:40

package org.rjava.compiler.semantics.symtab;
import org.rjava.compiler.semantics.representation.*;
import org.rjava.compiler.semantics.symtab.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class RJavaSymbolTableParser extends Parser {
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


    public RJavaSymbolTableParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public RJavaSymbolTableParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.ruleMemo = new HashMap[381+1];
         

    }

    public String[] getTokenNames() { return RJavaSymbolTableParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g"; }


      private RClass klass;
      private String type;
      public void setClass(RClass klass) {
        this.klass = klass;
      }



    // $ANTLR start "compilationUnit"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:27:1: compilationUnit : ( ( annotations )? packageDeclaration )? ( importDeclaration )* ( typeDeclaration )* ;
    public final void compilationUnit() throws RecognitionException {
        int compilationUnit_StartIndex = input.index();

        RJavaSymbolTableParser.importDeclaration_return importDeclaration1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:28:5: ( ( ( annotations )? packageDeclaration )? ( importDeclaration )* ( typeDeclaration )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:28:9: ( ( annotations )? packageDeclaration )? ( importDeclaration )* ( typeDeclaration )*
            {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:28:9: ( ( annotations )? packageDeclaration )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==MONKEYS_AT) ) {
                int LA2_1 = input.LA(2);

                if ( (synpred2_RJavaSymbolTable()) ) {
                    alt2=1;
                }
            }
            else if ( (LA2_0==PACKAGE) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:28:13: ( annotations )? packageDeclaration
                    {
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:28:13: ( annotations )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==MONKEYS_AT) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:28:14: annotations
                            {
                            pushFollow(FOLLOW_annotations_in_compilationUnit75);
                            annotations();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    pushFollow(FOLLOW_packageDeclaration_in_compilationUnit104);
                    packageDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:32:9: ( importDeclaration )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==IMPORT) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:32:10: importDeclaration
            	    {
            	    pushFollow(FOLLOW_importDeclaration_in_compilationUnit126);
            	    importDeclaration1=importDeclaration();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    if ( state.backtracking==0 ) {klass.addNewImport((importDeclaration1!=null?input.toString(importDeclaration1.start,importDeclaration1.stop):null));}

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:34:9: ( typeDeclaration )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==ABSTRACT||LA4_0==BOOLEAN||LA4_0==BYTE||LA4_0==CHAR||LA4_0==CLASS||LA4_0==DOUBLE||LA4_0==ENUM||LA4_0==FINAL||LA4_0==FLOAT||LA4_0==IDENTIFIER||(LA4_0 >= INT && LA4_0 <= INTERFACE)||LA4_0==LONG||LA4_0==LT||(LA4_0 >= MONKEYS_AT && LA4_0 <= NATIVE)||(LA4_0 >= PRIVATE && LA4_0 <= PUBLIC)||(LA4_0 >= SEMI && LA4_0 <= SHORT)||(LA4_0 >= STATIC && LA4_0 <= STRICTFP)||LA4_0==SYNCHRONIZED||LA4_0==TRANSIENT||(LA4_0 >= VOID && LA4_0 <= VOLATILE)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:34:10: typeDeclaration
            	    {
            	    pushFollow(FOLLOW_typeDeclaration_in_compilationUnit150);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:38:1: packageDeclaration : 'package' qualifiedName ';' ;
    public final void packageDeclaration() throws RecognitionException {
        int packageDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:39:5: ( 'package' qualifiedName ';' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:39:9: 'package' qualifiedName ';'
            {
            match(input,PACKAGE,FOLLOW_PACKAGE_in_packageDeclaration181); if (state.failed) return ;

            pushFollow(FOLLOW_qualifiedName_in_packageDeclaration183);
            qualifiedName();

            state._fsp--;
            if (state.failed) return ;

            match(input,SEMI,FOLLOW_SEMI_in_packageDeclaration193); if (state.failed) return ;

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


    public static class importDeclaration_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "importDeclaration"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:43:1: importDeclaration : ( 'import' ( 'static' )? IDENTIFIER '.' '*' ';' | 'import' ( 'static' )? IDENTIFIER ( '.' IDENTIFIER )+ ( '.' '*' )? ';' );
    public final RJavaSymbolTableParser.importDeclaration_return importDeclaration() throws RecognitionException {
        RJavaSymbolTableParser.importDeclaration_return retval = new RJavaSymbolTableParser.importDeclaration_return();
        retval.start = input.LT(1);

        int importDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:44:5: ( 'import' ( 'static' )? IDENTIFIER '.' '*' ';' | 'import' ( 'static' )? IDENTIFIER ( '.' IDENTIFIER )+ ( '.' '*' )? ';' )
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
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 9, 4, input);

                                throw nvae;

                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 3, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
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
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 4, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 3, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:44:9: 'import' ( 'static' )? IDENTIFIER '.' '*' ';'
                    {
                    match(input,IMPORT,FOLLOW_IMPORT_in_importDeclaration215); if (state.failed) return retval;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:45:9: ( 'static' )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==STATIC) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:45:10: 'static'
                            {
                            match(input,STATIC,FOLLOW_STATIC_in_importDeclaration227); if (state.failed) return retval;

                            }
                            break;

                    }


                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_importDeclaration248); if (state.failed) return retval;

                    match(input,DOT,FOLLOW_DOT_in_importDeclaration250); if (state.failed) return retval;

                    match(input,STAR,FOLLOW_STAR_in_importDeclaration252); if (state.failed) return retval;

                    match(input,SEMI,FOLLOW_SEMI_in_importDeclaration262); if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:49:9: 'import' ( 'static' )? IDENTIFIER ( '.' IDENTIFIER )+ ( '.' '*' )? ';'
                    {
                    match(input,IMPORT,FOLLOW_IMPORT_in_importDeclaration279); if (state.failed) return retval;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:50:9: ( 'static' )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==STATIC) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:50:10: 'static'
                            {
                            match(input,STATIC,FOLLOW_STATIC_in_importDeclaration291); if (state.failed) return retval;

                            }
                            break;

                    }


                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_importDeclaration312); if (state.failed) return retval;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:53:9: ( '.' IDENTIFIER )+
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
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:53:10: '.' IDENTIFIER
                    	    {
                    	    match(input,DOT,FOLLOW_DOT_in_importDeclaration323); if (state.failed) return retval;

                    	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_importDeclaration325); if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);


                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:55:9: ( '.' '*' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==DOT) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:55:10: '.' '*'
                            {
                            match(input,DOT,FOLLOW_DOT_in_importDeclaration347); if (state.failed) return retval;

                            match(input,STAR,FOLLOW_STAR_in_importDeclaration349); if (state.failed) return retval;

                            }
                            break;

                    }


                    match(input,SEMI,FOLLOW_SEMI_in_importDeclaration370); if (state.failed) return retval;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, importDeclaration_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "importDeclaration"



    // $ANTLR start "qualifiedImportName"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:60:1: qualifiedImportName : IDENTIFIER ( '.' IDENTIFIER )* ;
    public final void qualifiedImportName() throws RecognitionException {
        int qualifiedImportName_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:61:5: ( IDENTIFIER ( '.' IDENTIFIER )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:61:9: IDENTIFIER ( '.' IDENTIFIER )*
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_qualifiedImportName390); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:62:9: ( '.' IDENTIFIER )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==DOT) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:62:10: '.' IDENTIFIER
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_qualifiedImportName401); if (state.failed) return ;

            	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_qualifiedImportName403); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:66:1: typeDeclaration : ( classOrInterfaceDeclaration | ';' );
    public final void typeDeclaration() throws RecognitionException {
        int typeDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:67:5: ( classOrInterfaceDeclaration | ';' )
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:67:9: classOrInterfaceDeclaration
                    {
                    pushFollow(FOLLOW_classOrInterfaceDeclaration_in_typeDeclaration434);
                    classOrInterfaceDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:68:9: ';'
                    {
                    match(input,SEMI,FOLLOW_SEMI_in_typeDeclaration444); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:71:1: classOrInterfaceDeclaration : ( classDeclaration | interfaceDeclaration );
    public final void classOrInterfaceDeclaration() throws RecognitionException {
        int classOrInterfaceDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:72:5: ( classDeclaration | interfaceDeclaration )
            int alt12=2;
            switch ( input.LA(1) ) {
            case MONKEYS_AT:
                {
                int LA12_1 = input.LA(2);

                if ( (synpred12_RJavaSymbolTable()) ) {
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

                if ( (synpred12_RJavaSymbolTable()) ) {
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

                if ( (synpred12_RJavaSymbolTable()) ) {
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

                if ( (synpred12_RJavaSymbolTable()) ) {
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

                if ( (synpred12_RJavaSymbolTable()) ) {
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

                if ( (synpred12_RJavaSymbolTable()) ) {
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

                if ( (synpred12_RJavaSymbolTable()) ) {
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

                if ( (synpred12_RJavaSymbolTable()) ) {
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

                if ( (synpred12_RJavaSymbolTable()) ) {
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

                if ( (synpred12_RJavaSymbolTable()) ) {
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

                if ( (synpred12_RJavaSymbolTable()) ) {
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

                if ( (synpred12_RJavaSymbolTable()) ) {
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:72:10: classDeclaration
                    {
                    pushFollow(FOLLOW_classDeclaration_in_classOrInterfaceDeclaration465);
                    classDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:73:9: interfaceDeclaration
                    {
                    pushFollow(FOLLOW_interfaceDeclaration_in_classOrInterfaceDeclaration475);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:77:1: modifiers : ( annotation | 'public' | 'protected' | 'private' | 'static' | 'abstract' | 'final' | 'native' | 'synchronized' | 'transient' | 'volatile' | 'strictfp' )* ;
    public final void modifiers() throws RecognitionException {
        int modifiers_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:78:5: ( ( annotation | 'public' | 'protected' | 'private' | 'static' | 'abstract' | 'final' | 'native' | 'synchronized' | 'transient' | 'volatile' | 'strictfp' )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:79:5: ( annotation | 'public' | 'protected' | 'private' | 'static' | 'abstract' | 'final' | 'native' | 'synchronized' | 'transient' | 'volatile' | 'strictfp' )*
            {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:79:5: ( annotation | 'public' | 'protected' | 'private' | 'static' | 'abstract' | 'final' | 'native' | 'synchronized' | 'transient' | 'volatile' | 'strictfp' )*
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
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:79:10: annotation
            	    {
            	    pushFollow(FOLLOW_annotation_in_modifiers510);
            	    annotation();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:80:9: 'public'
            	    {
            	    match(input,PUBLIC,FOLLOW_PUBLIC_in_modifiers520); if (state.failed) return ;

            	    }
            	    break;
            	case 3 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:81:9: 'protected'
            	    {
            	    match(input,PROTECTED,FOLLOW_PROTECTED_in_modifiers530); if (state.failed) return ;

            	    }
            	    break;
            	case 4 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:82:9: 'private'
            	    {
            	    match(input,PRIVATE,FOLLOW_PRIVATE_in_modifiers540); if (state.failed) return ;

            	    }
            	    break;
            	case 5 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:83:9: 'static'
            	    {
            	    match(input,STATIC,FOLLOW_STATIC_in_modifiers550); if (state.failed) return ;

            	    }
            	    break;
            	case 6 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:84:9: 'abstract'
            	    {
            	    match(input,ABSTRACT,FOLLOW_ABSTRACT_in_modifiers560); if (state.failed) return ;

            	    }
            	    break;
            	case 7 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:85:9: 'final'
            	    {
            	    match(input,FINAL,FOLLOW_FINAL_in_modifiers570); if (state.failed) return ;

            	    }
            	    break;
            	case 8 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:86:9: 'native'
            	    {
            	    match(input,NATIVE,FOLLOW_NATIVE_in_modifiers580); if (state.failed) return ;

            	    }
            	    break;
            	case 9 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:87:9: 'synchronized'
            	    {
            	    match(input,SYNCHRONIZED,FOLLOW_SYNCHRONIZED_in_modifiers590); if (state.failed) return ;

            	    }
            	    break;
            	case 10 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:88:9: 'transient'
            	    {
            	    match(input,TRANSIENT,FOLLOW_TRANSIENT_in_modifiers600); if (state.failed) return ;

            	    }
            	    break;
            	case 11 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:89:9: 'volatile'
            	    {
            	    match(input,VOLATILE,FOLLOW_VOLATILE_in_modifiers610); if (state.failed) return ;

            	    }
            	    break;
            	case 12 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:90:9: 'strictfp'
            	    {
            	    match(input,STRICTFP,FOLLOW_STRICTFP_in_modifiers620); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:95:1: variableModifiers : ( 'final' | annotation )* ;
    public final void variableModifiers() throws RecognitionException {
        int variableModifiers_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:96:5: ( ( 'final' | annotation )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:96:9: ( 'final' | annotation )*
            {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:96:9: ( 'final' | annotation )*
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
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:96:13: 'final'
            	    {
            	    match(input,FINAL,FOLLOW_FINAL_in_variableModifiers652); if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:97:13: annotation
            	    {
            	    pushFollow(FOLLOW_annotation_in_variableModifiers666);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:102:1: classDeclaration : ( normalClassDeclaration | enumDeclaration );
    public final void classDeclaration() throws RecognitionException {
        int classDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:103:5: ( normalClassDeclaration | enumDeclaration )
            int alt15=2;
            switch ( input.LA(1) ) {
            case MONKEYS_AT:
                {
                int LA15_1 = input.LA(2);

                if ( (synpred27_RJavaSymbolTable()) ) {
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

                if ( (synpred27_RJavaSymbolTable()) ) {
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

                if ( (synpred27_RJavaSymbolTable()) ) {
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

                if ( (synpred27_RJavaSymbolTable()) ) {
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

                if ( (synpred27_RJavaSymbolTable()) ) {
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

                if ( (synpred27_RJavaSymbolTable()) ) {
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

                if ( (synpred27_RJavaSymbolTable()) ) {
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

                if ( (synpred27_RJavaSymbolTable()) ) {
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

                if ( (synpred27_RJavaSymbolTable()) ) {
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

                if ( (synpred27_RJavaSymbolTable()) ) {
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

                if ( (synpred27_RJavaSymbolTable()) ) {
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

                if ( (synpred27_RJavaSymbolTable()) ) {
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:103:9: normalClassDeclaration
                    {
                    pushFollow(FOLLOW_normalClassDeclaration_in_classDeclaration702);
                    normalClassDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:104:9: enumDeclaration
                    {
                    pushFollow(FOLLOW_enumDeclaration_in_classDeclaration712);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:107:1: normalClassDeclaration : modifiers 'class' IDENTIFIER ( typeParameters )? ( 'extends' type )? ( 'implements' typeList )? classBody ;
    public final void normalClassDeclaration() throws RecognitionException {
        int normalClassDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:108:5: ( modifiers 'class' IDENTIFIER ( typeParameters )? ( 'extends' type )? ( 'implements' typeList )? classBody )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:108:9: modifiers 'class' IDENTIFIER ( typeParameters )? ( 'extends' type )? ( 'implements' typeList )? classBody
            {
            pushFollow(FOLLOW_modifiers_in_normalClassDeclaration732);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            match(input,CLASS,FOLLOW_CLASS_in_normalClassDeclaration735); if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_normalClassDeclaration737); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:109:9: ( typeParameters )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==LT) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:109:10: typeParameters
                    {
                    pushFollow(FOLLOW_typeParameters_in_normalClassDeclaration748);
                    typeParameters();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:111:9: ( 'extends' type )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==EXTENDS) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:111:10: 'extends' type
                    {
                    match(input,EXTENDS,FOLLOW_EXTENDS_in_normalClassDeclaration770); if (state.failed) return ;

                    pushFollow(FOLLOW_type_in_normalClassDeclaration772);
                    type();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:113:9: ( 'implements' typeList )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==IMPLEMENTS) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:113:10: 'implements' typeList
                    {
                    match(input,IMPLEMENTS,FOLLOW_IMPLEMENTS_in_normalClassDeclaration794); if (state.failed) return ;

                    pushFollow(FOLLOW_typeList_in_normalClassDeclaration796);
                    typeList();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            pushFollow(FOLLOW_classBody_in_normalClassDeclaration829);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:119:1: typeParameters : '<' typeParameter ( ',' typeParameter )* '>' ;
    public final void typeParameters() throws RecognitionException {
        int typeParameters_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:120:5: ( '<' typeParameter ( ',' typeParameter )* '>' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:120:9: '<' typeParameter ( ',' typeParameter )* '>'
            {
            match(input,LT,FOLLOW_LT_in_typeParameters850); if (state.failed) return ;

            pushFollow(FOLLOW_typeParameter_in_typeParameters864);
            typeParameter();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:122:13: ( ',' typeParameter )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==COMMA) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:122:14: ',' typeParameter
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_typeParameters879); if (state.failed) return ;

            	    pushFollow(FOLLOW_typeParameter_in_typeParameters881);
            	    typeParameter();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            match(input,GT,FOLLOW_GT_in_typeParameters906); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:127:1: typeParameter : IDENTIFIER ( 'extends' typeBound )? ;
    public final void typeParameter() throws RecognitionException {
        int typeParameter_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:128:5: ( IDENTIFIER ( 'extends' typeBound )? )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:128:9: IDENTIFIER ( 'extends' typeBound )?
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_typeParameter926); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:129:9: ( 'extends' typeBound )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==EXTENDS) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:129:10: 'extends' typeBound
                    {
                    match(input,EXTENDS,FOLLOW_EXTENDS_in_typeParameter937); if (state.failed) return ;

                    pushFollow(FOLLOW_typeBound_in_typeParameter939);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:134:1: typeBound : type ( '&' type )* ;
    public final void typeBound() throws RecognitionException {
        int typeBound_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:135:5: ( type ( '&' type )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:135:9: type ( '&' type )*
            {
            pushFollow(FOLLOW_type_in_typeBound971);
            type();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:136:9: ( '&' type )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==AMP) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:136:10: '&' type
            	    {
            	    match(input,AMP,FOLLOW_AMP_in_typeBound982); if (state.failed) return ;

            	    pushFollow(FOLLOW_type_in_typeBound984);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:141:1: enumDeclaration : modifiers ( 'enum' ) IDENTIFIER ( 'implements' typeList )? enumBody ;
    public final void enumDeclaration() throws RecognitionException {
        int enumDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:142:5: ( modifiers ( 'enum' ) IDENTIFIER ( 'implements' typeList )? enumBody )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:142:9: modifiers ( 'enum' ) IDENTIFIER ( 'implements' typeList )? enumBody
            {
            pushFollow(FOLLOW_modifiers_in_enumDeclaration1016);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:143:9: ( 'enum' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:143:10: 'enum'
            {
            match(input,ENUM,FOLLOW_ENUM_in_enumDeclaration1028); if (state.failed) return ;

            }


            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enumDeclaration1049); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:146:9: ( 'implements' typeList )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==IMPLEMENTS) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:146:10: 'implements' typeList
                    {
                    match(input,IMPLEMENTS,FOLLOW_IMPLEMENTS_in_enumDeclaration1060); if (state.failed) return ;

                    pushFollow(FOLLOW_typeList_in_enumDeclaration1062);
                    typeList();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            pushFollow(FOLLOW_enumBody_in_enumDeclaration1083);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:152:1: enumBody : '{' ( enumConstants )? ( ',' )? ( enumBodyDeclarations )? '}' ;
    public final void enumBody() throws RecognitionException {
        int enumBody_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:153:5: ( '{' ( enumConstants )? ( ',' )? ( enumBodyDeclarations )? '}' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:153:9: '{' ( enumConstants )? ( ',' )? ( enumBodyDeclarations )? '}'
            {
            match(input,LBRACE,FOLLOW_LBRACE_in_enumBody1108); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:154:9: ( enumConstants )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==IDENTIFIER||LA23_0==MONKEYS_AT) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:154:10: enumConstants
                    {
                    pushFollow(FOLLOW_enumConstants_in_enumBody1119);
                    enumConstants();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:156:9: ( ',' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==COMMA) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:156:9: ','
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_enumBody1141); if (state.failed) return ;

                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:157:9: ( enumBodyDeclarations )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==SEMI) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:157:10: enumBodyDeclarations
                    {
                    pushFollow(FOLLOW_enumBodyDeclarations_in_enumBody1154);
                    enumBodyDeclarations();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            match(input,RBRACE,FOLLOW_RBRACE_in_enumBody1176); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:162:1: enumConstants : enumConstant ( ',' enumConstant )* ;
    public final void enumConstants() throws RecognitionException {
        int enumConstants_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:163:5: ( enumConstant ( ',' enumConstant )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:163:9: enumConstant ( ',' enumConstant )*
            {
            pushFollow(FOLLOW_enumConstant_in_enumConstants1196);
            enumConstant();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:164:9: ( ',' enumConstant )*
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
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:164:10: ',' enumConstant
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_enumConstants1207); if (state.failed) return ;

            	    pushFollow(FOLLOW_enumConstant_in_enumConstants1209);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:172:1: enumConstant : ( annotations )? IDENTIFIER ( arguments )? ( classBody )? ;
    public final void enumConstant() throws RecognitionException {
        int enumConstant_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:173:5: ( ( annotations )? IDENTIFIER ( arguments )? ( classBody )? )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:173:9: ( annotations )? IDENTIFIER ( arguments )? ( classBody )?
            {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:173:9: ( annotations )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==MONKEYS_AT) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:173:10: annotations
                    {
                    pushFollow(FOLLOW_annotations_in_enumConstant1243);
                    annotations();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enumConstant1264); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:176:9: ( arguments )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==LPAREN) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:176:10: arguments
                    {
                    pushFollow(FOLLOW_arguments_in_enumConstant1275);
                    arguments();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:178:9: ( classBody )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==LBRACE) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:178:10: classBody
                    {
                    pushFollow(FOLLOW_classBody_in_enumConstant1297);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:184:1: enumBodyDeclarations : ';' ( classBodyDeclaration )* ;
    public final void enumBodyDeclarations() throws RecognitionException {
        int enumBodyDeclarations_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:185:5: ( ';' ( classBodyDeclaration )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:185:9: ';' ( classBodyDeclaration )*
            {
            match(input,SEMI,FOLLOW_SEMI_in_enumBodyDeclarations1338); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:186:9: ( classBodyDeclaration )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==ABSTRACT||LA30_0==BOOLEAN||LA30_0==BYTE||LA30_0==CHAR||LA30_0==CLASS||LA30_0==DOUBLE||LA30_0==ENUM||LA30_0==FINAL||LA30_0==FLOAT||LA30_0==IDENTIFIER||(LA30_0 >= INT && LA30_0 <= INTERFACE)||LA30_0==LBRACE||LA30_0==LONG||LA30_0==LT||(LA30_0 >= MONKEYS_AT && LA30_0 <= NATIVE)||(LA30_0 >= PRIVATE && LA30_0 <= PUBLIC)||(LA30_0 >= SEMI && LA30_0 <= SHORT)||(LA30_0 >= STATIC && LA30_0 <= STRICTFP)||LA30_0==SYNCHRONIZED||LA30_0==TRANSIENT||(LA30_0 >= VOID && LA30_0 <= VOLATILE)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:186:10: classBodyDeclaration
            	    {
            	    pushFollow(FOLLOW_classBodyDeclaration_in_enumBodyDeclarations1350);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:190:1: interfaceDeclaration : ( normalInterfaceDeclaration | annotationTypeDeclaration );
    public final void interfaceDeclaration() throws RecognitionException {
        int interfaceDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:191:5: ( normalInterfaceDeclaration | annotationTypeDeclaration )
            int alt31=2;
            switch ( input.LA(1) ) {
            case MONKEYS_AT:
                {
                int LA31_1 = input.LA(2);

                if ( (synpred43_RJavaSymbolTable()) ) {
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

                if ( (synpred43_RJavaSymbolTable()) ) {
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

                if ( (synpred43_RJavaSymbolTable()) ) {
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

                if ( (synpred43_RJavaSymbolTable()) ) {
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

                if ( (synpred43_RJavaSymbolTable()) ) {
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

                if ( (synpred43_RJavaSymbolTable()) ) {
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

                if ( (synpred43_RJavaSymbolTable()) ) {
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

                if ( (synpred43_RJavaSymbolTable()) ) {
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

                if ( (synpred43_RJavaSymbolTable()) ) {
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

                if ( (synpred43_RJavaSymbolTable()) ) {
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

                if ( (synpred43_RJavaSymbolTable()) ) {
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

                if ( (synpred43_RJavaSymbolTable()) ) {
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:191:9: normalInterfaceDeclaration
                    {
                    pushFollow(FOLLOW_normalInterfaceDeclaration_in_interfaceDeclaration1381);
                    normalInterfaceDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:192:9: annotationTypeDeclaration
                    {
                    pushFollow(FOLLOW_annotationTypeDeclaration_in_interfaceDeclaration1391);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:195:1: normalInterfaceDeclaration : modifiers 'interface' IDENTIFIER ( typeParameters )? ( 'extends' typeList )? interfaceBody ;
    public final void normalInterfaceDeclaration() throws RecognitionException {
        int normalInterfaceDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:196:5: ( modifiers 'interface' IDENTIFIER ( typeParameters )? ( 'extends' typeList )? interfaceBody )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:196:9: modifiers 'interface' IDENTIFIER ( typeParameters )? ( 'extends' typeList )? interfaceBody
            {
            pushFollow(FOLLOW_modifiers_in_normalInterfaceDeclaration1415);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            match(input,INTERFACE,FOLLOW_INTERFACE_in_normalInterfaceDeclaration1417); if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_normalInterfaceDeclaration1419); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:197:9: ( typeParameters )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==LT) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:197:10: typeParameters
                    {
                    pushFollow(FOLLOW_typeParameters_in_normalInterfaceDeclaration1430);
                    typeParameters();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:199:9: ( 'extends' typeList )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==EXTENDS) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:199:10: 'extends' typeList
                    {
                    match(input,EXTENDS,FOLLOW_EXTENDS_in_normalInterfaceDeclaration1452); if (state.failed) return ;

                    pushFollow(FOLLOW_typeList_in_normalInterfaceDeclaration1454);
                    typeList();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            pushFollow(FOLLOW_interfaceBody_in_normalInterfaceDeclaration1475);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:204:1: typeList : type ( ',' type )* ;
    public final void typeList() throws RecognitionException {
        int typeList_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:205:5: ( type ( ',' type )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:205:9: type ( ',' type )*
            {
            pushFollow(FOLLOW_type_in_typeList1495);
            type();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:206:9: ( ',' type )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==COMMA) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:206:10: ',' type
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_typeList1506); if (state.failed) return ;

            	    pushFollow(FOLLOW_type_in_typeList1508);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:210:1: classBody : '{' ( classBodyDeclaration )* '}' ;
    public final void classBody() throws RecognitionException {
        int classBody_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:211:5: ( '{' ( classBodyDeclaration )* '}' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:211:9: '{' ( classBodyDeclaration )* '}'
            {
            match(input,LBRACE,FOLLOW_LBRACE_in_classBody1539); if (state.failed) return ;

            if ( state.backtracking==0 ) {klass.setCurrentBlock(klass.getTopBlock());}

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:212:9: ( classBodyDeclaration )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==ABSTRACT||LA35_0==BOOLEAN||LA35_0==BYTE||LA35_0==CHAR||LA35_0==CLASS||LA35_0==DOUBLE||LA35_0==ENUM||LA35_0==FINAL||LA35_0==FLOAT||LA35_0==IDENTIFIER||(LA35_0 >= INT && LA35_0 <= INTERFACE)||LA35_0==LBRACE||LA35_0==LONG||LA35_0==LT||(LA35_0 >= MONKEYS_AT && LA35_0 <= NATIVE)||(LA35_0 >= PRIVATE && LA35_0 <= PUBLIC)||(LA35_0 >= SEMI && LA35_0 <= SHORT)||(LA35_0 >= STATIC && LA35_0 <= STRICTFP)||LA35_0==SYNCHRONIZED||LA35_0==TRANSIENT||(LA35_0 >= VOID && LA35_0 <= VOLATILE)) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:212:10: classBodyDeclaration
            	    {
            	    pushFollow(FOLLOW_classBodyDeclaration_in_classBody1552);
            	    classBodyDeclaration();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            match(input,RBRACE,FOLLOW_RBRACE_in_classBody1574); if (state.failed) return ;

            if ( state.backtracking==0 ) {klass.backToUpperBlock();}

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:217:1: interfaceBody : '{' ( interfaceBodyDeclaration )* '}' ;
    public final void interfaceBody() throws RecognitionException {
        int interfaceBody_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:218:5: ( '{' ( interfaceBodyDeclaration )* '}' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:218:9: '{' ( interfaceBodyDeclaration )* '}'
            {
            match(input,LBRACE,FOLLOW_LBRACE_in_interfaceBody1596); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:219:9: ( interfaceBodyDeclaration )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==ABSTRACT||LA36_0==BOOLEAN||LA36_0==BYTE||LA36_0==CHAR||LA36_0==CLASS||LA36_0==DOUBLE||LA36_0==ENUM||LA36_0==FINAL||LA36_0==FLOAT||LA36_0==IDENTIFIER||(LA36_0 >= INT && LA36_0 <= INTERFACE)||LA36_0==LONG||LA36_0==LT||(LA36_0 >= MONKEYS_AT && LA36_0 <= NATIVE)||(LA36_0 >= PRIVATE && LA36_0 <= PUBLIC)||(LA36_0 >= SEMI && LA36_0 <= SHORT)||(LA36_0 >= STATIC && LA36_0 <= STRICTFP)||LA36_0==SYNCHRONIZED||LA36_0==TRANSIENT||(LA36_0 >= VOID && LA36_0 <= VOLATILE)) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:219:10: interfaceBodyDeclaration
            	    {
            	    pushFollow(FOLLOW_interfaceBodyDeclaration_in_interfaceBody1608);
            	    interfaceBodyDeclaration();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            match(input,RBRACE,FOLLOW_RBRACE_in_interfaceBody1630); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:224:1: classBodyDeclaration : ( ';' | 'static' block | block | memberDecl );
    public final void classBodyDeclaration() throws RecognitionException {
        int classBodyDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:225:5: ( ';' | 'static' block | block | memberDecl )
            int alt37=4;
            switch ( input.LA(1) ) {
            case SEMI:
                {
                alt37=1;
                }
                break;
            case STATIC:
                {
                int LA37_2 = input.LA(2);

                if ( (LA37_2==LBRACE) ) {
                    alt37=2;
                }
                else if ( (LA37_2==ABSTRACT||LA37_2==BOOLEAN||LA37_2==BYTE||LA37_2==CHAR||LA37_2==CLASS||LA37_2==DOUBLE||LA37_2==ENUM||LA37_2==FINAL||LA37_2==FLOAT||LA37_2==IDENTIFIER||(LA37_2 >= INT && LA37_2 <= INTERFACE)||LA37_2==LONG||LA37_2==LT||(LA37_2 >= MONKEYS_AT && LA37_2 <= NATIVE)||(LA37_2 >= PRIVATE && LA37_2 <= PUBLIC)||LA37_2==SHORT||(LA37_2 >= STATIC && LA37_2 <= STRICTFP)||LA37_2==SYNCHRONIZED||LA37_2==TRANSIENT||(LA37_2 >= VOID && LA37_2 <= VOLATILE)) ) {
                    alt37=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 2, input);

                    throw nvae;

                }
                }
                break;
            case LBRACE:
                {
                alt37=3;
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
                alt37=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;

            }

            switch (alt37) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:225:9: ';'
                    {
                    match(input,SEMI,FOLLOW_SEMI_in_classBodyDeclaration1650); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:226:9: 'static' block
                    {
                    match(input,STATIC,FOLLOW_STATIC_in_classBodyDeclaration1660); if (state.failed) return ;

                    if ( state.backtracking==0 ) {klass.newBlock(RBlock.STATIC_INITIALIZER);}

                    pushFollow(FOLLOW_block_in_classBodyDeclaration1673);
                    block();

                    state._fsp--;
                    if (state.failed) return ;

                    if ( state.backtracking==0 ) {klass.backToUpperBlock();}

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:229:9: block
                    {
                    if ( state.backtracking==0 ) {klass.newBlock(RBlock.IN_METHOD);}

                    pushFollow(FOLLOW_block_in_classBodyDeclaration1703);
                    block();

                    state._fsp--;
                    if (state.failed) return ;

                    if ( state.backtracking==0 ) {klass.backToUpperBlock();}

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:232:9: memberDecl
                    {
                    pushFollow(FOLLOW_memberDecl_in_classBodyDeclaration1723);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:235:1: memberDecl : ( fieldDeclaration | methodDeclaration | classDeclaration | interfaceDeclaration );
    public final void memberDecl() throws RecognitionException {
        int memberDecl_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:236:5: ( fieldDeclaration | methodDeclaration | classDeclaration | interfaceDeclaration )
            int alt38=4;
            switch ( input.LA(1) ) {
            case MONKEYS_AT:
                {
                int LA38_1 = input.LA(2);

                if ( (synpred52_RJavaSymbolTable()) ) {
                    alt38=1;
                }
                else if ( (synpred53_RJavaSymbolTable()) ) {
                    alt38=2;
                }
                else if ( (synpred54_RJavaSymbolTable()) ) {
                    alt38=3;
                }
                else if ( (true) ) {
                    alt38=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 1, input);

                    throw nvae;

                }
                }
                break;
            case PUBLIC:
                {
                int LA38_2 = input.LA(2);

                if ( (synpred52_RJavaSymbolTable()) ) {
                    alt38=1;
                }
                else if ( (synpred53_RJavaSymbolTable()) ) {
                    alt38=2;
                }
                else if ( (synpred54_RJavaSymbolTable()) ) {
                    alt38=3;
                }
                else if ( (true) ) {
                    alt38=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 2, input);

                    throw nvae;

                }
                }
                break;
            case PROTECTED:
                {
                int LA38_3 = input.LA(2);

                if ( (synpred52_RJavaSymbolTable()) ) {
                    alt38=1;
                }
                else if ( (synpred53_RJavaSymbolTable()) ) {
                    alt38=2;
                }
                else if ( (synpred54_RJavaSymbolTable()) ) {
                    alt38=3;
                }
                else if ( (true) ) {
                    alt38=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 3, input);

                    throw nvae;

                }
                }
                break;
            case PRIVATE:
                {
                int LA38_4 = input.LA(2);

                if ( (synpred52_RJavaSymbolTable()) ) {
                    alt38=1;
                }
                else if ( (synpred53_RJavaSymbolTable()) ) {
                    alt38=2;
                }
                else if ( (synpred54_RJavaSymbolTable()) ) {
                    alt38=3;
                }
                else if ( (true) ) {
                    alt38=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 4, input);

                    throw nvae;

                }
                }
                break;
            case STATIC:
                {
                int LA38_5 = input.LA(2);

                if ( (synpred52_RJavaSymbolTable()) ) {
                    alt38=1;
                }
                else if ( (synpred53_RJavaSymbolTable()) ) {
                    alt38=2;
                }
                else if ( (synpred54_RJavaSymbolTable()) ) {
                    alt38=3;
                }
                else if ( (true) ) {
                    alt38=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 5, input);

                    throw nvae;

                }
                }
                break;
            case ABSTRACT:
                {
                int LA38_6 = input.LA(2);

                if ( (synpred52_RJavaSymbolTable()) ) {
                    alt38=1;
                }
                else if ( (synpred53_RJavaSymbolTable()) ) {
                    alt38=2;
                }
                else if ( (synpred54_RJavaSymbolTable()) ) {
                    alt38=3;
                }
                else if ( (true) ) {
                    alt38=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 6, input);

                    throw nvae;

                }
                }
                break;
            case FINAL:
                {
                int LA38_7 = input.LA(2);

                if ( (synpred52_RJavaSymbolTable()) ) {
                    alt38=1;
                }
                else if ( (synpred53_RJavaSymbolTable()) ) {
                    alt38=2;
                }
                else if ( (synpred54_RJavaSymbolTable()) ) {
                    alt38=3;
                }
                else if ( (true) ) {
                    alt38=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 7, input);

                    throw nvae;

                }
                }
                break;
            case NATIVE:
                {
                int LA38_8 = input.LA(2);

                if ( (synpred52_RJavaSymbolTable()) ) {
                    alt38=1;
                }
                else if ( (synpred53_RJavaSymbolTable()) ) {
                    alt38=2;
                }
                else if ( (synpred54_RJavaSymbolTable()) ) {
                    alt38=3;
                }
                else if ( (true) ) {
                    alt38=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 8, input);

                    throw nvae;

                }
                }
                break;
            case SYNCHRONIZED:
                {
                int LA38_9 = input.LA(2);

                if ( (synpred52_RJavaSymbolTable()) ) {
                    alt38=1;
                }
                else if ( (synpred53_RJavaSymbolTable()) ) {
                    alt38=2;
                }
                else if ( (synpred54_RJavaSymbolTable()) ) {
                    alt38=3;
                }
                else if ( (true) ) {
                    alt38=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 9, input);

                    throw nvae;

                }
                }
                break;
            case TRANSIENT:
                {
                int LA38_10 = input.LA(2);

                if ( (synpred52_RJavaSymbolTable()) ) {
                    alt38=1;
                }
                else if ( (synpred53_RJavaSymbolTable()) ) {
                    alt38=2;
                }
                else if ( (synpred54_RJavaSymbolTable()) ) {
                    alt38=3;
                }
                else if ( (true) ) {
                    alt38=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 10, input);

                    throw nvae;

                }
                }
                break;
            case VOLATILE:
                {
                int LA38_11 = input.LA(2);

                if ( (synpred52_RJavaSymbolTable()) ) {
                    alt38=1;
                }
                else if ( (synpred53_RJavaSymbolTable()) ) {
                    alt38=2;
                }
                else if ( (synpred54_RJavaSymbolTable()) ) {
                    alt38=3;
                }
                else if ( (true) ) {
                    alt38=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 11, input);

                    throw nvae;

                }
                }
                break;
            case STRICTFP:
                {
                int LA38_12 = input.LA(2);

                if ( (synpred52_RJavaSymbolTable()) ) {
                    alt38=1;
                }
                else if ( (synpred53_RJavaSymbolTable()) ) {
                    alt38=2;
                }
                else if ( (synpred54_RJavaSymbolTable()) ) {
                    alt38=3;
                }
                else if ( (true) ) {
                    alt38=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 12, input);

                    throw nvae;

                }
                }
                break;
            case IDENTIFIER:
                {
                int LA38_13 = input.LA(2);

                if ( (synpred52_RJavaSymbolTable()) ) {
                    alt38=1;
                }
                else if ( (synpred53_RJavaSymbolTable()) ) {
                    alt38=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 13, input);

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
                int LA38_14 = input.LA(2);

                if ( (synpred52_RJavaSymbolTable()) ) {
                    alt38=1;
                }
                else if ( (synpred53_RJavaSymbolTable()) ) {
                    alt38=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 14, input);

                    throw nvae;

                }
                }
                break;
            case LT:
            case VOID:
                {
                alt38=2;
                }
                break;
            case CLASS:
            case ENUM:
                {
                alt38=3;
                }
                break;
            case INTERFACE:
                {
                alt38=4;
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:236:10: fieldDeclaration
                    {
                    pushFollow(FOLLOW_fieldDeclaration_in_memberDecl1744);
                    fieldDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:237:10: methodDeclaration
                    {
                    pushFollow(FOLLOW_methodDeclaration_in_memberDecl1755);
                    methodDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:238:10: classDeclaration
                    {
                    pushFollow(FOLLOW_classDeclaration_in_memberDecl1766);
                    classDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:239:10: interfaceDeclaration
                    {
                    pushFollow(FOLLOW_interfaceDeclaration_in_memberDecl1777);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:243:1: methodDeclaration : ( modifiers ( typeParameters )? IDENTIFIER formalParameters ( 'throws' qualifiedNameList )? '{' ( explicitConstructorInvocation )? ( blockStatement )* '}' | modifiers ( typeParameters )? ( type | 'void' ) IDENTIFIER formalParameters ( '[' ']' )* ( 'throws' qualifiedNameList )? ( block | ';' ) );
    public final void methodDeclaration() throws RecognitionException {
        int methodDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:244:5: ( modifiers ( typeParameters )? IDENTIFIER formalParameters ( 'throws' qualifiedNameList )? '{' ( explicitConstructorInvocation )? ( blockStatement )* '}' | modifiers ( typeParameters )? ( type | 'void' ) IDENTIFIER formalParameters ( '[' ']' )* ( 'throws' qualifiedNameList )? ( block | ';' ) )
            int alt48=2;
            switch ( input.LA(1) ) {
            case MONKEYS_AT:
                {
                int LA48_1 = input.LA(2);

                if ( (synpred59_RJavaSymbolTable()) ) {
                    alt48=1;
                }
                else if ( (true) ) {
                    alt48=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 48, 1, input);

                    throw nvae;

                }
                }
                break;
            case PUBLIC:
                {
                int LA48_2 = input.LA(2);

                if ( (synpred59_RJavaSymbolTable()) ) {
                    alt48=1;
                }
                else if ( (true) ) {
                    alt48=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 48, 2, input);

                    throw nvae;

                }
                }
                break;
            case PROTECTED:
                {
                int LA48_3 = input.LA(2);

                if ( (synpred59_RJavaSymbolTable()) ) {
                    alt48=1;
                }
                else if ( (true) ) {
                    alt48=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 48, 3, input);

                    throw nvae;

                }
                }
                break;
            case PRIVATE:
                {
                int LA48_4 = input.LA(2);

                if ( (synpred59_RJavaSymbolTable()) ) {
                    alt48=1;
                }
                else if ( (true) ) {
                    alt48=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 48, 4, input);

                    throw nvae;

                }
                }
                break;
            case STATIC:
                {
                int LA48_5 = input.LA(2);

                if ( (synpred59_RJavaSymbolTable()) ) {
                    alt48=1;
                }
                else if ( (true) ) {
                    alt48=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 48, 5, input);

                    throw nvae;

                }
                }
                break;
            case ABSTRACT:
                {
                int LA48_6 = input.LA(2);

                if ( (synpred59_RJavaSymbolTable()) ) {
                    alt48=1;
                }
                else if ( (true) ) {
                    alt48=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 48, 6, input);

                    throw nvae;

                }
                }
                break;
            case FINAL:
                {
                int LA48_7 = input.LA(2);

                if ( (synpred59_RJavaSymbolTable()) ) {
                    alt48=1;
                }
                else if ( (true) ) {
                    alt48=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 48, 7, input);

                    throw nvae;

                }
                }
                break;
            case NATIVE:
                {
                int LA48_8 = input.LA(2);

                if ( (synpred59_RJavaSymbolTable()) ) {
                    alt48=1;
                }
                else if ( (true) ) {
                    alt48=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 48, 8, input);

                    throw nvae;

                }
                }
                break;
            case SYNCHRONIZED:
                {
                int LA48_9 = input.LA(2);

                if ( (synpred59_RJavaSymbolTable()) ) {
                    alt48=1;
                }
                else if ( (true) ) {
                    alt48=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 48, 9, input);

                    throw nvae;

                }
                }
                break;
            case TRANSIENT:
                {
                int LA48_10 = input.LA(2);

                if ( (synpred59_RJavaSymbolTable()) ) {
                    alt48=1;
                }
                else if ( (true) ) {
                    alt48=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 48, 10, input);

                    throw nvae;

                }
                }
                break;
            case VOLATILE:
                {
                int LA48_11 = input.LA(2);

                if ( (synpred59_RJavaSymbolTable()) ) {
                    alt48=1;
                }
                else if ( (true) ) {
                    alt48=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 48, 11, input);

                    throw nvae;

                }
                }
                break;
            case STRICTFP:
                {
                int LA48_12 = input.LA(2);

                if ( (synpred59_RJavaSymbolTable()) ) {
                    alt48=1;
                }
                else if ( (true) ) {
                    alt48=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 48, 12, input);

                    throw nvae;

                }
                }
                break;
            case LT:
                {
                int LA48_13 = input.LA(2);

                if ( (synpred59_RJavaSymbolTable()) ) {
                    alt48=1;
                }
                else if ( (true) ) {
                    alt48=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 48, 13, input);

                    throw nvae;

                }
                }
                break;
            case IDENTIFIER:
                {
                int LA48_14 = input.LA(2);

                if ( (synpred59_RJavaSymbolTable()) ) {
                    alt48=1;
                }
                else if ( (true) ) {
                    alt48=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 48, 14, input);

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
                alt48=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;

            }

            switch (alt48) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:246:9: modifiers ( typeParameters )? IDENTIFIER formalParameters ( 'throws' qualifiedNameList )? '{' ( explicitConstructorInvocation )? ( blockStatement )* '}'
                    {
                    if ( state.backtracking==0 ) {klass.newBlock(RBlock.METHOD_WIDE);}

                    pushFollow(FOLLOW_modifiers_in_methodDeclaration1825);
                    modifiers();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:248:9: ( typeParameters )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==LT) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:248:10: typeParameters
                            {
                            pushFollow(FOLLOW_typeParameters_in_methodDeclaration1836);
                            typeParameters();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_methodDeclaration1857); if (state.failed) return ;

                    pushFollow(FOLLOW_formalParameters_in_methodDeclaration1868);
                    formalParameters();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:252:9: ( 'throws' qualifiedNameList )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==THROWS) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:252:10: 'throws' qualifiedNameList
                            {
                            match(input,THROWS,FOLLOW_THROWS_in_methodDeclaration1879); if (state.failed) return ;

                            pushFollow(FOLLOW_qualifiedNameList_in_methodDeclaration1881);
                            qualifiedNameList();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,LBRACE,FOLLOW_LBRACE_in_methodDeclaration1902); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:255:9: ( explicitConstructorInvocation )?
                    int alt41=2;
                    switch ( input.LA(1) ) {
                        case LT:
                            {
                            alt41=1;
                            }
                            break;
                        case THIS:
                            {
                            int LA41_2 = input.LA(2);

                            if ( (synpred57_RJavaSymbolTable()) ) {
                                alt41=1;
                            }
                            }
                            break;
                        case LPAREN:
                            {
                            int LA41_3 = input.LA(2);

                            if ( (synpred57_RJavaSymbolTable()) ) {
                                alt41=1;
                            }
                            }
                            break;
                        case SUPER:
                            {
                            int LA41_4 = input.LA(2);

                            if ( (synpred57_RJavaSymbolTable()) ) {
                                alt41=1;
                            }
                            }
                            break;
                        case IDENTIFIER:
                            {
                            int LA41_5 = input.LA(2);

                            if ( (synpred57_RJavaSymbolTable()) ) {
                                alt41=1;
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
                            int LA41_6 = input.LA(2);

                            if ( (synpred57_RJavaSymbolTable()) ) {
                                alt41=1;
                            }
                            }
                            break;
                        case NEW:
                            {
                            int LA41_7 = input.LA(2);

                            if ( (synpred57_RJavaSymbolTable()) ) {
                                alt41=1;
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
                            int LA41_8 = input.LA(2);

                            if ( (synpred57_RJavaSymbolTable()) ) {
                                alt41=1;
                            }
                            }
                            break;
                        case VOID:
                            {
                            int LA41_9 = input.LA(2);

                            if ( (synpred57_RJavaSymbolTable()) ) {
                                alt41=1;
                            }
                            }
                            break;
                    }

                    switch (alt41) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:255:10: explicitConstructorInvocation
                            {
                            pushFollow(FOLLOW_explicitConstructorInvocation_in_methodDeclaration1914);
                            explicitConstructorInvocation();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:257:9: ( blockStatement )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==ABSTRACT||(LA42_0 >= ASSERT && LA42_0 <= BANG)||(LA42_0 >= BOOLEAN && LA42_0 <= BYTE)||(LA42_0 >= CHAR && LA42_0 <= CLASS)||LA42_0==CONTINUE||LA42_0==DO||(LA42_0 >= DOUBLE && LA42_0 <= DOUBLELITERAL)||LA42_0==ENUM||(LA42_0 >= FALSE && LA42_0 <= FINAL)||(LA42_0 >= FLOAT && LA42_0 <= FOR)||(LA42_0 >= IDENTIFIER && LA42_0 <= IF)||(LA42_0 >= INT && LA42_0 <= INTLITERAL)||LA42_0==LBRACE||(LA42_0 >= LONG && LA42_0 <= LT)||(LA42_0 >= MONKEYS_AT && LA42_0 <= NULL)||LA42_0==PLUS||(LA42_0 >= PLUSPLUS && LA42_0 <= PUBLIC)||LA42_0==RETURN||(LA42_0 >= SEMI && LA42_0 <= SHORT)||(LA42_0 >= STATIC && LA42_0 <= SUB)||(LA42_0 >= SUBSUB && LA42_0 <= SYNCHRONIZED)||(LA42_0 >= THIS && LA42_0 <= THROW)||(LA42_0 >= TILDE && LA42_0 <= WHILE)) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:257:10: blockStatement
                    	    {
                    	    pushFollow(FOLLOW_blockStatement_in_methodDeclaration1936);
                    	    blockStatement();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);


                    match(input,RBRACE,FOLLOW_RBRACE_in_methodDeclaration1957); if (state.failed) return ;

                    if ( state.backtracking==0 ) {klass.backToUpperBlock();}

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:261:9: modifiers ( typeParameters )? ( type | 'void' ) IDENTIFIER formalParameters ( '[' ']' )* ( 'throws' qualifiedNameList )? ( block | ';' )
                    {
                    if ( state.backtracking==0 ) {klass.newBlock(RBlock.METHOD_WIDE);}

                    pushFollow(FOLLOW_modifiers_in_methodDeclaration1988);
                    modifiers();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:263:9: ( typeParameters )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==LT) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:263:10: typeParameters
                            {
                            pushFollow(FOLLOW_typeParameters_in_methodDeclaration1999);
                            typeParameters();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:265:9: ( type | 'void' )
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==BOOLEAN||LA44_0==BYTE||LA44_0==CHAR||LA44_0==DOUBLE||LA44_0==FLOAT||LA44_0==IDENTIFIER||LA44_0==INT||LA44_0==LONG||LA44_0==SHORT) ) {
                        alt44=1;
                    }
                    else if ( (LA44_0==VOID) ) {
                        alt44=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 44, 0, input);

                        throw nvae;

                    }
                    switch (alt44) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:265:10: type
                            {
                            pushFollow(FOLLOW_type_in_methodDeclaration2021);
                            type();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;
                        case 2 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:266:13: 'void'
                            {
                            match(input,VOID,FOLLOW_VOID_in_methodDeclaration2035); if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_methodDeclaration2055); if (state.failed) return ;

                    pushFollow(FOLLOW_formalParameters_in_methodDeclaration2066);
                    formalParameters();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:270:9: ( '[' ']' )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==LBRACKET) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:270:10: '[' ']'
                    	    {
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_methodDeclaration2077); if (state.failed) return ;

                    	    match(input,RBRACKET,FOLLOW_RBRACKET_in_methodDeclaration2079); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop45;
                        }
                    } while (true);


                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:272:9: ( 'throws' qualifiedNameList )?
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==THROWS) ) {
                        alt46=1;
                    }
                    switch (alt46) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:272:10: 'throws' qualifiedNameList
                            {
                            match(input,THROWS,FOLLOW_THROWS_in_methodDeclaration2101); if (state.failed) return ;

                            pushFollow(FOLLOW_qualifiedNameList_in_methodDeclaration2103);
                            qualifiedNameList();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:274:9: ( block | ';' )
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==LBRACE) ) {
                        alt47=1;
                    }
                    else if ( (LA47_0==SEMI) ) {
                        alt47=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 47, 0, input);

                        throw nvae;

                    }
                    switch (alt47) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:275:13: block
                            {
                            pushFollow(FOLLOW_block_in_methodDeclaration2158);
                            block();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;
                        case 2 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:276:13: ';'
                            {
                            match(input,SEMI,FOLLOW_SEMI_in_methodDeclaration2172); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:281:1: fieldDeclaration : modifiers type variableDeclarator ( ',' variableDeclarator )* ';' ;
    public final void fieldDeclaration() throws RecognitionException {
        int fieldDeclaration_StartIndex = input.index();

        RJavaSymbolTableParser.type_return type2 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:282:5: ( modifiers type variableDeclarator ( ',' variableDeclarator )* ';' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:282:9: modifiers type variableDeclarator ( ',' variableDeclarator )* ';'
            {
            pushFollow(FOLLOW_modifiers_in_fieldDeclaration2204);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_type_in_fieldDeclaration2215);
            type2=type();

            state._fsp--;
            if (state.failed) return ;

            if ( state.backtracking==0 ) {type = (type2!=null?input.toString(type2.start,type2.stop):null);}

            pushFollow(FOLLOW_variableDeclarator_in_fieldDeclaration2227);
            variableDeclarator();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:285:9: ( ',' variableDeclarator )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==COMMA) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:285:10: ',' variableDeclarator
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_fieldDeclaration2239); if (state.failed) return ;

            	    pushFollow(FOLLOW_variableDeclarator_in_fieldDeclaration2241);
            	    variableDeclarator();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);


            match(input,SEMI,FOLLOW_SEMI_in_fieldDeclaration2263); if (state.failed) return ;

            if ( state.backtracking==0 ) {type = null;}

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:290:1: variableDeclarator returns [RIdentifier id] : IDENTIFIER ( '[' ']' )* ( '=' variableInitializer )? ;
    public final RIdentifier variableDeclarator() throws RecognitionException {
        RIdentifier id = null;

        int variableDeclarator_StartIndex = input.index();

        Token IDENTIFIER3=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return id; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:291:5: ( IDENTIFIER ( '[' ']' )* ( '=' variableInitializer )? )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:291:9: IDENTIFIER ( '[' ']' )* ( '=' variableInitializer )?
            {
            IDENTIFIER3=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_variableDeclarator2288); if (state.failed) return id;

            if ( state.backtracking==0 ) {
                      id = new RIdentifier(); 
                      id.setId((IDENTIFIER3!=null?IDENTIFIER3.getText():null)); 
                      id.setType(RType.initWithClassName(klass, type));
                      }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:296:9: ( '[' ']' )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==LBRACKET) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:296:10: '[' ']'
            	    {
            	    match(input,LBRACKET,FOLLOW_LBRACKET_in_variableDeclarator2301); if (state.failed) return id;

            	    match(input,RBRACKET,FOLLOW_RBRACKET_in_variableDeclarator2303); if (state.failed) return id;

            	    if ( state.backtracking==0 ) {id.setArray(true);}

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:298:9: ( '=' variableInitializer )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==EQ) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:298:10: '=' variableInitializer
                    {
                    match(input,EQ,FOLLOW_EQ_in_variableDeclarator2327); if (state.failed) return id;

                    pushFollow(FOLLOW_variableInitializer_in_variableDeclarator2329);
                    variableInitializer();

                    state._fsp--;
                    if (state.failed) return id;

                    }
                    break;

            }


            if ( state.backtracking==0 ) {klass.newIdToCurrentBlock(id);}

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
        return id;
    }
    // $ANTLR end "variableDeclarator"



    // $ANTLR start "interfaceBodyDeclaration"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:306:1: interfaceBodyDeclaration : ( interfaceFieldDeclaration | interfaceMethodDeclaration | interfaceDeclaration | classDeclaration | ';' );
    public final void interfaceBodyDeclaration() throws RecognitionException {
        int interfaceBodyDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:307:5: ( interfaceFieldDeclaration | interfaceMethodDeclaration | interfaceDeclaration | classDeclaration | ';' )
            int alt52=5;
            switch ( input.LA(1) ) {
            case MONKEYS_AT:
                {
                int LA52_1 = input.LA(2);

                if ( (synpred68_RJavaSymbolTable()) ) {
                    alt52=1;
                }
                else if ( (synpred69_RJavaSymbolTable()) ) {
                    alt52=2;
                }
                else if ( (synpred70_RJavaSymbolTable()) ) {
                    alt52=3;
                }
                else if ( (synpred71_RJavaSymbolTable()) ) {
                    alt52=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 1, input);

                    throw nvae;

                }
                }
                break;
            case PUBLIC:
                {
                int LA52_2 = input.LA(2);

                if ( (synpred68_RJavaSymbolTable()) ) {
                    alt52=1;
                }
                else if ( (synpred69_RJavaSymbolTable()) ) {
                    alt52=2;
                }
                else if ( (synpred70_RJavaSymbolTable()) ) {
                    alt52=3;
                }
                else if ( (synpred71_RJavaSymbolTable()) ) {
                    alt52=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 2, input);

                    throw nvae;

                }
                }
                break;
            case PROTECTED:
                {
                int LA52_3 = input.LA(2);

                if ( (synpred68_RJavaSymbolTable()) ) {
                    alt52=1;
                }
                else if ( (synpred69_RJavaSymbolTable()) ) {
                    alt52=2;
                }
                else if ( (synpred70_RJavaSymbolTable()) ) {
                    alt52=3;
                }
                else if ( (synpred71_RJavaSymbolTable()) ) {
                    alt52=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 3, input);

                    throw nvae;

                }
                }
                break;
            case PRIVATE:
                {
                int LA52_4 = input.LA(2);

                if ( (synpred68_RJavaSymbolTable()) ) {
                    alt52=1;
                }
                else if ( (synpred69_RJavaSymbolTable()) ) {
                    alt52=2;
                }
                else if ( (synpred70_RJavaSymbolTable()) ) {
                    alt52=3;
                }
                else if ( (synpred71_RJavaSymbolTable()) ) {
                    alt52=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 4, input);

                    throw nvae;

                }
                }
                break;
            case STATIC:
                {
                int LA52_5 = input.LA(2);

                if ( (synpred68_RJavaSymbolTable()) ) {
                    alt52=1;
                }
                else if ( (synpred69_RJavaSymbolTable()) ) {
                    alt52=2;
                }
                else if ( (synpred70_RJavaSymbolTable()) ) {
                    alt52=3;
                }
                else if ( (synpred71_RJavaSymbolTable()) ) {
                    alt52=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 5, input);

                    throw nvae;

                }
                }
                break;
            case ABSTRACT:
                {
                int LA52_6 = input.LA(2);

                if ( (synpred68_RJavaSymbolTable()) ) {
                    alt52=1;
                }
                else if ( (synpred69_RJavaSymbolTable()) ) {
                    alt52=2;
                }
                else if ( (synpred70_RJavaSymbolTable()) ) {
                    alt52=3;
                }
                else if ( (synpred71_RJavaSymbolTable()) ) {
                    alt52=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 6, input);

                    throw nvae;

                }
                }
                break;
            case FINAL:
                {
                int LA52_7 = input.LA(2);

                if ( (synpred68_RJavaSymbolTable()) ) {
                    alt52=1;
                }
                else if ( (synpred69_RJavaSymbolTable()) ) {
                    alt52=2;
                }
                else if ( (synpred70_RJavaSymbolTable()) ) {
                    alt52=3;
                }
                else if ( (synpred71_RJavaSymbolTable()) ) {
                    alt52=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 7, input);

                    throw nvae;

                }
                }
                break;
            case NATIVE:
                {
                int LA52_8 = input.LA(2);

                if ( (synpred68_RJavaSymbolTable()) ) {
                    alt52=1;
                }
                else if ( (synpred69_RJavaSymbolTable()) ) {
                    alt52=2;
                }
                else if ( (synpred70_RJavaSymbolTable()) ) {
                    alt52=3;
                }
                else if ( (synpred71_RJavaSymbolTable()) ) {
                    alt52=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 8, input);

                    throw nvae;

                }
                }
                break;
            case SYNCHRONIZED:
                {
                int LA52_9 = input.LA(2);

                if ( (synpred68_RJavaSymbolTable()) ) {
                    alt52=1;
                }
                else if ( (synpred69_RJavaSymbolTable()) ) {
                    alt52=2;
                }
                else if ( (synpred70_RJavaSymbolTable()) ) {
                    alt52=3;
                }
                else if ( (synpred71_RJavaSymbolTable()) ) {
                    alt52=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 9, input);

                    throw nvae;

                }
                }
                break;
            case TRANSIENT:
                {
                int LA52_10 = input.LA(2);

                if ( (synpred68_RJavaSymbolTable()) ) {
                    alt52=1;
                }
                else if ( (synpred69_RJavaSymbolTable()) ) {
                    alt52=2;
                }
                else if ( (synpred70_RJavaSymbolTable()) ) {
                    alt52=3;
                }
                else if ( (synpred71_RJavaSymbolTable()) ) {
                    alt52=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 10, input);

                    throw nvae;

                }
                }
                break;
            case VOLATILE:
                {
                int LA52_11 = input.LA(2);

                if ( (synpred68_RJavaSymbolTable()) ) {
                    alt52=1;
                }
                else if ( (synpred69_RJavaSymbolTable()) ) {
                    alt52=2;
                }
                else if ( (synpred70_RJavaSymbolTable()) ) {
                    alt52=3;
                }
                else if ( (synpred71_RJavaSymbolTable()) ) {
                    alt52=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 11, input);

                    throw nvae;

                }
                }
                break;
            case STRICTFP:
                {
                int LA52_12 = input.LA(2);

                if ( (synpred68_RJavaSymbolTable()) ) {
                    alt52=1;
                }
                else if ( (synpred69_RJavaSymbolTable()) ) {
                    alt52=2;
                }
                else if ( (synpred70_RJavaSymbolTable()) ) {
                    alt52=3;
                }
                else if ( (synpred71_RJavaSymbolTable()) ) {
                    alt52=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 12, input);

                    throw nvae;

                }
                }
                break;
            case IDENTIFIER:
                {
                int LA52_13 = input.LA(2);

                if ( (synpred68_RJavaSymbolTable()) ) {
                    alt52=1;
                }
                else if ( (synpred69_RJavaSymbolTable()) ) {
                    alt52=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 13, input);

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
                int LA52_14 = input.LA(2);

                if ( (synpred68_RJavaSymbolTable()) ) {
                    alt52=1;
                }
                else if ( (synpred69_RJavaSymbolTable()) ) {
                    alt52=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 14, input);

                    throw nvae;

                }
                }
                break;
            case LT:
            case VOID:
                {
                alt52=2;
                }
                break;
            case INTERFACE:
                {
                alt52=3;
                }
                break;
            case CLASS:
            case ENUM:
                {
                alt52=4;
                }
                break;
            case SEMI:
                {
                alt52=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;

            }

            switch (alt52) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:308:9: interfaceFieldDeclaration
                    {
                    pushFollow(FOLLOW_interfaceFieldDeclaration_in_interfaceBodyDeclaration2378);
                    interfaceFieldDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:309:9: interfaceMethodDeclaration
                    {
                    pushFollow(FOLLOW_interfaceMethodDeclaration_in_interfaceBodyDeclaration2388);
                    interfaceMethodDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:310:9: interfaceDeclaration
                    {
                    pushFollow(FOLLOW_interfaceDeclaration_in_interfaceBodyDeclaration2398);
                    interfaceDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:311:9: classDeclaration
                    {
                    pushFollow(FOLLOW_classDeclaration_in_interfaceBodyDeclaration2408);
                    classDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:312:9: ';'
                    {
                    match(input,SEMI,FOLLOW_SEMI_in_interfaceBodyDeclaration2418); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:315:1: interfaceMethodDeclaration : modifiers ( typeParameters )? ( type | 'void' ) IDENTIFIER formalParameters ( '[' ']' )* ( 'throws' qualifiedNameList )? ';' ;
    public final void interfaceMethodDeclaration() throws RecognitionException {
        int interfaceMethodDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:316:5: ( modifiers ( typeParameters )? ( type | 'void' ) IDENTIFIER formalParameters ( '[' ']' )* ( 'throws' qualifiedNameList )? ';' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:316:9: modifiers ( typeParameters )? ( type | 'void' ) IDENTIFIER formalParameters ( '[' ']' )* ( 'throws' qualifiedNameList )? ';'
            {
            pushFollow(FOLLOW_modifiers_in_interfaceMethodDeclaration2438);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:317:9: ( typeParameters )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==LT) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:317:10: typeParameters
                    {
                    pushFollow(FOLLOW_typeParameters_in_interfaceMethodDeclaration2449);
                    typeParameters();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:319:9: ( type | 'void' )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==BOOLEAN||LA54_0==BYTE||LA54_0==CHAR||LA54_0==DOUBLE||LA54_0==FLOAT||LA54_0==IDENTIFIER||LA54_0==INT||LA54_0==LONG||LA54_0==SHORT) ) {
                alt54=1;
            }
            else if ( (LA54_0==VOID) ) {
                alt54=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;

            }
            switch (alt54) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:319:10: type
                    {
                    pushFollow(FOLLOW_type_in_interfaceMethodDeclaration2471);
                    type();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:320:10: 'void'
                    {
                    match(input,VOID,FOLLOW_VOID_in_interfaceMethodDeclaration2482); if (state.failed) return ;

                    }
                    break;

            }


            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_interfaceMethodDeclaration2502); if (state.failed) return ;

            pushFollow(FOLLOW_formalParameters_in_interfaceMethodDeclaration2512);
            formalParameters();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:324:9: ( '[' ']' )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==LBRACKET) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:324:10: '[' ']'
            	    {
            	    match(input,LBRACKET,FOLLOW_LBRACKET_in_interfaceMethodDeclaration2523); if (state.failed) return ;

            	    match(input,RBRACKET,FOLLOW_RBRACKET_in_interfaceMethodDeclaration2525); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:326:9: ( 'throws' qualifiedNameList )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==THROWS) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:326:10: 'throws' qualifiedNameList
                    {
                    match(input,THROWS,FOLLOW_THROWS_in_interfaceMethodDeclaration2547); if (state.failed) return ;

                    pushFollow(FOLLOW_qualifiedNameList_in_interfaceMethodDeclaration2549);
                    qualifiedNameList();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            match(input,SEMI,FOLLOW_SEMI_in_interfaceMethodDeclaration2562); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:335:1: interfaceFieldDeclaration : modifiers type variableDeclarator ( ',' variableDeclarator )* ';' ;
    public final void interfaceFieldDeclaration() throws RecognitionException {
        int interfaceFieldDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:336:5: ( modifiers type variableDeclarator ( ',' variableDeclarator )* ';' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:336:9: modifiers type variableDeclarator ( ',' variableDeclarator )* ';'
            {
            pushFollow(FOLLOW_modifiers_in_interfaceFieldDeclaration2584);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_type_in_interfaceFieldDeclaration2586);
            type();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_variableDeclarator_in_interfaceFieldDeclaration2588);
            variableDeclarator();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:337:9: ( ',' variableDeclarator )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==COMMA) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:337:10: ',' variableDeclarator
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_interfaceFieldDeclaration2599); if (state.failed) return ;

            	    pushFollow(FOLLOW_variableDeclarator_in_interfaceFieldDeclaration2601);
            	    variableDeclarator();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);


            match(input,SEMI,FOLLOW_SEMI_in_interfaceFieldDeclaration2622); if (state.failed) return ;

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


    public static class type_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "type"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:343:1: type : ( classOrInterfaceType ( '[' ']' )* | primitiveType ( '[' ']' )* );
    public final RJavaSymbolTableParser.type_return type() throws RecognitionException {
        RJavaSymbolTableParser.type_return retval = new RJavaSymbolTableParser.type_return();
        retval.start = input.LT(1);

        int type_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return retval; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:344:5: ( classOrInterfaceType ( '[' ']' )* | primitiveType ( '[' ']' )* )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==IDENTIFIER) ) {
                alt60=1;
            }
            else if ( (LA60_0==BOOLEAN||LA60_0==BYTE||LA60_0==CHAR||LA60_0==DOUBLE||LA60_0==FLOAT||LA60_0==INT||LA60_0==LONG||LA60_0==SHORT) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;

            }
            switch (alt60) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:344:9: classOrInterfaceType ( '[' ']' )*
                    {
                    pushFollow(FOLLOW_classOrInterfaceType_in_type2643);
                    classOrInterfaceType();

                    state._fsp--;
                    if (state.failed) return retval;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:345:9: ( '[' ']' )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==LBRACKET) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:345:10: '[' ']'
                    	    {
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_type2654); if (state.failed) return retval;

                    	    match(input,RBRACKET,FOLLOW_RBRACKET_in_type2656); if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    break loop58;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:347:9: primitiveType ( '[' ']' )*
                    {
                    pushFollow(FOLLOW_primitiveType_in_type2677);
                    primitiveType();

                    state._fsp--;
                    if (state.failed) return retval;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:348:9: ( '[' ']' )*
                    loop59:
                    do {
                        int alt59=2;
                        int LA59_0 = input.LA(1);

                        if ( (LA59_0==LBRACKET) ) {
                            alt59=1;
                        }


                        switch (alt59) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:348:10: '[' ']'
                    	    {
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_type2688); if (state.failed) return retval;

                    	    match(input,RBRACKET,FOLLOW_RBRACKET_in_type2690); if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    break loop59;
                        }
                    } while (true);


                    }
                    break;

            }
            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 32, type_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "type"



    // $ANTLR start "classOrInterfaceType"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:353:1: classOrInterfaceType : IDENTIFIER ( typeArguments )? ( '.' IDENTIFIER ( typeArguments )? )* ;
    public final void classOrInterfaceType() throws RecognitionException {
        int classOrInterfaceType_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:354:5: ( IDENTIFIER ( typeArguments )? ( '.' IDENTIFIER ( typeArguments )? )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:354:9: IDENTIFIER ( typeArguments )? ( '.' IDENTIFIER ( typeArguments )? )*
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_classOrInterfaceType2722); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:355:9: ( typeArguments )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==LT) ) {
                int LA61_1 = input.LA(2);

                if ( (LA61_1==BOOLEAN||LA61_1==BYTE||LA61_1==CHAR||LA61_1==DOUBLE||LA61_1==FLOAT||LA61_1==IDENTIFIER||LA61_1==INT||LA61_1==LONG||LA61_1==QUES||LA61_1==SHORT) ) {
                    alt61=1;
                }
            }
            switch (alt61) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:355:10: typeArguments
                    {
                    pushFollow(FOLLOW_typeArguments_in_classOrInterfaceType2733);
                    typeArguments();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:357:9: ( '.' IDENTIFIER ( typeArguments )? )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==DOT) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:357:10: '.' IDENTIFIER ( typeArguments )?
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_classOrInterfaceType2755); if (state.failed) return ;

            	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_classOrInterfaceType2757); if (state.failed) return ;

            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:358:13: ( typeArguments )?
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
            	            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:358:14: typeArguments
            	            {
            	            pushFollow(FOLLOW_typeArguments_in_classOrInterfaceType2772);
            	            typeArguments();

            	            state._fsp--;
            	            if (state.failed) return ;

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop63;
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:363:1: primitiveType : ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' );
    public final void primitiveType() throws RecognitionException {
        int primitiveType_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:364:5: ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:374:1: typeArguments : '<' typeArgument ( ',' typeArgument )* '>' ;
    public final void typeArguments() throws RecognitionException {
        int typeArguments_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:375:5: ( '<' typeArgument ( ',' typeArgument )* '>' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:375:9: '<' typeArgument ( ',' typeArgument )* '>'
            {
            match(input,LT,FOLLOW_LT_in_typeArguments2909); if (state.failed) return ;

            pushFollow(FOLLOW_typeArgument_in_typeArguments2911);
            typeArgument();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:376:9: ( ',' typeArgument )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==COMMA) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:376:10: ',' typeArgument
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_typeArguments2922); if (state.failed) return ;

            	    pushFollow(FOLLOW_typeArgument_in_typeArguments2924);
            	    typeArgument();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);


            match(input,GT,FOLLOW_GT_in_typeArguments2946); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:381:1: typeArgument : ( type | '?' ( ( 'extends' | 'super' ) type )? );
    public final void typeArgument() throws RecognitionException {
        int typeArgument_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:382:5: ( type | '?' ( ( 'extends' | 'super' ) type )? )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==BOOLEAN||LA66_0==BYTE||LA66_0==CHAR||LA66_0==DOUBLE||LA66_0==FLOAT||LA66_0==IDENTIFIER||LA66_0==INT||LA66_0==LONG||LA66_0==SHORT) ) {
                alt66=1;
            }
            else if ( (LA66_0==QUES) ) {
                alt66=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;

            }
            switch (alt66) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:382:9: type
                    {
                    pushFollow(FOLLOW_type_in_typeArgument2966);
                    type();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:383:9: '?' ( ( 'extends' | 'super' ) type )?
                    {
                    match(input,QUES,FOLLOW_QUES_in_typeArgument2976); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:384:9: ( ( 'extends' | 'super' ) type )?
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==EXTENDS||LA65_0==SUPER) ) {
                        alt65=1;
                    }
                    switch (alt65) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:385:13: ( 'extends' | 'super' ) type
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


                            pushFollow(FOLLOW_type_in_typeArgument3044);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:392:1: qualifiedNameList : qualifiedName ( ',' qualifiedName )* ;
    public final void qualifiedNameList() throws RecognitionException {
        int qualifiedNameList_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:393:5: ( qualifiedName ( ',' qualifiedName )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:393:9: qualifiedName ( ',' qualifiedName )*
            {
            pushFollow(FOLLOW_qualifiedName_in_qualifiedNameList3075);
            qualifiedName();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:394:9: ( ',' qualifiedName )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==COMMA) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:394:10: ',' qualifiedName
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_qualifiedNameList3086); if (state.failed) return ;

            	    pushFollow(FOLLOW_qualifiedName_in_qualifiedNameList3088);
            	    qualifiedName();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop67;
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:398:1: formalParameters : '(' ( formalParameterDecls )? ')' ;
    public final void formalParameters() throws RecognitionException {
        int formalParameters_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:399:5: ( '(' ( formalParameterDecls )? ')' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:399:9: '(' ( formalParameterDecls )? ')'
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_formalParameters3119); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:400:9: ( formalParameterDecls )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==BOOLEAN||LA68_0==BYTE||LA68_0==CHAR||LA68_0==DOUBLE||LA68_0==FINAL||LA68_0==FLOAT||LA68_0==IDENTIFIER||LA68_0==INT||LA68_0==LONG||LA68_0==MONKEYS_AT||LA68_0==SHORT) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:400:10: formalParameterDecls
                    {
                    pushFollow(FOLLOW_formalParameterDecls_in_formalParameters3130);
                    formalParameterDecls();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            match(input,RPAREN,FOLLOW_RPAREN_in_formalParameters3152); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:405:1: formalParameterDecls : ( ellipsisParameterDecl | normalParameterDecl ( ',' normalParameterDecl )* | ( normalParameterDecl ',' )+ ellipsisParameterDecl );
    public final void formalParameterDecls() throws RecognitionException {
        int formalParameterDecls_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:406:5: ( ellipsisParameterDecl | normalParameterDecl ( ',' normalParameterDecl )* | ( normalParameterDecl ',' )+ ellipsisParameterDecl )
            int alt71=3;
            switch ( input.LA(1) ) {
            case FINAL:
                {
                int LA71_1 = input.LA(2);

                if ( (synpred96_RJavaSymbolTable()) ) {
                    alt71=1;
                }
                else if ( (synpred98_RJavaSymbolTable()) ) {
                    alt71=2;
                }
                else if ( (true) ) {
                    alt71=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 71, 1, input);

                    throw nvae;

                }
                }
                break;
            case MONKEYS_AT:
                {
                int LA71_2 = input.LA(2);

                if ( (synpred96_RJavaSymbolTable()) ) {
                    alt71=1;
                }
                else if ( (synpred98_RJavaSymbolTable()) ) {
                    alt71=2;
                }
                else if ( (true) ) {
                    alt71=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 71, 2, input);

                    throw nvae;

                }
                }
                break;
            case IDENTIFIER:
                {
                int LA71_3 = input.LA(2);

                if ( (synpred96_RJavaSymbolTable()) ) {
                    alt71=1;
                }
                else if ( (synpred98_RJavaSymbolTable()) ) {
                    alt71=2;
                }
                else if ( (true) ) {
                    alt71=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 71, 3, input);

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
                int LA71_4 = input.LA(2);

                if ( (synpred96_RJavaSymbolTable()) ) {
                    alt71=1;
                }
                else if ( (synpred98_RJavaSymbolTable()) ) {
                    alt71=2;
                }
                else if ( (true) ) {
                    alt71=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 71, 4, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;

            }

            switch (alt71) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:406:9: ellipsisParameterDecl
                    {
                    pushFollow(FOLLOW_ellipsisParameterDecl_in_formalParameterDecls3172);
                    ellipsisParameterDecl();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:407:9: normalParameterDecl ( ',' normalParameterDecl )*
                    {
                    pushFollow(FOLLOW_normalParameterDecl_in_formalParameterDecls3182);
                    normalParameterDecl();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:408:9: ( ',' normalParameterDecl )*
                    loop69:
                    do {
                        int alt69=2;
                        int LA69_0 = input.LA(1);

                        if ( (LA69_0==COMMA) ) {
                            alt69=1;
                        }


                        switch (alt69) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:408:10: ',' normalParameterDecl
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_formalParameterDecls3193); if (state.failed) return ;

                    	    pushFollow(FOLLOW_normalParameterDecl_in_formalParameterDecls3195);
                    	    normalParameterDecl();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop69;
                        }
                    } while (true);


                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:410:9: ( normalParameterDecl ',' )+ ellipsisParameterDecl
                    {
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:410:9: ( normalParameterDecl ',' )+
                    int cnt70=0;
                    loop70:
                    do {
                        int alt70=2;
                        switch ( input.LA(1) ) {
                        case FINAL:
                            {
                            int LA70_1 = input.LA(2);

                            if ( (synpred99_RJavaSymbolTable()) ) {
                                alt70=1;
                            }


                            }
                            break;
                        case MONKEYS_AT:
                            {
                            int LA70_2 = input.LA(2);

                            if ( (synpred99_RJavaSymbolTable()) ) {
                                alt70=1;
                            }


                            }
                            break;
                        case IDENTIFIER:
                            {
                            int LA70_3 = input.LA(2);

                            if ( (synpred99_RJavaSymbolTable()) ) {
                                alt70=1;
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
                            int LA70_4 = input.LA(2);

                            if ( (synpred99_RJavaSymbolTable()) ) {
                                alt70=1;
                            }


                            }
                            break;

                        }

                        switch (alt70) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:410:10: normalParameterDecl ','
                    	    {
                    	    pushFollow(FOLLOW_normalParameterDecl_in_formalParameterDecls3217);
                    	    normalParameterDecl();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    match(input,COMMA,FOLLOW_COMMA_in_formalParameterDecls3227); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt70 >= 1 ) break loop70;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(70, input);
                                throw eee;
                        }
                        cnt70++;
                    } while (true);


                    pushFollow(FOLLOW_ellipsisParameterDecl_in_formalParameterDecls3249);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:416:1: normalParameterDecl returns [RIdentifier id] : variableModifiers type IDENTIFIER ( '[' ']' )* ;
    public final RIdentifier normalParameterDecl() throws RecognitionException {
        RIdentifier id = null;

        int normalParameterDecl_StartIndex = input.index();

        Token IDENTIFIER4=null;
        RJavaSymbolTableParser.type_return type5 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return id; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:417:5: ( variableModifiers type IDENTIFIER ( '[' ']' )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:418:9: variableModifiers type IDENTIFIER ( '[' ']' )*
            {
            pushFollow(FOLLOW_variableModifiers_in_normalParameterDecl3281);
            variableModifiers();

            state._fsp--;
            if (state.failed) return id;

            pushFollow(FOLLOW_type_in_normalParameterDecl3283);
            type5=type();

            state._fsp--;
            if (state.failed) return id;

            IDENTIFIER4=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_normalParameterDecl3285); if (state.failed) return id;

            if ( state.backtracking==0 ) {id = new RIdentifier();
                    id.setId((IDENTIFIER4!=null?IDENTIFIER4.getText():null));
                    id.setType(RType.initWithClassName(klass, (type5!=null?input.toString(type5.start,type5.stop):null)));
                    }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:423:9: ( '[' ']' )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==LBRACKET) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:423:10: '[' ']'
            	    {
            	    match(input,LBRACKET,FOLLOW_LBRACKET_in_normalParameterDecl3306); if (state.failed) return id;

            	    match(input,RBRACKET,FOLLOW_RBRACKET_in_normalParameterDecl3308); if (state.failed) return id;

            	    if ( state.backtracking==0 ) {id.setArray(true);}

            	    }
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);


            if ( state.backtracking==0 ) {klass.newIdToCurrentBlock(id);}

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
        return id;
    }
    // $ANTLR end "normalParameterDecl"



    // $ANTLR start "ellipsisParameterDecl"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:428:1: ellipsisParameterDecl returns [RIdentifier id] : variableModifiers type '...' IDENTIFIER ;
    public final RIdentifier ellipsisParameterDecl() throws RecognitionException {
        RIdentifier id = null;

        int ellipsisParameterDecl_StartIndex = input.index();

        Token IDENTIFIER6=null;
        RJavaSymbolTableParser.type_return type7 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return id; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:429:5: ( variableModifiers type '...' IDENTIFIER )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:429:9: variableModifiers type '...' IDENTIFIER
            {
            pushFollow(FOLLOW_variableModifiers_in_ellipsisParameterDecl3355);
            variableModifiers();

            state._fsp--;
            if (state.failed) return id;

            pushFollow(FOLLOW_type_in_ellipsisParameterDecl3365);
            type7=type();

            state._fsp--;
            if (state.failed) return id;

            match(input,ELLIPSIS,FOLLOW_ELLIPSIS_in_ellipsisParameterDecl3368); if (state.failed) return id;

            IDENTIFIER6=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_ellipsisParameterDecl3378); if (state.failed) return id;

            if ( state.backtracking==0 ) {id = new RIdentifier();
                    id.setId((IDENTIFIER6!=null?IDENTIFIER6.getText():null));
                    id.setType(RType.initWithClassName(klass, (type7!=null?input.toString(type7.start,type7.stop):null)));
                    id.setArray(true);
                    klass.newIdToCurrentBlock(id);}

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
        return id;
    }
    // $ANTLR end "ellipsisParameterDecl"



    // $ANTLR start "explicitConstructorInvocation"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:440:1: explicitConstructorInvocation : ( ( nonWildcardTypeArguments )? ( 'this' | 'super' ) arguments ';' | primary '.' ( nonWildcardTypeArguments )? 'super' arguments ';' );
    public final void explicitConstructorInvocation() throws RecognitionException {
        int explicitConstructorInvocation_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:441:5: ( ( nonWildcardTypeArguments )? ( 'this' | 'super' ) arguments ';' | primary '.' ( nonWildcardTypeArguments )? 'super' arguments ';' )
            int alt75=2;
            switch ( input.LA(1) ) {
            case LT:
                {
                alt75=1;
                }
                break;
            case THIS:
                {
                int LA75_2 = input.LA(2);

                if ( (synpred103_RJavaSymbolTable()) ) {
                    alt75=1;
                }
                else if ( (true) ) {
                    alt75=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 75, 2, input);

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
                alt75=2;
                }
                break;
            case SUPER:
                {
                int LA75_4 = input.LA(2);

                if ( (synpred103_RJavaSymbolTable()) ) {
                    alt75=1;
                }
                else if ( (true) ) {
                    alt75=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 75, 4, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;

            }

            switch (alt75) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:441:9: ( nonWildcardTypeArguments )? ( 'this' | 'super' ) arguments ';'
                    {
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:441:9: ( nonWildcardTypeArguments )?
                    int alt73=2;
                    int LA73_0 = input.LA(1);

                    if ( (LA73_0==LT) ) {
                        alt73=1;
                    }
                    switch (alt73) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:441:10: nonWildcardTypeArguments
                            {
                            pushFollow(FOLLOW_nonWildcardTypeArguments_in_explicitConstructorInvocation3410);
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


                    pushFollow(FOLLOW_arguments_in_explicitConstructorInvocation3468);
                    arguments();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,SEMI,FOLLOW_SEMI_in_explicitConstructorInvocation3470); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:448:9: primary '.' ( nonWildcardTypeArguments )? 'super' arguments ';'
                    {
                    pushFollow(FOLLOW_primary_in_explicitConstructorInvocation3481);
                    primary();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,DOT,FOLLOW_DOT_in_explicitConstructorInvocation3491); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:450:9: ( nonWildcardTypeArguments )?
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0==LT) ) {
                        alt74=1;
                    }
                    switch (alt74) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:450:10: nonWildcardTypeArguments
                            {
                            pushFollow(FOLLOW_nonWildcardTypeArguments_in_explicitConstructorInvocation3502);
                            nonWildcardTypeArguments();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,SUPER,FOLLOW_SUPER_in_explicitConstructorInvocation3523); if (state.failed) return ;

                    pushFollow(FOLLOW_arguments_in_explicitConstructorInvocation3533);
                    arguments();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,SEMI,FOLLOW_SEMI_in_explicitConstructorInvocation3535); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:456:1: qualifiedName : IDENTIFIER ( '.' IDENTIFIER )* ;
    public final void qualifiedName() throws RecognitionException {
        int qualifiedName_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:457:5: ( IDENTIFIER ( '.' IDENTIFIER )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:457:9: IDENTIFIER ( '.' IDENTIFIER )*
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_qualifiedName3555); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:458:9: ( '.' IDENTIFIER )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==DOT) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:458:10: '.' IDENTIFIER
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_qualifiedName3566); if (state.failed) return ;

            	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_qualifiedName3568); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop76;
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:462:1: annotations : ( annotation )+ ;
    public final void annotations() throws RecognitionException {
        int annotations_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:463:5: ( ( annotation )+ )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:463:9: ( annotation )+
            {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:463:9: ( annotation )+
            int cnt77=0;
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==MONKEYS_AT) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:463:10: annotation
            	    {
            	    pushFollow(FOLLOW_annotation_in_annotations3600);
            	    annotation();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt77 >= 1 ) break loop77;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(77, input);
                        throw eee;
                }
                cnt77++;
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:471:1: annotation : '@' qualifiedName ( '(' ( elementValuePairs | elementValue )? ')' )? ;
    public final void annotation() throws RecognitionException {
        int annotation_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:472:5: ( '@' qualifiedName ( '(' ( elementValuePairs | elementValue )? ')' )? )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:472:9: '@' qualifiedName ( '(' ( elementValuePairs | elementValue )? ')' )?
            {
            match(input,MONKEYS_AT,FOLLOW_MONKEYS_AT_in_annotation3633); if (state.failed) return ;

            pushFollow(FOLLOW_qualifiedName_in_annotation3635);
            qualifiedName();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:473:9: ( '(' ( elementValuePairs | elementValue )? ')' )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==LPAREN) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:473:13: '(' ( elementValuePairs | elementValue )? ')'
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_annotation3649); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:474:19: ( elementValuePairs | elementValue )?
                    int alt78=3;
                    int LA78_0 = input.LA(1);

                    if ( (LA78_0==IDENTIFIER) ) {
                        int LA78_1 = input.LA(2);

                        if ( (LA78_1==EQ) ) {
                            alt78=1;
                        }
                        else if ( ((LA78_1 >= AMP && LA78_1 <= AMPAMP)||(LA78_1 >= BANGEQ && LA78_1 <= BARBAR)||LA78_1==CARET||LA78_1==DOT||LA78_1==EQEQ||LA78_1==GT||LA78_1==INSTANCEOF||LA78_1==LBRACKET||(LA78_1 >= LPAREN && LA78_1 <= LT)||LA78_1==PERCENT||LA78_1==PLUS||LA78_1==PLUSPLUS||LA78_1==QUES||LA78_1==RPAREN||LA78_1==SLASH||LA78_1==STAR||LA78_1==SUB||LA78_1==SUBSUB) ) {
                            alt78=2;
                        }
                    }
                    else if ( (LA78_0==BANG||LA78_0==BOOLEAN||LA78_0==BYTE||(LA78_0 >= CHAR && LA78_0 <= CHARLITERAL)||(LA78_0 >= DOUBLE && LA78_0 <= DOUBLELITERAL)||LA78_0==FALSE||(LA78_0 >= FLOAT && LA78_0 <= FLOATLITERAL)||LA78_0==INT||LA78_0==INTLITERAL||LA78_0==LBRACE||(LA78_0 >= LONG && LA78_0 <= LPAREN)||LA78_0==MONKEYS_AT||(LA78_0 >= NEW && LA78_0 <= NULL)||LA78_0==PLUS||LA78_0==PLUSPLUS||LA78_0==SHORT||(LA78_0 >= STRINGLITERAL && LA78_0 <= SUB)||(LA78_0 >= SUBSUB && LA78_0 <= SUPER)||LA78_0==THIS||LA78_0==TILDE||LA78_0==TRUE||LA78_0==VOID) ) {
                        alt78=2;
                    }
                    switch (alt78) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:474:23: elementValuePairs
                            {
                            pushFollow(FOLLOW_elementValuePairs_in_annotation3676);
                            elementValuePairs();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;
                        case 2 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:475:23: elementValue
                            {
                            pushFollow(FOLLOW_elementValue_in_annotation3700);
                            elementValue();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,RPAREN,FOLLOW_RPAREN_in_annotation3736); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:481:1: elementValuePairs : elementValuePair ( ',' elementValuePair )* ;
    public final void elementValuePairs() throws RecognitionException {
        int elementValuePairs_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:482:5: ( elementValuePair ( ',' elementValuePair )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:482:9: elementValuePair ( ',' elementValuePair )*
            {
            pushFollow(FOLLOW_elementValuePair_in_elementValuePairs3768);
            elementValuePair();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:483:9: ( ',' elementValuePair )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==COMMA) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:483:10: ',' elementValuePair
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_elementValuePairs3779); if (state.failed) return ;

            	    pushFollow(FOLLOW_elementValuePair_in_elementValuePairs3781);
            	    elementValuePair();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop80;
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:487:1: elementValuePair : IDENTIFIER '=' elementValue ;
    public final void elementValuePair() throws RecognitionException {
        int elementValuePair_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:488:5: ( IDENTIFIER '=' elementValue )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:488:9: IDENTIFIER '=' elementValue
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_elementValuePair3812); if (state.failed) return ;

            match(input,EQ,FOLLOW_EQ_in_elementValuePair3814); if (state.failed) return ;

            pushFollow(FOLLOW_elementValue_in_elementValuePair3816);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:491:1: elementValue : ( conditionalExpression | annotation | elementValueArrayInitializer );
    public final void elementValue() throws RecognitionException {
        int elementValue_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:492:5: ( conditionalExpression | annotation | elementValueArrayInitializer )
            int alt81=3;
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
                alt81=1;
                }
                break;
            case MONKEYS_AT:
                {
                alt81=2;
                }
                break;
            case LBRACE:
                {
                alt81=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;

            }

            switch (alt81) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:492:9: conditionalExpression
                    {
                    pushFollow(FOLLOW_conditionalExpression_in_elementValue3836);
                    conditionalExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:493:9: annotation
                    {
                    pushFollow(FOLLOW_annotation_in_elementValue3846);
                    annotation();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:494:9: elementValueArrayInitializer
                    {
                    pushFollow(FOLLOW_elementValueArrayInitializer_in_elementValue3856);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:497:1: elementValueArrayInitializer : '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' ;
    public final void elementValueArrayInitializer() throws RecognitionException {
        int elementValueArrayInitializer_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:498:5: ( '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:498:9: '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}'
            {
            match(input,LBRACE,FOLLOW_LBRACE_in_elementValueArrayInitializer3876); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:499:9: ( elementValue ( ',' elementValue )* )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==BANG||LA83_0==BOOLEAN||LA83_0==BYTE||(LA83_0 >= CHAR && LA83_0 <= CHARLITERAL)||(LA83_0 >= DOUBLE && LA83_0 <= DOUBLELITERAL)||LA83_0==FALSE||(LA83_0 >= FLOAT && LA83_0 <= FLOATLITERAL)||LA83_0==IDENTIFIER||LA83_0==INT||LA83_0==INTLITERAL||LA83_0==LBRACE||(LA83_0 >= LONG && LA83_0 <= LPAREN)||LA83_0==MONKEYS_AT||(LA83_0 >= NEW && LA83_0 <= NULL)||LA83_0==PLUS||LA83_0==PLUSPLUS||LA83_0==SHORT||(LA83_0 >= STRINGLITERAL && LA83_0 <= SUB)||(LA83_0 >= SUBSUB && LA83_0 <= SUPER)||LA83_0==THIS||LA83_0==TILDE||LA83_0==TRUE||LA83_0==VOID) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:499:10: elementValue ( ',' elementValue )*
                    {
                    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer3887);
                    elementValue();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:500:13: ( ',' elementValue )*
                    loop82:
                    do {
                        int alt82=2;
                        int LA82_0 = input.LA(1);

                        if ( (LA82_0==COMMA) ) {
                            int LA82_1 = input.LA(2);

                            if ( (LA82_1==BANG||LA82_1==BOOLEAN||LA82_1==BYTE||(LA82_1 >= CHAR && LA82_1 <= CHARLITERAL)||(LA82_1 >= DOUBLE && LA82_1 <= DOUBLELITERAL)||LA82_1==FALSE||(LA82_1 >= FLOAT && LA82_1 <= FLOATLITERAL)||LA82_1==IDENTIFIER||LA82_1==INT||LA82_1==INTLITERAL||LA82_1==LBRACE||(LA82_1 >= LONG && LA82_1 <= LPAREN)||LA82_1==MONKEYS_AT||(LA82_1 >= NEW && LA82_1 <= NULL)||LA82_1==PLUS||LA82_1==PLUSPLUS||LA82_1==SHORT||(LA82_1 >= STRINGLITERAL && LA82_1 <= SUB)||(LA82_1 >= SUBSUB && LA82_1 <= SUPER)||LA82_1==THIS||LA82_1==TILDE||LA82_1==TRUE||LA82_1==VOID) ) {
                                alt82=1;
                            }


                        }


                        switch (alt82) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:500:14: ',' elementValue
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_elementValueArrayInitializer3902); if (state.failed) return ;

                    	    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer3904);
                    	    elementValue();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop82;
                        }
                    } while (true);


                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:502:12: ( ',' )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==COMMA) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:502:13: ','
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_elementValueArrayInitializer3933); if (state.failed) return ;

                    }
                    break;

            }


            match(input,RBRACE,FOLLOW_RBRACE_in_elementValueArrayInitializer3937); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:509:1: annotationTypeDeclaration : modifiers '@' 'interface' IDENTIFIER annotationTypeBody ;
    public final void annotationTypeDeclaration() throws RecognitionException {
        int annotationTypeDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:510:5: ( modifiers '@' 'interface' IDENTIFIER annotationTypeBody )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:510:9: modifiers '@' 'interface' IDENTIFIER annotationTypeBody
            {
            pushFollow(FOLLOW_modifiers_in_annotationTypeDeclaration3960);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            match(input,MONKEYS_AT,FOLLOW_MONKEYS_AT_in_annotationTypeDeclaration3962); if (state.failed) return ;

            match(input,INTERFACE,FOLLOW_INTERFACE_in_annotationTypeDeclaration3972); if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_annotationTypeDeclaration3982); if (state.failed) return ;

            pushFollow(FOLLOW_annotationTypeBody_in_annotationTypeDeclaration3992);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:517:1: annotationTypeBody : '{' ( annotationTypeElementDeclaration )* '}' ;
    public final void annotationTypeBody() throws RecognitionException {
        int annotationTypeBody_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:518:5: ( '{' ( annotationTypeElementDeclaration )* '}' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:518:9: '{' ( annotationTypeElementDeclaration )* '}'
            {
            match(input,LBRACE,FOLLOW_LBRACE_in_annotationTypeBody4013); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:519:9: ( annotationTypeElementDeclaration )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==ABSTRACT||LA85_0==BOOLEAN||LA85_0==BYTE||LA85_0==CHAR||LA85_0==CLASS||LA85_0==DOUBLE||LA85_0==ENUM||LA85_0==FINAL||LA85_0==FLOAT||LA85_0==IDENTIFIER||(LA85_0 >= INT && LA85_0 <= INTERFACE)||LA85_0==LONG||LA85_0==LT||(LA85_0 >= MONKEYS_AT && LA85_0 <= NATIVE)||(LA85_0 >= PRIVATE && LA85_0 <= PUBLIC)||(LA85_0 >= SEMI && LA85_0 <= SHORT)||(LA85_0 >= STATIC && LA85_0 <= STRICTFP)||LA85_0==SYNCHRONIZED||LA85_0==TRANSIENT||(LA85_0 >= VOID && LA85_0 <= VOLATILE)) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:519:10: annotationTypeElementDeclaration
            	    {
            	    pushFollow(FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody4025);
            	    annotationTypeElementDeclaration();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop85;
                }
            } while (true);


            match(input,RBRACE,FOLLOW_RBRACE_in_annotationTypeBody4047); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:527:1: annotationTypeElementDeclaration : ( annotationMethodDeclaration | interfaceFieldDeclaration | normalClassDeclaration | normalInterfaceDeclaration | enumDeclaration | annotationTypeDeclaration | ';' );
    public final void annotationTypeElementDeclaration() throws RecognitionException {
        int annotationTypeElementDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:528:5: ( annotationMethodDeclaration | interfaceFieldDeclaration | normalClassDeclaration | normalInterfaceDeclaration | enumDeclaration | annotationTypeDeclaration | ';' )
            int alt86=7;
            switch ( input.LA(1) ) {
            case MONKEYS_AT:
                {
                int LA86_1 = input.LA(2);

                if ( (synpred117_RJavaSymbolTable()) ) {
                    alt86=1;
                }
                else if ( (synpred118_RJavaSymbolTable()) ) {
                    alt86=2;
                }
                else if ( (synpred119_RJavaSymbolTable()) ) {
                    alt86=3;
                }
                else if ( (synpred120_RJavaSymbolTable()) ) {
                    alt86=4;
                }
                else if ( (synpred121_RJavaSymbolTable()) ) {
                    alt86=5;
                }
                else if ( (synpred122_RJavaSymbolTable()) ) {
                    alt86=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 86, 1, input);

                    throw nvae;

                }
                }
                break;
            case PUBLIC:
                {
                int LA86_2 = input.LA(2);

                if ( (synpred117_RJavaSymbolTable()) ) {
                    alt86=1;
                }
                else if ( (synpred118_RJavaSymbolTable()) ) {
                    alt86=2;
                }
                else if ( (synpred119_RJavaSymbolTable()) ) {
                    alt86=3;
                }
                else if ( (synpred120_RJavaSymbolTable()) ) {
                    alt86=4;
                }
                else if ( (synpred121_RJavaSymbolTable()) ) {
                    alt86=5;
                }
                else if ( (synpred122_RJavaSymbolTable()) ) {
                    alt86=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 86, 2, input);

                    throw nvae;

                }
                }
                break;
            case PROTECTED:
                {
                int LA86_3 = input.LA(2);

                if ( (synpred117_RJavaSymbolTable()) ) {
                    alt86=1;
                }
                else if ( (synpred118_RJavaSymbolTable()) ) {
                    alt86=2;
                }
                else if ( (synpred119_RJavaSymbolTable()) ) {
                    alt86=3;
                }
                else if ( (synpred120_RJavaSymbolTable()) ) {
                    alt86=4;
                }
                else if ( (synpred121_RJavaSymbolTable()) ) {
                    alt86=5;
                }
                else if ( (synpred122_RJavaSymbolTable()) ) {
                    alt86=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 86, 3, input);

                    throw nvae;

                }
                }
                break;
            case PRIVATE:
                {
                int LA86_4 = input.LA(2);

                if ( (synpred117_RJavaSymbolTable()) ) {
                    alt86=1;
                }
                else if ( (synpred118_RJavaSymbolTable()) ) {
                    alt86=2;
                }
                else if ( (synpred119_RJavaSymbolTable()) ) {
                    alt86=3;
                }
                else if ( (synpred120_RJavaSymbolTable()) ) {
                    alt86=4;
                }
                else if ( (synpred121_RJavaSymbolTable()) ) {
                    alt86=5;
                }
                else if ( (synpred122_RJavaSymbolTable()) ) {
                    alt86=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 86, 4, input);

                    throw nvae;

                }
                }
                break;
            case STATIC:
                {
                int LA86_5 = input.LA(2);

                if ( (synpred117_RJavaSymbolTable()) ) {
                    alt86=1;
                }
                else if ( (synpred118_RJavaSymbolTable()) ) {
                    alt86=2;
                }
                else if ( (synpred119_RJavaSymbolTable()) ) {
                    alt86=3;
                }
                else if ( (synpred120_RJavaSymbolTable()) ) {
                    alt86=4;
                }
                else if ( (synpred121_RJavaSymbolTable()) ) {
                    alt86=5;
                }
                else if ( (synpred122_RJavaSymbolTable()) ) {
                    alt86=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 86, 5, input);

                    throw nvae;

                }
                }
                break;
            case ABSTRACT:
                {
                int LA86_6 = input.LA(2);

                if ( (synpred117_RJavaSymbolTable()) ) {
                    alt86=1;
                }
                else if ( (synpred118_RJavaSymbolTable()) ) {
                    alt86=2;
                }
                else if ( (synpred119_RJavaSymbolTable()) ) {
                    alt86=3;
                }
                else if ( (synpred120_RJavaSymbolTable()) ) {
                    alt86=4;
                }
                else if ( (synpred121_RJavaSymbolTable()) ) {
                    alt86=5;
                }
                else if ( (synpred122_RJavaSymbolTable()) ) {
                    alt86=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 86, 6, input);

                    throw nvae;

                }
                }
                break;
            case FINAL:
                {
                int LA86_7 = input.LA(2);

                if ( (synpred117_RJavaSymbolTable()) ) {
                    alt86=1;
                }
                else if ( (synpred118_RJavaSymbolTable()) ) {
                    alt86=2;
                }
                else if ( (synpred119_RJavaSymbolTable()) ) {
                    alt86=3;
                }
                else if ( (synpred120_RJavaSymbolTable()) ) {
                    alt86=4;
                }
                else if ( (synpred121_RJavaSymbolTable()) ) {
                    alt86=5;
                }
                else if ( (synpred122_RJavaSymbolTable()) ) {
                    alt86=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 86, 7, input);

                    throw nvae;

                }
                }
                break;
            case NATIVE:
                {
                int LA86_8 = input.LA(2);

                if ( (synpred117_RJavaSymbolTable()) ) {
                    alt86=1;
                }
                else if ( (synpred118_RJavaSymbolTable()) ) {
                    alt86=2;
                }
                else if ( (synpred119_RJavaSymbolTable()) ) {
                    alt86=3;
                }
                else if ( (synpred120_RJavaSymbolTable()) ) {
                    alt86=4;
                }
                else if ( (synpred121_RJavaSymbolTable()) ) {
                    alt86=5;
                }
                else if ( (synpred122_RJavaSymbolTable()) ) {
                    alt86=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 86, 8, input);

                    throw nvae;

                }
                }
                break;
            case SYNCHRONIZED:
                {
                int LA86_9 = input.LA(2);

                if ( (synpred117_RJavaSymbolTable()) ) {
                    alt86=1;
                }
                else if ( (synpred118_RJavaSymbolTable()) ) {
                    alt86=2;
                }
                else if ( (synpred119_RJavaSymbolTable()) ) {
                    alt86=3;
                }
                else if ( (synpred120_RJavaSymbolTable()) ) {
                    alt86=4;
                }
                else if ( (synpred121_RJavaSymbolTable()) ) {
                    alt86=5;
                }
                else if ( (synpred122_RJavaSymbolTable()) ) {
                    alt86=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 86, 9, input);

                    throw nvae;

                }
                }
                break;
            case TRANSIENT:
                {
                int LA86_10 = input.LA(2);

                if ( (synpred117_RJavaSymbolTable()) ) {
                    alt86=1;
                }
                else if ( (synpred118_RJavaSymbolTable()) ) {
                    alt86=2;
                }
                else if ( (synpred119_RJavaSymbolTable()) ) {
                    alt86=3;
                }
                else if ( (synpred120_RJavaSymbolTable()) ) {
                    alt86=4;
                }
                else if ( (synpred121_RJavaSymbolTable()) ) {
                    alt86=5;
                }
                else if ( (synpred122_RJavaSymbolTable()) ) {
                    alt86=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 86, 10, input);

                    throw nvae;

                }
                }
                break;
            case VOLATILE:
                {
                int LA86_11 = input.LA(2);

                if ( (synpred117_RJavaSymbolTable()) ) {
                    alt86=1;
                }
                else if ( (synpred118_RJavaSymbolTable()) ) {
                    alt86=2;
                }
                else if ( (synpred119_RJavaSymbolTable()) ) {
                    alt86=3;
                }
                else if ( (synpred120_RJavaSymbolTable()) ) {
                    alt86=4;
                }
                else if ( (synpred121_RJavaSymbolTable()) ) {
                    alt86=5;
                }
                else if ( (synpred122_RJavaSymbolTable()) ) {
                    alt86=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 86, 11, input);

                    throw nvae;

                }
                }
                break;
            case STRICTFP:
                {
                int LA86_12 = input.LA(2);

                if ( (synpred117_RJavaSymbolTable()) ) {
                    alt86=1;
                }
                else if ( (synpred118_RJavaSymbolTable()) ) {
                    alt86=2;
                }
                else if ( (synpred119_RJavaSymbolTable()) ) {
                    alt86=3;
                }
                else if ( (synpred120_RJavaSymbolTable()) ) {
                    alt86=4;
                }
                else if ( (synpred121_RJavaSymbolTable()) ) {
                    alt86=5;
                }
                else if ( (synpred122_RJavaSymbolTable()) ) {
                    alt86=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 86, 12, input);

                    throw nvae;

                }
                }
                break;
            case IDENTIFIER:
                {
                int LA86_13 = input.LA(2);

                if ( (synpred117_RJavaSymbolTable()) ) {
                    alt86=1;
                }
                else if ( (synpred118_RJavaSymbolTable()) ) {
                    alt86=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 86, 13, input);

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
                int LA86_14 = input.LA(2);

                if ( (synpred117_RJavaSymbolTable()) ) {
                    alt86=1;
                }
                else if ( (synpred118_RJavaSymbolTable()) ) {
                    alt86=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 86, 14, input);

                    throw nvae;

                }
                }
                break;
            case CLASS:
                {
                alt86=3;
                }
                break;
            case INTERFACE:
                {
                alt86=4;
                }
                break;
            case ENUM:
                {
                alt86=5;
                }
                break;
            case SEMI:
                {
                alt86=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;

            }

            switch (alt86) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:528:9: annotationMethodDeclaration
                    {
                    pushFollow(FOLLOW_annotationMethodDeclaration_in_annotationTypeElementDeclaration4069);
                    annotationMethodDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:529:9: interfaceFieldDeclaration
                    {
                    pushFollow(FOLLOW_interfaceFieldDeclaration_in_annotationTypeElementDeclaration4079);
                    interfaceFieldDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:530:9: normalClassDeclaration
                    {
                    pushFollow(FOLLOW_normalClassDeclaration_in_annotationTypeElementDeclaration4089);
                    normalClassDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:531:9: normalInterfaceDeclaration
                    {
                    pushFollow(FOLLOW_normalInterfaceDeclaration_in_annotationTypeElementDeclaration4099);
                    normalInterfaceDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:532:9: enumDeclaration
                    {
                    pushFollow(FOLLOW_enumDeclaration_in_annotationTypeElementDeclaration4109);
                    enumDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:533:9: annotationTypeDeclaration
                    {
                    pushFollow(FOLLOW_annotationTypeDeclaration_in_annotationTypeElementDeclaration4119);
                    annotationTypeDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:534:9: ';'
                    {
                    match(input,SEMI,FOLLOW_SEMI_in_annotationTypeElementDeclaration4129); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:537:1: annotationMethodDeclaration : modifiers type IDENTIFIER '(' ')' ( 'default' elementValue )? ';' ;
    public final void annotationMethodDeclaration() throws RecognitionException {
        int annotationMethodDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:538:5: ( modifiers type IDENTIFIER '(' ')' ( 'default' elementValue )? ';' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:538:9: modifiers type IDENTIFIER '(' ')' ( 'default' elementValue )? ';'
            {
            pushFollow(FOLLOW_modifiers_in_annotationMethodDeclaration4149);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_type_in_annotationMethodDeclaration4151);
            type();

            state._fsp--;
            if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_annotationMethodDeclaration4153); if (state.failed) return ;

            match(input,LPAREN,FOLLOW_LPAREN_in_annotationMethodDeclaration4163); if (state.failed) return ;

            match(input,RPAREN,FOLLOW_RPAREN_in_annotationMethodDeclaration4165); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:539:17: ( 'default' elementValue )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==DEFAULT) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:539:18: 'default' elementValue
                    {
                    match(input,DEFAULT,FOLLOW_DEFAULT_in_annotationMethodDeclaration4168); if (state.failed) return ;

                    pushFollow(FOLLOW_elementValue_in_annotationMethodDeclaration4170);
                    elementValue();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            match(input,SEMI,FOLLOW_SEMI_in_annotationMethodDeclaration4199); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:544:1: block : '{' ( blockStatement )* '}' ;
    public final void block() throws RecognitionException {
        int block_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:545:5: ( '{' ( blockStatement )* '}' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:545:9: '{' ( blockStatement )* '}'
            {
            if ( state.backtracking==0 ) {klass.newBlock(RBlock.IN_METHOD);}

            match(input,LBRACE,FOLLOW_LBRACE_in_block4233); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:547:9: ( blockStatement )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==ABSTRACT||(LA88_0 >= ASSERT && LA88_0 <= BANG)||(LA88_0 >= BOOLEAN && LA88_0 <= BYTE)||(LA88_0 >= CHAR && LA88_0 <= CLASS)||LA88_0==CONTINUE||LA88_0==DO||(LA88_0 >= DOUBLE && LA88_0 <= DOUBLELITERAL)||LA88_0==ENUM||(LA88_0 >= FALSE && LA88_0 <= FINAL)||(LA88_0 >= FLOAT && LA88_0 <= FOR)||(LA88_0 >= IDENTIFIER && LA88_0 <= IF)||(LA88_0 >= INT && LA88_0 <= INTLITERAL)||LA88_0==LBRACE||(LA88_0 >= LONG && LA88_0 <= LT)||(LA88_0 >= MONKEYS_AT && LA88_0 <= NULL)||LA88_0==PLUS||(LA88_0 >= PLUSPLUS && LA88_0 <= PUBLIC)||LA88_0==RETURN||(LA88_0 >= SEMI && LA88_0 <= SHORT)||(LA88_0 >= STATIC && LA88_0 <= SUB)||(LA88_0 >= SUBSUB && LA88_0 <= SYNCHRONIZED)||(LA88_0 >= THIS && LA88_0 <= THROW)||(LA88_0 >= TILDE && LA88_0 <= WHILE)) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:547:10: blockStatement
            	    {
            	    pushFollow(FOLLOW_blockStatement_in_block4244);
            	    blockStatement();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop88;
                }
            } while (true);


            match(input,RBRACE,FOLLOW_RBRACE_in_block4265); if (state.failed) return ;

            if ( state.backtracking==0 ) {klass.backToUpperBlock();}

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:577:1: blockStatement : ( localVariableDeclarationStatement | classOrInterfaceDeclaration | statement );
    public final void blockStatement() throws RecognitionException {
        int blockStatement_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:578:5: ( localVariableDeclarationStatement | classOrInterfaceDeclaration | statement )
            int alt89=3;
            switch ( input.LA(1) ) {
            case FINAL:
                {
                int LA89_1 = input.LA(2);

                if ( (synpred125_RJavaSymbolTable()) ) {
                    alt89=1;
                }
                else if ( (synpred126_RJavaSymbolTable()) ) {
                    alt89=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 89, 1, input);

                    throw nvae;

                }
                }
                break;
            case MONKEYS_AT:
                {
                int LA89_2 = input.LA(2);

                if ( (synpred125_RJavaSymbolTable()) ) {
                    alt89=1;
                }
                else if ( (synpred126_RJavaSymbolTable()) ) {
                    alt89=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 89, 2, input);

                    throw nvae;

                }
                }
                break;
            case IDENTIFIER:
                {
                int LA89_3 = input.LA(2);

                if ( (synpred125_RJavaSymbolTable()) ) {
                    alt89=1;
                }
                else if ( (true) ) {
                    alt89=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 89, 3, input);

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
                int LA89_4 = input.LA(2);

                if ( (synpred125_RJavaSymbolTable()) ) {
                    alt89=1;
                }
                else if ( (true) ) {
                    alt89=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 89, 4, input);

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
                alt89=2;
                }
                break;
            case SYNCHRONIZED:
                {
                int LA89_11 = input.LA(2);

                if ( (synpred126_RJavaSymbolTable()) ) {
                    alt89=2;
                }
                else if ( (true) ) {
                    alt89=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 89, 11, input);

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
                alt89=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;

            }

            switch (alt89) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:578:9: localVariableDeclarationStatement
                    {
                    pushFollow(FOLLOW_localVariableDeclarationStatement_in_blockStatement4297);
                    localVariableDeclarationStatement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:579:9: classOrInterfaceDeclaration
                    {
                    pushFollow(FOLLOW_classOrInterfaceDeclaration_in_blockStatement4307);
                    classOrInterfaceDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:580:9: statement
                    {
                    pushFollow(FOLLOW_statement_in_blockStatement4317);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:584:1: localVariableDeclarationStatement : localVariableDeclaration ';' ;
    public final void localVariableDeclarationStatement() throws RecognitionException {
        int localVariableDeclarationStatement_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:585:5: ( localVariableDeclaration ';' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:585:9: localVariableDeclaration ';'
            {
            pushFollow(FOLLOW_localVariableDeclaration_in_localVariableDeclarationStatement4338);
            localVariableDeclaration();

            state._fsp--;
            if (state.failed) return ;

            match(input,SEMI,FOLLOW_SEMI_in_localVariableDeclarationStatement4348); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:589:1: localVariableDeclaration : variableModifiers type variableDeclarator ( ',' variableDeclarator )* ;
    public final void localVariableDeclaration() throws RecognitionException {
        int localVariableDeclaration_StartIndex = input.index();

        RJavaSymbolTableParser.type_return type8 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:590:5: ( variableModifiers type variableDeclarator ( ',' variableDeclarator )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:590:9: variableModifiers type variableDeclarator ( ',' variableDeclarator )*
            {
            pushFollow(FOLLOW_variableModifiers_in_localVariableDeclaration4368);
            variableModifiers();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_type_in_localVariableDeclaration4370);
            type8=type();

            state._fsp--;
            if (state.failed) return ;

            if ( state.backtracking==0 ) {type = (type8!=null?input.toString(type8.start,type8.stop):null);}

            pushFollow(FOLLOW_variableDeclarator_in_localVariableDeclaration4382);
            variableDeclarator();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:592:9: ( ',' variableDeclarator )*
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==COMMA) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:592:10: ',' variableDeclarator
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_localVariableDeclaration4393); if (state.failed) return ;

            	    pushFollow(FOLLOW_variableDeclarator_in_localVariableDeclaration4395);
            	    variableDeclarator();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop90;
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:596:1: statement : ( block | ( 'assert' ) expression ( ':' expression )? ';' | 'assert' expression ( ':' expression )? ';' | 'if' parExpression statement ( 'else' statement )? | forstatement | 'while' parExpression statement | 'do' statement 'while' parExpression ';' | trystatement | 'switch' parExpression '{' switchBlockStatementGroups '}' | 'synchronized' parExpression block | 'return' ( expression )? ';' | 'throw' expression ';' | 'break' ( IDENTIFIER )? ';' | 'continue' ( IDENTIFIER )? ';' | expression ';' | IDENTIFIER ':' statement | ';' );
    public final void statement() throws RecognitionException {
        int statement_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:597:5: ( block | ( 'assert' ) expression ( ':' expression )? ';' | 'assert' expression ( ':' expression )? ';' | 'if' parExpression statement ( 'else' statement )? | forstatement | 'while' parExpression statement | 'do' statement 'while' parExpression ';' | trystatement | 'switch' parExpression '{' switchBlockStatementGroups '}' | 'synchronized' parExpression block | 'return' ( expression )? ';' | 'throw' expression ';' | 'break' ( IDENTIFIER )? ';' | 'continue' ( IDENTIFIER )? ';' | expression ';' | IDENTIFIER ':' statement | ';' )
            int alt97=17;
            switch ( input.LA(1) ) {
            case LBRACE:
                {
                alt97=1;
                }
                break;
            case ASSERT:
                {
                int LA97_2 = input.LA(2);

                if ( (synpred130_RJavaSymbolTable()) ) {
                    alt97=2;
                }
                else if ( (synpred132_RJavaSymbolTable()) ) {
                    alt97=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 97, 2, input);

                    throw nvae;

                }
                }
                break;
            case IF:
                {
                alt97=4;
                }
                break;
            case FOR:
                {
                alt97=5;
                }
                break;
            case WHILE:
                {
                alt97=6;
                }
                break;
            case DO:
                {
                alt97=7;
                }
                break;
            case TRY:
                {
                alt97=8;
                }
                break;
            case SWITCH:
                {
                alt97=9;
                }
                break;
            case SYNCHRONIZED:
                {
                alt97=10;
                }
                break;
            case RETURN:
                {
                alt97=11;
                }
                break;
            case THROW:
                {
                alt97=12;
                }
                break;
            case BREAK:
                {
                alt97=13;
                }
                break;
            case CONTINUE:
                {
                alt97=14;
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
                alt97=15;
                }
                break;
            case IDENTIFIER:
                {
                int LA97_22 = input.LA(2);

                if ( (synpred148_RJavaSymbolTable()) ) {
                    alt97=15;
                }
                else if ( (synpred149_RJavaSymbolTable()) ) {
                    alt97=16;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 97, 22, input);

                    throw nvae;

                }
                }
                break;
            case SEMI:
                {
                alt97=17;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 97, 0, input);

                throw nvae;

            }

            switch (alt97) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:597:9: block
                    {
                    pushFollow(FOLLOW_block_in_statement4426);
                    block();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:599:9: ( 'assert' ) expression ( ':' expression )? ';'
                    {
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:599:9: ( 'assert' )
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:599:10: 'assert'
                    {
                    match(input,ASSERT,FOLLOW_ASSERT_in_statement4450); if (state.failed) return ;

                    }


                    pushFollow(FOLLOW_expression_in_statement4470);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:601:20: ( ':' expression )?
                    int alt91=2;
                    int LA91_0 = input.LA(1);

                    if ( (LA91_0==COLON) ) {
                        alt91=1;
                    }
                    switch (alt91) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:601:21: ':' expression
                            {
                            match(input,COLON,FOLLOW_COLON_in_statement4473); if (state.failed) return ;

                            pushFollow(FOLLOW_expression_in_statement4475);
                            expression();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,SEMI,FOLLOW_SEMI_in_statement4479); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:602:9: 'assert' expression ( ':' expression )? ';'
                    {
                    match(input,ASSERT,FOLLOW_ASSERT_in_statement4489); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_statement4492);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:602:30: ( ':' expression )?
                    int alt92=2;
                    int LA92_0 = input.LA(1);

                    if ( (LA92_0==COLON) ) {
                        alt92=1;
                    }
                    switch (alt92) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:602:31: ':' expression
                            {
                            match(input,COLON,FOLLOW_COLON_in_statement4495); if (state.failed) return ;

                            pushFollow(FOLLOW_expression_in_statement4497);
                            expression();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,SEMI,FOLLOW_SEMI_in_statement4501); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:603:9: 'if' parExpression statement ( 'else' statement )?
                    {
                    match(input,IF,FOLLOW_IF_in_statement4523); if (state.failed) return ;

                    pushFollow(FOLLOW_parExpression_in_statement4525);
                    parExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    pushFollow(FOLLOW_statement_in_statement4527);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:603:38: ( 'else' statement )?
                    int alt93=2;
                    int LA93_0 = input.LA(1);

                    if ( (LA93_0==ELSE) ) {
                        int LA93_1 = input.LA(2);

                        if ( (synpred133_RJavaSymbolTable()) ) {
                            alt93=1;
                        }
                    }
                    switch (alt93) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:603:39: 'else' statement
                            {
                            match(input,ELSE,FOLLOW_ELSE_in_statement4530); if (state.failed) return ;

                            pushFollow(FOLLOW_statement_in_statement4532);
                            statement();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 5 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:604:9: forstatement
                    {
                    pushFollow(FOLLOW_forstatement_in_statement4554);
                    forstatement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:605:9: 'while' parExpression statement
                    {
                    match(input,WHILE,FOLLOW_WHILE_in_statement4564); if (state.failed) return ;

                    pushFollow(FOLLOW_parExpression_in_statement4566);
                    parExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    pushFollow(FOLLOW_statement_in_statement4568);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:606:9: 'do' statement 'while' parExpression ';'
                    {
                    match(input,DO,FOLLOW_DO_in_statement4578); if (state.failed) return ;

                    pushFollow(FOLLOW_statement_in_statement4580);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,WHILE,FOLLOW_WHILE_in_statement4582); if (state.failed) return ;

                    pushFollow(FOLLOW_parExpression_in_statement4584);
                    parExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,SEMI,FOLLOW_SEMI_in_statement4586); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:607:9: trystatement
                    {
                    pushFollow(FOLLOW_trystatement_in_statement4596);
                    trystatement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 9 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:608:9: 'switch' parExpression '{' switchBlockStatementGroups '}'
                    {
                    match(input,SWITCH,FOLLOW_SWITCH_in_statement4606); if (state.failed) return ;

                    pushFollow(FOLLOW_parExpression_in_statement4608);
                    parExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,LBRACE,FOLLOW_LBRACE_in_statement4610); if (state.failed) return ;

                    pushFollow(FOLLOW_switchBlockStatementGroups_in_statement4612);
                    switchBlockStatementGroups();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,RBRACE,FOLLOW_RBRACE_in_statement4614); if (state.failed) return ;

                    }
                    break;
                case 10 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:609:9: 'synchronized' parExpression block
                    {
                    match(input,SYNCHRONIZED,FOLLOW_SYNCHRONIZED_in_statement4624); if (state.failed) return ;

                    pushFollow(FOLLOW_parExpression_in_statement4626);
                    parExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    pushFollow(FOLLOW_block_in_statement4628);
                    block();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 11 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:610:9: 'return' ( expression )? ';'
                    {
                    match(input,RETURN,FOLLOW_RETURN_in_statement4638); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:610:18: ( expression )?
                    int alt94=2;
                    int LA94_0 = input.LA(1);

                    if ( (LA94_0==BANG||LA94_0==BOOLEAN||LA94_0==BYTE||(LA94_0 >= CHAR && LA94_0 <= CHARLITERAL)||(LA94_0 >= DOUBLE && LA94_0 <= DOUBLELITERAL)||LA94_0==FALSE||(LA94_0 >= FLOAT && LA94_0 <= FLOATLITERAL)||LA94_0==IDENTIFIER||LA94_0==INT||LA94_0==INTLITERAL||(LA94_0 >= LONG && LA94_0 <= LPAREN)||(LA94_0 >= NEW && LA94_0 <= NULL)||LA94_0==PLUS||LA94_0==PLUSPLUS||LA94_0==SHORT||(LA94_0 >= STRINGLITERAL && LA94_0 <= SUB)||(LA94_0 >= SUBSUB && LA94_0 <= SUPER)||LA94_0==THIS||LA94_0==TILDE||LA94_0==TRUE||LA94_0==VOID) ) {
                        alt94=1;
                    }
                    switch (alt94) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:610:19: expression
                            {
                            pushFollow(FOLLOW_expression_in_statement4641);
                            expression();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,SEMI,FOLLOW_SEMI_in_statement4646); if (state.failed) return ;

                    }
                    break;
                case 12 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:611:9: 'throw' expression ';'
                    {
                    match(input,THROW,FOLLOW_THROW_in_statement4656); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_statement4658);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,SEMI,FOLLOW_SEMI_in_statement4660); if (state.failed) return ;

                    }
                    break;
                case 13 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:612:9: 'break' ( IDENTIFIER )? ';'
                    {
                    match(input,BREAK,FOLLOW_BREAK_in_statement4670); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:613:13: ( IDENTIFIER )?
                    int alt95=2;
                    int LA95_0 = input.LA(1);

                    if ( (LA95_0==IDENTIFIER) ) {
                        alt95=1;
                    }
                    switch (alt95) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:613:14: IDENTIFIER
                            {
                            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_statement4685); if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,SEMI,FOLLOW_SEMI_in_statement4702); if (state.failed) return ;

                    }
                    break;
                case 14 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:615:9: 'continue' ( IDENTIFIER )? ';'
                    {
                    match(input,CONTINUE,FOLLOW_CONTINUE_in_statement4712); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:616:13: ( IDENTIFIER )?
                    int alt96=2;
                    int LA96_0 = input.LA(1);

                    if ( (LA96_0==IDENTIFIER) ) {
                        alt96=1;
                    }
                    switch (alt96) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:616:14: IDENTIFIER
                            {
                            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_statement4727); if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,SEMI,FOLLOW_SEMI_in_statement4744); if (state.failed) return ;

                    }
                    break;
                case 15 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:618:9: expression ';'
                    {
                    pushFollow(FOLLOW_expression_in_statement4754);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,SEMI,FOLLOW_SEMI_in_statement4757); if (state.failed) return ;

                    }
                    break;
                case 16 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:619:9: IDENTIFIER ':' statement
                    {
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_statement4772); if (state.failed) return ;

                    match(input,COLON,FOLLOW_COLON_in_statement4774); if (state.failed) return ;

                    pushFollow(FOLLOW_statement_in_statement4776);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 17 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:620:9: ';'
                    {
                    match(input,SEMI,FOLLOW_SEMI_in_statement4786); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:624:1: switchBlockStatementGroups : ( switchBlockStatementGroup )* ;
    public final void switchBlockStatementGroups() throws RecognitionException {
        int switchBlockStatementGroups_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:625:5: ( ( switchBlockStatementGroup )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:625:9: ( switchBlockStatementGroup )*
            {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:625:9: ( switchBlockStatementGroup )*
            loop98:
            do {
                int alt98=2;
                int LA98_0 = input.LA(1);

                if ( (LA98_0==CASE||LA98_0==DEFAULT) ) {
                    alt98=1;
                }


                switch (alt98) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:625:10: switchBlockStatementGroup
            	    {
            	    pushFollow(FOLLOW_switchBlockStatementGroup_in_switchBlockStatementGroups4808);
            	    switchBlockStatementGroup();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop98;
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:628:1: switchBlockStatementGroup : switchLabel ( blockStatement )* ;
    public final void switchBlockStatementGroup() throws RecognitionException {
        int switchBlockStatementGroup_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:629:5: ( switchLabel ( blockStatement )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:630:9: switchLabel ( blockStatement )*
            {
            pushFollow(FOLLOW_switchLabel_in_switchBlockStatementGroup4837);
            switchLabel();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:631:9: ( blockStatement )*
            loop99:
            do {
                int alt99=2;
                int LA99_0 = input.LA(1);

                if ( (LA99_0==ABSTRACT||(LA99_0 >= ASSERT && LA99_0 <= BANG)||(LA99_0 >= BOOLEAN && LA99_0 <= BYTE)||(LA99_0 >= CHAR && LA99_0 <= CLASS)||LA99_0==CONTINUE||LA99_0==DO||(LA99_0 >= DOUBLE && LA99_0 <= DOUBLELITERAL)||LA99_0==ENUM||(LA99_0 >= FALSE && LA99_0 <= FINAL)||(LA99_0 >= FLOAT && LA99_0 <= FOR)||(LA99_0 >= IDENTIFIER && LA99_0 <= IF)||(LA99_0 >= INT && LA99_0 <= INTLITERAL)||LA99_0==LBRACE||(LA99_0 >= LONG && LA99_0 <= LT)||(LA99_0 >= MONKEYS_AT && LA99_0 <= NULL)||LA99_0==PLUS||(LA99_0 >= PLUSPLUS && LA99_0 <= PUBLIC)||LA99_0==RETURN||(LA99_0 >= SEMI && LA99_0 <= SHORT)||(LA99_0 >= STATIC && LA99_0 <= SUB)||(LA99_0 >= SUBSUB && LA99_0 <= SYNCHRONIZED)||(LA99_0 >= THIS && LA99_0 <= THROW)||(LA99_0 >= TILDE && LA99_0 <= WHILE)) ) {
                    alt99=1;
                }


                switch (alt99) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:631:10: blockStatement
            	    {
            	    pushFollow(FOLLOW_blockStatement_in_switchBlockStatementGroup4848);
            	    blockStatement();

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
            if ( state.backtracking>0 ) { memoize(input, 60, switchBlockStatementGroup_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "switchBlockStatementGroup"



    // $ANTLR start "switchLabel"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:635:1: switchLabel : ( 'case' expression ':' | 'default' ':' );
    public final void switchLabel() throws RecognitionException {
        int switchLabel_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:636:5: ( 'case' expression ':' | 'default' ':' )
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==CASE) ) {
                alt100=1;
            }
            else if ( (LA100_0==DEFAULT) ) {
                alt100=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;

            }
            switch (alt100) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:636:9: 'case' expression ':'
                    {
                    match(input,CASE,FOLLOW_CASE_in_switchLabel4879); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_switchLabel4881);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,COLON,FOLLOW_COLON_in_switchLabel4883); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:637:9: 'default' ':'
                    {
                    match(input,DEFAULT,FOLLOW_DEFAULT_in_switchLabel4893); if (state.failed) return ;

                    match(input,COLON,FOLLOW_COLON_in_switchLabel4895); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:641:1: trystatement : 'try' block ( catches 'finally' block | catches | 'finally' block ) ;
    public final void trystatement() throws RecognitionException {
        int trystatement_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:642:5: ( 'try' block ( catches 'finally' block | catches | 'finally' block ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:642:9: 'try' block ( catches 'finally' block | catches | 'finally' block )
            {
            match(input,TRY,FOLLOW_TRY_in_trystatement4916); if (state.failed) return ;

            pushFollow(FOLLOW_block_in_trystatement4918);
            block();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:643:9: ( catches 'finally' block | catches | 'finally' block )
            int alt101=3;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==CATCH) ) {
                int LA101_1 = input.LA(2);

                if ( (synpred153_RJavaSymbolTable()) ) {
                    alt101=1;
                }
                else if ( (synpred154_RJavaSymbolTable()) ) {
                    alt101=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 101, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA101_0==FINALLY) ) {
                alt101=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;

            }
            switch (alt101) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:643:13: catches 'finally' block
                    {
                    pushFollow(FOLLOW_catches_in_trystatement4932);
                    catches();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,FINALLY,FOLLOW_FINALLY_in_trystatement4934); if (state.failed) return ;

                    pushFollow(FOLLOW_block_in_trystatement4936);
                    block();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:644:13: catches
                    {
                    pushFollow(FOLLOW_catches_in_trystatement4950);
                    catches();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:645:13: 'finally' block
                    {
                    match(input,FINALLY,FOLLOW_FINALLY_in_trystatement4964); if (state.failed) return ;

                    pushFollow(FOLLOW_block_in_trystatement4966);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:649:1: catches : catchClause ( catchClause )* ;
    public final void catches() throws RecognitionException {
        int catches_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:650:5: ( catchClause ( catchClause )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:650:9: catchClause ( catchClause )*
            {
            pushFollow(FOLLOW_catchClause_in_catches4997);
            catchClause();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:651:9: ( catchClause )*
            loop102:
            do {
                int alt102=2;
                int LA102_0 = input.LA(1);

                if ( (LA102_0==CATCH) ) {
                    alt102=1;
                }


                switch (alt102) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:651:10: catchClause
            	    {
            	    pushFollow(FOLLOW_catchClause_in_catches5008);
            	    catchClause();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop102;
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:655:1: catchClause : 'catch' '(' formalParameter ')' block ;
    public final void catchClause() throws RecognitionException {
        int catchClause_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:656:5: ( 'catch' '(' formalParameter ')' block )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:656:9: 'catch' '(' formalParameter ')' block
            {
            match(input,CATCH,FOLLOW_CATCH_in_catchClause5039); if (state.failed) return ;

            match(input,LPAREN,FOLLOW_LPAREN_in_catchClause5041); if (state.failed) return ;

            pushFollow(FOLLOW_formalParameter_in_catchClause5043);
            formalParameter();

            state._fsp--;
            if (state.failed) return ;

            match(input,RPAREN,FOLLOW_RPAREN_in_catchClause5053); if (state.failed) return ;

            pushFollow(FOLLOW_block_in_catchClause5055);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:660:1: formalParameter : variableModifiers type IDENTIFIER ( '[' ']' )* ;
    public final void formalParameter() throws RecognitionException {
        int formalParameter_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:661:5: ( variableModifiers type IDENTIFIER ( '[' ']' )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:661:9: variableModifiers type IDENTIFIER ( '[' ']' )*
            {
            pushFollow(FOLLOW_variableModifiers_in_formalParameter5076);
            variableModifiers();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_type_in_formalParameter5078);
            type();

            state._fsp--;
            if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_formalParameter5080); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:662:9: ( '[' ']' )*
            loop103:
            do {
                int alt103=2;
                int LA103_0 = input.LA(1);

                if ( (LA103_0==LBRACKET) ) {
                    alt103=1;
                }


                switch (alt103) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:662:10: '[' ']'
            	    {
            	    match(input,LBRACKET,FOLLOW_LBRACKET_in_formalParameter5091); if (state.failed) return ;

            	    match(input,RBRACKET,FOLLOW_RBRACKET_in_formalParameter5093); if (state.failed) return ;

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
            if ( state.backtracking>0 ) { memoize(input, 65, formalParameter_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "formalParameter"



    // $ANTLR start "forstatement"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:666:1: forstatement : ( 'for' '(' variableModifiers type IDENTIFIER ':' expression ')' statement | 'for' '(' ( forInit )? ';' ( expression )? ';' ( expressionList )? ')' statement );
    public final void forstatement() throws RecognitionException {
        int forstatement_StartIndex = input.index();

        Token IDENTIFIER10=null;
        RJavaSymbolTableParser.type_return type9 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:667:5: ( 'for' '(' variableModifiers type IDENTIFIER ':' expression ')' statement | 'for' '(' ( forInit )? ';' ( expression )? ';' ( expressionList )? ')' statement )
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==FOR) ) {
                int LA107_1 = input.LA(2);

                if ( (synpred157_RJavaSymbolTable()) ) {
                    alt107=1;
                }
                else if ( (true) ) {
                    alt107=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 107, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 107, 0, input);

                throw nvae;

            }
            switch (alt107) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:669:9: 'for' '(' variableModifiers type IDENTIFIER ':' expression ')' statement
                    {
                    if ( state.backtracking==0 ) {klass.newBlock(RBlock.IN_METHOD);}

                    match(input,FOR,FOLLOW_FOR_in_forstatement5152); if (state.failed) return ;

                    match(input,LPAREN,FOLLOW_LPAREN_in_forstatement5154); if (state.failed) return ;

                    pushFollow(FOLLOW_variableModifiers_in_forstatement5156);
                    variableModifiers();

                    state._fsp--;
                    if (state.failed) return ;

                    pushFollow(FOLLOW_type_in_forstatement5158);
                    type9=type();

                    state._fsp--;
                    if (state.failed) return ;

                    IDENTIFIER10=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_forstatement5160); if (state.failed) return ;

                    match(input,COLON,FOLLOW_COLON_in_forstatement5162); if (state.failed) return ;

                    if ( state.backtracking==0 ) {RIdentifier id = new RIdentifier();
                            id.setType(RType.initWithClassName(klass, (type9!=null?input.toString(type9.start,type9.stop):null)));
                            id.setId((IDENTIFIER10!=null?IDENTIFIER10.getText():null));
                            klass.newIdToCurrentBlock(id);}

                    pushFollow(FOLLOW_expression_in_forstatement5183);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,RPAREN,FOLLOW_RPAREN_in_forstatement5185); if (state.failed) return ;

                    pushFollow(FOLLOW_statement_in_forstatement5187);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    if ( state.backtracking==0 ) {klass.backToUpperBlock();}

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:680:9: 'for' '(' ( forInit )? ';' ( expression )? ';' ( expressionList )? ')' statement
                    {
                    if ( state.backtracking==0 ) {klass.newBlock(RBlock.IN_METHOD);}

                    match(input,FOR,FOLLOW_FOR_in_forstatement5248); if (state.failed) return ;

                    match(input,LPAREN,FOLLOW_LPAREN_in_forstatement5250); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:682:17: ( forInit )?
                    int alt104=2;
                    int LA104_0 = input.LA(1);

                    if ( (LA104_0==BANG||LA104_0==BOOLEAN||LA104_0==BYTE||(LA104_0 >= CHAR && LA104_0 <= CHARLITERAL)||(LA104_0 >= DOUBLE && LA104_0 <= DOUBLELITERAL)||(LA104_0 >= FALSE && LA104_0 <= FINAL)||(LA104_0 >= FLOAT && LA104_0 <= FLOATLITERAL)||LA104_0==IDENTIFIER||LA104_0==INT||LA104_0==INTLITERAL||(LA104_0 >= LONG && LA104_0 <= LPAREN)||LA104_0==MONKEYS_AT||(LA104_0 >= NEW && LA104_0 <= NULL)||LA104_0==PLUS||LA104_0==PLUSPLUS||LA104_0==SHORT||(LA104_0 >= STRINGLITERAL && LA104_0 <= SUB)||(LA104_0 >= SUBSUB && LA104_0 <= SUPER)||LA104_0==THIS||LA104_0==TILDE||LA104_0==TRUE||LA104_0==VOID) ) {
                        alt104=1;
                    }
                    switch (alt104) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:682:18: forInit
                            {
                            pushFollow(FOLLOW_forInit_in_forstatement5270);
                            forInit();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,SEMI,FOLLOW_SEMI_in_forstatement5291); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:684:17: ( expression )?
                    int alt105=2;
                    int LA105_0 = input.LA(1);

                    if ( (LA105_0==BANG||LA105_0==BOOLEAN||LA105_0==BYTE||(LA105_0 >= CHAR && LA105_0 <= CHARLITERAL)||(LA105_0 >= DOUBLE && LA105_0 <= DOUBLELITERAL)||LA105_0==FALSE||(LA105_0 >= FLOAT && LA105_0 <= FLOATLITERAL)||LA105_0==IDENTIFIER||LA105_0==INT||LA105_0==INTLITERAL||(LA105_0 >= LONG && LA105_0 <= LPAREN)||(LA105_0 >= NEW && LA105_0 <= NULL)||LA105_0==PLUS||LA105_0==PLUSPLUS||LA105_0==SHORT||(LA105_0 >= STRINGLITERAL && LA105_0 <= SUB)||(LA105_0 >= SUBSUB && LA105_0 <= SUPER)||LA105_0==THIS||LA105_0==TILDE||LA105_0==TRUE||LA105_0==VOID) ) {
                        alt105=1;
                    }
                    switch (alt105) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:684:18: expression
                            {
                            pushFollow(FOLLOW_expression_in_forstatement5311);
                            expression();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,SEMI,FOLLOW_SEMI_in_forstatement5332); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:686:17: ( expressionList )?
                    int alt106=2;
                    int LA106_0 = input.LA(1);

                    if ( (LA106_0==BANG||LA106_0==BOOLEAN||LA106_0==BYTE||(LA106_0 >= CHAR && LA106_0 <= CHARLITERAL)||(LA106_0 >= DOUBLE && LA106_0 <= DOUBLELITERAL)||LA106_0==FALSE||(LA106_0 >= FLOAT && LA106_0 <= FLOATLITERAL)||LA106_0==IDENTIFIER||LA106_0==INT||LA106_0==INTLITERAL||(LA106_0 >= LONG && LA106_0 <= LPAREN)||(LA106_0 >= NEW && LA106_0 <= NULL)||LA106_0==PLUS||LA106_0==PLUSPLUS||LA106_0==SHORT||(LA106_0 >= STRINGLITERAL && LA106_0 <= SUB)||(LA106_0 >= SUBSUB && LA106_0 <= SUPER)||LA106_0==THIS||LA106_0==TILDE||LA106_0==TRUE||LA106_0==VOID) ) {
                        alt106=1;
                    }
                    switch (alt106) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:686:18: expressionList
                            {
                            pushFollow(FOLLOW_expressionList_in_forstatement5352);
                            expressionList();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,RPAREN,FOLLOW_RPAREN_in_forstatement5373); if (state.failed) return ;

                    pushFollow(FOLLOW_statement_in_forstatement5375);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    if ( state.backtracking==0 ) {klass.backToUpperBlock();}

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:691:1: forInit : ( localVariableDeclaration | expressionList );
    public final void forInit() throws RecognitionException {
        int forInit_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:692:5: ( localVariableDeclaration | expressionList )
            int alt108=2;
            switch ( input.LA(1) ) {
            case FINAL:
            case MONKEYS_AT:
                {
                alt108=1;
                }
                break;
            case IDENTIFIER:
                {
                int LA108_3 = input.LA(2);

                if ( (synpred161_RJavaSymbolTable()) ) {
                    alt108=1;
                }
                else if ( (true) ) {
                    alt108=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 108, 3, input);

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
                int LA108_4 = input.LA(2);

                if ( (synpred161_RJavaSymbolTable()) ) {
                    alt108=1;
                }
                else if ( (true) ) {
                    alt108=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 108, 4, input);

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
                alt108=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 108, 0, input);

                throw nvae;

            }

            switch (alt108) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:692:9: localVariableDeclaration
                    {
                    pushFollow(FOLLOW_localVariableDeclaration_in_forInit5405);
                    localVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:693:9: expressionList
                    {
                    pushFollow(FOLLOW_expressionList_in_forInit5415);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:696:1: parExpression : '(' expression ')' ;
    public final void parExpression() throws RecognitionException {
        int parExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:697:5: ( '(' expression ')' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:697:9: '(' expression ')'
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_parExpression5435); if (state.failed) return ;

            pushFollow(FOLLOW_expression_in_parExpression5437);
            expression();

            state._fsp--;
            if (state.failed) return ;

            match(input,RPAREN,FOLLOW_RPAREN_in_parExpression5439); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:700:1: expressionList : expression ( ',' expression )* ;
    public final void expressionList() throws RecognitionException {
        int expressionList_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:701:5: ( expression ( ',' expression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:701:9: expression ( ',' expression )*
            {
            pushFollow(FOLLOW_expression_in_expressionList5459);
            expression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:702:9: ( ',' expression )*
            loop109:
            do {
                int alt109=2;
                int LA109_0 = input.LA(1);

                if ( (LA109_0==COMMA) ) {
                    alt109=1;
                }


                switch (alt109) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:702:10: ',' expression
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_expressionList5470); if (state.failed) return ;

            	    pushFollow(FOLLOW_expression_in_expressionList5472);
            	    expression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop109;
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:707:1: expression : conditionalExpression ( assignmentOperator expression )? ;
    public final void expression() throws RecognitionException {
        int expression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:708:5: ( conditionalExpression ( assignmentOperator expression )? )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:708:9: conditionalExpression ( assignmentOperator expression )?
            {
            pushFollow(FOLLOW_conditionalExpression_in_expression5504);
            conditionalExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:709:9: ( assignmentOperator expression )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==AMPEQ||LA110_0==BAREQ||LA110_0==CARETEQ||LA110_0==EQ||LA110_0==GT||LA110_0==LT||LA110_0==PERCENTEQ||LA110_0==PLUSEQ||LA110_0==SLASHEQ||LA110_0==STAREQ||LA110_0==SUBEQ) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:709:10: assignmentOperator expression
                    {
                    pushFollow(FOLLOW_assignmentOperator_in_expression5515);
                    assignmentOperator();

                    state._fsp--;
                    if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_expression5517);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:714:1: assignmentOperator : ( '=' | '+=' | '-=' | '*=' | '/=' | '&=' | '|=' | '^=' | '%=' | '<' '<' '=' | '>' '>' '>' '=' | '>' '>' '=' );
    public final void assignmentOperator() throws RecognitionException {
        int assignmentOperator_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:715:5: ( '=' | '+=' | '-=' | '*=' | '/=' | '&=' | '|=' | '^=' | '%=' | '<' '<' '=' | '>' '>' '>' '=' | '>' '>' '=' )
            int alt111=12;
            switch ( input.LA(1) ) {
            case EQ:
                {
                alt111=1;
                }
                break;
            case PLUSEQ:
                {
                alt111=2;
                }
                break;
            case SUBEQ:
                {
                alt111=3;
                }
                break;
            case STAREQ:
                {
                alt111=4;
                }
                break;
            case SLASHEQ:
                {
                alt111=5;
                }
                break;
            case AMPEQ:
                {
                alt111=6;
                }
                break;
            case BAREQ:
                {
                alt111=7;
                }
                break;
            case CARETEQ:
                {
                alt111=8;
                }
                break;
            case PERCENTEQ:
                {
                alt111=9;
                }
                break;
            case LT:
                {
                alt111=10;
                }
                break;
            case GT:
                {
                int LA111_11 = input.LA(2);

                if ( (LA111_11==GT) ) {
                    int LA111_12 = input.LA(3);

                    if ( (LA111_12==GT) ) {
                        alt111=11;
                    }
                    else if ( (LA111_12==EQ) ) {
                        alt111=12;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 111, 12, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 111, 11, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 111, 0, input);

                throw nvae;

            }

            switch (alt111) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:715:9: '='
                    {
                    match(input,EQ,FOLLOW_EQ_in_assignmentOperator5549); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:716:9: '+='
                    {
                    match(input,PLUSEQ,FOLLOW_PLUSEQ_in_assignmentOperator5559); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:717:9: '-='
                    {
                    match(input,SUBEQ,FOLLOW_SUBEQ_in_assignmentOperator5569); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:718:9: '*='
                    {
                    match(input,STAREQ,FOLLOW_STAREQ_in_assignmentOperator5579); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:719:9: '/='
                    {
                    match(input,SLASHEQ,FOLLOW_SLASHEQ_in_assignmentOperator5589); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:720:9: '&='
                    {
                    match(input,AMPEQ,FOLLOW_AMPEQ_in_assignmentOperator5599); if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:721:9: '|='
                    {
                    match(input,BAREQ,FOLLOW_BAREQ_in_assignmentOperator5609); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:722:9: '^='
                    {
                    match(input,CARETEQ,FOLLOW_CARETEQ_in_assignmentOperator5619); if (state.failed) return ;

                    }
                    break;
                case 9 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:723:9: '%='
                    {
                    match(input,PERCENTEQ,FOLLOW_PERCENTEQ_in_assignmentOperator5629); if (state.failed) return ;

                    }
                    break;
                case 10 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:724:10: '<' '<' '='
                    {
                    match(input,LT,FOLLOW_LT_in_assignmentOperator5640); if (state.failed) return ;

                    match(input,LT,FOLLOW_LT_in_assignmentOperator5642); if (state.failed) return ;

                    match(input,EQ,FOLLOW_EQ_in_assignmentOperator5644); if (state.failed) return ;

                    }
                    break;
                case 11 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:725:10: '>' '>' '>' '='
                    {
                    match(input,GT,FOLLOW_GT_in_assignmentOperator5655); if (state.failed) return ;

                    match(input,GT,FOLLOW_GT_in_assignmentOperator5657); if (state.failed) return ;

                    match(input,GT,FOLLOW_GT_in_assignmentOperator5659); if (state.failed) return ;

                    match(input,EQ,FOLLOW_EQ_in_assignmentOperator5661); if (state.failed) return ;

                    }
                    break;
                case 12 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:726:10: '>' '>' '='
                    {
                    match(input,GT,FOLLOW_GT_in_assignmentOperator5672); if (state.failed) return ;

                    match(input,GT,FOLLOW_GT_in_assignmentOperator5674); if (state.failed) return ;

                    match(input,EQ,FOLLOW_EQ_in_assignmentOperator5676); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:730:1: conditionalExpression : conditionalOrExpression ( '?' expression ':' conditionalExpression )? ;
    public final void conditionalExpression() throws RecognitionException {
        int conditionalExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:731:5: ( conditionalOrExpression ( '?' expression ':' conditionalExpression )? )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:731:9: conditionalOrExpression ( '?' expression ':' conditionalExpression )?
            {
            pushFollow(FOLLOW_conditionalOrExpression_in_conditionalExpression5697);
            conditionalOrExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:732:9: ( '?' expression ':' conditionalExpression )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==QUES) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:732:10: '?' expression ':' conditionalExpression
                    {
                    match(input,QUES,FOLLOW_QUES_in_conditionalExpression5708); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_conditionalExpression5710);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,COLON,FOLLOW_COLON_in_conditionalExpression5712); if (state.failed) return ;

                    pushFollow(FOLLOW_conditionalExpression_in_conditionalExpression5714);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:736:1: conditionalOrExpression : conditionalAndExpression ( '||' conditionalAndExpression )* ;
    public final void conditionalOrExpression() throws RecognitionException {
        int conditionalOrExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:737:5: ( conditionalAndExpression ( '||' conditionalAndExpression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:737:9: conditionalAndExpression ( '||' conditionalAndExpression )*
            {
            pushFollow(FOLLOW_conditionalAndExpression_in_conditionalOrExpression5745);
            conditionalAndExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:738:9: ( '||' conditionalAndExpression )*
            loop113:
            do {
                int alt113=2;
                int LA113_0 = input.LA(1);

                if ( (LA113_0==BARBAR) ) {
                    alt113=1;
                }


                switch (alt113) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:738:10: '||' conditionalAndExpression
            	    {
            	    match(input,BARBAR,FOLLOW_BARBAR_in_conditionalOrExpression5756); if (state.failed) return ;

            	    pushFollow(FOLLOW_conditionalAndExpression_in_conditionalOrExpression5758);
            	    conditionalAndExpression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop113;
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:742:1: conditionalAndExpression : inclusiveOrExpression ( '&&' inclusiveOrExpression )* ;
    public final void conditionalAndExpression() throws RecognitionException {
        int conditionalAndExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 74) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:743:5: ( inclusiveOrExpression ( '&&' inclusiveOrExpression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:743:9: inclusiveOrExpression ( '&&' inclusiveOrExpression )*
            {
            pushFollow(FOLLOW_inclusiveOrExpression_in_conditionalAndExpression5789);
            inclusiveOrExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:744:9: ( '&&' inclusiveOrExpression )*
            loop114:
            do {
                int alt114=2;
                int LA114_0 = input.LA(1);

                if ( (LA114_0==AMPAMP) ) {
                    alt114=1;
                }


                switch (alt114) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:744:10: '&&' inclusiveOrExpression
            	    {
            	    match(input,AMPAMP,FOLLOW_AMPAMP_in_conditionalAndExpression5800); if (state.failed) return ;

            	    pushFollow(FOLLOW_inclusiveOrExpression_in_conditionalAndExpression5802);
            	    inclusiveOrExpression();

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
            if ( state.backtracking>0 ) { memoize(input, 74, conditionalAndExpression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "conditionalAndExpression"



    // $ANTLR start "inclusiveOrExpression"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:748:1: inclusiveOrExpression : exclusiveOrExpression ( '|' exclusiveOrExpression )* ;
    public final void inclusiveOrExpression() throws RecognitionException {
        int inclusiveOrExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 75) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:749:5: ( exclusiveOrExpression ( '|' exclusiveOrExpression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:749:9: exclusiveOrExpression ( '|' exclusiveOrExpression )*
            {
            pushFollow(FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression5833);
            exclusiveOrExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:750:9: ( '|' exclusiveOrExpression )*
            loop115:
            do {
                int alt115=2;
                int LA115_0 = input.LA(1);

                if ( (LA115_0==BAR) ) {
                    alt115=1;
                }


                switch (alt115) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:750:10: '|' exclusiveOrExpression
            	    {
            	    match(input,BAR,FOLLOW_BAR_in_inclusiveOrExpression5844); if (state.failed) return ;

            	    pushFollow(FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression5846);
            	    exclusiveOrExpression();

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
            if ( state.backtracking>0 ) { memoize(input, 75, inclusiveOrExpression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "inclusiveOrExpression"



    // $ANTLR start "exclusiveOrExpression"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:754:1: exclusiveOrExpression : andExpression ( '^' andExpression )* ;
    public final void exclusiveOrExpression() throws RecognitionException {
        int exclusiveOrExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 76) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:755:5: ( andExpression ( '^' andExpression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:755:9: andExpression ( '^' andExpression )*
            {
            pushFollow(FOLLOW_andExpression_in_exclusiveOrExpression5877);
            andExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:756:9: ( '^' andExpression )*
            loop116:
            do {
                int alt116=2;
                int LA116_0 = input.LA(1);

                if ( (LA116_0==CARET) ) {
                    alt116=1;
                }


                switch (alt116) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:756:10: '^' andExpression
            	    {
            	    match(input,CARET,FOLLOW_CARET_in_exclusiveOrExpression5888); if (state.failed) return ;

            	    pushFollow(FOLLOW_andExpression_in_exclusiveOrExpression5890);
            	    andExpression();

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
            if ( state.backtracking>0 ) { memoize(input, 76, exclusiveOrExpression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "exclusiveOrExpression"



    // $ANTLR start "andExpression"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:760:1: andExpression : equalityExpression ( '&' equalityExpression )* ;
    public final void andExpression() throws RecognitionException {
        int andExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 77) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:761:5: ( equalityExpression ( '&' equalityExpression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:761:9: equalityExpression ( '&' equalityExpression )*
            {
            pushFollow(FOLLOW_equalityExpression_in_andExpression5921);
            equalityExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:762:9: ( '&' equalityExpression )*
            loop117:
            do {
                int alt117=2;
                int LA117_0 = input.LA(1);

                if ( (LA117_0==AMP) ) {
                    alt117=1;
                }


                switch (alt117) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:762:10: '&' equalityExpression
            	    {
            	    match(input,AMP,FOLLOW_AMP_in_andExpression5932); if (state.failed) return ;

            	    pushFollow(FOLLOW_equalityExpression_in_andExpression5934);
            	    equalityExpression();

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
            if ( state.backtracking>0 ) { memoize(input, 77, andExpression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "andExpression"



    // $ANTLR start "equalityExpression"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:766:1: equalityExpression : instanceOfExpression ( ( '==' | '!=' ) instanceOfExpression )* ;
    public final void equalityExpression() throws RecognitionException {
        int equalityExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 78) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:767:5: ( instanceOfExpression ( ( '==' | '!=' ) instanceOfExpression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:767:9: instanceOfExpression ( ( '==' | '!=' ) instanceOfExpression )*
            {
            pushFollow(FOLLOW_instanceOfExpression_in_equalityExpression5965);
            instanceOfExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:768:9: ( ( '==' | '!=' ) instanceOfExpression )*
            loop118:
            do {
                int alt118=2;
                int LA118_0 = input.LA(1);

                if ( (LA118_0==BANGEQ||LA118_0==EQEQ) ) {
                    alt118=1;
                }


                switch (alt118) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:769:13: ( '==' | '!=' ) instanceOfExpression
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


            	    pushFollow(FOLLOW_instanceOfExpression_in_equalityExpression6042);
            	    instanceOfExpression();

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
            if ( state.backtracking>0 ) { memoize(input, 78, equalityExpression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "equalityExpression"



    // $ANTLR start "instanceOfExpression"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:776:1: instanceOfExpression : relationalExpression ( 'instanceof' type )? ;
    public final void instanceOfExpression() throws RecognitionException {
        int instanceOfExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 79) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:777:5: ( relationalExpression ( 'instanceof' type )? )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:777:9: relationalExpression ( 'instanceof' type )?
            {
            pushFollow(FOLLOW_relationalExpression_in_instanceOfExpression6073);
            relationalExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:778:9: ( 'instanceof' type )?
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==INSTANCEOF) ) {
                alt119=1;
            }
            switch (alt119) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:778:10: 'instanceof' type
                    {
                    match(input,INSTANCEOF,FOLLOW_INSTANCEOF_in_instanceOfExpression6084); if (state.failed) return ;

                    pushFollow(FOLLOW_type_in_instanceOfExpression6086);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:782:1: relationalExpression : shiftExpression ( relationalOp shiftExpression )* ;
    public final void relationalExpression() throws RecognitionException {
        int relationalExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 80) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:783:5: ( shiftExpression ( relationalOp shiftExpression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:783:9: shiftExpression ( relationalOp shiftExpression )*
            {
            pushFollow(FOLLOW_shiftExpression_in_relationalExpression6117);
            shiftExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:784:9: ( relationalOp shiftExpression )*
            loop120:
            do {
                int alt120=2;
                int LA120_0 = input.LA(1);

                if ( (LA120_0==LT) ) {
                    int LA120_2 = input.LA(2);

                    if ( (LA120_2==BANG||LA120_2==BOOLEAN||LA120_2==BYTE||(LA120_2 >= CHAR && LA120_2 <= CHARLITERAL)||(LA120_2 >= DOUBLE && LA120_2 <= DOUBLELITERAL)||LA120_2==EQ||LA120_2==FALSE||(LA120_2 >= FLOAT && LA120_2 <= FLOATLITERAL)||LA120_2==IDENTIFIER||LA120_2==INT||LA120_2==INTLITERAL||(LA120_2 >= LONG && LA120_2 <= LPAREN)||(LA120_2 >= NEW && LA120_2 <= NULL)||LA120_2==PLUS||LA120_2==PLUSPLUS||LA120_2==SHORT||(LA120_2 >= STRINGLITERAL && LA120_2 <= SUB)||(LA120_2 >= SUBSUB && LA120_2 <= SUPER)||LA120_2==THIS||LA120_2==TILDE||LA120_2==TRUE||LA120_2==VOID) ) {
                        alt120=1;
                    }


                }
                else if ( (LA120_0==GT) ) {
                    int LA120_3 = input.LA(2);

                    if ( (LA120_3==BANG||LA120_3==BOOLEAN||LA120_3==BYTE||(LA120_3 >= CHAR && LA120_3 <= CHARLITERAL)||(LA120_3 >= DOUBLE && LA120_3 <= DOUBLELITERAL)||LA120_3==EQ||LA120_3==FALSE||(LA120_3 >= FLOAT && LA120_3 <= FLOATLITERAL)||LA120_3==IDENTIFIER||LA120_3==INT||LA120_3==INTLITERAL||(LA120_3 >= LONG && LA120_3 <= LPAREN)||(LA120_3 >= NEW && LA120_3 <= NULL)||LA120_3==PLUS||LA120_3==PLUSPLUS||LA120_3==SHORT||(LA120_3 >= STRINGLITERAL && LA120_3 <= SUB)||(LA120_3 >= SUBSUB && LA120_3 <= SUPER)||LA120_3==THIS||LA120_3==TILDE||LA120_3==TRUE||LA120_3==VOID) ) {
                        alt120=1;
                    }


                }


                switch (alt120) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:784:10: relationalOp shiftExpression
            	    {
            	    pushFollow(FOLLOW_relationalOp_in_relationalExpression6128);
            	    relationalOp();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    pushFollow(FOLLOW_shiftExpression_in_relationalExpression6130);
            	    shiftExpression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop120;
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:788:1: relationalOp : ( '<' '=' | '>' '=' | '<' | '>' );
    public final void relationalOp() throws RecognitionException {
        int relationalOp_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 81) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:789:5: ( '<' '=' | '>' '=' | '<' | '>' )
            int alt121=4;
            int LA121_0 = input.LA(1);

            if ( (LA121_0==LT) ) {
                int LA121_1 = input.LA(2);

                if ( (LA121_1==EQ) ) {
                    alt121=1;
                }
                else if ( (LA121_1==BANG||LA121_1==BOOLEAN||LA121_1==BYTE||(LA121_1 >= CHAR && LA121_1 <= CHARLITERAL)||(LA121_1 >= DOUBLE && LA121_1 <= DOUBLELITERAL)||LA121_1==FALSE||(LA121_1 >= FLOAT && LA121_1 <= FLOATLITERAL)||LA121_1==IDENTIFIER||LA121_1==INT||LA121_1==INTLITERAL||(LA121_1 >= LONG && LA121_1 <= LPAREN)||(LA121_1 >= NEW && LA121_1 <= NULL)||LA121_1==PLUS||LA121_1==PLUSPLUS||LA121_1==SHORT||(LA121_1 >= STRINGLITERAL && LA121_1 <= SUB)||(LA121_1 >= SUBSUB && LA121_1 <= SUPER)||LA121_1==THIS||LA121_1==TILDE||LA121_1==TRUE||LA121_1==VOID) ) {
                    alt121=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 121, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA121_0==GT) ) {
                int LA121_2 = input.LA(2);

                if ( (LA121_2==EQ) ) {
                    alt121=2;
                }
                else if ( (LA121_2==BANG||LA121_2==BOOLEAN||LA121_2==BYTE||(LA121_2 >= CHAR && LA121_2 <= CHARLITERAL)||(LA121_2 >= DOUBLE && LA121_2 <= DOUBLELITERAL)||LA121_2==FALSE||(LA121_2 >= FLOAT && LA121_2 <= FLOATLITERAL)||LA121_2==IDENTIFIER||LA121_2==INT||LA121_2==INTLITERAL||(LA121_2 >= LONG && LA121_2 <= LPAREN)||(LA121_2 >= NEW && LA121_2 <= NULL)||LA121_2==PLUS||LA121_2==PLUSPLUS||LA121_2==SHORT||(LA121_2 >= STRINGLITERAL && LA121_2 <= SUB)||(LA121_2 >= SUBSUB && LA121_2 <= SUPER)||LA121_2==THIS||LA121_2==TILDE||LA121_2==TRUE||LA121_2==VOID) ) {
                    alt121=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 121, 2, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 121, 0, input);

                throw nvae;

            }
            switch (alt121) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:789:10: '<' '='
                    {
                    match(input,LT,FOLLOW_LT_in_relationalOp6162); if (state.failed) return ;

                    match(input,EQ,FOLLOW_EQ_in_relationalOp6164); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:790:10: '>' '='
                    {
                    match(input,GT,FOLLOW_GT_in_relationalOp6175); if (state.failed) return ;

                    match(input,EQ,FOLLOW_EQ_in_relationalOp6177); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:791:9: '<'
                    {
                    match(input,LT,FOLLOW_LT_in_relationalOp6187); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:792:9: '>'
                    {
                    match(input,GT,FOLLOW_GT_in_relationalOp6197); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:795:1: shiftExpression : additiveExpression ( shiftOp additiveExpression )* ;
    public final void shiftExpression() throws RecognitionException {
        int shiftExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 82) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:796:5: ( additiveExpression ( shiftOp additiveExpression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:796:9: additiveExpression ( shiftOp additiveExpression )*
            {
            pushFollow(FOLLOW_additiveExpression_in_shiftExpression6217);
            additiveExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:797:9: ( shiftOp additiveExpression )*
            loop122:
            do {
                int alt122=2;
                int LA122_0 = input.LA(1);

                if ( (LA122_0==LT) ) {
                    int LA122_1 = input.LA(2);

                    if ( (LA122_1==LT) ) {
                        int LA122_4 = input.LA(3);

                        if ( (LA122_4==BANG||LA122_4==BOOLEAN||LA122_4==BYTE||(LA122_4 >= CHAR && LA122_4 <= CHARLITERAL)||(LA122_4 >= DOUBLE && LA122_4 <= DOUBLELITERAL)||LA122_4==FALSE||(LA122_4 >= FLOAT && LA122_4 <= FLOATLITERAL)||LA122_4==IDENTIFIER||LA122_4==INT||LA122_4==INTLITERAL||(LA122_4 >= LONG && LA122_4 <= LPAREN)||(LA122_4 >= NEW && LA122_4 <= NULL)||LA122_4==PLUS||LA122_4==PLUSPLUS||LA122_4==SHORT||(LA122_4 >= STRINGLITERAL && LA122_4 <= SUB)||(LA122_4 >= SUBSUB && LA122_4 <= SUPER)||LA122_4==THIS||LA122_4==TILDE||LA122_4==TRUE||LA122_4==VOID) ) {
                            alt122=1;
                        }


                    }


                }
                else if ( (LA122_0==GT) ) {
                    int LA122_2 = input.LA(2);

                    if ( (LA122_2==GT) ) {
                        int LA122_5 = input.LA(3);

                        if ( (LA122_5==GT) ) {
                            int LA122_7 = input.LA(4);

                            if ( (LA122_7==BANG||LA122_7==BOOLEAN||LA122_7==BYTE||(LA122_7 >= CHAR && LA122_7 <= CHARLITERAL)||(LA122_7 >= DOUBLE && LA122_7 <= DOUBLELITERAL)||LA122_7==FALSE||(LA122_7 >= FLOAT && LA122_7 <= FLOATLITERAL)||LA122_7==IDENTIFIER||LA122_7==INT||LA122_7==INTLITERAL||(LA122_7 >= LONG && LA122_7 <= LPAREN)||(LA122_7 >= NEW && LA122_7 <= NULL)||LA122_7==PLUS||LA122_7==PLUSPLUS||LA122_7==SHORT||(LA122_7 >= STRINGLITERAL && LA122_7 <= SUB)||(LA122_7 >= SUBSUB && LA122_7 <= SUPER)||LA122_7==THIS||LA122_7==TILDE||LA122_7==TRUE||LA122_7==VOID) ) {
                                alt122=1;
                            }


                        }
                        else if ( (LA122_5==BANG||LA122_5==BOOLEAN||LA122_5==BYTE||(LA122_5 >= CHAR && LA122_5 <= CHARLITERAL)||(LA122_5 >= DOUBLE && LA122_5 <= DOUBLELITERAL)||LA122_5==FALSE||(LA122_5 >= FLOAT && LA122_5 <= FLOATLITERAL)||LA122_5==IDENTIFIER||LA122_5==INT||LA122_5==INTLITERAL||(LA122_5 >= LONG && LA122_5 <= LPAREN)||(LA122_5 >= NEW && LA122_5 <= NULL)||LA122_5==PLUS||LA122_5==PLUSPLUS||LA122_5==SHORT||(LA122_5 >= STRINGLITERAL && LA122_5 <= SUB)||(LA122_5 >= SUBSUB && LA122_5 <= SUPER)||LA122_5==THIS||LA122_5==TILDE||LA122_5==TRUE||LA122_5==VOID) ) {
                            alt122=1;
                        }


                    }


                }


                switch (alt122) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:797:10: shiftOp additiveExpression
            	    {
            	    pushFollow(FOLLOW_shiftOp_in_shiftExpression6228);
            	    shiftOp();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    pushFollow(FOLLOW_additiveExpression_in_shiftExpression6230);
            	    additiveExpression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop122;
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:802:1: shiftOp : ( '<' '<' | '>' '>' '>' | '>' '>' );
    public final void shiftOp() throws RecognitionException {
        int shiftOp_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 83) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:803:5: ( '<' '<' | '>' '>' '>' | '>' '>' )
            int alt123=3;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==LT) ) {
                alt123=1;
            }
            else if ( (LA123_0==GT) ) {
                int LA123_2 = input.LA(2);

                if ( (LA123_2==GT) ) {
                    int LA123_3 = input.LA(3);

                    if ( (LA123_3==GT) ) {
                        alt123=2;
                    }
                    else if ( (LA123_3==BANG||LA123_3==BOOLEAN||LA123_3==BYTE||(LA123_3 >= CHAR && LA123_3 <= CHARLITERAL)||(LA123_3 >= DOUBLE && LA123_3 <= DOUBLELITERAL)||LA123_3==FALSE||(LA123_3 >= FLOAT && LA123_3 <= FLOATLITERAL)||LA123_3==IDENTIFIER||LA123_3==INT||LA123_3==INTLITERAL||(LA123_3 >= LONG && LA123_3 <= LPAREN)||(LA123_3 >= NEW && LA123_3 <= NULL)||LA123_3==PLUS||LA123_3==PLUSPLUS||LA123_3==SHORT||(LA123_3 >= STRINGLITERAL && LA123_3 <= SUB)||(LA123_3 >= SUBSUB && LA123_3 <= SUPER)||LA123_3==THIS||LA123_3==TILDE||LA123_3==TRUE||LA123_3==VOID) ) {
                        alt123=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 123, 3, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 123, 2, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 123, 0, input);

                throw nvae;

            }
            switch (alt123) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:803:10: '<' '<'
                    {
                    match(input,LT,FOLLOW_LT_in_shiftOp6263); if (state.failed) return ;

                    match(input,LT,FOLLOW_LT_in_shiftOp6265); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:804:10: '>' '>' '>'
                    {
                    match(input,GT,FOLLOW_GT_in_shiftOp6276); if (state.failed) return ;

                    match(input,GT,FOLLOW_GT_in_shiftOp6278); if (state.failed) return ;

                    match(input,GT,FOLLOW_GT_in_shiftOp6280); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:805:10: '>' '>'
                    {
                    match(input,GT,FOLLOW_GT_in_shiftOp6291); if (state.failed) return ;

                    match(input,GT,FOLLOW_GT_in_shiftOp6293); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:809:1: additiveExpression : multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )* ;
    public final void additiveExpression() throws RecognitionException {
        int additiveExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 84) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:810:5: ( multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:810:9: multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )*
            {
            pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression6314);
            multiplicativeExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:811:9: ( ( '+' | '-' ) multiplicativeExpression )*
            loop124:
            do {
                int alt124=2;
                int LA124_0 = input.LA(1);

                if ( (LA124_0==PLUS||LA124_0==SUB) ) {
                    alt124=1;
                }


                switch (alt124) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:812:13: ( '+' | '-' ) multiplicativeExpression
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


            	    pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression6391);
            	    multiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop124;
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:819:1: multiplicativeExpression : unaryExpression ( ( '*' | '/' | '%' ) unaryExpression )* ;
    public final void multiplicativeExpression() throws RecognitionException {
        int multiplicativeExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 85) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:820:5: ( unaryExpression ( ( '*' | '/' | '%' ) unaryExpression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:821:9: unaryExpression ( ( '*' | '/' | '%' ) unaryExpression )*
            {
            pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression6429);
            unaryExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:822:9: ( ( '*' | '/' | '%' ) unaryExpression )*
            loop125:
            do {
                int alt125=2;
                int LA125_0 = input.LA(1);

                if ( (LA125_0==PERCENT||LA125_0==SLASH||LA125_0==STAR) ) {
                    alt125=1;
                }


                switch (alt125) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:823:13: ( '*' | '/' | '%' ) unaryExpression
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


            	    pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression6524);
            	    unaryExpression();

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
            if ( state.backtracking>0 ) { memoize(input, 85, multiplicativeExpression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "multiplicativeExpression"



    // $ANTLR start "unaryExpression"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:835:1: unaryExpression : ( '+' unaryExpression | '-' unaryExpression | '++' unaryExpression | '--' unaryExpression | unaryExpressionNotPlusMinus );
    public final void unaryExpression() throws RecognitionException {
        int unaryExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 86) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:836:5: ( '+' unaryExpression | '-' unaryExpression | '++' unaryExpression | '--' unaryExpression | unaryExpressionNotPlusMinus )
            int alt126=5;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt126=1;
                }
                break;
            case SUB:
                {
                alt126=2;
                }
                break;
            case PLUSPLUS:
                {
                alt126=3;
                }
                break;
            case SUBSUB:
                {
                alt126=4;
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
                alt126=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 126, 0, input);

                throw nvae;

            }

            switch (alt126) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:836:9: '+' unaryExpression
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_unaryExpression6557); if (state.failed) return ;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression6560);
                    unaryExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:837:9: '-' unaryExpression
                    {
                    match(input,SUB,FOLLOW_SUB_in_unaryExpression6570); if (state.failed) return ;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression6572);
                    unaryExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:838:9: '++' unaryExpression
                    {
                    match(input,PLUSPLUS,FOLLOW_PLUSPLUS_in_unaryExpression6582); if (state.failed) return ;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression6584);
                    unaryExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:839:9: '--' unaryExpression
                    {
                    match(input,SUBSUB,FOLLOW_SUBSUB_in_unaryExpression6594); if (state.failed) return ;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression6596);
                    unaryExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:840:9: unaryExpressionNotPlusMinus
                    {
                    pushFollow(FOLLOW_unaryExpressionNotPlusMinus_in_unaryExpression6606);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:843:1: unaryExpressionNotPlusMinus : ( '~' unaryExpression | '!' unaryExpression | castExpression | primary ( selector )* ( '++' | '--' )? );
    public final void unaryExpressionNotPlusMinus() throws RecognitionException {
        int unaryExpressionNotPlusMinus_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 87) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:844:5: ( '~' unaryExpression | '!' unaryExpression | castExpression | primary ( selector )* ( '++' | '--' )? )
            int alt129=4;
            switch ( input.LA(1) ) {
            case TILDE:
                {
                alt129=1;
                }
                break;
            case BANG:
                {
                alt129=2;
                }
                break;
            case LPAREN:
                {
                int LA129_3 = input.LA(2);

                if ( (synpred202_RJavaSymbolTable()) ) {
                    alt129=3;
                }
                else if ( (true) ) {
                    alt129=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 129, 3, input);

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
                alt129=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 129, 0, input);

                throw nvae;

            }

            switch (alt129) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:844:9: '~' unaryExpression
                    {
                    match(input,TILDE,FOLLOW_TILDE_in_unaryExpressionNotPlusMinus6626); if (state.failed) return ;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus6628);
                    unaryExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:845:9: '!' unaryExpression
                    {
                    match(input,BANG,FOLLOW_BANG_in_unaryExpressionNotPlusMinus6638); if (state.failed) return ;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus6640);
                    unaryExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:846:9: castExpression
                    {
                    pushFollow(FOLLOW_castExpression_in_unaryExpressionNotPlusMinus6650);
                    castExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:847:9: primary ( selector )* ( '++' | '--' )?
                    {
                    pushFollow(FOLLOW_primary_in_unaryExpressionNotPlusMinus6660);
                    primary();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:848:9: ( selector )*
                    loop127:
                    do {
                        int alt127=2;
                        int LA127_0 = input.LA(1);

                        if ( (LA127_0==DOT||LA127_0==LBRACKET) ) {
                            alt127=1;
                        }


                        switch (alt127) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:848:10: selector
                    	    {
                    	    pushFollow(FOLLOW_selector_in_unaryExpressionNotPlusMinus6671);
                    	    selector();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop127;
                        }
                    } while (true);


                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:850:9: ( '++' | '--' )?
                    int alt128=2;
                    int LA128_0 = input.LA(1);

                    if ( (LA128_0==PLUSPLUS||LA128_0==SUBSUB) ) {
                        alt128=1;
                    }
                    switch (alt128) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:855:1: castExpression : ( '(' primitiveType ')' unaryExpression | '(' type ')' unaryExpressionNotPlusMinus );
    public final void castExpression() throws RecognitionException {
        int castExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 88) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:856:5: ( '(' primitiveType ')' unaryExpression | '(' type ')' unaryExpressionNotPlusMinus )
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==LPAREN) ) {
                int LA130_1 = input.LA(2);

                if ( (synpred206_RJavaSymbolTable()) ) {
                    alt130=1;
                }
                else if ( (true) ) {
                    alt130=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 130, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 130, 0, input);

                throw nvae;

            }
            switch (alt130) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:856:9: '(' primitiveType ')' unaryExpression
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_castExpression6741); if (state.failed) return ;

                    pushFollow(FOLLOW_primitiveType_in_castExpression6743);
                    primitiveType();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,RPAREN,FOLLOW_RPAREN_in_castExpression6745); if (state.failed) return ;

                    pushFollow(FOLLOW_unaryExpression_in_castExpression6747);
                    unaryExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:857:9: '(' type ')' unaryExpressionNotPlusMinus
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_castExpression6757); if (state.failed) return ;

                    pushFollow(FOLLOW_type_in_castExpression6759);
                    type();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,RPAREN,FOLLOW_RPAREN_in_castExpression6761); if (state.failed) return ;

                    pushFollow(FOLLOW_unaryExpressionNotPlusMinus_in_castExpression6763);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:863:1: primary : ( parExpression | 'this' ( '.' IDENTIFIER )* ( identifierSuffix )? | IDENTIFIER ( '.' IDENTIFIER )* ( identifierSuffix )? | 'super' superSuffix | literal | creator | primitiveType ( '[' ']' )* '.' 'class' | 'void' '.' 'class' );
    public final void primary() throws RecognitionException {
        int primary_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 89) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:864:5: ( parExpression | 'this' ( '.' IDENTIFIER )* ( identifierSuffix )? | IDENTIFIER ( '.' IDENTIFIER )* ( identifierSuffix )? | 'super' superSuffix | literal | creator | primitiveType ( '[' ']' )* '.' 'class' | 'void' '.' 'class' )
            int alt136=8;
            switch ( input.LA(1) ) {
            case LPAREN:
                {
                alt136=1;
                }
                break;
            case THIS:
                {
                alt136=2;
                }
                break;
            case IDENTIFIER:
                {
                alt136=3;
                }
                break;
            case SUPER:
                {
                alt136=4;
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
                alt136=5;
                }
                break;
            case NEW:
                {
                alt136=6;
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
                alt136=7;
                }
                break;
            case VOID:
                {
                alt136=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 136, 0, input);

                throw nvae;

            }

            switch (alt136) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:864:9: parExpression
                    {
                    pushFollow(FOLLOW_parExpression_in_primary6785);
                    parExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:865:9: 'this' ( '.' IDENTIFIER )* ( identifierSuffix )?
                    {
                    match(input,THIS,FOLLOW_THIS_in_primary6807); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:866:9: ( '.' IDENTIFIER )*
                    loop131:
                    do {
                        int alt131=2;
                        int LA131_0 = input.LA(1);

                        if ( (LA131_0==DOT) ) {
                            int LA131_2 = input.LA(2);

                            if ( (LA131_2==IDENTIFIER) ) {
                                int LA131_3 = input.LA(3);

                                if ( (synpred208_RJavaSymbolTable()) ) {
                                    alt131=1;
                                }


                            }


                        }


                        switch (alt131) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:866:10: '.' IDENTIFIER
                    	    {
                    	    match(input,DOT,FOLLOW_DOT_in_primary6818); if (state.failed) return ;

                    	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primary6820); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop131;
                        }
                    } while (true);


                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:868:9: ( identifierSuffix )?
                    int alt132=2;
                    switch ( input.LA(1) ) {
                        case LBRACKET:
                            {
                            int LA132_1 = input.LA(2);

                            if ( (synpred209_RJavaSymbolTable()) ) {
                                alt132=1;
                            }
                            }
                            break;
                        case LPAREN:
                            {
                            alt132=1;
                            }
                            break;
                        case DOT:
                            {
                            int LA132_3 = input.LA(2);

                            if ( (synpred209_RJavaSymbolTable()) ) {
                                alt132=1;
                            }
                            }
                            break;
                    }

                    switch (alt132) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:868:10: identifierSuffix
                            {
                            pushFollow(FOLLOW_identifierSuffix_in_primary6842);
                            identifierSuffix();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:870:9: IDENTIFIER ( '.' IDENTIFIER )* ( identifierSuffix )?
                    {
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primary6863); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:871:9: ( '.' IDENTIFIER )*
                    loop133:
                    do {
                        int alt133=2;
                        int LA133_0 = input.LA(1);

                        if ( (LA133_0==DOT) ) {
                            int LA133_2 = input.LA(2);

                            if ( (LA133_2==IDENTIFIER) ) {
                                int LA133_3 = input.LA(3);

                                if ( (synpred211_RJavaSymbolTable()) ) {
                                    alt133=1;
                                }


                            }


                        }


                        switch (alt133) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:871:10: '.' IDENTIFIER
                    	    {
                    	    match(input,DOT,FOLLOW_DOT_in_primary6874); if (state.failed) return ;

                    	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primary6876); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop133;
                        }
                    } while (true);


                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:873:9: ( identifierSuffix )?
                    int alt134=2;
                    switch ( input.LA(1) ) {
                        case LBRACKET:
                            {
                            int LA134_1 = input.LA(2);

                            if ( (synpred212_RJavaSymbolTable()) ) {
                                alt134=1;
                            }
                            }
                            break;
                        case LPAREN:
                            {
                            alt134=1;
                            }
                            break;
                        case DOT:
                            {
                            int LA134_3 = input.LA(2);

                            if ( (synpred212_RJavaSymbolTable()) ) {
                                alt134=1;
                            }
                            }
                            break;
                    }

                    switch (alt134) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:873:10: identifierSuffix
                            {
                            pushFollow(FOLLOW_identifierSuffix_in_primary6898);
                            identifierSuffix();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:875:9: 'super' superSuffix
                    {
                    match(input,SUPER,FOLLOW_SUPER_in_primary6919); if (state.failed) return ;

                    pushFollow(FOLLOW_superSuffix_in_primary6929);
                    superSuffix();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:877:9: literal
                    {
                    pushFollow(FOLLOW_literal_in_primary6939);
                    literal();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:878:9: creator
                    {
                    pushFollow(FOLLOW_creator_in_primary6949);
                    creator();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:879:9: primitiveType ( '[' ']' )* '.' 'class'
                    {
                    pushFollow(FOLLOW_primitiveType_in_primary6959);
                    primitiveType();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:880:9: ( '[' ']' )*
                    loop135:
                    do {
                        int alt135=2;
                        int LA135_0 = input.LA(1);

                        if ( (LA135_0==LBRACKET) ) {
                            alt135=1;
                        }


                        switch (alt135) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:880:10: '[' ']'
                    	    {
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_primary6970); if (state.failed) return ;

                    	    match(input,RBRACKET,FOLLOW_RBRACKET_in_primary6972); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop135;
                        }
                    } while (true);


                    match(input,DOT,FOLLOW_DOT_in_primary6993); if (state.failed) return ;

                    match(input,CLASS,FOLLOW_CLASS_in_primary6995); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:883:9: 'void' '.' 'class'
                    {
                    match(input,VOID,FOLLOW_VOID_in_primary7005); if (state.failed) return ;

                    match(input,DOT,FOLLOW_DOT_in_primary7007); if (state.failed) return ;

                    match(input,CLASS,FOLLOW_CLASS_in_primary7009); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:887:1: superSuffix : ( arguments | '.' ( typeArguments )? IDENTIFIER ( arguments )? );
    public final void superSuffix() throws RecognitionException {
        int superSuffix_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 90) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:888:5: ( arguments | '.' ( typeArguments )? IDENTIFIER ( arguments )? )
            int alt139=2;
            int LA139_0 = input.LA(1);

            if ( (LA139_0==LPAREN) ) {
                alt139=1;
            }
            else if ( (LA139_0==DOT) ) {
                alt139=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 139, 0, input);

                throw nvae;

            }
            switch (alt139) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:888:9: arguments
                    {
                    pushFollow(FOLLOW_arguments_in_superSuffix7035);
                    arguments();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:889:9: '.' ( typeArguments )? IDENTIFIER ( arguments )?
                    {
                    match(input,DOT,FOLLOW_DOT_in_superSuffix7045); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:889:13: ( typeArguments )?
                    int alt137=2;
                    int LA137_0 = input.LA(1);

                    if ( (LA137_0==LT) ) {
                        alt137=1;
                    }
                    switch (alt137) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:889:14: typeArguments
                            {
                            pushFollow(FOLLOW_typeArguments_in_superSuffix7048);
                            typeArguments();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_superSuffix7069); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:892:9: ( arguments )?
                    int alt138=2;
                    int LA138_0 = input.LA(1);

                    if ( (LA138_0==LPAREN) ) {
                        alt138=1;
                    }
                    switch (alt138) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:892:10: arguments
                            {
                            pushFollow(FOLLOW_arguments_in_superSuffix7080);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:897:1: identifierSuffix : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | arguments | '.' 'class' | '.' nonWildcardTypeArguments IDENTIFIER arguments | '.' 'this' | '.' 'super' arguments | innerCreator );
    public final void identifierSuffix() throws RecognitionException {
        int identifierSuffix_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 91) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:898:5: ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | arguments | '.' 'class' | '.' nonWildcardTypeArguments IDENTIFIER arguments | '.' 'this' | '.' 'super' arguments | innerCreator )
            int alt142=8;
            switch ( input.LA(1) ) {
            case LBRACKET:
                {
                int LA142_1 = input.LA(2);

                if ( (LA142_1==RBRACKET) ) {
                    alt142=1;
                }
                else if ( (LA142_1==BANG||LA142_1==BOOLEAN||LA142_1==BYTE||(LA142_1 >= CHAR && LA142_1 <= CHARLITERAL)||(LA142_1 >= DOUBLE && LA142_1 <= DOUBLELITERAL)||LA142_1==FALSE||(LA142_1 >= FLOAT && LA142_1 <= FLOATLITERAL)||LA142_1==IDENTIFIER||LA142_1==INT||LA142_1==INTLITERAL||(LA142_1 >= LONG && LA142_1 <= LPAREN)||(LA142_1 >= NEW && LA142_1 <= NULL)||LA142_1==PLUS||LA142_1==PLUSPLUS||LA142_1==SHORT||(LA142_1 >= STRINGLITERAL && LA142_1 <= SUB)||(LA142_1 >= SUBSUB && LA142_1 <= SUPER)||LA142_1==THIS||LA142_1==TILDE||LA142_1==TRUE||LA142_1==VOID) ) {
                    alt142=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 142, 1, input);

                    throw nvae;

                }
                }
                break;
            case LPAREN:
                {
                alt142=3;
                }
                break;
            case DOT:
                {
                switch ( input.LA(2) ) {
                case CLASS:
                    {
                    alt142=4;
                    }
                    break;
                case THIS:
                    {
                    alt142=6;
                    }
                    break;
                case SUPER:
                    {
                    alt142=7;
                    }
                    break;
                case NEW:
                    {
                    alt142=8;
                    }
                    break;
                case LT:
                    {
                    alt142=5;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 142, 3, input);

                    throw nvae;

                }

                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 142, 0, input);

                throw nvae;

            }

            switch (alt142) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:898:9: ( '[' ']' )+ '.' 'class'
                    {
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:898:9: ( '[' ']' )+
                    int cnt140=0;
                    loop140:
                    do {
                        int alt140=2;
                        int LA140_0 = input.LA(1);

                        if ( (LA140_0==LBRACKET) ) {
                            alt140=1;
                        }


                        switch (alt140) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:898:10: '[' ']'
                    	    {
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_identifierSuffix7113); if (state.failed) return ;

                    	    match(input,RBRACKET,FOLLOW_RBRACKET_in_identifierSuffix7115); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt140 >= 1 ) break loop140;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(140, input);
                                throw eee;
                        }
                        cnt140++;
                    } while (true);


                    match(input,DOT,FOLLOW_DOT_in_identifierSuffix7136); if (state.failed) return ;

                    match(input,CLASS,FOLLOW_CLASS_in_identifierSuffix7138); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:901:9: ( '[' expression ']' )+
                    {
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:901:9: ( '[' expression ']' )+
                    int cnt141=0;
                    loop141:
                    do {
                        int alt141=2;
                        int LA141_0 = input.LA(1);

                        if ( (LA141_0==LBRACKET) ) {
                            int LA141_2 = input.LA(2);

                            if ( (synpred224_RJavaSymbolTable()) ) {
                                alt141=1;
                            }


                        }


                        switch (alt141) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:901:10: '[' expression ']'
                    	    {
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_identifierSuffix7149); if (state.failed) return ;

                    	    pushFollow(FOLLOW_expression_in_identifierSuffix7151);
                    	    expression();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    match(input,RBRACKET,FOLLOW_RBRACKET_in_identifierSuffix7153); if (state.failed) return ;

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


                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:903:9: arguments
                    {
                    pushFollow(FOLLOW_arguments_in_identifierSuffix7174);
                    arguments();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:904:9: '.' 'class'
                    {
                    match(input,DOT,FOLLOW_DOT_in_identifierSuffix7184); if (state.failed) return ;

                    match(input,CLASS,FOLLOW_CLASS_in_identifierSuffix7186); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:905:9: '.' nonWildcardTypeArguments IDENTIFIER arguments
                    {
                    match(input,DOT,FOLLOW_DOT_in_identifierSuffix7196); if (state.failed) return ;

                    pushFollow(FOLLOW_nonWildcardTypeArguments_in_identifierSuffix7198);
                    nonWildcardTypeArguments();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_identifierSuffix7200); if (state.failed) return ;

                    pushFollow(FOLLOW_arguments_in_identifierSuffix7202);
                    arguments();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:906:9: '.' 'this'
                    {
                    match(input,DOT,FOLLOW_DOT_in_identifierSuffix7212); if (state.failed) return ;

                    match(input,THIS,FOLLOW_THIS_in_identifierSuffix7214); if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:907:9: '.' 'super' arguments
                    {
                    match(input,DOT,FOLLOW_DOT_in_identifierSuffix7224); if (state.failed) return ;

                    match(input,SUPER,FOLLOW_SUPER_in_identifierSuffix7226); if (state.failed) return ;

                    pushFollow(FOLLOW_arguments_in_identifierSuffix7228);
                    arguments();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:908:9: innerCreator
                    {
                    pushFollow(FOLLOW_innerCreator_in_identifierSuffix7238);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:912:1: selector : ( '.' IDENTIFIER ( arguments )? | '.' 'this' | '.' 'super' superSuffix | innerCreator | '[' expression ']' );
    public final void selector() throws RecognitionException {
        int selector_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 92) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:913:5: ( '.' IDENTIFIER ( arguments )? | '.' 'this' | '.' 'super' superSuffix | innerCreator | '[' expression ']' )
            int alt144=5;
            int LA144_0 = input.LA(1);

            if ( (LA144_0==DOT) ) {
                switch ( input.LA(2) ) {
                case IDENTIFIER:
                    {
                    alt144=1;
                    }
                    break;
                case THIS:
                    {
                    alt144=2;
                    }
                    break;
                case SUPER:
                    {
                    alt144=3;
                    }
                    break;
                case NEW:
                    {
                    alt144=4;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 144, 1, input);

                    throw nvae;

                }

            }
            else if ( (LA144_0==LBRACKET) ) {
                alt144=5;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 144, 0, input);

                throw nvae;

            }
            switch (alt144) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:913:9: '.' IDENTIFIER ( arguments )?
                    {
                    match(input,DOT,FOLLOW_DOT_in_selector7260); if (state.failed) return ;

                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_selector7262); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:914:9: ( arguments )?
                    int alt143=2;
                    int LA143_0 = input.LA(1);

                    if ( (LA143_0==LPAREN) ) {
                        alt143=1;
                    }
                    switch (alt143) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:914:10: arguments
                            {
                            pushFollow(FOLLOW_arguments_in_selector7273);
                            arguments();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:916:9: '.' 'this'
                    {
                    match(input,DOT,FOLLOW_DOT_in_selector7294); if (state.failed) return ;

                    match(input,THIS,FOLLOW_THIS_in_selector7296); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:917:9: '.' 'super' superSuffix
                    {
                    match(input,DOT,FOLLOW_DOT_in_selector7306); if (state.failed) return ;

                    match(input,SUPER,FOLLOW_SUPER_in_selector7308); if (state.failed) return ;

                    pushFollow(FOLLOW_superSuffix_in_selector7318);
                    superSuffix();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:919:9: innerCreator
                    {
                    pushFollow(FOLLOW_innerCreator_in_selector7328);
                    innerCreator();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:920:9: '[' expression ']'
                    {
                    match(input,LBRACKET,FOLLOW_LBRACKET_in_selector7338); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_selector7340);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,RBRACKET,FOLLOW_RBRACKET_in_selector7342); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:923:1: creator : ( 'new' nonWildcardTypeArguments classOrInterfaceType classCreatorRest | 'new' classOrInterfaceType classCreatorRest | arrayCreator );
    public final void creator() throws RecognitionException {
        int creator_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 93) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:924:5: ( 'new' nonWildcardTypeArguments classOrInterfaceType classCreatorRest | 'new' classOrInterfaceType classCreatorRest | arrayCreator )
            int alt145=3;
            int LA145_0 = input.LA(1);

            if ( (LA145_0==NEW) ) {
                int LA145_1 = input.LA(2);

                if ( (synpred236_RJavaSymbolTable()) ) {
                    alt145=1;
                }
                else if ( (synpred237_RJavaSymbolTable()) ) {
                    alt145=2;
                }
                else if ( (true) ) {
                    alt145=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 145, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 145, 0, input);

                throw nvae;

            }
            switch (alt145) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:924:9: 'new' nonWildcardTypeArguments classOrInterfaceType classCreatorRest
                    {
                    match(input,NEW,FOLLOW_NEW_in_creator7362); if (state.failed) return ;

                    pushFollow(FOLLOW_nonWildcardTypeArguments_in_creator7364);
                    nonWildcardTypeArguments();

                    state._fsp--;
                    if (state.failed) return ;

                    pushFollow(FOLLOW_classOrInterfaceType_in_creator7366);
                    classOrInterfaceType();

                    state._fsp--;
                    if (state.failed) return ;

                    pushFollow(FOLLOW_classCreatorRest_in_creator7368);
                    classCreatorRest();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:925:9: 'new' classOrInterfaceType classCreatorRest
                    {
                    match(input,NEW,FOLLOW_NEW_in_creator7378); if (state.failed) return ;

                    pushFollow(FOLLOW_classOrInterfaceType_in_creator7380);
                    classOrInterfaceType();

                    state._fsp--;
                    if (state.failed) return ;

                    pushFollow(FOLLOW_classCreatorRest_in_creator7382);
                    classCreatorRest();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:926:9: arrayCreator
                    {
                    pushFollow(FOLLOW_arrayCreator_in_creator7392);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:929:1: arrayCreator : ( 'new' createdName '[' ']' ( '[' ']' )* arrayInitializer | 'new' createdName '[' expression ']' ( '[' expression ']' )* ( '[' ']' )* );
    public final void arrayCreator() throws RecognitionException {
        int arrayCreator_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 94) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:930:5: ( 'new' createdName '[' ']' ( '[' ']' )* arrayInitializer | 'new' createdName '[' expression ']' ( '[' expression ']' )* ( '[' ']' )* )
            int alt149=2;
            int LA149_0 = input.LA(1);

            if ( (LA149_0==NEW) ) {
                int LA149_1 = input.LA(2);

                if ( (synpred239_RJavaSymbolTable()) ) {
                    alt149=1;
                }
                else if ( (true) ) {
                    alt149=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 149, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 149, 0, input);

                throw nvae;

            }
            switch (alt149) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:930:9: 'new' createdName '[' ']' ( '[' ']' )* arrayInitializer
                    {
                    match(input,NEW,FOLLOW_NEW_in_arrayCreator7412); if (state.failed) return ;

                    pushFollow(FOLLOW_createdName_in_arrayCreator7414);
                    createdName();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,LBRACKET,FOLLOW_LBRACKET_in_arrayCreator7424); if (state.failed) return ;

                    match(input,RBRACKET,FOLLOW_RBRACKET_in_arrayCreator7426); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:932:9: ( '[' ']' )*
                    loop146:
                    do {
                        int alt146=2;
                        int LA146_0 = input.LA(1);

                        if ( (LA146_0==LBRACKET) ) {
                            alt146=1;
                        }


                        switch (alt146) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:932:10: '[' ']'
                    	    {
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_arrayCreator7437); if (state.failed) return ;

                    	    match(input,RBRACKET,FOLLOW_RBRACKET_in_arrayCreator7439); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop146;
                        }
                    } while (true);


                    pushFollow(FOLLOW_arrayInitializer_in_arrayCreator7460);
                    arrayInitializer();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:936:9: 'new' createdName '[' expression ']' ( '[' expression ']' )* ( '[' ']' )*
                    {
                    match(input,NEW,FOLLOW_NEW_in_arrayCreator7471); if (state.failed) return ;

                    pushFollow(FOLLOW_createdName_in_arrayCreator7473);
                    createdName();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,LBRACKET,FOLLOW_LBRACKET_in_arrayCreator7483); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_arrayCreator7485);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,RBRACKET,FOLLOW_RBRACKET_in_arrayCreator7495); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:939:9: ( '[' expression ']' )*
                    loop147:
                    do {
                        int alt147=2;
                        int LA147_0 = input.LA(1);

                        if ( (LA147_0==LBRACKET) ) {
                            int LA147_1 = input.LA(2);

                            if ( (synpred240_RJavaSymbolTable()) ) {
                                alt147=1;
                            }


                        }


                        switch (alt147) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:939:13: '[' expression ']'
                    	    {
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_arrayCreator7509); if (state.failed) return ;

                    	    pushFollow(FOLLOW_expression_in_arrayCreator7511);
                    	    expression();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    match(input,RBRACKET,FOLLOW_RBRACKET_in_arrayCreator7525); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop147;
                        }
                    } while (true);


                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:942:9: ( '[' ']' )*
                    loop148:
                    do {
                        int alt148=2;
                        int LA148_0 = input.LA(1);

                        if ( (LA148_0==LBRACKET) ) {
                            int LA148_2 = input.LA(2);

                            if ( (LA148_2==RBRACKET) ) {
                                alt148=1;
                            }


                        }


                        switch (alt148) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:942:10: '[' ']'
                    	    {
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_arrayCreator7547); if (state.failed) return ;

                    	    match(input,RBRACKET,FOLLOW_RBRACKET_in_arrayCreator7549); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop148;
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:946:1: variableInitializer : ( arrayInitializer | expression );
    public final void variableInitializer() throws RecognitionException {
        int variableInitializer_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 95) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:947:5: ( arrayInitializer | expression )
            int alt150=2;
            int LA150_0 = input.LA(1);

            if ( (LA150_0==LBRACE) ) {
                alt150=1;
            }
            else if ( (LA150_0==BANG||LA150_0==BOOLEAN||LA150_0==BYTE||(LA150_0 >= CHAR && LA150_0 <= CHARLITERAL)||(LA150_0 >= DOUBLE && LA150_0 <= DOUBLELITERAL)||LA150_0==FALSE||(LA150_0 >= FLOAT && LA150_0 <= FLOATLITERAL)||LA150_0==IDENTIFIER||LA150_0==INT||LA150_0==INTLITERAL||(LA150_0 >= LONG && LA150_0 <= LPAREN)||(LA150_0 >= NEW && LA150_0 <= NULL)||LA150_0==PLUS||LA150_0==PLUSPLUS||LA150_0==SHORT||(LA150_0 >= STRINGLITERAL && LA150_0 <= SUB)||(LA150_0 >= SUBSUB && LA150_0 <= SUPER)||LA150_0==THIS||LA150_0==TILDE||LA150_0==TRUE||LA150_0==VOID) ) {
                alt150=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 150, 0, input);

                throw nvae;

            }
            switch (alt150) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:947:9: arrayInitializer
                    {
                    pushFollow(FOLLOW_arrayInitializer_in_variableInitializer7580);
                    arrayInitializer();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:948:9: expression
                    {
                    pushFollow(FOLLOW_expression_in_variableInitializer7590);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:951:1: arrayInitializer : '{' ( variableInitializer ( ',' variableInitializer )* )? ( ',' )? '}' ;
    public final void arrayInitializer() throws RecognitionException {
        int arrayInitializer_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 96) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:952:5: ( '{' ( variableInitializer ( ',' variableInitializer )* )? ( ',' )? '}' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:952:9: '{' ( variableInitializer ( ',' variableInitializer )* )? ( ',' )? '}'
            {
            match(input,LBRACE,FOLLOW_LBRACE_in_arrayInitializer7610); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:953:13: ( variableInitializer ( ',' variableInitializer )* )?
            int alt152=2;
            int LA152_0 = input.LA(1);

            if ( (LA152_0==BANG||LA152_0==BOOLEAN||LA152_0==BYTE||(LA152_0 >= CHAR && LA152_0 <= CHARLITERAL)||(LA152_0 >= DOUBLE && LA152_0 <= DOUBLELITERAL)||LA152_0==FALSE||(LA152_0 >= FLOAT && LA152_0 <= FLOATLITERAL)||LA152_0==IDENTIFIER||LA152_0==INT||LA152_0==INTLITERAL||LA152_0==LBRACE||(LA152_0 >= LONG && LA152_0 <= LPAREN)||(LA152_0 >= NEW && LA152_0 <= NULL)||LA152_0==PLUS||LA152_0==PLUSPLUS||LA152_0==SHORT||(LA152_0 >= STRINGLITERAL && LA152_0 <= SUB)||(LA152_0 >= SUBSUB && LA152_0 <= SUPER)||LA152_0==THIS||LA152_0==TILDE||LA152_0==TRUE||LA152_0==VOID) ) {
                alt152=1;
            }
            switch (alt152) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:953:14: variableInitializer ( ',' variableInitializer )*
                    {
                    pushFollow(FOLLOW_variableInitializer_in_arrayInitializer7626);
                    variableInitializer();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:954:17: ( ',' variableInitializer )*
                    loop151:
                    do {
                        int alt151=2;
                        int LA151_0 = input.LA(1);

                        if ( (LA151_0==COMMA) ) {
                            int LA151_1 = input.LA(2);

                            if ( (LA151_1==BANG||LA151_1==BOOLEAN||LA151_1==BYTE||(LA151_1 >= CHAR && LA151_1 <= CHARLITERAL)||(LA151_1 >= DOUBLE && LA151_1 <= DOUBLELITERAL)||LA151_1==FALSE||(LA151_1 >= FLOAT && LA151_1 <= FLOATLITERAL)||LA151_1==IDENTIFIER||LA151_1==INT||LA151_1==INTLITERAL||LA151_1==LBRACE||(LA151_1 >= LONG && LA151_1 <= LPAREN)||(LA151_1 >= NEW && LA151_1 <= NULL)||LA151_1==PLUS||LA151_1==PLUSPLUS||LA151_1==SHORT||(LA151_1 >= STRINGLITERAL && LA151_1 <= SUB)||(LA151_1 >= SUBSUB && LA151_1 <= SUPER)||LA151_1==THIS||LA151_1==TILDE||LA151_1==TRUE||LA151_1==VOID) ) {
                                alt151=1;
                            }


                        }


                        switch (alt151) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:954:18: ',' variableInitializer
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_arrayInitializer7645); if (state.failed) return ;

                    	    pushFollow(FOLLOW_variableInitializer_in_arrayInitializer7647);
                    	    variableInitializer();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop151;
                        }
                    } while (true);


                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:957:13: ( ',' )?
            int alt153=2;
            int LA153_0 = input.LA(1);

            if ( (LA153_0==COMMA) ) {
                alt153=1;
            }
            switch (alt153) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:957:14: ','
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_arrayInitializer7697); if (state.failed) return ;

                    }
                    break;

            }


            match(input,RBRACE,FOLLOW_RBRACE_in_arrayInitializer7710); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:962:1: createdName : ( classOrInterfaceType | primitiveType );
    public final void createdName() throws RecognitionException {
        int createdName_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 97) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:963:5: ( classOrInterfaceType | primitiveType )
            int alt154=2;
            int LA154_0 = input.LA(1);

            if ( (LA154_0==IDENTIFIER) ) {
                alt154=1;
            }
            else if ( (LA154_0==BOOLEAN||LA154_0==BYTE||LA154_0==CHAR||LA154_0==DOUBLE||LA154_0==FLOAT||LA154_0==INT||LA154_0==LONG||LA154_0==SHORT) ) {
                alt154=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 154, 0, input);

                throw nvae;

            }
            switch (alt154) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:963:9: classOrInterfaceType
                    {
                    pushFollow(FOLLOW_classOrInterfaceType_in_createdName7744);
                    classOrInterfaceType();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:964:9: primitiveType
                    {
                    pushFollow(FOLLOW_primitiveType_in_createdName7754);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:967:1: innerCreator : '.' 'new' ( nonWildcardTypeArguments )? IDENTIFIER ( typeArguments )? classCreatorRest ;
    public final void innerCreator() throws RecognitionException {
        int innerCreator_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 98) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:968:5: ( '.' 'new' ( nonWildcardTypeArguments )? IDENTIFIER ( typeArguments )? classCreatorRest )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:968:9: '.' 'new' ( nonWildcardTypeArguments )? IDENTIFIER ( typeArguments )? classCreatorRest
            {
            match(input,DOT,FOLLOW_DOT_in_innerCreator7775); if (state.failed) return ;

            match(input,NEW,FOLLOW_NEW_in_innerCreator7777); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:969:9: ( nonWildcardTypeArguments )?
            int alt155=2;
            int LA155_0 = input.LA(1);

            if ( (LA155_0==LT) ) {
                alt155=1;
            }
            switch (alt155) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:969:10: nonWildcardTypeArguments
                    {
                    pushFollow(FOLLOW_nonWildcardTypeArguments_in_innerCreator7788);
                    nonWildcardTypeArguments();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_innerCreator7809); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:972:9: ( typeArguments )?
            int alt156=2;
            int LA156_0 = input.LA(1);

            if ( (LA156_0==LT) ) {
                alt156=1;
            }
            switch (alt156) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:972:10: typeArguments
                    {
                    pushFollow(FOLLOW_typeArguments_in_innerCreator7820);
                    typeArguments();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            pushFollow(FOLLOW_classCreatorRest_in_innerCreator7841);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:978:1: classCreatorRest : arguments ( classBody )? ;
    public final void classCreatorRest() throws RecognitionException {
        int classCreatorRest_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 99) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:979:5: ( arguments ( classBody )? )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:979:9: arguments ( classBody )?
            {
            pushFollow(FOLLOW_arguments_in_classCreatorRest7862);
            arguments();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:980:9: ( classBody )?
            int alt157=2;
            int LA157_0 = input.LA(1);

            if ( (LA157_0==LBRACE) ) {
                alt157=1;
            }
            switch (alt157) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:980:10: classBody
                    {
                    pushFollow(FOLLOW_classBody_in_classCreatorRest7873);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:985:1: nonWildcardTypeArguments : '<' typeList '>' ;
    public final void nonWildcardTypeArguments() throws RecognitionException {
        int nonWildcardTypeArguments_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 100) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:986:5: ( '<' typeList '>' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:986:9: '<' typeList '>'
            {
            match(input,LT,FOLLOW_LT_in_nonWildcardTypeArguments7905); if (state.failed) return ;

            pushFollow(FOLLOW_typeList_in_nonWildcardTypeArguments7907);
            typeList();

            state._fsp--;
            if (state.failed) return ;

            match(input,GT,FOLLOW_GT_in_nonWildcardTypeArguments7917); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:990:1: arguments : '(' ( expressionList )? ')' ;
    public final void arguments() throws RecognitionException {
        int arguments_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 101) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:991:5: ( '(' ( expressionList )? ')' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:991:9: '(' ( expressionList )? ')'
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_arguments7937); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:991:13: ( expressionList )?
            int alt158=2;
            int LA158_0 = input.LA(1);

            if ( (LA158_0==BANG||LA158_0==BOOLEAN||LA158_0==BYTE||(LA158_0 >= CHAR && LA158_0 <= CHARLITERAL)||(LA158_0 >= DOUBLE && LA158_0 <= DOUBLELITERAL)||LA158_0==FALSE||(LA158_0 >= FLOAT && LA158_0 <= FLOATLITERAL)||LA158_0==IDENTIFIER||LA158_0==INT||LA158_0==INTLITERAL||(LA158_0 >= LONG && LA158_0 <= LPAREN)||(LA158_0 >= NEW && LA158_0 <= NULL)||LA158_0==PLUS||LA158_0==PLUSPLUS||LA158_0==SHORT||(LA158_0 >= STRINGLITERAL && LA158_0 <= SUB)||(LA158_0 >= SUBSUB && LA158_0 <= SUPER)||LA158_0==THIS||LA158_0==TILDE||LA158_0==TRUE||LA158_0==VOID) ) {
                alt158=1;
            }
            switch (alt158) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:991:14: expressionList
                    {
                    pushFollow(FOLLOW_expressionList_in_arguments7940);
                    expressionList();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            match(input,RPAREN,FOLLOW_RPAREN_in_arguments7953); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:995:1: literal : ( INTLITERAL | LONGLITERAL | FLOATLITERAL | DOUBLELITERAL | CHARLITERAL | STRINGLITERAL | TRUE | FALSE | NULL );
    public final void literal() throws RecognitionException {
        int literal_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 102) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:996:5: ( INTLITERAL | LONGLITERAL | FLOATLITERAL | DOUBLELITERAL | CHARLITERAL | STRINGLITERAL | TRUE | FALSE | NULL )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1011:1: classHeader : modifiers 'class' IDENTIFIER ;
    public final void classHeader() throws RecognitionException {
        int classHeader_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 103) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1012:5: ( modifiers 'class' IDENTIFIER )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1012:9: modifiers 'class' IDENTIFIER
            {
            pushFollow(FOLLOW_modifiers_in_classHeader8077);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            match(input,CLASS,FOLLOW_CLASS_in_classHeader8079); if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_classHeader8081); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1015:1: enumHeader : modifiers ( 'enum' | IDENTIFIER ) IDENTIFIER ;
    public final void enumHeader() throws RecognitionException {
        int enumHeader_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 104) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1016:5: ( modifiers ( 'enum' | IDENTIFIER ) IDENTIFIER )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1016:9: modifiers ( 'enum' | IDENTIFIER ) IDENTIFIER
            {
            pushFollow(FOLLOW_modifiers_in_enumHeader8101);
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


            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enumHeader8109); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1019:1: interfaceHeader : modifiers 'interface' IDENTIFIER ;
    public final void interfaceHeader() throws RecognitionException {
        int interfaceHeader_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 105) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1020:5: ( modifiers 'interface' IDENTIFIER )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1020:9: modifiers 'interface' IDENTIFIER
            {
            pushFollow(FOLLOW_modifiers_in_interfaceHeader8129);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            match(input,INTERFACE,FOLLOW_INTERFACE_in_interfaceHeader8131); if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_interfaceHeader8133); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1023:1: annotationHeader : modifiers '@' 'interface' IDENTIFIER ;
    public final void annotationHeader() throws RecognitionException {
        int annotationHeader_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 106) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1024:5: ( modifiers '@' 'interface' IDENTIFIER )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1024:9: modifiers '@' 'interface' IDENTIFIER
            {
            pushFollow(FOLLOW_modifiers_in_annotationHeader8153);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            match(input,MONKEYS_AT,FOLLOW_MONKEYS_AT_in_annotationHeader8155); if (state.failed) return ;

            match(input,INTERFACE,FOLLOW_INTERFACE_in_annotationHeader8157); if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_annotationHeader8159); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1027:1: typeHeader : modifiers ( 'class' | 'enum' | ( ( '@' )? 'interface' ) ) IDENTIFIER ;
    public final void typeHeader() throws RecognitionException {
        int typeHeader_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 107) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1028:5: ( modifiers ( 'class' | 'enum' | ( ( '@' )? 'interface' ) ) IDENTIFIER )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1028:9: modifiers ( 'class' | 'enum' | ( ( '@' )? 'interface' ) ) IDENTIFIER
            {
            pushFollow(FOLLOW_modifiers_in_typeHeader8179);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1028:19: ( 'class' | 'enum' | ( ( '@' )? 'interface' ) )
            int alt160=3;
            switch ( input.LA(1) ) {
            case CLASS:
                {
                alt160=1;
                }
                break;
            case ENUM:
                {
                alt160=2;
                }
                break;
            case INTERFACE:
            case MONKEYS_AT:
                {
                alt160=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 160, 0, input);

                throw nvae;

            }

            switch (alt160) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1028:20: 'class'
                    {
                    match(input,CLASS,FOLLOW_CLASS_in_typeHeader8182); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1028:28: 'enum'
                    {
                    match(input,ENUM,FOLLOW_ENUM_in_typeHeader8184); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1028:35: ( ( '@' )? 'interface' )
                    {
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1028:35: ( ( '@' )? 'interface' )
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1028:36: ( '@' )? 'interface'
                    {
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1028:36: ( '@' )?
                    int alt159=2;
                    int LA159_0 = input.LA(1);

                    if ( (LA159_0==MONKEYS_AT) ) {
                        alt159=1;
                    }
                    switch (alt159) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1028:36: '@'
                            {
                            match(input,MONKEYS_AT,FOLLOW_MONKEYS_AT_in_typeHeader8187); if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,INTERFACE,FOLLOW_INTERFACE_in_typeHeader8191); if (state.failed) return ;

                    }


                    }
                    break;

            }


            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_typeHeader8195); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1031:1: methodHeader : modifiers ( typeParameters )? ( type | 'void' )? IDENTIFIER '(' ;
    public final void methodHeader() throws RecognitionException {
        int methodHeader_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 108) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1032:5: ( modifiers ( typeParameters )? ( type | 'void' )? IDENTIFIER '(' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1032:9: modifiers ( typeParameters )? ( type | 'void' )? IDENTIFIER '('
            {
            pushFollow(FOLLOW_modifiers_in_methodHeader8215);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1032:19: ( typeParameters )?
            int alt161=2;
            int LA161_0 = input.LA(1);

            if ( (LA161_0==LT) ) {
                alt161=1;
            }
            switch (alt161) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1032:19: typeParameters
                    {
                    pushFollow(FOLLOW_typeParameters_in_methodHeader8217);
                    typeParameters();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1032:35: ( type | 'void' )?
            int alt162=3;
            switch ( input.LA(1) ) {
                case IDENTIFIER:
                    {
                    int LA162_1 = input.LA(2);

                    if ( (LA162_1==DOT||LA162_1==IDENTIFIER||LA162_1==LBRACKET||LA162_1==LT) ) {
                        alt162=1;
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
                    alt162=1;
                    }
                    break;
                case VOID:
                    {
                    alt162=2;
                    }
                    break;
            }

            switch (alt162) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1032:36: type
                    {
                    pushFollow(FOLLOW_type_in_methodHeader8221);
                    type();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1032:41: 'void'
                    {
                    match(input,VOID,FOLLOW_VOID_in_methodHeader8223); if (state.failed) return ;

                    }
                    break;

            }


            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_methodHeader8227); if (state.failed) return ;

            match(input,LPAREN,FOLLOW_LPAREN_in_methodHeader8229); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1035:1: fieldHeader : modifiers type IDENTIFIER ( '[' ']' )* ( '=' | ',' | ';' ) ;
    public final void fieldHeader() throws RecognitionException {
        int fieldHeader_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 109) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1036:5: ( modifiers type IDENTIFIER ( '[' ']' )* ( '=' | ',' | ';' ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1036:9: modifiers type IDENTIFIER ( '[' ']' )* ( '=' | ',' | ';' )
            {
            pushFollow(FOLLOW_modifiers_in_fieldHeader8249);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_type_in_fieldHeader8251);
            type();

            state._fsp--;
            if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_fieldHeader8253); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1036:35: ( '[' ']' )*
            loop163:
            do {
                int alt163=2;
                int LA163_0 = input.LA(1);

                if ( (LA163_0==LBRACKET) ) {
                    alt163=1;
                }


                switch (alt163) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1036:36: '[' ']'
            	    {
            	    match(input,LBRACKET,FOLLOW_LBRACKET_in_fieldHeader8256); if (state.failed) return ;

            	    match(input,RBRACKET,FOLLOW_RBRACKET_in_fieldHeader8257); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop163;
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1039:1: localVariableHeader : variableModifiers type IDENTIFIER ( '[' ']' )* ( '=' | ',' | ';' ) ;
    public final void localVariableHeader() throws RecognitionException {
        int localVariableHeader_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 110) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1040:5: ( variableModifiers type IDENTIFIER ( '[' ']' )* ( '=' | ',' | ';' ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1040:9: variableModifiers type IDENTIFIER ( '[' ']' )* ( '=' | ',' | ';' )
            {
            pushFollow(FOLLOW_variableModifiers_in_localVariableHeader8287);
            variableModifiers();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_type_in_localVariableHeader8289);
            type();

            state._fsp--;
            if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_localVariableHeader8291); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1040:43: ( '[' ']' )*
            loop164:
            do {
                int alt164=2;
                int LA164_0 = input.LA(1);

                if ( (LA164_0==LBRACKET) ) {
                    alt164=1;
                }


                switch (alt164) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1040:44: '[' ']'
            	    {
            	    match(input,LBRACKET,FOLLOW_LBRACKET_in_localVariableHeader8294); if (state.failed) return ;

            	    match(input,RBRACKET,FOLLOW_RBRACKET_in_localVariableHeader8295); if (state.failed) return ;

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
            if ( state.backtracking>0 ) { memoize(input, 110, localVariableHeader_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "localVariableHeader"

    // $ANTLR start synpred2_RJavaSymbolTable
    public final void synpred2_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:28:13: ( ( annotations )? packageDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:28:13: ( annotations )? packageDeclaration
        {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:28:13: ( annotations )?
        int alt165=2;
        int LA165_0 = input.LA(1);

        if ( (LA165_0==MONKEYS_AT) ) {
            alt165=1;
        }
        switch (alt165) {
            case 1 :
                // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:28:14: annotations
                {
                pushFollow(FOLLOW_annotations_in_synpred2_RJavaSymbolTable75);
                annotations();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        pushFollow(FOLLOW_packageDeclaration_in_synpred2_RJavaSymbolTable104);
        packageDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred2_RJavaSymbolTable

    // $ANTLR start synpred12_RJavaSymbolTable
    public final void synpred12_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:72:10: ( classDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:72:10: classDeclaration
        {
        pushFollow(FOLLOW_classDeclaration_in_synpred12_RJavaSymbolTable465);
        classDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred12_RJavaSymbolTable

    // $ANTLR start synpred27_RJavaSymbolTable
    public final void synpred27_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:103:9: ( normalClassDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:103:9: normalClassDeclaration
        {
        pushFollow(FOLLOW_normalClassDeclaration_in_synpred27_RJavaSymbolTable702);
        normalClassDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred27_RJavaSymbolTable

    // $ANTLR start synpred43_RJavaSymbolTable
    public final void synpred43_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:191:9: ( normalInterfaceDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:191:9: normalInterfaceDeclaration
        {
        pushFollow(FOLLOW_normalInterfaceDeclaration_in_synpred43_RJavaSymbolTable1381);
        normalInterfaceDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred43_RJavaSymbolTable

    // $ANTLR start synpred52_RJavaSymbolTable
    public final void synpred52_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:236:10: ( fieldDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:236:10: fieldDeclaration
        {
        pushFollow(FOLLOW_fieldDeclaration_in_synpred52_RJavaSymbolTable1744);
        fieldDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred52_RJavaSymbolTable

    // $ANTLR start synpred53_RJavaSymbolTable
    public final void synpred53_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:237:10: ( methodDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:237:10: methodDeclaration
        {
        pushFollow(FOLLOW_methodDeclaration_in_synpred53_RJavaSymbolTable1755);
        methodDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred53_RJavaSymbolTable

    // $ANTLR start synpred54_RJavaSymbolTable
    public final void synpred54_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:238:10: ( classDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:238:10: classDeclaration
        {
        pushFollow(FOLLOW_classDeclaration_in_synpred54_RJavaSymbolTable1766);
        classDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred54_RJavaSymbolTable

    // $ANTLR start synpred57_RJavaSymbolTable
    public final void synpred57_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:255:10: ( explicitConstructorInvocation )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:255:10: explicitConstructorInvocation
        {
        pushFollow(FOLLOW_explicitConstructorInvocation_in_synpred57_RJavaSymbolTable1914);
        explicitConstructorInvocation();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred57_RJavaSymbolTable

    // $ANTLR start synpred59_RJavaSymbolTable
    public final void synpred59_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:246:9: ( modifiers ( typeParameters )? IDENTIFIER formalParameters ( 'throws' qualifiedNameList )? '{' ( explicitConstructorInvocation )? ( blockStatement )* '}' )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:246:9: modifiers ( typeParameters )? IDENTIFIER formalParameters ( 'throws' qualifiedNameList )? '{' ( explicitConstructorInvocation )? ( blockStatement )* '}'
        {
        pushFollow(FOLLOW_modifiers_in_synpred59_RJavaSymbolTable1825);
        modifiers();

        state._fsp--;
        if (state.failed) return ;

        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:248:9: ( typeParameters )?
        int alt167=2;
        int LA167_0 = input.LA(1);

        if ( (LA167_0==LT) ) {
            alt167=1;
        }
        switch (alt167) {
            case 1 :
                // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:248:10: typeParameters
                {
                pushFollow(FOLLOW_typeParameters_in_synpred59_RJavaSymbolTable1836);
                typeParameters();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred59_RJavaSymbolTable1857); if (state.failed) return ;

        pushFollow(FOLLOW_formalParameters_in_synpred59_RJavaSymbolTable1868);
        formalParameters();

        state._fsp--;
        if (state.failed) return ;

        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:252:9: ( 'throws' qualifiedNameList )?
        int alt168=2;
        int LA168_0 = input.LA(1);

        if ( (LA168_0==THROWS) ) {
            alt168=1;
        }
        switch (alt168) {
            case 1 :
                // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:252:10: 'throws' qualifiedNameList
                {
                match(input,THROWS,FOLLOW_THROWS_in_synpred59_RJavaSymbolTable1879); if (state.failed) return ;

                pushFollow(FOLLOW_qualifiedNameList_in_synpred59_RJavaSymbolTable1881);
                qualifiedNameList();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        match(input,LBRACE,FOLLOW_LBRACE_in_synpred59_RJavaSymbolTable1902); if (state.failed) return ;

        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:255:9: ( explicitConstructorInvocation )?
        int alt169=2;
        switch ( input.LA(1) ) {
            case LT:
                {
                alt169=1;
                }
                break;
            case THIS:
                {
                int LA169_2 = input.LA(2);

                if ( (synpred57_RJavaSymbolTable()) ) {
                    alt169=1;
                }
                }
                break;
            case LPAREN:
                {
                int LA169_3 = input.LA(2);

                if ( (synpred57_RJavaSymbolTable()) ) {
                    alt169=1;
                }
                }
                break;
            case SUPER:
                {
                int LA169_4 = input.LA(2);

                if ( (synpred57_RJavaSymbolTable()) ) {
                    alt169=1;
                }
                }
                break;
            case IDENTIFIER:
                {
                int LA169_5 = input.LA(2);

                if ( (synpred57_RJavaSymbolTable()) ) {
                    alt169=1;
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
                int LA169_6 = input.LA(2);

                if ( (synpred57_RJavaSymbolTable()) ) {
                    alt169=1;
                }
                }
                break;
            case NEW:
                {
                int LA169_7 = input.LA(2);

                if ( (synpred57_RJavaSymbolTable()) ) {
                    alt169=1;
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
                int LA169_8 = input.LA(2);

                if ( (synpred57_RJavaSymbolTable()) ) {
                    alt169=1;
                }
                }
                break;
            case VOID:
                {
                int LA169_9 = input.LA(2);

                if ( (synpred57_RJavaSymbolTable()) ) {
                    alt169=1;
                }
                }
                break;
        }

        switch (alt169) {
            case 1 :
                // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:255:10: explicitConstructorInvocation
                {
                pushFollow(FOLLOW_explicitConstructorInvocation_in_synpred59_RJavaSymbolTable1914);
                explicitConstructorInvocation();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:257:9: ( blockStatement )*
        loop170:
        do {
            int alt170=2;
            int LA170_0 = input.LA(1);

            if ( (LA170_0==ABSTRACT||(LA170_0 >= ASSERT && LA170_0 <= BANG)||(LA170_0 >= BOOLEAN && LA170_0 <= BYTE)||(LA170_0 >= CHAR && LA170_0 <= CLASS)||LA170_0==CONTINUE||LA170_0==DO||(LA170_0 >= DOUBLE && LA170_0 <= DOUBLELITERAL)||LA170_0==ENUM||(LA170_0 >= FALSE && LA170_0 <= FINAL)||(LA170_0 >= FLOAT && LA170_0 <= FOR)||(LA170_0 >= IDENTIFIER && LA170_0 <= IF)||(LA170_0 >= INT && LA170_0 <= INTLITERAL)||LA170_0==LBRACE||(LA170_0 >= LONG && LA170_0 <= LT)||(LA170_0 >= MONKEYS_AT && LA170_0 <= NULL)||LA170_0==PLUS||(LA170_0 >= PLUSPLUS && LA170_0 <= PUBLIC)||LA170_0==RETURN||(LA170_0 >= SEMI && LA170_0 <= SHORT)||(LA170_0 >= STATIC && LA170_0 <= SUB)||(LA170_0 >= SUBSUB && LA170_0 <= SYNCHRONIZED)||(LA170_0 >= THIS && LA170_0 <= THROW)||(LA170_0 >= TILDE && LA170_0 <= WHILE)) ) {
                alt170=1;
            }


            switch (alt170) {
        	case 1 :
        	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:257:10: blockStatement
        	    {
        	    pushFollow(FOLLOW_blockStatement_in_synpred59_RJavaSymbolTable1936);
        	    blockStatement();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop170;
            }
        } while (true);


        match(input,RBRACE,FOLLOW_RBRACE_in_synpred59_RJavaSymbolTable1957); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred59_RJavaSymbolTable

    // $ANTLR start synpred68_RJavaSymbolTable
    public final void synpred68_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:308:9: ( interfaceFieldDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:308:9: interfaceFieldDeclaration
        {
        pushFollow(FOLLOW_interfaceFieldDeclaration_in_synpred68_RJavaSymbolTable2378);
        interfaceFieldDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred68_RJavaSymbolTable

    // $ANTLR start synpred69_RJavaSymbolTable
    public final void synpred69_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:309:9: ( interfaceMethodDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:309:9: interfaceMethodDeclaration
        {
        pushFollow(FOLLOW_interfaceMethodDeclaration_in_synpred69_RJavaSymbolTable2388);
        interfaceMethodDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred69_RJavaSymbolTable

    // $ANTLR start synpred70_RJavaSymbolTable
    public final void synpred70_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:310:9: ( interfaceDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:310:9: interfaceDeclaration
        {
        pushFollow(FOLLOW_interfaceDeclaration_in_synpred70_RJavaSymbolTable2398);
        interfaceDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred70_RJavaSymbolTable

    // $ANTLR start synpred71_RJavaSymbolTable
    public final void synpred71_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:311:9: ( classDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:311:9: classDeclaration
        {
        pushFollow(FOLLOW_classDeclaration_in_synpred71_RJavaSymbolTable2408);
        classDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred71_RJavaSymbolTable

    // $ANTLR start synpred96_RJavaSymbolTable
    public final void synpred96_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:406:9: ( ellipsisParameterDecl )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:406:9: ellipsisParameterDecl
        {
        pushFollow(FOLLOW_ellipsisParameterDecl_in_synpred96_RJavaSymbolTable3172);
        ellipsisParameterDecl();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred96_RJavaSymbolTable

    // $ANTLR start synpred98_RJavaSymbolTable
    public final void synpred98_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:407:9: ( normalParameterDecl ( ',' normalParameterDecl )* )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:407:9: normalParameterDecl ( ',' normalParameterDecl )*
        {
        pushFollow(FOLLOW_normalParameterDecl_in_synpred98_RJavaSymbolTable3182);
        normalParameterDecl();

        state._fsp--;
        if (state.failed) return ;

        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:408:9: ( ',' normalParameterDecl )*
        loop173:
        do {
            int alt173=2;
            int LA173_0 = input.LA(1);

            if ( (LA173_0==COMMA) ) {
                alt173=1;
            }


            switch (alt173) {
        	case 1 :
        	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:408:10: ',' normalParameterDecl
        	    {
        	    match(input,COMMA,FOLLOW_COMMA_in_synpred98_RJavaSymbolTable3193); if (state.failed) return ;

        	    pushFollow(FOLLOW_normalParameterDecl_in_synpred98_RJavaSymbolTable3195);
        	    normalParameterDecl();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop173;
            }
        } while (true);


        }

    }
    // $ANTLR end synpred98_RJavaSymbolTable

    // $ANTLR start synpred99_RJavaSymbolTable
    public final void synpred99_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:410:10: ( normalParameterDecl ',' )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:410:10: normalParameterDecl ','
        {
        pushFollow(FOLLOW_normalParameterDecl_in_synpred99_RJavaSymbolTable3217);
        normalParameterDecl();

        state._fsp--;
        if (state.failed) return ;

        match(input,COMMA,FOLLOW_COMMA_in_synpred99_RJavaSymbolTable3227); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred99_RJavaSymbolTable

    // $ANTLR start synpred103_RJavaSymbolTable
    public final void synpred103_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:441:9: ( ( nonWildcardTypeArguments )? ( 'this' | 'super' ) arguments ';' )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:441:9: ( nonWildcardTypeArguments )? ( 'this' | 'super' ) arguments ';'
        {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:441:9: ( nonWildcardTypeArguments )?
        int alt174=2;
        int LA174_0 = input.LA(1);

        if ( (LA174_0==LT) ) {
            alt174=1;
        }
        switch (alt174) {
            case 1 :
                // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:441:10: nonWildcardTypeArguments
                {
                pushFollow(FOLLOW_nonWildcardTypeArguments_in_synpred103_RJavaSymbolTable3410);
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


        pushFollow(FOLLOW_arguments_in_synpred103_RJavaSymbolTable3468);
        arguments();

        state._fsp--;
        if (state.failed) return ;

        match(input,SEMI,FOLLOW_SEMI_in_synpred103_RJavaSymbolTable3470); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred103_RJavaSymbolTable

    // $ANTLR start synpred117_RJavaSymbolTable
    public final void synpred117_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:528:9: ( annotationMethodDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:528:9: annotationMethodDeclaration
        {
        pushFollow(FOLLOW_annotationMethodDeclaration_in_synpred117_RJavaSymbolTable4069);
        annotationMethodDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred117_RJavaSymbolTable

    // $ANTLR start synpred118_RJavaSymbolTable
    public final void synpred118_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:529:9: ( interfaceFieldDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:529:9: interfaceFieldDeclaration
        {
        pushFollow(FOLLOW_interfaceFieldDeclaration_in_synpred118_RJavaSymbolTable4079);
        interfaceFieldDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred118_RJavaSymbolTable

    // $ANTLR start synpred119_RJavaSymbolTable
    public final void synpred119_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:530:9: ( normalClassDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:530:9: normalClassDeclaration
        {
        pushFollow(FOLLOW_normalClassDeclaration_in_synpred119_RJavaSymbolTable4089);
        normalClassDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred119_RJavaSymbolTable

    // $ANTLR start synpred120_RJavaSymbolTable
    public final void synpred120_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:531:9: ( normalInterfaceDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:531:9: normalInterfaceDeclaration
        {
        pushFollow(FOLLOW_normalInterfaceDeclaration_in_synpred120_RJavaSymbolTable4099);
        normalInterfaceDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred120_RJavaSymbolTable

    // $ANTLR start synpred121_RJavaSymbolTable
    public final void synpred121_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:532:9: ( enumDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:532:9: enumDeclaration
        {
        pushFollow(FOLLOW_enumDeclaration_in_synpred121_RJavaSymbolTable4109);
        enumDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred121_RJavaSymbolTable

    // $ANTLR start synpred122_RJavaSymbolTable
    public final void synpred122_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:533:9: ( annotationTypeDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:533:9: annotationTypeDeclaration
        {
        pushFollow(FOLLOW_annotationTypeDeclaration_in_synpred122_RJavaSymbolTable4119);
        annotationTypeDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred122_RJavaSymbolTable

    // $ANTLR start synpred125_RJavaSymbolTable
    public final void synpred125_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:578:9: ( localVariableDeclarationStatement )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:578:9: localVariableDeclarationStatement
        {
        pushFollow(FOLLOW_localVariableDeclarationStatement_in_synpred125_RJavaSymbolTable4297);
        localVariableDeclarationStatement();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred125_RJavaSymbolTable

    // $ANTLR start synpred126_RJavaSymbolTable
    public final void synpred126_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:579:9: ( classOrInterfaceDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:579:9: classOrInterfaceDeclaration
        {
        pushFollow(FOLLOW_classOrInterfaceDeclaration_in_synpred126_RJavaSymbolTable4307);
        classOrInterfaceDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred126_RJavaSymbolTable

    // $ANTLR start synpred130_RJavaSymbolTable
    public final void synpred130_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:599:9: ( ( 'assert' ) expression ( ':' expression )? ';' )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:599:9: ( 'assert' ) expression ( ':' expression )? ';'
        {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:599:9: ( 'assert' )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:599:10: 'assert'
        {
        match(input,ASSERT,FOLLOW_ASSERT_in_synpred130_RJavaSymbolTable4450); if (state.failed) return ;

        }


        pushFollow(FOLLOW_expression_in_synpred130_RJavaSymbolTable4470);
        expression();

        state._fsp--;
        if (state.failed) return ;

        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:601:20: ( ':' expression )?
        int alt177=2;
        int LA177_0 = input.LA(1);

        if ( (LA177_0==COLON) ) {
            alt177=1;
        }
        switch (alt177) {
            case 1 :
                // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:601:21: ':' expression
                {
                match(input,COLON,FOLLOW_COLON_in_synpred130_RJavaSymbolTable4473); if (state.failed) return ;

                pushFollow(FOLLOW_expression_in_synpred130_RJavaSymbolTable4475);
                expression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        match(input,SEMI,FOLLOW_SEMI_in_synpred130_RJavaSymbolTable4479); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred130_RJavaSymbolTable

    // $ANTLR start synpred132_RJavaSymbolTable
    public final void synpred132_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:602:9: ( 'assert' expression ( ':' expression )? ';' )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:602:9: 'assert' expression ( ':' expression )? ';'
        {
        match(input,ASSERT,FOLLOW_ASSERT_in_synpred132_RJavaSymbolTable4489); if (state.failed) return ;

        pushFollow(FOLLOW_expression_in_synpred132_RJavaSymbolTable4492);
        expression();

        state._fsp--;
        if (state.failed) return ;

        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:602:30: ( ':' expression )?
        int alt178=2;
        int LA178_0 = input.LA(1);

        if ( (LA178_0==COLON) ) {
            alt178=1;
        }
        switch (alt178) {
            case 1 :
                // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:602:31: ':' expression
                {
                match(input,COLON,FOLLOW_COLON_in_synpred132_RJavaSymbolTable4495); if (state.failed) return ;

                pushFollow(FOLLOW_expression_in_synpred132_RJavaSymbolTable4497);
                expression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        match(input,SEMI,FOLLOW_SEMI_in_synpred132_RJavaSymbolTable4501); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred132_RJavaSymbolTable

    // $ANTLR start synpred133_RJavaSymbolTable
    public final void synpred133_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:603:39: ( 'else' statement )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:603:39: 'else' statement
        {
        match(input,ELSE,FOLLOW_ELSE_in_synpred133_RJavaSymbolTable4530); if (state.failed) return ;

        pushFollow(FOLLOW_statement_in_synpred133_RJavaSymbolTable4532);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred133_RJavaSymbolTable

    // $ANTLR start synpred148_RJavaSymbolTable
    public final void synpred148_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:618:9: ( expression ';' )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:618:9: expression ';'
        {
        pushFollow(FOLLOW_expression_in_synpred148_RJavaSymbolTable4754);
        expression();

        state._fsp--;
        if (state.failed) return ;

        match(input,SEMI,FOLLOW_SEMI_in_synpred148_RJavaSymbolTable4757); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred148_RJavaSymbolTable

    // $ANTLR start synpred149_RJavaSymbolTable
    public final void synpred149_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:619:9: ( IDENTIFIER ':' statement )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:619:9: IDENTIFIER ':' statement
        {
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred149_RJavaSymbolTable4772); if (state.failed) return ;

        match(input,COLON,FOLLOW_COLON_in_synpred149_RJavaSymbolTable4774); if (state.failed) return ;

        pushFollow(FOLLOW_statement_in_synpred149_RJavaSymbolTable4776);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred149_RJavaSymbolTable

    // $ANTLR start synpred153_RJavaSymbolTable
    public final void synpred153_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:643:13: ( catches 'finally' block )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:643:13: catches 'finally' block
        {
        pushFollow(FOLLOW_catches_in_synpred153_RJavaSymbolTable4932);
        catches();

        state._fsp--;
        if (state.failed) return ;

        match(input,FINALLY,FOLLOW_FINALLY_in_synpred153_RJavaSymbolTable4934); if (state.failed) return ;

        pushFollow(FOLLOW_block_in_synpred153_RJavaSymbolTable4936);
        block();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred153_RJavaSymbolTable

    // $ANTLR start synpred154_RJavaSymbolTable
    public final void synpred154_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:644:13: ( catches )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:644:13: catches
        {
        pushFollow(FOLLOW_catches_in_synpred154_RJavaSymbolTable4950);
        catches();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred154_RJavaSymbolTable

    // $ANTLR start synpred157_RJavaSymbolTable
    public final void synpred157_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:669:9: ( 'for' '(' variableModifiers type IDENTIFIER ':' expression ')' statement )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:669:9: 'for' '(' variableModifiers type IDENTIFIER ':' expression ')' statement
        {
        match(input,FOR,FOLLOW_FOR_in_synpred157_RJavaSymbolTable5152); if (state.failed) return ;

        match(input,LPAREN,FOLLOW_LPAREN_in_synpred157_RJavaSymbolTable5154); if (state.failed) return ;

        pushFollow(FOLLOW_variableModifiers_in_synpred157_RJavaSymbolTable5156);
        variableModifiers();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_type_in_synpred157_RJavaSymbolTable5158);
        type();

        state._fsp--;
        if (state.failed) return ;

        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred157_RJavaSymbolTable5160); if (state.failed) return ;

        match(input,COLON,FOLLOW_COLON_in_synpred157_RJavaSymbolTable5162); if (state.failed) return ;

        pushFollow(FOLLOW_expression_in_synpred157_RJavaSymbolTable5183);
        expression();

        state._fsp--;
        if (state.failed) return ;

        match(input,RPAREN,FOLLOW_RPAREN_in_synpred157_RJavaSymbolTable5185); if (state.failed) return ;

        pushFollow(FOLLOW_statement_in_synpred157_RJavaSymbolTable5187);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred157_RJavaSymbolTable

    // $ANTLR start synpred161_RJavaSymbolTable
    public final void synpred161_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:692:9: ( localVariableDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:692:9: localVariableDeclaration
        {
        pushFollow(FOLLOW_localVariableDeclaration_in_synpred161_RJavaSymbolTable5405);
        localVariableDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred161_RJavaSymbolTable

    // $ANTLR start synpred202_RJavaSymbolTable
    public final void synpred202_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:846:9: ( castExpression )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:846:9: castExpression
        {
        pushFollow(FOLLOW_castExpression_in_synpred202_RJavaSymbolTable6650);
        castExpression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred202_RJavaSymbolTable

    // $ANTLR start synpred206_RJavaSymbolTable
    public final void synpred206_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:856:9: ( '(' primitiveType ')' unaryExpression )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:856:9: '(' primitiveType ')' unaryExpression
        {
        match(input,LPAREN,FOLLOW_LPAREN_in_synpred206_RJavaSymbolTable6741); if (state.failed) return ;

        pushFollow(FOLLOW_primitiveType_in_synpred206_RJavaSymbolTable6743);
        primitiveType();

        state._fsp--;
        if (state.failed) return ;

        match(input,RPAREN,FOLLOW_RPAREN_in_synpred206_RJavaSymbolTable6745); if (state.failed) return ;

        pushFollow(FOLLOW_unaryExpression_in_synpred206_RJavaSymbolTable6747);
        unaryExpression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred206_RJavaSymbolTable

    // $ANTLR start synpred208_RJavaSymbolTable
    public final void synpred208_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:866:10: ( '.' IDENTIFIER )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:866:10: '.' IDENTIFIER
        {
        match(input,DOT,FOLLOW_DOT_in_synpred208_RJavaSymbolTable6818); if (state.failed) return ;

        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred208_RJavaSymbolTable6820); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred208_RJavaSymbolTable

    // $ANTLR start synpred209_RJavaSymbolTable
    public final void synpred209_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:868:10: ( identifierSuffix )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:868:10: identifierSuffix
        {
        pushFollow(FOLLOW_identifierSuffix_in_synpred209_RJavaSymbolTable6842);
        identifierSuffix();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred209_RJavaSymbolTable

    // $ANTLR start synpred211_RJavaSymbolTable
    public final void synpred211_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:871:10: ( '.' IDENTIFIER )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:871:10: '.' IDENTIFIER
        {
        match(input,DOT,FOLLOW_DOT_in_synpred211_RJavaSymbolTable6874); if (state.failed) return ;

        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred211_RJavaSymbolTable6876); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred211_RJavaSymbolTable

    // $ANTLR start synpred212_RJavaSymbolTable
    public final void synpred212_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:873:10: ( identifierSuffix )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:873:10: identifierSuffix
        {
        pushFollow(FOLLOW_identifierSuffix_in_synpred212_RJavaSymbolTable6898);
        identifierSuffix();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred212_RJavaSymbolTable

    // $ANTLR start synpred224_RJavaSymbolTable
    public final void synpred224_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:901:10: ( '[' expression ']' )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:901:10: '[' expression ']'
        {
        match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred224_RJavaSymbolTable7149); if (state.failed) return ;

        pushFollow(FOLLOW_expression_in_synpred224_RJavaSymbolTable7151);
        expression();

        state._fsp--;
        if (state.failed) return ;

        match(input,RBRACKET,FOLLOW_RBRACKET_in_synpred224_RJavaSymbolTable7153); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred224_RJavaSymbolTable

    // $ANTLR start synpred236_RJavaSymbolTable
    public final void synpred236_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:924:9: ( 'new' nonWildcardTypeArguments classOrInterfaceType classCreatorRest )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:924:9: 'new' nonWildcardTypeArguments classOrInterfaceType classCreatorRest
        {
        match(input,NEW,FOLLOW_NEW_in_synpred236_RJavaSymbolTable7362); if (state.failed) return ;

        pushFollow(FOLLOW_nonWildcardTypeArguments_in_synpred236_RJavaSymbolTable7364);
        nonWildcardTypeArguments();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_classOrInterfaceType_in_synpred236_RJavaSymbolTable7366);
        classOrInterfaceType();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_classCreatorRest_in_synpred236_RJavaSymbolTable7368);
        classCreatorRest();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred236_RJavaSymbolTable

    // $ANTLR start synpred237_RJavaSymbolTable
    public final void synpred237_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:925:9: ( 'new' classOrInterfaceType classCreatorRest )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:925:9: 'new' classOrInterfaceType classCreatorRest
        {
        match(input,NEW,FOLLOW_NEW_in_synpred237_RJavaSymbolTable7378); if (state.failed) return ;

        pushFollow(FOLLOW_classOrInterfaceType_in_synpred237_RJavaSymbolTable7380);
        classOrInterfaceType();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_classCreatorRest_in_synpred237_RJavaSymbolTable7382);
        classCreatorRest();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred237_RJavaSymbolTable

    // $ANTLR start synpred239_RJavaSymbolTable
    public final void synpred239_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:930:9: ( 'new' createdName '[' ']' ( '[' ']' )* arrayInitializer )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:930:9: 'new' createdName '[' ']' ( '[' ']' )* arrayInitializer
        {
        match(input,NEW,FOLLOW_NEW_in_synpred239_RJavaSymbolTable7412); if (state.failed) return ;

        pushFollow(FOLLOW_createdName_in_synpred239_RJavaSymbolTable7414);
        createdName();

        state._fsp--;
        if (state.failed) return ;

        match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred239_RJavaSymbolTable7424); if (state.failed) return ;

        match(input,RBRACKET,FOLLOW_RBRACKET_in_synpred239_RJavaSymbolTable7426); if (state.failed) return ;

        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:932:9: ( '[' ']' )*
        loop191:
        do {
            int alt191=2;
            int LA191_0 = input.LA(1);

            if ( (LA191_0==LBRACKET) ) {
                alt191=1;
            }


            switch (alt191) {
        	case 1 :
        	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:932:10: '[' ']'
        	    {
        	    match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred239_RJavaSymbolTable7437); if (state.failed) return ;

        	    match(input,RBRACKET,FOLLOW_RBRACKET_in_synpred239_RJavaSymbolTable7439); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop191;
            }
        } while (true);


        pushFollow(FOLLOW_arrayInitializer_in_synpred239_RJavaSymbolTable7460);
        arrayInitializer();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred239_RJavaSymbolTable

    // $ANTLR start synpred240_RJavaSymbolTable
    public final void synpred240_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:939:13: ( '[' expression ']' )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:939:13: '[' expression ']'
        {
        match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred240_RJavaSymbolTable7509); if (state.failed) return ;

        pushFollow(FOLLOW_expression_in_synpred240_RJavaSymbolTable7511);
        expression();

        state._fsp--;
        if (state.failed) return ;

        match(input,RBRACKET,FOLLOW_RBRACKET_in_synpred240_RJavaSymbolTable7525); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred240_RJavaSymbolTable

    // Delegated rules

    public final boolean synpred211_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred211_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred209_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred209_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred161_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred161_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred132_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred132_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred53_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred53_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred96_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred96_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred212_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred212_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred69_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred69_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred154_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred154_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred206_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred206_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred99_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred99_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred157_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred157_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred236_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred236_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred119_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred119_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred130_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred130_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred117_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred117_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred153_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred153_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred125_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred125_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred43_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred122_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred122_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred68_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred68_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred103_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred103_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred118_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred118_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred148_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred148_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred149_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred149_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred121_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred121_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred133_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred133_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred239_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred239_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred224_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred224_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred54_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred71_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred71_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred126_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred126_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred52_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred52_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred237_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred237_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred240_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred240_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred208_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred208_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred59_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred59_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred57_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred57_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred120_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred120_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred98_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred98_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred202_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred202_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred70_RJavaSymbolTable() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred70_RJavaSymbolTable_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_annotations_in_compilationUnit75 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_packageDeclaration_in_compilationUnit104 = new BitSet(new long[]{0x1200102000800012L,0x0011040C10700600L});
    public static final BitSet FOLLOW_importDeclaration_in_compilationUnit126 = new BitSet(new long[]{0x1200102000800012L,0x0011040C10700600L});
    public static final BitSet FOLLOW_typeDeclaration_in_compilationUnit150 = new BitSet(new long[]{0x1000102000800012L,0x0011040C10700600L});
    public static final BitSet FOLLOW_PACKAGE_in_packageDeclaration181 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_qualifiedName_in_packageDeclaration183 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_packageDeclaration193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_importDeclaration215 = new BitSet(new long[]{0x0040000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_STATIC_in_importDeclaration227 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_importDeclaration248 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_DOT_in_importDeclaration250 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_STAR_in_importDeclaration252 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_importDeclaration262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_importDeclaration279 = new BitSet(new long[]{0x0040000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_STATIC_in_importDeclaration291 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_importDeclaration312 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_DOT_in_importDeclaration323 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_importDeclaration325 = new BitSet(new long[]{0x0000000080000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_DOT_in_importDeclaration347 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_STAR_in_importDeclaration349 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_importDeclaration370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_qualifiedImportName390 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_DOT_in_qualifiedImportName401 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_qualifiedImportName403 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_classOrInterfaceDeclaration_in_typeDeclaration434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_typeDeclaration444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classDeclaration_in_classOrInterfaceDeclaration465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceDeclaration_in_classOrInterfaceDeclaration475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_modifiers510 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_PUBLIC_in_modifiers520 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_PROTECTED_in_modifiers530 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_PRIVATE_in_modifiers540 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_STATIC_in_modifiers550 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_ABSTRACT_in_modifiers560 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_FINAL_in_modifiers570 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_NATIVE_in_modifiers580 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_SYNCHRONIZED_in_modifiers590 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_TRANSIENT_in_modifiers600 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_VOLATILE_in_modifiers610 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_STRICTFP_in_modifiers620 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_FINAL_in_variableModifiers652 = new BitSet(new long[]{0x0000100000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_annotation_in_variableModifiers666 = new BitSet(new long[]{0x0000100000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_normalClassDeclaration_in_classDeclaration702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumDeclaration_in_classDeclaration712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_normalClassDeclaration732 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_CLASS_in_normalClassDeclaration735 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_normalClassDeclaration737 = new BitSet(new long[]{0x0100010000000000L,0x0000000000000082L});
    public static final BitSet FOLLOW_typeParameters_in_normalClassDeclaration748 = new BitSet(new long[]{0x0100010000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_EXTENDS_in_normalClassDeclaration770 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_normalClassDeclaration772 = new BitSet(new long[]{0x0100000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_IMPLEMENTS_in_normalClassDeclaration794 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_typeList_in_normalClassDeclaration796 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_classBody_in_normalClassDeclaration829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_typeParameters850 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_typeParameter_in_typeParameters864 = new BitSet(new long[]{0x0008000002000000L});
    public static final BitSet FOLLOW_COMMA_in_typeParameters879 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_typeParameter_in_typeParameters881 = new BitSet(new long[]{0x0008000002000000L});
    public static final BitSet FOLLOW_GT_in_typeParameters906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_typeParameter926 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_EXTENDS_in_typeParameter937 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_typeBound_in_typeParameter939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typeBound971 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_AMP_in_typeBound982 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_typeBound984 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_modifiers_in_enumDeclaration1016 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_ENUM_in_enumDeclaration1028 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_enumDeclaration1049 = new BitSet(new long[]{0x0100000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_IMPLEMENTS_in_enumDeclaration1060 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_typeList_in_enumDeclaration1062 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_enumBody_in_enumDeclaration1083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_enumBody1108 = new BitSet(new long[]{0x0040000002000000L,0x0000000011000200L});
    public static final BitSet FOLLOW_enumConstants_in_enumBody1119 = new BitSet(new long[]{0x0000000002000000L,0x0000000011000000L});
    public static final BitSet FOLLOW_COMMA_in_enumBody1141 = new BitSet(new long[]{0x0000000000000000L,0x0000000011000000L});
    public static final BitSet FOLLOW_enumBodyDeclarations_in_enumBody1154 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_RBRACE_in_enumBody1176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumConstant_in_enumConstants1196 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_enumConstants1207 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_enumConstant_in_enumConstants1209 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_annotations_in_enumConstant1243 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_enumConstant1264 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000042L});
    public static final BitSet FOLLOW_arguments_in_enumConstant1275 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_classBody_in_enumConstant1297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_enumBodyDeclarations1338 = new BitSet(new long[]{0x1840502100A14012L,0x0019040C30700692L});
    public static final BitSet FOLLOW_classBodyDeclaration_in_enumBodyDeclarations1350 = new BitSet(new long[]{0x1840502100A14012L,0x0019040C30700692L});
    public static final BitSet FOLLOW_normalInterfaceDeclaration_in_interfaceDeclaration1381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeDeclaration_in_interfaceDeclaration1391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_normalInterfaceDeclaration1415 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_INTERFACE_in_normalInterfaceDeclaration1417 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_normalInterfaceDeclaration1419 = new BitSet(new long[]{0x0000010000000000L,0x0000000000000082L});
    public static final BitSet FOLLOW_typeParameters_in_normalInterfaceDeclaration1430 = new BitSet(new long[]{0x0000010000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_EXTENDS_in_normalInterfaceDeclaration1452 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_typeList_in_normalInterfaceDeclaration1454 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceBody_in_normalInterfaceDeclaration1475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typeList1495 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_typeList1506 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_typeList1508 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_LBRACE_in_classBody1539 = new BitSet(new long[]{0x1840502100A14010L,0x0019040C31700692L});
    public static final BitSet FOLLOW_classBodyDeclaration_in_classBody1552 = new BitSet(new long[]{0x1840502100A14010L,0x0019040C31700692L});
    public static final BitSet FOLLOW_RBRACE_in_classBody1574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_interfaceBody1596 = new BitSet(new long[]{0x1840502100A14010L,0x0019040C31700690L});
    public static final BitSet FOLLOW_interfaceBodyDeclaration_in_interfaceBody1608 = new BitSet(new long[]{0x1840502100A14010L,0x0019040C31700690L});
    public static final BitSet FOLLOW_RBRACE_in_interfaceBody1630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_classBodyDeclaration1650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STATIC_in_classBodyDeclaration1660 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_classBodyDeclaration1673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_classBodyDeclaration1703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_memberDecl_in_classBodyDeclaration1723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fieldDeclaration_in_memberDecl1744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_methodDeclaration_in_memberDecl1755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classDeclaration_in_memberDecl1766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceDeclaration_in_memberDecl1777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_methodDeclaration1825 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_typeParameters_in_methodDeclaration1836 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_methodDeclaration1857 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_formalParameters_in_methodDeclaration1868 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000002L});
    public static final BitSet FOLLOW_THROWS_in_methodDeclaration1879 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_qualifiedNameList_in_methodDeclaration1881 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_methodDeclaration1902 = new BitSet(new long[]{0x38C1D82350E1C310L,0x003FB7BC357A1EF2L});
    public static final BitSet FOLLOW_explicitConstructorInvocation_in_methodDeclaration1914 = new BitSet(new long[]{0x38C1D82350E1C310L,0x003FB7BC357A1E72L});
    public static final BitSet FOLLOW_blockStatement_in_methodDeclaration1936 = new BitSet(new long[]{0x38C1D82350E1C310L,0x003FB7BC357A1E72L});
    public static final BitSet FOLLOW_RBRACE_in_methodDeclaration1957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_methodDeclaration1988 = new BitSet(new long[]{0x0840400100214000L,0x0008000020000090L});
    public static final BitSet FOLLOW_typeParameters_in_methodDeclaration1999 = new BitSet(new long[]{0x0840400100214000L,0x0008000020000010L});
    public static final BitSet FOLLOW_type_in_methodDeclaration2021 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_VOID_in_methodDeclaration2035 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_methodDeclaration2055 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_formalParameters_in_methodDeclaration2066 = new BitSet(new long[]{0x0000000000000000L,0x0000400010000006L});
    public static final BitSet FOLLOW_LBRACKET_in_methodDeclaration2077 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_methodDeclaration2079 = new BitSet(new long[]{0x0000000000000000L,0x0000400010000006L});
    public static final BitSet FOLLOW_THROWS_in_methodDeclaration2101 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_qualifiedNameList_in_methodDeclaration2103 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000002L});
    public static final BitSet FOLLOW_block_in_methodDeclaration2158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_methodDeclaration2172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_fieldDeclaration2204 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_fieldDeclaration2215 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_variableDeclarator_in_fieldDeclaration2227 = new BitSet(new long[]{0x0000000002000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_COMMA_in_fieldDeclaration2239 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_variableDeclarator_in_fieldDeclaration2241 = new BitSet(new long[]{0x0000000002000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_fieldDeclaration2263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_variableDeclarator2288 = new BitSet(new long[]{0x0000004000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_variableDeclarator2301 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_variableDeclarator2303 = new BitSet(new long[]{0x0000004000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_EQ_in_variableDeclarator2327 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1872L});
    public static final BitSet FOLLOW_variableInitializer_in_variableDeclarator2329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceFieldDeclaration_in_interfaceBodyDeclaration2378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceMethodDeclaration_in_interfaceBodyDeclaration2388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceDeclaration_in_interfaceBodyDeclaration2398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classDeclaration_in_interfaceBodyDeclaration2408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_interfaceBodyDeclaration2418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_interfaceMethodDeclaration2438 = new BitSet(new long[]{0x0840400100214000L,0x0008000020000090L});
    public static final BitSet FOLLOW_typeParameters_in_interfaceMethodDeclaration2449 = new BitSet(new long[]{0x0840400100214000L,0x0008000020000010L});
    public static final BitSet FOLLOW_type_in_interfaceMethodDeclaration2471 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_VOID_in_interfaceMethodDeclaration2482 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_interfaceMethodDeclaration2502 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_formalParameters_in_interfaceMethodDeclaration2512 = new BitSet(new long[]{0x0000000000000000L,0x0000400010000004L});
    public static final BitSet FOLLOW_LBRACKET_in_interfaceMethodDeclaration2523 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_interfaceMethodDeclaration2525 = new BitSet(new long[]{0x0000000000000000L,0x0000400010000004L});
    public static final BitSet FOLLOW_THROWS_in_interfaceMethodDeclaration2547 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_qualifiedNameList_in_interfaceMethodDeclaration2549 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_interfaceMethodDeclaration2562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_interfaceFieldDeclaration2584 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_interfaceFieldDeclaration2586 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_variableDeclarator_in_interfaceFieldDeclaration2588 = new BitSet(new long[]{0x0000000002000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_COMMA_in_interfaceFieldDeclaration2599 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_variableDeclarator_in_interfaceFieldDeclaration2601 = new BitSet(new long[]{0x0000000002000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_interfaceFieldDeclaration2622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_type2643 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_type2654 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_type2656 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_primitiveType_in_type2677 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_type2688 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_type2690 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_classOrInterfaceType2722 = new BitSet(new long[]{0x0000000080000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_typeArguments_in_classOrInterfaceType2733 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_DOT_in_classOrInterfaceType2755 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_classOrInterfaceType2757 = new BitSet(new long[]{0x0000000080000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_typeArguments_in_classOrInterfaceType2772 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_LT_in_typeArguments2909 = new BitSet(new long[]{0x0840400100214000L,0x0000000020800010L});
    public static final BitSet FOLLOW_typeArgument_in_typeArguments2911 = new BitSet(new long[]{0x0008000002000000L});
    public static final BitSet FOLLOW_COMMA_in_typeArguments2922 = new BitSet(new long[]{0x0840400100214000L,0x0000000020800010L});
    public static final BitSet FOLLOW_typeArgument_in_typeArguments2924 = new BitSet(new long[]{0x0008000002000000L});
    public static final BitSet FOLLOW_GT_in_typeArguments2946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typeArgument2966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUES_in_typeArgument2976 = new BitSet(new long[]{0x0000010000000002L,0x0000010000000000L});
    public static final BitSet FOLLOW_set_in_typeArgument3000 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_typeArgument3044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedName_in_qualifiedNameList3075 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_qualifiedNameList3086 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_qualifiedName_in_qualifiedNameList3088 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_LPAREN_in_formalParameters3119 = new BitSet(new long[]{0x0840500100214000L,0x0000000028000210L});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameters3130 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_formalParameters3152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ellipsisParameterDecl_in_formalParameterDecls3172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normalParameterDecl_in_formalParameterDecls3182 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_formalParameterDecls3193 = new BitSet(new long[]{0x0840500100214000L,0x0000000020000210L});
    public static final BitSet FOLLOW_normalParameterDecl_in_formalParameterDecls3195 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_normalParameterDecl_in_formalParameterDecls3217 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_COMMA_in_formalParameterDecls3227 = new BitSet(new long[]{0x0840500100214000L,0x0000000020000210L});
    public static final BitSet FOLLOW_ellipsisParameterDecl_in_formalParameterDecls3249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableModifiers_in_normalParameterDecl3281 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_normalParameterDecl3283 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_normalParameterDecl3285 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_normalParameterDecl3306 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_normalParameterDecl3308 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_variableModifiers_in_ellipsisParameterDecl3355 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_ellipsisParameterDecl3365 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_ELLIPSIS_in_ellipsisParameterDecl3368 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_ellipsisParameterDecl3378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nonWildcardTypeArguments_in_explicitConstructorInvocation3410 = new BitSet(new long[]{0x0000000000000000L,0x0000110000000000L});
    public static final BitSet FOLLOW_set_in_explicitConstructorInvocation3436 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_arguments_in_explicitConstructorInvocation3468 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_explicitConstructorInvocation3470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_explicitConstructorInvocation3481 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_DOT_in_explicitConstructorInvocation3491 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000080L});
    public static final BitSet FOLLOW_nonWildcardTypeArguments_in_explicitConstructorInvocation3502 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_SUPER_in_explicitConstructorInvocation3523 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_arguments_in_explicitConstructorInvocation3533 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_explicitConstructorInvocation3535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_qualifiedName3555 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_DOT_in_qualifiedName3566 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_qualifiedName3568 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_annotation_in_annotations3600 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_MONKEYS_AT_in_annotation3633 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_qualifiedName_in_annotation3635 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_LPAREN_in_annotation3649 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0280A1A72L});
    public static final BitSet FOLLOW_elementValuePairs_in_annotation3676 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_elementValue_in_annotation3700 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_annotation3736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs3768 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_elementValuePairs3779 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs3781 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_elementValuePair3812 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_EQ_in_elementValuePair3814 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1A72L});
    public static final BitSet FOLLOW_elementValue_in_elementValuePair3816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalExpression_in_elementValue3836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_elementValue3846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elementValueArrayInitializer_in_elementValue3856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_elementValueArrayInitializer3876 = new BitSet(new long[]{0x2840C80302614200L,0x000A91B0210A1A72L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer3887 = new BitSet(new long[]{0x0000000002000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_COMMA_in_elementValueArrayInitializer3902 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1A72L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer3904 = new BitSet(new long[]{0x0000000002000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_COMMA_in_elementValueArrayInitializer3933 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_RBRACE_in_elementValueArrayInitializer3937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_annotationTypeDeclaration3960 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_MONKEYS_AT_in_annotationTypeDeclaration3962 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_INTERFACE_in_annotationTypeDeclaration3972 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_annotationTypeDeclaration3982 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeBody_in_annotationTypeDeclaration3992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_annotationTypeBody4013 = new BitSet(new long[]{0x1840502100A14010L,0x0011040C31700610L});
    public static final BitSet FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody4025 = new BitSet(new long[]{0x1840502100A14010L,0x0011040C31700610L});
    public static final BitSet FOLLOW_RBRACE_in_annotationTypeBody4047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationMethodDeclaration_in_annotationTypeElementDeclaration4069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceFieldDeclaration_in_annotationTypeElementDeclaration4079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normalClassDeclaration_in_annotationTypeElementDeclaration4089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normalInterfaceDeclaration_in_annotationTypeElementDeclaration4099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumDeclaration_in_annotationTypeElementDeclaration4109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeDeclaration_in_annotationTypeElementDeclaration4119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_annotationTypeElementDeclaration4129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_annotationMethodDeclaration4149 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_annotationMethodDeclaration4151 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_annotationMethodDeclaration4153 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_LPAREN_in_annotationMethodDeclaration4163 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_annotationMethodDeclaration4165 = new BitSet(new long[]{0x0000000020000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_DEFAULT_in_annotationMethodDeclaration4168 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1A72L});
    public static final BitSet FOLLOW_elementValue_in_annotationMethodDeclaration4170 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_annotationMethodDeclaration4199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_block4233 = new BitSet(new long[]{0x38C1D82350E1C310L,0x003FB7BC357A1E72L});
    public static final BitSet FOLLOW_blockStatement_in_block4244 = new BitSet(new long[]{0x38C1D82350E1C310L,0x003FB7BC357A1E72L});
    public static final BitSet FOLLOW_RBRACE_in_block4265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localVariableDeclarationStatement_in_blockStatement4297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceDeclaration_in_blockStatement4307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_blockStatement4317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localVariableDeclaration_in_localVariableDeclarationStatement4338 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_localVariableDeclarationStatement4348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableModifiers_in_localVariableDeclaration4368 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_localVariableDeclaration4370 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_variableDeclarator_in_localVariableDeclaration4382 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_localVariableDeclaration4393 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_variableDeclarator_in_localVariableDeclaration4395 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_block_in_statement4426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSERT_in_statement4450 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_statement4470 = new BitSet(new long[]{0x0000000001000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_COLON_in_statement4473 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_statement4475 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_statement4479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSERT_in_statement4489 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_statement4492 = new BitSet(new long[]{0x0000000001000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_COLON_in_statement4495 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_statement4497 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_statement4501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_statement4523 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_parExpression_in_statement4525 = new BitSet(new long[]{0x28C1C8035061C300L,0x002EB7B0340A1872L});
    public static final BitSet FOLLOW_statement_in_statement4527 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_ELSE_in_statement4530 = new BitSet(new long[]{0x28C1C8035061C300L,0x002EB7B0340A1872L});
    public static final BitSet FOLLOW_statement_in_statement4532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forstatement_in_statement4554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_in_statement4564 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_parExpression_in_statement4566 = new BitSet(new long[]{0x28C1C8035061C300L,0x002EB7B0340A1872L});
    public static final BitSet FOLLOW_statement_in_statement4568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DO_in_statement4578 = new BitSet(new long[]{0x28C1C8035061C300L,0x002EB7B0340A1872L});
    public static final BitSet FOLLOW_statement_in_statement4580 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_WHILE_in_statement4582 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_parExpression_in_statement4584 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_statement4586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_trystatement_in_statement4596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SWITCH_in_statement4606 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_parExpression_in_statement4608 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_statement4610 = new BitSet(new long[]{0x0000000020080000L,0x0000000001000000L});
    public static final BitSet FOLLOW_switchBlockStatementGroups_in_statement4612 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_RBRACE_in_statement4614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYNCHRONIZED_in_statement4624 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_parExpression_in_statement4626 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_statement4628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_in_statement4638 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0300A1870L});
    public static final BitSet FOLLOW_expression_in_statement4641 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_statement4646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROW_in_statement4656 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_statement4658 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_statement4660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BREAK_in_statement4670 = new BitSet(new long[]{0x0040000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_statement4685 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_statement4702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONTINUE_in_statement4712 = new BitSet(new long[]{0x0040000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_statement4727 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_statement4744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_statement4754 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_statement4757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_statement4772 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_COLON_in_statement4774 = new BitSet(new long[]{0x28C1C8035061C300L,0x002EB7B0340A1872L});
    public static final BitSet FOLLOW_statement_in_statement4776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_statement4786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_switchBlockStatementGroup_in_switchBlockStatementGroups4808 = new BitSet(new long[]{0x0000000020080002L});
    public static final BitSet FOLLOW_switchLabel_in_switchBlockStatementGroup4837 = new BitSet(new long[]{0x38C1D82350E1C312L,0x003FB7BC347A1E72L});
    public static final BitSet FOLLOW_blockStatement_in_switchBlockStatementGroup4848 = new BitSet(new long[]{0x38C1D82350E1C312L,0x003FB7BC347A1E72L});
    public static final BitSet FOLLOW_CASE_in_switchLabel4879 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_switchLabel4881 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_COLON_in_switchLabel4883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFAULT_in_switchLabel4893 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_COLON_in_switchLabel4895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRY_in_trystatement4916 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_trystatement4918 = new BitSet(new long[]{0x0000200000100000L});
    public static final BitSet FOLLOW_catches_in_trystatement4932 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_FINALLY_in_trystatement4934 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_trystatement4936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_catches_in_trystatement4950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FINALLY_in_trystatement4964 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_trystatement4966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_catchClause_in_catches4997 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_catchClause_in_catches5008 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_CATCH_in_catchClause5039 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_LPAREN_in_catchClause5041 = new BitSet(new long[]{0x0840500100214000L,0x0000000020000210L});
    public static final BitSet FOLLOW_formalParameter_in_catchClause5043 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_catchClause5053 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_catchClause5055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableModifiers_in_formalParameter5076 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_formalParameter5078 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_formalParameter5080 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_formalParameter5091 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_formalParameter5093 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_FOR_in_forstatement5152 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_LPAREN_in_forstatement5154 = new BitSet(new long[]{0x0840500100214000L,0x0000000020000210L});
    public static final BitSet FOLLOW_variableModifiers_in_forstatement5156 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_forstatement5158 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_forstatement5160 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_COLON_in_forstatement5162 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_forstatement5183 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_forstatement5185 = new BitSet(new long[]{0x28C1C8035061C300L,0x002EB7B0340A1872L});
    public static final BitSet FOLLOW_statement_in_forstatement5187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_forstatement5248 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_LPAREN_in_forstatement5250 = new BitSet(new long[]{0x2840D80300614200L,0x000A91B0300A1A70L});
    public static final BitSet FOLLOW_forInit_in_forstatement5270 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_forstatement5291 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0300A1870L});
    public static final BitSet FOLLOW_expression_in_forstatement5311 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_forstatement5332 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0280A1870L});
    public static final BitSet FOLLOW_expressionList_in_forstatement5352 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_forstatement5373 = new BitSet(new long[]{0x28C1C8035061C300L,0x002EB7B0340A1872L});
    public static final BitSet FOLLOW_statement_in_forstatement5375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localVariableDeclaration_in_forInit5405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionList_in_forInit5415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_parExpression5435 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_parExpression5437 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_parExpression5439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_expressionList5459 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_expressionList5470 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_expressionList5472 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_conditionalExpression_in_expression5504 = new BitSet(new long[]{0x0008004000042082L,0x0000004280050080L});
    public static final BitSet FOLLOW_assignmentOperator_in_expression5515 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_expression5517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQ_in_assignmentOperator5549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUSEQ_in_assignmentOperator5559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUBEQ_in_assignmentOperator5569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAREQ_in_assignmentOperator5579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SLASHEQ_in_assignmentOperator5589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AMPEQ_in_assignmentOperator5599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAREQ_in_assignmentOperator5609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CARETEQ_in_assignmentOperator5619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERCENTEQ_in_assignmentOperator5629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_assignmentOperator5640 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_LT_in_assignmentOperator5642 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_EQ_in_assignmentOperator5644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_assignmentOperator5655 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_GT_in_assignmentOperator5657 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_GT_in_assignmentOperator5659 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_EQ_in_assignmentOperator5661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_assignmentOperator5672 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_GT_in_assignmentOperator5674 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_EQ_in_assignmentOperator5676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalOrExpression_in_conditionalExpression5697 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_QUES_in_conditionalExpression5708 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_conditionalExpression5710 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_COLON_in_conditionalExpression5712 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_conditionalExpression_in_conditionalExpression5714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalAndExpression_in_conditionalOrExpression5745 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_BARBAR_in_conditionalOrExpression5756 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_conditionalAndExpression_in_conditionalOrExpression5758 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_inclusiveOrExpression_in_conditionalAndExpression5789 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_AMPAMP_in_conditionalAndExpression5800 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_inclusiveOrExpression_in_conditionalAndExpression5802 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression5833 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_BAR_in_inclusiveOrExpression5844 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression5846 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_andExpression_in_exclusiveOrExpression5877 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_CARET_in_exclusiveOrExpression5888 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_andExpression_in_exclusiveOrExpression5890 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_equalityExpression_in_andExpression5921 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_AMP_in_andExpression5932 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_equalityExpression_in_andExpression5934 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_instanceOfExpression_in_equalityExpression5965 = new BitSet(new long[]{0x0000008000000402L});
    public static final BitSet FOLLOW_set_in_equalityExpression5992 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_instanceOfExpression_in_equalityExpression6042 = new BitSet(new long[]{0x0000008000000402L});
    public static final BitSet FOLLOW_relationalExpression_in_instanceOfExpression6073 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_INSTANCEOF_in_instanceOfExpression6084 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_instanceOfExpression6086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpression6117 = new BitSet(new long[]{0x0008000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_relationalOp_in_relationalExpression6128 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpression6130 = new BitSet(new long[]{0x0008000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_LT_in_relationalOp6162 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_EQ_in_relationalOp6164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_relationalOp6175 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_EQ_in_relationalOp6177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_relationalOp6187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_relationalOp6197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_additiveExpression_in_shiftExpression6217 = new BitSet(new long[]{0x0008000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_shiftOp_in_shiftExpression6228 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_additiveExpression_in_shiftExpression6230 = new BitSet(new long[]{0x0008000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_LT_in_shiftOp6263 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_LT_in_shiftOp6265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_shiftOp6276 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_GT_in_shiftOp6278 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_GT_in_shiftOp6280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_shiftOp6291 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_GT_in_shiftOp6293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression6314 = new BitSet(new long[]{0x0000000000000002L,0x0000002000020000L});
    public static final BitSet FOLLOW_set_in_additiveExpression6341 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression6391 = new BitSet(new long[]{0x0000000000000002L,0x0000002000020000L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression6429 = new BitSet(new long[]{0x0000000000000002L,0x0000000140008000L});
    public static final BitSet FOLLOW_set_in_multiplicativeExpression6456 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression6524 = new BitSet(new long[]{0x0000000000000002L,0x0000000140008000L});
    public static final BitSet FOLLOW_PLUS_in_unaryExpression6557 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression6560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUB_in_unaryExpression6570 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression6572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUSPLUS_in_unaryExpression6582 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression6584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUBSUB_in_unaryExpression6594 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression6596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryExpressionNotPlusMinus_in_unaryExpression6606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TILDE_in_unaryExpressionNotPlusMinus6626 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus6628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BANG_in_unaryExpressionNotPlusMinus6638 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus6640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_castExpression_in_unaryExpressionNotPlusMinus6650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unaryExpressionNotPlusMinus6660 = new BitSet(new long[]{0x0000000080000002L,0x0000008000080004L});
    public static final BitSet FOLLOW_selector_in_unaryExpressionNotPlusMinus6671 = new BitSet(new long[]{0x0000000080000002L,0x0000008000080004L});
    public static final BitSet FOLLOW_LPAREN_in_castExpression6741 = new BitSet(new long[]{0x0800400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_primitiveType_in_castExpression6743 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_castExpression6745 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_unaryExpression_in_castExpression6747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_castExpression6757 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_castExpression6759 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_castExpression6761 = new BitSet(new long[]{0x2840C80300614200L,0x000A911020001870L});
    public static final BitSet FOLLOW_unaryExpressionNotPlusMinus_in_castExpression6763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parExpression_in_primary6785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THIS_in_primary6807 = new BitSet(new long[]{0x0000000080000002L,0x0000000000000044L});
    public static final BitSet FOLLOW_DOT_in_primary6818 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primary6820 = new BitSet(new long[]{0x0000000080000002L,0x0000000000000044L});
    public static final BitSet FOLLOW_identifierSuffix_in_primary6842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primary6863 = new BitSet(new long[]{0x0000000080000002L,0x0000000000000044L});
    public static final BitSet FOLLOW_DOT_in_primary6874 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primary6876 = new BitSet(new long[]{0x0000000080000002L,0x0000000000000044L});
    public static final BitSet FOLLOW_identifierSuffix_in_primary6898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUPER_in_primary6919 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_superSuffix_in_primary6929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_primary6939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_creator_in_primary6949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveType_in_primary6959 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_primary6970 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_primary6972 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_DOT_in_primary6993 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_CLASS_in_primary6995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VOID_in_primary7005 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_DOT_in_primary7007 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_CLASS_in_primary7009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arguments_in_superSuffix7035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_superSuffix7045 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_typeArguments_in_superSuffix7048 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_superSuffix7069 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_arguments_in_superSuffix7080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_identifierSuffix7113 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_identifierSuffix7115 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_DOT_in_identifierSuffix7136 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_CLASS_in_identifierSuffix7138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_identifierSuffix7149 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_identifierSuffix7151 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_identifierSuffix7153 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_arguments_in_identifierSuffix7174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_identifierSuffix7184 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_CLASS_in_identifierSuffix7186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_identifierSuffix7196 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_nonWildcardTypeArguments_in_identifierSuffix7198 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_identifierSuffix7200 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_arguments_in_identifierSuffix7202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_identifierSuffix7212 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_THIS_in_identifierSuffix7214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_identifierSuffix7224 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_SUPER_in_identifierSuffix7226 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_arguments_in_identifierSuffix7228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_innerCreator_in_identifierSuffix7238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_selector7260 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_selector7262 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_arguments_in_selector7273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_selector7294 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_THIS_in_selector7296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_selector7306 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_SUPER_in_selector7308 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_superSuffix_in_selector7318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_innerCreator_in_selector7328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_selector7338 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_selector7340 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_selector7342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_creator7362 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_nonWildcardTypeArguments_in_creator7364 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_creator7366 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_classCreatorRest_in_creator7368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_creator7378 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_creator7380 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_classCreatorRest_in_creator7382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayCreator_in_creator7392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_arrayCreator7412 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_createdName_in_arrayCreator7414 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_arrayCreator7424 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_arrayCreator7426 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_LBRACKET_in_arrayCreator7437 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_arrayCreator7439 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_arrayInitializer_in_arrayCreator7460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_arrayCreator7471 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_createdName_in_arrayCreator7473 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_arrayCreator7483 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_arrayCreator7485 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_arrayCreator7495 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_arrayCreator7509 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_arrayCreator7511 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_arrayCreator7525 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_arrayCreator7547 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_arrayCreator7549 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_arrayInitializer_in_variableInitializer7580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_variableInitializer7590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_arrayInitializer7610 = new BitSet(new long[]{0x2840C80302614200L,0x000A91B0210A1872L});
    public static final BitSet FOLLOW_variableInitializer_in_arrayInitializer7626 = new BitSet(new long[]{0x0000000002000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_COMMA_in_arrayInitializer7645 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1872L});
    public static final BitSet FOLLOW_variableInitializer_in_arrayInitializer7647 = new BitSet(new long[]{0x0000000002000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_COMMA_in_arrayInitializer7697 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_RBRACE_in_arrayInitializer7710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_createdName7744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveType_in_createdName7754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_innerCreator7775 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_NEW_in_innerCreator7777 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_nonWildcardTypeArguments_in_innerCreator7788 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_innerCreator7809 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_typeArguments_in_innerCreator7820 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_classCreatorRest_in_innerCreator7841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arguments_in_classCreatorRest7862 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_classBody_in_classCreatorRest7873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_nonWildcardTypeArguments7905 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_typeList_in_nonWildcardTypeArguments7907 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_GT_in_nonWildcardTypeArguments7917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_arguments7937 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0280A1870L});
    public static final BitSet FOLLOW_expressionList_in_arguments7940 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_arguments7953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_classHeader8077 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_CLASS_in_classHeader8079 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_classHeader8081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_enumHeader8101 = new BitSet(new long[]{0x0040002000000000L});
    public static final BitSet FOLLOW_set_in_enumHeader8103 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_enumHeader8109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_interfaceHeader8129 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_INTERFACE_in_interfaceHeader8131 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_interfaceHeader8133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_annotationHeader8153 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_MONKEYS_AT_in_annotationHeader8155 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_INTERFACE_in_annotationHeader8157 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_annotationHeader8159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_typeHeader8179 = new BitSet(new long[]{0x1000002000800000L,0x0000000000000200L});
    public static final BitSet FOLLOW_CLASS_in_typeHeader8182 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ENUM_in_typeHeader8184 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_MONKEYS_AT_in_typeHeader8187 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_INTERFACE_in_typeHeader8191 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_typeHeader8195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_methodHeader8215 = new BitSet(new long[]{0x0840400100214000L,0x0008000020000090L});
    public static final BitSet FOLLOW_typeParameters_in_methodHeader8217 = new BitSet(new long[]{0x0840400100214000L,0x0008000020000010L});
    public static final BitSet FOLLOW_type_in_methodHeader8221 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_VOID_in_methodHeader8223 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_methodHeader8227 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_LPAREN_in_methodHeader8229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_fieldHeader8249 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_fieldHeader8251 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_fieldHeader8253 = new BitSet(new long[]{0x0000004002000000L,0x0000000010000004L});
    public static final BitSet FOLLOW_LBRACKET_in_fieldHeader8256 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_fieldHeader8257 = new BitSet(new long[]{0x0000004002000000L,0x0000000010000004L});
    public static final BitSet FOLLOW_set_in_fieldHeader8261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableModifiers_in_localVariableHeader8287 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_localVariableHeader8289 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_localVariableHeader8291 = new BitSet(new long[]{0x0000004002000000L,0x0000000010000004L});
    public static final BitSet FOLLOW_LBRACKET_in_localVariableHeader8294 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_localVariableHeader8295 = new BitSet(new long[]{0x0000004002000000L,0x0000000010000004L});
    public static final BitSet FOLLOW_set_in_localVariableHeader8299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotations_in_synpred2_RJavaSymbolTable75 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_packageDeclaration_in_synpred2_RJavaSymbolTable104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classDeclaration_in_synpred12_RJavaSymbolTable465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normalClassDeclaration_in_synpred27_RJavaSymbolTable702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normalInterfaceDeclaration_in_synpred43_RJavaSymbolTable1381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fieldDeclaration_in_synpred52_RJavaSymbolTable1744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_methodDeclaration_in_synpred53_RJavaSymbolTable1755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classDeclaration_in_synpred54_RJavaSymbolTable1766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_explicitConstructorInvocation_in_synpred57_RJavaSymbolTable1914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_synpred59_RJavaSymbolTable1825 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_typeParameters_in_synpred59_RJavaSymbolTable1836 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred59_RJavaSymbolTable1857 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_formalParameters_in_synpred59_RJavaSymbolTable1868 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000002L});
    public static final BitSet FOLLOW_THROWS_in_synpred59_RJavaSymbolTable1879 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_qualifiedNameList_in_synpred59_RJavaSymbolTable1881 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_synpred59_RJavaSymbolTable1902 = new BitSet(new long[]{0x38C1D82350E1C310L,0x003FB7BC357A1EF2L});
    public static final BitSet FOLLOW_explicitConstructorInvocation_in_synpred59_RJavaSymbolTable1914 = new BitSet(new long[]{0x38C1D82350E1C310L,0x003FB7BC357A1E72L});
    public static final BitSet FOLLOW_blockStatement_in_synpred59_RJavaSymbolTable1936 = new BitSet(new long[]{0x38C1D82350E1C310L,0x003FB7BC357A1E72L});
    public static final BitSet FOLLOW_RBRACE_in_synpred59_RJavaSymbolTable1957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceFieldDeclaration_in_synpred68_RJavaSymbolTable2378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceMethodDeclaration_in_synpred69_RJavaSymbolTable2388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceDeclaration_in_synpred70_RJavaSymbolTable2398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classDeclaration_in_synpred71_RJavaSymbolTable2408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ellipsisParameterDecl_in_synpred96_RJavaSymbolTable3172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normalParameterDecl_in_synpred98_RJavaSymbolTable3182 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_synpred98_RJavaSymbolTable3193 = new BitSet(new long[]{0x0840500100214000L,0x0000000020000210L});
    public static final BitSet FOLLOW_normalParameterDecl_in_synpred98_RJavaSymbolTable3195 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_normalParameterDecl_in_synpred99_RJavaSymbolTable3217 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_COMMA_in_synpred99_RJavaSymbolTable3227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nonWildcardTypeArguments_in_synpred103_RJavaSymbolTable3410 = new BitSet(new long[]{0x0000000000000000L,0x0000110000000000L});
    public static final BitSet FOLLOW_set_in_synpred103_RJavaSymbolTable3436 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_arguments_in_synpred103_RJavaSymbolTable3468 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_synpred103_RJavaSymbolTable3470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationMethodDeclaration_in_synpred117_RJavaSymbolTable4069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceFieldDeclaration_in_synpred118_RJavaSymbolTable4079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normalClassDeclaration_in_synpred119_RJavaSymbolTable4089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normalInterfaceDeclaration_in_synpred120_RJavaSymbolTable4099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumDeclaration_in_synpred121_RJavaSymbolTable4109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeDeclaration_in_synpred122_RJavaSymbolTable4119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localVariableDeclarationStatement_in_synpred125_RJavaSymbolTable4297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceDeclaration_in_synpred126_RJavaSymbolTable4307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSERT_in_synpred130_RJavaSymbolTable4450 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_synpred130_RJavaSymbolTable4470 = new BitSet(new long[]{0x0000000001000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_COLON_in_synpred130_RJavaSymbolTable4473 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_synpred130_RJavaSymbolTable4475 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_synpred130_RJavaSymbolTable4479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSERT_in_synpred132_RJavaSymbolTable4489 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_synpred132_RJavaSymbolTable4492 = new BitSet(new long[]{0x0000000001000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_COLON_in_synpred132_RJavaSymbolTable4495 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_synpred132_RJavaSymbolTable4497 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_synpred132_RJavaSymbolTable4501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_in_synpred133_RJavaSymbolTable4530 = new BitSet(new long[]{0x28C1C8035061C300L,0x002EB7B0340A1872L});
    public static final BitSet FOLLOW_statement_in_synpred133_RJavaSymbolTable4532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred148_RJavaSymbolTable4754 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_synpred148_RJavaSymbolTable4757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred149_RJavaSymbolTable4772 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_COLON_in_synpred149_RJavaSymbolTable4774 = new BitSet(new long[]{0x28C1C8035061C300L,0x002EB7B0340A1872L});
    public static final BitSet FOLLOW_statement_in_synpred149_RJavaSymbolTable4776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_catches_in_synpred153_RJavaSymbolTable4932 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_FINALLY_in_synpred153_RJavaSymbolTable4934 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_synpred153_RJavaSymbolTable4936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_catches_in_synpred154_RJavaSymbolTable4950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_synpred157_RJavaSymbolTable5152 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_LPAREN_in_synpred157_RJavaSymbolTable5154 = new BitSet(new long[]{0x0840500100214000L,0x0000000020000210L});
    public static final BitSet FOLLOW_variableModifiers_in_synpred157_RJavaSymbolTable5156 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_synpred157_RJavaSymbolTable5158 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred157_RJavaSymbolTable5160 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_COLON_in_synpred157_RJavaSymbolTable5162 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_synpred157_RJavaSymbolTable5183 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_synpred157_RJavaSymbolTable5185 = new BitSet(new long[]{0x28C1C8035061C300L,0x002EB7B0340A1872L});
    public static final BitSet FOLLOW_statement_in_synpred157_RJavaSymbolTable5187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localVariableDeclaration_in_synpred161_RJavaSymbolTable5405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_castExpression_in_synpred202_RJavaSymbolTable6650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_synpred206_RJavaSymbolTable6741 = new BitSet(new long[]{0x0800400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_primitiveType_in_synpred206_RJavaSymbolTable6743 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_synpred206_RJavaSymbolTable6745 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_unaryExpression_in_synpred206_RJavaSymbolTable6747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_synpred208_RJavaSymbolTable6818 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred208_RJavaSymbolTable6820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierSuffix_in_synpred209_RJavaSymbolTable6842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_synpred211_RJavaSymbolTable6874 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred211_RJavaSymbolTable6876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierSuffix_in_synpred212_RJavaSymbolTable6898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred224_RJavaSymbolTable7149 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_synpred224_RJavaSymbolTable7151 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_synpred224_RJavaSymbolTable7153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_synpred236_RJavaSymbolTable7362 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_nonWildcardTypeArguments_in_synpred236_RJavaSymbolTable7364 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_synpred236_RJavaSymbolTable7366 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_classCreatorRest_in_synpred236_RJavaSymbolTable7368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_synpred237_RJavaSymbolTable7378 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_synpred237_RJavaSymbolTable7380 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_classCreatorRest_in_synpred237_RJavaSymbolTable7382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_synpred239_RJavaSymbolTable7412 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_createdName_in_synpred239_RJavaSymbolTable7414 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred239_RJavaSymbolTable7424 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_synpred239_RJavaSymbolTable7426 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred239_RJavaSymbolTable7437 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_synpred239_RJavaSymbolTable7439 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_arrayInitializer_in_synpred239_RJavaSymbolTable7460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred240_RJavaSymbolTable7509 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_synpred240_RJavaSymbolTable7511 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_synpred240_RJavaSymbolTable7525 = new BitSet(new long[]{0x0000000000000002L});

}