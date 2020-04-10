package sp.co.soe.emp.domain.entity;

import java.util.Date;

/**
 * Table: close_status
 */
public class CloseStatus {
    /**
     * Column: close_date
     */
    private Date closeDate;

    /**
     * Column: close_flag
     */
    private Integer closeFlag;

    /**
     * Column: create_user
     */
    private String createUser;

    /**
     * Column: create_date
     */
    private Date createDate;

    /**
     * Column: create_pgid
     */
    private String createPgid;

    /**
     * Column: update_user
     */
    private String updateUser;

    /**
     * Column: update_date
     */
    private Date updateDate;

    /**
     * Column: update_pgid
     */
    private String updatePgid;

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public Integer getCloseFlag() {
        return closeFlag;
    }

    public void setCloseFlag(Integer closeFlag) {
        this.closeFlag = closeFlag;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreatePgid() {
        return createPgid;
    }

    public void setCreatePgid(String createPgid) {
        this.createPgid = createPgid == null ? null : createPgid.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdatePgid() {
        return updatePgid;
    }

    public void setUpdatePgid(String updatePgid) {
        this.updatePgid = updatePgid == null ? null : updatePgid.trim();
    }
}