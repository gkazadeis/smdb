package openbet.codehub.smdb.controller;

import lombok.RequiredArgsConstructor;
import openbet.codehub.smdb.service.SeriesService;
import openbet.codehub.smdb.transfer.ApiResponse;
import openbet.codehub.smdb.transfer.SeriesDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/series")
public class SeriesController {
    private final SeriesService seriesService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<SeriesDetails>>> findAllSeries(){
        return ResponseEntity.ok(ApiResponse.<List<SeriesDetails>>builder().data(seriesService.findAllLazy()).build());
    }
}
