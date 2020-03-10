package com.github.alvgaona.it;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;

public class SomeIT {
  @Test
  public void givenSum_when2plu2_then4() {
    final int x = 2;
    final int y = x + x;
    Assertions.assertThat(y).isEqualTo(4);
  }

  @Test
  public void giveInternet_whenGoogle_thenRequest() {
    try (final CloseableHttpClient client = HttpClientBuilder.create().build()) {
      final HttpUriRequest uriRequest = RequestBuilder.get()
          .setUri(URI.create("https://google.com"))
          .build();

      try (final CloseableHttpResponse response = client.execute(uriRequest)) {
        final String payload = EntityUtils.toString(response.getEntity());
        Assertions.assertThat(payload).isNotEmpty();
      }
    } catch (final IOException e) {
      throw new UncheckedIOException(e);
    }
  }
}
