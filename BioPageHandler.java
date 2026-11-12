public class BioPageHandler implements RequestHandler {

    @Override
    public HttpResponse handle(HttpRequest request) {
        String html = """
                <!DOCTYPE html>
                <html lang="tr">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Halil Kerem Güler - Java Web Sunucusu</title>
                    <style>
                        body {
                            margin: 0;
                            padding: 0;
                            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                            background: linear-gradient(135deg, #0f172a 0%, #1e293b 100%);
                            color: #f8fafc;
                            display: flex;
                            justify-content: center;
                            align-items: center;
                            min-height: 100vh;
                        }
                        .card {
                            background-color: #1e293b;
                            border: 1px solid #334155;
                            border-radius: 16px;
                            padding: 40px;
                            max-width: 680px;
                            width: 90%;
                            box-shadow: 0 20px 40px rgba(0, 0, 0, 0.45);
                        }
                        h1 {
                            margin: 0 0 8px 0;
                            font-size: 2.4rem;
                            color: #38bdf8;
                            letter-spacing: 0.5px;
                            font-family: 'Georgia', serif;
                        }
                        h2 {
                            margin: 0 0 24px 0;
                            font-size: 1.35rem;
                            color: #94a3b8;
                            font-weight: 500;
                            border-bottom: 2px solid #334155;
                            padding-bottom: 14px;
                        }
                        .bio-text {
                            font-size: 1.05rem;
                            line-height: 1.75;
                            color: #e2e8f0;
                            text-align: justify;
                        }
                        .highlight {
                            color: #38bdf8;
                            font-weight: 600;
                        }
                        .tags {
                            margin-top: 24px;
                            display: flex;
                            flex-wrap: wrap;
                            gap: 10px;
                        }
                        .tag {
                            background-color: #0f172a;
                            color: #7dd3fc;
                            border: 1px solid #0284c7;
                            padding: 6px 14px;
                            border-radius: 999px;
                            font-size: 0.88rem;
                            font-family: 'Consolas', monospace;
                        }
                        .footer-info {
                            margin-top: 28px;
                            font-size: 0.85rem;
                            color: #64748b;
                            text-align: right;
                        }
                    </style>
                </head>
                <body>
                    <div class="card">
                        <h1>Halil Kerem Güler</h1>
                        <h2>Öğrenci No: 1250505045</h2>
                        <p class="bio-text">
                            Merhaba, ben <span class="highlight">Halil Kerem Güler</span>. 
                            <span class="highlight">Kırklareli Üniversitesi Yazılım Mühendisliği</span> bölümü öğrencisiyim. 
                            Sistem programlama, veri yapıları, ağ haberleşmesi ve nesne yönelimli yazılım mimarileri üzerine 
                            çalışmalar yürütmekteyim. C ve Java dillerinde düşük seviyeli bellek yönetimi, soket programlama ve 
                            algoritma optimizasyonu alanlarına özel ilgi duyuyorum. Boş zamanlarımda strateji oyunları oynamaktan 
                            ve farklı yazılım mimarilerini pratik projelerle test etmekten keyif alıyorum.
                        </p>
                        <div class="tags">
                            <span class="tag">Java SE</span>
                            <span class="tag">Socket Programming</span>
                            <span class="tag">C &amp; Veri Yapıları</span>
                            <span class="tag">SOLID Mimari</span>
                            <span class="tag">Port: 1989</span>
                        </div>
                        <div class="footer-info">
                            Saf Java ServerSocket ile 1989 portundan sunulmaktadır.
                        </div>
                    </div>
                </body>
                </html>
                """;
        return HttpResponse.okHtml(html);
    }
}