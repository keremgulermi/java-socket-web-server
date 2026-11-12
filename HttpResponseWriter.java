import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class HttpResponseWriter implements ResponseWriter {

    @Override
    public void write(OutputStream outputStream, HttpResponse response) throws IOException {
        byte[] body = response.getBody();
        String headerBlock = "HTTP/1.1 " + response.getStatusCode() + " " + response.getStatusText() + "\r\n"
                + "Content-Type: " + response.getContentType() + "\r\n"
                + "Content-Length: " + body.length + "\r\n"
                + "Connection: close\r\n"
                + "\r\n";

        outputStream.write(headerBlock.getBytes(StandardCharsets.UTF_8));
        outputStream.write(body);
        outputStream.flush();
    }
}