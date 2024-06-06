package org.napalabs.bpms.delegates;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class PrintLnDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
//        var name = delegateExecution.getVariable("name");
//        System.out.println("Hello, " + name.toString() + "!");
        throw new BpmnError("BPMN_ERROR");
    }
}
