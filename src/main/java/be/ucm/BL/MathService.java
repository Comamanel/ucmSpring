package be.ucm.BL;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

//import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Service
//@Scope(SCOPE_CUCUMBER_GLUE)
public class MathService {

    public double multiplication(double nb1, double nb2){
        return nb1 * nb2;
    }
}
