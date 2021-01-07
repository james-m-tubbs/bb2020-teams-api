package ca.gkworkbench.bb2020api.team.controller;

import ca.gkworkbench.bb2020api.team.bo.TeamsBO;
import ca.gkworkbench.bb2020api.team.vo.TeamVO;
import javassist.bytecode.ByteArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;


@RestController
public class TeamPDFController {

    @Autowired
    TeamsBO tBO;

    @RequestMapping(value = "/api/team/pdf/{teamId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> getPdfForTeamId(@PathVariable("teamId") int teamId) {
        try {
            TeamVO tVO = tBO.getTeamById(teamId, true);
            if (tVO == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            String html = generateHtmlFromTeamVO(tVO);
            System.err.println(html);
            byte[] pdf = generateByteArrayFromHTML(html);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            // Here you have to set the actual filename of your pdf
            String filename = tVO.getTeamName().replace(" ","_")+".pdf";
            headers.setContentDispositionFormData(filename, filename);
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
            ResponseEntity<byte[]> response = new ResponseEntity<>(pdf, headers, HttpStatus.OK);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not Found"
            );
        }
    }

    private String generateHtmlFromTeamVO(TeamVO tVO) throws Exception {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setPrefix("/templates/");

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        Context context = new Context();
        context.setVariable("team", tVO);
        context.setVariable("teamId", tVO.getId());
        context.setVariable("teamName", tVO.getTeamName());
        context.setVariable("teamRace", tVO.getTeamTemplateVO().getTeamType());
        context.setVariable("coachName", tVO.getCoachId());
        context.setVariable("players", tVO.getPlayers());

        return templateEngine.process("pdfRoster", context);
    }

    private byte[] generateByteArrayFromHTML(String html) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(byteArrayOutputStream);

       return byteArrayOutputStream.toByteArray();
    }

}
