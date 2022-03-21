package com.company;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class Information {
    private String type;
    private String name;
    private Date creationDate;
    private List<Creator> creators;
    private int pageCount;
    private Time duration;
    private List<String> signatures;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Type: ");
        if (type == null){sb.append("unknown");}
        else {sb.append(type);}
        if (creationDate != null){sb.append("\n Date: "+creationDate);}
        if (creators != null) {
            sb.append("\nCreators:");
            for (Creator creator:
                    creators) {
                sb.append("\n-"+creator);
            }
        }
        if (pageCount != 0){
            sb.append("\nPages: ");
            if(pageCount <= 0)  sb.append("uncounted");
            else sb.append(pageCount)
            ;}
        if (duration != null){sb.append("\n Duration:"+duration);}
        if (signatures != null) {
            sb.append("\nSignatures:");
            for (String signature:
                    signatures) {
                sb.append("\n-"+signature);
            }
        }
        return sb.toString();
    }

    public Information() {
    }
    public Information(Information information) {
        this.type = information.type;
        this.name = information.name;
        this.creationDate = information.creationDate;
        this.creators = information.creators;
        this.pageCount = information.pageCount;
        this.duration = information.duration;
    }

    //region getters and setters

    public List<String> getSignatures() {
        return signatures;
    }

    public void setSignatures(List<String> signatures) {
        this.signatures = signatures;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<Creator> getCreators() {
        return creators;
    }

    public void setCreators(List<Creator> creators) {
        this.creators = creators;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    //endregion
}