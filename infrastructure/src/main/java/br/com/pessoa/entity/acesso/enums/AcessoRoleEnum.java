package br.com.pessoa.entity.acesso.enums;

public enum AcessoRoleEnum {
    ADMIN("admin"),
    USER("user");

    private String role;

    AcessoRoleEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
