package uk.co.hadoopathome.kafkastreams.drools;

import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.List;

/**
 * Responsible for getting a Drools session and applying the Drools rules.
 */
public class DroolsRulesApplier {
    private static KieSession KIE_SESSION;
    private List<String> returnMessages;

    public DroolsRulesApplier(String sessionName) {
        KIE_SESSION = DroolsSessionFactory.createDroolsSession(sessionName);
        returnMessages = new ArrayList<>();
        KIE_SESSION.setGlobal("returnList", returnMessages);
    }

    /**
     * Applies the loaded Drools rules to a given String.
     *
     * @param value the String to which the rules should be applied
     * @return the String after the rule has been applied
     */
    public Iterable<String> applyRule(String value) {
        Message message = new Message(value);
        KIE_SESSION.insert(message);
        KIE_SESSION.fireAllRules();
        return freeReturnMessages();
    }

    private Iterable<String> freeReturnMessages(){
        List<String> tempMessages = new ArrayList<>(returnMessages);
        returnMessages.clear();
        return tempMessages;
    }
}
