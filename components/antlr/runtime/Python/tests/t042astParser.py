# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g 2013-01-03 10:51:51

import sys
from antlr3 import *
from antlr3.compat import set, frozenset

from antlr3.tree import *




# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EOF=-1
T__16=16
T__17=17
T__18=18
T__19=19
T__20=20
T__21=21
T__22=22
T__23=23
T__24=24
T__25=25
T__26=26
T__27=27
T__28=28
T__29=29
T__30=30
T__31=31
T__32=32
T__33=33
T__34=34
T__35=35
T__36=36
T__37=37
T__38=38
T__39=39
T__40=40
T__41=41
T__42=42
T__43=43
T__44=44
T__45=45
BLOCK=4
CALL=5
EXPR=6
FIELD=7
FIELDACCESS=8
FLOAT=9
ID=10
INDEX=11
INT=12
VARDEF=13
VARIABLE=14
WS=15

# token names
tokenNames = [
    "<invalid>", "<EOR>", "<DOWN>", "<UP>",
    "BLOCK", "CALL", "EXPR", "FIELD", "FIELDACCESS", "FLOAT", "ID", "INDEX", 
    "INT", "VARDEF", "VARIABLE", "WS", "'('", "')'", "'+'", "','", "'.'", 
    "':'", "';'", "'='", "'['", "']'", "'assert'", "'bool'", "'class'", 
    "'else'", "'extends'", "'foo28a'", "'foo28b'", "'fooze'", "'fooze2'", 
    "'for'", "'if'", "'implements'", "'int'", "'private'", "'public'", "'return'", 
    "'var'", "'while'", "'{'", "'}'"
]




class t042astParser(Parser):
    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g"
    api_version = 1
    tokenNames = tokenNames

    def __init__(self, input, state=None, *args, **kwargs):
        if state is None:
            state = RecognizerSharedState()

        super(t042astParser, self).__init__(input, state, *args, **kwargs)



              
        self.flag = False


        self.delegates = []

	self._adaptor = None
	self.adaptor = CommonTreeAdaptor()



    def getTreeAdaptor(self):
        return self._adaptor

    def setTreeAdaptor(self, adaptor):
        self._adaptor = adaptor

    adaptor = property(getTreeAdaptor, setTreeAdaptor)


    class r1_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r1_return, self).__init__()

            self.tree = None





    # $ANTLR start "r1"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:23:1: r1 : INT ( '+' ^ INT )* ;
    def r1(self, ):
        retval = self.r1_return()
        retval.start = self.input.LT(1)


        root_0 = None

        INT1 = None
        char_literal2 = None
        INT3 = None

        INT1_tree = None
        char_literal2_tree = None
        INT3_tree = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:24:5: ( INT ( '+' ^ INT )* )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:24:7: INT ( '+' ^ INT )*
                pass 
                root_0 = self._adaptor.nil()


                INT1 = self.match(self.input, INT, self.FOLLOW_INT_in_r1114)
                if self._state.backtracking == 0:
                    INT1_tree = self._adaptor.createWithPayload(INT1)
                    self._adaptor.addChild(root_0, INT1_tree)



                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:24:11: ( '+' ^ INT )*
                while True: #loop1
                    alt1 = 2
                    LA1_0 = self.input.LA(1)

                    if (LA1_0 == 18) :
                        alt1 = 1


                    if alt1 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:24:12: '+' ^ INT
                        pass 
                        char_literal2 = self.match(self.input, 18, self.FOLLOW_18_in_r1117)
                        if self._state.backtracking == 0:
                            char_literal2_tree = self._adaptor.createWithPayload(char_literal2)
                            root_0 = self._adaptor.becomeRoot(char_literal2_tree, root_0)



                        INT3 = self.match(self.input, INT, self.FOLLOW_INT_in_r1120)
                        if self._state.backtracking == 0:
                            INT3_tree = self._adaptor.createWithPayload(INT3)
                            self._adaptor.addChild(root_0, INT3_tree)




                    else:
                        break #loop1




                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r1"


    class r2_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r2_return, self).__init__()

            self.tree = None





    # $ANTLR start "r2"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:27:1: r2 : 'assert' ^x= expression ( ':' !y= expression )? ';' !;
    def r2(self, ):
        retval = self.r2_return()
        retval.start = self.input.LT(1)


        root_0 = None

        string_literal4 = None
        char_literal5 = None
        char_literal6 = None
        x = None

        y = None


        string_literal4_tree = None
        char_literal5_tree = None
        char_literal6_tree = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:28:5: ( 'assert' ^x= expression ( ':' !y= expression )? ';' !)
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:28:7: 'assert' ^x= expression ( ':' !y= expression )? ';' !
                pass 
                root_0 = self._adaptor.nil()


                string_literal4 = self.match(self.input, 26, self.FOLLOW_26_in_r2139)
                if self._state.backtracking == 0:
                    string_literal4_tree = self._adaptor.createWithPayload(string_literal4)
                    root_0 = self._adaptor.becomeRoot(string_literal4_tree, root_0)



                self._state.following.append(self.FOLLOW_expression_in_r2144)
                x = self.expression()

                self._state.following.pop()
                if self._state.backtracking == 0:
                    self._adaptor.addChild(root_0, x.tree)


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:28:30: ( ':' !y= expression )?
                alt2 = 2
                LA2_0 = self.input.LA(1)

                if (LA2_0 == 21) :
                    alt2 = 1
                if alt2 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:28:31: ':' !y= expression
                    pass 
                    char_literal5 = self.match(self.input, 21, self.FOLLOW_21_in_r2147)

                    self._state.following.append(self.FOLLOW_expression_in_r2152)
                    y = self.expression()

                    self._state.following.pop()
                    if self._state.backtracking == 0:
                        self._adaptor.addChild(root_0, y.tree)





                char_literal6 = self.match(self.input, 22, self.FOLLOW_22_in_r2156)



                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r2"


    class r3_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r3_return, self).__init__()

            self.tree = None





    # $ANTLR start "r3"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:31:1: r3 : 'if' ^ expression s1= statement ( 'else' !s2= statement )? ;
    def r3(self, ):
        retval = self.r3_return()
        retval.start = self.input.LT(1)


        root_0 = None

        string_literal7 = None
        string_literal9 = None
        s1 = None

        s2 = None

        expression8 = None


        string_literal7_tree = None
        string_literal9_tree = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:32:5: ( 'if' ^ expression s1= statement ( 'else' !s2= statement )? )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:32:7: 'if' ^ expression s1= statement ( 'else' !s2= statement )?
                pass 
                root_0 = self._adaptor.nil()


                string_literal7 = self.match(self.input, 36, self.FOLLOW_36_in_r3174)
                if self._state.backtracking == 0:
                    string_literal7_tree = self._adaptor.createWithPayload(string_literal7)
                    root_0 = self._adaptor.becomeRoot(string_literal7_tree, root_0)



                self._state.following.append(self.FOLLOW_expression_in_r3177)
                expression8 = self.expression()

                self._state.following.pop()
                if self._state.backtracking == 0:
                    self._adaptor.addChild(root_0, expression8.tree)


                self._state.following.append(self.FOLLOW_statement_in_r3181)
                s1 = self.statement()

                self._state.following.pop()
                if self._state.backtracking == 0:
                    self._adaptor.addChild(root_0, s1.tree)


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:32:37: ( 'else' !s2= statement )?
                alt3 = 2
                LA3_0 = self.input.LA(1)

                if (LA3_0 == 29) :
                    alt3 = 1
                if alt3 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:32:38: 'else' !s2= statement
                    pass 
                    string_literal9 = self.match(self.input, 29, self.FOLLOW_29_in_r3184)

                    self._state.following.append(self.FOLLOW_statement_in_r3189)
                    s2 = self.statement()

                    self._state.following.pop()
                    if self._state.backtracking == 0:
                        self._adaptor.addChild(root_0, s2.tree)







                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r3"


    class r4_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r4_return, self).__init__()

            self.tree = None





    # $ANTLR start "r4"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:35:1: r4 : 'while' ^ expression statement ;
    def r4(self, ):
        retval = self.r4_return()
        retval.start = self.input.LT(1)


        root_0 = None

        string_literal10 = None
        expression11 = None

        statement12 = None


        string_literal10_tree = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:36:5: ( 'while' ^ expression statement )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:36:7: 'while' ^ expression statement
                pass 
                root_0 = self._adaptor.nil()


                string_literal10 = self.match(self.input, 43, self.FOLLOW_43_in_r4208)
                if self._state.backtracking == 0:
                    string_literal10_tree = self._adaptor.createWithPayload(string_literal10)
                    root_0 = self._adaptor.becomeRoot(string_literal10_tree, root_0)



                self._state.following.append(self.FOLLOW_expression_in_r4211)
                expression11 = self.expression()

                self._state.following.pop()
                if self._state.backtracking == 0:
                    self._adaptor.addChild(root_0, expression11.tree)


                self._state.following.append(self.FOLLOW_statement_in_r4213)
                statement12 = self.statement()

                self._state.following.pop()
                if self._state.backtracking == 0:
                    self._adaptor.addChild(root_0, statement12.tree)




                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r4"


    class r5_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r5_return, self).__init__()

            self.tree = None





    # $ANTLR start "r5"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:39:1: r5 : 'return' ^ ( expression )? ';' !;
    def r5(self, ):
        retval = self.r5_return()
        retval.start = self.input.LT(1)


        root_0 = None

        string_literal13 = None
        char_literal15 = None
        expression14 = None


        string_literal13_tree = None
        char_literal15_tree = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:40:5: ( 'return' ^ ( expression )? ';' !)
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:40:7: 'return' ^ ( expression )? ';' !
                pass 
                root_0 = self._adaptor.nil()


                string_literal13 = self.match(self.input, 41, self.FOLLOW_41_in_r5230)
                if self._state.backtracking == 0:
                    string_literal13_tree = self._adaptor.createWithPayload(string_literal13)
                    root_0 = self._adaptor.becomeRoot(string_literal13_tree, root_0)



                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:40:17: ( expression )?
                alt4 = 2
                LA4_0 = self.input.LA(1)

                if (LA4_0 == INT) :
                    alt4 = 1
                if alt4 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:40:17: expression
                    pass 
                    self._state.following.append(self.FOLLOW_expression_in_r5233)
                    expression14 = self.expression()

                    self._state.following.pop()
                    if self._state.backtracking == 0:
                        self._adaptor.addChild(root_0, expression14.tree)





                char_literal15 = self.match(self.input, 22, self.FOLLOW_22_in_r5236)



                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r5"


    class r6_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r6_return, self).__init__()

            self.tree = None





    # $ANTLR start "r6"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:43:1: r6 : ( INT | ID )+ ;
    def r6(self, ):
        retval = self.r6_return()
        retval.start = self.input.LT(1)


        root_0 = None

        set16 = None

        set16_tree = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:44:5: ( ( INT | ID )+ )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:44:7: ( INT | ID )+
                pass 
                root_0 = self._adaptor.nil()


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:44:7: ( INT | ID )+
                cnt5 = 0
                while True: #loop5
                    alt5 = 2
                    LA5_0 = self.input.LA(1)

                    if (LA5_0 == ID or LA5_0 == INT) :
                        alt5 = 1


                    if alt5 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:
                        pass 
                        set16 = self.input.LT(1)

                        if self.input.LA(1) == ID or self.input.LA(1) == INT:
                            self.input.consume()
                            if self._state.backtracking == 0:
                                self._adaptor.addChild(root_0, self._adaptor.createWithPayload(set16))

                            self._state.errorRecovery = False


                        else:
                            if self._state.backtracking > 0:
                                raise BacktrackingFailed


                            mse = MismatchedSetException(None, self.input)
                            raise mse




                    else:
                        if cnt5 >= 1:
                            break #loop5

                        if self._state.backtracking > 0:
                            raise BacktrackingFailed


                        eee = EarlyExitException(5, self.input)
                        raise eee

                    cnt5 += 1




                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r6"


    class r7_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r7_return, self).__init__()

            self.tree = None





    # $ANTLR start "r7"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:47:1: r7 : INT ->;
    def r7(self, ):
        retval = self.r7_return()
        retval.start = self.input.LT(1)


        root_0 = None

        INT17 = None

        INT17_tree = None
        stream_INT = RewriteRuleTokenStream(self._adaptor, "token INT")

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:48:5: ( INT ->)
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:48:7: INT
                pass 
                INT17 = self.match(self.input, INT, self.FOLLOW_INT_in_r7276) 
                if self._state.backtracking == 0:
                    stream_INT.add(INT17)


                # AST Rewrite
                # elements: 
                # token labels: 
                # rule labels: retval
                # token list labels: 
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                    root_0 = self._adaptor.nil()
                    # 48:11: ->
                    root_0 = None



                    retval.tree = root_0





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r7"


    class r8_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r8_return, self).__init__()

            self.tree = None





    # $ANTLR start "r8"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:51:1: r8 : 'var' ID ':' type -> ^( 'var' type ID ) ;
    def r8(self, ):
        retval = self.r8_return()
        retval.start = self.input.LT(1)


        root_0 = None

        string_literal18 = None
        ID19 = None
        char_literal20 = None
        type21 = None


        string_literal18_tree = None
        ID19_tree = None
        char_literal20_tree = None
        stream_21 = RewriteRuleTokenStream(self._adaptor, "token 21")
        stream_42 = RewriteRuleTokenStream(self._adaptor, "token 42")
        stream_ID = RewriteRuleTokenStream(self._adaptor, "token ID")
        stream_type = RewriteRuleSubtreeStream(self._adaptor, "rule type")
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:52:5: ( 'var' ID ':' type -> ^( 'var' type ID ) )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:52:7: 'var' ID ':' type
                pass 
                string_literal18 = self.match(self.input, 42, self.FOLLOW_42_in_r8296) 
                if self._state.backtracking == 0:
                    stream_42.add(string_literal18)


                ID19 = self.match(self.input, ID, self.FOLLOW_ID_in_r8298) 
                if self._state.backtracking == 0:
                    stream_ID.add(ID19)


                char_literal20 = self.match(self.input, 21, self.FOLLOW_21_in_r8300) 
                if self._state.backtracking == 0:
                    stream_21.add(char_literal20)


                self._state.following.append(self.FOLLOW_type_in_r8302)
                type21 = self.type()

                self._state.following.pop()
                if self._state.backtracking == 0:
                    stream_type.add(type21.tree)


                # AST Rewrite
                # elements: ID, 42, type
                # token labels: 
                # rule labels: retval
                # token list labels: 
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                    root_0 = self._adaptor.nil()
                    # 52:25: -> ^( 'var' type ID )
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:52:28: ^( 'var' type ID )
                    root_1 = self._adaptor.nil()
                    root_1 = self._adaptor.becomeRoot(
                    stream_42.nextNode()
                    , root_1)

                    self._adaptor.addChild(root_1, stream_type.nextTree())

                    self._adaptor.addChild(root_1, 
                    stream_ID.nextNode()
                    )

                    self._adaptor.addChild(root_0, root_1)




                    retval.tree = root_0





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r8"


    class r9_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r9_return, self).__init__()

            self.tree = None





    # $ANTLR start "r9"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:55:1: r9 : type ID ';' -> ^( VARDEF type ID ) ;
    def r9(self, ):
        retval = self.r9_return()
        retval.start = self.input.LT(1)


        root_0 = None

        ID23 = None
        char_literal24 = None
        type22 = None


        ID23_tree = None
        char_literal24_tree = None
        stream_ID = RewriteRuleTokenStream(self._adaptor, "token ID")
        stream_22 = RewriteRuleTokenStream(self._adaptor, "token 22")
        stream_type = RewriteRuleSubtreeStream(self._adaptor, "rule type")
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:56:5: ( type ID ';' -> ^( VARDEF type ID ) )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:56:7: type ID ';'
                pass 
                self._state.following.append(self.FOLLOW_type_in_r9330)
                type22 = self.type()

                self._state.following.pop()
                if self._state.backtracking == 0:
                    stream_type.add(type22.tree)


                ID23 = self.match(self.input, ID, self.FOLLOW_ID_in_r9332) 
                if self._state.backtracking == 0:
                    stream_ID.add(ID23)


                char_literal24 = self.match(self.input, 22, self.FOLLOW_22_in_r9334) 
                if self._state.backtracking == 0:
                    stream_22.add(char_literal24)


                # AST Rewrite
                # elements: ID, type
                # token labels: 
                # rule labels: retval
                # token list labels: 
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                    root_0 = self._adaptor.nil()
                    # 56:19: -> ^( VARDEF type ID )
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:56:22: ^( VARDEF type ID )
                    root_1 = self._adaptor.nil()
                    root_1 = self._adaptor.becomeRoot(
                    self._adaptor.createFromType(VARDEF, "VARDEF")
                    , root_1)

                    self._adaptor.addChild(root_1, stream_type.nextTree())

                    self._adaptor.addChild(root_1, 
                    stream_ID.nextNode()
                    )

                    self._adaptor.addChild(root_0, root_1)




                    retval.tree = root_0





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r9"


    class r10_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r10_return, self).__init__()

            self.tree = None





    # $ANTLR start "r10"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:59:1: r10 : INT ->;
    def r10(self, ):
        retval = self.r10_return()
        retval.start = self.input.LT(1)


        root_0 = None

        INT25 = None

        INT25_tree = None
        stream_INT = RewriteRuleTokenStream(self._adaptor, "token INT")

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:60:5: ( INT ->)
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:60:7: INT
                pass 
                INT25 = self.match(self.input, INT, self.FOLLOW_INT_in_r10362) 
                if self._state.backtracking == 0:
                    stream_INT.add(INT25)


                # AST Rewrite
                # elements: 
                # token labels: 
                # rule labels: retval
                # token list labels: 
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                    root_0 = self._adaptor.nil()
                    # 60:11: ->
                    self._adaptor.addChild(root_0, CommonTree(CommonToken(type=FLOAT, text=INT25.text + ".0")))




                    retval.tree = root_0





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r10"


    class r11_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r11_return, self).__init__()

            self.tree = None





    # $ANTLR start "r11"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:63:1: r11 : ( expression -> ^( EXPR expression ) | -> EXPR );
    def r11(self, ):
        retval = self.r11_return()
        retval.start = self.input.LT(1)


        root_0 = None

        expression26 = None


        stream_expression = RewriteRuleSubtreeStream(self._adaptor, "rule expression")
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:64:5: ( expression -> ^( EXPR expression ) | -> EXPR )
                alt6 = 2
                LA6_0 = self.input.LA(1)

                if (LA6_0 == INT) :
                    alt6 = 1
                elif (LA6_0 == EOF) :
                    alt6 = 2
                else:
                    if self._state.backtracking > 0:
                        raise BacktrackingFailed


                    nvae = NoViableAltException("", 6, 0, self.input)

                    raise nvae


                if alt6 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:64:7: expression
                    pass 
                    self._state.following.append(self.FOLLOW_expression_in_r11383)
                    expression26 = self.expression()

                    self._state.following.pop()
                    if self._state.backtracking == 0:
                        stream_expression.add(expression26.tree)


                    # AST Rewrite
                    # elements: expression
                    # token labels: 
                    # rule labels: retval
                    # token list labels: 
                    # rule list labels: 
                    # wildcard labels: 
                    if self._state.backtracking == 0:
                        retval.tree = root_0
                        if retval is not None:
                            stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                        else:
                            stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                        root_0 = self._adaptor.nil()
                        # 64:18: -> ^( EXPR expression )
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:64:21: ^( EXPR expression )
                        root_1 = self._adaptor.nil()
                        root_1 = self._adaptor.becomeRoot(
                        self._adaptor.createFromType(EXPR, "EXPR")
                        , root_1)

                        self._adaptor.addChild(root_1, stream_expression.nextTree())

                        self._adaptor.addChild(root_0, root_1)




                        retval.tree = root_0




                elif alt6 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:65:7: 
                    pass 
                    # AST Rewrite
                    # elements: 
                    # token labels: 
                    # rule labels: retval
                    # token list labels: 
                    # rule list labels: 
                    # wildcard labels: 
                    if self._state.backtracking == 0:
                        retval.tree = root_0
                        if retval is not None:
                            stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                        else:
                            stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                        root_0 = self._adaptor.nil()
                        # 65:7: -> EXPR
                        self._adaptor.addChild(root_0, 
                        self._adaptor.createFromType(EXPR, "EXPR")
                        )




                        retval.tree = root_0




                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r11"


    class r12_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r12_return, self).__init__()

            self.tree = None





    # $ANTLR start "r12"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:68:1: r12 : ID ( ',' ID )* -> ( ID )+ ;
    def r12(self, ):
        retval = self.r12_return()
        retval.start = self.input.LT(1)


        root_0 = None

        ID27 = None
        char_literal28 = None
        ID29 = None

        ID27_tree = None
        char_literal28_tree = None
        ID29_tree = None
        stream_19 = RewriteRuleTokenStream(self._adaptor, "token 19")
        stream_ID = RewriteRuleTokenStream(self._adaptor, "token ID")

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:69:5: ( ID ( ',' ID )* -> ( ID )+ )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:69:7: ID ( ',' ID )*
                pass 
                ID27 = self.match(self.input, ID, self.FOLLOW_ID_in_r12418) 
                if self._state.backtracking == 0:
                    stream_ID.add(ID27)


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:69:10: ( ',' ID )*
                while True: #loop7
                    alt7 = 2
                    LA7_0 = self.input.LA(1)

                    if (LA7_0 == 19) :
                        alt7 = 1


                    if alt7 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:69:11: ',' ID
                        pass 
                        char_literal28 = self.match(self.input, 19, self.FOLLOW_19_in_r12421) 
                        if self._state.backtracking == 0:
                            stream_19.add(char_literal28)


                        ID29 = self.match(self.input, ID, self.FOLLOW_ID_in_r12423) 
                        if self._state.backtracking == 0:
                            stream_ID.add(ID29)



                    else:
                        break #loop7


                # AST Rewrite
                # elements: ID
                # token labels: 
                # rule labels: retval
                # token list labels: 
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                    root_0 = self._adaptor.nil()
                    # 69:20: -> ( ID )+
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:69:23: ( ID )+
                    if not (stream_ID.hasNext()):
                        raise RewriteEarlyExitException()

                    while stream_ID.hasNext():
                        self._adaptor.addChild(root_0, 
                        stream_ID.nextNode()
                        )


                    stream_ID.reset()




                    retval.tree = root_0





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r12"


    class r13_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r13_return, self).__init__()

            self.tree = None





    # $ANTLR start "r13"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:72:1: r13 : type ID ( ',' ID )* ';' -> ^( type ( ID )+ ) ;
    def r13(self, ):
        retval = self.r13_return()
        retval.start = self.input.LT(1)


        root_0 = None

        ID31 = None
        char_literal32 = None
        ID33 = None
        char_literal34 = None
        type30 = None


        ID31_tree = None
        char_literal32_tree = None
        ID33_tree = None
        char_literal34_tree = None
        stream_19 = RewriteRuleTokenStream(self._adaptor, "token 19")
        stream_ID = RewriteRuleTokenStream(self._adaptor, "token ID")
        stream_22 = RewriteRuleTokenStream(self._adaptor, "token 22")
        stream_type = RewriteRuleSubtreeStream(self._adaptor, "rule type")
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:73:5: ( type ID ( ',' ID )* ';' -> ^( type ( ID )+ ) )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:73:7: type ID ( ',' ID )* ';'
                pass 
                self._state.following.append(self.FOLLOW_type_in_r13447)
                type30 = self.type()

                self._state.following.pop()
                if self._state.backtracking == 0:
                    stream_type.add(type30.tree)


                ID31 = self.match(self.input, ID, self.FOLLOW_ID_in_r13449) 
                if self._state.backtracking == 0:
                    stream_ID.add(ID31)


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:73:15: ( ',' ID )*
                while True: #loop8
                    alt8 = 2
                    LA8_0 = self.input.LA(1)

                    if (LA8_0 == 19) :
                        alt8 = 1


                    if alt8 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:73:16: ',' ID
                        pass 
                        char_literal32 = self.match(self.input, 19, self.FOLLOW_19_in_r13452) 
                        if self._state.backtracking == 0:
                            stream_19.add(char_literal32)


                        ID33 = self.match(self.input, ID, self.FOLLOW_ID_in_r13454) 
                        if self._state.backtracking == 0:
                            stream_ID.add(ID33)



                    else:
                        break #loop8


                char_literal34 = self.match(self.input, 22, self.FOLLOW_22_in_r13458) 
                if self._state.backtracking == 0:
                    stream_22.add(char_literal34)


                # AST Rewrite
                # elements: type, ID
                # token labels: 
                # rule labels: retval
                # token list labels: 
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                    root_0 = self._adaptor.nil()
                    # 73:29: -> ^( type ( ID )+ )
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:73:32: ^( type ( ID )+ )
                    root_1 = self._adaptor.nil()
                    root_1 = self._adaptor.becomeRoot(stream_type.nextNode(), root_1)

                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:73:39: ( ID )+
                    if not (stream_ID.hasNext()):
                        raise RewriteEarlyExitException()

                    while stream_ID.hasNext():
                        self._adaptor.addChild(root_1, 
                        stream_ID.nextNode()
                        )


                    stream_ID.reset()

                    self._adaptor.addChild(root_0, root_1)




                    retval.tree = root_0





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r13"


    class r14_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r14_return, self).__init__()

            self.tree = None





    # $ANTLR start "r14"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:76:1: r14 : ( expression )? ( statement )* ( type )+ -> ^( EXPR ( expression )? ( statement )* ( type )+ ) ;
    def r14(self, ):
        retval = self.r14_return()
        retval.start = self.input.LT(1)


        root_0 = None

        expression35 = None

        statement36 = None

        type37 = None


        stream_expression = RewriteRuleSubtreeStream(self._adaptor, "rule expression")
        stream_statement = RewriteRuleSubtreeStream(self._adaptor, "rule statement")
        stream_type = RewriteRuleSubtreeStream(self._adaptor, "rule type")
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:77:5: ( ( expression )? ( statement )* ( type )+ -> ^( EXPR ( expression )? ( statement )* ( type )+ ) )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:77:9: ( expression )? ( statement )* ( type )+
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:77:9: ( expression )?
                alt9 = 2
                LA9_0 = self.input.LA(1)

                if (LA9_0 == INT) :
                    alt9 = 1
                if alt9 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:77:9: expression
                    pass 
                    self._state.following.append(self.FOLLOW_expression_in_r14486)
                    expression35 = self.expression()

                    self._state.following.pop()
                    if self._state.backtracking == 0:
                        stream_expression.add(expression35.tree)





                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:77:21: ( statement )*
                while True: #loop10
                    alt10 = 2
                    LA10_0 = self.input.LA(1)

                    if ((33 <= LA10_0 <= 34)) :
                        alt10 = 1


                    if alt10 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:77:21: statement
                        pass 
                        self._state.following.append(self.FOLLOW_statement_in_r14489)
                        statement36 = self.statement()

                        self._state.following.pop()
                        if self._state.backtracking == 0:
                            stream_statement.add(statement36.tree)



                    else:
                        break #loop10


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:77:32: ( type )+
                cnt11 = 0
                while True: #loop11
                    alt11 = 2
                    LA11_0 = self.input.LA(1)

                    if (LA11_0 == 27 or LA11_0 == 38) :
                        alt11 = 1


                    if alt11 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:77:32: type
                        pass 
                        self._state.following.append(self.FOLLOW_type_in_r14492)
                        type37 = self.type()

                        self._state.following.pop()
                        if self._state.backtracking == 0:
                            stream_type.add(type37.tree)



                    else:
                        if cnt11 >= 1:
                            break #loop11

                        if self._state.backtracking > 0:
                            raise BacktrackingFailed


                        eee = EarlyExitException(11, self.input)
                        raise eee

                    cnt11 += 1


                # AST Rewrite
                # elements: type, expression, statement
                # token labels: 
                # rule labels: retval
                # token list labels: 
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                    root_0 = self._adaptor.nil()
                    # 78:9: -> ^( EXPR ( expression )? ( statement )* ( type )+ )
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:78:12: ^( EXPR ( expression )? ( statement )* ( type )+ )
                    root_1 = self._adaptor.nil()
                    root_1 = self._adaptor.becomeRoot(
                    self._adaptor.createFromType(EXPR, "EXPR")
                    , root_1)

                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:78:19: ( expression )?
                    if stream_expression.hasNext():
                        self._adaptor.addChild(root_1, stream_expression.nextTree())


                    stream_expression.reset();

                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:78:31: ( statement )*
                    while stream_statement.hasNext():
                        self._adaptor.addChild(root_1, stream_statement.nextTree())


                    stream_statement.reset();

                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:78:42: ( type )+
                    if not (stream_type.hasNext()):
                        raise RewriteEarlyExitException()

                    while stream_type.hasNext():
                        self._adaptor.addChild(root_1, stream_type.nextTree())


                    stream_type.reset()

                    self._adaptor.addChild(root_0, root_1)




                    retval.tree = root_0





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r14"


    class r15_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r15_return, self).__init__()

            self.tree = None





    # $ANTLR start "r15"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:81:1: r15 : INT -> INT INT ;
    def r15(self, ):
        retval = self.r15_return()
        retval.start = self.input.LT(1)


        root_0 = None

        INT38 = None

        INT38_tree = None
        stream_INT = RewriteRuleTokenStream(self._adaptor, "token INT")

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:82:5: ( INT -> INT INT )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:82:7: INT
                pass 
                INT38 = self.match(self.input, INT, self.FOLLOW_INT_in_r15533) 
                if self._state.backtracking == 0:
                    stream_INT.add(INT38)


                # AST Rewrite
                # elements: INT, INT
                # token labels: 
                # rule labels: retval
                # token list labels: 
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                    root_0 = self._adaptor.nil()
                    # 82:11: -> INT INT
                    self._adaptor.addChild(root_0, 
                    stream_INT.nextNode()
                    )

                    self._adaptor.addChild(root_0, 
                    stream_INT.nextNode()
                    )




                    retval.tree = root_0





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r15"


    class r16_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r16_return, self).__init__()

            self.tree = None





    # $ANTLR start "r16"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:85:1: r16 : 'int' ID ( ',' ID )* -> ( ^( 'int' ID ) )+ ;
    def r16(self, ):
        retval = self.r16_return()
        retval.start = self.input.LT(1)


        root_0 = None

        string_literal39 = None
        ID40 = None
        char_literal41 = None
        ID42 = None

        string_literal39_tree = None
        ID40_tree = None
        char_literal41_tree = None
        ID42_tree = None
        stream_19 = RewriteRuleTokenStream(self._adaptor, "token 19")
        stream_ID = RewriteRuleTokenStream(self._adaptor, "token ID")
        stream_38 = RewriteRuleTokenStream(self._adaptor, "token 38")

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:86:5: ( 'int' ID ( ',' ID )* -> ( ^( 'int' ID ) )+ )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:86:7: 'int' ID ( ',' ID )*
                pass 
                string_literal39 = self.match(self.input, 38, self.FOLLOW_38_in_r16556) 
                if self._state.backtracking == 0:
                    stream_38.add(string_literal39)


                ID40 = self.match(self.input, ID, self.FOLLOW_ID_in_r16558) 
                if self._state.backtracking == 0:
                    stream_ID.add(ID40)


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:86:16: ( ',' ID )*
                while True: #loop12
                    alt12 = 2
                    LA12_0 = self.input.LA(1)

                    if (LA12_0 == 19) :
                        alt12 = 1


                    if alt12 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:86:17: ',' ID
                        pass 
                        char_literal41 = self.match(self.input, 19, self.FOLLOW_19_in_r16561) 
                        if self._state.backtracking == 0:
                            stream_19.add(char_literal41)


                        ID42 = self.match(self.input, ID, self.FOLLOW_ID_in_r16563) 
                        if self._state.backtracking == 0:
                            stream_ID.add(ID42)



                    else:
                        break #loop12


                # AST Rewrite
                # elements: ID, 38
                # token labels: 
                # rule labels: retval
                # token list labels: 
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                    root_0 = self._adaptor.nil()
                    # 86:26: -> ( ^( 'int' ID ) )+
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:86:29: ( ^( 'int' ID ) )+
                    if not (stream_ID.hasNext() or stream_38.hasNext()):
                        raise RewriteEarlyExitException()

                    while stream_ID.hasNext() or stream_38.hasNext():
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:86:29: ^( 'int' ID )
                        root_1 = self._adaptor.nil()
                        root_1 = self._adaptor.becomeRoot(
                        stream_38.nextNode()
                        , root_1)

                        self._adaptor.addChild(root_1, 
                        stream_ID.nextNode()
                        )

                        self._adaptor.addChild(root_0, root_1)


                    stream_ID.reset()
                    stream_38.reset()




                    retval.tree = root_0





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r16"


    class r17_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r17_return, self).__init__()

            self.tree = None





    # $ANTLR start "r17"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:89:1: r17 : 'for' '(' start= statement ';' expression ';' next= statement ')' statement -> ^( 'for' $start expression $next statement ) ;
    def r17(self, ):
        retval = self.r17_return()
        retval.start = self.input.LT(1)


        root_0 = None

        string_literal43 = None
        char_literal44 = None
        char_literal45 = None
        char_literal47 = None
        char_literal48 = None
        start = None

        next = None

        expression46 = None

        statement49 = None


        string_literal43_tree = None
        char_literal44_tree = None
        char_literal45_tree = None
        char_literal47_tree = None
        char_literal48_tree = None
        stream_17 = RewriteRuleTokenStream(self._adaptor, "token 17")
        stream_35 = RewriteRuleTokenStream(self._adaptor, "token 35")
        stream_22 = RewriteRuleTokenStream(self._adaptor, "token 22")
        stream_16 = RewriteRuleTokenStream(self._adaptor, "token 16")
        stream_statement = RewriteRuleSubtreeStream(self._adaptor, "rule statement")
        stream_expression = RewriteRuleSubtreeStream(self._adaptor, "rule expression")
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:90:5: ( 'for' '(' start= statement ';' expression ';' next= statement ')' statement -> ^( 'for' $start expression $next statement ) )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:90:7: 'for' '(' start= statement ';' expression ';' next= statement ')' statement
                pass 
                string_literal43 = self.match(self.input, 35, self.FOLLOW_35_in_r17591) 
                if self._state.backtracking == 0:
                    stream_35.add(string_literal43)


                char_literal44 = self.match(self.input, 16, self.FOLLOW_16_in_r17593) 
                if self._state.backtracking == 0:
                    stream_16.add(char_literal44)


                self._state.following.append(self.FOLLOW_statement_in_r17597)
                start = self.statement()

                self._state.following.pop()
                if self._state.backtracking == 0:
                    stream_statement.add(start.tree)


                char_literal45 = self.match(self.input, 22, self.FOLLOW_22_in_r17599) 
                if self._state.backtracking == 0:
                    stream_22.add(char_literal45)


                self._state.following.append(self.FOLLOW_expression_in_r17601)
                expression46 = self.expression()

                self._state.following.pop()
                if self._state.backtracking == 0:
                    stream_expression.add(expression46.tree)


                char_literal47 = self.match(self.input, 22, self.FOLLOW_22_in_r17603) 
                if self._state.backtracking == 0:
                    stream_22.add(char_literal47)


                self._state.following.append(self.FOLLOW_statement_in_r17607)
                next = self.statement()

                self._state.following.pop()
                if self._state.backtracking == 0:
                    stream_statement.add(next.tree)


                char_literal48 = self.match(self.input, 17, self.FOLLOW_17_in_r17609) 
                if self._state.backtracking == 0:
                    stream_17.add(char_literal48)


                self._state.following.append(self.FOLLOW_statement_in_r17611)
                statement49 = self.statement()

                self._state.following.pop()
                if self._state.backtracking == 0:
                    stream_statement.add(statement49.tree)


                # AST Rewrite
                # elements: 35, start, expression, next, statement
                # token labels: 
                # rule labels: retval, start, next
                # token list labels: 
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)

                    if start is not None:
                        stream_start = RewriteRuleSubtreeStream(self._adaptor, "rule start", start.tree)
                    else:
                        stream_start = RewriteRuleSubtreeStream(self._adaptor, "token start", None)

                    if next is not None:
                        stream_next = RewriteRuleSubtreeStream(self._adaptor, "rule next", next.tree)
                    else:
                        stream_next = RewriteRuleSubtreeStream(self._adaptor, "token next", None)


                    root_0 = self._adaptor.nil()
                    # 91:9: -> ^( 'for' $start expression $next statement )
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:91:12: ^( 'for' $start expression $next statement )
                    root_1 = self._adaptor.nil()
                    root_1 = self._adaptor.becomeRoot(
                    stream_35.nextNode()
                    , root_1)

                    self._adaptor.addChild(root_1, stream_start.nextTree())

                    self._adaptor.addChild(root_1, stream_expression.nextTree())

                    self._adaptor.addChild(root_1, stream_next.nextTree())

                    self._adaptor.addChild(root_1, stream_statement.nextTree())

                    self._adaptor.addChild(root_0, root_1)




                    retval.tree = root_0





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r17"


    class r18_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r18_return, self).__init__()

            self.tree = None





    # $ANTLR start "r18"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:94:1: r18 : t= 'for' -> ^( BLOCK ) ;
    def r18(self, ):
        retval = self.r18_return()
        retval.start = self.input.LT(1)


        root_0 = None

        t = None

        t_tree = None
        stream_35 = RewriteRuleTokenStream(self._adaptor, "token 35")

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:95:5: (t= 'for' -> ^( BLOCK ) )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:95:7: t= 'for'
                pass 
                t = self.match(self.input, 35, self.FOLLOW_35_in_r18654) 
                if self._state.backtracking == 0:
                    stream_35.add(t)


                # AST Rewrite
                # elements: 
                # token labels: 
                # rule labels: retval
                # token list labels: 
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                    root_0 = self._adaptor.nil()
                    # 95:15: -> ^( BLOCK )
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:95:18: ^( BLOCK )
                    root_1 = self._adaptor.nil()
                    root_1 = self._adaptor.becomeRoot(
                    self._adaptor.createFromType(BLOCK, "BLOCK")
                    , root_1)

                    self._adaptor.addChild(root_0, root_1)




                    retval.tree = root_0





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r18"


    class r19_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r19_return, self).__init__()

            self.tree = None





    # $ANTLR start "r19"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:98:1: r19 : t= 'for' -> ^( BLOCK[$t] ) ;
    def r19(self, ):
        retval = self.r19_return()
        retval.start = self.input.LT(1)


        root_0 = None

        t = None

        t_tree = None
        stream_35 = RewriteRuleTokenStream(self._adaptor, "token 35")

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:99:5: (t= 'for' -> ^( BLOCK[$t] ) )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:99:7: t= 'for'
                pass 
                t = self.match(self.input, 35, self.FOLLOW_35_in_r19679) 
                if self._state.backtracking == 0:
                    stream_35.add(t)


                # AST Rewrite
                # elements: 
                # token labels: 
                # rule labels: retval
                # token list labels: 
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                    root_0 = self._adaptor.nil()
                    # 99:15: -> ^( BLOCK[$t] )
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:99:18: ^( BLOCK[$t] )
                    root_1 = self._adaptor.nil()
                    root_1 = self._adaptor.becomeRoot(
                    self._adaptor.create(BLOCK, t)
                    , root_1)

                    self._adaptor.addChild(root_0, root_1)




                    retval.tree = root_0





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r19"


    class r20_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r20_return, self).__init__()

            self.tree = None





    # $ANTLR start "r20"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:102:1: r20 : t= 'for' -> ^( BLOCK[$t,\"FOR\"] ) ;
    def r20(self, ):
        retval = self.r20_return()
        retval.start = self.input.LT(1)


        root_0 = None

        t = None

        t_tree = None
        stream_35 = RewriteRuleTokenStream(self._adaptor, "token 35")

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:103:5: (t= 'for' -> ^( BLOCK[$t,\"FOR\"] ) )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:103:7: t= 'for'
                pass 
                t = self.match(self.input, 35, self.FOLLOW_35_in_r20705) 
                if self._state.backtracking == 0:
                    stream_35.add(t)


                # AST Rewrite
                # elements: 
                # token labels: 
                # rule labels: retval
                # token list labels: 
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                    root_0 = self._adaptor.nil()
                    # 103:15: -> ^( BLOCK[$t,\"FOR\"] )
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:103:18: ^( BLOCK[$t,\"FOR\"] )
                    root_1 = self._adaptor.nil()
                    root_1 = self._adaptor.becomeRoot(
                    self._adaptor.create(BLOCK, t, "FOR")
                    , root_1)

                    self._adaptor.addChild(root_0, root_1)




                    retval.tree = root_0





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r20"


    class r21_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r21_return, self).__init__()

            self.tree = None





    # $ANTLR start "r21"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:106:1: r21 : t= 'for' -> BLOCK ;
    def r21(self, ):
        retval = self.r21_return()
        retval.start = self.input.LT(1)


        root_0 = None

        t = None

        t_tree = None
        stream_35 = RewriteRuleTokenStream(self._adaptor, "token 35")

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:107:5: (t= 'for' -> BLOCK )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:107:7: t= 'for'
                pass 
                t = self.match(self.input, 35, self.FOLLOW_35_in_r21731) 
                if self._state.backtracking == 0:
                    stream_35.add(t)


                # AST Rewrite
                # elements: 
                # token labels: 
                # rule labels: retval
                # token list labels: 
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                    root_0 = self._adaptor.nil()
                    # 107:15: -> BLOCK
                    self._adaptor.addChild(root_0, 
                    self._adaptor.createFromType(BLOCK, "BLOCK")
                    )




                    retval.tree = root_0





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r21"


    class r22_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r22_return, self).__init__()

            self.tree = None





    # $ANTLR start "r22"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:110:1: r22 : t= 'for' -> BLOCK[$t] ;
    def r22(self, ):
        retval = self.r22_return()
        retval.start = self.input.LT(1)


        root_0 = None

        t = None

        t_tree = None
        stream_35 = RewriteRuleTokenStream(self._adaptor, "token 35")

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:111:5: (t= 'for' -> BLOCK[$t] )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:111:7: t= 'for'
                pass 
                t = self.match(self.input, 35, self.FOLLOW_35_in_r22754) 
                if self._state.backtracking == 0:
                    stream_35.add(t)


                # AST Rewrite
                # elements: 
                # token labels: 
                # rule labels: retval
                # token list labels: 
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                    root_0 = self._adaptor.nil()
                    # 111:15: -> BLOCK[$t]
                    self._adaptor.addChild(root_0, 
                    self._adaptor.create(BLOCK, t)
                    )




                    retval.tree = root_0





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r22"


    class r23_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r23_return, self).__init__()

            self.tree = None





    # $ANTLR start "r23"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:114:1: r23 : t= 'for' -> BLOCK[$t,\"FOR\"] ;
    def r23(self, ):
        retval = self.r23_return()
        retval.start = self.input.LT(1)


        root_0 = None

        t = None

        t_tree = None
        stream_35 = RewriteRuleTokenStream(self._adaptor, "token 35")

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:115:5: (t= 'for' -> BLOCK[$t,\"FOR\"] )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:115:7: t= 'for'
                pass 
                t = self.match(self.input, 35, self.FOLLOW_35_in_r23778) 
                if self._state.backtracking == 0:
                    stream_35.add(t)


                # AST Rewrite
                # elements: 
                # token labels: 
                # rule labels: retval
                # token list labels: 
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                    root_0 = self._adaptor.nil()
                    # 115:15: -> BLOCK[$t,\"FOR\"]
                    self._adaptor.addChild(root_0, 
                    self._adaptor.create(BLOCK, t, "FOR")
                    )




                    retval.tree = root_0





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r23"


    class r24_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r24_return, self).__init__()

            self.tree = None





    # $ANTLR start "r24"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:118:1: r24 : r= statement expression -> ^( $r expression ) ;
    def r24(self, ):
        retval = self.r24_return()
        retval.start = self.input.LT(1)


        root_0 = None

        r = None

        expression50 = None


        stream_statement = RewriteRuleSubtreeStream(self._adaptor, "rule statement")
        stream_expression = RewriteRuleSubtreeStream(self._adaptor, "rule expression")
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:119:5: (r= statement expression -> ^( $r expression ) )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:119:7: r= statement expression
                pass 
                self._state.following.append(self.FOLLOW_statement_in_r24802)
                r = self.statement()

                self._state.following.pop()
                if self._state.backtracking == 0:
                    stream_statement.add(r.tree)


                self._state.following.append(self.FOLLOW_expression_in_r24804)
                expression50 = self.expression()

                self._state.following.pop()
                if self._state.backtracking == 0:
                    stream_expression.add(expression50.tree)


                # AST Rewrite
                # elements: r, expression
                # token labels: 
                # rule labels: retval, r
                # token list labels: 
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)

                    if r is not None:
                        stream_r = RewriteRuleSubtreeStream(self._adaptor, "rule r", r.tree)
                    else:
                        stream_r = RewriteRuleSubtreeStream(self._adaptor, "token r", None)


                    root_0 = self._adaptor.nil()
                    # 119:30: -> ^( $r expression )
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:119:33: ^( $r expression )
                    root_1 = self._adaptor.nil()
                    root_1 = self._adaptor.becomeRoot(stream_r.nextNode(), root_1)

                    self._adaptor.addChild(root_1, stream_expression.nextTree())

                    self._adaptor.addChild(root_0, root_1)




                    retval.tree = root_0





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r24"


    class r25_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r25_return, self).__init__()

            self.tree = None





    # $ANTLR start "r25"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:122:1: r25 :r+= statement ( ',' r+= statement )+ expression -> ^( $r expression ) ;
    def r25(self, ):
        retval = self.r25_return()
        retval.start = self.input.LT(1)


        root_0 = None

        char_literal51 = None
        list_r = None
        expression52 = None

        r = None

        r = None
        char_literal51_tree = None
        stream_19 = RewriteRuleTokenStream(self._adaptor, "token 19")
        stream_statement = RewriteRuleSubtreeStream(self._adaptor, "rule statement")
        stream_expression = RewriteRuleSubtreeStream(self._adaptor, "rule expression")
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:123:5: (r+= statement ( ',' r+= statement )+ expression -> ^( $r expression ) )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:123:7: r+= statement ( ',' r+= statement )+ expression
                pass 
                self._state.following.append(self.FOLLOW_statement_in_r25832)
                r = self.statement()

                self._state.following.pop()
                if self._state.backtracking == 0:
                    stream_statement.add(r.tree)

                if list_r is None:
                    list_r = []
                list_r.append(r.tree)


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:123:20: ( ',' r+= statement )+
                cnt13 = 0
                while True: #loop13
                    alt13 = 2
                    LA13_0 = self.input.LA(1)

                    if (LA13_0 == 19) :
                        alt13 = 1


                    if alt13 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:123:21: ',' r+= statement
                        pass 
                        char_literal51 = self.match(self.input, 19, self.FOLLOW_19_in_r25835) 
                        if self._state.backtracking == 0:
                            stream_19.add(char_literal51)


                        self._state.following.append(self.FOLLOW_statement_in_r25839)
                        r = self.statement()

                        self._state.following.pop()
                        if self._state.backtracking == 0:
                            stream_statement.add(r.tree)

                        if list_r is None:
                            list_r = []
                        list_r.append(r.tree)



                    else:
                        if cnt13 >= 1:
                            break #loop13

                        if self._state.backtracking > 0:
                            raise BacktrackingFailed


                        eee = EarlyExitException(13, self.input)
                        raise eee

                    cnt13 += 1


                self._state.following.append(self.FOLLOW_expression_in_r25843)
                expression52 = self.expression()

                self._state.following.pop()
                if self._state.backtracking == 0:
                    stream_expression.add(expression52.tree)


                # AST Rewrite
                # elements: expression, r
                # token labels: 
                # rule labels: retval
                # token list labels: 
                # rule list labels: r
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)

                    stream_r = RewriteRuleSubtreeStream(self._adaptor, "token r", list_r)
                    root_0 = self._adaptor.nil()
                    # 123:51: -> ^( $r expression )
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:123:54: ^( $r expression )
                    root_1 = self._adaptor.nil()
                    root_1 = self._adaptor.becomeRoot(stream_r.nextNode(), root_1)

                    self._adaptor.addChild(root_1, stream_expression.nextTree())

                    self._adaptor.addChild(root_0, root_1)




                    retval.tree = root_0





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r25"


    class r26_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r26_return, self).__init__()

            self.tree = None





    # $ANTLR start "r26"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:126:1: r26 :r+= statement ( ',' r+= statement )+ -> ^( BLOCK ( $r)+ ) ;
    def r26(self, ):
        retval = self.r26_return()
        retval.start = self.input.LT(1)


        root_0 = None

        char_literal53 = None
        list_r = None
        r = None

        r = None
        char_literal53_tree = None
        stream_19 = RewriteRuleTokenStream(self._adaptor, "token 19")
        stream_statement = RewriteRuleSubtreeStream(self._adaptor, "rule statement")
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:127:5: (r+= statement ( ',' r+= statement )+ -> ^( BLOCK ( $r)+ ) )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:127:7: r+= statement ( ',' r+= statement )+
                pass 
                self._state.following.append(self.FOLLOW_statement_in_r26871)
                r = self.statement()

                self._state.following.pop()
                if self._state.backtracking == 0:
                    stream_statement.add(r.tree)

                if list_r is None:
                    list_r = []
                list_r.append(r.tree)


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:127:20: ( ',' r+= statement )+
                cnt14 = 0
                while True: #loop14
                    alt14 = 2
                    LA14_0 = self.input.LA(1)

                    if (LA14_0 == 19) :
                        alt14 = 1


                    if alt14 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:127:21: ',' r+= statement
                        pass 
                        char_literal53 = self.match(self.input, 19, self.FOLLOW_19_in_r26874) 
                        if self._state.backtracking == 0:
                            stream_19.add(char_literal53)


                        self._state.following.append(self.FOLLOW_statement_in_r26878)
                        r = self.statement()

                        self._state.following.pop()
                        if self._state.backtracking == 0:
                            stream_statement.add(r.tree)

                        if list_r is None:
                            list_r = []
                        list_r.append(r.tree)



                    else:
                        if cnt14 >= 1:
                            break #loop14

                        if self._state.backtracking > 0:
                            raise BacktrackingFailed


                        eee = EarlyExitException(14, self.input)
                        raise eee

                    cnt14 += 1


                # AST Rewrite
                # elements: r
                # token labels: 
                # rule labels: retval
                # token list labels: 
                # rule list labels: r
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)

                    stream_r = RewriteRuleSubtreeStream(self._adaptor, "token r", list_r)
                    root_0 = self._adaptor.nil()
                    # 127:40: -> ^( BLOCK ( $r)+ )
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:127:43: ^( BLOCK ( $r)+ )
                    root_1 = self._adaptor.nil()
                    root_1 = self._adaptor.becomeRoot(
                    self._adaptor.createFromType(BLOCK, "BLOCK")
                    , root_1)

                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:127:52: ( $r)+
                    if not (stream_r.hasNext()):
                        raise RewriteEarlyExitException()

                    while stream_r.hasNext():
                        self._adaptor.addChild(root_1, stream_r.nextTree())


                    stream_r.reset()

                    self._adaptor.addChild(root_0, root_1)




                    retval.tree = root_0





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r26"


    class r27_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r27_return, self).__init__()

            self.tree = None





    # $ANTLR start "r27"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:130:1: r27 : r= statement expression -> ^( $r ^( $r expression ) ) ;
    def r27(self, ):
        retval = self.r27_return()
        retval.start = self.input.LT(1)


        root_0 = None

        r = None

        expression54 = None


        stream_statement = RewriteRuleSubtreeStream(self._adaptor, "rule statement")
        stream_expression = RewriteRuleSubtreeStream(self._adaptor, "rule expression")
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:131:5: (r= statement expression -> ^( $r ^( $r expression ) ) )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:131:7: r= statement expression
                pass 
                self._state.following.append(self.FOLLOW_statement_in_r27909)
                r = self.statement()

                self._state.following.pop()
                if self._state.backtracking == 0:
                    stream_statement.add(r.tree)


                self._state.following.append(self.FOLLOW_expression_in_r27911)
                expression54 = self.expression()

                self._state.following.pop()
                if self._state.backtracking == 0:
                    stream_expression.add(expression54.tree)


                # AST Rewrite
                # elements: expression, r, r
                # token labels: 
                # rule labels: retval, r
                # token list labels: 
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)

                    if r is not None:
                        stream_r = RewriteRuleSubtreeStream(self._adaptor, "rule r", r.tree)
                    else:
                        stream_r = RewriteRuleSubtreeStream(self._adaptor, "token r", None)


                    root_0 = self._adaptor.nil()
                    # 131:30: -> ^( $r ^( $r expression ) )
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:131:33: ^( $r ^( $r expression ) )
                    root_1 = self._adaptor.nil()
                    root_1 = self._adaptor.becomeRoot(stream_r.nextNode(), root_1)

                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:131:38: ^( $r expression )
                    root_2 = self._adaptor.nil()
                    root_2 = self._adaptor.becomeRoot(stream_r.nextNode(), root_2)

                    self._adaptor.addChild(root_2, stream_expression.nextTree())

                    self._adaptor.addChild(root_1, root_2)

                    self._adaptor.addChild(root_0, root_1)




                    retval.tree = root_0





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r27"


    class r28_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r28_return, self).__init__()

            self.tree = None





    # $ANTLR start "r28"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:134:1: r28 : ( 'foo28a' | 'foo28b' ) ->;
    def r28(self, ):
        retval = self.r28_return()
        retval.start = self.input.LT(1)


        root_0 = None

        string_literal55 = None
        string_literal56 = None

        string_literal55_tree = None
        string_literal56_tree = None
        stream_32 = RewriteRuleTokenStream(self._adaptor, "token 32")
        stream_31 = RewriteRuleTokenStream(self._adaptor, "token 31")

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:135:5: ( ( 'foo28a' | 'foo28b' ) ->)
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:135:7: ( 'foo28a' | 'foo28b' )
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:135:7: ( 'foo28a' | 'foo28b' )
                alt15 = 2
                LA15_0 = self.input.LA(1)

                if (LA15_0 == 31) :
                    alt15 = 1
                elif (LA15_0 == 32) :
                    alt15 = 2
                else:
                    if self._state.backtracking > 0:
                        raise BacktrackingFailed


                    nvae = NoViableAltException("", 15, 0, self.input)

                    raise nvae


                if alt15 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:135:8: 'foo28a'
                    pass 
                    string_literal55 = self.match(self.input, 31, self.FOLLOW_31_in_r28943) 
                    if self._state.backtracking == 0:
                        stream_31.add(string_literal55)



                elif alt15 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:135:17: 'foo28b'
                    pass 
                    string_literal56 = self.match(self.input, 32, self.FOLLOW_32_in_r28945) 
                    if self._state.backtracking == 0:
                        stream_32.add(string_literal56)





                # AST Rewrite
                # elements: 
                # token labels: 
                # rule labels: retval
                # token list labels: 
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                    root_0 = self._adaptor.nil()
                    # 135:27: ->
                    root_0 = None



                    retval.tree = root_0





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r28"


    class r29_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r29_return, self).__init__()

            self.tree = None





    # $ANTLR start "r29"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:138:1: r29 : (r+= statement )* -> ^( BLOCK ( $r)+ ) ;
    def r29(self, ):
        retval = self.r29_return()
        retval.start = self.input.LT(1)


        root_0 = None

        list_r = None
        r = None

        r = None
        stream_statement = RewriteRuleSubtreeStream(self._adaptor, "rule statement")
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:139:5: ( (r+= statement )* -> ^( BLOCK ( $r)+ ) )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:139:7: (r+= statement )*
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:139:7: (r+= statement )*
                while True: #loop16
                    alt16 = 2
                    LA16_0 = self.input.LA(1)

                    if ((33 <= LA16_0 <= 34)) :
                        alt16 = 1


                    if alt16 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:139:8: r+= statement
                        pass 
                        self._state.following.append(self.FOLLOW_statement_in_r29968)
                        r = self.statement()

                        self._state.following.pop()
                        if self._state.backtracking == 0:
                            stream_statement.add(r.tree)

                        if list_r is None:
                            list_r = []
                        list_r.append(r.tree)



                    else:
                        break #loop16


                # AST Rewrite
                # elements: r
                # token labels: 
                # rule labels: retval
                # token list labels: 
                # rule list labels: r
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)

                    stream_r = RewriteRuleSubtreeStream(self._adaptor, "token r", list_r)
                    root_0 = self._adaptor.nil()
                    # 139:23: -> ^( BLOCK ( $r)+ )
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:139:26: ^( BLOCK ( $r)+ )
                    root_1 = self._adaptor.nil()
                    root_1 = self._adaptor.becomeRoot(
                    self._adaptor.createFromType(BLOCK, "BLOCK")
                    , root_1)

                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:139:35: ( $r)+
                    if not (stream_r.hasNext()):
                        raise RewriteEarlyExitException()

                    while stream_r.hasNext():
                        self._adaptor.addChild(root_1, stream_r.nextTree())


                    stream_r.reset()

                    self._adaptor.addChild(root_0, root_1)




                    retval.tree = root_0





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r29"


    class r30_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r30_return, self).__init__()

            self.tree = None





    # $ANTLR start "r30"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:142:1: r30 : ( statement )* -> ^( BLOCK ( statement )? ) ;
    def r30(self, ):
        retval = self.r30_return()
        retval.start = self.input.LT(1)


        root_0 = None

        statement57 = None


        stream_statement = RewriteRuleSubtreeStream(self._adaptor, "rule statement")
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:143:5: ( ( statement )* -> ^( BLOCK ( statement )? ) )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:143:7: ( statement )*
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:143:7: ( statement )*
                while True: #loop17
                    alt17 = 2
                    LA17_0 = self.input.LA(1)

                    if ((33 <= LA17_0 <= 34)) :
                        alt17 = 1


                    if alt17 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:143:7: statement
                        pass 
                        self._state.following.append(self.FOLLOW_statement_in_r30997)
                        statement57 = self.statement()

                        self._state.following.pop()
                        if self._state.backtracking == 0:
                            stream_statement.add(statement57.tree)



                    else:
                        break #loop17


                # AST Rewrite
                # elements: statement
                # token labels: 
                # rule labels: retval
                # token list labels: 
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                    root_0 = self._adaptor.nil()
                    # 143:18: -> ^( BLOCK ( statement )? )
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:143:21: ^( BLOCK ( statement )? )
                    root_1 = self._adaptor.nil()
                    root_1 = self._adaptor.becomeRoot(
                    self._adaptor.createFromType(BLOCK, "BLOCK")
                    , root_1)

                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:143:29: ( statement )?
                    if stream_statement.hasNext():
                        self._adaptor.addChild(root_1, stream_statement.nextTree())


                    stream_statement.reset();

                    self._adaptor.addChild(root_0, root_1)




                    retval.tree = root_0





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r30"


    class r31_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r31_return, self).__init__()

            self.tree = None





    # $ANTLR start "r31"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:146:1: r31 : modifier type ID ( '=' expression )? ';' -> {self.flag == 0}? ^( VARDEF ID ( modifier )* type ( expression )? ) -> {self.flag == 1}? ^( VARIABLE ID ( modifier )* type ( expression )? ) -> ^( FIELD ID ( modifier )* type ( expression )? ) ;
    def r31(self, ):
        retval = self.r31_return()
        retval.start = self.input.LT(1)


        root_0 = None

        ID60 = None
        char_literal61 = None
        char_literal63 = None
        modifier58 = None

        type59 = None

        expression62 = None


        ID60_tree = None
        char_literal61_tree = None
        char_literal63_tree = None
        stream_ID = RewriteRuleTokenStream(self._adaptor, "token ID")
        stream_22 = RewriteRuleTokenStream(self._adaptor, "token 22")
        stream_23 = RewriteRuleTokenStream(self._adaptor, "token 23")
        stream_modifier = RewriteRuleSubtreeStream(self._adaptor, "rule modifier")
        stream_expression = RewriteRuleSubtreeStream(self._adaptor, "rule expression")
        stream_type = RewriteRuleSubtreeStream(self._adaptor, "rule type")
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:147:5: ( modifier type ID ( '=' expression )? ';' -> {self.flag == 0}? ^( VARDEF ID ( modifier )* type ( expression )? ) -> {self.flag == 1}? ^( VARIABLE ID ( modifier )* type ( expression )? ) -> ^( FIELD ID ( modifier )* type ( expression )? ) )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:147:7: modifier type ID ( '=' expression )? ';'
                pass 
                self._state.following.append(self.FOLLOW_modifier_in_r311024)
                modifier58 = self.modifier()

                self._state.following.pop()
                if self._state.backtracking == 0:
                    stream_modifier.add(modifier58.tree)


                self._state.following.append(self.FOLLOW_type_in_r311026)
                type59 = self.type()

                self._state.following.pop()
                if self._state.backtracking == 0:
                    stream_type.add(type59.tree)


                ID60 = self.match(self.input, ID, self.FOLLOW_ID_in_r311028) 
                if self._state.backtracking == 0:
                    stream_ID.add(ID60)


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:147:24: ( '=' expression )?
                alt18 = 2
                LA18_0 = self.input.LA(1)

                if (LA18_0 == 23) :
                    alt18 = 1
                if alt18 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:147:25: '=' expression
                    pass 
                    char_literal61 = self.match(self.input, 23, self.FOLLOW_23_in_r311031) 
                    if self._state.backtracking == 0:
                        stream_23.add(char_literal61)


                    self._state.following.append(self.FOLLOW_expression_in_r311033)
                    expression62 = self.expression()

                    self._state.following.pop()
                    if self._state.backtracking == 0:
                        stream_expression.add(expression62.tree)





                char_literal63 = self.match(self.input, 22, self.FOLLOW_22_in_r311037) 
                if self._state.backtracking == 0:
                    stream_22.add(char_literal63)


                # AST Rewrite
                # elements: ID, type, modifier, ID, expression, expression, ID, expression, type, modifier, modifier, type
                # token labels: 
                # rule labels: retval
                # token list labels: 
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                    root_0 = self._adaptor.nil()
                    if self.flag == 0:
                        # 148:9: -> {self.flag == 0}? ^( VARDEF ID ( modifier )* type ( expression )? )
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:148:30: ^( VARDEF ID ( modifier )* type ( expression )? )
                        root_1 = self._adaptor.nil()
                        root_1 = self._adaptor.becomeRoot(
                        self._adaptor.createFromType(VARDEF, "VARDEF")
                        , root_1)

                        self._adaptor.addChild(root_1, 
                        stream_ID.nextNode()
                        )

                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:148:42: ( modifier )*
                        while stream_modifier.hasNext():
                            self._adaptor.addChild(root_1, stream_modifier.nextTree())


                        stream_modifier.reset();

                        self._adaptor.addChild(root_1, stream_type.nextTree())

                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:148:57: ( expression )?
                        if stream_expression.hasNext():
                            self._adaptor.addChild(root_1, stream_expression.nextTree())


                        stream_expression.reset();

                        self._adaptor.addChild(root_0, root_1)



                    elif self.flag == 1:
                        # 149:9: -> {self.flag == 1}? ^( VARIABLE ID ( modifier )* type ( expression )? )
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:149:30: ^( VARIABLE ID ( modifier )* type ( expression )? )
                        root_1 = self._adaptor.nil()
                        root_1 = self._adaptor.becomeRoot(
                        self._adaptor.createFromType(VARIABLE, "VARIABLE")
                        , root_1)

                        self._adaptor.addChild(root_1, 
                        stream_ID.nextNode()
                        )

                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:149:44: ( modifier )*
                        while stream_modifier.hasNext():
                            self._adaptor.addChild(root_1, stream_modifier.nextTree())


                        stream_modifier.reset();

                        self._adaptor.addChild(root_1, stream_type.nextTree())

                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:149:59: ( expression )?
                        if stream_expression.hasNext():
                            self._adaptor.addChild(root_1, stream_expression.nextTree())


                        stream_expression.reset();

                        self._adaptor.addChild(root_0, root_1)



                    else: 
                        # 150:9: -> ^( FIELD ID ( modifier )* type ( expression )? )
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:150:30: ^( FIELD ID ( modifier )* type ( expression )? )
                        root_1 = self._adaptor.nil()
                        root_1 = self._adaptor.becomeRoot(
                        self._adaptor.createFromType(FIELD, "FIELD")
                        , root_1)

                        self._adaptor.addChild(root_1, 
                        stream_ID.nextNode()
                        )

                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:150:41: ( modifier )*
                        while stream_modifier.hasNext():
                            self._adaptor.addChild(root_1, stream_modifier.nextTree())


                        stream_modifier.reset();

                        self._adaptor.addChild(root_1, stream_type.nextTree())

                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:150:56: ( expression )?
                        if stream_expression.hasNext():
                            self._adaptor.addChild(root_1, stream_expression.nextTree())


                        stream_expression.reset();

                        self._adaptor.addChild(root_0, root_1)



                    retval.tree = root_0





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r31"


    class r32_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r32_return, self).__init__()

            self.tree = None





    # $ANTLR start "r32"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:153:1: r32[which] : ID INT -> {which==1}? ID -> {which==2}? INT ->;
    def r32(self, which):
        retval = self.r32_return()
        retval.start = self.input.LT(1)


        root_0 = None

        ID64 = None
        INT65 = None

        ID64_tree = None
        INT65_tree = None
        stream_INT = RewriteRuleTokenStream(self._adaptor, "token INT")
        stream_ID = RewriteRuleTokenStream(self._adaptor, "token ID")

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:154:3: ( ID INT -> {which==1}? ID -> {which==2}? INT ->)
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:154:5: ID INT
                pass 
                ID64 = self.match(self.input, ID, self.FOLLOW_ID_in_r321147) 
                if self._state.backtracking == 0:
                    stream_ID.add(ID64)


                INT65 = self.match(self.input, INT, self.FOLLOW_INT_in_r321149) 
                if self._state.backtracking == 0:
                    stream_INT.add(INT65)


                # AST Rewrite
                # elements: ID, INT
                # token labels: 
                # rule labels: retval
                # token list labels: 
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                    root_0 = self._adaptor.nil()
                    if which==1:
                        # 154:12: -> {which==1}? ID
                        self._adaptor.addChild(root_0, 
                        stream_ID.nextNode()
                        )



                    elif which==2:
                        # 155:12: -> {which==2}? INT
                        self._adaptor.addChild(root_0, 
                        stream_INT.nextNode()
                        )



                    else: 
                        # 156:12: ->
                        root_0 = None


                    retval.tree = root_0





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r32"


    class r33_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r33_return, self).__init__()

            self.tree = None





    # $ANTLR start "r33"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:159:1: r33 : modifiers ! statement ;
    def r33(self, ):
        retval = self.r33_return()
        retval.start = self.input.LT(1)


        root_0 = None

        modifiers66 = None

        statement67 = None



        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:160:5: ( modifiers ! statement )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:160:9: modifiers ! statement
                pass 
                root_0 = self._adaptor.nil()


                self._state.following.append(self.FOLLOW_modifiers_in_r331203)
                modifiers66 = self.modifiers()

                self._state.following.pop()

                self._state.following.append(self.FOLLOW_statement_in_r331206)
                statement67 = self.statement()

                self._state.following.pop()
                if self._state.backtracking == 0:
                    self._adaptor.addChild(root_0, statement67.tree)




                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r33"


    class r34_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r34_return, self).__init__()

            self.tree = None





    # $ANTLR start "r34"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:163:1: r34 : modifiers ! r34a[$modifiers.tree] ;
    def r34(self, ):
        retval = self.r34_return()
        retval.start = self.input.LT(1)


        root_0 = None

        modifiers68 = None

        r34a69 = None



        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:164:5: ( modifiers ! r34a[$modifiers.tree] )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:164:9: modifiers ! r34a[$modifiers.tree]
                pass 
                root_0 = self._adaptor.nil()


                self._state.following.append(self.FOLLOW_modifiers_in_r341225)
                modifiers68 = self.modifiers()

                self._state.following.pop()

                self._state.following.append(self.FOLLOW_r34a_in_r341228)
                r34a69 = self.r34a(modifiers68.tree)

                self._state.following.pop()
                if self._state.backtracking == 0:
                    self._adaptor.addChild(root_0, r34a69.tree)




                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r34"


    class r34a_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r34a_return, self).__init__()

            self.tree = None





    # $ANTLR start "r34a"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:168:1: r34a[mod] : 'class' ID ( 'extends' sup= type )? ( 'implements' i+= type ( ',' i+= type )* )? '{' ( statement )* '}' -> ^( 'class' ID ( ^( 'extends' $sup) )? ( ^( 'implements' ( $i)+ ) )? ( statement )* ) ;
    def r34a(self, mod):
        retval = self.r34a_return()
        retval.start = self.input.LT(1)


        root_0 = None

        string_literal70 = None
        ID71 = None
        string_literal72 = None
        string_literal73 = None
        char_literal74 = None
        char_literal75 = None
        char_literal77 = None
        list_i = None
        sup = None

        statement76 = None

        i = None

        i = None
        string_literal70_tree = None
        ID71_tree = None
        string_literal72_tree = None
        string_literal73_tree = None
        char_literal74_tree = None
        char_literal75_tree = None
        char_literal77_tree = None
        stream_30 = RewriteRuleTokenStream(self._adaptor, "token 30")
        stream_45 = RewriteRuleTokenStream(self._adaptor, "token 45")
        stream_44 = RewriteRuleTokenStream(self._adaptor, "token 44")
        stream_19 = RewriteRuleTokenStream(self._adaptor, "token 19")
        stream_ID = RewriteRuleTokenStream(self._adaptor, "token ID")
        stream_37 = RewriteRuleTokenStream(self._adaptor, "token 37")
        stream_28 = RewriteRuleTokenStream(self._adaptor, "token 28")
        stream_statement = RewriteRuleSubtreeStream(self._adaptor, "rule statement")
        stream_type = RewriteRuleSubtreeStream(self._adaptor, "rule type")
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:169:5: ( 'class' ID ( 'extends' sup= type )? ( 'implements' i+= type ( ',' i+= type )* )? '{' ( statement )* '}' -> ^( 'class' ID ( ^( 'extends' $sup) )? ( ^( 'implements' ( $i)+ ) )? ( statement )* ) )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:169:9: 'class' ID ( 'extends' sup= type )? ( 'implements' i+= type ( ',' i+= type )* )? '{' ( statement )* '}'
                pass 
                string_literal70 = self.match(self.input, 28, self.FOLLOW_28_in_r34a1254) 
                if self._state.backtracking == 0:
                    stream_28.add(string_literal70)


                ID71 = self.match(self.input, ID, self.FOLLOW_ID_in_r34a1256) 
                if self._state.backtracking == 0:
                    stream_ID.add(ID71)


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:169:20: ( 'extends' sup= type )?
                alt19 = 2
                LA19_0 = self.input.LA(1)

                if (LA19_0 == 30) :
                    alt19 = 1
                if alt19 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:169:21: 'extends' sup= type
                    pass 
                    string_literal72 = self.match(self.input, 30, self.FOLLOW_30_in_r34a1259) 
                    if self._state.backtracking == 0:
                        stream_30.add(string_literal72)


                    self._state.following.append(self.FOLLOW_type_in_r34a1263)
                    sup = self.type()

                    self._state.following.pop()
                    if self._state.backtracking == 0:
                        stream_type.add(sup.tree)





                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:170:9: ( 'implements' i+= type ( ',' i+= type )* )?
                alt21 = 2
                LA21_0 = self.input.LA(1)

                if (LA21_0 == 37) :
                    alt21 = 1
                if alt21 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:170:11: 'implements' i+= type ( ',' i+= type )*
                    pass 
                    string_literal73 = self.match(self.input, 37, self.FOLLOW_37_in_r34a1277) 
                    if self._state.backtracking == 0:
                        stream_37.add(string_literal73)


                    self._state.following.append(self.FOLLOW_type_in_r34a1281)
                    i = self.type()

                    self._state.following.pop()
                    if self._state.backtracking == 0:
                        stream_type.add(i.tree)

                    if list_i is None:
                        list_i = []
                    list_i.append(i.tree)


                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:170:32: ( ',' i+= type )*
                    while True: #loop20
                        alt20 = 2
                        LA20_0 = self.input.LA(1)

                        if (LA20_0 == 19) :
                            alt20 = 1


                        if alt20 == 1:
                            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:170:33: ',' i+= type
                            pass 
                            char_literal74 = self.match(self.input, 19, self.FOLLOW_19_in_r34a1284) 
                            if self._state.backtracking == 0:
                                stream_19.add(char_literal74)


                            self._state.following.append(self.FOLLOW_type_in_r34a1288)
                            i = self.type()

                            self._state.following.pop()
                            if self._state.backtracking == 0:
                                stream_type.add(i.tree)

                            if list_i is None:
                                list_i = []
                            list_i.append(i.tree)



                        else:
                            break #loop20





                char_literal75 = self.match(self.input, 44, self.FOLLOW_44_in_r34a1302) 
                if self._state.backtracking == 0:
                    stream_44.add(char_literal75)


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:171:13: ( statement )*
                while True: #loop22
                    alt22 = 2
                    LA22_0 = self.input.LA(1)

                    if ((33 <= LA22_0 <= 34)) :
                        alt22 = 1


                    if alt22 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:171:13: statement
                        pass 
                        self._state.following.append(self.FOLLOW_statement_in_r34a1304)
                        statement76 = self.statement()

                        self._state.following.pop()
                        if self._state.backtracking == 0:
                            stream_statement.add(statement76.tree)



                    else:
                        break #loop22


                char_literal77 = self.match(self.input, 45, self.FOLLOW_45_in_r34a1307) 
                if self._state.backtracking == 0:
                    stream_45.add(char_literal77)


                # AST Rewrite
                # elements: 30, i, sup, 37, ID, statement, 28
                # token labels: 
                # rule labels: retval, sup
                # token list labels: 
                # rule list labels: i
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)

                    if sup is not None:
                        stream_sup = RewriteRuleSubtreeStream(self._adaptor, "rule sup", sup.tree)
                    else:
                        stream_sup = RewriteRuleSubtreeStream(self._adaptor, "token sup", None)

                    stream_i = RewriteRuleSubtreeStream(self._adaptor, "token i", list_i)
                    root_0 = self._adaptor.nil()
                    # 172:9: -> ^( 'class' ID ( ^( 'extends' $sup) )? ( ^( 'implements' ( $i)+ ) )? ( statement )* )
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:172:12: ^( 'class' ID ( ^( 'extends' $sup) )? ( ^( 'implements' ( $i)+ ) )? ( statement )* )
                    root_1 = self._adaptor.nil()
                    root_1 = self._adaptor.becomeRoot(
                    stream_28.nextNode()
                    , root_1)

                    self._adaptor.addChild(root_1, 
                    stream_ID.nextNode()
                    )

                    self._adaptor.addChild(root_1, mod)

                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:172:32: ( ^( 'extends' $sup) )?
                    if stream_30.hasNext() or stream_sup.hasNext():
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:172:32: ^( 'extends' $sup)
                        root_2 = self._adaptor.nil()
                        root_2 = self._adaptor.becomeRoot(
                        stream_30.nextNode()
                        , root_2)

                        self._adaptor.addChild(root_2, stream_sup.nextTree())

                        self._adaptor.addChild(root_1, root_2)


                    stream_30.reset();
                    stream_sup.reset();

                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:172:51: ( ^( 'implements' ( $i)+ ) )?
                    if stream_i.hasNext() or stream_37.hasNext():
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:172:51: ^( 'implements' ( $i)+ )
                        root_2 = self._adaptor.nil()
                        root_2 = self._adaptor.becomeRoot(
                        stream_37.nextNode()
                        , root_2)

                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:172:67: ( $i)+
                        if not (stream_i.hasNext()):
                            raise RewriteEarlyExitException()

                        while stream_i.hasNext():
                            self._adaptor.addChild(root_2, stream_i.nextTree())


                        stream_i.reset()

                        self._adaptor.addChild(root_1, root_2)


                    stream_i.reset();
                    stream_37.reset();

                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:172:72: ( statement )*
                    while stream_statement.hasNext():
                        self._adaptor.addChild(root_1, stream_statement.nextTree())


                    stream_statement.reset();

                    self._adaptor.addChild(root_0, root_1)




                    retval.tree = root_0





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r34a"


    class r35_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r35_return, self).__init__()

            self.tree = None





    # $ANTLR start "r35"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:175:1: r35 : '{' 'extends' (sup= type )? '}' -> ( ^( 'extends' $sup) )? ;
    def r35(self, ):
        retval = self.r35_return()
        retval.start = self.input.LT(1)


        root_0 = None

        char_literal78 = None
        string_literal79 = None
        char_literal80 = None
        sup = None


        char_literal78_tree = None
        string_literal79_tree = None
        char_literal80_tree = None
        stream_30 = RewriteRuleTokenStream(self._adaptor, "token 30")
        stream_45 = RewriteRuleTokenStream(self._adaptor, "token 45")
        stream_44 = RewriteRuleTokenStream(self._adaptor, "token 44")
        stream_type = RewriteRuleSubtreeStream(self._adaptor, "rule type")
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:176:5: ( '{' 'extends' (sup= type )? '}' -> ( ^( 'extends' $sup) )? )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:176:7: '{' 'extends' (sup= type )? '}'
                pass 
                char_literal78 = self.match(self.input, 44, self.FOLLOW_44_in_r351363) 
                if self._state.backtracking == 0:
                    stream_44.add(char_literal78)


                string_literal79 = self.match(self.input, 30, self.FOLLOW_30_in_r351365) 
                if self._state.backtracking == 0:
                    stream_30.add(string_literal79)


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:176:21: (sup= type )?
                alt23 = 2
                LA23_0 = self.input.LA(1)

                if (LA23_0 == 27 or LA23_0 == 38) :
                    alt23 = 1
                if alt23 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:176:22: sup= type
                    pass 
                    self._state.following.append(self.FOLLOW_type_in_r351370)
                    sup = self.type()

                    self._state.following.pop()
                    if self._state.backtracking == 0:
                        stream_type.add(sup.tree)





                char_literal80 = self.match(self.input, 45, self.FOLLOW_45_in_r351374) 
                if self._state.backtracking == 0:
                    stream_45.add(char_literal80)


                # AST Rewrite
                # elements: 30, sup
                # token labels: 
                # rule labels: retval, sup
                # token list labels: 
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)

                    if sup is not None:
                        stream_sup = RewriteRuleSubtreeStream(self._adaptor, "rule sup", sup.tree)
                    else:
                        stream_sup = RewriteRuleSubtreeStream(self._adaptor, "token sup", None)


                    root_0 = self._adaptor.nil()
                    # 177:9: -> ( ^( 'extends' $sup) )?
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:177:13: ( ^( 'extends' $sup) )?
                    if stream_30.hasNext() or stream_sup.hasNext():
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:177:13: ^( 'extends' $sup)
                        root_1 = self._adaptor.nil()
                        root_1 = self._adaptor.becomeRoot(
                        stream_30.nextNode()
                        , root_1)

                        self._adaptor.addChild(root_1, stream_sup.nextTree())

                        self._adaptor.addChild(root_0, root_1)


                    stream_30.reset();
                    stream_sup.reset();




                    retval.tree = root_0





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r35"


    class r36_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r36_return, self).__init__()

            self.tree = None





    # $ANTLR start "r36"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:180:1: r36 : 'if' '(' expression ')' s1= statement ( 'else' s2= statement -> ^( 'if' ^( EXPR expression ) $s1 $s2) | -> ^( 'if' ^( EXPR expression ) $s1) ) ;
    def r36(self, ):
        retval = self.r36_return()
        retval.start = self.input.LT(1)


        root_0 = None

        string_literal81 = None
        char_literal82 = None
        char_literal84 = None
        string_literal85 = None
        s1 = None

        s2 = None

        expression83 = None


        string_literal81_tree = None
        char_literal82_tree = None
        char_literal84_tree = None
        string_literal85_tree = None
        stream_17 = RewriteRuleTokenStream(self._adaptor, "token 17")
        stream_36 = RewriteRuleTokenStream(self._adaptor, "token 36")
        stream_16 = RewriteRuleTokenStream(self._adaptor, "token 16")
        stream_29 = RewriteRuleTokenStream(self._adaptor, "token 29")
        stream_expression = RewriteRuleSubtreeStream(self._adaptor, "rule expression")
        stream_statement = RewriteRuleSubtreeStream(self._adaptor, "rule statement")
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:181:5: ( 'if' '(' expression ')' s1= statement ( 'else' s2= statement -> ^( 'if' ^( EXPR expression ) $s1 $s2) | -> ^( 'if' ^( EXPR expression ) $s1) ) )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:181:7: 'if' '(' expression ')' s1= statement ( 'else' s2= statement -> ^( 'if' ^( EXPR expression ) $s1 $s2) | -> ^( 'if' ^( EXPR expression ) $s1) )
                pass 
                string_literal81 = self.match(self.input, 36, self.FOLLOW_36_in_r361410) 
                if self._state.backtracking == 0:
                    stream_36.add(string_literal81)


                char_literal82 = self.match(self.input, 16, self.FOLLOW_16_in_r361412) 
                if self._state.backtracking == 0:
                    stream_16.add(char_literal82)


                self._state.following.append(self.FOLLOW_expression_in_r361414)
                expression83 = self.expression()

                self._state.following.pop()
                if self._state.backtracking == 0:
                    stream_expression.add(expression83.tree)


                char_literal84 = self.match(self.input, 17, self.FOLLOW_17_in_r361416) 
                if self._state.backtracking == 0:
                    stream_17.add(char_literal84)


                self._state.following.append(self.FOLLOW_statement_in_r361420)
                s1 = self.statement()

                self._state.following.pop()
                if self._state.backtracking == 0:
                    stream_statement.add(s1.tree)


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:182:9: ( 'else' s2= statement -> ^( 'if' ^( EXPR expression ) $s1 $s2) | -> ^( 'if' ^( EXPR expression ) $s1) )
                alt24 = 2
                LA24_0 = self.input.LA(1)

                if (LA24_0 == 29) :
                    alt24 = 1
                elif (LA24_0 == EOF) :
                    alt24 = 2
                else:
                    if self._state.backtracking > 0:
                        raise BacktrackingFailed


                    nvae = NoViableAltException("", 24, 0, self.input)

                    raise nvae


                if alt24 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:182:11: 'else' s2= statement
                    pass 
                    string_literal85 = self.match(self.input, 29, self.FOLLOW_29_in_r361432) 
                    if self._state.backtracking == 0:
                        stream_29.add(string_literal85)


                    self._state.following.append(self.FOLLOW_statement_in_r361436)
                    s2 = self.statement()

                    self._state.following.pop()
                    if self._state.backtracking == 0:
                        stream_statement.add(s2.tree)


                    # AST Rewrite
                    # elements: s1, expression, 36, s2
                    # token labels: 
                    # rule labels: retval, s2, s1
                    # token list labels: 
                    # rule list labels: 
                    # wildcard labels: 
                    if self._state.backtracking == 0:
                        retval.tree = root_0
                        if retval is not None:
                            stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                        else:
                            stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)

                        if s2 is not None:
                            stream_s2 = RewriteRuleSubtreeStream(self._adaptor, "rule s2", s2.tree)
                        else:
                            stream_s2 = RewriteRuleSubtreeStream(self._adaptor, "token s2", None)

                        if s1 is not None:
                            stream_s1 = RewriteRuleSubtreeStream(self._adaptor, "rule s1", s1.tree)
                        else:
                            stream_s1 = RewriteRuleSubtreeStream(self._adaptor, "token s1", None)


                        root_0 = self._adaptor.nil()
                        # 182:31: -> ^( 'if' ^( EXPR expression ) $s1 $s2)
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:182:34: ^( 'if' ^( EXPR expression ) $s1 $s2)
                        root_1 = self._adaptor.nil()
                        root_1 = self._adaptor.becomeRoot(
                        stream_36.nextNode()
                        , root_1)

                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:182:41: ^( EXPR expression )
                        root_2 = self._adaptor.nil()
                        root_2 = self._adaptor.becomeRoot(
                        self._adaptor.createFromType(EXPR, "EXPR")
                        , root_2)

                        self._adaptor.addChild(root_2, stream_expression.nextTree())

                        self._adaptor.addChild(root_1, root_2)

                        self._adaptor.addChild(root_1, stream_s1.nextTree())

                        self._adaptor.addChild(root_1, stream_s2.nextTree())

                        self._adaptor.addChild(root_0, root_1)




                        retval.tree = root_0




                elif alt24 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:183:31: 
                    pass 
                    # AST Rewrite
                    # elements: s1, 36, expression
                    # token labels: 
                    # rule labels: retval, s1
                    # token list labels: 
                    # rule list labels: 
                    # wildcard labels: 
                    if self._state.backtracking == 0:
                        retval.tree = root_0
                        if retval is not None:
                            stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                        else:
                            stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)

                        if s1 is not None:
                            stream_s1 = RewriteRuleSubtreeStream(self._adaptor, "rule s1", s1.tree)
                        else:
                            stream_s1 = RewriteRuleSubtreeStream(self._adaptor, "token s1", None)


                        root_0 = self._adaptor.nil()
                        # 183:31: -> ^( 'if' ^( EXPR expression ) $s1)
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:183:34: ^( 'if' ^( EXPR expression ) $s1)
                        root_1 = self._adaptor.nil()
                        root_1 = self._adaptor.becomeRoot(
                        stream_36.nextNode()
                        , root_1)

                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:183:41: ^( EXPR expression )
                        root_2 = self._adaptor.nil()
                        root_2 = self._adaptor.becomeRoot(
                        self._adaptor.createFromType(EXPR, "EXPR")
                        , root_2)

                        self._adaptor.addChild(root_2, stream_expression.nextTree())

                        self._adaptor.addChild(root_1, root_2)

                        self._adaptor.addChild(root_1, stream_s1.nextTree())

                        self._adaptor.addChild(root_0, root_1)




                        retval.tree = root_0








                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r36"


    class r37_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r37_return, self).__init__()

            self.tree = None





    # $ANTLR start "r37"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:187:1: r37 : ( INT -> INT ) ( '+' i= INT -> ^( '+' $r37 $i) )* ;
    def r37(self, ):
        retval = self.r37_return()
        retval.start = self.input.LT(1)


        root_0 = None

        i = None
        INT86 = None
        char_literal87 = None

        i_tree = None
        INT86_tree = None
        char_literal87_tree = None
        stream_INT = RewriteRuleTokenStream(self._adaptor, "token INT")
        stream_18 = RewriteRuleTokenStream(self._adaptor, "token 18")

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:188:5: ( ( INT -> INT ) ( '+' i= INT -> ^( '+' $r37 $i) )* )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:188:7: ( INT -> INT ) ( '+' i= INT -> ^( '+' $r37 $i) )*
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:188:7: ( INT -> INT )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:188:8: INT
                pass 
                INT86 = self.match(self.input, INT, self.FOLLOW_INT_in_r371527) 
                if self._state.backtracking == 0:
                    stream_INT.add(INT86)


                # AST Rewrite
                # elements: INT
                # token labels: 
                # rule labels: retval
                # token list labels: 
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                    root_0 = self._adaptor.nil()
                    # 188:12: -> INT
                    self._adaptor.addChild(root_0, 
                    stream_INT.nextNode()
                    )




                    retval.tree = root_0






                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:188:20: ( '+' i= INT -> ^( '+' $r37 $i) )*
                while True: #loop25
                    alt25 = 2
                    LA25_0 = self.input.LA(1)

                    if (LA25_0 == 18) :
                        alt25 = 1


                    if alt25 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:188:21: '+' i= INT
                        pass 
                        char_literal87 = self.match(self.input, 18, self.FOLLOW_18_in_r371535) 
                        if self._state.backtracking == 0:
                            stream_18.add(char_literal87)


                        i = self.match(self.input, INT, self.FOLLOW_INT_in_r371539) 
                        if self._state.backtracking == 0:
                            stream_INT.add(i)


                        # AST Rewrite
                        # elements: 18, r37, i
                        # token labels: i
                        # rule labels: retval
                        # token list labels: 
                        # rule list labels: 
                        # wildcard labels: 
                        if self._state.backtracking == 0:
                            retval.tree = root_0
                            stream_i = RewriteRuleTokenStream(self._adaptor, "token i", i)
                            if retval is not None:
                                stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                            else:
                                stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                            root_0 = self._adaptor.nil()
                            # 188:31: -> ^( '+' $r37 $i)
                            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:188:34: ^( '+' $r37 $i)
                            root_1 = self._adaptor.nil()
                            root_1 = self._adaptor.becomeRoot(
                            stream_18.nextNode()
                            , root_1)

                            self._adaptor.addChild(root_1, stream_retval.nextTree())

                            self._adaptor.addChild(root_1, stream_i.nextNode())

                            self._adaptor.addChild(root_0, root_1)




                            retval.tree = root_0




                    else:
                        break #loop25




                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r37"


    class r38_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r38_return, self).__init__()

            self.tree = None





    # $ANTLR start "r38"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:191:1: r38 : INT ( '+' ^ INT )* ;
    def r38(self, ):
        retval = self.r38_return()
        retval.start = self.input.LT(1)


        root_0 = None

        INT88 = None
        char_literal89 = None
        INT90 = None

        INT88_tree = None
        char_literal89_tree = None
        INT90_tree = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:192:5: ( INT ( '+' ^ INT )* )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:192:7: INT ( '+' ^ INT )*
                pass 
                root_0 = self._adaptor.nil()


                INT88 = self.match(self.input, INT, self.FOLLOW_INT_in_r381572)
                if self._state.backtracking == 0:
                    INT88_tree = self._adaptor.createWithPayload(INT88)
                    self._adaptor.addChild(root_0, INT88_tree)



                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:192:11: ( '+' ^ INT )*
                while True: #loop26
                    alt26 = 2
                    LA26_0 = self.input.LA(1)

                    if (LA26_0 == 18) :
                        alt26 = 1


                    if alt26 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:192:12: '+' ^ INT
                        pass 
                        char_literal89 = self.match(self.input, 18, self.FOLLOW_18_in_r381575)
                        if self._state.backtracking == 0:
                            char_literal89_tree = self._adaptor.createWithPayload(char_literal89)
                            root_0 = self._adaptor.becomeRoot(char_literal89_tree, root_0)



                        INT90 = self.match(self.input, INT, self.FOLLOW_INT_in_r381578)
                        if self._state.backtracking == 0:
                            INT90_tree = self._adaptor.createWithPayload(INT90)
                            self._adaptor.addChild(root_0, INT90_tree)




                    else:
                        break #loop26




                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r38"


    class r39_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r39_return, self).__init__()

            self.tree = None





    # $ANTLR start "r39"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:195:1: r39 : ( primary -> primary ) ( '(' arg= expression ')' -> ^( CALL $r39 $arg) | '[' ie= expression ']' -> ^( INDEX $r39 $ie) | '.' p= primary -> ^( FIELDACCESS $r39 $p) )* ;
    def r39(self, ):
        retval = self.r39_return()
        retval.start = self.input.LT(1)


        root_0 = None

        char_literal92 = None
        char_literal93 = None
        char_literal94 = None
        char_literal95 = None
        char_literal96 = None
        arg = None

        ie = None

        p = None

        primary91 = None


        char_literal92_tree = None
        char_literal93_tree = None
        char_literal94_tree = None
        char_literal95_tree = None
        char_literal96_tree = None
        stream_20 = RewriteRuleTokenStream(self._adaptor, "token 20")
        stream_17 = RewriteRuleTokenStream(self._adaptor, "token 17")
        stream_24 = RewriteRuleTokenStream(self._adaptor, "token 24")
        stream_25 = RewriteRuleTokenStream(self._adaptor, "token 25")
        stream_16 = RewriteRuleTokenStream(self._adaptor, "token 16")
        stream_expression = RewriteRuleSubtreeStream(self._adaptor, "rule expression")
        stream_primary = RewriteRuleSubtreeStream(self._adaptor, "rule primary")
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:196:5: ( ( primary -> primary ) ( '(' arg= expression ')' -> ^( CALL $r39 $arg) | '[' ie= expression ']' -> ^( INDEX $r39 $ie) | '.' p= primary -> ^( FIELDACCESS $r39 $p) )* )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:196:7: ( primary -> primary ) ( '(' arg= expression ')' -> ^( CALL $r39 $arg) | '[' ie= expression ']' -> ^( INDEX $r39 $ie) | '.' p= primary -> ^( FIELDACCESS $r39 $p) )*
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:196:7: ( primary -> primary )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:196:8: primary
                pass 
                self._state.following.append(self.FOLLOW_primary_in_r391598)
                primary91 = self.primary()

                self._state.following.pop()
                if self._state.backtracking == 0:
                    stream_primary.add(primary91.tree)


                # AST Rewrite
                # elements: primary
                # token labels: 
                # rule labels: retval
                # token list labels: 
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                    root_0 = self._adaptor.nil()
                    # 196:15: -> primary
                    self._adaptor.addChild(root_0, stream_primary.nextTree())




                    retval.tree = root_0






                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:197:9: ( '(' arg= expression ')' -> ^( CALL $r39 $arg) | '[' ie= expression ']' -> ^( INDEX $r39 $ie) | '.' p= primary -> ^( FIELDACCESS $r39 $p) )*
                while True: #loop27
                    alt27 = 4
                    LA27 = self.input.LA(1)
                    if LA27 == 16:
                        alt27 = 1
                    elif LA27 == 24:
                        alt27 = 2
                    elif LA27 == 20:
                        alt27 = 3

                    if alt27 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:197:11: '(' arg= expression ')'
                        pass 
                        char_literal92 = self.match(self.input, 16, self.FOLLOW_16_in_r391614) 
                        if self._state.backtracking == 0:
                            stream_16.add(char_literal92)


                        self._state.following.append(self.FOLLOW_expression_in_r391618)
                        arg = self.expression()

                        self._state.following.pop()
                        if self._state.backtracking == 0:
                            stream_expression.add(arg.tree)


                        char_literal93 = self.match(self.input, 17, self.FOLLOW_17_in_r391620) 
                        if self._state.backtracking == 0:
                            stream_17.add(char_literal93)


                        # AST Rewrite
                        # elements: arg, r39
                        # token labels: 
                        # rule labels: arg, retval
                        # token list labels: 
                        # rule list labels: 
                        # wildcard labels: 
                        if self._state.backtracking == 0:
                            retval.tree = root_0
                            if arg is not None:
                                stream_arg = RewriteRuleSubtreeStream(self._adaptor, "rule arg", arg.tree)
                            else:
                                stream_arg = RewriteRuleSubtreeStream(self._adaptor, "token arg", None)

                            if retval is not None:
                                stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                            else:
                                stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                            root_0 = self._adaptor.nil()
                            # 198:13: -> ^( CALL $r39 $arg)
                            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:198:16: ^( CALL $r39 $arg)
                            root_1 = self._adaptor.nil()
                            root_1 = self._adaptor.becomeRoot(
                            self._adaptor.createFromType(CALL, "CALL")
                            , root_1)

                            self._adaptor.addChild(root_1, stream_retval.nextTree())

                            self._adaptor.addChild(root_1, stream_arg.nextTree())

                            self._adaptor.addChild(root_0, root_1)




                            retval.tree = root_0




                    elif alt27 == 2:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:199:11: '[' ie= expression ']'
                        pass 
                        char_literal94 = self.match(self.input, 24, self.FOLLOW_24_in_r391656) 
                        if self._state.backtracking == 0:
                            stream_24.add(char_literal94)


                        self._state.following.append(self.FOLLOW_expression_in_r391660)
                        ie = self.expression()

                        self._state.following.pop()
                        if self._state.backtracking == 0:
                            stream_expression.add(ie.tree)


                        char_literal95 = self.match(self.input, 25, self.FOLLOW_25_in_r391662) 
                        if self._state.backtracking == 0:
                            stream_25.add(char_literal95)


                        # AST Rewrite
                        # elements: ie, r39
                        # token labels: 
                        # rule labels: retval, ie
                        # token list labels: 
                        # rule list labels: 
                        # wildcard labels: 
                        if self._state.backtracking == 0:
                            retval.tree = root_0
                            if retval is not None:
                                stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                            else:
                                stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)

                            if ie is not None:
                                stream_ie = RewriteRuleSubtreeStream(self._adaptor, "rule ie", ie.tree)
                            else:
                                stream_ie = RewriteRuleSubtreeStream(self._adaptor, "token ie", None)


                            root_0 = self._adaptor.nil()
                            # 200:13: -> ^( INDEX $r39 $ie)
                            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:200:16: ^( INDEX $r39 $ie)
                            root_1 = self._adaptor.nil()
                            root_1 = self._adaptor.becomeRoot(
                            self._adaptor.createFromType(INDEX, "INDEX")
                            , root_1)

                            self._adaptor.addChild(root_1, stream_retval.nextTree())

                            self._adaptor.addChild(root_1, stream_ie.nextTree())

                            self._adaptor.addChild(root_0, root_1)




                            retval.tree = root_0




                    elif alt27 == 3:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:201:11: '.' p= primary
                        pass 
                        char_literal96 = self.match(self.input, 20, self.FOLLOW_20_in_r391698) 
                        if self._state.backtracking == 0:
                            stream_20.add(char_literal96)


                        self._state.following.append(self.FOLLOW_primary_in_r391702)
                        p = self.primary()

                        self._state.following.pop()
                        if self._state.backtracking == 0:
                            stream_primary.add(p.tree)


                        # AST Rewrite
                        # elements: p, r39
                        # token labels: 
                        # rule labels: retval, p
                        # token list labels: 
                        # rule list labels: 
                        # wildcard labels: 
                        if self._state.backtracking == 0:
                            retval.tree = root_0
                            if retval is not None:
                                stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                            else:
                                stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)

                            if p is not None:
                                stream_p = RewriteRuleSubtreeStream(self._adaptor, "rule p", p.tree)
                            else:
                                stream_p = RewriteRuleSubtreeStream(self._adaptor, "token p", None)


                            root_0 = self._adaptor.nil()
                            # 202:13: -> ^( FIELDACCESS $r39 $p)
                            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:202:16: ^( FIELDACCESS $r39 $p)
                            root_1 = self._adaptor.nil()
                            root_1 = self._adaptor.becomeRoot(
                            self._adaptor.createFromType(FIELDACCESS, "FIELDACCESS")
                            , root_1)

                            self._adaptor.addChild(root_1, stream_retval.nextTree())

                            self._adaptor.addChild(root_1, stream_p.nextTree())

                            self._adaptor.addChild(root_0, root_1)




                            retval.tree = root_0




                    else:
                        break #loop27




                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r39"


    class r40_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r40_return, self).__init__()

            self.tree = None





    # $ANTLR start "r40"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:206:1: r40 : ( INT -> INT ) ( ( '+' i+= INT )* -> ^( '+' $r40 ( $i)* ) ) ';' ;
    def r40(self, ):
        retval = self.r40_return()
        retval.start = self.input.LT(1)


        root_0 = None

        INT97 = None
        char_literal98 = None
        char_literal99 = None
        i = None
        list_i = None

        INT97_tree = None
        char_literal98_tree = None
        char_literal99_tree = None
        i_tree = None
        stream_INT = RewriteRuleTokenStream(self._adaptor, "token INT")
        stream_22 = RewriteRuleTokenStream(self._adaptor, "token 22")
        stream_18 = RewriteRuleTokenStream(self._adaptor, "token 18")

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:207:5: ( ( INT -> INT ) ( ( '+' i+= INT )* -> ^( '+' $r40 ( $i)* ) ) ';' )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:207:7: ( INT -> INT ) ( ( '+' i+= INT )* -> ^( '+' $r40 ( $i)* ) ) ';'
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:207:7: ( INT -> INT )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:207:8: INT
                pass 
                INT97 = self.match(self.input, INT, self.FOLLOW_INT_in_r401755) 
                if self._state.backtracking == 0:
                    stream_INT.add(INT97)


                # AST Rewrite
                # elements: INT
                # token labels: 
                # rule labels: retval
                # token list labels: 
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                    root_0 = self._adaptor.nil()
                    # 207:12: -> INT
                    self._adaptor.addChild(root_0, 
                    stream_INT.nextNode()
                    )




                    retval.tree = root_0






                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:207:20: ( ( '+' i+= INT )* -> ^( '+' $r40 ( $i)* ) )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:207:22: ( '+' i+= INT )*
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:207:22: ( '+' i+= INT )*
                while True: #loop28
                    alt28 = 2
                    LA28_0 = self.input.LA(1)

                    if (LA28_0 == 18) :
                        alt28 = 1


                    if alt28 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:207:23: '+' i+= INT
                        pass 
                        char_literal98 = self.match(self.input, 18, self.FOLLOW_18_in_r401765) 
                        if self._state.backtracking == 0:
                            stream_18.add(char_literal98)


                        i = self.match(self.input, INT, self.FOLLOW_INT_in_r401769) 
                        if self._state.backtracking == 0:
                            stream_INT.add(i)

                        if list_i is None:
                            list_i = []
                        list_i.append(i)



                    else:
                        break #loop28


                # AST Rewrite
                # elements: r40, 18, i
                # token labels: 
                # rule labels: retval
                # token list labels: i
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    stream_i = RewriteRuleTokenStream(self._adaptor, "token i", list_i)
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                    root_0 = self._adaptor.nil()
                    # 207:36: -> ^( '+' $r40 ( $i)* )
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:207:39: ^( '+' $r40 ( $i)* )
                    root_1 = self._adaptor.nil()
                    root_1 = self._adaptor.becomeRoot(
                    stream_18.nextNode()
                    , root_1)

                    self._adaptor.addChild(root_1, stream_retval.nextTree())

                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:207:51: ( $i)*
                    while stream_i.hasNext():
                        self._adaptor.addChild(root_1, stream_i.nextNode())


                    stream_i.reset();

                    self._adaptor.addChild(root_0, root_1)




                    retval.tree = root_0






                char_literal99 = self.match(self.input, 22, self.FOLLOW_22_in_r401788) 
                if self._state.backtracking == 0:
                    stream_22.add(char_literal99)




                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r40"


    class r41_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r41_return, self).__init__()

            self.tree = None





    # $ANTLR start "r41"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:210:1: r41 : ( INT -> INT ) ( ( '+' i= INT ) -> ^( $i $r41) )* ';' ;
    def r41(self, ):
        retval = self.r41_return()
        retval.start = self.input.LT(1)


        root_0 = None

        i = None
        INT100 = None
        char_literal101 = None
        char_literal102 = None

        i_tree = None
        INT100_tree = None
        char_literal101_tree = None
        char_literal102_tree = None
        stream_INT = RewriteRuleTokenStream(self._adaptor, "token INT")
        stream_22 = RewriteRuleTokenStream(self._adaptor, "token 22")
        stream_18 = RewriteRuleTokenStream(self._adaptor, "token 18")

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:211:5: ( ( INT -> INT ) ( ( '+' i= INT ) -> ^( $i $r41) )* ';' )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:211:7: ( INT -> INT ) ( ( '+' i= INT ) -> ^( $i $r41) )* ';'
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:211:7: ( INT -> INT )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:211:8: INT
                pass 
                INT100 = self.match(self.input, INT, self.FOLLOW_INT_in_r411806) 
                if self._state.backtracking == 0:
                    stream_INT.add(INT100)


                # AST Rewrite
                # elements: INT
                # token labels: 
                # rule labels: retval
                # token list labels: 
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                    root_0 = self._adaptor.nil()
                    # 211:12: -> INT
                    self._adaptor.addChild(root_0, 
                    stream_INT.nextNode()
                    )




                    retval.tree = root_0






                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:211:20: ( ( '+' i= INT ) -> ^( $i $r41) )*
                while True: #loop29
                    alt29 = 2
                    LA29_0 = self.input.LA(1)

                    if (LA29_0 == 18) :
                        alt29 = 1


                    if alt29 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:211:22: ( '+' i= INT )
                        pass 
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:211:22: ( '+' i= INT )
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:211:23: '+' i= INT
                        pass 
                        char_literal101 = self.match(self.input, 18, self.FOLLOW_18_in_r411816) 
                        if self._state.backtracking == 0:
                            stream_18.add(char_literal101)


                        i = self.match(self.input, INT, self.FOLLOW_INT_in_r411820) 
                        if self._state.backtracking == 0:
                            stream_INT.add(i)





                        # AST Rewrite
                        # elements: r41, i
                        # token labels: i
                        # rule labels: retval
                        # token list labels: 
                        # rule list labels: 
                        # wildcard labels: 
                        if self._state.backtracking == 0:
                            retval.tree = root_0
                            stream_i = RewriteRuleTokenStream(self._adaptor, "token i", i)
                            if retval is not None:
                                stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                            else:
                                stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                            root_0 = self._adaptor.nil()
                            # 211:34: -> ^( $i $r41)
                            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:211:37: ^( $i $r41)
                            root_1 = self._adaptor.nil()
                            root_1 = self._adaptor.becomeRoot(stream_i.nextNode(), root_1)

                            self._adaptor.addChild(root_1, stream_retval.nextTree())

                            self._adaptor.addChild(root_0, root_1)




                            retval.tree = root_0




                    else:
                        break #loop29


                char_literal102 = self.match(self.input, 22, self.FOLLOW_22_in_r411836) 
                if self._state.backtracking == 0:
                    stream_22.add(char_literal102)




                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r41"


    class r42_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r42_return, self).__init__()

            self.tree = None





    # $ANTLR start "r42"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:214:1: r42 :ids+= ID ( ',' !ids+= ID )* ;
    def r42(self, ):
        retval = self.r42_return()
        retval.start = self.input.LT(1)


        root_0 = None

        char_literal103 = None
        ids = None
        list_ids = None

        char_literal103_tree = None
        ids_tree = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:215:5: (ids+= ID ( ',' !ids+= ID )* )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:215:7: ids+= ID ( ',' !ids+= ID )*
                pass 
                root_0 = self._adaptor.nil()


                ids = self.match(self.input, ID, self.FOLLOW_ID_in_r421855)
                if self._state.backtracking == 0:
                    ids_tree = self._adaptor.createWithPayload(ids)
                    self._adaptor.addChild(root_0, ids_tree)


                if list_ids is None:
                    list_ids = []
                list_ids.append(ids)


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:215:15: ( ',' !ids+= ID )*
                while True: #loop30
                    alt30 = 2
                    LA30_0 = self.input.LA(1)

                    if (LA30_0 == 19) :
                        alt30 = 1


                    if alt30 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:215:16: ',' !ids+= ID
                        pass 
                        char_literal103 = self.match(self.input, 19, self.FOLLOW_19_in_r421858)

                        ids = self.match(self.input, ID, self.FOLLOW_ID_in_r421863)
                        if self._state.backtracking == 0:
                            ids_tree = self._adaptor.createWithPayload(ids)
                            self._adaptor.addChild(root_0, ids_tree)


                        if list_ids is None:
                            list_ids = []
                        list_ids.append(ids)



                    else:
                        break #loop30




                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r42"


    class r43_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r43_return, self).__init__()

            self.res = None
            self.tree = None





    # $ANTLR start "r43"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:218:1: r43 returns [res] :ids+= ID ! ( ',' !ids+= ID !)* ;
    def r43(self, ):
        retval = self.r43_return()
        retval.start = self.input.LT(1)


        root_0 = None

        char_literal104 = None
        ids = None
        list_ids = None

        char_literal104_tree = None
        ids_tree = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:219:5: (ids+= ID ! ( ',' !ids+= ID !)* )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:219:7: ids+= ID ! ( ',' !ids+= ID !)*
                pass 
                root_0 = self._adaptor.nil()


                ids = self.match(self.input, ID, self.FOLLOW_ID_in_r431888)
                if list_ids is None:
                    list_ids = []
                list_ids.append(ids)


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:219:16: ( ',' !ids+= ID !)*
                while True: #loop31
                    alt31 = 2
                    LA31_0 = self.input.LA(1)

                    if (LA31_0 == 19) :
                        alt31 = 1


                    if alt31 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:219:17: ',' !ids+= ID !
                        pass 
                        char_literal104 = self.match(self.input, 19, self.FOLLOW_19_in_r431892)

                        ids = self.match(self.input, ID, self.FOLLOW_ID_in_r431897)
                        if list_ids is None:
                            list_ids = []
                        list_ids.append(ids)



                    else:
                        break #loop31


                if self._state.backtracking == 0:
                    pass
                    retval.res = [id.text for id in list_ids]





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r43"


    class r44_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r44_return, self).__init__()

            self.tree = None





    # $ANTLR start "r44"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:222:1: r44 :ids+= ID ^ ( ',' !ids+= ID ^)* ;
    def r44(self, ):
        retval = self.r44_return()
        retval.start = self.input.LT(1)


        root_0 = None

        char_literal105 = None
        ids = None
        list_ids = None

        char_literal105_tree = None
        ids_tree = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:223:5: (ids+= ID ^ ( ',' !ids+= ID ^)* )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:223:7: ids+= ID ^ ( ',' !ids+= ID ^)*
                pass 
                root_0 = self._adaptor.nil()


                ids = self.match(self.input, ID, self.FOLLOW_ID_in_r441921)
                if self._state.backtracking == 0:
                    ids_tree = self._adaptor.createWithPayload(ids)
                    root_0 = self._adaptor.becomeRoot(ids_tree, root_0)


                if list_ids is None:
                    list_ids = []
                list_ids.append(ids)


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:223:16: ( ',' !ids+= ID ^)*
                while True: #loop32
                    alt32 = 2
                    LA32_0 = self.input.LA(1)

                    if (LA32_0 == 19) :
                        alt32 = 1


                    if alt32 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:223:17: ',' !ids+= ID ^
                        pass 
                        char_literal105 = self.match(self.input, 19, self.FOLLOW_19_in_r441925)

                        ids = self.match(self.input, ID, self.FOLLOW_ID_in_r441930)
                        if self._state.backtracking == 0:
                            ids_tree = self._adaptor.createWithPayload(ids)
                            root_0 = self._adaptor.becomeRoot(ids_tree, root_0)


                        if list_ids is None:
                            list_ids = []
                        list_ids.append(ids)



                    else:
                        break #loop32




                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r44"


    class r45_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r45_return, self).__init__()

            self.tree = None





    # $ANTLR start "r45"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:226:1: r45 : primary ^;
    def r45(self, ):
        retval = self.r45_return()
        retval.start = self.input.LT(1)


        root_0 = None

        primary106 = None



        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:227:5: ( primary ^)
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:227:7: primary ^
                pass 
                root_0 = self._adaptor.nil()


                self._state.following.append(self.FOLLOW_primary_in_r451950)
                primary106 = self.primary()

                self._state.following.pop()
                if self._state.backtracking == 0:
                    root_0 = self._adaptor.becomeRoot(primary106.tree, root_0)




                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r45"


    class r46_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r46_return, self).__init__()

            self.res = None
            self.tree = None





    # $ANTLR start "r46"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:230:1: r46 returns [res] :ids+= primary ! ( ',' !ids+= primary !)* ;
    def r46(self, ):
        retval = self.r46_return()
        retval.start = self.input.LT(1)


        root_0 = None

        char_literal107 = None
        list_ids = None
        ids = None

        ids = None
        char_literal107_tree = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:231:5: (ids+= primary ! ( ',' !ids+= primary !)* )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:231:7: ids+= primary ! ( ',' !ids+= primary !)*
                pass 
                root_0 = self._adaptor.nil()


                self._state.following.append(self.FOLLOW_primary_in_r461974)
                ids = self.primary()

                self._state.following.pop()
                if list_ids is None:
                    list_ids = []
                list_ids.append(ids.tree)


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:231:21: ( ',' !ids+= primary !)*
                while True: #loop33
                    alt33 = 2
                    LA33_0 = self.input.LA(1)

                    if (LA33_0 == 19) :
                        alt33 = 1


                    if alt33 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:231:22: ',' !ids+= primary !
                        pass 
                        char_literal107 = self.match(self.input, 19, self.FOLLOW_19_in_r461978)

                        self._state.following.append(self.FOLLOW_primary_in_r461983)
                        ids = self.primary()

                        self._state.following.pop()
                        if list_ids is None:
                            list_ids = []
                        list_ids.append(ids.tree)



                    else:
                        break #loop33


                if self._state.backtracking == 0:
                    pass
                    retval.res = [id.text for id in list_ids]





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r46"


    class r47_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r47_return, self).__init__()

            self.tree = None





    # $ANTLR start "r47"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:234:1: r47 :ids+= primary ( ',' !ids+= primary )* ;
    def r47(self, ):
        retval = self.r47_return()
        retval.start = self.input.LT(1)


        root_0 = None

        char_literal108 = None
        list_ids = None
        ids = None

        ids = None
        char_literal108_tree = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:235:5: (ids+= primary ( ',' !ids+= primary )* )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:235:7: ids+= primary ( ',' !ids+= primary )*
                pass 
                root_0 = self._adaptor.nil()


                self._state.following.append(self.FOLLOW_primary_in_r472007)
                ids = self.primary()

                self._state.following.pop()
                if self._state.backtracking == 0:
                    self._adaptor.addChild(root_0, ids.tree)

                if list_ids is None:
                    list_ids = []
                list_ids.append(ids.tree)


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:235:20: ( ',' !ids+= primary )*
                while True: #loop34
                    alt34 = 2
                    LA34_0 = self.input.LA(1)

                    if (LA34_0 == 19) :
                        alt34 = 1


                    if alt34 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:235:21: ',' !ids+= primary
                        pass 
                        char_literal108 = self.match(self.input, 19, self.FOLLOW_19_in_r472010)

                        self._state.following.append(self.FOLLOW_primary_in_r472015)
                        ids = self.primary()

                        self._state.following.pop()
                        if self._state.backtracking == 0:
                            self._adaptor.addChild(root_0, ids.tree)

                        if list_ids is None:
                            list_ids = []
                        list_ids.append(ids.tree)



                    else:
                        break #loop34




                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r47"


    class r48_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r48_return, self).__init__()

            self.tree = None





    # $ANTLR start "r48"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:238:1: r48 :ids+= . ( ',' !ids+= . )* ;
    def r48(self, ):
        retval = self.r48_return()
        retval.start = self.input.LT(1)


        root_0 = None

        char_literal109 = None
        ids = None
        list_ids = None

        char_literal109_tree = None
        ids_tree = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:239:5: (ids+= . ( ',' !ids+= . )* )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:239:7: ids+= . ( ',' !ids+= . )*
                pass 
                root_0 = self._adaptor.nil()


                ids = self.input.LT(1)

                self.matchAny(self.input)
                if self._state.backtracking == 0:
                    ids_tree = self._adaptor.createWithPayload(ids)
                    self._adaptor.addChild(root_0, ids_tree)


                if list_ids is None:
                    list_ids = []
                list_ids.append(ids)


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:239:14: ( ',' !ids+= . )*
                while True: #loop35
                    alt35 = 2
                    LA35_0 = self.input.LA(1)

                    if (LA35_0 == 19) :
                        alt35 = 1


                    if alt35 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:239:15: ',' !ids+= .
                        pass 
                        char_literal109 = self.match(self.input, 19, self.FOLLOW_19_in_r482039)

                        ids = self.input.LT(1)

                        self.matchAny(self.input)
                        if self._state.backtracking == 0:
                            ids_tree = self._adaptor.createWithPayload(ids)
                            self._adaptor.addChild(root_0, ids_tree)


                        if list_ids is None:
                            list_ids = []
                        list_ids.append(ids)



                    else:
                        break #loop35




                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r48"


    class r49_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r49_return, self).__init__()

            self.tree = None





    # $ANTLR start "r49"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:242:1: r49 : . ^ ID ;
    def r49(self, ):
        retval = self.r49_return()
        retval.start = self.input.LT(1)


        root_0 = None

        wildcard110 = None
        ID111 = None

        wildcard110_tree = None
        ID111_tree = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:243:5: ( . ^ ID )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:243:7: . ^ ID
                pass 
                root_0 = self._adaptor.nil()


                wildcard110 = self.input.LT(1)

                self.matchAny(self.input)
                if self._state.backtracking == 0:
                    wildcard110_tree = self._adaptor.createWithPayload(wildcard110)
                    root_0 = self._adaptor.becomeRoot(wildcard110_tree, root_0)



                ID111 = self.match(self.input, ID, self.FOLLOW_ID_in_r492066)
                if self._state.backtracking == 0:
                    ID111_tree = self._adaptor.createWithPayload(ID111)
                    self._adaptor.addChild(root_0, ID111_tree)





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r49"


    class r50_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r50_return, self).__init__()

            self.tree = None





    # $ANTLR start "r50"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:246:1: r50 : ID -> ^( ID ) ;
    def r50(self, ):
        retval = self.r50_return()
        retval.start = self.input.LT(1)


        root_0 = None

        ID112 = None

        ID112_tree = None
        stream_ID = RewriteRuleTokenStream(self._adaptor, "token ID")

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:247:5: ( ID -> ^( ID ) )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:247:7: ID
                pass 
                ID112 = self.match(self.input, ID, self.FOLLOW_ID_in_r502083) 
                if self._state.backtracking == 0:
                    stream_ID.add(ID112)


                # AST Rewrite
                # elements: ID
                # token labels: 
                # rule labels: retval
                # token list labels: 
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                    root_0 = self._adaptor.nil()
                    # 248:9: -> ^( ID )
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:248:12: ^( ID )
                    root_1 = self._adaptor.nil()
                    root_1 = self._adaptor.becomeRoot(CommonTree(CommonToken(type=FLOAT, text="1.0")), root_1)

                    self._adaptor.addChild(root_1, 
                    stream_ID.nextNode()
                    )

                    self._adaptor.addChild(root_0, root_1)




                    retval.tree = root_0





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r50"


    class r51_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r51_return, self).__init__()

            self.res = None
            self.tree = None





    # $ANTLR start "r51"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:254:1: r51 returns [res] : ID t= ID ID ;
    def r51(self, ):
        retval = self.r51_return()
        retval.start = self.input.LT(1)


        root_0 = None

        t = None
        ID113 = None
        ID114 = None

        t_tree = None
        ID113_tree = None
        ID114_tree = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:255:5: ( ID t= ID ID )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:255:7: ID t= ID ID
                pass 
                root_0 = self._adaptor.nil()


                ID113 = self.match(self.input, ID, self.FOLLOW_ID_in_r512123)
                if self._state.backtracking == 0:
                    ID113_tree = self._adaptor.createWithPayload(ID113)
                    self._adaptor.addChild(root_0, ID113_tree)



                t = self.match(self.input, ID, self.FOLLOW_ID_in_r512127)
                if self._state.backtracking == 0:
                    t_tree = self._adaptor.createWithPayload(t)
                    self._adaptor.addChild(root_0, t_tree)



                ID114 = self.match(self.input, ID, self.FOLLOW_ID_in_r512129)
                if self._state.backtracking == 0:
                    ID114_tree = self._adaptor.createWithPayload(ID114)
                    self._adaptor.addChild(root_0, ID114_tree)



                if self._state.backtracking == 0:
                    pass
                    retval.res = t_tree 





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r51"


    class r52_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r52_return, self).__init__()

            self.res = None
            self.tree = None





    # $ANTLR start "r52"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:262:1: r52 returns [res] : ID ;
    def r52(self, ):
        retval = self.r52_return()
        retval.start = self.input.LT(1)


        root_0 = None

        ID115 = None

        ID115_tree = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:266:5: ( ID )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:266:7: ID
                pass 
                root_0 = self._adaptor.nil()


                ID115 = self.match(self.input, ID, self.FOLLOW_ID_in_r522167)
                if self._state.backtracking == 0:
                    ID115_tree = self._adaptor.createWithPayload(ID115)
                    self._adaptor.addChild(root_0, ID115_tree)





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



                if self._state.backtracking == 0:
                    pass
                           
                    retval.res = retval.tree




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r52"


    class r53_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r53_return, self).__init__()

            self.res = None
            self.tree = None





    # $ANTLR start "r53"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:272:1: r53 returns [res] : t= primary ;
    def r53(self, ):
        retval = self.r53_return()
        retval.start = self.input.LT(1)


        root_0 = None

        t = None



        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:273:5: (t= primary )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:273:7: t= primary
                pass 
                root_0 = self._adaptor.nil()


                self._state.following.append(self.FOLLOW_primary_in_r532192)
                t = self.primary()

                self._state.following.pop()
                if self._state.backtracking == 0:
                    self._adaptor.addChild(root_0, t.tree)


                if self._state.backtracking == 0:
                    pass
                    retval.res = t.tree 





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r53"


    class r54_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r54_return, self).__init__()

            self.res = None
            self.tree = None





    # $ANTLR start "r54"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:280:1: r54 returns [res] : ID t= expression ID ;
    def r54(self, ):
        retval = self.r54_return()
        retval.start = self.input.LT(1)


        root_0 = None

        ID116 = None
        ID117 = None
        t = None


        ID116_tree = None
        ID117_tree = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:284:5: ( ID t= expression ID )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:284:7: ID t= expression ID
                pass 
                root_0 = self._adaptor.nil()


                ID116 = self.match(self.input, ID, self.FOLLOW_ID_in_r542230)
                if self._state.backtracking == 0:
                    ID116_tree = self._adaptor.createWithPayload(ID116)
                    self._adaptor.addChild(root_0, ID116_tree)



                self._state.following.append(self.FOLLOW_expression_in_r542234)
                t = self.expression()

                self._state.following.pop()
                if self._state.backtracking == 0:
                    self._adaptor.addChild(root_0, t.tree)


                ID117 = self.match(self.input, ID, self.FOLLOW_ID_in_r542236)
                if self._state.backtracking == 0:
                    ID117_tree = self._adaptor.createWithPayload(ID117)
                    self._adaptor.addChild(root_0, ID117_tree)





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



                if self._state.backtracking == 0:
                    pass
                           
                    retval.tree = t.tree




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r54"


    class r55_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r55_return, self).__init__()

            self.tree = None





    # $ANTLR start "r55"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:288:1: r55 options {backtrack=true; k=1; } : ( ( ( modifier )+ INT )=> ( modifier )+ expression | ( modifier )+ statement );
    def r55(self, ):
        retval = self.r55_return()
        retval.start = self.input.LT(1)


        root_0 = None

        modifier118 = None

        expression119 = None

        modifier120 = None

        statement121 = None



        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:290:5: ( ( ( modifier )+ INT )=> ( modifier )+ expression | ( modifier )+ statement )
                alt38 = 2
                LA38_0 = self.input.LA(1)

                if ((39 <= LA38_0 <= 40)) :
                    LA38_1 = self.input.LA(2)

                    if (self.synpred1_t042ast()) :
                        alt38 = 1
                    elif (True) :
                        alt38 = 2
                    else:
                        if self._state.backtracking > 0:
                            raise BacktrackingFailed


                        nvae = NoViableAltException("", 38, 1, self.input)

                        raise nvae


                else:
                    if self._state.backtracking > 0:
                        raise BacktrackingFailed


                    nvae = NoViableAltException("", 38, 0, self.input)

                    raise nvae


                if alt38 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:290:7: ( ( modifier )+ INT )=> ( modifier )+ expression
                    pass 
                    root_0 = self._adaptor.nil()


                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:290:25: ( modifier )+
                    cnt36 = 0
                    while True: #loop36
                        alt36 = 2
                        LA36_0 = self.input.LA(1)

                        if ((39 <= LA36_0 <= 40)) :
                            alt36 = 1


                        if alt36 == 1:
                            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:290:25: modifier
                            pass 
                            self._state.following.append(self.FOLLOW_modifier_in_r552277)
                            modifier118 = self.modifier()

                            self._state.following.pop()
                            if self._state.backtracking == 0:
                                self._adaptor.addChild(root_0, modifier118.tree)



                        else:
                            if cnt36 >= 1:
                                break #loop36

                            if self._state.backtracking > 0:
                                raise BacktrackingFailed


                            eee = EarlyExitException(36, self.input)
                            raise eee

                        cnt36 += 1


                    self._state.following.append(self.FOLLOW_expression_in_r552280)
                    expression119 = self.expression()

                    self._state.following.pop()
                    if self._state.backtracking == 0:
                        self._adaptor.addChild(root_0, expression119.tree)



                elif alt38 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:291:7: ( modifier )+ statement
                    pass 
                    root_0 = self._adaptor.nil()


                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:291:7: ( modifier )+
                    cnt37 = 0
                    while True: #loop37
                        alt37 = 2
                        LA37_0 = self.input.LA(1)

                        if ((39 <= LA37_0 <= 40)) :
                            alt37 = 1


                        if alt37 == 1:
                            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:291:7: modifier
                            pass 
                            self._state.following.append(self.FOLLOW_modifier_in_r552288)
                            modifier120 = self.modifier()

                            self._state.following.pop()
                            if self._state.backtracking == 0:
                                self._adaptor.addChild(root_0, modifier120.tree)



                        else:
                            if cnt37 >= 1:
                                break #loop37

                            if self._state.backtracking > 0:
                                raise BacktrackingFailed


                            eee = EarlyExitException(37, self.input)
                            raise eee

                        cnt37 += 1


                    self._state.following.append(self.FOLLOW_statement_in_r552291)
                    statement121 = self.statement()

                    self._state.following.pop()
                    if self._state.backtracking == 0:
                        self._adaptor.addChild(root_0, statement121.tree)



                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r55"


    class r56_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r56_return, self).__init__()

            self.tree = None





    # $ANTLR start "r56"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:298:1: r56 : (t= ID )* -> ID[$t,'foo'] ;
    def r56(self, ):
        retval = self.r56_return()
        retval.start = self.input.LT(1)


        root_0 = None

        t = None

        t_tree = None
        stream_ID = RewriteRuleTokenStream(self._adaptor, "token ID")

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:299:5: ( (t= ID )* -> ID[$t,'foo'] )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:299:7: (t= ID )*
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:299:8: (t= ID )*
                while True: #loop39
                    alt39 = 2
                    LA39_0 = self.input.LA(1)

                    if (LA39_0 == ID) :
                        alt39 = 1


                    if alt39 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:299:8: t= ID
                        pass 
                        t = self.match(self.input, ID, self.FOLLOW_ID_in_r562313) 
                        if self._state.backtracking == 0:
                            stream_ID.add(t)



                    else:
                        break #loop39


                # AST Rewrite
                # elements: ID
                # token labels: 
                # rule labels: retval
                # token list labels: 
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                    root_0 = self._adaptor.nil()
                    # 299:13: -> ID[$t,'foo']
                    self._adaptor.addChild(root_0, 
                    self._adaptor.create(ID, t, 'foo')
                    )




                    retval.tree = root_0





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r56"


    class r57_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r57_return, self).__init__()

            self.tree = None





    # $ANTLR start "r57"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:305:1: r57 : (t= ID )* -> ^( ID[$t,'foo'] ) ;
    def r57(self, ):
        retval = self.r57_return()
        retval.start = self.input.LT(1)


        root_0 = None

        t = None

        t_tree = None
        stream_ID = RewriteRuleTokenStream(self._adaptor, "token ID")

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:306:5: ( (t= ID )* -> ^( ID[$t,'foo'] ) )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:306:7: (t= ID )*
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:306:8: (t= ID )*
                while True: #loop40
                    alt40 = 2
                    LA40_0 = self.input.LA(1)

                    if (LA40_0 == ID) :
                        alt40 = 1


                    if alt40 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:306:8: t= ID
                        pass 
                        t = self.match(self.input, ID, self.FOLLOW_ID_in_r572340) 
                        if self._state.backtracking == 0:
                            stream_ID.add(t)



                    else:
                        break #loop40


                # AST Rewrite
                # elements: ID
                # token labels: 
                # rule labels: retval
                # token list labels: 
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                    root_0 = self._adaptor.nil()
                    # 306:13: -> ^( ID[$t,'foo'] )
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:306:16: ^( ID[$t,'foo'] )
                    root_1 = self._adaptor.nil()
                    root_1 = self._adaptor.becomeRoot(
                    self._adaptor.create(ID, t, 'foo')
                    , root_1)

                    self._adaptor.addChild(root_0, root_1)




                    retval.tree = root_0





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r57"


    class r58_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r58_return, self).__init__()

            self.tree = None





    # $ANTLR start "r58"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:312:1: r58 : () ^;
    def r58(self, ):
        retval = self.r58_return()
        retval.start = self.input.LT(1)


        root_0 = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:313:5: ( () ^)
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:313:7: () ^
                pass 
                root_0 = self._adaptor.nil()


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:313:7: ()
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:313:8: 
                pass 
                if self._state.backtracking == 0:
                    pass
                    CommonTree(CommonToken(type=FLOAT, text="2.0"))








                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            finally:
                pass

        finally:
            pass
        return retval

    # $ANTLR end "r58"


    class r59_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.r59_return, self).__init__()

            self.tree = None





    # $ANTLR start "r59"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:319:1: r59 : (t+= ID )+ statement -> ( ^( $t statement ) )+ ;
    def r59(self, ):
        retval = self.r59_return()
        retval.start = self.input.LT(1)


        root_0 = None

        t = None
        list_t = None
        statement122 = None


        t_tree = None
        stream_ID = RewriteRuleTokenStream(self._adaptor, "token ID")
        stream_statement = RewriteRuleSubtreeStream(self._adaptor, "rule statement")
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:320:5: ( (t+= ID )+ statement -> ( ^( $t statement ) )+ )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:320:7: (t+= ID )+ statement
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:320:7: (t+= ID )+
                cnt41 = 0
                while True: #loop41
                    alt41 = 2
                    LA41_0 = self.input.LA(1)

                    if (LA41_0 == ID) :
                        alt41 = 1


                    if alt41 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:320:8: t+= ID
                        pass 
                        t = self.match(self.input, ID, self.FOLLOW_ID_in_r592392) 
                        if self._state.backtracking == 0:
                            stream_ID.add(t)

                        if list_t is None:
                            list_t = []
                        list_t.append(t)



                    else:
                        if cnt41 >= 1:
                            break #loop41

                        if self._state.backtracking > 0:
                            raise BacktrackingFailed


                        eee = EarlyExitException(41, self.input)
                        raise eee

                    cnt41 += 1


                self._state.following.append(self.FOLLOW_statement_in_r592396)
                statement122 = self.statement()

                self._state.following.pop()
                if self._state.backtracking == 0:
                    stream_statement.add(statement122.tree)


                # AST Rewrite
                # elements: t, statement
                # token labels: 
                # rule labels: retval
                # token list labels: t
                # rule list labels: 
                # wildcard labels: 
                if self._state.backtracking == 0:
                    retval.tree = root_0
                    stream_t = RewriteRuleTokenStream(self._adaptor, "token t", list_t)
                    if retval is not None:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "rule retval", retval.tree)
                    else:
                        stream_retval = RewriteRuleSubtreeStream(self._adaptor, "token retval", None)


                    root_0 = self._adaptor.nil()
                    # 320:26: -> ( ^( $t statement ) )+
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:320:29: ( ^( $t statement ) )+
                    if not (stream_t.hasNext() or stream_statement.hasNext()):
                        raise RewriteEarlyExitException()

                    while stream_t.hasNext() or stream_statement.hasNext():
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:320:29: ^( $t statement )
                        root_1 = self._adaptor.nil()
                        root_1 = self._adaptor.becomeRoot(stream_t.nextNode(), root_1)

                        self._adaptor.addChild(root_1, stream_statement.nextTree())

                        self._adaptor.addChild(root_0, root_1)


                    stream_t.reset()
                    stream_statement.reset()




                    retval.tree = root_0





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "r59"


    class primary_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.primary_return, self).__init__()

            self.tree = None





    # $ANTLR start "primary"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:323:1: primary : ID ;
    def primary(self, ):
        retval = self.primary_return()
        retval.start = self.input.LT(1)


        root_0 = None

        ID123 = None

        ID123_tree = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:324:5: ( ID )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:324:7: ID
                pass 
                root_0 = self._adaptor.nil()


                ID123 = self.match(self.input, ID, self.FOLLOW_ID_in_primary2423)
                if self._state.backtracking == 0:
                    ID123_tree = self._adaptor.createWithPayload(ID123)
                    self._adaptor.addChild(root_0, ID123_tree)





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "primary"


    class expression_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.expression_return, self).__init__()

            self.tree = None





    # $ANTLR start "expression"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:327:1: expression : r1 ;
    def expression(self, ):
        retval = self.expression_return()
        retval.start = self.input.LT(1)


        root_0 = None

        r1124 = None



        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:328:5: ( r1 )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:328:7: r1
                pass 
                root_0 = self._adaptor.nil()


                self._state.following.append(self.FOLLOW_r1_in_expression2440)
                r1124 = self.r1()

                self._state.following.pop()
                if self._state.backtracking == 0:
                    self._adaptor.addChild(root_0, r1124.tree)




                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "expression"


    class statement_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.statement_return, self).__init__()

            self.tree = None





    # $ANTLR start "statement"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:331:1: statement : ( 'fooze' | 'fooze2' );
    def statement(self, ):
        retval = self.statement_return()
        retval.start = self.input.LT(1)


        root_0 = None

        set125 = None

        set125_tree = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:332:5: ( 'fooze' | 'fooze2' )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:
                pass 
                root_0 = self._adaptor.nil()


                set125 = self.input.LT(1)

                if (33 <= self.input.LA(1) <= 34):
                    self.input.consume()
                    if self._state.backtracking == 0:
                        self._adaptor.addChild(root_0, self._adaptor.createWithPayload(set125))

                    self._state.errorRecovery = False


                else:
                    if self._state.backtracking > 0:
                        raise BacktrackingFailed


                    mse = MismatchedSetException(None, self.input)
                    raise mse





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "statement"


    class modifiers_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.modifiers_return, self).__init__()

            self.tree = None





    # $ANTLR start "modifiers"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:336:1: modifiers : ( modifier )+ ;
    def modifiers(self, ):
        retval = self.modifiers_return()
        retval.start = self.input.LT(1)


        root_0 = None

        modifier126 = None



        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:337:5: ( ( modifier )+ )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:337:7: ( modifier )+
                pass 
                root_0 = self._adaptor.nil()


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:337:7: ( modifier )+
                cnt42 = 0
                while True: #loop42
                    alt42 = 2
                    LA42_0 = self.input.LA(1)

                    if ((39 <= LA42_0 <= 40)) :
                        alt42 = 1


                    if alt42 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:337:7: modifier
                        pass 
                        self._state.following.append(self.FOLLOW_modifier_in_modifiers2482)
                        modifier126 = self.modifier()

                        self._state.following.pop()
                        if self._state.backtracking == 0:
                            self._adaptor.addChild(root_0, modifier126.tree)



                    else:
                        if cnt42 >= 1:
                            break #loop42

                        if self._state.backtracking > 0:
                            raise BacktrackingFailed


                        eee = EarlyExitException(42, self.input)
                        raise eee

                    cnt42 += 1




                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "modifiers"


    class modifier_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.modifier_return, self).__init__()

            self.tree = None





    # $ANTLR start "modifier"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:340:1: modifier : ( 'public' | 'private' );
    def modifier(self, ):
        retval = self.modifier_return()
        retval.start = self.input.LT(1)


        root_0 = None

        set127 = None

        set127_tree = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:341:5: ( 'public' | 'private' )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:
                pass 
                root_0 = self._adaptor.nil()


                set127 = self.input.LT(1)

                if (39 <= self.input.LA(1) <= 40):
                    self.input.consume()
                    if self._state.backtracking == 0:
                        self._adaptor.addChild(root_0, self._adaptor.createWithPayload(set127))

                    self._state.errorRecovery = False


                else:
                    if self._state.backtracking > 0:
                        raise BacktrackingFailed


                    mse = MismatchedSetException(None, self.input)
                    raise mse





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "modifier"


    class type_return(ParserRuleReturnScope):
        def __init__(self):
            super(t042astParser.type_return, self).__init__()

            self.tree = None





    # $ANTLR start "type"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:345:1: type : ( 'int' | 'bool' );
    def type(self, ):
        retval = self.type_return()
        retval.start = self.input.LT(1)


        root_0 = None

        set128 = None

        set128_tree = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:346:5: ( 'int' | 'bool' )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:
                pass 
                root_0 = self._adaptor.nil()


                set128 = self.input.LT(1)

                if self.input.LA(1) == 27 or self.input.LA(1) == 38:
                    self.input.consume()
                    if self._state.backtracking == 0:
                        self._adaptor.addChild(root_0, self._adaptor.createWithPayload(set128))

                    self._state.errorRecovery = False


                else:
                    if self._state.backtracking > 0:
                        raise BacktrackingFailed


                    mse = MismatchedSetException(None, self.input)
                    raise mse





                retval.stop = self.input.LT(-1)


                if self._state.backtracking == 0:
                    retval.tree = self._adaptor.rulePostProcessing(root_0)
                    self._adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)
                retval.tree = self._adaptor.errorNode(self.input, retval.start, self.input.LT(-1), re)

        finally:
            pass
        return retval

    # $ANTLR end "type"

    # $ANTLR start "synpred1_t042ast"
    def synpred1_t042ast_fragment(self, ):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:290:7: ( ( modifier )+ INT )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:290:8: ( modifier )+ INT
        pass 
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:290:8: ( modifier )+
        cnt43 = 0
        while True: #loop43
            alt43 = 2
            LA43_0 = self.input.LA(1)

            if ((39 <= LA43_0 <= 40)) :
                alt43 = 1


            if alt43 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t042ast.g:290:8: modifier
                pass 
                self._state.following.append(self.FOLLOW_modifier_in_synpred1_t042ast2270)
                self.modifier()

                self._state.following.pop()


            else:
                if cnt43 >= 1:
                    break #loop43

                if self._state.backtracking > 0:
                    raise BacktrackingFailed


                eee = EarlyExitException(43, self.input)
                raise eee

            cnt43 += 1


        self.match(self.input, INT, self.FOLLOW_INT_in_synpred1_t042ast2273)



    # $ANTLR end "synpred1_t042ast"




    def synpred1_t042ast(self):
        self._state.backtracking += 1
        start = self.input.mark()
        try:
            self.synpred1_t042ast_fragment()
        except BacktrackingFailed:
            success = False
        else:
            success = True
        self.input.rewind(start)
        self._state.backtracking -= 1
        return success



 

    FOLLOW_INT_in_r1114 = frozenset([1, 18])
    FOLLOW_18_in_r1117 = frozenset([12])
    FOLLOW_INT_in_r1120 = frozenset([1, 18])
    FOLLOW_26_in_r2139 = frozenset([12])
    FOLLOW_expression_in_r2144 = frozenset([21, 22])
    FOLLOW_21_in_r2147 = frozenset([12])
    FOLLOW_expression_in_r2152 = frozenset([22])
    FOLLOW_22_in_r2156 = frozenset([1])
    FOLLOW_36_in_r3174 = frozenset([12])
    FOLLOW_expression_in_r3177 = frozenset([33, 34])
    FOLLOW_statement_in_r3181 = frozenset([1, 29])
    FOLLOW_29_in_r3184 = frozenset([33, 34])
    FOLLOW_statement_in_r3189 = frozenset([1])
    FOLLOW_43_in_r4208 = frozenset([12])
    FOLLOW_expression_in_r4211 = frozenset([33, 34])
    FOLLOW_statement_in_r4213 = frozenset([1])
    FOLLOW_41_in_r5230 = frozenset([12, 22])
    FOLLOW_expression_in_r5233 = frozenset([22])
    FOLLOW_22_in_r5236 = frozenset([1])
    FOLLOW_INT_in_r7276 = frozenset([1])
    FOLLOW_42_in_r8296 = frozenset([10])
    FOLLOW_ID_in_r8298 = frozenset([21])
    FOLLOW_21_in_r8300 = frozenset([27, 38])
    FOLLOW_type_in_r8302 = frozenset([1])
    FOLLOW_type_in_r9330 = frozenset([10])
    FOLLOW_ID_in_r9332 = frozenset([22])
    FOLLOW_22_in_r9334 = frozenset([1])
    FOLLOW_INT_in_r10362 = frozenset([1])
    FOLLOW_expression_in_r11383 = frozenset([1])
    FOLLOW_ID_in_r12418 = frozenset([1, 19])
    FOLLOW_19_in_r12421 = frozenset([10])
    FOLLOW_ID_in_r12423 = frozenset([1, 19])
    FOLLOW_type_in_r13447 = frozenset([10])
    FOLLOW_ID_in_r13449 = frozenset([19, 22])
    FOLLOW_19_in_r13452 = frozenset([10])
    FOLLOW_ID_in_r13454 = frozenset([19, 22])
    FOLLOW_22_in_r13458 = frozenset([1])
    FOLLOW_expression_in_r14486 = frozenset([27, 33, 34, 38])
    FOLLOW_statement_in_r14489 = frozenset([27, 33, 34, 38])
    FOLLOW_type_in_r14492 = frozenset([1, 27, 38])
    FOLLOW_INT_in_r15533 = frozenset([1])
    FOLLOW_38_in_r16556 = frozenset([10])
    FOLLOW_ID_in_r16558 = frozenset([1, 19])
    FOLLOW_19_in_r16561 = frozenset([10])
    FOLLOW_ID_in_r16563 = frozenset([1, 19])
    FOLLOW_35_in_r17591 = frozenset([16])
    FOLLOW_16_in_r17593 = frozenset([33, 34])
    FOLLOW_statement_in_r17597 = frozenset([22])
    FOLLOW_22_in_r17599 = frozenset([12])
    FOLLOW_expression_in_r17601 = frozenset([22])
    FOLLOW_22_in_r17603 = frozenset([33, 34])
    FOLLOW_statement_in_r17607 = frozenset([17])
    FOLLOW_17_in_r17609 = frozenset([33, 34])
    FOLLOW_statement_in_r17611 = frozenset([1])
    FOLLOW_35_in_r18654 = frozenset([1])
    FOLLOW_35_in_r19679 = frozenset([1])
    FOLLOW_35_in_r20705 = frozenset([1])
    FOLLOW_35_in_r21731 = frozenset([1])
    FOLLOW_35_in_r22754 = frozenset([1])
    FOLLOW_35_in_r23778 = frozenset([1])
    FOLLOW_statement_in_r24802 = frozenset([12])
    FOLLOW_expression_in_r24804 = frozenset([1])
    FOLLOW_statement_in_r25832 = frozenset([19])
    FOLLOW_19_in_r25835 = frozenset([33, 34])
    FOLLOW_statement_in_r25839 = frozenset([12, 19])
    FOLLOW_expression_in_r25843 = frozenset([1])
    FOLLOW_statement_in_r26871 = frozenset([19])
    FOLLOW_19_in_r26874 = frozenset([33, 34])
    FOLLOW_statement_in_r26878 = frozenset([1, 19])
    FOLLOW_statement_in_r27909 = frozenset([12])
    FOLLOW_expression_in_r27911 = frozenset([1])
    FOLLOW_31_in_r28943 = frozenset([1])
    FOLLOW_32_in_r28945 = frozenset([1])
    FOLLOW_statement_in_r29968 = frozenset([1, 33, 34])
    FOLLOW_statement_in_r30997 = frozenset([1, 33, 34])
    FOLLOW_modifier_in_r311024 = frozenset([27, 38])
    FOLLOW_type_in_r311026 = frozenset([10])
    FOLLOW_ID_in_r311028 = frozenset([22, 23])
    FOLLOW_23_in_r311031 = frozenset([12])
    FOLLOW_expression_in_r311033 = frozenset([22])
    FOLLOW_22_in_r311037 = frozenset([1])
    FOLLOW_ID_in_r321147 = frozenset([12])
    FOLLOW_INT_in_r321149 = frozenset([1])
    FOLLOW_modifiers_in_r331203 = frozenset([33, 34])
    FOLLOW_statement_in_r331206 = frozenset([1])
    FOLLOW_modifiers_in_r341225 = frozenset([28])
    FOLLOW_r34a_in_r341228 = frozenset([1])
    FOLLOW_28_in_r34a1254 = frozenset([10])
    FOLLOW_ID_in_r34a1256 = frozenset([30, 37, 44])
    FOLLOW_30_in_r34a1259 = frozenset([27, 38])
    FOLLOW_type_in_r34a1263 = frozenset([37, 44])
    FOLLOW_37_in_r34a1277 = frozenset([27, 38])
    FOLLOW_type_in_r34a1281 = frozenset([19, 44])
    FOLLOW_19_in_r34a1284 = frozenset([27, 38])
    FOLLOW_type_in_r34a1288 = frozenset([19, 44])
    FOLLOW_44_in_r34a1302 = frozenset([33, 34, 45])
    FOLLOW_statement_in_r34a1304 = frozenset([33, 34, 45])
    FOLLOW_45_in_r34a1307 = frozenset([1])
    FOLLOW_44_in_r351363 = frozenset([30])
    FOLLOW_30_in_r351365 = frozenset([27, 38, 45])
    FOLLOW_type_in_r351370 = frozenset([45])
    FOLLOW_45_in_r351374 = frozenset([1])
    FOLLOW_36_in_r361410 = frozenset([16])
    FOLLOW_16_in_r361412 = frozenset([12])
    FOLLOW_expression_in_r361414 = frozenset([17])
    FOLLOW_17_in_r361416 = frozenset([33, 34])
    FOLLOW_statement_in_r361420 = frozenset([1, 29])
    FOLLOW_29_in_r361432 = frozenset([33, 34])
    FOLLOW_statement_in_r361436 = frozenset([1])
    FOLLOW_INT_in_r371527 = frozenset([1, 18])
    FOLLOW_18_in_r371535 = frozenset([12])
    FOLLOW_INT_in_r371539 = frozenset([1, 18])
    FOLLOW_INT_in_r381572 = frozenset([1, 18])
    FOLLOW_18_in_r381575 = frozenset([12])
    FOLLOW_INT_in_r381578 = frozenset([1, 18])
    FOLLOW_primary_in_r391598 = frozenset([1, 16, 20, 24])
    FOLLOW_16_in_r391614 = frozenset([12])
    FOLLOW_expression_in_r391618 = frozenset([17])
    FOLLOW_17_in_r391620 = frozenset([1, 16, 20, 24])
    FOLLOW_24_in_r391656 = frozenset([12])
    FOLLOW_expression_in_r391660 = frozenset([25])
    FOLLOW_25_in_r391662 = frozenset([1, 16, 20, 24])
    FOLLOW_20_in_r391698 = frozenset([10])
    FOLLOW_primary_in_r391702 = frozenset([1, 16, 20, 24])
    FOLLOW_INT_in_r401755 = frozenset([18, 22])
    FOLLOW_18_in_r401765 = frozenset([12])
    FOLLOW_INT_in_r401769 = frozenset([18, 22])
    FOLLOW_22_in_r401788 = frozenset([1])
    FOLLOW_INT_in_r411806 = frozenset([18, 22])
    FOLLOW_18_in_r411816 = frozenset([12])
    FOLLOW_INT_in_r411820 = frozenset([18, 22])
    FOLLOW_22_in_r411836 = frozenset([1])
    FOLLOW_ID_in_r421855 = frozenset([1, 19])
    FOLLOW_19_in_r421858 = frozenset([10])
    FOLLOW_ID_in_r421863 = frozenset([1, 19])
    FOLLOW_ID_in_r431888 = frozenset([1, 19])
    FOLLOW_19_in_r431892 = frozenset([10])
    FOLLOW_ID_in_r431897 = frozenset([1, 19])
    FOLLOW_ID_in_r441921 = frozenset([1, 19])
    FOLLOW_19_in_r441925 = frozenset([10])
    FOLLOW_ID_in_r441930 = frozenset([1, 19])
    FOLLOW_primary_in_r451950 = frozenset([1])
    FOLLOW_primary_in_r461974 = frozenset([1, 19])
    FOLLOW_19_in_r461978 = frozenset([10])
    FOLLOW_primary_in_r461983 = frozenset([1, 19])
    FOLLOW_primary_in_r472007 = frozenset([1, 19])
    FOLLOW_19_in_r472010 = frozenset([10])
    FOLLOW_primary_in_r472015 = frozenset([1, 19])
    FOLLOW_19_in_r482039 = frozenset([4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45])
    FOLLOW_ID_in_r492066 = frozenset([1])
    FOLLOW_ID_in_r502083 = frozenset([1])
    FOLLOW_ID_in_r512123 = frozenset([10])
    FOLLOW_ID_in_r512127 = frozenset([10])
    FOLLOW_ID_in_r512129 = frozenset([1])
    FOLLOW_ID_in_r522167 = frozenset([1])
    FOLLOW_primary_in_r532192 = frozenset([1])
    FOLLOW_ID_in_r542230 = frozenset([12])
    FOLLOW_expression_in_r542234 = frozenset([10])
    FOLLOW_ID_in_r542236 = frozenset([1])
    FOLLOW_modifier_in_r552277 = frozenset([12, 39, 40])
    FOLLOW_expression_in_r552280 = frozenset([1])
    FOLLOW_modifier_in_r552288 = frozenset([33, 34, 39, 40])
    FOLLOW_statement_in_r552291 = frozenset([1])
    FOLLOW_ID_in_r562313 = frozenset([1, 10])
    FOLLOW_ID_in_r572340 = frozenset([1, 10])
    FOLLOW_ID_in_r592392 = frozenset([10, 33, 34])
    FOLLOW_statement_in_r592396 = frozenset([1])
    FOLLOW_ID_in_primary2423 = frozenset([1])
    FOLLOW_r1_in_expression2440 = frozenset([1])
    FOLLOW_modifier_in_modifiers2482 = frozenset([1, 39, 40])
    FOLLOW_modifier_in_synpred1_t042ast2270 = frozenset([12, 39, 40])
    FOLLOW_INT_in_synpred1_t042ast2273 = frozenset([1])



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import ParserMain
    main = ParserMain("t042astLexer", t042astParser)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
