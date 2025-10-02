import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

public class WorldTimeDisplay {

    public static void main(String[] args) {
        
        Map<String, ZoneOffset> cityOffsets = new LinkedHashMap<>();
        cityOffsets.put("UTC", ZoneOffset.ofHours(0));
        cityOffsets.put("San Francisco", ZoneOffset.ofHours(-7));
        cityOffsets.put("New York", ZoneOffset.ofHours(-4));
        cityOffsets.put("London", ZoneOffset.ofHours(1));
        cityOffsets.put("Dubai", ZoneOffset.ofHours(4));
        cityOffsets.put("Bangalore", ZoneOffset.ofHoursMinutes(5, 30));
        cityOffsets.put("Singapore", ZoneOffset.ofHours(8));
        cityOffsets.put("Tokyo", ZoneOffset.ofHours(9));
        cityOffsets.put("Sydney", ZoneOffset.ofHours(10));
        cityOffsets.put("Wellington", ZoneOffset.ofHours(12));

        LocalDateTime utcLocalTime = LocalDateTime.now(ZoneOffset.UTC);
        
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println("Assignment Time Display (Java)");

        for (Map.Entry<String, ZoneOffset> entry : cityOffsets.entrySet()) {
            String city = entry.getKey();
            ZoneOffset offset = entry.getValue();

            OffsetDateTime cityTime = utcLocalTime.atOffset(offset);
            
            String offsetDisplay = offset.getId().replace("Z", "+00:00");
            
            System.out.printf("%-15s (UTC %-7s): %s%n", 
                              city, 
                              offsetDisplay,
                              cityTime.format(timeFormatter));
        }
    }
                                                       }

