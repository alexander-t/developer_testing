package premiums.supplier;

import premiums.domain.Gender;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

import java.util.Arrays;
import java.util.List;

import static org.junit.experimental.theories.PotentialAssignment.forValue;

public class GenderSupplier extends ParameterSupplier {
    @Override
    public List<PotentialAssignment> getValueSources(ParameterSignature sig) {
        return Arrays.asList(
                forValue("gender", Gender.MALE),
                forValue("gender", Gender.FEMALE),
                forValue("gender", Gender.UNKNOWN));
    }
}
