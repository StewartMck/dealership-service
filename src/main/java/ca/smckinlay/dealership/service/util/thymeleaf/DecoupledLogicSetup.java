package ca.smckinlay.dealership.service.util.thymeleaf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.annotation.PostConstruct;

@Component
public class DecoupledLogicSetup {

    private static final Logger log = LoggerFactory.getLogger(DecoupledLogicSetup.class);

    private final SpringResourceTemplateResolver templateResolver;


    public DecoupledLogicSetup(SpringResourceTemplateResolver templateResolver) {
        this.templateResolver = templateResolver;
    }

    @PostConstruct
    public void init(){
        templateResolver.setUseDecoupledLogic(true);
        log.info("THYMELEAF DECOUPLED LOGIC ENABLED");
    }
}
