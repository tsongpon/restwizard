import admin.RestWizawdHealtCheck;
import config.RestWizardConfig;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import resources.EmployeeResource;

/**
 *
 */
public class RestWizaedApplication extends Application<RestWizardConfig> {

    public static void main(String[] args) throws Exception {
        new RestWizaedApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<RestWizardConfig> restWizardConfigBootstrap) {

    }

    @Override
    public void run(RestWizardConfig restWizardConfig, Environment environment) throws Exception {
        //final EmployeeResource employeeResource = new EmployeeResource();
        //final RestWizawdHealtCheck restWizawdHealtCheck = new RestWizawdHealtCheck();

        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        EmployeeResource employeeResource = context.getBean("employeeResource", EmployeeResource.class);
        RestWizawdHealtCheck restWizawdHealtCheck = context.getBean("restWizawdHealtCheck", RestWizawdHealtCheck.class);

        environment.healthChecks().register("restwizard", restWizawdHealtCheck);
        environment.jersey().register(employeeResource);
    }
}
