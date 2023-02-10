package fr.ea.abj.eattestationback.exception.handler;

import lombok.Data;

@Data
public class ExceptionMessage {

    private  String message;
    private  String error;
    private  String path;
}
