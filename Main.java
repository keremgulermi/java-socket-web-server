import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int port = 1989;

        Map<String, RequestHandler> routes = new HashMap<>();
        routes.put("/", new BioPageHandler());

        RequestHandler notFoundHandler = new NotFoundHandler();
        ResponseWriter responseWriter = new HttpResponseWriter();

        SimpleWebServer server = new SimpleWebServer(port, routes, notFoundHandler, responseWriter);

        try {
            server.start();
        } catch (IOException e) {
            System.err.println("Sunucu " + port + " portunda başlatılamadı: " + e.getMessage());
        }
    }
}