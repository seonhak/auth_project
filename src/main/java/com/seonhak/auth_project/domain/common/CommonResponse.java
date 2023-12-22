package com.seonhak.auth_project.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {
    int status;
    String msg;
}
