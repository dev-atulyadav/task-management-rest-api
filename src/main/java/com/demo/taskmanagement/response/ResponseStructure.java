package com.demo.taskmanagement.response;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ResponseStructure<T> {

	private String msg;
	private int status;
	private T data;
}
