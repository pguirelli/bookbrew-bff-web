package com.bookbrew.bff.web.dto.auth;

public class RecoverEmailRequestDTO {

    private String cpf;

    private String phone;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
