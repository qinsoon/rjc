# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g 2013-01-03 10:51:34

import sys
from antlr3 import *
from antlr3.tree import *

from antlr3.compat import set, frozenset



# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EOF=-1
T__21=21
T__22=22
T__23=23
T__24=24
T__25=25
T__26=26
ARG_DEF=4
BLOCK=5
CHAR=6
EQ=7
EQEQ=8
FOR=9
FUNC_DECL=10
FUNC_DEF=11
FUNC_HDR=12
ID=13
INT=14
INT_TYPE=15
LT=16
PLUS=17
VAR_DEF=18
VOID=19
WS=20

# token names
tokenNames = [
    "<invalid>", "<EOR>", "<DOWN>", "<UP>",
    "ARG_DEF", "BLOCK", "CHAR", "EQ", "EQEQ", "FOR", "FUNC_DECL", "FUNC_DEF", 
    "FUNC_HDR", "ID", "INT", "INT_TYPE", "LT", "PLUS", "VAR_DEF", "VOID", 
    "WS", "'('", "')'", "','", "';'", "'{'", "'}'"
]




class t047treeparserWalker(TreeParser):
    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g"
    api_version = 1
    tokenNames = tokenNames

    def __init__(self, input, state=None, *args, **kwargs):
        if state is None:
            state = RecognizerSharedState()

        super(t047treeparserWalker, self).__init__(input, state, *args, **kwargs)




        self.delegates = []






    # $ANTLR start "program"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:8:1: program : ( declaration )+ ;
    def program(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:9:5: ( ( declaration )+ )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:9:9: ( declaration )+
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:9:9: ( declaration )+
                cnt1 = 0
                while True: #loop1
                    alt1 = 2
                    LA1_0 = self.input.LA(1)

                    if ((FUNC_DECL <= LA1_0 <= FUNC_DEF) or LA1_0 == VAR_DEF) :
                        alt1 = 1


                    if alt1 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:9:9: declaration
                        pass 
                        self._state.following.append(self.FOLLOW_declaration_in_program49)
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
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:12:1: declaration : ( variable | ^( FUNC_DECL functionHeader ) | ^( FUNC_DEF functionHeader block ) );
    def declaration(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:13:5: ( variable | ^( FUNC_DECL functionHeader ) | ^( FUNC_DEF functionHeader block ) )
                alt2 = 3
                LA2 = self.input.LA(1)
                if LA2 == VAR_DEF:
                    alt2 = 1
                elif LA2 == FUNC_DECL:
                    alt2 = 2
                elif LA2 == FUNC_DEF:
                    alt2 = 3
                else:
                    nvae = NoViableAltException("", 2, 0, self.input)

                    raise nvae


                if alt2 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:13:9: variable
                    pass 
                    self._state.following.append(self.FOLLOW_variable_in_declaration69)
                    self.variable()

                    self._state.following.pop()


                elif alt2 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:14:9: ^( FUNC_DECL functionHeader )
                    pass 
                    self.match(self.input, FUNC_DECL, self.FOLLOW_FUNC_DECL_in_declaration80)

                    self.match(self.input, DOWN, None)
                    self._state.following.append(self.FOLLOW_functionHeader_in_declaration82)
                    self.functionHeader()

                    self._state.following.pop()

                    self.match(self.input, UP, None)



                elif alt2 == 3:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:15:9: ^( FUNC_DEF functionHeader block )
                    pass 
                    self.match(self.input, FUNC_DEF, self.FOLLOW_FUNC_DEF_in_declaration94)

                    self.match(self.input, DOWN, None)
                    self._state.following.append(self.FOLLOW_functionHeader_in_declaration96)
                    self.functionHeader()

                    self._state.following.pop()

                    self._state.following.append(self.FOLLOW_block_in_declaration98)
                    self.block()

                    self._state.following.pop()

                    self.match(self.input, UP, None)




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "declaration"



    # $ANTLR start "variable"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:18:1: variable returns [res] : ^( VAR_DEF type declarator ) ;
    def variable(self, ):
        res = None


        declarator1 = None


        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:19:5: ( ^( VAR_DEF type declarator ) )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:19:9: ^( VAR_DEF type declarator )
                pass 
                self.match(self.input, VAR_DEF, self.FOLLOW_VAR_DEF_in_variable123)

                self.match(self.input, DOWN, None)
                self._state.following.append(self.FOLLOW_type_in_variable125)
                self.type()

                self._state.following.pop()

                self._state.following.append(self.FOLLOW_declarator_in_variable127)
                declarator1 = self.declarator()

                self._state.following.pop()

                self.match(self.input, UP, None)


                #action start
                         
                res =  ((declarator1 is not None) and [self.input.getTokenStream().toString(self.input.getTreeAdaptor().getTokenStartIndex(declarator1.start),self.input.getTreeAdaptor().getTokenStopIndex(declarator1.start))] or [None])[0] 
                        
                #action end





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return res

    # $ANTLR end "variable"


    class declarator_return(TreeRuleReturnScope):
        def __init__(self):
            super(t047treeparserWalker.declarator_return, self).__init__()






    # $ANTLR start "declarator"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:25:1: declarator : ID ;
    def declarator(self, ):
        retval = self.declarator_return()
        retval.start = self.input.LT(1)


        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:26:5: ( ID )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:26:9: ID
                pass 
                self.match(self.input, ID, self.FOLLOW_ID_in_declarator157)




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return retval

    # $ANTLR end "declarator"



    # $ANTLR start "functionHeader"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:29:1: functionHeader : ^( FUNC_HDR type ID ( formalParameter )+ ) ;
    def functionHeader(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:30:5: ( ^( FUNC_HDR type ID ( formalParameter )+ ) )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:30:9: ^( FUNC_HDR type ID ( formalParameter )+ )
                pass 
                self.match(self.input, FUNC_HDR, self.FOLLOW_FUNC_HDR_in_functionHeader178)

                self.match(self.input, DOWN, None)
                self._state.following.append(self.FOLLOW_type_in_functionHeader180)
                self.type()

                self._state.following.pop()

                self.match(self.input, ID, self.FOLLOW_ID_in_functionHeader182)

                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:30:28: ( formalParameter )+
                cnt3 = 0
                while True: #loop3
                    alt3 = 2
                    LA3_0 = self.input.LA(1)

                    if (LA3_0 == ARG_DEF) :
                        alt3 = 1


                    if alt3 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:30:28: formalParameter
                        pass 
                        self._state.following.append(self.FOLLOW_formalParameter_in_functionHeader184)
                        self.formalParameter()

                        self._state.following.pop()


                    else:
                        if cnt3 >= 1:
                            break #loop3

                        eee = EarlyExitException(3, self.input)
                        raise eee

                    cnt3 += 1


                self.match(self.input, UP, None)





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "functionHeader"



    # $ANTLR start "formalParameter"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:33:1: formalParameter : ^( ARG_DEF type declarator ) ;
    def formalParameter(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:34:5: ( ^( ARG_DEF type declarator ) )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:34:9: ^( ARG_DEF type declarator )
                pass 
                self.match(self.input, ARG_DEF, self.FOLLOW_ARG_DEF_in_formalParameter206)

                self.match(self.input, DOWN, None)
                self._state.following.append(self.FOLLOW_type_in_formalParameter208)
                self.type()

                self._state.following.pop()

                self._state.following.append(self.FOLLOW_declarator_in_formalParameter210)
                self.declarator()

                self._state.following.pop()

                self.match(self.input, UP, None)





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "formalParameter"



    # $ANTLR start "type"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:37:1: type : ( 'int' | 'char' | 'void' | ID );
    def type(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:38:5: ( 'int' | 'char' | 'void' | ID )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:
                pass 
                if self.input.LA(1) == CHAR or self.input.LA(1) == ID or self.input.LA(1) == INT_TYPE or self.input.LA(1) == VOID:
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
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:44:1: block : ^( BLOCK ( variable )* ( stat )* ) ;
    def block(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:45:5: ( ^( BLOCK ( variable )* ( stat )* ) )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:45:9: ^( BLOCK ( variable )* ( stat )* )
                pass 
                self.match(self.input, BLOCK, self.FOLLOW_BLOCK_in_block288)

                if self.input.LA(1) == DOWN:
                    self.match(self.input, DOWN, None)
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:45:17: ( variable )*
                    while True: #loop4
                        alt4 = 2
                        LA4_0 = self.input.LA(1)

                        if (LA4_0 == VAR_DEF) :
                            alt4 = 1


                        if alt4 == 1:
                            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:45:17: variable
                            pass 
                            self._state.following.append(self.FOLLOW_variable_in_block290)
                            self.variable()

                            self._state.following.pop()


                        else:
                            break #loop4


                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:45:27: ( stat )*
                    while True: #loop5
                        alt5 = 2
                        LA5_0 = self.input.LA(1)

                        if (LA5_0 == BLOCK or (EQ <= LA5_0 <= FOR) or (ID <= LA5_0 <= INT) or (LT <= LA5_0 <= PLUS)) :
                            alt5 = 1


                        if alt5 == 1:
                            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:45:27: stat
                            pass 
                            self._state.following.append(self.FOLLOW_stat_in_block293)
                            self.stat()

                            self._state.following.pop()


                        else:
                            break #loop5


                    self.match(self.input, UP, None)






            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "block"



    # $ANTLR start "stat"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:48:1: stat : ( forStat | expr | block );
    def stat(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:48:5: ( forStat | expr | block )
                alt6 = 3
                LA6 = self.input.LA(1)
                if LA6 == FOR:
                    alt6 = 1
                elif LA6 == EQ or LA6 == EQEQ or LA6 == ID or LA6 == INT or LA6 == LT or LA6 == PLUS:
                    alt6 = 2
                elif LA6 == BLOCK:
                    alt6 = 3
                else:
                    nvae = NoViableAltException("", 6, 0, self.input)

                    raise nvae


                if alt6 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:48:7: forStat
                    pass 
                    self._state.following.append(self.FOLLOW_forStat_in_stat307)
                    self.forStat()

                    self._state.following.pop()


                elif alt6 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:49:7: expr
                    pass 
                    self._state.following.append(self.FOLLOW_expr_in_stat315)
                    self.expr()

                    self._state.following.pop()


                elif alt6 == 3:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:50:7: block
                    pass 
                    self._state.following.append(self.FOLLOW_block_in_stat323)
                    self.block()

                    self._state.following.pop()



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "stat"



    # $ANTLR start "forStat"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:53:1: forStat : ^( 'for' expr expr expr block ) ;
    def forStat(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:54:5: ( ^( 'for' expr expr expr block ) )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:54:9: ^( 'for' expr expr expr block )
                pass 
                self.match(self.input, FOR, self.FOLLOW_FOR_in_forStat343)

                self.match(self.input, DOWN, None)
                self._state.following.append(self.FOLLOW_expr_in_forStat345)
                self.expr()

                self._state.following.pop()

                self._state.following.append(self.FOLLOW_expr_in_forStat347)
                self.expr()

                self._state.following.pop()

                self._state.following.append(self.FOLLOW_expr_in_forStat349)
                self.expr()

                self._state.following.pop()

                self._state.following.append(self.FOLLOW_block_in_forStat351)
                self.block()

                self._state.following.pop()

                self.match(self.input, UP, None)





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "forStat"



    # $ANTLR start "expr"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:57:1: expr : ( ^( EQEQ expr expr ) | ^( LT expr expr ) | ^( PLUS expr expr ) | ^( EQ ID expr ) | atom );
    def expr(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:57:5: ( ^( EQEQ expr expr ) | ^( LT expr expr ) | ^( PLUS expr expr ) | ^( EQ ID expr ) | atom )
                alt7 = 5
                LA7 = self.input.LA(1)
                if LA7 == EQEQ:
                    alt7 = 1
                elif LA7 == LT:
                    alt7 = 2
                elif LA7 == PLUS:
                    alt7 = 3
                elif LA7 == EQ:
                    alt7 = 4
                elif LA7 == ID or LA7 == INT:
                    alt7 = 5
                else:
                    nvae = NoViableAltException("", 7, 0, self.input)

                    raise nvae


                if alt7 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:57:9: ^( EQEQ expr expr )
                    pass 
                    self.match(self.input, EQEQ, self.FOLLOW_EQEQ_in_expr367)

                    self.match(self.input, DOWN, None)
                    self._state.following.append(self.FOLLOW_expr_in_expr369)
                    self.expr()

                    self._state.following.pop()

                    self._state.following.append(self.FOLLOW_expr_in_expr371)
                    self.expr()

                    self._state.following.pop()

                    self.match(self.input, UP, None)



                elif alt7 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:58:9: ^( LT expr expr )
                    pass 
                    self.match(self.input, LT, self.FOLLOW_LT_in_expr383)

                    self.match(self.input, DOWN, None)
                    self._state.following.append(self.FOLLOW_expr_in_expr385)
                    self.expr()

                    self._state.following.pop()

                    self._state.following.append(self.FOLLOW_expr_in_expr387)
                    self.expr()

                    self._state.following.pop()

                    self.match(self.input, UP, None)



                elif alt7 == 3:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:59:9: ^( PLUS expr expr )
                    pass 
                    self.match(self.input, PLUS, self.FOLLOW_PLUS_in_expr399)

                    self.match(self.input, DOWN, None)
                    self._state.following.append(self.FOLLOW_expr_in_expr401)
                    self.expr()

                    self._state.following.pop()

                    self._state.following.append(self.FOLLOW_expr_in_expr403)
                    self.expr()

                    self._state.following.pop()

                    self.match(self.input, UP, None)



                elif alt7 == 4:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:60:9: ^( EQ ID expr )
                    pass 
                    self.match(self.input, EQ, self.FOLLOW_EQ_in_expr415)

                    self.match(self.input, DOWN, None)
                    self.match(self.input, ID, self.FOLLOW_ID_in_expr417)

                    self._state.following.append(self.FOLLOW_expr_in_expr419)
                    self.expr()

                    self._state.following.pop()

                    self.match(self.input, UP, None)



                elif alt7 == 5:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:61:9: atom
                    pass 
                    self._state.following.append(self.FOLLOW_atom_in_expr430)
                    self.atom()

                    self._state.following.pop()



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "expr"



    # $ANTLR start "atom"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:64:1: atom : ( ID | INT );
    def atom(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:65:5: ( ID | INT )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparserWalker.g:
                pass 
                if (ID <= self.input.LA(1) <= INT):
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

    # $ANTLR end "atom"



 

    FOLLOW_declaration_in_program49 = frozenset([1, 10, 11, 18])
    FOLLOW_variable_in_declaration69 = frozenset([1])
    FOLLOW_FUNC_DECL_in_declaration80 = frozenset([2])
    FOLLOW_functionHeader_in_declaration82 = frozenset([3])
    FOLLOW_FUNC_DEF_in_declaration94 = frozenset([2])
    FOLLOW_functionHeader_in_declaration96 = frozenset([5])
    FOLLOW_block_in_declaration98 = frozenset([3])
    FOLLOW_VAR_DEF_in_variable123 = frozenset([2])
    FOLLOW_type_in_variable125 = frozenset([13])
    FOLLOW_declarator_in_variable127 = frozenset([3])
    FOLLOW_ID_in_declarator157 = frozenset([1])
    FOLLOW_FUNC_HDR_in_functionHeader178 = frozenset([2])
    FOLLOW_type_in_functionHeader180 = frozenset([13])
    FOLLOW_ID_in_functionHeader182 = frozenset([4])
    FOLLOW_formalParameter_in_functionHeader184 = frozenset([3, 4])
    FOLLOW_ARG_DEF_in_formalParameter206 = frozenset([2])
    FOLLOW_type_in_formalParameter208 = frozenset([13])
    FOLLOW_declarator_in_formalParameter210 = frozenset([3])
    FOLLOW_BLOCK_in_block288 = frozenset([2])
    FOLLOW_variable_in_block290 = frozenset([3, 5, 7, 8, 9, 13, 14, 16, 17, 18])
    FOLLOW_stat_in_block293 = frozenset([3, 5, 7, 8, 9, 13, 14, 16, 17])
    FOLLOW_forStat_in_stat307 = frozenset([1])
    FOLLOW_expr_in_stat315 = frozenset([1])
    FOLLOW_block_in_stat323 = frozenset([1])
    FOLLOW_FOR_in_forStat343 = frozenset([2])
    FOLLOW_expr_in_forStat345 = frozenset([7, 8, 13, 14, 16, 17])
    FOLLOW_expr_in_forStat347 = frozenset([7, 8, 13, 14, 16, 17])
    FOLLOW_expr_in_forStat349 = frozenset([5])
    FOLLOW_block_in_forStat351 = frozenset([3])
    FOLLOW_EQEQ_in_expr367 = frozenset([2])
    FOLLOW_expr_in_expr369 = frozenset([7, 8, 13, 14, 16, 17])
    FOLLOW_expr_in_expr371 = frozenset([3])
    FOLLOW_LT_in_expr383 = frozenset([2])
    FOLLOW_expr_in_expr385 = frozenset([7, 8, 13, 14, 16, 17])
    FOLLOW_expr_in_expr387 = frozenset([3])
    FOLLOW_PLUS_in_expr399 = frozenset([2])
    FOLLOW_expr_in_expr401 = frozenset([7, 8, 13, 14, 16, 17])
    FOLLOW_expr_in_expr403 = frozenset([3])
    FOLLOW_EQ_in_expr415 = frozenset([2])
    FOLLOW_ID_in_expr417 = frozenset([7, 8, 13, 14, 16, 17])
    FOLLOW_expr_in_expr419 = frozenset([3])
    FOLLOW_atom_in_expr430 = frozenset([1])



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import WalkerMain
    main = WalkerMain(t047treeparserWalker)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
