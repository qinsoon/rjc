# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t034tokenLabelPropertyRef.g 2013-01-03 10:52:10

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




class t034tokenLabelPropertyRefParser(Parser):
    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t034tokenLabelPropertyRef.g"
    api_version = 1
    tokenNames = tokenNames

    def __init__(self, input, state=None, *args, **kwargs):
        if state is None:
            state = RecognizerSharedState()

        super(t034tokenLabelPropertyRefParser, self).__init__(input, state, *args, **kwargs)




        self.delegates = []






    # $ANTLR start "a"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t034tokenLabelPropertyRef.g:6:1: a : t= A ;
    def a(self, ):
        t = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t034tokenLabelPropertyRef.g:6:2: (t= A )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t034tokenLabelPropertyRef.g:6:4: t= A
                pass 
                t = self.match(self.input, A, self.FOLLOW_A_in_a24)

                #action start
                        
                print t.text
                print t.type
                print t.line
                print t.charPositionInLine
                print t.channel
                print t.index
                #print t_tree
                        
                #action end





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "a"



 

    FOLLOW_A_in_a24 = frozenset([1])



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import ParserMain
    main = ParserMain("t034tokenLabelPropertyRefLexer", t034tokenLabelPropertyRefParser)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
