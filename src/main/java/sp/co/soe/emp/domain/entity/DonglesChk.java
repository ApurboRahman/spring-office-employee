package sp.co.soe.emp.domain.entity;

import java.util.Date;

/**
 * Table: dongles_chk
 */
public class DonglesChk {
    /**
     * Column: period_month
     */
    private Date periodMonth;

    /**
     * Column: employee_id
     */
    private String employeeId;

    /**
     * Column: manage_num
     */
    private String manageNum;

    /**
     * Column: effective_date
     */
    private Date effectiveDate;

    /**
     * Column: return_date
     */
    private Date returnDate;

    /**
     * Column: chk_user
     */
    private String chkUser;

    /**
     * Column: chk_date
     */
    private Date chkDate;

    /**
     * Column: approval_user
     */
    private String approvalUser;

    /**
     * Column: approval_date
     */
    private Date approvalDate;

    /**
     * Column: notes
     */
    private String notes;

    /**
     * Column: chk_flg
     */
    private String chkFlg;

    /**
     * Column: approval_flg
     */
    private String approvalFlg;

    /**
     * Column: edit_flg
     */
    private String editFlg;

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

    public Date getPeriodMonth() {
        return periodMonth;
    }

    public void setPeriodMonth(Date periodMonth) {
        this.periodMonth = periodMonth;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId == null ? null : employeeId.trim();
    }

    public String getManageNum() {
        return manageNum;
    }

    public void setManageNum(String manageNum) {
        this.manageNum = manageNum == null ? null : manageNum.trim();
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getChkUser() {
        return chkUser;
    }

    public void setChkUser(String chkUser) {
        this.chkUser = chkUser == null ? null : chkUser.trim();
    }

    public Date getChkDate() {
        return chkDate;
    }

    public void setChkDate(Date chkDate) {
        this.chkDate = chkDate;
    }

    public String getApprovalUser() {
        return approvalUser;
    }

    public void setApprovalUser(String approvalUser) {
        this.approvalUser = approvalUser == null ? null : approvalUser.trim();
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    public String getChkFlg() {
        return chkFlg;
    }

    public void setChkFlg(String chkFlg) {
        this.chkFlg = chkFlg == null ? null : chkFlg.trim();
    }

    public String getApprovalFlg() {
        return approvalFlg;
    }

    public void setApprovalFlg(String approvalFlg) {
        this.approvalFlg = approvalFlg == null ? null : approvalFlg.trim();
    }

    public String getEditFlg() {
        return editFlg;
    }

    public void setEditFlg(String editFlg) {
        this.editFlg = editFlg == null ? null : editFlg.trim();
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