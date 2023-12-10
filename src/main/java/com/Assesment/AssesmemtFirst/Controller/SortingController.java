package com.Assesment.AssesmemtFirst.Controller;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Assesment.AssesmemtFirst.Entity.SortTask;
import com.Assesment.AssesmemtFirst.Entity.SortingRequest;
import com.Assesment.AssesmemtFirst.Entity.SortingResponse;

@RestController
@RequestMapping("/sorting")
public class SortingController {
	
	@PostMapping("/process-single")
    public SortingResponse processSingle(@RequestBody SortingRequest request) {
        long startTime = System.nanoTime();

        int[][] sortedArrays = Arrays.stream(request.getToSort())
                .map((array) -> {
                    Arrays.sort(array);
                    return array;
                })
                .toArray(int[][]::new);

        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;

        return new SortingResponse(sortedArrays, timeTaken);
    }
	
	@PostMapping("/process-concurrent")
    public SortingResponse processConcurrent(@RequestBody SortingRequest request) {
        long startTime = System.nanoTime();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(() ->
                Arrays.stream(request.getToSort())
                        .parallel()
                        .forEach(array -> {
                            SortTask sortTask = new SortTask(array);
                            ForkJoinPool.commonPool().submit(sortTask).join();
                        })
        ).join();

        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;

        return new SortingResponse(request.getToSort(), timeTaken);
    }

}
