package io.pivotal.cf.circuitbreakerdemo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Message {
    private Long id;
    @NonNull
    private String messageText;
}
