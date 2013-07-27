use strict;
use warnings;

sub read_payment_file_v1() {
    my $filename = shift;
    open(F, $filename) || die;
    while (<F>) {
	my $payment = parse_payment($_);
	
	# Process payment here...
    }
}

sub read_payment_file_v2() {
    my $filename = shift;
    open(F, $filename) || die;
    my @lines = <F>;
    &parse_payments(@lines);
}


# Just stubs
sub parse_payments() {
}

sub parse_payment() {
    my $line = shift;
    chomp($line);
    return $line;
}

