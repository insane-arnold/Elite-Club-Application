package com.club.eliteclub.initializer;

import org.hibernate.validator.constraints.URL;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Configuration
@ConfigurationProperties(prefix = "forbes400.billionaire")
@Validated
public class Forbes400Properties {

    @NotNull
    @NotEmpty
    @URL
    private String api;

    @Positive
    private int maxrecord;

//    public Forbes400Properties(@NotNull @NotEmpty @URL String api, @Positive int maxrecord) {
//        this.api = api;
//        this.maxrecord = maxrecord;
//    }

    public void setApi(@NotNull @NotEmpty @URL String api) {
         this.api = api;
    }

    public void setMaxrecord(@Positive int maxrecord) {
        this.maxrecord = maxrecord;
    }
    public String getApi() {
        return api;
    }

    public int getMaxrecord() {
        return maxrecord;
    }

    public String buildEndPoint() {
        return api + "?limit=" + maxrecord;
    }


}
