# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t032subrulePredict.g 2013-01-03 10:52:16

import sys
from antlr3 import *
from antlr3.compat import set, frozenset



# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EOF=-1
T__5=5
T__6=6
T__7=7
WS=4

# token names
tokenNames = [
    "<invalid>", "<EOR>", "<DOWN>", "<UP>",
    "WS", "'A'", "'BEGIN'", "'END'"
]




class t032subrulePredictParser(Parser):
    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t032subrulePredict.g"
    api_version = 1
    tokenNames = tokenNames

    def __init__(self, input, state=None, *args, **kwargs):
        if state is None:
            state = RecognizerSharedState()

        super(t032subrulePredictParser, self).__init__(input, state, *args, **kwargs)

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






    # $ANTLR start "a"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t032subrulePredict.g:6:1: a : 'BEGIN' b ( WS )+ 'END' ;
    def a(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t032subrulePredict.g:6:2: ( 'BEGIN' b ( WS )+ 'END' )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t032subrulePredict.g:6:4: 'BEGIN' b ( WS )+ 'END'
                pass 
                self.match(self.input, 6, self.FOLLOW_6_in_a22)

                self._state.following.append(self.FOLLOW_b_in_a24)
                self.b()

                self._state.following.pop()

                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t032subrulePredict.g:6:14: ( WS )+
                cnt1 = 0
                while True: #loop1
                    alt1 = 2
                    LA1_0 = self.input.LA(1)

                    if (LA1_0 == WS) :
                        alt1 = 1


                    if alt1 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t032subrulePredict.g:6:14: WS
                        pass 
                        self.match(self.input, WS, self.FOLLOW_WS_in_a26)


                    else:
                        if cnt1 >= 1:
                            break #loop1

                        eee = EarlyExitException(1, self.input)
                        raise eee

                    cnt1 += 1


                self.match(self.input, 7, self.FOLLOW_7_in_a29)




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "a"



    # $ANTLR start "b"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t032subrulePredict.g:7:1: b : ( ( WS )+ 'A' )+ ;
    def b(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t032subrulePredict.g:7:2: ( ( ( WS )+ 'A' )+ )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t032subrulePredict.g:7:4: ( ( WS )+ 'A' )+
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t032subrulePredict.g:7:4: ( ( WS )+ 'A' )+
                cnt3 = 0
                while True: #loop3
                    alt3 = 2
                    alt3 = self.dfa3.predict(self.input)
                    if alt3 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t032subrulePredict.g:7:6: ( WS )+ 'A'
                        pass 
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t032subrulePredict.g:7:6: ( WS )+
                        cnt2 = 0
                        while True: #loop2
                            alt2 = 2
                            LA2_0 = self.input.LA(1)

                            if (LA2_0 == WS) :
                                alt2 = 1


                            if alt2 == 1:
                                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t032subrulePredict.g:7:6: WS
                                pass 
                                self.match(self.input, WS, self.FOLLOW_WS_in_b37)


                            else:
                                if cnt2 >= 1:
                                    break #loop2

                                eee = EarlyExitException(2, self.input)
                                raise eee

                            cnt2 += 1


                        self.match(self.input, 5, self.FOLLOW_5_in_b40)


                    else:
                        if cnt3 >= 1:
                            break #loop3

                        eee = EarlyExitException(3, self.input)
                        raise eee

                    cnt3 += 1





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "b"



    # lookup tables for DFA #3

    DFA3_eot = DFA.unpack(
        u"\4\uffff"
        )

    DFA3_eof = DFA.unpack(
        u"\4\uffff"
        )

    DFA3_min = DFA.unpack(
        u"\2\4\2\uffff"
        )

    DFA3_max = DFA.unpack(
        u"\1\4\1\7\2\uffff"
        )

    DFA3_accept = DFA.unpack(
        u"\2\uffff\1\2\1\1"
        )

    DFA3_special = DFA.unpack(
        u"\4\uffff"
        )


    DFA3_transition = [
        DFA.unpack(u"\1\1"),
        DFA.unpack(u"\1\1\1\3\1\uffff\1\2"),
        DFA.unpack(u""),
        DFA.unpack(u"")
    ]

    # class definition for DFA #3

    class DFA3(DFA):
        pass


 

    FOLLOW_6_in_a22 = frozenset([4])
    FOLLOW_b_in_a24 = frozenset([4])
    FOLLOW_WS_in_a26 = frozenset([4, 7])
    FOLLOW_7_in_a29 = frozenset([1])
    FOLLOW_WS_in_b37 = frozenset([4, 5])
    FOLLOW_5_in_b40 = frozenset([1, 4])



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import ParserMain
    main = ParserMain("t032subrulePredictLexer", t032subrulePredictParser)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
