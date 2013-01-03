# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g 2013-01-03 10:51:59

import sys
from antlr3 import *
from antlr3.compat import set, frozenset



# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EOF=-1
T__11=11
A=4
B=5
C=6
D=7
E=8
F=9
WS=10

# token names
tokenNames = [
    "<invalid>", "<EOR>", "<DOWN>", "<UP>",
    "A", "B", "C", "D", "E", "F", "WS", "','"
]




class t039labelsParser(Parser):
    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g"
    api_version = 1
    tokenNames = tokenNames

    def __init__(self, input, state=None, *args, **kwargs):
        if state is None:
            state = RecognizerSharedState()

        super(t039labelsParser, self).__init__(input, state, *args, **kwargs)




        self.delegates = []






    # $ANTLR start "a"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:6:1: a returns [l] :ids+= A ( ',' ids+= ( A | B ) )* C D w= . ids+= . F EOF ;
    def a(self, ):
        l = None


        w = None
        ids = None
        list_ids = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:7:5: (ids+= A ( ',' ids+= ( A | B ) )* C D w= . ids+= . F EOF )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:7:7: ids+= A ( ',' ids+= ( A | B ) )* C D w= . ids+= . F EOF
                pass 
                ids = self.match(self.input, A, self.FOLLOW_A_in_a33)
                if list_ids is None:
                    list_ids = []
                list_ids.append(ids)


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:7:14: ( ',' ids+= ( A | B ) )*
                while True: #loop1
                    alt1 = 2
                    LA1_0 = self.input.LA(1)

                    if (LA1_0 == 11) :
                        alt1 = 1


                    if alt1 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:7:16: ',' ids+= ( A | B )
                        pass 
                        self.match(self.input, 11, self.FOLLOW_11_in_a37)

                        ids = self.input.LT(1)

                        if (A <= self.input.LA(1) <= B):
                            self.input.consume()
                            self._state.errorRecovery = False


                        else:
                            mse = MismatchedSetException(None, self.input)
                            raise mse


                        if list_ids is None:
                            list_ids = []
                        list_ids.append(ids)



                    else:
                        break #loop1


                self.match(self.input, C, self.FOLLOW_C_in_a50)

                self.match(self.input, D, self.FOLLOW_D_in_a52)

                w = self.input.LT(1)

                self.matchAny(self.input)

                ids = self.input.LT(1)

                self.matchAny(self.input)
                if list_ids is None:
                    list_ids = []
                list_ids.append(ids)


                self.match(self.input, F, self.FOLLOW_F_in_a62)

                self.match(self.input, EOF, self.FOLLOW_EOF_in_a64)

                #action start
                l = (list_ids, w) 
                #action end





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return l

    # $ANTLR end "a"



 

    FOLLOW_A_in_a33 = frozenset([6, 11])
    FOLLOW_11_in_a37 = frozenset([4, 5])
    FOLLOW_set_in_a41 = frozenset([6, 11])
    FOLLOW_C_in_a50 = frozenset([7])
    FOLLOW_D_in_a52 = frozenset([4, 5, 6, 7, 8, 9, 10, 11])
    FOLLOW_F_in_a62 = frozenset([])
    FOLLOW_EOF_in_a64 = frozenset([1])



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import ParserMain
    main = ParserMain("t039labelsLexer", t039labelsParser)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
