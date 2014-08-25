import admin.RestWizawdHealtCheck;
import config.RestWizardConfig;
import factory.EployeeResourceFactory;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;
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
        final RestWizawdHealtCheck restWizawdHealtCheck = new RestWizawdHealtCheck();

        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, restWizardConfig.getDataSourceFactory(), "empdb");

        EployeeResourceFactory eployeeResourceFactory = new EployeeResourceFactory();
        EmployeeResource employeeResource = eployeeResourceFactory.getNewInstance(jdbi);

        environment.healthChecks().register("restwizard", restWizawdHealtCheck);
        environment.jersey().register(employeeResource);
    }
}
