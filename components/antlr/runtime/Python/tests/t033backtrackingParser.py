# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g 2013-01-03 10:52:12

import sys
from antlr3 import *
from antlr3.compat import set, frozenset

        
# compatibility stuff
try:
    set = set
    frozenset = frozenset
except NameError:
    from sets import Set as set, ImmutableSet as frozenset


try:
    reversed = reversed
except NameError:
    def reversed(l):
        l = l[:]
        l.reverse()
        return l




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

# token names
tokenNames = [
    "<invalid>", "<EOR>", "<DOWN>", "<UP>",
    "CHARACTER_LITERAL", "COMMENT", "DECIMAL_LITERAL", "EscapeSequence", 
    "Exponent", "FLOATING_POINT_LITERAL", "FloatTypeSuffix", "HEX_LITERAL", 
    "HexDigit", "IDENTIFIER", "IntegerTypeSuffix", "LETTER", "LINE_COMMAND", 
    "LINE_COMMENT", "OCTAL_LITERAL", "OctalEscape", "STRING_LITERAL", "UnicodeEscape", 
    "WS", "'('", "')'", "'*'", "','", "';'", "'['", "']'", "'auto'", "'char'", 
    "'const'", "'double'", "'extern'", "'float'", "'int'", "'long'", "'register'", 
    "'short'", "'signed'", "'static'", "'typedef'", "'unsigned'", "'void'", 
    "'volatile'"
]

class Symbols_scope(object):
    def __init__(self):
        self.types = None




class declaration_scope(object):
    def __init__(self):
        self.isTypedef = None



class t033backtrackingParser(Parser):
    grammarFileName = "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g"
    api_version = 1
    tokenNames = tokenNames

    def __init__(self, input, state=None, *args, **kwargs):
        if state is None:
            state = RecognizerSharedState()

        super(t033backtrackingParser, self).__init__(input, state, *args, **kwargs)

        self._state.ruleMemo = {}


        self.Symbols_stack = []


	self.declaration_stack = []




        self.delegates = []




             
    def isTypeName(self, name):
        for scope in reversed(self.Symbols_stack):
            if name in scope.types:
                return True

        return False




    # $ANTLR start "translation_unit"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:42:1: translation_unit : ( external_declaration )+ ;
    def translation_unit(self, ):
        self.Symbols_stack.append(Symbols_scope())

        translation_unit_StartIndex = self.input.index()

              
        self.Symbols_stack[-1].types = set()

        success = False

        try:
            try:
                if self._state.backtracking > 0 and self.alreadyParsedRule(self.input, 1):
                    # for cached failed rules, alreadyParsedRule will raise an exception
                    success = True
                    return 


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:47:2: ( ( external_declaration )+ )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:47:4: ( external_declaration )+
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:47:4: ( external_declaration )+
                cnt1 = 0
                while True: #loop1
                    alt1 = 2
                    LA1_0 = self.input.LA(1)

                    if (LA1_0 == IDENTIFIER or LA1_0 == 23 or LA1_0 == 25 or (30 <= LA1_0 <= 45)) :
                        alt1 = 1


                    if alt1 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:47:4: external_declaration
                        pass 
                        self._state.following.append(self.FOLLOW_external_declaration_in_translation_unit81)
                        self.external_declaration()

                        self._state.following.pop()


                    else:
                        if cnt1 >= 1:
                            break #loop1

                        if self._state.backtracking > 0:
                            raise BacktrackingFailed


                        eee = EarlyExitException(1, self.input)
                        raise eee

                    cnt1 += 1





                success = True

            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            if self._state.backtracking > 0:
                self.memoize(self.input, 1, translation_unit_StartIndex, success)


            self.Symbols_stack.pop()

            pass
        return 

    # $ANTLR end "translation_unit"



    # $ANTLR start "external_declaration"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:64:1: external_declaration options {k=1; } : ( ( ( declaration_specifiers )? declarator ( declaration )* '{' )=> function_definition | declaration );
    def external_declaration(self, ):
        external_declaration_StartIndex = self.input.index()

        success = False

        try:
            try:
                if self._state.backtracking > 0 and self.alreadyParsedRule(self.input, 2):
                    # for cached failed rules, alreadyParsedRule will raise an exception
                    success = True
                    return 


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:66:2: ( ( ( declaration_specifiers )? declarator ( declaration )* '{' )=> function_definition | declaration )
                alt2 = 2
                LA2_0 = self.input.LA(1)

                if (LA2_0 == 30 or LA2_0 == 34 or LA2_0 == 38 or LA2_0 == 41) :
                    LA2_1 = self.input.LA(2)

                    if (self.synpred4_t033backtracking()) :
                        alt2 = 1
                    elif (True) :
                        alt2 = 2
                    else:
                        if self._state.backtracking > 0:
                            raise BacktrackingFailed


                        nvae = NoViableAltException("", 2, 1, self.input)

                        raise nvae


                elif (LA2_0 == 44) :
                    LA2_2 = self.input.LA(2)

                    if (self.synpred4_t033backtracking()) :
                        alt2 = 1
                    elif (True) :
                        alt2 = 2
                    else:
                        if self._state.backtracking > 0:
                            raise BacktrackingFailed


                        nvae = NoViableAltException("", 2, 2, self.input)

                        raise nvae


                elif (LA2_0 == 31) :
                    LA2_3 = self.input.LA(2)

                    if (self.synpred4_t033backtracking()) :
                        alt2 = 1
                    elif (True) :
                        alt2 = 2
                    else:
                        if self._state.backtracking > 0:
                            raise BacktrackingFailed


                        nvae = NoViableAltException("", 2, 3, self.input)

                        raise nvae


                elif (LA2_0 == 39) :
                    LA2_4 = self.input.LA(2)

                    if (self.synpred4_t033backtracking()) :
                        alt2 = 1
                    elif (True) :
                        alt2 = 2
                    else:
                        if self._state.backtracking > 0:
                            raise BacktrackingFailed


                        nvae = NoViableAltException("", 2, 4, self.input)

                        raise nvae


                elif (LA2_0 == 36) :
                    LA2_5 = self.input.LA(2)

                    if (self.synpred4_t033backtracking()) :
                        alt2 = 1
                    elif (True) :
                        alt2 = 2
                    else:
                        if self._state.backtracking > 0:
                            raise BacktrackingFailed


                        nvae = NoViableAltException("", 2, 5, self.input)

                        raise nvae


                elif (LA2_0 == 37) :
                    LA2_6 = self.input.LA(2)

                    if (self.synpred4_t033backtracking()) :
                        alt2 = 1
                    elif (True) :
                        alt2 = 2
                    else:
                        if self._state.backtracking > 0:
                            raise BacktrackingFailed


                        nvae = NoViableAltException("", 2, 6, self.input)

                        raise nvae


                elif (LA2_0 == 35) :
                    LA2_7 = self.input.LA(2)

                    if (self.synpred4_t033backtracking()) :
                        alt2 = 1
                    elif (True) :
                        alt2 = 2
                    else:
                        if self._state.backtracking > 0:
                            raise BacktrackingFailed


                        nvae = NoViableAltException("", 2, 7, self.input)

                        raise nvae


                elif (LA2_0 == 33) :
                    LA2_8 = self.input.LA(2)

                    if (self.synpred4_t033backtracking()) :
                        alt2 = 1
                    elif (True) :
                        alt2 = 2
                    else:
                        if self._state.backtracking > 0:
                            raise BacktrackingFailed


                        nvae = NoViableAltException("", 2, 8, self.input)

                        raise nvae


                elif (LA2_0 == 40) :
                    LA2_9 = self.input.LA(2)

                    if (self.synpred4_t033backtracking()) :
                        alt2 = 1
                    elif (True) :
                        alt2 = 2
                    else:
                        if self._state.backtracking > 0:
                            raise BacktrackingFailed


                        nvae = NoViableAltException("", 2, 9, self.input)

                        raise nvae


                elif (LA2_0 == 43) :
                    LA2_10 = self.input.LA(2)

                    if (self.synpred4_t033backtracking()) :
                        alt2 = 1
                    elif (True) :
                        alt2 = 2
                    else:
                        if self._state.backtracking > 0:
                            raise BacktrackingFailed


                        nvae = NoViableAltException("", 2, 10, self.input)

                        raise nvae


                elif (LA2_0 == IDENTIFIER) :
                    LA2_11 = self.input.LA(2)

                    if (self.synpred4_t033backtracking()) :
                        alt2 = 1
                    elif ((self.isTypeName(self.input.LT(1).getText()))) :
                        alt2 = 2
                    else:
                        if self._state.backtracking > 0:
                            raise BacktrackingFailed


                        nvae = NoViableAltException("", 2, 11, self.input)

                        raise nvae


                elif (LA2_0 == 32 or LA2_0 == 45) :
                    LA2_12 = self.input.LA(2)

                    if (self.synpred4_t033backtracking()) :
                        alt2 = 1
                    elif (True) :
                        alt2 = 2
                    else:
                        if self._state.backtracking > 0:
                            raise BacktrackingFailed


                        nvae = NoViableAltException("", 2, 12, self.input)

                        raise nvae


                elif (LA2_0 == 25) and (self.synpred4_t033backtracking()):
                    alt2 = 1
                elif (LA2_0 == 23) and (self.synpred4_t033backtracking()):
                    alt2 = 1
                elif (LA2_0 == 42) :
                    alt2 = 2
                else:
                    if self._state.backtracking > 0:
                        raise BacktrackingFailed


                    nvae = NoViableAltException("", 2, 0, self.input)

                    raise nvae


                if alt2 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:66:4: ( ( declaration_specifiers )? declarator ( declaration )* '{' )=> function_definition
                    pass 
                    self._state.following.append(self.FOLLOW_function_definition_in_external_declaration117)
                    self.function_definition()

                    self._state.following.pop()


                elif alt2 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:67:4: declaration
                    pass 
                    self._state.following.append(self.FOLLOW_declaration_in_external_declaration122)
                    self.declaration()

                    self._state.following.pop()



                success = True

            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            if self._state.backtracking > 0:
                self.memoize(self.input, 2, external_declaration_StartIndex, success)


            pass
        return 

    # $ANTLR end "external_declaration"



    # $ANTLR start "function_definition"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:70:1: function_definition : ( declaration_specifiers )? declarator ;
    def function_definition(self, ):
        self.Symbols_stack.append(Symbols_scope())

        function_definition_StartIndex = self.input.index()

              
        self.Symbols_stack[-1].types = set()

        success = False

        try:
            try:
                if self._state.backtracking > 0 and self.alreadyParsedRule(self.input, 3):
                    # for cached failed rules, alreadyParsedRule will raise an exception
                    success = True
                    return 


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:75:2: ( ( declaration_specifiers )? declarator )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:75:4: ( declaration_specifiers )? declarator
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:75:4: ( declaration_specifiers )?
                alt3 = 2
                LA3_0 = self.input.LA(1)

                if ((30 <= LA3_0 <= 41) or (43 <= LA3_0 <= 45)) :
                    alt3 = 1
                elif (LA3_0 == IDENTIFIER) :
                    LA3_11 = self.input.LA(2)

                    if (((((self.synpred5_t033backtracking()) and (self.synpred5_t033backtracking()))) and ((self.isTypeName(self.input.LT(1).getText()))))) :
                        alt3 = 1
                if alt3 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:75:4: declaration_specifiers
                    pass 
                    self._state.following.append(self.FOLLOW_declaration_specifiers_in_function_definition144)
                    self.declaration_specifiers()

                    self._state.following.pop()




                self._state.following.append(self.FOLLOW_declarator_in_function_definition147)
                self.declarator()

                self._state.following.pop()




                success = True

            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            if self._state.backtracking > 0:
                self.memoize(self.input, 3, function_definition_StartIndex, success)


            self.Symbols_stack.pop()

            pass
        return 

    # $ANTLR end "function_definition"



    # $ANTLR start "declaration"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:81:1: declaration : ( 'typedef' ( declaration_specifiers )? init_declarator_list ';' | declaration_specifiers ( init_declarator_list )? ';' );
    def declaration(self, ):
        self.declaration_stack.append(declaration_scope())
        declaration_StartIndex = self.input.index()

              
        self.declaration_stack[-1].isTypedef = False

        success = False

        try:
            try:
                if self._state.backtracking > 0 and self.alreadyParsedRule(self.input, 4):
                    # for cached failed rules, alreadyParsedRule will raise an exception
                    success = True
                    return 


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:88:2: ( 'typedef' ( declaration_specifiers )? init_declarator_list ';' | declaration_specifiers ( init_declarator_list )? ';' )
                alt6 = 2
                LA6_0 = self.input.LA(1)

                if (LA6_0 == 42) :
                    alt6 = 1
                elif (LA6_0 == IDENTIFIER or (30 <= LA6_0 <= 41) or (43 <= LA6_0 <= 45)) :
                    alt6 = 2
                else:
                    if self._state.backtracking > 0:
                        raise BacktrackingFailed


                    nvae = NoViableAltException("", 6, 0, self.input)

                    raise nvae


                if alt6 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:88:4: 'typedef' ( declaration_specifiers )? init_declarator_list ';'
                    pass 
                    self.match(self.input, 42, self.FOLLOW_42_in_declaration170)

                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:88:14: ( declaration_specifiers )?
                    alt4 = 2
                    LA4_0 = self.input.LA(1)

                    if ((30 <= LA4_0 <= 41) or (43 <= LA4_0 <= 45)) :
                        alt4 = 1
                    elif (LA4_0 == IDENTIFIER) :
                        LA4_11 = self.input.LA(2)

                        if (LA4_11 == IDENTIFIER or LA4_11 == 25 or (30 <= LA4_11 <= 41) or (43 <= LA4_11 <= 45)) :
                            alt4 = 1
                        elif (LA4_11 == 23) :
                            LA4_17 = self.input.LA(3)

                            if (((((self.synpred6_t033backtracking()) and (self.synpred6_t033backtracking()))) and ((self.isTypeName(self.input.LT(1).getText()))))) :
                                alt4 = 1
                    if alt4 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:88:14: declaration_specifiers
                        pass 
                        self._state.following.append(self.FOLLOW_declaration_specifiers_in_declaration172)
                        self.declaration_specifiers()

                        self._state.following.pop()




                    if self._state.backtracking == 0:
                        pass
                        self.declaration_stack[-1].isTypedef = True



                    self._state.following.append(self.FOLLOW_init_declarator_list_in_declaration180)
                    self.init_declarator_list()

                    self._state.following.pop()

                    self.match(self.input, 27, self.FOLLOW_27_in_declaration182)


                elif alt6 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:90:4: declaration_specifiers ( init_declarator_list )? ';'
                    pass 
                    self._state.following.append(self.FOLLOW_declaration_specifiers_in_declaration188)
                    self.declaration_specifiers()

                    self._state.following.pop()

                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:90:27: ( init_declarator_list )?
                    alt5 = 2
                    LA5_0 = self.input.LA(1)

                    if (LA5_0 == IDENTIFIER or LA5_0 == 23 or LA5_0 == 25) :
                        alt5 = 1
                    if alt5 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:90:27: init_declarator_list
                        pass 
                        self._state.following.append(self.FOLLOW_init_declarator_list_in_declaration190)
                        self.init_declarator_list()

                        self._state.following.pop()




                    self.match(self.input, 27, self.FOLLOW_27_in_declaration193)



                success = True

            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            if self._state.backtracking > 0:
                self.memoize(self.input, 4, declaration_StartIndex, success)


            self.declaration_stack.pop()
            pass
        return 

    # $ANTLR end "declaration"



    # $ANTLR start "declaration_specifiers"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:93:1: declaration_specifiers : ( storage_class_specifier | type_specifier | type_qualifier )+ ;
    def declaration_specifiers(self, ):
        declaration_specifiers_StartIndex = self.input.index()

        success = False

        try:
            try:
                if self._state.backtracking > 0 and self.alreadyParsedRule(self.input, 5):
                    # for cached failed rules, alreadyParsedRule will raise an exception
                    success = True
                    return 


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:94:2: ( ( storage_class_specifier | type_specifier | type_qualifier )+ )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:94:6: ( storage_class_specifier | type_specifier | type_qualifier )+
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:94:6: ( storage_class_specifier | type_specifier | type_qualifier )+
                cnt7 = 0
                while True: #loop7
                    alt7 = 4
                    LA7 = self.input.LA(1)
                    if LA7 == IDENTIFIER:
                        LA7_2 = self.input.LA(2)

                        if ((((((self.isTypeName(self.input.LT(1).getText()))) and ((self.isTypeName(self.input.LT(1).getText()))))) and (self.synpred10_t033backtracking()))) :
                            alt7 = 2


                    elif LA7 == 30 or LA7 == 34 or LA7 == 38 or LA7 == 41:
                        alt7 = 1
                    elif LA7 == 31 or LA7 == 33 or LA7 == 35 or LA7 == 36 or LA7 == 37 or LA7 == 39 or LA7 == 40 or LA7 == 43 or LA7 == 44:
                        alt7 = 2
                    elif LA7 == 32 or LA7 == 45:
                        alt7 = 3

                    if alt7 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:94:10: storage_class_specifier
                        pass 
                        self._state.following.append(self.FOLLOW_storage_class_specifier_in_declaration_specifiers210)
                        self.storage_class_specifier()

                        self._state.following.pop()


                    elif alt7 == 2:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:95:7: type_specifier
                        pass 
                        self._state.following.append(self.FOLLOW_type_specifier_in_declaration_specifiers218)
                        self.type_specifier()

                        self._state.following.pop()


                    elif alt7 == 3:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:96:13: type_qualifier
                        pass 
                        self._state.following.append(self.FOLLOW_type_qualifier_in_declaration_specifiers232)
                        self.type_qualifier()

                        self._state.following.pop()


                    else:
                        if cnt7 >= 1:
                            break #loop7

                        if self._state.backtracking > 0:
                            raise BacktrackingFailed


                        eee = EarlyExitException(7, self.input)
                        raise eee

                    cnt7 += 1





                success = True

            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            if self._state.backtracking > 0:
                self.memoize(self.input, 5, declaration_specifiers_StartIndex, success)


            pass
        return 

    # $ANTLR end "declaration_specifiers"



    # $ANTLR start "init_declarator_list"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:100:1: init_declarator_list : init_declarator ( ',' init_declarator )* ;
    def init_declarator_list(self, ):
        init_declarator_list_StartIndex = self.input.index()

        success = False

        try:
            try:
                if self._state.backtracking > 0 and self.alreadyParsedRule(self.input, 6):
                    # for cached failed rules, alreadyParsedRule will raise an exception
                    success = True
                    return 


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:101:2: ( init_declarator ( ',' init_declarator )* )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:101:4: init_declarator ( ',' init_declarator )*
                pass 
                self._state.following.append(self.FOLLOW_init_declarator_in_init_declarator_list254)
                self.init_declarator()

                self._state.following.pop()

                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:101:20: ( ',' init_declarator )*
                while True: #loop8
                    alt8 = 2
                    LA8_0 = self.input.LA(1)

                    if (LA8_0 == 26) :
                        alt8 = 1


                    if alt8 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:101:21: ',' init_declarator
                        pass 
                        self.match(self.input, 26, self.FOLLOW_26_in_init_declarator_list257)

                        self._state.following.append(self.FOLLOW_init_declarator_in_init_declarator_list259)
                        self.init_declarator()

                        self._state.following.pop()


                    else:
                        break #loop8





                success = True

            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            if self._state.backtracking > 0:
                self.memoize(self.input, 6, init_declarator_list_StartIndex, success)


            pass
        return 

    # $ANTLR end "init_declarator_list"



    # $ANTLR start "init_declarator"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:104:1: init_declarator : declarator ;
    def init_declarator(self, ):
        init_declarator_StartIndex = self.input.index()

        success = False

        try:
            try:
                if self._state.backtracking > 0 and self.alreadyParsedRule(self.input, 7):
                    # for cached failed rules, alreadyParsedRule will raise an exception
                    success = True
                    return 


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:105:2: ( declarator )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:105:4: declarator
                pass 
                self._state.following.append(self.FOLLOW_declarator_in_init_declarator272)
                self.declarator()

                self._state.following.pop()




                success = True

            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            if self._state.backtracking > 0:
                self.memoize(self.input, 7, init_declarator_StartIndex, success)


            pass
        return 

    # $ANTLR end "init_declarator"



    # $ANTLR start "storage_class_specifier"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:108:1: storage_class_specifier : ( 'extern' | 'static' | 'auto' | 'register' );
    def storage_class_specifier(self, ):
        storage_class_specifier_StartIndex = self.input.index()

        success = False

        try:
            try:
                if self._state.backtracking > 0 and self.alreadyParsedRule(self.input, 8):
                    # for cached failed rules, alreadyParsedRule will raise an exception
                    success = True
                    return 


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:109:2: ( 'extern' | 'static' | 'auto' | 'register' )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:
                pass 
                if self.input.LA(1) == 30 or self.input.LA(1) == 34 or self.input.LA(1) == 38 or self.input.LA(1) == 41:
                    self.input.consume()
                    self._state.errorRecovery = False


                else:
                    if self._state.backtracking > 0:
                        raise BacktrackingFailed


                    mse = MismatchedSetException(None, self.input)
                    raise mse






                success = True

            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            if self._state.backtracking > 0:
                self.memoize(self.input, 8, storage_class_specifier_StartIndex, success)


            pass
        return 

    # $ANTLR end "storage_class_specifier"



    # $ANTLR start "type_specifier"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:115:1: type_specifier : ( 'void' | 'char' | 'short' | 'int' | 'long' | 'float' | 'double' | 'signed' | 'unsigned' | type_id );
    def type_specifier(self, ):
        type_specifier_StartIndex = self.input.index()

        success = False

        try:
            try:
                if self._state.backtracking > 0 and self.alreadyParsedRule(self.input, 9):
                    # for cached failed rules, alreadyParsedRule will raise an exception
                    success = True
                    return 


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:116:2: ( 'void' | 'char' | 'short' | 'int' | 'long' | 'float' | 'double' | 'signed' | 'unsigned' | type_id )
                alt9 = 10
                LA9 = self.input.LA(1)
                if LA9 == 44:
                    alt9 = 1
                elif LA9 == 31:
                    alt9 = 2
                elif LA9 == 39:
                    alt9 = 3
                elif LA9 == 36:
                    alt9 = 4
                elif LA9 == 37:
                    alt9 = 5
                elif LA9 == 35:
                    alt9 = 6
                elif LA9 == 33:
                    alt9 = 7
                elif LA9 == 40:
                    alt9 = 8
                elif LA9 == 43:
                    alt9 = 9
                elif LA9 == IDENTIFIER:
                    alt9 = 10
                else:
                    if self._state.backtracking > 0:
                        raise BacktrackingFailed


                    nvae = NoViableAltException("", 9, 0, self.input)

                    raise nvae


                if alt9 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:116:4: 'void'
                    pass 
                    self.match(self.input, 44, self.FOLLOW_44_in_type_specifier310)


                elif alt9 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:117:4: 'char'
                    pass 
                    self.match(self.input, 31, self.FOLLOW_31_in_type_specifier315)


                elif alt9 == 3:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:118:4: 'short'
                    pass 
                    self.match(self.input, 39, self.FOLLOW_39_in_type_specifier320)


                elif alt9 == 4:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:119:4: 'int'
                    pass 
                    self.match(self.input, 36, self.FOLLOW_36_in_type_specifier325)


                elif alt9 == 5:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:120:4: 'long'
                    pass 
                    self.match(self.input, 37, self.FOLLOW_37_in_type_specifier330)


                elif alt9 == 6:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:121:4: 'float'
                    pass 
                    self.match(self.input, 35, self.FOLLOW_35_in_type_specifier335)


                elif alt9 == 7:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:122:4: 'double'
                    pass 
                    self.match(self.input, 33, self.FOLLOW_33_in_type_specifier340)


                elif alt9 == 8:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:123:4: 'signed'
                    pass 
                    self.match(self.input, 40, self.FOLLOW_40_in_type_specifier345)


                elif alt9 == 9:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:124:4: 'unsigned'
                    pass 
                    self.match(self.input, 43, self.FOLLOW_43_in_type_specifier350)


                elif alt9 == 10:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:127:4: type_id
                    pass 
                    self._state.following.append(self.FOLLOW_type_id_in_type_specifier357)
                    self.type_id()

                    self._state.following.pop()



                success = True

            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            if self._state.backtracking > 0:
                self.memoize(self.input, 9, type_specifier_StartIndex, success)


            pass
        return 

    # $ANTLR end "type_specifier"



    # $ANTLR start "type_id"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:130:1: type_id :{...}? IDENTIFIER ;
    def type_id(self, ):
        type_id_StartIndex = self.input.index()

        success = False

        try:
            try:
                if self._state.backtracking > 0 and self.alreadyParsedRule(self.input, 10):
                    # for cached failed rules, alreadyParsedRule will raise an exception
                    success = True
                    return 


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:131:5: ({...}? IDENTIFIER )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:131:9: {...}? IDENTIFIER
                pass 
                if not ((self.isTypeName(self.input.LT(1).getText()))):
                    if self._state.backtracking > 0:
                        raise BacktrackingFailed


                    raise FailedPredicateException(self.input, "type_id", "self.isTypeName(self.input.LT(1).getText())")


                self.match(self.input, IDENTIFIER, self.FOLLOW_IDENTIFIER_in_type_id375)




                success = True

            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            if self._state.backtracking > 0:
                self.memoize(self.input, 10, type_id_StartIndex, success)


            pass
        return 

    # $ANTLR end "type_id"



    # $ANTLR start "type_qualifier"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:186:1: type_qualifier : ( 'const' | 'volatile' );
    def type_qualifier(self, ):
        type_qualifier_StartIndex = self.input.index()

        success = False

        try:
            try:
                if self._state.backtracking > 0 and self.alreadyParsedRule(self.input, 11):
                    # for cached failed rules, alreadyParsedRule will raise an exception
                    success = True
                    return 


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:187:2: ( 'const' | 'volatile' )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:
                pass 
                if self.input.LA(1) == 32 or self.input.LA(1) == 45:
                    self.input.consume()
                    self._state.errorRecovery = False


                else:
                    if self._state.backtracking > 0:
                        raise BacktrackingFailed


                    mse = MismatchedSetException(None, self.input)
                    raise mse






                success = True

            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            if self._state.backtracking > 0:
                self.memoize(self.input, 11, type_qualifier_StartIndex, success)


            pass
        return 

    # $ANTLR end "type_qualifier"



    # $ANTLR start "declarator"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:191:1: declarator : ( ( pointer )? direct_declarator | pointer );
    def declarator(self, ):
        declarator_StartIndex = self.input.index()

        success = False

        try:
            try:
                if self._state.backtracking > 0 and self.alreadyParsedRule(self.input, 12):
                    # for cached failed rules, alreadyParsedRule will raise an exception
                    success = True
                    return 


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:192:2: ( ( pointer )? direct_declarator | pointer )
                alt11 = 2
                LA11_0 = self.input.LA(1)

                if (LA11_0 == 25) :
                    LA11_1 = self.input.LA(2)

                    if (self.synpred27_t033backtracking()) :
                        alt11 = 1
                    elif (True) :
                        alt11 = 2
                    else:
                        if self._state.backtracking > 0:
                            raise BacktrackingFailed


                        nvae = NoViableAltException("", 11, 1, self.input)

                        raise nvae


                elif (LA11_0 == IDENTIFIER or LA11_0 == 23) :
                    alt11 = 1
                else:
                    if self._state.backtracking > 0:
                        raise BacktrackingFailed


                    nvae = NoViableAltException("", 11, 0, self.input)

                    raise nvae


                if alt11 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:192:4: ( pointer )? direct_declarator
                    pass 
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:192:4: ( pointer )?
                    alt10 = 2
                    LA10_0 = self.input.LA(1)

                    if (LA10_0 == 25) :
                        alt10 = 1
                    if alt10 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:192:4: pointer
                        pass 
                        self._state.following.append(self.FOLLOW_pointer_in_declarator457)
                        self.pointer()

                        self._state.following.pop()




                    self._state.following.append(self.FOLLOW_direct_declarator_in_declarator460)
                    self.direct_declarator()

                    self._state.following.pop()


                elif alt11 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:193:4: pointer
                    pass 
                    self._state.following.append(self.FOLLOW_pointer_in_declarator465)
                    self.pointer()

                    self._state.following.pop()



                success = True

            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            if self._state.backtracking > 0:
                self.memoize(self.input, 12, declarator_StartIndex, success)


            pass
        return 

    # $ANTLR end "declarator"



    # $ANTLR start "direct_declarator"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:196:1: direct_declarator : ( IDENTIFIER | '(' declarator ')' ) ( declarator_suffix )* ;
    def direct_declarator(self, ):
        direct_declarator_StartIndex = self.input.index()

        IDENTIFIER1 = None

        success = False

        try:
            try:
                if self._state.backtracking > 0 and self.alreadyParsedRule(self.input, 13):
                    # for cached failed rules, alreadyParsedRule will raise an exception
                    success = True
                    return 


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:197:2: ( ( IDENTIFIER | '(' declarator ')' ) ( declarator_suffix )* )
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:197:6: ( IDENTIFIER | '(' declarator ')' ) ( declarator_suffix )*
                pass 
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:197:6: ( IDENTIFIER | '(' declarator ')' )
                alt12 = 2
                LA12_0 = self.input.LA(1)

                if (LA12_0 == IDENTIFIER) :
                    alt12 = 1
                elif (LA12_0 == 23) :
                    alt12 = 2
                else:
                    if self._state.backtracking > 0:
                        raise BacktrackingFailed


                    nvae = NoViableAltException("", 12, 0, self.input)

                    raise nvae


                if alt12 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:197:8: IDENTIFIER
                    pass 
                    IDENTIFIER1 = self.match(self.input, IDENTIFIER, self.FOLLOW_IDENTIFIER_in_direct_declarator480)

                    if self._state.backtracking == 0:
                        pass
                           
                        if len(self.declaration_stack)>0 and self.declaration_stack[-1].isTypedef:
                        	self.Symbols_stack[-1].types.add(IDENTIFIER1.text)
                        	print "define type "+IDENTIFIER1.text
                        			




                elif alt12 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:203:5: '(' declarator ')'
                    pass 
                    self.match(self.input, 23, self.FOLLOW_23_in_direct_declarator491)

                    self._state.following.append(self.FOLLOW_declarator_in_direct_declarator493)
                    self.declarator()

                    self._state.following.pop()

                    self.match(self.input, 24, self.FOLLOW_24_in_direct_declarator495)




                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:205:9: ( declarator_suffix )*
                while True: #loop13
                    alt13 = 2
                    LA13_0 = self.input.LA(1)

                    if (LA13_0 == 23) :
                        LA13_15 = self.input.LA(2)

                        if (LA13_15 == 24) :
                            alt13 = 1


                    elif (LA13_0 == 28) :
                        alt13 = 1


                    if alt13 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:205:9: declarator_suffix
                        pass 
                        self._state.following.append(self.FOLLOW_declarator_suffix_in_direct_declarator509)
                        self.declarator_suffix()

                        self._state.following.pop()


                    else:
                        break #loop13





                success = True

            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            if self._state.backtracking > 0:
                self.memoize(self.input, 13, direct_declarator_StartIndex, success)


            pass
        return 

    # $ANTLR end "direct_declarator"



    # $ANTLR start "declarator_suffix"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:208:1: declarator_suffix : ( '[' ']' | '(' ')' );
    def declarator_suffix(self, ):
        declarator_suffix_StartIndex = self.input.index()

        success = False

        try:
            try:
                if self._state.backtracking > 0 and self.alreadyParsedRule(self.input, 14):
                    # for cached failed rules, alreadyParsedRule will raise an exception
                    success = True
                    return 


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:209:2: ( '[' ']' | '(' ')' )
                alt14 = 2
                LA14_0 = self.input.LA(1)

                if (LA14_0 == 28) :
                    alt14 = 1
                elif (LA14_0 == 23) :
                    alt14 = 2
                else:
                    if self._state.backtracking > 0:
                        raise BacktrackingFailed


                    nvae = NoViableAltException("", 14, 0, self.input)

                    raise nvae


                if alt14 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:210:11: '[' ']'
                    pass 
                    self.match(self.input, 28, self.FOLLOW_28_in_declarator_suffix527)

                    self.match(self.input, 29, self.FOLLOW_29_in_declarator_suffix529)


                elif alt14 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:213:9: '(' ')'
                    pass 
                    self.match(self.input, 23, self.FOLLOW_23_in_declarator_suffix541)

                    self.match(self.input, 24, self.FOLLOW_24_in_declarator_suffix543)



                success = True

            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            if self._state.backtracking > 0:
                self.memoize(self.input, 14, declarator_suffix_StartIndex, success)


            pass
        return 

    # $ANTLR end "declarator_suffix"



    # $ANTLR start "pointer"
    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:216:1: pointer : ( '*' ( type_qualifier )+ ( pointer )? | '*' pointer | '*' );
    def pointer(self, ):
        pointer_StartIndex = self.input.index()

        success = False

        try:
            try:
                if self._state.backtracking > 0 and self.alreadyParsedRule(self.input, 15):
                    # for cached failed rules, alreadyParsedRule will raise an exception
                    success = True
                    return 


                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:217:2: ( '*' ( type_qualifier )+ ( pointer )? | '*' pointer | '*' )
                alt17 = 3
                LA17_0 = self.input.LA(1)

                if (LA17_0 == 25) :
                    LA17 = self.input.LA(2)
                    if LA17 == 32 or LA17 == 45:
                        LA17_2 = self.input.LA(3)

                        if (self.synpred33_t033backtracking()) :
                            alt17 = 1
                        elif (True) :
                            alt17 = 3
                        else:
                            if self._state.backtracking > 0:
                                raise BacktrackingFailed


                            nvae = NoViableAltException("", 17, 2, self.input)

                            raise nvae


                    elif LA17 == 25:
                        LA17_3 = self.input.LA(3)

                        if (self.synpred34_t033backtracking()) :
                            alt17 = 2
                        elif (True) :
                            alt17 = 3
                        else:
                            if self._state.backtracking > 0:
                                raise BacktrackingFailed


                            nvae = NoViableAltException("", 17, 3, self.input)

                            raise nvae


                    elif LA17 == <INVALID> or LA17 == EOF or LA17 == IDENTIFIER or LA17 == 23 or LA17 == 24 or LA17 == 26 or LA17 == 27 or LA17 == 30 or LA17 == 31 or LA17 == 33 or LA17 == 34 or LA17 == 35 or LA17 == 36 or LA17 == 37 or LA17 == 38 or LA17 == 39 or LA17 == 40 or LA17 == 41 or LA17 == 42 or LA17 == 43 or LA17 == 44:
                        alt17 = 3
                    else:
                        if self._state.backtracking > 0:
                            raise BacktrackingFailed


                        nvae = NoViableAltException("", 17, 1, self.input)

                        raise nvae


                else:
                    if self._state.backtracking > 0:
                        raise BacktrackingFailed


                    nvae = NoViableAltException("", 17, 0, self.input)

                    raise nvae


                if alt17 == 1:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:217:4: '*' ( type_qualifier )+ ( pointer )?
                    pass 
                    self.match(self.input, 25, self.FOLLOW_25_in_pointer554)

                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:217:8: ( type_qualifier )+
                    cnt15 = 0
                    while True: #loop15
                        alt15 = 2
                        LA15_0 = self.input.LA(1)

                        if (LA15_0 == 32 or LA15_0 == 45) :
                            LA15_15 = self.input.LA(2)

                            if (self.synpred31_t033backtracking()) :
                                alt15 = 1




                        if alt15 == 1:
                            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:217:8: type_qualifier
                            pass 
                            self._state.following.append(self.FOLLOW_type_qualifier_in_pointer556)
                            self.type_qualifier()

                            self._state.following.pop()


                        else:
                            if cnt15 >= 1:
                                break #loop15

                            if self._state.backtracking > 0:
                                raise BacktrackingFailed


                            eee = EarlyExitException(15, self.input)
                            raise eee

                        cnt15 += 1


                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:217:24: ( pointer )?
                    alt16 = 2
                    LA16_0 = self.input.LA(1)

                    if (LA16_0 == 25) :
                        LA16_1 = self.input.LA(2)

                        if (self.synpred32_t033backtracking()) :
                            alt16 = 1
                    if alt16 == 1:
                        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:217:24: pointer
                        pass 
                        self._state.following.append(self.FOLLOW_pointer_in_pointer559)
                        self.pointer()

                        self._state.following.pop()





                elif alt17 == 2:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:218:4: '*' pointer
                    pass 
                    self.match(self.input, 25, self.FOLLOW_25_in_pointer565)

                    self._state.following.append(self.FOLLOW_pointer_in_pointer567)
                    self.pointer()

                    self._state.following.pop()


                elif alt17 == 3:
                    # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:219:4: '*'
                    pass 
                    self.match(self.input, 25, self.FOLLOW_25_in_pointer572)



                success = True

            except RecognitionException, re:
                self.reportError(re)
                self.recover(self.input, re)

        finally:
            if self._state.backtracking > 0:
                self.memoize(self.input, 15, pointer_StartIndex, success)


            pass
        return 

    # $ANTLR end "pointer"

    # $ANTLR start "synpred2_t033backtracking"
    def synpred2_t033backtracking_fragment(self, ):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:66:6: ( declaration_specifiers )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:66:6: declaration_specifiers
        pass 
        self._state.following.append(self.FOLLOW_declaration_specifiers_in_synpred2_t033backtracking104)
        self.declaration_specifiers()

        self._state.following.pop()



    # $ANTLR end "synpred2_t033backtracking"



    # $ANTLR start "synpred4_t033backtracking"
    def synpred4_t033backtracking_fragment(self, ):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:66:4: ( ( declaration_specifiers )? declarator ( declaration )* '{' )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:66:6: ( declaration_specifiers )? declarator ( declaration )* '{'
        pass 
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:66:6: ( declaration_specifiers )?
        alt18 = 2
        LA18_0 = self.input.LA(1)

        if ((30 <= LA18_0 <= 41) or (43 <= LA18_0 <= 45)) :
            alt18 = 1
        elif (LA18_0 == IDENTIFIER) :
            LA18 = self.input.LA(2)
            if LA18 == 25:
                alt18 = 1
            elif LA18 == IDENTIFIER:
                LA18_16 = self.input.LA(3)

                if ((((((self.isTypeName(self.input.LT(1).getText()))) and ((self.isTypeName(self.input.LT(1).getText()))))) and (self.synpred2_t033backtracking()))) :
                    alt18 = 1
            elif LA18 == 23:
                LA18_17 = self.input.LA(3)

                if ((((((self.isTypeName(self.input.LT(1).getText()))) and ((self.isTypeName(self.input.LT(1).getText()))))) and (self.synpred2_t033backtracking()))) :
                    alt18 = 1
            elif LA18 == 30 or LA18 == 34 or LA18 == 38 or LA18 == 41:
                LA18_18 = self.input.LA(3)

                if ((((((self.isTypeName(self.input.LT(1).getText()))) and ((self.isTypeName(self.input.LT(1).getText()))))) and (self.synpred2_t033backtracking()))) :
                    alt18 = 1
            elif LA18 == 44:
                LA18_19 = self.input.LA(3)

                if ((((((self.isTypeName(self.input.LT(1).getText()))) and ((self.isTypeName(self.input.LT(1).getText()))))) and (self.synpred2_t033backtracking()))) :
                    alt18 = 1
            elif LA18 == 31:
                LA18_20 = self.input.LA(3)

                if ((((((self.isTypeName(self.input.LT(1).getText()))) and ((self.isTypeName(self.input.LT(1).getText()))))) and (self.synpred2_t033backtracking()))) :
                    alt18 = 1
            elif LA18 == 39:
                LA18_21 = self.input.LA(3)

                if ((((((self.isTypeName(self.input.LT(1).getText()))) and ((self.isTypeName(self.input.LT(1).getText()))))) and (self.synpred2_t033backtracking()))) :
                    alt18 = 1
            elif LA18 == 36:
                LA18_22 = self.input.LA(3)

                if ((((((self.isTypeName(self.input.LT(1).getText()))) and ((self.isTypeName(self.input.LT(1).getText()))))) and (self.synpred2_t033backtracking()))) :
                    alt18 = 1
            elif LA18 == 37:
                LA18_23 = self.input.LA(3)

                if ((((((self.isTypeName(self.input.LT(1).getText()))) and ((self.isTypeName(self.input.LT(1).getText()))))) and (self.synpred2_t033backtracking()))) :
                    alt18 = 1
            elif LA18 == 35:
                LA18_24 = self.input.LA(3)

                if ((((((self.isTypeName(self.input.LT(1).getText()))) and ((self.isTypeName(self.input.LT(1).getText()))))) and (self.synpred2_t033backtracking()))) :
                    alt18 = 1
            elif LA18 == 33:
                LA18_25 = self.input.LA(3)

                if ((((((self.isTypeName(self.input.LT(1).getText()))) and ((self.isTypeName(self.input.LT(1).getText()))))) and (self.synpred2_t033backtracking()))) :
                    alt18 = 1
            elif LA18 == 40:
                LA18_26 = self.input.LA(3)

                if ((((((self.isTypeName(self.input.LT(1).getText()))) and ((self.isTypeName(self.input.LT(1).getText()))))) and (self.synpred2_t033backtracking()))) :
                    alt18 = 1
            elif LA18 == 43:
                LA18_27 = self.input.LA(3)

                if ((((((self.isTypeName(self.input.LT(1).getText()))) and ((self.isTypeName(self.input.LT(1).getText()))))) and (self.synpred2_t033backtracking()))) :
                    alt18 = 1
            elif LA18 == 32 or LA18 == 45:
                LA18_28 = self.input.LA(3)

                if ((((((self.isTypeName(self.input.LT(1).getText()))) and ((self.isTypeName(self.input.LT(1).getText()))))) and (self.synpred2_t033backtracking()))) :
                    alt18 = 1
        if alt18 == 1:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:66:6: declaration_specifiers
            pass 
            self._state.following.append(self.FOLLOW_declaration_specifiers_in_synpred4_t033backtracking104)
            self.declaration_specifiers()

            self._state.following.pop()




        self._state.following.append(self.FOLLOW_declarator_in_synpred4_t033backtracking107)
        self.declarator()

        self._state.following.pop()

        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:66:41: ( declaration )*
        while True: #loop19
            alt19 = 2
            LA19_0 = self.input.LA(1)

            if (LA19_0 == IDENTIFIER or (30 <= LA19_0 <= 45)) :
                alt19 = 1


            if alt19 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:66:41: declaration
                pass 
                self._state.following.append(self.FOLLOW_declaration_in_synpred4_t033backtracking109)
                self.declaration()

                self._state.following.pop()


            else:
                break #loop19


        self.match(self.input, <INVALID>, self.FOLLOW_<INVALID>_in_synpred4_t033backtracking112)



    # $ANTLR end "synpred4_t033backtracking"



    # $ANTLR start "synpred5_t033backtracking"
    def synpred5_t033backtracking_fragment(self, ):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:75:4: ( declaration_specifiers )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:75:4: declaration_specifiers
        pass 
        self._state.following.append(self.FOLLOW_declaration_specifiers_in_synpred5_t033backtracking144)
        self.declaration_specifiers()

        self._state.following.pop()



    # $ANTLR end "synpred5_t033backtracking"



    # $ANTLR start "synpred6_t033backtracking"
    def synpred6_t033backtracking_fragment(self, ):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:88:14: ( declaration_specifiers )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:88:14: declaration_specifiers
        pass 
        self._state.following.append(self.FOLLOW_declaration_specifiers_in_synpred6_t033backtracking172)
        self.declaration_specifiers()

        self._state.following.pop()



    # $ANTLR end "synpred6_t033backtracking"



    # $ANTLR start "synpred10_t033backtracking"
    def synpred10_t033backtracking_fragment(self, ):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:95:7: ( type_specifier )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:95:7: type_specifier
        pass 
        self._state.following.append(self.FOLLOW_type_specifier_in_synpred10_t033backtracking218)
        self.type_specifier()

        self._state.following.pop()



    # $ANTLR end "synpred10_t033backtracking"



    # $ANTLR start "synpred27_t033backtracking"
    def synpred27_t033backtracking_fragment(self, ):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:192:4: ( ( pointer )? direct_declarator )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:192:4: ( pointer )? direct_declarator
        pass 
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:192:4: ( pointer )?
        alt21 = 2
        LA21_0 = self.input.LA(1)

        if (LA21_0 == 25) :
            alt21 = 1
        if alt21 == 1:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:192:4: pointer
            pass 
            self._state.following.append(self.FOLLOW_pointer_in_synpred27_t033backtracking457)
            self.pointer()

            self._state.following.pop()




        self._state.following.append(self.FOLLOW_direct_declarator_in_synpred27_t033backtracking460)
        self.direct_declarator()

        self._state.following.pop()



    # $ANTLR end "synpred27_t033backtracking"



    # $ANTLR start "synpred31_t033backtracking"
    def synpred31_t033backtracking_fragment(self, ):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:217:8: ( type_qualifier )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:217:8: type_qualifier
        pass 
        self._state.following.append(self.FOLLOW_type_qualifier_in_synpred31_t033backtracking556)
        self.type_qualifier()

        self._state.following.pop()



    # $ANTLR end "synpred31_t033backtracking"



    # $ANTLR start "synpred32_t033backtracking"
    def synpred32_t033backtracking_fragment(self, ):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:217:24: ( pointer )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:217:24: pointer
        pass 
        self._state.following.append(self.FOLLOW_pointer_in_synpred32_t033backtracking559)
        self.pointer()

        self._state.following.pop()



    # $ANTLR end "synpred32_t033backtracking"



    # $ANTLR start "synpred33_t033backtracking"
    def synpred33_t033backtracking_fragment(self, ):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:217:4: ( '*' ( type_qualifier )+ ( pointer )? )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:217:4: '*' ( type_qualifier )+ ( pointer )?
        pass 
        self.match(self.input, 25, self.FOLLOW_25_in_synpred33_t033backtracking554)

        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:217:8: ( type_qualifier )+
        cnt22 = 0
        while True: #loop22
            alt22 = 2
            LA22_0 = self.input.LA(1)

            if (LA22_0 == 32 or LA22_0 == 45) :
                alt22 = 1


            if alt22 == 1:
                # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:217:8: type_qualifier
                pass 
                self._state.following.append(self.FOLLOW_type_qualifier_in_synpred33_t033backtracking556)
                self.type_qualifier()

                self._state.following.pop()


            else:
                if cnt22 >= 1:
                    break #loop22

                if self._state.backtracking > 0:
                    raise BacktrackingFailed


                eee = EarlyExitException(22, self.input)
                raise eee

            cnt22 += 1


        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:217:24: ( pointer )?
        alt23 = 2
        LA23_0 = self.input.LA(1)

        if (LA23_0 == 25) :
            alt23 = 1
        if alt23 == 1:
            # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:217:24: pointer
            pass 
            self._state.following.append(self.FOLLOW_pointer_in_synpred33_t033backtracking559)
            self.pointer()

            self._state.following.pop()






    # $ANTLR end "synpred33_t033backtracking"



    # $ANTLR start "synpred34_t033backtracking"
    def synpred34_t033backtracking_fragment(self, ):
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:218:4: ( '*' pointer )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Python/tests/t033backtracking.g:218:4: '*' pointer
        pass 
        self.match(self.input, 25, self.FOLLOW_25_in_synpred34_t033backtracking565)

        self._state.following.append(self.FOLLOW_pointer_in_synpred34_t033backtracking567)
        self.pointer()

        self._state.following.pop()



    # $ANTLR end "synpred34_t033backtracking"




    def synpred5_t033backtracking(self):
        self._state.backtracking += 1
        start = self.input.mark()
        try:
            self.synpred5_t033backtracking_fragment()
        except BacktrackingFailed:
            success = False
        else:
            success = True
        self.input.rewind(start)
        self._state.backtracking -= 1
        return success

    def synpred4_t033backtracking(self):
        self._state.backtracking += 1
        start = self.input.mark()
        try:
            self.synpred4_t033backtracking_fragment()
        except BacktrackingFailed:
            success = False
        else:
            success = True
        self.input.rewind(start)
        self._state.backtracking -= 1
        return success

    def synpred34_t033backtracking(self):
        self._state.backtracking += 1
        start = self.input.mark()
        try:
            self.synpred34_t033backtracking_fragment()
        except BacktrackingFailed:
            success = False
        else:
            success = True
        self.input.rewind(start)
        self._state.backtracking -= 1
        return success

    def synpred6_t033backtracking(self):
        self._state.backtracking += 1
        start = self.input.mark()
        try:
            self.synpred6_t033backtracking_fragment()
        except BacktrackingFailed:
            success = False
        else:
            success = True
        self.input.rewind(start)
        self._state.backtracking -= 1
        return success

    def synpred32_t033backtracking(self):
        self._state.backtracking += 1
        start = self.input.mark()
        try:
            self.synpred32_t033backtracking_fragment()
        except BacktrackingFailed:
            success = False
        else:
            success = True
        self.input.rewind(start)
        self._state.backtracking -= 1
        return success

    def synpred31_t033backtracking(self):
        self._state.backtracking += 1
        start = self.input.mark()
        try:
            self.synpred31_t033backtracking_fragment()
        except BacktrackingFailed:
            success = False
        else:
            success = True
        self.input.rewind(start)
        self._state.backtracking -= 1
        return success

    def synpred2_t033backtracking(self):
        self._state.backtracking += 1
        start = self.input.mark()
        try:
            self.synpred2_t033backtracking_fragment()
        except BacktrackingFailed:
            success = False
        else:
            success = True
        self.input.rewind(start)
        self._state.backtracking -= 1
        return success

    def synpred27_t033backtracking(self):
        self._state.backtracking += 1
        start = self.input.mark()
        try:
            self.synpred27_t033backtracking_fragment()
        except BacktrackingFailed:
            success = False
        else:
            success = True
        self.input.rewind(start)
        self._state.backtracking -= 1
        return success

    def synpred10_t033backtracking(self):
        self._state.backtracking += 1
        start = self.input.mark()
        try:
            self.synpred10_t033backtracking_fragment()
        except BacktrackingFailed:
            success = False
        else:
            success = True
        self.input.rewind(start)
        self._state.backtracking -= 1
        return success

    def synpred33_t033backtracking(self):
        self._state.backtracking += 1
        start = self.input.mark()
        try:
            self.synpred33_t033backtracking_fragment()
        except BacktrackingFailed:
            success = False
        else:
            success = True
        self.input.rewind(start)
        self._state.backtracking -= 1
        return success



 

    FOLLOW_external_declaration_in_translation_unit81 = frozenset([1, 13, 23, 25, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45])
    FOLLOW_function_definition_in_external_declaration117 = frozenset([1])
    FOLLOW_declaration_in_external_declaration122 = frozenset([1])
    FOLLOW_declaration_specifiers_in_function_definition144 = frozenset([13, 23, 25])
    FOLLOW_declarator_in_function_definition147 = frozenset([1])
    FOLLOW_42_in_declaration170 = frozenset([13, 23, 25, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 43, 44, 45])
    FOLLOW_declaration_specifiers_in_declaration172 = frozenset([13, 23, 25])
    FOLLOW_init_declarator_list_in_declaration180 = frozenset([27])
    FOLLOW_27_in_declaration182 = frozenset([1])
    FOLLOW_declaration_specifiers_in_declaration188 = frozenset([13, 23, 25, 27])
    FOLLOW_init_declarator_list_in_declaration190 = frozenset([27])
    FOLLOW_27_in_declaration193 = frozenset([1])
    FOLLOW_storage_class_specifier_in_declaration_specifiers210 = frozenset([1, 13, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 43, 44, 45])
    FOLLOW_type_specifier_in_declaration_specifiers218 = frozenset([1, 13, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 43, 44, 45])
    FOLLOW_type_qualifier_in_declaration_specifiers232 = frozenset([1, 13, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 43, 44, 45])
    FOLLOW_init_declarator_in_init_declarator_list254 = frozenset([1, 26])
    FOLLOW_26_in_init_declarator_list257 = frozenset([13, 23, 25])
    FOLLOW_init_declarator_in_init_declarator_list259 = frozenset([1, 26])
    FOLLOW_declarator_in_init_declarator272 = frozenset([1])
    FOLLOW_44_in_type_specifier310 = frozenset([1])
    FOLLOW_31_in_type_specifier315 = frozenset([1])
    FOLLOW_39_in_type_specifier320 = frozenset([1])
    FOLLOW_36_in_type_specifier325 = frozenset([1])
    FOLLOW_37_in_type_specifier330 = frozenset([1])
    FOLLOW_35_in_type_specifier335 = frozenset([1])
    FOLLOW_33_in_type_specifier340 = frozenset([1])
    FOLLOW_40_in_type_specifier345 = frozenset([1])
    FOLLOW_43_in_type_specifier350 = frozenset([1])
    FOLLOW_type_id_in_type_specifier357 = frozenset([1])
    FOLLOW_IDENTIFIER_in_type_id375 = frozenset([1])
    FOLLOW_pointer_in_declarator457 = frozenset([13, 23])
    FOLLOW_direct_declarator_in_declarator460 = frozenset([1])
    FOLLOW_pointer_in_declarator465 = frozenset([1])
    FOLLOW_IDENTIFIER_in_direct_declarator480 = frozenset([1, 23, 28])
    FOLLOW_23_in_direct_declarator491 = frozenset([13, 23, 25])
    FOLLOW_declarator_in_direct_declarator493 = frozenset([24])
    FOLLOW_24_in_direct_declarator495 = frozenset([1, 23, 28])
    FOLLOW_declarator_suffix_in_direct_declarator509 = frozenset([1, 23, 28])
    FOLLOW_28_in_declarator_suffix527 = frozenset([29])
    FOLLOW_29_in_declarator_suffix529 = frozenset([1])
    FOLLOW_23_in_declarator_suffix541 = frozenset([24])
    FOLLOW_24_in_declarator_suffix543 = frozenset([1])
    FOLLOW_25_in_pointer554 = frozenset([32, 45])
    FOLLOW_type_qualifier_in_pointer556 = frozenset([1, 25, 32, 45])
    FOLLOW_pointer_in_pointer559 = frozenset([1])
    FOLLOW_25_in_pointer565 = frozenset([25])
    FOLLOW_pointer_in_pointer567 = frozenset([1])
    FOLLOW_25_in_pointer572 = frozenset([1])
    FOLLOW_declaration_specifiers_in_synpred2_t033backtracking104 = frozenset([1])
    FOLLOW_declaration_specifiers_in_synpred4_t033backtracking104 = frozenset([13, 23, 25])
    FOLLOW_declarator_in_synpred4_t033backtracking107 = frozenset([1, 13, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45])
    FOLLOW_declaration_in_synpred4_t033backtracking109 = frozenset([1, 13, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45])
    FOLLOW_<INVALID>_in_synpred4_t033backtracking112 = frozenset([1])
    FOLLOW_declaration_specifiers_in_synpred5_t033backtracking144 = frozenset([1])
    FOLLOW_declaration_specifiers_in_synpred6_t033backtracking172 = frozenset([1])
    FOLLOW_type_specifier_in_synpred10_t033backtracking218 = frozenset([1])
    FOLLOW_pointer_in_synpred27_t033backtracking457 = frozenset([13, 23])
    FOLLOW_direct_declarator_in_synpred27_t033backtracking460 = frozenset([1])
    FOLLOW_type_qualifier_in_synpred31_t033backtracking556 = frozenset([1])
    FOLLOW_pointer_in_synpred32_t033backtracking559 = frozenset([1])
    FOLLOW_25_in_synpred33_t033backtracking554 = frozenset([32, 45])
    FOLLOW_type_qualifier_in_synpred33_t033backtracking556 = frozenset([1, 25, 32, 45])
    FOLLOW_pointer_in_synpred33_t033backtracking559 = frozenset([1])
    FOLLOW_25_in_synpred34_t033backtracking565 = frozenset([25])
    FOLLOW_pointer_in_synpred34_t033backtracking567 = frozenset([1])



def main(argv, stdin=sys.stdin, stdout=sys.stdout, stderr=sys.stderr):
    from antlr3.main import ParserMain
    main = ParserMain("t033backtrackingLexer", t033backtrackingParser)

    main.stdin = stdin
    main.stdout = stdout
    main.stderr = stderr
    main.execute(argv)



if __name__ == '__main__':
    main(sys.argv)
