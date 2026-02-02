package org.br.service;

import jakarta.inject.Inject;
import org.br.dto.FeedbackDTO;
import org.br.model.FeedbackModel;
import org.br.model.Urgencia;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;

public class FeedbackService {

    @Inject
    DynamoDbEnhancedClient dynamoDbEnhancedClient;

    public FeedbackModel createFeedback(FeedbackDTO feedbackRequest) {
        Urgencia urgencia;

        if (feedbackRequest.nota() >= 7) {
            urgencia = Urgencia.LEVE;
        }else if (feedbackRequest.nota() <= 6 || feedbackRequest.nota() >= 4) {
            urgencia = Urgencia.MEDIA;
        }else {
            urgencia = Urgencia.LEVE;
        }
        FeedbackModel feedbackModel = new FeedbackModel(feedbackRequest,urgencia);
        return feedbackModel;
    }
}
