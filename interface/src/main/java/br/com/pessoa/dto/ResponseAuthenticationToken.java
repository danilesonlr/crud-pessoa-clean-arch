package br.com.pessoa.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ResponseAuthenticationToken {
    String token;
}
