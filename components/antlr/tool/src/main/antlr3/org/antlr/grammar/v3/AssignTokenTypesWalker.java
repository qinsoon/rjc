// $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g 2013-02-27 10:13:17

package org.antlr.grammar.v3;

import java.util.*;
import org.antlr.analysis.*;
import org.antlr.misc.*;
import org.antlr.tool.*;

import org.antlr.runtime.BitSet;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/** [Warning: TJP says that this is probably out of date as of 11/19/2005,
 *   but since it's probably still useful, I'll leave in.  Don't have energy
 *   to update at the moment.]
 *
 *  Compute the token types for all literals and rules etc..  There are
 *  a few different cases to consider for grammar types and a few situations
 *  within.
 *
 *  CASE 1 : pure parser grammar
 *	a) Any reference to a token gets a token type.
 *  b) The tokens section may alias a token name to a string or char
 *
 *  CASE 2 : pure lexer grammar
 *  a) Import token vocabulary if available. Set token types for any new tokens
 *     to values above last imported token type
 *  b) token rule definitions get token types if not already defined
 *  c) literals do NOT get token types
 *
 *  CASE 3 : merged parser / lexer grammar
 *	a) Any char or string literal gets a token type in a parser rule
 *  b) Any reference to a token gets a token type if not referencing
 *     a fragment lexer rule
 *  c) The tokens section may alias a token name to a string or char
 *     which must add a rule to the lexer
 *  d) token rule definitions get token types if not already defined
 *  e) token rule definitions may also alias a token name to a literal.
 *     E.g., Rule 'FOR : "for";' will alias FOR to "for" in the sense that
 *     references to either in the parser grammar will yield the token type
 *
 *  What this pass does:
 *
 *  0. Collects basic info about the grammar like grammar name and type;
 *     Oh, I have go get the options in case they affect the token types.
 *     E.g., tokenVocab option.
 *     Imports any token vocab name/type pairs into a local hashtable.
 *  1. Finds a list of all literals and token names.
 *  2. Finds a list of all token name rule definitions;
 *     no token rules implies pure parser.
 *  3. Finds a list of all simple token rule defs of form "<NAME> : <literal>;"
 *     and aliases them.
 *  4. Walks token names table and assign types to any unassigned
 *  5. Walks aliases and assign types to referenced literals
 *  6. Walks literals, assigning types if untyped
 *  4. Informs the Grammar object of the type definitions such as:
 *     g.defineToken(<charliteral>, ttype);
 *     g.defineToken(<stringliteral>, ttype);
 *     g.defineToken(<tokenID>, ttype);
 *     where some of the ttype values will be the same for aliases tokens.
 */
@SuppressWarnings({"all", "warnings", "unchecked"})
public class AssignTokenTypesWalker extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACTION", "ACTION_CHAR_LITERAL", "ACTION_ESC", "ACTION_STRING_LITERAL", "ALT", "AMPERSAND", "ARG", "ARGLIST", "ARG_ACTION", "ASSIGN", "BACKTRACK_SEMPRED", "BANG", "BLOCK", "CATCH", "CHAR_LITERAL", "CHAR_RANGE", "CLOSE_ELEMENT_OPTION", "CLOSURE", "COLON", "COMBINED_GRAMMAR", "COMMA", "COMMENT", "DIGIT", "DOC_COMMENT", "DOLLAR", "DOT", "DOUBLE_ANGLE_STRING_LITERAL", "DOUBLE_QUOTE_STRING_LITERAL", "EOA", "EOB", "EOR", "EPSILON", "ESC", "ETC", "FINALLY", "FORCED_ACTION", "FRAGMENT", "GATED_SEMPRED", "GRAMMAR", "ID", "IMPLIES", "IMPORT", "INITACTION", "INT", "LABEL", "LEXER", "LEXER_GRAMMAR", "LPAREN", "ML_COMMENT", "NESTED_ACTION", "NESTED_ARG_ACTION", "NOT", "OPEN_ELEMENT_OPTION", "OPTIONAL", "OPTIONS", "OR", "PARSER", "PARSER_GRAMMAR", "PLUS", "PLUS_ASSIGN", "POSITIVE_CLOSURE", "PREC_RULE", "PRIVATE", "PROTECTED", "PUBLIC", "QUESTION", "RANGE", "RCURLY", "RECURSIVE_RULE_REF", "RET", "RETURNS", "REWRITE", "REWRITES", "ROOT", "RPAREN", "RULE", "RULE_REF", "SCOPE", "SEMI", "SEMPRED", "SL_COMMENT", "SRC", "STAR", "STRAY_BRACKET", "STRING_LITERAL", "SYNPRED", "SYN_SEMPRED", "TEMPLATE", "THROWS", "TOKENS", "TOKEN_REF", "TREE", "TREE_BEGIN", "TREE_GRAMMAR", "WILDCARD", "WS", "WS_LOOP", "WS_OPT", "XDIGIT", "CHARSET"
    };

    public static final int EOF=-1;
    public static final int ACTION=4;
    public static final int ACTION_CHAR_LITERAL=5;
    public static final int ACTION_ESC=6;
    public static final int ACTION_STRING_LITERAL=7;
    public static final int ALT=8;
    public static final int AMPERSAND=9;
    public static final int ARG=10;
    public static final int ARGLIST=11;
    public static final int ARG_ACTION=12;
    public static final int ASSIGN=13;
    public static final int BACKTRACK_SEMPRED=14;
    public static final int BANG=15;
    public static final int BLOCK=16;
    public static final int CATCH=17;
    public static final int CHAR_LITERAL=18;
    public static final int CHAR_RANGE=19;
    public static final int CLOSE_ELEMENT_OPTION=20;
    public static final int CLOSURE=21;
    public static final int COLON=22;
    public static final int COMBINED_GRAMMAR=23;
    public static final int COMMA=24;
    public static final int COMMENT=25;
    public static final int DIGIT=26;
    public static final int DOC_COMMENT=27;
    public static final int DOLLAR=28;
    public static final int DOT=29;
    public static final int DOUBLE_ANGLE_STRING_LITERAL=30;
    public static final int DOUBLE_QUOTE_STRING_LITERAL=31;
    public static final int EOA=32;
    public static final int EOB=33;
    public static final int EOR=34;
    public static final int EPSILON=35;
    public static final int ESC=36;
    public static final int ETC=37;
    public static final int FINALLY=38;
    public static final int FORCED_ACTION=39;
    public static final int FRAGMENT=40;
    public static final int GATED_SEMPRED=41;
    public static final int GRAMMAR=42;
    public static final int ID=43;
    public static final int IMPLIES=44;
    public static final int IMPORT=45;
    public static final int INITACTION=46;
    public static final int INT=47;
    public static final int LABEL=48;
    public static final int LEXER=49;
    public static final int LEXER_GRAMMAR=50;
    public static final int LPAREN=51;
    public static final int ML_COMMENT=52;
    public static final int NESTED_ACTION=53;
    public static final int NESTED_ARG_ACTION=54;
    public static final int NOT=55;
    public static final int OPEN_ELEMENT_OPTION=56;
    public static final int OPTIONAL=57;
    public static final int OPTIONS=58;
    public static final int OR=59;
    public static final int PARSER=60;
    public static final int PARSER_GRAMMAR=61;
    public static final int PLUS=62;
    public static final int PLUS_ASSIGN=63;
    public static final int POSITIVE_CLOSURE=64;
    public static final int PREC_RULE=65;
    public static final int PRIVATE=66;
    public static final int PROTECTED=67;
    public static final int PUBLIC=68;
    public static final int QUESTION=69;
    public static final int RANGE=70;
    public static final int RCURLY=71;
    public static final int RECURSIVE_RULE_REF=72;
    public static final int RET=73;
    public static final int RETURNS=74;
    public static final int REWRITE=75;
    public static final int REWRITES=76;
    public static final int ROOT=77;
    public static final int RPAREN=78;
    public static final int RULE=79;
    public static final int RULE_REF=80;
    public static final int SCOPE=81;
    public static final int SEMI=82;
    public static final int SEMPRED=83;
    public static final int SL_COMMENT=84;
    public static final int SRC=85;
    public static final int STAR=86;
    public static final int STRAY_BRACKET=87;
    public static final int STRING_LITERAL=88;
    public static final int SYNPRED=89;
    public static final int SYN_SEMPRED=90;
    public static final int TEMPLATE=91;
    public static final int THROWS=92;
    public static final int TOKENS=93;
    public static final int TOKEN_REF=94;
    public static final int TREE=95;
    public static final int TREE_BEGIN=96;
    public static final int TREE_GRAMMAR=97;
    public static final int WILDCARD=98;
    public static final int WS=99;
    public static final int WS_LOOP=100;
    public static final int WS_OPT=101;
    public static final int XDIGIT=102;
    public static final int CHARSET=103;

    // delegates
    public TreeParser[] getDelegates() {
        return new TreeParser[] {};
    }

    // delegators


    public AssignTokenTypesWalker(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public AssignTokenTypesWalker(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return AssignTokenTypesWalker.tokenNames; }
    public String getGrammarFileName() { return "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g"; }


    protected Grammar grammar;
    protected String currentRuleName;

    protected static GrammarAST stringAlias;
    protected static GrammarAST charAlias;
    protected static GrammarAST stringAlias2;
    protected static GrammarAST charAlias2;

    @Override
    public void reportError(RecognitionException ex)
    {
        Token token = null;
        if (ex instanceof MismatchedTokenException) {
            token = ((MismatchedTokenException)ex).token;
        } else if (ex instanceof NoViableAltException) {
            token = ((NoViableAltException)ex).token;
        }

        ErrorManager.syntaxError(
            ErrorManager.MSG_SYNTAX_ERROR,
            grammar,
            token,
            "assign.types: " + ex.toString(),
            ex);
    }

    protected void initASTPatterns()
    {
        TreeAdaptor adaptor = new ANTLRParser.grammar_Adaptor(null);

        /*
         * stringAlias = ^(BLOCK[] ^(ALT[] STRING_LITERAL[] EOA[]) EOB[])
         */
        stringAlias = (GrammarAST)adaptor.create( BLOCK, "BLOCK" );
        {
            GrammarAST alt = (GrammarAST)adaptor.create( ALT, "ALT" );
            adaptor.addChild( alt, adaptor.create( STRING_LITERAL, "STRING_LITERAL" ) );
            adaptor.addChild( alt, adaptor.create( EOA, "EOA" ) );
            adaptor.addChild( stringAlias, alt );
        }
        adaptor.addChild( stringAlias, adaptor.create( EOB, "EOB" ) );

        /*
         * charAlias = ^(BLOCK[] ^(ALT[] CHAR_LITERAL[] EOA[]) EOB[])
         */
        charAlias = (GrammarAST)adaptor.create( BLOCK, "BLOCK" );
        {
            GrammarAST alt = (GrammarAST)adaptor.create( ALT, "ALT" );
            adaptor.addChild( alt, adaptor.create( CHAR_LITERAL, "CHAR_LITERAL" ) );
            adaptor.addChild( alt, adaptor.create( EOA, "EOA" ) );
            adaptor.addChild( charAlias, alt );
        }
        adaptor.addChild( charAlias, adaptor.create( EOB, "EOB" ) );

        /*
         * stringAlias2 = ^(BLOCK[] ^(ALT[] STRING_LITERAL[] ACTION[] EOA[]) EOB[])
         */
        stringAlias2 = (GrammarAST)adaptor.create( BLOCK, "BLOCK" );
        {
            GrammarAST alt = (GrammarAST)adaptor.create( ALT, "ALT" );
            adaptor.addChild( alt, adaptor.create( STRING_LITERAL, "STRING_LITERAL" ) );
            adaptor.addChild( alt, adaptor.create( ACTION, "ACTION" ) );
            adaptor.addChild( alt, adaptor.create( EOA, "EOA" ) );
            adaptor.addChild( stringAlias2, alt );
        }
        adaptor.addChild( stringAlias2, adaptor.create( EOB, "EOB" ) );

        /*
         * charAlias = ^(BLOCK[] ^(ALT[] CHAR_LITERAL[] ACTION[] EOA[]) EOB[])
         */
        charAlias2 = (GrammarAST)adaptor.create( BLOCK, "BLOCK" );
        {
            GrammarAST alt = (GrammarAST)adaptor.create( ALT, "ALT" );
            adaptor.addChild( alt, adaptor.create( CHAR_LITERAL, "CHAR_LITERAL" ) );
            adaptor.addChild( alt, adaptor.create( ACTION, "ACTION" ) );
            adaptor.addChild( alt, adaptor.create( EOA, "EOA" ) );
            adaptor.addChild( charAlias2, alt );
        }
        adaptor.addChild( charAlias2, adaptor.create( EOB, "EOB" ) );
    }

    // Behavior moved to AssignTokenTypesBehavior
    protected void trackString(GrammarAST t) {}
    protected void trackToken( GrammarAST t ) {}
    protected void trackTokenRule( GrammarAST t, GrammarAST modifier, GrammarAST block ) {}
    protected void alias( GrammarAST t, GrammarAST s ) {}
    public void defineTokens( Grammar root ) {}
    protected void defineStringLiteralsFromDelegates() {}
    protected void assignStringTypes( Grammar root ) {}
    protected void aliasTokenIDsAndLiterals( Grammar root ) {}
    protected void assignTokenIDTypes( Grammar root ) {}
    protected void defineTokenNamesAndLiteralsInGrammar( Grammar root ) {}
    protected void init( Grammar root ) {}



    // $ANTLR start "grammar_"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:198:1: public grammar_[Grammar g] : ( ^( LEXER_GRAMMAR grammarSpec ) | ^( PARSER_GRAMMAR grammarSpec ) | ^( TREE_GRAMMAR grammarSpec ) | ^( COMBINED_GRAMMAR grammarSpec ) ) ;
    public final void grammar_(Grammar g) throws RecognitionException {

        	if ( state.backtracking == 0 )
        		init(g);

        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:204:2: ( ( ^( LEXER_GRAMMAR grammarSpec ) | ^( PARSER_GRAMMAR grammarSpec ) | ^( TREE_GRAMMAR grammarSpec ) | ^( COMBINED_GRAMMAR grammarSpec ) ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:204:4: ( ^( LEXER_GRAMMAR grammarSpec ) | ^( PARSER_GRAMMAR grammarSpec ) | ^( TREE_GRAMMAR grammarSpec ) | ^( COMBINED_GRAMMAR grammarSpec ) )
            {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:204:4: ( ^( LEXER_GRAMMAR grammarSpec ) | ^( PARSER_GRAMMAR grammarSpec ) | ^( TREE_GRAMMAR grammarSpec ) | ^( COMBINED_GRAMMAR grammarSpec ) )
            int alt1=4;
            switch ( input.LA(1) ) {
            case LEXER_GRAMMAR:
                {
                alt1=1;
                }
                break;
            case PARSER_GRAMMAR:
                {
                alt1=2;
                }
                break;
            case TREE_GRAMMAR:
                {
                alt1=3;
                }
                break;
            case COMBINED_GRAMMAR:
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }

            switch (alt1) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:204:6: ^( LEXER_GRAMMAR grammarSpec )
                    {
                    match(input,LEXER_GRAMMAR,FOLLOW_LEXER_GRAMMAR_in_grammar_63); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_grammarSpec_in_grammar_68);
                    grammarSpec();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:205:5: ^( PARSER_GRAMMAR grammarSpec )
                    {
                    match(input,PARSER_GRAMMAR,FOLLOW_PARSER_GRAMMAR_in_grammar_78); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_grammarSpec_in_grammar_82);
                    grammarSpec();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:206:5: ^( TREE_GRAMMAR grammarSpec )
                    {
                    match(input,TREE_GRAMMAR,FOLLOW_TREE_GRAMMAR_in_grammar_92); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_grammarSpec_in_grammar_98);
                    grammarSpec();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:207:5: ^( COMBINED_GRAMMAR grammarSpec )
                    {
                    match(input,COMBINED_GRAMMAR,FOLLOW_COMBINED_GRAMMAR_in_grammar_108); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_grammarSpec_in_grammar_110);
                    grammarSpec();

                    state._fsp--;


                    match(input, Token.UP, null); 


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
        }
        return ;
    }
    // $ANTLR end "grammar_"



    // $ANTLR start "grammarSpec"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:211:1: grammarSpec : id= ID (cmt= DOC_COMMENT )? ( optionsSpec )? ( delegateGrammars )? ( tokensSpec )? ( attrScope )* ( ^( AMPERSAND ( . )* ) )* rules ;
    public final void grammarSpec() throws RecognitionException {
        GrammarAST id=null;
        GrammarAST cmt=null;

        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:212:2: (id= ID (cmt= DOC_COMMENT )? ( optionsSpec )? ( delegateGrammars )? ( tokensSpec )? ( attrScope )* ( ^( AMPERSAND ( . )* ) )* rules )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:212:4: id= ID (cmt= DOC_COMMENT )? ( optionsSpec )? ( delegateGrammars )? ( tokensSpec )? ( attrScope )* ( ^( AMPERSAND ( . )* ) )* rules
            {
            id=(GrammarAST)match(input,ID,FOLLOW_ID_in_grammarSpec129); 

            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:213:3: (cmt= DOC_COMMENT )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==DOC_COMMENT) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:213:4: cmt= DOC_COMMENT
                    {
                    cmt=(GrammarAST)match(input,DOC_COMMENT,FOLLOW_DOC_COMMENT_in_grammarSpec136); 

                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:214:3: ( optionsSpec )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==OPTIONS) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:214:4: optionsSpec
                    {
                    pushFollow(FOLLOW_optionsSpec_in_grammarSpec143);
                    optionsSpec();

                    state._fsp--;


                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:215:3: ( delegateGrammars )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==IMPORT) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:215:4: delegateGrammars
                    {
                    pushFollow(FOLLOW_delegateGrammars_in_grammarSpec150);
                    delegateGrammars();

                    state._fsp--;


                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:216:3: ( tokensSpec )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==TOKENS) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:216:4: tokensSpec
                    {
                    pushFollow(FOLLOW_tokensSpec_in_grammarSpec157);
                    tokensSpec();

                    state._fsp--;


                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:217:3: ( attrScope )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==SCOPE) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:217:4: attrScope
            	    {
            	    pushFollow(FOLLOW_attrScope_in_grammarSpec164);
            	    attrScope();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:218:3: ( ^( AMPERSAND ( . )* ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==AMPERSAND) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:218:5: ^( AMPERSAND ( . )* )
            	    {
            	    match(input,AMPERSAND,FOLLOW_AMPERSAND_in_grammarSpec173); 

            	    if ( input.LA(1)==Token.DOWN ) {
            	        match(input, Token.DOWN, null); 
            	        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:218:17: ( . )*
            	        loop7:
            	        do {
            	            int alt7=2;
            	            int LA7_0 = input.LA(1);

            	            if ( ((LA7_0 >= ACTION && LA7_0 <= CHARSET)) ) {
            	                alt7=1;
            	            }
            	            else if ( (LA7_0==UP) ) {
            	                alt7=2;
            	            }


            	            switch (alt7) {
            	        	case 1 :
            	        	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:218:17: .
            	        	    {
            	        	    matchAny(input); 

            	        	    }
            	        	    break;

            	        	default :
            	        	    break loop7;
            	            }
            	        } while (true);


            	        match(input, Token.UP, null); 
            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            pushFollow(FOLLOW_rules_in_grammarSpec185);
            rules();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "grammarSpec"



    // $ANTLR start "attrScope"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:222:1: attrScope : ^( 'scope' ID ( ^( AMPERSAND ( . )* ) )* ACTION ) ;
    public final void attrScope() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:223:2: ( ^( 'scope' ID ( ^( AMPERSAND ( . )* ) )* ACTION ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:223:4: ^( 'scope' ID ( ^( AMPERSAND ( . )* ) )* ACTION )
            {
            match(input,SCOPE,FOLLOW_SCOPE_in_attrScope198); 

            match(input, Token.DOWN, null); 
            match(input,ID,FOLLOW_ID_in_attrScope200); 

            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:223:18: ( ^( AMPERSAND ( . )* ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==AMPERSAND) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:223:20: ^( AMPERSAND ( . )* )
            	    {
            	    match(input,AMPERSAND,FOLLOW_AMPERSAND_in_attrScope205); 

            	    if ( input.LA(1)==Token.DOWN ) {
            	        match(input, Token.DOWN, null); 
            	        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:223:32: ( . )*
            	        loop9:
            	        do {
            	            int alt9=2;
            	            int LA9_0 = input.LA(1);

            	            if ( ((LA9_0 >= ACTION && LA9_0 <= CHARSET)) ) {
            	                alt9=1;
            	            }
            	            else if ( (LA9_0==UP) ) {
            	                alt9=2;
            	            }


            	            switch (alt9) {
            	        	case 1 :
            	        	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:223:32: .
            	        	    {
            	        	    matchAny(input); 

            	        	    }
            	        	    break;

            	        	default :
            	        	    break loop9;
            	            }
            	        } while (true);


            	        match(input, Token.UP, null); 
            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            match(input,ACTION,FOLLOW_ACTION_in_attrScope214); 

            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "attrScope"



    // $ANTLR start "optionsSpec"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:226:1: optionsSpec returns [Map<Object, Object> opts = new HashMap<Object, Object>()] : ^( OPTIONS ( option[$opts] )+ ) ;
    public final Map<Object, Object> optionsSpec() throws RecognitionException {
        Map<Object, Object> opts =  new HashMap<Object, Object>();


        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:227:2: ( ^( OPTIONS ( option[$opts] )+ ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:227:4: ^( OPTIONS ( option[$opts] )+ )
            {
            match(input,OPTIONS,FOLLOW_OPTIONS_in_optionsSpec233); 

            match(input, Token.DOWN, null); 
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:227:15: ( option[$opts] )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==ASSIGN) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:227:16: option[$opts]
            	    {
            	    pushFollow(FOLLOW_option_in_optionsSpec236);
            	    option(opts);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return opts;
    }
    // $ANTLR end "optionsSpec"



    // $ANTLR start "option"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:230:1: option[Map<Object, Object> opts] : ^( ASSIGN ID optionValue ) ;
    public final void option(Map<Object, Object> opts) throws RecognitionException {
        GrammarAST ID1=null;
        AssignTokenTypesWalker.optionValue_return optionValue2 =null;


        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:231:2: ( ^( ASSIGN ID optionValue ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:231:4: ^( ASSIGN ID optionValue )
            {
            match(input,ASSIGN,FOLLOW_ASSIGN_in_option255); 

            match(input, Token.DOWN, null); 
            ID1=(GrammarAST)match(input,ID,FOLLOW_ID_in_option257); 

            pushFollow(FOLLOW_optionValue_in_option259);
            optionValue2=optionValue();

            state._fsp--;


            match(input, Token.UP, null); 



            			String key = (ID1!=null?ID1.getText():null);
            			opts.put(key, (optionValue2!=null?optionValue2.value:null));
            			// check for grammar-level option to import vocabulary
            			if ( currentRuleName==null && key.equals("tokenVocab") )
            			{
            				grammar.importTokenVocabulary(ID1,(String)(optionValue2!=null?optionValue2.value:null));
            			}
            		

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "option"


    public static class optionValue_return extends TreeRuleReturnScope {
        public Object value=null;
    };


    // $ANTLR start "optionValue"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:243:1: optionValue returns [Object value=null] : ( ID | STRING_LITERAL | CHAR_LITERAL | INT );
    public final AssignTokenTypesWalker.optionValue_return optionValue() throws RecognitionException {
        AssignTokenTypesWalker.optionValue_return retval = new AssignTokenTypesWalker.optionValue_return();
        retval.start = input.LT(1);


        GrammarAST INT3=null;


        	if ( state.backtracking == 0 )
        		retval.value = ((GrammarAST)retval.start).getText();

        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:249:2: ( ID | STRING_LITERAL | CHAR_LITERAL | INT )
            int alt12=4;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt12=1;
                }
                break;
            case STRING_LITERAL:
                {
                alt12=2;
                }
                break;
            case CHAR_LITERAL:
                {
                alt12=3;
                }
                break;
            case INT:
                {
                alt12=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }

            switch (alt12) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:249:4: ID
                    {
                    match(input,ID,FOLLOW_ID_in_optionValue285); 

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:250:4: STRING_LITERAL
                    {
                    match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_optionValue290); 

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:251:4: CHAR_LITERAL
                    {
                    match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_optionValue295); 

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:252:4: INT
                    {
                    INT3=(GrammarAST)match(input,INT,FOLLOW_INT_in_optionValue300); 

                    retval.value = Integer.parseInt((INT3!=null?INT3.getText():null));

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
        }
        return retval;
    }
    // $ANTLR end "optionValue"



    // $ANTLR start "charSet"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:257:1: charSet : ^( CHARSET charSetElement ) ;
    public final void charSet() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:258:2: ( ^( CHARSET charSetElement ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:258:4: ^( CHARSET charSetElement )
            {
            match(input,CHARSET,FOLLOW_CHARSET_in_charSet318); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_charSetElement_in_charSet320);
            charSetElement();

            state._fsp--;


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "charSet"



    // $ANTLR start "charSetElement"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:261:1: charSetElement : ( CHAR_LITERAL | ^( OR CHAR_LITERAL CHAR_LITERAL ) | ^( RANGE CHAR_LITERAL CHAR_LITERAL ) );
    public final void charSetElement() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:262:2: ( CHAR_LITERAL | ^( OR CHAR_LITERAL CHAR_LITERAL ) | ^( RANGE CHAR_LITERAL CHAR_LITERAL ) )
            int alt13=3;
            switch ( input.LA(1) ) {
            case CHAR_LITERAL:
                {
                alt13=1;
                }
                break;
            case OR:
                {
                alt13=2;
                }
                break;
            case RANGE:
                {
                alt13=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }

            switch (alt13) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:262:4: CHAR_LITERAL
                    {
                    match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_charSetElement333); 

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:263:4: ^( OR CHAR_LITERAL CHAR_LITERAL )
                    {
                    match(input,OR,FOLLOW_OR_in_charSetElement340); 

                    match(input, Token.DOWN, null); 
                    match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_charSetElement342); 

                    match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_charSetElement344); 

                    match(input, Token.UP, null); 


                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:264:4: ^( RANGE CHAR_LITERAL CHAR_LITERAL )
                    {
                    match(input,RANGE,FOLLOW_RANGE_in_charSetElement353); 

                    match(input, Token.DOWN, null); 
                    match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_charSetElement355); 

                    match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_charSetElement357); 

                    match(input, Token.UP, null); 


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
        }
        return ;
    }
    // $ANTLR end "charSetElement"



    // $ANTLR start "delegateGrammars"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:267:1: delegateGrammars : ^( 'import' ( ^( ASSIGN ID ID ) | ID )+ ) ;
    public final void delegateGrammars() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:268:2: ( ^( 'import' ( ^( ASSIGN ID ID ) | ID )+ ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:268:4: ^( 'import' ( ^( ASSIGN ID ID ) | ID )+ )
            {
            match(input,IMPORT,FOLLOW_IMPORT_in_delegateGrammars372); 

            match(input, Token.DOWN, null); 
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:269:4: ( ^( ASSIGN ID ID ) | ID )+
            int cnt14=0;
            loop14:
            do {
                int alt14=3;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==ASSIGN) ) {
                    alt14=1;
                }
                else if ( (LA14_0==ID) ) {
                    alt14=2;
                }


                switch (alt14) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:269:6: ^( ASSIGN ID ID )
            	    {
            	    match(input,ASSIGN,FOLLOW_ASSIGN_in_delegateGrammars380); 

            	    match(input, Token.DOWN, null); 
            	    match(input,ID,FOLLOW_ID_in_delegateGrammars382); 

            	    match(input,ID,FOLLOW_ID_in_delegateGrammars384); 

            	    match(input, Token.UP, null); 


            	    }
            	    break;
            	case 2 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:270:6: ID
            	    {
            	    match(input,ID,FOLLOW_ID_in_delegateGrammars392); 

            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "delegateGrammars"



    // $ANTLR start "tokensSpec"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:275:1: tokensSpec : ^( TOKENS ( tokenSpec )* ) ;
    public final void tokensSpec() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:276:2: ( ^( TOKENS ( tokenSpec )* ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:276:4: ^( TOKENS ( tokenSpec )* )
            {
            match(input,TOKENS,FOLLOW_TOKENS_in_tokensSpec414); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:276:13: ( tokenSpec )*
                loop15:
                do {
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==ASSIGN||LA15_0==TOKEN_REF) ) {
                        alt15=1;
                    }


                    switch (alt15) {
                	case 1 :
                	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:276:13: tokenSpec
                	    {
                	    pushFollow(FOLLOW_tokenSpec_in_tokensSpec416);
                	    tokenSpec();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop15;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "tokensSpec"



    // $ANTLR start "tokenSpec"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:279:1: tokenSpec : (t= TOKEN_REF | ^( ASSIGN t2= TOKEN_REF (s= STRING_LITERAL |c= CHAR_LITERAL ) ) );
    public final void tokenSpec() throws RecognitionException {
        GrammarAST t=null;
        GrammarAST t2=null;
        GrammarAST s=null;
        GrammarAST c=null;

        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:280:2: (t= TOKEN_REF | ^( ASSIGN t2= TOKEN_REF (s= STRING_LITERAL |c= CHAR_LITERAL ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==TOKEN_REF) ) {
                alt17=1;
            }
            else if ( (LA17_0==ASSIGN) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }
            switch (alt17) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:280:4: t= TOKEN_REF
                    {
                    t=(GrammarAST)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_tokenSpec431); 

                    trackToken(t);

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:281:4: ^( ASSIGN t2= TOKEN_REF (s= STRING_LITERAL |c= CHAR_LITERAL ) )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_tokenSpec451); 

                    match(input, Token.DOWN, null); 
                    t2=(GrammarAST)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_tokenSpec458); 

                    trackToken(t2);

                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:283:4: (s= STRING_LITERAL |c= CHAR_LITERAL )
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==STRING_LITERAL) ) {
                        alt16=1;
                    }
                    else if ( (LA16_0==CHAR_LITERAL) ) {
                        alt16=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 16, 0, input);

                        throw nvae;

                    }
                    switch (alt16) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:283:6: s= STRING_LITERAL
                            {
                            s=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_tokenSpec475); 

                            trackString(s); alias(t2,s);

                            }
                            break;
                        case 2 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:284:6: c= CHAR_LITERAL
                            {
                            c=(GrammarAST)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_tokenSpec486); 

                            trackString(c); alias(t2,c);

                            }
                            break;

                    }


                    match(input, Token.UP, null); 


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
        }
        return ;
    }
    // $ANTLR end "tokenSpec"



    // $ANTLR start "rules"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:289:1: rules : ( rule )+ ;
    public final void rules() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:290:2: ( ( rule )+ )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:290:4: ( rule )+
            {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:290:4: ( rule )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==PREC_RULE||LA18_0==RULE) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:290:4: rule
            	    {
            	    pushFollow(FOLLOW_rule_in_rules510);
            	    rule();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "rules"



    // $ANTLR start "rule"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:293:1: rule : ( ^( RULE ruleBody ) | ^( PREC_RULE ruleBody ) );
    public final void rule() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:294:2: ( ^( RULE ruleBody ) | ^( PREC_RULE ruleBody ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE) ) {
                alt19=1;
            }
            else if ( (LA19_0==PREC_RULE) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;

            }
            switch (alt19) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:294:4: ^( RULE ruleBody )
                    {
                    match(input,RULE,FOLLOW_RULE_in_rule523); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_ruleBody_in_rule525);
                    ruleBody();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:295:4: ^( PREC_RULE ruleBody )
                    {
                    match(input,PREC_RULE,FOLLOW_PREC_RULE_in_rule532); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_ruleBody_in_rule534);
                    ruleBody();

                    state._fsp--;


                    match(input, Token.UP, null); 


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
        }
        return ;
    }
    // $ANTLR end "rule"



    // $ANTLR start "ruleBody"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:298:1: ruleBody : id= ID (m= modifier )? ^( ARG ( ARG_ACTION )? ) ^( RET ( ARG_ACTION )? ) ( throwsSpec )? ( optionsSpec )? ( ruleScopeSpec )? ( ^( AMPERSAND ( . )* ) )* b= block ( exceptionGroup )? EOR ;
    public final void ruleBody() throws RecognitionException {
        GrammarAST id=null;
        AssignTokenTypesWalker.modifier_return m =null;

        AssignTokenTypesWalker.block_return b =null;


        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:299:2: (id= ID (m= modifier )? ^( ARG ( ARG_ACTION )? ) ^( RET ( ARG_ACTION )? ) ( throwsSpec )? ( optionsSpec )? ( ruleScopeSpec )? ( ^( AMPERSAND ( . )* ) )* b= block ( exceptionGroup )? EOR )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:299:4: id= ID (m= modifier )? ^( ARG ( ARG_ACTION )? ) ^( RET ( ARG_ACTION )? ) ( throwsSpec )? ( optionsSpec )? ( ruleScopeSpec )? ( ^( AMPERSAND ( . )* ) )* b= block ( exceptionGroup )? EOR
            {
            id=(GrammarAST)match(input,ID,FOLLOW_ID_in_ruleBody548); 

            currentRuleName=(id!=null?id.getText():null);

            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:300:3: (m= modifier )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==FRAGMENT||(LA20_0 >= PRIVATE && LA20_0 <= PUBLIC)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:300:4: m= modifier
                    {
                    pushFollow(FOLLOW_modifier_in_ruleBody557);
                    m=modifier();

                    state._fsp--;


                    }
                    break;

            }


            match(input,ARG,FOLLOW_ARG_in_ruleBody564); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:301:9: ( ARG_ACTION )?
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==ARG_ACTION) ) {
                    alt21=1;
                }
                switch (alt21) {
                    case 1 :
                        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:301:10: ARG_ACTION
                        {
                        match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_ruleBody567); 

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }


            match(input,RET,FOLLOW_RET_in_ruleBody575); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:302:9: ( ARG_ACTION )?
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==ARG_ACTION) ) {
                    alt22=1;
                }
                switch (alt22) {
                    case 1 :
                        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:302:10: ARG_ACTION
                        {
                        match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_ruleBody578); 

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:303:3: ( throwsSpec )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==THROWS) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:303:4: throwsSpec
                    {
                    pushFollow(FOLLOW_throwsSpec_in_ruleBody586);
                    throwsSpec();

                    state._fsp--;


                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:304:3: ( optionsSpec )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==OPTIONS) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:304:4: optionsSpec
                    {
                    pushFollow(FOLLOW_optionsSpec_in_ruleBody593);
                    optionsSpec();

                    state._fsp--;


                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:305:3: ( ruleScopeSpec )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==SCOPE) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:305:4: ruleScopeSpec
                    {
                    pushFollow(FOLLOW_ruleScopeSpec_in_ruleBody600);
                    ruleScopeSpec();

                    state._fsp--;


                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:306:3: ( ^( AMPERSAND ( . )* ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==AMPERSAND) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:306:5: ^( AMPERSAND ( . )* )
            	    {
            	    match(input,AMPERSAND,FOLLOW_AMPERSAND_in_ruleBody609); 

            	    if ( input.LA(1)==Token.DOWN ) {
            	        match(input, Token.DOWN, null); 
            	        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:306:17: ( . )*
            	        loop26:
            	        do {
            	            int alt26=2;
            	            int LA26_0 = input.LA(1);

            	            if ( ((LA26_0 >= ACTION && LA26_0 <= CHARSET)) ) {
            	                alt26=1;
            	            }
            	            else if ( (LA26_0==UP) ) {
            	                alt26=2;
            	            }


            	            switch (alt26) {
            	        	case 1 :
            	        	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:306:17: .
            	        	    {
            	        	    matchAny(input); 

            	        	    }
            	        	    break;

            	        	default :
            	        	    break loop26;
            	            }
            	        } while (true);


            	        match(input, Token.UP, null); 
            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            pushFollow(FOLLOW_block_in_ruleBody622);
            b=block();

            state._fsp--;


            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:308:3: ( exceptionGroup )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==CATCH||LA28_0==FINALLY) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:308:4: exceptionGroup
                    {
                    pushFollow(FOLLOW_exceptionGroup_in_ruleBody627);
                    exceptionGroup();

                    state._fsp--;


                    }
                    break;

            }


            match(input,EOR,FOLLOW_EOR_in_ruleBody633); 

            trackTokenRule(id,(m!=null?((GrammarAST)m.start):null),(b!=null?((GrammarAST)b.start):null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "ruleBody"


    public static class modifier_return extends TreeRuleReturnScope {
    };


    // $ANTLR start "modifier"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:313:1: modifier : ( 'protected' | 'public' | 'private' | 'fragment' );
    public final AssignTokenTypesWalker.modifier_return modifier() throws RecognitionException {
        AssignTokenTypesWalker.modifier_return retval = new AssignTokenTypesWalker.modifier_return();
        retval.start = input.LT(1);


        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:314:2: ( 'protected' | 'public' | 'private' | 'fragment' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:
            {
            if ( input.LA(1)==FRAGMENT||(input.LA(1) >= PRIVATE && input.LA(1) <= PUBLIC) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
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
        }
        return retval;
    }
    // $ANTLR end "modifier"



    // $ANTLR start "throwsSpec"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:320:1: throwsSpec : ^( 'throws' ( ID )+ ) ;
    public final void throwsSpec() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:321:2: ( ^( 'throws' ( ID )+ ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:321:4: ^( 'throws' ( ID )+ )
            {
            match(input,THROWS,FOLLOW_THROWS_in_throwsSpec675); 

            match(input, Token.DOWN, null); 
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:321:15: ( ID )+
            int cnt29=0;
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==ID) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:321:15: ID
            	    {
            	    match(input,ID,FOLLOW_ID_in_throwsSpec677); 

            	    }
            	    break;

            	default :
            	    if ( cnt29 >= 1 ) break loop29;
                        EarlyExitException eee =
                            new EarlyExitException(29, input);
                        throw eee;
                }
                cnt29++;
            } while (true);


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "throwsSpec"



    // $ANTLR start "ruleScopeSpec"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:324:1: ruleScopeSpec : ^( 'scope' ( ^( AMPERSAND ( . )* ) )* ( ACTION )? ( ID )* ) ;
    public final void ruleScopeSpec() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:325:2: ( ^( 'scope' ( ^( AMPERSAND ( . )* ) )* ( ACTION )? ( ID )* ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:325:4: ^( 'scope' ( ^( AMPERSAND ( . )* ) )* ( ACTION )? ( ID )* )
            {
            match(input,SCOPE,FOLLOW_SCOPE_in_ruleScopeSpec692); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:325:15: ( ^( AMPERSAND ( . )* ) )*
                loop31:
                do {
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==AMPERSAND) ) {
                        alt31=1;
                    }


                    switch (alt31) {
                	case 1 :
                	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:325:17: ^( AMPERSAND ( . )* )
                	    {
                	    match(input,AMPERSAND,FOLLOW_AMPERSAND_in_ruleScopeSpec697); 

                	    if ( input.LA(1)==Token.DOWN ) {
                	        match(input, Token.DOWN, null); 
                	        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:325:29: ( . )*
                	        loop30:
                	        do {
                	            int alt30=2;
                	            int LA30_0 = input.LA(1);

                	            if ( ((LA30_0 >= ACTION && LA30_0 <= CHARSET)) ) {
                	                alt30=1;
                	            }
                	            else if ( (LA30_0==UP) ) {
                	                alt30=2;
                	            }


                	            switch (alt30) {
                	        	case 1 :
                	        	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:325:29: .
                	        	    {
                	        	    matchAny(input); 

                	        	    }
                	        	    break;

                	        	default :
                	        	    break loop30;
                	            }
                	        } while (true);


                	        match(input, Token.UP, null); 
                	    }


                	    }
                	    break;

                	default :
                	    break loop31;
                    }
                } while (true);


                // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:325:36: ( ACTION )?
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==ACTION) ) {
                    alt32=1;
                }
                switch (alt32) {
                    case 1 :
                        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:325:37: ACTION
                        {
                        match(input,ACTION,FOLLOW_ACTION_in_ruleScopeSpec707); 

                        }
                        break;

                }


                // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:325:46: ( ID )*
                loop33:
                do {
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==ID) ) {
                        alt33=1;
                    }


                    switch (alt33) {
                	case 1 :
                	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:325:48: ID
                	    {
                	    match(input,ID,FOLLOW_ID_in_ruleScopeSpec713); 

                	    }
                	    break;

                	default :
                	    break loop33;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "ruleScopeSpec"


    public static class block_return extends TreeRuleReturnScope {
    };


    // $ANTLR start "block"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:328:1: block : ^( BLOCK ( optionsSpec )? ( alternative rewrite )+ EOB ) ;
    public final AssignTokenTypesWalker.block_return block() throws RecognitionException {
        AssignTokenTypesWalker.block_return retval = new AssignTokenTypesWalker.block_return();
        retval.start = input.LT(1);


        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:329:2: ( ^( BLOCK ( optionsSpec )? ( alternative rewrite )+ EOB ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:329:4: ^( BLOCK ( optionsSpec )? ( alternative rewrite )+ EOB )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_block731); 

            match(input, Token.DOWN, null); 
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:330:4: ( optionsSpec )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==OPTIONS) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:330:5: optionsSpec
                    {
                    pushFollow(FOLLOW_optionsSpec_in_block737);
                    optionsSpec();

                    state._fsp--;


                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:331:4: ( alternative rewrite )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==ALT) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:331:6: alternative rewrite
            	    {
            	    pushFollow(FOLLOW_alternative_in_block746);
            	    alternative();

            	    state._fsp--;


            	    pushFollow(FOLLOW_rewrite_in_block748);
            	    rewrite();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt35 >= 1 ) break loop35;
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        throw eee;
                }
                cnt35++;
            } while (true);


            match(input,EOB,FOLLOW_EOB_in_block756); 

            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "block"



    // $ANTLR start "alternative"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:336:1: alternative : ^( ALT ( element )+ EOA ) ;
    public final void alternative() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:337:2: ( ^( ALT ( element )+ EOA ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:337:4: ^( ALT ( element )+ EOA )
            {
            match(input,ALT,FOLLOW_ALT_in_alternative773); 

            match(input, Token.DOWN, null); 
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:337:11: ( element )+
            int cnt36=0;
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==ACTION||(LA36_0 >= ASSIGN && LA36_0 <= BLOCK)||(LA36_0 >= CHAR_LITERAL && LA36_0 <= CHAR_RANGE)||LA36_0==CLOSURE||LA36_0==DOT||LA36_0==EPSILON||LA36_0==FORCED_ACTION||LA36_0==GATED_SEMPRED||LA36_0==NOT||LA36_0==OPTIONAL||(LA36_0 >= PLUS_ASSIGN && LA36_0 <= POSITIVE_CLOSURE)||LA36_0==RANGE||LA36_0==ROOT||LA36_0==RULE_REF||LA36_0==SEMPRED||(LA36_0 >= STRING_LITERAL && LA36_0 <= SYN_SEMPRED)||LA36_0==TOKEN_REF||LA36_0==TREE_BEGIN||LA36_0==WILDCARD) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:337:12: element
            	    {
            	    pushFollow(FOLLOW_element_in_alternative776);
            	    element();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt36 >= 1 ) break loop36;
                        EarlyExitException eee =
                            new EarlyExitException(36, input);
                        throw eee;
                }
                cnt36++;
            } while (true);


            match(input,EOA,FOLLOW_EOA_in_alternative780); 

            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "alternative"



    // $ANTLR start "exceptionGroup"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:340:1: exceptionGroup : ( ( exceptionHandler )+ ( finallyClause )? | finallyClause );
    public final void exceptionGroup() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:341:2: ( ( exceptionHandler )+ ( finallyClause )? | finallyClause )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==CATCH) ) {
                alt39=1;
            }
            else if ( (LA39_0==FINALLY) ) {
                alt39=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;

            }
            switch (alt39) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:341:4: ( exceptionHandler )+ ( finallyClause )?
                    {
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:341:4: ( exceptionHandler )+
                    int cnt37=0;
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==CATCH) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:341:6: exceptionHandler
                    	    {
                    	    pushFollow(FOLLOW_exceptionHandler_in_exceptionGroup795);
                    	    exceptionHandler();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt37 >= 1 ) break loop37;
                                EarlyExitException eee =
                                    new EarlyExitException(37, input);
                                throw eee;
                        }
                        cnt37++;
                    } while (true);


                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:341:26: ( finallyClause )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==FINALLY) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:341:27: finallyClause
                            {
                            pushFollow(FOLLOW_finallyClause_in_exceptionGroup801);
                            finallyClause();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:342:4: finallyClause
                    {
                    pushFollow(FOLLOW_finallyClause_in_exceptionGroup808);
                    finallyClause();

                    state._fsp--;


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
        }
        return ;
    }
    // $ANTLR end "exceptionGroup"



    // $ANTLR start "exceptionHandler"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:345:1: exceptionHandler : ^( 'catch' ARG_ACTION ACTION ) ;
    public final void exceptionHandler() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:346:2: ( ^( 'catch' ARG_ACTION ACTION ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:346:4: ^( 'catch' ARG_ACTION ACTION )
            {
            match(input,CATCH,FOLLOW_CATCH_in_exceptionHandler820); 

            match(input, Token.DOWN, null); 
            match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_exceptionHandler822); 

            match(input,ACTION,FOLLOW_ACTION_in_exceptionHandler824); 

            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "exceptionHandler"



    // $ANTLR start "finallyClause"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:349:1: finallyClause : ^( 'finally' ACTION ) ;
    public final void finallyClause() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:350:2: ( ^( 'finally' ACTION ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:350:4: ^( 'finally' ACTION )
            {
            match(input,FINALLY,FOLLOW_FINALLY_in_finallyClause837); 

            match(input, Token.DOWN, null); 
            match(input,ACTION,FOLLOW_ACTION_in_finallyClause839); 

            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "finallyClause"



    // $ANTLR start "rewrite"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:353:1: rewrite : ( ^( REWRITES ( ^( REWRITE ( . )* ) )* ) |);
    public final void rewrite() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:354:2: ( ^( REWRITES ( ^( REWRITE ( . )* ) )* ) |)
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==REWRITES) ) {
                alt42=1;
            }
            else if ( (LA42_0==ALT||LA42_0==EOB) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;

            }
            switch (alt42) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:354:4: ^( REWRITES ( ^( REWRITE ( . )* ) )* )
                    {
                    match(input,REWRITES,FOLLOW_REWRITES_in_rewrite852); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:354:15: ( ^( REWRITE ( . )* ) )*
                        loop41:
                        do {
                            int alt41=2;
                            int LA41_0 = input.LA(1);

                            if ( (LA41_0==REWRITE) ) {
                                alt41=1;
                            }


                            switch (alt41) {
                        	case 1 :
                        	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:354:17: ^( REWRITE ( . )* )
                        	    {
                        	    match(input,REWRITE,FOLLOW_REWRITE_in_rewrite857); 

                        	    if ( input.LA(1)==Token.DOWN ) {
                        	        match(input, Token.DOWN, null); 
                        	        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:354:27: ( . )*
                        	        loop40:
                        	        do {
                        	            int alt40=2;
                        	            int LA40_0 = input.LA(1);

                        	            if ( ((LA40_0 >= ACTION && LA40_0 <= CHARSET)) ) {
                        	                alt40=1;
                        	            }
                        	            else if ( (LA40_0==UP) ) {
                        	                alt40=2;
                        	            }


                        	            switch (alt40) {
                        	        	case 1 :
                        	        	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:354:27: .
                        	        	    {
                        	        	    matchAny(input); 

                        	        	    }
                        	        	    break;

                        	        	default :
                        	        	    break loop40;
                        	            }
                        	        } while (true);


                        	        match(input, Token.UP, null); 
                        	    }


                        	    }
                        	    break;

                        	default :
                        	    break loop41;
                            }
                        } while (true);


                        match(input, Token.UP, null); 
                    }


                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:356:2: 
                    {
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
        }
        return ;
    }
    // $ANTLR end "rewrite"



    // $ANTLR start "element"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:358:1: element : ( ^( ROOT element ) | ^( BANG element ) | atom | ^( NOT element ) | ^( RANGE atom atom ) | ^( CHAR_RANGE atom atom ) | ^( ASSIGN ID element ) | ^( PLUS_ASSIGN ID element ) | ebnf | tree_ | ^( SYNPRED block ) | FORCED_ACTION | ACTION | SEMPRED | SYN_SEMPRED | ^( BACKTRACK_SEMPRED ( . )* ) | GATED_SEMPRED | EPSILON );
    public final void element() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:359:2: ( ^( ROOT element ) | ^( BANG element ) | atom | ^( NOT element ) | ^( RANGE atom atom ) | ^( CHAR_RANGE atom atom ) | ^( ASSIGN ID element ) | ^( PLUS_ASSIGN ID element ) | ebnf | tree_ | ^( SYNPRED block ) | FORCED_ACTION | ACTION | SEMPRED | SYN_SEMPRED | ^( BACKTRACK_SEMPRED ( . )* ) | GATED_SEMPRED | EPSILON )
            int alt44=18;
            switch ( input.LA(1) ) {
            case ROOT:
                {
                alt44=1;
                }
                break;
            case BANG:
                {
                alt44=2;
                }
                break;
            case CHAR_LITERAL:
            case DOT:
            case RULE_REF:
            case STRING_LITERAL:
            case TOKEN_REF:
            case WILDCARD:
                {
                alt44=3;
                }
                break;
            case NOT:
                {
                alt44=4;
                }
                break;
            case RANGE:
                {
                alt44=5;
                }
                break;
            case CHAR_RANGE:
                {
                alt44=6;
                }
                break;
            case ASSIGN:
                {
                alt44=7;
                }
                break;
            case PLUS_ASSIGN:
                {
                alt44=8;
                }
                break;
            case BLOCK:
            case CLOSURE:
            case OPTIONAL:
            case POSITIVE_CLOSURE:
                {
                alt44=9;
                }
                break;
            case TREE_BEGIN:
                {
                alt44=10;
                }
                break;
            case SYNPRED:
                {
                alt44=11;
                }
                break;
            case FORCED_ACTION:
                {
                alt44=12;
                }
                break;
            case ACTION:
                {
                alt44=13;
                }
                break;
            case SEMPRED:
                {
                alt44=14;
                }
                break;
            case SYN_SEMPRED:
                {
                alt44=15;
                }
                break;
            case BACKTRACK_SEMPRED:
                {
                alt44=16;
                }
                break;
            case GATED_SEMPRED:
                {
                alt44=17;
                }
                break;
            case EPSILON:
                {
                alt44=18;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;

            }

            switch (alt44) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:359:4: ^( ROOT element )
                    {
                    match(input,ROOT,FOLLOW_ROOT_in_element881); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_element_in_element883);
                    element();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:360:4: ^( BANG element )
                    {
                    match(input,BANG,FOLLOW_BANG_in_element890); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_element_in_element892);
                    element();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:361:4: atom
                    {
                    pushFollow(FOLLOW_atom_in_element898);
                    atom();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:362:4: ^( NOT element )
                    {
                    match(input,NOT,FOLLOW_NOT_in_element904); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_element_in_element906);
                    element();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 5 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:363:4: ^( RANGE atom atom )
                    {
                    match(input,RANGE,FOLLOW_RANGE_in_element913); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_atom_in_element915);
                    atom();

                    state._fsp--;


                    pushFollow(FOLLOW_atom_in_element917);
                    atom();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 6 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:364:4: ^( CHAR_RANGE atom atom )
                    {
                    match(input,CHAR_RANGE,FOLLOW_CHAR_RANGE_in_element924); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_atom_in_element926);
                    atom();

                    state._fsp--;


                    pushFollow(FOLLOW_atom_in_element928);
                    atom();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 7 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:365:4: ^( ASSIGN ID element )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_element935); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_element937); 

                    pushFollow(FOLLOW_element_in_element939);
                    element();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 8 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:366:4: ^( PLUS_ASSIGN ID element )
                    {
                    match(input,PLUS_ASSIGN,FOLLOW_PLUS_ASSIGN_in_element946); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_element948); 

                    pushFollow(FOLLOW_element_in_element950);
                    element();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 9 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:367:4: ebnf
                    {
                    pushFollow(FOLLOW_ebnf_in_element956);
                    ebnf();

                    state._fsp--;


                    }
                    break;
                case 10 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:368:4: tree_
                    {
                    pushFollow(FOLLOW_tree__in_element961);
                    tree_();

                    state._fsp--;


                    }
                    break;
                case 11 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:369:4: ^( SYNPRED block )
                    {
                    match(input,SYNPRED,FOLLOW_SYNPRED_in_element968); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_block_in_element970);
                    block();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 12 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:370:4: FORCED_ACTION
                    {
                    match(input,FORCED_ACTION,FOLLOW_FORCED_ACTION_in_element977); 

                    }
                    break;
                case 13 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:371:4: ACTION
                    {
                    match(input,ACTION,FOLLOW_ACTION_in_element982); 

                    }
                    break;
                case 14 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:372:4: SEMPRED
                    {
                    match(input,SEMPRED,FOLLOW_SEMPRED_in_element987); 

                    }
                    break;
                case 15 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:373:4: SYN_SEMPRED
                    {
                    match(input,SYN_SEMPRED,FOLLOW_SYN_SEMPRED_in_element992); 

                    }
                    break;
                case 16 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:374:4: ^( BACKTRACK_SEMPRED ( . )* )
                    {
                    match(input,BACKTRACK_SEMPRED,FOLLOW_BACKTRACK_SEMPRED_in_element998); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:374:24: ( . )*
                        loop43:
                        do {
                            int alt43=2;
                            int LA43_0 = input.LA(1);

                            if ( ((LA43_0 >= ACTION && LA43_0 <= CHARSET)) ) {
                                alt43=1;
                            }
                            else if ( (LA43_0==UP) ) {
                                alt43=2;
                            }


                            switch (alt43) {
                        	case 1 :
                        	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:374:24: .
                        	    {
                        	    matchAny(input); 

                        	    }
                        	    break;

                        	default :
                        	    break loop43;
                            }
                        } while (true);


                        match(input, Token.UP, null); 
                    }


                    }
                    break;
                case 17 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:375:4: GATED_SEMPRED
                    {
                    match(input,GATED_SEMPRED,FOLLOW_GATED_SEMPRED_in_element1007); 

                    }
                    break;
                case 18 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:376:4: EPSILON
                    {
                    match(input,EPSILON,FOLLOW_EPSILON_in_element1012); 

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
        }
        return ;
    }
    // $ANTLR end "element"



    // $ANTLR start "ebnf"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:379:1: ebnf : ( block | ^( OPTIONAL block ) | ^( CLOSURE block ) | ^( POSITIVE_CLOSURE block ) );
    public final void ebnf() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:380:2: ( block | ^( OPTIONAL block ) | ^( CLOSURE block ) | ^( POSITIVE_CLOSURE block ) )
            int alt45=4;
            switch ( input.LA(1) ) {
            case BLOCK:
                {
                alt45=1;
                }
                break;
            case OPTIONAL:
                {
                alt45=2;
                }
                break;
            case CLOSURE:
                {
                alt45=3;
                }
                break;
            case POSITIVE_CLOSURE:
                {
                alt45=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;

            }

            switch (alt45) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:380:4: block
                    {
                    pushFollow(FOLLOW_block_in_ebnf1023);
                    block();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:381:4: ^( OPTIONAL block )
                    {
                    match(input,OPTIONAL,FOLLOW_OPTIONAL_in_ebnf1030); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_block_in_ebnf1032);
                    block();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:382:4: ^( CLOSURE block )
                    {
                    match(input,CLOSURE,FOLLOW_CLOSURE_in_ebnf1041); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_block_in_ebnf1043);
                    block();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:383:4: ^( POSITIVE_CLOSURE block )
                    {
                    match(input,POSITIVE_CLOSURE,FOLLOW_POSITIVE_CLOSURE_in_ebnf1052); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_block_in_ebnf1054);
                    block();

                    state._fsp--;


                    match(input, Token.UP, null); 


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
        }
        return ;
    }
    // $ANTLR end "ebnf"



    // $ANTLR start "tree_"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:386:1: tree_ : ^( TREE_BEGIN ( element )+ ) ;
    public final void tree_() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:387:2: ( ^( TREE_BEGIN ( element )+ ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:387:4: ^( TREE_BEGIN ( element )+ )
            {
            match(input,TREE_BEGIN,FOLLOW_TREE_BEGIN_in_tree_1068); 

            match(input, Token.DOWN, null); 
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:387:17: ( element )+
            int cnt46=0;
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==ACTION||(LA46_0 >= ASSIGN && LA46_0 <= BLOCK)||(LA46_0 >= CHAR_LITERAL && LA46_0 <= CHAR_RANGE)||LA46_0==CLOSURE||LA46_0==DOT||LA46_0==EPSILON||LA46_0==FORCED_ACTION||LA46_0==GATED_SEMPRED||LA46_0==NOT||LA46_0==OPTIONAL||(LA46_0 >= PLUS_ASSIGN && LA46_0 <= POSITIVE_CLOSURE)||LA46_0==RANGE||LA46_0==ROOT||LA46_0==RULE_REF||LA46_0==SEMPRED||(LA46_0 >= STRING_LITERAL && LA46_0 <= SYN_SEMPRED)||LA46_0==TOKEN_REF||LA46_0==TREE_BEGIN||LA46_0==WILDCARD) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:387:17: element
            	    {
            	    pushFollow(FOLLOW_element_in_tree_1070);
            	    element();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt46 >= 1 ) break loop46;
                        EarlyExitException eee =
                            new EarlyExitException(46, input);
                        throw eee;
                }
                cnt46++;
            } while (true);


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "tree_"



    // $ANTLR start "atom"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:390:1: atom : ( ^( RULE_REF ( ARG_ACTION )? ) | ^(t= TOKEN_REF ( ARG_ACTION )? ) |c= CHAR_LITERAL |s= STRING_LITERAL | WILDCARD | ^( DOT ID atom ) );
    public final void atom() throws RecognitionException {
        GrammarAST t=null;
        GrammarAST c=null;
        GrammarAST s=null;

        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:391:2: ( ^( RULE_REF ( ARG_ACTION )? ) | ^(t= TOKEN_REF ( ARG_ACTION )? ) |c= CHAR_LITERAL |s= STRING_LITERAL | WILDCARD | ^( DOT ID atom ) )
            int alt49=6;
            switch ( input.LA(1) ) {
            case RULE_REF:
                {
                alt49=1;
                }
                break;
            case TOKEN_REF:
                {
                alt49=2;
                }
                break;
            case CHAR_LITERAL:
                {
                alt49=3;
                }
                break;
            case STRING_LITERAL:
                {
                alt49=4;
                }
                break;
            case WILDCARD:
                {
                alt49=5;
                }
                break;
            case DOT:
                {
                alt49=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;

            }

            switch (alt49) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:391:4: ^( RULE_REF ( ARG_ACTION )? )
                    {
                    match(input,RULE_REF,FOLLOW_RULE_REF_in_atom1085); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:391:16: ( ARG_ACTION )?
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==ARG_ACTION) ) {
                            alt47=1;
                        }
                        switch (alt47) {
                            case 1 :
                                // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:391:17: ARG_ACTION
                                {
                                match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_atom1088); 

                                }
                                break;

                        }


                        match(input, Token.UP, null); 
                    }


                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:392:4: ^(t= TOKEN_REF ( ARG_ACTION )? )
                    {
                    t=(GrammarAST)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_atom1101); 

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); 
                        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:392:19: ( ARG_ACTION )?
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==ARG_ACTION) ) {
                            alt48=1;
                        }
                        switch (alt48) {
                            case 1 :
                                // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:392:20: ARG_ACTION
                                {
                                match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_atom1104); 

                                }
                                break;

                        }


                        match(input, Token.UP, null); 
                    }


                    trackToken(t);

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:393:4: c= CHAR_LITERAL
                    {
                    c=(GrammarAST)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_atom1118); 

                    trackString(c);

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:394:4: s= STRING_LITERAL
                    {
                    s=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_atom1129); 

                    trackString(s);

                    }
                    break;
                case 5 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:395:4: WILDCARD
                    {
                    match(input,WILDCARD,FOLLOW_WILDCARD_in_atom1136); 

                    }
                    break;
                case 6 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:396:4: ^( DOT ID atom )
                    {
                    match(input,DOT,FOLLOW_DOT_in_atom1142); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_atom1144); 

                    pushFollow(FOLLOW_atom_in_atom1146);
                    atom();

                    state._fsp--;


                    match(input, Token.UP, null); 


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
        }
        return ;
    }
    // $ANTLR end "atom"



    // $ANTLR start "ast_suffix"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:399:1: ast_suffix : ( ROOT | BANG );
    public final void ast_suffix() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:400:2: ( ROOT | BANG )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/AssignTokenTypesWalker.g:
            {
            if ( input.LA(1)==BANG||input.LA(1)==ROOT ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
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
        }
        return ;
    }
    // $ANTLR end "ast_suffix"

    // Delegated rules


 

    public static final BitSet FOLLOW_LEXER_GRAMMAR_in_grammar_63 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_grammarSpec_in_grammar_68 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARSER_GRAMMAR_in_grammar_78 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_grammarSpec_in_grammar_82 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TREE_GRAMMAR_in_grammar_92 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_grammarSpec_in_grammar_98 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COMBINED_GRAMMAR_in_grammar_108 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_grammarSpec_in_grammar_110 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_grammarSpec129 = new BitSet(new long[]{0x0400200008000200L,0x0000000020028002L});
    public static final BitSet FOLLOW_DOC_COMMENT_in_grammarSpec136 = new BitSet(new long[]{0x0400200000000200L,0x0000000020028002L});
    public static final BitSet FOLLOW_optionsSpec_in_grammarSpec143 = new BitSet(new long[]{0x0000200000000200L,0x0000000020028002L});
    public static final BitSet FOLLOW_delegateGrammars_in_grammarSpec150 = new BitSet(new long[]{0x0000000000000200L,0x0000000020028002L});
    public static final BitSet FOLLOW_tokensSpec_in_grammarSpec157 = new BitSet(new long[]{0x0000000000000200L,0x0000000000028002L});
    public static final BitSet FOLLOW_attrScope_in_grammarSpec164 = new BitSet(new long[]{0x0000000000000200L,0x0000000000028002L});
    public static final BitSet FOLLOW_AMPERSAND_in_grammarSpec173 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rules_in_grammarSpec185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SCOPE_in_attrScope198 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_attrScope200 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_AMPERSAND_in_attrScope205 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ACTION_in_attrScope214 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OPTIONS_in_optionsSpec233 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_option_in_optionsSpec236 = new BitSet(new long[]{0x0000000000002008L});
    public static final BitSet FOLLOW_ASSIGN_in_option255 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_option257 = new BitSet(new long[]{0x0000880000040000L,0x0000000001000000L});
    public static final BitSet FOLLOW_optionValue_in_option259 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_optionValue285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_optionValue290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_optionValue295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_optionValue300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARSET_in_charSet318 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_charSetElement_in_charSet320 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_charSetElement333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_charSetElement340 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_charSetElement342 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_charSetElement344 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANGE_in_charSetElement353 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_charSetElement355 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_charSetElement357 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IMPORT_in_delegateGrammars372 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ASSIGN_in_delegateGrammars380 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_delegateGrammars382 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_ID_in_delegateGrammars384 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_delegateGrammars392 = new BitSet(new long[]{0x0000080000002008L});
    public static final BitSet FOLLOW_TOKENS_in_tokensSpec414 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tokenSpec_in_tokensSpec416 = new BitSet(new long[]{0x0000000000002008L,0x0000000040000000L});
    public static final BitSet FOLLOW_TOKEN_REF_in_tokenSpec431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_tokenSpec451 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TOKEN_REF_in_tokenSpec458 = new BitSet(new long[]{0x0000000000040000L,0x0000000001000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_tokenSpec475 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_tokenSpec486 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rule_in_rules510 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008002L});
    public static final BitSet FOLLOW_RULE_in_rule523 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ruleBody_in_rule525 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PREC_RULE_in_rule532 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ruleBody_in_rule534 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_ruleBody548 = new BitSet(new long[]{0x0000010000000400L,0x000000000000001CL});
    public static final BitSet FOLLOW_modifier_in_ruleBody557 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ARG_in_ruleBody564 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_ruleBody567 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RET_in_ruleBody575 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_ruleBody578 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_throwsSpec_in_ruleBody586 = new BitSet(new long[]{0x0400000000010200L,0x0000000000020000L});
    public static final BitSet FOLLOW_optionsSpec_in_ruleBody593 = new BitSet(new long[]{0x0000000000010200L,0x0000000000020000L});
    public static final BitSet FOLLOW_ruleScopeSpec_in_ruleBody600 = new BitSet(new long[]{0x0000000000010200L});
    public static final BitSet FOLLOW_AMPERSAND_in_ruleBody609 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_ruleBody622 = new BitSet(new long[]{0x0000004400020000L});
    public static final BitSet FOLLOW_exceptionGroup_in_ruleBody627 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_EOR_in_ruleBody633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROWS_in_throwsSpec675 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_throwsSpec677 = new BitSet(new long[]{0x0000080000000008L});
    public static final BitSet FOLLOW_SCOPE_in_ruleScopeSpec692 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_AMPERSAND_in_ruleScopeSpec697 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ACTION_in_ruleScopeSpec707 = new BitSet(new long[]{0x0000080000000008L});
    public static final BitSet FOLLOW_ID_in_ruleScopeSpec713 = new BitSet(new long[]{0x0000080000000008L});
    public static final BitSet FOLLOW_BLOCK_in_block731 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_optionsSpec_in_block737 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_alternative_in_block746 = new BitSet(new long[]{0x0000000200000100L,0x0000000000001000L});
    public static final BitSet FOLLOW_rewrite_in_block748 = new BitSet(new long[]{0x0000000200000100L});
    public static final BitSet FOLLOW_EOB_in_block756 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ALT_in_alternative773 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_alternative776 = new BitSet(new long[]{0x82800289202DE010L,0x0000000547092041L});
    public static final BitSet FOLLOW_EOA_in_alternative780 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_exceptionHandler_in_exceptionGroup795 = new BitSet(new long[]{0x0000004000020002L});
    public static final BitSet FOLLOW_finallyClause_in_exceptionGroup801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_finallyClause_in_exceptionGroup808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CATCH_in_exceptionHandler820 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_exceptionHandler822 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ACTION_in_exceptionHandler824 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FINALLY_in_finallyClause837 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ACTION_in_finallyClause839 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REWRITES_in_rewrite852 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_REWRITE_in_rewrite857 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ROOT_in_element881 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_element883 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BANG_in_element890 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_element892 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_atom_in_element898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_element904 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_element906 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANGE_in_element913 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_atom_in_element915 = new BitSet(new long[]{0x0000000020040000L,0x0000000441010000L});
    public static final BitSet FOLLOW_atom_in_element917 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CHAR_RANGE_in_element924 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_atom_in_element926 = new BitSet(new long[]{0x0000000020040000L,0x0000000441010000L});
    public static final BitSet FOLLOW_atom_in_element928 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_element935 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_element937 = new BitSet(new long[]{0x82800288202DE010L,0x0000000547092041L});
    public static final BitSet FOLLOW_element_in_element939 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_ASSIGN_in_element946 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_element948 = new BitSet(new long[]{0x82800288202DE010L,0x0000000547092041L});
    public static final BitSet FOLLOW_element_in_element950 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ebnf_in_element956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tree__in_element961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYNPRED_in_element968 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_element970 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FORCED_ACTION_in_element977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_element982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMPRED_in_element987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYN_SEMPRED_in_element992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BACKTRACK_SEMPRED_in_element998 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_GATED_SEMPRED_in_element1007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EPSILON_in_element1012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_ebnf1023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPTIONAL_in_ebnf1030 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_ebnf1032 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CLOSURE_in_ebnf1041 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_ebnf1043 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POSITIVE_CLOSURE_in_ebnf1052 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_ebnf1054 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TREE_BEGIN_in_tree_1068 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_tree_1070 = new BitSet(new long[]{0x82800288202DE018L,0x0000000547092041L});
    public static final BitSet FOLLOW_RULE_REF_in_atom1085 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_atom1088 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TOKEN_REF_in_atom1101 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_atom1104 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_atom1118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_atom1129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WILDCARD_in_atom1136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_atom1142 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_atom1144 = new BitSet(new long[]{0x0000000020040000L,0x0000000441010000L});
    public static final BitSet FOLLOW_atom_in_atom1146 = new BitSet(new long[]{0x0000000000000008L});

}