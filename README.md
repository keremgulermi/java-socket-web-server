# java-socket-web-server
Pure Java HTTP web server running on port 1989 using ServerSocket and SOLID principles.
# Java Socket Web Sunucusu (Port: 1989)

Bu proje, hiçbir üçüncü parti kütüphane kullanılmadan yalnızca standart Java SE (`java.net`, `java.io`, `java.nio`, `java.util.concurrent`) kütüphaneleri kullanılarak geliştirilmiş basit ve çok iş parçacıklı bir HTTP web sunucusudur.

## Özellikler

- **Saf Java Mimarisi:** Harici bağımlılık içermez, doğrudan standart JDK ile derlenir ve çalıştırılır.
- **Port 1989 Desteği:** `ServerSocket` üzerinden `1989` numaralı portu dinler.
- **Eşzamanlı İstek Yönetimi:** `ExecutorService` iş parçacığı havuzu ile aynı anda gelen tarayıcı isteklerini bloklamadan yanıtlar.
- **UTF-8 Türkçe Karakter Desteği:** HTTP başlıkları ve HTML meta etiketleri `UTF-8` uyumludur.
- **SOLID Uyumlu Tasarım:** İstek yönlendirme, HTML üretimi ve HTTP yanıt yazma katmanları arayüzler üzerinden ayrıştırılmıştır.

## Proje Yapısı

```text
src/
├── Main.java                      # Uygulama giriş noktası ve bağımlılık enjeksiyonu
├── SimpleWebServer.java           # 1989 portunu dinleyen ana sunucu sınıfı
├── ClientConnectionHandler.java   # İstemci soket bağlantısını ve HTTP ayrıştırmayı yöneten sınıf
├── RequestHandler.java            # İstek işleyici arayüzü (ISP / DIP)
├── BioPageHandler.java            # Ana sayfa ve biçimlendirilmiş HTML biyografi üretici
├── NotFoundHandler.java           # Tanımsız yollar için 404 yanıt üretici
├── ResponseWriter.java            # Yanıt yazıcı arayüzü (ISP / DIP)
├── HttpResponseWriter.java        # HTTP/1.1 durum ve başlık çıktı yazıcısı
├── HttpRequest.java               # HTTP istek veri modeli
└── HttpResponse.java              # HTTP yanıt veri modeli
