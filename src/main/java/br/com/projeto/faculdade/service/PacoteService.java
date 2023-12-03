package br.com.projeto.faculdade.service;

import br.com.projeto.faculdade.dto.PacoteDTO;
import br.com.projeto.faculdade.exceptions.PacoteCadastradoException;
import br.com.projeto.faculdade.exceptions.PacoteNaoEncontradoException;
import br.com.projeto.faculdade.model.PacoteEntity;
import br.com.projeto.faculdade.repository.PacoteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class PacoteService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PacoteRepository pacoteRepository;

    public List<PacoteDTO> listarTodosPactotes(Integer page, Integer size)  {
        Pageable pageable = PageRequest.of(page != null ? page : 0, size != null ? size : 10);

        Page<PacoteEntity> pacoteEntityPage = pacoteRepository.findAll(pageable);

        return pacoteEntityPage.getContent().stream()
                .map(pacoteEntity -> modelMapper.map(pacoteEntity, PacoteDTO.class))
                .collect(Collectors.toList());

    }

    public PacoteDTO listarPorId(Long id) {
        Optional<PacoteEntity> pacoteEntity = Optional.ofNullable(pacoteRepository.findById(id)
                .orElseThrow(() -> new PacoteNaoEncontradoException(
                        "Pacote não encontrado com ID: " + id)));

        return modelMapper.map(pacoteEntity, PacoteDTO.class);

    }

    public PacoteDTO cadastrar(PacoteDTO request) {

        PacoteEntity pacoteEntity = pacoteRepository.findById(request.getId()).orElse(new PacoteEntity());

        if(!ObjectUtils.isEmpty(pacoteEntity)) {
            Optional<PacoteEntity> optionalPacote = pacoteRepository.findByCodRastreamento(request.getCodRastreamento());

            if(optionalPacote.isPresent()) {
                throw new PacoteCadastradoException("Pacote já cadastrado com ID: " + optionalPacote.get().getId());
            }
        }

        BeanUtils.copyProperties(request, pacoteEntity);

        pacoteRepository.save(pacoteEntity);

        return modelMapper.map(pacoteEntity, PacoteDTO.class);

    }

    public PacoteDTO alterar(PacoteDTO request) {

        PacoteEntity pacoteEntity = pacoteRepository.findById(request.getId()).orElseThrow(
                () -> new PacoteNaoEncontradoException("Pacote não encontrado com ID: " + request.getId()));

        BeanUtils.copyProperties(request, pacoteEntity);

        pacoteRepository.save(pacoteEntity);

        return modelMapper.map(pacoteEntity, PacoteDTO.class);

    }

    public void excluirPacote(Long id) {

        PacoteEntity pacoteEntity = pacoteRepository.findById(id).orElseThrow(
                () -> new PacoteNaoEncontradoException("Pacote não encontrado com ID: " + id));

        pacoteRepository.delete(pacoteEntity);

    }

}
