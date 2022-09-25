package uk.ac.ucl.utils;

import org.apache.commons.beanutils.BeanUtils;
import uk.ac.ucl.pojo.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Taobang
 * @create 2022-09-21 14:23
 */
public class WebUtils {

    public static <T> T copyParamToBean(Map parameterMap, T bean) {
        try {
            BeanUtils.populate(bean, parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bean;
    }

    public static int parseInt(String strInt, int defaultValue) {

        try {
            if (strInt == null || "".equals(strInt)) {
                return defaultValue;
            }
            return Integer.parseInt(strInt);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return defaultValue;
    }
}
