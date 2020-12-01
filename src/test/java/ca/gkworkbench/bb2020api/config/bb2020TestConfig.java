package ca.gkworkbench.bb2020api.config;

import ca.gkworkbench.bb2020api.player.template.bo.PlayerTemplateBO;
import ca.gkworkbench.bb2020api.player.template.bo.PlayerTemplateBOImpl;
import ca.gkworkbench.bb2020api.player.template.dao.PlayerTemplateDAO;
import ca.gkworkbench.bb2020api.player.template.dao.PlayerTemplateDAOImpl;
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
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@PropertySource("bb2020api.properties")
@EnableTransactionManagement
public class bb2020TestConfig {
    @Autowired
    private Environment env;

    /**
     ******************************
     * Data source
     ******************************
     */

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:init-db.sql")
                .build();
    }

    /**
     ******************************
     * Player Template Beans
     ******************************
     */

    @Bean
    public PlayerTemplateDAO playerTemplateDAO() {
        PlayerTemplateDAOImpl ptDAO = new PlayerTemplateDAOImpl();
        ptDAO.setDataSource(dataSource());
        return ptDAO;
    }

    @Bean
    public PlayerTemplateBO playerTemplateBO() {
        return new PlayerTemplateBOImpl(playerTemplateDAO());
    }

    /*
     ******************************
     * Team Template Beans
     ******************************
     */

    @Bean
    public TeamTemplateDAO teamTemplateDAO() {
        TeamTemplateDAOImpl ttDAO = new TeamTemplateDAOImpl();
        ttDAO.setDataSource(dataSource());
        return ttDAO;
    }

    @Bean
    public TeamTemplateBO teamTemplateBO() {
        return new TeamTemplateBOImpl(teamTemplateDAO(),playerTemplateBO());
    }
}
