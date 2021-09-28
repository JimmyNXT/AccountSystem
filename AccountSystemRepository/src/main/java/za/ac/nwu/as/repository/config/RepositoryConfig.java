package za.ac.nwu.as.repository.config;

import oracle.jdbc.pool.OracleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("za.ac.nwu.as.repository.persistence")
@EntityScan("za.ac.nwu.as.domain.persistence")
@PropertySource(value = "classpath:application-db.properties")
public class RepositoryConfig {

    private static final String[] ENTITY_PACKAGES_TO_SCAN = {"za.ac.nwu.as.domain.persistence"};
    private static final String PERSISTENCE_UNIT_NAME = "account.system.persistence";

    @Value("$spring.datasource.url$")
    private String datasourceUrl;

    @Value("$spring.datasource.username$")
    private String username;

    @Value("$spring.datasource.password$")
    private String password;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan(ENTITY_PACKAGES_TO_SCAN);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setJpaProperties(buildJpaProperties());
        entityManagerFactoryBean.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);

        return entityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate();
    }

    @Bean
    public DataSource dataSource()
    {
        try{
            OracleDataSource dataSource = new OracleDataSource();
            dataSource.setUser(username);
            dataSource.setPassword(password);
            dataSource.setURL(datasourceUrl);
            dataSource.setImplicitCachingEnabled(true);
            //dataSource.setFastConnectionFailoverEnabled(true);

            return dataSource;
        }catch (SQLException e){
            //TODO: Log out of that Repository Configured
            throw new RuntimeException("Unable to connect to the Database", e);
        }
    }

    private Properties buildJpaProperties(){

    }
}
