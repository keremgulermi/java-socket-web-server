import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleWebServer {
    private final int port;
    private final Map<String, RequestHandler> routes;
    private final RequestHandler fallbackHandler;
    private final ResponseWriter responseWriter;
    private final ExecutorService threadPool;

    public SimpleWebServer(
            int port,
            Map<String, RequestHandler> routes,
            RequestHandler fallbackHandler,
            ResponseWriter responseWriter) {
        this.port = port;
        this.routes = routes;
        this.fallbackHandler = fallbackHandler;
        this.responseWriter = responseWriter;
        this.threadPool = Executors.newFixedThreadPool(10);
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Web sunucusu " + port + " portunda başlatıldı.");
            System.out.println("Tarayıcıdan erişim adresi: http://localhost:" + port);

            while (!Thread.currentThread().isInterrupted()) {
                Socket clientSocket = serverSocket.accept();
                ClientConnectionHandler connectionHandler = new ClientConnectionHandler(
                        clientSocket,
                        routes,
                        fallbackHandler,
                        responseWriter
                );
                threadPool.execute(connectionHandler);
            }
        } finally {
            threadPool.shutdown();
        }
    }
}