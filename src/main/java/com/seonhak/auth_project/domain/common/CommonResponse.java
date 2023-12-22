package com.seonhak.auth_project.domain.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Getter
public class CommonResponse {
    int status;
    String msg;
}
