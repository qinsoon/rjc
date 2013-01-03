# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t045dfabug.g 2013-01-03 10:51:43

import sys
from antlr3 import *
from antlr3.compat import set, frozenset

from antlr3.tree import *




# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EOF=-1
T__7=7
T__8=8
T__9=9
T__10=10
T__11=11
ID=4
INT=5
WS=6

# token names
tokenNames = [
    "<invalid>", "<EOR>", "<DOWN>", "<UP>",
    "ID", "INT", "WS", "'+'", "'fooze'", "'fooze2'", "'private'", "'public'"
]




class t045dfabugParser(Parser):
    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t045dfabug.g"
    api_version = 1
    tokenNames = tokenNames

    def __init__(self, input, state=None, *args, **kwargs):
        if state is None:
            state = RecognizerSharedState()

        super(t045dfabugParser, self).__init__(input, state, *args, **kwargs)

        self.dfa3 = self.DFA3(
            self, 3,
            eot = self.DFA3_eot,
            eof = self.DFA3_eof,
            min = self.DFA3_min,
            max = self.DFA3_max,
            accept = self.DFA3_accept,
            special = self.DFA3_special,
            transition = self.DFA3_transition
            )




        self.delegates = []

	self._adaptor = None
	self.adaptor = CommonTreeAdaptor()



    def getTreeAdaptor(self):
        return self._adaptor

    def setTreeAdaptor(self, adaptor):
        self._adaptor = adaptor

    adaptor = property(getTreeAdaptor, setTreeAdaptor)


    class r_return(ParserRuleReturnScope):
        def __init__(self):
            super(t045dfabugParser.r_return, self).__init__()

            self.tree = None





    # $ANTLR start "r"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t045dfabug.g:9:1: r options {backtrack=true; } : ( ( ( modifier )+ INT )=> ( modifier )+ expression | ( modifier )+ statement );
    def r(self, ):
        retval = self.r_return()
        retval.start = self.input.LT(1)


        root_0 = None

        modifier1 = None

        expression2 = None

        modifier3 = None

        statement4 = None



        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t045dfabug.g:11:5: ( ( ( modifier )+ INT )=> ( modifier )+ expression | ( modifier )+ statement )
                alt3 = 2
                alt3 = self.dfa3.predict(self.input)
                if alt3 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t045dfabug.g:11:7: ( ( modifier )+ INT )=> ( modifier )+ expression
                    pass 
                    root_0 = self._adaptor.nil()


                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t045dfabug.g:11:25: ( modifier )+
                    cnt1 = 0
                    while True: #loop1
                        alt1 = 2
                        LA1_0 = self.input.LA(1)

                        if ((10 <= LA1_0 <= 11)) :
                            alt1 = 1


                        if alt1 == 1:
                            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t045dfabug.g:11:25: modifier
                            pass 
                            self._state.following.append(self.FOLLOW_modifier_in_r59)
                            modifier1 = self.modifier()

                            self._state.following.pop()
                            if self._state.backtracking == 0:
                                self._adaptor.addChild(root_0, modifier1.tree)



                        else:
                            if cnt1 >= 1:
                                break #loop1

                            if self._state.backtracking > 0:
                                raise BacktrackingFailed


                            eee = EarlyExitException(1, self.input)
                            raise eee

                        cnt1 += 1


                    self._state.following.append(self.FOLLOW_expression_in_r62)
                    expression2 = self.expression()

                    self._state.following.pop()
                    if self._state.backtracking == 0:
                        self._adaptor.addChild(root_0, expression2.tree)



                elif alt3 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t045dfabug.g:12:7: ( modifier )+ statement
                    pass 
                    root_0 = self._adaptor.nil()


                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t045dfabug.g:12:7: ( modifier )+
                    cnt2 = 0
                    while True: #loop2
                        alt2 = 2
                        LA2_0 = self.input.LA(1)

                        if ((10 <= LA2_0 <= 11)) :
                            alt2 = 1


                        if alt2 == 1:
                            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t045dfabug.g:12:7: modifier
                            pass 
                            self._state.following.append(self.FOLLOW_modifier_in_r70)
                            modifier3 = self.modifier()

                            self._state.following.pop()
                            if self._state.backtracking == 0:
                                self._adaptor.addChild(root_0, modifier3.tree)



                        else:
                            if cnt2 >= 1:
                                break #loop2

                            if self._state.backtracking > 0:
                                raise BacktrackingFailed


                            eee = EarlyExitException(2, self.input)
                            raise eee

                        cnt2 += 1


                    self._state.following.append(self.FOLLOW_statement_in_r73)
                    statement4 = self.statement()

                    self._state.following.pop()
                    if self._state.backtracking == 0:
                        self._adaptor.addChild(root_0, statement4.tree)



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

    # $ANTLR end "r"


    class expression_return(ParserRuleReturnScope):
        def __init__(self):
            super(t045dfabugParser.expression_return, self).__init__()

            self.tree = None





    # $ANTLR start "expression"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t045dfabug.g:15:1: expression : INT '+' INT ;
    def expression(self, ):
        retval = self.expression_return()
        retval.start = self.input.LT(1)


        root_0 = None

        INT5 = None
        char_literal6 = None
        INT7 = None

        INT5_tree = None
        char_literal6_tree = None
        INT7_tree = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t045dfabug.g:16:5: ( INT '+' INT )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t045dfabug.g:16:7: INT '+' INT
                pass 
                root_0 = self._adaptor.nil()


                INT5 = self.match(self.input, INT, self.FOLLOW_INT_in_expression90)
                if self._state.backtracking == 0:
                    INT5_tree = self._adaptor.createWithPayload(INT5)
                    self._adaptor.addChild(root_0, INT5_tree)



                char_literal6 = self.match(self.input, 7, self.FOLLOW_7_in_expression92)
                if self._state.backtracking == 0:
                    char_literal6_tree = self._adaptor.createWithPayload(char_literal6)
                    self._adaptor.addChild(root_0, char_literal6_tree)



                INT7 = self.match(self.input, INT, self.FOLLOW_INT_in_expression94)
                if self._state.backtracking == 0:
                    INT7_tree = self._adaptor.createWithPayload(INT7)
                    self._adaptor.addChild(root_0, INT7_tree)





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
            super(t045dfabugParser.statement_return, self).__init__()

            self.tree = None





    # $ANTLR start "statement"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t045dfabug.g:19:1: statement : ( 'fooze' | 'fooze2' );
    def statement(self, ):
        retval = self.statement_return()
        retval.start = self.input.LT(1)


        root_0 = None

        set8 = None

        set8_tree = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t045dfabug.g:20:5: ( 'fooze' | 'fooze2' )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t045dfabug.g:
                pass 
                root_0 = self._adaptor.nil()


                set8 = self.input.LT(1)

                if (8 <= self.input.LA(1) <= 9):
                    self.input.consume()
                    if self._state.backtracking == 0:
                        self._adaptor.addChild(root_0, self._adaptor.createWithPayload(set8))

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


    class modifier_return(ParserRuleReturnScope):
        def __init__(self):
            super(t045dfabugParser.modifier_return, self).__init__()

            self.tree = None





    # $ANTLR start "modifier"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t045dfabug.g:24:1: modifier : ( 'public' | 'private' );
    def modifier(self, ):
        retval = self.modifier_return()
        retval.start = self.input.LT(1)


        root_0 = None

        set9 = None

        set9_tree = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t045dfabug.g:25:5: ( 'public' | 'private' )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t045dfabug.g:
                pass 
                root_0 = self._adaptor.nil()


                set9 = self.input.LT(1)

                if (10 <= self.input.LA(1) <= 11):
                    self.input.consume()
                    if self._state.backtracking == 0:
                        self._adaptor.addChild(root_0, self._adaptor.createWithPayload(set9))

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

    # $ANTLR start "synpred1_t045dfabug"
    def synpred1_t045dfabug_fragment(self, ):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t045dfabug.g:11:7: ( ( modifier )+ INT )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t045dfabug.g:11:8: ( modifier )+ INT
        pass 
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t045dfabug.g:11:8: ( modifier )+
        cnt4 = 0
        while True: #loop4
            alt4 = 2
            LA4_0 = self.input.LA(1)

            if ((10 <= LA4_0 <= 11)) :
                alt4 = 1


            if alt4 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t045dfabug.g:11:8: modifier
                pass 
                self._state.following.append(self.FOLLOW_modifier_in_synpred1_t045dfabug52)
                self.modifier()

                self._state.following.pop()


            else:
                if cnt4 >= 1:
                    break #loop4

                if self._state.backtracking > 0:
                    raise BacktrackingFailed


                eee = EarlyExitException(4, self.input)
                raise eee

            cnt4 += 1


        self.match(self.input, INT, self.FOLLOW_INT_in_synpred1_t045dfabug55)



    # $ANTLR end "synpred1_t045dfabug"




    def synpred1_t045dfabug(self):
        self._state.backtracking += 1
        start = self.input.mark()
        try:
            self.synpred1_t045dfabug_fragment()
        except BacktrackingFailed:
            success = False
        else:
            success = True
        self.input.rewind(start)
        self._state.backtracking -= 1
        return success



    # lookup tables for DFA #3

    DFA3_eot = DFA.unpack(
        u"\4\uffff"
        )

    DFA3_eof = DFA.unpack(
        u"\4\uffff"
        )

    DFA3_min = DFA.unpack(
        u"\1\12\1\5\2\uffff"
        )

    DFA3_max = DFA.unpack(
        u"\2\13\2\uffff"
        )

    DFA3_accept = DFA.unpack(
        u"\2\uffff\1\1\1\2"
        )

    DFA3_special = DFA.unpack(
        u"\1\uffff\1\0\2\uffff"
        )


    DFA3_transition = [
        DFA.unpack(u"\2\1"),
        DFA.unpack(u"\1\2\2\uffff\2\3\2\1"),
        DFA.unpack(u""),
        DFA.unpack(u"")
    ]

    # class definition for DFA #3

    class DFA3(DFA):
        pass


        def specialStateTransition(self_, s, input):
            # convince pylint that my self_ magic is ok ;)
            # pylint: disable-msg=E0213

            # pretend we are a member of the recognizer
            # thus semantic predicates can be evaluated
            self = self_.recognizer

            _s = s

            if s == 0: 
                LA3_1 = input.LA(1)

                 
                index3_1 = input.index()
                input.rewind()

                s = -1
                if (LA3_1 == INT) and (self.synpred1_t045dfabug()):
                    s = 2

                elif ((10 <= LA3_1 <= 11)):
                    s = 1

                elif ((8 <= LA3_1 <= 9)):
                    s = 3

                 
                input.seek(index3_1)

                if s >= 0:
                    return s

            if self._state.backtracking > 0:
                raise BacktrackingFailed

            nvae = NoViableAltException(self_.getDescription(), 3, _s, input)
            self_.error(nvae)
            raise nvae

 

    FOLLOW_modifier_in_r59 = frozenset([5, 10, 11])
    FOLLOW_expression_in_r62 = frozenset([1])
    FOLLOW_modifier_in_r70 = frozenset([8, 9, 10, 11])
    FOLLOW_statement_in_r73 = frozenset([1])
    FOLLOW_INT_in_expression90 = frozenset([7])
    FOLLOW_7_in_expression92 = frozenset([5])
    FOLLOW_INT_in_expression94 = frozenset([1])
    FOLLOW_modifier_in_synpred1_t045dfabug52 = frozenset([5, 10, 11])
    FOLLOW_INT_in_synpred1_t045dfabug55 = frozenset([1])



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import ParserMain
    main = ParserMain("t045dfabugLexer", t045dfabugParser)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
