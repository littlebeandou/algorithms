package other;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xiaoqiang
 * @date 2019-03-30 09
 */
public enum Phase {
    SOLID, LIQUID, GAS, PLASMA;

    public enum Transition {
        MELT(SOLID, LIQUID),
        FREEZE(LIQUID, SOLID),
        BOIT(LIQUID, GAS),
        CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS),
        DEPOSIT(GAS, SOLID),
        IONIZE(GAS, PLASMA),
        DEIONIZE(PLASMA, GAS);

        private final Phase from;
        private final Phase to;

        Transition(Phase from, Phase to) {
            this.from = from;
            this.to = to;
        }

        private static final Map<Phase, Map<Phase, Transition>> map = new EnumMap<Phase, Map<Phase, Transition>>(Phase.class);

        static {
            for (Transition transition : values()) {
                Map<Phase, Transition> enumMap;
                if (map.containsKey(transition.from)) {
                    enumMap = map.get(transition.from);
                } else {
                    enumMap = new EnumMap<Phase, Transition>(Phase.class);
                    map.put(transition.from, enumMap);
                }
                enumMap.put(transition.to, transition);
            }
        }

        public static Transition from(Phase from, Phase to) {
            return map.get(from).get(to);
        }

    }
}
