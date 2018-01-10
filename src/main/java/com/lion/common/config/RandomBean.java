package com.lion.common.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Administrator on 2017/12/18.
 */
@Configuration
@ConfigurationProperties(prefix = "randomValue", ignoreUnknownFields = false)
@PropertySource(value = "classpath:random.properties")
public class RandomBean {

    private Integer intNumber;
    private Long longNumber;
    private String secret;
    private String uuid;
    private Integer numberLessTen;

    public Integer getNumberLessTen() {
        return numberLessTen;
    }

    public void setNumberLessTen(Integer numberLessTen) {
        this.numberLessTen = numberLessTen;
    }

    public Integer getIntNumber() {
        return intNumber;
    }

    public void setIntNumber(Integer intNumber) {
        this.intNumber = intNumber;
    }

    public Long getLongNumber() {
        return longNumber;
    }

    public void setLongNumber(Long longNumber) {
        this.longNumber = longNumber;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "RandomBean{" +
                "intNumber=" + intNumber +
                ", longNumber=" + longNumber +
                ", secret='" + secret + '\'' +
                ", uuid='" + uuid + '\'' +
                ", numberLessTen=" + numberLessTen +
                '}';
    }
}
