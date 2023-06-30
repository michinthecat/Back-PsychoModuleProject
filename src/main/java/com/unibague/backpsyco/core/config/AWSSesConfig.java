package com.unibague.backpsyco.core.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class AWSSesConfig {

    private static final Logger logger = LoggerFactory.getLogger(AWSSesConfig.class);

    @Value("${aws.accessKeyId}")
    private String awsAccessKey;

    @Value("${env.aws.secretKey}")
    private String awsSecretKey;

    @Value("${aws.region}")
    private String awsRegion;

    @Bean
    public AmazonSimpleEmailService amazonSimpleEmailService() {
        logger.info("awsRegion: {}", awsRegion);

        logger.info("awsAccessKey: {}", awsAccessKey);
        logger.info("awsSecretKey: {}", awsSecretKey);
        logger.info("awsRegion: {}", awsRegion);

        return AmazonSimpleEmailServiceClientBuilder.standard()
                .withRegion(Regions.fromName(awsRegion))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey)))
                .build();
    }
}