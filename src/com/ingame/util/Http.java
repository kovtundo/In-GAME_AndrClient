package com.ingame.util;

import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class Http {

    public static String Request(String requestURL) throws Exception {
        return Request(requestURL, "GET", "", "");
    }

    public static String Request(String requestURL, String METHOD, String data, String conttype) throws Exception {
        return Request(requestURL, METHOD, data, conttype, "UTF-8", true);
    }

    public static String Request(
            String requestURL,
            String METHOD,
            String data,
            String conttype,
            String inputEncoding,
            boolean ignoreSSL) throws Exception {
        URL url = new URL(requestURL);
        StringBuilder sb = new StringBuilder();

        if (ignoreSSL) {
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {

            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
            }

            public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
            }
        }};
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        }
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        if (conn instanceof HttpsURLConnection) {
            ((HttpsURLConnection) conn).setHostnameVerifier(new HostnameVerifier() {

                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
        }
        try {
            conn.setUseCaches(false);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setAllowUserInteraction(false);
            //conn.setInstanceFollowRedirects(false);
            conn.setRequestMethod(METHOD);
            if ("POST".equals(METHOD)) {
                conn.setRequestProperty("Content-type", conttype);
                Writer wout = new OutputStreamWriter(conn.getOutputStream());
                wout.write(data);
                wout.flush();
                wout.close();
            }
            //conn.setRequestProperty("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            int respCode = conn.getResponseCode();
            if (respCode != HttpURLConnection.HTTP_OK) {
                throw new Exception("http error code "+respCode);
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), inputEncoding));
            String nextLine = null;
            while ((nextLine = in.readLine()) != null) {
                sb.append(nextLine).append("\n");
            }
            in.close();
        } finally {
            conn.disconnect();
        }
        return sb.toString();
    }
}
