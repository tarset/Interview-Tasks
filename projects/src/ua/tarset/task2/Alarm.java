package ua.tarset.task2;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Alarm {
    Timer _timer;
    UserView user;

    public Alarm(UserView user) {
    	this.user = user;

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Date alarmTime = calendar.getTime();

        _timer = new Timer();
        _timer.schedule(new AlarmTask(), alarmTime);
    }

    class AlarmTask extends TimerTask {
        public void run() {
        	user.nextDay();
        }
    }
}