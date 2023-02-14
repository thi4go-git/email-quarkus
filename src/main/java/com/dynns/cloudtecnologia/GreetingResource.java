package com.dynns.cloudtecnologia;


import io.quarkus.mailer.reactive.ReactiveMailer;
import io.quarkus.mailer.*;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class GreetingResource {

    @Inject
    Mailer mailer;

    @Inject
    ReactiveMailer reactiveMailer;

    private static final String DESTINATARIO = "thi4go19@gmails.com";


    @GET
    @Path("/mail-assincrona")//envia e não aguarda retorno
    public Response assincrona() {
        List<String> destinatarios = new ArrayList<>();
        destinatarios.add("john.doe@example.com");
        //
        Mail mail = new Mail();
        mail.setTo(destinatarios);
        mail.setSubject("Assunto aqui");
        mail.setText("Hello from Quarkus!");
        //
        mailer.send(mail);
        return Response.accepted().build();
    }


}