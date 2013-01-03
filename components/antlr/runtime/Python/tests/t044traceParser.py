# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t044trace.g 2013-01-03 10:51:45

import sys
from antlr3 import *
from antlr3.compat import set, frozenset



# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EOF=-1
T__6=6
T__7=7
T__8=8
INT=4
WS=5

# token names
tokenNames = [
    "<invalid>", "<EOR>", "<DOWN>", "<UP>",
    "INT", "WS", "'+'", "'<'", "'>'"
]




class t044traceParser(Parser):
    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t044trace.g"
    api_version = 1
    tokenNames = tokenNames

    def __init__(self, input, state=None, *args, **kwargs):
        if state is None:
            state = RecognizerSharedState()

        super(t044traceParser, self).__init__(input, state, *args, **kwargs)



              
        self._stack = None


        self.delegates = []






    # $ANTLR start "a"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t044trace.g:10:1: a : '<' ( ( INT '+' )=> b | c ) '>' ;
    def a(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t044trace.g:10:2: ( '<' ( ( INT '+' )=> b | c ) '>' )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t044trace.g:10:4: '<' ( ( INT '+' )=> b | c ) '>'
                pass 
                self.match(self.input, 7, self.FOLLOW_7_in_a28)

                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t044trace.g:10:8: ( ( INT '+' )=> b | c )
                alt1 = 2
                LA1_0 = self.input.LA(1)

                if (LA1_0 == INT) :
                    LA1_1 = self.input.LA(2)

                    if (self.synpred1_t044trace()) :
                        alt1 = 1
                    elif (True) :
                        alt1 = 2
                    else:
                        if self._state.backtracking > 0:
                            raise BacktrackingFailed


                        nvae = NoViableAltException("", 1, 1, self.input)

                        raise nvae


                else:
                    if self._state.backtracking > 0:
                        raise BacktrackingFailed


                    nvae = NoViableAltException("", 1, 0, self.input)

                    raise nvae


                if alt1 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t044trace.g:10:9: ( INT '+' )=> b
                    pass 
                    self._state.following.append(self.FOLLOW_b_in_a37)
                    self.b()

                    self._state.following.pop()


                elif alt1 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t044trace.g:10:22: c
                    pass 
                    self._state.following.append(self.FOLLOW_c_in_a39)
                    self.c()

                    self._state.following.pop()




                self.match(self.input, 8, self.FOLLOW_8_in_a42)




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "a"



    # $ANTLR start "b"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t044trace.g:11:1: b : c ( '+' c )* ;
    def b(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t044trace.g:11:2: ( c ( '+' c )* )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t044trace.g:11:4: c ( '+' c )*
                pass 
                self._state.following.append(self.FOLLOW_c_in_b48)
                self.c()

                self._state.following.pop()

                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t044trace.g:11:6: ( '+' c )*
                while True: #loop2
                    alt2 = 2
                    LA2_0 = self.input.LA(1)

                    if (LA2_0 == 6) :
                        alt2 = 1


                    if alt2 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t044trace.g:11:7: '+' c
                        pass 
                        self.match(self.input, 6, self.FOLLOW_6_in_b51)

                        self._state.following.append(self.FOLLOW_c_in_b53)
                        self.c()

                        self._state.following.pop()


                    else:
                        break #loop2





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "b"



    # $ANTLR start "c"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t044trace.g:12:1: c : INT ;
    def c(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t044trace.g:12:2: ( INT )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t044trace.g:12:4: INT
                pass 
                self.match(self.input, INT, self.FOLLOW_INT_in_c61)

                if self._state.backtracking == 0:
                    pass
                        
                    if self._stack is None:
                        self._stack = self.getRuleInvocationStack()
                        






            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "c"

    # $ANTLR start "synpred1_t044trace"
    def synpred1_t044trace_fragment(self, ):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t044trace.g:10:9: ( INT '+' )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t044trace.g:10:10: INT '+'
        pass 
        self.match(self.input, INT, self.FOLLOW_INT_in_synpred1_t044trace32)

        self.match(self.input, 6, self.FOLLOW_6_in_synpred1_t044trace34)



    # $ANTLR end "synpred1_t044trace"




    def synpred1_t044trace(self):
        self._state.backtracking += 1
        start = self.input.mark()
        try:
            self.synpred1_t044trace_fragment()
        except BacktrackingFailed:
            success = False
        else:
            success = True
        self.input.rewind(start)
        self._state.backtracking -= 1
        return success



 

    FOLLOW_7_in_a28 = frozenset([4])
    FOLLOW_b_in_a37 = frozenset([8])
    FOLLOW_c_in_a39 = frozenset([8])
    FOLLOW_8_in_a42 = frozenset([1])
    FOLLOW_c_in_b48 = frozenset([1, 6])
    FOLLOW_6_in_b51 = frozenset([4])
    FOLLOW_c_in_b53 = frozenset([1, 6])
    FOLLOW_INT_in_c61 = frozenset([1])
    FOLLOW_INT_in_synpred1_t044trace32 = frozenset([6])
    FOLLOW_6_in_synpred1_t044trace34 = frozenset([1])



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import ParserMain
    main = ParserMain("t044traceLexer", t044traceParser)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
