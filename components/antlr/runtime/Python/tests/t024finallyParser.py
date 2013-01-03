# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t024finally.g 2013-01-03 10:52:30

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




class t024finallyParser(Parser):
    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t024finally.g"
    api_version = 1
    tokenNames = tokenNames

    def __init__(self, input, state=None, *args, **kwargs):
        if state is None:
            state = RecognizerSharedState()

        super(t024finallyParser, self).__init__(input, state, *args, **kwargs)




        self.delegates = []






    # $ANTLR start "prog"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t024finally.g:7:1: prog returns [events] : ID ;
    def prog(self, ):
        events = None


        events = []
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t024finally.g:10:5: ( ID )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t024finally.g:10:9: ID
                pass 
                self.match(self.input, ID, self.FOLLOW_ID_in_prog44)

                #action start
                raise RuntimeError
                #action end




                #action start
                events.append('after')
                #action end


            except RuntimeError:
                events.append('catch')


        finally:
            events.append('finally')
            pass
        return events

    # $ANTLR end "prog"



 

    FOLLOW_ID_in_prog44 = frozenset([1])



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import ParserMain
    main = ParserMain("t024finallyLexer", t024finallyParser)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
