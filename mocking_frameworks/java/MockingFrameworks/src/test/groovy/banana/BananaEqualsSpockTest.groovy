package banana

import spock.lang.Specification

public class BananaEqualsSpockTest extends Specification {
    class Banana {
        String color = "yellow"
    }

    interface Monkey {
        boolean likes(Banana banana)
    }

    def "Monkeys like bananas"() {
        given:
        def monkeyStub = Stub(Monkey)
        monkeyStub.likes(new Banana()) >> true

        expect:
        monkeyStub.likes(new Banana())
    }
}
