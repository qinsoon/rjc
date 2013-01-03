# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g 2013-01-03 10:52:36

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
ID=4
NUM=5
WS=6

# token names
tokenNames = [
    "<invalid>", "<EOR>", "<DOWN>", "<UP>",
    "ID", "NUM", "WS", "';'", "'='", "'int'", "'{'", "'}'"
]

class aScope_scope(object):
    def __init__(self):
        self.names = None




class b_scope(object):
    def __init__(self):
        self.x = None


class c_scope(object):
    def __init__(self):
        self.symbols = None


class d_scope(object):
    def __init__(self):
        self.symbols = None


class e_scope(object):
    def __init__(self):
        self.a = None


class f_scope(object):
    def __init__(self):
        self.a = None



class t022scopesParser(Parser):
    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g"
    api_version = 1
    tokenNames = tokenNames

    def __init__(self, input, state=None, *args, **kwargs):
        if state is None:
            state = RecognizerSharedState()

        super(t022scopesParser, self).__init__(input, state, *args, **kwargs)


        self.aScope_stack = []


	self.b_stack = []


	self.c_stack = []


	self.d_stack = []


	self.e_stack = []


	self.f_stack = []




        self.delegates = []






    # $ANTLR start "a"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:13:1: a : ( ID )* ;
    def a(self, ):
        self.aScope_stack.append(aScope_scope())

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:15:5: ( ( ID )* )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:15:9: ( ID )*
                pass 
                #action start
                self.aScope_stack[-1].names =  []
                #action end


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:15:32: ( ID )*
                while True: #loop1
                    alt1 = 2
                    LA1_0 = self.input.LA(1)

                    if (LA1_0 == ID) :
                        alt1 = 1


                    if alt1 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:15:32: ID
                        pass 
                        self.match(self.input, ID, self.FOLLOW_ID_in_a47)


                    else:
                        break #loop1





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            self.aScope_stack.pop()

            pass
        return 

    # $ANTLR end "a"



    # $ANTLR start "b"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:21:1: b[v] : b2 ;
    def b(self, v):
        self.b_stack.append(b_scope())
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:23:5: ( b2 )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:23:7: b2
                pass 
                #action start
                self.b_stack[-1].x =  v
                #action end


                self._state.following.append(self.FOLLOW_b2_in_b76)
                self.b2()

                self._state.following.pop()




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            self.b_stack.pop()
            pass
        return 

    # $ANTLR end "b"



    # $ANTLR start "b2"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:26:1: b2 : b3 ;
    def b2(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:27:5: ( b3 )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:27:7: b3
                pass 
                self._state.following.append(self.FOLLOW_b3_in_b293)
                self.b3()

                self._state.following.pop()




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "b2"



    # $ANTLR start "b3"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:30:1: b3 : ({...}? => ID | NUM );
    def b3(self, ):
        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:31:5: ({...}? => ID | NUM )
                alt2 = 2
                LA2_0 = self.input.LA(1)

                if (LA2_0 == ID) and ((self.b_stack[-1].x)):
                    alt2 = 1
                elif (LA2_0 == NUM) :
                    alt2 = 2
                else:
                    nvae = NoViableAltException("", 2, 0, self.input)

                    raise nvae


                if alt2 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:31:7: {...}? => ID
                    pass 
                    if not ((self.b_stack[-1].x)):
                        raise FailedPredicateException(self.input, "b3", "$b::x")


                    self.match(self.input, ID, self.FOLLOW_ID_in_b3114)


                elif alt2 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:32:7: NUM
                    pass 
                    self.match(self.input, NUM, self.FOLLOW_NUM_in_b3123)



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "b3"



    # $ANTLR start "c"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:38:1: c returns [res] : '{' ( c1 )* ( c2 )+ '}' ;
    def c(self, ):
        self.c_stack.append(c_scope())
        res = None


              
        self.c_stack[-1].symbols =  set()

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:45:5: ( '{' ( c1 )* ( c2 )+ '}' )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:45:7: '{' ( c1 )* ( c2 )+ '}'
                pass 
                self.match(self.input, 10, self.FOLLOW_10_in_c157)

                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:45:11: ( c1 )*
                while True: #loop3
                    alt3 = 2
                    LA3_0 = self.input.LA(1)

                    if (LA3_0 == 9) :
                        alt3 = 1


                    if alt3 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:45:11: c1
                        pass 
                        self._state.following.append(self.FOLLOW_c1_in_c159)
                        self.c1()

                        self._state.following.pop()


                    else:
                        break #loop3


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:45:15: ( c2 )+
                cnt4 = 0
                while True: #loop4
                    alt4 = 2
                    LA4_0 = self.input.LA(1)

                    if (LA4_0 == ID) :
                        alt4 = 1


                    if alt4 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:45:15: c2
                        pass 
                        self._state.following.append(self.FOLLOW_c2_in_c162)
                        self.c2()

                        self._state.following.pop()


                    else:
                        if cnt4 >= 1:
                            break #loop4

                        eee = EarlyExitException(4, self.input)
                        raise eee

                    cnt4 += 1


                self.match(self.input, 11, self.FOLLOW_11_in_c165)

                #action start
                res =  self.c_stack[-1].symbols 
                #action end





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            self.c_stack.pop()
            pass
        return res

    # $ANTLR end "c"



    # $ANTLR start "c1"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:49:1: c1 : 'int' ID ';' ;
    def c1(self, ):
        ID1 = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:50:5: ( 'int' ID ';' )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:50:7: 'int' ID ';'
                pass 
                self.match(self.input, 9, self.FOLLOW_9_in_c1192)

                ID1 = self.match(self.input, ID, self.FOLLOW_ID_in_c1194)

                #action start
                self.c_stack[-1].symbols.add(ID1.text)
                #action end


                self.match(self.input, 7, self.FOLLOW_7_in_c1198)




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "c1"



    # $ANTLR start "c2"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:53:1: c2 : ID '=' NUM ';' ;
    def c2(self, ):
        ID2 = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:54:5: ( ID '=' NUM ';' )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:54:7: ID '=' NUM ';'
                pass 
                ID2 = self.match(self.input, ID, self.FOLLOW_ID_in_c2215)

                self.match(self.input, 8, self.FOLLOW_8_in_c2217)

                self.match(self.input, NUM, self.FOLLOW_NUM_in_c2219)

                self.match(self.input, 7, self.FOLLOW_7_in_c2221)

                #action start
                        
                if ID2.text not in self.c_stack[-1].symbols:
                    raise RuntimeError(ID2.text)
                        
                #action end





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "c2"



    # $ANTLR start "d"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:63:1: d returns [res] : '{' ( d1 )* ( d2 )* '}' ;
    def d(self, ):
        self.d_stack.append(d_scope())
        res = None


              
        self.d_stack[-1].symbols =  set()

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:70:5: ( '{' ( d1 )* ( d2 )* '}' )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:70:7: '{' ( d1 )* ( d2 )* '}'
                pass 
                self.match(self.input, 10, self.FOLLOW_10_in_d264)

                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:70:11: ( d1 )*
                while True: #loop5
                    alt5 = 2
                    LA5_0 = self.input.LA(1)

                    if (LA5_0 == 9) :
                        alt5 = 1


                    if alt5 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:70:11: d1
                        pass 
                        self._state.following.append(self.FOLLOW_d1_in_d266)
                        self.d1()

                        self._state.following.pop()


                    else:
                        break #loop5


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:70:15: ( d2 )*
                while True: #loop6
                    alt6 = 2
                    LA6_0 = self.input.LA(1)

                    if (LA6_0 == ID or LA6_0 == 10) :
                        alt6 = 1


                    if alt6 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:70:15: d2
                        pass 
                        self._state.following.append(self.FOLLOW_d2_in_d269)
                        self.d2()

                        self._state.following.pop()


                    else:
                        break #loop6


                self.match(self.input, 11, self.FOLLOW_11_in_d272)

                #action start
                res =  self.d_stack[-1].symbols 
                #action end





            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            self.d_stack.pop()
            pass
        return res

    # $ANTLR end "d"



    # $ANTLR start "d1"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:74:1: d1 : 'int' ID ';' ;
    def d1(self, ):
        ID3 = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:75:5: ( 'int' ID ';' )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:75:7: 'int' ID ';'
                pass 
                self.match(self.input, 9, self.FOLLOW_9_in_d1299)

                ID3 = self.match(self.input, ID, self.FOLLOW_ID_in_d1301)

                #action start
                self.d_stack[-1].symbols.add(ID3.text)
                #action end


                self.match(self.input, 7, self.FOLLOW_7_in_d1305)




            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "d1"



    # $ANTLR start "d2"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:78:1: d2 : ( ID '=' NUM ';' | d );
    def d2(self, ):
        ID4 = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:79:5: ( ID '=' NUM ';' | d )
                alt7 = 2
                LA7_0 = self.input.LA(1)

                if (LA7_0 == ID) :
                    alt7 = 1
                elif (LA7_0 == 10) :
                    alt7 = 2
                else:
                    nvae = NoViableAltException("", 7, 0, self.input)

                    raise nvae


                if alt7 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:79:7: ID '=' NUM ';'
                    pass 
                    ID4 = self.match(self.input, ID, self.FOLLOW_ID_in_d2322)

                    self.match(self.input, 8, self.FOLLOW_8_in_d2324)

                    self.match(self.input, NUM, self.FOLLOW_NUM_in_d2326)

                    self.match(self.input, 7, self.FOLLOW_7_in_d2328)

                    #action start
                            
                    for s in reversed(range(len(self.d_stack))):
                        if ID4.text in self.d_stack[s].symbols:
                            break
                    else:
                        raise RuntimeError(ID4.text)
                            
                    #action end



                elif alt7 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:87:7: d
                    pass 
                    self._state.following.append(self.FOLLOW_d_in_d2346)
                    self.d()

                    self._state.following.pop()



            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            pass
        return 

    # $ANTLR end "d2"



    # $ANTLR start "e"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:92:1: e returns [res] : ( NUM | '{' e '}' );
    def e(self, ):
        self.e_stack.append(e_scope())
        res = None


        NUM5 = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:99:5: ( NUM | '{' e '}' )
                alt8 = 2
                LA8_0 = self.input.LA(1)

                if (LA8_0 == NUM) :
                    alt8 = 1
                elif (LA8_0 == 10) :
                    alt8 = 2
                else:
                    nvae = NoViableAltException("", 8, 0, self.input)

                    raise nvae


                if alt8 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:99:7: NUM
                    pass 
                    NUM5 = self.match(self.input, NUM, self.FOLLOW_NUM_in_e379)

                    #action start
                    self.e_stack[0].a = int(NUM5.text); 
                    #action end



                elif alt8 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:100:7: '{' e '}'
                    pass 
                    self.match(self.input, 10, self.FOLLOW_10_in_e389)

                    self._state.following.append(self.FOLLOW_e_in_e391)
                    self.e()

                    self._state.following.pop()

                    self.match(self.input, 11, self.FOLLOW_11_in_e393)



                #action start
                       
                res =  self.e_stack[-1].a

                #action end


            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            self.e_stack.pop()
            pass
        return res

    # $ANTLR end "e"



    # $ANTLR start "f"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:106:1: f returns [res] : ( NUM | '{' f '}' );
    def f(self, ):
        self.f_stack.append(f_scope())
        res = None


        NUM6 = None

        try:
            try:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:113:5: ( NUM | '{' f '}' )
                alt9 = 2
                LA9_0 = self.input.LA(1)

                if (LA9_0 == NUM) :
                    alt9 = 1
                elif (LA9_0 == 10) :
                    alt9 = 2
                else:
                    nvae = NoViableAltException("", 9, 0, self.input)

                    raise nvae


                if alt9 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:113:7: NUM
                    pass 
                    NUM6 = self.match(self.input, NUM, self.FOLLOW_NUM_in_f427)

                    #action start
                    self.f_stack[-2].a = int(NUM6.text); 
                    #action end



                elif alt9 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t022scopes.g:114:7: '{' f '}'
                    pass 
                    self.match(self.input, 10, self.FOLLOW_10_in_f437)

                    self._state.following.append(self.FOLLOW_f_in_f439)
                    self.f()

                    self._state.following.pop()

                    self.match(self.input, 11, self.FOLLOW_11_in_f441)



                #action start
                       
                res =  self.f_stack[-1].a

                #action end


            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            self.f_stack.pop()
            pass
        return res

    # $ANTLR end "f"



 

    FOLLOW_ID_in_a47 = frozenset([1, 4])
    FOLLOW_b2_in_b76 = frozenset([1])
    FOLLOW_b3_in_b293 = frozenset([1])
    FOLLOW_ID_in_b3114 = frozenset([1])
    FOLLOW_NUM_in_b3123 = frozenset([1])
    FOLLOW_10_in_c157 = frozenset([4, 9])
    FOLLOW_c1_in_c159 = frozenset([4, 9])
    FOLLOW_c2_in_c162 = frozenset([4, 11])
    FOLLOW_11_in_c165 = frozenset([1])
    FOLLOW_9_in_c1192 = frozenset([4])
    FOLLOW_ID_in_c1194 = frozenset([7])
    FOLLOW_7_in_c1198 = frozenset([1])
    FOLLOW_ID_in_c2215 = frozenset([8])
    FOLLOW_8_in_c2217 = frozenset([5])
    FOLLOW_NUM_in_c2219 = frozenset([7])
    FOLLOW_7_in_c2221 = frozenset([1])
    FOLLOW_10_in_d264 = frozenset([4, 9, 10, 11])
    FOLLOW_d1_in_d266 = frozenset([4, 9, 10, 11])
    FOLLOW_d2_in_d269 = frozenset([4, 10, 11])
    FOLLOW_11_in_d272 = frozenset([1])
    FOLLOW_9_in_d1299 = frozenset([4])
    FOLLOW_ID_in_d1301 = frozenset([7])
    FOLLOW_7_in_d1305 = frozenset([1])
    FOLLOW_ID_in_d2322 = frozenset([8])
    FOLLOW_8_in_d2324 = frozenset([5])
    FOLLOW_NUM_in_d2326 = frozenset([7])
    FOLLOW_7_in_d2328 = frozenset([1])
    FOLLOW_d_in_d2346 = frozenset([1])
    FOLLOW_NUM_in_e379 = frozenset([1])
    FOLLOW_10_in_e389 = frozenset([5, 10])
    FOLLOW_e_in_e391 = frozenset([11])
    FOLLOW_11_in_e393 = frozenset([1])
    FOLLOW_NUM_in_f427 = frozenset([1])
    FOLLOW_10_in_f437 = frozenset([5, 10])
    FOLLOW_f_in_f439 = frozenset([11])
    FOLLOW_11_in_f441 = frozenset([1])



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import ParserMain
    main = ParserMain("t022scopesLexer", t022scopesParser)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
