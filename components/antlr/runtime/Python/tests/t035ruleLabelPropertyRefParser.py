# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t035ruleLabelPropertyRef.g 2013-01-03 10:52:07

import sys
from antlr3 import *
from antlr3.compat import set, frozenset



# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EOF=-1
A=4
WS=5

# token names
tokenNames = [
    "<invalid>", "<EOR>", "<DOWN>", "<UP>",
    "A", "WS"
]




class t035ruleLabelPropertyRefParser(Parser):
    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t035ruleLabelPropertyRef.g"
    api_version = 1
    tokenNames = tokenNames

    def __init__(self, input, state=None, *args, **kwargs):
        if state is None:
            state = RecognizerSharedState()

        super(t035ruleLabelPropertyRefParser, self).__init__(input, state, *args, **kwargs)




        self.delegates = []






    # $ANTLR start "a"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t035ruleLabelPropertyRef.g:6:1: a returns [bla] : t= b ;
    def a(self, ):
        bla = None


        t = None


        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t035ruleLabelPropertyRef.g:6:16: (t= b )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t035ruleLabelPropertyRef.g:6:18: t= b
                pass 
                self._state.following.append(self.FOLLOW_b_in_a28)
                t = self.b()

                self._state.following.pop()

                #action start
                        
                bla = t.start, t.stop, ((t is not None) and [self.input.toString(t.start,t.stop)] or [None])[0]
                        
                #action end





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return bla

    # $ANTLR end "a"


    class b_return(ParserRuleReturnScope):
        def __init__(self):
            super(t035ruleLabelPropertyRefParser.b_return, self).__init__()






    # $ANTLR start "b"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t035ruleLabelPropertyRef.g:12:1: b : ( A )+ ;
    def b(self, ):
        retval = self.b_return()
        retval.start = self.input.LT(1)


        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t035ruleLabelPropertyRef.g:12:2: ( ( A )+ )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t035ruleLabelPropertyRef.g:12:4: ( A )+
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t035ruleLabelPropertyRef.g:12:4: ( A )+
                cnt1 = 0
                while True: #loop1
                    alt1 = 2
                    LA1_0 = self.input.LA(1)

                    if (LA1_0 == A) :
                        alt1 = 1


                    if alt1 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t035ruleLabelPropertyRef.g:12:4: A
                        pass 
                        self.match(self.input, A, self.FOLLOW_A_in_b50)


                    else:
                        if cnt1 >= 1:
                            break #loop1

                        eee = EarlyExitException(1, self.input)
                        raise eee

                    cnt1 += 1




                retval.stop = self.input.LT(-1)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return retval

    # $ANTLR end "b"



 

    FOLLOW_b_in_a28 = frozenset([1])
    FOLLOW_A_in_b50 = frozenset([1, 4])



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import ParserMain
    main = ParserMain("t035ruleLabelPropertyRefLexer", t035ruleLabelPropertyRefParser)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
