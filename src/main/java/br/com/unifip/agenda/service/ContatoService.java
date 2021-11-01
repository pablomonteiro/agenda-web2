package br.com.unifip.agenda.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.unifip.agenda.model.Contato;

public class ContatoService {

    private Map<Long, Contato> contatosDB;

    public ContatoService() {
        this.contatosDB = new HashMap<>();
    }

    public List<Contato> findAll() {
        return contatosDB.values().stream().collect(Collectors.toList());
    }

    public void add(Contato contato) {
        this.contatosDB.put(contato.getId(), contato);
    }

    public void remove(Long id) {
        this.contatosDB.remove(id);
    }

    public void update(Long id, Contato contatoNovo) {
        this.contatosDB.put(id, contatoNovo);
    }
    
}
