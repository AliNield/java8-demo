import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateTimeDemo {

    public static void printTheDate(Date date) {
        System.out.println(date.toString());
    }

    public static void main(String[] args) {
        Date oldDate = new Date();
        printTheDate(oldDate);
        Date manipulatedDate = Date.from(oldDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .withDayOfMonth(1)
                .toInstant());
        printTheDate(manipulatedDate);


        LocalDate ThirtyDaysFromNow = LocalDate.now()
                                        .atStartOfDay()
                                        .plusDays(30)
                                        .toLocalDate();
    }
}
