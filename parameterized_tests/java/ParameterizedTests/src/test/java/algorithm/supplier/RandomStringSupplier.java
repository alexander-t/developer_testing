package algorithm.supplier;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

import java.util.Arrays;
import java.util.List;

public class RandomStringSupplier extends ParameterSupplier {

    @Override
    public List<PotentialAssignment> getValueSources(ParameterSignature signature) throws Throwable {
        RandomString annotation = signature.getAnnotation(RandomString.class);
        int length = (int) (Math.random() * annotation.maxLength());
        final String s = RandomStringUtils.randomAlphanumeric(length);
        return Arrays.asList(PotentialAssignment.forValue("random string", s));
    }
}
