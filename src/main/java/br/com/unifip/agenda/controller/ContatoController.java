package br.com.unifip.agenda.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.unifip.agenda.model.Contato;
import br.com.unifip.agenda.service.ContatoService;

@RestController
public class ContatoController {

    private ContatoService contatoService = new ContatoService();

    @RequestMapping(path = Rotas.CONTATO)
    public List<Contato> findAll() {
        return contatoService.findAll();
    }

    @RequestMapping(path = Rotas.CONTATO, method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody Contato contato) {
        contatoService.add(contato);
    }

    @RequestMapping(path = Rotas.CONTATO_ID, method = RequestMethod.DELETE)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        contatoService.remove(id);
    }

    @RequestMapping(path = Rotas.CONTATO_ID, method = RequestMethod.PUT)
    public void update(@PathVariable Long id, @RequestBody Contato novoContato) {
        contatoService.update(id, novoContato);
    }

}
