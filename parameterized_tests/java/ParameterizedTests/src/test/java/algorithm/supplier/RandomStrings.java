package algorithm.supplier;

import org.junit.experimental.theories.ParametersSuppliedBy;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@ParametersSuppliedBy(RandomStringsSupplier.class)
public @interface RandomStrings {
    int count();
}
