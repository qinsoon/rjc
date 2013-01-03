# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t032subrulePredict.g 2013-01-03 10:52:16

import sys
from antlr3 import *
from antlr3.compat import set, frozenset



# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EOF=-1
T__5=5
T__6=6
T__7=7
WS=4


class t032subrulePredictLexer(Lexer):

    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t032subrulePredict.g"
    api_version = 1

    def __init__(self, input=None, state=None):
        if state is None:
            state = RecognizerSharedState()
        super(t032subrulePredictLexer, self).__init__(input, state)

        self.delegates = []






    # $ANTLR start "T__5"
    def mT__5(self, ):
        try:
            _type = T__5
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t032subrulePredict.g:7:6: ( 'A' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t032subrulePredict.g:7:8: 'A'
            pass 
            self.match(65)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__5"



    # $ANTLR start "T__6"
    def mT__6(self, ):
        try:
            _type = T__6
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t032subrulePredict.g:8:6: ( 'BEGIN' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t032subrulePredict.g:8:8: 'BEGIN'
            pass 
            self.match("BEGIN")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__6"



    # $ANTLR start "T__7"
    def mT__7(self, ):
        try:
            _type = T__7
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t032subrulePredict.g:9:6: ( 'END' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t032subrulePredict.g:9:8: 'END'
            pass 
            self.match("END")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__7"



    # $ANTLR start "WS"
    def mWS(self, ):
        try:
            _type = WS
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t032subrulePredict.g:8:3: ( ' ' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t032subrulePredict.g:8:5: ' '
            pass 
            self.match(32)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "WS"



    def mTokens(self):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t032subrulePredict.g:1:8: ( T__5 | T__6 | T__7 | WS )
        alt1 = 4
        LA1 = self.input.LA(1)
        if LA1 == 65:
            alt1 = 1
        elif LA1 == 66:
            alt1 = 2
        elif LA1 == 69:
            alt1 = 3
        elif LA1 == 32:
            alt1 = 4
        else:
            nvae = NoViableAltException("", 1, 0, self.input)

            raise nvae


        if alt1 == 1:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t032subrulePredict.g:1:10: T__5
            pass 
            self.mT__5()



        elif alt1 == 2:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t032subrulePredict.g:1:15: T__6
            pass 
            self.mT__6()



        elif alt1 == 3:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t032subrulePredict.g:1:20: T__7
            pass 
            self.mT__7()



        elif alt1 == 4:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t032subrulePredict.g:1:25: WS
            pass 
            self.mWS()








 



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import LexerMain
    main = LexerMain(t032subrulePredictLexer)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
