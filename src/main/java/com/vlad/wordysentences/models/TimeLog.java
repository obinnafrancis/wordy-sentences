package com.vlad.wordysentences.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "time_log")
public class TimeLog extends AbstractModel{
    @Column(updatable = false)
    private String currentDate;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false, name = "clock_in_time")
    private Date clockIn;
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, name = "clock_out_time")
    private Date clockOut;
    private int staffId;

    public Date getClockIn() {
        return clockIn;
    }

    public void setClockIn(Date clockIn) {
        this.clockIn = clockIn;
    }

    public Date getClockOut() {
        return clockOut;
    }

    public void setClockOut(Date clockOut) {
        this.clockOut = clockOut;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }
}
