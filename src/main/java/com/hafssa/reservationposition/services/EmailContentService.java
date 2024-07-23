package com.hafssa.reservationposition.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;



@Service
public class EmailContentService {

    @Autowired
    private EmailSenderService emailSenderService;

    public String generateOccupancyHtmlTable(List<Object[]> occupancyList) {
        StringBuilder htmlContent = new StringBuilder();
        htmlContent.append("<html><body>")
                .append("<h1>Occupancy Rates for the Next Two Weeks</h1>")
                .append("<table border='1' style='border-collapse: collapse;'>")
                .append("<tr><th>Date</th><th>Occupancy Rate</th></tr>");

        for (Object[] entry : occupancyList) {
            // Convertir java.sql.Date en java.time.LocalDate
            Date sqlDate = (Date) entry[0];
            LocalDate date = sqlDate.toLocalDate(); // Assurez-vous que cette méthode est disponible dans votre JDK

            // Utiliser BigDecimal pour le taux
            BigDecimal rate = (BigDecimal) entry[1];
            String color = rate.doubleValue() > 90 ? "red" : "black";

            htmlContent.append("<tr>")
                    .append("<td>").append(date).append("</td>")
                    .append("<td style='color: ").append(color).append(";'>" + String.format("%.2f", rate.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()) + "%</td>")
                    .append("</tr>");
        }

        htmlContent.append("</table>")
                .append("</body></html>");

        return htmlContent.toString();
    }

    public void generateAndSendOccupancyEmail(List<Object[]> occupancyList, String toEmail, String subject) {
        String htmlContent = generateOccupancyHtmlTable(occupancyList);
        emailSenderService.sendOccupancyReportEmail(toEmail, subject, htmlContent);
    }

}
