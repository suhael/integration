package com.suhael.integration.consumer.config;

import com.suhael.integration.consumer.controllers.SampleEndpoint;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.dsl.SourcePollingChannelAdapterSpec;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;

import java.io.File;
import java.util.function.Consumer;

@Configuration
public class SampleIntegrationConfig {

    @Bean
    public FileReadingMessageSource fileReader() {
        FileReadingMessageSource reader = new FileReadingMessageSource();
        reader.setDirectory(new File("target/input"));
        return reader;
    }

    @Bean
    public DirectChannel inputChannel() {
        return new DirectChannel();
    }

    @Bean
    public DirectChannel outputChannel() {
        return new DirectChannel();
    }

    @Bean
    public FileWritingMessageHandler fileWriter() {
        FileWritingMessageHandler writer = new FileWritingMessageHandler(
                new File("target/output"));
        writer.setExpectReply(false);
        return writer;
    }

    @Bean
    public IntegrationFlow integrationFlow(SampleEndpoint endpoint) {
        return IntegrationFlows.from(fileReader(), new FixedRatePoller())
                .channel(inputChannel()).handle(endpoint).channel(outputChannel())
                .handle(fileWriter()).get();
    }

    private static class FixedRatePoller
            implements Consumer<SourcePollingChannelAdapterSpec> {

        @Override
        public void accept(SourcePollingChannelAdapterSpec spec) {
            spec.poller(Pollers.fixedRate(500));
        }

    }

}
