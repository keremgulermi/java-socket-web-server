public class NotFoundHandler implements RequestHandler {

    @Override
    public HttpResponse handle(HttpRequest request) {
        String html = """
                <!DOCTYPE html>
                <html lang="tr">
                <head>
                    <meta charset="UTF-8">
                    <title>404 - Sayfa Bulunamadı</title>
                    <style>
                        body {
                            font-family: Arial, sans-serif;
                            background-color: #0f172a;
                            color: #f8fafc;
                            display: flex;
                            justify-content: center;
                            align-items: center;
                            height: 100vh;
                            margin: 0;
                        }
                        .box {
                            text-align: center;
                            padding: 32px;
                            border: 1px solid #334155;
                            border-radius: 12px;
                            background-color: #1e293b;
                        }
                        h1 { color: #f87171; }
                        a { color: #38bdf8; text-decoration: none; }
                    </style>
                </head>
                <body>
                    <div class="box">
                        <h1>404 - Sayfa Bulunamadı</h1>
                        <p>İstenen yol sunucuda tanımlı değil.</p>
                        <a href="/">Ana Sayfaya Dön</a>
                    </div>
                </body>
                </html>
                """;
        return HttpResponse.notFoundHtml(html);
    }
}