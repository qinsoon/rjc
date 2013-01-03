# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t036multipleReturnValues.g 2013-01-03 10:52:05

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




class t036multipleReturnValuesParser(Parser):
    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t036multipleReturnValues.g"
    api_version = 1
    tokenNames = tokenNames

    def __init__(self, input, state=None, *args, **kwargs):
        if state is None:
            state = RecognizerSharedState()

        super(t036multipleReturnValuesParser, self).__init__(input, state, *args, **kwargs)




        self.delegates = []





    class a_return(ParserRuleReturnScope):
        def __init__(self):
            super(t036multipleReturnValuesParser.a_return, self).__init__()

            self.foo = None
            self.bar = None





    # $ANTLR start "a"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t036multipleReturnValues.g:6:1: a returns [foo, bar] : A ;
    def a(self, ):
        retval = self.a_return()
        retval.start = self.input.LT(1)


        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t036multipleReturnValues.g:6:21: ( A )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t036multipleReturnValues.g:6:23: A
                pass 
                self.match(self.input, A, self.FOLLOW_A_in_a26)

                #action start
                        
                retval.foo =  "foo"
                retval.bar =  "bar"
                        
                #action end




                retval.stop = self.input.LT(-1)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return retval

    # $ANTLR end "a"



 

    FOLLOW_A_in_a26 = frozenset([1])



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import ParserMain
    main = ParserMain("t036multipleReturnValuesLexer", t036multipleReturnValuesParser)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
