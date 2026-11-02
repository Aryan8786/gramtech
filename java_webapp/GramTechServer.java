import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import logic.GramTechData;

import java.io.*;
import java.net.BindException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * GramTechServer — Lightweight Pure Java Web Server & API Backend
 * College CEP Project: "Technology Support for Rural Startups"
 * Zero external JAR dependencies; uses built-in com.sun.net.httpserver.
 */
public class GramTechServer {

    private static final int DEFAULT_PORT = 8080;
    private static final String WEB_DIR = "web";

    public static void main(String[] args) {
        int port = DEFAULT_PORT;
        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException ignored) {}
        }

        HttpServer server = null;
        int attempts = 0;
        while (server == null && attempts < 10) {
            try {
                server = HttpServer.create(new InetSocketAddress(port), 0);
            } catch (BindException e) {
                System.out.println("[WARN] Port " + port + " is busy. Trying port " + (port + 1) + "...");
                port++;
                attempts++;
            } catch (IOException e) {
                System.err.println("[ERROR] Failed to initialize HTTP server: " + e.getMessage());
                return;
            }
        }

        if (server == null) {
            System.err.println("[ERROR] Could not bind server to any available port.");
            return;
        }

        // Register API endpoint
        server.createContext("/api/data", new ApiDataHandler());

        // Register Static file handler (HTML, CSS, JS, Assets)
        server.createContext("/", new StaticFileHandler());

        server.setExecutor(null); // default executor
        server.start();

        System.out.println("===============================================================");
        System.out.println("  RuralRise / GramTech Web Application (Java Edition)");
        System.out.println("  Topic: Technology Support for Rural Startups");
        System.out.println("===============================================================");
        System.out.println("  >> Server running at: http://localhost:" + port);
        System.out.println("  >> Static Web Dir   : " + Paths.get(WEB_DIR).toAbsolutePath());
        System.out.println("  >> API Endpoints    : /api/data");
        System.out.println("  Press Ctrl+C to stop the server anytime.");
        System.out.println("===============================================================");
    }

    // ==========================================
    // API HANDLER
    // ==========================================

    private static class ApiDataHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            addCorsHeaders(exchange);
            if ("OPTIONS".equalsIgnoreCase(exchange.getRequestMethod())) {
                exchange.sendResponseHeaders(204, -1);
                return;
            }

            String json = GramTechData.getAllDataJson();
            byte[] bytes = json.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
            exchange.sendResponseHeaders(200, bytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }
        }
    }

    // ==========================================
    // STATIC FILE HANDLER
    // ==========================================

    private static class StaticFileHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            addCorsHeaders(exchange);
            if ("OPTIONS".equalsIgnoreCase(exchange.getRequestMethod())) {
                exchange.sendResponseHeaders(204, -1);
                return;
            }

            String path = exchange.getRequestURI().getPath();
            if (path == null || path.equals("/") || path.isEmpty()) {
                path = "/index.html";
            }

            // Path sanitization to prevent directory traversal
            path = path.replace("\\", "/");
            while (path.contains("../")) {
                path = path.replace("../", "/");
            }
            if (path.startsWith("/")) {
                path = path.substring(1);
            }

            Path filePath = Paths.get(WEB_DIR, path).normalize();
            Path webDirPath = Paths.get(WEB_DIR).toAbsolutePath().normalize();

            // Ensure requested file is inside WEB_DIR
            if (!filePath.toAbsolutePath().normalize().startsWith(webDirPath) || !Files.exists(filePath) || Files.isDirectory(filePath)) {
                Path indexFile = Paths.get(WEB_DIR, "index.html");
                if (Files.exists(indexFile)) {
                    filePath = indexFile;
                } else {
                    String notFound = "<h1>404 Not Found</h1><p>The requested file does not exist.</p>";
                    byte[] bytes = notFound.getBytes(StandardCharsets.UTF_8);
                    exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
                    exchange.sendResponseHeaders(404, bytes.length);
                    try (OutputStream os = exchange.getResponseBody()) {
                        os.write(bytes);
                    }
                    return;
                }
            }

            String contentType = getContentType(filePath.getFileName().toString());
            byte[] fileBytes = Files.readAllBytes(filePath);

            exchange.getResponseHeaders().set("Content-Type", contentType);
            exchange.sendResponseHeaders(200, fileBytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(fileBytes);
            }
        }
    }

    // ==========================================
    // UTILITY METHODS
    // ==========================================

    private static void addCorsHeaders(HttpExchange exchange) {
        exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
        exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "Content-Type, Authorization");
    }

    private static String getContentType(String filename) {
        String lower = filename.toLowerCase();
        if (lower.endsWith(".html") || lower.endsWith(".htm")) return "text/html; charset=UTF-8";
        if (lower.endsWith(".css")) return "text/css; charset=UTF-8";
        if (lower.endsWith(".js")) return "application/javascript; charset=UTF-8";
        if (lower.endsWith(".json")) return "application/json; charset=UTF-8";
        if (lower.endsWith(".svg")) return "image/svg+xml";
        if (lower.endsWith(".png")) return "image/png";
        if (lower.endsWith(".jpg") || lower.endsWith(".jpeg")) return "image/jpeg";
        if (lower.endsWith(".ico")) return "image/x-icon";
        if (lower.endsWith(".txt")) return "text/plain; charset=UTF-8";
        return "application/octet-stream";
    }
}
