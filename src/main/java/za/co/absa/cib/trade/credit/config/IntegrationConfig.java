package za.co.absa.cib.trade.credit.config;

import javax.sql.DataSource;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import za.co.absa.cib.trade.credit.Application;
import za.co.absa.cib.trade.credit.CreditApplication;
import za.co.absa.cib.trade.credit.absa.AbsaCreditCheck;
import za.co.absa.cib.trade.credit.absa.AbsaCreditCheckTransformer;
import za.co.absa.cib.trade.credit.hsbc.HsbcCreditCheck;
import za.co.absa.cib.trade.credit.hsbc.HsbcCreditCheckTransformer;

@Configuration
@ComponentScan(basePackageClasses = Application.class)
@EnableJpaRepositories(basePackageClasses = CreditApplication.class,
entityManagerFactoryRef = "entityManagerFactory")
public class IntegrationConfig {

	@Bean(name="entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean defaultEntityManagerFactory(
	        EntityManagerFactoryBuilder builder) {
	    return builder
	            .dataSource(dataSource())
	            .packages(CreditApplication.class)
	            .persistenceUnit("trade")
	            .build();
	}
	
	@Bean
	public DataSource dataSource() {
	    DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
	        dataSourceBuilder.url("jdbc:postgresql:trade");
	        dataSourceBuilder.username("trade");
	        dataSourceBuilder.password("jack123");
	        return dataSourceBuilder.build();   
	}
	
	@Bean(name = "absaCreditCheck")
	public AbsaCreditCheck produceAbsaCreditCheck() {
		return new AbsaCreditCheck();
	}

	@Bean(name = "absaCreditCheckTransformer")
	public AbsaCreditCheckTransformer produceAbsaCreditCheckTransformer() {
		return new AbsaCreditCheckTransformer();
	}

	@Bean(name = "hsbcCreditCheck")
	public HsbcCreditCheck produceHsbcCreditCheck() {
		return new HsbcCreditCheck();
	}

	@Bean(name = "hsbcCreditCheckTransformer")
	public HsbcCreditCheckTransformer produceHsbcCreditCheckTransformer() {
		return new HsbcCreditCheckTransformer();
	}
	
	@Bean(name = "defaultCreditCheck")
	public DefaultCreditCheck produceDefaultCreditCheck() {
		return new DefaultCreditCheck();
	}
	

	@Bean
	RouteBuilder produceCreditCheckRoute() {
		return new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				from("direct:start").choice().when(body().method("getBank").isEqualToIgnoreCase("Absa"))
						.transform().method("absaCreditCheckTransformer", "transform").to("absaCreditCheck")
						.when(body().method("bank").isEqualToIgnoreCase("HSBC")).transform()
						.method("hsbcCreditCheckTransformer", "transform").to("hsbcCreditCheck")
						.otherwise().to("defaultCreditCheck");
			}

		};
	}
}
