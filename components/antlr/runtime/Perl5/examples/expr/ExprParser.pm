# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/expr/Expr.g 2013-01-03 10:54:27



package ExprParser;

use English qw( -no_match_vars ) ;
use Readonly;
use Switch;
use Carp;
use ANTLR::Runtime::BitSet;

use Moose;

extends 'ANTLR::Runtime::Parser';

Readonly my $token_names => [
    "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "NEWLINE", "WS", "'('", "')'", "'*'", "'+'", "'-'", "'='"
];

use constant {
  => , 
  => , 
  => , 
  => , 
  => , 
  => , 
  => , 
  => , 
  => , 
  => , 
  => , 
};



sub BUILD {
    my ($self, $arg_ref) = @_;

}

sub get_token_names {
    return $token_names;
}

sub get_grammar_file_name {
    return "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/expr/Expr.g";
}


    my %memory;



# $ANTLR start prog
# /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/expr/Expr.g:14:1: prog : ( stat )+ ;
sub prog() {
    my ($self, ) = @_;
    eval {
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/expr/Expr.g:14:5: ( ( stat )+ )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/expr/Expr.g:14:9: ( stat )+
        {


        }

    };
    my $exception = $EVAL_ERROR;
    if (ref $exception && $exception->isa('ANTLR::Runtime::RecognitionException')) {
        $self->report_error($exception);
        $self->recover($self->input, $exception);
        $exception = undef;
    }

    if ($exception) {
        croak $exception;
        #$exception->rethrow();
    }
    return 
;
}
# $ANTLR end prog



# $ANTLR start stat
# /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/expr/Expr.g:16:1: stat : ( expr NEWLINE | ID '=' expr NEWLINE | NEWLINE );
sub stat() {
    my ($self, ) = @_;
    my $ = undef;

    eval {
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/expr/Expr.g:16:5: ( expr NEWLINE | ID '=' expr NEWLINE | NEWLINE )
        my $alt2 = 3;
        switch ( $self->input->LA(1) ) {
            case [  ,   ] { $alt2 = 1; }
            case [  ] { my $LA2_2 = $self->input->LA(2);

            if ( ($LA2_2 eq 13) ) {
                $alt2 = 2;
            }
            elsif ( ($LA2_2 eq NEWLINE || ($LA2_2 ge 10 && $LA2_2 le 12)) ) {
                $alt2 = 1;
            }
            else {
                my $nvae =
                    ANTLR::Runtime::NoViableAltException->new({
                        grammar_decision_description => "",
                        decision_number => 2,
                        state_number => 2,
                        input => $self->input,
                    });

                croak $nvae;

            } }
            case [  ] { $alt2 = 3; }
            else {
                my $nvae =
                    ANTLR::Runtime::NoViableAltException->new({
                        grammar_decision_description => "",
                        decision_number => 2,
                        state_number => 0,
                        input => $self->input,
                    });

                croak $nvae;

            }
        }

        switch ($alt2) {
            case  {
            }
            case  {
            }
            case  {
            }

        }
    };
    my $exception = $EVAL_ERROR;
    if (ref $exception && $exception->isa('ANTLR::Runtime::RecognitionException')) {
        $self->report_error($exception);
        $self->recover($self->input, $exception);
        $exception = undef;
    }

    if ($exception) {
        croak $exception;
        #$exception->rethrow();
    }
    return 
;
}
# $ANTLR end stat



# $ANTLR start expr
# /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/expr/Expr.g:22:1: expr returns [value] : e= multExpr ( '+' e= multExpr | '-' e= multExpr )* ;
sub expr() {
    my ($self, ) = @_;
    my $value = 
    undef
    ;


    eval {
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/expr/Expr.g:23:5: (e= multExpr ( '+' e= multExpr | '-' e= multExpr )* )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/expr/Expr.g:23:9: e= multExpr ( '+' e= multExpr | '-' e= multExpr )*
        {






        }

    };
    my $exception = $EVAL_ERROR;
    if (ref $exception && $exception->isa('ANTLR::Runtime::RecognitionException')) {
        $self->report_error($exception);
        $self->recover($self->input, $exception);
        $exception = undef;
    }

    if ($exception) {
        croak $exception;
        #$exception->rethrow();
    }
    return 
$value
;
}
# $ANTLR end expr



# $ANTLR start multExpr
# /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/expr/Expr.g:29:1: multExpr returns [value] : e= atom ( '*' e= atom )* ;
sub multExpr() {
    my ($self, ) = @_;
    my $value = 
    undef
    ;


    eval {
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/expr/Expr.g:30:5: (e= atom ( '*' e= atom )* )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/expr/Expr.g:30:9: e= atom ( '*' e= atom )*
        {






        }

    };
    my $exception = $EVAL_ERROR;
    if (ref $exception && $exception->isa('ANTLR::Runtime::RecognitionException')) {
        $self->report_error($exception);
        $self->recover($self->input, $exception);
        $exception = undef;
    }

    if ($exception) {
        croak $exception;
        #$exception->rethrow();
    }
    return 
$value
;
}
# $ANTLR end multExpr



# $ANTLR start atom
# /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/expr/Expr.g:33:1: atom returns [value] : ( INT | ID | '(' expr ')' );
sub atom() {
    my ($self, ) = @_;
    my $value = 
    undef
    ;


    my $ = undef;
    my $ = undef;

    eval {
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/expr/Expr.g:34:5: ( INT | ID | '(' expr ')' )
        my $alt5 = 3;
        switch ( $self->input->LA(1) ) {
            case [  ] { $alt5 = 1; }
            case [  ] { $alt5 = 2; }
            case [  ] { $alt5 = 3; }
            else {
                my $nvae =
                    ANTLR::Runtime::NoViableAltException->new({
                        grammar_decision_description => "",
                        decision_number => 5,
                        state_number => 0,
                        input => $self->input,
                    });

                croak $nvae;

            }
        }

        switch ($alt5) {
            case  {
            }
            case  {
            }
            case  {
            }

        }
    };
    my $exception = $EVAL_ERROR;
    if (ref $exception && $exception->isa('ANTLR::Runtime::RecognitionException')) {
        $self->report_error($exception);
        $self->recover($self->input, $exception);
        $exception = undef;
    }

    if ($exception) {
        croak $exception;
        #$exception->rethrow();
    }
    return 
$value
;
}
# $ANTLR end atom


 

no Moose;
__PACKAGE__->meta->make_immutable();
1;
__END__