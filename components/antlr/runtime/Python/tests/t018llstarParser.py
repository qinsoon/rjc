# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g 2013-01-03 10:52:47

import sys
from antlr3 import *
from antlr3.compat import set, frozenset

        
from cStringIO import StringIO



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




class t018llstarParser(Parser):
    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g"
    api_version = 1
    tokenNames = tokenNames

    def __init__(self, input, state=None, *args, **kwargs):
        if state is None:
            state = RecognizerSharedState()

        super(t018llstarParser, self).__init__(input, state, *args, **kwargs)

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



              
        self.output = StringIO()


        self.delegates = []






    # $ANTLR start "program"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:15:1: program : ( declaration )+ ;
    def program(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:16:5: ( ( declaration )+ )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:16:9: ( declaration )+
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:16:9: ( declaration )+
                cnt1 = 0
                while True: #loop1
                    alt1 = 2
                    LA1_0 = self.input.LA(1)

                    if (LA1_0 == ID or LA1_0 == 15 or (17 <= LA1_0 <= 18)) :
                        alt1 = 1


                    if alt1 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:16:9: declaration
                        pass 
                        self._state.following.append(self.FOLLOW_declaration_in_program44)
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
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:28:1: declaration : ( variable | functionHeader ';' | functionHeader block );
    def declaration(self, ):
        functionHeader1 = None

        functionHeader2 = None


        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:29:5: ( variable | functionHeader ';' | functionHeader block )
                alt2 = 3
                alt2 = self.dfa2.predict(self.input)
                if alt2 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:29:9: variable
                    pass 
                    self._state.following.append(self.FOLLOW_variable_in_declaration66)
                    self.variable()

                    self._state.following.pop()


                elif alt2 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:30:9: functionHeader ';'
                    pass 
                    self._state.following.append(self.FOLLOW_functionHeader_in_declaration76)
                    functionHeader1 = self.functionHeader()

                    self._state.following.pop()

                    self.match(self.input, 11, self.FOLLOW_11_in_declaration78)

                    #action start
                    self.output.write(functionHeader1+" is a declaration\n")
                    #action end



                elif alt2 == 3:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:32:9: functionHeader block
                    pass 
                    self._state.following.append(self.FOLLOW_functionHeader_in_declaration91)
                    functionHeader2 = self.functionHeader()

                    self._state.following.pop()

                    self._state.following.append(self.FOLLOW_block_in_declaration93)
                    self.block()

                    self._state.following.pop()

                    #action start
                    self.output.write(functionHeader2+" is a definition\n")
                    #action end




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "declaration"



    # $ANTLR start "variable"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:36:1: variable : type declarator ';' ;
    def variable(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:37:5: ( type declarator ';' )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:37:9: type declarator ';'
                pass 
                self._state.following.append(self.FOLLOW_type_in_variable115)
                self.type()

                self._state.following.pop()

                self._state.following.append(self.FOLLOW_declarator_in_variable117)
                self.declarator()

                self._state.following.pop()

                self.match(self.input, 11, self.FOLLOW_11_in_variable119)




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "variable"



    # $ANTLR start "declarator"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:40:1: declarator : ID ;
    def declarator(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:41:5: ( ID )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:41:9: ID
                pass 
                self.match(self.input, ID, self.FOLLOW_ID_in_declarator138)




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "declarator"



    # $ANTLR start "functionHeader"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:44:1: functionHeader returns [name] : type ID '(' ( formalParameter ( ',' formalParameter )* )? ')' ;
    def functionHeader(self, ):
        name = None


        ID3 = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:45:5: ( type ID '(' ( formalParameter ( ',' formalParameter )* )? ')' )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:45:9: type ID '(' ( formalParameter ( ',' formalParameter )* )? ')'
                pass 
                self._state.following.append(self.FOLLOW_type_in_functionHeader162)
                self.type()

                self._state.following.pop()

                ID3 = self.match(self.input, ID, self.FOLLOW_ID_in_functionHeader164)

                self.match(self.input, 7, self.FOLLOW_7_in_functionHeader166)

                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:45:21: ( formalParameter ( ',' formalParameter )* )?
                alt4 = 2
                LA4_0 = self.input.LA(1)

                if (LA4_0 == ID or LA4_0 == 15 or (17 <= LA4_0 <= 18)) :
                    alt4 = 1
                if alt4 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:45:23: formalParameter ( ',' formalParameter )*
                    pass 
                    self._state.following.append(self.FOLLOW_formalParameter_in_functionHeader170)
                    self.formalParameter()

                    self._state.following.pop()

                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:45:39: ( ',' formalParameter )*
                    while True: #loop3
                        alt3 = 2
                        LA3_0 = self.input.LA(1)

                        if (LA3_0 == 10) :
                            alt3 = 1


                        if alt3 == 1:
                            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:45:41: ',' formalParameter
                            pass 
                            self.match(self.input, 10, self.FOLLOW_10_in_functionHeader174)

                            self._state.following.append(self.FOLLOW_formalParameter_in_functionHeader176)
                            self.formalParameter()

                            self._state.following.pop()


                        else:
                            break #loop3





                self.match(self.input, 8, self.FOLLOW_8_in_functionHeader184)

                #action start
                name = ID3.text
                #action end





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return name

    # $ANTLR end "functionHeader"



    # $ANTLR start "formalParameter"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:49:1: formalParameter : type declarator ;
    def formalParameter(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:50:5: ( type declarator )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:50:9: type declarator
                pass 
                self._state.following.append(self.FOLLOW_type_in_formalParameter206)
                self.type()

                self._state.following.pop()

                self._state.following.append(self.FOLLOW_declarator_in_formalParameter208)
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
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:53:1: type : ( 'int' | 'char' | 'void' | ID );
    def type(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:54:5: ( 'int' | 'char' | 'void' | ID )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:
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
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:60:1: block : '{' ( variable )* ( stat )* '}' ;
    def block(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:61:5: ( '{' ( variable )* ( stat )* '}' )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:61:9: '{' ( variable )* ( stat )* '}'
                pass 
                self.match(self.input, 19, self.FOLLOW_19_in_block297)

                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:62:13: ( variable )*
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
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:62:13: variable
                        pass 
                        self._state.following.append(self.FOLLOW_variable_in_block311)
                        self.variable()

                        self._state.following.pop()


                    else:
                        break #loop5


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:63:13: ( stat )*
                while True: #loop6
                    alt6 = 2
                    LA6_0 = self.input.LA(1)

                    if ((ID <= LA6_0 <= INT) or LA6_0 == 7 or LA6_0 == 11 or LA6_0 == 16 or LA6_0 == 19) :
                        alt6 = 1


                    if alt6 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:63:13: stat
                        pass 
                        self._state.following.append(self.FOLLOW_stat_in_block326)
                        self.stat()

                        self._state.following.pop()


                    else:
                        break #loop6


                self.match(self.input, 20, self.FOLLOW_20_in_block337)




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "block"



    # $ANTLR start "stat"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:67:1: stat : ( forStat | expr ';' | block | assignStat ';' | ';' );
    def stat(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:67:5: ( forStat | expr ';' | block | assignStat ';' | ';' )
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
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:67:7: forStat
                    pass 
                    self._state.following.append(self.FOLLOW_forStat_in_stat349)
                    self.forStat()

                    self._state.following.pop()


                elif alt7 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:68:7: expr ';'
                    pass 
                    self._state.following.append(self.FOLLOW_expr_in_stat357)
                    self.expr()

                    self._state.following.pop()

                    self.match(self.input, 11, self.FOLLOW_11_in_stat359)


                elif alt7 == 3:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:69:7: block
                    pass 
                    self._state.following.append(self.FOLLOW_block_in_stat373)
                    self.block()

                    self._state.following.pop()


                elif alt7 == 4:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:70:7: assignStat ';'
                    pass 
                    self._state.following.append(self.FOLLOW_assignStat_in_stat381)
                    self.assignStat()

                    self._state.following.pop()

                    self.match(self.input, 11, self.FOLLOW_11_in_stat383)


                elif alt7 == 5:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:71:7: ';'
                    pass 
                    self.match(self.input, 11, self.FOLLOW_11_in_stat391)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "stat"



    # $ANTLR start "forStat"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:74:1: forStat : 'for' '(' assignStat ';' expr ';' assignStat ')' block ;
    def forStat(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:75:5: ( 'for' '(' assignStat ';' expr ';' assignStat ')' block )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:75:9: 'for' '(' assignStat ';' expr ';' assignStat ')' block
                pass 
                self.match(self.input, 16, self.FOLLOW_16_in_forStat410)

                self.match(self.input, 7, self.FOLLOW_7_in_forStat412)

                self._state.following.append(self.FOLLOW_assignStat_in_forStat414)
                self.assignStat()

                self._state.following.pop()

                self.match(self.input, 11, self.FOLLOW_11_in_forStat416)

                self._state.following.append(self.FOLLOW_expr_in_forStat418)
                self.expr()

                self._state.following.pop()

                self.match(self.input, 11, self.FOLLOW_11_in_forStat420)

                self._state.following.append(self.FOLLOW_assignStat_in_forStat422)
                self.assignStat()

                self._state.following.pop()

                self.match(self.input, 8, self.FOLLOW_8_in_forStat424)

                self._state.following.append(self.FOLLOW_block_in_forStat426)
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
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:78:1: assignStat : ID '=' expr ;
    def assignStat(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:79:5: ( ID '=' expr )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:79:9: ID '=' expr
                pass 
                self.match(self.input, ID, self.FOLLOW_ID_in_assignStat453)

                self.match(self.input, 13, self.FOLLOW_13_in_assignStat455)

                self._state.following.append(self.FOLLOW_expr_in_assignStat457)
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
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:82:1: expr : condExpr ;
    def expr(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:82:5: ( condExpr )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:82:9: condExpr
                pass 
                self._state.following.append(self.FOLLOW_condExpr_in_expr479)
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
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:85:1: condExpr : aexpr ( ( '==' | '<' ) aexpr )? ;
    def condExpr(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:86:5: ( aexpr ( ( '==' | '<' ) aexpr )? )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:86:9: aexpr ( ( '==' | '<' ) aexpr )?
                pass 
                self._state.following.append(self.FOLLOW_aexpr_in_condExpr498)
                self.aexpr()

                self._state.following.pop()

                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:86:15: ( ( '==' | '<' ) aexpr )?
                alt8 = 2
                LA8_0 = self.input.LA(1)

                if (LA8_0 == 12 or LA8_0 == 14) :
                    alt8 = 1
                if alt8 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:86:17: ( '==' | '<' ) aexpr
                    pass 
                    if self.input.LA(1) == 12 or self.input.LA(1) == 14:
                        self.input.consume()
                        self._state.errorRecovery = False


                    else:
                        mse = MismatchedSetException(None, self.input)
                        raise mse



                    self._state.following.append(self.FOLLOW_aexpr_in_condExpr510)
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
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:89:1: aexpr : atom ( '+' atom )* ;
    def aexpr(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:90:5: ( atom ( '+' atom )* )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:90:9: atom ( '+' atom )*
                pass 
                self._state.following.append(self.FOLLOW_atom_in_aexpr532)
                self.atom()

                self._state.following.pop()

                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:90:14: ( '+' atom )*
                while True: #loop9
                    alt9 = 2
                    LA9_0 = self.input.LA(1)

                    if (LA9_0 == 9) :
                        alt9 = 1


                    if alt9 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:90:16: '+' atom
                        pass 
                        self.match(self.input, 9, self.FOLLOW_9_in_aexpr536)

                        self._state.following.append(self.FOLLOW_atom_in_aexpr538)
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
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:93:1: atom : ( ID | INT | '(' expr ')' );
    def atom(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:94:5: ( ID | INT | '(' expr ')' )
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
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:94:7: ID
                    pass 
                    self.match(self.input, ID, self.FOLLOW_ID_in_atom558)


                elif alt10 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:95:7: INT
                    pass 
                    self.match(self.input, INT, self.FOLLOW_INT_in_atom572)


                elif alt10 == 3:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t018llstar.g:96:7: '(' expr ')'
                    pass 
                    self.match(self.input, 7, self.FOLLOW_7_in_atom586)

                    self._state.following.append(self.FOLLOW_expr_in_atom588)
                    self.expr()

                    self._state.following.pop()

                    self.match(self.input, 8, self.FOLLOW_8_in_atom590)



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


 

    FOLLOW_declaration_in_program44 = frozenset([1, 4, 15, 17, 18])
    FOLLOW_variable_in_declaration66 = frozenset([1])
    FOLLOW_functionHeader_in_declaration76 = frozenset([11])
    FOLLOW_11_in_declaration78 = frozenset([1])
    FOLLOW_functionHeader_in_declaration91 = frozenset([19])
    FOLLOW_block_in_declaration93 = frozenset([1])
    FOLLOW_type_in_variable115 = frozenset([4])
    FOLLOW_declarator_in_variable117 = frozenset([11])
    FOLLOW_11_in_variable119 = frozenset([1])
    FOLLOW_ID_in_declarator138 = frozenset([1])
    FOLLOW_type_in_functionHeader162 = frozenset([4])
    FOLLOW_ID_in_functionHeader164 = frozenset([7])
    FOLLOW_7_in_functionHeader166 = frozenset([4, 8, 15, 17, 18])
    FOLLOW_formalParameter_in_functionHeader170 = frozenset([8, 10])
    FOLLOW_10_in_functionHeader174 = frozenset([4, 15, 17, 18])
    FOLLOW_formalParameter_in_functionHeader176 = frozenset([8, 10])
    FOLLOW_8_in_functionHeader184 = frozenset([1])
    FOLLOW_type_in_formalParameter206 = frozenset([4])
    FOLLOW_declarator_in_formalParameter208 = frozenset([1])
    FOLLOW_19_in_block297 = frozenset([4, 5, 7, 11, 15, 16, 17, 18, 19, 20])
    FOLLOW_variable_in_block311 = frozenset([4, 5, 7, 11, 15, 16, 17, 18, 19, 20])
    FOLLOW_stat_in_block326 = frozenset([4, 5, 7, 11, 16, 19, 20])
    FOLLOW_20_in_block337 = frozenset([1])
    FOLLOW_forStat_in_stat349 = frozenset([1])
    FOLLOW_expr_in_stat357 = frozenset([11])
    FOLLOW_11_in_stat359 = frozenset([1])
    FOLLOW_block_in_stat373 = frozenset([1])
    FOLLOW_assignStat_in_stat381 = frozenset([11])
    FOLLOW_11_in_stat383 = frozenset([1])
    FOLLOW_11_in_stat391 = frozenset([1])
    FOLLOW_16_in_forStat410 = frozenset([7])
    FOLLOW_7_in_forStat412 = frozenset([4])
    FOLLOW_assignStat_in_forStat414 = frozenset([11])
    FOLLOW_11_in_forStat416 = frozenset([4, 5, 7])
    FOLLOW_expr_in_forStat418 = frozenset([11])
    FOLLOW_11_in_forStat420 = frozenset([4])
    FOLLOW_assignStat_in_forStat422 = frozenset([8])
    FOLLOW_8_in_forStat424 = frozenset([19])
    FOLLOW_block_in_forStat426 = frozenset([1])
    FOLLOW_ID_in_assignStat453 = frozenset([13])
    FOLLOW_13_in_assignStat455 = frozenset([4, 5, 7])
    FOLLOW_expr_in_assignStat457 = frozenset([1])
    FOLLOW_condExpr_in_expr479 = frozenset([1])
    FOLLOW_aexpr_in_condExpr498 = frozenset([1, 12, 14])
    FOLLOW_set_in_condExpr502 = frozenset([4, 5, 7])
    FOLLOW_aexpr_in_condExpr510 = frozenset([1])
    FOLLOW_atom_in_aexpr532 = frozenset([1, 9])
    FOLLOW_9_in_aexpr536 = frozenset([4, 5, 7])
    FOLLOW_atom_in_aexpr538 = frozenset([1, 9])
    FOLLOW_ID_in_atom558 = frozenset([1])
    FOLLOW_INT_in_atom572 = frozenset([1])
    FOLLOW_7_in_atom586 = frozenset([4, 5, 7])
    FOLLOW_expr_in_atom588 = frozenset([8])
    FOLLOW_8_in_atom590 = frozenset([1])



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import ParserMain
    main = ParserMain("t018llstarLexer", t018llstarParser)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
