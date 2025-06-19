package com.pickgo.domain.performance.kopis.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public record KopisPerformanceListResponse(
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "db")
    List<KopisPerformanceDto> performances
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record KopisPerformanceDto(
        @JacksonXmlProperty(localName = "mt20id")
        String id
    ) {
    }
}
