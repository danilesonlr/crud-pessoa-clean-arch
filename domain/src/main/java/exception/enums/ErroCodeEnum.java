package exception.enums;

public enum ErroCodeEnum {
    BUS0001("Nome é obrigatório.","BUS-0001"),
    BUS0002("Telefone é obrigatório.","BUS-0002"),
    BUS0003("CPF é obrigatório.","BUS-0003"),
    BUS0004("Data de nascimento é obrigatória.","BUS-0004"),
    BUS0005("CEP é obrigatório.","BUS-0005"),
    BUS0006("Funcionário deve ser maior de 18 anos.","BUS-0006"),


    UC0001("Endereço não encontrado.","UC-0001"),
    UC0002("Erro ao buscar endereço.","UC-0002") ,

    INF0001("Falha na validação dos campos.", "INF0001");

    private String message;
    private String code;

    ErroCodeEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
