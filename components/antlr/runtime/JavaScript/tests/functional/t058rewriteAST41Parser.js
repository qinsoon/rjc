// $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST41.g 2013-01-03 11:01:12

var t058rewriteAST41Parser = function(input, state) {
    if (!state) {
        state = new org.antlr.runtime.RecognizerSharedState();
    }

    (function(){
    }).call(this);

    t058rewriteAST41Parser.superclass.constructor.call(this, input, state);



    /* @todo only create adaptor if output=AST */
    this.adaptor = new org.antlr.runtime.tree.CommonTreeAdaptor();

};

org.antlr.lang.augmentObject(t058rewriteAST41Parser, {
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
    = ;

// public instance methods/vars
org.antlr.lang.extend(t058rewriteAST41Parser, org.antlr.runtime.Parser, {
setTreeAdaptor: function(adaptor) {
    this.adaptor = adaptor;
},
getTreeAdaptor: function() {
    return this.adaptor;
},

    getTokenNames: function() { return t058rewriteAST41Parser.tokenNames; },
    getGrammarFileName: function() { return "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST41.g"; }
});
org.antlr.lang.augmentObject(t058rewriteAST41Parser.prototype, {

    // inline static return class
    _return: (function() {
        t058rewriteAST41Parser._return
     = function(){};
        org.antlr.lang.extend(
    t058rewriteAST41Parser._return
    ,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),


    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST41.g:5:1: a : atom -> ^( atom atom ) ;
    // $ANTLR start "a"
    a: function() {
        var retval = new 
        t058rewriteAST41Parser._return
        ();
        retval.start = this.input.LT(1);


        var root_0 = null;

        var stream_=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"rule ");
        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST41.g:5:3: ( atom -> ^( atom atom ) )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST41.g:5:5: atom


            // AST REWRITE
            // elements: atom, atom
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            var stream_=new org.antlr.runtime.tree.RewriteRuleSubtreeStream(this.adaptor,"token ",!=null?.tree:null);

            root_0 = this.adaptor.nil();
            // 5:10: -> ^( atom atom )
            {
                // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST41.g:5:13: ^( atom atom )
                {
                var root_1 = this.adaptor.nil();
                root_1 = this.adaptor.becomeRoot(stream_atom.nextNode(), root_1);

                this.adaptor.addChild(root_1, stream_atom.nextTree());

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
        t058rewriteAST41Parser._return
     = function(){};
        org.antlr.lang.extend(
    t058rewriteAST41Parser._return
    ,
                          org.antlr.runtime.ParserRuleReturnScope,
        {
            getTree: function() { return this.tree; }
        });
        return;
    })(),


    // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST41.g:6:1: atom : INT ;
    // $ANTLR start "atom"
    atom: function() {
        var retval = new 
        t058rewriteAST41Parser._return
        ();
        retval.start = this.input.LT(1);


        var root_0 = null;

        var  = null;

        var _tree=null;

        try {
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST41.g:6:6: ( INT )
            // /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/JavaScript/tests/functional/t058rewriteAST41.g:6:8: INT
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
org.antlr.lang.augmentObject(t058rewriteAST41Parser, {
    tokenNames: ["<invalid>", "<EOR>", "<DOWN>", "<UP>", "BLOCK", "ID", "INT", "WS"],

});

})();