package com.itheima.domain;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;

@TableName(value = "dialog_t")
public class Dialog {
    @TableId
    private Integer id;
    @TableField
    private String dialogCode;
    @TableField
    private String dialogName;
    @TableField
    private String creator;
    @TableField
    private LocalDateTime createTime;
    @TableField
    private LocalDateTime updateTime;

    @Override
    public String toString() {
        return "Dialog{" +
                "id=" + id +
                ", dialogCode='" + dialogCode + '\'' +
                ", dialogName='" + dialogName + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDialogCode() {
        return dialogCode;
    }

    public void setDialogCode(String dialogCode) {
        this.dialogCode = dialogCode;
    }

    public String getDialogName() {
        return dialogName;
    }

    public void setDialogName(String dialogName) {
        this.dialogName = dialogName;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
