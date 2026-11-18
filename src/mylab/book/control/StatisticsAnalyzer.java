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
        Map<String, Double> sums = new HashMap<String, Double>();
        Map<String, Integer> counts = new HashMap<String, Integer>();
        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            sums.put(type, sums.getOrDefault(type, 0.0) + pub.getPrice());
            counts.put(type, counts.getOrDefault(type, 0) + 1);
        }
        Map<String, Double> averages = new HashMap<String, Double>();
        for (String type : sums.keySet()) {
            averages.put(type, sums.get(type) / counts.get(type));
        }
        return averages;
    }

    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> counts = new HashMap<String, Integer>();
        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            counts.put(type, counts.getOrDefault(type, 0) + 1);
        }
        Map<String, Double> distribution = new HashMap<String, Double>();
        for (String type : counts.keySet()) {
            distribution.put(type, publications.length == 0 ? 0.0
                    : counts.get(type) * 100.0 / publications.length);
        }
        return distribution;
    }

    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        if (publications.length == 0) return 0.0;
        int count = 0;
        for (Publication pub : publications) {
            String date = pub.getPublishDate();
            if (date != null && date.length() >= 4 && date.substring(0, 4).equals(year)) count++;
        }
        return count * 100.0 / publications.length;
    }

    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) return "소설";
        if (pub instanceof Magazine) return "잡지";
        if (pub instanceof ReferenceBook) return "참고서";
        return "기타";
    }

    public void printStatistics(Publication[] publications) {
        DecimalFormat priceFormat = new DecimalFormat("#,###.##");
        DecimalFormat percentFormat = new DecimalFormat("0.00");
        String[] types = {"소설", "참고서", "잡지", "기타"};
        Map<String, Double> averages = calculateAveragePriceByType(publications);
        Map<String, Double> distribution = calculatePublicationDistribution(publications);

        System.out.println("===== 출판물 통계 분석 =====");
        System.out.println("1. 타입별 평균 가격:");
        for (String type : types) {
            if (averages.containsKey(type)) {
                System.out.println("   - " + type + ": " + priceFormat.format(averages.get(type)) + "원");
            }
        }
        System.out.println("2. 출판물 유형 분포:");
        for (String type : types) {
            if (distribution.containsKey(type)) {
                System.out.println("   - " + type + ": " + percentFormat.format(distribution.get(type)) + "%");
            }
        }
        System.out.println("3. 2007년에 출판된 출판물 비율: "
                + percentFormat.format(calculatePublicationRatioByYear(publications, "2007")) + "%");
    }
}
