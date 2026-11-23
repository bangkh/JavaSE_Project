package mylab.book.control;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class StatisticsAnalyzer {

    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Double> totalPrices = new HashMap<String, Double>();
        Map<String, Integer> counts = new HashMap<String, Integer>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);

            if (totalPrices.containsKey(type)) {
                totalPrices.put(type, totalPrices.get(type) + pub.getPrice());
                counts.put(type, counts.get(type) + 1);
            } else {
                totalPrices.put(type, (double) pub.getPrice());
                counts.put(type, 1);
            }
        }

        Map<String, Double> averages = new HashMap<String, Double>();
        for (String type : totalPrices.keySet()) {
            double average = totalPrices.get(type) / counts.get(type);
            averages.put(type, average);
        }
        return averages;
    }

    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> counts = new HashMap<String, Integer>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);

            if (counts.containsKey(type)) {
                counts.put(type, counts.get(type) + 1);
            } else {
                counts.put(type, 1);
            }
        }

        Map<String, Double> result = new HashMap<String, Double>();
        for (String type : counts.keySet()) {
            double percent = 0;
            if (publications.length > 0) {
                percent = counts.get(type) * 100.0 / publications.length;
            }
            result.put(type, percent);
        }
        return result;
    }

    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        if (publications.length == 0) {
            return 0;
        }

        int count = 0;
        for (Publication pub : publications) {
            String publishDate = pub.getPublishDate();
            if (publishDate != null && publishDate.startsWith(year)) {
                count++;
            }
        }
        return count * 100.0 / publications.length;
    }

    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) {
            return "소설";
        } else if (pub instanceof Magazine) {
            return "잡지";
        } else if (pub instanceof ReferenceBook) {
            return "참고서";
        } else {
            return "기타";
        }
    }

    public void printStatistics(Publication[] publications) {
        Map<String, Double> averages = calculateAveragePriceByType(publications);
        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        String[] types = {"소설", "참고서", "잡지", "기타"};

        DecimalFormat priceFormat = new DecimalFormat("#,###.##");
        DecimalFormat percentFormat = new DecimalFormat("0.00");

        System.out.println("===== 출판물 통계 분석 =====");
        System.out.println("1. 타입별 평균 가격:");
        for (String type : types) {
            if (averages.containsKey(type)) {
                System.out.println("   - " + type + ": "
                        + priceFormat.format(averages.get(type)) + "원");
            }
        }

        System.out.println("2. 출판물 유형 분포:");
        for (String type : types) {
            if (distribution.containsKey(type)) {
                System.out.println("   - " + type + ": "
                        + percentFormat.format(distribution.get(type)) + "%");
            }
        }

        double yearRatio = calculatePublicationRatioByYear(publications, "2007");
        System.out.println("3. 2007년에 출판된 출판물 비율: "
                + percentFormat.format(yearRatio) + "%");
    }
}
