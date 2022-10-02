package uk.ac.ucl.utils;

import org.apache.commons.beanutils.BeanUtils;
import uk.ac.ucl.pojo.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author huang-wt
 * @create 2022-09-21 14:23
 */
public class WebUtils {

    /**
     * Parse all parameters in request scope into a corresponding object
     * @param parameterMap
     * @param bean an object of some class where set methods are defined
     * @param <T>
     * @return
     */
    public static <T> T copyParamToBean(Map parameterMap, T bean) {
        try {
            BeanUtils.populate(bean, parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bean;
    }

    /**
     * Parses the string argument (often from web domain) as a signed decimal integer
     * @param strInt
     * @param defaultValue
     * @return defaultValue if exception occurs or the given string is null; or corresponding integer
     */
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
