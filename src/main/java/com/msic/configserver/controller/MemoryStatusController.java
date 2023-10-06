package com.msic.configserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemoryStatusController {

    @GetMapping("memory-status")
    public MemoryStats getMemoryStatistics() {
        MemoryStats stats = new MemoryStats();
        stats.setHeapSize(Runtime.getRuntime()
                .totalMemory());
        stats.setHeapMaxSize(Runtime.getRuntime()
                .maxMemory());
        stats.setHeapFreeSize(Runtime.getRuntime()
                .freeMemory());
        long maxBytes = Runtime.getRuntime().maxMemory();
        System.out.println("Max memory: " + maxBytes / 1024 / 1024 + "M");
        return stats;
    }
}
