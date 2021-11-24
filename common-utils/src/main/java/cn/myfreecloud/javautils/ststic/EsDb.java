package cn.myfreecloud.javautils.ststic;

import lombok.Data;

import java.util.Date;

@Data
public class EsDb {

    private Date reportDate;


    private String marketType;


    private String mediaType;


    private Double cost;

    private Double userRegisterNum;


    private Double userCompleteResumeNum;

    private Double chatUserNum;

    private Double chatInstanceNum;
}
