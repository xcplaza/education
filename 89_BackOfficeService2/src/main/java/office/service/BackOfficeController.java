package office.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/backoffice")
public class BackOfficeController {

    private final IBackOffice backOfficeService;

    @Autowired
    public BackOfficeController(IBackOffice backOfficeService) {
        this.backOfficeService = backOfficeService;
    }

    @GetMapping("/idBigValues")
    public List<Integer> getIdBigValues(
            @RequestParam("from") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime from,
            @RequestParam("to") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime to,
            @RequestParam("normalValue") int normalValue) {
        return backOfficeService.getIdBigValues(from, to, normalValue);
    }

    @GetMapping("/idSmallValues")
    public List<Integer> getIdSmallValues(
            @RequestParam("from") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime from,
            @RequestParam("to") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime to,
            @RequestParam("normalValue") int normalValue) {
        return backOfficeService.getIdSmallValues(from, to, normalValue);
    }

    @GetMapping("/datesBigValues")
    public List<LocalDateTime> getDatesBigValues(
            @RequestParam("sensorId") int sensorId,
            @RequestParam("normalValue") int normalValue,
            @RequestParam("from") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime from,
            @RequestParam("to") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime to) {
        return backOfficeService.getDatesBigValues(sensorId, normalValue, from, to);
    }

    @GetMapping("/datesSmallValues")
    public List<LocalDateTime> getDatesSmallValues(
            @RequestParam("sensorId") int sensorId,
            @RequestParam("normalValue") int normalValue,
            @RequestParam("from") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime from,
            @RequestParam("to") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime to) {
        return backOfficeService.getDatesSmallValues(sensorId, normalValue, from, to);
    }

    @GetMapping("/sensorStatistics")
    public SensorStatistics getSensorStatistics(
            @RequestParam("sensorId") int sensorId,
            @RequestParam("from") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime from,
            @RequestParam("to") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime to) {
        return backOfficeService.getSensorStatistics(sensorId, from, to);
    }
}
