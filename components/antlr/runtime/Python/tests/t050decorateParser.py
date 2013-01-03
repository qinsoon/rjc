# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t050decorate.g 2013-01-03 10:51:23

import sys
from antlr3 import *
from antlr3.compat import set, frozenset

        
def logme(func):
    def decorated(self, *args, **kwargs):
        self.events.append('before')
        try:
            return func(self, *args, **kwargs)
        finally:
            self.events.append('after')

    return decorated



# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EOF=-1
IDENTIFIER=4

# token names
tokenNames = [
    "<invalid>", "<EOR>", "<DOWN>", "<UP>",
    "IDENTIFIER"
]




class t050decorateParser(Parser):
    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t050decorate.g"
    api_version = 1
    tokenNames = tokenNames

    def __init__(self, input, state=None, *args, **kwargs):
        if state is None:
            state = RecognizerSharedState()

        super(t050decorateParser, self).__init__(input, state, *args, **kwargs)



                      
        self.events = []


        self.delegates = []






    # $ANTLR start "document"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t050decorate.g:22:1: document : IDENTIFIER ;
              
    @logme

    def document(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t050decorate.g:26:5: ( IDENTIFIER )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t050decorate.g:26:7: IDENTIFIER
                pass 
                self.match(self.input, IDENTIFIER, self.FOLLOW_IDENTIFIER_in_document47)




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "document"



 

    FOLLOW_IDENTIFIER_in_document47 = frozenset([1])



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import ParserMain
    main = ParserMain("t050decorateLexer", t050decorateParser)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
