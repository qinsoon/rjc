# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g 2013-01-03 10:52:49

import sys
from antlr3 import *
from antlr3.compat import set, frozenset



# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EOF=-1
T__7=7
T__8=8
T__9=9
T__10=10
T__11=11
T__12=12
T__13=13
T__14=14
T__15=15
T__16=16
T__17=17
T__18=18
T__19=19
T__20=20
ID=4
INT=5
WS=6

# token names
tokenNames = [
    "<invalid>", "<EOR>", "<DOWN>", "<UP>",
    "ID", "INT", "WS", "'('", "')'", "'+'", "','", "';'", "'<'", "'='", 
    "'=='", "'char'", "'for'", "'int'", "'void'", "'{'", "'}'"
]




class t017parserParser(Parser):
    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g"
    api_version = 1
    tokenNames = tokenNames

    def __init__(self, input, state=None, *args, **kwargs):
        if state is None:
            state = RecognizerSharedState()

        super(t017parserParser, self).__init__(input, state, *args, **kwargs)

        self.dfa2 = self.DFA2(
            self, 2,
            eot = self.DFA2_eot,
            eof = self.DFA2_eof,
            min = self.DFA2_min,
            max = self.DFA2_max,
            accept = self.DFA2_accept,
            special = self.DFA2_special,
            transition = self.DFA2_transition
            )




        self.delegates = []






    # $ANTLR start "program"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:7:1: program : ( declaration )+ ;
    def program(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:8:5: ( ( declaration )+ )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:8:9: ( declaration )+
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:8:9: ( declaration )+
                cnt1 = 0
                while True: #loop1
                    alt1 = 2
                    LA1_0 = self.input.LA(1)

                    if (LA1_0 == ID or LA1_0 == 15 or (17 <= LA1_0 <= 18)) :
                        alt1 = 1


                    if alt1 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:8:9: declaration
                        pass 
                        self._state.following.append(self.FOLLOW_declaration_in_program32)
                        self.declaration()

                        self._state.following.pop()


                    else:
                        if cnt1 >= 1:
                            break #loop1

                        eee = EarlyExitException(1, self.input)
                        raise eee

                    cnt1 += 1





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "program"



    # $ANTLR start "declaration"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:11:1: declaration : ( variable | functionHeader ';' | functionHeader block );
    def declaration(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:12:5: ( variable | functionHeader ';' | functionHeader block )
                alt2 = 3
                alt2 = self.dfa2.predict(self.input)
                if alt2 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:12:9: variable
                    pass 
                    self._state.following.append(self.FOLLOW_variable_in_declaration52)
                    self.variable()

                    self._state.following.pop()


                elif alt2 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:13:9: functionHeader ';'
                    pass 
                    self._state.following.append(self.FOLLOW_functionHeader_in_declaration62)
                    self.functionHeader()

                    self._state.following.pop()

                    self.match(self.input, 11, self.FOLLOW_11_in_declaration64)


                elif alt2 == 3:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:14:9: functionHeader block
                    pass 
                    self._state.following.append(self.FOLLOW_functionHeader_in_declaration74)
                    self.functionHeader()

                    self._state.following.pop()

                    self._state.following.append(self.FOLLOW_block_in_declaration76)
                    self.block()

                    self._state.following.pop()



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "declaration"



    # $ANTLR start "variable"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:17:1: variable : type declarator ';' ;
    def variable(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:18:5: ( type declarator ';' )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:18:9: type declarator ';'
                pass 
                self._state.following.append(self.FOLLOW_type_in_variable95)
                self.type()

                self._state.following.pop()

                self._state.following.append(self.FOLLOW_declarator_in_variable97)
                self.declarator()

                self._state.following.pop()

                self.match(self.input, 11, self.FOLLOW_11_in_variable99)




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "variable"



    # $ANTLR start "declarator"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:21:1: declarator : ID ;
    def declarator(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:22:5: ( ID )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:22:9: ID
                pass 
                self.match(self.input, ID, self.FOLLOW_ID_in_declarator118)




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "declarator"



    # $ANTLR start "functionHeader"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:25:1: functionHeader : type ID '(' ( formalParameter ( ',' formalParameter )* )? ')' ;
    def functionHeader(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:26:5: ( type ID '(' ( formalParameter ( ',' formalParameter )* )? ')' )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:26:9: type ID '(' ( formalParameter ( ',' formalParameter )* )? ')'
                pass 
                self._state.following.append(self.FOLLOW_type_in_functionHeader138)
                self.type()

                self._state.following.pop()

                self.match(self.input, ID, self.FOLLOW_ID_in_functionHeader140)

                self.match(self.input, 7, self.FOLLOW_7_in_functionHeader142)

                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:26:21: ( formalParameter ( ',' formalParameter )* )?
                alt4 = 2
                LA4_0 = self.input.LA(1)

                if (LA4_0 == ID or LA4_0 == 15 or (17 <= LA4_0 <= 18)) :
                    alt4 = 1
                if alt4 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:26:23: formalParameter ( ',' formalParameter )*
                    pass 
                    self._state.following.append(self.FOLLOW_formalParameter_in_functionHeader146)
                    self.formalParameter()

                    self._state.following.pop()

                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:26:39: ( ',' formalParameter )*
                    while True: #loop3
                        alt3 = 2
                        LA3_0 = self.input.LA(1)

                        if (LA3_0 == 10) :
                            alt3 = 1


                        if alt3 == 1:
                            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:26:41: ',' formalParameter
                            pass 
                            self.match(self.input, 10, self.FOLLOW_10_in_functionHeader150)

                            self._state.following.append(self.FOLLOW_formalParameter_in_functionHeader152)
                            self.formalParameter()

                            self._state.following.pop()


                        else:
                            break #loop3





                self.match(self.input, 8, self.FOLLOW_8_in_functionHeader160)




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "functionHeader"



    # $ANTLR start "formalParameter"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:29:1: formalParameter : type declarator ;
    def formalParameter(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:30:5: ( type declarator )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:30:9: type declarator
                pass 
                self._state.following.append(self.FOLLOW_type_in_formalParameter179)
                self.type()

                self._state.following.pop()

                self._state.following.append(self.FOLLOW_declarator_in_formalParameter181)
                self.declarator()

                self._state.following.pop()




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "formalParameter"



    # $ANTLR start "type"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:33:1: type : ( 'int' | 'char' | 'void' | ID );
    def type(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:34:5: ( 'int' | 'char' | 'void' | ID )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:
                pass 
                if self.input.LA(1) == ID or self.input.LA(1) == 15 or (17 <= self.input.LA(1) <= 18):
                    self.input.consume()
                    self._state.errorRecovery = False


                else:
                    mse = MismatchedSetException(None, self.input)
                    raise mse






            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "type"



    # $ANTLR start "block"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:40:1: block : '{' ( variable )* ( stat )* '}' ;
    def block(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:41:5: ( '{' ( variable )* ( stat )* '}' )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:41:9: '{' ( variable )* ( stat )* '}'
                pass 
                self.match(self.input, 19, self.FOLLOW_19_in_block270)

                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:42:13: ( variable )*
                while True: #loop5
                    alt5 = 2
                    LA5_0 = self.input.LA(1)

                    if (LA5_0 == ID) :
                        LA5_2 = self.input.LA(2)

                        if (LA5_2 == ID) :
                            alt5 = 1


                    elif (LA5_0 == 15 or (17 <= LA5_0 <= 18)) :
                        alt5 = 1


                    if alt5 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:42:13: variable
                        pass 
                        self._state.following.append(self.FOLLOW_variable_in_block284)
                        self.variable()

                        self._state.following.pop()


                    else:
                        break #loop5


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:43:13: ( stat )*
                while True: #loop6
                    alt6 = 2
                    LA6_0 = self.input.LA(1)

                    if ((ID <= LA6_0 <= INT) or LA6_0 == 7 or LA6_0 == 11 or LA6_0 == 16 or LA6_0 == 19) :
                        alt6 = 1


                    if alt6 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:43:13: stat
                        pass 
                        self._state.following.append(self.FOLLOW_stat_in_block299)
                        self.stat()

                        self._state.following.pop()


                    else:
                        break #loop6


                self.match(self.input, 20, self.FOLLOW_20_in_block310)




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "block"



    # $ANTLR start "stat"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:47:1: stat : ( forStat | expr ';' | block | assignStat ';' | ';' );
    def stat(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:47:5: ( forStat | expr ';' | block | assignStat ';' | ';' )
                alt7 = 5
                LA7 = self.input.LA(1)
                if LA7 == 16:
                    alt7 = 1
                elif LA7 == ID:
                    LA7_2 = self.input.LA(2)

                    if (LA7_2 == 13) :
                        alt7 = 4
                    elif (LA7_2 == 9 or (11 <= LA7_2 <= 12) or LA7_2 == 14) :
                        alt7 = 2
                    else:
                        nvae = NoViableAltException("", 7, 2, self.input)

                        raise nvae


                elif LA7 == INT or LA7 == 7:
                    alt7 = 2
                elif LA7 == 19:
                    alt7 = 3
                elif LA7 == 11:
                    alt7 = 5
                else:
                    nvae = NoViableAltException("", 7, 0, self.input)

                    raise nvae


                if alt7 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:47:7: forStat
                    pass 
                    self._state.following.append(self.FOLLOW_forStat_in_stat322)
                    self.forStat()

                    self._state.following.pop()


                elif alt7 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:48:7: expr ';'
                    pass 
                    self._state.following.append(self.FOLLOW_expr_in_stat330)
                    self.expr()

                    self._state.following.pop()

                    self.match(self.input, 11, self.FOLLOW_11_in_stat332)


                elif alt7 == 3:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:49:7: block
                    pass 
                    self._state.following.append(self.FOLLOW_block_in_stat346)
                    self.block()

                    self._state.following.pop()


                elif alt7 == 4:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:50:7: assignStat ';'
                    pass 
                    self._state.following.append(self.FOLLOW_assignStat_in_stat354)
                    self.assignStat()

                    self._state.following.pop()

                    self.match(self.input, 11, self.FOLLOW_11_in_stat356)


                elif alt7 == 5:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:51:7: ';'
                    pass 
                    self.match(self.input, 11, self.FOLLOW_11_in_stat364)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "stat"



    # $ANTLR start "forStat"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:54:1: forStat : 'for' '(' assignStat ';' expr ';' assignStat ')' block ;
    def forStat(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:55:5: ( 'for' '(' assignStat ';' expr ';' assignStat ')' block )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:55:9: 'for' '(' assignStat ';' expr ';' assignStat ')' block
                pass 
                self.match(self.input, 16, self.FOLLOW_16_in_forStat383)

                self.match(self.input, 7, self.FOLLOW_7_in_forStat385)

                self._state.following.append(self.FOLLOW_assignStat_in_forStat387)
                self.assignStat()

                self._state.following.pop()

                self.match(self.input, 11, self.FOLLOW_11_in_forStat389)

                self._state.following.append(self.FOLLOW_expr_in_forStat391)
                self.expr()

                self._state.following.pop()

                self.match(self.input, 11, self.FOLLOW_11_in_forStat393)

                self._state.following.append(self.FOLLOW_assignStat_in_forStat395)
                self.assignStat()

                self._state.following.pop()

                self.match(self.input, 8, self.FOLLOW_8_in_forStat397)

                self._state.following.append(self.FOLLOW_block_in_forStat399)
                self.block()

                self._state.following.pop()




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "forStat"



    # $ANTLR start "assignStat"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:58:1: assignStat : ID '=' expr ;
    def assignStat(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:59:5: ( ID '=' expr )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:59:9: ID '=' expr
                pass 
                self.match(self.input, ID, self.FOLLOW_ID_in_assignStat426)

                self.match(self.input, 13, self.FOLLOW_13_in_assignStat428)

                self._state.following.append(self.FOLLOW_expr_in_assignStat430)
                self.expr()

                self._state.following.pop()




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "assignStat"



    # $ANTLR start "expr"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:62:1: expr : condExpr ;
    def expr(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:62:5: ( condExpr )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:62:9: condExpr
                pass 
                self._state.following.append(self.FOLLOW_condExpr_in_expr452)
                self.condExpr()

                self._state.following.pop()




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "expr"



    # $ANTLR start "condExpr"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:65:1: condExpr : aexpr ( ( '==' | '<' ) aexpr )? ;
    def condExpr(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:66:5: ( aexpr ( ( '==' | '<' ) aexpr )? )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:66:9: aexpr ( ( '==' | '<' ) aexpr )?
                pass 
                self._state.following.append(self.FOLLOW_aexpr_in_condExpr471)
                self.aexpr()

                self._state.following.pop()

                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:66:15: ( ( '==' | '<' ) aexpr )?
                alt8 = 2
                LA8_0 = self.input.LA(1)

                if (LA8_0 == 12 or LA8_0 == 14) :
                    alt8 = 1
                if alt8 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:66:17: ( '==' | '<' ) aexpr
                    pass 
                    if self.input.LA(1) == 12 or self.input.LA(1) == 14:
                        self.input.consume()
                        self._state.errorRecovery = False


                    else:
                        mse = MismatchedSetException(None, self.input)
                        raise mse



                    self._state.following.append(self.FOLLOW_aexpr_in_condExpr483)
                    self.aexpr()

                    self._state.following.pop()







            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "condExpr"



    # $ANTLR start "aexpr"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:69:1: aexpr : atom ( '+' atom )* ;
    def aexpr(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:70:5: ( atom ( '+' atom )* )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:70:9: atom ( '+' atom )*
                pass 
                self._state.following.append(self.FOLLOW_atom_in_aexpr505)
                self.atom()

                self._state.following.pop()

                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:70:14: ( '+' atom )*
                while True: #loop9
                    alt9 = 2
                    LA9_0 = self.input.LA(1)

                    if (LA9_0 == 9) :
                        alt9 = 1


                    if alt9 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:70:16: '+' atom
                        pass 
                        self.match(self.input, 9, self.FOLLOW_9_in_aexpr509)

                        self._state.following.append(self.FOLLOW_atom_in_aexpr511)
                        self.atom()

                        self._state.following.pop()


                    else:
                        break #loop9





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "aexpr"



    # $ANTLR start "atom"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:73:1: atom : ( ID | INT | '(' expr ')' );
    def atom(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:74:5: ( ID | INT | '(' expr ')' )
                alt10 = 3
                LA10 = self.input.LA(1)
                if LA10 == ID:
                    alt10 = 1
                elif LA10 == INT:
                    alt10 = 2
                elif LA10 == 7:
                    alt10 = 3
                else:
                    nvae = NoViableAltException("", 10, 0, self.input)

                    raise nvae


                if alt10 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:74:7: ID
                    pass 
                    self.match(self.input, ID, self.FOLLOW_ID_in_atom531)


                elif alt10 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:75:7: INT
                    pass 
                    self.match(self.input, INT, self.FOLLOW_INT_in_atom545)


                elif alt10 == 3:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t017parser.g:76:7: '(' expr ')'
                    pass 
                    self.match(self.input, 7, self.FOLLOW_7_in_atom559)

                    self._state.following.append(self.FOLLOW_expr_in_atom561)
                    self.expr()

                    self._state.following.pop()

                    self.match(self.input, 8, self.FOLLOW_8_in_atom563)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "atom"



    # lookup tables for DFA #2

    DFA2_eot = DFA.unpack(
        u"\15\uffff"
        )

    DFA2_eof = DFA.unpack(
        u"\15\uffff"
        )

    DFA2_min = DFA.unpack(
        u"\2\4\1\7\1\4\1\uffff\1\4\1\13\1\10\2\uffff\2\4\1\10"
        )

    DFA2_max = DFA.unpack(
        u"\1\22\1\4\1\13\1\22\1\uffff\1\4\1\23\1\12\2\uffff\1\22\1\4\1\12"
        )

    DFA2_accept = DFA.unpack(
        u"\4\uffff\1\1\3\uffff\1\2\1\3\3\uffff"
        )

    DFA2_special = DFA.unpack(
        u"\15\uffff"
        )


    DFA2_transition = [
        DFA.unpack(u"\1\1\12\uffff\1\1\1\uffff\2\1"),
        DFA.unpack(u"\1\2"),
        DFA.unpack(u"\1\3\3\uffff\1\4"),
        DFA.unpack(u"\1\5\3\uffff\1\6\6\uffff\1\5\1\uffff\2\5"),
        DFA.unpack(u""),
        DFA.unpack(u"\1\7"),
        DFA.unpack(u"\1\10\7\uffff\1\11"),
        DFA.unpack(u"\1\6\1\uffff\1\12"),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u"\1\13\12\uffff\1\13\1\uffff\2\13"),
        DFA.unpack(u"\1\14"),
        DFA.unpack(u"\1\6\1\uffff\1\12")
    ]

    # class definition for DFA #2

    class DFA2(DFA):
        pass


 

    FOLLOW_declaration_in_program32 = frozenset([1, 4, 15, 17, 18])
    FOLLOW_variable_in_declaration52 = frozenset([1])
    FOLLOW_functionHeader_in_declaration62 = frozenset([11])
    FOLLOW_11_in_declaration64 = frozenset([1])
    FOLLOW_functionHeader_in_declaration74 = frozenset([19])
    FOLLOW_block_in_declaration76 = frozenset([1])
    FOLLOW_type_in_variable95 = frozenset([4])
    FOLLOW_declarator_in_variable97 = frozenset([11])
    FOLLOW_11_in_variable99 = frozenset([1])
    FOLLOW_ID_in_declarator118 = frozenset([1])
    FOLLOW_type_in_functionHeader138 = frozenset([4])
    FOLLOW_ID_in_functionHeader140 = frozenset([7])
    FOLLOW_7_in_functionHeader142 = frozenset([4, 8, 15, 17, 18])
    FOLLOW_formalParameter_in_functionHeader146 = frozenset([8, 10])
    FOLLOW_10_in_functionHeader150 = frozenset([4, 15, 17, 18])
    FOLLOW_formalParameter_in_functionHeader152 = frozenset([8, 10])
    FOLLOW_8_in_functionHeader160 = frozenset([1])
    FOLLOW_type_in_formalParameter179 = frozenset([4])
    FOLLOW_declarator_in_formalParameter181 = frozenset([1])
    FOLLOW_19_in_block270 = frozenset([4, 5, 7, 11, 15, 16, 17, 18, 19, 20])
    FOLLOW_variable_in_block284 = frozenset([4, 5, 7, 11, 15, 16, 17, 18, 19, 20])
    FOLLOW_stat_in_block299 = frozenset([4, 5, 7, 11, 16, 19, 20])
    FOLLOW_20_in_block310 = frozenset([1])
    FOLLOW_forStat_in_stat322 = frozenset([1])
    FOLLOW_expr_in_stat330 = frozenset([11])
    FOLLOW_11_in_stat332 = frozenset([1])
    FOLLOW_block_in_stat346 = frozenset([1])
    FOLLOW_assignStat_in_stat354 = frozenset([11])
    FOLLOW_11_in_stat356 = frozenset([1])
    FOLLOW_11_in_stat364 = frozenset([1])
    FOLLOW_16_in_forStat383 = frozenset([7])
    FOLLOW_7_in_forStat385 = frozenset([4])
    FOLLOW_assignStat_in_forStat387 = frozenset([11])
    FOLLOW_11_in_forStat389 = frozenset([4, 5, 7])
    FOLLOW_expr_in_forStat391 = frozenset([11])
    FOLLOW_11_in_forStat393 = frozenset([4])
    FOLLOW_assignStat_in_forStat395 = frozenset([8])
    FOLLOW_8_in_forStat397 = frozenset([19])
    FOLLOW_block_in_forStat399 = frozenset([1])
    FOLLOW_ID_in_assignStat426 = frozenset([13])
    FOLLOW_13_in_assignStat428 = frozenset([4, 5, 7])
    FOLLOW_expr_in_assignStat430 = frozenset([1])
    FOLLOW_condExpr_in_expr452 = frozenset([1])
    FOLLOW_aexpr_in_condExpr471 = frozenset([1, 12, 14])
    FOLLOW_set_in_condExpr475 = frozenset([4, 5, 7])
    FOLLOW_aexpr_in_condExpr483 = frozenset([1])
    FOLLOW_atom_in_aexpr505 = frozenset([1, 9])
    FOLLOW_9_in_aexpr509 = frozenset([4, 5, 7])
    FOLLOW_atom_in_aexpr511 = frozenset([1, 9])
    FOLLOW_ID_in_atom531 = frozenset([1])
    FOLLOW_INT_in_atom545 = frozenset([1])
    FOLLOW_7_in_atom559 = frozenset([4, 5, 7])
    FOLLOW_expr_in_atom561 = frozenset([8])
    FOLLOW_8_in_atom563 = frozenset([1])



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import ParserMain
    main = ParserMain("t017parserLexer", t017parserParser)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
