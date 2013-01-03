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


class t014parserLexer(Lexer):

    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g"
    api_version = 1

    def __init__(self, input=None, state=None):
        if state is None:
            state = RecognizerSharedState()
        super(t014parserLexer, self).__init__(input, state)

        self.delegates = []






    # $ANTLR start "T__6"
    def mT__6(self, ):
        try:
            _type = T__6
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:7:6: ( '(' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:7:8: '('
            pass 
            self.match(40)



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

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:8:6: ( ')' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:8:8: ')'
            pass 
            self.match(41)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__7"



    # $ANTLR start "T__8"
    def mT__8(self, ):
        try:
            _type = T__8
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:9:6: ( ';' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:9:8: ';'
            pass 
            self.match(59)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__8"



    # $ANTLR start "T__9"
    def mT__9(self, ):
        try:
            _type = T__9
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:10:6: ( 'var' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:10:8: 'var'
            pass 
            self.match("var")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__9"



    # $ANTLR start "IDENTIFIER"
    def mIDENTIFIER(self, ):
        try:
            _type = IDENTIFIER
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:34:11: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:34:13: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            pass 
            if (65 <= self.input.LA(1) <= 90) or self.input.LA(1) == 95 or (97 <= self.input.LA(1) <= 122):
                self.input.consume()
            else:
                mse = MismatchedSetException(None, self.input)
                self.recover(mse)
                raise mse



            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:34:37: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            while True: #loop1
                alt1 = 2
                LA1_0 = self.input.LA(1)

                if ((48 <= LA1_0 <= 57) or (65 <= LA1_0 <= 90) or LA1_0 == 95 or (97 <= LA1_0 <= 122)) :
                    alt1 = 1


                if alt1 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:
                    pass 
                    if (48 <= self.input.LA(1) <= 57) or (65 <= self.input.LA(1) <= 90) or self.input.LA(1) == 95 or (97 <= self.input.LA(1) <= 122):
                        self.input.consume()
                    else:
                        mse = MismatchedSetException(None, self.input)
                        self.recover(mse)
                        raise mse




                else:
                    break #loop1




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "IDENTIFIER"



    # $ANTLR start "WS"
    def mWS(self, ):
        try:
            _type = WS
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:35:3: ( ( ' ' | '\\r' | '\\t' | '\\n' ) )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:35:6: ( ' ' | '\\r' | '\\t' | '\\n' )
            pass 
            if (9 <= self.input.LA(1) <= 10) or self.input.LA(1) == 13 or self.input.LA(1) == 32:
                self.input.consume()
            else:
                mse = MismatchedSetException(None, self.input)
                self.recover(mse)
                raise mse



            #action start
            _channel=HIDDEN;
            #action end




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "WS"



    def mTokens(self):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:1:8: ( T__6 | T__7 | T__8 | T__9 | IDENTIFIER | WS )
        alt2 = 6
        LA2 = self.input.LA(1)
        if LA2 == 40:
            alt2 = 1
        elif LA2 == 41:
            alt2 = 2
        elif LA2 == 59:
            alt2 = 3
        elif LA2 == 118:
            LA2_4 = self.input.LA(2)

            if (LA2_4 == 97) :
                LA2_7 = self.input.LA(3)

                if (LA2_7 == 114) :
                    LA2_8 = self.input.LA(4)

                    if ((48 <= LA2_8 <= 57) or (65 <= LA2_8 <= 90) or LA2_8 == 95 or (97 <= LA2_8 <= 122)) :
                        alt2 = 5
                    else:
                        alt2 = 4

                else:
                    alt2 = 5

            else:
                alt2 = 5

        elif LA2 == 65 or LA2 == 66 or LA2 == 67 or LA2 == 68 or LA2 == 69 or LA2 == 70 or LA2 == 71 or LA2 == 72 or LA2 == 73 or LA2 == 74 or LA2 == 75 or LA2 == 76 or LA2 == 77 or LA2 == 78 or LA2 == 79 or LA2 == 80 or LA2 == 81 or LA2 == 82 or LA2 == 83 or LA2 == 84 or LA2 == 85 or LA2 == 86 or LA2 == 87 or LA2 == 88 or LA2 == 89 or LA2 == 90 or LA2 == 95 or LA2 == 97 or LA2 == 98 or LA2 == 99 or LA2 == 100 or LA2 == 101 or LA2 == 102 or LA2 == 103 or LA2 == 104 or LA2 == 105 or LA2 == 106 or LA2 == 107 or LA2 == 108 or LA2 == 109 or LA2 == 110 or LA2 == 111 or LA2 == 112 or LA2 == 113 or LA2 == 114 or LA2 == 115 or LA2 == 116 or LA2 == 117 or LA2 == 119 or LA2 == 120 or LA2 == 121 or LA2 == 122:
            alt2 = 5
        elif LA2 == 9 or LA2 == 10 or LA2 == 13 or LA2 == 32:
            alt2 = 6
        else:
            nvae = NoViableAltException("", 2, 0, self.input)

            raise nvae


        if alt2 == 1:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:1:10: T__6
            pass 
            self.mT__6()



        elif alt2 == 2:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:1:15: T__7
            pass 
            self.mT__7()



        elif alt2 == 3:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:1:20: T__8
            pass 
            self.mT__8()



        elif alt2 == 4:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:1:25: T__9
            pass 
            self.mT__9()



        elif alt2 == 5:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:1:30: IDENTIFIER
            pass 
            self.mIDENTIFIER()



        elif alt2 == 6:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t014parser.g:1:41: WS
            pass 
            self.mWS()








 



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import LexerMain
    main = LexerMain(t014parserLexer)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
