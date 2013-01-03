# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t023scopes.g 2013-01-03 10:52:33

import sys
from antlr3 import *
from antlr3.compat import set, frozenset



# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EOF=-1
ID=4
WS=5

# token names
tokenNames = [
    "<invalid>", "<EOR>", "<DOWN>", "<UP>",
    "ID", "WS"
]



class prog_scope(object):
    def __init__(self):
        self.name = None



class t023scopesParser(Parser):
    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t023scopes.g"
    api_version = 1
    tokenNames = tokenNames

    def __init__(self, input, state=None, *args, **kwargs):
        if state is None:
            state = RecognizerSharedState()

        super(t023scopesParser, self).__init__(input, state, *args, **kwargs)


	self.prog_stack = []




        self.delegates = []






    # $ANTLR start "prog"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t023scopes.g:7:1: prog : ID ;
    def prog(self, ):
        self.prog_stack.append(prog_scope())
        ID1 = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t023scopes.g:11:5: ( ID )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t023scopes.g:11:9: ID
                pass 
                ID1 = self.match(self.input, ID, self.FOLLOW_ID_in_prog34)

                #action start
                self.prog_stack[-1].name = ID1.text
                #action end





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            self.prog_stack.pop()
            pass
        return 

    # $ANTLR end "prog"



 

    FOLLOW_ID_in_prog34 = frozenset([1])



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import ParserMain
    main = ParserMain("t023scopesLexer", t023scopesParser)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
