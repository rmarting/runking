/**
 * 
 */
package com.dogmaweb.model;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import com.google.gson.Gson;

/**
 * @author L02435
 */
public abstract class Auditable {

    /* Auditing fields */

    @CreatedDate
    private DateTime createdAt;

    @LastModifiedDate
    private DateTime lastModified;

    @CreatedBy
    private User createdBy;

    @LastModifiedBy
    private User lastModifiedBy;

    @Version
    private Long version;

    public DateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(DateTime createdDate) {
        this.createdAt = createdDate;
    }

    public DateTime getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(DateTime lastModifiedDate) {
        this.lastModified = lastModifiedDate;
    }

    public User getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getLastModifiedBy() {
        return this.lastModifiedBy;
    }

    public void setLastModifiedBy(User lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
