// $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST74.g 2013-01-03 10:57:09

var t058rewriteAST74Lexer = function(input, state) {
// alternate constructor @todo
// public t058rewriteAST74Lexer(CharStream input)
// public t058rewriteAST74Lexer(CharStream input, RecognizerSharedState state) {
    if (!state) {
        state = new org.antlr.runtime.RecognizerSharedState();
    }

    (function(){
    }).call(this);

    t058rewriteAST74Lexer.superclass.constructor.call(this, input, state);

};

org.antlr.lang.augmentObject(t058rewriteAST74Lexer, {
    : ,
    : ,
    : ,
    : ,
    : ,
    : 
});

(function(){
var HIDDEN = org.antlr.runtime.Token.HIDDEN_CHANNEL,
    EOF = org.antlr.runtime.Token.EOF;
org.antlr.lang.extend(t058rewriteAST74Lexer, org.antlr.runtime.Lexer, {
     : ,
     : ,
     : ,
     : ,
     : ,
     : ,
    getGrammarFileName: function() { return "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST74.g"; }
});
org.antlr.lang.augmentObject(t058rewriteAST74Lexer.prototype, {
    // $ANTLR start T__7
    mT__7: function()  {
        try {
            var _type = this.T__7;
            var _channel = org.antlr.runtime.BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST74.g:7:6: ( '+' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST74.g:7:8: '+'




            this.state.type = _type;
            this.state.channel = _channel;
        }
        finally {
        }
    },
    // $ANTLR end "T__7",

    // $ANTLR start T__8
    mT__8: function()  {
        try {
            var _type = this.T__8;
            var _channel = org.antlr.runtime.BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST74.g:8:6: ( '-' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST74.g:8:8: '-'




            this.state.type = _type;
            this.state.channel = _channel;
        }
        finally {
        }
    },
    // $ANTLR end "T__8",

    // $ANTLR start ID
    mID: function()  {
        try {
            var _type = this.ID;
            var _channel = org.antlr.runtime.BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST74.g:6:4: ( ( 'a' .. 'z' )+ )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST74.g:6:6: ( 'a' .. 'z' )+




            this.state.type = _type;
            this.state.channel = _channel;
        }
        finally {
        }
    },
    // $ANTLR end "ID",

    // $ANTLR start INT
    mINT: function()  {
        try {
            var _type = this.INT;
            var _channel = org.antlr.runtime.BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST74.g:7:5: ( ( '0' .. '9' )+ )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST74.g:7:7: ( '0' .. '9' )+




            this.state.type = _type;
            this.state.channel = _channel;
        }
        finally {
        }
    },
    // $ANTLR end "INT",

    // $ANTLR start WS
    mWS: function()  {
        try {
            var _type = this.WS;
            var _channel = org.antlr.runtime.BaseRecognizer.DEFAULT_TOKEN_CHANNEL;
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST74.g:8:4: ( ( ' ' | '\\n' ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST74.g:8:6: ( ' ' | '\\n' )






            this.state.type = _type;
            this.state.channel = _channel;
        }
        finally {
        }
    },
    // $ANTLR end "WS",

    mTokens: function() {
        // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST74.g:1:8: ( T__7 | T__8 | ID | INT | WS )
        var alt3=5;
        switch ( this.input.LA(1) ) {
        case :
            alt3=1;
            break;
        case :
            alt3=2;
            break;
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
            alt3=3;
            break;
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
        case :
            alt3=4;
            break;
        case :
        case :
            alt3=5;
            break;
        default:
            var nvae =
                new org.antlr.runtime.NoViableAltException("", 3, 0, this.input);

            throw nvae;

        }

        switch (alt3) {
            case  :
                break;
            case  :
                break;
            case  :
                break;
            case  :
                break;
            case  :
                break;

        }

    }

}, true); // important to pass true to overwrite default implementations

 
})();