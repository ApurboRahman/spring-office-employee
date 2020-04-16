package sp.co.soe.emp.domain.entity;

import java.util.Date;

/**
 * Table: message_m
 */
public class MessageM {
    /**
     * Column: message_id
     */
    private Integer messageId;

    /**
     * Column: message_nm
     */
    private String messageNm;

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

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getMessageNm() {
        return messageNm;
    }

    public void setMessageNm(String messageNm) {
        this.messageNm = messageNm == null ? null : messageNm.trim();
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