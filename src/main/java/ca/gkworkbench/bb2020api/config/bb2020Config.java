package ca.gkworkbench.bb2020api.config;

import ca.gkworkbench.bb2020api.player.bo.PlayerTemplateBO;
import ca.gkworkbench.bb2020api.player.bo.impl.PlayerTemplateBOImpl;
import ca.gkworkbench.bb2020api.player.dao.PlayerTemplateDAO;
import ca.gkworkbench.bb2020api.player.dao.impl.PlayerTemplateDAOImpl;
import ca.gkworkbench.bb2020api.skill.dao.SkillTemplateDAO;
import ca.gkworkbench.bb2020api.skill.dao.SkillTemplateDAOImpl;
import ca.gkworkbench.bb2020api.team.bo.TeamTemplateBO;
import ca.gkworkbench.bb2020api.team.bo.TeamsBO;
import ca.gkworkbench.bb2020api.team.bo.impl.TeamTemplateBOImpl;
import ca.gkworkbench.bb2020api.team.bo.impl.TeamsBOImpl;
import ca.gkworkbench.bb2020api.team.dao.TeamTemplateDAO;
import ca.gkworkbench.bb2020api.team.dao.TeamsDAO;
import ca.gkworkbench.bb2020api.team.dao.impl.TeamTemplateDAOImpl;
import ca.gkworkbench.bb2020api.team.dao.impl.TeamsDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@PropertySource("bb2020api.properties")
@EnableTransactionManagement
public class bb2020Config {
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
     * Skill Template Beans
     ******************************
     */

    @Bean
    public SkillTemplateDAO skillTemplateDAO() {
        SkillTemplateDAOImpl stDAO = new SkillTemplateDAOImpl();
        stDAO.setDataSource(dataSource());
        return stDAO;
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
        return new PlayerTemplateBOImpl(
                playerTemplateDAO(),
                skillTemplateDAO());
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

    /**
     ******************************
     * Team Beans
     ******************************
     */

    @Bean
    public TeamsDAO teamsDAO() {
        TeamsDAOImpl tDAO = new TeamsDAOImpl();
        tDAO.setDataSource(dataSource());
        return tDAO;
    }

    @Bean
    public TeamsBO teamsBO() {
        return new TeamsBOImpl(
                teamsDAO(),
                teamTemplateDAO());
    }
}
