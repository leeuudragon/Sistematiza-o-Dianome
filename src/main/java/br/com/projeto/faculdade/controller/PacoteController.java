package br.com.projeto.faculdade.controller;

import br.com.projeto.faculdade.dto.PacoteDTO;
import br.com.projeto.faculdade.service.PacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/dianome/pacote")
public class PacoteController {

    @Autowired
    PacoteService pacoteService;

    @GetMapping(value = "/listar-todos")
    public ResponseEntity<List<PacoteDTO>> listarTodosPacotes(Integer page, Integer size) {
        List<PacoteDTO> dto = pacoteService.listarTodosPactotes(page, size);
        return ResponseEntity.ok(dto);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PacoteDTO> listarPorId(@PathVariable Long id) {
        PacoteDTO dto = pacoteService.listarPorId(id);
        return ResponseEntity.ok(dto);

    }

    @PostMapping(value = "/incluir")
    public ResponseEntity<PacoteDTO> cadastrarPacote(@RequestBody PacoteDTO request) {
        PacoteDTO dto = pacoteService.cadastrar(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();

        return ResponseEntity.created(location).body(dto);

    }

    @PutMapping(value = "/alterar")
    public ResponseEntity<PacoteDTO> alterarPacote(@RequestBody PacoteDTO request) {
        PacoteDTO dto = pacoteService.alterar(request);
        return ResponseEntity.ok(dto);

    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void excluirPacote(@PathVariable Long id) {
        pacoteService.excluirPacote(id);

    }

}
