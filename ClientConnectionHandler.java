import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class ClientConnectionHandler implements Runnable {
    private final Socket clientSocket;
    private final Map<String, RequestHandler> routes;
    private final RequestHandler fallbackHandler;
    private final ResponseWriter responseWriter;

    public ClientConnectionHandler(
            Socket clientSocket,
            Map<String, RequestHandler> routes,
            RequestHandler fallbackHandler,
            ResponseWriter responseWriter) {
        this.clientSocket = clientSocket;
        this.routes = routes;
        this.fallbackHandler = fallbackHandler;
        this.responseWriter = responseWriter;
    }

    @Override
    public void run() {
        try (Socket socket = this.clientSocket;
             BufferedReader reader = new BufferedReader(
                     new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8))) {

            String requestLine = reader.readLine();
            if (requestLine == null || requestLine.isBlank()) {
                return;
            }

            String[] requestParts = requestLine.split("\\s+");
            String method = requestParts.length > 0 ? requestParts[0] : "GET";
            String rawPath = requestParts.length > 1 ? requestParts[1] : "/";
            String path = rawPath.split("\\?")[0];
            String protocol = requestParts.length > 2 ? requestParts[2] : "HTTP/1.1";

            Map<String, String> headers = new HashMap<>();
            String headerLine;
            while ((headerLine = reader.readLine()) != null && !headerLine.isEmpty()) {
                int separatorIndex = headerLine.indexOf(':');
                if (separatorIndex > 0) {
                    String key = headerLine.substring(0, separatorIndex).trim();
                    String value = headerLine.substring(separatorIndex + 1).trim();
                    headers.put(key, value);
                }
            }

            HttpRequest request = new HttpRequest(method, path, protocol, headers);
            RequestHandler handler = routes.getOrDefault(request.getPath(), fallbackHandler);
            HttpResponse response = handler.handle(request);

            responseWriter.write(socket.getOutputStream(), response);

        } catch (IOException e) {
            System.err.println("İstemci bağlantısı işlenirken hata oluştu: " + e.getMessage());
        }
    }
}