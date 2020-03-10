package com.github.alvgaona.api.aws;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfiguration {
  @Bean
  public AmazonS3 getS3Client() {
    return AmazonS3ClientBuilder
        .standard()
        .build();
  }
}
