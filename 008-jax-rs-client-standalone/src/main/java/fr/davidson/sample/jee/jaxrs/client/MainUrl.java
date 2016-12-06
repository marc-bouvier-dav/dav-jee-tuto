/*
 * This is free and unencumbered software released into the public domain.
 * 
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 * 
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 * 
 * For more information, please refer to <http://unlicense.org>
 */
package fr.davidson.sample.jee.jaxrs.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

/**
 * Cette application simple montre comment initialiser un proxy d'un service web
 * jax-ws et comment appeler une web méthode depuis ce client.
 *
 * @author marc.bouvier@davidson.fr
 */
public class MainUrl {

    public static void main(String[] args) throws MalformedURLException, IOException {
        URL url = new URL("http://localhost:8080/008-jax-rs-server/");

        System.out.println(callUrl(url, "application/json"));
        System.out.println(callUrl(url, "application/xml"));
    }

    private static String callUrl(URL url, final String acceptedContent) throws IOException, RuntimeException {
        HttpURLConnection connection = null;
        String response = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            connection.setRequestProperty("Accept", acceptedContent);
            response = getResponse(connection);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return response;
    }

    private static String getResponse(HttpURLConnection connection) throws RuntimeException, IOException {
        String response = null;
        if (connection.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + connection.getResponseCode());
        }
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()))) {
            StringBuilder outputBuilder = new StringBuilder();
            String lineRead = reader.readLine();
            while (lineRead != null) {
                outputBuilder.append(lineRead);
                outputBuilder.append("\n");
                lineRead = reader.readLine();
            }
            response = outputBuilder.toString();
        }
        return response;
    }
}
