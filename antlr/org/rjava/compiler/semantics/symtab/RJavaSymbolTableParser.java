// $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g 2013-01-03 18:35:29

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
            	    importDeclaration();

            	    state._fsp--;
            	    if (state.failed) return ;

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
            	    pushFollow(FOLLOW_typeDeclaration_in_compilationUnit148);
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
            match(input,PACKAGE,FOLLOW_PACKAGE_in_packageDeclaration179); if (state.failed) return ;

            pushFollow(FOLLOW_qualifiedName_in_packageDeclaration181);
            qualifiedName();

            state._fsp--;
            if (state.failed) return ;

            match(input,SEMI,FOLLOW_SEMI_in_packageDeclaration191); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:43:1: importDeclaration : ( 'import' ( 'static' )? IDENTIFIER '.' '*' ';' | 'import' ( 'static' )? IDENTIFIER ( '.' IDENTIFIER )+ ( '.' '*' )? ';' );
    public final void importDeclaration() throws RecognitionException {
        int importDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return ; }

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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:44:9: 'import' ( 'static' )? IDENTIFIER '.' '*' ';'
                    {
                    match(input,IMPORT,FOLLOW_IMPORT_in_importDeclaration212); if (state.failed) return ;

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
                            match(input,STATIC,FOLLOW_STATIC_in_importDeclaration224); if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_importDeclaration245); if (state.failed) return ;

                    match(input,DOT,FOLLOW_DOT_in_importDeclaration247); if (state.failed) return ;

                    match(input,STAR,FOLLOW_STAR_in_importDeclaration249); if (state.failed) return ;

                    match(input,SEMI,FOLLOW_SEMI_in_importDeclaration259); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:49:9: 'import' ( 'static' )? IDENTIFIER ( '.' IDENTIFIER )+ ( '.' '*' )? ';'
                    {
                    match(input,IMPORT,FOLLOW_IMPORT_in_importDeclaration276); if (state.failed) return ;

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
                            match(input,STATIC,FOLLOW_STATIC_in_importDeclaration288); if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_importDeclaration309); if (state.failed) return ;

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
                    	    match(input,DOT,FOLLOW_DOT_in_importDeclaration320); if (state.failed) return ;

                    	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_importDeclaration322); if (state.failed) return ;

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
                            match(input,DOT,FOLLOW_DOT_in_importDeclaration344); if (state.failed) return ;

                            match(input,STAR,FOLLOW_STAR_in_importDeclaration346); if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,SEMI,FOLLOW_SEMI_in_importDeclaration367); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:60:1: qualifiedImportName : IDENTIFIER ( '.' IDENTIFIER )* ;
    public final void qualifiedImportName() throws RecognitionException {
        int qualifiedImportName_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:61:5: ( IDENTIFIER ( '.' IDENTIFIER )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:61:9: IDENTIFIER ( '.' IDENTIFIER )*
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_qualifiedImportName387); if (state.failed) return ;

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
            	    match(input,DOT,FOLLOW_DOT_in_qualifiedImportName398); if (state.failed) return ;

            	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_qualifiedImportName400); if (state.failed) return ;

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
                    pushFollow(FOLLOW_classOrInterfaceDeclaration_in_typeDeclaration431);
                    classOrInterfaceDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:68:9: ';'
                    {
                    match(input,SEMI,FOLLOW_SEMI_in_typeDeclaration441); if (state.failed) return ;

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
                    pushFollow(FOLLOW_classDeclaration_in_classOrInterfaceDeclaration462);
                    classDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:73:9: interfaceDeclaration
                    {
                    pushFollow(FOLLOW_interfaceDeclaration_in_classOrInterfaceDeclaration472);
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
            	    pushFollow(FOLLOW_annotation_in_modifiers507);
            	    annotation();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:80:9: 'public'
            	    {
            	    match(input,PUBLIC,FOLLOW_PUBLIC_in_modifiers517); if (state.failed) return ;

            	    }
            	    break;
            	case 3 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:81:9: 'protected'
            	    {
            	    match(input,PROTECTED,FOLLOW_PROTECTED_in_modifiers527); if (state.failed) return ;

            	    }
            	    break;
            	case 4 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:82:9: 'private'
            	    {
            	    match(input,PRIVATE,FOLLOW_PRIVATE_in_modifiers537); if (state.failed) return ;

            	    }
            	    break;
            	case 5 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:83:9: 'static'
            	    {
            	    match(input,STATIC,FOLLOW_STATIC_in_modifiers547); if (state.failed) return ;

            	    }
            	    break;
            	case 6 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:84:9: 'abstract'
            	    {
            	    match(input,ABSTRACT,FOLLOW_ABSTRACT_in_modifiers557); if (state.failed) return ;

            	    }
            	    break;
            	case 7 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:85:9: 'final'
            	    {
            	    match(input,FINAL,FOLLOW_FINAL_in_modifiers567); if (state.failed) return ;

            	    }
            	    break;
            	case 8 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:86:9: 'native'
            	    {
            	    match(input,NATIVE,FOLLOW_NATIVE_in_modifiers577); if (state.failed) return ;

            	    }
            	    break;
            	case 9 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:87:9: 'synchronized'
            	    {
            	    match(input,SYNCHRONIZED,FOLLOW_SYNCHRONIZED_in_modifiers587); if (state.failed) return ;

            	    }
            	    break;
            	case 10 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:88:9: 'transient'
            	    {
            	    match(input,TRANSIENT,FOLLOW_TRANSIENT_in_modifiers597); if (state.failed) return ;

            	    }
            	    break;
            	case 11 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:89:9: 'volatile'
            	    {
            	    match(input,VOLATILE,FOLLOW_VOLATILE_in_modifiers607); if (state.failed) return ;

            	    }
            	    break;
            	case 12 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:90:9: 'strictfp'
            	    {
            	    match(input,STRICTFP,FOLLOW_STRICTFP_in_modifiers617); if (state.failed) return ;

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
            	    match(input,FINAL,FOLLOW_FINAL_in_variableModifiers649); if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:97:13: annotation
            	    {
            	    pushFollow(FOLLOW_annotation_in_variableModifiers663);
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
                    pushFollow(FOLLOW_normalClassDeclaration_in_classDeclaration699);
                    normalClassDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:104:9: enumDeclaration
                    {
                    pushFollow(FOLLOW_enumDeclaration_in_classDeclaration709);
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
            pushFollow(FOLLOW_modifiers_in_normalClassDeclaration729);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            match(input,CLASS,FOLLOW_CLASS_in_normalClassDeclaration732); if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_normalClassDeclaration734); if (state.failed) return ;

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
                    pushFollow(FOLLOW_typeParameters_in_normalClassDeclaration745);
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
                    match(input,EXTENDS,FOLLOW_EXTENDS_in_normalClassDeclaration767); if (state.failed) return ;

                    pushFollow(FOLLOW_type_in_normalClassDeclaration769);
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
                    match(input,IMPLEMENTS,FOLLOW_IMPLEMENTS_in_normalClassDeclaration791); if (state.failed) return ;

                    pushFollow(FOLLOW_typeList_in_normalClassDeclaration793);
                    typeList();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            pushFollow(FOLLOW_classBody_in_normalClassDeclaration826);
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
            match(input,LT,FOLLOW_LT_in_typeParameters847); if (state.failed) return ;

            pushFollow(FOLLOW_typeParameter_in_typeParameters861);
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
            	    match(input,COMMA,FOLLOW_COMMA_in_typeParameters876); if (state.failed) return ;

            	    pushFollow(FOLLOW_typeParameter_in_typeParameters878);
            	    typeParameter();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            match(input,GT,FOLLOW_GT_in_typeParameters903); if (state.failed) return ;

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
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_typeParameter923); if (state.failed) return ;

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
                    match(input,EXTENDS,FOLLOW_EXTENDS_in_typeParameter934); if (state.failed) return ;

                    pushFollow(FOLLOW_typeBound_in_typeParameter936);
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
            pushFollow(FOLLOW_type_in_typeBound968);
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
            	    match(input,AMP,FOLLOW_AMP_in_typeBound979); if (state.failed) return ;

            	    pushFollow(FOLLOW_type_in_typeBound981);
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
            pushFollow(FOLLOW_modifiers_in_enumDeclaration1013);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:143:9: ( 'enum' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:143:10: 'enum'
            {
            match(input,ENUM,FOLLOW_ENUM_in_enumDeclaration1025); if (state.failed) return ;

            }


            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enumDeclaration1046); if (state.failed) return ;

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
                    match(input,IMPLEMENTS,FOLLOW_IMPLEMENTS_in_enumDeclaration1057); if (state.failed) return ;

                    pushFollow(FOLLOW_typeList_in_enumDeclaration1059);
                    typeList();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            pushFollow(FOLLOW_enumBody_in_enumDeclaration1080);
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
            match(input,LBRACE,FOLLOW_LBRACE_in_enumBody1105); if (state.failed) return ;

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
                    pushFollow(FOLLOW_enumConstants_in_enumBody1116);
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
                    match(input,COMMA,FOLLOW_COMMA_in_enumBody1138); if (state.failed) return ;

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
                    pushFollow(FOLLOW_enumBodyDeclarations_in_enumBody1151);
                    enumBodyDeclarations();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            match(input,RBRACE,FOLLOW_RBRACE_in_enumBody1173); if (state.failed) return ;

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
            pushFollow(FOLLOW_enumConstant_in_enumConstants1193);
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
            	    match(input,COMMA,FOLLOW_COMMA_in_enumConstants1204); if (state.failed) return ;

            	    pushFollow(FOLLOW_enumConstant_in_enumConstants1206);
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
                    pushFollow(FOLLOW_annotations_in_enumConstant1240);
                    annotations();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enumConstant1261); if (state.failed) return ;

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
                    pushFollow(FOLLOW_arguments_in_enumConstant1272);
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
                    pushFollow(FOLLOW_classBody_in_enumConstant1294);
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
            match(input,SEMI,FOLLOW_SEMI_in_enumBodyDeclarations1335); if (state.failed) return ;

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
            	    pushFollow(FOLLOW_classBodyDeclaration_in_enumBodyDeclarations1347);
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
                    pushFollow(FOLLOW_normalInterfaceDeclaration_in_interfaceDeclaration1378);
                    normalInterfaceDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:192:9: annotationTypeDeclaration
                    {
                    pushFollow(FOLLOW_annotationTypeDeclaration_in_interfaceDeclaration1388);
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
            pushFollow(FOLLOW_modifiers_in_normalInterfaceDeclaration1412);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            match(input,INTERFACE,FOLLOW_INTERFACE_in_normalInterfaceDeclaration1414); if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_normalInterfaceDeclaration1416); if (state.failed) return ;

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
                    pushFollow(FOLLOW_typeParameters_in_normalInterfaceDeclaration1427);
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
                    match(input,EXTENDS,FOLLOW_EXTENDS_in_normalInterfaceDeclaration1449); if (state.failed) return ;

                    pushFollow(FOLLOW_typeList_in_normalInterfaceDeclaration1451);
                    typeList();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            pushFollow(FOLLOW_interfaceBody_in_normalInterfaceDeclaration1472);
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
            pushFollow(FOLLOW_type_in_typeList1492);
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
            	    match(input,COMMA,FOLLOW_COMMA_in_typeList1503); if (state.failed) return ;

            	    pushFollow(FOLLOW_type_in_typeList1505);
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
            match(input,LBRACE,FOLLOW_LBRACE_in_classBody1536); if (state.failed) return ;

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
            	    pushFollow(FOLLOW_classBodyDeclaration_in_classBody1549);
            	    classBodyDeclaration();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            match(input,RBRACE,FOLLOW_RBRACE_in_classBody1571); if (state.failed) return ;

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
            match(input,LBRACE,FOLLOW_LBRACE_in_interfaceBody1593); if (state.failed) return ;

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
            	    pushFollow(FOLLOW_interfaceBodyDeclaration_in_interfaceBody1605);
            	    interfaceBodyDeclaration();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            match(input,RBRACE,FOLLOW_RBRACE_in_interfaceBody1627); if (state.failed) return ;

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
                    match(input,SEMI,FOLLOW_SEMI_in_classBodyDeclaration1647); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:226:9: 'static' block
                    {
                    match(input,STATIC,FOLLOW_STATIC_in_classBodyDeclaration1657); if (state.failed) return ;

                    if ( state.backtracking==0 ) {klass.newBlock(RBlock.STATIC_INITIALIZER);}

                    pushFollow(FOLLOW_block_in_classBodyDeclaration1670);
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

                    pushFollow(FOLLOW_block_in_classBodyDeclaration1700);
                    block();

                    state._fsp--;
                    if (state.failed) return ;

                    if ( state.backtracking==0 ) {klass.backToUpperBlock();}

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:232:9: memberDecl
                    {
                    pushFollow(FOLLOW_memberDecl_in_classBodyDeclaration1720);
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
                    pushFollow(FOLLOW_fieldDeclaration_in_memberDecl1741);
                    fieldDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:237:10: methodDeclaration
                    {
                    pushFollow(FOLLOW_methodDeclaration_in_memberDecl1752);
                    methodDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:238:10: classDeclaration
                    {
                    pushFollow(FOLLOW_classDeclaration_in_memberDecl1763);
                    classDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:239:10: interfaceDeclaration
                    {
                    pushFollow(FOLLOW_interfaceDeclaration_in_memberDecl1774);
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:246:10: modifiers ( typeParameters )? IDENTIFIER formalParameters ( 'throws' qualifiedNameList )? '{' ( explicitConstructorInvocation )? ( blockStatement )* '}'
                    {
                    pushFollow(FOLLOW_modifiers_in_methodDeclaration1812);
                    modifiers();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:247:9: ( typeParameters )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==LT) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:247:10: typeParameters
                            {
                            pushFollow(FOLLOW_typeParameters_in_methodDeclaration1823);
                            typeParameters();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_methodDeclaration1844); if (state.failed) return ;

                    pushFollow(FOLLOW_formalParameters_in_methodDeclaration1854);
                    formalParameters();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:251:9: ( 'throws' qualifiedNameList )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==THROWS) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:251:10: 'throws' qualifiedNameList
                            {
                            match(input,THROWS,FOLLOW_THROWS_in_methodDeclaration1865); if (state.failed) return ;

                            pushFollow(FOLLOW_qualifiedNameList_in_methodDeclaration1867);
                            qualifiedNameList();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,LBRACE,FOLLOW_LBRACE_in_methodDeclaration1888); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:254:9: ( explicitConstructorInvocation )?
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
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:254:10: explicitConstructorInvocation
                            {
                            pushFollow(FOLLOW_explicitConstructorInvocation_in_methodDeclaration1900);
                            explicitConstructorInvocation();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:256:9: ( blockStatement )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==ABSTRACT||(LA42_0 >= ASSERT && LA42_0 <= BANG)||(LA42_0 >= BOOLEAN && LA42_0 <= BYTE)||(LA42_0 >= CHAR && LA42_0 <= CLASS)||LA42_0==CONTINUE||LA42_0==DO||(LA42_0 >= DOUBLE && LA42_0 <= DOUBLELITERAL)||LA42_0==ENUM||(LA42_0 >= FALSE && LA42_0 <= FINAL)||(LA42_0 >= FLOAT && LA42_0 <= FOR)||(LA42_0 >= IDENTIFIER && LA42_0 <= IF)||(LA42_0 >= INT && LA42_0 <= INTLITERAL)||LA42_0==LBRACE||(LA42_0 >= LONG && LA42_0 <= LT)||(LA42_0 >= MONKEYS_AT && LA42_0 <= NULL)||LA42_0==PLUS||(LA42_0 >= PLUSPLUS && LA42_0 <= PUBLIC)||LA42_0==RETURN||(LA42_0 >= SEMI && LA42_0 <= SHORT)||(LA42_0 >= STATIC && LA42_0 <= SUB)||(LA42_0 >= SUBSUB && LA42_0 <= SYNCHRONIZED)||(LA42_0 >= THIS && LA42_0 <= THROW)||(LA42_0 >= TILDE && LA42_0 <= WHILE)) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:256:10: blockStatement
                    	    {
                    	    pushFollow(FOLLOW_blockStatement_in_methodDeclaration1922);
                    	    blockStatement();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);


                    match(input,RBRACE,FOLLOW_RBRACE_in_methodDeclaration1943); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:259:9: modifiers ( typeParameters )? ( type | 'void' ) IDENTIFIER formalParameters ( '[' ']' )* ( 'throws' qualifiedNameList )? ( block | ';' )
                    {
                    pushFollow(FOLLOW_modifiers_in_methodDeclaration1953);
                    modifiers();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:260:9: ( typeParameters )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==LT) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:260:10: typeParameters
                            {
                            pushFollow(FOLLOW_typeParameters_in_methodDeclaration1964);
                            typeParameters();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:262:9: ( type | 'void' )
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
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:262:10: type
                            {
                            pushFollow(FOLLOW_type_in_methodDeclaration1986);
                            type();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;
                        case 2 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:263:13: 'void'
                            {
                            match(input,VOID,FOLLOW_VOID_in_methodDeclaration2000); if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_methodDeclaration2020); if (state.failed) return ;

                    pushFollow(FOLLOW_formalParameters_in_methodDeclaration2030);
                    formalParameters();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:267:9: ( '[' ']' )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==LBRACKET) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:267:10: '[' ']'
                    	    {
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_methodDeclaration2041); if (state.failed) return ;

                    	    match(input,RBRACKET,FOLLOW_RBRACKET_in_methodDeclaration2043); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop45;
                        }
                    } while (true);


                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:269:9: ( 'throws' qualifiedNameList )?
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==THROWS) ) {
                        alt46=1;
                    }
                    switch (alt46) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:269:10: 'throws' qualifiedNameList
                            {
                            match(input,THROWS,FOLLOW_THROWS_in_methodDeclaration2065); if (state.failed) return ;

                            pushFollow(FOLLOW_qualifiedNameList_in_methodDeclaration2067);
                            qualifiedNameList();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:271:9: ( block | ';' )
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
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:272:13: block
                            {
                            pushFollow(FOLLOW_block_in_methodDeclaration2122);
                            block();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;
                        case 2 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:273:13: ';'
                            {
                            match(input,SEMI,FOLLOW_SEMI_in_methodDeclaration2136); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:278:1: fieldDeclaration : modifiers type variableDeclarator ( ',' variableDeclarator )* ';' ;
    public final void fieldDeclaration() throws RecognitionException {
        int fieldDeclaration_StartIndex = input.index();

        RJavaSymbolTableParser.type_return type1 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:279:5: ( modifiers type variableDeclarator ( ',' variableDeclarator )* ';' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:279:9: modifiers type variableDeclarator ( ',' variableDeclarator )* ';'
            {
            pushFollow(FOLLOW_modifiers_in_fieldDeclaration2168);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_type_in_fieldDeclaration2179);
            type1=type();

            state._fsp--;
            if (state.failed) return ;

            if ( state.backtracking==0 ) {type = (type1!=null?input.toString(type1.start,type1.stop):null);}

            pushFollow(FOLLOW_variableDeclarator_in_fieldDeclaration2191);
            variableDeclarator();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:282:9: ( ',' variableDeclarator )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==COMMA) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:282:10: ',' variableDeclarator
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_fieldDeclaration2203); if (state.failed) return ;

            	    pushFollow(FOLLOW_variableDeclarator_in_fieldDeclaration2205);
            	    variableDeclarator();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);


            match(input,SEMI,FOLLOW_SEMI_in_fieldDeclaration2227); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:287:1: variableDeclarator returns [RIdentifier id] : IDENTIFIER ( '[' ']' )* ( '=' variableInitializer )? ;
    public final RIdentifier variableDeclarator() throws RecognitionException {
        RIdentifier id = null;

        int variableDeclarator_StartIndex = input.index();

        Token IDENTIFIER2=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return id; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:288:5: ( IDENTIFIER ( '[' ']' )* ( '=' variableInitializer )? )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:288:9: IDENTIFIER ( '[' ']' )* ( '=' variableInitializer )?
            {
            IDENTIFIER2=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_variableDeclarator2252); if (state.failed) return id;

            if ( state.backtracking==0 ) {
                      id = new RIdentifier(); 
                      id.setId((IDENTIFIER2!=null?IDENTIFIER2.getText():null)); 
                      id.setType(RType.initWithClassName(type));
                      }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:293:9: ( '[' ']' )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==LBRACKET) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:293:10: '[' ']'
            	    {
            	    match(input,LBRACKET,FOLLOW_LBRACKET_in_variableDeclarator2265); if (state.failed) return id;

            	    match(input,RBRACKET,FOLLOW_RBRACKET_in_variableDeclarator2267); if (state.failed) return id;

            	    if ( state.backtracking==0 ) {id.setArray(true);}

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:295:9: ( '=' variableInitializer )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==EQ) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:295:10: '=' variableInitializer
                    {
                    match(input,EQ,FOLLOW_EQ_in_variableDeclarator2291); if (state.failed) return id;

                    pushFollow(FOLLOW_variableInitializer_in_variableDeclarator2293);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:303:1: interfaceBodyDeclaration : ( interfaceFieldDeclaration | interfaceMethodDeclaration | interfaceDeclaration | classDeclaration | ';' );
    public final void interfaceBodyDeclaration() throws RecognitionException {
        int interfaceBodyDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:304:5: ( interfaceFieldDeclaration | interfaceMethodDeclaration | interfaceDeclaration | classDeclaration | ';' )
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:305:9: interfaceFieldDeclaration
                    {
                    pushFollow(FOLLOW_interfaceFieldDeclaration_in_interfaceBodyDeclaration2342);
                    interfaceFieldDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:306:9: interfaceMethodDeclaration
                    {
                    pushFollow(FOLLOW_interfaceMethodDeclaration_in_interfaceBodyDeclaration2352);
                    interfaceMethodDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:307:9: interfaceDeclaration
                    {
                    pushFollow(FOLLOW_interfaceDeclaration_in_interfaceBodyDeclaration2362);
                    interfaceDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:308:9: classDeclaration
                    {
                    pushFollow(FOLLOW_classDeclaration_in_interfaceBodyDeclaration2372);
                    classDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:309:9: ';'
                    {
                    match(input,SEMI,FOLLOW_SEMI_in_interfaceBodyDeclaration2382); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:312:1: interfaceMethodDeclaration : modifiers ( typeParameters )? ( type | 'void' ) IDENTIFIER formalParameters ( '[' ']' )* ( 'throws' qualifiedNameList )? ';' ;
    public final void interfaceMethodDeclaration() throws RecognitionException {
        int interfaceMethodDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:313:5: ( modifiers ( typeParameters )? ( type | 'void' ) IDENTIFIER formalParameters ( '[' ']' )* ( 'throws' qualifiedNameList )? ';' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:313:9: modifiers ( typeParameters )? ( type | 'void' ) IDENTIFIER formalParameters ( '[' ']' )* ( 'throws' qualifiedNameList )? ';'
            {
            pushFollow(FOLLOW_modifiers_in_interfaceMethodDeclaration2402);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:314:9: ( typeParameters )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==LT) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:314:10: typeParameters
                    {
                    pushFollow(FOLLOW_typeParameters_in_interfaceMethodDeclaration2413);
                    typeParameters();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:316:9: ( type | 'void' )
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:316:10: type
                    {
                    pushFollow(FOLLOW_type_in_interfaceMethodDeclaration2435);
                    type();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:317:10: 'void'
                    {
                    match(input,VOID,FOLLOW_VOID_in_interfaceMethodDeclaration2446); if (state.failed) return ;

                    }
                    break;

            }


            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_interfaceMethodDeclaration2466); if (state.failed) return ;

            pushFollow(FOLLOW_formalParameters_in_interfaceMethodDeclaration2476);
            formalParameters();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:321:9: ( '[' ']' )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==LBRACKET) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:321:10: '[' ']'
            	    {
            	    match(input,LBRACKET,FOLLOW_LBRACKET_in_interfaceMethodDeclaration2487); if (state.failed) return ;

            	    match(input,RBRACKET,FOLLOW_RBRACKET_in_interfaceMethodDeclaration2489); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:323:9: ( 'throws' qualifiedNameList )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==THROWS) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:323:10: 'throws' qualifiedNameList
                    {
                    match(input,THROWS,FOLLOW_THROWS_in_interfaceMethodDeclaration2511); if (state.failed) return ;

                    pushFollow(FOLLOW_qualifiedNameList_in_interfaceMethodDeclaration2513);
                    qualifiedNameList();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            match(input,SEMI,FOLLOW_SEMI_in_interfaceMethodDeclaration2526); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:332:1: interfaceFieldDeclaration : modifiers type variableDeclarator ( ',' variableDeclarator )* ';' ;
    public final void interfaceFieldDeclaration() throws RecognitionException {
        int interfaceFieldDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:333:5: ( modifiers type variableDeclarator ( ',' variableDeclarator )* ';' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:333:9: modifiers type variableDeclarator ( ',' variableDeclarator )* ';'
            {
            pushFollow(FOLLOW_modifiers_in_interfaceFieldDeclaration2548);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_type_in_interfaceFieldDeclaration2550);
            type();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_variableDeclarator_in_interfaceFieldDeclaration2552);
            variableDeclarator();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:334:9: ( ',' variableDeclarator )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==COMMA) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:334:10: ',' variableDeclarator
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_interfaceFieldDeclaration2563); if (state.failed) return ;

            	    pushFollow(FOLLOW_variableDeclarator_in_interfaceFieldDeclaration2565);
            	    variableDeclarator();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);


            match(input,SEMI,FOLLOW_SEMI_in_interfaceFieldDeclaration2586); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:340:1: type : ( classOrInterfaceType ( '[' ']' )* | primitiveType ( '[' ']' )* );
    public final RJavaSymbolTableParser.type_return type() throws RecognitionException {
        RJavaSymbolTableParser.type_return retval = new RJavaSymbolTableParser.type_return();
        retval.start = input.LT(1);

        int type_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return retval; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:341:5: ( classOrInterfaceType ( '[' ']' )* | primitiveType ( '[' ']' )* )
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:341:9: classOrInterfaceType ( '[' ']' )*
                    {
                    pushFollow(FOLLOW_classOrInterfaceType_in_type2607);
                    classOrInterfaceType();

                    state._fsp--;
                    if (state.failed) return retval;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:342:9: ( '[' ']' )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==LBRACKET) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:342:10: '[' ']'
                    	    {
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_type2618); if (state.failed) return retval;

                    	    match(input,RBRACKET,FOLLOW_RBRACKET_in_type2620); if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    break loop58;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:344:9: primitiveType ( '[' ']' )*
                    {
                    pushFollow(FOLLOW_primitiveType_in_type2641);
                    primitiveType();

                    state._fsp--;
                    if (state.failed) return retval;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:345:9: ( '[' ']' )*
                    loop59:
                    do {
                        int alt59=2;
                        int LA59_0 = input.LA(1);

                        if ( (LA59_0==LBRACKET) ) {
                            alt59=1;
                        }


                        switch (alt59) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:345:10: '[' ']'
                    	    {
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_type2652); if (state.failed) return retval;

                    	    match(input,RBRACKET,FOLLOW_RBRACKET_in_type2654); if (state.failed) return retval;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:350:1: classOrInterfaceType : IDENTIFIER ( typeArguments )? ( '.' IDENTIFIER ( typeArguments )? )* ;
    public final void classOrInterfaceType() throws RecognitionException {
        int classOrInterfaceType_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:351:5: ( IDENTIFIER ( typeArguments )? ( '.' IDENTIFIER ( typeArguments )? )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:351:9: IDENTIFIER ( typeArguments )? ( '.' IDENTIFIER ( typeArguments )? )*
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_classOrInterfaceType2686); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:352:9: ( typeArguments )?
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:352:10: typeArguments
                    {
                    pushFollow(FOLLOW_typeArguments_in_classOrInterfaceType2697);
                    typeArguments();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:354:9: ( '.' IDENTIFIER ( typeArguments )? )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==DOT) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:354:10: '.' IDENTIFIER ( typeArguments )?
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_classOrInterfaceType2719); if (state.failed) return ;

            	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_classOrInterfaceType2721); if (state.failed) return ;

            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:355:13: ( typeArguments )?
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
            	            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:355:14: typeArguments
            	            {
            	            pushFollow(FOLLOW_typeArguments_in_classOrInterfaceType2736);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:360:1: primitiveType : ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' );
    public final void primitiveType() throws RecognitionException {
        int primitiveType_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:361:5: ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' )
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:371:1: typeArguments : '<' typeArgument ( ',' typeArgument )* '>' ;
    public final void typeArguments() throws RecognitionException {
        int typeArguments_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:372:5: ( '<' typeArgument ( ',' typeArgument )* '>' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:372:9: '<' typeArgument ( ',' typeArgument )* '>'
            {
            match(input,LT,FOLLOW_LT_in_typeArguments2873); if (state.failed) return ;

            pushFollow(FOLLOW_typeArgument_in_typeArguments2875);
            typeArgument();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:373:9: ( ',' typeArgument )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==COMMA) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:373:10: ',' typeArgument
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_typeArguments2886); if (state.failed) return ;

            	    pushFollow(FOLLOW_typeArgument_in_typeArguments2888);
            	    typeArgument();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);


            match(input,GT,FOLLOW_GT_in_typeArguments2910); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:378:1: typeArgument : ( type | '?' ( ( 'extends' | 'super' ) type )? );
    public final void typeArgument() throws RecognitionException {
        int typeArgument_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:379:5: ( type | '?' ( ( 'extends' | 'super' ) type )? )
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:379:9: type
                    {
                    pushFollow(FOLLOW_type_in_typeArgument2930);
                    type();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:380:9: '?' ( ( 'extends' | 'super' ) type )?
                    {
                    match(input,QUES,FOLLOW_QUES_in_typeArgument2940); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:381:9: ( ( 'extends' | 'super' ) type )?
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==EXTENDS||LA65_0==SUPER) ) {
                        alt65=1;
                    }
                    switch (alt65) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:382:13: ( 'extends' | 'super' ) type
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


                            pushFollow(FOLLOW_type_in_typeArgument3008);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:389:1: qualifiedNameList : qualifiedName ( ',' qualifiedName )* ;
    public final void qualifiedNameList() throws RecognitionException {
        int qualifiedNameList_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:390:5: ( qualifiedName ( ',' qualifiedName )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:390:9: qualifiedName ( ',' qualifiedName )*
            {
            pushFollow(FOLLOW_qualifiedName_in_qualifiedNameList3039);
            qualifiedName();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:391:9: ( ',' qualifiedName )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==COMMA) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:391:10: ',' qualifiedName
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_qualifiedNameList3050); if (state.failed) return ;

            	    pushFollow(FOLLOW_qualifiedName_in_qualifiedNameList3052);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:395:1: formalParameters : '(' ( formalParameterDecls )? ')' ;
    public final void formalParameters() throws RecognitionException {
        int formalParameters_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:396:5: ( '(' ( formalParameterDecls )? ')' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:396:9: '(' ( formalParameterDecls )? ')'
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_formalParameters3083); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:397:9: ( formalParameterDecls )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==BOOLEAN||LA68_0==BYTE||LA68_0==CHAR||LA68_0==DOUBLE||LA68_0==FINAL||LA68_0==FLOAT||LA68_0==IDENTIFIER||LA68_0==INT||LA68_0==LONG||LA68_0==MONKEYS_AT||LA68_0==SHORT) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:397:10: formalParameterDecls
                    {
                    pushFollow(FOLLOW_formalParameterDecls_in_formalParameters3094);
                    formalParameterDecls();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            match(input,RPAREN,FOLLOW_RPAREN_in_formalParameters3116); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:402:1: formalParameterDecls : ( ellipsisParameterDecl | normalParameterDecl ( ',' normalParameterDecl )* | ( normalParameterDecl ',' )+ ellipsisParameterDecl );
    public final void formalParameterDecls() throws RecognitionException {
        int formalParameterDecls_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:403:5: ( ellipsisParameterDecl | normalParameterDecl ( ',' normalParameterDecl )* | ( normalParameterDecl ',' )+ ellipsisParameterDecl )
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:403:9: ellipsisParameterDecl
                    {
                    pushFollow(FOLLOW_ellipsisParameterDecl_in_formalParameterDecls3136);
                    ellipsisParameterDecl();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:404:9: normalParameterDecl ( ',' normalParameterDecl )*
                    {
                    pushFollow(FOLLOW_normalParameterDecl_in_formalParameterDecls3146);
                    normalParameterDecl();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:405:9: ( ',' normalParameterDecl )*
                    loop69:
                    do {
                        int alt69=2;
                        int LA69_0 = input.LA(1);

                        if ( (LA69_0==COMMA) ) {
                            alt69=1;
                        }


                        switch (alt69) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:405:10: ',' normalParameterDecl
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_formalParameterDecls3157); if (state.failed) return ;

                    	    pushFollow(FOLLOW_normalParameterDecl_in_formalParameterDecls3159);
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:407:9: ( normalParameterDecl ',' )+ ellipsisParameterDecl
                    {
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:407:9: ( normalParameterDecl ',' )+
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
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:407:10: normalParameterDecl ','
                    	    {
                    	    pushFollow(FOLLOW_normalParameterDecl_in_formalParameterDecls3181);
                    	    normalParameterDecl();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    match(input,COMMA,FOLLOW_COMMA_in_formalParameterDecls3191); if (state.failed) return ;

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


                    pushFollow(FOLLOW_ellipsisParameterDecl_in_formalParameterDecls3213);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:413:1: normalParameterDecl : variableModifiers type IDENTIFIER ( '[' ']' )* ;
    public final void normalParameterDecl() throws RecognitionException {
        int normalParameterDecl_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:414:5: ( variableModifiers type IDENTIFIER ( '[' ']' )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:414:9: variableModifiers type IDENTIFIER ( '[' ']' )*
            {
            pushFollow(FOLLOW_variableModifiers_in_normalParameterDecl3233);
            variableModifiers();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_type_in_normalParameterDecl3235);
            type();

            state._fsp--;
            if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_normalParameterDecl3237); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:415:9: ( '[' ']' )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==LBRACKET) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:415:10: '[' ']'
            	    {
            	    match(input,LBRACKET,FOLLOW_LBRACKET_in_normalParameterDecl3248); if (state.failed) return ;

            	    match(input,RBRACKET,FOLLOW_RBRACKET_in_normalParameterDecl3250); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop72;
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:419:1: ellipsisParameterDecl : variableModifiers type '...' IDENTIFIER ;
    public final void ellipsisParameterDecl() throws RecognitionException {
        int ellipsisParameterDecl_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:420:5: ( variableModifiers type '...' IDENTIFIER )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:420:9: variableModifiers type '...' IDENTIFIER
            {
            pushFollow(FOLLOW_variableModifiers_in_ellipsisParameterDecl3281);
            variableModifiers();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_type_in_ellipsisParameterDecl3291);
            type();

            state._fsp--;
            if (state.failed) return ;

            match(input,ELLIPSIS,FOLLOW_ELLIPSIS_in_ellipsisParameterDecl3294); if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_ellipsisParameterDecl3304); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:426:1: explicitConstructorInvocation : ( ( nonWildcardTypeArguments )? ( 'this' | 'super' ) arguments ';' | primary '.' ( nonWildcardTypeArguments )? 'super' arguments ';' );
    public final void explicitConstructorInvocation() throws RecognitionException {
        int explicitConstructorInvocation_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:427:5: ( ( nonWildcardTypeArguments )? ( 'this' | 'super' ) arguments ';' | primary '.' ( nonWildcardTypeArguments )? 'super' arguments ';' )
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:427:9: ( nonWildcardTypeArguments )? ( 'this' | 'super' ) arguments ';'
                    {
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:427:9: ( nonWildcardTypeArguments )?
                    int alt73=2;
                    int LA73_0 = input.LA(1);

                    if ( (LA73_0==LT) ) {
                        alt73=1;
                    }
                    switch (alt73) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:427:10: nonWildcardTypeArguments
                            {
                            pushFollow(FOLLOW_nonWildcardTypeArguments_in_explicitConstructorInvocation3326);
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


                    pushFollow(FOLLOW_arguments_in_explicitConstructorInvocation3384);
                    arguments();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,SEMI,FOLLOW_SEMI_in_explicitConstructorInvocation3386); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:434:9: primary '.' ( nonWildcardTypeArguments )? 'super' arguments ';'
                    {
                    pushFollow(FOLLOW_primary_in_explicitConstructorInvocation3397);
                    primary();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,DOT,FOLLOW_DOT_in_explicitConstructorInvocation3407); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:436:9: ( nonWildcardTypeArguments )?
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0==LT) ) {
                        alt74=1;
                    }
                    switch (alt74) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:436:10: nonWildcardTypeArguments
                            {
                            pushFollow(FOLLOW_nonWildcardTypeArguments_in_explicitConstructorInvocation3418);
                            nonWildcardTypeArguments();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,SUPER,FOLLOW_SUPER_in_explicitConstructorInvocation3439); if (state.failed) return ;

                    pushFollow(FOLLOW_arguments_in_explicitConstructorInvocation3449);
                    arguments();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,SEMI,FOLLOW_SEMI_in_explicitConstructorInvocation3451); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:442:1: qualifiedName : IDENTIFIER ( '.' IDENTIFIER )* ;
    public final void qualifiedName() throws RecognitionException {
        int qualifiedName_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:443:5: ( IDENTIFIER ( '.' IDENTIFIER )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:443:9: IDENTIFIER ( '.' IDENTIFIER )*
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_qualifiedName3471); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:444:9: ( '.' IDENTIFIER )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==DOT) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:444:10: '.' IDENTIFIER
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_qualifiedName3482); if (state.failed) return ;

            	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_qualifiedName3484); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:448:1: annotations : ( annotation )+ ;
    public final void annotations() throws RecognitionException {
        int annotations_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:449:5: ( ( annotation )+ )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:449:9: ( annotation )+
            {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:449:9: ( annotation )+
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
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:449:10: annotation
            	    {
            	    pushFollow(FOLLOW_annotation_in_annotations3516);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:457:1: annotation : '@' qualifiedName ( '(' ( elementValuePairs | elementValue )? ')' )? ;
    public final void annotation() throws RecognitionException {
        int annotation_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:458:5: ( '@' qualifiedName ( '(' ( elementValuePairs | elementValue )? ')' )? )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:458:9: '@' qualifiedName ( '(' ( elementValuePairs | elementValue )? ')' )?
            {
            match(input,MONKEYS_AT,FOLLOW_MONKEYS_AT_in_annotation3549); if (state.failed) return ;

            pushFollow(FOLLOW_qualifiedName_in_annotation3551);
            qualifiedName();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:459:9: ( '(' ( elementValuePairs | elementValue )? ')' )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==LPAREN) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:459:13: '(' ( elementValuePairs | elementValue )? ')'
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_annotation3565); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:460:19: ( elementValuePairs | elementValue )?
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
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:460:23: elementValuePairs
                            {
                            pushFollow(FOLLOW_elementValuePairs_in_annotation3592);
                            elementValuePairs();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;
                        case 2 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:461:23: elementValue
                            {
                            pushFollow(FOLLOW_elementValue_in_annotation3616);
                            elementValue();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,RPAREN,FOLLOW_RPAREN_in_annotation3652); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:467:1: elementValuePairs : elementValuePair ( ',' elementValuePair )* ;
    public final void elementValuePairs() throws RecognitionException {
        int elementValuePairs_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:468:5: ( elementValuePair ( ',' elementValuePair )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:468:9: elementValuePair ( ',' elementValuePair )*
            {
            pushFollow(FOLLOW_elementValuePair_in_elementValuePairs3684);
            elementValuePair();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:469:9: ( ',' elementValuePair )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==COMMA) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:469:10: ',' elementValuePair
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_elementValuePairs3695); if (state.failed) return ;

            	    pushFollow(FOLLOW_elementValuePair_in_elementValuePairs3697);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:473:1: elementValuePair : IDENTIFIER '=' elementValue ;
    public final void elementValuePair() throws RecognitionException {
        int elementValuePair_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:474:5: ( IDENTIFIER '=' elementValue )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:474:9: IDENTIFIER '=' elementValue
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_elementValuePair3728); if (state.failed) return ;

            match(input,EQ,FOLLOW_EQ_in_elementValuePair3730); if (state.failed) return ;

            pushFollow(FOLLOW_elementValue_in_elementValuePair3732);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:477:1: elementValue : ( conditionalExpression | annotation | elementValueArrayInitializer );
    public final void elementValue() throws RecognitionException {
        int elementValue_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:478:5: ( conditionalExpression | annotation | elementValueArrayInitializer )
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:478:9: conditionalExpression
                    {
                    pushFollow(FOLLOW_conditionalExpression_in_elementValue3752);
                    conditionalExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:479:9: annotation
                    {
                    pushFollow(FOLLOW_annotation_in_elementValue3762);
                    annotation();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:480:9: elementValueArrayInitializer
                    {
                    pushFollow(FOLLOW_elementValueArrayInitializer_in_elementValue3772);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:483:1: elementValueArrayInitializer : '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' ;
    public final void elementValueArrayInitializer() throws RecognitionException {
        int elementValueArrayInitializer_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:484:5: ( '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:484:9: '{' ( elementValue ( ',' elementValue )* )? ( ',' )? '}'
            {
            match(input,LBRACE,FOLLOW_LBRACE_in_elementValueArrayInitializer3792); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:485:9: ( elementValue ( ',' elementValue )* )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==BANG||LA83_0==BOOLEAN||LA83_0==BYTE||(LA83_0 >= CHAR && LA83_0 <= CHARLITERAL)||(LA83_0 >= DOUBLE && LA83_0 <= DOUBLELITERAL)||LA83_0==FALSE||(LA83_0 >= FLOAT && LA83_0 <= FLOATLITERAL)||LA83_0==IDENTIFIER||LA83_0==INT||LA83_0==INTLITERAL||LA83_0==LBRACE||(LA83_0 >= LONG && LA83_0 <= LPAREN)||LA83_0==MONKEYS_AT||(LA83_0 >= NEW && LA83_0 <= NULL)||LA83_0==PLUS||LA83_0==PLUSPLUS||LA83_0==SHORT||(LA83_0 >= STRINGLITERAL && LA83_0 <= SUB)||(LA83_0 >= SUBSUB && LA83_0 <= SUPER)||LA83_0==THIS||LA83_0==TILDE||LA83_0==TRUE||LA83_0==VOID) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:485:10: elementValue ( ',' elementValue )*
                    {
                    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer3803);
                    elementValue();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:486:13: ( ',' elementValue )*
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
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:486:14: ',' elementValue
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_elementValueArrayInitializer3818); if (state.failed) return ;

                    	    pushFollow(FOLLOW_elementValue_in_elementValueArrayInitializer3820);
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


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:488:12: ( ',' )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==COMMA) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:488:13: ','
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_elementValueArrayInitializer3849); if (state.failed) return ;

                    }
                    break;

            }


            match(input,RBRACE,FOLLOW_RBRACE_in_elementValueArrayInitializer3853); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:495:1: annotationTypeDeclaration : modifiers '@' 'interface' IDENTIFIER annotationTypeBody ;
    public final void annotationTypeDeclaration() throws RecognitionException {
        int annotationTypeDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:496:5: ( modifiers '@' 'interface' IDENTIFIER annotationTypeBody )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:496:9: modifiers '@' 'interface' IDENTIFIER annotationTypeBody
            {
            pushFollow(FOLLOW_modifiers_in_annotationTypeDeclaration3876);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            match(input,MONKEYS_AT,FOLLOW_MONKEYS_AT_in_annotationTypeDeclaration3878); if (state.failed) return ;

            match(input,INTERFACE,FOLLOW_INTERFACE_in_annotationTypeDeclaration3888); if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_annotationTypeDeclaration3898); if (state.failed) return ;

            pushFollow(FOLLOW_annotationTypeBody_in_annotationTypeDeclaration3908);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:503:1: annotationTypeBody : '{' ( annotationTypeElementDeclaration )* '}' ;
    public final void annotationTypeBody() throws RecognitionException {
        int annotationTypeBody_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:504:5: ( '{' ( annotationTypeElementDeclaration )* '}' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:504:9: '{' ( annotationTypeElementDeclaration )* '}'
            {
            match(input,LBRACE,FOLLOW_LBRACE_in_annotationTypeBody3929); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:505:9: ( annotationTypeElementDeclaration )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==ABSTRACT||LA85_0==BOOLEAN||LA85_0==BYTE||LA85_0==CHAR||LA85_0==CLASS||LA85_0==DOUBLE||LA85_0==ENUM||LA85_0==FINAL||LA85_0==FLOAT||LA85_0==IDENTIFIER||(LA85_0 >= INT && LA85_0 <= INTERFACE)||LA85_0==LONG||LA85_0==LT||(LA85_0 >= MONKEYS_AT && LA85_0 <= NATIVE)||(LA85_0 >= PRIVATE && LA85_0 <= PUBLIC)||(LA85_0 >= SEMI && LA85_0 <= SHORT)||(LA85_0 >= STATIC && LA85_0 <= STRICTFP)||LA85_0==SYNCHRONIZED||LA85_0==TRANSIENT||(LA85_0 >= VOID && LA85_0 <= VOLATILE)) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:505:10: annotationTypeElementDeclaration
            	    {
            	    pushFollow(FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody3941);
            	    annotationTypeElementDeclaration();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop85;
                }
            } while (true);


            match(input,RBRACE,FOLLOW_RBRACE_in_annotationTypeBody3963); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:513:1: annotationTypeElementDeclaration : ( annotationMethodDeclaration | interfaceFieldDeclaration | normalClassDeclaration | normalInterfaceDeclaration | enumDeclaration | annotationTypeDeclaration | ';' );
    public final void annotationTypeElementDeclaration() throws RecognitionException {
        int annotationTypeElementDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:514:5: ( annotationMethodDeclaration | interfaceFieldDeclaration | normalClassDeclaration | normalInterfaceDeclaration | enumDeclaration | annotationTypeDeclaration | ';' )
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:514:9: annotationMethodDeclaration
                    {
                    pushFollow(FOLLOW_annotationMethodDeclaration_in_annotationTypeElementDeclaration3985);
                    annotationMethodDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:515:9: interfaceFieldDeclaration
                    {
                    pushFollow(FOLLOW_interfaceFieldDeclaration_in_annotationTypeElementDeclaration3995);
                    interfaceFieldDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:516:9: normalClassDeclaration
                    {
                    pushFollow(FOLLOW_normalClassDeclaration_in_annotationTypeElementDeclaration4005);
                    normalClassDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:517:9: normalInterfaceDeclaration
                    {
                    pushFollow(FOLLOW_normalInterfaceDeclaration_in_annotationTypeElementDeclaration4015);
                    normalInterfaceDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:518:9: enumDeclaration
                    {
                    pushFollow(FOLLOW_enumDeclaration_in_annotationTypeElementDeclaration4025);
                    enumDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:519:9: annotationTypeDeclaration
                    {
                    pushFollow(FOLLOW_annotationTypeDeclaration_in_annotationTypeElementDeclaration4035);
                    annotationTypeDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:520:9: ';'
                    {
                    match(input,SEMI,FOLLOW_SEMI_in_annotationTypeElementDeclaration4045); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:523:1: annotationMethodDeclaration : modifiers type IDENTIFIER '(' ')' ( 'default' elementValue )? ';' ;
    public final void annotationMethodDeclaration() throws RecognitionException {
        int annotationMethodDeclaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:524:5: ( modifiers type IDENTIFIER '(' ')' ( 'default' elementValue )? ';' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:524:9: modifiers type IDENTIFIER '(' ')' ( 'default' elementValue )? ';'
            {
            pushFollow(FOLLOW_modifiers_in_annotationMethodDeclaration4065);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_type_in_annotationMethodDeclaration4067);
            type();

            state._fsp--;
            if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_annotationMethodDeclaration4069); if (state.failed) return ;

            match(input,LPAREN,FOLLOW_LPAREN_in_annotationMethodDeclaration4079); if (state.failed) return ;

            match(input,RPAREN,FOLLOW_RPAREN_in_annotationMethodDeclaration4081); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:525:17: ( 'default' elementValue )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==DEFAULT) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:525:18: 'default' elementValue
                    {
                    match(input,DEFAULT,FOLLOW_DEFAULT_in_annotationMethodDeclaration4084); if (state.failed) return ;

                    pushFollow(FOLLOW_elementValue_in_annotationMethodDeclaration4086);
                    elementValue();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            match(input,SEMI,FOLLOW_SEMI_in_annotationMethodDeclaration4115); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:530:1: block : '{' ( blockStatement )* '}' ;
    public final void block() throws RecognitionException {
        int block_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:531:5: ( '{' ( blockStatement )* '}' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:531:9: '{' ( blockStatement )* '}'
            {
            match(input,LBRACE,FOLLOW_LBRACE_in_block4139); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:532:9: ( blockStatement )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==ABSTRACT||(LA88_0 >= ASSERT && LA88_0 <= BANG)||(LA88_0 >= BOOLEAN && LA88_0 <= BYTE)||(LA88_0 >= CHAR && LA88_0 <= CLASS)||LA88_0==CONTINUE||LA88_0==DO||(LA88_0 >= DOUBLE && LA88_0 <= DOUBLELITERAL)||LA88_0==ENUM||(LA88_0 >= FALSE && LA88_0 <= FINAL)||(LA88_0 >= FLOAT && LA88_0 <= FOR)||(LA88_0 >= IDENTIFIER && LA88_0 <= IF)||(LA88_0 >= INT && LA88_0 <= INTLITERAL)||LA88_0==LBRACE||(LA88_0 >= LONG && LA88_0 <= LT)||(LA88_0 >= MONKEYS_AT && LA88_0 <= NULL)||LA88_0==PLUS||(LA88_0 >= PLUSPLUS && LA88_0 <= PUBLIC)||LA88_0==RETURN||(LA88_0 >= SEMI && LA88_0 <= SHORT)||(LA88_0 >= STATIC && LA88_0 <= SUB)||(LA88_0 >= SUBSUB && LA88_0 <= SYNCHRONIZED)||(LA88_0 >= THIS && LA88_0 <= THROW)||(LA88_0 >= TILDE && LA88_0 <= WHILE)) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:532:10: blockStatement
            	    {
            	    pushFollow(FOLLOW_blockStatement_in_block4150);
            	    blockStatement();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop88;
                }
            } while (true);


            match(input,RBRACE,FOLLOW_RBRACE_in_block4171); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:561:1: blockStatement : ( localVariableDeclarationStatement | classOrInterfaceDeclaration | statement );
    public final void blockStatement() throws RecognitionException {
        int blockStatement_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:562:5: ( localVariableDeclarationStatement | classOrInterfaceDeclaration | statement )
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:562:9: localVariableDeclarationStatement
                    {
                    pushFollow(FOLLOW_localVariableDeclarationStatement_in_blockStatement4193);
                    localVariableDeclarationStatement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:563:9: classOrInterfaceDeclaration
                    {
                    pushFollow(FOLLOW_classOrInterfaceDeclaration_in_blockStatement4203);
                    classOrInterfaceDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:564:9: statement
                    {
                    pushFollow(FOLLOW_statement_in_blockStatement4213);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:568:1: localVariableDeclarationStatement : localVariableDeclaration ';' ;
    public final void localVariableDeclarationStatement() throws RecognitionException {
        int localVariableDeclarationStatement_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:569:5: ( localVariableDeclaration ';' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:569:9: localVariableDeclaration ';'
            {
            pushFollow(FOLLOW_localVariableDeclaration_in_localVariableDeclarationStatement4234);
            localVariableDeclaration();

            state._fsp--;
            if (state.failed) return ;

            match(input,SEMI,FOLLOW_SEMI_in_localVariableDeclarationStatement4244); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:573:1: localVariableDeclaration : variableModifiers type variableDeclarator ( ',' variableDeclarator )* ;
    public final void localVariableDeclaration() throws RecognitionException {
        int localVariableDeclaration_StartIndex = input.index();

        RJavaSymbolTableParser.type_return type3 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:574:5: ( variableModifiers type variableDeclarator ( ',' variableDeclarator )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:574:9: variableModifiers type variableDeclarator ( ',' variableDeclarator )*
            {
            pushFollow(FOLLOW_variableModifiers_in_localVariableDeclaration4264);
            variableModifiers();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_type_in_localVariableDeclaration4266);
            type3=type();

            state._fsp--;
            if (state.failed) return ;

            if ( state.backtracking==0 ) {type = (type3!=null?input.toString(type3.start,type3.stop):null);}

            pushFollow(FOLLOW_variableDeclarator_in_localVariableDeclaration4278);
            variableDeclarator();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:576:9: ( ',' variableDeclarator )*
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==COMMA) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:576:10: ',' variableDeclarator
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_localVariableDeclaration4289); if (state.failed) return ;

            	    pushFollow(FOLLOW_variableDeclarator_in_localVariableDeclaration4291);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:580:1: statement : ( block | ( 'assert' ) expression ( ':' expression )? ';' | 'assert' expression ( ':' expression )? ';' | 'if' parExpression statement ( 'else' statement )? | forstatement | 'while' parExpression statement | 'do' statement 'while' parExpression ';' | trystatement | 'switch' parExpression '{' switchBlockStatementGroups '}' | 'synchronized' parExpression block | 'return' ( expression )? ';' | 'throw' expression ';' | 'break' ( IDENTIFIER )? ';' | 'continue' ( IDENTIFIER )? ';' | expression ';' | IDENTIFIER ':' statement | ';' );
    public final void statement() throws RecognitionException {
        int statement_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:581:5: ( block | ( 'assert' ) expression ( ':' expression )? ';' | 'assert' expression ( ':' expression )? ';' | 'if' parExpression statement ( 'else' statement )? | forstatement | 'while' parExpression statement | 'do' statement 'while' parExpression ';' | trystatement | 'switch' parExpression '{' switchBlockStatementGroups '}' | 'synchronized' parExpression block | 'return' ( expression )? ';' | 'throw' expression ';' | 'break' ( IDENTIFIER )? ';' | 'continue' ( IDENTIFIER )? ';' | expression ';' | IDENTIFIER ':' statement | ';' )
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:581:9: block
                    {
                    pushFollow(FOLLOW_block_in_statement4322);
                    block();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:583:9: ( 'assert' ) expression ( ':' expression )? ';'
                    {
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:583:9: ( 'assert' )
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:583:10: 'assert'
                    {
                    match(input,ASSERT,FOLLOW_ASSERT_in_statement4346); if (state.failed) return ;

                    }


                    pushFollow(FOLLOW_expression_in_statement4366);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:585:20: ( ':' expression )?
                    int alt91=2;
                    int LA91_0 = input.LA(1);

                    if ( (LA91_0==COLON) ) {
                        alt91=1;
                    }
                    switch (alt91) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:585:21: ':' expression
                            {
                            match(input,COLON,FOLLOW_COLON_in_statement4369); if (state.failed) return ;

                            pushFollow(FOLLOW_expression_in_statement4371);
                            expression();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,SEMI,FOLLOW_SEMI_in_statement4375); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:586:9: 'assert' expression ( ':' expression )? ';'
                    {
                    match(input,ASSERT,FOLLOW_ASSERT_in_statement4385); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_statement4388);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:586:30: ( ':' expression )?
                    int alt92=2;
                    int LA92_0 = input.LA(1);

                    if ( (LA92_0==COLON) ) {
                        alt92=1;
                    }
                    switch (alt92) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:586:31: ':' expression
                            {
                            match(input,COLON,FOLLOW_COLON_in_statement4391); if (state.failed) return ;

                            pushFollow(FOLLOW_expression_in_statement4393);
                            expression();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,SEMI,FOLLOW_SEMI_in_statement4397); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:587:9: 'if' parExpression statement ( 'else' statement )?
                    {
                    match(input,IF,FOLLOW_IF_in_statement4419); if (state.failed) return ;

                    pushFollow(FOLLOW_parExpression_in_statement4421);
                    parExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    pushFollow(FOLLOW_statement_in_statement4423);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:587:38: ( 'else' statement )?
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
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:587:39: 'else' statement
                            {
                            match(input,ELSE,FOLLOW_ELSE_in_statement4426); if (state.failed) return ;

                            pushFollow(FOLLOW_statement_in_statement4428);
                            statement();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 5 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:588:9: forstatement
                    {
                    pushFollow(FOLLOW_forstatement_in_statement4450);
                    forstatement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:589:9: 'while' parExpression statement
                    {
                    match(input,WHILE,FOLLOW_WHILE_in_statement4460); if (state.failed) return ;

                    pushFollow(FOLLOW_parExpression_in_statement4462);
                    parExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    pushFollow(FOLLOW_statement_in_statement4464);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:590:9: 'do' statement 'while' parExpression ';'
                    {
                    match(input,DO,FOLLOW_DO_in_statement4474); if (state.failed) return ;

                    pushFollow(FOLLOW_statement_in_statement4476);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,WHILE,FOLLOW_WHILE_in_statement4478); if (state.failed) return ;

                    pushFollow(FOLLOW_parExpression_in_statement4480);
                    parExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,SEMI,FOLLOW_SEMI_in_statement4482); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:591:9: trystatement
                    {
                    pushFollow(FOLLOW_trystatement_in_statement4492);
                    trystatement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 9 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:592:9: 'switch' parExpression '{' switchBlockStatementGroups '}'
                    {
                    match(input,SWITCH,FOLLOW_SWITCH_in_statement4502); if (state.failed) return ;

                    pushFollow(FOLLOW_parExpression_in_statement4504);
                    parExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,LBRACE,FOLLOW_LBRACE_in_statement4506); if (state.failed) return ;

                    pushFollow(FOLLOW_switchBlockStatementGroups_in_statement4508);
                    switchBlockStatementGroups();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,RBRACE,FOLLOW_RBRACE_in_statement4510); if (state.failed) return ;

                    }
                    break;
                case 10 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:593:9: 'synchronized' parExpression block
                    {
                    match(input,SYNCHRONIZED,FOLLOW_SYNCHRONIZED_in_statement4520); if (state.failed) return ;

                    pushFollow(FOLLOW_parExpression_in_statement4522);
                    parExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    pushFollow(FOLLOW_block_in_statement4524);
                    block();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 11 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:594:9: 'return' ( expression )? ';'
                    {
                    match(input,RETURN,FOLLOW_RETURN_in_statement4534); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:594:18: ( expression )?
                    int alt94=2;
                    int LA94_0 = input.LA(1);

                    if ( (LA94_0==BANG||LA94_0==BOOLEAN||LA94_0==BYTE||(LA94_0 >= CHAR && LA94_0 <= CHARLITERAL)||(LA94_0 >= DOUBLE && LA94_0 <= DOUBLELITERAL)||LA94_0==FALSE||(LA94_0 >= FLOAT && LA94_0 <= FLOATLITERAL)||LA94_0==IDENTIFIER||LA94_0==INT||LA94_0==INTLITERAL||(LA94_0 >= LONG && LA94_0 <= LPAREN)||(LA94_0 >= NEW && LA94_0 <= NULL)||LA94_0==PLUS||LA94_0==PLUSPLUS||LA94_0==SHORT||(LA94_0 >= STRINGLITERAL && LA94_0 <= SUB)||(LA94_0 >= SUBSUB && LA94_0 <= SUPER)||LA94_0==THIS||LA94_0==TILDE||LA94_0==TRUE||LA94_0==VOID) ) {
                        alt94=1;
                    }
                    switch (alt94) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:594:19: expression
                            {
                            pushFollow(FOLLOW_expression_in_statement4537);
                            expression();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,SEMI,FOLLOW_SEMI_in_statement4542); if (state.failed) return ;

                    }
                    break;
                case 12 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:595:9: 'throw' expression ';'
                    {
                    match(input,THROW,FOLLOW_THROW_in_statement4552); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_statement4554);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,SEMI,FOLLOW_SEMI_in_statement4556); if (state.failed) return ;

                    }
                    break;
                case 13 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:596:9: 'break' ( IDENTIFIER )? ';'
                    {
                    match(input,BREAK,FOLLOW_BREAK_in_statement4566); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:597:13: ( IDENTIFIER )?
                    int alt95=2;
                    int LA95_0 = input.LA(1);

                    if ( (LA95_0==IDENTIFIER) ) {
                        alt95=1;
                    }
                    switch (alt95) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:597:14: IDENTIFIER
                            {
                            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_statement4581); if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,SEMI,FOLLOW_SEMI_in_statement4598); if (state.failed) return ;

                    }
                    break;
                case 14 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:599:9: 'continue' ( IDENTIFIER )? ';'
                    {
                    match(input,CONTINUE,FOLLOW_CONTINUE_in_statement4608); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:600:13: ( IDENTIFIER )?
                    int alt96=2;
                    int LA96_0 = input.LA(1);

                    if ( (LA96_0==IDENTIFIER) ) {
                        alt96=1;
                    }
                    switch (alt96) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:600:14: IDENTIFIER
                            {
                            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_statement4623); if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,SEMI,FOLLOW_SEMI_in_statement4640); if (state.failed) return ;

                    }
                    break;
                case 15 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:602:9: expression ';'
                    {
                    pushFollow(FOLLOW_expression_in_statement4650);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,SEMI,FOLLOW_SEMI_in_statement4653); if (state.failed) return ;

                    }
                    break;
                case 16 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:603:9: IDENTIFIER ':' statement
                    {
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_statement4668); if (state.failed) return ;

                    match(input,COLON,FOLLOW_COLON_in_statement4670); if (state.failed) return ;

                    pushFollow(FOLLOW_statement_in_statement4672);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 17 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:604:9: ';'
                    {
                    match(input,SEMI,FOLLOW_SEMI_in_statement4682); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:608:1: switchBlockStatementGroups : ( switchBlockStatementGroup )* ;
    public final void switchBlockStatementGroups() throws RecognitionException {
        int switchBlockStatementGroups_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:609:5: ( ( switchBlockStatementGroup )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:609:9: ( switchBlockStatementGroup )*
            {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:609:9: ( switchBlockStatementGroup )*
            loop98:
            do {
                int alt98=2;
                int LA98_0 = input.LA(1);

                if ( (LA98_0==CASE||LA98_0==DEFAULT) ) {
                    alt98=1;
                }


                switch (alt98) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:609:10: switchBlockStatementGroup
            	    {
            	    pushFollow(FOLLOW_switchBlockStatementGroup_in_switchBlockStatementGroups4704);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:612:1: switchBlockStatementGroup : switchLabel ( blockStatement )* ;
    public final void switchBlockStatementGroup() throws RecognitionException {
        int switchBlockStatementGroup_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:613:5: ( switchLabel ( blockStatement )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:614:9: switchLabel ( blockStatement )*
            {
            pushFollow(FOLLOW_switchLabel_in_switchBlockStatementGroup4733);
            switchLabel();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:615:9: ( blockStatement )*
            loop99:
            do {
                int alt99=2;
                int LA99_0 = input.LA(1);

                if ( (LA99_0==ABSTRACT||(LA99_0 >= ASSERT && LA99_0 <= BANG)||(LA99_0 >= BOOLEAN && LA99_0 <= BYTE)||(LA99_0 >= CHAR && LA99_0 <= CLASS)||LA99_0==CONTINUE||LA99_0==DO||(LA99_0 >= DOUBLE && LA99_0 <= DOUBLELITERAL)||LA99_0==ENUM||(LA99_0 >= FALSE && LA99_0 <= FINAL)||(LA99_0 >= FLOAT && LA99_0 <= FOR)||(LA99_0 >= IDENTIFIER && LA99_0 <= IF)||(LA99_0 >= INT && LA99_0 <= INTLITERAL)||LA99_0==LBRACE||(LA99_0 >= LONG && LA99_0 <= LT)||(LA99_0 >= MONKEYS_AT && LA99_0 <= NULL)||LA99_0==PLUS||(LA99_0 >= PLUSPLUS && LA99_0 <= PUBLIC)||LA99_0==RETURN||(LA99_0 >= SEMI && LA99_0 <= SHORT)||(LA99_0 >= STATIC && LA99_0 <= SUB)||(LA99_0 >= SUBSUB && LA99_0 <= SYNCHRONIZED)||(LA99_0 >= THIS && LA99_0 <= THROW)||(LA99_0 >= TILDE && LA99_0 <= WHILE)) ) {
                    alt99=1;
                }


                switch (alt99) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:615:10: blockStatement
            	    {
            	    pushFollow(FOLLOW_blockStatement_in_switchBlockStatementGroup4744);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:619:1: switchLabel : ( 'case' expression ':' | 'default' ':' );
    public final void switchLabel() throws RecognitionException {
        int switchLabel_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:620:5: ( 'case' expression ':' | 'default' ':' )
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:620:9: 'case' expression ':'
                    {
                    match(input,CASE,FOLLOW_CASE_in_switchLabel4775); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_switchLabel4777);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,COLON,FOLLOW_COLON_in_switchLabel4779); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:621:9: 'default' ':'
                    {
                    match(input,DEFAULT,FOLLOW_DEFAULT_in_switchLabel4789); if (state.failed) return ;

                    match(input,COLON,FOLLOW_COLON_in_switchLabel4791); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:625:1: trystatement : 'try' block ( catches 'finally' block | catches | 'finally' block ) ;
    public final void trystatement() throws RecognitionException {
        int trystatement_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:626:5: ( 'try' block ( catches 'finally' block | catches | 'finally' block ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:626:9: 'try' block ( catches 'finally' block | catches | 'finally' block )
            {
            match(input,TRY,FOLLOW_TRY_in_trystatement4812); if (state.failed) return ;

            pushFollow(FOLLOW_block_in_trystatement4814);
            block();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:627:9: ( catches 'finally' block | catches | 'finally' block )
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:627:13: catches 'finally' block
                    {
                    pushFollow(FOLLOW_catches_in_trystatement4828);
                    catches();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,FINALLY,FOLLOW_FINALLY_in_trystatement4830); if (state.failed) return ;

                    pushFollow(FOLLOW_block_in_trystatement4832);
                    block();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:628:13: catches
                    {
                    pushFollow(FOLLOW_catches_in_trystatement4846);
                    catches();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:629:13: 'finally' block
                    {
                    match(input,FINALLY,FOLLOW_FINALLY_in_trystatement4860); if (state.failed) return ;

                    pushFollow(FOLLOW_block_in_trystatement4862);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:633:1: catches : catchClause ( catchClause )* ;
    public final void catches() throws RecognitionException {
        int catches_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:634:5: ( catchClause ( catchClause )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:634:9: catchClause ( catchClause )*
            {
            pushFollow(FOLLOW_catchClause_in_catches4893);
            catchClause();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:635:9: ( catchClause )*
            loop102:
            do {
                int alt102=2;
                int LA102_0 = input.LA(1);

                if ( (LA102_0==CATCH) ) {
                    alt102=1;
                }


                switch (alt102) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:635:10: catchClause
            	    {
            	    pushFollow(FOLLOW_catchClause_in_catches4904);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:639:1: catchClause : 'catch' '(' formalParameter ')' block ;
    public final void catchClause() throws RecognitionException {
        int catchClause_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:640:5: ( 'catch' '(' formalParameter ')' block )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:640:9: 'catch' '(' formalParameter ')' block
            {
            match(input,CATCH,FOLLOW_CATCH_in_catchClause4935); if (state.failed) return ;

            match(input,LPAREN,FOLLOW_LPAREN_in_catchClause4937); if (state.failed) return ;

            pushFollow(FOLLOW_formalParameter_in_catchClause4939);
            formalParameter();

            state._fsp--;
            if (state.failed) return ;

            match(input,RPAREN,FOLLOW_RPAREN_in_catchClause4949); if (state.failed) return ;

            pushFollow(FOLLOW_block_in_catchClause4951);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:644:1: formalParameter : variableModifiers type IDENTIFIER ( '[' ']' )* ;
    public final void formalParameter() throws RecognitionException {
        int formalParameter_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:645:5: ( variableModifiers type IDENTIFIER ( '[' ']' )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:645:9: variableModifiers type IDENTIFIER ( '[' ']' )*
            {
            pushFollow(FOLLOW_variableModifiers_in_formalParameter4972);
            variableModifiers();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_type_in_formalParameter4974);
            type();

            state._fsp--;
            if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_formalParameter4976); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:646:9: ( '[' ']' )*
            loop103:
            do {
                int alt103=2;
                int LA103_0 = input.LA(1);

                if ( (LA103_0==LBRACKET) ) {
                    alt103=1;
                }


                switch (alt103) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:646:10: '[' ']'
            	    {
            	    match(input,LBRACKET,FOLLOW_LBRACKET_in_formalParameter4987); if (state.failed) return ;

            	    match(input,RBRACKET,FOLLOW_RBRACKET_in_formalParameter4989); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:650:1: forstatement : ( 'for' '(' variableModifiers type IDENTIFIER ':' expression ')' statement | 'for' '(' ( forInit )? ';' ( expression )? ';' ( expressionList )? ')' statement );
    public final void forstatement() throws RecognitionException {
        int forstatement_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:651:5: ( 'for' '(' variableModifiers type IDENTIFIER ':' expression ')' statement | 'for' '(' ( forInit )? ';' ( expression )? ';' ( expressionList )? ')' statement )
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:653:9: 'for' '(' variableModifiers type IDENTIFIER ':' expression ')' statement
                    {
                    match(input,FOR,FOLLOW_FOR_in_forstatement5038); if (state.failed) return ;

                    match(input,LPAREN,FOLLOW_LPAREN_in_forstatement5040); if (state.failed) return ;

                    pushFollow(FOLLOW_variableModifiers_in_forstatement5042);
                    variableModifiers();

                    state._fsp--;
                    if (state.failed) return ;

                    pushFollow(FOLLOW_type_in_forstatement5044);
                    type();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_forstatement5046); if (state.failed) return ;

                    match(input,COLON,FOLLOW_COLON_in_forstatement5048); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_forstatement5059);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,RPAREN,FOLLOW_RPAREN_in_forstatement5061); if (state.failed) return ;

                    pushFollow(FOLLOW_statement_in_forstatement5063);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:657:9: 'for' '(' ( forInit )? ';' ( expression )? ';' ( expressionList )? ')' statement
                    {
                    match(input,FOR,FOLLOW_FOR_in_forstatement5095); if (state.failed) return ;

                    match(input,LPAREN,FOLLOW_LPAREN_in_forstatement5097); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:658:17: ( forInit )?
                    int alt104=2;
                    int LA104_0 = input.LA(1);

                    if ( (LA104_0==BANG||LA104_0==BOOLEAN||LA104_0==BYTE||(LA104_0 >= CHAR && LA104_0 <= CHARLITERAL)||(LA104_0 >= DOUBLE && LA104_0 <= DOUBLELITERAL)||(LA104_0 >= FALSE && LA104_0 <= FINAL)||(LA104_0 >= FLOAT && LA104_0 <= FLOATLITERAL)||LA104_0==IDENTIFIER||LA104_0==INT||LA104_0==INTLITERAL||(LA104_0 >= LONG && LA104_0 <= LPAREN)||LA104_0==MONKEYS_AT||(LA104_0 >= NEW && LA104_0 <= NULL)||LA104_0==PLUS||LA104_0==PLUSPLUS||LA104_0==SHORT||(LA104_0 >= STRINGLITERAL && LA104_0 <= SUB)||(LA104_0 >= SUBSUB && LA104_0 <= SUPER)||LA104_0==THIS||LA104_0==TILDE||LA104_0==TRUE||LA104_0==VOID) ) {
                        alt104=1;
                    }
                    switch (alt104) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:658:18: forInit
                            {
                            pushFollow(FOLLOW_forInit_in_forstatement5117);
                            forInit();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,SEMI,FOLLOW_SEMI_in_forstatement5138); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:660:17: ( expression )?
                    int alt105=2;
                    int LA105_0 = input.LA(1);

                    if ( (LA105_0==BANG||LA105_0==BOOLEAN||LA105_0==BYTE||(LA105_0 >= CHAR && LA105_0 <= CHARLITERAL)||(LA105_0 >= DOUBLE && LA105_0 <= DOUBLELITERAL)||LA105_0==FALSE||(LA105_0 >= FLOAT && LA105_0 <= FLOATLITERAL)||LA105_0==IDENTIFIER||LA105_0==INT||LA105_0==INTLITERAL||(LA105_0 >= LONG && LA105_0 <= LPAREN)||(LA105_0 >= NEW && LA105_0 <= NULL)||LA105_0==PLUS||LA105_0==PLUSPLUS||LA105_0==SHORT||(LA105_0 >= STRINGLITERAL && LA105_0 <= SUB)||(LA105_0 >= SUBSUB && LA105_0 <= SUPER)||LA105_0==THIS||LA105_0==TILDE||LA105_0==TRUE||LA105_0==VOID) ) {
                        alt105=1;
                    }
                    switch (alt105) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:660:18: expression
                            {
                            pushFollow(FOLLOW_expression_in_forstatement5158);
                            expression();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,SEMI,FOLLOW_SEMI_in_forstatement5179); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:662:17: ( expressionList )?
                    int alt106=2;
                    int LA106_0 = input.LA(1);

                    if ( (LA106_0==BANG||LA106_0==BOOLEAN||LA106_0==BYTE||(LA106_0 >= CHAR && LA106_0 <= CHARLITERAL)||(LA106_0 >= DOUBLE && LA106_0 <= DOUBLELITERAL)||LA106_0==FALSE||(LA106_0 >= FLOAT && LA106_0 <= FLOATLITERAL)||LA106_0==IDENTIFIER||LA106_0==INT||LA106_0==INTLITERAL||(LA106_0 >= LONG && LA106_0 <= LPAREN)||(LA106_0 >= NEW && LA106_0 <= NULL)||LA106_0==PLUS||LA106_0==PLUSPLUS||LA106_0==SHORT||(LA106_0 >= STRINGLITERAL && LA106_0 <= SUB)||(LA106_0 >= SUBSUB && LA106_0 <= SUPER)||LA106_0==THIS||LA106_0==TILDE||LA106_0==TRUE||LA106_0==VOID) ) {
                        alt106=1;
                    }
                    switch (alt106) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:662:18: expressionList
                            {
                            pushFollow(FOLLOW_expressionList_in_forstatement5199);
                            expressionList();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,RPAREN,FOLLOW_RPAREN_in_forstatement5220); if (state.failed) return ;

                    pushFollow(FOLLOW_statement_in_forstatement5222);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:666:1: forInit : ( localVariableDeclaration | expressionList );
    public final void forInit() throws RecognitionException {
        int forInit_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 67) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:667:5: ( localVariableDeclaration | expressionList )
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:667:9: localVariableDeclaration
                    {
                    pushFollow(FOLLOW_localVariableDeclaration_in_forInit5242);
                    localVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:668:9: expressionList
                    {
                    pushFollow(FOLLOW_expressionList_in_forInit5252);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:671:1: parExpression : '(' expression ')' ;
    public final void parExpression() throws RecognitionException {
        int parExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 68) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:672:5: ( '(' expression ')' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:672:9: '(' expression ')'
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_parExpression5272); if (state.failed) return ;

            pushFollow(FOLLOW_expression_in_parExpression5274);
            expression();

            state._fsp--;
            if (state.failed) return ;

            match(input,RPAREN,FOLLOW_RPAREN_in_parExpression5276); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:675:1: expressionList : expression ( ',' expression )* ;
    public final void expressionList() throws RecognitionException {
        int expressionList_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 69) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:676:5: ( expression ( ',' expression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:676:9: expression ( ',' expression )*
            {
            pushFollow(FOLLOW_expression_in_expressionList5296);
            expression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:677:9: ( ',' expression )*
            loop109:
            do {
                int alt109=2;
                int LA109_0 = input.LA(1);

                if ( (LA109_0==COMMA) ) {
                    alt109=1;
                }


                switch (alt109) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:677:10: ',' expression
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_expressionList5307); if (state.failed) return ;

            	    pushFollow(FOLLOW_expression_in_expressionList5309);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:682:1: expression : conditionalExpression ( assignmentOperator expression )? ;
    public final void expression() throws RecognitionException {
        int expression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 70) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:683:5: ( conditionalExpression ( assignmentOperator expression )? )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:683:9: conditionalExpression ( assignmentOperator expression )?
            {
            pushFollow(FOLLOW_conditionalExpression_in_expression5341);
            conditionalExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:684:9: ( assignmentOperator expression )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==AMPEQ||LA110_0==BAREQ||LA110_0==CARETEQ||LA110_0==EQ||LA110_0==GT||LA110_0==LT||LA110_0==PERCENTEQ||LA110_0==PLUSEQ||LA110_0==SLASHEQ||LA110_0==STAREQ||LA110_0==SUBEQ) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:684:10: assignmentOperator expression
                    {
                    pushFollow(FOLLOW_assignmentOperator_in_expression5352);
                    assignmentOperator();

                    state._fsp--;
                    if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_expression5354);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:689:1: assignmentOperator : ( '=' | '+=' | '-=' | '*=' | '/=' | '&=' | '|=' | '^=' | '%=' | '<' '<' '=' | '>' '>' '>' '=' | '>' '>' '=' );
    public final void assignmentOperator() throws RecognitionException {
        int assignmentOperator_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 71) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:690:5: ( '=' | '+=' | '-=' | '*=' | '/=' | '&=' | '|=' | '^=' | '%=' | '<' '<' '=' | '>' '>' '>' '=' | '>' '>' '=' )
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:690:9: '='
                    {
                    match(input,EQ,FOLLOW_EQ_in_assignmentOperator5386); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:691:9: '+='
                    {
                    match(input,PLUSEQ,FOLLOW_PLUSEQ_in_assignmentOperator5396); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:692:9: '-='
                    {
                    match(input,SUBEQ,FOLLOW_SUBEQ_in_assignmentOperator5406); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:693:9: '*='
                    {
                    match(input,STAREQ,FOLLOW_STAREQ_in_assignmentOperator5416); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:694:9: '/='
                    {
                    match(input,SLASHEQ,FOLLOW_SLASHEQ_in_assignmentOperator5426); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:695:9: '&='
                    {
                    match(input,AMPEQ,FOLLOW_AMPEQ_in_assignmentOperator5436); if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:696:9: '|='
                    {
                    match(input,BAREQ,FOLLOW_BAREQ_in_assignmentOperator5446); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:697:9: '^='
                    {
                    match(input,CARETEQ,FOLLOW_CARETEQ_in_assignmentOperator5456); if (state.failed) return ;

                    }
                    break;
                case 9 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:698:9: '%='
                    {
                    match(input,PERCENTEQ,FOLLOW_PERCENTEQ_in_assignmentOperator5466); if (state.failed) return ;

                    }
                    break;
                case 10 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:699:10: '<' '<' '='
                    {
                    match(input,LT,FOLLOW_LT_in_assignmentOperator5477); if (state.failed) return ;

                    match(input,LT,FOLLOW_LT_in_assignmentOperator5479); if (state.failed) return ;

                    match(input,EQ,FOLLOW_EQ_in_assignmentOperator5481); if (state.failed) return ;

                    }
                    break;
                case 11 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:700:10: '>' '>' '>' '='
                    {
                    match(input,GT,FOLLOW_GT_in_assignmentOperator5492); if (state.failed) return ;

                    match(input,GT,FOLLOW_GT_in_assignmentOperator5494); if (state.failed) return ;

                    match(input,GT,FOLLOW_GT_in_assignmentOperator5496); if (state.failed) return ;

                    match(input,EQ,FOLLOW_EQ_in_assignmentOperator5498); if (state.failed) return ;

                    }
                    break;
                case 12 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:701:10: '>' '>' '='
                    {
                    match(input,GT,FOLLOW_GT_in_assignmentOperator5509); if (state.failed) return ;

                    match(input,GT,FOLLOW_GT_in_assignmentOperator5511); if (state.failed) return ;

                    match(input,EQ,FOLLOW_EQ_in_assignmentOperator5513); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:705:1: conditionalExpression : conditionalOrExpression ( '?' expression ':' conditionalExpression )? ;
    public final void conditionalExpression() throws RecognitionException {
        int conditionalExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 72) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:706:5: ( conditionalOrExpression ( '?' expression ':' conditionalExpression )? )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:706:9: conditionalOrExpression ( '?' expression ':' conditionalExpression )?
            {
            pushFollow(FOLLOW_conditionalOrExpression_in_conditionalExpression5534);
            conditionalOrExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:707:9: ( '?' expression ':' conditionalExpression )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==QUES) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:707:10: '?' expression ':' conditionalExpression
                    {
                    match(input,QUES,FOLLOW_QUES_in_conditionalExpression5545); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_conditionalExpression5547);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,COLON,FOLLOW_COLON_in_conditionalExpression5549); if (state.failed) return ;

                    pushFollow(FOLLOW_conditionalExpression_in_conditionalExpression5551);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:711:1: conditionalOrExpression : conditionalAndExpression ( '||' conditionalAndExpression )* ;
    public final void conditionalOrExpression() throws RecognitionException {
        int conditionalOrExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 73) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:712:5: ( conditionalAndExpression ( '||' conditionalAndExpression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:712:9: conditionalAndExpression ( '||' conditionalAndExpression )*
            {
            pushFollow(FOLLOW_conditionalAndExpression_in_conditionalOrExpression5582);
            conditionalAndExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:713:9: ( '||' conditionalAndExpression )*
            loop113:
            do {
                int alt113=2;
                int LA113_0 = input.LA(1);

                if ( (LA113_0==BARBAR) ) {
                    alt113=1;
                }


                switch (alt113) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:713:10: '||' conditionalAndExpression
            	    {
            	    match(input,BARBAR,FOLLOW_BARBAR_in_conditionalOrExpression5593); if (state.failed) return ;

            	    pushFollow(FOLLOW_conditionalAndExpression_in_conditionalOrExpression5595);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:717:1: conditionalAndExpression : inclusiveOrExpression ( '&&' inclusiveOrExpression )* ;
    public final void conditionalAndExpression() throws RecognitionException {
        int conditionalAndExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 74) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:718:5: ( inclusiveOrExpression ( '&&' inclusiveOrExpression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:718:9: inclusiveOrExpression ( '&&' inclusiveOrExpression )*
            {
            pushFollow(FOLLOW_inclusiveOrExpression_in_conditionalAndExpression5626);
            inclusiveOrExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:719:9: ( '&&' inclusiveOrExpression )*
            loop114:
            do {
                int alt114=2;
                int LA114_0 = input.LA(1);

                if ( (LA114_0==AMPAMP) ) {
                    alt114=1;
                }


                switch (alt114) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:719:10: '&&' inclusiveOrExpression
            	    {
            	    match(input,AMPAMP,FOLLOW_AMPAMP_in_conditionalAndExpression5637); if (state.failed) return ;

            	    pushFollow(FOLLOW_inclusiveOrExpression_in_conditionalAndExpression5639);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:723:1: inclusiveOrExpression : exclusiveOrExpression ( '|' exclusiveOrExpression )* ;
    public final void inclusiveOrExpression() throws RecognitionException {
        int inclusiveOrExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 75) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:724:5: ( exclusiveOrExpression ( '|' exclusiveOrExpression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:724:9: exclusiveOrExpression ( '|' exclusiveOrExpression )*
            {
            pushFollow(FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression5670);
            exclusiveOrExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:725:9: ( '|' exclusiveOrExpression )*
            loop115:
            do {
                int alt115=2;
                int LA115_0 = input.LA(1);

                if ( (LA115_0==BAR) ) {
                    alt115=1;
                }


                switch (alt115) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:725:10: '|' exclusiveOrExpression
            	    {
            	    match(input,BAR,FOLLOW_BAR_in_inclusiveOrExpression5681); if (state.failed) return ;

            	    pushFollow(FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression5683);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:729:1: exclusiveOrExpression : andExpression ( '^' andExpression )* ;
    public final void exclusiveOrExpression() throws RecognitionException {
        int exclusiveOrExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 76) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:730:5: ( andExpression ( '^' andExpression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:730:9: andExpression ( '^' andExpression )*
            {
            pushFollow(FOLLOW_andExpression_in_exclusiveOrExpression5714);
            andExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:731:9: ( '^' andExpression )*
            loop116:
            do {
                int alt116=2;
                int LA116_0 = input.LA(1);

                if ( (LA116_0==CARET) ) {
                    alt116=1;
                }


                switch (alt116) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:731:10: '^' andExpression
            	    {
            	    match(input,CARET,FOLLOW_CARET_in_exclusiveOrExpression5725); if (state.failed) return ;

            	    pushFollow(FOLLOW_andExpression_in_exclusiveOrExpression5727);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:735:1: andExpression : equalityExpression ( '&' equalityExpression )* ;
    public final void andExpression() throws RecognitionException {
        int andExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 77) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:736:5: ( equalityExpression ( '&' equalityExpression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:736:9: equalityExpression ( '&' equalityExpression )*
            {
            pushFollow(FOLLOW_equalityExpression_in_andExpression5758);
            equalityExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:737:9: ( '&' equalityExpression )*
            loop117:
            do {
                int alt117=2;
                int LA117_0 = input.LA(1);

                if ( (LA117_0==AMP) ) {
                    alt117=1;
                }


                switch (alt117) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:737:10: '&' equalityExpression
            	    {
            	    match(input,AMP,FOLLOW_AMP_in_andExpression5769); if (state.failed) return ;

            	    pushFollow(FOLLOW_equalityExpression_in_andExpression5771);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:741:1: equalityExpression : instanceOfExpression ( ( '==' | '!=' ) instanceOfExpression )* ;
    public final void equalityExpression() throws RecognitionException {
        int equalityExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 78) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:742:5: ( instanceOfExpression ( ( '==' | '!=' ) instanceOfExpression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:742:9: instanceOfExpression ( ( '==' | '!=' ) instanceOfExpression )*
            {
            pushFollow(FOLLOW_instanceOfExpression_in_equalityExpression5802);
            instanceOfExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:743:9: ( ( '==' | '!=' ) instanceOfExpression )*
            loop118:
            do {
                int alt118=2;
                int LA118_0 = input.LA(1);

                if ( (LA118_0==BANGEQ||LA118_0==EQEQ) ) {
                    alt118=1;
                }


                switch (alt118) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:744:13: ( '==' | '!=' ) instanceOfExpression
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


            	    pushFollow(FOLLOW_instanceOfExpression_in_equalityExpression5879);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:751:1: instanceOfExpression : relationalExpression ( 'instanceof' type )? ;
    public final void instanceOfExpression() throws RecognitionException {
        int instanceOfExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 79) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:752:5: ( relationalExpression ( 'instanceof' type )? )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:752:9: relationalExpression ( 'instanceof' type )?
            {
            pushFollow(FOLLOW_relationalExpression_in_instanceOfExpression5910);
            relationalExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:753:9: ( 'instanceof' type )?
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==INSTANCEOF) ) {
                alt119=1;
            }
            switch (alt119) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:753:10: 'instanceof' type
                    {
                    match(input,INSTANCEOF,FOLLOW_INSTANCEOF_in_instanceOfExpression5921); if (state.failed) return ;

                    pushFollow(FOLLOW_type_in_instanceOfExpression5923);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:757:1: relationalExpression : shiftExpression ( relationalOp shiftExpression )* ;
    public final void relationalExpression() throws RecognitionException {
        int relationalExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 80) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:758:5: ( shiftExpression ( relationalOp shiftExpression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:758:9: shiftExpression ( relationalOp shiftExpression )*
            {
            pushFollow(FOLLOW_shiftExpression_in_relationalExpression5954);
            shiftExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:759:9: ( relationalOp shiftExpression )*
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
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:759:10: relationalOp shiftExpression
            	    {
            	    pushFollow(FOLLOW_relationalOp_in_relationalExpression5965);
            	    relationalOp();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    pushFollow(FOLLOW_shiftExpression_in_relationalExpression5967);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:763:1: relationalOp : ( '<' '=' | '>' '=' | '<' | '>' );
    public final void relationalOp() throws RecognitionException {
        int relationalOp_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 81) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:764:5: ( '<' '=' | '>' '=' | '<' | '>' )
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:764:10: '<' '='
                    {
                    match(input,LT,FOLLOW_LT_in_relationalOp5999); if (state.failed) return ;

                    match(input,EQ,FOLLOW_EQ_in_relationalOp6001); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:765:10: '>' '='
                    {
                    match(input,GT,FOLLOW_GT_in_relationalOp6012); if (state.failed) return ;

                    match(input,EQ,FOLLOW_EQ_in_relationalOp6014); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:766:9: '<'
                    {
                    match(input,LT,FOLLOW_LT_in_relationalOp6024); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:767:9: '>'
                    {
                    match(input,GT,FOLLOW_GT_in_relationalOp6034); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:770:1: shiftExpression : additiveExpression ( shiftOp additiveExpression )* ;
    public final void shiftExpression() throws RecognitionException {
        int shiftExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 82) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:771:5: ( additiveExpression ( shiftOp additiveExpression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:771:9: additiveExpression ( shiftOp additiveExpression )*
            {
            pushFollow(FOLLOW_additiveExpression_in_shiftExpression6054);
            additiveExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:772:9: ( shiftOp additiveExpression )*
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
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:772:10: shiftOp additiveExpression
            	    {
            	    pushFollow(FOLLOW_shiftOp_in_shiftExpression6065);
            	    shiftOp();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    pushFollow(FOLLOW_additiveExpression_in_shiftExpression6067);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:777:1: shiftOp : ( '<' '<' | '>' '>' '>' | '>' '>' );
    public final void shiftOp() throws RecognitionException {
        int shiftOp_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 83) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:778:5: ( '<' '<' | '>' '>' '>' | '>' '>' )
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:778:10: '<' '<'
                    {
                    match(input,LT,FOLLOW_LT_in_shiftOp6100); if (state.failed) return ;

                    match(input,LT,FOLLOW_LT_in_shiftOp6102); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:779:10: '>' '>' '>'
                    {
                    match(input,GT,FOLLOW_GT_in_shiftOp6113); if (state.failed) return ;

                    match(input,GT,FOLLOW_GT_in_shiftOp6115); if (state.failed) return ;

                    match(input,GT,FOLLOW_GT_in_shiftOp6117); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:780:10: '>' '>'
                    {
                    match(input,GT,FOLLOW_GT_in_shiftOp6128); if (state.failed) return ;

                    match(input,GT,FOLLOW_GT_in_shiftOp6130); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:784:1: additiveExpression : multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )* ;
    public final void additiveExpression() throws RecognitionException {
        int additiveExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 84) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:785:5: ( multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:785:9: multiplicativeExpression ( ( '+' | '-' ) multiplicativeExpression )*
            {
            pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression6151);
            multiplicativeExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:786:9: ( ( '+' | '-' ) multiplicativeExpression )*
            loop124:
            do {
                int alt124=2;
                int LA124_0 = input.LA(1);

                if ( (LA124_0==PLUS||LA124_0==SUB) ) {
                    alt124=1;
                }


                switch (alt124) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:787:13: ( '+' | '-' ) multiplicativeExpression
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


            	    pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression6228);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:794:1: multiplicativeExpression : unaryExpression ( ( '*' | '/' | '%' ) unaryExpression )* ;
    public final void multiplicativeExpression() throws RecognitionException {
        int multiplicativeExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 85) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:795:5: ( unaryExpression ( ( '*' | '/' | '%' ) unaryExpression )* )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:796:9: unaryExpression ( ( '*' | '/' | '%' ) unaryExpression )*
            {
            pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression6266);
            unaryExpression();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:797:9: ( ( '*' | '/' | '%' ) unaryExpression )*
            loop125:
            do {
                int alt125=2;
                int LA125_0 = input.LA(1);

                if ( (LA125_0==PERCENT||LA125_0==SLASH||LA125_0==STAR) ) {
                    alt125=1;
                }


                switch (alt125) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:798:13: ( '*' | '/' | '%' ) unaryExpression
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


            	    pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression6361);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:810:1: unaryExpression : ( '+' unaryExpression | '-' unaryExpression | '++' unaryExpression | '--' unaryExpression | unaryExpressionNotPlusMinus );
    public final void unaryExpression() throws RecognitionException {
        int unaryExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 86) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:811:5: ( '+' unaryExpression | '-' unaryExpression | '++' unaryExpression | '--' unaryExpression | unaryExpressionNotPlusMinus )
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:811:9: '+' unaryExpression
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_unaryExpression6394); if (state.failed) return ;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression6397);
                    unaryExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:812:9: '-' unaryExpression
                    {
                    match(input,SUB,FOLLOW_SUB_in_unaryExpression6407); if (state.failed) return ;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression6409);
                    unaryExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:813:9: '++' unaryExpression
                    {
                    match(input,PLUSPLUS,FOLLOW_PLUSPLUS_in_unaryExpression6419); if (state.failed) return ;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression6421);
                    unaryExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:814:9: '--' unaryExpression
                    {
                    match(input,SUBSUB,FOLLOW_SUBSUB_in_unaryExpression6431); if (state.failed) return ;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression6433);
                    unaryExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:815:9: unaryExpressionNotPlusMinus
                    {
                    pushFollow(FOLLOW_unaryExpressionNotPlusMinus_in_unaryExpression6443);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:818:1: unaryExpressionNotPlusMinus : ( '~' unaryExpression | '!' unaryExpression | castExpression | primary ( selector )* ( '++' | '--' )? );
    public final void unaryExpressionNotPlusMinus() throws RecognitionException {
        int unaryExpressionNotPlusMinus_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 87) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:819:5: ( '~' unaryExpression | '!' unaryExpression | castExpression | primary ( selector )* ( '++' | '--' )? )
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:819:9: '~' unaryExpression
                    {
                    match(input,TILDE,FOLLOW_TILDE_in_unaryExpressionNotPlusMinus6463); if (state.failed) return ;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus6465);
                    unaryExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:820:9: '!' unaryExpression
                    {
                    match(input,BANG,FOLLOW_BANG_in_unaryExpressionNotPlusMinus6475); if (state.failed) return ;

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus6477);
                    unaryExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:821:9: castExpression
                    {
                    pushFollow(FOLLOW_castExpression_in_unaryExpressionNotPlusMinus6487);
                    castExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:822:9: primary ( selector )* ( '++' | '--' )?
                    {
                    pushFollow(FOLLOW_primary_in_unaryExpressionNotPlusMinus6497);
                    primary();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:823:9: ( selector )*
                    loop127:
                    do {
                        int alt127=2;
                        int LA127_0 = input.LA(1);

                        if ( (LA127_0==DOT||LA127_0==LBRACKET) ) {
                            alt127=1;
                        }


                        switch (alt127) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:823:10: selector
                    	    {
                    	    pushFollow(FOLLOW_selector_in_unaryExpressionNotPlusMinus6508);
                    	    selector();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop127;
                        }
                    } while (true);


                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:825:9: ( '++' | '--' )?
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:830:1: castExpression : ( '(' primitiveType ')' unaryExpression | '(' type ')' unaryExpressionNotPlusMinus );
    public final void castExpression() throws RecognitionException {
        int castExpression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 88) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:831:5: ( '(' primitiveType ')' unaryExpression | '(' type ')' unaryExpressionNotPlusMinus )
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:831:9: '(' primitiveType ')' unaryExpression
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_castExpression6578); if (state.failed) return ;

                    pushFollow(FOLLOW_primitiveType_in_castExpression6580);
                    primitiveType();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,RPAREN,FOLLOW_RPAREN_in_castExpression6582); if (state.failed) return ;

                    pushFollow(FOLLOW_unaryExpression_in_castExpression6584);
                    unaryExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:832:9: '(' type ')' unaryExpressionNotPlusMinus
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_castExpression6594); if (state.failed) return ;

                    pushFollow(FOLLOW_type_in_castExpression6596);
                    type();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,RPAREN,FOLLOW_RPAREN_in_castExpression6598); if (state.failed) return ;

                    pushFollow(FOLLOW_unaryExpressionNotPlusMinus_in_castExpression6600);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:838:1: primary : ( parExpression | 'this' ( '.' IDENTIFIER )* ( identifierSuffix )? | IDENTIFIER ( '.' IDENTIFIER )* ( identifierSuffix )? | 'super' superSuffix | literal | creator | primitiveType ( '[' ']' )* '.' 'class' | 'void' '.' 'class' );
    public final void primary() throws RecognitionException {
        int primary_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 89) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:839:5: ( parExpression | 'this' ( '.' IDENTIFIER )* ( identifierSuffix )? | IDENTIFIER ( '.' IDENTIFIER )* ( identifierSuffix )? | 'super' superSuffix | literal | creator | primitiveType ( '[' ']' )* '.' 'class' | 'void' '.' 'class' )
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:839:9: parExpression
                    {
                    pushFollow(FOLLOW_parExpression_in_primary6622);
                    parExpression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:840:9: 'this' ( '.' IDENTIFIER )* ( identifierSuffix )?
                    {
                    match(input,THIS,FOLLOW_THIS_in_primary6644); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:841:9: ( '.' IDENTIFIER )*
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
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:841:10: '.' IDENTIFIER
                    	    {
                    	    match(input,DOT,FOLLOW_DOT_in_primary6655); if (state.failed) return ;

                    	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primary6657); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop131;
                        }
                    } while (true);


                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:843:9: ( identifierSuffix )?
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
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:843:10: identifierSuffix
                            {
                            pushFollow(FOLLOW_identifierSuffix_in_primary6679);
                            identifierSuffix();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:845:9: IDENTIFIER ( '.' IDENTIFIER )* ( identifierSuffix )?
                    {
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primary6700); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:846:9: ( '.' IDENTIFIER )*
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
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:846:10: '.' IDENTIFIER
                    	    {
                    	    match(input,DOT,FOLLOW_DOT_in_primary6711); if (state.failed) return ;

                    	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primary6713); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop133;
                        }
                    } while (true);


                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:848:9: ( identifierSuffix )?
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
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:848:10: identifierSuffix
                            {
                            pushFollow(FOLLOW_identifierSuffix_in_primary6735);
                            identifierSuffix();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:850:9: 'super' superSuffix
                    {
                    match(input,SUPER,FOLLOW_SUPER_in_primary6756); if (state.failed) return ;

                    pushFollow(FOLLOW_superSuffix_in_primary6766);
                    superSuffix();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:852:9: literal
                    {
                    pushFollow(FOLLOW_literal_in_primary6776);
                    literal();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:853:9: creator
                    {
                    pushFollow(FOLLOW_creator_in_primary6786);
                    creator();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:854:9: primitiveType ( '[' ']' )* '.' 'class'
                    {
                    pushFollow(FOLLOW_primitiveType_in_primary6796);
                    primitiveType();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:855:9: ( '[' ']' )*
                    loop135:
                    do {
                        int alt135=2;
                        int LA135_0 = input.LA(1);

                        if ( (LA135_0==LBRACKET) ) {
                            alt135=1;
                        }


                        switch (alt135) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:855:10: '[' ']'
                    	    {
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_primary6807); if (state.failed) return ;

                    	    match(input,RBRACKET,FOLLOW_RBRACKET_in_primary6809); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop135;
                        }
                    } while (true);


                    match(input,DOT,FOLLOW_DOT_in_primary6830); if (state.failed) return ;

                    match(input,CLASS,FOLLOW_CLASS_in_primary6832); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:858:9: 'void' '.' 'class'
                    {
                    match(input,VOID,FOLLOW_VOID_in_primary6842); if (state.failed) return ;

                    match(input,DOT,FOLLOW_DOT_in_primary6844); if (state.failed) return ;

                    match(input,CLASS,FOLLOW_CLASS_in_primary6846); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:862:1: superSuffix : ( arguments | '.' ( typeArguments )? IDENTIFIER ( arguments )? );
    public final void superSuffix() throws RecognitionException {
        int superSuffix_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 90) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:863:5: ( arguments | '.' ( typeArguments )? IDENTIFIER ( arguments )? )
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:863:9: arguments
                    {
                    pushFollow(FOLLOW_arguments_in_superSuffix6872);
                    arguments();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:864:9: '.' ( typeArguments )? IDENTIFIER ( arguments )?
                    {
                    match(input,DOT,FOLLOW_DOT_in_superSuffix6882); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:864:13: ( typeArguments )?
                    int alt137=2;
                    int LA137_0 = input.LA(1);

                    if ( (LA137_0==LT) ) {
                        alt137=1;
                    }
                    switch (alt137) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:864:14: typeArguments
                            {
                            pushFollow(FOLLOW_typeArguments_in_superSuffix6885);
                            typeArguments();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_superSuffix6906); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:867:9: ( arguments )?
                    int alt138=2;
                    int LA138_0 = input.LA(1);

                    if ( (LA138_0==LPAREN) ) {
                        alt138=1;
                    }
                    switch (alt138) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:867:10: arguments
                            {
                            pushFollow(FOLLOW_arguments_in_superSuffix6917);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:872:1: identifierSuffix : ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | arguments | '.' 'class' | '.' nonWildcardTypeArguments IDENTIFIER arguments | '.' 'this' | '.' 'super' arguments | innerCreator );
    public final void identifierSuffix() throws RecognitionException {
        int identifierSuffix_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 91) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:873:5: ( ( '[' ']' )+ '.' 'class' | ( '[' expression ']' )+ | arguments | '.' 'class' | '.' nonWildcardTypeArguments IDENTIFIER arguments | '.' 'this' | '.' 'super' arguments | innerCreator )
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:873:9: ( '[' ']' )+ '.' 'class'
                    {
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:873:9: ( '[' ']' )+
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
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:873:10: '[' ']'
                    	    {
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_identifierSuffix6950); if (state.failed) return ;

                    	    match(input,RBRACKET,FOLLOW_RBRACKET_in_identifierSuffix6952); if (state.failed) return ;

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


                    match(input,DOT,FOLLOW_DOT_in_identifierSuffix6973); if (state.failed) return ;

                    match(input,CLASS,FOLLOW_CLASS_in_identifierSuffix6975); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:876:9: ( '[' expression ']' )+
                    {
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:876:9: ( '[' expression ']' )+
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
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:876:10: '[' expression ']'
                    	    {
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_identifierSuffix6986); if (state.failed) return ;

                    	    pushFollow(FOLLOW_expression_in_identifierSuffix6988);
                    	    expression();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    match(input,RBRACKET,FOLLOW_RBRACKET_in_identifierSuffix6990); if (state.failed) return ;

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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:878:9: arguments
                    {
                    pushFollow(FOLLOW_arguments_in_identifierSuffix7011);
                    arguments();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:879:9: '.' 'class'
                    {
                    match(input,DOT,FOLLOW_DOT_in_identifierSuffix7021); if (state.failed) return ;

                    match(input,CLASS,FOLLOW_CLASS_in_identifierSuffix7023); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:880:9: '.' nonWildcardTypeArguments IDENTIFIER arguments
                    {
                    match(input,DOT,FOLLOW_DOT_in_identifierSuffix7033); if (state.failed) return ;

                    pushFollow(FOLLOW_nonWildcardTypeArguments_in_identifierSuffix7035);
                    nonWildcardTypeArguments();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_identifierSuffix7037); if (state.failed) return ;

                    pushFollow(FOLLOW_arguments_in_identifierSuffix7039);
                    arguments();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:881:9: '.' 'this'
                    {
                    match(input,DOT,FOLLOW_DOT_in_identifierSuffix7049); if (state.failed) return ;

                    match(input,THIS,FOLLOW_THIS_in_identifierSuffix7051); if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:882:9: '.' 'super' arguments
                    {
                    match(input,DOT,FOLLOW_DOT_in_identifierSuffix7061); if (state.failed) return ;

                    match(input,SUPER,FOLLOW_SUPER_in_identifierSuffix7063); if (state.failed) return ;

                    pushFollow(FOLLOW_arguments_in_identifierSuffix7065);
                    arguments();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:883:9: innerCreator
                    {
                    pushFollow(FOLLOW_innerCreator_in_identifierSuffix7075);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:887:1: selector : ( '.' IDENTIFIER ( arguments )? | '.' 'this' | '.' 'super' superSuffix | innerCreator | '[' expression ']' );
    public final void selector() throws RecognitionException {
        int selector_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 92) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:888:5: ( '.' IDENTIFIER ( arguments )? | '.' 'this' | '.' 'super' superSuffix | innerCreator | '[' expression ']' )
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:888:9: '.' IDENTIFIER ( arguments )?
                    {
                    match(input,DOT,FOLLOW_DOT_in_selector7097); if (state.failed) return ;

                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_selector7099); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:889:9: ( arguments )?
                    int alt143=2;
                    int LA143_0 = input.LA(1);

                    if ( (LA143_0==LPAREN) ) {
                        alt143=1;
                    }
                    switch (alt143) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:889:10: arguments
                            {
                            pushFollow(FOLLOW_arguments_in_selector7110);
                            arguments();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:891:9: '.' 'this'
                    {
                    match(input,DOT,FOLLOW_DOT_in_selector7131); if (state.failed) return ;

                    match(input,THIS,FOLLOW_THIS_in_selector7133); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:892:9: '.' 'super' superSuffix
                    {
                    match(input,DOT,FOLLOW_DOT_in_selector7143); if (state.failed) return ;

                    match(input,SUPER,FOLLOW_SUPER_in_selector7145); if (state.failed) return ;

                    pushFollow(FOLLOW_superSuffix_in_selector7155);
                    superSuffix();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:894:9: innerCreator
                    {
                    pushFollow(FOLLOW_innerCreator_in_selector7165);
                    innerCreator();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:895:9: '[' expression ']'
                    {
                    match(input,LBRACKET,FOLLOW_LBRACKET_in_selector7175); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_selector7177);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,RBRACKET,FOLLOW_RBRACKET_in_selector7179); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:898:1: creator : ( 'new' nonWildcardTypeArguments classOrInterfaceType classCreatorRest | 'new' classOrInterfaceType classCreatorRest | arrayCreator );
    public final void creator() throws RecognitionException {
        int creator_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 93) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:899:5: ( 'new' nonWildcardTypeArguments classOrInterfaceType classCreatorRest | 'new' classOrInterfaceType classCreatorRest | arrayCreator )
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:899:9: 'new' nonWildcardTypeArguments classOrInterfaceType classCreatorRest
                    {
                    match(input,NEW,FOLLOW_NEW_in_creator7199); if (state.failed) return ;

                    pushFollow(FOLLOW_nonWildcardTypeArguments_in_creator7201);
                    nonWildcardTypeArguments();

                    state._fsp--;
                    if (state.failed) return ;

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
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:900:9: 'new' classOrInterfaceType classCreatorRest
                    {
                    match(input,NEW,FOLLOW_NEW_in_creator7215); if (state.failed) return ;

                    pushFollow(FOLLOW_classOrInterfaceType_in_creator7217);
                    classOrInterfaceType();

                    state._fsp--;
                    if (state.failed) return ;

                    pushFollow(FOLLOW_classCreatorRest_in_creator7219);
                    classCreatorRest();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:901:9: arrayCreator
                    {
                    pushFollow(FOLLOW_arrayCreator_in_creator7229);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:904:1: arrayCreator : ( 'new' createdName '[' ']' ( '[' ']' )* arrayInitializer | 'new' createdName '[' expression ']' ( '[' expression ']' )* ( '[' ']' )* );
    public final void arrayCreator() throws RecognitionException {
        int arrayCreator_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 94) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:905:5: ( 'new' createdName '[' ']' ( '[' ']' )* arrayInitializer | 'new' createdName '[' expression ']' ( '[' expression ']' )* ( '[' ']' )* )
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:905:9: 'new' createdName '[' ']' ( '[' ']' )* arrayInitializer
                    {
                    match(input,NEW,FOLLOW_NEW_in_arrayCreator7249); if (state.failed) return ;

                    pushFollow(FOLLOW_createdName_in_arrayCreator7251);
                    createdName();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,LBRACKET,FOLLOW_LBRACKET_in_arrayCreator7261); if (state.failed) return ;

                    match(input,RBRACKET,FOLLOW_RBRACKET_in_arrayCreator7263); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:907:9: ( '[' ']' )*
                    loop146:
                    do {
                        int alt146=2;
                        int LA146_0 = input.LA(1);

                        if ( (LA146_0==LBRACKET) ) {
                            alt146=1;
                        }


                        switch (alt146) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:907:10: '[' ']'
                    	    {
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_arrayCreator7274); if (state.failed) return ;

                    	    match(input,RBRACKET,FOLLOW_RBRACKET_in_arrayCreator7276); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop146;
                        }
                    } while (true);


                    pushFollow(FOLLOW_arrayInitializer_in_arrayCreator7297);
                    arrayInitializer();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:911:9: 'new' createdName '[' expression ']' ( '[' expression ']' )* ( '[' ']' )*
                    {
                    match(input,NEW,FOLLOW_NEW_in_arrayCreator7308); if (state.failed) return ;

                    pushFollow(FOLLOW_createdName_in_arrayCreator7310);
                    createdName();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,LBRACKET,FOLLOW_LBRACKET_in_arrayCreator7320); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_arrayCreator7322);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,RBRACKET,FOLLOW_RBRACKET_in_arrayCreator7332); if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:914:9: ( '[' expression ']' )*
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
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:914:13: '[' expression ']'
                    	    {
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_arrayCreator7346); if (state.failed) return ;

                    	    pushFollow(FOLLOW_expression_in_arrayCreator7348);
                    	    expression();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    match(input,RBRACKET,FOLLOW_RBRACKET_in_arrayCreator7362); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop147;
                        }
                    } while (true);


                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:917:9: ( '[' ']' )*
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
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:917:10: '[' ']'
                    	    {
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_arrayCreator7384); if (state.failed) return ;

                    	    match(input,RBRACKET,FOLLOW_RBRACKET_in_arrayCreator7386); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:921:1: variableInitializer : ( arrayInitializer | expression );
    public final void variableInitializer() throws RecognitionException {
        int variableInitializer_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 95) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:922:5: ( arrayInitializer | expression )
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:922:9: arrayInitializer
                    {
                    pushFollow(FOLLOW_arrayInitializer_in_variableInitializer7417);
                    arrayInitializer();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:923:9: expression
                    {
                    pushFollow(FOLLOW_expression_in_variableInitializer7427);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:926:1: arrayInitializer : '{' ( variableInitializer ( ',' variableInitializer )* )? ( ',' )? '}' ;
    public final void arrayInitializer() throws RecognitionException {
        int arrayInitializer_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 96) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:927:5: ( '{' ( variableInitializer ( ',' variableInitializer )* )? ( ',' )? '}' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:927:9: '{' ( variableInitializer ( ',' variableInitializer )* )? ( ',' )? '}'
            {
            match(input,LBRACE,FOLLOW_LBRACE_in_arrayInitializer7447); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:928:13: ( variableInitializer ( ',' variableInitializer )* )?
            int alt152=2;
            int LA152_0 = input.LA(1);

            if ( (LA152_0==BANG||LA152_0==BOOLEAN||LA152_0==BYTE||(LA152_0 >= CHAR && LA152_0 <= CHARLITERAL)||(LA152_0 >= DOUBLE && LA152_0 <= DOUBLELITERAL)||LA152_0==FALSE||(LA152_0 >= FLOAT && LA152_0 <= FLOATLITERAL)||LA152_0==IDENTIFIER||LA152_0==INT||LA152_0==INTLITERAL||LA152_0==LBRACE||(LA152_0 >= LONG && LA152_0 <= LPAREN)||(LA152_0 >= NEW && LA152_0 <= NULL)||LA152_0==PLUS||LA152_0==PLUSPLUS||LA152_0==SHORT||(LA152_0 >= STRINGLITERAL && LA152_0 <= SUB)||(LA152_0 >= SUBSUB && LA152_0 <= SUPER)||LA152_0==THIS||LA152_0==TILDE||LA152_0==TRUE||LA152_0==VOID) ) {
                alt152=1;
            }
            switch (alt152) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:928:14: variableInitializer ( ',' variableInitializer )*
                    {
                    pushFollow(FOLLOW_variableInitializer_in_arrayInitializer7463);
                    variableInitializer();

                    state._fsp--;
                    if (state.failed) return ;

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:929:17: ( ',' variableInitializer )*
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
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:929:18: ',' variableInitializer
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_arrayInitializer7482); if (state.failed) return ;

                    	    pushFollow(FOLLOW_variableInitializer_in_arrayInitializer7484);
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


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:932:13: ( ',' )?
            int alt153=2;
            int LA153_0 = input.LA(1);

            if ( (LA153_0==COMMA) ) {
                alt153=1;
            }
            switch (alt153) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:932:14: ','
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_arrayInitializer7534); if (state.failed) return ;

                    }
                    break;

            }


            match(input,RBRACE,FOLLOW_RBRACE_in_arrayInitializer7547); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:937:1: createdName : ( classOrInterfaceType | primitiveType );
    public final void createdName() throws RecognitionException {
        int createdName_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 97) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:938:5: ( classOrInterfaceType | primitiveType )
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:938:9: classOrInterfaceType
                    {
                    pushFollow(FOLLOW_classOrInterfaceType_in_createdName7581);
                    classOrInterfaceType();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:939:9: primitiveType
                    {
                    pushFollow(FOLLOW_primitiveType_in_createdName7591);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:942:1: innerCreator : '.' 'new' ( nonWildcardTypeArguments )? IDENTIFIER ( typeArguments )? classCreatorRest ;
    public final void innerCreator() throws RecognitionException {
        int innerCreator_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 98) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:943:5: ( '.' 'new' ( nonWildcardTypeArguments )? IDENTIFIER ( typeArguments )? classCreatorRest )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:943:9: '.' 'new' ( nonWildcardTypeArguments )? IDENTIFIER ( typeArguments )? classCreatorRest
            {
            match(input,DOT,FOLLOW_DOT_in_innerCreator7612); if (state.failed) return ;

            match(input,NEW,FOLLOW_NEW_in_innerCreator7614); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:944:9: ( nonWildcardTypeArguments )?
            int alt155=2;
            int LA155_0 = input.LA(1);

            if ( (LA155_0==LT) ) {
                alt155=1;
            }
            switch (alt155) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:944:10: nonWildcardTypeArguments
                    {
                    pushFollow(FOLLOW_nonWildcardTypeArguments_in_innerCreator7625);
                    nonWildcardTypeArguments();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_innerCreator7646); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:947:9: ( typeArguments )?
            int alt156=2;
            int LA156_0 = input.LA(1);

            if ( (LA156_0==LT) ) {
                alt156=1;
            }
            switch (alt156) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:947:10: typeArguments
                    {
                    pushFollow(FOLLOW_typeArguments_in_innerCreator7657);
                    typeArguments();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            pushFollow(FOLLOW_classCreatorRest_in_innerCreator7678);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:953:1: classCreatorRest : arguments ( classBody )? ;
    public final void classCreatorRest() throws RecognitionException {
        int classCreatorRest_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 99) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:954:5: ( arguments ( classBody )? )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:954:9: arguments ( classBody )?
            {
            pushFollow(FOLLOW_arguments_in_classCreatorRest7699);
            arguments();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:955:9: ( classBody )?
            int alt157=2;
            int LA157_0 = input.LA(1);

            if ( (LA157_0==LBRACE) ) {
                alt157=1;
            }
            switch (alt157) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:955:10: classBody
                    {
                    pushFollow(FOLLOW_classBody_in_classCreatorRest7710);
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:960:1: nonWildcardTypeArguments : '<' typeList '>' ;
    public final void nonWildcardTypeArguments() throws RecognitionException {
        int nonWildcardTypeArguments_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 100) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:961:5: ( '<' typeList '>' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:961:9: '<' typeList '>'
            {
            match(input,LT,FOLLOW_LT_in_nonWildcardTypeArguments7742); if (state.failed) return ;

            pushFollow(FOLLOW_typeList_in_nonWildcardTypeArguments7744);
            typeList();

            state._fsp--;
            if (state.failed) return ;

            match(input,GT,FOLLOW_GT_in_nonWildcardTypeArguments7754); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:965:1: arguments : '(' ( expressionList )? ')' ;
    public final void arguments() throws RecognitionException {
        int arguments_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 101) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:966:5: ( '(' ( expressionList )? ')' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:966:9: '(' ( expressionList )? ')'
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_arguments7774); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:966:13: ( expressionList )?
            int alt158=2;
            int LA158_0 = input.LA(1);

            if ( (LA158_0==BANG||LA158_0==BOOLEAN||LA158_0==BYTE||(LA158_0 >= CHAR && LA158_0 <= CHARLITERAL)||(LA158_0 >= DOUBLE && LA158_0 <= DOUBLELITERAL)||LA158_0==FALSE||(LA158_0 >= FLOAT && LA158_0 <= FLOATLITERAL)||LA158_0==IDENTIFIER||LA158_0==INT||LA158_0==INTLITERAL||(LA158_0 >= LONG && LA158_0 <= LPAREN)||(LA158_0 >= NEW && LA158_0 <= NULL)||LA158_0==PLUS||LA158_0==PLUSPLUS||LA158_0==SHORT||(LA158_0 >= STRINGLITERAL && LA158_0 <= SUB)||(LA158_0 >= SUBSUB && LA158_0 <= SUPER)||LA158_0==THIS||LA158_0==TILDE||LA158_0==TRUE||LA158_0==VOID) ) {
                alt158=1;
            }
            switch (alt158) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:966:14: expressionList
                    {
                    pushFollow(FOLLOW_expressionList_in_arguments7777);
                    expressionList();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            match(input,RPAREN,FOLLOW_RPAREN_in_arguments7790); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:970:1: literal : ( INTLITERAL | LONGLITERAL | FLOATLITERAL | DOUBLELITERAL | CHARLITERAL | STRINGLITERAL | TRUE | FALSE | NULL );
    public final void literal() throws RecognitionException {
        int literal_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 102) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:971:5: ( INTLITERAL | LONGLITERAL | FLOATLITERAL | DOUBLELITERAL | CHARLITERAL | STRINGLITERAL | TRUE | FALSE | NULL )
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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:986:1: classHeader : modifiers 'class' IDENTIFIER ;
    public final void classHeader() throws RecognitionException {
        int classHeader_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 103) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:987:5: ( modifiers 'class' IDENTIFIER )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:987:9: modifiers 'class' IDENTIFIER
            {
            pushFollow(FOLLOW_modifiers_in_classHeader7914);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            match(input,CLASS,FOLLOW_CLASS_in_classHeader7916); if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_classHeader7918); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:990:1: enumHeader : modifiers ( 'enum' | IDENTIFIER ) IDENTIFIER ;
    public final void enumHeader() throws RecognitionException {
        int enumHeader_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 104) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:991:5: ( modifiers ( 'enum' | IDENTIFIER ) IDENTIFIER )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:991:9: modifiers ( 'enum' | IDENTIFIER ) IDENTIFIER
            {
            pushFollow(FOLLOW_modifiers_in_enumHeader7938);
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


            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enumHeader7946); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:994:1: interfaceHeader : modifiers 'interface' IDENTIFIER ;
    public final void interfaceHeader() throws RecognitionException {
        int interfaceHeader_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 105) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:995:5: ( modifiers 'interface' IDENTIFIER )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:995:9: modifiers 'interface' IDENTIFIER
            {
            pushFollow(FOLLOW_modifiers_in_interfaceHeader7966);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            match(input,INTERFACE,FOLLOW_INTERFACE_in_interfaceHeader7968); if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_interfaceHeader7970); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:998:1: annotationHeader : modifiers '@' 'interface' IDENTIFIER ;
    public final void annotationHeader() throws RecognitionException {
        int annotationHeader_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 106) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:999:5: ( modifiers '@' 'interface' IDENTIFIER )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:999:9: modifiers '@' 'interface' IDENTIFIER
            {
            pushFollow(FOLLOW_modifiers_in_annotationHeader7990);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            match(input,MONKEYS_AT,FOLLOW_MONKEYS_AT_in_annotationHeader7992); if (state.failed) return ;

            match(input,INTERFACE,FOLLOW_INTERFACE_in_annotationHeader7994); if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_annotationHeader7996); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1002:1: typeHeader : modifiers ( 'class' | 'enum' | ( ( '@' )? 'interface' ) ) IDENTIFIER ;
    public final void typeHeader() throws RecognitionException {
        int typeHeader_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 107) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1003:5: ( modifiers ( 'class' | 'enum' | ( ( '@' )? 'interface' ) ) IDENTIFIER )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1003:9: modifiers ( 'class' | 'enum' | ( ( '@' )? 'interface' ) ) IDENTIFIER
            {
            pushFollow(FOLLOW_modifiers_in_typeHeader8016);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1003:19: ( 'class' | 'enum' | ( ( '@' )? 'interface' ) )
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1003:20: 'class'
                    {
                    match(input,CLASS,FOLLOW_CLASS_in_typeHeader8019); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1003:28: 'enum'
                    {
                    match(input,ENUM,FOLLOW_ENUM_in_typeHeader8021); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1003:35: ( ( '@' )? 'interface' )
                    {
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1003:35: ( ( '@' )? 'interface' )
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1003:36: ( '@' )? 'interface'
                    {
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1003:36: ( '@' )?
                    int alt159=2;
                    int LA159_0 = input.LA(1);

                    if ( (LA159_0==MONKEYS_AT) ) {
                        alt159=1;
                    }
                    switch (alt159) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1003:36: '@'
                            {
                            match(input,MONKEYS_AT,FOLLOW_MONKEYS_AT_in_typeHeader8024); if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,INTERFACE,FOLLOW_INTERFACE_in_typeHeader8028); if (state.failed) return ;

                    }


                    }
                    break;

            }


            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_typeHeader8032); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1006:1: methodHeader : modifiers ( typeParameters )? ( type | 'void' )? IDENTIFIER '(' ;
    public final void methodHeader() throws RecognitionException {
        int methodHeader_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 108) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1007:5: ( modifiers ( typeParameters )? ( type | 'void' )? IDENTIFIER '(' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1007:9: modifiers ( typeParameters )? ( type | 'void' )? IDENTIFIER '('
            {
            pushFollow(FOLLOW_modifiers_in_methodHeader8052);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1007:19: ( typeParameters )?
            int alt161=2;
            int LA161_0 = input.LA(1);

            if ( (LA161_0==LT) ) {
                alt161=1;
            }
            switch (alt161) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1007:19: typeParameters
                    {
                    pushFollow(FOLLOW_typeParameters_in_methodHeader8054);
                    typeParameters();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1007:35: ( type | 'void' )?
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
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1007:36: type
                    {
                    pushFollow(FOLLOW_type_in_methodHeader8058);
                    type();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1007:41: 'void'
                    {
                    match(input,VOID,FOLLOW_VOID_in_methodHeader8060); if (state.failed) return ;

                    }
                    break;

            }


            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_methodHeader8064); if (state.failed) return ;

            match(input,LPAREN,FOLLOW_LPAREN_in_methodHeader8066); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1010:1: fieldHeader : modifiers type IDENTIFIER ( '[' ']' )* ( '=' | ',' | ';' ) ;
    public final void fieldHeader() throws RecognitionException {
        int fieldHeader_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 109) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1011:5: ( modifiers type IDENTIFIER ( '[' ']' )* ( '=' | ',' | ';' ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1011:9: modifiers type IDENTIFIER ( '[' ']' )* ( '=' | ',' | ';' )
            {
            pushFollow(FOLLOW_modifiers_in_fieldHeader8086);
            modifiers();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_type_in_fieldHeader8088);
            type();

            state._fsp--;
            if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_fieldHeader8090); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1011:35: ( '[' ']' )*
            loop163:
            do {
                int alt163=2;
                int LA163_0 = input.LA(1);

                if ( (LA163_0==LBRACKET) ) {
                    alt163=1;
                }


                switch (alt163) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1011:36: '[' ']'
            	    {
            	    match(input,LBRACKET,FOLLOW_LBRACKET_in_fieldHeader8093); if (state.failed) return ;

            	    match(input,RBRACKET,FOLLOW_RBRACKET_in_fieldHeader8094); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1014:1: localVariableHeader : variableModifiers type IDENTIFIER ( '[' ']' )* ( '=' | ',' | ';' ) ;
    public final void localVariableHeader() throws RecognitionException {
        int localVariableHeader_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 110) ) { return ; }

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1015:5: ( variableModifiers type IDENTIFIER ( '[' ']' )* ( '=' | ',' | ';' ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1015:9: variableModifiers type IDENTIFIER ( '[' ']' )* ( '=' | ',' | ';' )
            {
            pushFollow(FOLLOW_variableModifiers_in_localVariableHeader8124);
            variableModifiers();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_type_in_localVariableHeader8126);
            type();

            state._fsp--;
            if (state.failed) return ;

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_localVariableHeader8128); if (state.failed) return ;

            // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1015:43: ( '[' ']' )*
            loop164:
            do {
                int alt164=2;
                int LA164_0 = input.LA(1);

                if ( (LA164_0==LBRACKET) ) {
                    alt164=1;
                }


                switch (alt164) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:1015:44: '[' ']'
            	    {
            	    match(input,LBRACKET,FOLLOW_LBRACKET_in_localVariableHeader8131); if (state.failed) return ;

            	    match(input,RBRACKET,FOLLOW_RBRACKET_in_localVariableHeader8132); if (state.failed) return ;

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
        pushFollow(FOLLOW_classDeclaration_in_synpred12_RJavaSymbolTable462);
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
        pushFollow(FOLLOW_normalClassDeclaration_in_synpred27_RJavaSymbolTable699);
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
        pushFollow(FOLLOW_normalInterfaceDeclaration_in_synpred43_RJavaSymbolTable1378);
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
        pushFollow(FOLLOW_fieldDeclaration_in_synpred52_RJavaSymbolTable1741);
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
        pushFollow(FOLLOW_methodDeclaration_in_synpred53_RJavaSymbolTable1752);
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
        pushFollow(FOLLOW_classDeclaration_in_synpred54_RJavaSymbolTable1763);
        classDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred54_RJavaSymbolTable

    // $ANTLR start synpred57_RJavaSymbolTable
    public final void synpred57_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:254:10: ( explicitConstructorInvocation )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:254:10: explicitConstructorInvocation
        {
        pushFollow(FOLLOW_explicitConstructorInvocation_in_synpred57_RJavaSymbolTable1900);
        explicitConstructorInvocation();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred57_RJavaSymbolTable

    // $ANTLR start synpred59_RJavaSymbolTable
    public final void synpred59_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:246:10: ( modifiers ( typeParameters )? IDENTIFIER formalParameters ( 'throws' qualifiedNameList )? '{' ( explicitConstructorInvocation )? ( blockStatement )* '}' )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:246:10: modifiers ( typeParameters )? IDENTIFIER formalParameters ( 'throws' qualifiedNameList )? '{' ( explicitConstructorInvocation )? ( blockStatement )* '}'
        {
        pushFollow(FOLLOW_modifiers_in_synpred59_RJavaSymbolTable1812);
        modifiers();

        state._fsp--;
        if (state.failed) return ;

        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:247:9: ( typeParameters )?
        int alt167=2;
        int LA167_0 = input.LA(1);

        if ( (LA167_0==LT) ) {
            alt167=1;
        }
        switch (alt167) {
            case 1 :
                // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:247:10: typeParameters
                {
                pushFollow(FOLLOW_typeParameters_in_synpred59_RJavaSymbolTable1823);
                typeParameters();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred59_RJavaSymbolTable1844); if (state.failed) return ;

        pushFollow(FOLLOW_formalParameters_in_synpred59_RJavaSymbolTable1854);
        formalParameters();

        state._fsp--;
        if (state.failed) return ;

        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:251:9: ( 'throws' qualifiedNameList )?
        int alt168=2;
        int LA168_0 = input.LA(1);

        if ( (LA168_0==THROWS) ) {
            alt168=1;
        }
        switch (alt168) {
            case 1 :
                // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:251:10: 'throws' qualifiedNameList
                {
                match(input,THROWS,FOLLOW_THROWS_in_synpred59_RJavaSymbolTable1865); if (state.failed) return ;

                pushFollow(FOLLOW_qualifiedNameList_in_synpred59_RJavaSymbolTable1867);
                qualifiedNameList();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        match(input,LBRACE,FOLLOW_LBRACE_in_synpred59_RJavaSymbolTable1888); if (state.failed) return ;

        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:254:9: ( explicitConstructorInvocation )?
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
                // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:254:10: explicitConstructorInvocation
                {
                pushFollow(FOLLOW_explicitConstructorInvocation_in_synpred59_RJavaSymbolTable1900);
                explicitConstructorInvocation();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:256:9: ( blockStatement )*
        loop170:
        do {
            int alt170=2;
            int LA170_0 = input.LA(1);

            if ( (LA170_0==ABSTRACT||(LA170_0 >= ASSERT && LA170_0 <= BANG)||(LA170_0 >= BOOLEAN && LA170_0 <= BYTE)||(LA170_0 >= CHAR && LA170_0 <= CLASS)||LA170_0==CONTINUE||LA170_0==DO||(LA170_0 >= DOUBLE && LA170_0 <= DOUBLELITERAL)||LA170_0==ENUM||(LA170_0 >= FALSE && LA170_0 <= FINAL)||(LA170_0 >= FLOAT && LA170_0 <= FOR)||(LA170_0 >= IDENTIFIER && LA170_0 <= IF)||(LA170_0 >= INT && LA170_0 <= INTLITERAL)||LA170_0==LBRACE||(LA170_0 >= LONG && LA170_0 <= LT)||(LA170_0 >= MONKEYS_AT && LA170_0 <= NULL)||LA170_0==PLUS||(LA170_0 >= PLUSPLUS && LA170_0 <= PUBLIC)||LA170_0==RETURN||(LA170_0 >= SEMI && LA170_0 <= SHORT)||(LA170_0 >= STATIC && LA170_0 <= SUB)||(LA170_0 >= SUBSUB && LA170_0 <= SYNCHRONIZED)||(LA170_0 >= THIS && LA170_0 <= THROW)||(LA170_0 >= TILDE && LA170_0 <= WHILE)) ) {
                alt170=1;
            }


            switch (alt170) {
        	case 1 :
        	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:256:10: blockStatement
        	    {
        	    pushFollow(FOLLOW_blockStatement_in_synpred59_RJavaSymbolTable1922);
        	    blockStatement();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop170;
            }
        } while (true);


        match(input,RBRACE,FOLLOW_RBRACE_in_synpred59_RJavaSymbolTable1943); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred59_RJavaSymbolTable

    // $ANTLR start synpred68_RJavaSymbolTable
    public final void synpred68_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:305:9: ( interfaceFieldDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:305:9: interfaceFieldDeclaration
        {
        pushFollow(FOLLOW_interfaceFieldDeclaration_in_synpred68_RJavaSymbolTable2342);
        interfaceFieldDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred68_RJavaSymbolTable

    // $ANTLR start synpred69_RJavaSymbolTable
    public final void synpred69_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:306:9: ( interfaceMethodDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:306:9: interfaceMethodDeclaration
        {
        pushFollow(FOLLOW_interfaceMethodDeclaration_in_synpred69_RJavaSymbolTable2352);
        interfaceMethodDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred69_RJavaSymbolTable

    // $ANTLR start synpred70_RJavaSymbolTable
    public final void synpred70_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:307:9: ( interfaceDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:307:9: interfaceDeclaration
        {
        pushFollow(FOLLOW_interfaceDeclaration_in_synpred70_RJavaSymbolTable2362);
        interfaceDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred70_RJavaSymbolTable

    // $ANTLR start synpred71_RJavaSymbolTable
    public final void synpred71_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:308:9: ( classDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:308:9: classDeclaration
        {
        pushFollow(FOLLOW_classDeclaration_in_synpred71_RJavaSymbolTable2372);
        classDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred71_RJavaSymbolTable

    // $ANTLR start synpred96_RJavaSymbolTable
    public final void synpred96_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:403:9: ( ellipsisParameterDecl )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:403:9: ellipsisParameterDecl
        {
        pushFollow(FOLLOW_ellipsisParameterDecl_in_synpred96_RJavaSymbolTable3136);
        ellipsisParameterDecl();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred96_RJavaSymbolTable

    // $ANTLR start synpred98_RJavaSymbolTable
    public final void synpred98_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:404:9: ( normalParameterDecl ( ',' normalParameterDecl )* )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:404:9: normalParameterDecl ( ',' normalParameterDecl )*
        {
        pushFollow(FOLLOW_normalParameterDecl_in_synpred98_RJavaSymbolTable3146);
        normalParameterDecl();

        state._fsp--;
        if (state.failed) return ;

        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:405:9: ( ',' normalParameterDecl )*
        loop173:
        do {
            int alt173=2;
            int LA173_0 = input.LA(1);

            if ( (LA173_0==COMMA) ) {
                alt173=1;
            }


            switch (alt173) {
        	case 1 :
        	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:405:10: ',' normalParameterDecl
        	    {
        	    match(input,COMMA,FOLLOW_COMMA_in_synpred98_RJavaSymbolTable3157); if (state.failed) return ;

        	    pushFollow(FOLLOW_normalParameterDecl_in_synpred98_RJavaSymbolTable3159);
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
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:407:10: ( normalParameterDecl ',' )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:407:10: normalParameterDecl ','
        {
        pushFollow(FOLLOW_normalParameterDecl_in_synpred99_RJavaSymbolTable3181);
        normalParameterDecl();

        state._fsp--;
        if (state.failed) return ;

        match(input,COMMA,FOLLOW_COMMA_in_synpred99_RJavaSymbolTable3191); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred99_RJavaSymbolTable

    // $ANTLR start synpred103_RJavaSymbolTable
    public final void synpred103_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:427:9: ( ( nonWildcardTypeArguments )? ( 'this' | 'super' ) arguments ';' )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:427:9: ( nonWildcardTypeArguments )? ( 'this' | 'super' ) arguments ';'
        {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:427:9: ( nonWildcardTypeArguments )?
        int alt174=2;
        int LA174_0 = input.LA(1);

        if ( (LA174_0==LT) ) {
            alt174=1;
        }
        switch (alt174) {
            case 1 :
                // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:427:10: nonWildcardTypeArguments
                {
                pushFollow(FOLLOW_nonWildcardTypeArguments_in_synpred103_RJavaSymbolTable3326);
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


        pushFollow(FOLLOW_arguments_in_synpred103_RJavaSymbolTable3384);
        arguments();

        state._fsp--;
        if (state.failed) return ;

        match(input,SEMI,FOLLOW_SEMI_in_synpred103_RJavaSymbolTable3386); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred103_RJavaSymbolTable

    // $ANTLR start synpred117_RJavaSymbolTable
    public final void synpred117_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:514:9: ( annotationMethodDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:514:9: annotationMethodDeclaration
        {
        pushFollow(FOLLOW_annotationMethodDeclaration_in_synpred117_RJavaSymbolTable3985);
        annotationMethodDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred117_RJavaSymbolTable

    // $ANTLR start synpred118_RJavaSymbolTable
    public final void synpred118_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:515:9: ( interfaceFieldDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:515:9: interfaceFieldDeclaration
        {
        pushFollow(FOLLOW_interfaceFieldDeclaration_in_synpred118_RJavaSymbolTable3995);
        interfaceFieldDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred118_RJavaSymbolTable

    // $ANTLR start synpred119_RJavaSymbolTable
    public final void synpred119_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:516:9: ( normalClassDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:516:9: normalClassDeclaration
        {
        pushFollow(FOLLOW_normalClassDeclaration_in_synpred119_RJavaSymbolTable4005);
        normalClassDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred119_RJavaSymbolTable

    // $ANTLR start synpred120_RJavaSymbolTable
    public final void synpred120_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:517:9: ( normalInterfaceDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:517:9: normalInterfaceDeclaration
        {
        pushFollow(FOLLOW_normalInterfaceDeclaration_in_synpred120_RJavaSymbolTable4015);
        normalInterfaceDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred120_RJavaSymbolTable

    // $ANTLR start synpred121_RJavaSymbolTable
    public final void synpred121_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:518:9: ( enumDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:518:9: enumDeclaration
        {
        pushFollow(FOLLOW_enumDeclaration_in_synpred121_RJavaSymbolTable4025);
        enumDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred121_RJavaSymbolTable

    // $ANTLR start synpred122_RJavaSymbolTable
    public final void synpred122_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:519:9: ( annotationTypeDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:519:9: annotationTypeDeclaration
        {
        pushFollow(FOLLOW_annotationTypeDeclaration_in_synpred122_RJavaSymbolTable4035);
        annotationTypeDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred122_RJavaSymbolTable

    // $ANTLR start synpred125_RJavaSymbolTable
    public final void synpred125_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:562:9: ( localVariableDeclarationStatement )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:562:9: localVariableDeclarationStatement
        {
        pushFollow(FOLLOW_localVariableDeclarationStatement_in_synpred125_RJavaSymbolTable4193);
        localVariableDeclarationStatement();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred125_RJavaSymbolTable

    // $ANTLR start synpred126_RJavaSymbolTable
    public final void synpred126_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:563:9: ( classOrInterfaceDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:563:9: classOrInterfaceDeclaration
        {
        pushFollow(FOLLOW_classOrInterfaceDeclaration_in_synpred126_RJavaSymbolTable4203);
        classOrInterfaceDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred126_RJavaSymbolTable

    // $ANTLR start synpred130_RJavaSymbolTable
    public final void synpred130_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:583:9: ( ( 'assert' ) expression ( ':' expression )? ';' )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:583:9: ( 'assert' ) expression ( ':' expression )? ';'
        {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:583:9: ( 'assert' )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:583:10: 'assert'
        {
        match(input,ASSERT,FOLLOW_ASSERT_in_synpred130_RJavaSymbolTable4346); if (state.failed) return ;

        }


        pushFollow(FOLLOW_expression_in_synpred130_RJavaSymbolTable4366);
        expression();

        state._fsp--;
        if (state.failed) return ;

        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:585:20: ( ':' expression )?
        int alt177=2;
        int LA177_0 = input.LA(1);

        if ( (LA177_0==COLON) ) {
            alt177=1;
        }
        switch (alt177) {
            case 1 :
                // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:585:21: ':' expression
                {
                match(input,COLON,FOLLOW_COLON_in_synpred130_RJavaSymbolTable4369); if (state.failed) return ;

                pushFollow(FOLLOW_expression_in_synpred130_RJavaSymbolTable4371);
                expression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        match(input,SEMI,FOLLOW_SEMI_in_synpred130_RJavaSymbolTable4375); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred130_RJavaSymbolTable

    // $ANTLR start synpred132_RJavaSymbolTable
    public final void synpred132_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:586:9: ( 'assert' expression ( ':' expression )? ';' )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:586:9: 'assert' expression ( ':' expression )? ';'
        {
        match(input,ASSERT,FOLLOW_ASSERT_in_synpred132_RJavaSymbolTable4385); if (state.failed) return ;

        pushFollow(FOLLOW_expression_in_synpred132_RJavaSymbolTable4388);
        expression();

        state._fsp--;
        if (state.failed) return ;

        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:586:30: ( ':' expression )?
        int alt178=2;
        int LA178_0 = input.LA(1);

        if ( (LA178_0==COLON) ) {
            alt178=1;
        }
        switch (alt178) {
            case 1 :
                // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:586:31: ':' expression
                {
                match(input,COLON,FOLLOW_COLON_in_synpred132_RJavaSymbolTable4391); if (state.failed) return ;

                pushFollow(FOLLOW_expression_in_synpred132_RJavaSymbolTable4393);
                expression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        match(input,SEMI,FOLLOW_SEMI_in_synpred132_RJavaSymbolTable4397); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred132_RJavaSymbolTable

    // $ANTLR start synpred133_RJavaSymbolTable
    public final void synpred133_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:587:39: ( 'else' statement )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:587:39: 'else' statement
        {
        match(input,ELSE,FOLLOW_ELSE_in_synpred133_RJavaSymbolTable4426); if (state.failed) return ;

        pushFollow(FOLLOW_statement_in_synpred133_RJavaSymbolTable4428);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred133_RJavaSymbolTable

    // $ANTLR start synpred148_RJavaSymbolTable
    public final void synpred148_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:602:9: ( expression ';' )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:602:9: expression ';'
        {
        pushFollow(FOLLOW_expression_in_synpred148_RJavaSymbolTable4650);
        expression();

        state._fsp--;
        if (state.failed) return ;

        match(input,SEMI,FOLLOW_SEMI_in_synpred148_RJavaSymbolTable4653); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred148_RJavaSymbolTable

    // $ANTLR start synpred149_RJavaSymbolTable
    public final void synpred149_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:603:9: ( IDENTIFIER ':' statement )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:603:9: IDENTIFIER ':' statement
        {
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred149_RJavaSymbolTable4668); if (state.failed) return ;

        match(input,COLON,FOLLOW_COLON_in_synpred149_RJavaSymbolTable4670); if (state.failed) return ;

        pushFollow(FOLLOW_statement_in_synpred149_RJavaSymbolTable4672);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred149_RJavaSymbolTable

    // $ANTLR start synpred153_RJavaSymbolTable
    public final void synpred153_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:627:13: ( catches 'finally' block )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:627:13: catches 'finally' block
        {
        pushFollow(FOLLOW_catches_in_synpred153_RJavaSymbolTable4828);
        catches();

        state._fsp--;
        if (state.failed) return ;

        match(input,FINALLY,FOLLOW_FINALLY_in_synpred153_RJavaSymbolTable4830); if (state.failed) return ;

        pushFollow(FOLLOW_block_in_synpred153_RJavaSymbolTable4832);
        block();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred153_RJavaSymbolTable

    // $ANTLR start synpred154_RJavaSymbolTable
    public final void synpred154_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:628:13: ( catches )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:628:13: catches
        {
        pushFollow(FOLLOW_catches_in_synpred154_RJavaSymbolTable4846);
        catches();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred154_RJavaSymbolTable

    // $ANTLR start synpred157_RJavaSymbolTable
    public final void synpred157_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:653:9: ( 'for' '(' variableModifiers type IDENTIFIER ':' expression ')' statement )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:653:9: 'for' '(' variableModifiers type IDENTIFIER ':' expression ')' statement
        {
        match(input,FOR,FOLLOW_FOR_in_synpred157_RJavaSymbolTable5038); if (state.failed) return ;

        match(input,LPAREN,FOLLOW_LPAREN_in_synpred157_RJavaSymbolTable5040); if (state.failed) return ;

        pushFollow(FOLLOW_variableModifiers_in_synpred157_RJavaSymbolTable5042);
        variableModifiers();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_type_in_synpred157_RJavaSymbolTable5044);
        type();

        state._fsp--;
        if (state.failed) return ;

        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred157_RJavaSymbolTable5046); if (state.failed) return ;

        match(input,COLON,FOLLOW_COLON_in_synpred157_RJavaSymbolTable5048); if (state.failed) return ;

        pushFollow(FOLLOW_expression_in_synpred157_RJavaSymbolTable5059);
        expression();

        state._fsp--;
        if (state.failed) return ;

        match(input,RPAREN,FOLLOW_RPAREN_in_synpred157_RJavaSymbolTable5061); if (state.failed) return ;

        pushFollow(FOLLOW_statement_in_synpred157_RJavaSymbolTable5063);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred157_RJavaSymbolTable

    // $ANTLR start synpred161_RJavaSymbolTable
    public final void synpred161_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:667:9: ( localVariableDeclaration )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:667:9: localVariableDeclaration
        {
        pushFollow(FOLLOW_localVariableDeclaration_in_synpred161_RJavaSymbolTable5242);
        localVariableDeclaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred161_RJavaSymbolTable

    // $ANTLR start synpred202_RJavaSymbolTable
    public final void synpred202_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:821:9: ( castExpression )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:821:9: castExpression
        {
        pushFollow(FOLLOW_castExpression_in_synpred202_RJavaSymbolTable6487);
        castExpression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred202_RJavaSymbolTable

    // $ANTLR start synpred206_RJavaSymbolTable
    public final void synpred206_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:831:9: ( '(' primitiveType ')' unaryExpression )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:831:9: '(' primitiveType ')' unaryExpression
        {
        match(input,LPAREN,FOLLOW_LPAREN_in_synpred206_RJavaSymbolTable6578); if (state.failed) return ;

        pushFollow(FOLLOW_primitiveType_in_synpred206_RJavaSymbolTable6580);
        primitiveType();

        state._fsp--;
        if (state.failed) return ;

        match(input,RPAREN,FOLLOW_RPAREN_in_synpred206_RJavaSymbolTable6582); if (state.failed) return ;

        pushFollow(FOLLOW_unaryExpression_in_synpred206_RJavaSymbolTable6584);
        unaryExpression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred206_RJavaSymbolTable

    // $ANTLR start synpred208_RJavaSymbolTable
    public final void synpred208_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:841:10: ( '.' IDENTIFIER )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:841:10: '.' IDENTIFIER
        {
        match(input,DOT,FOLLOW_DOT_in_synpred208_RJavaSymbolTable6655); if (state.failed) return ;

        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred208_RJavaSymbolTable6657); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred208_RJavaSymbolTable

    // $ANTLR start synpred209_RJavaSymbolTable
    public final void synpred209_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:843:10: ( identifierSuffix )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:843:10: identifierSuffix
        {
        pushFollow(FOLLOW_identifierSuffix_in_synpred209_RJavaSymbolTable6679);
        identifierSuffix();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred209_RJavaSymbolTable

    // $ANTLR start synpred211_RJavaSymbolTable
    public final void synpred211_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:846:10: ( '.' IDENTIFIER )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:846:10: '.' IDENTIFIER
        {
        match(input,DOT,FOLLOW_DOT_in_synpred211_RJavaSymbolTable6711); if (state.failed) return ;

        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred211_RJavaSymbolTable6713); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred211_RJavaSymbolTable

    // $ANTLR start synpred212_RJavaSymbolTable
    public final void synpred212_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:848:10: ( identifierSuffix )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:848:10: identifierSuffix
        {
        pushFollow(FOLLOW_identifierSuffix_in_synpred212_RJavaSymbolTable6735);
        identifierSuffix();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred212_RJavaSymbolTable

    // $ANTLR start synpred224_RJavaSymbolTable
    public final void synpred224_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:876:10: ( '[' expression ']' )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:876:10: '[' expression ']'
        {
        match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred224_RJavaSymbolTable6986); if (state.failed) return ;

        pushFollow(FOLLOW_expression_in_synpred224_RJavaSymbolTable6988);
        expression();

        state._fsp--;
        if (state.failed) return ;

        match(input,RBRACKET,FOLLOW_RBRACKET_in_synpred224_RJavaSymbolTable6990); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred224_RJavaSymbolTable

    // $ANTLR start synpred236_RJavaSymbolTable
    public final void synpred236_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:899:9: ( 'new' nonWildcardTypeArguments classOrInterfaceType classCreatorRest )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:899:9: 'new' nonWildcardTypeArguments classOrInterfaceType classCreatorRest
        {
        match(input,NEW,FOLLOW_NEW_in_synpred236_RJavaSymbolTable7199); if (state.failed) return ;

        pushFollow(FOLLOW_nonWildcardTypeArguments_in_synpred236_RJavaSymbolTable7201);
        nonWildcardTypeArguments();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_classOrInterfaceType_in_synpred236_RJavaSymbolTable7203);
        classOrInterfaceType();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_classCreatorRest_in_synpred236_RJavaSymbolTable7205);
        classCreatorRest();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred236_RJavaSymbolTable

    // $ANTLR start synpred237_RJavaSymbolTable
    public final void synpred237_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:900:9: ( 'new' classOrInterfaceType classCreatorRest )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:900:9: 'new' classOrInterfaceType classCreatorRest
        {
        match(input,NEW,FOLLOW_NEW_in_synpred237_RJavaSymbolTable7215); if (state.failed) return ;

        pushFollow(FOLLOW_classOrInterfaceType_in_synpred237_RJavaSymbolTable7217);
        classOrInterfaceType();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_classCreatorRest_in_synpred237_RJavaSymbolTable7219);
        classCreatorRest();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred237_RJavaSymbolTable

    // $ANTLR start synpred239_RJavaSymbolTable
    public final void synpred239_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:905:9: ( 'new' createdName '[' ']' ( '[' ']' )* arrayInitializer )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:905:9: 'new' createdName '[' ']' ( '[' ']' )* arrayInitializer
        {
        match(input,NEW,FOLLOW_NEW_in_synpred239_RJavaSymbolTable7249); if (state.failed) return ;

        pushFollow(FOLLOW_createdName_in_synpred239_RJavaSymbolTable7251);
        createdName();

        state._fsp--;
        if (state.failed) return ;

        match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred239_RJavaSymbolTable7261); if (state.failed) return ;

        match(input,RBRACKET,FOLLOW_RBRACKET_in_synpred239_RJavaSymbolTable7263); if (state.failed) return ;

        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:907:9: ( '[' ']' )*
        loop191:
        do {
            int alt191=2;
            int LA191_0 = input.LA(1);

            if ( (LA191_0==LBRACKET) ) {
                alt191=1;
            }


            switch (alt191) {
        	case 1 :
        	    // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:907:10: '[' ']'
        	    {
        	    match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred239_RJavaSymbolTable7274); if (state.failed) return ;

        	    match(input,RBRACKET,FOLLOW_RBRACKET_in_synpred239_RJavaSymbolTable7276); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop191;
            }
        } while (true);


        pushFollow(FOLLOW_arrayInitializer_in_synpred239_RJavaSymbolTable7297);
        arrayInitializer();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred239_RJavaSymbolTable

    // $ANTLR start synpred240_RJavaSymbolTable
    public final void synpred240_RJavaSymbolTable_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:914:13: ( '[' expression ']' )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/antlr/org/rjava/compiler/semantics/symtab/RJavaSymbolTable.g:914:13: '[' expression ']'
        {
        match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred240_RJavaSymbolTable7346); if (state.failed) return ;

        pushFollow(FOLLOW_expression_in_synpred240_RJavaSymbolTable7348);
        expression();

        state._fsp--;
        if (state.failed) return ;

        match(input,RBRACKET,FOLLOW_RBRACKET_in_synpred240_RJavaSymbolTable7362); if (state.failed) return ;

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
    public static final BitSet FOLLOW_typeDeclaration_in_compilationUnit148 = new BitSet(new long[]{0x1000102000800012L,0x0011040C10700600L});
    public static final BitSet FOLLOW_PACKAGE_in_packageDeclaration179 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_qualifiedName_in_packageDeclaration181 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_packageDeclaration191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_importDeclaration212 = new BitSet(new long[]{0x0040000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_STATIC_in_importDeclaration224 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_importDeclaration245 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_DOT_in_importDeclaration247 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_STAR_in_importDeclaration249 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_importDeclaration259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_importDeclaration276 = new BitSet(new long[]{0x0040000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_STATIC_in_importDeclaration288 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_importDeclaration309 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_DOT_in_importDeclaration320 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_importDeclaration322 = new BitSet(new long[]{0x0000000080000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_DOT_in_importDeclaration344 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_STAR_in_importDeclaration346 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_importDeclaration367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_qualifiedImportName387 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_DOT_in_qualifiedImportName398 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_qualifiedImportName400 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_classOrInterfaceDeclaration_in_typeDeclaration431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_typeDeclaration441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classDeclaration_in_classOrInterfaceDeclaration462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceDeclaration_in_classOrInterfaceDeclaration472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_modifiers507 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_PUBLIC_in_modifiers517 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_PROTECTED_in_modifiers527 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_PRIVATE_in_modifiers537 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_STATIC_in_modifiers547 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_ABSTRACT_in_modifiers557 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_FINAL_in_modifiers567 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_NATIVE_in_modifiers577 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_SYNCHRONIZED_in_modifiers587 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_TRANSIENT_in_modifiers597 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_VOLATILE_in_modifiers607 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_STRICTFP_in_modifiers617 = new BitSet(new long[]{0x0000100000000012L,0x0011040C00700600L});
    public static final BitSet FOLLOW_FINAL_in_variableModifiers649 = new BitSet(new long[]{0x0000100000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_annotation_in_variableModifiers663 = new BitSet(new long[]{0x0000100000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_normalClassDeclaration_in_classDeclaration699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumDeclaration_in_classDeclaration709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_normalClassDeclaration729 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_CLASS_in_normalClassDeclaration732 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_normalClassDeclaration734 = new BitSet(new long[]{0x0100010000000000L,0x0000000000000082L});
    public static final BitSet FOLLOW_typeParameters_in_normalClassDeclaration745 = new BitSet(new long[]{0x0100010000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_EXTENDS_in_normalClassDeclaration767 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_normalClassDeclaration769 = new BitSet(new long[]{0x0100000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_IMPLEMENTS_in_normalClassDeclaration791 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_typeList_in_normalClassDeclaration793 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_classBody_in_normalClassDeclaration826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_typeParameters847 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_typeParameter_in_typeParameters861 = new BitSet(new long[]{0x0008000002000000L});
    public static final BitSet FOLLOW_COMMA_in_typeParameters876 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_typeParameter_in_typeParameters878 = new BitSet(new long[]{0x0008000002000000L});
    public static final BitSet FOLLOW_GT_in_typeParameters903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_typeParameter923 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_EXTENDS_in_typeParameter934 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_typeBound_in_typeParameter936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typeBound968 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_AMP_in_typeBound979 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_typeBound981 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_modifiers_in_enumDeclaration1013 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_ENUM_in_enumDeclaration1025 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_enumDeclaration1046 = new BitSet(new long[]{0x0100000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_IMPLEMENTS_in_enumDeclaration1057 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_typeList_in_enumDeclaration1059 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_enumBody_in_enumDeclaration1080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_enumBody1105 = new BitSet(new long[]{0x0040000002000000L,0x0000000011000200L});
    public static final BitSet FOLLOW_enumConstants_in_enumBody1116 = new BitSet(new long[]{0x0000000002000000L,0x0000000011000000L});
    public static final BitSet FOLLOW_COMMA_in_enumBody1138 = new BitSet(new long[]{0x0000000000000000L,0x0000000011000000L});
    public static final BitSet FOLLOW_enumBodyDeclarations_in_enumBody1151 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_RBRACE_in_enumBody1173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumConstant_in_enumConstants1193 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_enumConstants1204 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_enumConstant_in_enumConstants1206 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_annotations_in_enumConstant1240 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_enumConstant1261 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000042L});
    public static final BitSet FOLLOW_arguments_in_enumConstant1272 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_classBody_in_enumConstant1294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_enumBodyDeclarations1335 = new BitSet(new long[]{0x1840502100A14012L,0x0019040C30700692L});
    public static final BitSet FOLLOW_classBodyDeclaration_in_enumBodyDeclarations1347 = new BitSet(new long[]{0x1840502100A14012L,0x0019040C30700692L});
    public static final BitSet FOLLOW_normalInterfaceDeclaration_in_interfaceDeclaration1378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeDeclaration_in_interfaceDeclaration1388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_normalInterfaceDeclaration1412 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_INTERFACE_in_normalInterfaceDeclaration1414 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_normalInterfaceDeclaration1416 = new BitSet(new long[]{0x0000010000000000L,0x0000000000000082L});
    public static final BitSet FOLLOW_typeParameters_in_normalInterfaceDeclaration1427 = new BitSet(new long[]{0x0000010000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_EXTENDS_in_normalInterfaceDeclaration1449 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_typeList_in_normalInterfaceDeclaration1451 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceBody_in_normalInterfaceDeclaration1472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typeList1492 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_typeList1503 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_typeList1505 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_LBRACE_in_classBody1536 = new BitSet(new long[]{0x1840502100A14010L,0x0019040C31700692L});
    public static final BitSet FOLLOW_classBodyDeclaration_in_classBody1549 = new BitSet(new long[]{0x1840502100A14010L,0x0019040C31700692L});
    public static final BitSet FOLLOW_RBRACE_in_classBody1571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_interfaceBody1593 = new BitSet(new long[]{0x1840502100A14010L,0x0019040C31700690L});
    public static final BitSet FOLLOW_interfaceBodyDeclaration_in_interfaceBody1605 = new BitSet(new long[]{0x1840502100A14010L,0x0019040C31700690L});
    public static final BitSet FOLLOW_RBRACE_in_interfaceBody1627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_classBodyDeclaration1647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STATIC_in_classBodyDeclaration1657 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_classBodyDeclaration1670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_classBodyDeclaration1700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_memberDecl_in_classBodyDeclaration1720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fieldDeclaration_in_memberDecl1741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_methodDeclaration_in_memberDecl1752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classDeclaration_in_memberDecl1763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceDeclaration_in_memberDecl1774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_methodDeclaration1812 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_typeParameters_in_methodDeclaration1823 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_methodDeclaration1844 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_formalParameters_in_methodDeclaration1854 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000002L});
    public static final BitSet FOLLOW_THROWS_in_methodDeclaration1865 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_qualifiedNameList_in_methodDeclaration1867 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_methodDeclaration1888 = new BitSet(new long[]{0x38C1D82350E1C310L,0x003FB7BC357A1EF2L});
    public static final BitSet FOLLOW_explicitConstructorInvocation_in_methodDeclaration1900 = new BitSet(new long[]{0x38C1D82350E1C310L,0x003FB7BC357A1E72L});
    public static final BitSet FOLLOW_blockStatement_in_methodDeclaration1922 = new BitSet(new long[]{0x38C1D82350E1C310L,0x003FB7BC357A1E72L});
    public static final BitSet FOLLOW_RBRACE_in_methodDeclaration1943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_methodDeclaration1953 = new BitSet(new long[]{0x0840400100214000L,0x0008000020000090L});
    public static final BitSet FOLLOW_typeParameters_in_methodDeclaration1964 = new BitSet(new long[]{0x0840400100214000L,0x0008000020000010L});
    public static final BitSet FOLLOW_type_in_methodDeclaration1986 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_VOID_in_methodDeclaration2000 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_methodDeclaration2020 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_formalParameters_in_methodDeclaration2030 = new BitSet(new long[]{0x0000000000000000L,0x0000400010000006L});
    public static final BitSet FOLLOW_LBRACKET_in_methodDeclaration2041 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_methodDeclaration2043 = new BitSet(new long[]{0x0000000000000000L,0x0000400010000006L});
    public static final BitSet FOLLOW_THROWS_in_methodDeclaration2065 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_qualifiedNameList_in_methodDeclaration2067 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000002L});
    public static final BitSet FOLLOW_block_in_methodDeclaration2122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_methodDeclaration2136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_fieldDeclaration2168 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_fieldDeclaration2179 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_variableDeclarator_in_fieldDeclaration2191 = new BitSet(new long[]{0x0000000002000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_COMMA_in_fieldDeclaration2203 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_variableDeclarator_in_fieldDeclaration2205 = new BitSet(new long[]{0x0000000002000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_fieldDeclaration2227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_variableDeclarator2252 = new BitSet(new long[]{0x0000004000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_variableDeclarator2265 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_variableDeclarator2267 = new BitSet(new long[]{0x0000004000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_EQ_in_variableDeclarator2291 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1872L});
    public static final BitSet FOLLOW_variableInitializer_in_variableDeclarator2293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceFieldDeclaration_in_interfaceBodyDeclaration2342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceMethodDeclaration_in_interfaceBodyDeclaration2352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceDeclaration_in_interfaceBodyDeclaration2362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classDeclaration_in_interfaceBodyDeclaration2372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_interfaceBodyDeclaration2382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_interfaceMethodDeclaration2402 = new BitSet(new long[]{0x0840400100214000L,0x0008000020000090L});
    public static final BitSet FOLLOW_typeParameters_in_interfaceMethodDeclaration2413 = new BitSet(new long[]{0x0840400100214000L,0x0008000020000010L});
    public static final BitSet FOLLOW_type_in_interfaceMethodDeclaration2435 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_VOID_in_interfaceMethodDeclaration2446 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_interfaceMethodDeclaration2466 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_formalParameters_in_interfaceMethodDeclaration2476 = new BitSet(new long[]{0x0000000000000000L,0x0000400010000004L});
    public static final BitSet FOLLOW_LBRACKET_in_interfaceMethodDeclaration2487 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_interfaceMethodDeclaration2489 = new BitSet(new long[]{0x0000000000000000L,0x0000400010000004L});
    public static final BitSet FOLLOW_THROWS_in_interfaceMethodDeclaration2511 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_qualifiedNameList_in_interfaceMethodDeclaration2513 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_interfaceMethodDeclaration2526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_interfaceFieldDeclaration2548 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_interfaceFieldDeclaration2550 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_variableDeclarator_in_interfaceFieldDeclaration2552 = new BitSet(new long[]{0x0000000002000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_COMMA_in_interfaceFieldDeclaration2563 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_variableDeclarator_in_interfaceFieldDeclaration2565 = new BitSet(new long[]{0x0000000002000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_interfaceFieldDeclaration2586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_type2607 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_type2618 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_type2620 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_primitiveType_in_type2641 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_type2652 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_type2654 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_classOrInterfaceType2686 = new BitSet(new long[]{0x0000000080000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_typeArguments_in_classOrInterfaceType2697 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_DOT_in_classOrInterfaceType2719 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_classOrInterfaceType2721 = new BitSet(new long[]{0x0000000080000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_typeArguments_in_classOrInterfaceType2736 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_LT_in_typeArguments2873 = new BitSet(new long[]{0x0840400100214000L,0x0000000020800010L});
    public static final BitSet FOLLOW_typeArgument_in_typeArguments2875 = new BitSet(new long[]{0x0008000002000000L});
    public static final BitSet FOLLOW_COMMA_in_typeArguments2886 = new BitSet(new long[]{0x0840400100214000L,0x0000000020800010L});
    public static final BitSet FOLLOW_typeArgument_in_typeArguments2888 = new BitSet(new long[]{0x0008000002000000L});
    public static final BitSet FOLLOW_GT_in_typeArguments2910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_typeArgument2930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUES_in_typeArgument2940 = new BitSet(new long[]{0x0000010000000002L,0x0000010000000000L});
    public static final BitSet FOLLOW_set_in_typeArgument2964 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_typeArgument3008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedName_in_qualifiedNameList3039 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_qualifiedNameList3050 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_qualifiedName_in_qualifiedNameList3052 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_LPAREN_in_formalParameters3083 = new BitSet(new long[]{0x0840500100214000L,0x0000000028000210L});
    public static final BitSet FOLLOW_formalParameterDecls_in_formalParameters3094 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_formalParameters3116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ellipsisParameterDecl_in_formalParameterDecls3136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normalParameterDecl_in_formalParameterDecls3146 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_formalParameterDecls3157 = new BitSet(new long[]{0x0840500100214000L,0x0000000020000210L});
    public static final BitSet FOLLOW_normalParameterDecl_in_formalParameterDecls3159 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_normalParameterDecl_in_formalParameterDecls3181 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_COMMA_in_formalParameterDecls3191 = new BitSet(new long[]{0x0840500100214000L,0x0000000020000210L});
    public static final BitSet FOLLOW_ellipsisParameterDecl_in_formalParameterDecls3213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableModifiers_in_normalParameterDecl3233 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_normalParameterDecl3235 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_normalParameterDecl3237 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_normalParameterDecl3248 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_normalParameterDecl3250 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_variableModifiers_in_ellipsisParameterDecl3281 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_ellipsisParameterDecl3291 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_ELLIPSIS_in_ellipsisParameterDecl3294 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_ellipsisParameterDecl3304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nonWildcardTypeArguments_in_explicitConstructorInvocation3326 = new BitSet(new long[]{0x0000000000000000L,0x0000110000000000L});
    public static final BitSet FOLLOW_set_in_explicitConstructorInvocation3352 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_arguments_in_explicitConstructorInvocation3384 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_explicitConstructorInvocation3386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_explicitConstructorInvocation3397 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_DOT_in_explicitConstructorInvocation3407 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000080L});
    public static final BitSet FOLLOW_nonWildcardTypeArguments_in_explicitConstructorInvocation3418 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_SUPER_in_explicitConstructorInvocation3439 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_arguments_in_explicitConstructorInvocation3449 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_explicitConstructorInvocation3451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_qualifiedName3471 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_DOT_in_qualifiedName3482 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_qualifiedName3484 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_annotation_in_annotations3516 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_MONKEYS_AT_in_annotation3549 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_qualifiedName_in_annotation3551 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_LPAREN_in_annotation3565 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0280A1A72L});
    public static final BitSet FOLLOW_elementValuePairs_in_annotation3592 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_elementValue_in_annotation3616 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_annotation3652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs3684 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_elementValuePairs3695 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_elementValuePair_in_elementValuePairs3697 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_elementValuePair3728 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_EQ_in_elementValuePair3730 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1A72L});
    public static final BitSet FOLLOW_elementValue_in_elementValuePair3732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalExpression_in_elementValue3752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_elementValue3762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elementValueArrayInitializer_in_elementValue3772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_elementValueArrayInitializer3792 = new BitSet(new long[]{0x2840C80302614200L,0x000A91B0210A1A72L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer3803 = new BitSet(new long[]{0x0000000002000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_COMMA_in_elementValueArrayInitializer3818 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1A72L});
    public static final BitSet FOLLOW_elementValue_in_elementValueArrayInitializer3820 = new BitSet(new long[]{0x0000000002000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_COMMA_in_elementValueArrayInitializer3849 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_RBRACE_in_elementValueArrayInitializer3853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_annotationTypeDeclaration3876 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_MONKEYS_AT_in_annotationTypeDeclaration3878 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_INTERFACE_in_annotationTypeDeclaration3888 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_annotationTypeDeclaration3898 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeBody_in_annotationTypeDeclaration3908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_annotationTypeBody3929 = new BitSet(new long[]{0x1840502100A14010L,0x0011040C31700610L});
    public static final BitSet FOLLOW_annotationTypeElementDeclaration_in_annotationTypeBody3941 = new BitSet(new long[]{0x1840502100A14010L,0x0011040C31700610L});
    public static final BitSet FOLLOW_RBRACE_in_annotationTypeBody3963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationMethodDeclaration_in_annotationTypeElementDeclaration3985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceFieldDeclaration_in_annotationTypeElementDeclaration3995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normalClassDeclaration_in_annotationTypeElementDeclaration4005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normalInterfaceDeclaration_in_annotationTypeElementDeclaration4015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumDeclaration_in_annotationTypeElementDeclaration4025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeDeclaration_in_annotationTypeElementDeclaration4035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_annotationTypeElementDeclaration4045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_annotationMethodDeclaration4065 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_annotationMethodDeclaration4067 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_annotationMethodDeclaration4069 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_LPAREN_in_annotationMethodDeclaration4079 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_annotationMethodDeclaration4081 = new BitSet(new long[]{0x0000000020000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_DEFAULT_in_annotationMethodDeclaration4084 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1A72L});
    public static final BitSet FOLLOW_elementValue_in_annotationMethodDeclaration4086 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_annotationMethodDeclaration4115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_block4139 = new BitSet(new long[]{0x38C1D82350E1C310L,0x003FB7BC357A1E72L});
    public static final BitSet FOLLOW_blockStatement_in_block4150 = new BitSet(new long[]{0x38C1D82350E1C310L,0x003FB7BC357A1E72L});
    public static final BitSet FOLLOW_RBRACE_in_block4171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localVariableDeclarationStatement_in_blockStatement4193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceDeclaration_in_blockStatement4203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_blockStatement4213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localVariableDeclaration_in_localVariableDeclarationStatement4234 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_localVariableDeclarationStatement4244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableModifiers_in_localVariableDeclaration4264 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_localVariableDeclaration4266 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_variableDeclarator_in_localVariableDeclaration4278 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_localVariableDeclaration4289 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_variableDeclarator_in_localVariableDeclaration4291 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_block_in_statement4322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSERT_in_statement4346 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_statement4366 = new BitSet(new long[]{0x0000000001000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_COLON_in_statement4369 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_statement4371 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_statement4375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSERT_in_statement4385 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_statement4388 = new BitSet(new long[]{0x0000000001000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_COLON_in_statement4391 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_statement4393 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_statement4397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_statement4419 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_parExpression_in_statement4421 = new BitSet(new long[]{0x28C1C8035061C300L,0x002EB7B0340A1872L});
    public static final BitSet FOLLOW_statement_in_statement4423 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_ELSE_in_statement4426 = new BitSet(new long[]{0x28C1C8035061C300L,0x002EB7B0340A1872L});
    public static final BitSet FOLLOW_statement_in_statement4428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forstatement_in_statement4450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_in_statement4460 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_parExpression_in_statement4462 = new BitSet(new long[]{0x28C1C8035061C300L,0x002EB7B0340A1872L});
    public static final BitSet FOLLOW_statement_in_statement4464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DO_in_statement4474 = new BitSet(new long[]{0x28C1C8035061C300L,0x002EB7B0340A1872L});
    public static final BitSet FOLLOW_statement_in_statement4476 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_WHILE_in_statement4478 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_parExpression_in_statement4480 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_statement4482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_trystatement_in_statement4492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SWITCH_in_statement4502 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_parExpression_in_statement4504 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_statement4506 = new BitSet(new long[]{0x0000000020080000L,0x0000000001000000L});
    public static final BitSet FOLLOW_switchBlockStatementGroups_in_statement4508 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_RBRACE_in_statement4510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYNCHRONIZED_in_statement4520 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_parExpression_in_statement4522 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_statement4524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_in_statement4534 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0300A1870L});
    public static final BitSet FOLLOW_expression_in_statement4537 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_statement4542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROW_in_statement4552 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_statement4554 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_statement4556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BREAK_in_statement4566 = new BitSet(new long[]{0x0040000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_statement4581 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_statement4598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONTINUE_in_statement4608 = new BitSet(new long[]{0x0040000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_statement4623 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_statement4640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_statement4650 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_statement4653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_statement4668 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_COLON_in_statement4670 = new BitSet(new long[]{0x28C1C8035061C300L,0x002EB7B0340A1872L});
    public static final BitSet FOLLOW_statement_in_statement4672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_statement4682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_switchBlockStatementGroup_in_switchBlockStatementGroups4704 = new BitSet(new long[]{0x0000000020080002L});
    public static final BitSet FOLLOW_switchLabel_in_switchBlockStatementGroup4733 = new BitSet(new long[]{0x38C1D82350E1C312L,0x003FB7BC347A1E72L});
    public static final BitSet FOLLOW_blockStatement_in_switchBlockStatementGroup4744 = new BitSet(new long[]{0x38C1D82350E1C312L,0x003FB7BC347A1E72L});
    public static final BitSet FOLLOW_CASE_in_switchLabel4775 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_switchLabel4777 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_COLON_in_switchLabel4779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFAULT_in_switchLabel4789 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_COLON_in_switchLabel4791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRY_in_trystatement4812 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_trystatement4814 = new BitSet(new long[]{0x0000200000100000L});
    public static final BitSet FOLLOW_catches_in_trystatement4828 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_FINALLY_in_trystatement4830 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_trystatement4832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_catches_in_trystatement4846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FINALLY_in_trystatement4860 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_trystatement4862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_catchClause_in_catches4893 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_catchClause_in_catches4904 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_CATCH_in_catchClause4935 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_LPAREN_in_catchClause4937 = new BitSet(new long[]{0x0840500100214000L,0x0000000020000210L});
    public static final BitSet FOLLOW_formalParameter_in_catchClause4939 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_catchClause4949 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_catchClause4951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableModifiers_in_formalParameter4972 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_formalParameter4974 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_formalParameter4976 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_formalParameter4987 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_formalParameter4989 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_FOR_in_forstatement5038 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_LPAREN_in_forstatement5040 = new BitSet(new long[]{0x0840500100214000L,0x0000000020000210L});
    public static final BitSet FOLLOW_variableModifiers_in_forstatement5042 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_forstatement5044 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_forstatement5046 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_COLON_in_forstatement5048 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_forstatement5059 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_forstatement5061 = new BitSet(new long[]{0x28C1C8035061C300L,0x002EB7B0340A1872L});
    public static final BitSet FOLLOW_statement_in_forstatement5063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_forstatement5095 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_LPAREN_in_forstatement5097 = new BitSet(new long[]{0x2840D80300614200L,0x000A91B0300A1A70L});
    public static final BitSet FOLLOW_forInit_in_forstatement5117 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_forstatement5138 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0300A1870L});
    public static final BitSet FOLLOW_expression_in_forstatement5158 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_forstatement5179 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0280A1870L});
    public static final BitSet FOLLOW_expressionList_in_forstatement5199 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_forstatement5220 = new BitSet(new long[]{0x28C1C8035061C300L,0x002EB7B0340A1872L});
    public static final BitSet FOLLOW_statement_in_forstatement5222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localVariableDeclaration_in_forInit5242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressionList_in_forInit5252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_parExpression5272 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_parExpression5274 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_parExpression5276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_expressionList5296 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_expressionList5307 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_expressionList5309 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_conditionalExpression_in_expression5341 = new BitSet(new long[]{0x0008004000042082L,0x0000004280050080L});
    public static final BitSet FOLLOW_assignmentOperator_in_expression5352 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_expression5354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQ_in_assignmentOperator5386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUSEQ_in_assignmentOperator5396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUBEQ_in_assignmentOperator5406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAREQ_in_assignmentOperator5416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SLASHEQ_in_assignmentOperator5426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AMPEQ_in_assignmentOperator5436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAREQ_in_assignmentOperator5446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CARETEQ_in_assignmentOperator5456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERCENTEQ_in_assignmentOperator5466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_assignmentOperator5477 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_LT_in_assignmentOperator5479 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_EQ_in_assignmentOperator5481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_assignmentOperator5492 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_GT_in_assignmentOperator5494 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_GT_in_assignmentOperator5496 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_EQ_in_assignmentOperator5498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_assignmentOperator5509 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_GT_in_assignmentOperator5511 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_EQ_in_assignmentOperator5513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalOrExpression_in_conditionalExpression5534 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_QUES_in_conditionalExpression5545 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_conditionalExpression5547 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_COLON_in_conditionalExpression5549 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_conditionalExpression_in_conditionalExpression5551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalAndExpression_in_conditionalOrExpression5582 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_BARBAR_in_conditionalOrExpression5593 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_conditionalAndExpression_in_conditionalOrExpression5595 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_inclusiveOrExpression_in_conditionalAndExpression5626 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_AMPAMP_in_conditionalAndExpression5637 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_inclusiveOrExpression_in_conditionalAndExpression5639 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression5670 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_BAR_in_inclusiveOrExpression5681 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression5683 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_andExpression_in_exclusiveOrExpression5714 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_CARET_in_exclusiveOrExpression5725 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_andExpression_in_exclusiveOrExpression5727 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_equalityExpression_in_andExpression5758 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_AMP_in_andExpression5769 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_equalityExpression_in_andExpression5771 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_instanceOfExpression_in_equalityExpression5802 = new BitSet(new long[]{0x0000008000000402L});
    public static final BitSet FOLLOW_set_in_equalityExpression5829 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_instanceOfExpression_in_equalityExpression5879 = new BitSet(new long[]{0x0000008000000402L});
    public static final BitSet FOLLOW_relationalExpression_in_instanceOfExpression5910 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_INSTANCEOF_in_instanceOfExpression5921 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_instanceOfExpression5923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpression5954 = new BitSet(new long[]{0x0008000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_relationalOp_in_relationalExpression5965 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpression5967 = new BitSet(new long[]{0x0008000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_LT_in_relationalOp5999 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_EQ_in_relationalOp6001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_relationalOp6012 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_EQ_in_relationalOp6014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_relationalOp6024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_relationalOp6034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_additiveExpression_in_shiftExpression6054 = new BitSet(new long[]{0x0008000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_shiftOp_in_shiftExpression6065 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_additiveExpression_in_shiftExpression6067 = new BitSet(new long[]{0x0008000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_LT_in_shiftOp6100 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_LT_in_shiftOp6102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_shiftOp6113 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_GT_in_shiftOp6115 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_GT_in_shiftOp6117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_shiftOp6128 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_GT_in_shiftOp6130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression6151 = new BitSet(new long[]{0x0000000000000002L,0x0000002000020000L});
    public static final BitSet FOLLOW_set_in_additiveExpression6178 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression6228 = new BitSet(new long[]{0x0000000000000002L,0x0000002000020000L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression6266 = new BitSet(new long[]{0x0000000000000002L,0x0000000140008000L});
    public static final BitSet FOLLOW_set_in_multiplicativeExpression6293 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression6361 = new BitSet(new long[]{0x0000000000000002L,0x0000000140008000L});
    public static final BitSet FOLLOW_PLUS_in_unaryExpression6394 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression6397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUB_in_unaryExpression6407 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression6409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUSPLUS_in_unaryExpression6419 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression6421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUBSUB_in_unaryExpression6431 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression6433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryExpressionNotPlusMinus_in_unaryExpression6443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TILDE_in_unaryExpressionNotPlusMinus6463 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus6465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BANG_in_unaryExpressionNotPlusMinus6475 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus6477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_castExpression_in_unaryExpressionNotPlusMinus6487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_in_unaryExpressionNotPlusMinus6497 = new BitSet(new long[]{0x0000000080000002L,0x0000008000080004L});
    public static final BitSet FOLLOW_selector_in_unaryExpressionNotPlusMinus6508 = new BitSet(new long[]{0x0000000080000002L,0x0000008000080004L});
    public static final BitSet FOLLOW_LPAREN_in_castExpression6578 = new BitSet(new long[]{0x0800400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_primitiveType_in_castExpression6580 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_castExpression6582 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_unaryExpression_in_castExpression6584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_castExpression6594 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_castExpression6596 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_castExpression6598 = new BitSet(new long[]{0x2840C80300614200L,0x000A911020001870L});
    public static final BitSet FOLLOW_unaryExpressionNotPlusMinus_in_castExpression6600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parExpression_in_primary6622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THIS_in_primary6644 = new BitSet(new long[]{0x0000000080000002L,0x0000000000000044L});
    public static final BitSet FOLLOW_DOT_in_primary6655 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primary6657 = new BitSet(new long[]{0x0000000080000002L,0x0000000000000044L});
    public static final BitSet FOLLOW_identifierSuffix_in_primary6679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primary6700 = new BitSet(new long[]{0x0000000080000002L,0x0000000000000044L});
    public static final BitSet FOLLOW_DOT_in_primary6711 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primary6713 = new BitSet(new long[]{0x0000000080000002L,0x0000000000000044L});
    public static final BitSet FOLLOW_identifierSuffix_in_primary6735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUPER_in_primary6756 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_superSuffix_in_primary6766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_primary6776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_creator_in_primary6786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveType_in_primary6796 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_primary6807 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_primary6809 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_DOT_in_primary6830 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_CLASS_in_primary6832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VOID_in_primary6842 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_DOT_in_primary6844 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_CLASS_in_primary6846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arguments_in_superSuffix6872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_superSuffix6882 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_typeArguments_in_superSuffix6885 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_superSuffix6906 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_arguments_in_superSuffix6917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_identifierSuffix6950 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_identifierSuffix6952 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_DOT_in_identifierSuffix6973 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_CLASS_in_identifierSuffix6975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_identifierSuffix6986 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_identifierSuffix6988 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_identifierSuffix6990 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_arguments_in_identifierSuffix7011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_identifierSuffix7021 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_CLASS_in_identifierSuffix7023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_identifierSuffix7033 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_nonWildcardTypeArguments_in_identifierSuffix7035 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_identifierSuffix7037 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_arguments_in_identifierSuffix7039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_identifierSuffix7049 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_THIS_in_identifierSuffix7051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_identifierSuffix7061 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_SUPER_in_identifierSuffix7063 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_arguments_in_identifierSuffix7065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_innerCreator_in_identifierSuffix7075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_selector7097 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_selector7099 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_arguments_in_selector7110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_selector7131 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_THIS_in_selector7133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_selector7143 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_SUPER_in_selector7145 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_superSuffix_in_selector7155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_innerCreator_in_selector7165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_selector7175 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_selector7177 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_selector7179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_creator7199 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_nonWildcardTypeArguments_in_creator7201 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_creator7203 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_classCreatorRest_in_creator7205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_creator7215 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_creator7217 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_classCreatorRest_in_creator7219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayCreator_in_creator7229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_arrayCreator7249 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_createdName_in_arrayCreator7251 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_arrayCreator7261 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_arrayCreator7263 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_LBRACKET_in_arrayCreator7274 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_arrayCreator7276 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_arrayInitializer_in_arrayCreator7297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_arrayCreator7308 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_createdName_in_arrayCreator7310 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_arrayCreator7320 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_arrayCreator7322 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_arrayCreator7332 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_arrayCreator7346 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_arrayCreator7348 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_arrayCreator7362 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_arrayCreator7384 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_arrayCreator7386 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_arrayInitializer_in_variableInitializer7417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_variableInitializer7427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_arrayInitializer7447 = new BitSet(new long[]{0x2840C80302614200L,0x000A91B0210A1872L});
    public static final BitSet FOLLOW_variableInitializer_in_arrayInitializer7463 = new BitSet(new long[]{0x0000000002000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_COMMA_in_arrayInitializer7482 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1872L});
    public static final BitSet FOLLOW_variableInitializer_in_arrayInitializer7484 = new BitSet(new long[]{0x0000000002000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_COMMA_in_arrayInitializer7534 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_RBRACE_in_arrayInitializer7547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_createdName7581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primitiveType_in_createdName7591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_innerCreator7612 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_NEW_in_innerCreator7614 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_nonWildcardTypeArguments_in_innerCreator7625 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_innerCreator7646 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_typeArguments_in_innerCreator7657 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_classCreatorRest_in_innerCreator7678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arguments_in_classCreatorRest7699 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_classBody_in_classCreatorRest7710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_nonWildcardTypeArguments7742 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_typeList_in_nonWildcardTypeArguments7744 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_GT_in_nonWildcardTypeArguments7754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_arguments7774 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0280A1870L});
    public static final BitSet FOLLOW_expressionList_in_arguments7777 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_arguments7790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_classHeader7914 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_CLASS_in_classHeader7916 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_classHeader7918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_enumHeader7938 = new BitSet(new long[]{0x0040002000000000L});
    public static final BitSet FOLLOW_set_in_enumHeader7940 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_enumHeader7946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_interfaceHeader7966 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_INTERFACE_in_interfaceHeader7968 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_interfaceHeader7970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_annotationHeader7990 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_MONKEYS_AT_in_annotationHeader7992 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_INTERFACE_in_annotationHeader7994 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_annotationHeader7996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_typeHeader8016 = new BitSet(new long[]{0x1000002000800000L,0x0000000000000200L});
    public static final BitSet FOLLOW_CLASS_in_typeHeader8019 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ENUM_in_typeHeader8021 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_MONKEYS_AT_in_typeHeader8024 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_INTERFACE_in_typeHeader8028 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_typeHeader8032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_methodHeader8052 = new BitSet(new long[]{0x0840400100214000L,0x0008000020000090L});
    public static final BitSet FOLLOW_typeParameters_in_methodHeader8054 = new BitSet(new long[]{0x0840400100214000L,0x0008000020000010L});
    public static final BitSet FOLLOW_type_in_methodHeader8058 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_VOID_in_methodHeader8060 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_methodHeader8064 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_LPAREN_in_methodHeader8066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_fieldHeader8086 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_fieldHeader8088 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_fieldHeader8090 = new BitSet(new long[]{0x0000004002000000L,0x0000000010000004L});
    public static final BitSet FOLLOW_LBRACKET_in_fieldHeader8093 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_fieldHeader8094 = new BitSet(new long[]{0x0000004002000000L,0x0000000010000004L});
    public static final BitSet FOLLOW_set_in_fieldHeader8098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableModifiers_in_localVariableHeader8124 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_localVariableHeader8126 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_localVariableHeader8128 = new BitSet(new long[]{0x0000004002000000L,0x0000000010000004L});
    public static final BitSet FOLLOW_LBRACKET_in_localVariableHeader8131 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_localVariableHeader8132 = new BitSet(new long[]{0x0000004002000000L,0x0000000010000004L});
    public static final BitSet FOLLOW_set_in_localVariableHeader8136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotations_in_synpred2_RJavaSymbolTable75 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_packageDeclaration_in_synpred2_RJavaSymbolTable104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classDeclaration_in_synpred12_RJavaSymbolTable462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normalClassDeclaration_in_synpred27_RJavaSymbolTable699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normalInterfaceDeclaration_in_synpred43_RJavaSymbolTable1378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fieldDeclaration_in_synpred52_RJavaSymbolTable1741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_methodDeclaration_in_synpred53_RJavaSymbolTable1752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classDeclaration_in_synpred54_RJavaSymbolTable1763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_explicitConstructorInvocation_in_synpred57_RJavaSymbolTable1900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_synpred59_RJavaSymbolTable1812 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_typeParameters_in_synpred59_RJavaSymbolTable1823 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred59_RJavaSymbolTable1844 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_formalParameters_in_synpred59_RJavaSymbolTable1854 = new BitSet(new long[]{0x0000000000000000L,0x0000400000000002L});
    public static final BitSet FOLLOW_THROWS_in_synpred59_RJavaSymbolTable1865 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_qualifiedNameList_in_synpred59_RJavaSymbolTable1867 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_synpred59_RJavaSymbolTable1888 = new BitSet(new long[]{0x38C1D82350E1C310L,0x003FB7BC357A1EF2L});
    public static final BitSet FOLLOW_explicitConstructorInvocation_in_synpred59_RJavaSymbolTable1900 = new BitSet(new long[]{0x38C1D82350E1C310L,0x003FB7BC357A1E72L});
    public static final BitSet FOLLOW_blockStatement_in_synpred59_RJavaSymbolTable1922 = new BitSet(new long[]{0x38C1D82350E1C310L,0x003FB7BC357A1E72L});
    public static final BitSet FOLLOW_RBRACE_in_synpred59_RJavaSymbolTable1943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceFieldDeclaration_in_synpred68_RJavaSymbolTable2342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceMethodDeclaration_in_synpred69_RJavaSymbolTable2352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceDeclaration_in_synpred70_RJavaSymbolTable2362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classDeclaration_in_synpred71_RJavaSymbolTable2372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ellipsisParameterDecl_in_synpred96_RJavaSymbolTable3136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normalParameterDecl_in_synpred98_RJavaSymbolTable3146 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMMA_in_synpred98_RJavaSymbolTable3157 = new BitSet(new long[]{0x0840500100214000L,0x0000000020000210L});
    public static final BitSet FOLLOW_normalParameterDecl_in_synpred98_RJavaSymbolTable3159 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_normalParameterDecl_in_synpred99_RJavaSymbolTable3181 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_COMMA_in_synpred99_RJavaSymbolTable3191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nonWildcardTypeArguments_in_synpred103_RJavaSymbolTable3326 = new BitSet(new long[]{0x0000000000000000L,0x0000110000000000L});
    public static final BitSet FOLLOW_set_in_synpred103_RJavaSymbolTable3352 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_arguments_in_synpred103_RJavaSymbolTable3384 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_synpred103_RJavaSymbolTable3386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationMethodDeclaration_in_synpred117_RJavaSymbolTable3985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceFieldDeclaration_in_synpred118_RJavaSymbolTable3995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normalClassDeclaration_in_synpred119_RJavaSymbolTable4005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normalInterfaceDeclaration_in_synpred120_RJavaSymbolTable4015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumDeclaration_in_synpred121_RJavaSymbolTable4025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationTypeDeclaration_in_synpred122_RJavaSymbolTable4035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localVariableDeclarationStatement_in_synpred125_RJavaSymbolTable4193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classOrInterfaceDeclaration_in_synpred126_RJavaSymbolTable4203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSERT_in_synpred130_RJavaSymbolTable4346 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_synpred130_RJavaSymbolTable4366 = new BitSet(new long[]{0x0000000001000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_COLON_in_synpred130_RJavaSymbolTable4369 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_synpred130_RJavaSymbolTable4371 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_synpred130_RJavaSymbolTable4375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSERT_in_synpred132_RJavaSymbolTable4385 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_synpred132_RJavaSymbolTable4388 = new BitSet(new long[]{0x0000000001000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_COLON_in_synpred132_RJavaSymbolTable4391 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_synpred132_RJavaSymbolTable4393 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_synpred132_RJavaSymbolTable4397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_in_synpred133_RJavaSymbolTable4426 = new BitSet(new long[]{0x28C1C8035061C300L,0x002EB7B0340A1872L});
    public static final BitSet FOLLOW_statement_in_synpred133_RJavaSymbolTable4428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred148_RJavaSymbolTable4650 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_SEMI_in_synpred148_RJavaSymbolTable4653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred149_RJavaSymbolTable4668 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_COLON_in_synpred149_RJavaSymbolTable4670 = new BitSet(new long[]{0x28C1C8035061C300L,0x002EB7B0340A1872L});
    public static final BitSet FOLLOW_statement_in_synpred149_RJavaSymbolTable4672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_catches_in_synpred153_RJavaSymbolTable4828 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_FINALLY_in_synpred153_RJavaSymbolTable4830 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_synpred153_RJavaSymbolTable4832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_catches_in_synpred154_RJavaSymbolTable4846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_synpred157_RJavaSymbolTable5038 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_LPAREN_in_synpred157_RJavaSymbolTable5040 = new BitSet(new long[]{0x0840500100214000L,0x0000000020000210L});
    public static final BitSet FOLLOW_variableModifiers_in_synpred157_RJavaSymbolTable5042 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_type_in_synpred157_RJavaSymbolTable5044 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred157_RJavaSymbolTable5046 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_COLON_in_synpred157_RJavaSymbolTable5048 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_synpred157_RJavaSymbolTable5059 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_synpred157_RJavaSymbolTable5061 = new BitSet(new long[]{0x28C1C8035061C300L,0x002EB7B0340A1872L});
    public static final BitSet FOLLOW_statement_in_synpred157_RJavaSymbolTable5063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localVariableDeclaration_in_synpred161_RJavaSymbolTable5242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_castExpression_in_synpred202_RJavaSymbolTable6487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_synpred206_RJavaSymbolTable6578 = new BitSet(new long[]{0x0800400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_primitiveType_in_synpred206_RJavaSymbolTable6580 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_RPAREN_in_synpred206_RJavaSymbolTable6582 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_unaryExpression_in_synpred206_RJavaSymbolTable6584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_synpred208_RJavaSymbolTable6655 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred208_RJavaSymbolTable6657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierSuffix_in_synpred209_RJavaSymbolTable6679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_synpred211_RJavaSymbolTable6711 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred211_RJavaSymbolTable6713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierSuffix_in_synpred212_RJavaSymbolTable6735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred224_RJavaSymbolTable6986 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_synpred224_RJavaSymbolTable6988 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_synpred224_RJavaSymbolTable6990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_synpred236_RJavaSymbolTable7199 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_nonWildcardTypeArguments_in_synpred236_RJavaSymbolTable7201 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_synpred236_RJavaSymbolTable7203 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_classCreatorRest_in_synpred236_RJavaSymbolTable7205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_synpred237_RJavaSymbolTable7215 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_classOrInterfaceType_in_synpred237_RJavaSymbolTable7217 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_classCreatorRest_in_synpred237_RJavaSymbolTable7219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_synpred239_RJavaSymbolTable7249 = new BitSet(new long[]{0x0840400100214000L,0x0000000020000010L});
    public static final BitSet FOLLOW_createdName_in_synpred239_RJavaSymbolTable7251 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred239_RJavaSymbolTable7261 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_synpred239_RJavaSymbolTable7263 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred239_RJavaSymbolTable7274 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_synpred239_RJavaSymbolTable7276 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_arrayInitializer_in_synpred239_RJavaSymbolTable7297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred240_RJavaSymbolTable7346 = new BitSet(new long[]{0x2840C80300614200L,0x000A91B0200A1870L});
    public static final BitSet FOLLOW_expression_in_synpred240_RJavaSymbolTable7348 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_RBRACKET_in_synpred240_RJavaSymbolTable7362 = new BitSet(new long[]{0x0000000000000002L});

}