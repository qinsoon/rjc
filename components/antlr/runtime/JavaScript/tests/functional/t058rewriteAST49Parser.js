// $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST49.g 2013-01-03 11:00:12

var t058rewriteAST49Parser = function(input, state) {
    if (!state) {
        state = new org.antlr.runtime.RecognizerSharedState();
    }

    (function(){
    }).call(this);

    t058rewriteAST49Parser.superclass.constructor.call(this, input, state);



    /* @todo only create adaptor if output=AST */
    this.adaptor = new org.antlr.runtime.tree.CommonTreeAdaptor();

};

org.antlr.lang.augmentObject(t058rewriteAST49Parser, {
    : ,
    : ,
    : ,
    : ,
    : ,
    : ,
    : ,
    : ,
    : 
});

(function(){
// public class variables
var = ,
    = ,
    = ,
    = ,
    = ,
    = ,
    = ,
    = ,
    = ;

// public instance methods/vars
org.antlr.lang.extend(t058rewriteAST49Parser, org.antlr.runtime.Parser, {
setTreeAdaptor: function(adaptor) {
    this.adaptor = adaptor;
},
getTreeAdaptor: function() {
    return this.adaptor;
},

    getTokenNames: function() { return t058rewriteAST49Parser.tokenNames; },
    getGrammarFileName: function() { return "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST49.g"; }
});
org.antlr.lang.augmentObject(t058rewriteAST49Parser.prototype, {

    // inline static return class
    _return: (function() {
        t058rewriteAST49Parser._return
     = function(){};
        org.antlr.lang.extend(
    t058rewriteAST49Parser._return
    ,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),


    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST49.g:4:1: a : 'int' ID ( ',' ID )* ';' -> ^( 'int' ( ID )+ ) ;
    // $ANTLR start "a"
    a: function() {
        var retval = new 
        t058rewriteAST49Parser._return
        ();
        retval.start = this.input.LT(1);


        var root_0 = null;

        var  = null;
        var  = null;
        var  = null;
        var  = null;
        var  = null;

        var _tree=null;
        var _tree=null;
        var _tree=null;
        var _tree=null;
        var _tree=null;
        var stream_=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token ");
        var stream_=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token ");
        var stream_=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token ");
        var stream_=new org.antlr.runtime.tree.RewriteRuleTokenStream(this.adaptor,"token ");

        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST49.g:4:3: ( 'int' ID ( ',' ID )* ';' -> ^( 'int' ( ID )+ ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST49.g:4:5: 'int' ID ( ',' ID )* ';'








            // AST REWRITE
            // elements: ID, 11
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            var stream_=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"token ",!=null?.tree:null);

            root_0 = this.adaptor.nil();
            // 4:28: -> ^( 'int' ( ID )+ )
            {
                // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST49.g:4:31: ^( 'int' ( ID )+ )
                {
                var root_1 = this.adaptor.nil();
                root_1 = this.adaptor.becomeRoot(
                stream_11.nextNode()
                , root_1);

                if ( !(stream_ID.hasNext()) ) {
                    throw new org.antlr.runtime.tree.RewriteEarlyExitException();
                }
                while ( stream_ID.hasNext() ) {
                    this.adaptor.addChild(root_1, 
                    stream_ID.nextNode()
                    );

                }
                stream_ID.reset();

                this.adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;



            retval.stop = this.input.LT(-1);


            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }

        finally {
        }
        return 
    retval
    ;
    },


    // inline static return class
    _return: (function() {
        t058rewriteAST49Parser._return
     = function(){};
        org.antlr.lang.extend(
    t058rewriteAST49Parser._return
    ,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),


    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST49.g:5:1: op : ( '+' | '-' );
    // $ANTLR start "op"
    op: function() {
        var retval = new 
        t058rewriteAST49Parser._return
        ();
        retval.start = this.input.LT(1);


        var root_0 = null;

        var  = null;

        var _tree=null;

        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST49.g:5:4: ( '+' | '-' )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST49.g:
            root_0 = this.adaptor.nil();






            retval.stop = this.input.LT(-1);


            retval.tree = this.adaptor.rulePostProcessing(root_0);
            this.adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (re) {
            if (re instanceof org.antlr.runtime.RecognitionException) {
                this.reportError(re);
                this.recover(this.input,re);
                retval.tree = this.adaptor.errorNode(this.input, retval.start, this.input.LT(-1), re);
            } else {
                throw re;
            }
        }

        finally {
        }
        return 
    retval
    ;
    }

    // Delegated rules




}, true); // important to pass true to overwrite default implementations

 

// public class variables
org.antlr.lang.augmentObject(t058rewriteAST49Parser, {
    tokenNames: ["<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "WS", "'+'", "','", "'-'", "';'", "'int'"],

});

})();