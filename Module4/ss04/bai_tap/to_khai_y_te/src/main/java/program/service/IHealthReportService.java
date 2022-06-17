package program.service;

import org.springframework.stereotype.Service;
import program.model.HealthReport;

import java.util.List;


public interface IHealthReportService {
    void addReportList(HealthReport healthReport);

    List<HealthReport> showList();

    HealthReport getReport(String dateStart);
}
