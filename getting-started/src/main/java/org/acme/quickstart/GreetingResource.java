package org.acme.quickstart;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/greeting")
public class GreetingResource {

    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @Path("add")
    @GET
    public String add(@QueryParam("a") int a, @QueryParam("b") int b) {
        return String.valueOf(a + b);
    }

    @Path("pdf")
    @GET
    public Response generatePdf() throws DocumentException {
        File file = new File("path-to-file");
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
        document.open();
        Paragraph paragraph = new Paragraph();
        paragraph.add(new Chunk(new Text("Hello from Quarkus PDF")));
        document.add(paragraph);
        document.close();
        return Response.ok((Object) file).build();
    }

        // Convert String to Integer
} 
