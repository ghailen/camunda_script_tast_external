package org.ghailene;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component("requestTypeClass")
public class RequestHandler implements JavaDelegate {

    private final Logger LOGGER = Logger.getLogger(RequestHandler.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("Task Show request type: is executed ");

        // all the variable are with type Object so we need to cast it to get the value
        String requestType= (String) delegateExecution.getVariable("requestType");

        boolean requestStatus;

        if (!requestType.isEmpty() && requestType!=null){
            requestStatus=true;
            delegateExecution.setVariable("status",requestStatus);
        }else
            requestStatus=false;
            delegateExecution.setVariable("status",requestStatus);

    }
}
