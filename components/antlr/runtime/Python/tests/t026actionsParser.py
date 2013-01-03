# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t026actions.g 2013-01-03 10:52:26

import sys
from antlr3 import *
from antlr3.compat import set, frozenset



# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EOF=-1
IDENTIFIER=4
WS=5

# token names
tokenNames = [
    "<invalid>", "<EOR>", "<DOWN>", "<UP>",
    "IDENTIFIER", "WS"
]




class t026actionsParser(Parser):
    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t026actions.g"
    api_version = 1
    tokenNames = tokenNames

    def __init__(self, input, state=None, *args, **kwargs):
        if state is None:
            state = RecognizerSharedState()

        super(t026actionsParser, self).__init__(input, state, *args, **kwargs)




        self.delegates = []






    # $ANTLR start "prog"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t026actions.g:10:1: prog : IDENTIFIER EOF ;
    def prog(self, ):
              
        self.capture('init;')

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t026actions.g:17:5: ( IDENTIFIER EOF )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t026actions.g:17:9: IDENTIFIER EOF
                pass 
                self.match(self.input, IDENTIFIER, self.FOLLOW_IDENTIFIER_in_prog48)

                self.match(self.input, EOF, self.FOLLOW_EOF_in_prog50)



                #action start
                       
                self.capture('after;')

                #action end


            except  RecognitionException, exc :
                                                        
                self.capture('catch;')
                raise
                    


        finally:
                        
            self.capture('finally;')
                
            pass
        return 

    # $ANTLR end "prog"



 

    FOLLOW_IDENTIFIER_in_prog48 = frozenset([])
    FOLLOW_EOF_in_prog50 = frozenset([1])



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import ParserMain
    main = ParserMain("t026actionsLexer", t026actionsParser)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
