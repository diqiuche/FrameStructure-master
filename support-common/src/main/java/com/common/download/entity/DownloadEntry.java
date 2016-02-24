package com.common.download.entity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

import com.constants.fixed.GlobalConstants;
import com.constants.level.DownloadStatusLevel;

import java.io.File;
import java.io.Serializable;

/**
 * Entity mapped to table "DOWNLOAD_ENTRY".
 */
public class DownloadEntry implements Serializable{

    /** Not-null value. */
    private String url;
    /** Not-null value. */
    private String name;
    private String saveUrl;
    private String saveName;
    private String fileType;
    private String fileSuffix;

    private Integer currentLength = 0;
    private Integer totalLength = 0;
    private Integer status = DownloadStatusLevel.IDLE.value();
    private Integer percent = 0;
    private Boolean isSupportRange;
    private Integer range_0 = 0;
    private Integer range_1 = 0;
    private Integer range_2 = 0;

    public DownloadEntry() {
    }

    public DownloadEntry(String url) {
        this.url = url;
    }

    public DownloadEntry(String url, String name, Integer currentLength, Integer totalLength, Integer status, Integer percent, String saveUrl, String saveName, String fileType, String fileSuffix, Boolean isSupportRange, Integer range_0, Integer range_1, Integer range_2) {
        this.url = url;
        this.name = name;
        this.currentLength = currentLength;
        this.totalLength = totalLength;
        this.status = status;
        this.percent = percent;
        this.saveUrl = saveUrl;
        this.saveName = saveName;
        this.fileType = fileType;
        this.fileSuffix = fileSuffix;
        this.isSupportRange = isSupportRange;
        this.range_0 = range_0;
        this.range_1 = range_1;
        this.range_2 = range_2;
    }

    /** Not-null value. */
    public String getUrl() {
        return url;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setUrl(String url) {
        this.url = url;
    }

    /** Not-null value. */
    public String getName() {
        return name;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setName(String name) {
        this.name = name;
    }

    public Integer getCurrentLength() {
        return currentLength;
    }

    public void setCurrentLength(Integer currentLength) {
        this.currentLength = currentLength;
    }

    public Integer getTotalLength() {
        return totalLength;
    }

    public void setTotalLength(Integer totalLength) {
        this.totalLength = totalLength;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    public String getSaveUrl() {
        return saveUrl;
    }

    public void setSaveUrl(String saveUrl) {
        this.saveUrl = saveUrl;
    }

    public String getSaveName() {
        return saveName;
    }

    public void setSaveName(String saveName) {
        this.saveName = saveName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    public Boolean getIsSupportRange() {
        return isSupportRange;
    }

    public void setIsSupportRange(Boolean isSupportRange) {
        this.isSupportRange = isSupportRange;
    }

    public Integer getRange_0() {
        return range_0;
    }

    public void setRange_0(Integer range_0) {
        this.range_0 = range_0;
    }

    public Integer getRange_1() {
        return range_1;
    }

    public void setRange_1(Integer range_1) {
        this.range_1 = range_1;
    }

    public Integer getRange_2() {
        return range_2;
    }

    public void setRange_2(Integer range_2) {
        this.range_2 = range_2;
    }
    @Override
    public String toString() {
        return name + " is " + status + " with " + currentLength + "/" + totalLength + " " + percent +"%";
//		return name + "==" + percent
//				+ "%==" + status.name();
    }

    public void reset() {
        currentLength = 0;
        percent = 0;
        range_0 = 0;
        range_1 = 0;
        range_2 = 0;
        String path = GlobalConstants.DOWNLOAD_PATH + name;
        File file = new File(path);
        if(file.exists()){
            file.delete();
        }
    }
}
