package za.ac.nwu.as.repository.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import za.ac.nwu.as.domain.persistence.AccountType;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("za.ac.nwu.as.repository.persistence")
@EntityScan("za.ac.nwu.as.domain.persistence")
@PropertySource(value = "classpath:application-db.properties")
public class RepositoryConfig {
//
//    private static final String[] ENTITY_PACKAGES_TO_SCAN = {"za.ac.nwu.as.domain.persistence"};
//    private static final String PERSISTENCE_UNIT_NAME = "account.system.persistence";
//
//    @Bean
//    public DataSource dataSource(){
//        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//
//        return builder.setType(EmbeddedDatabaseType.HSQL)
//                .addScript("script/schema.sql")
//                .addScript("script/data.sql")
//                .build();
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
//        final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactoryBean.setDataSource(this.dataSource());
//        entityManagerFactoryBean.setPackagesToScan(ENTITY_PACKAGES_TO_SCAN);
//        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        entityManagerFactoryBean.setJpaProperties(this.buildJpaProperties());
//        entityManagerFactoryBean.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
//
//        return entityManagerFactoryBean;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory);
//        return transactionManager;
//    }
//
//    @Bean
//    public JdbcTemplate getJdbcTemplate(){
//        return new JdbcTemplate();
//    }
//
//    @Bean
//    public PersistenceExceptionTranslationPostProcessor exceptionTranslation()
//    {
//        return new PersistenceExceptionTranslationPostProcessor();
//    }
//
//    @Bean
//    public Properties buildJpaProperties()
//    {
//        final Properties properties = new Properties();
//
////        spring.datasource.url=jdbc:mysql://localhost:3306/mydb
////        spring.datasource.username=root
////        spring.datasource.password=dean1998
////        spring.datasource.driver-class-name=com.mysql.jdbc.Driver
////        spring.jpa.database-platform = org.hibernate.dialect.MySQL5Dialect
////        spring.jpa.generate-ddl=true
////        spring.jpa.hibernate.ddl-auto = update
////        spring.jpa.properties.hibernate.format_sql=true
//
//        properties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
//        properties.setProperty("hibernate.show_sql","true");
//        properties.setProperty("hibernate.format_sql","true");
//
//
//        return properties;
//    }
}
