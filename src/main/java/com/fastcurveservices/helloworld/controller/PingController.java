package com.fastcurveservices.helloworld.controller;

import com.fastcurveservices.helloworld.utils.ResourceUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.GitProperties;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping
public class PingController {
    private final GitProperties gitProperties;


    public PingController(@Value("classpath:git.properties") Resource resource) throws IOException {
        this.gitProperties = new GitProperties(ResourceUtils.loadGit(resource));
    }

    @GetMapping("ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("version")
    public String version() {
        return gitProperties.getShortCommitId();
    }
}
