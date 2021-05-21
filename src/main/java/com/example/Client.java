package com.example;

import com.google.errorprone.annotations.InlineMe;

public final class Client {
  @Deprecated
  public interface TextSupplier {
    String text();
  }

  private String text;

  public String getText() {
    return text;
  }

  private Client(String text) {
    this.text = text;
  }

  @Deprecated
  @InlineMe(replacement = "Client.client(supplier.text())", imports={"com.example.Client"})
  public static Client client(TextSupplier supplier) {
    return client(supplier.text());
  }

  public static Client client(String text) {
    return new Client(text);
  }
}
