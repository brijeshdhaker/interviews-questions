package com.hackerrank.sample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import com.hackerrank.sample.dto.StringResponse;

@CrossOrigin(origins = {"*localhost*"})
@RestController
@RequestMapping(path ="/", produces = MediaType.APPLICATION_JSON_VALUE)
public class SampleController {

    @GetMapping(path = "/defaultHello")
    public ResponseEntity<StringResponse> defaultHello(@Nullable  @RequestParam(name = "message", required = false)String message){
        StringResponse sr = new StringResponse("Default Hello World!");
        ResponseEntity<StringResponse> response = new ResponseEntity<>(sr, HttpStatus.OK);
        return response;
    }

    @PostMapping(path = "/customHello")
    public ResponseEntity<?> customHello(@RequestParam("message") String message){
        ResponseEntity<?> response;
        if(null != message){
            StringResponse sr = new StringResponse("Custom " + message);
            response = new ResponseEntity<>(sr, HttpStatus.OK);
        }else {
            response = new ResponseEntity<>("sr", HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}
