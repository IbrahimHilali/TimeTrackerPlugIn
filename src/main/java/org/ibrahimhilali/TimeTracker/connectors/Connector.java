package org.ibrahimhilali.TimeTracker.connectors;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Connector {

    private HTTP httpObject;

    Connector() {
        httpObject = (HTTP) new HttpV8();
    }

    public HTTP getServices(){
        return  httpObject;
    }
    public abstract HashMap<String, String> configure();

    class HttpV11 implements HTTP {
        private final HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();


        public HttpResponse<String> get(String url) throws IOException, InterruptedException {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(configure().get(url)))
                    .GET()
                    .build();
            return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        }

        public HttpResponse<String> post(String url, HashMap<String, String> data) throws IOException, InterruptedException {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(configure().get(url)))
                    .setHeader("Content-Type", "application/json")
                    .setHeader("Authorization", "Basic " + configure().get(Configuration.TOKEN))
                    .POST(buildBody(data)).build();
            return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        }

        public HttpResponse<String> put(String url, HashMap<String, String> data) throws IOException, InterruptedException {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(configure().get(url)))
                    .setHeader("Content-Type", "application/json")
                    .setHeader("Authorization", "Basic " + configure().get(Configuration.TOKEN))
                    .PUT(buildBody(data)).build();
            return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        }

        public HttpResponse<String> delete(String url) throws IOException, InterruptedException {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(configure().get(url)))
                    .setHeader("Content-Type", "application/json")
                    .setHeader("Authorization", "Basic " + configure().get(Configuration.TOKEN))
                    .DELETE().build();
            return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        }

        protected HttpRequest.BodyPublisher buildBody(HashMap<String, String> data) {
            StringBuilder builder = new StringBuilder();
            for (Map.Entry<String, String> entry : data.entrySet()) {
                if (builder.length() > 0) {
                    builder.append("&");
                }
                builder.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
                builder.append("=");
                builder.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
            }
            return HttpRequest.BodyPublishers.ofString(builder.toString());
        }
    }

    class HttpV8 implements HTTP{
        private final CloseableHttpClient httpClient = HttpClients.createDefault();

        @Override
        public Object post(String url, HashMap<String, String> data) throws IOException, InterruptedException {
            return null;
        }

        @Override
        public Object put(String url, HashMap<String, String> data) throws IOException, InterruptedException {
            return null;
        }

        public CloseableHttpResponse get(String url) throws IOException {
            try (CloseableHttpResponse response = httpClient.execute(new HttpGet(url))) {
                return response;
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                httpClient.close();
            }
            return null;
        }

        @Override
        public Object delete(String url) throws IOException, InterruptedException {
            return null;
        }

        public CloseableHttpResponse post(String url,Map<String, Object> data) throws IOException {
            HttpPost post = new HttpPost(configure().get(url));
            List<NameValuePair> urlParameters = new ArrayList<>();
            for (String key : data.keySet()) {
                urlParameters.add(new BasicNameValuePair(key, (String) data.get(key)));
            }
            post.setEntity(new UrlEncodedFormEntity(urlParameters));
            post.setHeader("Content-Type", "application/json");
            post.setHeader("Authorization", "Basic " + configure().get(Configuration.TOKEN));
            try (CloseableHttpClient httpClient = HttpClients.createDefault();
                 CloseableHttpResponse response = httpClient.execute(post)) {
                return response;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                httpClient.close();
            }

            return null;
        }

    }

}
