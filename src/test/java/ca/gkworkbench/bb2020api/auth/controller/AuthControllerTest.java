package ca.gkworkbench.bb2020api.auth.controller;

import ca.gkworkbench.bb2020api.auth.bo.AuthBO;
import ca.gkworkbench.bb2020api.auth.vo.LoginVO;
import ca.gkworkbench.bb2020api.config.bb2020TestConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthController.class)
@Import(AuthController.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes= bb2020TestConfig.class)
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    AuthBO authBO;

    //working user
    private final String testUsername = "authControllerTestUser";
    private final String testPassword = "authControllerTestPassword";
    private final LoginVO workingLoginVO = new LoginVO (testUsername, testPassword);

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @BeforeAll
    public void create_user() throws Exception {
        authBO.createUser(workingLoginVO.getUsername(), workingLoginVO.getPassword());

    }

    // Util
    private String createJsonForLoginVO(LoginVO loginVO) throws Exception{

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
         return ow.writeValueAsString(loginVO);
    }

    /***********
     * Create Account
     */
    @Test
    public void create_account_null_username() throws Exception {
        LoginVO loginVO = new LoginVO(null,"irrellevant");
        String requestJson = createJsonForLoginVO(loginVO);
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/user/create")
                        .content(createJsonForLoginVO(loginVO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void create_account_short_username() throws Exception {
        LoginVO loginVO = new LoginVO("12345","irrellevant");
        String requestJson = createJsonForLoginVO(loginVO);
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/user/create")
                        .content(createJsonForLoginVO(loginVO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void create_account_empty_username() throws Exception {
        LoginVO loginVO = new LoginVO("","irrellevant");
        String requestJson = createJsonForLoginVO(loginVO);
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/user/create")
                        .content(createJsonForLoginVO(loginVO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(status().isBadRequest());
    }


    @Test
    public void create_account_missing_password() throws Exception {
        LoginVO loginVO = new LoginVO("nullPwd",null);
        String requestJson = createJsonForLoginVO(loginVO);
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/user/create")
                        .content(createJsonForLoginVO(loginVO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void create_account_empty_password() throws Exception {
        LoginVO loginVO = new LoginVO("emptyPwd","");
        String requestJson = createJsonForLoginVO(loginVO);
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/user/create")
                        .content(createJsonForLoginVO(loginVO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void create_account_short_password() throws Exception {
        LoginVO loginVO = new LoginVO("shortPwd","1234567");
        String requestJson = createJsonForLoginVO(loginVO);
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/user/create")
                        .content(createJsonForLoginVO(loginVO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(status().isBadRequest());
    }
    @Test
    public void create_account_already_exists() throws Exception {
        LoginVO loginVO = new LoginVO(testUsername,testPassword);
        String requestJson = createJsonForLoginVO(loginVO);
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/user/create")
                        .content(createJsonForLoginVO(loginVO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void create_account_successfully() throws Exception {
        String requestJson = createJsonForLoginVO(workingLoginVO);
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/user/create")
                        .content(createJsonForLoginVO(workingLoginVO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.coachId").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.bearer_token").exists());
    }

    /***********
     * Login
     */

    @Test
    public void login_but_the_user_doesnt_exist() throws Exception {
        LoginVO loginVO = new LoginVO("userdoesntexist","passwordisgreat");
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/user/login")
                        .content(createJsonForLoginVO(loginVO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(status().isUnauthorized());;
    }

    @Test
    public void login_and_the_user_exists() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/user/login")
                        .content(createJsonForLoginVO(workingLoginVO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.coachId").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.bearer_token").exists());
    }

    @Test
    public void login_and_wrong_password() throws Exception {
        LoginVO loginVO = new LoginVO(workingLoginVO.getUsername(),"badpasswd");
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/user/login")
                        .content(createJsonForLoginVO(loginVO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(status().isUnauthorized());;
    }

    @Test
    public void login_missing_empty_username() throws Exception {
        LoginVO loginVO = new LoginVO("","passwordisgreat");
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/user/login")
                        .content(createJsonForLoginVO(loginVO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(status().isUnauthorized());;
    }

    @Test
    public void login_null_username() throws Exception {
        LoginVO loginVO = new LoginVO(null,"passwordisgreat");
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/user/login")
                        .content(createJsonForLoginVO(loginVO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(status().isUnauthorized());;
    }

    @Test
    public void login_missing_password_user_doesnt_exist() throws Exception {
        LoginVO loginVO = new LoginVO("userdoesntexist","");
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/user/login")
                        .content(createJsonForLoginVO(loginVO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(status().isUnauthorized());;
    }

    @Test
    public void login_null_password_user_doesnt_exist() throws Exception {
        LoginVO loginVO = new LoginVO("userdoesntexist",null);
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/user/login")
                        .content(createJsonForLoginVO(loginVO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(status().isUnauthorized());;
    }

    @Test
    public void login_missing_password_user_exists() throws Exception {
        LoginVO loginVO = new LoginVO(workingLoginVO.getUsername(),"");
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/user/login")
                        .content(createJsonForLoginVO(loginVO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(status().isUnauthorized());;
    }

    @Test
    public void login_null_password_user_exists() throws Exception {
        LoginVO loginVO = new LoginVO(workingLoginVO.getUsername(),null);
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/user/login")
                        .content(createJsonForLoginVO(loginVO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(status().isUnauthorized());;
    }
}
