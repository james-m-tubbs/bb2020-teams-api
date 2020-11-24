package ca.gkworkbench.bb2020api.config;

import ca.gkworkbench.bb2020api.team.template.bo.TeamTemplateBO;
import ca.gkworkbench.bb2020api.team.template.bo.TeamTemplateBOImpl;
import ca.gkworkbench.bb2020api.team.template.dao.TeamTemplateDAO;
import ca.gkworkbench.bb2020api.team.template.dao.TeamTemplateDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@PropertySource("bb2020api.properties")
@EnableTransactionManagement
public class bb2020Config {
    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.pass"));

        return dataSource;
    }

    @Bean
    public TeamTemplateDAO teamTemplateDAO() {
        TeamTemplateDAOImpl ttDAO = new TeamTemplateDAOImpl();
        ttDAO.setDataSource(dataSource());
        return ttDAO;
    }

    @Bean
    public TeamTemplateBO teamTemplateBO() {
        return new TeamTemplateBOImpl(teamTemplateDAO());
    }
}
