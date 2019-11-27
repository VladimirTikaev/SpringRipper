package quoters;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        Field[] declaredFields = bean.getClass().getDeclaredFields();


        for (Field field : declaredFields) {//Проходим по всем полям бина
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class); //Пытаемся получить нужную аннотацию у бина
            if(annotation != null){ //Если есть, то получаем значение min и max
                int min = annotation.min();
                int max = annotation.max();
                //Далее получаем рандомное значение
                Random random = new Random();
                int i = min + random.nextInt(max - min);
                //Теперь нашему полю бина нужно присвоить значение i. Скорее всего поле private поэтому включаем возможность устанавливать значение
                field.setAccessible(true);
                //Далее устаноавливаем значение
//                try {
//                    field.set(field, i); Здесь возникает исключение, пробросиьт вверх мы его не можем т.к. мы имплементим интерфейс
//                  если чужой интерфейс не кидает исключение, то и мы не можем
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }

                //Трайкэч выглядит некрасиво - мы используем библиотеку, которая реализует внутри себя эти трайкэтчи в рантайм исключ

                ReflectionUtils.setField(field, bean, i);

            }
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }


}
