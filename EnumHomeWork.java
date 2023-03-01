import java.util.concurrent.TimeUnit;

public class EnumHomeWork {
    public static void main(String[] args) {
        //       System.out.println(ChoiceOfWay.TR.getTime());
//  Вариант 1.
        long secondsIn = 0;
        long dayCount = 0;
        long hoursCount = 0;
        long minutesCount = 0;
        long secondsCount = 0;

        for (int i = 0; i < ChoiceOfWay.values().length; i++) {
            secondsIn =  TimeUnit.HOURS.toSeconds ((long) (ChoiceOfWay.values()[i].getTime()));
            dayCount = TimeUnit.SECONDS.toDays(secondsIn);
            secondsCount = secondsIn - TimeUnit.DAYS.toSeconds(dayCount);
            hoursCount = TimeUnit.SECONDS.toHours(secondsCount);
            secondsCount -= TimeUnit.HOURS.toSeconds(hoursCount);
            minutesCount = TimeUnit.SECONDS.toMinutes(secondsCount);
            secondsCount -= TimeUnit.MINUTES.toSeconds(minutesCount);


            System.out.println(ChoiceOfWay.values()[i] + " " + dayCount + " " + hoursCount + " " + minutesCount + " " + secondsCount);
        }
        System.out.println();
//      Вариант 2.
        int time = 0;
        int days = 0;
        int hours = 0;
        int minut = 0;
        int sec = 0;


        for (int i = 0; i < ChoiceOfWay.values().length; i++) {
            time = (int) (ChoiceOfWay.values()[i].getTime() * 3600);

            days = (int) (time / 86400);

            hours = (time % 86400) / 3600;

            minut = ((time % 86400) % 3600) / 60;

            sec = ((time % 86400) % 3600) % 60;

            System.out.println(ChoiceOfWay.values()[i] + " " + days + "d" + " " + hours + "h" +
                    " " + minut + "m" + " " + sec + "s");

        }
    }

    enum ChoiceOfWay {
        AIR(25.78),
        TR(9.7),
        CAR(6.5),
        BYC(35),
        WALK(118);

        private double time;

        ChoiceOfWay(double time) {
            this.time = time;
        }

        public double getTime() {
            return time;
        }


    }
}
/*
Представьте, что Вы живете в Берлине и собираетесь поехать в Мюнхен. Вам необходимо создать enum, в котором будут такие варианты передвижения как:
самолет, поезд, автомобиль, велосипед и пешком. Вам необходимо создать такой enum, в котором в качестве конструктора задавалась бы продолжительность поездки,
в зависимости от способа передвижения. Значение будет задаваться в часах (дробное число, можно задать приближённое значение,
либо попробовать найти лучший вариант на google maps).
Помимо этого, в этом enum необходимо создать метод для получения информации о продолжительности поездки в днях, часах, минутах и секундах (разными методами)
 */