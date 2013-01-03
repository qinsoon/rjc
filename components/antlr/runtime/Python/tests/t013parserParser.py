# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t013parser.g 2013-01-03 10:53:04

import sys
from antlr3 import *
from antlr3.compat import set, frozenset



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




class t013parserParser(Parser):
    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t013parser.g"
    api_version = 1
    tokenNames = tokenNames

    def __init__(self, input, state=None, *args, **kwargs):
        if state is None:
            state = RecognizerSharedState()

        super(t013parserParser, self).__init__(input, state, *args, **kwargs)



                      
        self.identifiers = []
        self.reportedErrors = []


        self.delegates = []




                     
    def foundIdentifier(self, name):
        self.identifiers.append(name)

    def emitErrorMessage(self, msg):
        self.reportedErrors.append(msg)



    # $ANTLR start "document"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t013parser.g:19:1: document : t= IDENTIFIER ;
    def document(self, ):
        t = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t013parser.g:19:9: (t= IDENTIFIER )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t013parser.g:20:9: t= IDENTIFIER
                pass 
                t = self.match(self.input, IDENTIFIER, self.FOLLOW_IDENTIFIER_in_document50)

                #action start
                self.foundIdentifier(t.text)
                #action end





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "document"



 

    FOLLOW_IDENTIFIER_in_document50 = frozenset([1])



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import ParserMain
    main = ParserMain("t013parserLexer", t013parserParser)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
