package br.com.projeto.faculdade.dto;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PacoteDTO {

    private Long id;
    private String codRastreamento;
    private String nomDestinatario;
    private String email;
    private String endereco;
    private Date dtRecebimento;
    private String status;
    private String entregador;
    private Date dtEntrega;

}
