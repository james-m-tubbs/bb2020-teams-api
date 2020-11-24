package ca.gkworkbench.bb2020api.config;

import ca.gkworkbench.bb2020api.team.template.bo.TeamTemplateBO;
import ca.gkworkbench.bb2020api.team.template.bo.TeamTemplateBOImpl;
import ca.gkworkbench.bb2020api.team.template.dao.TeamTemplateDAO;
import ca.gkworkbench.bb2020api.team.template.dao.TeamTemplateDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class bb2020TestConfig {
    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:team-template.sql")
                .build();
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
