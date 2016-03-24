package pl.sly.jersey2.spring.example.service.impl;

import org.springframework.stereotype.Service;
import pl.sly.jersey2.spring.example.service.StatusService;

@Service
public class StatusServiceImpl implements StatusService {
    @Override
    public Long getTime() {
        return Long.valueOf(System.currentTimeMillis());
    }
}
