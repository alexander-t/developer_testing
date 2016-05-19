package syntax

import spock.lang.Specification

class SpockSyntaxTest extends Specification {

    def "Demonstrate creation of a stub"() {
        given:
        def dependencyStub = Stub(Dependency)
        dependencyStub.computeAndReturnValue(_) >> 21

        expect:
        dependencyStub.computeAndReturnValue(10) == 21
    }

    def "Demonstrate stubbing of consecutive calls"() {
        given:
        def dependencyStub = Stub(Dependency)
        dependencyStub.computeAndReturnValue(_) >>> [21, 45]

        expect:
        dependencyStub.computeAndReturnValue(10) == 21
        dependencyStub.computeAndReturnValue(10) == 45
    }
}
