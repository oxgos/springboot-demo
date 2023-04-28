package com.itheima.domain;


import java.time.LocalDateTime;

public class Dialog {
    private Integer id;
    private String dialog_code;
    private String dialog_name;
    private String creator;
    private LocalDateTime create_time;
    private LocalDateTime update_time;

    @Override
    public String toString() {
        return "Dialog{" +
                "id=" + id +
                ", dialog_code='" + dialog_code + '\'' +
                ", dialog_name='" + dialog_name + '\'' +
                ", creator='" + creator + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDialog_code() {
        return dialog_code;
    }

    public void setDialog_code(String dialog_code) {
        this.dialog_code = dialog_code;
    }

    public String getDialog_name() {
        return dialog_name;
    }

    public void setDialog_name(String dialog_name) {
        this.dialog_name = dialog_name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public LocalDateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(LocalDateTime create_time) {
        this.create_time = create_time;
    }

    public LocalDateTime getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(LocalDateTime update_time) {
        this.update_time = update_time;
    }
}
