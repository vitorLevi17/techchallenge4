package org.br.model;

import org.br.dto.FeedbackDTO;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.time.LocalDateTime;

@DynamoDbBean
public class FeedbackModel {

    private String id;
    private Integer nota;
    private String descricao;
    private Urgencia urgencia;
    private LocalDateTime data;
    //private String idCurso;

    public FeedbackModel() {
    }

    public FeedbackModel(FeedbackDTO request, Urgencia urgencia) {
        this.nota = request.nota();
        this.descricao = request.descricao();
        this.urgencia = urgencia;
        this.data = LocalDateTime.now();
    }

    @DynamoDbPartitionKey
    public String getId() {
        return id;
    }

    public Integer getNota() {
        return nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public Urgencia getUrgencia() {
        return urgencia;
    }

    public LocalDateTime getData() {
        return data;
    }

}
