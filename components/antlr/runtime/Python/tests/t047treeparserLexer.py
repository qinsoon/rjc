# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g 2013-01-03 10:51:38

import sys
from antlr3 import *
from antlr3.compat import set, frozenset



# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EOF=-1
T__21=21
T__22=22
T__23=23
T__24=24
T__25=25
T__26=26
ARG_DEF=4
BLOCK=5
CHAR=6
EQ=7
EQEQ=8
FOR=9
FUNC_DECL=10
FUNC_DEF=11
FUNC_HDR=12
ID=13
INT=14
INT_TYPE=15
LT=16
PLUS=17
VAR_DEF=18
VOID=19
WS=20


class t047treeparserLexer(Lexer):

    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g"
    api_version = 1

    def __init__(self, input=None, state=None):
        if state is None:
            state = RecognizerSharedState()
        super(t047treeparserLexer, self).__init__(input, state)

        self.delegates = []






    # $ANTLR start "T__21"
    def mT__21(self, ):
        try:
            _type = T__21
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:7:7: ( '(' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:7:9: '('
            pass 
            self.match(40)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__21"



    # $ANTLR start "T__22"
    def mT__22(self, ):
        try:
            _type = T__22
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:8:7: ( ')' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:8:9: ')'
            pass 
            self.match(41)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__22"



    # $ANTLR start "T__23"
    def mT__23(self, ):
        try:
            _type = T__23
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:9:7: ( ',' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:9:9: ','
            pass 
            self.match(44)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__23"



    # $ANTLR start "T__24"
    def mT__24(self, ):
        try:
            _type = T__24
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:10:7: ( ';' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:10:9: ';'
            pass 
            self.match(59)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__24"



    # $ANTLR start "T__25"
    def mT__25(self, ):
        try:
            _type = T__25
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:11:7: ( '{' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:11:9: '{'
            pass 
            self.match(123)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__25"



    # $ANTLR start "T__26"
    def mT__26(self, ):
        try:
            _type = T__26
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:12:7: ( '}' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:12:9: '}'
            pass 
            self.match(125)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__26"



    # $ANTLR start "FOR"
    def mFOR(self, ):
        try:
            _type = FOR
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:91:5: ( 'for' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:91:7: 'for'
            pass 
            self.match("for")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "FOR"



    # $ANTLR start "INT_TYPE"
    def mINT_TYPE(self, ):
        try:
            _type = INT_TYPE
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:92:10: ( 'int' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:92:12: 'int'
            pass 
            self.match("int")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "INT_TYPE"



    # $ANTLR start "CHAR"
    def mCHAR(self, ):
        try:
            _type = CHAR
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:93:5: ( 'char' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:93:7: 'char'
            pass 
            self.match("char")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "CHAR"



    # $ANTLR start "VOID"
    def mVOID(self, ):
        try:
            _type = VOID
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:94:5: ( 'void' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:94:7: 'void'
            pass 
            self.match("void")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "VOID"



    # $ANTLR start "ID"
    def mID(self, ):
        try:
            _type = ID
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:96:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:96:9: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            pass 
            if (65 <= self.input.LA(1) <= 90) or self.input.LA(1) == 95 or (97 <= self.input.LA(1) <= 122):
                self.input.consume()
            else:
                mse = MismatchedSetException(None, self.input)
                self.recover(mse)
                raise mse



            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:96:33: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            while True: #loop1
                alt1 = 2
                LA1_0 = self.input.LA(1)

                if ((48 <= LA1_0 <= 57) or (65 <= LA1_0 <= 90) or LA1_0 == 95 or (97 <= LA1_0 <= 122)) :
                    alt1 = 1


                if alt1 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:
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

    # $ANTLR end "ID"



    # $ANTLR start "INT"
    def mINT(self, ):
        try:
            _type = INT
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:99:5: ( ( '0' .. '9' )+ )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:99:7: ( '0' .. '9' )+
            pass 
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:99:7: ( '0' .. '9' )+
            cnt2 = 0
            while True: #loop2
                alt2 = 2
                LA2_0 = self.input.LA(1)

                if ((48 <= LA2_0 <= 57)) :
                    alt2 = 1


                if alt2 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:
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



    # $ANTLR start "EQ"
    def mEQ(self, ):
        try:
            _type = EQ
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:102:6: ( '=' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:102:8: '='
            pass 
            self.match(61)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "EQ"



    # $ANTLR start "EQEQ"
    def mEQEQ(self, ):
        try:
            _type = EQEQ
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:103:6: ( '==' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:103:8: '=='
            pass 
            self.match("==")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "EQEQ"



    # $ANTLR start "LT"
    def mLT(self, ):
        try:
            _type = LT
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:104:6: ( '<' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:104:8: '<'
            pass 
            self.match(60)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "LT"



    # $ANTLR start "PLUS"
    def mPLUS(self, ):
        try:
            _type = PLUS
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:105:6: ( '+' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:105:8: '+'
            pass 
            self.match(43)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "PLUS"



    # $ANTLR start "WS"
    def mWS(self, ):
        try:
            _type = WS
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:107:5: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:107:9: ( ' ' | '\\t' | '\\r' | '\\n' )+
            pass 
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:107:9: ( ' ' | '\\t' | '\\r' | '\\n' )+
            cnt3 = 0
            while True: #loop3
                alt3 = 2
                LA3_0 = self.input.LA(1)

                if ((9 <= LA3_0 <= 10) or LA3_0 == 13 or LA3_0 == 32) :
                    alt3 = 1


                if alt3 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:
                    pass 
                    if (9 <= self.input.LA(1) <= 10) or self.input.LA(1) == 13 or self.input.LA(1) == 32:
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
            _channel=HIDDEN 
            #action end




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "WS"



    def mTokens(self):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:1:8: ( T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | FOR | INT_TYPE | CHAR | VOID | ID | INT | EQ | EQEQ | LT | PLUS | WS )
        alt4 = 17
        LA4 = self.input.LA(1)
        if LA4 == 40:
            alt4 = 1
        elif LA4 == 41:
            alt4 = 2
        elif LA4 == 44:
            alt4 = 3
        elif LA4 == 59:
            alt4 = 4
        elif LA4 == 123:
            alt4 = 5
        elif LA4 == 125:
            alt4 = 6
        elif LA4 == 102:
            LA4_7 = self.input.LA(2)

            if (LA4_7 == 111) :
                LA4_17 = self.input.LA(3)

                if (LA4_17 == 114) :
                    LA4_23 = self.input.LA(4)

                    if ((48 <= LA4_23 <= 57) or (65 <= LA4_23 <= 90) or LA4_23 == 95 or (97 <= LA4_23 <= 122)) :
                        alt4 = 11
                    else:
                        alt4 = 7

                else:
                    alt4 = 11

            else:
                alt4 = 11

        elif LA4 == 105:
            LA4_8 = self.input.LA(2)

            if (LA4_8 == 110) :
                LA4_18 = self.input.LA(3)

                if (LA4_18 == 116) :
                    LA4_24 = self.input.LA(4)

                    if ((48 <= LA4_24 <= 57) or (65 <= LA4_24 <= 90) or LA4_24 == 95 or (97 <= LA4_24 <= 122)) :
                        alt4 = 11
                    else:
                        alt4 = 8

                else:
                    alt4 = 11

            else:
                alt4 = 11

        elif LA4 == 99:
            LA4_9 = self.input.LA(2)

            if (LA4_9 == 104) :
                LA4_19 = self.input.LA(3)

                if (LA4_19 == 97) :
                    LA4_25 = self.input.LA(4)

                    if (LA4_25 == 114) :
                        LA4_29 = self.input.LA(5)

                        if ((48 <= LA4_29 <= 57) or (65 <= LA4_29 <= 90) or LA4_29 == 95 or (97 <= LA4_29 <= 122)) :
                            alt4 = 11
                        else:
                            alt4 = 9

                    else:
                        alt4 = 11

                else:
                    alt4 = 11

            else:
                alt4 = 11

        elif LA4 == 118:
            LA4_10 = self.input.LA(2)

            if (LA4_10 == 111) :
                LA4_20 = self.input.LA(3)

                if (LA4_20 == 105) :
                    LA4_26 = self.input.LA(4)

                    if (LA4_26 == 100) :
                        LA4_30 = self.input.LA(5)

                        if ((48 <= LA4_30 <= 57) or (65 <= LA4_30 <= 90) or LA4_30 == 95 or (97 <= LA4_30 <= 122)) :
                            alt4 = 11
                        else:
                            alt4 = 10

                    else:
                        alt4 = 11

                else:
                    alt4 = 11

            else:
                alt4 = 11

        elif LA4 == 65 or LA4 == 66 or LA4 == 67 or LA4 == 68 or LA4 == 69 or LA4 == 70 or LA4 == 71 or LA4 == 72 or LA4 == 73 or LA4 == 74 or LA4 == 75 or LA4 == 76 or LA4 == 77 or LA4 == 78 or LA4 == 79 or LA4 == 80 or LA4 == 81 or LA4 == 82 or LA4 == 83 or LA4 == 84 or LA4 == 85 or LA4 == 86 or LA4 == 87 or LA4 == 88 or LA4 == 89 or LA4 == 90 or LA4 == 95 or LA4 == 97 or LA4 == 98 or LA4 == 100 or LA4 == 101 or LA4 == 103 or LA4 == 104 or LA4 == 106 or LA4 == 107 or LA4 == 108 or LA4 == 109 or LA4 == 110 or LA4 == 111 or LA4 == 112 or LA4 == 113 or LA4 == 114 or LA4 == 115 or LA4 == 116 or LA4 == 117 or LA4 == 119 or LA4 == 120 or LA4 == 121 or LA4 == 122:
            alt4 = 11
        elif LA4 == 48 or LA4 == 49 or LA4 == 50 or LA4 == 51 or LA4 == 52 or LA4 == 53 or LA4 == 54 or LA4 == 55 or LA4 == 56 or LA4 == 57:
            alt4 = 12
        elif LA4 == 61:
            LA4_13 = self.input.LA(2)

            if (LA4_13 == 61) :
                alt4 = 14
            else:
                alt4 = 13

        elif LA4 == 60:
            alt4 = 15
        elif LA4 == 43:
            alt4 = 16
        elif LA4 == 9 or LA4 == 10 or LA4 == 13 or LA4 == 32:
            alt4 = 17
        else:
            nvae = NoViableAltException("", 4, 0, self.input)

            raise nvae


        if alt4 == 1:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:1:10: T__21
            pass 
            self.mT__21()



        elif alt4 == 2:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:1:16: T__22
            pass 
            self.mT__22()



        elif alt4 == 3:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:1:22: T__23
            pass 
            self.mT__23()



        elif alt4 == 4:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:1:28: T__24
            pass 
            self.mT__24()



        elif alt4 == 5:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:1:34: T__25
            pass 
            self.mT__25()



        elif alt4 == 6:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:1:40: T__26
            pass 
            self.mT__26()



        elif alt4 == 7:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:1:46: FOR
            pass 
            self.mFOR()



        elif alt4 == 8:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:1:50: INT_TYPE
            pass 
            self.mINT_TYPE()



        elif alt4 == 9:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:1:59: CHAR
            pass 
            self.mCHAR()



        elif alt4 == 10:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:1:64: VOID
            pass 
            self.mVOID()



        elif alt4 == 11:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:1:69: ID
            pass 
            self.mID()



        elif alt4 == 12:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:1:72: INT
            pass 
            self.mINT()



        elif alt4 == 13:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:1:76: EQ
            pass 
            self.mEQ()



        elif alt4 == 14:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:1:79: EQEQ
            pass 
            self.mEQEQ()



        elif alt4 == 15:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:1:84: LT
            pass 
            self.mLT()



        elif alt4 == 16:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:1:87: PLUS
            pass 
            self.mPLUS()



        elif alt4 == 17:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t047treeparser.g:1:92: WS
            pass 
            self.mWS()








 



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import LexerMain
    main = LexerMain(t047treeparserLexer)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
