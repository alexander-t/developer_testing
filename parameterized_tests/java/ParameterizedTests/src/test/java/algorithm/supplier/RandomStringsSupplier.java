package algorithm.supplier;

import net.java.quickcheck.Generator;
import net.java.quickcheck.generator.distribution.Distribution;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

import java.util.ArrayList;
import java.util.List;

import static net.java.quickcheck.generator.PrimitiveGenerators.*;

public class RandomStringsSupplier extends ParameterSupplier {

    @Override
    public List<PotentialAssignment> getValueSources(ParameterSignature signature) throws Throwable {

        List<PotentialAssignment> values = new ArrayList<>();
        RandomStrings annotation = signature.getAnnotation(RandomStrings.class);
        Generator<String> stringGenerator = strings(integers(1, 128, Distribution.INVERTED_NORMAL), characters());

        for (int i = 0; i < annotation.count(); i++) {
            values.add(PotentialAssignment.forValue("random string", stringGenerator.next()));
        }
        return values;
    }
}

