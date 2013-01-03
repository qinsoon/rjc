# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t030specialStates.g 2013-01-03 10:52:20

import sys
from antlr3 import *
from antlr3.compat import set, frozenset



# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EOF=-1
NAME=4
NUMBER=5
WS=6

# token names
tokenNames = [
    "<invalid>", "<EOR>", "<DOWN>", "<UP>",
    "NAME", "NUMBER", "WS"
]




class t030specialStatesParser(Parser):
    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t030specialStates.g"
    api_version = 1
    tokenNames = tokenNames

    def __init__(self, input, state=None, *args, **kwargs):
        if state is None:
            state = RecognizerSharedState()

        super(t030specialStatesParser, self).__init__(input, state, *args, **kwargs)

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



              
        self.cond = True


        self.delegates = []




             
    def recover(self, input, re):
        # no error recovery yet, just crash!
        raise re



    # $ANTLR start "r"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t030specialStates.g:16:1: r : ({...}? NAME |{...}? NAME ( WS )+ NAME ) ( ( WS )+ NAME )? EOF ;
    def r(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t030specialStates.g:17:5: ( ({...}? NAME |{...}? NAME ( WS )+ NAME ) ( ( WS )+ NAME )? EOF )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t030specialStates.g:17:7: ({...}? NAME |{...}? NAME ( WS )+ NAME ) ( ( WS )+ NAME )? EOF
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t030specialStates.g:17:7: ({...}? NAME |{...}? NAME ( WS )+ NAME )
                alt2 = 2
                alt2 = self.dfa2.predict(self.input)
                if alt2 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t030specialStates.g:17:9: {...}? NAME
                    pass 
                    if not ((self.cond)):
                        raise FailedPredicateException(self.input, "r", "self.cond")


                    self.match(self.input, NAME, self.FOLLOW_NAME_in_r43)


                elif alt2 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t030specialStates.g:18:11: {...}? NAME ( WS )+ NAME
                    pass 
                    if not ((not self.cond)):
                        raise FailedPredicateException(self.input, "r", "not self.cond")


                    self.match(self.input, NAME, self.FOLLOW_NAME_in_r57)

                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t030specialStates.g:18:33: ( WS )+
                    cnt1 = 0
                    while True: #loop1
                        alt1 = 2
                        LA1_0 = self.input.LA(1)

                        if (LA1_0 == WS) :
                            alt1 = 1


                        if alt1 == 1:
                            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t030specialStates.g:18:33: WS
                            pass 
                            self.match(self.input, WS, self.FOLLOW_WS_in_r59)


                        else:
                            if cnt1 >= 1:
                                break #loop1

                            eee = EarlyExitException(1, self.input)
                            raise eee

                        cnt1 += 1


                    self.match(self.input, NAME, self.FOLLOW_NAME_in_r62)




                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t030specialStates.g:20:9: ( ( WS )+ NAME )?
                alt4 = 2
                LA4_0 = self.input.LA(1)

                if (LA4_0 == WS) :
                    alt4 = 1
                if alt4 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t030specialStates.g:20:11: ( WS )+ NAME
                    pass 
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t030specialStates.g:20:11: ( WS )+
                    cnt3 = 0
                    while True: #loop3
                        alt3 = 2
                        LA3_0 = self.input.LA(1)

                        if (LA3_0 == WS) :
                            alt3 = 1


                        if alt3 == 1:
                            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t030specialStates.g:20:11: WS
                            pass 
                            self.match(self.input, WS, self.FOLLOW_WS_in_r84)


                        else:
                            if cnt3 >= 1:
                                break #loop3

                            eee = EarlyExitException(3, self.input)
                            raise eee

                        cnt3 += 1


                    self.match(self.input, NAME, self.FOLLOW_NAME_in_r87)




                self.match(self.input, EOF, self.FOLLOW_EOF_in_r100)




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "r"



    # lookup tables for DFA #2

    DFA2_eot = DFA.unpack(
        u"\6\uffff"
        )

    DFA2_eof = DFA.unpack(
        u"\1\uffff\1\3\4\uffff"
        )

    DFA2_min = DFA.unpack(
        u"\1\4\1\6\1\4\1\uffff\1\0\1\uffff"
        )

    DFA2_max = DFA.unpack(
        u"\1\4\2\6\1\uffff\1\0\1\uffff"
        )

    DFA2_accept = DFA.unpack(
        u"\3\uffff\1\1\1\uffff\1\2"
        )

    DFA2_special = DFA.unpack(
        u"\4\uffff\1\0\1\uffff"
        )


    DFA2_transition = [
        DFA.unpack(u"\1\1"),
        DFA.unpack(u"\1\2"),
        DFA.unpack(u"\1\4\1\uffff\1\2"),
        DFA.unpack(u""),
        DFA.unpack(u"\1\uffff"),
        DFA.unpack(u"")
    ]

    # class definition for DFA #2

    class DFA2(DFA):
        pass


        def specialStateTransition(self_, s, input):
            # convince pylint that my self_ magic is ok ;)
            # pylint: disable-msg=E0213

            # pretend we are a member of the recognizer
            # thus semantic predicates can be evaluated
            self = self_.recognizer

            _s = s

            if s == 0: 
                LA2_4 = input.LA(1)

                 
                index2_4 = input.index()
                input.rewind()

                s = -1
                if ((self.cond)):
                    s = 3

                elif ((not self.cond)):
                    s = 5

                 
                input.seek(index2_4)

                if s >= 0:
                    return s

            nvae = NoViableAltException(self_.getDescription(), 2, _s, input)
            self_.error(nvae)
            raise nvae

 

    FOLLOW_NAME_in_r43 = frozenset([6])
    FOLLOW_NAME_in_r57 = frozenset([6])
    FOLLOW_WS_in_r59 = frozenset([4, 6])
    FOLLOW_NAME_in_r62 = frozenset([6])
    FOLLOW_WS_in_r84 = frozenset([4, 6])
    FOLLOW_NAME_in_r87 = frozenset([])
    FOLLOW_EOF_in_r100 = frozenset([1])



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import ParserMain
    main = ParserMain("t030specialStatesLexer", t030specialStatesParser)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
