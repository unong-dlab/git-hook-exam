package lab.desire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
//    @Bean
//    public HibernateJpaSessionFactoryBean sessionFactory(EntityManagerFactory emf) {
//        HibernateJpaSessionFactoryBean factory = new HibernateJpaSessionFactoryBean();
//        factory.setEntityManagerFactory(emf);
//        return factory;
//    }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
