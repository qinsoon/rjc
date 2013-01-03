# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g 2013-01-03 10:51:49

import sys
from antlr3 import *
from antlr3.compat import set, frozenset



# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EOF=-1
T__7=7
E=4
P=5
S=6


class t043synpredLexer(Lexer):

    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g"
    api_version = 1

    def __init__(self, input=None, state=None):
        if state is None:
            state = RecognizerSharedState()
        super(t043synpredLexer, self).__init__(input, state)

        self.delegates = []






    # $ANTLR start "T__7"
    def mT__7(self, ):
        try:
            _type = T__7
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g:7:6: ( 'foo' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g:7:8: 'foo'
            pass 
            self.match("foo")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__7"



    # $ANTLR start "S"
    def mS(self, ):
        try:
            _type = S
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g:12:2: ( ' ' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g:12:4: ' '
            pass 
            self.match(32)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "S"



    # $ANTLR start "P"
    def mP(self, ):
        try:
            _type = P
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g:13:2: ( '+' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g:13:4: '+'
            pass 
            self.match(43)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "P"



    # $ANTLR start "E"
    def mE(self, ):
        try:
            _type = E
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g:14:2: ( '>' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g:14:4: '>'
            pass 
            self.match(62)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "E"



    def mTokens(self):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g:1:8: ( T__7 | S | P | E )
        alt1 = 4
        LA1 = self.input.LA(1)
        if LA1 == 102:
            alt1 = 1
        elif LA1 == 32:
            alt1 = 2
        elif LA1 == 43:
            alt1 = 3
        elif LA1 == 62:
            alt1 = 4
        else:
            nvae = NoViableAltException("", 1, 0, self.input)

            raise nvae


        if alt1 == 1:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g:1:10: T__7
            pass 
            self.mT__7()



        elif alt1 == 2:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g:1:15: S
            pass 
            self.mS()



        elif alt1 == 3:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g:1:17: P
            pass 
            self.mP()



        elif alt1 == 4:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t043synpred.g:1:19: E
            pass 
            self.mE()








 



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import LexerMain
    main = LexerMain(t043synpredLexer)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
