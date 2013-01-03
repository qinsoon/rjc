# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g 2013-01-03 10:52:14

import sys
from antlr3 import *
from antlr3.compat import set, frozenset



# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EOF=-1
T__23=23
T__24=24
T__25=25
T__26=26
T__27=27
T__28=28
T__29=29
T__30=30
T__31=31
T__32=32
T__33=33
T__34=34
T__35=35
T__36=36
T__37=37
T__38=38
T__39=39
T__40=40
T__41=41
T__42=42
T__43=43
T__44=44
T__45=45
CHARACTER_LITERAL=4
COMMENT=5
DECIMAL_LITERAL=6
EscapeSequence=7
Exponent=8
FLOATING_POINT_LITERAL=9
FloatTypeSuffix=10
HEX_LITERAL=11
HexDigit=12
IDENTIFIER=13
IntegerTypeSuffix=14
LETTER=15
LINE_COMMAND=16
LINE_COMMENT=17
OCTAL_LITERAL=18
OctalEscape=19
STRING_LITERAL=20
UnicodeEscape=21
WS=22


class t033backtrackingLexer(Lexer):

    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g"
    api_version = 1

    def __init__(self, input=None, state=None):
        if state is None:
            state = RecognizerSharedState()
        super(t033backtrackingLexer, self).__init__(input, state)

        self.delegates = []

        self.dfa25 = self.DFA25(
            self, 25,
            eot = self.DFA25_eot,
            eof = self.DFA25_eof,
            min = self.DFA25_min,
            max = self.DFA25_max,
            accept = self.DFA25_accept,
            special = self.DFA25_special,
            transition = self.DFA25_transition
            )

        self.dfa35 = self.DFA35(
            self, 35,
            eot = self.DFA35_eot,
            eof = self.DFA35_eof,
            min = self.DFA35_min,
            max = self.DFA35_max,
            accept = self.DFA35_accept,
            special = self.DFA35_special,
            transition = self.DFA35_transition
            )






    # $ANTLR start "T__23"
    def mT__23(self, ):
        try:
            _type = T__23
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:7:7: ( '(' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:7:9: '('
            pass 
            self.match(40)



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

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:8:7: ( ')' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:8:9: ')'
            pass 
            self.match(41)



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

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:9:7: ( '*' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:9:9: '*'
            pass 
            self.match(42)



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

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:10:7: ( ',' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:10:9: ','
            pass 
            self.match(44)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__26"



    # $ANTLR start "T__27"
    def mT__27(self, ):
        try:
            _type = T__27
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:11:7: ( ';' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:11:9: ';'
            pass 
            self.match(59)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__27"



    # $ANTLR start "T__28"
    def mT__28(self, ):
        try:
            _type = T__28
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:12:7: ( '[' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:12:9: '['
            pass 
            self.match(91)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__28"



    # $ANTLR start "T__29"
    def mT__29(self, ):
        try:
            _type = T__29
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:13:7: ( ']' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:13:9: ']'
            pass 
            self.match(93)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__29"



    # $ANTLR start "T__30"
    def mT__30(self, ):
        try:
            _type = T__30
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:14:7: ( 'auto' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:14:9: 'auto'
            pass 
            self.match("auto")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__30"



    # $ANTLR start "T__31"
    def mT__31(self, ):
        try:
            _type = T__31
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:15:7: ( 'char' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:15:9: 'char'
            pass 
            self.match("char")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__31"



    # $ANTLR start "T__32"
    def mT__32(self, ):
        try:
            _type = T__32
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:16:7: ( 'const' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:16:9: 'const'
            pass 
            self.match("const")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__32"



    # $ANTLR start "T__33"
    def mT__33(self, ):
        try:
            _type = T__33
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:17:7: ( 'double' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:17:9: 'double'
            pass 
            self.match("double")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__33"



    # $ANTLR start "T__34"
    def mT__34(self, ):
        try:
            _type = T__34
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:18:7: ( 'extern' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:18:9: 'extern'
            pass 
            self.match("extern")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__34"



    # $ANTLR start "T__35"
    def mT__35(self, ):
        try:
            _type = T__35
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:19:7: ( 'float' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:19:9: 'float'
            pass 
            self.match("float")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__35"



    # $ANTLR start "T__36"
    def mT__36(self, ):
        try:
            _type = T__36
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:20:7: ( 'int' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:20:9: 'int'
            pass 
            self.match("int")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__36"



    # $ANTLR start "T__37"
    def mT__37(self, ):
        try:
            _type = T__37
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:21:7: ( 'long' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:21:9: 'long'
            pass 
            self.match("long")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__37"



    # $ANTLR start "T__38"
    def mT__38(self, ):
        try:
            _type = T__38
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:22:7: ( 'register' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:22:9: 'register'
            pass 
            self.match("register")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__38"



    # $ANTLR start "T__39"
    def mT__39(self, ):
        try:
            _type = T__39
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:23:7: ( 'short' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:23:9: 'short'
            pass 
            self.match("short")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__39"



    # $ANTLR start "T__40"
    def mT__40(self, ):
        try:
            _type = T__40
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:24:7: ( 'signed' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:24:9: 'signed'
            pass 
            self.match("signed")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__40"



    # $ANTLR start "T__41"
    def mT__41(self, ):
        try:
            _type = T__41
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:25:7: ( 'static' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:25:9: 'static'
            pass 
            self.match("static")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__41"



    # $ANTLR start "T__42"
    def mT__42(self, ):
        try:
            _type = T__42
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:26:7: ( 'typedef' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:26:9: 'typedef'
            pass 
            self.match("typedef")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__42"



    # $ANTLR start "T__43"
    def mT__43(self, ):
        try:
            _type = T__43
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:27:7: ( 'unsigned' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:27:9: 'unsigned'
            pass 
            self.match("unsigned")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__43"



    # $ANTLR start "T__44"
    def mT__44(self, ):
        try:
            _type = T__44
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:28:7: ( 'void' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:28:9: 'void'
            pass 
            self.match("void")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__44"



    # $ANTLR start "T__45"
    def mT__45(self, ):
        try:
            _type = T__45
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:29:7: ( 'volatile' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:29:9: 'volatile'
            pass 
            self.match("volatile")




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "T__45"



    # $ANTLR start "IDENTIFIER"
    def mIDENTIFIER(self, ):
        try:
            _type = IDENTIFIER
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:454:2: ( LETTER ( LETTER | '0' .. '9' )* )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:454:4: LETTER ( LETTER | '0' .. '9' )*
            pass 
            self.mLETTER()


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:454:11: ( LETTER | '0' .. '9' )*
            while True: #loop1
                alt1 = 2
                LA1_0 = self.input.LA(1)

                if (LA1_0 == 36 or (48 <= LA1_0 <= 57) or (65 <= LA1_0 <= 90) or LA1_0 == 95 or (97 <= LA1_0 <= 122)) :
                    alt1 = 1


                if alt1 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:
                    pass 
                    if self.input.LA(1) == 36 or (48 <= self.input.LA(1) <= 57) or (65 <= self.input.LA(1) <= 90) or self.input.LA(1) == 95 or (97 <= self.input.LA(1) <= 122):
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



    # $ANTLR start "LETTER"
    def mLETTER(self, ):
        try:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:460:2: ( '$' | 'A' .. 'Z' | 'a' .. 'z' | '_' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:
            pass 
            if self.input.LA(1) == 36 or (65 <= self.input.LA(1) <= 90) or self.input.LA(1) == 95 or (97 <= self.input.LA(1) <= 122):
                self.input.consume()
            else:
                mse = MismatchedSetException(None, self.input)
                self.recover(mse)
                raise mse






        finally:
            pass

    # $ANTLR end "LETTER"



    # $ANTLR start "CHARACTER_LITERAL"
    def mCHARACTER_LITERAL(self, ):
        try:
            _type = CHARACTER_LITERAL
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:466:5: ( '\\'' ( EscapeSequence |~ ( '\\'' | '\\\\' ) ) '\\'' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:466:9: '\\'' ( EscapeSequence |~ ( '\\'' | '\\\\' ) ) '\\''
            pass 
            self.match(39)

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:466:14: ( EscapeSequence |~ ( '\\'' | '\\\\' ) )
            alt2 = 2
            LA2_0 = self.input.LA(1)

            if (LA2_0 == 92) :
                alt2 = 1
            elif ((0 <= LA2_0 <= 38) or (40 <= LA2_0 <= 91) or (93 <= LA2_0 <= 65535)) :
                alt2 = 2
            else:
                nvae = NoViableAltException("", 2, 0, self.input)

                raise nvae


            if alt2 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:466:16: EscapeSequence
                pass 
                self.mEscapeSequence()



            elif alt2 == 2:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:466:33: ~ ( '\\'' | '\\\\' )
                pass 
                if (0 <= self.input.LA(1) <= 38) or (40 <= self.input.LA(1) <= 91) or (93 <= self.input.LA(1) <= 65535):
                    self.input.consume()
                else:
                    mse = MismatchedSetException(None, self.input)
                    self.recover(mse)
                    raise mse






            self.match(39)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "CHARACTER_LITERAL"



    # $ANTLR start "STRING_LITERAL"
    def mSTRING_LITERAL(self, ):
        try:
            _type = STRING_LITERAL
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:470:5: ( '\"' ( EscapeSequence |~ ( '\\\\' | '\"' ) )* '\"' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:470:8: '\"' ( EscapeSequence |~ ( '\\\\' | '\"' ) )* '\"'
            pass 
            self.match(34)

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:470:12: ( EscapeSequence |~ ( '\\\\' | '\"' ) )*
            while True: #loop3
                alt3 = 3
                LA3_0 = self.input.LA(1)

                if (LA3_0 == 92) :
                    alt3 = 1
                elif ((0 <= LA3_0 <= 33) or (35 <= LA3_0 <= 91) or (93 <= LA3_0 <= 65535)) :
                    alt3 = 2


                if alt3 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:470:14: EscapeSequence
                    pass 
                    self.mEscapeSequence()



                elif alt3 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:470:31: ~ ( '\\\\' | '\"' )
                    pass 
                    if (0 <= self.input.LA(1) <= 33) or (35 <= self.input.LA(1) <= 91) or (93 <= self.input.LA(1) <= 65535):
                        self.input.consume()
                    else:
                        mse = MismatchedSetException(None, self.input)
                        self.recover(mse)
                        raise mse




                else:
                    break #loop3


            self.match(34)



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "STRING_LITERAL"



    # $ANTLR start "HEX_LITERAL"
    def mHEX_LITERAL(self, ):
        try:
            _type = HEX_LITERAL
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:473:13: ( '0' ( 'x' | 'X' ) ( HexDigit )+ ( IntegerTypeSuffix )? )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:473:15: '0' ( 'x' | 'X' ) ( HexDigit )+ ( IntegerTypeSuffix )?
            pass 
            self.match(48)

            if self.input.LA(1) == 88 or self.input.LA(1) == 120:
                self.input.consume()
            else:
                mse = MismatchedSetException(None, self.input)
                self.recover(mse)
                raise mse



            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:473:29: ( HexDigit )+
            cnt4 = 0
            while True: #loop4
                alt4 = 2
                LA4_0 = self.input.LA(1)

                if ((48 <= LA4_0 <= 57) or (65 <= LA4_0 <= 70) or (97 <= LA4_0 <= 102)) :
                    alt4 = 1


                if alt4 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:
                    pass 
                    if (48 <= self.input.LA(1) <= 57) or (65 <= self.input.LA(1) <= 70) or (97 <= self.input.LA(1) <= 102):
                        self.input.consume()
                    else:
                        mse = MismatchedSetException(None, self.input)
                        self.recover(mse)
                        raise mse




                else:
                    if cnt4 >= 1:
                        break #loop4

                    eee = EarlyExitException(4, self.input)
                    raise eee

                cnt4 += 1


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:473:39: ( IntegerTypeSuffix )?
            alt5 = 2
            LA5_0 = self.input.LA(1)

            if (LA5_0 == 76 or LA5_0 == 85 or LA5_0 == 108 or LA5_0 == 117) :
                alt5 = 1
            if alt5 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:473:39: IntegerTypeSuffix
                pass 
                self.mIntegerTypeSuffix()







            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "HEX_LITERAL"



    # $ANTLR start "DECIMAL_LITERAL"
    def mDECIMAL_LITERAL(self, ):
        try:
            _type = DECIMAL_LITERAL
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:475:17: ( ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( IntegerTypeSuffix )? )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:475:19: ( '0' | '1' .. '9' ( '0' .. '9' )* ) ( IntegerTypeSuffix )?
            pass 
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:475:19: ( '0' | '1' .. '9' ( '0' .. '9' )* )
            alt7 = 2
            LA7_0 = self.input.LA(1)

            if (LA7_0 == 48) :
                alt7 = 1
            elif ((49 <= LA7_0 <= 57)) :
                alt7 = 2
            else:
                nvae = NoViableAltException("", 7, 0, self.input)

                raise nvae


            if alt7 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:475:20: '0'
                pass 
                self.match(48)


            elif alt7 == 2:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:475:26: '1' .. '9' ( '0' .. '9' )*
                pass 
                self.matchRange(49, 57)

                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:475:35: ( '0' .. '9' )*
                while True: #loop6
                    alt6 = 2
                    LA6_0 = self.input.LA(1)

                    if ((48 <= LA6_0 <= 57)) :
                        alt6 = 1


                    if alt6 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:
                        pass 
                        if (48 <= self.input.LA(1) <= 57):
                            self.input.consume()
                        else:
                            mse = MismatchedSetException(None, self.input)
                            self.recover(mse)
                            raise mse




                    else:
                        break #loop6





            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:475:46: ( IntegerTypeSuffix )?
            alt8 = 2
            LA8_0 = self.input.LA(1)

            if (LA8_0 == 76 or LA8_0 == 85 or LA8_0 == 108 or LA8_0 == 117) :
                alt8 = 1
            if alt8 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:475:46: IntegerTypeSuffix
                pass 
                self.mIntegerTypeSuffix()







            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "DECIMAL_LITERAL"



    # $ANTLR start "OCTAL_LITERAL"
    def mOCTAL_LITERAL(self, ):
        try:
            _type = OCTAL_LITERAL
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:477:15: ( '0' ( '0' .. '7' )+ ( IntegerTypeSuffix )? )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:477:17: '0' ( '0' .. '7' )+ ( IntegerTypeSuffix )?
            pass 
            self.match(48)

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:477:21: ( '0' .. '7' )+
            cnt9 = 0
            while True: #loop9
                alt9 = 2
                LA9_0 = self.input.LA(1)

                if ((48 <= LA9_0 <= 55)) :
                    alt9 = 1


                if alt9 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:
                    pass 
                    if (48 <= self.input.LA(1) <= 55):
                        self.input.consume()
                    else:
                        mse = MismatchedSetException(None, self.input)
                        self.recover(mse)
                        raise mse




                else:
                    if cnt9 >= 1:
                        break #loop9

                    eee = EarlyExitException(9, self.input)
                    raise eee

                cnt9 += 1


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:477:33: ( IntegerTypeSuffix )?
            alt10 = 2
            LA10_0 = self.input.LA(1)

            if (LA10_0 == 76 or LA10_0 == 85 or LA10_0 == 108 or LA10_0 == 117) :
                alt10 = 1
            if alt10 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:477:33: IntegerTypeSuffix
                pass 
                self.mIntegerTypeSuffix()







            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "OCTAL_LITERAL"



    # $ANTLR start "HexDigit"
    def mHexDigit(self, ):
        try:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:481:10: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:
            pass 
            if (48 <= self.input.LA(1) <= 57) or (65 <= self.input.LA(1) <= 70) or (97 <= self.input.LA(1) <= 102):
                self.input.consume()
            else:
                mse = MismatchedSetException(None, self.input)
                self.recover(mse)
                raise mse






        finally:
            pass

    # $ANTLR end "HexDigit"



    # $ANTLR start "IntegerTypeSuffix"
    def mIntegerTypeSuffix(self, ):
        try:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:485:2: ( ( 'u' | 'U' )? ( 'l' | 'L' ) | ( 'u' | 'U' ) ( 'l' | 'L' )? )
            alt13 = 2
            LA13_0 = self.input.LA(1)

            if (LA13_0 == 85 or LA13_0 == 117) :
                LA13_1 = self.input.LA(2)

                if (LA13_1 == 76 or LA13_1 == 108) :
                    alt13 = 1
                else:
                    alt13 = 2

            elif (LA13_0 == 76 or LA13_0 == 108) :
                alt13 = 1
            else:
                nvae = NoViableAltException("", 13, 0, self.input)

                raise nvae


            if alt13 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:485:4: ( 'u' | 'U' )? ( 'l' | 'L' )
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:485:4: ( 'u' | 'U' )?
                alt11 = 2
                LA11_0 = self.input.LA(1)

                if (LA11_0 == 85 or LA11_0 == 117) :
                    alt11 = 1
                if alt11 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:
                    pass 
                    if self.input.LA(1) == 85 or self.input.LA(1) == 117:
                        self.input.consume()
                    else:
                        mse = MismatchedSetException(None, self.input)
                        self.recover(mse)
                        raise mse






                if self.input.LA(1) == 76 or self.input.LA(1) == 108:
                    self.input.consume()
                else:
                    mse = MismatchedSetException(None, self.input)
                    self.recover(mse)
                    raise mse




            elif alt13 == 2:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:486:4: ( 'u' | 'U' ) ( 'l' | 'L' )?
                pass 
                if self.input.LA(1) == 85 or self.input.LA(1) == 117:
                    self.input.consume()
                else:
                    mse = MismatchedSetException(None, self.input)
                    self.recover(mse)
                    raise mse



                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:486:15: ( 'l' | 'L' )?
                alt12 = 2
                LA12_0 = self.input.LA(1)

                if (LA12_0 == 76 or LA12_0 == 108) :
                    alt12 = 1
                if alt12 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:
                    pass 
                    if self.input.LA(1) == 76 or self.input.LA(1) == 108:
                        self.input.consume()
                    else:
                        mse = MismatchedSetException(None, self.input)
                        self.recover(mse)
                        raise mse








        finally:
            pass

    # $ANTLR end "IntegerTypeSuffix"



    # $ANTLR start "FLOATING_POINT_LITERAL"
    def mFLOATING_POINT_LITERAL(self, ):
        try:
            _type = FLOATING_POINT_LITERAL
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:489:5: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? ( FloatTypeSuffix )? | '.' ( '0' .. '9' )+ ( Exponent )? ( FloatTypeSuffix )? | ( '0' .. '9' )+ Exponent ( FloatTypeSuffix )? | ( '0' .. '9' )+ ( Exponent )? FloatTypeSuffix )
            alt25 = 4
            alt25 = self.dfa25.predict(self.input)
            if alt25 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:489:9: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( Exponent )? ( FloatTypeSuffix )?
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:489:9: ( '0' .. '9' )+
                cnt14 = 0
                while True: #loop14
                    alt14 = 2
                    LA14_0 = self.input.LA(1)

                    if ((48 <= LA14_0 <= 57)) :
                        alt14 = 1


                    if alt14 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:
                        pass 
                        if (48 <= self.input.LA(1) <= 57):
                            self.input.consume()
                        else:
                            mse = MismatchedSetException(None, self.input)
                            self.recover(mse)
                            raise mse




                    else:
                        if cnt14 >= 1:
                            break #loop14

                        eee = EarlyExitException(14, self.input)
                        raise eee

                    cnt14 += 1


                self.match(46)

                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:489:25: ( '0' .. '9' )*
                while True: #loop15
                    alt15 = 2
                    LA15_0 = self.input.LA(1)

                    if ((48 <= LA15_0 <= 57)) :
                        alt15 = 1


                    if alt15 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:
                        pass 
                        if (48 <= self.input.LA(1) <= 57):
                            self.input.consume()
                        else:
                            mse = MismatchedSetException(None, self.input)
                            self.recover(mse)
                            raise mse




                    else:
                        break #loop15


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:489:37: ( Exponent )?
                alt16 = 2
                LA16_0 = self.input.LA(1)

                if (LA16_0 == 69 or LA16_0 == 101) :
                    alt16 = 1
                if alt16 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:489:37: Exponent
                    pass 
                    self.mExponent()





                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:489:47: ( FloatTypeSuffix )?
                alt17 = 2
                LA17_0 = self.input.LA(1)

                if (LA17_0 == 68 or LA17_0 == 70 or LA17_0 == 100 or LA17_0 == 102) :
                    alt17 = 1
                if alt17 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:
                    pass 
                    if self.input.LA(1) == 68 or self.input.LA(1) == 70 or self.input.LA(1) == 100 or self.input.LA(1) == 102:
                        self.input.consume()
                    else:
                        mse = MismatchedSetException(None, self.input)
                        self.recover(mse)
                        raise mse







            elif alt25 == 2:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:490:9: '.' ( '0' .. '9' )+ ( Exponent )? ( FloatTypeSuffix )?
                pass 
                self.match(46)

                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:490:13: ( '0' .. '9' )+
                cnt18 = 0
                while True: #loop18
                    alt18 = 2
                    LA18_0 = self.input.LA(1)

                    if ((48 <= LA18_0 <= 57)) :
                        alt18 = 1


                    if alt18 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:
                        pass 
                        if (48 <= self.input.LA(1) <= 57):
                            self.input.consume()
                        else:
                            mse = MismatchedSetException(None, self.input)
                            self.recover(mse)
                            raise mse




                    else:
                        if cnt18 >= 1:
                            break #loop18

                        eee = EarlyExitException(18, self.input)
                        raise eee

                    cnt18 += 1


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:490:25: ( Exponent )?
                alt19 = 2
                LA19_0 = self.input.LA(1)

                if (LA19_0 == 69 or LA19_0 == 101) :
                    alt19 = 1
                if alt19 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:490:25: Exponent
                    pass 
                    self.mExponent()





                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:490:35: ( FloatTypeSuffix )?
                alt20 = 2
                LA20_0 = self.input.LA(1)

                if (LA20_0 == 68 or LA20_0 == 70 or LA20_0 == 100 or LA20_0 == 102) :
                    alt20 = 1
                if alt20 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:
                    pass 
                    if self.input.LA(1) == 68 or self.input.LA(1) == 70 or self.input.LA(1) == 100 or self.input.LA(1) == 102:
                        self.input.consume()
                    else:
                        mse = MismatchedSetException(None, self.input)
                        self.recover(mse)
                        raise mse







            elif alt25 == 3:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:491:9: ( '0' .. '9' )+ Exponent ( FloatTypeSuffix )?
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:491:9: ( '0' .. '9' )+
                cnt21 = 0
                while True: #loop21
                    alt21 = 2
                    LA21_0 = self.input.LA(1)

                    if ((48 <= LA21_0 <= 57)) :
                        alt21 = 1


                    if alt21 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:
                        pass 
                        if (48 <= self.input.LA(1) <= 57):
                            self.input.consume()
                        else:
                            mse = MismatchedSetException(None, self.input)
                            self.recover(mse)
                            raise mse




                    else:
                        if cnt21 >= 1:
                            break #loop21

                        eee = EarlyExitException(21, self.input)
                        raise eee

                    cnt21 += 1


                self.mExponent()


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:491:30: ( FloatTypeSuffix )?
                alt22 = 2
                LA22_0 = self.input.LA(1)

                if (LA22_0 == 68 or LA22_0 == 70 or LA22_0 == 100 or LA22_0 == 102) :
                    alt22 = 1
                if alt22 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:
                    pass 
                    if self.input.LA(1) == 68 or self.input.LA(1) == 70 or self.input.LA(1) == 100 or self.input.LA(1) == 102:
                        self.input.consume()
                    else:
                        mse = MismatchedSetException(None, self.input)
                        self.recover(mse)
                        raise mse







            elif alt25 == 4:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:492:9: ( '0' .. '9' )+ ( Exponent )? FloatTypeSuffix
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:492:9: ( '0' .. '9' )+
                cnt23 = 0
                while True: #loop23
                    alt23 = 2
                    LA23_0 = self.input.LA(1)

                    if ((48 <= LA23_0 <= 57)) :
                        alt23 = 1


                    if alt23 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:
                        pass 
                        if (48 <= self.input.LA(1) <= 57):
                            self.input.consume()
                        else:
                            mse = MismatchedSetException(None, self.input)
                            self.recover(mse)
                            raise mse




                    else:
                        if cnt23 >= 1:
                            break #loop23

                        eee = EarlyExitException(23, self.input)
                        raise eee

                    cnt23 += 1


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:492:21: ( Exponent )?
                alt24 = 2
                LA24_0 = self.input.LA(1)

                if (LA24_0 == 69 or LA24_0 == 101) :
                    alt24 = 1
                if alt24 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:492:21: Exponent
                    pass 
                    self.mExponent()





                self.mFloatTypeSuffix()



            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "FLOATING_POINT_LITERAL"



    # $ANTLR start "Exponent"
    def mExponent(self, ):
        try:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:497:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:497:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            pass 
            if self.input.LA(1) == 69 or self.input.LA(1) == 101:
                self.input.consume()
            else:
                mse = MismatchedSetException(None, self.input)
                self.recover(mse)
                raise mse



            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:497:22: ( '+' | '-' )?
            alt26 = 2
            LA26_0 = self.input.LA(1)

            if (LA26_0 == 43 or LA26_0 == 45) :
                alt26 = 1
            if alt26 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:
                pass 
                if self.input.LA(1) == 43 or self.input.LA(1) == 45:
                    self.input.consume()
                else:
                    mse = MismatchedSetException(None, self.input)
                    self.recover(mse)
                    raise mse






            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:497:33: ( '0' .. '9' )+
            cnt27 = 0
            while True: #loop27
                alt27 = 2
                LA27_0 = self.input.LA(1)

                if ((48 <= LA27_0 <= 57)) :
                    alt27 = 1


                if alt27 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:
                    pass 
                    if (48 <= self.input.LA(1) <= 57):
                        self.input.consume()
                    else:
                        mse = MismatchedSetException(None, self.input)
                        self.recover(mse)
                        raise mse




                else:
                    if cnt27 >= 1:
                        break #loop27

                    eee = EarlyExitException(27, self.input)
                    raise eee

                cnt27 += 1





        finally:
            pass

    # $ANTLR end "Exponent"



    # $ANTLR start "FloatTypeSuffix"
    def mFloatTypeSuffix(self, ):
        try:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:500:17: ( ( 'f' | 'F' | 'd' | 'D' ) )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:
            pass 
            if self.input.LA(1) == 68 or self.input.LA(1) == 70 or self.input.LA(1) == 100 or self.input.LA(1) == 102:
                self.input.consume()
            else:
                mse = MismatchedSetException(None, self.input)
                self.recover(mse)
                raise mse






        finally:
            pass

    # $ANTLR end "FloatTypeSuffix"



    # $ANTLR start "EscapeSequence"
    def mEscapeSequence(self, ):
        try:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:504:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | OctalEscape )
            alt28 = 2
            LA28_0 = self.input.LA(1)

            if (LA28_0 == 92) :
                LA28_1 = self.input.LA(2)

                if (LA28_1 == 34 or LA28_1 == 39 or LA28_1 == 92 or LA28_1 == 98 or LA28_1 == 102 or LA28_1 == 110 or LA28_1 == 114 or LA28_1 == 116) :
                    alt28 = 1
                elif ((48 <= LA28_1 <= 55)) :
                    alt28 = 2
                else:
                    nvae = NoViableAltException("", 28, 1, self.input)

                    raise nvae


            else:
                nvae = NoViableAltException("", 28, 0, self.input)

                raise nvae


            if alt28 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:504:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                pass 
                self.match(92)

                if self.input.LA(1) == 34 or self.input.LA(1) == 39 or self.input.LA(1) == 92 or self.input.LA(1) == 98 or self.input.LA(1) == 102 or self.input.LA(1) == 110 or self.input.LA(1) == 114 or self.input.LA(1) == 116:
                    self.input.consume()
                else:
                    mse = MismatchedSetException(None, self.input)
                    self.recover(mse)
                    raise mse




            elif alt28 == 2:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:505:9: OctalEscape
                pass 
                self.mOctalEscape()




        finally:
            pass

    # $ANTLR end "EscapeSequence"



    # $ANTLR start "OctalEscape"
    def mOctalEscape(self, ):
        try:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:510:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            alt29 = 3
            LA29_0 = self.input.LA(1)

            if (LA29_0 == 92) :
                LA29_1 = self.input.LA(2)

                if ((48 <= LA29_1 <= 51)) :
                    LA29_2 = self.input.LA(3)

                    if ((48 <= LA29_2 <= 55)) :
                        LA29_4 = self.input.LA(4)

                        if ((48 <= LA29_4 <= 55)) :
                            alt29 = 1
                        else:
                            alt29 = 2

                    else:
                        alt29 = 3

                elif ((52 <= LA29_1 <= 55)) :
                    LA29_3 = self.input.LA(3)

                    if ((48 <= LA29_3 <= 55)) :
                        alt29 = 2
                    else:
                        alt29 = 3

                else:
                    nvae = NoViableAltException("", 29, 1, self.input)

                    raise nvae


            else:
                nvae = NoViableAltException("", 29, 0, self.input)

                raise nvae


            if alt29 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:510:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                pass 
                self.match(92)

                if (48 <= self.input.LA(1) <= 51):
                    self.input.consume()
                else:
                    mse = MismatchedSetException(None, self.input)
                    self.recover(mse)
                    raise mse



                if (48 <= self.input.LA(1) <= 55):
                    self.input.consume()
                else:
                    mse = MismatchedSetException(None, self.input)
                    self.recover(mse)
                    raise mse



                if (48 <= self.input.LA(1) <= 55):
                    self.input.consume()
                else:
                    mse = MismatchedSetException(None, self.input)
                    self.recover(mse)
                    raise mse




            elif alt29 == 2:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:511:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                pass 
                self.match(92)

                if (48 <= self.input.LA(1) <= 55):
                    self.input.consume()
                else:
                    mse = MismatchedSetException(None, self.input)
                    self.recover(mse)
                    raise mse



                if (48 <= self.input.LA(1) <= 55):
                    self.input.consume()
                else:
                    mse = MismatchedSetException(None, self.input)
                    self.recover(mse)
                    raise mse




            elif alt29 == 3:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:512:9: '\\\\' ( '0' .. '7' )
                pass 
                self.match(92)

                if (48 <= self.input.LA(1) <= 55):
                    self.input.consume()
                else:
                    mse = MismatchedSetException(None, self.input)
                    self.recover(mse)
                    raise mse





        finally:
            pass

    # $ANTLR end "OctalEscape"



    # $ANTLR start "UnicodeEscape"
    def mUnicodeEscape(self, ):
        try:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:517:5: ( '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:517:9: '\\\\' 'u' HexDigit HexDigit HexDigit HexDigit
            pass 
            self.match(92)

            self.match(117)

            self.mHexDigit()


            self.mHexDigit()


            self.mHexDigit()


            self.mHexDigit()





        finally:
            pass

    # $ANTLR end "UnicodeEscape"



    # $ANTLR start "WS"
    def mWS(self, ):
        try:
            _type = WS
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:519:5: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:519:8: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
            pass 
            if (9 <= self.input.LA(1) <= 10) or (12 <= self.input.LA(1) <= 13) or self.input.LA(1) == 32:
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



    # $ANTLR start "COMMENT"
    def mCOMMENT(self, ):
        try:
            _type = COMMENT
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:523:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:523:9: '/*' ( options {greedy=false; } : . )* '*/'
            pass 
            self.match("/*")


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:523:14: ( options {greedy=false; } : . )*
            while True: #loop30
                alt30 = 2
                LA30_0 = self.input.LA(1)

                if (LA30_0 == 42) :
                    LA30_1 = self.input.LA(2)

                    if (LA30_1 == 47) :
                        alt30 = 2
                    elif ((0 <= LA30_1 <= 46) or (48 <= LA30_1 <= 65535)) :
                        alt30 = 1


                elif ((0 <= LA30_0 <= 41) or (43 <= LA30_0 <= 65535)) :
                    alt30 = 1


                if alt30 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:523:42: .
                    pass 
                    self.matchAny()


                else:
                    break #loop30


            self.match("*/")


            #action start
            _channel=HIDDEN;
            #action end




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "COMMENT"



    # $ANTLR start "LINE_COMMENT"
    def mLINE_COMMENT(self, ):
        try:
            _type = LINE_COMMENT
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:527:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:527:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            pass 
            self.match("//")


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:527:12: (~ ( '\\n' | '\\r' ) )*
            while True: #loop31
                alt31 = 2
                LA31_0 = self.input.LA(1)

                if ((0 <= LA31_0 <= 9) or (11 <= LA31_0 <= 12) or (14 <= LA31_0 <= 65535)) :
                    alt31 = 1


                if alt31 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:
                    pass 
                    if (0 <= self.input.LA(1) <= 9) or (11 <= self.input.LA(1) <= 12) or (14 <= self.input.LA(1) <= 65535):
                        self.input.consume()
                    else:
                        mse = MismatchedSetException(None, self.input)
                        self.recover(mse)
                        raise mse




                else:
                    break #loop31


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:527:26: ( '\\r' )?
            alt32 = 2
            LA32_0 = self.input.LA(1)

            if (LA32_0 == 13) :
                alt32 = 1
            if alt32 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:527:26: '\\r'
                pass 
                self.match(13)




            self.match(10)

            #action start
            _channel=HIDDEN;
            #action end




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "LINE_COMMENT"



    # $ANTLR start "LINE_COMMAND"
    def mLINE_COMMAND(self, ):
        try:
            _type = LINE_COMMAND
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:532:5: ( '#' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:532:7: '#' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            pass 
            self.match(35)

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:532:11: (~ ( '\\n' | '\\r' ) )*
            while True: #loop33
                alt33 = 2
                LA33_0 = self.input.LA(1)

                if ((0 <= LA33_0 <= 9) or (11 <= LA33_0 <= 12) or (14 <= LA33_0 <= 65535)) :
                    alt33 = 1


                if alt33 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:
                    pass 
                    if (0 <= self.input.LA(1) <= 9) or (11 <= self.input.LA(1) <= 12) or (14 <= self.input.LA(1) <= 65535):
                        self.input.consume()
                    else:
                        mse = MismatchedSetException(None, self.input)
                        self.recover(mse)
                        raise mse




                else:
                    break #loop33


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:532:25: ( '\\r' )?
            alt34 = 2
            LA34_0 = self.input.LA(1)

            if (LA34_0 == 13) :
                alt34 = 1
            if alt34 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:532:25: '\\r'
                pass 
                self.match(13)




            self.match(10)

            #action start
            _channel=HIDDEN;
            #action end




            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "LINE_COMMAND"



    def mTokens(self):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:8: ( T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | IDENTIFIER | CHARACTER_LITERAL | STRING_LITERAL | HEX_LITERAL | DECIMAL_LITERAL | OCTAL_LITERAL | FLOATING_POINT_LITERAL | WS | COMMENT | LINE_COMMENT | LINE_COMMAND )
        alt35 = 34
        alt35 = self.dfa35.predict(self.input)
        if alt35 == 1:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:10: T__23
            pass 
            self.mT__23()



        elif alt35 == 2:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:16: T__24
            pass 
            self.mT__24()



        elif alt35 == 3:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:22: T__25
            pass 
            self.mT__25()



        elif alt35 == 4:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:28: T__26
            pass 
            self.mT__26()



        elif alt35 == 5:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:34: T__27
            pass 
            self.mT__27()



        elif alt35 == 6:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:40: T__28
            pass 
            self.mT__28()



        elif alt35 == 7:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:46: T__29
            pass 
            self.mT__29()



        elif alt35 == 8:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:52: T__30
            pass 
            self.mT__30()



        elif alt35 == 9:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:58: T__31
            pass 
            self.mT__31()



        elif alt35 == 10:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:64: T__32
            pass 
            self.mT__32()



        elif alt35 == 11:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:70: T__33
            pass 
            self.mT__33()



        elif alt35 == 12:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:76: T__34
            pass 
            self.mT__34()



        elif alt35 == 13:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:82: T__35
            pass 
            self.mT__35()



        elif alt35 == 14:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:88: T__36
            pass 
            self.mT__36()



        elif alt35 == 15:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:94: T__37
            pass 
            self.mT__37()



        elif alt35 == 16:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:100: T__38
            pass 
            self.mT__38()



        elif alt35 == 17:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:106: T__39
            pass 
            self.mT__39()



        elif alt35 == 18:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:112: T__40
            pass 
            self.mT__40()



        elif alt35 == 19:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:118: T__41
            pass 
            self.mT__41()



        elif alt35 == 20:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:124: T__42
            pass 
            self.mT__42()



        elif alt35 == 21:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:130: T__43
            pass 
            self.mT__43()



        elif alt35 == 22:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:136: T__44
            pass 
            self.mT__44()



        elif alt35 == 23:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:142: T__45
            pass 
            self.mT__45()



        elif alt35 == 24:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:148: IDENTIFIER
            pass 
            self.mIDENTIFIER()



        elif alt35 == 25:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:159: CHARACTER_LITERAL
            pass 
            self.mCHARACTER_LITERAL()



        elif alt35 == 26:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:177: STRING_LITERAL
            pass 
            self.mSTRING_LITERAL()



        elif alt35 == 27:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:192: HEX_LITERAL
            pass 
            self.mHEX_LITERAL()



        elif alt35 == 28:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:204: DECIMAL_LITERAL
            pass 
            self.mDECIMAL_LITERAL()



        elif alt35 == 29:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:220: OCTAL_LITERAL
            pass 
            self.mOCTAL_LITERAL()



        elif alt35 == 30:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:234: FLOATING_POINT_LITERAL
            pass 
            self.mFLOATING_POINT_LITERAL()



        elif alt35 == 31:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:257: WS
            pass 
            self.mWS()



        elif alt35 == 32:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:260: COMMENT
            pass 
            self.mCOMMENT()



        elif alt35 == 33:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:268: LINE_COMMENT
            pass 
            self.mLINE_COMMENT()



        elif alt35 == 34:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:1:281: LINE_COMMAND
            pass 
            self.mLINE_COMMAND()








    # lookup tables for DFA #25

    DFA25_eot = DFA.unpack(
        u"\7\uffff\1\10\2\uffff"
        )

    DFA25_eof = DFA.unpack(
        u"\12\uffff"
        )

    DFA25_min = DFA.unpack(
        u"\2\56\2\uffff\1\53\1\uffff\2\60\2\uffff"
        )

    DFA25_max = DFA.unpack(
        u"\1\71\1\146\2\uffff\1\71\1\uffff\1\71\1\146\2\uffff"
        )

    DFA25_accept = DFA.unpack(
        u"\2\uffff\1\2\1\1\1\uffff\1\4\2\uffff\2\3"
        )

    DFA25_special = DFA.unpack(
        u"\12\uffff"
        )


    DFA25_transition = [
        DFA.unpack(u"\1\2\1\uffff\12\1"),
        DFA.unpack(u"\1\3\1\uffff\12\1\12\uffff\1\5\1\4\1\5\35\uffff\1\5"
        u"\1\4\1\5"),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u"\1\6\1\uffff\1\6\2\uffff\12\7"),
        DFA.unpack(u""),
        DFA.unpack(u"\12\7"),
        DFA.unpack(u"\12\7\12\uffff\1\11\1\uffff\1\11\35\uffff\1\11\1\uffff"
        u"\1\11"),
        DFA.unpack(u""),
        DFA.unpack(u"")
    ]

    # class definition for DFA #25

    class DFA25(DFA):
        pass


    # lookup tables for DFA #35

    DFA35_eot = DFA.unpack(
        u"\10\uffff\14\24\3\uffff\2\55\4\uffff\17\24\2\uffff\1\102\1\55\2"
        u"\uffff\6\24\1\111\11\24\1\uffff\1\123\1\124\4\24\1\uffff\1\131"
        u"\6\24\1\140\1\24\2\uffff\1\142\2\24\1\145\1\uffff\1\24\1\147\4"
        u"\24\1\uffff\1\24\1\uffff\1\155\1\156\1\uffff\1\24\1\uffff\1\160"
        u"\1\161\3\24\2\uffff\1\24\2\uffff\1\166\2\24\1\171\1\uffff\1\172"
        u"\1\173\3\uffff"
        )

    DFA35_eof = DFA.unpack(
        u"\174\uffff"
        )

    DFA35_min = DFA.unpack(
        u"\1\11\7\uffff\1\165\1\150\1\157\1\170\1\154\1\156\1\157\1\145\1"
        u"\150\1\171\1\156\1\157\3\uffff\2\56\2\uffff\1\52\1\uffff\1\164"
        u"\1\141\1\156\1\165\1\164\1\157\1\164\1\156\1\147\1\157\1\147\1"
        u"\141\1\160\1\163\1\151\2\uffff\2\56\2\uffff\1\157\1\162\1\163\1"
        u"\142\1\145\1\141\1\44\1\147\1\151\1\162\1\156\1\164\1\145\1\151"
        u"\1\144\1\141\1\uffff\2\44\1\164\1\154\1\162\1\164\1\uffff\1\44"
        u"\1\163\1\164\1\145\1\151\1\144\1\147\1\44\1\164\2\uffff\1\44\1"
        u"\145\1\156\1\44\1\uffff\1\164\1\44\1\144\1\143\1\145\1\156\1\uffff"
        u"\1\151\1\uffff\2\44\1\uffff\1\145\1\uffff\2\44\1\146\1\145\1\154"
        u"\2\uffff\1\162\2\uffff\1\44\1\144\1\145\1\44\1\uffff\2\44\3\uffff"
        )

    DFA35_max = DFA.unpack(
        u"\1\172\7\uffff\1\165\2\157\1\170\1\154\1\156\1\157\1\145\1\164"
        u"\1\171\1\156\1\157\3\uffff\1\170\1\146\2\uffff\1\57\1\uffff\1\164"
        u"\1\141\1\156\1\165\1\164\1\157\1\164\1\156\1\147\1\157\1\147\1"
        u"\141\1\160\1\163\1\154\2\uffff\2\146\2\uffff\1\157\1\162\1\163"
        u"\1\142\1\145\1\141\1\172\1\147\1\151\1\162\1\156\1\164\1\145\1"
        u"\151\1\144\1\141\1\uffff\2\172\1\164\1\154\1\162\1\164\1\uffff"
        u"\1\172\1\163\1\164\1\145\1\151\1\144\1\147\1\172\1\164\2\uffff"
        u"\1\172\1\145\1\156\1\172\1\uffff\1\164\1\172\1\144\1\143\1\145"
        u"\1\156\1\uffff\1\151\1\uffff\2\172\1\uffff\1\145\1\uffff\2\172"
        u"\1\146\1\145\1\154\2\uffff\1\162\2\uffff\1\172\1\144\1\145\1\172"
        u"\1\uffff\2\172\3\uffff"
        )

    DFA35_accept = DFA.unpack(
        u"\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\14\uffff\1\30\1\31\1\32\2"
        u"\uffff\1\36\1\37\1\uffff\1\42\17\uffff\1\33\1\34\2\uffff\1\40\1"
        u"\41\20\uffff\1\35\6\uffff\1\16\11\uffff\1\10\1\11\4\uffff\1\17"
        u"\6\uffff\1\26\1\uffff\1\12\2\uffff\1\15\1\uffff\1\21\5\uffff\1"
        u"\13\1\14\1\uffff\1\22\1\23\4\uffff\1\24\2\uffff\1\20\1\25\1\27"
        )

    DFA35_special = DFA.unpack(
        u"\174\uffff"
        )


    DFA35_transition = [
        DFA.unpack(u"\2\32\1\uffff\2\32\22\uffff\1\32\1\uffff\1\26\1\34\1"
        u"\24\2\uffff\1\25\1\1\1\2\1\3\1\uffff\1\4\1\uffff\1\31\1\33\1\27"
        u"\11\30\1\uffff\1\5\5\uffff\32\24\1\6\1\uffff\1\7\1\uffff\1\24\1"
        u"\uffff\1\10\1\24\1\11\1\12\1\13\1\14\2\24\1\15\2\24\1\16\5\24\1"
        u"\17\1\20\1\21\1\22\1\23\4\24"),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u"\1\35"),
        DFA.unpack(u"\1\36\6\uffff\1\37"),
        DFA.unpack(u"\1\40"),
        DFA.unpack(u"\1\41"),
        DFA.unpack(u"\1\42"),
        DFA.unpack(u"\1\43"),
        DFA.unpack(u"\1\44"),
        DFA.unpack(u"\1\45"),
        DFA.unpack(u"\1\46\1\47\12\uffff\1\50"),
        DFA.unpack(u"\1\51"),
        DFA.unpack(u"\1\52"),
        DFA.unpack(u"\1\53"),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u"\1\31\1\uffff\10\56\2\31\12\uffff\3\31\21\uffff\1\54"
        u"\13\uffff\3\31\21\uffff\1\54"),
        DFA.unpack(u"\1\31\1\uffff\12\57\12\uffff\3\31\35\uffff\3\31"),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u"\1\60\4\uffff\1\61"),
        DFA.unpack(u""),
        DFA.unpack(u"\1\62"),
        DFA.unpack(u"\1\63"),
        DFA.unpack(u"\1\64"),
        DFA.unpack(u"\1\65"),
        DFA.unpack(u"\1\66"),
        DFA.unpack(u"\1\67"),
        DFA.unpack(u"\1\70"),
        DFA.unpack(u"\1\71"),
        DFA.unpack(u"\1\72"),
        DFA.unpack(u"\1\73"),
        DFA.unpack(u"\1\74"),
        DFA.unpack(u"\1\75"),
        DFA.unpack(u"\1\76"),
        DFA.unpack(u"\1\77"),
        DFA.unpack(u"\1\100\2\uffff\1\101"),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u"\1\31\1\uffff\10\56\2\31\12\uffff\3\31\35\uffff\3\31"),
        DFA.unpack(u"\1\31\1\uffff\12\57\12\uffff\3\31\35\uffff\3\31"),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u"\1\103"),
        DFA.unpack(u"\1\104"),
        DFA.unpack(u"\1\105"),
        DFA.unpack(u"\1\106"),
        DFA.unpack(u"\1\107"),
        DFA.unpack(u"\1\110"),
        DFA.unpack(u"\1\24\13\uffff\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff"
        u"\32\24"),
        DFA.unpack(u"\1\112"),
        DFA.unpack(u"\1\113"),
        DFA.unpack(u"\1\114"),
        DFA.unpack(u"\1\115"),
        DFA.unpack(u"\1\116"),
        DFA.unpack(u"\1\117"),
        DFA.unpack(u"\1\120"),
        DFA.unpack(u"\1\121"),
        DFA.unpack(u"\1\122"),
        DFA.unpack(u""),
        DFA.unpack(u"\1\24\13\uffff\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff"
        u"\32\24"),
        DFA.unpack(u"\1\24\13\uffff\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff"
        u"\32\24"),
        DFA.unpack(u"\1\125"),
        DFA.unpack(u"\1\126"),
        DFA.unpack(u"\1\127"),
        DFA.unpack(u"\1\130"),
        DFA.unpack(u""),
        DFA.unpack(u"\1\24\13\uffff\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff"
        u"\32\24"),
        DFA.unpack(u"\1\132"),
        DFA.unpack(u"\1\133"),
        DFA.unpack(u"\1\134"),
        DFA.unpack(u"\1\135"),
        DFA.unpack(u"\1\136"),
        DFA.unpack(u"\1\137"),
        DFA.unpack(u"\1\24\13\uffff\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff"
        u"\32\24"),
        DFA.unpack(u"\1\141"),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u"\1\24\13\uffff\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff"
        u"\32\24"),
        DFA.unpack(u"\1\143"),
        DFA.unpack(u"\1\144"),
        DFA.unpack(u"\1\24\13\uffff\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff"
        u"\32\24"),
        DFA.unpack(u""),
        DFA.unpack(u"\1\146"),
        DFA.unpack(u"\1\24\13\uffff\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff"
        u"\32\24"),
        DFA.unpack(u"\1\150"),
        DFA.unpack(u"\1\151"),
        DFA.unpack(u"\1\152"),
        DFA.unpack(u"\1\153"),
        DFA.unpack(u""),
        DFA.unpack(u"\1\154"),
        DFA.unpack(u""),
        DFA.unpack(u"\1\24\13\uffff\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff"
        u"\32\24"),
        DFA.unpack(u"\1\24\13\uffff\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff"
        u"\32\24"),
        DFA.unpack(u""),
        DFA.unpack(u"\1\157"),
        DFA.unpack(u""),
        DFA.unpack(u"\1\24\13\uffff\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff"
        u"\32\24"),
        DFA.unpack(u"\1\24\13\uffff\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff"
        u"\32\24"),
        DFA.unpack(u"\1\162"),
        DFA.unpack(u"\1\163"),
        DFA.unpack(u"\1\164"),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u"\1\165"),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u"\1\24\13\uffff\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff"
        u"\32\24"),
        DFA.unpack(u"\1\167"),
        DFA.unpack(u"\1\170"),
        DFA.unpack(u"\1\24\13\uffff\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff"
        u"\32\24"),
        DFA.unpack(u""),
        DFA.unpack(u"\1\24\13\uffff\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff"
        u"\32\24"),
        DFA.unpack(u"\1\24\13\uffff\12\24\7\uffff\32\24\4\uffff\1\24\1\uffff"
        u"\32\24"),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u"")
    ]

    # class definition for DFA #35

    class DFA35(DFA):
        pass


 



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import LexerMain
    main = LexerMain(t033backtrackingLexer)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
