import java.nio.charset.StandardCharsets;

public class HttpResponse {
    private final int statusCode;
    private final String statusText;
    private final String contentType;
    private final byte[] body;

    public HttpResponse(int statusCode, String statusText, String contentType, byte[] body) {
        this.statusCode = statusCode;
        this.statusText = statusText;
        this.contentType = contentType;
        this.body = body;
    }

    public static HttpResponse okHtml(String htmlContent) {
        byte[] bytes = htmlContent.getBytes(StandardCharsets.UTF_8);
        return new HttpResponse(200, "OK", "text/html; charset=UTF-8", bytes);
    }

    public static HttpResponse notFoundHtml(String htmlContent) {
        byte[] bytes = htmlContent.getBytes(StandardCharsets.UTF_8);
        return new HttpResponse(404, "Not Found", "text/html; charset=UTF-8", bytes);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusText() {
        return statusText;
    }

    public String getContentType() {
        return contentType;
    }

    public byte[] getBody() {
        return body;
    }
}