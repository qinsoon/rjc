# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g 2013-01-03 10:51:41

import sys
from antlr3 import *
from antlr3.compat import set, frozenset



# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EOF=-1
T__7=7
T__8=8
T__9=9
T__10=10
T__11=11
T__12=12
T__13=13
T__14=14
T__15=15
ID=4
INT=5
WS=6


class t046rewriteLexer(Lexer):

    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g"
    api_version = 1

    def __init__(self, input=None, state=None):
        if state is None:
            state = RecognizerSharedState()
        super(t046rewriteLexer, self).__init__(input, state)

        self.delegates = []






    # $ANTLR start "T__7"
    def mT__7(self, ):
        try:
            _type = T__7
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:7:6: ( '(' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:7:8: '('
            pass 
            self.match(40)



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

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:8:6: ( ')' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:8:8: ')'
            pass 
            self.match(41)



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

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:9:6: ( '*' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:9:8: '*'
            pass 
            self.match(42)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__9"



    # $ANTLR start "T__10"
    def mT__10(self, ):
        try:
            _type = T__10
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:10:7: ( '+' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:10:9: '+'
            pass 
            self.match(43)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__10"



    # $ANTLR start "T__11"
    def mT__11(self, ):
        try:
            _type = T__11
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:11:7: ( ';' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:11:9: ';'
            pass 
            self.match(59)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__11"



    # $ANTLR start "T__12"
    def mT__12(self, ):
        try:
            _type = T__12
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:12:7: ( '=' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:12:9: '='
            pass 
            self.match(61)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__12"



    # $ANTLR start "T__13"
    def mT__13(self, ):
        try:
            _type = T__13
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:13:7: ( 'method' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:13:9: 'method'
            pass 
            self.match("method")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__13"



    # $ANTLR start "T__14"
    def mT__14(self, ):
        try:
            _type = T__14
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:14:7: ( '{' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:14:9: '{'
            pass 
            self.match(123)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__14"



    # $ANTLR start "T__15"
    def mT__15(self, ):
        try:
            _type = T__15
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:15:7: ( '}' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:15:9: '}'
            pass 
            self.match(125)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__15"



    # $ANTLR start "ID"
    def mID(self, ):
        try:
            _type = ID
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:49:5: ( ( 'a' .. 'z' | 'A' .. 'Z' )+ )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:49:9: ( 'a' .. 'z' | 'A' .. 'Z' )+
            pass 
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:49:9: ( 'a' .. 'z' | 'A' .. 'Z' )+
            cnt1 = 0
            while True: #loop1
                alt1 = 2
                LA1_0 = self.input.LA(1)

                if ((65 <= LA1_0 <= 90) or (97 <= LA1_0 <= 122)) :
                    alt1 = 1


                if alt1 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:
                    pass 
                    if (65 <= self.input.LA(1) <= 90) or (97 <= self.input.LA(1) <= 122):
                        self.input.consume()
                    else:
                        mse = MismatchedSetException(None, self.input)
                        self.recover(mse)
                        raise mse




                else:
                    if cnt1 >= 1:
                        break #loop1

                    eee = EarlyExitException(1, self.input)
                    raise eee

                cnt1 += 1




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "ID"



    # $ANTLR start "INT"
    def mINT(self, ):
        try:
            _type = INT
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:51:5: ( ( '0' .. '9' )+ )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:51:9: ( '0' .. '9' )+
            pass 
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:51:9: ( '0' .. '9' )+
            cnt2 = 0
            while True: #loop2
                alt2 = 2
                LA2_0 = self.input.LA(1)

                if ((48 <= LA2_0 <= 57)) :
                    alt2 = 1


                if alt2 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:
                    pass 
                    if (48 <= self.input.LA(1) <= 57):
                        self.input.consume()
                    else:
                        mse = MismatchedSetException(None, self.input)
                        self.recover(mse)
                        raise mse




                else:
                    if cnt2 >= 1:
                        break #loop2

                    eee = EarlyExitException(2, self.input)
                    raise eee

                cnt2 += 1




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "INT"



    # $ANTLR start "WS"
    def mWS(self, ):
        try:
            _type = WS
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:53:5: ( ( ' ' | '\\t' | '\\n' )+ )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:53:9: ( ' ' | '\\t' | '\\n' )+
            pass 
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:53:9: ( ' ' | '\\t' | '\\n' )+
            cnt3 = 0
            while True: #loop3
                alt3 = 2
                LA3_0 = self.input.LA(1)

                if ((9 <= LA3_0 <= 10) or LA3_0 == 32) :
                    alt3 = 1


                if alt3 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:
                    pass 
                    if (9 <= self.input.LA(1) <= 10) or self.input.LA(1) == 32:
                        self.input.consume()
                    else:
                        mse = MismatchedSetException(None, self.input)
                        self.recover(mse)
                        raise mse




                else:
                    if cnt3 >= 1:
                        break #loop3

                    eee = EarlyExitException(3, self.input)
                    raise eee

                cnt3 += 1


            #action start
            _channel=HIDDEN;
            #action end




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "WS"



    def mTokens(self):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:1:8: ( T__7 | T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | ID | INT | WS )
        alt4 = 12
        LA4 = self.input.LA(1)
        if LA4 == 40:
            alt4 = 1
        elif LA4 == 41:
            alt4 = 2
        elif LA4 == 42:
            alt4 = 3
        elif LA4 == 43:
            alt4 = 4
        elif LA4 == 59:
            alt4 = 5
        elif LA4 == 61:
            alt4 = 6
        elif LA4 == 109:
            LA4_7 = self.input.LA(2)

            if (LA4_7 == 101) :
                LA4_13 = self.input.LA(3)

                if (LA4_13 == 116) :
                    LA4_14 = self.input.LA(4)

                    if (LA4_14 == 104) :
                        LA4_15 = self.input.LA(5)

                        if (LA4_15 == 111) :
                            LA4_16 = self.input.LA(6)

                            if (LA4_16 == 100) :
                                LA4_17 = self.input.LA(7)

                                if ((65 <= LA4_17 <= 90) or (97 <= LA4_17 <= 122)) :
                                    alt4 = 10
                                else:
                                    alt4 = 7

                            else:
                                alt4 = 10

                        else:
                            alt4 = 10

                    else:
                        alt4 = 10

                else:
                    alt4 = 10

            else:
                alt4 = 10

        elif LA4 == 123:
            alt4 = 8
        elif LA4 == 125:
            alt4 = 9
        elif LA4 == 65 or LA4 == 66 or LA4 == 67 or LA4 == 68 or LA4 == 69 or LA4 == 70 or LA4 == 71 or LA4 == 72 or LA4 == 73 or LA4 == 74 or LA4 == 75 or LA4 == 76 or LA4 == 77 or LA4 == 78 or LA4 == 79 or LA4 == 80 or LA4 == 81 or LA4 == 82 or LA4 == 83 or LA4 == 84 or LA4 == 85 or LA4 == 86 or LA4 == 87 or LA4 == 88 or LA4 == 89 or LA4 == 90 or LA4 == 97 or LA4 == 98 or LA4 == 99 or LA4 == 100 or LA4 == 101 or LA4 == 102 or LA4 == 103 or LA4 == 104 or LA4 == 105 or LA4 == 106 or LA4 == 107 or LA4 == 108 or LA4 == 110 or LA4 == 111 or LA4 == 112 or LA4 == 113 or LA4 == 114 or LA4 == 115 or LA4 == 116 or LA4 == 117 or LA4 == 118 or LA4 == 119 or LA4 == 120 or LA4 == 121 or LA4 == 122:
            alt4 = 10
        elif LA4 == 48 or LA4 == 49 or LA4 == 50 or LA4 == 51 or LA4 == 52 or LA4 == 53 or LA4 == 54 or LA4 == 55 or LA4 == 56 or LA4 == 57:
            alt4 = 11
        elif LA4 == 9 or LA4 == 10 or LA4 == 32:
            alt4 = 12
        else:
            nvae = NoViableAltException("", 4, 0, self.input)

            raise nvae


        if alt4 == 1:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:1:10: T__7
            pass 
            self.mT__7()



        elif alt4 == 2:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:1:15: T__8
            pass 
            self.mT__8()



        elif alt4 == 3:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:1:20: T__9
            pass 
            self.mT__9()



        elif alt4 == 4:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:1:25: T__10
            pass 
            self.mT__10()



        elif alt4 == 5:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:1:31: T__11
            pass 
            self.mT__11()



        elif alt4 == 6:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:1:37: T__12
            pass 
            self.mT__12()



        elif alt4 == 7:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:1:43: T__13
            pass 
            self.mT__13()



        elif alt4 == 8:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:1:49: T__14
            pass 
            self.mT__14()



        elif alt4 == 9:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:1:55: T__15
            pass 
            self.mT__15()



        elif alt4 == 10:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:1:61: ID
            pass 
            self.mID()



        elif alt4 == 11:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:1:64: INT
            pass 
            self.mINT()



        elif alt4 == 12:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t046rewrite.g:1:68: WS
            pass 
            self.mWS()








 



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import LexerMain
    main = LexerMain(t046rewriteLexer)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
