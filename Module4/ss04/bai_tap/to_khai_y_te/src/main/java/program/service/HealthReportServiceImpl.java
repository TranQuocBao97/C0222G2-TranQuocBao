package program.service;

import org.springframework.stereotype.Service;
import program.model.HealthReport;

import java.util.ArrayList;
import java.util.List;


@Service
public class HealthReportServiceImpl implements IHealthReportService{
    List<HealthReport> healthReportList = new ArrayList<>();
    @Override
    public void addReportList(HealthReport healthReport) {
        healthReportList.add(healthReport);
    }

    @Override
    public List<HealthReport> showList() {
        return healthReportList;
    }

    @Override
    public HealthReport getReport(String dateStart) {
        for(HealthReport healthReport : healthReportList){
            if(healthReport.getDateStart().equals(dateStart)){
                return healthReport;
            }
        }
        return null;
    }

}
