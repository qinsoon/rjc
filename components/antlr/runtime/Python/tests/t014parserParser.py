# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g 2013-01-03 10:53:00

import sys
from antlr3 import *
from antlr3.compat import set, frozenset



# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EOF=-1
T__6=6
T__7=7
T__8=8
T__9=9
IDENTIFIER=4
WS=5

# token names
tokenNames = [
    "<invalid>", "<EOR>", "<DOWN>", "<UP>",
    "IDENTIFIER", "WS", "'('", "')'", "';'", "'var'"
]




class t014parserParser(Parser):
    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g"
    api_version = 1
    tokenNames = tokenNames

    def __init__(self, input, state=None, *args, **kwargs):
        if state is None:
            state = RecognizerSharedState()

        super(t014parserParser, self).__init__(input, state, *args, **kwargs)



                      
        self.events = []
        self.reportedErrors = []


        self.delegates = []




                     
    def emitErrorMessage(self, msg):
        self.reportedErrors.append(msg)



    # $ANTLR start "document"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:17:1: document : ( declaration | call )* EOF ;
    def document(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:17:9: ( ( declaration | call )* EOF )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:18:9: ( declaration | call )* EOF
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:18:9: ( declaration | call )*
                while True: #loop1
                    alt1 = 3
                    LA1_0 = self.input.LA(1)

                    if (LA1_0 == 9) :
                        alt1 = 1
                    elif (LA1_0 == IDENTIFIER) :
                        alt1 = 2


                    if alt1 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:18:11: declaration
                        pass 
                        self._state.following.append(self.FOLLOW_declaration_in_document59)
                        self.declaration()

                        self._state.following.pop()


                    elif alt1 == 2:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:19:11: call
                        pass 
                        self._state.following.append(self.FOLLOW_call_in_document71)
                        self.call()

                        self._state.following.pop()


                    else:
                        break #loop1


                self.match(self.input, EOF, self.FOLLOW_EOF_in_document92)




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "document"



    # $ANTLR start "declaration"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:24:1: declaration : 'var' t= IDENTIFIER ';' ;
    def declaration(self, ):
        t = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:24:12: ( 'var' t= IDENTIFIER ';' )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:25:9: 'var' t= IDENTIFIER ';'
                pass 
                self.match(self.input, 9, self.FOLLOW_9_in_declaration112)

                t = self.match(self.input, IDENTIFIER, self.FOLLOW_IDENTIFIER_in_declaration116)

                self.match(self.input, 8, self.FOLLOW_8_in_declaration118)

                #action start
                self.events.append(('decl', t.text))
                #action end





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "declaration"



    # $ANTLR start "call"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:29:1: call : t= IDENTIFIER '(' ')' ';' ;
    def call(self, ):
        t = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:29:5: (t= IDENTIFIER '(' ')' ';' )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:30:9: t= IDENTIFIER '(' ')' ';'
                pass 
                t = self.match(self.input, IDENTIFIER, self.FOLLOW_IDENTIFIER_in_call150)

                self.match(self.input, 6, self.FOLLOW_6_in_call152)

                self.match(self.input, 7, self.FOLLOW_7_in_call154)

                self.match(self.input, 8, self.FOLLOW_8_in_call156)

                #action start
                self.events.append(('call', t.text))
                #action end





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "call"



 

    FOLLOW_declaration_in_document59 = frozenset([4, 9])
    FOLLOW_call_in_document71 = frozenset([4, 9])
    FOLLOW_EOF_in_document92 = frozenset([1])
    FOLLOW_9_in_declaration112 = frozenset([4])
    FOLLOW_IDENTIFIER_in_declaration116 = frozenset([8])
    FOLLOW_8_in_declaration118 = frozenset([1])
    FOLLOW_IDENTIFIER_in_call150 = frozenset([6])
    FOLLOW_6_in_call152 = frozenset([7])
    FOLLOW_7_in_call154 = frozenset([8])
    FOLLOW_8_in_call156 = frozenset([1])



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import ParserMain
    main = ParserMain("t014parserLexer", t014parserParser)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
