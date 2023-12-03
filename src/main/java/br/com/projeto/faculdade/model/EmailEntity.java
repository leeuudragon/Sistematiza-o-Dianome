package br.com.projeto.faculdade.model;

import br.com.projeto.faculdade.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "TBL_EMAIL", schema = "PUBLIC")
public class EmailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEmail")
    @SequenceGenerator(name = "seqEmail", sequenceName = "SEQ_TBL_EMAIL", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "OWNER_REF")
    private String ownerRef;

    @Column(name = "EMAIL_FROM")
    private String emailFrom;

    @Column(name = "EMAIL_TO")
    private String emailTo;

    @Column(name = "SUBJECT")
    private String subject;

    @Column(name = "EMAIL_TEXT")
    private String emailText;

    @Column(name = "SEND_DATE_EMAIL")
    private Date sendDateEmail;

    @Column(name = "STATUS_EMAIL")
    private StatusEmail statusEmail;

}
