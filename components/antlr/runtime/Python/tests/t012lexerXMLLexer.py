# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g 2013-01-03 10:53:08

import sys
from antlr3 import *
from antlr3.compat import set, frozenset

        
from cStringIO import StringIO



# for convenience in actions
HIDDEN = BaseRecognizer.HIDDEN

# token types
EOF=-1
ATTRIBUTE=4
CDATA=5
COMMENT=6
DOCTYPE=7
DOCUMENT=8
ELEMENT=9
EMPTY_ELEMENT=10
END_TAG=11
GENERIC_ID=12
INTERNAL_DTD=13
LETTER=14
PCDATA=15
PI=16
START_TAG=17
VALUE=18
WS=19
XMLDECL=20


class t012lexerXMLLexer(Lexer):

    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g"
    api_version = 1

    def __init__(self, input=None, state=None):
        if state is None:
            state = RecognizerSharedState()
        super(t012lexerXMLLexer, self).__init__(input, state)

        self.delegates = []

        self.dfa18 = self.DFA18(
            self, 18,
            eot = self.DFA18_eot,
            eof = self.DFA18_eof,
            min = self.DFA18_min,
            max = self.DFA18_max,
            accept = self.DFA18_accept,
            special = self.DFA18_special,
            transition = self.DFA18_transition
            )


                     
        self.outbuf = StringIO()



                    
    def output(self, line):
        self.outbuf.write(line.encode('utf-8') + "\n")



    # $ANTLR start "DOCUMENT"
    def mDOCUMENT(self, ):
        try:
            _type = DOCUMENT
            _channel = DEFAULT_CHANNEL

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:20:5: ( ( XMLDECL )? ( WS )? ( DOCTYPE )? ( WS )? ELEMENT ( WS )? )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:20:8: ( XMLDECL )? ( WS )? ( DOCTYPE )? ( WS )? ELEMENT ( WS )?
            pass 
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:20:8: ( XMLDECL )?
            alt1 = 2
            LA1_0 = self.input.LA(1)

            if (LA1_0 == 60) :
                LA1_1 = self.input.LA(2)

                if (LA1_1 == 63) :
                    alt1 = 1
            if alt1 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:20:8: XMLDECL
                pass 
                self.mXMLDECL()





            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:20:17: ( WS )?
            alt2 = 2
            LA2 = self.input.LA(1)
            if LA2 == 32:
                alt2 = 1
            elif LA2 == 9:
                alt2 = 1
            elif LA2 == 10:
                alt2 = 1
            elif LA2 == 13:
                alt2 = 1
            if alt2 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:20:17: WS
                pass 
                self.mWS()





            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:20:21: ( DOCTYPE )?
            alt3 = 2
            LA3_0 = self.input.LA(1)

            if (LA3_0 == 60) :
                LA3_1 = self.input.LA(2)

                if (LA3_1 == 33) :
                    alt3 = 1
            if alt3 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:20:21: DOCTYPE
                pass 
                self.mDOCTYPE()





            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:20:30: ( WS )?
            alt4 = 2
            LA4_0 = self.input.LA(1)

            if ((9 <= LA4_0 <= 10) or LA4_0 == 13 or LA4_0 == 32) :
                alt4 = 1
            if alt4 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:20:30: WS
                pass 
                self.mWS()





            self.mELEMENT()


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:20:42: ( WS )?
            alt5 = 2
            LA5_0 = self.input.LA(1)

            if ((9 <= LA5_0 <= 10) or LA5_0 == 13 or LA5_0 == 32) :
                alt5 = 1
            if alt5 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:20:42: WS
                pass 
                self.mWS()







            self._state.type = _type
            self._state.channel = _channel
        finally:
            pass

    # $ANTLR end "DOCUMENT"



    # $ANTLR start "DOCTYPE"
    def mDOCTYPE(self, ):
        try:
            rootElementName = None
            sys1 = None
            pub = None
            sys2 = None
            dtd = None

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:24:5: ( '<!DOCTYPE' WS rootElementName= GENERIC_ID WS ( ( 'SYSTEM' WS sys1= VALUE | 'PUBLIC' WS pub= VALUE WS sys2= VALUE ) ( WS )? )? (dtd= INTERNAL_DTD )? '>' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:25:9: '<!DOCTYPE' WS rootElementName= GENERIC_ID WS ( ( 'SYSTEM' WS sys1= VALUE | 'PUBLIC' WS pub= VALUE WS sys2= VALUE ) ( WS )? )? (dtd= INTERNAL_DTD )? '>'
            pass 
            self.match("<!DOCTYPE")


            self.mWS()


            rootElementNameStart103 = self.getCharIndex()
            self.mGENERIC_ID()
            rootElementNameStartLine103 = self.getLine()
            rootElementNameStartCharPos103 = self.getCharPositionInLine()
            rootElementName = CommonToken(
                input=self.input,
                type=INVALID_TOKEN_TYPE,
                channel=DEFAULT_CHANNEL,
                start=rootElementNameStart103,
                stop=self.getCharIndex()-1)
            rootElementName.setLine(rootElementNameStartLine103)
            rootElementName.setCharPositionInLine(rootElementNameStartCharPos103)


            #action start
            self.output("ROOTELEMENT: "+rootElementName.text)
            #action end


            self.mWS()


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:28:9: ( ( 'SYSTEM' WS sys1= VALUE | 'PUBLIC' WS pub= VALUE WS sys2= VALUE ) ( WS )? )?
            alt8 = 2
            LA8_0 = self.input.LA(1)

            if (LA8_0 == 80 or LA8_0 == 83) :
                alt8 = 1
            if alt8 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:29:13: ( 'SYSTEM' WS sys1= VALUE | 'PUBLIC' WS pub= VALUE WS sys2= VALUE ) ( WS )?
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:29:13: ( 'SYSTEM' WS sys1= VALUE | 'PUBLIC' WS pub= VALUE WS sys2= VALUE )
                alt6 = 2
                LA6_0 = self.input.LA(1)

                if (LA6_0 == 83) :
                    alt6 = 1
                elif (LA6_0 == 80) :
                    alt6 = 2
                else:
                    nvae = NoViableAltException("", 6, 0, self.input)

                    raise nvae


                if alt6 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:29:15: 'SYSTEM' WS sys1= VALUE
                    pass 
                    self.match("SYSTEM")


                    self.mWS()


                    sys1Start157 = self.getCharIndex()
                    self.mVALUE()
                    sys1StartLine157 = self.getLine()
                    sys1StartCharPos157 = self.getCharPositionInLine()
                    sys1 = CommonToken(
                        input=self.input,
                        type=INVALID_TOKEN_TYPE,
                        channel=DEFAULT_CHANNEL,
                        start=sys1Start157,
                        stop=self.getCharIndex()-1)
                    sys1.setLine(sys1StartLine157)
                    sys1.setCharPositionInLine(sys1StartCharPos157)


                    #action start
                    self.output("SYSTEM: "+sys1.text)
                    #action end



                elif alt6 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:32:15: 'PUBLIC' WS pub= VALUE WS sys2= VALUE
                    pass 
                    self.match("PUBLIC")


                    self.mWS()


                    pubStart214 = self.getCharIndex()
                    self.mVALUE()
                    pubStartLine214 = self.getLine()
                    pubStartCharPos214 = self.getCharPositionInLine()
                    pub = CommonToken(
                        input=self.input,
                        type=INVALID_TOKEN_TYPE,
                        channel=DEFAULT_CHANNEL,
                        start=pubStart214,
                        stop=self.getCharIndex()-1)
                    pub.setLine(pubStartLine214)
                    pub.setCharPositionInLine(pubStartCharPos214)


                    self.mWS()


                    sys2Start220 = self.getCharIndex()
                    self.mVALUE()
                    sys2StartLine220 = self.getLine()
                    sys2StartCharPos220 = self.getCharPositionInLine()
                    sys2 = CommonToken(
                        input=self.input,
                        type=INVALID_TOKEN_TYPE,
                        channel=DEFAULT_CHANNEL,
                        start=sys2Start220,
                        stop=self.getCharIndex()-1)
                    sys2.setLine(sys2StartLine220)
                    sys2.setCharPositionInLine(sys2StartCharPos220)


                    #action start
                    self.output("PUBLIC: "+pub.text)
                    #action end


                    #action start
                    self.output("SYSTEM: "+sys2.text)
                    #action end





                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:36:13: ( WS )?
                alt7 = 2
                LA7_0 = self.input.LA(1)

                if ((9 <= LA7_0 <= 10) or LA7_0 == 13 or LA7_0 == 32) :
                    alt7 = 1
                if alt7 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:36:15: WS
                    pass 
                    self.mWS()








            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:38:9: (dtd= INTERNAL_DTD )?
            alt9 = 2
            LA9_0 = self.input.LA(1)

            if (LA9_0 == 91) :
                alt9 = 1
            if alt9 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:38:11: dtd= INTERNAL_DTD
                pass 
                dtdStart317 = self.getCharIndex()
                self.mINTERNAL_DTD()
                dtdStartLine317 = self.getLine()
                dtdStartCharPos317 = self.getCharPositionInLine()
                dtd = CommonToken(
                    input=self.input,
                    type=INVALID_TOKEN_TYPE,
                    channel=DEFAULT_CHANNEL,
                    start=dtdStart317,
                    stop=self.getCharIndex()-1)
                dtd.setLine(dtdStartLine317)
                dtd.setCharPositionInLine(dtdStartCharPos317)


                #action start
                self.output("INTERNAL DTD: "+dtd.text)
                #action end





            self.match(62)




        finally:
            pass

    # $ANTLR end "DOCTYPE"



    # $ANTLR start "INTERNAL_DTD"
    def mINTERNAL_DTD(self, ):
        try:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:44:23: ( '[' ( options {greedy=false; } : . )* ']' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:44:25: '[' ( options {greedy=false; } : . )* ']'
            pass 
            self.match(91)

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:44:29: ( options {greedy=false; } : . )*
            while True: #loop10
                alt10 = 2
                LA10_0 = self.input.LA(1)

                if (LA10_0 == 93) :
                    alt10 = 2
                elif ((0 <= LA10_0 <= 92) or (94 <= LA10_0 <= 65535)) :
                    alt10 = 1


                if alt10 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:44:56: .
                    pass 
                    self.matchAny()


                else:
                    break #loop10


            self.match(93)




        finally:
            pass

    # $ANTLR end "INTERNAL_DTD"



    # $ANTLR start "PI"
    def mPI(self, ):
        try:
            target = None

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:46:13: ( '<?' target= GENERIC_ID ( WS )? ( ATTRIBUTE ( WS )? )* '?>' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:47:9: '<?' target= GENERIC_ID ( WS )? ( ATTRIBUTE ( WS )? )* '?>'
            pass 
            self.match("<?")


            targetStart397 = self.getCharIndex()
            self.mGENERIC_ID()
            targetStartLine397 = self.getLine()
            targetStartCharPos397 = self.getCharPositionInLine()
            target = CommonToken(
                input=self.input,
                type=INVALID_TOKEN_TYPE,
                channel=DEFAULT_CHANNEL,
                start=targetStart397,
                stop=self.getCharIndex()-1)
            target.setLine(targetStartLine397)
            target.setCharPositionInLine(targetStartCharPos397)


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:47:32: ( WS )?
            alt11 = 2
            LA11_0 = self.input.LA(1)

            if ((9 <= LA11_0 <= 10) or LA11_0 == 13 or LA11_0 == 32) :
                alt11 = 1
            if alt11 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:47:32: WS
                pass 
                self.mWS()





            #action start
            self.output("PI: "+target.text)
            #action end


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:49:9: ( ATTRIBUTE ( WS )? )*
            while True: #loop13
                alt13 = 2
                LA13_0 = self.input.LA(1)

                if (LA13_0 == 58 or (65 <= LA13_0 <= 90) or LA13_0 == 95 or (97 <= LA13_0 <= 122)) :
                    alt13 = 1


                if alt13 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:49:11: ATTRIBUTE ( WS )?
                    pass 
                    self.mATTRIBUTE()


                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:49:21: ( WS )?
                    alt12 = 2
                    LA12_0 = self.input.LA(1)

                    if ((9 <= LA12_0 <= 10) or LA12_0 == 13 or LA12_0 == 32) :
                        alt12 = 1
                    if alt12 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:49:21: WS
                        pass 
                        self.mWS()






                else:
                    break #loop13


            self.match("?>")





        finally:
            pass

    # $ANTLR end "PI"



    # $ANTLR start "XMLDECL"
    def mXMLDECL(self, ):
        try:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:52:18: ( '<?' ( 'x' | 'X' ) ( 'm' | 'M' ) ( 'l' | 'L' ) ( WS )? ( ATTRIBUTE ( WS )? )* '?>' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:53:9: '<?' ( 'x' | 'X' ) ( 'm' | 'M' ) ( 'l' | 'L' ) ( WS )? ( ATTRIBUTE ( WS )? )* '?>'
            pass 
            self.match("<?")


            if self.input.LA(1) == 88 or self.input.LA(1) == 120:
                self.input.consume()
            else:
                mse = MismatchedSetException(None, self.input)
                self.recover(mse)
                raise mse



            if self.input.LA(1) == 77 or self.input.LA(1) == 109:
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



            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:53:44: ( WS )?
            alt14 = 2
            LA14_0 = self.input.LA(1)

            if ((9 <= LA14_0 <= 10) or LA14_0 == 13 or LA14_0 == 32) :
                alt14 = 1
            if alt14 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:53:44: WS
                pass 
                self.mWS()





            #action start
            self.output("XML declaration")
            #action end


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:55:9: ( ATTRIBUTE ( WS )? )*
            while True: #loop16
                alt16 = 2
                LA16_0 = self.input.LA(1)

                if (LA16_0 == 58 or (65 <= LA16_0 <= 90) or LA16_0 == 95 or (97 <= LA16_0 <= 122)) :
                    alt16 = 1


                if alt16 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:55:11: ATTRIBUTE ( WS )?
                    pass 
                    self.mATTRIBUTE()


                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:55:21: ( WS )?
                    alt15 = 2
                    LA15_0 = self.input.LA(1)

                    if ((9 <= LA15_0 <= 10) or LA15_0 == 13 or LA15_0 == 32) :
                        alt15 = 1
                    if alt15 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:55:21: WS
                        pass 
                        self.mWS()






                else:
                    break #loop16


            self.match("?>")





        finally:
            pass

    # $ANTLR end "XMLDECL"



    # $ANTLR start "ELEMENT"
    def mELEMENT(self, ):
        try:
            t = None
            pi = None

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:60:5: ( ( START_TAG ( ELEMENT |t= PCDATA |t= CDATA |t= COMMENT |pi= PI )* END_TAG | EMPTY_ELEMENT ) )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:60:7: ( START_TAG ( ELEMENT |t= PCDATA |t= CDATA |t= COMMENT |pi= PI )* END_TAG | EMPTY_ELEMENT )
            pass 
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:60:7: ( START_TAG ( ELEMENT |t= PCDATA |t= CDATA |t= COMMENT |pi= PI )* END_TAG | EMPTY_ELEMENT )
            alt18 = 2
            alt18 = self.dfa18.predict(self.input)
            if alt18 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:60:9: START_TAG ( ELEMENT |t= PCDATA |t= CDATA |t= COMMENT |pi= PI )* END_TAG
                pass 
                self.mSTART_TAG()


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:61:13: ( ELEMENT |t= PCDATA |t= CDATA |t= COMMENT |pi= PI )*
                while True: #loop17
                    alt17 = 6
                    LA17_0 = self.input.LA(1)

                    if (LA17_0 == 60) :
                        LA17 = self.input.LA(2)
                        if LA17 == 33:
                            LA17_4 = self.input.LA(3)

                            if (LA17_4 == 91) :
                                alt17 = 3
                            elif (LA17_4 == 45) :
                                alt17 = 4


                        elif LA17 == 63:
                            alt17 = 5
                        elif LA17 == 9 or LA17 == 10 or LA17 == 13 or LA17 == 32 or LA17 == 58 or LA17 == 65 or LA17 == 66 or LA17 == 67 or LA17 == 68 or LA17 == 69 or LA17 == 70 or LA17 == 71 or LA17 == 72 or LA17 == 73 or LA17 == 74 or LA17 == 75 or LA17 == 76 or LA17 == 77 or LA17 == 78 or LA17 == 79 or LA17 == 80 or LA17 == 81 or LA17 == 82 or LA17 == 83 or LA17 == 84 or LA17 == 85 or LA17 == 86 or LA17 == 87 or LA17 == 88 or LA17 == 89 or LA17 == 90 or LA17 == 95 or LA17 == 97 or LA17 == 98 or LA17 == 99 or LA17 == 100 or LA17 == 101 or LA17 == 102 or LA17 == 103 or LA17 == 104 or LA17 == 105 or LA17 == 106 or LA17 == 107 or LA17 == 108 or LA17 == 109 or LA17 == 110 or LA17 == 111 or LA17 == 112 or LA17 == 113 or LA17 == 114 or LA17 == 115 or LA17 == 116 or LA17 == 117 or LA17 == 118 or LA17 == 119 or LA17 == 120 or LA17 == 121 or LA17 == 122:
                            alt17 = 1

                    elif ((0 <= LA17_0 <= 59) or (61 <= LA17_0 <= 65535)) :
                        alt17 = 2


                    if alt17 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:61:14: ELEMENT
                        pass 
                        self.mELEMENT()



                    elif alt17 == 2:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:62:15: t= PCDATA
                        pass 
                        tStart561 = self.getCharIndex()
                        self.mPCDATA()
                        tStartLine561 = self.getLine()
                        tStartCharPos561 = self.getCharPositionInLine()
                        t = CommonToken(
                            input=self.input,
                            type=INVALID_TOKEN_TYPE,
                            channel=DEFAULT_CHANNEL,
                            start=tStart561,
                            stop=self.getCharIndex()-1)
                        t.setLine(tStartLine561)
                        t.setCharPositionInLine(tStartCharPos561)


                        #action start
                        self.output("PCDATA: \""+t.text+"\"")
                        #action end



                    elif alt17 == 3:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:64:15: t= CDATA
                        pass 
                        tStart597 = self.getCharIndex()
                        self.mCDATA()
                        tStartLine597 = self.getLine()
                        tStartCharPos597 = self.getCharPositionInLine()
                        t = CommonToken(
                            input=self.input,
                            type=INVALID_TOKEN_TYPE,
                            channel=DEFAULT_CHANNEL,
                            start=tStart597,
                            stop=self.getCharIndex()-1)
                        t.setLine(tStartLine597)
                        t.setCharPositionInLine(tStartCharPos597)


                        #action start
                        self.output("CDATA: \""+t.text+"\"")
                        #action end



                    elif alt17 == 4:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:66:15: t= COMMENT
                        pass 
                        tStart633 = self.getCharIndex()
                        self.mCOMMENT()
                        tStartLine633 = self.getLine()
                        tStartCharPos633 = self.getCharPositionInLine()
                        t = CommonToken(
                            input=self.input,
                            type=INVALID_TOKEN_TYPE,
                            channel=DEFAULT_CHANNEL,
                            start=tStart633,
                            stop=self.getCharIndex()-1)
                        t.setLine(tStartLine633)
                        t.setCharPositionInLine(tStartCharPos633)


                        #action start
                        self.output("Comment: \""+t.text+"\"")
                        #action end



                    elif alt17 == 5:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:68:15: pi= PI
                        pass 
                        piStart669 = self.getCharIndex()
                        self.mPI()
                        piStartLine669 = self.getLine()
                        piStartCharPos669 = self.getCharPositionInLine()
                        pi = CommonToken(
                            input=self.input,
                            type=INVALID_TOKEN_TYPE,
                            channel=DEFAULT_CHANNEL,
                            start=piStart669,
                            stop=self.getCharIndex()-1)
                        pi.setLine(piStartLine669)
                        pi.setCharPositionInLine(piStartCharPos669)



                    else:
                        break #loop17


                self.mEND_TAG()



            elif alt18 == 2:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:71:11: EMPTY_ELEMENT
                pass 
                self.mEMPTY_ELEMENT()








        finally:
            pass

    # $ANTLR end "ELEMENT"



    # $ANTLR start "START_TAG"
    def mSTART_TAG(self, ):
        try:
            name = None

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:76:5: ( '<' ( WS )? name= GENERIC_ID ( WS )? ( ATTRIBUTE ( WS )? )* '>' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:76:7: '<' ( WS )? name= GENERIC_ID ( WS )? ( ATTRIBUTE ( WS )? )* '>'
            pass 
            self.match(60)

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:76:11: ( WS )?
            alt19 = 2
            LA19_0 = self.input.LA(1)

            if ((9 <= LA19_0 <= 10) or LA19_0 == 13 or LA19_0 == 32) :
                alt19 = 1
            if alt19 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:76:11: WS
                pass 
                self.mWS()





            nameStart747 = self.getCharIndex()
            self.mGENERIC_ID()
            nameStartLine747 = self.getLine()
            nameStartCharPos747 = self.getCharPositionInLine()
            name = CommonToken(
                input=self.input,
                type=INVALID_TOKEN_TYPE,
                channel=DEFAULT_CHANNEL,
                start=nameStart747,
                stop=self.getCharIndex()-1)
            name.setLine(nameStartLine747)
            name.setCharPositionInLine(nameStartCharPos747)


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:76:31: ( WS )?
            alt20 = 2
            LA20_0 = self.input.LA(1)

            if ((9 <= LA20_0 <= 10) or LA20_0 == 13 or LA20_0 == 32) :
                alt20 = 1
            if alt20 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:76:31: WS
                pass 
                self.mWS()





            #action start
            self.output("Start Tag: "+name.text)
            #action end


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:78:9: ( ATTRIBUTE ( WS )? )*
            while True: #loop22
                alt22 = 2
                LA22_0 = self.input.LA(1)

                if (LA22_0 == 58 or (65 <= LA22_0 <= 90) or LA22_0 == 95 or (97 <= LA22_0 <= 122)) :
                    alt22 = 1


                if alt22 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:78:11: ATTRIBUTE ( WS )?
                    pass 
                    self.mATTRIBUTE()


                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:78:21: ( WS )?
                    alt21 = 2
                    LA21_0 = self.input.LA(1)

                    if ((9 <= LA21_0 <= 10) or LA21_0 == 13 or LA21_0 == 32) :
                        alt21 = 1
                    if alt21 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:78:21: WS
                        pass 
                        self.mWS()






                else:
                    break #loop22


            self.match(62)




        finally:
            pass

    # $ANTLR end "START_TAG"



    # $ANTLR start "EMPTY_ELEMENT"
    def mEMPTY_ELEMENT(self, ):
        try:
            name = None

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:82:5: ( '<' ( WS )? name= GENERIC_ID ( WS )? ( ATTRIBUTE ( WS )? )* '/>' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:82:7: '<' ( WS )? name= GENERIC_ID ( WS )? ( ATTRIBUTE ( WS )? )* '/>'
            pass 
            self.match(60)

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:82:11: ( WS )?
            alt23 = 2
            LA23_0 = self.input.LA(1)

            if ((9 <= LA23_0 <= 10) or LA23_0 == 13 or LA23_0 == 32) :
                alt23 = 1
            if alt23 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:82:11: WS
                pass 
                self.mWS()





            nameStart809 = self.getCharIndex()
            self.mGENERIC_ID()
            nameStartLine809 = self.getLine()
            nameStartCharPos809 = self.getCharPositionInLine()
            name = CommonToken(
                input=self.input,
                type=INVALID_TOKEN_TYPE,
                channel=DEFAULT_CHANNEL,
                start=nameStart809,
                stop=self.getCharIndex()-1)
            name.setLine(nameStartLine809)
            name.setCharPositionInLine(nameStartCharPos809)


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:82:31: ( WS )?
            alt24 = 2
            LA24_0 = self.input.LA(1)

            if ((9 <= LA24_0 <= 10) or LA24_0 == 13 or LA24_0 == 32) :
                alt24 = 1
            if alt24 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:82:31: WS
                pass 
                self.mWS()





            #action start
            self.output("Empty Element: "+name.text)
            #action end


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:84:9: ( ATTRIBUTE ( WS )? )*
            while True: #loop26
                alt26 = 2
                LA26_0 = self.input.LA(1)

                if (LA26_0 == 58 or (65 <= LA26_0 <= 90) or LA26_0 == 95 or (97 <= LA26_0 <= 122)) :
                    alt26 = 1


                if alt26 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:84:11: ATTRIBUTE ( WS )?
                    pass 
                    self.mATTRIBUTE()


                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:84:21: ( WS )?
                    alt25 = 2
                    LA25_0 = self.input.LA(1)

                    if ((9 <= LA25_0 <= 10) or LA25_0 == 13 or LA25_0 == 32) :
                        alt25 = 1
                    if alt25 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:84:21: WS
                        pass 
                        self.mWS()






                else:
                    break #loop26


            self.match("/>")





        finally:
            pass

    # $ANTLR end "EMPTY_ELEMENT"



    # $ANTLR start "ATTRIBUTE"
    def mATTRIBUTE(self, ):
        try:
            name = None
            value = None

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:88:5: (name= GENERIC_ID ( WS )? '=' ( WS )? value= VALUE )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:88:7: name= GENERIC_ID ( WS )? '=' ( WS )? value= VALUE
            pass 
            nameStart866 = self.getCharIndex()
            self.mGENERIC_ID()
            nameStartLine866 = self.getLine()
            nameStartCharPos866 = self.getCharPositionInLine()
            name = CommonToken(
                input=self.input,
                type=INVALID_TOKEN_TYPE,
                channel=DEFAULT_CHANNEL,
                start=nameStart866,
                stop=self.getCharIndex()-1)
            name.setLine(nameStartLine866)
            name.setCharPositionInLine(nameStartCharPos866)


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:88:23: ( WS )?
            alt27 = 2
            LA27_0 = self.input.LA(1)

            if ((9 <= LA27_0 <= 10) or LA27_0 == 13 or LA27_0 == 32) :
                alt27 = 1
            if alt27 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:88:23: WS
                pass 
                self.mWS()





            self.match(61)

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:88:31: ( WS )?
            alt28 = 2
            LA28_0 = self.input.LA(1)

            if ((9 <= LA28_0 <= 10) or LA28_0 == 13 or LA28_0 == 32) :
                alt28 = 1
            if alt28 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:88:31: WS
                pass 
                self.mWS()





            valueStart878 = self.getCharIndex()
            self.mVALUE()
            valueStartLine878 = self.getLine()
            valueStartCharPos878 = self.getCharPositionInLine()
            value = CommonToken(
                input=self.input,
                type=INVALID_TOKEN_TYPE,
                channel=DEFAULT_CHANNEL,
                start=valueStart878,
                stop=self.getCharIndex()-1)
            value.setLine(valueStartLine878)
            value.setCharPositionInLine(valueStartCharPos878)


            #action start
            self.output("Attr: "+name.text+"="+value.text)
            #action end





        finally:
            pass

    # $ANTLR end "ATTRIBUTE"



    # $ANTLR start "END_TAG"
    def mEND_TAG(self, ):
        try:
            name = None

            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:93:5: ( '</' ( WS )? name= GENERIC_ID ( WS )? '>' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:93:7: '</' ( WS )? name= GENERIC_ID ( WS )? '>'
            pass 
            self.match("</")


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:93:12: ( WS )?
            alt29 = 2
            LA29_0 = self.input.LA(1)

            if ((9 <= LA29_0 <= 10) or LA29_0 == 13 or LA29_0 == 32) :
                alt29 = 1
            if alt29 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:93:12: WS
                pass 
                self.mWS()





            nameStart915 = self.getCharIndex()
            self.mGENERIC_ID()
            nameStartLine915 = self.getLine()
            nameStartCharPos915 = self.getCharPositionInLine()
            name = CommonToken(
                input=self.input,
                type=INVALID_TOKEN_TYPE,
                channel=DEFAULT_CHANNEL,
                start=nameStart915,
                stop=self.getCharIndex()-1)
            name.setLine(nameStartLine915)
            name.setCharPositionInLine(nameStartCharPos915)


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:93:32: ( WS )?
            alt30 = 2
            LA30_0 = self.input.LA(1)

            if ((9 <= LA30_0 <= 10) or LA30_0 == 13 or LA30_0 == 32) :
                alt30 = 1
            if alt30 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:93:32: WS
                pass 
                self.mWS()





            self.match(62)

            #action start
            self.output("End Tag: "+name.text)
            #action end





        finally:
            pass

    # $ANTLR end "END_TAG"



    # $ANTLR start "COMMENT"
    def mCOMMENT(self, ):
        try:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:98:2: ( '<!--' ( options {greedy=false; } : . )* '-->' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:98:4: '<!--' ( options {greedy=false; } : . )* '-->'
            pass 
            self.match("<!--")


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:98:11: ( options {greedy=false; } : . )*
            while True: #loop31
                alt31 = 2
                LA31_0 = self.input.LA(1)

                if (LA31_0 == 45) :
                    LA31_1 = self.input.LA(2)

                    if (LA31_1 == 45) :
                        LA31_3 = self.input.LA(3)

                        if (LA31_3 == 62) :
                            alt31 = 2
                        elif ((0 <= LA31_3 <= 61) or (63 <= LA31_3 <= 65535)) :
                            alt31 = 1


                    elif ((0 <= LA31_1 <= 44) or (46 <= LA31_1 <= 65535)) :
                        alt31 = 1


                elif ((0 <= LA31_0 <= 44) or (46 <= LA31_0 <= 65535)) :
                    alt31 = 1


                if alt31 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:98:38: .
                    pass 
                    self.matchAny()


                else:
                    break #loop31


            self.match("-->")





        finally:
            pass

    # $ANTLR end "COMMENT"



    # $ANTLR start "CDATA"
    def mCDATA(self, ):
        try:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:102:2: ( '<![CDATA[' ( options {greedy=false; } : . )* ']]>' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:102:4: '<![CDATA[' ( options {greedy=false; } : . )* ']]>'
            pass 
            self.match("<![CDATA[")


            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:102:16: ( options {greedy=false; } : . )*
            while True: #loop32
                alt32 = 2
                LA32_0 = self.input.LA(1)

                if (LA32_0 == 93) :
                    LA32_1 = self.input.LA(2)

                    if (LA32_1 == 93) :
                        LA32_3 = self.input.LA(3)

                        if (LA32_3 == 62) :
                            alt32 = 2
                        elif ((0 <= LA32_3 <= 61) or (63 <= LA32_3 <= 65535)) :
                            alt32 = 1


                    elif ((0 <= LA32_1 <= 92) or (94 <= LA32_1 <= 65535)) :
                        alt32 = 1


                elif ((0 <= LA32_0 <= 92) or (94 <= LA32_0 <= 65535)) :
                    alt32 = 1


                if alt32 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:102:43: .
                    pass 
                    self.matchAny()


                else:
                    break #loop32


            self.match("]]>")





        finally:
            pass

    # $ANTLR end "CDATA"



    # $ANTLR start "PCDATA"
    def mPCDATA(self, ):
        try:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:105:17: ( (~ '<' )+ )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:105:19: (~ '<' )+
            pass 
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:105:19: (~ '<' )+
            cnt33 = 0
            while True: #loop33
                alt33 = 2
                LA33_0 = self.input.LA(1)

                if ((0 <= LA33_0 <= 59) or (61 <= LA33_0 <= 65535)) :
                    alt33 = 1


                if alt33 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:
                    pass 
                    if (0 <= self.input.LA(1) <= 59) or (61 <= self.input.LA(1) <= 65535):
                        self.input.consume()
                    else:
                        mse = MismatchedSetException(None, self.input)
                        self.recover(mse)
                        raise mse




                else:
                    if cnt33 >= 1:
                        break #loop33

                    eee = EarlyExitException(33, self.input)
                    raise eee

                cnt33 += 1





        finally:
            pass

    # $ANTLR end "PCDATA"



    # $ANTLR start "VALUE"
    def mVALUE(self, ):
        try:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:107:16: ( ( '\\\"' (~ '\\\"' )* '\\\"' | '\\'' (~ '\\'' )* '\\'' ) )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:108:9: ( '\\\"' (~ '\\\"' )* '\\\"' | '\\'' (~ '\\'' )* '\\'' )
            pass 
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:108:9: ( '\\\"' (~ '\\\"' )* '\\\"' | '\\'' (~ '\\'' )* '\\'' )
            alt36 = 2
            LA36_0 = self.input.LA(1)

            if (LA36_0 == 34) :
                alt36 = 1
            elif (LA36_0 == 39) :
                alt36 = 2
            else:
                nvae = NoViableAltException("", 36, 0, self.input)

                raise nvae


            if alt36 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:108:11: '\\\"' (~ '\\\"' )* '\\\"'
                pass 
                self.match(34)

                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:108:16: (~ '\\\"' )*
                while True: #loop34
                    alt34 = 2
                    LA34_0 = self.input.LA(1)

                    if ((0 <= LA34_0 <= 33) or (35 <= LA34_0 <= 65535)) :
                        alt34 = 1


                    if alt34 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:
                        pass 
                        if (0 <= self.input.LA(1) <= 33) or (35 <= self.input.LA(1) <= 65535):
                            self.input.consume()
                        else:
                            mse = MismatchedSetException(None, self.input)
                            self.recover(mse)
                            raise mse




                    else:
                        break #loop34


                self.match(34)


            elif alt36 == 2:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:109:11: '\\'' (~ '\\'' )* '\\''
                pass 
                self.match(39)

                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:109:16: (~ '\\'' )*
                while True: #loop35
                    alt35 = 2
                    LA35_0 = self.input.LA(1)

                    if ((0 <= LA35_0 <= 38) or (40 <= LA35_0 <= 65535)) :
                        alt35 = 1


                    if alt35 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:
                        pass 
                        if (0 <= self.input.LA(1) <= 38) or (40 <= self.input.LA(1) <= 65535):
                            self.input.consume()
                        else:
                            mse = MismatchedSetException(None, self.input)
                            self.recover(mse)
                            raise mse




                    else:
                        break #loop35


                self.match(39)







        finally:
            pass

    # $ANTLR end "VALUE"



    # $ANTLR start "GENERIC_ID"
    def mGENERIC_ID(self, ):
        try:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:114:5: ( ( LETTER | '_' | ':' ) ( options {greedy=true; } : LETTER | '0' .. '9' | '.' | '-' | '_' | ':' )* )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:114:7: ( LETTER | '_' | ':' ) ( options {greedy=true; } : LETTER | '0' .. '9' | '.' | '-' | '_' | ':' )*
            pass 
            if self.input.LA(1) == 58 or (65 <= self.input.LA(1) <= 90) or self.input.LA(1) == 95 or (97 <= self.input.LA(1) <= 122):
                self.input.consume()
            else:
                mse = MismatchedSetException(None, self.input)
                self.recover(mse)
                raise mse



            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:115:9: ( options {greedy=true; } : LETTER | '0' .. '9' | '.' | '-' | '_' | ':' )*
            while True: #loop37
                alt37 = 7
                LA37 = self.input.LA(1)
                if LA37 == 65 or LA37 == 66 or LA37 == 67 or LA37 == 68 or LA37 == 69 or LA37 == 70 or LA37 == 71 or LA37 == 72 or LA37 == 73 or LA37 == 74 or LA37 == 75 or LA37 == 76 or LA37 == 77 or LA37 == 78 or LA37 == 79 or LA37 == 80 or LA37 == 81 or LA37 == 82 or LA37 == 83 or LA37 == 84 or LA37 == 85 or LA37 == 86 or LA37 == 87 or LA37 == 88 or LA37 == 89 or LA37 == 90 or LA37 == 97 or LA37 == 98 or LA37 == 99 or LA37 == 100 or LA37 == 101 or LA37 == 102 or LA37 == 103 or LA37 == 104 or LA37 == 105 or LA37 == 106 or LA37 == 107 or LA37 == 108 or LA37 == 109 or LA37 == 110 or LA37 == 111 or LA37 == 112 or LA37 == 113 or LA37 == 114 or LA37 == 115 or LA37 == 116 or LA37 == 117 or LA37 == 118 or LA37 == 119 or LA37 == 120 or LA37 == 121 or LA37 == 122:
                    alt37 = 1
                elif LA37 == 48 or LA37 == 49 or LA37 == 50 or LA37 == 51 or LA37 == 52 or LA37 == 53 or LA37 == 54 or LA37 == 55 or LA37 == 56 or LA37 == 57:
                    alt37 = 2
                elif LA37 == 46:
                    alt37 = 3
                elif LA37 == 45:
                    alt37 = 4
                elif LA37 == 95:
                    alt37 = 5
                elif LA37 == 58:
                    alt37 = 6

                if alt37 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:115:36: LETTER
                    pass 
                    self.mLETTER()



                elif alt37 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:115:45: '0' .. '9'
                    pass 
                    self.matchRange(48, 57)


                elif alt37 == 3:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:115:56: '.'
                    pass 
                    self.match(46)


                elif alt37 == 4:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:115:62: '-'
                    pass 
                    self.match(45)


                elif alt37 == 5:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:115:68: '_'
                    pass 
                    self.match(95)


                elif alt37 == 6:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:115:74: ':'
                    pass 
                    self.match(58)


                else:
                    break #loop37





        finally:
            pass

    # $ANTLR end "GENERIC_ID"



    # $ANTLR start "LETTER"
    def mLETTER(self, ):
        try:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:119:2: ( 'a' .. 'z' | 'A' .. 'Z' )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:
            pass 
            if (65 <= self.input.LA(1) <= 90) or (97 <= self.input.LA(1) <= 122):
                self.input.consume()
            else:
                mse = MismatchedSetException(None, self.input)
                self.recover(mse)
                raise mse






        finally:
            pass

    # $ANTLR end "LETTER"



    # $ANTLR start "WS"
    def mWS(self, ):
        try:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:123:14: ( ( ' ' | '\\t' | ( '\\n' | '\\r\\n' | '\\r' ) )+ )
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:124:9: ( ' ' | '\\t' | ( '\\n' | '\\r\\n' | '\\r' ) )+
            pass 
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:124:9: ( ' ' | '\\t' | ( '\\n' | '\\r\\n' | '\\r' ) )+
            cnt39 = 0
            while True: #loop39
                alt39 = 4
                LA39 = self.input.LA(1)
                if LA39 == 32:
                    alt39 = 1
                elif LA39 == 9:
                    alt39 = 2
                elif LA39 == 10 or LA39 == 13:
                    alt39 = 3

                if alt39 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:124:13: ' '
                    pass 
                    self.match(32)


                elif alt39 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:125:13: '\\t'
                    pass 
                    self.match(9)


                elif alt39 == 3:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:126:12: ( '\\n' | '\\r\\n' | '\\r' )
                    pass 
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:126:12: ( '\\n' | '\\r\\n' | '\\r' )
                    alt38 = 3
                    LA38_0 = self.input.LA(1)

                    if (LA38_0 == 10) :
                        alt38 = 1
                    elif (LA38_0 == 13) :
                        LA38_2 = self.input.LA(2)

                        if (LA38_2 == 10) :
                            alt38 = 2
                        else:
                            alt38 = 3

                    else:
                        nvae = NoViableAltException("", 38, 0, self.input)

                        raise nvae


                    if alt38 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:126:14: '\\n'
                        pass 
                        self.match(10)


                    elif alt38 == 2:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:127:15: '\\r\\n'
                        pass 
                        self.match("\r\n")



                    elif alt38 == 3:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:128:15: '\\r'
                        pass 
                        self.match(13)





                else:
                    if cnt39 >= 1:
                        break #loop39

                    eee = EarlyExitException(39, self.input)
                    raise eee

                cnt39 += 1





        finally:
            pass

    # $ANTLR end "WS"



    def mTokens(self):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:1:8: ( DOCUMENT )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t012lexerXMLLexer.g:1:10: DOCUMENT
        pass 
        self.mDOCUMENT()









    # lookup tables for DFA #18

    DFA18_eot = DFA.unpack(
        u"\75\uffff"
        )

    DFA18_eof = DFA.unpack(
        u"\75\uffff"
        )

    DFA18_min = DFA.unpack(
        u"\1\74\21\11\2\uffff\22\11\2\0\13\11\1\0\1\11\1\0\7\11"
        )

    DFA18_max = DFA.unpack(
        u"\1\74\21\172\2\uffff\12\172\1\47\3\172\4\47\2\uffff\6\172\4\75"
        u"\1\47\1\uffff\1\172\1\uffff\1\172\1\75\5\172"
        )

    DFA18_accept = DFA.unpack(
        u"\22\uffff\1\1\1\2\51\uffff"
        )

    DFA18_special = DFA.unpack(
        u"\46\uffff\1\0\1\2\13\uffff\1\3\1\uffff\1\1\7\uffff"
        )


    DFA18_transition = [
        DFA.unpack(u"\1\1"),
        DFA.unpack(u"\1\3\1\4\2\uffff\1\5\22\uffff\1\2\31\uffff\1\6\6\uffff"
        u"\32\6\4\uffff\1\6\1\uffff\32\6"),
        DFA.unpack(u"\1\3\1\4\2\uffff\1\5\22\uffff\1\2\31\uffff\1\6\6\uffff"
        u"\32\6\4\uffff\1\6\1\uffff\32\6"),
        DFA.unpack(u"\1\3\1\4\2\uffff\1\5\22\uffff\1\2\31\uffff\1\6\6\uffff"
        u"\32\6\4\uffff\1\6\1\uffff\32\6"),
        DFA.unpack(u"\1\3\1\4\2\uffff\1\5\22\uffff\1\2\31\uffff\1\6\6\uffff"
        u"\32\6\4\uffff\1\6\1\uffff\32\6"),
        DFA.unpack(u"\1\3\1\7\2\uffff\1\5\22\uffff\1\2\31\uffff\1\6\6\uffff"
        u"\32\6\4\uffff\1\6\1\uffff\32\6"),
        DFA.unpack(u"\1\17\1\20\2\uffff\1\21\22\uffff\1\16\14\uffff\1\13"
        u"\1\12\1\23\12\11\1\15\3\uffff\1\22\2\uffff\32\10\4\uffff\1\14\1"
        u"\uffff\32\10"),
        DFA.unpack(u"\1\3\1\4\2\uffff\1\5\22\uffff\1\2\31\uffff\1\6\6\uffff"
        u"\32\6\4\uffff\1\6\1\uffff\32\6"),
        DFA.unpack(u"\1\25\1\26\2\uffff\1\27\22\uffff\1\24\14\uffff\1\34"
        u"\1\33\1\23\12\32\1\35\2\uffff\1\36\1\22\2\uffff\32\30\4\uffff\1"
        u"\31\1\uffff\32\30"),
        DFA.unpack(u"\1\17\1\20\2\uffff\1\21\22\uffff\1\16\14\uffff\1\13"
        u"\1\12\1\23\12\11\1\15\3\uffff\1\22\2\uffff\32\10\4\uffff\1\14\1"
        u"\uffff\32\10"),
        DFA.unpack(u"\1\17\1\20\2\uffff\1\21\22\uffff\1\16\14\uffff\1\13"
        u"\1\12\1\23\12\11\1\15\3\uffff\1\22\2\uffff\32\10\4\uffff\1\14\1"
        u"\uffff\32\10"),
        DFA.unpack(u"\1\17\1\20\2\uffff\1\21\22\uffff\1\16\14\uffff\1\13"
        u"\1\12\1\23\12\11\1\15\3\uffff\1\22\2\uffff\32\10\4\uffff\1\14\1"
        u"\uffff\32\10"),
        DFA.unpack(u"\1\25\1\26\2\uffff\1\27\22\uffff\1\24\14\uffff\1\34"
        u"\1\33\1\23\12\32\1\35\2\uffff\1\36\1\22\2\uffff\32\30\4\uffff\1"
        u"\31\1\uffff\32\30"),
        DFA.unpack(u"\1\25\1\26\2\uffff\1\27\22\uffff\1\24\14\uffff\1\34"
        u"\1\33\1\23\12\32\1\35\2\uffff\1\36\1\22\2\uffff\32\30\4\uffff\1"
        u"\31\1\uffff\32\30"),
        DFA.unpack(u"\1\17\1\20\2\uffff\1\21\22\uffff\1\16\16\uffff\1\23"
        u"\12\uffff\1\37\3\uffff\1\22\2\uffff\32\37\4\uffff\1\37\1\uffff"
        u"\32\37"),
        DFA.unpack(u"\1\17\1\20\2\uffff\1\21\22\uffff\1\16\16\uffff\1\23"
        u"\12\uffff\1\37\3\uffff\1\22\2\uffff\32\37\4\uffff\1\37\1\uffff"
        u"\32\37"),
        DFA.unpack(u"\1\17\1\20\2\uffff\1\21\22\uffff\1\16\16\uffff\1\23"
        u"\12\uffff\1\37\3\uffff\1\22\2\uffff\32\37\4\uffff\1\37\1\uffff"
        u"\32\37"),
        DFA.unpack(u"\1\17\1\40\2\uffff\1\21\22\uffff\1\16\16\uffff\1\23"
        u"\12\uffff\1\37\3\uffff\1\22\2\uffff\32\37\4\uffff\1\37\1\uffff"
        u"\32\37"),
        DFA.unpack(u""),
        DFA.unpack(u""),
        DFA.unpack(u"\1\25\1\26\2\uffff\1\27\22\uffff\1\24\16\uffff\1\23"
        u"\12\uffff\1\37\2\uffff\1\36\1\22\2\uffff\32\37\4\uffff\1\37\1\uffff"
        u"\32\37"),
        DFA.unpack(u"\1\25\1\26\2\uffff\1\27\22\uffff\1\24\16\uffff\1\23"
        u"\12\uffff\1\37\2\uffff\1\36\1\22\2\uffff\32\37\4\uffff\1\37\1\uffff"
        u"\32\37"),
        DFA.unpack(u"\1\25\1\26\2\uffff\1\27\22\uffff\1\24\16\uffff\1\23"
        u"\12\uffff\1\37\2\uffff\1\36\1\22\2\uffff\32\37\4\uffff\1\37\1\uffff"
        u"\32\37"),
        DFA.unpack(u"\1\25\1\41\2\uffff\1\27\22\uffff\1\24\16\uffff\1\23"
        u"\12\uffff\1\37\2\uffff\1\36\1\22\2\uffff\32\37\4\uffff\1\37\1\uffff"
        u"\32\37"),
        DFA.unpack(u"\1\25\1\26\2\uffff\1\27\22\uffff\1\24\14\uffff\1\34"
        u"\1\33\1\23\12\32\1\35\2\uffff\1\36\1\22\2\uffff\32\30\4\uffff\1"
        u"\31\1\uffff\32\30"),
        DFA.unpack(u"\1\25\1\26\2\uffff\1\27\22\uffff\1\24\14\uffff\1\34"
        u"\1\33\1\23\12\32\1\35\2\uffff\1\36\1\22\2\uffff\32\30\4\uffff\1"
        u"\31\1\uffff\32\30"),
        DFA.unpack(u"\1\25\1\26\2\uffff\1\27\22\uffff\1\24\14\uffff\1\34"
        u"\1\33\1\23\12\32\1\35\2\uffff\1\36\1\22\2\uffff\32\30\4\uffff\1"
        u"\31\1\uffff\32\30"),
        DFA.unpack(u"\1\25\1\26\2\uffff\1\27\22\uffff\1\24\14\uffff\1\34"
        u"\1\33\1\23\12\32\1\35\2\uffff\1\36\1\22\2\uffff\32\30\4\uffff\1"
        u"\31\1\uffff\32\30"),
        DFA.unpack(u"\1\25\1\26\2\uffff\1\27\22\uffff\1\24\14\uffff\1\34"
        u"\1\33\1\23\12\32\1\35\2\uffff\1\36\1\22\2\uffff\32\30\4\uffff\1"
        u"\31\1\uffff\32\30"),
        DFA.unpack(u"\1\25\1\26\2\uffff\1\27\22\uffff\1\24\14\uffff\1\34"
        u"\1\33\1\23\12\32\1\35\2\uffff\1\36\1\22\2\uffff\32\30\4\uffff\1"
        u"\31\1\uffff\32\30"),
        DFA.unpack(u"\1\43\1\44\2\uffff\1\45\22\uffff\1\42\1\uffff\1\46"
        u"\4\uffff\1\47"),
        DFA.unpack(u"\1\57\1\60\2\uffff\1\61\22\uffff\1\56\14\uffff\1\53"
        u"\1\52\1\uffff\12\51\1\55\2\uffff\1\36\3\uffff\32\50\4\uffff\1\54"
        u"\1\uffff\32\50"),
        DFA.unpack(u"\1\17\1\20\2\uffff\1\21\22\uffff\1\16\16\uffff\1\23"
        u"\12\uffff\1\37\3\uffff\1\22\2\uffff\32\37\4\uffff\1\37\1\uffff"
        u"\32\37"),
        DFA.unpack(u"\1\25\1\26\2\uffff\1\27\22\uffff\1\24\16\uffff\1\23"
        u"\12\uffff\1\37\2\uffff\1\36\1\22\2\uffff\32\37\4\uffff\1\37\1\uffff"
        u"\32\37"),
        DFA.unpack(u"\1\43\1\44\2\uffff\1\45\22\uffff\1\42\1\uffff\1\46"
        u"\4\uffff\1\47"),
        DFA.unpack(u"\1\43\1\44\2\uffff\1\45\22\uffff\1\42\1\uffff\1\46"
        u"\4\uffff\1\47"),
        DFA.unpack(u"\1\43\1\44\2\uffff\1\45\22\uffff\1\42\1\uffff\1\46"
        u"\4\uffff\1\47"),
        DFA.unpack(u"\1\43\1\62\2\uffff\1\45\22\uffff\1\42\1\uffff\1\46"
        u"\4\uffff\1\47"),
        DFA.unpack(u"\42\63\1\64\uffdd\63"),
        DFA.unpack(u"\47\65\1\66\uffd8\65"),
        DFA.unpack(u"\1\57\1\60\2\uffff\1\61\22\uffff\1\56\14\uffff\1\53"
        u"\1\52\1\uffff\12\51\1\55\2\uffff\1\36\3\uffff\32\50\4\uffff\1\54"
        u"\1\uffff\32\50"),
        DFA.unpack(u"\1\57\1\60\2\uffff\1\61\22\uffff\1\56\14\uffff\1\53"
        u"\1\52\1\uffff\12\51\1\55\2\uffff\1\36\3\uffff\32\50\4\uffff\1\54"
        u"\1\uffff\32\50"),
        DFA.unpack(u"\1\57\1\60\2\uffff\1\61\22\uffff\1\56\14\uffff\1\53"
        u"\1\52\1\uffff\12\51\1\55\2\uffff\1\36\3\uffff\32\50\4\uffff\1\54"
        u"\1\uffff\32\50"),
        DFA.unpack(u"\1\57\1\60\2\uffff\1\61\22\uffff\1\56\14\uffff\1\53"
        u"\1\52\1\uffff\12\51\1\55\2\uffff\1\36\3\uffff\32\50\4\uffff\1\54"
        u"\1\uffff\32\50"),
        DFA.unpack(u"\1\57\1\60\2\uffff\1\61\22\uffff\1\56\14\uffff\1\53"
        u"\1\52\1\uffff\12\51\1\55\2\uffff\1\36\3\uffff\32\50\4\uffff\1\54"
        u"\1\uffff\32\50"),
        DFA.unpack(u"\1\57\1\60\2\uffff\1\61\22\uffff\1\56\14\uffff\1\53"
        u"\1\52\1\uffff\12\51\1\55\2\uffff\1\36\3\uffff\32\50\4\uffff\1\54"
        u"\1\uffff\32\50"),
        DFA.unpack(u"\1\57\1\60\2\uffff\1\61\22\uffff\1\56\34\uffff\1\36"),
        DFA.unpack(u"\1\57\1\60\2\uffff\1\61\22\uffff\1\56\34\uffff\1\36"),
        DFA.unpack(u"\1\57\1\60\2\uffff\1\61\22\uffff\1\56\34\uffff\1\36"),
        DFA.unpack(u"\1\57\1\67\2\uffff\1\61\22\uffff\1\56\34\uffff\1\36"),
        DFA.unpack(u"\1\43\1\44\2\uffff\1\45\22\uffff\1\42\1\uffff\1\46"
        u"\4\uffff\1\47"),
        DFA.unpack(u"\42\63\1\64\uffdd\63"),
        DFA.unpack(u"\1\71\1\72\2\uffff\1\73\22\uffff\1\70\16\uffff\1\23"
        u"\12\uffff\1\37\3\uffff\1\22\2\uffff\32\37\4\uffff\1\37\1\uffff"
        u"\32\37"),
        DFA.unpack(u"\47\65\1\66\uffd8\65"),
        DFA.unpack(u"\1\71\1\72\2\uffff\1\73\22\uffff\1\70\16\uffff\1\23"
        u"\12\uffff\1\37\3\uffff\1\22\2\uffff\32\37\4\uffff\1\37\1\uffff"
        u"\32\37"),
        DFA.unpack(u"\1\57\1\60\2\uffff\1\61\22\uffff\1\56\34\uffff\1\36"),
        DFA.unpack(u"\1\71\1\72\2\uffff\1\73\22\uffff\1\70\16\uffff\1\23"
        u"\12\uffff\1\37\3\uffff\1\22\2\uffff\32\37\4\uffff\1\37\1\uffff"
        u"\32\37"),
        DFA.unpack(u"\1\71\1\72\2\uffff\1\73\22\uffff\1\70\16\uffff\1\23"
        u"\12\uffff\1\37\3\uffff\1\22\2\uffff\32\37\4\uffff\1\37\1\uffff"
        u"\32\37"),
        DFA.unpack(u"\1\71\1\72\2\uffff\1\73\22\uffff\1\70\16\uffff\1\23"
        u"\12\uffff\1\37\3\uffff\1\22\2\uffff\32\37\4\uffff\1\37\1\uffff"
        u"\32\37"),
        DFA.unpack(u"\1\71\1\74\2\uffff\1\73\22\uffff\1\70\16\uffff\1\23"
        u"\12\uffff\1\37\3\uffff\1\22\2\uffff\32\37\4\uffff\1\37\1\uffff"
        u"\32\37"),
        DFA.unpack(u"\1\71\1\72\2\uffff\1\73\22\uffff\1\70\16\uffff\1\23"
        u"\12\uffff\1\37\3\uffff\1\22\2\uffff\32\37\4\uffff\1\37\1\uffff"
        u"\32\37")
    ]

    # class definition for DFA #18

    class DFA18(DFA):
        pass


        def specialStateTransition(self_, s, input):
            # convince pylint that my self_ magic is ok ;)
            # pylint: disable-msg=E0213

            # pretend we are a member of the recognizer
            # thus semantic predicates can be evaluated
            self = self_.recognizer

            _s = s

            if s == 0: 
                LA18_38 = input.LA(1)

                s = -1
                if ((0 <= LA18_38 <= 33) or (35 <= LA18_38 <= 65535)):
                    s = 51

                elif (LA18_38 == 34):
                    s = 52

                if s >= 0:
                    return s
            el
            if s == 1: 
                LA18_53 = input.LA(1)

                s = -1
                if (LA18_53 == 39):
                    s = 54

                elif ((0 <= LA18_53 <= 38) or (40 <= LA18_53 <= 65535)):
                    s = 53

                if s >= 0:
                    return s
            el
            if s == 2: 
                LA18_39 = input.LA(1)

                s = -1
                if ((0 <= LA18_39 <= 38) or (40 <= LA18_39 <= 65535)):
                    s = 53

                elif (LA18_39 == 39):
                    s = 54

                if s >= 0:
                    return s
            el
            if s == 3: 
                LA18_51 = input.LA(1)

                s = -1
                if (LA18_51 == 34):
                    s = 52

                elif ((0 <= LA18_51 <= 33) or (35 <= LA18_51 <= 65535)):
                    s = 51

                if s >= 0:
                    return s

            nvae = NoViableAltException(self_.getDescription(), 18, _s, input)
            self_.error(nvae)
            raise nvae

 



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import LexerMain
    main = LexerMain(t012lexerXMLLexer)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
