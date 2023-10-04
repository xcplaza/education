package office.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
            @RequestParam LocalDateTime from,
            @RequestParam LocalDateTime to,
            @RequestParam int normalValue
    ) {
        return backOfficeService.getIdBigValues(from, to, normalValue);
    }

    @GetMapping("/idSmallValues")
    public List<Integer> getIdSmallValues(
            @RequestParam LocalDateTime from,
            @RequestParam LocalDateTime to,
            @RequestParam int normalValue
    ) {
        return backOfficeService.getIdSmallValues(from, to, normalValue);
    }

    @GetMapping("/datesBigValues")
    public List<LocalDateTime> getDatesBigValues(
            @RequestParam int sensorId,
            @RequestParam int normalValue,
            @RequestParam LocalDateTime from,
            @RequestParam LocalDateTime to
    ) {
        return backOfficeService.getDatesBigValues(sensorId, normalValue, from, to);
    }

    @GetMapping("/datesSmallValues")
    public List<LocalDateTime> getDatesSmallValues(
            @RequestParam int sensorId,
            @RequestParam int normalValue,
            @RequestParam LocalDateTime from,
            @RequestParam LocalDateTime to
    ) {
        return backOfficeService.getDatesSmallValues(sensorId, normalValue, from, to);
    }

    @GetMapping("/sensorStatistics")
    public SensorStatistics getSensorStatistics(
            @RequestParam int sensorId,
            @RequestParam LocalDateTime from,
            @RequestParam LocalDateTime to
    ) {
        return backOfficeService.getSensorStatistics(sensorId, from, to);
    }
}
