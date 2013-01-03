# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t041parameters.g 2013-01-03 10:51:55

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




class t041parametersParser(Parser):
    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t041parameters.g"
    api_version = 1
    tokenNames = tokenNames

    def __init__(self, input, state=None, *args, **kwargs):
        if state is None:
            state = RecognizerSharedState()

        super(t041parametersParser, self).__init__(input, state, *args, **kwargs)




        self.delegates = []






    # $ANTLR start "a"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t041parameters.g:6:1: a[arg1, arg2] returns [l] : ( A )+ EOF ;
    def a(self, arg1, arg2):
        l = None


        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t041parameters.g:7:5: ( ( A )+ EOF )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t041parameters.g:7:7: ( A )+ EOF
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t041parameters.g:7:7: ( A )+
                cnt1 = 0
                while True: #loop1
                    alt1 = 2
                    LA1_0 = self.input.LA(1)

                    if (LA1_0 == A) :
                        alt1 = 1


                    if alt1 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t041parameters.g:7:7: A
                        pass 
                        self.match(self.input, A, self.FOLLOW_A_in_a32)


                    else:
                        if cnt1 >= 1:
                            break #loop1

                        eee = EarlyExitException(1, self.input)
                        raise eee

                    cnt1 += 1


                self.match(self.input, EOF, self.FOLLOW_EOF_in_a35)

                #action start
                         
                l = (arg1, arg2) 
                arg1 = "gnarz"
                        
                #action end





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return l

    # $ANTLR end "a"



 

    FOLLOW_A_in_a32 = frozenset([4])
    FOLLOW_EOF_in_a35 = frozenset([1])



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import ParserMain
    main = ParserMain("t041parametersLexer", t041parametersParser)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
