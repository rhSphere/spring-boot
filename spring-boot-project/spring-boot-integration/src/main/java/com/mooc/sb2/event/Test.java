package com.mooc.sb2.event;

public class Test {

    public static void main(String[] args) {
        WeatherEventMulticaster eventMulticaster = new WeatherEventMulticaster();
        RainListener rainListener = new RainListener();
        SnowListener snowListener = new SnowListener();

        eventMulticaster.addListener(rainListener);
        eventMulticaster.addListener(snowListener);

        eventMulticaster.multicastEvent(new SnowEvent());
        eventMulticaster.multicastEvent(new RainEvent());

        System.out.println("====");
        System.out.println("删除下雨监听器");
        eventMulticaster.removeListener(rainListener);

        eventMulticaster.multicastEvent(new SnowEvent());
        eventMulticaster.multicastEvent(new RainEvent());
    }

}
