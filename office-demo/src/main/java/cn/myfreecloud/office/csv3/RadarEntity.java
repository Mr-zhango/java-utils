package cn.myfreecloud.office.csv3;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RadarEntity {
    private String sourceFileName;
    private String targetNumber;
    private String date;
    private String noiseLevel;
    private String maxCircularMean;
    private String minCircularMean;
    private String heightChannel;
    private String height;
    private String heightInterval;
    private String startCycle;
    private String endCycle;
    private String startTime;
    private String endTime;
    private String timespan;
    private String speed1;
    private String speed2;
    private String speed3;
    private String direction;
    private String alignment;
    private String a0;
    private String a2;
    private String a4;
    private String mass;
    private String wingbeatFrequency;
    private String errorCode;
    private String failureRate;
    private String beamOffset;
    private String identification;
}
