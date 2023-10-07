package Basics;

public class EnumWeekDaysTest {

	WeekDays day;
	
	public EnumWeekDaysTest(WeekDays day) {
		super();
		this.day = day;
	}
	void dayCheck() {
		switch(day) {
		
		case MONDAY:
			System.out.println("Monday will be busy day");
			break;
		case FRIDAY:
			System.out.println("Friday will be better");
			break;
		case SUNDAY:
			System.out.println("SUNDAY will be WEEKEND NIce");
			break;
		default:
				System.out.println("middays are ok ok....");
				break;
			
		}
	}

	public static void main(String[] args) {
		
		String day="MONDAY";
		
		EnumWeekDaysTest obj = new EnumWeekDaysTest(WeekDays.valueOf(day));
		obj.dayCheck();
		WeekDays weekday=WeekDays.FRIDAY;
		System.out.println("Today:"+weekday);
	}

}
