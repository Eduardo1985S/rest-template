package br.com.eduardocorreia.resttemplate.consultacep;

import br.com.eduardocorreia.resttemplate.RestTemplateApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
@RequestMapping("consulta-cep")
public class ConsultaCepAPI {
    @GetMapping("{cep}")
    public CepResultDTO consultaCep (@PathVariable("cep") String cep){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CepResultDTO> resp =
                restTemplate
                        .getForEntity(
                String.format("https://viacep.com.br/ws/%s/json/", cep),
                                CepResultDTO.class);
        return resp.getBody();
    }
}
