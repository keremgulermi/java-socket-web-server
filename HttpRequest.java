import java.util.Collections;
import java.util.Map;

public class HttpRequest {
    private final String method;
    private final String path;
    private final String protocol;
    private final Map<String, String> headers;

    public HttpRequest(String method, String path, String protocol, Map<String, String> headers) {
        this.method = method;
        this.path = path;
        this.protocol = protocol;
        this.headers = Collections.unmodifiableMap(headers);
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public String getProtocol() {
        return protocol;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }
}