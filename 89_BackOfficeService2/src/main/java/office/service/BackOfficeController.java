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

    // Добавьте методы обработки HTTP-запросов для каждого метода интерфейса IBackOffice
}

