package com.edfeff;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.AvailabilityState;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

/**
 * 存活探针
 * <p>
 * 可读探针
 *
 * @author wangpp
 */
//@Component
public class ReadinessStateExporter {

    @EventListener( classes = AvailabilityChangeEvent.class )
    public void onStateChange(AvailabilityChangeEvent<AvailabilityState> event) {

        System.out.println(event);
        AvailabilityState state = event.getState();
        System.out.println(state.getClass().getName());
        if (ReadinessState.class.isAssignableFrom(state.getClass())) {
            switch ((ReadinessState) state) {
                case ACCEPTING_TRAFFIC:
                    System.out.println("设置可读");
                    break;
                case REFUSING_TRAFFIC:
                    System.out.println("设置不可读");
                    break;
            }
        } else if (LivenessState.class.isAssignableFrom(state.getClass())) {
            switch ((LivenessState) state) {
                case CORRECT:
                    System.out.println("设置成功");
                    break;
                case BROKEN:
                    System.out.println("设置失败");
                    break;
            }
        }


    }

}
