# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t037rulePropertyRef.g 2013-01-03 10:52:03

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




class t037rulePropertyRefParser(Parser):
    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t037rulePropertyRef.g"
    api_version = 1
    tokenNames = tokenNames

    def __init__(self, input, state=None, *args, **kwargs):
        if state is None:
            state = RecognizerSharedState()

        super(t037rulePropertyRefParser, self).__init__(input, state, *args, **kwargs)




        self.delegates = []





    class a_return(ParserRuleReturnScope):
        def __init__(self):
            super(t037rulePropertyRefParser.a_return, self).__init__()

            self.bla = None





    # $ANTLR start "a"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t037rulePropertyRef.g:6:1: a returns [bla] : ( A )+ ;
    def a(self, ):
        retval = self.a_return()
        retval.start = self.input.LT(1)


        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t037rulePropertyRef.g:10:5: ( ( A )+ )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t037rulePropertyRef.g:10:7: ( A )+
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t037rulePropertyRef.g:10:7: ( A )+
                cnt1 = 0
                while True: #loop1
                    alt1 = 2
                    LA1_0 = self.input.LA(1)

                    if (LA1_0 == A) :
                        alt1 = 1


                    if alt1 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t037rulePropertyRef.g:10:7: A
                        pass 
                        self.match(self.input, A, self.FOLLOW_A_in_a36)


                    else:
                        if cnt1 >= 1:
                            break #loop1

                        eee = EarlyExitException(1, self.input)
                        raise eee

                    cnt1 += 1




                retval.stop = self.input.LT(-1)



                #action start
                       
                retval.bla = retval.start, retval.stop, self.input.toString(retval.start, self.input.LT(-1))

                #action end


            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return retval

    # $ANTLR end "a"



 

    FOLLOW_A_in_a36 = frozenset([1, 4])



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import ParserMain
    main = ParserMain("t037rulePropertyRefLexer", t037rulePropertyRefParser)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
