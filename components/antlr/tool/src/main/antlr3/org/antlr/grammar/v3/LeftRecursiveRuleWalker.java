// $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g 2013-02-27 10:12:43

package org.antlr.grammar.v3;

import org.antlr.analysis.*;
import org.antlr.misc.*;
import org.antlr.tool.*;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.DFA;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/** Find left-recursive rules */
@SuppressWarnings({"all", "warnings", "unchecked"})
public class LeftRecursiveRuleWalker extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACTION", "ACTION_CHAR_LITERAL", "ACTION_ESC", "ACTION_STRING_LITERAL", "ALT", "AMPERSAND", "ARG", "ARGLIST", "ARG_ACTION", "ASSIGN", "BACKTRACK_SEMPRED", "BANG", "BLOCK", "CATCH", "CHAR_LITERAL", "CHAR_RANGE", "CLOSE_ELEMENT_OPTION", "CLOSURE", "COLON", "COMBINED_GRAMMAR", "COMMA", "COMMENT", "DIGIT", "DOC_COMMENT", "DOLLAR", "DOT", "DOUBLE_ANGLE_STRING_LITERAL", "DOUBLE_QUOTE_STRING_LITERAL", "EOA", "EOB", "EOR", "EPSILON", "ESC", "ETC", "FINALLY", "FORCED_ACTION", "FRAGMENT", "GATED_SEMPRED", "GRAMMAR", "ID", "IMPLIES", "IMPORT", "INITACTION", "INT", "LABEL", "LEXER", "LEXER_GRAMMAR", "LPAREN", "ML_COMMENT", "NESTED_ACTION", "NESTED_ARG_ACTION", "NOT", "OPEN_ELEMENT_OPTION", "OPTIONAL", "OPTIONS", "OR", "PARSER", "PARSER_GRAMMAR", "PLUS", "PLUS_ASSIGN", "POSITIVE_CLOSURE", "PREC_RULE", "PRIVATE", "PROTECTED", "PUBLIC", "QUESTION", "RANGE", "RCURLY", "RECURSIVE_RULE_REF", "RET", "RETURNS", "REWRITE", "REWRITES", "ROOT", "RPAREN", "RULE", "RULE_REF", "SCOPE", "SEMI", "SEMPRED", "SL_COMMENT", "SRC", "STAR", "STRAY_BRACKET", "STRING_LITERAL", "SYNPRED", "SYN_SEMPRED", "TEMPLATE", "THROWS", "TOKENS", "TOKEN_REF", "TREE", "TREE_BEGIN", "TREE_GRAMMAR", "WILDCARD", "WS", "WS_LOOP", "WS_OPT", "XDIGIT"
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

    // delegates
    public TreeParser[] getDelegates() {
        return new TreeParser[] {};
    }

    // delegators


    public LeftRecursiveRuleWalker(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public LeftRecursiveRuleWalker(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return LeftRecursiveRuleWalker.tokenNames; }
    public String getGrammarFileName() { return "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g"; }


    protected Grammar grammar;
    private String ruleName;
    private int outerAlt; // which outer alt of rule?
    public int numAlts;  // how many alts for this rule total?

    @Override
    public void reportError(RecognitionException ex)
    {
        Token token = null;
        if (ex instanceof MismatchedTokenException)
        {
            token = ((MismatchedTokenException)ex).token;
        }
        else if (ex instanceof NoViableAltException)
        {
            token = ((NoViableAltException)ex).token;
        }

        ErrorManager.syntaxError(
            ErrorManager.MSG_SYNTAX_ERROR,
            grammar,
            token,
            "assign.types: " + ex.toString(),
            ex);
    }

    public void setTokenPrec(GrammarAST t, int alt) {}
    public void binaryAlt(GrammarAST altTree, GrammarAST rewriteTree, int alt) {}
    public void ternaryAlt(GrammarAST altTree, GrammarAST rewriteTree, int alt) {}
    public void prefixAlt(GrammarAST altTree, GrammarAST rewriteTree, int alt) {}
    public void suffixAlt(GrammarAST altTree, GrammarAST rewriteTree, int alt) {}
    public void otherAlt(GrammarAST altTree, GrammarAST rewriteTree, int alt) {}
    public void setReturnValues(GrammarAST t) {}



    // $ANTLR start "optionsSpec"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:88:1: optionsSpec : ^( OPTIONS ( option )+ ) ;
    public final void optionsSpec() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:89:2: ( ^( OPTIONS ( option )+ ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:89:4: ^( OPTIONS ( option )+ )
            {
            match(input,OPTIONS,FOLLOW_OPTIONS_in_optionsSpec51); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:89:14: ( option )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==ASSIGN) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:89:14: option
            	    {
            	    pushFollow(FOLLOW_option_in_optionsSpec53);
            	    option();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return ;


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
    // $ANTLR end "optionsSpec"



    // $ANTLR start "option"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:92:1: option : ^( ASSIGN ID optionValue ) ;
    public final void option() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:93:2: ( ^( ASSIGN ID optionValue ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:93:4: ^( ASSIGN ID optionValue )
            {
            match(input,ASSIGN,FOLLOW_ASSIGN_in_option67); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            match(input,ID,FOLLOW_ID_in_option69); if (state.failed) return ;

            pushFollow(FOLLOW_optionValue_in_option71);
            optionValue();

            state._fsp--;
            if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


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



    // $ANTLR start "optionValue"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:96:1: optionValue : ( ID | STRING_LITERAL | CHAR_LITERAL | INT );
    public final void optionValue() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:97:2: ( ID | STRING_LITERAL | CHAR_LITERAL | INT )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:
            {
            if ( input.LA(1)==CHAR_LITERAL||input.LA(1)==ID||input.LA(1)==INT||input.LA(1)==STRING_LITERAL ) {
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
        }
        return ;
    }
    // $ANTLR end "optionValue"



    // $ANTLR start "charSetElement"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:103:1: charSetElement : ( CHAR_LITERAL | ^( OR CHAR_LITERAL CHAR_LITERAL ) | ^( RANGE CHAR_LITERAL CHAR_LITERAL ) );
    public final void charSetElement() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:104:2: ( CHAR_LITERAL | ^( OR CHAR_LITERAL CHAR_LITERAL ) | ^( RANGE CHAR_LITERAL CHAR_LITERAL ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case CHAR_LITERAL:
                {
                alt2=1;
                }
                break;
            case OR:
                {
                alt2=2;
                }
                break;
            case RANGE:
                {
                alt2=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:104:4: CHAR_LITERAL
                    {
                    match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_charSetElement109); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:105:4: ^( OR CHAR_LITERAL CHAR_LITERAL )
                    {
                    match(input,OR,FOLLOW_OR_in_charSetElement115); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_charSetElement117); if (state.failed) return ;

                    match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_charSetElement119); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:106:4: ^( RANGE CHAR_LITERAL CHAR_LITERAL )
                    {
                    match(input,RANGE,FOLLOW_RANGE_in_charSetElement126); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_charSetElement128); if (state.failed) return ;

                    match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_charSetElement130); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


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



    // $ANTLR start "rec_rule"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:110:1: public rec_rule[Grammar g] returns [boolean isLeftRec] : ^(r= RULE id= ID ( modifier )? ^( ARG ( ARG_ACTION )? ) ^( RET ( ARG_ACTION )? ) ( optionsSpec )? ( ruleScopeSpec )? ( ^( AMPERSAND ( . )* ) )* ruleBlock ( exceptionGroup )? EOR ) ;
    public final boolean rec_rule(Grammar g) throws RecognitionException {
        boolean isLeftRec = false;


        GrammarAST r=null;
        GrammarAST id=null;
        LeftRecursiveRuleWalker.ruleBlock_return ruleBlock1 =null;



        	grammar = g;
        	outerAlt = 1;

        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:116:2: ( ^(r= RULE id= ID ( modifier )? ^( ARG ( ARG_ACTION )? ) ^( RET ( ARG_ACTION )? ) ( optionsSpec )? ( ruleScopeSpec )? ( ^( AMPERSAND ( . )* ) )* ruleBlock ( exceptionGroup )? EOR ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:116:4: ^(r= RULE id= ID ( modifier )? ^( ARG ( ARG_ACTION )? ) ^( RET ( ARG_ACTION )? ) ( optionsSpec )? ( ruleScopeSpec )? ( ^( AMPERSAND ( . )* ) )* ruleBlock ( exceptionGroup )? EOR )
            {
            r=(GrammarAST)match(input,RULE,FOLLOW_RULE_in_rec_rule158); if (state.failed) return isLeftRec;

            match(input, Token.DOWN, null); if (state.failed) return isLeftRec;
            id=(GrammarAST)match(input,ID,FOLLOW_ID_in_rec_rule162); if (state.failed) return isLeftRec;

            if ( state.backtracking==0 ) {ruleName=id.getText();}

            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:117:4: ( modifier )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==FRAGMENT||(LA3_0 >= PRIVATE && LA3_0 <= PUBLIC)) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:117:4: modifier
                    {
                    pushFollow(FOLLOW_modifier_in_rec_rule169);
                    modifier();

                    state._fsp--;
                    if (state.failed) return isLeftRec;

                    }
                    break;

            }


            match(input,ARG,FOLLOW_ARG_in_rec_rule176); if (state.failed) return isLeftRec;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return isLeftRec;
                // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:118:10: ( ARG_ACTION )?
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==ARG_ACTION) ) {
                    alt4=1;
                }
                switch (alt4) {
                    case 1 :
                        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:118:10: ARG_ACTION
                        {
                        match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rec_rule178); if (state.failed) return isLeftRec;

                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return isLeftRec;
            }


            match(input,RET,FOLLOW_RET_in_rec_rule186); if (state.failed) return isLeftRec;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return isLeftRec;
                // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:119:10: ( ARG_ACTION )?
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==ARG_ACTION) ) {
                    alt5=1;
                }
                switch (alt5) {
                    case 1 :
                        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:119:10: ARG_ACTION
                        {
                        match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rec_rule188); if (state.failed) return isLeftRec;

                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return isLeftRec;
            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:120:4: ( optionsSpec )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==OPTIONS) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:120:4: optionsSpec
                    {
                    pushFollow(FOLLOW_optionsSpec_in_rec_rule195);
                    optionsSpec();

                    state._fsp--;
                    if (state.failed) return isLeftRec;

                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:121:4: ( ruleScopeSpec )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==SCOPE) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:121:4: ruleScopeSpec
                    {
                    pushFollow(FOLLOW_ruleScopeSpec_in_rec_rule201);
                    ruleScopeSpec();

                    state._fsp--;
                    if (state.failed) return isLeftRec;

                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:122:4: ( ^( AMPERSAND ( . )* ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==AMPERSAND) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:122:5: ^( AMPERSAND ( . )* )
            	    {
            	    match(input,AMPERSAND,FOLLOW_AMPERSAND_in_rec_rule209); if (state.failed) return isLeftRec;

            	    if ( input.LA(1)==Token.DOWN ) {
            	        match(input, Token.DOWN, null); if (state.failed) return isLeftRec;
            	        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:122:17: ( . )*
            	        loop8:
            	        do {
            	            int alt8=2;
            	            int LA8_0 = input.LA(1);

            	            if ( ((LA8_0 >= ACTION && LA8_0 <= XDIGIT)) ) {
            	                alt8=1;
            	            }
            	            else if ( (LA8_0==UP) ) {
            	                alt8=2;
            	            }


            	            switch (alt8) {
            	        	case 1 :
            	        	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:122:17: .
            	        	    {
            	        	    matchAny(input); if (state.failed) return isLeftRec;

            	        	    }
            	        	    break;

            	        	default :
            	        	    break loop8;
            	            }
            	        } while (true);


            	        match(input, Token.UP, null); if (state.failed) return isLeftRec;
            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            pushFollow(FOLLOW_ruleBlock_in_rec_rule220);
            ruleBlock1=ruleBlock();

            state._fsp--;
            if (state.failed) return isLeftRec;

            if ( state.backtracking==0 ) {isLeftRec = (ruleBlock1!=null?ruleBlock1.isLeftRec:false);}

            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:124:4: ( exceptionGroup )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==CATCH||LA10_0==FINALLY) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:124:4: exceptionGroup
                    {
                    pushFollow(FOLLOW_exceptionGroup_in_rec_rule227);
                    exceptionGroup();

                    state._fsp--;
                    if (state.failed) return isLeftRec;

                    }
                    break;

            }


            match(input,EOR,FOLLOW_EOR_in_rec_rule233); if (state.failed) return isLeftRec;

            match(input, Token.UP, null); if (state.failed) return isLeftRec;


            if ( state.backtracking==0 ) {if ((ruleBlock1!=null?ruleBlock1.isLeftRec:false)) r.setType(PREC_RULE);}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return isLeftRec;
    }
    // $ANTLR end "rec_rule"



    // $ANTLR start "modifier"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:130:1: modifier : ( 'protected' | 'public' | 'private' | 'fragment' );
    public final void modifier() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:131:2: ( 'protected' | 'public' | 'private' | 'fragment' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:
            {
            if ( input.LA(1)==FRAGMENT||(input.LA(1) >= PRIVATE && input.LA(1) <= PUBLIC) ) {
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
        }
        return ;
    }
    // $ANTLR end "modifier"



    // $ANTLR start "ruleScopeSpec"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:137:1: ruleScopeSpec : ^( 'scope' ( ACTION )? ( ID )* ) ;
    public final void ruleScopeSpec() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:138:3: ( ^( 'scope' ( ACTION )? ( ID )* ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:138:5: ^( 'scope' ( ACTION )? ( ID )* )
            {
            match(input,SCOPE,FOLLOW_SCOPE_in_ruleScopeSpec280); if (state.failed) return ;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return ;
                // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:138:15: ( ACTION )?
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==ACTION) ) {
                    alt11=1;
                }
                switch (alt11) {
                    case 1 :
                        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:138:15: ACTION
                        {
                        match(input,ACTION,FOLLOW_ACTION_in_ruleScopeSpec282); if (state.failed) return ;

                        }
                        break;

                }


                // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:138:23: ( ID )*
                loop12:
                do {
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==ID) ) {
                        alt12=1;
                    }


                    switch (alt12) {
                	case 1 :
                	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:138:23: ID
                	    {
                	    match(input,ID,FOLLOW_ID_in_ruleScopeSpec285); if (state.failed) return ;

                	    }
                	    break;

                	default :
                	    break loop12;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return ;
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


    public static class ruleBlock_return extends TreeRuleReturnScope {
        public boolean isLeftRec;
    };


    // $ANTLR start "ruleBlock"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:141:1: ruleBlock returns [boolean isLeftRec] : ^( BLOCK ( optionsSpec )? ( outerAlternative ( rewrite )? )+ EOB ) ;
    public final LeftRecursiveRuleWalker.ruleBlock_return ruleBlock() throws RecognitionException {
        LeftRecursiveRuleWalker.ruleBlock_return retval = new LeftRecursiveRuleWalker.ruleBlock_return();
        retval.start = input.LT(1);


        LeftRecursiveRuleWalker.outerAlternative_return outerAlternative2 =null;


        boolean lr=false; this.numAlts = ((GrammarAST)retval.start).getChildCount();
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:143:2: ( ^( BLOCK ( optionsSpec )? ( outerAlternative ( rewrite )? )+ EOB ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:143:4: ^( BLOCK ( optionsSpec )? ( outerAlternative ( rewrite )? )+ EOB )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_ruleBlock309); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:144:4: ( optionsSpec )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==OPTIONS) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:144:4: optionsSpec
                    {
                    pushFollow(FOLLOW_optionsSpec_in_ruleBlock314);
                    optionsSpec();

                    state._fsp--;
                    if (state.failed) return retval;

                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:145:4: ( outerAlternative ( rewrite )? )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==ALT) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:145:6: outerAlternative ( rewrite )?
            	    {
            	    pushFollow(FOLLOW_outerAlternative_in_ruleBlock322);
            	    outerAlternative2=outerAlternative();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    if ( state.backtracking==0 ) {if ((outerAlternative2!=null?outerAlternative2.isLeftRec:false)) retval.isLeftRec = true;}

            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:147:5: ( rewrite )?
            	    int alt14=2;
            	    int LA14_0 = input.LA(1);

            	    if ( (LA14_0==REWRITES) ) {
            	        alt14=1;
            	    }
            	    switch (alt14) {
            	        case 1 :
            	            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:147:5: rewrite
            	            {
            	            pushFollow(FOLLOW_rewrite_in_ruleBlock334);
            	            rewrite();

            	            state._fsp--;
            	            if (state.failed) return retval;

            	            }
            	            break;

            	    }


            	    if ( state.backtracking==0 ) {outerAlt++;}

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);


            match(input,EOB,FOLLOW_EOB_in_ruleBlock352); if (state.failed) return retval;

            match(input, Token.UP, null); if (state.failed) return retval;


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
    // $ANTLR end "ruleBlock"



    // $ANTLR start "block"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:154:1: block : ^( BLOCK ( optionsSpec )? ( ^( ALT ( element )+ EOA ) ( rewrite )? )+ EOB ) ;
    public final void block() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:155:5: ( ^( BLOCK ( optionsSpec )? ( ^( ALT ( element )+ EOA ) ( rewrite )? )+ EOB ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:155:9: ^( BLOCK ( optionsSpec )? ( ^( ALT ( element )+ EOA ) ( rewrite )? )+ EOB )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_block375); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:156:13: ( optionsSpec )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==OPTIONS) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:156:13: optionsSpec
                    {
                    pushFollow(FOLLOW_optionsSpec_in_block389);
                    optionsSpec();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:157:13: ( ^( ALT ( element )+ EOA ) ( rewrite )? )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==ALT) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:157:15: ^( ALT ( element )+ EOA ) ( rewrite )?
            	    {
            	    match(input,ALT,FOLLOW_ALT_in_block407); if (state.failed) return ;

            	    match(input, Token.DOWN, null); if (state.failed) return ;
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:157:21: ( element )+
            	    int cnt17=0;
            	    loop17:
            	    do {
            	        int alt17=2;
            	        int LA17_0 = input.LA(1);

            	        if ( (LA17_0==ACTION||(LA17_0 >= ASSIGN && LA17_0 <= BLOCK)||LA17_0==CHAR_LITERAL||LA17_0==CLOSURE||LA17_0==DOT||LA17_0==EPSILON||LA17_0==FORCED_ACTION||LA17_0==GATED_SEMPRED||LA17_0==NOT||LA17_0==OPTIONAL||(LA17_0 >= PLUS_ASSIGN && LA17_0 <= POSITIVE_CLOSURE)||LA17_0==RANGE||LA17_0==ROOT||LA17_0==RULE_REF||LA17_0==SEMPRED||(LA17_0 >= STRING_LITERAL && LA17_0 <= SYN_SEMPRED)||LA17_0==TOKEN_REF||LA17_0==TREE_BEGIN||LA17_0==WILDCARD) ) {
            	            alt17=1;
            	        }


            	        switch (alt17) {
            	    	case 1 :
            	    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:157:21: element
            	    	    {
            	    	    pushFollow(FOLLOW_element_in_block409);
            	    	    element();

            	    	    state._fsp--;
            	    	    if (state.failed) return ;

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt17 >= 1 ) break loop17;
            	    	    if (state.backtracking>0) {state.failed=true; return ;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(17, input);
            	                throw eee;
            	        }
            	        cnt17++;
            	    } while (true);


            	    match(input,EOA,FOLLOW_EOA_in_block412); if (state.failed) return ;

            	    match(input, Token.UP, null); if (state.failed) return ;


            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:157:35: ( rewrite )?
            	    int alt18=2;
            	    int LA18_0 = input.LA(1);

            	    if ( (LA18_0==REWRITES) ) {
            	        alt18=1;
            	    }
            	    switch (alt18) {
            	        case 1 :
            	            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:157:35: rewrite
            	            {
            	            pushFollow(FOLLOW_rewrite_in_block415);
            	            rewrite();

            	            state._fsp--;
            	            if (state.failed) return ;

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);


            match(input,EOB,FOLLOW_EOB_in_block433); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


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
    // $ANTLR end "block"


    public static class outerAlternative_return extends TreeRuleReturnScope {
        public boolean isLeftRec;
    };


    // $ANTLR start "outerAlternative"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:163:1: outerAlternative returns [boolean isLeftRec] : ( ( binaryMultipleOp )=> binaryMultipleOp | ( binary )=> binary | ( ternary )=> ternary | ( prefix )=> prefix | ( suffix )=> suffix | ^( ALT ( element )+ EOA ) );
    public final LeftRecursiveRuleWalker.outerAlternative_return outerAlternative() throws RecognitionException {
        LeftRecursiveRuleWalker.outerAlternative_return retval = new LeftRecursiveRuleWalker.outerAlternative_return();
        retval.start = input.LT(1);



        GrammarAST rew=(GrammarAST)((GrammarAST)retval.start).getNextSibling();
        if (rew.getType() != REWRITES)
        	rew = null;

        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:170:5: ( ( binaryMultipleOp )=> binaryMultipleOp | ( binary )=> binary | ( ternary )=> ternary | ( prefix )=> prefix | ( suffix )=> suffix | ^( ALT ( element )+ EOA ) )
            int alt21=6;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==ALT) ) {
                int LA21_1 = input.LA(2);

                if ( (synpred1_LeftRecursiveRuleWalker()) ) {
                    alt21=1;
                }
                else if ( (synpred2_LeftRecursiveRuleWalker()) ) {
                    alt21=2;
                }
                else if ( (synpred3_LeftRecursiveRuleWalker()) ) {
                    alt21=3;
                }
                else if ( (synpred4_LeftRecursiveRuleWalker()) ) {
                    alt21=4;
                }
                else if ( (synpred5_LeftRecursiveRuleWalker()) ) {
                    alt21=5;
                }
                else if ( (true) ) {
                    alt21=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;

            }
            switch (alt21) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:170:9: ( binaryMultipleOp )=> binaryMultipleOp
                    {
                    pushFollow(FOLLOW_binaryMultipleOp_in_outerAlternative482);
                    binaryMultipleOp();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {binaryAlt(((GrammarAST)retval.start), rew, outerAlt); retval.isLeftRec =true;}

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:172:9: ( binary )=> binary
                    {
                    pushFollow(FOLLOW_binary_in_outerAlternative538);
                    binary();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {binaryAlt(((GrammarAST)retval.start), rew, outerAlt); retval.isLeftRec =true;}

                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:174:9: ( ternary )=> ternary
                    {
                    pushFollow(FOLLOW_ternary_in_outerAlternative600);
                    ternary();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {ternaryAlt(((GrammarAST)retval.start), rew, outerAlt); retval.isLeftRec =true;}

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:176:9: ( prefix )=> prefix
                    {
                    pushFollow(FOLLOW_prefix_in_outerAlternative656);
                    prefix();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {prefixAlt(((GrammarAST)retval.start), rew, outerAlt);}

                    }
                    break;
                case 5 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:178:9: ( suffix )=> suffix
                    {
                    pushFollow(FOLLOW_suffix_in_outerAlternative712);
                    suffix();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {suffixAlt(((GrammarAST)retval.start), rew, outerAlt); retval.isLeftRec =true;}

                    }
                    break;
                case 6 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:180:9: ^( ALT ( element )+ EOA )
                    {
                    match(input,ALT,FOLLOW_ALT_in_outerAlternative754); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:180:15: ( element )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==ACTION||(LA20_0 >= ASSIGN && LA20_0 <= BLOCK)||LA20_0==CHAR_LITERAL||LA20_0==CLOSURE||LA20_0==DOT||LA20_0==EPSILON||LA20_0==FORCED_ACTION||LA20_0==GATED_SEMPRED||LA20_0==NOT||LA20_0==OPTIONAL||(LA20_0 >= PLUS_ASSIGN && LA20_0 <= POSITIVE_CLOSURE)||LA20_0==RANGE||LA20_0==ROOT||LA20_0==RULE_REF||LA20_0==SEMPRED||(LA20_0 >= STRING_LITERAL && LA20_0 <= SYN_SEMPRED)||LA20_0==TOKEN_REF||LA20_0==TREE_BEGIN||LA20_0==WILDCARD) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:180:15: element
                    	    {
                    	    pushFollow(FOLLOW_element_in_outerAlternative756);
                    	    element();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);


                    match(input,EOA,FOLLOW_EOA_in_outerAlternative759); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;


                    if ( state.backtracking==0 ) {otherAlt(((GrammarAST)retval.start), rew, outerAlt);}

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
    // $ANTLR end "outerAlternative"



    // $ANTLR start "binary"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:184:1: binary : ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? recurseNoLabel op= token recurse EOA ) ;
    public final void binary() throws RecognitionException {
        GrammarAST op =null;


        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:185:2: ( ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? recurseNoLabel op= token recurse EOA ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:185:4: ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? recurseNoLabel op= token recurse EOA )
            {
            match(input,ALT,FOLLOW_ALT_in_binary808); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:185:11: ( ^( BACKTRACK_SEMPRED ( . )* ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==BACKTRACK_SEMPRED) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:185:12: ^( BACKTRACK_SEMPRED ( . )* )
                    {
                    match(input,BACKTRACK_SEMPRED,FOLLOW_BACKTRACK_SEMPRED_in_binary812); if (state.failed) return ;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return ;
                        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:185:32: ( . )*
                        loop22:
                        do {
                            int alt22=2;
                            int LA22_0 = input.LA(1);

                            if ( ((LA22_0 >= ACTION && LA22_0 <= XDIGIT)) ) {
                                alt22=1;
                            }
                            else if ( (LA22_0==UP) ) {
                                alt22=2;
                            }


                            switch (alt22) {
                        	case 1 :
                        	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:185:32: .
                        	    {
                        	    matchAny(input); if (state.failed) return ;

                        	    }
                        	    break;

                        	default :
                        	    break loop22;
                            }
                        } while (true);


                        match(input, Token.UP, null); if (state.failed) return ;
                    }


                    }
                    break;

            }


            pushFollow(FOLLOW_recurseNoLabel_in_binary820);
            recurseNoLabel();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_token_in_binary824);
            op=token();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_recurse_in_binary826);
            recurse();

            state._fsp--;
            if (state.failed) return ;

            match(input,EOA,FOLLOW_EOA_in_binary828); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==0 ) {setTokenPrec(op, outerAlt);}

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
    // $ANTLR end "binary"



    // $ANTLR start "binaryMultipleOp"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:188:1: binaryMultipleOp : ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? recurseNoLabel ^( BLOCK ( ^( ALT op= token EOA ) )+ EOB ) recurse EOA ) ;
    public final void binaryMultipleOp() throws RecognitionException {
        GrammarAST op =null;


        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:189:2: ( ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? recurseNoLabel ^( BLOCK ( ^( ALT op= token EOA ) )+ EOB ) recurse EOA ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:189:4: ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? recurseNoLabel ^( BLOCK ( ^( ALT op= token EOA ) )+ EOB ) recurse EOA )
            {
            match(input,ALT,FOLLOW_ALT_in_binaryMultipleOp845); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:189:11: ( ^( BACKTRACK_SEMPRED ( . )* ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==BACKTRACK_SEMPRED) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:189:12: ^( BACKTRACK_SEMPRED ( . )* )
                    {
                    match(input,BACKTRACK_SEMPRED,FOLLOW_BACKTRACK_SEMPRED_in_binaryMultipleOp849); if (state.failed) return ;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return ;
                        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:189:32: ( . )*
                        loop24:
                        do {
                            int alt24=2;
                            int LA24_0 = input.LA(1);

                            if ( ((LA24_0 >= ACTION && LA24_0 <= XDIGIT)) ) {
                                alt24=1;
                            }
                            else if ( (LA24_0==UP) ) {
                                alt24=2;
                            }


                            switch (alt24) {
                        	case 1 :
                        	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:189:32: .
                        	    {
                        	    matchAny(input); if (state.failed) return ;

                        	    }
                        	    break;

                        	default :
                        	    break loop24;
                            }
                        } while (true);


                        match(input, Token.UP, null); if (state.failed) return ;
                    }


                    }
                    break;

            }


            pushFollow(FOLLOW_recurseNoLabel_in_binaryMultipleOp857);
            recurseNoLabel();

            state._fsp--;
            if (state.failed) return ;

            match(input,BLOCK,FOLLOW_BLOCK_in_binaryMultipleOp861); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:189:62: ( ^( ALT op= token EOA ) )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==ALT) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:189:64: ^( ALT op= token EOA )
            	    {
            	    match(input,ALT,FOLLOW_ALT_in_binaryMultipleOp867); if (state.failed) return ;

            	    match(input, Token.DOWN, null); if (state.failed) return ;
            	    pushFollow(FOLLOW_token_in_binaryMultipleOp871);
            	    op=token();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    match(input,EOA,FOLLOW_EOA_in_binaryMultipleOp873); if (state.failed) return ;

            	    if ( state.backtracking==0 ) {setTokenPrec(op, outerAlt);}

            	    match(input, Token.UP, null); if (state.failed) return ;


            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);


            match(input,EOB,FOLLOW_EOB_in_binaryMultipleOp882); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            pushFollow(FOLLOW_recurse_in_binaryMultipleOp886);
            recurse();

            state._fsp--;
            if (state.failed) return ;

            match(input,EOA,FOLLOW_EOA_in_binaryMultipleOp888); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


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
    // $ANTLR end "binaryMultipleOp"



    // $ANTLR start "ternary"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:192:1: ternary : ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? recurseNoLabel op= token recurse token recurse EOA ) ;
    public final void ternary() throws RecognitionException {
        GrammarAST op =null;


        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:193:2: ( ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? recurseNoLabel op= token recurse token recurse EOA ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:193:4: ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? recurseNoLabel op= token recurse token recurse EOA )
            {
            match(input,ALT,FOLLOW_ALT_in_ternary903); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:193:11: ( ^( BACKTRACK_SEMPRED ( . )* ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==BACKTRACK_SEMPRED) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:193:12: ^( BACKTRACK_SEMPRED ( . )* )
                    {
                    match(input,BACKTRACK_SEMPRED,FOLLOW_BACKTRACK_SEMPRED_in_ternary907); if (state.failed) return ;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return ;
                        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:193:32: ( . )*
                        loop27:
                        do {
                            int alt27=2;
                            int LA27_0 = input.LA(1);

                            if ( ((LA27_0 >= ACTION && LA27_0 <= XDIGIT)) ) {
                                alt27=1;
                            }
                            else if ( (LA27_0==UP) ) {
                                alt27=2;
                            }


                            switch (alt27) {
                        	case 1 :
                        	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:193:32: .
                        	    {
                        	    matchAny(input); if (state.failed) return ;

                        	    }
                        	    break;

                        	default :
                        	    break loop27;
                            }
                        } while (true);


                        match(input, Token.UP, null); if (state.failed) return ;
                    }


                    }
                    break;

            }


            pushFollow(FOLLOW_recurseNoLabel_in_ternary915);
            recurseNoLabel();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_token_in_ternary919);
            op=token();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_recurse_in_ternary921);
            recurse();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_token_in_ternary923);
            token();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_recurse_in_ternary925);
            recurse();

            state._fsp--;
            if (state.failed) return ;

            match(input,EOA,FOLLOW_EOA_in_ternary927); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==0 ) {setTokenPrec(op, outerAlt);}

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
    // $ANTLR end "ternary"



    // $ANTLR start "prefix"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:196:1: prefix : ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? ({...}? element )+ recurse EOA ) ;
    public final void prefix() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:196:8: ( ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? ({...}? element )+ recurse EOA ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:196:10: ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? ({...}? element )+ recurse EOA )
            {
            match(input,ALT,FOLLOW_ALT_in_prefix943); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:196:17: ( ^( BACKTRACK_SEMPRED ( . )* ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==BACKTRACK_SEMPRED) ) {
                int LA30_1 = input.LA(2);

                if ( (LA30_1==DOWN) ) {
                    alt30=1;
                }
            }
            switch (alt30) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:196:18: ^( BACKTRACK_SEMPRED ( . )* )
                    {
                    match(input,BACKTRACK_SEMPRED,FOLLOW_BACKTRACK_SEMPRED_in_prefix947); if (state.failed) return ;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return ;
                        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:196:38: ( . )*
                        loop29:
                        do {
                            int alt29=2;
                            int LA29_0 = input.LA(1);

                            if ( ((LA29_0 >= ACTION && LA29_0 <= XDIGIT)) ) {
                                alt29=1;
                            }
                            else if ( (LA29_0==UP) ) {
                                alt29=2;
                            }


                            switch (alt29) {
                        	case 1 :
                        	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:196:38: .
                        	    {
                        	    matchAny(input); if (state.failed) return ;

                        	    }
                        	    break;

                        	default :
                        	    break loop29;
                            }
                        } while (true);


                        match(input, Token.UP, null); if (state.failed) return ;
                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {setTokenPrec((GrammarAST)input.LT(1), outerAlt);}

            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:196:95: ({...}? element )+
            int cnt31=0;
            loop31:
            do {
                int alt31=2;
                switch ( input.LA(1) ) {
                case ASSIGN:
                    {
                    int LA31_1 = input.LA(2);

                    if ( (LA31_1==DOWN) ) {
                        int LA31_5 = input.LA(3);

                        if ( (LA31_5==ID) ) {
                            int LA31_8 = input.LA(4);

                            if ( (LA31_8==RULE_REF) ) {
                                int LA31_10 = input.LA(5);

                                if ( (LA31_10==DOWN) ) {
                                    alt31=1;
                                }


                            }
                            else if ( (LA31_8==ACTION||(LA31_8 >= ASSIGN && LA31_8 <= BLOCK)||LA31_8==CHAR_LITERAL||LA31_8==CLOSURE||LA31_8==DOT||LA31_8==EPSILON||LA31_8==FORCED_ACTION||LA31_8==GATED_SEMPRED||LA31_8==NOT||LA31_8==OPTIONAL||(LA31_8 >= PLUS_ASSIGN && LA31_8 <= POSITIVE_CLOSURE)||LA31_8==RANGE||LA31_8==ROOT||LA31_8==SEMPRED||(LA31_8 >= STRING_LITERAL && LA31_8 <= SYN_SEMPRED)||LA31_8==TOKEN_REF||LA31_8==TREE_BEGIN||LA31_8==WILDCARD) ) {
                                alt31=1;
                            }


                        }


                    }


                    }
                    break;
                case PLUS_ASSIGN:
                    {
                    int LA31_2 = input.LA(2);

                    if ( (LA31_2==DOWN) ) {
                        int LA31_6 = input.LA(3);

                        if ( (LA31_6==ID) ) {
                            int LA31_9 = input.LA(4);

                            if ( (LA31_9==RULE_REF) ) {
                                int LA31_11 = input.LA(5);

                                if ( (LA31_11==DOWN) ) {
                                    alt31=1;
                                }


                            }
                            else if ( (LA31_9==ACTION||(LA31_9 >= ASSIGN && LA31_9 <= BLOCK)||LA31_9==CHAR_LITERAL||LA31_9==CLOSURE||LA31_9==DOT||LA31_9==EPSILON||LA31_9==FORCED_ACTION||LA31_9==GATED_SEMPRED||LA31_9==NOT||LA31_9==OPTIONAL||(LA31_9 >= PLUS_ASSIGN && LA31_9 <= POSITIVE_CLOSURE)||LA31_9==RANGE||LA31_9==ROOT||LA31_9==SEMPRED||(LA31_9 >= STRING_LITERAL && LA31_9 <= SYN_SEMPRED)||LA31_9==TOKEN_REF||LA31_9==TREE_BEGIN||LA31_9==WILDCARD) ) {
                                alt31=1;
                            }


                        }


                    }


                    }
                    break;
                case RULE_REF:
                    {
                    int LA31_3 = input.LA(2);

                    if ( (LA31_3==DOWN) ) {
                        alt31=1;
                    }


                    }
                    break;
                case ACTION:
                case BACKTRACK_SEMPRED:
                case BANG:
                case BLOCK:
                case CHAR_LITERAL:
                case CLOSURE:
                case DOT:
                case EPSILON:
                case FORCED_ACTION:
                case GATED_SEMPRED:
                case NOT:
                case OPTIONAL:
                case POSITIVE_CLOSURE:
                case RANGE:
                case ROOT:
                case SEMPRED:
                case STRING_LITERAL:
                case SYNPRED:
                case SYN_SEMPRED:
                case TOKEN_REF:
                case TREE_BEGIN:
                case WILDCARD:
                    {
                    alt31=1;
                    }
                    break;

                }

                switch (alt31) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:196:96: {...}? element
            	    {
            	    if ( !((!((CommonTree)input.LT(1)).getText().equals(ruleName))) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "prefix", "!((CommonTree)input.LT(1)).getText().equals(ruleName)");
            	    }

            	    pushFollow(FOLLOW_element_in_prefix960);
            	    element();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt31 >= 1 ) break loop31;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
            } while (true);


            pushFollow(FOLLOW_recurse_in_prefix964);
            recurse();

            state._fsp--;
            if (state.failed) return ;

            match(input,EOA,FOLLOW_EOA_in_prefix966); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


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
    // $ANTLR end "prefix"



    // $ANTLR start "suffix"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:198:1: suffix : ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? recurseNoLabel ( element )+ EOA ) ;
    public final void suffix() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:198:8: ( ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? recurseNoLabel ( element )+ EOA ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:198:10: ^( ALT ( ^( BACKTRACK_SEMPRED ( . )* ) )? recurseNoLabel ( element )+ EOA )
            {
            match(input,ALT,FOLLOW_ALT_in_suffix979); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:198:17: ( ^( BACKTRACK_SEMPRED ( . )* ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==BACKTRACK_SEMPRED) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:198:18: ^( BACKTRACK_SEMPRED ( . )* )
                    {
                    match(input,BACKTRACK_SEMPRED,FOLLOW_BACKTRACK_SEMPRED_in_suffix983); if (state.failed) return ;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return ;
                        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:198:38: ( . )*
                        loop32:
                        do {
                            int alt32=2;
                            int LA32_0 = input.LA(1);

                            if ( ((LA32_0 >= ACTION && LA32_0 <= XDIGIT)) ) {
                                alt32=1;
                            }
                            else if ( (LA32_0==UP) ) {
                                alt32=2;
                            }


                            switch (alt32) {
                        	case 1 :
                        	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:198:38: .
                        	    {
                        	    matchAny(input); if (state.failed) return ;

                        	    }
                        	    break;

                        	default :
                        	    break loop32;
                            }
                        } while (true);


                        match(input, Token.UP, null); if (state.failed) return ;
                    }


                    }
                    break;

            }


            pushFollow(FOLLOW_recurseNoLabel_in_suffix991);
            recurseNoLabel();

            state._fsp--;
            if (state.failed) return ;

            if ( state.backtracking==0 ) {setTokenPrec((GrammarAST)input.LT(1), outerAlt);}

            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:198:110: ( element )+
            int cnt34=0;
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==ACTION||(LA34_0 >= ASSIGN && LA34_0 <= BLOCK)||LA34_0==CHAR_LITERAL||LA34_0==CLOSURE||LA34_0==DOT||LA34_0==EPSILON||LA34_0==FORCED_ACTION||LA34_0==GATED_SEMPRED||LA34_0==NOT||LA34_0==OPTIONAL||(LA34_0 >= PLUS_ASSIGN && LA34_0 <= POSITIVE_CLOSURE)||LA34_0==RANGE||LA34_0==ROOT||LA34_0==RULE_REF||LA34_0==SEMPRED||(LA34_0 >= STRING_LITERAL && LA34_0 <= SYN_SEMPRED)||LA34_0==TOKEN_REF||LA34_0==TREE_BEGIN||LA34_0==WILDCARD) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:198:110: element
            	    {
            	    pushFollow(FOLLOW_element_in_suffix995);
            	    element();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt34 >= 1 ) break loop34;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(34, input);
                        throw eee;
                }
                cnt34++;
            } while (true);


            match(input,EOA,FOLLOW_EOA_in_suffix999); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


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
    // $ANTLR end "suffix"



    // $ANTLR start "recurse"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:200:1: recurse : ( ^( ASSIGN ID recurseNoLabel ) | ^( PLUS_ASSIGN ID recurseNoLabel ) | recurseNoLabel );
    public final void recurse() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:201:2: ( ^( ASSIGN ID recurseNoLabel ) | ^( PLUS_ASSIGN ID recurseNoLabel ) | recurseNoLabel )
            int alt35=3;
            switch ( input.LA(1) ) {
            case ASSIGN:
                {
                alt35=1;
                }
                break;
            case PLUS_ASSIGN:
                {
                alt35=2;
                }
                break;
            case RULE_REF:
                {
                alt35=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;

            }

            switch (alt35) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:201:4: ^( ASSIGN ID recurseNoLabel )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_recurse1012); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,ID,FOLLOW_ID_in_recurse1014); if (state.failed) return ;

                    pushFollow(FOLLOW_recurseNoLabel_in_recurse1016);
                    recurseNoLabel();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:202:4: ^( PLUS_ASSIGN ID recurseNoLabel )
                    {
                    match(input,PLUS_ASSIGN,FOLLOW_PLUS_ASSIGN_in_recurse1023); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,ID,FOLLOW_ID_in_recurse1025); if (state.failed) return ;

                    pushFollow(FOLLOW_recurseNoLabel_in_recurse1027);
                    recurseNoLabel();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:203:4: recurseNoLabel
                    {
                    pushFollow(FOLLOW_recurseNoLabel_in_recurse1033);
                    recurseNoLabel();

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
        }
        return ;
    }
    // $ANTLR end "recurse"



    // $ANTLR start "recurseNoLabel"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:206:1: recurseNoLabel :{...}? RULE_REF ;
    public final void recurseNoLabel() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:206:16: ({...}? RULE_REF )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:206:18: {...}? RULE_REF
            {
            if ( !((((CommonTree)input.LT(1)).getText().equals(ruleName))) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "recurseNoLabel", "((CommonTree)input.LT(1)).getText().equals(ruleName)");
            }

            match(input,RULE_REF,FOLLOW_RULE_REF_in_recurseNoLabel1045); if (state.failed) return ;

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
    // $ANTLR end "recurseNoLabel"



    // $ANTLR start "token"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:215:1: token returns [GrammarAST t=null] : ( ^( ASSIGN ID s= token ) | ^( PLUS_ASSIGN ID s= token ) | ^( ROOT s= token ) | ^( BANG s= token ) |a= CHAR_LITERAL |b= STRING_LITERAL |c= TOKEN_REF );
    public final GrammarAST token() throws RecognitionException {
        GrammarAST t = null;


        GrammarAST a=null;
        GrammarAST b=null;
        GrammarAST c=null;
        GrammarAST s =null;


        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:216:2: ( ^( ASSIGN ID s= token ) | ^( PLUS_ASSIGN ID s= token ) | ^( ROOT s= token ) | ^( BANG s= token ) |a= CHAR_LITERAL |b= STRING_LITERAL |c= TOKEN_REF )
            int alt36=7;
            switch ( input.LA(1) ) {
            case ASSIGN:
                {
                alt36=1;
                }
                break;
            case PLUS_ASSIGN:
                {
                alt36=2;
                }
                break;
            case ROOT:
                {
                alt36=3;
                }
                break;
            case BANG:
                {
                alt36=4;
                }
                break;
            case CHAR_LITERAL:
                {
                alt36=5;
                }
                break;
            case STRING_LITERAL:
                {
                alt36=6;
                }
                break;
            case TOKEN_REF:
                {
                alt36=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return t;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;

            }

            switch (alt36) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:216:4: ^( ASSIGN ID s= token )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_token1062); if (state.failed) return t;

                    match(input, Token.DOWN, null); if (state.failed) return t;
                    match(input,ID,FOLLOW_ID_in_token1064); if (state.failed) return t;

                    pushFollow(FOLLOW_token_in_token1068);
                    s=token();

                    state._fsp--;
                    if (state.failed) return t;

                    if ( state.backtracking==0 ) {t = s;}

                    match(input, Token.UP, null); if (state.failed) return t;


                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:217:4: ^( PLUS_ASSIGN ID s= token )
                    {
                    match(input,PLUS_ASSIGN,FOLLOW_PLUS_ASSIGN_in_token1077); if (state.failed) return t;

                    match(input, Token.DOWN, null); if (state.failed) return t;
                    match(input,ID,FOLLOW_ID_in_token1079); if (state.failed) return t;

                    pushFollow(FOLLOW_token_in_token1083);
                    s=token();

                    state._fsp--;
                    if (state.failed) return t;

                    if ( state.backtracking==0 ) {t = s;}

                    match(input, Token.UP, null); if (state.failed) return t;


                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:218:4: ^( ROOT s= token )
                    {
                    match(input,ROOT,FOLLOW_ROOT_in_token1092); if (state.failed) return t;

                    match(input, Token.DOWN, null); if (state.failed) return t;
                    pushFollow(FOLLOW_token_in_token1096);
                    s=token();

                    state._fsp--;
                    if (state.failed) return t;

                    if ( state.backtracking==0 ) {t = s;}

                    match(input, Token.UP, null); if (state.failed) return t;


                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:219:4: ^( BANG s= token )
                    {
                    match(input,BANG,FOLLOW_BANG_in_token1105); if (state.failed) return t;

                    match(input, Token.DOWN, null); if (state.failed) return t;
                    pushFollow(FOLLOW_token_in_token1109);
                    s=token();

                    state._fsp--;
                    if (state.failed) return t;

                    if ( state.backtracking==0 ) {t = s;}

                    match(input, Token.UP, null); if (state.failed) return t;


                    }
                    break;
                case 5 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:220:4: a= CHAR_LITERAL
                    {
                    a=(GrammarAST)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_token1119); if (state.failed) return t;

                    if ( state.backtracking==0 ) {t = a;}

                    }
                    break;
                case 6 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:221:4: b= STRING_LITERAL
                    {
                    b=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_token1133); if (state.failed) return t;

                    if ( state.backtracking==0 ) {t = b;}

                    }
                    break;
                case 7 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:222:4: c= TOKEN_REF
                    {
                    c=(GrammarAST)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_token1145); if (state.failed) return t;

                    if ( state.backtracking==0 ) {t = c;}

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
        return t;
    }
    // $ANTLR end "token"



    // $ANTLR start "exceptionGroup"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:225:1: exceptionGroup : ( ( exceptionHandler )+ ( finallyClause )? | finallyClause );
    public final void exceptionGroup() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:226:2: ( ( exceptionHandler )+ ( finallyClause )? | finallyClause )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==CATCH) ) {
                alt39=1;
            }
            else if ( (LA39_0==FINALLY) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;

            }
            switch (alt39) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:226:4: ( exceptionHandler )+ ( finallyClause )?
                    {
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:226:4: ( exceptionHandler )+
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
                    	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:226:4: exceptionHandler
                    	    {
                    	    pushFollow(FOLLOW_exceptionHandler_in_exceptionGroup1166);
                    	    exceptionHandler();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt37 >= 1 ) break loop37;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(37, input);
                                throw eee;
                        }
                        cnt37++;
                    } while (true);


                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:226:22: ( finallyClause )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==FINALLY) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:226:22: finallyClause
                            {
                            pushFollow(FOLLOW_finallyClause_in_exceptionGroup1169);
                            finallyClause();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:227:4: finallyClause
                    {
                    pushFollow(FOLLOW_finallyClause_in_exceptionGroup1175);
                    finallyClause();

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
        }
        return ;
    }
    // $ANTLR end "exceptionGroup"



    // $ANTLR start "exceptionHandler"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:230:1: exceptionHandler : ^( 'catch' ARG_ACTION ACTION ) ;
    public final void exceptionHandler() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:231:2: ( ^( 'catch' ARG_ACTION ACTION ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:231:4: ^( 'catch' ARG_ACTION ACTION )
            {
            match(input,CATCH,FOLLOW_CATCH_in_exceptionHandler1190); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_exceptionHandler1192); if (state.failed) return ;

            match(input,ACTION,FOLLOW_ACTION_in_exceptionHandler1194); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:234:1: finallyClause : ^( 'finally' ACTION ) ;
    public final void finallyClause() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:235:2: ( ^( 'finally' ACTION ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:235:4: ^( 'finally' ACTION )
            {
            match(input,FINALLY,FOLLOW_FINALLY_in_finallyClause1207); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            match(input,ACTION,FOLLOW_ACTION_in_finallyClause1209); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:238:1: rewrite : ^( REWRITES ( ^( REWRITE ( SEMPRED )? ( ^( ALT ( . )* ) | ^( TEMPLATE ( . )* ) | ACTION | ETC ) ) )* ) ;
    public final void rewrite() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:239:2: ( ^( REWRITES ( ^( REWRITE ( SEMPRED )? ( ^( ALT ( . )* ) | ^( TEMPLATE ( . )* ) | ACTION | ETC ) ) )* ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:239:4: ^( REWRITES ( ^( REWRITE ( SEMPRED )? ( ^( ALT ( . )* ) | ^( TEMPLATE ( . )* ) | ACTION | ETC ) ) )* )
            {
            match(input,REWRITES,FOLLOW_REWRITES_in_rewrite1222); if (state.failed) return ;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return ;
                // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:239:15: ( ^( REWRITE ( SEMPRED )? ( ^( ALT ( . )* ) | ^( TEMPLATE ( . )* ) | ACTION | ETC ) ) )*
                loop44:
                do {
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==REWRITE) ) {
                        alt44=1;
                    }


                    switch (alt44) {
                	case 1 :
                	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:239:17: ^( REWRITE ( SEMPRED )? ( ^( ALT ( . )* ) | ^( TEMPLATE ( . )* ) | ACTION | ETC ) )
                	    {
                	    match(input,REWRITE,FOLLOW_REWRITE_in_rewrite1228); if (state.failed) return ;

                	    match(input, Token.DOWN, null); if (state.failed) return ;
                	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:239:28: ( SEMPRED )?
                	    int alt40=2;
                	    int LA40_0 = input.LA(1);

                	    if ( (LA40_0==SEMPRED) ) {
                	        alt40=1;
                	    }
                	    switch (alt40) {
                	        case 1 :
                	            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:239:28: SEMPRED
                	            {
                	            match(input,SEMPRED,FOLLOW_SEMPRED_in_rewrite1230); if (state.failed) return ;

                	            }
                	            break;

                	    }


                	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:239:37: ( ^( ALT ( . )* ) | ^( TEMPLATE ( . )* ) | ACTION | ETC )
                	    int alt43=4;
                	    switch ( input.LA(1) ) {
                	    case ALT:
                	        {
                	        alt43=1;
                	        }
                	        break;
                	    case TEMPLATE:
                	        {
                	        alt43=2;
                	        }
                	        break;
                	    case ACTION:
                	        {
                	        alt43=3;
                	        }
                	        break;
                	    case ETC:
                	        {
                	        alt43=4;
                	        }
                	        break;
                	    default:
                	        if (state.backtracking>0) {state.failed=true; return ;}
                	        NoViableAltException nvae =
                	            new NoViableAltException("", 43, 0, input);

                	        throw nvae;

                	    }

                	    switch (alt43) {
                	        case 1 :
                	            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:239:38: ^( ALT ( . )* )
                	            {
                	            match(input,ALT,FOLLOW_ALT_in_rewrite1235); if (state.failed) return ;

                	            if ( input.LA(1)==Token.DOWN ) {
                	                match(input, Token.DOWN, null); if (state.failed) return ;
                	                // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:239:44: ( . )*
                	                loop41:
                	                do {
                	                    int alt41=2;
                	                    int LA41_0 = input.LA(1);

                	                    if ( ((LA41_0 >= ACTION && LA41_0 <= XDIGIT)) ) {
                	                        alt41=1;
                	                    }
                	                    else if ( (LA41_0==UP) ) {
                	                        alt41=2;
                	                    }


                	                    switch (alt41) {
                	                	case 1 :
                	                	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:239:44: .
                	                	    {
                	                	    matchAny(input); if (state.failed) return ;

                	                	    }
                	                	    break;

                	                	default :
                	                	    break loop41;
                	                    }
                	                } while (true);


                	                match(input, Token.UP, null); if (state.failed) return ;
                	            }


                	            }
                	            break;
                	        case 2 :
                	            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:239:48: ^( TEMPLATE ( . )* )
                	            {
                	            match(input,TEMPLATE,FOLLOW_TEMPLATE_in_rewrite1242); if (state.failed) return ;

                	            if ( input.LA(1)==Token.DOWN ) {
                	                match(input, Token.DOWN, null); if (state.failed) return ;
                	                // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:239:59: ( . )*
                	                loop42:
                	                do {
                	                    int alt42=2;
                	                    int LA42_0 = input.LA(1);

                	                    if ( ((LA42_0 >= ACTION && LA42_0 <= XDIGIT)) ) {
                	                        alt42=1;
                	                    }
                	                    else if ( (LA42_0==UP) ) {
                	                        alt42=2;
                	                    }


                	                    switch (alt42) {
                	                	case 1 :
                	                	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:239:59: .
                	                	    {
                	                	    matchAny(input); if (state.failed) return ;

                	                	    }
                	                	    break;

                	                	default :
                	                	    break loop42;
                	                    }
                	                } while (true);


                	                match(input, Token.UP, null); if (state.failed) return ;
                	            }


                	            }
                	            break;
                	        case 3 :
                	            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:239:63: ACTION
                	            {
                	            match(input,ACTION,FOLLOW_ACTION_in_rewrite1248); if (state.failed) return ;

                	            }
                	            break;
                	        case 4 :
                	            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:239:70: ETC
                	            {
                	            match(input,ETC,FOLLOW_ETC_in_rewrite1250); if (state.failed) return ;

                	            }
                	            break;

                	    }


                	    match(input, Token.UP, null); if (state.failed) return ;


                	    }
                	    break;

                	default :
                	    break loop44;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return ;
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
    // $ANTLR end "rewrite"



    // $ANTLR start "element"
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:242:1: element : ( ^( ROOT element ) | ^( BANG element ) | atom | ^( NOT element ) | ^( RANGE atom atom ) | ^( ASSIGN ID element ) | ^( PLUS_ASSIGN ID element ) | ebnf | tree_ | ^( SYNPRED block ) | FORCED_ACTION | ACTION | SEMPRED | SYN_SEMPRED | BACKTRACK_SEMPRED | GATED_SEMPRED | EPSILON );
    public final void element() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:243:2: ( ^( ROOT element ) | ^( BANG element ) | atom | ^( NOT element ) | ^( RANGE atom atom ) | ^( ASSIGN ID element ) | ^( PLUS_ASSIGN ID element ) | ebnf | tree_ | ^( SYNPRED block ) | FORCED_ACTION | ACTION | SEMPRED | SYN_SEMPRED | BACKTRACK_SEMPRED | GATED_SEMPRED | EPSILON )
            int alt45=17;
            switch ( input.LA(1) ) {
            case ROOT:
                {
                alt45=1;
                }
                break;
            case BANG:
                {
                alt45=2;
                }
                break;
            case CHAR_LITERAL:
            case DOT:
            case RULE_REF:
            case STRING_LITERAL:
            case TOKEN_REF:
            case WILDCARD:
                {
                alt45=3;
                }
                break;
            case NOT:
                {
                alt45=4;
                }
                break;
            case RANGE:
                {
                alt45=5;
                }
                break;
            case ASSIGN:
                {
                alt45=6;
                }
                break;
            case PLUS_ASSIGN:
                {
                alt45=7;
                }
                break;
            case BLOCK:
            case CLOSURE:
            case OPTIONAL:
            case POSITIVE_CLOSURE:
                {
                alt45=8;
                }
                break;
            case TREE_BEGIN:
                {
                alt45=9;
                }
                break;
            case SYNPRED:
                {
                alt45=10;
                }
                break;
            case FORCED_ACTION:
                {
                alt45=11;
                }
                break;
            case ACTION:
                {
                alt45=12;
                }
                break;
            case SEMPRED:
                {
                alt45=13;
                }
                break;
            case SYN_SEMPRED:
                {
                alt45=14;
                }
                break;
            case BACKTRACK_SEMPRED:
                {
                alt45=15;
                }
                break;
            case GATED_SEMPRED:
                {
                alt45=16;
                }
                break;
            case EPSILON:
                {
                alt45=17;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;

            }

            switch (alt45) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:243:4: ^( ROOT element )
                    {
                    match(input,ROOT,FOLLOW_ROOT_in_element1270); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_element_in_element1272);
                    element();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:244:4: ^( BANG element )
                    {
                    match(input,BANG,FOLLOW_BANG_in_element1279); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_element_in_element1281);
                    element();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:245:4: atom
                    {
                    pushFollow(FOLLOW_atom_in_element1287);
                    atom();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:246:4: ^( NOT element )
                    {
                    match(input,NOT,FOLLOW_NOT_in_element1293); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_element_in_element1295);
                    element();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;
                case 5 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:247:4: ^( RANGE atom atom )
                    {
                    match(input,RANGE,FOLLOW_RANGE_in_element1302); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_atom_in_element1304);
                    atom();

                    state._fsp--;
                    if (state.failed) return ;

                    pushFollow(FOLLOW_atom_in_element1306);
                    atom();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;
                case 6 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:248:4: ^( ASSIGN ID element )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_element1313); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,ID,FOLLOW_ID_in_element1315); if (state.failed) return ;

                    pushFollow(FOLLOW_element_in_element1317);
                    element();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;
                case 7 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:249:4: ^( PLUS_ASSIGN ID element )
                    {
                    match(input,PLUS_ASSIGN,FOLLOW_PLUS_ASSIGN_in_element1324); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,ID,FOLLOW_ID_in_element1326); if (state.failed) return ;

                    pushFollow(FOLLOW_element_in_element1328);
                    element();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;
                case 8 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:250:4: ebnf
                    {
                    pushFollow(FOLLOW_ebnf_in_element1334);
                    ebnf();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 9 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:251:4: tree_
                    {
                    pushFollow(FOLLOW_tree__in_element1339);
                    tree_();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 10 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:252:4: ^( SYNPRED block )
                    {
                    match(input,SYNPRED,FOLLOW_SYNPRED_in_element1345); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_block_in_element1347);
                    block();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;
                case 11 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:253:4: FORCED_ACTION
                    {
                    match(input,FORCED_ACTION,FOLLOW_FORCED_ACTION_in_element1354); if (state.failed) return ;

                    }
                    break;
                case 12 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:254:4: ACTION
                    {
                    match(input,ACTION,FOLLOW_ACTION_in_element1359); if (state.failed) return ;

                    }
                    break;
                case 13 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:255:4: SEMPRED
                    {
                    match(input,SEMPRED,FOLLOW_SEMPRED_in_element1364); if (state.failed) return ;

                    }
                    break;
                case 14 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:256:4: SYN_SEMPRED
                    {
                    match(input,SYN_SEMPRED,FOLLOW_SYN_SEMPRED_in_element1369); if (state.failed) return ;

                    }
                    break;
                case 15 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:257:4: BACKTRACK_SEMPRED
                    {
                    match(input,BACKTRACK_SEMPRED,FOLLOW_BACKTRACK_SEMPRED_in_element1374); if (state.failed) return ;

                    }
                    break;
                case 16 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:258:4: GATED_SEMPRED
                    {
                    match(input,GATED_SEMPRED,FOLLOW_GATED_SEMPRED_in_element1379); if (state.failed) return ;

                    }
                    break;
                case 17 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:259:4: EPSILON
                    {
                    match(input,EPSILON,FOLLOW_EPSILON_in_element1384); if (state.failed) return ;

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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:262:1: ebnf : ( block | ^( OPTIONAL block ) | ^( CLOSURE block ) | ^( POSITIVE_CLOSURE block ) );
    public final void ebnf() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:262:5: ( block | ^( OPTIONAL block ) | ^( CLOSURE block ) | ^( POSITIVE_CLOSURE block ) )
            int alt46=4;
            switch ( input.LA(1) ) {
            case BLOCK:
                {
                alt46=1;
                }
                break;
            case OPTIONAL:
                {
                alt46=2;
                }
                break;
            case CLOSURE:
                {
                alt46=3;
                }
                break;
            case POSITIVE_CLOSURE:
                {
                alt46=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;

            }

            switch (alt46) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:262:9: block
                    {
                    pushFollow(FOLLOW_block_in_ebnf1396);
                    block();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:263:9: ^( OPTIONAL block )
                    {
                    match(input,OPTIONAL,FOLLOW_OPTIONAL_in_ebnf1408); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_block_in_ebnf1410);
                    block();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:264:9: ^( CLOSURE block )
                    {
                    match(input,CLOSURE,FOLLOW_CLOSURE_in_ebnf1425); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_block_in_ebnf1427);
                    block();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:265:9: ^( POSITIVE_CLOSURE block )
                    {
                    match(input,POSITIVE_CLOSURE,FOLLOW_POSITIVE_CLOSURE_in_ebnf1443); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_block_in_ebnf1445);
                    block();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:268:1: tree_ : ^( TREE_BEGIN ( element )+ ) ;
    public final void tree_() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:269:2: ( ^( TREE_BEGIN ( element )+ ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:269:4: ^( TREE_BEGIN ( element )+ )
            {
            match(input,TREE_BEGIN,FOLLOW_TREE_BEGIN_in_tree_1463); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:269:17: ( element )+
            int cnt47=0;
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==ACTION||(LA47_0 >= ASSIGN && LA47_0 <= BLOCK)||LA47_0==CHAR_LITERAL||LA47_0==CLOSURE||LA47_0==DOT||LA47_0==EPSILON||LA47_0==FORCED_ACTION||LA47_0==GATED_SEMPRED||LA47_0==NOT||LA47_0==OPTIONAL||(LA47_0 >= PLUS_ASSIGN && LA47_0 <= POSITIVE_CLOSURE)||LA47_0==RANGE||LA47_0==ROOT||LA47_0==RULE_REF||LA47_0==SEMPRED||(LA47_0 >= STRING_LITERAL && LA47_0 <= SYN_SEMPRED)||LA47_0==TOKEN_REF||LA47_0==TREE_BEGIN||LA47_0==WILDCARD) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:269:17: element
            	    {
            	    pushFollow(FOLLOW_element_in_tree_1465);
            	    element();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt47 >= 1 ) break loop47;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(47, input);
                        throw eee;
                }
                cnt47++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return ;


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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:272:1: atom : ( ^( RULE_REF ( ARG_ACTION )? ) | ^( TOKEN_REF ( ARG_ACTION )? ) | CHAR_LITERAL | STRING_LITERAL | WILDCARD | ^( DOT ID atom ) );
    public final void atom() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:273:2: ( ^( RULE_REF ( ARG_ACTION )? ) | ^( TOKEN_REF ( ARG_ACTION )? ) | CHAR_LITERAL | STRING_LITERAL | WILDCARD | ^( DOT ID atom ) )
            int alt50=6;
            switch ( input.LA(1) ) {
            case RULE_REF:
                {
                alt50=1;
                }
                break;
            case TOKEN_REF:
                {
                alt50=2;
                }
                break;
            case CHAR_LITERAL:
                {
                alt50=3;
                }
                break;
            case STRING_LITERAL:
                {
                alt50=4;
                }
                break;
            case WILDCARD:
                {
                alt50=5;
                }
                break;
            case DOT:
                {
                alt50=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;

            }

            switch (alt50) {
                case 1 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:273:4: ^( RULE_REF ( ARG_ACTION )? )
                    {
                    match(input,RULE_REF,FOLLOW_RULE_REF_in_atom1479); if (state.failed) return ;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return ;
                        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:273:15: ( ARG_ACTION )?
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==ARG_ACTION) ) {
                            alt48=1;
                        }
                        switch (alt48) {
                            case 1 :
                                // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:273:15: ARG_ACTION
                                {
                                match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_atom1481); if (state.failed) return ;

                                }
                                break;

                        }


                        match(input, Token.UP, null); if (state.failed) return ;
                    }


                    }
                    break;
                case 2 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:274:4: ^( TOKEN_REF ( ARG_ACTION )? )
                    {
                    match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_atom1489); if (state.failed) return ;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return ;
                        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:274:16: ( ARG_ACTION )?
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==ARG_ACTION) ) {
                            alt49=1;
                        }
                        switch (alt49) {
                            case 1 :
                                // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:274:16: ARG_ACTION
                                {
                                match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_atom1491); if (state.failed) return ;

                                }
                                break;

                        }


                        match(input, Token.UP, null); if (state.failed) return ;
                    }


                    }
                    break;
                case 3 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:275:4: CHAR_LITERAL
                    {
                    match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_atom1498); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:276:4: STRING_LITERAL
                    {
                    match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_atom1503); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:277:4: WILDCARD
                    {
                    match(input,WILDCARD,FOLLOW_WILDCARD_in_atom1508); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:278:4: ^( DOT ID atom )
                    {
                    match(input,DOT,FOLLOW_DOT_in_atom1514); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,ID,FOLLOW_ID_in_atom1516); if (state.failed) return ;

                    pushFollow(FOLLOW_atom_in_atom1518);
                    atom();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


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
    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:281:1: ast_suffix : ( ROOT | BANG );
    public final void ast_suffix() throws RecognitionException {
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:282:2: ( ROOT | BANG )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:
            {
            if ( input.LA(1)==BANG||input.LA(1)==ROOT ) {
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
        }
        return ;
    }
    // $ANTLR end "ast_suffix"

    // $ANTLR start synpred1_LeftRecursiveRuleWalker
    public final void synpred1_LeftRecursiveRuleWalker_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:170:9: ( binaryMultipleOp )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:170:10: binaryMultipleOp
        {
        pushFollow(FOLLOW_binaryMultipleOp_in_synpred1_LeftRecursiveRuleWalker478);
        binaryMultipleOp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred1_LeftRecursiveRuleWalker

    // $ANTLR start synpred2_LeftRecursiveRuleWalker
    public final void synpred2_LeftRecursiveRuleWalker_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:172:9: ( binary )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:172:10: binary
        {
        pushFollow(FOLLOW_binary_in_synpred2_LeftRecursiveRuleWalker524);
        binary();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred2_LeftRecursiveRuleWalker

    // $ANTLR start synpred3_LeftRecursiveRuleWalker
    public final void synpred3_LeftRecursiveRuleWalker_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:174:9: ( ternary )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:174:10: ternary
        {
        pushFollow(FOLLOW_ternary_in_synpred3_LeftRecursiveRuleWalker587);
        ternary();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred3_LeftRecursiveRuleWalker

    // $ANTLR start synpred4_LeftRecursiveRuleWalker
    public final void synpred4_LeftRecursiveRuleWalker_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:176:9: ( prefix )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:176:10: prefix
        {
        pushFollow(FOLLOW_prefix_in_synpred4_LeftRecursiveRuleWalker642);
        prefix();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred4_LeftRecursiveRuleWalker

    // $ANTLR start synpred5_LeftRecursiveRuleWalker
    public final void synpred5_LeftRecursiveRuleWalker_fragment() throws RecognitionException {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:178:9: ( suffix )
        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/tool/src/main/antlr3/org/antlr/grammar/v3/LeftRecursiveRuleWalker.g:178:10: suffix
        {
        pushFollow(FOLLOW_suffix_in_synpred5_LeftRecursiveRuleWalker698);
        suffix();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred5_LeftRecursiveRuleWalker

    // Delegated rules

    public final boolean synpred5_LeftRecursiveRuleWalker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_LeftRecursiveRuleWalker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_LeftRecursiveRuleWalker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_LeftRecursiveRuleWalker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_LeftRecursiveRuleWalker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_LeftRecursiveRuleWalker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_LeftRecursiveRuleWalker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_LeftRecursiveRuleWalker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_LeftRecursiveRuleWalker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_LeftRecursiveRuleWalker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_OPTIONS_in_optionsSpec51 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_option_in_optionsSpec53 = new BitSet(new long[]{0x0000000000002008L});
    public static final BitSet FOLLOW_ASSIGN_in_option67 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_option69 = new BitSet(new long[]{0x0000880000040000L,0x0000000001000000L});
    public static final BitSet FOLLOW_optionValue_in_option71 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_charSetElement109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_charSetElement115 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_charSetElement117 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_charSetElement119 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANGE_in_charSetElement126 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_charSetElement128 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_charSetElement130 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_in_rec_rule158 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_rec_rule162 = new BitSet(new long[]{0x0000010000000400L,0x000000000000001CL});
    public static final BitSet FOLLOW_modifier_in_rec_rule169 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ARG_in_rec_rule176 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_rec_rule178 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RET_in_rec_rule186 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_rec_rule188 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_optionsSpec_in_rec_rule195 = new BitSet(new long[]{0x0000000000010200L,0x0000000000020000L});
    public static final BitSet FOLLOW_ruleScopeSpec_in_rec_rule201 = new BitSet(new long[]{0x0000000000010200L});
    public static final BitSet FOLLOW_AMPERSAND_in_rec_rule209 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ruleBlock_in_rec_rule220 = new BitSet(new long[]{0x0000004400020000L});
    public static final BitSet FOLLOW_exceptionGroup_in_rec_rule227 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_EOR_in_rec_rule233 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SCOPE_in_ruleScopeSpec280 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ACTION_in_ruleScopeSpec282 = new BitSet(new long[]{0x0000080000000008L});
    public static final BitSet FOLLOW_ID_in_ruleScopeSpec285 = new BitSet(new long[]{0x0000080000000008L});
    public static final BitSet FOLLOW_BLOCK_in_ruleBlock309 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_optionsSpec_in_ruleBlock314 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_outerAlternative_in_ruleBlock322 = new BitSet(new long[]{0x0000000200000100L,0x0000000000001000L});
    public static final BitSet FOLLOW_rewrite_in_ruleBlock334 = new BitSet(new long[]{0x0000000200000100L});
    public static final BitSet FOLLOW_EOB_in_ruleBlock352 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BLOCK_in_block375 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_optionsSpec_in_block389 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ALT_in_block407 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_block409 = new BitSet(new long[]{0x828002892025E010L,0x0000000547092041L});
    public static final BitSet FOLLOW_EOA_in_block412 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rewrite_in_block415 = new BitSet(new long[]{0x0000000200000100L});
    public static final BitSet FOLLOW_EOB_in_block433 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_binaryMultipleOp_in_outerAlternative482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binary_in_outerAlternative538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ternary_in_outerAlternative600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prefix_in_outerAlternative656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_suffix_in_outerAlternative712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALT_in_outerAlternative754 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_outerAlternative756 = new BitSet(new long[]{0x828002892025E010L,0x0000000547092041L});
    public static final BitSet FOLLOW_EOA_in_outerAlternative759 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ALT_in_binary808 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BACKTRACK_SEMPRED_in_binary812 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_recurseNoLabel_in_binary820 = new BitSet(new long[]{0x800000000004A000L,0x0000000041002000L});
    public static final BitSet FOLLOW_token_in_binary824 = new BitSet(new long[]{0x8000000000002000L,0x0000000000010000L});
    public static final BitSet FOLLOW_recurse_in_binary826 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_EOA_in_binary828 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ALT_in_binaryMultipleOp845 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BACKTRACK_SEMPRED_in_binaryMultipleOp849 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_recurseNoLabel_in_binaryMultipleOp857 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_BLOCK_in_binaryMultipleOp861 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ALT_in_binaryMultipleOp867 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_token_in_binaryMultipleOp871 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_EOA_in_binaryMultipleOp873 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EOB_in_binaryMultipleOp882 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_recurse_in_binaryMultipleOp886 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_EOA_in_binaryMultipleOp888 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ALT_in_ternary903 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BACKTRACK_SEMPRED_in_ternary907 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_recurseNoLabel_in_ternary915 = new BitSet(new long[]{0x800000000004A000L,0x0000000041002000L});
    public static final BitSet FOLLOW_token_in_ternary919 = new BitSet(new long[]{0x8000000000002000L,0x0000000000010000L});
    public static final BitSet FOLLOW_recurse_in_ternary921 = new BitSet(new long[]{0x800000000004A000L,0x0000000041002000L});
    public static final BitSet FOLLOW_token_in_ternary923 = new BitSet(new long[]{0x8000000000002000L,0x0000000000010000L});
    public static final BitSet FOLLOW_recurse_in_ternary925 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_EOA_in_ternary927 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ALT_in_prefix943 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BACKTRACK_SEMPRED_in_prefix947 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_prefix960 = new BitSet(new long[]{0x828002882025E010L,0x0000000547092041L});
    public static final BitSet FOLLOW_recurse_in_prefix964 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_EOA_in_prefix966 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ALT_in_suffix979 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BACKTRACK_SEMPRED_in_suffix983 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_recurseNoLabel_in_suffix991 = new BitSet(new long[]{0x828002882025E010L,0x0000000547092041L});
    public static final BitSet FOLLOW_element_in_suffix995 = new BitSet(new long[]{0x828002892025E010L,0x0000000547092041L});
    public static final BitSet FOLLOW_EOA_in_suffix999 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_recurse1012 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_recurse1014 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_recurseNoLabel_in_recurse1016 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_ASSIGN_in_recurse1023 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_recurse1025 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_recurseNoLabel_in_recurse1027 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_recurseNoLabel_in_recurse1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REF_in_recurseNoLabel1045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_token1062 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_token1064 = new BitSet(new long[]{0x800000000004A000L,0x0000000041002000L});
    public static final BitSet FOLLOW_token_in_token1068 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_ASSIGN_in_token1077 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_token1079 = new BitSet(new long[]{0x800000000004A000L,0x0000000041002000L});
    public static final BitSet FOLLOW_token_in_token1083 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ROOT_in_token1092 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_token_in_token1096 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BANG_in_token1105 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_token_in_token1109 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_token1119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_token1133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKEN_REF_in_token1145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exceptionHandler_in_exceptionGroup1166 = new BitSet(new long[]{0x0000004000020002L});
    public static final BitSet FOLLOW_finallyClause_in_exceptionGroup1169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_finallyClause_in_exceptionGroup1175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CATCH_in_exceptionHandler1190 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_exceptionHandler1192 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ACTION_in_exceptionHandler1194 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FINALLY_in_finallyClause1207 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ACTION_in_finallyClause1209 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REWRITES_in_rewrite1222 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_REWRITE_in_rewrite1228 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SEMPRED_in_rewrite1230 = new BitSet(new long[]{0x0000002000000110L,0x0000000008000000L});
    public static final BitSet FOLLOW_ALT_in_rewrite1235 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TEMPLATE_in_rewrite1242 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ACTION_in_rewrite1248 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ETC_in_rewrite1250 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ROOT_in_element1270 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_element1272 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BANG_in_element1279 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_element1281 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_atom_in_element1287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_element1293 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_element1295 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANGE_in_element1302 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_atom_in_element1304 = new BitSet(new long[]{0x0000000020040000L,0x0000000441010000L});
    public static final BitSet FOLLOW_atom_in_element1306 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_element1313 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_element1315 = new BitSet(new long[]{0x828002882025E010L,0x0000000547092041L});
    public static final BitSet FOLLOW_element_in_element1317 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_ASSIGN_in_element1324 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_element1326 = new BitSet(new long[]{0x828002882025E010L,0x0000000547092041L});
    public static final BitSet FOLLOW_element_in_element1328 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ebnf_in_element1334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tree__in_element1339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYNPRED_in_element1345 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_element1347 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FORCED_ACTION_in_element1354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_element1359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMPRED_in_element1364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SYN_SEMPRED_in_element1369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BACKTRACK_SEMPRED_in_element1374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GATED_SEMPRED_in_element1379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EPSILON_in_element1384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_ebnf1396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPTIONAL_in_ebnf1408 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_ebnf1410 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CLOSURE_in_ebnf1425 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_ebnf1427 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POSITIVE_CLOSURE_in_ebnf1443 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_ebnf1445 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TREE_BEGIN_in_tree_1463 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_tree_1465 = new BitSet(new long[]{0x828002882025E018L,0x0000000547092041L});
    public static final BitSet FOLLOW_RULE_REF_in_atom1479 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_atom1481 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TOKEN_REF_in_atom1489 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_atom1491 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_atom1498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_atom1503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WILDCARD_in_atom1508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_atom1514 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_atom1516 = new BitSet(new long[]{0x0000000020040000L,0x0000000441010000L});
    public static final BitSet FOLLOW_atom_in_atom1518 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_binaryMultipleOp_in_synpred1_LeftRecursiveRuleWalker478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binary_in_synpred2_LeftRecursiveRuleWalker524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ternary_in_synpred3_LeftRecursiveRuleWalker587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prefix_in_synpred4_LeftRecursiveRuleWalker642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_suffix_in_synpred5_LeftRecursiveRuleWalker698 = new BitSet(new long[]{0x0000000000000002L});

}