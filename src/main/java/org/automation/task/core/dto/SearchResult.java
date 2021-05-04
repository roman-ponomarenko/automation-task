package org.automation.task.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class SearchResult {
    private String title;
    @JsonProperty("location_type")
    private String locationType;
    private long woeid;
    @JsonProperty("latt_long")
    private String lattLong;

    public static class SearchResults extends ArrayList<SearchResult> { }
}
