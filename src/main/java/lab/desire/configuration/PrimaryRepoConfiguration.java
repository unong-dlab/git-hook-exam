package lab.desire.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by unong on 4/12/16.
 */
@Configuration
@EnableJpaRepositories(basePackages = "lab.desire.repository",
        entityManagerFactoryRef = "primaryEntityManagerFactory")
public class PrimaryRepoConfiguration {

}
