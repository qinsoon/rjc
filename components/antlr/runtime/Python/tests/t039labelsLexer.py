# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g 2013-01-03 10:51:59

import sys
from antlr3 import *
from antlr3.compat import set, frozenset



# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EOF=-1
T__11=11
A=4
B=5
C=6
D=7
E=8
F=9
WS=10


class t039labelsLexer(Lexer):

    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g"
    api_version = 1

    def __init__(self, input=None, state=None):
        if state is None:
            state = RecognizerSharedState()
        super(t039labelsLexer, self).__init__(input, state)

        self.delegates = []






    # $ANTLR start "T__11"
    def mT__11(self, ):
        try:
            _type = T__11
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:7:7: ( ',' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:7:9: ','
            pass 
            self.match(44)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__11"



    # $ANTLR start "A"
    def mA(self, ):
        try:
            _type = A
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:11:2: ( 'a' .. 'z' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:
            pass 
            if (97 <= self.input.LA(1) <= 122):
                self.input.consume()
            else:
                mse = MismatchedSetException(None, self.input)
                self.recover(mse)
                raise mse





            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "A"



    # $ANTLR start "B"
    def mB(self, ):
        try:
            _type = B
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:12:2: ( '0' .. '9' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:
            pass 
            if (48 <= self.input.LA(1) <= 57):
                self.input.consume()
            else:
                mse = MismatchedSetException(None, self.input)
                self.recover(mse)
                raise mse





            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "B"



    # $ANTLR start "C"
    def mC(self, ):
        try:
            _type = C
            _channel = DEFAULT_CHANNEL

            a = None

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:13:2: (a= 'A' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:13:4: a= 'A'
            pass 
            a = self.input.LA(1)

            self.match(65)

            #action start
            print a 
            #action end




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "C"



    # $ANTLR start "D"
    def mD(self, ):
        try:
            _type = D
            _channel = DEFAULT_CHANNEL

            a = None

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:14:2: (a= 'FOOBAR' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:14:4: a= 'FOOBAR'
            pass 
            aStart = self.getCharIndex()
            self.match("FOOBAR")
            aStartLine61 = self.getLine()
            aStartCharPos61 = self.getCharPositionInLine()
            a = CommonToken(input=self.input, type=INVALID_TOKEN_TYPE, channel=DEFAULT_CHANNEL, start=aStart, stop=self.getCharIndex()-1)
            a.setLine(aStartLine61)
            a.setCharPositionInLine(aStartCharPos61)


            #action start
            print a 
            #action end




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "D"



    # $ANTLR start "E"
    def mE(self, ):
        try:
            _type = E
            _channel = DEFAULT_CHANNEL

            a = None

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:15:2: ( 'GNU' a= . )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:15:4: 'GNU' a= .
            pass 
            self.match("GNU")


            a = self.input.LA(1)

            self.matchAny()

            #action start
            print a 
            #action end




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "E"



    # $ANTLR start "F"
    def mF(self, ):
        try:
            _type = F
            _channel = DEFAULT_CHANNEL

            a = None

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:16:2: ( 'BLARZ' a= EOF )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:16:4: 'BLARZ' a= EOF
            pass 
            self.match("BLARZ")


            aStart85 = self.getCharIndex()
            aStartLine85 = self.getLine()
            aStartCharPos85 = self.getCharPositionInLine()
            self.match(EOF)
            a = CommonToken(input=self.input, type=EOF, channel=DEFAULT_CHANNEL, start=aStart85, stop=self.getCharIndex()-1)
            a.setLine(aStartLine85)
            a.setCharPositionInLine(aStartCharPos85)


            #action start
            print a 
            #action end




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "F"



    # $ANTLR start "WS"
    def mWS(self, ):
        try:
            _type = WS
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:18:3: ( ( ' ' )+ )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:18:5: ( ' ' )+
            pass 
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:18:5: ( ' ' )+
            cnt1 = 0
            while True: #loop1
                alt1 = 2
                LA1_0 = self.input.LA(1)

                if (LA1_0 == 32) :
                    alt1 = 1


                if alt1 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:18:5: ' '
                    pass 
                    self.match(32)


                else:
                    if cnt1 >= 1:
                        break #loop1

                    eee = EarlyExitException(1, self.input)
                    raise eee

                cnt1 += 1


            #action start
            _channel = HIDDEN 
            #action end




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "WS"



    def mTokens(self):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:1:8: ( T__11 | A | B | C | D | E | F | WS )
        alt2 = 8
        LA2 = self.input.LA(1)
        if LA2 == 44:
            alt2 = 1
        elif LA2 == 97 or LA2 == 98 or LA2 == 99 or LA2 == 100 or LA2 == 101 or LA2 == 102 or LA2 == 103 or LA2 == 104 or LA2 == 105 or LA2 == 106 or LA2 == 107 or LA2 == 108 or LA2 == 109 or LA2 == 110 or LA2 == 111 or LA2 == 112 or LA2 == 113 or LA2 == 114 or LA2 == 115 or LA2 == 116 or LA2 == 117 or LA2 == 118 or LA2 == 119 or LA2 == 120 or LA2 == 121 or LA2 == 122:
            alt2 = 2
        elif LA2 == 48 or LA2 == 49 or LA2 == 50 or LA2 == 51 or LA2 == 52 or LA2 == 53 or LA2 == 54 or LA2 == 55 or LA2 == 56 or LA2 == 57:
            alt2 = 3
        elif LA2 == 65:
            alt2 = 4
        elif LA2 == 70:
            alt2 = 5
        elif LA2 == 71:
            alt2 = 6
        elif LA2 == 66:
            alt2 = 7
        elif LA2 == 32:
            alt2 = 8
        else:
            nvae = NoViableAltException("", 2, 0, self.input)

            raise nvae


        if alt2 == 1:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:1:10: T__11
            pass 
            self.mT__11()



        elif alt2 == 2:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:1:16: A
            pass 
            self.mA()



        elif alt2 == 3:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:1:18: B
            pass 
            self.mB()



        elif alt2 == 4:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:1:20: C
            pass 
            self.mC()



        elif alt2 == 5:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:1:22: D
            pass 
            self.mD()



        elif alt2 == 6:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:1:24: E
            pass 
            self.mE()



        elif alt2 == 7:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:1:26: F
            pass 
            self.mF()



        elif alt2 == 8:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t039labels.g:1:28: WS
            pass 
            self.mWS()








 



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import LexerMain
    main = LexerMain(t039labelsLexer)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
