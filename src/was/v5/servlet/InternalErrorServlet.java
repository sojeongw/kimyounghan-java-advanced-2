package was.v5.servlet;

import was.httpserver.HttpRequest;
import was.httpserver.HttpResponse;

import java.io.IOException;

public class InternalErrorServlet implements HttpServlet {
    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        response.setStatus(500);
        response.writeBody("<h1>Internal Error</h1>");
    }
}
