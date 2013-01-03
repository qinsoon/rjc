# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g 2013-01-03 10:51:48

import sys
from antlr3 import *
from antlr3.compat import set, frozenset



# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EOF=-1
T__7=7
E=4
P=5
S=6

# token names
tokenNames = [
    "<invalid>", "<EOR>", "<DOWN>", "<UP>",
    "E", "P", "S", "'foo'"
]




class t043synpredParser(Parser):
    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g"
    api_version = 1
    tokenNames = tokenNames

    def __init__(self, input, state=None, *args, **kwargs):
        if state is None:
            state = RecognizerSharedState()

        super(t043synpredParser, self).__init__(input, state, *args, **kwargs)




        self.delegates = []






    # $ANTLR start "a"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g:6:1: a : ( ( ( s )+ P )=> ( s )+ b )? E ;
    def a(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g:6:2: ( ( ( ( s )+ P )=> ( s )+ b )? E )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g:6:4: ( ( ( s )+ P )=> ( s )+ b )? E
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g:6:4: ( ( ( s )+ P )=> ( s )+ b )?
                alt2 = 2
                LA2_0 = self.input.LA(1)

                if (LA2_0 == S) and (self.synpred1_t043synpred()):
                    alt2 = 1
                if alt2 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g:6:5: ( ( s )+ P )=> ( s )+ b
                    pass 
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g:6:14: ( s )+
                    cnt1 = 0
                    while True: #loop1
                        alt1 = 2
                        LA1_0 = self.input.LA(1)

                        if (LA1_0 == S) :
                            alt1 = 1


                        if alt1 == 1:
                            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g:6:14: s
                            pass 
                            self._state.following.append(self.FOLLOW_s_in_a31)
                            self.s()

                            self._state.following.pop()


                        else:
                            if cnt1 >= 1:
                                break #loop1

                            if self._state.backtracking > 0:
                                raise BacktrackingFailed


                            eee = EarlyExitException(1, self.input)
                            raise eee

                        cnt1 += 1


                    self._state.following.append(self.FOLLOW_b_in_a34)
                    self.b()

                    self._state.following.pop()




                self.match(self.input, E, self.FOLLOW_E_in_a38)




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "a"



    # $ANTLR start "b"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g:7:1: b : P 'foo' ;
    def b(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g:7:2: ( P 'foo' )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g:7:4: P 'foo'
                pass 
                self.match(self.input, P, self.FOLLOW_P_in_b44)

                self.match(self.input, 7, self.FOLLOW_7_in_b46)




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "b"



    # $ANTLR start "s"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g:9:1: s : S ;
    def s(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g:9:2: ( S )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g:9:4: S
                pass 
                self.match(self.input, S, self.FOLLOW_S_in_s53)




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "s"

    # $ANTLR start "synpred1_t043synpred"
    def synpred1_t043synpred_fragment(self, ):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g:6:5: ( ( s )+ P )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g:6:6: ( s )+ P
        pass 
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g:6:6: ( s )+
        cnt3 = 0
        while True: #loop3
            alt3 = 2
            LA3_0 = self.input.LA(1)

            if (LA3_0 == S) :
                alt3 = 1


            if alt3 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g:6:6: s
                pass 
                self._state.following.append(self.FOLLOW_s_in_synpred1_t043synpred24)
                self.s()

                self._state.following.pop()


            else:
                if cnt3 >= 1:
                    break #loop3

                if self._state.backtracking > 0:
                    raise BacktrackingFailed


                eee = EarlyExitException(3, self.input)
                raise eee

            cnt3 += 1


        self.match(self.input, P, self.FOLLOW_P_in_synpred1_t043synpred27)



    # $ANTLR end "synpred1_t043synpred"




    def synpred1_t043synpred(self):
        self._state.backtracking += 1
        start = self.input.mark()
        try:
            self.synpred1_t043synpred_fragment()
        except BacktrackingFailed:
            success = False
        else:
            success = True
        self.input.rewind(start)
        self._state.backtracking -= 1
        return success



 

    FOLLOW_s_in_a31 = frozenset([5, 6])
    FOLLOW_b_in_a34 = frozenset([4])
    FOLLOW_E_in_a38 = frozenset([1])
    FOLLOW_P_in_b44 = frozenset([7])
    FOLLOW_7_in_b46 = frozenset([1])
    FOLLOW_S_in_s53 = frozenset([1])
    FOLLOW_s_in_synpred1_t043synpred24 = frozenset([5, 6])
    FOLLOW_P_in_synpred1_t043synpred27 = frozenset([1])



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import ParserMain
    main = ParserMain("t043synpredLexer", t043synpredParser)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
