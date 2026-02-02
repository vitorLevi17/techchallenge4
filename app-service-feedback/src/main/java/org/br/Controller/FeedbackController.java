package org.br.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.br.dto.FeedbackDTO;
import org.br.model.FeedbackModel;
import org.br.service.FeedbackService;

@Path("/avaliacao")
public class FeedbackController {

    @Inject
    private FeedbackService feedbackService;

    @POST
    public Response.ResponseBuilder criarAvalicao(FeedbackDTO feedbackDTO) {
        feedbackService.createFeedback(feedbackDTO);
        return Response.ok("Recebemos sua avaliação");
    }
}
