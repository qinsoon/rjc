# $ANTLR 3.4 /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/simplecalc/SimpleCalc.g 2013-01-03 10:54:01

package SimpleCalcParser;

use English qw( -no_match_vars ) ;
use Readonly;
use Switch;
use Carp;
use ANTLR::Runtime::BitSet;

use Moose;

extends 'ANTLR::Runtime::Parser';

Readonly my $token_names => [
    "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DIGIT", "DIV", "MINUS", "MULT", "NUMBER", "PLUS", "WHITESPACE"
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
};



sub BUILD {
    my ($self, $arg_ref) = @_;

}

sub get_token_names {
    return $token_names;
}

sub get_grammar_file_name {
    return "/Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/simplecalc/SimpleCalc.g";
}



# $ANTLR start expr
# /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/simplecalc/SimpleCalc.g:15:1: expr : term ( ( PLUS | MINUS ) term )* ;
sub expr() {
    my ($self, ) = @_;
    eval {
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/simplecalc/SimpleCalc.g:15:9: ( term ( ( PLUS | MINUS ) term )* )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/simplecalc/SimpleCalc.g:15:11: term ( ( PLUS | MINUS ) term )*
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
# $ANTLR end expr



# $ANTLR start term
# /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/simplecalc/SimpleCalc.g:17:1: term : factor ( ( MULT | DIV ) factor )* ;
sub term() {
    my ($self, ) = @_;
    eval {
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/simplecalc/SimpleCalc.g:17:9: ( factor ( ( MULT | DIV ) factor )* )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/simplecalc/SimpleCalc.g:17:11: factor ( ( MULT | DIV ) factor )*
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
# $ANTLR end term



# $ANTLR start factor
# /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/simplecalc/SimpleCalc.g:19:1: factor : NUMBER ;
sub factor() {
    my ($self, ) = @_;
    eval {
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/simplecalc/SimpleCalc.g:19:9: ( NUMBER )
        # /Users/apple/Documents/workspace_research/RJava_Prototype/components/antlr/runtime/Perl5/examples/simplecalc/SimpleCalc.g:19:11: NUMBER
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
# $ANTLR end factor


 

no Moose;
__PACKAGE__->meta->make_immutable();
1;
__END__