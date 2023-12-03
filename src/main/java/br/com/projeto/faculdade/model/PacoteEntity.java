package br.com.projeto.faculdade.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_pacote", schema = "public")
public class PacoteEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pacoteSequence")
    @SequenceGenerator(name = "pacoteSequence", sequenceName = "seq_tbl_pacote", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CODIGO_RASTREAMENTO")
    private String codRastreamento;

    @Column(name = "NOM_DESTINATARIO")
    private String nomDestinatario;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ENDERECO")
    private String endereco;

    @Column(name = "DT_RECEBIMENTO")
    private Date dtRecebimento;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "ENTREGADOR")
    private String entregador;

    @Column(name = "DT_ENTREGA")
    private Date dtEntrega;

}
